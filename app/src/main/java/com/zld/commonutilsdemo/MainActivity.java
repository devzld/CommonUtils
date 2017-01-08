package com.zld.commonutilsdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.zld.commonutils.Logger;
import com.zld.commonutils.PreferenceUtils;
import com.zld.commonutils.ToastUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Logger.e("这是测试log");

        PreferenceUtils.putString(this,"ok","你好..");

        String msg = PreferenceUtils.getString(this,"ok","默认值");
        ToastUtils.showLong(msg);

    }
}
