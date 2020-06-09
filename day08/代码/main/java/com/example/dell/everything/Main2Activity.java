package com.example.dell.everything;

import android.os.Bundle;

import com.example.dell.everything.adapter.VpAdapter;
import com.example.dell.everything.fragment.HomeFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

public class Main2Activity extends AppCompatActivity {

    private TabLayout mTab;
    private ViewPager mVp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
    }

    private void initView() {
        mTab = (TabLayout) findViewById(R.id.tab_main2);
        mVp = (ViewPager) findViewById(R.id.vp_main2);


        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new HomeFragment());
        fragments.add(new HomeFragment());
        fragments.add(new HomeFragment());

        VpAdapter vpAdapter = new VpAdapter(getSupportFragmentManager(), fragments);
        mVp.setAdapter(vpAdapter);
        mTab.setupWithViewPager(mVp);

        mTab.getTabAt(0).setText("首页").setIcon(R.drawable.a1);
        mTab.getTabAt(1).setText("课程").setIcon(R.drawable.a1);
        mTab.getTabAt(2).setText("约课记录").setIcon(R.drawable.a1);
        mTab.getTabAt(3).setText("个人").setIcon(R.drawable.a1);
    }
}
