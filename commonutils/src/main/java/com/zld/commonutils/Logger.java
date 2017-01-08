package com.zld.commonutils;

import android.util.Log;

/**
 * Created by lingdong on 2017/1/8.
 *
 * 包含e,i,v,d,w的log输出类
 *
 * 用前在application里进行初始化
 *
 */

public class Logger {

    private static boolean isDebug = true;
    private static String TAG = "tag";
    private static boolean isFinishInit = false;

    private Logger(){

    }

    protected static void init(boolean isDebugMode,String defaultTag){
        if(isFinishInit){
            throw new LoggerException("你已经初始化过了，不必再初始化Logger");
        }
        isDebug = isDebugMode;
        TAG = defaultTag;
        isFinishInit = true;
    }

    private static void checkInit(){
        if(!isFinishInit){
            throw new LoggerException("你必须在application中调用CommonUtils的方法进行初始化");
        }
    }

    /************分割线************/
    public static void e(String msg){
        checkInit();
        if(isDebug){
            Log.e(TAG,msg);
        }
    }

    public static void e(String tag,String msg){
        checkInit();
        if(isDebug){
            Log.e(tag,msg);
        }
    }

    public static void e(String tag,String msg,Throwable throwable){
        checkInit();
        if(isDebug){
            Log.e(tag,msg,throwable);
        }
    }

    /************分割线************/

    public static void i(String msg){
        checkInit();
        if(isDebug){
            Log.i(TAG,msg);
        }
    }

    public static void i(String tag,String msg){
        checkInit();
        if(isDebug){
            Log.i(tag,msg);
        }
    }

    public static void i(String tag,String msg,Throwable throwable){
        checkInit();
        if(isDebug){
            Log.i(tag,msg,throwable);
        }
    }

    /************分割线************/

    public static void v(String msg){
        checkInit();
        if(isDebug){
            Log.v(TAG,msg);
        }
    }

    public static void v(String tag,String msg){
        checkInit();
        if(isDebug){
            Log.v(tag,msg);
        }
    }

    public static void v(String tag,String msg,Throwable throwable){
        checkInit();
        if(isDebug){
            Log.v(tag,msg,throwable);
        }
    }

    /************分割线************/

    public static void d(String msg){
        checkInit();
        if(isDebug){
            Log.d(TAG,msg);
        }
    }

    public static void d(String tag,String msg){
        checkInit();
        if(isDebug){
            Log.d(tag,msg);
        }
    }

    public static void d(String tag,String msg,Throwable throwable){
        checkInit();
        if(isDebug){
            Log.d(tag,msg,throwable);
        }
    }

    /************分割线************/

    public static void w(String msg){
        checkInit();
        if(isDebug){
            Log.w(TAG,msg);
        }
    }

    public static void w(String tag,String msg){
        checkInit();
        if(isDebug){
            Log.w(tag,msg);
        }
    }

    public static void w(String tag,String msg,Throwable throwable){
        checkInit();
        if(isDebug){
            Log.w(tag,msg,throwable);
        }
    }

    private static class LoggerException extends RuntimeException{
        public LoggerException() {
            super();
        }

        public LoggerException(String message) {
            super(message);
        }

        public LoggerException(String message, Throwable cause) {
            super(message, cause);
        }

        public LoggerException(Throwable cause) {
            super(cause);
        }

    }

}
