package com.excite.mobile.shop.Activities.EarnPointDetails;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.excite.mobile.shop.Activities.MerchantDetails.MerchantDetails;
import com.excite.mobile.shop.R;

import java.util.ArrayList;


/**
 * Created by erwinlim on 12/02/18.
 */

public class ListEarnPointsMenuFragment extends Fragment{
    private ListView mListView;

    public ListEarnPointsMenuFragment() {
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
        ListEarnPointsMenuProperties rowProperties = new ListEarnPointsMenuProperties(R.drawable.starbucks_logo, "Starbuck",
                "Jalan KH Wahid Hasyim no 89, Sarinah", "0.02 KM");
        ListEarnPointsMenuProperties rowProperties2 = new ListEarnPointsMenuProperties(R.drawable.starbucks_logo, "Kopi Tiam",
                "Jalan KH Wahid Hasyim no 89, Menteng", "0.02 KM");
        ListEarnPointsMenuProperties rowProperties3 = new ListEarnPointsMenuProperties(R.drawable.starbucks_logo, "Killiney",
                "Jalan KH Wahid Hasyim no 89, Gandaria", "0.02 KM");
        ListEarnPointsMenuProperties rowProperties4 = new ListEarnPointsMenuProperties(R.drawable.starbucks_logo, "Anomali",
                "Jalan KH Wahid Hasyim no 89, Menteng", "0.02 KM");
        ListEarnPointsMenuProperties rowProperties5 = new ListEarnPointsMenuProperties(R.drawable.starbucks_logo, "Chatime",
                "Jalan KH Wahid Hasyim no 89, Kebayoran", "0.02 KM");
        ListEarnPointsMenuProperties rowProperties6 = new ListEarnPointsMenuProperties(R.drawable.starbucks_logo, "Lekafe",
                "Jalan KH Wahid Hasyim no 89, Sabang", "0.02 KM");
        ListEarnPointsMenuProperties rowProperties7 = new ListEarnPointsMenuProperties(R.drawable.starbucks_logo, "Meow Cafe",
                "Jalan KH Wahid Hasyim no 89, Merauke", "0.02 KM");

        //put it inside the collection
        ArrayList<ListEarnPointsMenuProperties> arrRowProperties = new ArrayList<>();
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

    public class MySimpleArrayAdapter extends ArrayAdapter<ListEarnPointsMenuProperties> {
        private final Context context;
        private final ArrayList<ListEarnPointsMenuProperties> rowProperties;

        public MySimpleArrayAdapter(Context context, ArrayList<ListEarnPointsMenuProperties> rowProperties) {
            super(context, -1, rowProperties);
            this.context = context;
            this.rowProperties = rowProperties;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View rowView = inflater.inflate(R.layout.listview_adapter_earnpoint, parent, false);
            TextView textTitle = rowView.findViewById(R.id.firstLine);
            TextView textSubtitle = rowView.findViewById(R.id.secondLine);
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
