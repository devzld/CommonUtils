package com.zld.commonutils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by lingdong on 2017/1/8.
 */

public class ToastUtils {

    public static Context mContext;

    private ToastUtils(){
    }

    protected static void init(Context context){
        mContext = context.getApplicationContext();
    }

    private static void checkInit(){
        if(mContext == null){
            throw new NullPointerException(
                    "你必须在application中调用CommonUtils的方法进行初始化");
        }
    }

    public static void showShort(int resId) {
        checkInit();
        Toast.makeText(mContext, resId, Toast.LENGTH_SHORT).show();
    }


    public static void showShort(String message) {
        checkInit();
        Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
    }


    public static void showLong(int resId) {
        checkInit();
        Toast.makeText(mContext, resId, Toast.LENGTH_LONG).show();
    }


    public static void showLong(String message) {
        checkInit();
        Toast.makeText(mContext, message, Toast.LENGTH_LONG).show();
    }


    public static void showLongX2(String message) {
        showLong(message);
        showLong(message);
    }


    public static void showLongX2(int resId) {
        showLong(resId);
        showLong(resId);
    }


    public static void showLongX3(int resId) {
        showLong(resId);
        showLong(resId);
        showLong(resId);
    }


    public static void showLongX3(String message) {
        showLong(message);
        showLong(message);
        showLong(message);
    }


}
