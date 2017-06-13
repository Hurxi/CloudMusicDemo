package com.example.cloudmusicdemo.utils;

import okhttp3.Request;

/**
 * 网络访问工具类
 */

public class HttpUtils {

    /**
     * 获取Builder，无需再设置请求头
     * @return
     */
    public static Request.Builder getBuilder() {
        Request.Builder builder = new Request.Builder()
                .addHeader("X-LC-Id", "kCFRDdr9tqej8FRLoqopkuXl-gzGzoHsz")
                .addHeader("X-LC-Key", "bmEeEjcgvKIq0FRaPl8jV2Um")
                .addHeader("Content-Type", "application/json");
        return builder;
    }

    /**
     * 获取一个GET请求
     * @param url 请求地址
     * @return Request
     */
    public static Request requestGET(String url){
        Request request = getBuilder().url(url).get().build();
        return request;
    }






}
