package com.retrofitdemo.net;

import com.retrofitdemo.bean.BannerBean;
import com.retrofitdemo.bean.EditResultBean;

import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * <p>作者   wurui</p>
 * <p>时间   2018/11/23 0023</p>
 * <p>包名   com.retrofitdemo.net</p>
 * <p>描述   接口</p>
 */
public interface ApiService {

    String BASE_URL = "http://xx.xxx.xxx/api/";
    // 获取 banner轮播图
    @GET("conf/getBanner")// type 类型 判断摆放位置，1，APP首页banner   2 ，APP端专家banner   3，PC端网站首页banner 4 App邀请 banner
    Observable<BannerBean> getBanner(@Query("type") int type);
    //用户登出
    @POST("user/logout")
    Observable<EditResultBean> loginOut();
}
