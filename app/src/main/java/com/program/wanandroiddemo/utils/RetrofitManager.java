package com.program.wanandroiddemo.utils;

import com.program.wanandroiddemo.model.Api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitManager {

    private Api mApi;
    private static RetrofitManager sApiManager;

    public static RetrofitManager getInstence() {
        if (sApiManager == null) {
            synchronized (RetrofitManager.class) {
                if (sApiManager == null) {
                    sApiManager = new RetrofitManager();
                }
            }
        }
        return sApiManager;
    }

    public Api getApi() {
        if (mApi == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            mApi =  retrofit.create(Api.class);
        }
        return mApi;
    }

//    private static final RetrofitManager outInstance = new RetrofitManager();
//    private Retrofit mRetrofit;
//
//    public static RetrofitManager getInstance(){
//
//        return outInstance;
//    }
//
//    private RetrofitManager(){
//        LogUtils.d("DEBUG","RetrofitManager");
//            mRetrofit = new Retrofit.Builder()
//                    .baseUrl(Constants.BASE_URL)
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .build();
//        LogUtils.d("DEBUG","new Retrofit");
//
//
//    }
//
//    public Retrofit getRetrofit(){
//        return mRetrofit;
//    }

}
