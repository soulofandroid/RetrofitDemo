package com.retrofitdemo;

import com.retrofitdemo.activity.BaseActivity;
import com.retrofitdemo.bean.BannerBean;
import com.retrofitdemo.net.util.ProgressSubscriber;
import com.retrofitdemo.util.Constant;

import static com.retrofitdemo.util.Constant.BANNER_HOME;

public class MainActivity extends BaseActivity {

    @Override
    public int getContentResId() {
        return R.layout.activity_main;
    }

    @Override
    public void init() {
         mHttpUtil.getBanner(new ProgressSubscriber<BannerBean>(mContext) {
             @Override
             public void next(BannerBean result) {
                 String code=result.getCode();
                if(code.equals(Constant.SUCCESS)){
                    //接口数据请求成功
                }
             }
         },BANNER_HOME);
    }
}
