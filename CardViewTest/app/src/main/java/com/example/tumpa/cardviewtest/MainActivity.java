package com.example.tumpa.cardviewtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

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

public class MainActivity extends AppCompatActivity {
    RecyclerView myRecycleView;
    RecyclerView.LayoutManager myRVLayoutManager;
    RecyclerView.Adapter myRVAdapter;
    List<Doctor> doctorList;

    ProgressBar mProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.r_v_layout);
        mProgress = (ProgressBar) findViewById(R.id.progress_bar);

        myRecycleView = (RecyclerView) findViewById(R.id.rv);


        myRVLayoutManager = new LinearLayoutManager(this);
        myRecycleView.setLayoutManager(myRVLayoutManager);
        doctorList = new ArrayList<Doctor>();
        myRVAdapter = new MyCardAdapter(doctorList,MainActivity.this);

        myRecycleView.setAdapter(myRVAdapter);





        String url = "http://www.designtrick.com/all/doctors_admin_panel/get_all_doctor.php";
        mProgress.setVisibility(View.VISIBLE);
        mProgress.setMax(150);
        mProgress.setProgress(0);

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
                        mProgress.incrementProgressBy(i + 2 * 5);

                        JSONObject obj = array.getJSONObject(i);

                        doctor = new Doctor(obj.getString("doctor_id"),obj.getString("category_id"),
                                obj.getString("doctor_name"),obj.getString("doctor_degree"),
                                obj.getString("doctor_contact_no"),obj.getString("others_info"),
                                obj.getString("caregory"),obj.getString("category_details"));

                        doctorList.add(doctor);

                    }
                    Log.d("inside", doctorList.toString());
                    myRVAdapter.notifyDataSetChanged();
                    mProgress.setProgress(0);
                    mProgress.setVisibility(View.GONE);

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
