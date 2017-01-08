package com.zld.commonutilsdemo;

import android.app.Application;

import com.zld.commonutils.CommonUtils;

/**
 * Created by lingdong on 2017/1/8.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        /*注册方式一:统一注册*/
        CommonUtils.getInstance()
                .initLogger(true,"tag")
                .initPreference("commonutils")
                .initToast(this);
    }
}
