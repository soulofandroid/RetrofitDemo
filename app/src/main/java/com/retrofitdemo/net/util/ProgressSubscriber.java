package com.retrofitdemo.net.util;

import android.content.Context;
import android.util.Log;

import com.retrofitdemo.util.ToastUtil;
import com.retrofitdemo.widget.IRecyclerSwipe;

import java.net.ConnectException;
import java.net.SocketTimeoutException;

import rx.Subscriber;

public abstract class ProgressSubscriber<T> extends Subscriber<T> implements ProgressCancel {

    private Context context;
    private ProgressDialog handler;
    private IRecyclerSwipe iRecyclerSwipe;
    private boolean isHaveProgressBar=false;

    public ProgressSubscriber(Context context) {
        this.context = context;
        isHaveProgressBar=true;
        if(isHaveProgressBar){
            handler = new ProgressDialog(context, this, true);
        }
    }

    /**
     * 是否有进度条
     * @param context
     * @param isHasProgress
     */
    public ProgressSubscriber(Context context,Boolean isHasProgress) {
        this.context = context;
        this.isHaveProgressBar=isHasProgress;
        if(isHaveProgressBar){
            handler = new ProgressDialog(context, this, true);
        }
    }


    public ProgressSubscriber(Context context, IRecyclerSwipe iRecyclerSwipe) {
        this.context = context;
        this.iRecyclerSwipe = iRecyclerSwipe;
        isHaveProgressBar=true;
        handler = new ProgressDialog(context, this,isHaveProgressBar);

    }

    public ProgressSubscriber(Context context, IRecyclerSwipe iRecyclerSwipe,boolean isTrue) {
        this.context = context;
        this.iRecyclerSwipe = iRecyclerSwipe;
        isHaveProgressBar=isTrue;
        handler = new ProgressDialog(context,this,isHaveProgressBar);
    }

    private void showProgressDialog() {
        if(isHaveProgressBar){
            if (handler != null) {
                handler.obtainMessage(ProgressDialog.SHOW_PROGRESS_DIALOG).sendToTarget();
            }
        }
    }

    private void dismissProgressDialog() {
        if(isHaveProgressBar){
            if (handler != null) {
                handler.obtainMessage(ProgressDialog.DISMISS_PROGRESS_DIALOG).sendToTarget();
                handler = null;
            }
        }
    }

    @Override
    public void onStart() {
        showProgressDialog();
        super.onStart();
    }

    @Override
    public void onCompleted() {
        if (iRecyclerSwipe != null) {
            iRecyclerSwipe.hideSwipeLoading();
        }
        dismissProgressDialog();
    }

    @Override
    public void onError(Throwable e) {
        if (iRecyclerSwipe != null) {
            iRecyclerSwipe.hideSwipeLoading();
//            iRecyclerSwipe.showItemFail(iRecyclerSwipe.getName() + " 列表数据获取失败！");
        }
        if (e instanceof SocketTimeoutException) {
            ToastUtil.show(context, "网络中断，网络连接超时！");
        } else if (e instanceof ConnectException) {
            ToastUtil.show(context, "网络中断，请检查您的网络状态！");
        } else {
//            ToastUtil.show(context, "error:" + e.getMessage());
            Log.d("MyInfo","exception:"+e.getMessage());
        }
        dismissProgressDialog();
    }

    @Override
    public void onNext(T t) {
        next(t);
        if (iRecyclerSwipe != null) {
            iRecyclerSwipe.hideSwipeLoading();
        }
    }

    @Override
    public void onCancel() {
        if (!this.isUnsubscribed()) {
            this.unsubscribe();
        }
    }

    public abstract void next(T t);
}
