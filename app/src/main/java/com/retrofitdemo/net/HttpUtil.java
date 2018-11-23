package com.retrofitdemo.net;

import com.retrofitdemo.bean.BannerBean;
import com.retrofitdemo.net.util.RetrofitUtil;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class HttpUtil {

    private static HttpUtil httpUtil = new HttpUtil();
    private ApiService apiService;

    private HttpUtil() {
        apiService = RetrofitUtil.getInstance().getApiService();
    }

    public static HttpUtil getInstance() {
        return httpUtil;
    }

    private <T> void toSubscribe(Subscriber<T> subscriber, Observable<T> observable) {
        observable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void getBanner(Subscriber<BannerBean> subscriber, int type) {
        toSubscribe(subscriber, apiService.getBanner(type));
    }
}