package com.hapen.hapen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Home and Discover Spinner
        Spinner homeAndDiscoverSpinner = findViewById(R.id.homeAndDiscoverSpinner);
        ArrayAdapter<CharSequence> homeAndDiscoverAdapter = ArrayAdapter.createFromResource(this,
                R.array.homeAndDiscover, android.R.layout.simple_spinner_item);
        homeAndDiscoverAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        homeAndDiscoverSpinner.setAdapter(homeAndDiscoverAdapter);
        homeAndDiscoverSpinner.setOnItemSelectedListener(this);

        // Filter Spinner
        Spinner filterSpinner = findViewById(R.id.filterSpinner);
        ArrayAdapter<CharSequence> filterAdapter = ArrayAdapter.createFromResource(this,
                R.array.filters, android.R.layout.simple_spinner_item);
        filterAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        filterSpinner.setAdapter(filterAdapter);
        filterSpinner.setOnItemSelectedListener(this);

        // Category Spinner
        Spinner categorySpinner = findViewById(R.id.categorySpinner);
        ArrayAdapter<CharSequence> categoryAdapter = ArrayAdapter.createFromResource(this,
                R.array.categories, android.R.layout.simple_spinner_item);
        categoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categorySpinner.setAdapter(categoryAdapter);
        categorySpinner.setOnItemSelectedListener(this);

        // Organization Spinner
        Spinner organizationSpinner = findViewById(R.id.organizationSpinner);
        ArrayAdapter<CharSequence> organizationAdapter = ArrayAdapter.createFromResource(this,
                R.array.organizations, android.R.layout.simple_spinner_item);
        organizationAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        organizationSpinner.setAdapter(organizationAdapter);
        organizationSpinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        // Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
}
