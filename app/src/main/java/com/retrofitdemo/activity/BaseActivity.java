package com.retrofitdemo.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.retrofitdemo.net.HttpUtil;

/**
 * <p>作者   wurui</p>
 * <p>时间   2018/11/23 0023</p>
 * <p>包名   com.retrofitdemo.activity</p>
 * <p>描述  基类</p>
 */
public abstract class BaseActivity extends AppCompatActivity {
    protected Context mContext;
    protected Activity mActivity;
    protected HttpUtil mHttpUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getContentResId() != 0) {
            setContentView(getContentResId());
        }
        mContext = this;
        mActivity=this;
        mHttpUtil = HttpUtil.getInstance();
        init();
    }

    public abstract int getContentResId();

    public abstract void init();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mContext = null;
        mActivity=null;
    }
}
