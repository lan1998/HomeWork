package com.example.dell.myapplication;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.dell.myapplication.adapter.VpAdapter;
import com.example.dell.myapplication.fragment.ContactPersonFragment;
import com.example.dell.myapplication.fragment.DynamicFragment;
import com.example.dell.myapplication.fragment.NewsFragment;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

public class MainActivity extends AppCompatActivity {

    private Toolbar mTool;
    private TextView mTool_tv;
    private ViewPager mVp;
    private TabLayout mTab;
    private LinearLayout mLl;
    private NavigationView mNv;
    private DrawerLayout mDl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mTool = (Toolbar) findViewById(R.id.tool);
        mTool_tv = (TextView) findViewById(R.id.tool_tv);
        mVp = (ViewPager) findViewById(R.id.vp);
        mTab = (TabLayout) findViewById(R.id.tab);
        mLl = (LinearLayout) findViewById(R.id.ll);
        mNv = (NavigationView) findViewById(R.id.nv);
        mDl = (DrawerLayout) findViewById(R.id.dl);

        mTool.setTitle("");
        mTool_tv.setText("消息");
        setSupportActionBar(mTool);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDl, mTool, R.string.app_name, R.string.app_name);
        toggle.syncState();
        mDl.addDrawerListener(toggle);

        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new NewsFragment());
        fragments.add(new ContactPersonFragment());
        fragments.add(new DynamicFragment());

        VpAdapter vpAdapter = new VpAdapter(getSupportFragmentManager(), fragments);
        mVp.setAdapter(vpAdapter);
        mTab.setupWithViewPager(mVp);

        mTab.getTabAt(0).setText("消息").setIcon(R.drawable.a);
        mTab.getTabAt(1).setText("联系人").setIcon(R.drawable.b);
        mTab.getTabAt(2).setText("动态").setIcon(R.drawable.c);

        mTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                if(position==0){
                    mTool_tv.setText("消息");
                }else if(position==1){
                    mTool_tv.setText("联系人");
                }else if(position==2){
                    mTool_tv.setText("动态");
                }
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
