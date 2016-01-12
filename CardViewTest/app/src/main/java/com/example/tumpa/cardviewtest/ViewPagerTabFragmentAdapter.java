package com.example.tumpa.cardviewtest;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import java.util.List;

/**
 * Created by tumpa on 12/22/2015.
 */
public class ViewPagerTabFragmentAdapter extends FragmentStatePagerAdapter {
    int tabNumber;
    static Doctor doctor;
    static List<Doctor> doctorList;
    public ViewPagerTabFragmentAdapter(Doctor doctor,FragmentManager fm,int tabNumber) {
        super(fm);
        this.tabNumber = tabNumber;
        this.doctor = doctor;
        Log.d("inside sss", this.doctor.toString());
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
               TabFragment1 tab1 = new TabFragment1();
               return tab1;
            case 1:

                TabFragment2 tab2 = new TabFragment2();
                return tab2;
            case 2:
                TabFragment3 tab3 = new TabFragment3();
                return tab3;
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return tabNumber;
    }
}
