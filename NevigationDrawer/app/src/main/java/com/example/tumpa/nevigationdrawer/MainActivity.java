package com.example.tumpa.nevigationdrawer;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends ActionBarActivity {
    Context context;
    RecyclerView myRecycleView;
    RecyclerView.LayoutManager myRVLayoutManager;
    RecyclerView.Adapter myRVAdapter;
    List<Doctor> doctorList;
    ProgressDialog pd;
    //ProgressBar mProgress;
    @InjectView(R.id.drawer_layout)DrawerLayout drawerLayout;
    @InjectView(R.id.toolbar) Toolbar toolbar;
    @InjectView(R.id.drawer_recyclerView)RecyclerView drawerRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.r_v_layout);
        ButterKnife.inject(this);

        setSupportActionBar(toolbar);



        //mProgress = (ProgressBar) findViewById(R.id.progress_bar);
        pd = new ProgressDialog(MainActivity.this);


        myRecycleView = (RecyclerView) findViewById(R.id.rv);


        myRVLayoutManager = new LinearLayoutManager(this);
        myRecycleView.setLayoutManager(myRVLayoutManager);
        doctorList = new ArrayList<Doctor>();
        myRVAdapter = new MyCardAdapter(doctorList,MainActivity.this);

        myRecycleView.setAdapter(myRVAdapter);


        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name);
        drawerLayout.setDrawerListener(drawerToggle);
        drawerToggle.syncState();

        List<String> rows = new ArrayList<>();
        rows.add("Option 1");
        rows.add("Option 2: B");
        rows.add("Option 3: D");

        DrawerAdapter drawerAdapter = new DrawerAdapter(rows);
        drawerRecyclerView.setAdapter(drawerAdapter);
        drawerRecyclerView.setHasFixedSize(true);
        drawerRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        String url = "http://www.designtrick.com/all/doctors_admin_panel/get_all_doctor.php";
        /*mProgress.setVisibility(View.VISIBLE);
        mProgress.setMax(150);
        mProgress.setProgress(0);*/
        pd.setTitle("Processing...");
        pd.setMessage("Please wait.");
        pd.setCancelable(false);
        pd.setIndeterminate(true);
        pd.show();

        final StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {


            @Override
            public void onResponse(String response) {
                Log.d("inside", "on request");
                //tv.setText(response.toString());
                try {
                    JSONObject object = new JSONObject(response);
                    JSONArray array = object.getJSONArray("requests");
                    Log.d("inside","try");

                    Doctor doctor;
                    doctorList.clear();
                    for ( int i = 0 ;i<array.length();i++)
                    {
                       // mProgress.incrementProgressBy(i + 2 * 5);

                        JSONObject obj = array.getJSONObject(i);

                        doctor = new Doctor(obj.getString("doctor_id"),obj.getString("category_id"),
                                obj.getString("doctor_name"),obj.getString("doctor_degree"),
                                obj.getString("doctor_contact_no"),obj.getString("others_info"),
                                obj.getString("caregory"),obj.getString("category_details"));

                        doctorList.add(doctor);

                    }
                    Log.d("inside", doctorList.toString());
                    myRVAdapter.notifyDataSetChanged();
                   /* mProgress.setProgress(0);
                    mProgress.setVisibility(View.GONE);*/
                    pd.dismiss();

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        Volley.newRequestQueue(this).add(request);




    }
}
