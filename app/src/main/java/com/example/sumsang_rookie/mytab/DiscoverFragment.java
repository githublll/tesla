package com.example.sumsang_rookie.mytab;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sumsang_rookie.mytab.temp.MyFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class DiscoverFragment extends MyFragment {


    private static final String TAG = "MainActivity";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab3,container,false);
        Log.d(TAG, "onCreateView: DiscoverFragment");
        return view;
    }

}
