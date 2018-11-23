package com.retrofitdemo.net.util;

import com.retrofitdemo.App;
import com.retrofitdemo.net.ApiService;
import com.retrofitdemo.net.cookies.BaseInterceptor;
import com.retrofitdemo.net.cookies.CookieManger;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * <p>作者   wurui</p>
 * <p>时间   2018/11/23 0023</p>
 * <p>包名   com.retrofitdemo.util</p>
 * <p>描述   TODO</p>
 */
public class RetrofitUtil {

    private static final int DEFAULT_TIMEOUT = 5;
    private ApiService apiService;
    private static RetrofitUtil instance;

    private RetrofitUtil() {
        Map<String, String> map = new HashMap<>();
        map.put("Content-type", "application/json; charset=utf-8");
        OkHttpClient.Builder client = new OkHttpClient.Builder()
                .addNetworkInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.HEADERS))
                .cookieJar(new CookieManger(App.getAppContext()))
                .addInterceptor(new BaseInterceptor(map))
                .retryOnConnectionFailure(true)
                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        Retrofit retrofit = new Retrofit.Builder()
                .client(client.build())
                .baseUrl(ApiService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        apiService = retrofit.create(ApiService.class);
    }

    public ApiService getApiService() {
        return apiService;
    }

    public static RetrofitUtil getInstance() {
        if (instance == null) {
            synchronized (RetrofitUtil.class) {
                instance = new RetrofitUtil();
            }
        }
        return instance;
    }
}
