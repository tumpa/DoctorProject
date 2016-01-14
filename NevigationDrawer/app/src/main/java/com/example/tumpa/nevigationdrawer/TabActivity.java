package com.example.tumpa.nevigationdrawer;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.widget.TextView;

/**
 * Created by tumpa on 12/25/2015.
 */
public class TabActivity extends MainActivity {
    Doctor doctor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_test);
        Intent i = getIntent() ;

        doctor = (Doctor) i.getSerializableExtra("doc_details");


        TextView name = (TextView) findViewById(R.id.detail_name);
        name.setText(doctor.getDoctor_name());
        TextView category = (TextView) findViewById(R.id.detail_field);
        category.setText(doctor.getCaregory());


        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Details"));
        tabLayout.addTab(tabLayout.newTab().setText("Chambers"));
        tabLayout.addTab(tabLayout.newTab().setText("Comment"));

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final ViewPagerTabFragmentAdapter adapter = new ViewPagerTabFragmentAdapter(doctor,getSupportFragmentManager(),
                tabLayout.getTabCount());
        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }
}
