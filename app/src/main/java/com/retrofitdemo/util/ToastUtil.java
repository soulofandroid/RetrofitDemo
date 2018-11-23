package com.retrofitdemo.util;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.StringRes;
import android.text.TextUtils;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.retrofitdemo.R;


public final class ToastUtil {

    private static android.widget.Toast toast;
    private static Dialog progressDialog;
    private static ProgressBar dialogPb;
    private static TextView dialogMsg;

    /**
     * 普通弹窗
     */
    public static void show(Context context, String msg) {
        if (TextUtils.isEmpty(msg)) {
            if (toast != null) {
                toast.cancel();
            }
        } else {
            if (toast == null) {
                toast = android.widget.Toast.makeText(context.getApplicationContext(), msg, android.widget.Toast.LENGTH_SHORT);
            }
            toast.setText(msg);
            toast.show();
        }
    }

    public static void show(Context context, @StringRes int msg) {
        if (msg != 0) {
            if (toast != null) {
                toast.cancel();
            }
        } else {
            if (toast == null) {
                toast = android.widget.Toast.makeText(context.getApplicationContext(), msg, android.widget.Toast.LENGTH_SHORT);
            }
            toast.setText(msg);
            toast.show();
        }
    }

    /**
     * 加载中
     */
    public static void showProgressDialog(Context context) {
        baseProgressDialog(context, "正在加载...");
    }

    /**
     * base64转码中
     */
    public static void showConvertDialog(Context context) {
        baseProgressDialog(context, "正在加载...");
    }

    /**
     * 数据提交中
     */
    public static void showSubmitDialog(Context context) {
        baseProgressDialog(context, "正在提交...");
    }

    /**
     * 加载进度条
     */
    private static void baseProgressDialog(Context context, String msg) {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
            progressDialog = null;
        }
        try {
            progressDialog = new Dialog(context, R.style.progress_dialog);
            progressDialog.setContentView(R.layout.progress_dialog);
            dialogPb = (ProgressBar) progressDialog.findViewById(R.id.dialog_pb);
            dialogMsg = (TextView) progressDialog.findViewById(R.id.dialog_msg);
            dialogMsg.setText(msg);
            progressDialog.setCancelable(true);
            progressDialog.show();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    /**
     * 隐藏进度条
     */
    public static void dismissProgressDialog() {
        if (null != progressDialog && progressDialog.isShowing() == true) {
            progressDialog.dismiss();
            progressDialog = null;
        }
    }

}
