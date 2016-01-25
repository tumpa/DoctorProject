package com.example.tumpa.cardviewtest;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView myRecycleView;
    RecyclerView.LayoutManager myRVLayoutManager;
    RecyclerView.Adapter myRVAdapter;
    List<Doctor> doctorList;
    List<Doctor> doctortemp;
    List<String> categoryList;
    //ProgressBar mProgress;
    ProgressDialog pd;
    ImageButton search;
    Spinner categorySpnr;
    HashMap categoryHM ;
    ArrayAdapter<String> dataAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.r_v_layout);
        //mProgress = (ProgressBar) findViewById(R.id.progress_bar);
        pd = new ProgressDialog(MainActivity.this);
        pd.setTitle("Processing...");
        pd.setMessage("Please wait.");
        pd.setCancelable(false);
        pd.setIndeterminate(true);

        search = (ImageButton) findViewById(R.id.search_btn);
        categorySpnr = (Spinner) findViewById(R.id.category_spinner);

        myRecycleView = (RecyclerView) findViewById(R.id.rv);


        myRVLayoutManager = new LinearLayoutManager(this);
        myRecycleView.setLayoutManager(myRVLayoutManager);
        doctorList = new ArrayList<Doctor>();
        doctortemp = new ArrayList<Doctor>();

        categoryList = new ArrayList<String>();
        categoryHM = new HashMap();


        /////////////////////Spinner Implementation //////////////////
        dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item,categoryList );
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categorySpnr.setAdapter(dataAdapter);

        /////////////////////Search Implementation //////////////
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("btn onclick", categorySpnr.getSelectedItem().toString());
                String s = categorySpnr.getSelectedItem().toString();
                String id = (String) categoryHM.get(s);


                if(s.equals("All")){
                    doctorList.clear();
                    doctorList.addAll(doctortemp);
                    myRVAdapter.notifyDataSetChanged();

                }
                else {
                    String url = "http://www.designtrick.com/all/doctors_admin_panel/get_doc_by_category.php?id="+id;
                    /*mProgress.setVisibility(View.VISIBLE);
                    mProgress.setMax(150);
                    mProgress.setProgress(0);*/
                    pd.show();

                    final StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONObject object = new JSONObject(response);
                                JSONArray array = object.getJSONArray("requests");


                                Doctor doctor;
                                doctorList.clear();
                                for ( int i = 0 ;i<array.length();i++)
                                {
                                    //mProgress.incrementProgressBy(i + 2 * 5);

                                    JSONObject obj = array.getJSONObject(i);

                                    doctor = new Doctor(obj.getString("doctor_id"),obj.getString("category_id"),
                                            obj.getString("doctor_name"),obj.getString("doctor_degree"),
                                            obj.getString("doctor_contact_no"),obj.getString("others_info"),
                                            obj.getString("caregory"),obj.getString("category_details"));

                                    doctorList.add(doctor);

                                }
                                myRVAdapter.notifyDataSetChanged();
                                /*mProgress.setProgress(0);
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
                    Volley.newRequestQueue(MainActivity.this).add(request);
                }

            }
        });



        myRVAdapter = new MyCardAdapter(doctorList,MainActivity.this);

        myRecycleView.setAdapter(myRVAdapter);


        String url = "http://www.designtrick.com/all/doctors_admin_panel/get_all_doctor.php";
        /*mProgress.setVisibility(View.VISIBLE);
        mProgress.setMax(150);
        mProgress.setProgress(0);*/
        pd.show();
        final StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {


            @Override
            public void onResponse(String response) {
                Log.d("inside", "on request");
                //tv.setText(response.toString());

                try {
                    JSONObject object = new JSONObject(response);
                    JSONArray array = object.getJSONArray("requests");
                    Log.d("inside", "try");

                    Doctor doctor;
                    doctorList.clear();
                    for ( int i = 0 ;i<array.length();i++)
                    {
                        //mProgress.incrementProgressBy(i + 2 * 5);

                        JSONObject obj = array.getJSONObject(i);

                        doctor = new Doctor(obj.getString("doctor_id"),obj.getString("category_id"),
                                obj.getString("doctor_name"),obj.getString("doctor_degree"),
                                obj.getString("doctor_contact_no"),obj.getString("others_info"),
                                obj.getString("caregory"),obj.getString("category_details"));

                        doctorList.add(doctor);

                    }
                    doctortemp.addAll(doctorList);
                    Log.d("inside", doctorList.toString());
                    myRVAdapter.notifyDataSetChanged();
                    /*mProgress.setProgress(0);
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

        //////////////////////////////// Category Request/////////////////

        String url2 = "http://www.designtrick.com/all/doctors_admin_panel/get_all_category.php";
        final StringRequest request2 = new StringRequest(Request.Method.GET, url2, new Response.Listener<String>() {


            @Override
            public void onResponse(String response) {
                try {
                    JSONObject object = new JSONObject(response);
                    JSONArray array = object.getJSONArray("requests");

                    Category category;
                    categoryList.clear();
                    categoryList.add("All");
                    for ( int i = 0 ;i<array.length();i++)
                    {

                        JSONObject obj = array.getJSONObject(i);

                        category = new Category(obj.getString("category_id"),obj.getString("caregory"));
                        categoryList.add(category.getCategoryField().toString());
                        categoryHM.put(category.getCategoryField().toString(),category.categoryID.toString());

                    }
                    dataAdapter.notifyDataSetChanged();

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        Volley.newRequestQueue(this).add(request2);

}



}
