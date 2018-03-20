package com.excite.mobile.shop.Activities.Info;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.excite.mobile.shop.Activities.Home.EarnPointDetails.ShopOnline.ShopOnlineProperties;
import com.excite.mobile.shop.Database.AppDatabase;
import com.excite.mobile.shop.Database.Notification;
import com.excite.mobile.shop.R;
import com.excite.mobile.shop.Utils.AppConstants;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by erwinlim on 12/02/18.
 */

public class InfoFragment extends Fragment {
    private ListView mListView;

    public InfoFragment() {
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
        LinearLayout LayoutEarnPoint = (LinearLayout) inflater.inflate(R.layout.fragment_earn_points_food, container, false);
        final ListView listview = LayoutEarnPoint.findViewById(R.id.recipe_list_view);

        //lets populate our sample data
        ShopOnlineProperties rowProperties = new ShopOnlineProperties(R.drawable.ic_022_new, "Promotion",
                "Makan enak, ngeGrab gratis", "");
        ShopOnlineProperties rowProperties2 = new ShopOnlineProperties(R.drawable.ic_022_new, "Waktunya laga sepak bola Spanyol!",
                "Nonton LaLiga langsung di Spanyol", "");
        ShopOnlineProperties rowProperties3 = new ShopOnlineProperties(R.drawable.ic_022_new, "Diskon GrabBike Seminggu?",
                "Klik untuk lihat kode promonya", "");
        ShopOnlineProperties rowProperties4 = new ShopOnlineProperties(R.drawable.ic_022_new, "Sedang cari promo Grab",
                "Gak teat ke kantor, pakagi GrabNow!", "");
        ShopOnlineProperties rowProperties5 = new ShopOnlineProperties(R.drawable.ic_022_new, "Mau irit? Pakai kartu kredit!",
                "Ga pakai duit beli barang keren", "");
        ShopOnlineProperties rowProperties6 = new ShopOnlineProperties(R.drawable.ic_022_new, "Message from Excite",
                "Nunggu itu berat, nanti kamu telat. Pakai ini", "");
        ShopOnlineProperties rowProperties7 = new ShopOnlineProperties(R.drawable.ic_022_new, "Pulang dapat pacar baru! mau?",
                "Naik GrabHitch (Nebeng) Car aja", "");

        //put it inside the collection
        final ArrayList<ShopOnlineProperties> arrRowProperties = new ArrayList<>();

        //our blocks of database function
        List<Notification> NotificationData =  AppDatabase.getAppDatabase(getContext()).notificationDao().getAll();
        for(Notification notificationDataRow : NotificationData){
            ListInfoProperties rowPropertiesData = new ListInfoProperties(R.drawable.ic_022_new, notificationDataRow.getNotificationTitle(),
                    notificationDataRow.getNotificationSubtitle(), notificationDataRow.getNotificationID());
            arrRowProperties.add(rowPropertiesData);
        }

        final InfoFragment.MySimpleArrayAdapter adapter = new InfoFragment.MySimpleArrayAdapter(getContext(), arrRowProperties);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, final View view,
                                    int position, long id) {
                Intent intent = new Intent(getActivity(), Activity_InfoDetail.class);
                intent.putExtra(AppConstants.NOTIFICATION_ID, ((ListInfoProperties)arrRowProperties.get(position)).getNotificationID().toString());
                startActivity(intent);
            }

        });
        return LayoutEarnPoint;
    }

    public class MySimpleArrayAdapter extends ArrayAdapter<ShopOnlineProperties> {
        private final Context context;
        private final ArrayList<ShopOnlineProperties> rowProperties;

        public MySimpleArrayAdapter(Context context, ArrayList<ShopOnlineProperties> rowProperties) {
            super(context, -1, rowProperties);
            this.context = context;
            this.rowProperties = rowProperties;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View rowView = inflater.inflate(R.layout.listview_adapter_earnpoint, parent, false);

            final float scale = getResources().getDisplayMetrics().density;

            RelativeLayout adapterLayout = rowView.findViewById(R.id.listview_adapter_layout);
            adapterLayout.getLayoutParams().height = (int) (70 * scale);
            TextView textTitle = rowView.findViewById(R.id.firstLine);
            TextView textSubtitle = rowView.findViewById(R.id.secondLine);
            TextView textDistance = rowView.findViewById(R.id.txt_distances);
            ImageView imageView = rowView.findViewById(R.id.icon);

            Button btn_shop = rowView.findViewById(R.id.btn_shop);
            btn_shop.setVisibility(View.GONE);
            Button btn_promo = rowView.findViewById(R.id.btn_promo);
            btn_promo.setVisibility(View.GONE);

            textTitle.setText(this.rowProperties.get(position).getListTitle());
            textTitle.setTextSize(20.0f);

            if(this.rowProperties.get(position).getListSubtitle() == ""){
                textSubtitle.setVisibility(View.GONE);
            }else{
                textSubtitle.setText(this.rowProperties.get(position).getListSubtitle());
                textSubtitle.setTextSize(17.0f);
            }

            if(this.rowProperties.get(position).getListDistance() == ""){
                textDistance.setVisibility(View.GONE);
            }else {
                textDistance.setText(this.rowProperties.get(position).getListDistance());
            }
            imageView.setImageResource(this.rowProperties.get(position).getListIcon());

            return rowView;
        }
    }
}
