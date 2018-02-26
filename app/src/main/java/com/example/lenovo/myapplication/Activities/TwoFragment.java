package com.example.lenovo.myapplication.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.lenovo.myapplication.R;
import com.example.lenovo.myapplication.TestEmployee.Employee;
import com.example.lenovo.myapplication.TestEmployee.EmployeeAdapter;

import java.util.ArrayList;


/**
 * Created by erwinlim on 12/02/18.
 */

public class TwoFragment extends Fragment implements View.OnClickListener{

    EditText editText;
    Button chgButton;
    Button switchButton;

    private RecyclerView recyclerView;
    private EmployeeAdapter adapter;
    private ArrayList<Employee> employeeArrayList;

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

        employeeArrayList = new ArrayList<>();
        employeeArrayList.add(new Employee("Employee1", "emp1@example.com", "123456789"));
        employeeArrayList.add(new Employee("Employee2", "emp2@example.com", "987654321"));
        employeeArrayList.add(new Employee("Employee3", "emp3@example.com", "789456123"));
        employeeArrayList.add(new Employee("Employee4", "emp4@example.com", "321654987"));

        recyclerView = (RecyclerView) mainLayout.findViewById(R.id.recycler_view);

        adapter = new EmployeeAdapter(employeeArrayList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter);

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
