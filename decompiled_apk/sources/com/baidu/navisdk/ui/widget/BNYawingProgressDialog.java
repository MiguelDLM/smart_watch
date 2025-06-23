package com.baidu.navisdk.ui.widget;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.util.b;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes8.dex */
public class BNYawingProgressDialog extends Dialog {
    private Activity mActivity;
    private Animation mAnim;
    private ImageView mCloseIV;
    private TextView mLoadingTipTV;
    private DialogInterface.OnCancelListener mOnCancelListener;
    private ImageView mProgress;

    public BNYawingProgressDialog(Activity activity) {
        super(activity, R.style.theme_comm_progressdlg);
        View view = null;
        this.mOnCancelListener = null;
        this.mActivity = activity;
        Window window = getWindow();
        requestWindowFeature(1);
        window.setBackgroundDrawableResource(android.R.color.transparent);
        window.getAttributes().gravity = 17;
        try {
            view = JarUtils.inflate(activity, R.layout.nsdk_layout_yawing_progress_dialog_animation, null);
        } catch (Exception e) {
            if (LogUtil.LOGGABLE) {
                LogUtil.printException("", e);
            }
        }
        if (view == null) {
            return;
        }
        setContentView(view);
        setCanceledOnTouchOutside(false);
        setCancelable(true);
        this.mLoadingTipTV = (TextView) findViewById(R.id.progress_tip_text);
        this.mCloseIV = (ImageView) findViewById(R.id.iv_dialog_close);
        this.mProgress = (ImageView) findViewById(R.id.progress_cycle_normal);
        this.mCloseIV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.navisdk.ui.widget.BNYawingProgressDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (BNYawingProgressDialog.this.mOnCancelListener != null) {
                    BNYawingProgressDialog.this.mOnCancelListener.onCancel(BNYawingProgressDialog.this);
                }
                BNYawingProgressDialog.this.dismiss();
            }
        });
    }

    public BNYawingProgressDialog setMessage(String str) {
        this.mLoadingTipTV.setText(str);
        return this;
    }

    @Override // android.app.Dialog
    public void setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
        this.mOnCancelListener = onCancelListener;
        super.setOnCancelListener(onCancelListener);
    }

    public void startProgressAnim() {
        this.mAnim = b.b(this.mActivity, R.anim.nsdk_anim_yawing_progress_wait);
        this.mAnim.setInterpolator(new LinearInterpolator());
        Animation animation = this.mAnim;
        if (animation != null) {
            this.mProgress.startAnimation(animation);
        }
    }
}
