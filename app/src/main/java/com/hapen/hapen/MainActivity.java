package com.hapen.hapen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

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




        Log.d(TAG,"onCreate: started.");
        initImageBitmaps();

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        // Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }




    private static final String TAG = "MainActivity";

    //vars
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();



    private void initImageBitmaps(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        mImageUrls.add("https://alltogether.swe.org/wp-content/uploads/2018/05/SWE-Logo-Gray-Background-e1463523395680.jpg");
        mNames.add("Society of Women Engineers");

        mImageUrls.add("https://www.acm.org/binaries/content/gallery/acm/ctas/ambassadors-for-acm.jpg/ambassadors-for-acm.jpg/acm%3Adesktopcta");
        mNames.add("Association of Computing Machinery");

        mImageUrls.add("https://upload.wikimedia.org/wikipedia/en/thumb/e/ea/NSBE_organization_logo.png/220px-NSBE_organization_logo.png");
        mNames.add("National Society of Black Engineers");

        mImageUrls.add("https://pbs.twimg.com/profile_images/1028220746701697024/4zJphHM7_400x400.jpg");
        mNames.add("African Student Association");


        mImageUrls.add("https://nabaphilly.org/wp-content/uploads/2014/09/cropped-naba_logo-e1503146045204.jpg");
        mNames.add("National Association of Black Accountants ");

        mImageUrls.add("https://pbs.twimg.com/profile_images/867773389766893568/u52eecrL_400x400.jpg");
        mNames.add("Purple Jackets");


        mImageUrls.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTkAaU9zwEOUIOU4JqjIKmKRDhpDDjQzihefKCG4gcw7CSu-znq");
        mNames.add("Institute of Electrical and Electronics Engineers");

        mImageUrls.add("https://www.fxu.org.uk/asset/Organisation/6206/square%20logo.jpg?thumbnail_width=250&thumbnail_height=250&resize_type=CropToFit&fill_colour=cccccc");
        mNames.add("Enactus");

        mImageUrls.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ81GsFJ05OHdj75pgzOvkPkzqOwErw_m_VxUP2lUqFl2j2SkV22Q");
        mNames.add("Minority Association of Pre-Med Students");

        initRecyclerView();

    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview.");
        RecyclerView recyclerView = findViewById(R.id.recyclerv_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(mNames, mImageUrls, this);
        recyclerView.setAdapter(adapter);
        //RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mNames, mImageUrls);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}
