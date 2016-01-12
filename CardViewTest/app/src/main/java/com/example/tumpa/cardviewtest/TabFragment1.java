package com.example.tumpa.cardviewtest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by tumpa on 12/22/2015.
 */
public class TabFragment1 extends Fragment {
    public View v;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d("inside zzz", ViewPagerTabFragmentAdapter.doctor.toString());
        v = inflater.inflate(R.layout.tab_fragment_1, container,false);
        TextView degree = (TextView) v.findViewById(R.id.address);
        degree.setText(ViewPagerTabFragmentAdapter.doctor.getDoctor_degree());
        TextView contact = (TextView) v.findViewById(R.id.appointment);
        contact.setText(ViewPagerTabFragmentAdapter.doctor.getDoctor_contact_no());//

        TextView field = (TextView) v.findViewById(R.id.category);
        field.setText(ViewPagerTabFragmentAdapter.doctor.getCaregory());

        TextView fieldDetails = (TextView) v.findViewById(R.id.visiting_fees);
        fieldDetails.setText(ViewPagerTabFragmentAdapter.doctor.getCategory_details());
        TextView docDetails = (TextView) v.findViewById(R.id.doc_others_info);
        docDetails.setText(ViewPagerTabFragmentAdapter.doctor.getOthers_info());
        return v;
    }
}
