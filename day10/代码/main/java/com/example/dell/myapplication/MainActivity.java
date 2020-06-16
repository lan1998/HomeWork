package com.example.dell.myapplication;

import android.os.Bundle;

import com.example.dell.myapplication.Fragment.AppointCourseFragment;
import com.example.dell.myapplication.Fragment.CourseFragment;
import com.example.dell.myapplication.Fragment.HomeFragment;
import com.example.dell.myapplication.Fragment.MyFragment;
import com.example.dell.myapplication.adapter.VpAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayout tab_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        tab_layout = (TabLayout) findViewById(R.id.tab_layout);

        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new CourseFragment());
        fragments.add(new AppointCourseFragment());
        fragments.add(new MyFragment());

        VpAdapter vpAdapter = new VpAdapter(getSupportFragmentManager(), fragments);
        viewPager.setAdapter(vpAdapter);
        tab_layout.setupWithViewPager(viewPager);

        tab_layout.getTabAt(0).setText("首页").setIcon(R.drawable.home);
        tab_layout.getTabAt(1).setText("课程").setIcon(R.drawable.course);
        tab_layout.getTabAt(2).setText("约课记录").setIcon(R.drawable.appoint_course);
        tab_layout.getTabAt(3).setText("个人").setIcon(R.drawable.my);
    }
}
