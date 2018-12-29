package com.example.sumsang_rookie.mytab;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.example.sumsang_rookie.mytab.temp.MyFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity implements OnClickListener {
    private final String TAG = "MainActivity";
    private MyViewPager mViewPager;
    private FragmentPagerAdapter mAdapter;
    private List<MyFragment> mFragments;

    private LinearLayout homeTab;
    private LinearLayout mapTab;
    private LinearLayout discoverTab;
    private LinearLayout myInfoTab;

    private ImageButton mImgHome;
    private ImageButton mImgMap;
    private ImageButton mImgDiscover;
    private ImageButton mImgMyInfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initViews();
        initEvents();
        initDatas();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }


    private void initEvents() {
        homeTab.setOnClickListener(this);
        mapTab.setOnClickListener(this);
        discoverTab.setOnClickListener(this);
        myInfoTab.setOnClickListener(this);
    }

    private void initViews() {
        mViewPager = (MyViewPager) findViewById(R.id.id_viewpager);
        homeTab = (LinearLayout) findViewById(R.id.id_tab_home);
        mapTab = (LinearLayout) findViewById(R.id.id_tab_map);
        discoverTab = (LinearLayout) findViewById(R.id.id_tab_discover);
        myInfoTab = (LinearLayout) findViewById(R.id.id_tab_myInfo);

        mImgHome = (ImageButton) findViewById(R.id.id_tab_home_img);
        mImgMap = (ImageButton) findViewById(R.id.id_tab_map_img);
        mImgDiscover = (ImageButton) findViewById(R.id.id_tab_discover_img);
        mImgMyInfo = (ImageButton) findViewById(R.id.id_tab_myInfo_img);
    }

    private void initDatas() {
        mFragments = new ArrayList<>();
        mFragments.add(new HomeFragment());
        mFragments.add(new MapFragment());
        mFragments.add(new DiscoverFragment());
        mFragments.add(new MyInfoFragment());
        mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public MyFragment getItem(int position) {
                Log.d(TAG, "getItem: " + position);
                return mFragments.get(position);
            }

            @Override
            public int getCount() {
                return mFragments.size();
            }
        };

        mViewPager.setAdapter(mAdapter);
        mViewPager.setOffscreenPageLimit(0);
        mViewPager.addOnPageChangeListener(new OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Log.d(TAG, "onPageSelected: " + position);
                //mViewPager.setCurrentItem(position);
//                resetImgs();
//                selectTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        resetImgs();
        switch (v.getId()) {
            case R.id.id_tab_home:
                selectTab(0);
                break;
            case R.id.id_tab_map:
                selectTab(1);
                break;
            case R.id.id_tab_discover:
                selectTab(2);
                break;
            case R.id.id_tab_myInfo:
                selectTab(3);
                break;
        }
    }

    private void resetImgs() {
        mImgHome.setImageResource(R.mipmap.home_tab_normal);
        mImgMap.setImageResource(R.mipmap.map_tab_normal);
        mImgDiscover.setImageResource(R.mipmap.discover_tab_normal);
        mImgMyInfo.setImageResource(R.mipmap.myinfo_tab_normal);
    }

    private void selectTab(int i) {
        switch (i) {
            case 0:
                mImgHome.setImageResource(R.mipmap.home_tab_pressed);
                Log.d(TAG, "selectTab: home");
                break;
            case 1:
                mImgMap.setImageResource(R.mipmap.map_tab_pressed);
                Log.d(TAG, "selectTab: map");
                break;
            case 2:
                mImgDiscover.setImageResource(R.mipmap.discover_tab_pressed);
                Log.d(TAG, "selectTab: discover");
                break;
            case 3:
                if (!LoginUtil.IsLogin(this)) {
                    Log.d("MainActivity", "onCreateView: needLogin");
                    Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
                Log.d("MainActivity", "onCreateView: No needLogin");
                mImgMyInfo.setImageResource(R.mipmap.myinfo_tab_pressed);
                Log.d(TAG, "selectTab: myinfo");
                break;
        }
        mViewPager.setCurrentItem(i);
    }

}
