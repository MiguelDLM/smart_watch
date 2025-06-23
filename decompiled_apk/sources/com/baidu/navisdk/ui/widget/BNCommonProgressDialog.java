package com.baidu.navisdk.ui.widget;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes8.dex */
public class BNCommonProgressDialog extends Dialog {
    private final Activity mActivity;
    protected ImageView mCloseIV;
    protected TextView mLoadingTipTV;
    protected DialogInterface.OnCancelListener mOnCancelListener;

    public BNCommonProgressDialog(Activity activity) {
        super(activity, R.style.theme_comm_progressdlg);
        View view = null;
        this.mOnCancelListener = null;
        this.mActivity = activity;
        Window window = getWindow();
        requestWindowFeature(1);
        window.setBackgroundDrawableResource(android.R.color.transparent);
        window.getAttributes().gravity = 17;
        try {
            view = JarUtils.inflate(activity, R.layout.nsdk_layout_common_progress_dialog_animation, null);
        } catch (Exception unused) {
        }
        if (view == null) {
            return;
        }
        setContentView(view);
        setCanceledOnTouchOutside(false);
        setCancelable(true);
        getWindow().getAttributes().gravity = 17;
        this.mLoadingTipTV = (TextView) findViewById(R.id.progress_tip_text);
        this.mCloseIV = (ImageView) findViewById(R.id.iv_dialog_close);
        setCloseIVListener();
    }

    public void setCloseGone() {
        this.mCloseIV.setVisibility(8);
    }

    public void setCloseIVListener() {
        this.mCloseIV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.navisdk.ui.widget.BNCommonProgressDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BNCommonProgressDialog bNCommonProgressDialog = BNCommonProgressDialog.this;
                DialogInterface.OnCancelListener onCancelListener = bNCommonProgressDialog.mOnCancelListener;
                if (onCancelListener != null) {
                    onCancelListener.onCancel(bNCommonProgressDialog);
                }
                BNCommonProgressDialog.this.dismiss();
            }
        });
    }

    public void setCloseVisible() {
        this.mCloseIV.setVisibility(0);
    }

    public BNCommonProgressDialog setDimAmount(float f) {
        getWindow().setDimAmount(0.0f);
        return this;
    }

    public BNCommonProgressDialog setMessage(String str) {
        this.mLoadingTipTV.setText(str);
        return this;
    }

    @Override // android.app.Dialog
    public void setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
        this.mOnCancelListener = onCancelListener;
        super.setOnCancelListener(onCancelListener);
    }

    public BNCommonProgressDialog setYawingStyleGrivity(boolean z) {
        if (z) {
            getWindow().getAttributes().gravity = 51;
        } else {
            getWindow().getAttributes().gravity = 17;
        }
        return this;
    }

    @Override // android.app.Dialog
    public void show() {
        boolean isInPictureInPictureMode;
        if (Build.VERSION.SDK_INT >= 26) {
            isInPictureInPictureMode = this.mActivity.isInPictureInPictureMode();
            if (isInPictureInPictureMode) {
                g gVar = g.ROUTE_GUIDE;
                if (gVar.a()) {
                    gVar.a("in pip mode, not show");
                    return;
                }
                return;
            }
        }
        super.show();
    }
}
