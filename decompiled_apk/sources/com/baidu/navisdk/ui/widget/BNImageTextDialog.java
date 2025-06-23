package com.baidu.navisdk.ui.widget;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.util.b;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes8.dex */
public class BNImageTextDialog extends Dialog implements DialogInterface.OnDismissListener {
    private boolean isSupportDayNight;
    private final Activity mActivity;
    private int mAutoHideTime;
    private LinearLayout mContentLayout;
    private TextView mFirstBtn;
    private boolean mFirstHasText;
    private Runnable mHideRunnable;
    private TextView mMessage;
    private OnNaviClickListener mOnFirstBtnClickListener;
    private OnNaviClickListener mOnSecondBtnClickListener;
    private View mPlaceView;
    private TextView mSecondBtn;
    private boolean mSecondHasText;
    private TextView mTitleBar;
    private ImageView mTopImageView;

    /* loaded from: classes8.dex */
    public interface OnNaviClickListener {
        void onClick();
    }

    public BNImageTextDialog(Activity activity) {
        super(activity, R.style.BNDialog);
        this.isSupportDayNight = false;
        this.mAutoHideTime = 0;
        this.mHideRunnable = new Runnable() { // from class: com.baidu.navisdk.ui.widget.BNImageTextDialog.3
            @Override // java.lang.Runnable
            public void run() {
                if (BNImageTextDialog.this.isShowing()) {
                    try {
                        BNImageTextDialog.this.dismiss();
                    } catch (Exception e) {
                        if (LogUtil.LOGGABLE) {
                            LogUtil.printException("BNImageTextDialog-dismiss", e);
                        }
                    }
                }
            }
        };
        this.mActivity = activity;
        View inflate = JarUtils.inflate(activity, R.layout.nsdk_layout_image_text_dialog, null);
        try {
            setContentView(inflate);
            this.mContentLayout = (LinearLayout) inflate.findViewById(R.id.it_dialog_content);
            this.mTopImageView = (ImageView) inflate.findViewById(R.id.it_dialog_imageview);
            this.mTitleBar = (TextView) inflate.findViewById(R.id.it_dialog_title);
            this.mMessage = (TextView) inflate.findViewById(R.id.it_dialog_content_message);
            this.mFirstBtn = (TextView) inflate.findViewById(R.id.first_btn);
            this.mSecondBtn = (TextView) inflate.findViewById(R.id.second_btn);
            this.mPlaceView = inflate.findViewById(R.id.place_view);
            this.mFirstBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.navisdk.ui.widget.BNImageTextDialog.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BNImageTextDialog.this.mOnFirstBtnClickListener != null) {
                        BNImageTextDialog.this.mOnFirstBtnClickListener.onClick();
                    }
                    BNImageTextDialog.this.dismiss();
                }
            });
            this.mSecondBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.navisdk.ui.widget.BNImageTextDialog.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BNImageTextDialog.this.mOnSecondBtnClickListener != null) {
                        BNImageTextDialog.this.mOnSecondBtnClickListener.onClick();
                    }
                    try {
                        BNImageTextDialog.this.dismiss();
                    } catch (Exception e) {
                        if (LogUtil.LOGGABLE) {
                            LogUtil.printException("RoutePlan", e);
                        }
                    }
                }
            });
            this.mFirstHasText = false;
            this.mSecondHasText = false;
            this.mTitleBar.setVisibility(8);
            this.mMessage.setVisibility(8);
            this.mFirstBtn.setVisibility(8);
            this.mSecondBtn.setVisibility(8);
            setCanceledOnTouchOutside(false);
            setOnDismissListener(this);
        } catch (Throwable unused) {
        }
    }

    private void runAutoHide() {
        LinearLayout linearLayout = this.mContentLayout;
        if (linearLayout != null) {
            linearLayout.postDelayed(this.mHideRunnable, this.mAutoHideTime);
        }
    }

    private void setBtnVisible() {
        boolean z = this.mFirstHasText;
        if (!z && !this.mSecondHasText) {
            this.mFirstBtn.setVisibility(8);
            this.mSecondBtn.setVisibility(8);
            this.mPlaceView.setVisibility(8);
            return;
        }
        boolean z2 = this.mSecondHasText;
        if (!z2 && z) {
            this.mFirstBtn.setVisibility(0);
            this.mSecondBtn.setVisibility(8);
            this.mPlaceView.setVisibility(8);
            this.mFirstBtn.setBackgroundDrawable(b.f(R.drawable.bnav_image_text_dialog_button_selector));
            return;
        }
        if (!z && z2) {
            this.mFirstBtn.setVisibility(8);
            this.mSecondBtn.setVisibility(0);
            this.mPlaceView.setVisibility(8);
            this.mSecondBtn.setBackgroundDrawable(b.f(R.drawable.bnav_image_text_dialog_button_selector));
            return;
        }
        if (z && z2) {
            this.mFirstBtn.setVisibility(0);
            this.mSecondBtn.setVisibility(0);
            this.mPlaceView.setVisibility(0);
            TextView textView = this.mFirstBtn;
            int i = R.drawable.bnav_image_text_dialog_button_selector;
            textView.setBackgroundDrawable(b.f(i));
            this.mSecondBtn.setBackgroundDrawable(b.f(i));
        }
    }

    private void updateDayStyle() {
        TextView textView = this.mTitleBar;
        Resources resources = JarUtils.getResources();
        int i = R.color.nsdk_cl_text_a;
        textView.setTextColor(resources.getColor(i));
        this.mMessage.setTextColor(JarUtils.getResources().getColor(i));
        TextView textView2 = this.mFirstBtn;
        Resources resources2 = JarUtils.getResources();
        int i2 = R.color.nsdk_color_image_text_dialog_btn_selector;
        textView2.setTextColor(resources2.getColorStateList(i2));
        this.mSecondBtn.setTextColor(JarUtils.getResources().getColorStateList(i2));
        TextView textView3 = this.mFirstBtn;
        Resources resources3 = JarUtils.getResources();
        int i3 = R.drawable.bnav_image_text_dialog_button_selector;
        textView3.setBackgroundDrawable(resources3.getDrawable(i3));
        this.mSecondBtn.setBackgroundDrawable(JarUtils.getResources().getDrawable(i3));
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        this.mFirstHasText = false;
        this.mSecondHasText = false;
        LinearLayout linearLayout = this.mContentLayout;
        if (linearLayout != null) {
            linearLayout.removeCallbacks(this.mHideRunnable);
        }
        super.dismiss();
    }

    public BNImageTextDialog enableBackKey(boolean z) {
        super.setCancelable(z);
        return this;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        LinearLayout linearLayout = this.mContentLayout;
        if (linearLayout != null) {
            linearLayout.removeCallbacks(this.mHideRunnable);
        }
    }

    public BNImageTextDialog setAutoHideTime(int i) {
        this.mAutoHideTime = i;
        return this;
    }

    public BNImageTextDialog setBottomImageDrawable(Drawable drawable) {
        this.mContentLayout.setBackgroundDrawable(drawable);
        return this;
    }

    public BNImageTextDialog setContentMessage(String str) {
        if (str == null) {
            this.mMessage.setVisibility(8);
            this.mMessage.setText("", TextView.BufferType.SPANNABLE);
        } else {
            this.mMessage.setVisibility(0);
            this.mMessage.setText(str, TextView.BufferType.SPANNABLE);
        }
        return this;
    }

    public BNImageTextDialog setFirstBtnText(String str) {
        if (str == null) {
            this.mFirstHasText = false;
            this.mFirstBtn.setText("", TextView.BufferType.SPANNABLE);
        } else {
            this.mFirstHasText = true;
            this.mFirstBtn.setText(str, TextView.BufferType.SPANNABLE);
        }
        setBtnVisible();
        return this;
    }

    public BNImageTextDialog setMessageColor(int i) {
        TextView textView = this.mMessage;
        if (textView != null) {
            textView.setTextColor(i);
        }
        return this;
    }

    public BNImageTextDialog setMessageTextSize(int i) {
        TextView textView = this.mMessage;
        if (textView != null) {
            textView.setTextSize(i, 1.0f);
        }
        return this;
    }

    public BNImageTextDialog setOnFirstBtnClickListener(OnNaviClickListener onNaviClickListener) {
        this.mOnFirstBtnClickListener = onNaviClickListener;
        return this;
    }

    public BNImageTextDialog setOnSecondBtnClickListener(OnNaviClickListener onNaviClickListener) {
        this.mOnSecondBtnClickListener = onNaviClickListener;
        return this;
    }

    public BNImageTextDialog setSecondBtnChecked() {
        this.mSecondBtn.setSelected(true);
        return this;
    }

    public BNImageTextDialog setSecondBtnText(String str) {
        if (str == null) {
            this.mSecondHasText = false;
            this.mSecondBtn.setText("", TextView.BufferType.SPANNABLE);
        } else {
            this.mSecondHasText = true;
            this.mSecondBtn.setText(str, TextView.BufferType.SPANNABLE);
        }
        setBtnVisible();
        return this;
    }

    public BNImageTextDialog setTitleText(String str) {
        if (str == null) {
            this.mTitleBar.setVisibility(8);
            this.mTitleBar.setText("", TextView.BufferType.SPANNABLE);
        } else {
            this.mTitleBar.setVisibility(0);
            this.mTitleBar.setText(str, TextView.BufferType.SPANNABLE);
        }
        return this;
    }

    public BNImageTextDialog setTitleTextStyle(boolean z) {
        TextView textView = this.mTitleBar;
        if (textView != null) {
            if (z) {
                textView.setTypeface(Typeface.defaultFromStyle(1));
            } else {
                textView.setTypeface(Typeface.defaultFromStyle(0));
            }
        }
        return this;
    }

    public BNImageTextDialog setTopImageDrawable(Drawable drawable) {
        this.mTopImageView.setVisibility(0);
        this.mTopImageView.setImageDrawable(drawable);
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
        if (this.isSupportDayNight) {
            updateStyle();
        } else {
            updateDayStyle();
        }
        super.show();
        if (this.mAutoHideTime > 0) {
            runAutoHide();
        }
    }

    public void updateStyle() {
        this.isSupportDayNight = true;
        TextView textView = this.mTitleBar;
        int i = R.color.nsdk_color_dialog_content_text;
        textView.setTextColor(b.b(i));
        this.mMessage.setTextColor(b.b(i));
        TextView textView2 = this.mFirstBtn;
        Resources resources = JarUtils.getResources();
        int i2 = R.color.nsdk_color_image_text_dialog_btn_selector;
        textView2.setTextColor(resources.getColorStateList(i2));
        this.mSecondBtn.setTextColor(JarUtils.getResources().getColorStateList(i2));
        TextView textView3 = this.mFirstBtn;
        int i3 = R.drawable.bnav_image_text_dialog_button_selector;
        textView3.setBackgroundDrawable(b.f(i3));
        this.mSecondBtn.setBackgroundDrawable(b.f(i3));
    }

    public BNImageTextDialog setFirstBtnText(boolean z, String str) {
        if (str == null) {
            this.mFirstHasText = false;
            this.mFirstBtn.setText("", TextView.BufferType.SPANNABLE);
        } else {
            this.mFirstHasText = true;
            this.mFirstBtn.setText(str, TextView.BufferType.SPANNABLE);
        }
        setBtnVisible(z);
        return this;
    }

    public BNImageTextDialog setSecondBtnText(boolean z, String str) {
        if (str == null) {
            this.mSecondHasText = false;
            this.mSecondBtn.setText("", TextView.BufferType.SPANNABLE);
        } else {
            this.mSecondHasText = true;
            this.mSecondBtn.setText(str, TextView.BufferType.SPANNABLE);
        }
        setBtnVisible(z);
        return this;
    }

    private void setBtnVisible(boolean z) {
        boolean z2 = this.mFirstHasText;
        if (!z2 && !this.mSecondHasText) {
            this.mFirstBtn.setVisibility(8);
            this.mSecondBtn.setVisibility(8);
            return;
        }
        boolean z3 = this.mSecondHasText;
        if (!z3 && z2) {
            this.mFirstBtn.setVisibility(0);
            this.mSecondBtn.setVisibility(8);
            this.mFirstBtn.setBackgroundDrawable(b.c(R.drawable.bnav_image_text_dialog_button_selector, z));
            return;
        }
        if (!z2 && z3) {
            this.mFirstBtn.setVisibility(8);
            this.mSecondBtn.setVisibility(0);
            this.mSecondBtn.setBackgroundDrawable(b.c(R.drawable.bnav_image_text_dialog_button_selector, z));
        } else if (z2 && z3) {
            this.mFirstBtn.setVisibility(0);
            this.mSecondBtn.setVisibility(0);
            TextView textView = this.mFirstBtn;
            int i = R.drawable.bnav_image_text_dialog_button_selector;
            textView.setBackgroundDrawable(b.c(i, z));
            this.mSecondBtn.setBackgroundDrawable(b.c(i, z));
        }
    }
}
