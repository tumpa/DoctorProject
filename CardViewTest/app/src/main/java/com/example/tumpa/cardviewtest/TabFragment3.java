package com.example.tumpa.cardviewtest;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * Created by tumpa on 12/22/2015.
 */
public class TabFragment3 extends Fragment {
    public View v;
    ListView commentList;
    Context c;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.tab_fragment_3, container, false);

        commentList = (ListView) v.findViewById(R.id.listView);
        c = v.getContext();
        int [] prgmImages={R.drawable.person,R.drawable.person,R.drawable.person,R.drawable.person,R.drawable.person,R.drawable.person};
        String [] prgmNameList={"He is a good doc","Nice person","Very Much careful to patient","Responsible and caring","Best doc I ever have","Too busy"};
        commentList.setAdapter(new CustomListAdapter(c,prgmImages,prgmNameList));
        return v;
    }
}
