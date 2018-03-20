package com.excite.mobile.shop.Activities.Home.EarnPointDetails.StampProgramDetails;

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

import com.excite.mobile.shop.Activities.Home.EarnPointDetails.MerchantDetails.MerchantDetails;
import com.excite.mobile.shop.R;

import java.util.ArrayList;


/**
 * Created by erwinlim on 12/02/18.
 */

public class StampProgramDetailsFragment extends Fragment{

    public StampProgramDetailsFragment() {
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
        StampProgramDetailsProperties rowProperties = new StampProgramDetailsProperties(R.drawable.starbucks_logo, "Dapatkan 1 Hazelnut Cup C Tall",
                "Djakarta Theater (Skyline) Lantai GF, Jalan M.H. Thamrin No. 9, Kebon Sirih, Menteng, RT.2/RW.1, RT.2/RW.1, Kb. Sirih, Menteng", "0.02KM away");
        StampProgramDetailsProperties rowProperties2 = new StampProgramDetailsProperties(R.drawable.starbucks_logo, "Dapatkan 1 Hazelnut Cup C Tall",
                "Djakarta Theater (Skyline) Lantai GF, Jalan M.H. Thamrin No. 9, Kebon Sirih, Menteng, RT.2/RW.1, RT.2/RW.1, Kb. Sirih, Menteng", "0.02KM away");
        StampProgramDetailsProperties rowProperties3 = new StampProgramDetailsProperties(R.drawable.starbucks_logo, "Dapatkan 1 Hazelnut Cup C Tall",
                "Djakarta Theater (Skyline) Lantai GF, Jalan M.H. Thamrin No. 9, Kebon Sirih, Menteng, RT.2/RW.1, RT.2/RW.1, Kb. Sirih, Menteng", "0.02KM away");
        StampProgramDetailsProperties rowProperties4 = new StampProgramDetailsProperties(R.drawable.starbucks_logo, "Dapatkan 1 Hazelnut Cup C Tall",
                "Djakarta Theater (Skyline) Lantai GF, Jalan M.H. Thamrin No. 9, Kebon Sirih, Menteng, RT.2/RW.1, RT.2/RW.1, Kb. Sirih, Menteng", "0.02KM away");
        StampProgramDetailsProperties rowProperties5 = new StampProgramDetailsProperties(R.drawable.starbucks_logo, "Dapatkan 1 Hazelnut Cup C Tall",
                "Djakarta Theater (Skyline) Lantai GF, Jalan M.H. Thamrin No. 9, Kebon Sirih, Menteng, RT.2/RW.1, RT.2/RW.1, Kb. Sirih, Menteng", "0.02KM away");
        StampProgramDetailsProperties rowProperties6 = new StampProgramDetailsProperties(R.drawable.starbucks_logo, "Dapatkan 1 Hazelnut Cup C Tall",
                "Djakarta Theater (Skyline) Lantai GF, Jalan M.H. Thamrin No. 9, Kebon Sirih, Menteng, RT.2/RW.1, RT.2/RW.1, Kb. Sirih, Menteng", "0.02KM away");
        StampProgramDetailsProperties rowProperties7 = new StampProgramDetailsProperties(R.drawable.starbucks_logo, "Dapatkan 1 Hazelnut Cup C Tall",
                "Djakarta Theater (Skyline) Lantai GF, Jalan M.H. Thamrin No. 9, Kebon Sirih, Menteng, RT.2/RW.1, RT.2/RW.1, Kb. Sirih, Menteng", "0.02KM away");

        //put it inside the collection
        ArrayList<StampProgramDetailsProperties> arrRowProperties = new ArrayList<>();
        arrRowProperties.add(rowProperties);
        arrRowProperties.add(rowProperties2);
        arrRowProperties.add(rowProperties3);
        arrRowProperties.add(rowProperties4);
        arrRowProperties.add(rowProperties5);
        arrRowProperties.add(rowProperties6);
        arrRowProperties.add(rowProperties7);
        final MySimpleArrayAdapter adapter = new MySimpleArrayAdapter(getContext(), arrRowProperties);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, final View view,
                                    int position, long id) {
                Intent intent = new Intent(getActivity(), MerchantDetails.class);
                startActivity(intent);
            }

        });
        return LayoutEarnPoint;
    }

    public class MySimpleArrayAdapter extends ArrayAdapter<StampProgramDetailsProperties> {
        private final Context context;
        private final ArrayList<StampProgramDetailsProperties> rowProperties;

        public MySimpleArrayAdapter(Context context, ArrayList<StampProgramDetailsProperties> rowProperties) {
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
            adapterLayout.getLayoutParams().height = (int) (100 * scale);

            TextView textTitle = rowView.findViewById(R.id.firstLine);
            TextView textSubtitle = rowView.findViewById(R.id.secondLine);
            textSubtitle.setLines(2);
            textSubtitle.setSingleLine(false);

            Button btn_shop = rowView.findViewById(R.id.btn_shop);
            btn_shop.setVisibility(View.GONE);
            Button btn_promo = rowView.findViewById(R.id.btn_promo);
            btn_promo.setVisibility(View.GONE);

            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT);
            params.addRule(RelativeLayout.BELOW, R.id.firstLine);
            params.addRule(RelativeLayout.RIGHT_OF, R.id.icon);
            textSubtitle.setLayoutParams(params);

            TextView textDistance = rowView.findViewById(R.id.txt_distances);
            ImageView imageView = rowView.findViewById(R.id.icon);

            textTitle.setText(this.rowProperties.get(position).getListTitle());
            textSubtitle.setText(this.rowProperties.get(position).getListSubtitle());
            textDistance.setText(this.rowProperties.get(position).getListDistance());
            imageView.setImageResource(this.rowProperties.get(position).getListIcon());


            return rowView;
        }
    }
}
