package com.excite.mobile.shop.Activities.Home.EarnPointDetails.ShopOnline;

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

import com.excite.mobile.shop.Activities.Home.EarnPointDetails.MerchantDetails.MerchantDetails;
import com.excite.mobile.shop.R;

import java.util.ArrayList;


/**
 * Created by erwinlim on 12/02/18.
 */

public class ShopOnlineFragment extends Fragment{
    private ListView mListView;

    public ShopOnlineFragment() {
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
        ShopOnlineProperties rowProperties = new ShopOnlineProperties(R.drawable.starbucks_logo, "Voucher Tokopedia Cashback 20Ribu",
                "Dapatkan cashback 20Ribu dengan minimal pembelian Rp200.000 khusus produk elektronik", "+2% Cashback Point");
        ShopOnlineProperties rowProperties2 = new ShopOnlineProperties(R.drawable.starbucks_logo, "Voucher Tokopedia Cashback 20Ribu",
                "Dapatkan cashback 20Ribu dengan minimal pembelian Rp200.000 khusus produk elektronik", "+2% Cashback Point");
        ShopOnlineProperties rowProperties3 = new ShopOnlineProperties(R.drawable.starbucks_logo, "Voucher Tokopedia Cashback 20Ribu",
                "Dapatkan cashback 20Ribu dengan minimal pembelian Rp200.000 khusus produk elektronik", "+2% Cashback Point");
        ShopOnlineProperties rowProperties4 = new ShopOnlineProperties(R.drawable.starbucks_logo, "Voucher Tokopedia Cashback 20Ribu",
                "Dapatkan cashback 20Ribu dengan minimal pembelian Rp200.000 khusus produk elektronik", "+2% Cashback Point");
        ShopOnlineProperties rowProperties5 = new ShopOnlineProperties(R.drawable.starbucks_logo, "Voucher Tokopedia Cashback 20Ribu",
                "Dapatkan cashback 20Ribu dengan minimal pembelian Rp200.000 khusus produk elektronik", "+2% Cashback Point");
        ShopOnlineProperties rowProperties6 = new ShopOnlineProperties(R.drawable.starbucks_logo, "Voucher Tokopedia Cashback 20Ribu",
                "Dapatkan cashback 20Ribu dengan minimal pembelian Rp200.000 khusus produk elektronik", "+2% Cashback Point");
        ShopOnlineProperties rowProperties7 = new ShopOnlineProperties(R.drawable.starbucks_logo, "Voucher Tokopedia Cashback 20Ribu",
                "Dapatkan cashback 20Ribu dengan minimal pembelian Rp200.000 khusus produk elektronik", "+2% Cashback Point");

        //put it inside the collection
        ArrayList<ShopOnlineProperties> arrRowProperties = new ArrayList<>();
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
            adapterLayout.getLayoutParams().height = (int) (100 * scale);

            TextView textTitle = rowView.findViewById(R.id.firstLine);
            TextView textSubtitle = rowView.findViewById(R.id.secondLine);
            textSubtitle.setLines(2);
            textSubtitle.setSingleLine(false);

            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(textSubtitle.getLayoutParams().width,
                    RelativeLayout.LayoutParams.WRAP_CONTENT);
            params.width = (int)(200 * scale);
            params.addRule(RelativeLayout.BELOW, R.id.firstLine);
            params.addRule(RelativeLayout.RIGHT_OF, R.id.icon);
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
