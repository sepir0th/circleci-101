package com.example.lenovo.myapplication.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.lenovo.myapplication.R;


/**
 * Created by erwinlim on 12/02/18.
 */

public class TwoFragment extends Fragment implements View.OnClickListener{

    EditText editText;
    Button chgButton;
    Button switchButton;

    public TwoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        RelativeLayout mainLayout = (RelativeLayout )inflater.inflate(R.layout.fragment_two, container, false);
        editText = mainLayout.findViewById(R.id.inputFieldTwo);
        chgButton = mainLayout.findViewById(R.id.changeTextTwo);
        chgButton.setOnClickListener(this);
        switchButton = mainLayout.findViewById(R.id.switchActivityTwo);
        switchButton.setOnClickListener(this);

        // Inflate the layout for this fragment
        return mainLayout;
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.changeTextTwo:
                editText.setText("Lalala");
                break;
            case R.id.switchActivityTwo:
                Intent intent = new Intent(getActivity(), SecondActivity.class);
                intent.putExtra("input", editText.getText().toString());
                startActivity(intent);
                break;
        }

    }
}
