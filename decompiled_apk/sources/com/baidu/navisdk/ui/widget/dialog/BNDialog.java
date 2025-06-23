package com.baidu.navisdk.ui.widget.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.Resources;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.util.b;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes8.dex */
public class BNDialog extends Dialog {
    private boolean isFirstBtnHighLight;
    private boolean isSecondBtnHighLight;
    private boolean isSupportDayNight;
    private FrameLayout mContentList;
    private TextView mFirstBtn;
    private boolean mFirstHasText;
    private LinearLayout mLayoutContentList;
    private TextView mMessage;
    private OnNaviClickListener mOnFirstBtnClickListener;
    private OnNaviClickListener mOnSecondBtnClickListener;
    private TextView mSecondBtn;
    private boolean mSecondHasText;
    private TextView mTitleBar;
    private TextView mTitleBarList;
    private LinearLayout mTopContentLayout;

    /* loaded from: classes8.dex */
    public interface OnNaviClickListener {
        void onClick();
    }

    public BNDialog(Activity activity) {
        super(activity, R.style.BNDialog);
        this.isSupportDayNight = false;
        View inflate = JarUtils.inflate(activity, R.layout.nsdk_layout_common_dialog, null);
        try {
            setContentView(inflate);
            this.mTopContentLayout = (LinearLayout) inflate.findViewById(R.id.top_content);
            this.mTitleBar = (TextView) inflate.findViewById(R.id.title_bar);
            this.mMessage = (TextView) inflate.findViewById(R.id.content_message);
            this.mLayoutContentList = (LinearLayout) findViewById(R.id.layout_list);
            this.mContentList = (FrameLayout) findViewById(R.id.content_list);
            this.mTitleBarList = (TextView) findViewById(R.id.title_bar_list);
            this.mFirstBtn = (TextView) inflate.findViewById(R.id.first_btn);
            this.mSecondBtn = (TextView) inflate.findViewById(R.id.second_btn);
            this.mFirstBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.navisdk.ui.widget.dialog.BNDialog.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BNDialog.this.mOnFirstBtnClickListener != null) {
                        BNDialog.this.mOnFirstBtnClickListener.onClick();
                    }
                    BNDialog.this.dismiss();
                }
            });
            this.mSecondBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.navisdk.ui.widget.dialog.BNDialog.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BNDialog.this.mOnSecondBtnClickListener != null) {
                        BNDialog.this.mOnSecondBtnClickListener.onClick();
                    }
                    try {
                        BNDialog.this.dismiss();
                    } catch (Exception unused) {
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
        } catch (Throwable unused) {
        }
    }

    private void setBtnVisible() {
        boolean z = this.mFirstHasText;
        if (!z && !this.mSecondHasText) {
            TextView textView = this.mFirstBtn;
            if (textView != null) {
                textView.setVisibility(8);
            }
            TextView textView2 = this.mSecondBtn;
            if (textView2 != null) {
                textView2.setVisibility(8);
                return;
            }
            return;
        }
        boolean z2 = this.mSecondHasText;
        if (!z2 && z) {
            TextView textView3 = this.mFirstBtn;
            if (textView3 != null) {
                textView3.setVisibility(0);
                this.mFirstBtn.setBackgroundDrawable(b.f(R.drawable.nsdk_common_dialog_chang));
            }
            TextView textView4 = this.mSecondBtn;
            if (textView4 != null) {
                textView4.setVisibility(8);
                return;
            }
            return;
        }
        if (!z && z2) {
            TextView textView5 = this.mFirstBtn;
            if (textView5 != null) {
                textView5.setVisibility(8);
            }
            TextView textView6 = this.mSecondBtn;
            if (textView6 != null) {
                textView6.setVisibility(0);
                this.mSecondBtn.setBackgroundDrawable(b.f(R.drawable.nsdk_common_dialog_chang));
                return;
            }
            return;
        }
        if (z && z2) {
            TextView textView7 = this.mFirstBtn;
            if (textView7 != null) {
                textView7.setVisibility(0);
                this.mFirstBtn.setBackgroundDrawable(b.f(R.drawable.nsdk_common_dialog_left));
            }
            TextView textView8 = this.mSecondBtn;
            if (textView8 != null) {
                textView8.setVisibility(0);
                this.mSecondBtn.setBackgroundDrawable(b.f(R.drawable.nsdk_common_dialog_right));
            }
        }
    }

    private void updateDayStyle() {
        LinearLayout linearLayout = this.mTopContentLayout;
        if (linearLayout != null && this.mTitleBar != null && this.mMessage != null && this.mFirstBtn != null && this.mSecondBtn != null) {
            linearLayout.setBackgroundDrawable(JarUtils.getResources().getDrawable(R.drawable.nsdk_drawable_common_dialog_top));
            TextView textView = this.mTitleBar;
            Resources resources = JarUtils.getResources();
            int i = R.color.nsdk_color_dialog_content_text;
            textView.setTextColor(resources.getColor(i));
            this.mMessage.setTextColor(JarUtils.getResources().getColor(i));
            if (!this.isFirstBtnHighLight) {
                this.mFirstBtn.setTextColor(JarUtils.getResources().getColor(i));
            }
            if (!this.isSecondBtnHighLight) {
                this.mSecondBtn.setTextColor(JarUtils.getResources().getColor(i));
            }
            boolean z = this.mFirstHasText;
            if (z && this.mSecondHasText) {
                this.mFirstBtn.setBackgroundDrawable(JarUtils.getResources().getDrawable(R.drawable.nsdk_common_dialog_left));
                this.mSecondBtn.setBackgroundDrawable(JarUtils.getResources().getDrawable(R.drawable.nsdk_common_dialog_right));
            } else if (!z && this.mSecondHasText) {
                this.mSecondBtn.setBackgroundDrawable(JarUtils.getResources().getDrawable(R.drawable.nsdk_common_dialog_chang));
            } else if (z && !this.mSecondHasText) {
                this.mFirstBtn.setBackgroundDrawable(JarUtils.getResources().getDrawable(R.drawable.nsdk_common_dialog_chang));
            }
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        this.mFirstHasText = false;
        this.mSecondHasText = false;
        super.dismiss();
    }

    public BNDialog enableBackKey(boolean z) {
        super.setCancelable(z);
        return this;
    }

    public BNDialog setContentCenter() {
        TextView textView = this.mMessage;
        if (textView != null) {
            textView.setGravity(17);
        }
        return this;
    }

    public BNDialog setContentList(View view) {
        LinearLayout linearLayout = this.mTopContentLayout;
        if (linearLayout != null) {
            linearLayout.setBackgroundResource(b.b(R.drawable.transparent));
        }
        LinearLayout linearLayout2 = this.mLayoutContentList;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(0);
        }
        FrameLayout frameLayout = this.mContentList;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
            this.mContentList.addView(view);
        }
        return this;
    }

    public BNDialog setContentMessage(String str) {
        if (this.mMessage == null) {
            return this;
        }
        if (TextUtils.isEmpty(str)) {
            this.mMessage.setVisibility(8);
            this.mMessage.setText("", TextView.BufferType.SPANNABLE);
        } else {
            this.mMessage.setVisibility(0);
            this.mMessage.setText(str, TextView.BufferType.SPANNABLE);
        }
        return this;
    }

    public BNDialog setContentMessageFromActivity(int i) {
        TextView textView = this.mMessage;
        if (textView != null) {
            textView.setVisibility(0);
            this.mMessage.setText(i, TextView.BufferType.SPANNABLE);
        }
        return this;
    }

    public BNDialog setFirstBtnEnabled(boolean z) {
        TextView textView = this.mFirstBtn;
        if (textView != null) {
            textView.setEnabled(z);
        }
        return this;
    }

    public BNDialog setFirstBtnText(String str) {
        TextView textView = this.mFirstBtn;
        if (textView != null) {
            if (str == null) {
                this.mFirstHasText = false;
                textView.setText("", TextView.BufferType.SPANNABLE);
            } else {
                this.mFirstHasText = true;
                textView.setText(str, TextView.BufferType.SPANNABLE);
            }
            setBtnVisible();
        }
        return this;
    }

    public BNDialog setFirstBtnTextColorHighLight() {
        this.isFirstBtnHighLight = true;
        TextView textView = this.mFirstBtn;
        if (textView != null) {
            textView.setTextColor(-12352272);
        }
        return this;
    }

    public BNDialog setFirstBtnTextFromActivity(int i) {
        this.mFirstHasText = true;
        this.mFirstBtn.setText(i, TextView.BufferType.SPANNABLE);
        setBtnVisible();
        return this;
    }

    public BNDialog setListTitleText(String str) {
        LinearLayout linearLayout;
        TextView textView = this.mTitleBarList;
        if (textView != null && (linearLayout = this.mTopContentLayout) != null) {
            if (str == null) {
                textView.setVisibility(8);
                this.mTitleBarList.setText("", TextView.BufferType.SPANNABLE);
            } else {
                linearLayout.setVisibility(8);
                this.mTitleBarList.setVisibility(0);
                this.mTitleBarList.setText(str, TextView.BufferType.SPANNABLE);
            }
            this.mTitleBarList.setTextColor(b.b(R.color.nsdk_navi_dialog_high_light));
            this.mTitleBarList.setBackgroundDrawable(b.f(R.drawable.nsdk_drawable_common_dialog_top));
        }
        return this;
    }

    public BNDialog setOnFirstBtnClickListener(OnNaviClickListener onNaviClickListener) {
        this.mOnFirstBtnClickListener = onNaviClickListener;
        return this;
    }

    public BNDialog setOnSecondBtnClickListener(OnNaviClickListener onNaviClickListener) {
        this.mOnSecondBtnClickListener = onNaviClickListener;
        return this;
    }

    public BNDialog setSecondBtnEnabled(boolean z) {
        TextView textView = this.mSecondBtn;
        if (textView != null) {
            textView.setEnabled(z);
        }
        return this;
    }

    public BNDialog setSecondBtnText(String str) {
        TextView textView = this.mSecondBtn;
        if (textView != null) {
            if (str == null) {
                this.mSecondHasText = false;
                textView.setText("", TextView.BufferType.SPANNABLE);
            } else {
                this.mSecondHasText = true;
                textView.setText(str, TextView.BufferType.SPANNABLE);
            }
            setBtnVisible();
        }
        return this;
    }

    public BNDialog setSecondBtnTextColorHighLight() {
        this.isSecondBtnHighLight = true;
        TextView textView = this.mSecondBtn;
        if (textView != null) {
            textView.setTextColor(-12352272);
        }
        return this;
    }

    public BNDialog setSecondBtnTextFromActivity(int i) {
        TextView textView = this.mSecondBtn;
        if (textView != null) {
            this.mSecondHasText = true;
            textView.setText(i, TextView.BufferType.SPANNABLE);
            setBtnVisible();
        }
        return this;
    }

    public BNDialog setTitleText(String str) {
        TextView textView = this.mTitleBar;
        if (textView != null) {
            if (str == null) {
                textView.setVisibility(8);
                this.mTitleBar.setText("", TextView.BufferType.SPANNABLE);
            } else {
                textView.setVisibility(0);
                this.mTitleBar.setText(str, TextView.BufferType.SPANNABLE);
            }
        }
        return this;
    }

    public BNDialog setTitleTextFromActivity(int i) {
        TextView textView = this.mTitleBar;
        if (textView != null) {
            textView.setVisibility(0);
            this.mTitleBar.setText(i, TextView.BufferType.SPANNABLE);
        }
        return this;
    }

    @Override // android.app.Dialog
    public void show() {
        if (this.isSupportDayNight) {
            updateStyle();
        } else {
            updateDayStyle();
        }
        super.show();
    }

    public void updateStyle() {
        this.isSupportDayNight = true;
        LinearLayout linearLayout = this.mTopContentLayout;
        if (linearLayout != null && this.mTitleBar != null && this.mMessage != null && this.mFirstBtn != null && this.mSecondBtn != null) {
            linearLayout.setBackgroundDrawable(b.f(R.drawable.nsdk_drawable_common_dialog_top));
            TextView textView = this.mTitleBar;
            int i = R.color.nsdk_color_dialog_content_text;
            textView.setTextColor(b.b(i));
            this.mMessage.setTextColor(b.b(i));
            this.mFirstBtn.setTextColor(b.b(i));
            this.mSecondBtn.setTextColor(b.b(i));
            boolean z = this.mFirstHasText;
            if (z && this.mSecondHasText) {
                this.mFirstBtn.setBackgroundDrawable(b.f(R.drawable.nsdk_common_dialog_left));
                this.mSecondBtn.setBackgroundDrawable(b.f(R.drawable.nsdk_common_dialog_right));
            } else if (!z && this.mSecondHasText) {
                this.mSecondBtn.setBackgroundDrawable(b.f(R.drawable.nsdk_common_dialog_chang));
            } else if (z && !this.mSecondHasText) {
                this.mFirstBtn.setBackgroundDrawable(b.f(R.drawable.nsdk_common_dialog_chang));
            }
        }
    }

    public BNDialog setTitleText(int i) {
        return setTitleText(JarUtils.getResources().getString(i));
    }

    public BNDialog setContentMessage(int i) {
        return setContentMessage(JarUtils.getResources().getString(i));
    }

    public BNDialog setFirstBtnText(Spanned spanned) {
        TextView textView = this.mFirstBtn;
        if (textView != null) {
            if (spanned == null) {
                this.mFirstHasText = false;
                textView.setText("");
            } else {
                this.mFirstHasText = true;
                textView.setText(spanned);
            }
            setBtnVisible();
        }
        return this;
    }

    public BNDialog setSecondBtnText(Spanned spanned) {
        TextView textView = this.mSecondBtn;
        if (textView != null) {
            if (spanned == null) {
                this.mSecondHasText = false;
                textView.setText("");
            } else {
                this.mSecondHasText = true;
                textView.setText(spanned);
            }
            setBtnVisible();
        }
        return this;
    }

    public BNDialog setFirstBtnText(boolean z, String str) {
        TextView textView = this.mFirstBtn;
        if (textView != null) {
            if (str == null) {
                this.mFirstHasText = false;
                textView.setText("", TextView.BufferType.SPANNABLE);
            } else {
                this.mFirstHasText = true;
                textView.setText(str, TextView.BufferType.SPANNABLE);
            }
            setBtnVisible(z);
        }
        return this;
    }

    public BNDialog setSecondBtnText(boolean z, String str) {
        TextView textView = this.mSecondBtn;
        if (textView != null) {
            if (str == null) {
                this.mSecondHasText = false;
                textView.setText("", TextView.BufferType.SPANNABLE);
            } else {
                this.mSecondHasText = true;
                textView.setText(str, TextView.BufferType.SPANNABLE);
            }
            setBtnVisible(z);
        }
        return this;
    }

    public BNDialog setFirstBtnText(int i) {
        return setFirstBtnText(JarUtils.getResources().getString(i));
    }

    public BNDialog setSecondBtnText(int i) {
        return setSecondBtnText(JarUtils.getResources().getString(i));
    }

    private void setBtnVisible(boolean z) {
        boolean z2 = this.mFirstHasText;
        if (!z2 && !this.mSecondHasText) {
            TextView textView = this.mFirstBtn;
            if (textView != null) {
                textView.setVisibility(8);
            }
            TextView textView2 = this.mSecondBtn;
            if (textView2 != null) {
                textView2.setVisibility(8);
                return;
            }
            return;
        }
        boolean z3 = this.mSecondHasText;
        if (!z3 && z2) {
            TextView textView3 = this.mFirstBtn;
            if (textView3 != null) {
                textView3.setVisibility(0);
                this.mFirstBtn.setBackgroundDrawable(b.c(R.drawable.nsdk_common_dialog_chang, z));
            }
            TextView textView4 = this.mSecondBtn;
            if (textView4 != null) {
                textView4.setVisibility(8);
                return;
            }
            return;
        }
        if (!z2 && z3) {
            TextView textView5 = this.mFirstBtn;
            if (textView5 != null) {
                textView5.setVisibility(8);
            }
            TextView textView6 = this.mSecondBtn;
            if (textView6 != null) {
                textView6.setVisibility(0);
                this.mSecondBtn.setBackgroundDrawable(b.c(R.drawable.nsdk_common_dialog_chang, z));
                return;
            }
            return;
        }
        if (z2 && z3) {
            TextView textView7 = this.mFirstBtn;
            if (textView7 != null) {
                textView7.setVisibility(0);
                this.mFirstBtn.setBackgroundDrawable(b.c(R.drawable.nsdk_common_dialog_left, z));
            }
            TextView textView8 = this.mSecondBtn;
            if (textView8 != null) {
                textView8.setVisibility(0);
                this.mSecondBtn.setBackgroundDrawable(b.c(R.drawable.nsdk_common_dialog_right, z));
            }
        }
    }
}
