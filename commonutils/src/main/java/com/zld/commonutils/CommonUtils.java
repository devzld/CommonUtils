package com.zld.commonutils;

import android.content.Context;

/**
 * Created by lingdong on 2017/1/8.
 *
 * 一次性初始化类
 *
 */

public class CommonUtils {

    private static CommonUtils mCommonUtils;

    private CommonUtils(){

    }

    public static CommonUtils getInstance(){
        if(mCommonUtils == null)
            mCommonUtils = new CommonUtils();
        return mCommonUtils;
    }

    public  CommonUtils initLogger(boolean isDebugMode,String defaultTag){
        Logger.init(isDebugMode,defaultTag);
        return mCommonUtils;
    }

    public  CommonUtils initToast(Context context){
        ToastUtils.init(context);
        return mCommonUtils;
    }

    public  CommonUtils initPreference(String preferenceName){
        PreferenceUtils.init(preferenceName);
        return mCommonUtils;
    }

}
