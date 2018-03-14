package com.excite.mobile.shop.Registration;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.excite.mobile.shop.Activities.MainActivity;
import com.excite.mobile.shop.R;
import com.excite.mobile.shop.Utils.FacebookUtil;
import com.excite.mobile.shop.WelcomeSliders.PrefManager;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

import org.json.JSONObject;

import java.util.Arrays;

/**
 * Created by erwinlim on 09/03/18.
 *
 * <p>
 * Our base activity of login class. This class intented to simplify the flow and authentications method.
 * this class is responsible for : </br>
 *  - Google Email Sign in</br>
 *  - Facebook email Sign in</br>
 *  - provide authentication of Firebase (this is used to simplify the parsing process & some functionalities)</br>
 *  - check the login session</br>
 *  </p>
 */

public class BaseLoginActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener, FacebookCallback<LoginResult>{
    private SignInButton signInButton;
    private static final String TAG = MainActivity.class.getSimpleName();
    private static final int RC_SIGN_IN = 007;
    private CallbackManager callbackManager;
    private LoginButton loginButton;
    private Activity mActivity;
    public FirebaseAuth mAuth;
    public PrefManager prefManager;

    /**
     * Provide seamless integration between Login main class with Google & Facebook Login.
     * also providing the firebase integration.
     *
     * @param savedInstanceState the default onCreate parameter
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = this;

        // Checking for first time launch - before calling setContentView()
        prefManager = new PrefManager(this);

        if (prefManager.isLoginSession() && this.mAuth.getCurrentUser()!= null) {
            launchDashboardScreen();
            finish();
        }

        configure_GButton();
        configure_FButton();

        Button btnFacebookSignIn = findViewById(R.id.login_btn_facebook);
        btnFacebookSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginButton.performClick();
            }
        });
    }

    private void configure_GButton(){
        // Configure sign-in to request the user's ID, email address, and basic
        // profile. ID and basic profile are included in DEFAULT_SIGN_IN.
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        // Build a GoogleSignInClient with the options specified by gso.
        final GoogleSignInClient mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        signInButton = findViewById(R.id.sign_in_button);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signInIntent = mGoogleSignInClient.getSignInIntent();
                startActivityForResult(signInIntent, RC_SIGN_IN);
            }
        });
    }

    private void configure_FButton(){

        loginButton = findViewById(R.id.login_button);
        loginButton.setReadPermissions(Arrays.asList("public_profile","email"));
        // If you are using in a fragment, call loginButton.setFragment(this);

        callbackManager = CallbackManager.Factory.create();
        // Callback registration
        loginButton.registerCallback(callbackManager, this);
    }

    /**
     * this function block is to parse and map the login result from facebook.
     * we use these lines before we use Firebase
     *
     * @param loginResult is LoginResult that we get from onSuccess at configure_FButton function
     */
    private void parseFacebookLoginResult(LoginResult loginResult){
        String accessToken = loginResult.getAccessToken().getToken();

        // save accessToken to SharedPreference
        final FacebookUtil facebookUtil = new FacebookUtil(mActivity);
        facebookUtil.saveAccessToken(accessToken);

        GraphRequest request = GraphRequest.newMeRequest(
                loginResult.getAccessToken(),
                new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(JSONObject jsonObject,
                                            GraphResponse response) {

                        // Getting FB User Data
                        Bundle facebookData = facebookUtil.getFacebookData(jsonObject);
                        Log.i("Facebook ID = ", facebookData.getString("idFacebook"));
                        //launchDashboardScreen();
                    }
                });

        Bundle parameters = new Bundle();
        parameters.putString("fields", "id,first_name,last_name,email,gender");
        request.setParameters(parameters);
        request.executeAsync();
    }

    /**
     * our function to move the activity into the dashboard.
     */
    public void launchDashboardScreen() {
        prefManager.setLoginSession(true);
        startActivity(new Intent(BaseLoginActivity.this, MainActivity.class));
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);

        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            storetoFirebase(data);

//            since we are using firebase to parse, lets mark this function
//            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
//            handleSignInResult(result);
        }
    }

    private void storetoFirebase(Intent data){
        Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
        try {
            // Google Sign In was successful, authenticate with Firebase
            GoogleSignInAccount account = task.getResult(ApiException.class);
            firebaseAuthWithGoogle(account);
        } catch (ApiException e) {
            // Google Sign In failed, update UI appropriately
            Log.w(TAG, "Google sign in failed", e);
            // ...
        }
    }


    private void firebaseAuthWithGoogle(GoogleSignInAccount acct) {
        Log.d(TAG, "firebaseAuthWithGoogle:" + acct.getId());

        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithCredential:success");
                            launchDashboardScreen();
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithCredential:failure", task.getException());

                        }

                        // ...
                    }
                });
    }

    private void handleFacebookAccessToken(AccessToken token) {
        Log.d(TAG, "handleFacebookAccessToken:" + token);

        AuthCredential credential = FacebookAuthProvider.getCredential(token.getToken());
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithCredential:success");
                            launchDashboardScreen();
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithCredential:failure", task.getException());
                        }

                        // ...
                    }
                });
    }


    /**
     * this function is a default function to parse & map the result of GoogleSignInResult.
     * It is used before we're using Firebase to simplify process to be inherited to login main class
     *
     * @param result is the result from the Google authentication consisted of the user's profile
     */
    private void handleSignInResult(GoogleSignInResult result) {
        Log.d(TAG, "handleSignInResult:" + result.isSuccess());
        if (result.isSuccess()) {
            // Signed in successfully, show authenticated UI.
            GoogleSignInAccount acct = result.getSignInAccount();

            Log.e(TAG, "google account id: " + acct.getId());

            String personName = acct.getDisplayName();
            String personID = acct.getId();
            String personPhotoUrl = acct.getPhotoUrl().toString();
            String email = acct.getEmail();

            Log.e(TAG, "Name: " + personName + ", email: " + email
                    + ", Image: " + personPhotoUrl);
            launchDashboardScreen();

        } else {
            // Signed out, show unauthenticated UI.
        }
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    /**
     * Called when the dialog completes without error.
     * <p/>
     * Note: This will be called instead of {@link #onCancel()} if any of the following conditions
     * are true.
     * <ul>
     * <li>
     * {@link com.facebook.share.widget.MessageDialog} is used.
     * </li>
     * <li>
     * The logged in Facebook user has not authorized the app that has initiated the dialog.
     * </li>
     * </ul>
     *
     * @param loginResult Result from the dialog
     */
    @Override
    public void onSuccess(LoginResult loginResult) {
        parseFacebookLoginResult(loginResult);
        handleFacebookAccessToken(loginResult.getAccessToken());
    }

    /**
     * Called when the dialog is canceled.
     * <p/>
     * Note: {@link #onSuccess(Object)} will be called instead if any of the following conditions
     * are true.
     * <ul>
     * <li>
     * {@link com.facebook.share.widget.MessageDialog} is used.
     * </li>
     * <li>
     * The logged in Facebook user has not authorized the app that has initiated the dialog.
     * </li>
     * </ul>
     */
    @Override
    public void onCancel() {

    }

    /**
     * Called when the dialog finishes with an error.
     *
     * @param error The error that occurred
     */
    @Override
    public void onError(FacebookException error) {

    }
}
