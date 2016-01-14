package com.example.tumpa.nevigationdrawer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

/**
 * Created by tumpa on 12/22/2015.
 */
public class TabFragment2 extends Fragment {
    public View v;
    RecyclerView chamberRecycleView;
    RecyclerView.LayoutManager chamberRVLayoutManager;
    RecyclerView.Adapter chamberRVAdapter;
    List<Chamber> chamberList;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.tab_fragment_2, container, false);
        chamberRecycleView = (RecyclerView) v.findViewById(R.id.rv_chamber);

        chamberRVLayoutManager = new LinearLayoutManager(this.getContext());
        chamberRecycleView.setLayoutManager(chamberRVLayoutManager);
        chamberList = new ArrayList<Chamber>();
        chamberRVAdapter = new ChamberCardAdaptor(chamberList,this.getContext());
        chamberRecycleView.setAdapter(chamberRVAdapter);

        String url = "http://www.designtrick.com/all/doctors_admin_panel/get_chamber_by_doc_id.php?doc_id="+ViewPagerTabFragmentAdapter.doctor.getDoctor_id();


        final StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Log.d("inside", "on request");
                //tv.setText(response.toString());
                try {
                    JSONObject object = new JSONObject(response);
                    JSONArray array = object.getJSONArray("requests");
                    Log.d("inside","try");
                    Chamber chamber;
                    chamberList.clear();
                    for ( int i = 0 ;i<array.length();i++)
                    {
                        JSONObject obj = array.getJSONObject(i);

                        chamber = new Chamber(obj.getString("doctor_id"),obj.getString("chamber_id"),
                                obj.getString("visiting_fee"),obj.getString("chamber_address"),
                                obj.getString("appointment"),obj.getString("room"),
                                obj.getString("arrival"),obj.getString("leave"));

                        chamberList.add(chamber);

                    }
                    Log.d("inside", chamberList.toString());
                    chamberRVAdapter.notifyDataSetChanged();

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        Volley.newRequestQueue(this.getContext()).add(request);



        return v;
    }
}
