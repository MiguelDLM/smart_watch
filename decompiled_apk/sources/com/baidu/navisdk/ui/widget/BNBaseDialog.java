package com.baidu.navisdk.ui.widget;

import android.app.Activity;
import android.app.Dialog;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.util.b;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes8.dex */
public class BNBaseDialog extends Dialog {
    protected boolean isSupportDayNight;
    private final Activity mActivity;
    private FrameLayout mContent;
    private TextView mFirstBtn;
    private boolean mFirstHasText;
    private OnNaviClickListener mOnFirstBtnClickListener;
    private OnNaviClickListener mOnSecondBtnClickListener;
    private TextView mSecondBtn;
    private boolean mSecondHasText;
    private TextView mTitleBar;
    private LinearLayout mTopContentLayout;

    /* loaded from: classes8.dex */
    public interface OnNaviClickListener {
        void onClick();
    }

    public BNBaseDialog(Activity activity) {
        super(activity, R.style.BNDialog);
        this.isSupportDayNight = false;
        this.mActivity = activity;
        View inflate = JarUtils.inflate(activity, R.layout.nsdk_layout_dialog, null);
        setContentView(inflate);
        this.mTopContentLayout = (LinearLayout) inflate.findViewById(R.id.top_content);
        this.mTitleBar = (TextView) inflate.findViewById(R.id.title_bar);
        this.mContent = (FrameLayout) inflate.findViewById(R.id.content);
        this.mFirstBtn = (TextView) inflate.findViewById(R.id.first_btn);
        this.mSecondBtn = (TextView) inflate.findViewById(R.id.second_btn);
        this.mFirstBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.navisdk.ui.widget.BNBaseDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (BNBaseDialog.this.mOnFirstBtnClickListener != null) {
                    BNBaseDialog.this.mOnFirstBtnClickListener.onClick();
                }
                BNBaseDialog.this.dismiss();
            }
        });
        this.mSecondBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.navisdk.ui.widget.BNBaseDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (BNBaseDialog.this.mOnSecondBtnClickListener != null) {
                    BNBaseDialog.this.mOnSecondBtnClickListener.onClick();
                }
                BNBaseDialog.this.dismiss();
            }
        });
        this.mFirstHasText = false;
        this.mSecondHasText = false;
        this.mTitleBar.setVisibility(8);
        this.mFirstBtn.setVisibility(8);
        this.mSecondBtn.setVisibility(8);
        setCanceledOnTouchOutside(false);
        updateDayStyle();
    }

    private void setBtnVisible() {
        boolean z = this.mFirstHasText;
        if (!z && !this.mSecondHasText) {
            this.mFirstBtn.setVisibility(8);
            this.mSecondBtn.setVisibility(8);
            return;
        }
        boolean z2 = this.mSecondHasText;
        if (!z2 && z) {
            this.mFirstBtn.setVisibility(0);
            this.mSecondBtn.setVisibility(8);
            this.mFirstBtn.setBackgroundDrawable(b.f(R.drawable.nsdk_common_dialog_chang));
        } else if (!z && z2) {
            this.mFirstBtn.setVisibility(8);
            this.mSecondBtn.setVisibility(0);
            this.mSecondBtn.setBackgroundDrawable(b.f(R.drawable.nsdk_common_dialog_chang));
        } else if (z && z2) {
            this.mFirstBtn.setVisibility(0);
            this.mSecondBtn.setVisibility(0);
            this.mFirstBtn.setBackgroundDrawable(b.f(R.drawable.nsdk_common_dialog_left));
            this.mSecondBtn.setBackgroundDrawable(b.f(R.drawable.nsdk_common_dialog_right));
        }
    }

    private void updateDayStyle() {
        this.mTopContentLayout.setBackground(b.c(R.drawable.nsdk_drawable_common_dialog_top, true));
        this.mTitleBar.setTextColor(JarUtils.getResources().getColor(R.color.nsdk_common_color_dialog_content_text));
        boolean z = this.mFirstHasText;
        if (z && this.mSecondHasText) {
            this.mFirstBtn.setBackground(b.c(R.drawable.nsdk_common_dialog_left, true));
            this.mSecondBtn.setBackground(b.c(R.drawable.nsdk_common_dialog_right, true));
        } else if (!z && this.mSecondHasText) {
            this.mSecondBtn.setBackground(b.c(R.drawable.nsdk_common_dialog_chang, true));
        } else if (!this.mSecondHasText && z) {
            this.mFirstBtn.setBackground(b.c(R.drawable.nsdk_common_dialog_chang, true));
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        try {
            super.dismiss();
        } catch (Exception unused) {
        }
    }

    public BNBaseDialog enableBackKey(boolean z) {
        super.setCancelable(z);
        return this;
    }

    public BNBaseDialog setContent(View view) {
        FrameLayout frameLayout = this.mContent;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
            this.mContent.addView(view);
        }
        return this;
    }

    public BNBaseDialog setContentHeight(int i) {
        ViewGroup.LayoutParams layoutParams = this.mContent.getLayoutParams();
        layoutParams.height = i;
        this.mContent.setLayoutParams(layoutParams);
        return this;
    }

    public BNBaseDialog setContentWidth(int i) {
        ViewGroup.LayoutParams layoutParams = this.mContent.getLayoutParams();
        layoutParams.width = i;
        this.mContent.setLayoutParams(layoutParams);
        return this;
    }

    public BNBaseDialog setFirstBtnEnabled(boolean z) {
        this.mFirstBtn.setEnabled(z);
        return this;
    }

    public BNBaseDialog setFirstBtnText(String str) {
        if (str == null) {
            this.mFirstHasText = false;
            this.mFirstBtn.setText("", TextView.BufferType.SPANNABLE);
        } else {
            this.mFirstHasText = true;
            this.mFirstBtn.setText(str, TextView.BufferType.SPANNABLE);
        }
        setBtnVisible();
        this.mFirstBtn.setTextColor(b.b(R.color.nsdk_common_color_dialog_other_btn_text));
        return this;
    }

    public BNBaseDialog setFirstBtnTextColor(int i) {
        this.mFirstBtn.setTextColor(i);
        return this;
    }

    public BNBaseDialog setOnFirstBtnClickListener(OnNaviClickListener onNaviClickListener) {
        this.mOnFirstBtnClickListener = onNaviClickListener;
        return this;
    }

    public BNBaseDialog setOnSecondBtnClickListener(OnNaviClickListener onNaviClickListener) {
        this.mOnSecondBtnClickListener = onNaviClickListener;
        return this;
    }

    public BNBaseDialog setSecondBtnEnabled(boolean z) {
        this.mSecondBtn.setEnabled(z);
        return this;
    }

    public BNBaseDialog setSecondBtnText(String str) {
        if (str == null) {
            this.mSecondHasText = false;
            this.mSecondBtn.setText("", TextView.BufferType.SPANNABLE);
        } else {
            this.mSecondHasText = true;
            this.mSecondBtn.setText(str, TextView.BufferType.SPANNABLE);
        }
        setBtnVisible();
        this.mSecondBtn.setTextColor(b.b(R.color.nsdk_common_color_dialog_other_btn_text));
        return this;
    }

    public BNBaseDialog setSecondBtnTextColor(int i) {
        this.mSecondBtn.setTextColor(i);
        return this;
    }

    public BNBaseDialog setTitleText(String str) {
        if (str == null) {
            this.mTitleBar.setVisibility(8);
            this.mTitleBar.setText("", TextView.BufferType.SPANNABLE);
        } else {
            this.mTitleBar.setVisibility(0);
            this.mTitleBar.setText(str, TextView.BufferType.SPANNABLE);
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
        if (this.isSupportDayNight) {
            updateStyle();
        } else {
            updateDayStyle();
        }
        try {
            super.show();
        } catch (Exception unused) {
        }
    }

    public void updateStyle() {
        this.isSupportDayNight = true;
        this.mTopContentLayout.setBackground(b.f(R.drawable.nsdk_drawable_common_dialog_top));
        this.mTitleBar.setTextColor(b.b(R.color.nsdk_common_color_dialog_content_text));
        boolean z = this.mFirstHasText;
        if (z && this.mSecondHasText) {
            this.mFirstBtn.setBackground(b.f(R.drawable.nsdk_common_dialog_left));
            this.mSecondBtn.setBackground(b.f(R.drawable.nsdk_common_dialog_right));
        } else if (!z && this.mSecondHasText) {
            this.mSecondBtn.setBackground(b.f(R.drawable.nsdk_common_dialog_chang));
        } else if (!this.mSecondHasText && z) {
            this.mFirstBtn.setBackground(b.f(R.drawable.nsdk_common_dialog_chang));
        }
    }
}
