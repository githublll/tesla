package com.example.sumsang_rookie.mytab;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import static android.content.Context.MODE_PRIVATE;

public class LoginUtil {
    public static Boolean IsLogin(Context context){
        SharedPreferences sp = context.getSharedPreferences("token",MODE_PRIVATE);
        String access_token = sp.getString("token", "needToken");
        if (access_token.equals("needToken")){
            Log.d("MainActivity", "IsLogin: no");
            return false;
        }else {
            return true;
        }
    }
}
