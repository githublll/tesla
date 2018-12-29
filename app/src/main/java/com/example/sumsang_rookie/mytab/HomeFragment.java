package com.example.sumsang_rookie.mytab;


import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.format.Time;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.sumsang_rookie.mytab.temp.MyFragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends MyFragment {
    private final String TAG = "MainActivity";

    private TextView carModel, driveState, updateTime, lockState, airconditionerLockState, temperatureIn, temperatureOut;
    private ImageView sunOrMoon;

    private LinearLayout energyConsumption;
    private int i = 0;
    private ProgressBar progressBar;
    private Handler handler = new Handler();

    private List<OperateItem> mOperateItemList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: HomeFragment");
        View view = inflater.inflate(R.layout.tab1, container, false);
        initView(view);
        initOperate(view);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.operate_view);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        OperateAdapter operateAdapter = new OperateAdapter(mOperateItemList);
        recyclerView.setAdapter(operateAdapter);
        //energyConsumption = (LinearLayout) view.findViewById(R.id.energy_consumption);
        //Todo add energyConsumption click event
        return view;
    }
//  初始化操作的图片和文本
    private void initOperate(View view) {
        OperateItem ControlKeyLock = new OperateItem("启动+解锁",R.drawable.control_key_lock);
        mOperateItemList.add(ControlKeyLock);
        OperateItem ControlUnlockCar = new OperateItem("一键解地锁",R.drawable.control_unlock_car);
        mOperateItemList.add(ControlUnlockCar);
        OperateItem ControlAirconditioner = new OperateItem("空调",R.drawable.control_airconditioner);
        mOperateItemList.add(ControlAirconditioner);
        OperateItem ControlWhistle = new OperateItem("鸣笛",R.drawable.control_whistle);
        mOperateItemList.add(ControlWhistle);
        OperateItem ControlAirconditionerTimer = new OperateItem("定时空调",R.drawable.control_airconditioner_timer);
        mOperateItemList.add(ControlAirconditionerTimer);
        OperateItem ControlMore = new OperateItem("更多",R.drawable.control_more);
        mOperateItemList.add(ControlMore);
    }
    private void initView(View view) {
        String lock = "关";
        sunOrMoon = (ImageView) view.findViewById(R.id.sun_moon);
        carModel = (TextView) view.findViewById(R.id.car_modex);
        driveState = (TextView) view.findViewById(R.id.drive_state);
        updateTime = (TextView) view.findViewById(R.id.update_time);
        lockState = (TextView) view.findViewById(R.id.lock_state);
        airconditionerLockState = (TextView) view.findViewById(R.id.aircondition_lock_state);
        temperatureIn = (TextView) view.findViewById(R.id.in_car);
        temperatureOut = (TextView) view.findViewById(R.id.out_car);
        creatTime();
        if (LoginUtil.IsLogin(getContext())) {
            carModel.setText("白龙马");
            driveState.setText("已停车");
            lockState.setText("已上锁");
            airconditionerLockState.setText("空调: " + lock);
            temperatureIn.setText("室内：23℃");
            temperatureOut.setText("室外：18℃");
        }
        updateTime.setText("更新于: " + "3s前");

        progressBar = view.findViewById(R.id.progressBar);
        handler.postDelayed(runnable, 100);
    }

    private void creatTime() {
        Time t = new Time();
        t.setToNow();
        int h = t.hour;
        if (h < 6 || h > 18) {
            sunOrMoon.setImageResource(R.mipmap.black_theme);
        } else {
            sunOrMoon.setImageResource(R.mipmap.white_theme);
        }
    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            i++;
            Random power = new Random();
            int mpower = power.nextInt(101);
            Log.d(TAG, "run: " + mpower);
            if (mpower == 100) {
                Log.d(TAG, "count: " + i);
                progressBar.setProgress(mpower);
                handler.removeCallbacks(this);
            }else {
                progressBar.setProgress(mpower);
                handler.postDelayed(this, 100);
            }
        }
    };
}
