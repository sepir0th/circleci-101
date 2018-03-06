package com.example.lenovo.myapplication.Activities.RedeemPointsDetails;

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

import com.example.lenovo.myapplication.Activities.MerchantDetails.MerchantDetails;
import com.example.lenovo.myapplication.R;

/**
 * Created by erwinlim on 05/03/18.
 */

public class RedeemDetailsFragment extends Fragment {
    private ListView mListView;

    public RedeemDetailsFragment() {
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
        LinearLayout LayoutEarnPoint = (LinearLayout) inflater.inflate(R.layout.fragment_redeem, container, false);
        final ListView listview = (ListView) LayoutEarnPoint.findViewById(R.id.recipe_list_view);
        String[] values = new String[] { "Android", "iPhone", "WindowsMobile",
                "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
                "Linux", "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux",
                "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux", "OS/2",
                "Android", "iPhone", "WindowsMobile" };

        final MySimpleArrayAdapter adapter = new MySimpleArrayAdapter(getContext(), values);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, final View view,
                                    int position, long id) {
                final String item = (String) parent.getItemAtPosition(position);
                Intent intent = new Intent(getActivity(), MerchantDetails.class);
                startActivity(intent);
            }

        });
        return LayoutEarnPoint;
    }

    public class MySimpleArrayAdapter extends ArrayAdapter<String> {
        private final Context context;
        private final String[] values;

        public MySimpleArrayAdapter(Context context, String[] values) {
            super(context, -1, values);
            this.context = context;
            this.values = values;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View rowView = inflater.inflate(R.layout.listview_adapter_earnpoint, parent, false);
            TextView textView = rowView.findViewById(R.id.secondLine);
            ImageView imageView = rowView.findViewById(R.id.icon);
            textView.setText(values[position]);
            // change the icon for Windows and iPhone
            String s = values[position];
            if (s.startsWith("iPhone")) {
                imageView.setImageResource(R.drawable.ic_010_watch);
            } else {
                imageView.setImageResource(R.drawable.ic_099_wallet);
            }

            return rowView;
        }
    }
}
