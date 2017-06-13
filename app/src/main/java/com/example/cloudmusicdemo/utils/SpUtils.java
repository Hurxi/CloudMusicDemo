package com.example.cloudmusicdemo.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * SharedPreferences 工具类
 * 调用该工具类可以很方便的存储
 * 1. Boolean
 * 2. String
 * 等类型的数据
 */

public class SpUtils {
    //配置文件的名字
    static String SP_NAME = "config";

    /**
     * 使用sp存储一个布尔类型的数据
     * @param context 上下文
     * @param value   值
     */
    public static void putBoolean(Context context, String key, boolean value) {
        SharedPreferences sp = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor et = sp.edit();
        et.putBoolean(key, value);
        et.commit();
    }

    /**
     * 获取布尔类型的数据
     * @param  key 取指定key的值
     * @return 取到的值, 默认值为true
     */
    public static boolean getBoolean(Context context, String key){
        SharedPreferences sp = context.getSharedPreferences(SP_NAME,Context.MODE_PRIVATE);
        boolean value = sp.getBoolean(key,true);
        return value;
    }


}
