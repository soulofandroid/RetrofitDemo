package com.retrofitdemo.net.util;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import com.retrofitdemo.R;


public class ProgressDialog extends Handler {

    public static final int SHOW_PROGRESS_DIALOG = 1;
    public static final int DISMISS_PROGRESS_DIALOG = 2;

    private Dialog pd;

    private Context context;
    private boolean cancelable;
    private ProgressCancel cancel;

    public ProgressDialog(Context context, ProgressCancel cancel, boolean cancelable) {
        super();
        this.context = context;
        this.cancel = cancel;
        this.cancelable = cancelable;
    }

    private void initProgressDialog() {
        if (pd == null) {
            pd = new Dialog(context,R.style.progress_dialog);
            pd.setContentView(R.layout.progress_dialog);
            TextView dialogMsg = (TextView) pd.findViewById(R.id.dialog_msg);
            dialogMsg.setText("正在加载");

            pd.setCancelable(cancelable);

            if (cancelable) {
                pd.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialogInterface) {
                        cancel.onCancel();
                    }
                });
            }

            if (pd!=null&&!pd.isShowing()) {
                pd.show();
            }
        }
    }

    private void dismissProgressDialog() {
        if (pd != null && pd.isShowing()) {
            pd.dismiss();
            pd = null;
        }
    }

    @Override
    public void handleMessage(Message msg) {
        switch (msg.what) {
            case SHOW_PROGRESS_DIALOG:
                initProgressDialog();
                break;
            case DISMISS_PROGRESS_DIALOG:
                dismissProgressDialog();
                break;
        }
    }
}
