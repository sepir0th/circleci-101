package com.excite.mobile.shop.Activities.EarnPointDetails;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
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
import android.widget.RelativeLayout;
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
        ListEarnPointsMenuProperties rowProperties = new ListEarnPointsMenuProperties(R.drawable.starbucks_logo, "Voucher Tokopedia Cashback 20Ribu",
                "Dapatkan cashback 20Ribu dengan minimal pembelian Rp200.000 khusus produk elektronik", "+2% Cashback Point");
        ListEarnPointsMenuProperties rowProperties2 = new ListEarnPointsMenuProperties(R.drawable.starbucks_logo, "Voucher Tokopedia Cashback 20Ribu",
                "Dapatkan cashback 20Ribu dengan minimal pembelian Rp200.000 khusus produk elektronik", "+2% Cashback Point");
        ListEarnPointsMenuProperties rowProperties3 = new ListEarnPointsMenuProperties(R.drawable.starbucks_logo, "Voucher Tokopedia Cashback 20Ribu",
                "Dapatkan cashback 20Ribu dengan minimal pembelian Rp200.000 khusus produk elektronik", "+2% Cashback Point");
        ListEarnPointsMenuProperties rowProperties4 = new ListEarnPointsMenuProperties(R.drawable.starbucks_logo, "Voucher Tokopedia Cashback 20Ribu",
                "Dapatkan cashback 20Ribu dengan minimal pembelian Rp200.000 khusus produk elektronik", "+2% Cashback Point");
        ListEarnPointsMenuProperties rowProperties5 = new ListEarnPointsMenuProperties(R.drawable.starbucks_logo, "Voucher Tokopedia Cashback 20Ribu",
                "Dapatkan cashback 20Ribu dengan minimal pembelian Rp200.000 khusus produk elektronik", "+2% Cashback Point");
        ListEarnPointsMenuProperties rowProperties6 = new ListEarnPointsMenuProperties(R.drawable.starbucks_logo, "Voucher Tokopedia Cashback 20Ribu",
                "Dapatkan cashback 20Ribu dengan minimal pembelian Rp200.000 khusus produk elektronik", "+2% Cashback Point");
        ListEarnPointsMenuProperties rowProperties7 = new ListEarnPointsMenuProperties(R.drawable.starbucks_logo, "Voucher Tokopedia Cashback 20Ribu",
                "Dapatkan cashback 20Ribu dengan minimal pembelian Rp200.000 khusus produk elektronik", "+2% Cashback Point");

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

            final float scale = getResources().getDisplayMetrics().density;

            RelativeLayout adapterLayout = rowView.findViewById(R.id.listview_adapter_layout);
            adapterLayout.getLayoutParams().height = (int) (100 * scale);

            TextView textTitle = rowView.findViewById(R.id.firstLine);
            TextView textSubtitle = rowView.findViewById(R.id.secondLine);
            textSubtitle.setLines(2);
            textSubtitle.setSingleLine(false);

            ViewGroup.LayoutParams params = textSubtitle.getLayoutParams();
            params.width=20;
            textSubtitle.setLayoutParams(params);


            TextView textDistance = rowView.findViewById(R.id.txt_distances);
            ImageView imageView = rowView.findViewById(R.id.icon);

            textTitle.setText(this.rowProperties.get(position).getListTitle());
            textSubtitle.setText(this.rowProperties.get(position).getListSubtitle());
            textDistance.setText(this.rowProperties.get(position).getListDistance());
            textDistance.setTextColor(Color.RED);
            imageView.setImageResource(this.rowProperties.get(position).getListIcon());


            return rowView;
        }
    }
}
