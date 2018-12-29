package com.example.sumsang_rookie.mytab;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sumsang_rookie.mytab.temp.MyFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyInfoFragment extends MyFragment implements SwipeRefreshLayout.OnRefreshListener{
    private final String TAG = "MainActivity";
    SwipeRefreshLayout mRefresh;

    @Override
    public void onRefresh() {

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    private Handler mHandler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(Message msg) {
            mRefresh.setRefreshing(false);
        }
    };


    @Override
    protected void onFragmentVisibleChange(boolean isVisible) {
        Log.i(TAG, "onFragmentVisibleChange isVisible:" + isVisible);
    }

    @Override
    protected void onFragmentFirstVisible() {
        Log.i(TAG, "onFragmentFirstVisible");
        mRefresh.setRefreshing(true);

        new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    mHandler.sendEmptyMessage(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        MainActivity mActivity = (MainActivity) getActivity();
        Log.d(TAG, "onCreateView: MyInfoFragment");
        setUserVisibleHint(false);
        if (!LoginUtil.IsLogin(mActivity)) {
            Log.d("MainActivity", "onCreateView: needLogin");
            Intent intent = new Intent(mActivity, LoginActivity.class);
            startActivity(intent);
        }
        Log.d("MainActivity", "onCreateView: No needLogin");
        View view = inflater.inflate(R.layout.tab4, container, false);
        return view;
    }
}
