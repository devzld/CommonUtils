package com.zld.commonutils;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lingdong on 2017/1/8.
 *
 * SharePreference工具类
 *
 * 封装了String,int,long,float,boolean,ArrayList<String>的存取，删除
 *
 */

public class PreferenceUtils {

    private static String PREFERENCE_NAME = "";

    private PreferenceUtils(){

    }

    protected static void init(String preferenceName){
        if(PREFERENCE_NAME.isEmpty()) {
            PREFERENCE_NAME = preferenceName;
        }else {
            throw new PreferenceException("PreferenceUtils只需初始化一次");
        }
    }

    /****************分割线*************/

    public static boolean putString(Context context, String key, String value) {
        checkInit();
        SharedPreferences settings = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(key, value);
        return editor.commit();
    }

    public static String getString(Context context, String key) {
        return getString(context, key, null);
    }

    public static String getString(Context context, String key, String defaultValue) {
        checkInit();
        SharedPreferences settings = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
        return settings.getString(key, defaultValue);
    }

    /****************分割线*************/

    public static boolean putInt(Context context, String key, int value) {
        checkInit();
        SharedPreferences settings = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt(key, value);
        return editor.commit();
    }

    public static int getInt(Context context, String key) {
        return getInt(context, key, -1);
    }

    public static int getInt(Context context, String key, int defaultValue) {
        checkInit();
        SharedPreferences settings = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
        return settings.getInt(key, defaultValue);
    }

    /****************分割线*************/

    public static boolean putLong(Context context, String key, long value) {
        checkInit();
        SharedPreferences settings = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putLong(key, value);
        return editor.commit();
    }

    public static long getLong(Context context, String key) {
        return getLong(context, key, -1);
    }

    public static long getLong(Context context, String key, long defaultValue) {
        checkInit();
        SharedPreferences settings = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
        return settings.getLong(key, defaultValue);
    }

    /****************分割线*************/

    /**
     * put float preferences
     *
     */
    public static boolean putFloat(Context context, String key, float value) {
        checkInit();
        SharedPreferences settings = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putFloat(key, value);
        return editor.commit();
    }

    /**
     * get float preferences
     *
     */
    public static float getFloat(Context context, String key) {
        return getFloat(context, key, -1);
    }

    /**
     * get float preferences
     *
     */
    public static float getFloat(Context context, String key, float defaultValue) {
        checkInit();
        SharedPreferences settings = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
        return settings.getFloat(key, defaultValue);
    }

    /****************分割线*************/

    /**
     * put boolean preferences
     *
     */
    public static boolean putBoolean(Context context, String key, boolean value) {
        checkInit();
        SharedPreferences settings = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean(key, value);
        return editor.commit();
    }

    /**
     * get boolean preferences, default is false
     *
     */
    public static boolean getBoolean(Context context, String key) {
        return getBoolean(context, key, false);
    }

    /**
     * get boolean preferences
     *
     */
    public static boolean getBoolean(Context context, String key, boolean defaultValue) {
        checkInit();
        SharedPreferences settings = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
        return settings.getBoolean(key, defaultValue);
    }


    /****************分割线*************/

    /**
     * 存储List<String>
     *
     */
    public static void putStrListValue(Context context, String key,
                                       List<String> strList) {
        checkInit();
        if (null == strList) {
            return;
        }
        // 保存之前先清理已经存在的数据，保证数据的唯一性
        removeStrList(context, key);
        int size = strList.size();
        putInt(context, key + "size", size);
        for (int i = 0; i < size; i++) {
            putString(context, key + i, strList.get(i));
        }
    }

    /**
     * 取出List<String>
     *
     * @param context
     * @param key
     *            List<String> 对应的key
     * @return List<String>
     */
    public static List<String> getStrListValue(Context context, String key) {
        checkInit();
        List<String> strList = new ArrayList<>();
        int size = getInt(context, key + "size", 0);
        //Log.d("sp", "" + size);
        for (int i = 0; i < size; i++) {
            strList.add(getString(context, key + i, null));
        }
        return strList;
    }

    /**
     * 清空List<String>所有数据
     *
     * @param context
     * @param key
     *            List<String>对应的key
     */
    public static void removeStrList(Context context, String key) {
        checkInit();
        int size = getInt(context, key + "size", 0);
        if (0 == size) {
            return;
        }
        remove(context, key + "size");
        for (int i = 0; i < size; i++) {
            remove(context, key + i);
        }
    }

    /**
     * @Description TODO 清空List<String>单条数据
     * @param context
     * @param key
     *            List<String>对应的key
     * @param str
     *            List<String>中的元素String
     */
    public static void removeStrListItem(Context context, String key, String str) {
        checkInit();
        int size = getInt(context, key + "size", 0);
        if (0 == size) {
            return;
        }
        List<String> strList = getStrListValue(context, key);
        // 待删除的List<String>数据暂存
        List<String> removeList = new ArrayList<String>();
        for (int i = 0; i < size; i++) {
            if (str.equals(strList.get(i))) {
                if (i >= 0 && i < size) {
                    removeList.add(strList.get(i));
                    remove(context, key + i);
                    putInt(context, key + "size", size - 1);
                }
            }
        }
        strList.removeAll(removeList);
        // 删除元素重新建立索引写入数据
        putStrListValue(context, key, strList);
    }


    /**
     * 清空对应key数据
     *
     * @param context
     * @param key
     */
    public static boolean remove(Context context, String key) {
        checkInit();
        SharedPreferences.Editor sp = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)
                .edit();
        sp.remove(key);
        return sp.commit();
    }

    /**
     * 清空所有数据
     *
     * @param context
     */
    public static void clear(Context context) {
        checkInit();
        SharedPreferences.Editor sp = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)
                .edit();
        sp.clear();
        sp.commit();
    }

    /****************分割线*************/

    /**
     * 检查是否初始化
     */
    private static void checkInit(){
        if(PREFERENCE_NAME.isEmpty()){
            throw new PreferenceException("你必须在application中调用CommonUtils的方法进行初始化");
        }
    }

    private static class PreferenceException extends RuntimeException{

        public PreferenceException() {
            super();
        }

        public PreferenceException(String detailMessage) {
            super(detailMessage);
        }

        public PreferenceException(String detailMessage, Throwable throwable) {
            super(detailMessage, throwable);
        }

        public PreferenceException(Throwable throwable) {
            super(throwable);
        }
    }
}
