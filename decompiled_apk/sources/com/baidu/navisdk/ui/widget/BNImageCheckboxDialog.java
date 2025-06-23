package com.baidu.navisdk.ui.widget;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.util.b;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes8.dex */
public class BNImageCheckboxDialog extends Dialog implements View.OnClickListener {
    private final boolean isSupportDayNight;
    private Runnable mAutoHideRunnable;
    private int mAutoHideTime;
    private View mConfirmView;
    private LinearLayout mContentLayout;
    private CheckBox mFirstItemCheckbox;
    private TextView mFirstItemMainTextView;
    private TextView mFirstItemSubTextView;
    private View mFirstItemView;
    private OnClickListener mOnClickListener;
    private CheckBox mSecondItemCheckbox;
    private TextView mSecondItemMainTextView;
    private TextView mSecondItemSubTextView;
    private View mSecondItemView;
    private TextView mTitleTextView;
    private ImageView mTopImageView;

    /* loaded from: classes8.dex */
    public interface OnClickListener {
        void onAutoHide(int i);

        void onItemChecked(int i);
    }

    public BNImageCheckboxDialog(Activity activity, boolean z) {
        super(activity, R.style.BNDialog);
        View inflate;
        this.mAutoHideTime = 0;
        this.isSupportDayNight = z;
        if (z) {
            inflate = b.a(activity, R.layout.nsdk_layout_image_checkbox_dialog);
        } else {
            inflate = JarUtils.inflate(activity, R.layout.nsdk_layout_image_checkbox_dialog, null);
        }
        try {
            setContentView(inflate);
            this.mContentLayout = (LinearLayout) inflate.findViewById(R.id.ic_dialog_content);
            this.mTopImageView = (ImageView) inflate.findViewById(R.id.ic_dialog_imageview);
            this.mTitleTextView = (TextView) inflate.findViewById(R.id.ic_dialog_title);
            this.mFirstItemView = inflate.findViewById(R.id.ic_dialog_first_item);
            this.mFirstItemMainTextView = (TextView) inflate.findViewById(R.id.ic_dialog_first_item_main_txt);
            this.mFirstItemSubTextView = (TextView) inflate.findViewById(R.id.ic_dialog_first_item_sub_txt);
            CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.ic_dialog_first_item_checkbox);
            this.mFirstItemCheckbox = checkBox;
            checkBox.setChecked(true);
            this.mFirstItemCheckbox.setOnClickListener(this);
            this.mSecondItemView = inflate.findViewById(R.id.ic_dialog_second_item);
            this.mSecondItemMainTextView = (TextView) inflate.findViewById(R.id.ic_dialog_second_item_main_txt);
            this.mSecondItemSubTextView = (TextView) inflate.findViewById(R.id.ic_dialog_second_item_sub_txt);
            CheckBox checkBox2 = (CheckBox) inflate.findViewById(R.id.ic_dialog_second_item_checkbox);
            this.mSecondItemCheckbox = checkBox2;
            checkBox2.setChecked(false);
            this.mSecondItemCheckbox.setOnClickListener(this);
            View findViewById = inflate.findViewById(R.id.confirm_btn);
            this.mConfirmView = findViewById;
            findViewById.setOnClickListener(this);
            setCanceledOnTouchOutside(false);
        } catch (Throwable unused) {
        }
    }

    private void runAutoHide() {
        if (this.mContentLayout != null) {
            Runnable runnable = new Runnable() { // from class: com.baidu.navisdk.ui.widget.BNImageCheckboxDialog.1
                @Override // java.lang.Runnable
                public void run() {
                    int i;
                    if (BNImageCheckboxDialog.this.isShowing()) {
                        BNImageCheckboxDialog.this.dismiss();
                        if (BNImageCheckboxDialog.this.mOnClickListener != null && BNImageCheckboxDialog.this.mFirstItemCheckbox != null) {
                            OnClickListener onClickListener = BNImageCheckboxDialog.this.mOnClickListener;
                            if (BNImageCheckboxDialog.this.mFirstItemCheckbox.isChecked()) {
                                i = 1;
                            } else {
                                i = 2;
                            }
                            onClickListener.onAutoHide(i);
                        }
                    }
                }
            };
            this.mAutoHideRunnable = runnable;
            this.mContentLayout.postDelayed(runnable, this.mAutoHideTime);
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        try {
            super.dismiss();
        } catch (Exception e) {
            if (LogUtil.LOGGABLE) {
                LogUtil.printException("BNImageCheckboxDialog-dismiss", e);
            }
        }
        LinearLayout linearLayout = this.mContentLayout;
        if (linearLayout != null) {
            linearLayout.removeCallbacks(this.mAutoHideRunnable);
        }
    }

    public BNImageCheckboxDialog enableBackKey(boolean z) {
        super.setCancelable(z);
        return this;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        OnClickListener onClickListener;
        CheckBox checkBox = this.mFirstItemCheckbox;
        int i = 1;
        if (checkBox == view) {
            checkBox.setChecked(true);
            this.mSecondItemCheckbox.setChecked(false);
        } else if (this.mSecondItemCheckbox == view) {
            checkBox.setChecked(false);
            this.mSecondItemCheckbox.setChecked(true);
        } else if (this.mConfirmView == view && (onClickListener = this.mOnClickListener) != null) {
            if (!checkBox.isChecked()) {
                i = 2;
            }
            onClickListener.onItemChecked(i);
        }
    }

    public BNImageCheckboxDialog setAutoHideTime(int i) {
        this.mAutoHideTime = i;
        return this;
    }

    public BNImageCheckboxDialog setBottomBackground(int i) {
        if (this.isSupportDayNight) {
            b.a(this.mContentLayout, i);
        } else {
            this.mContentLayout.setBackgroundResource(i);
        }
        return this;
    }

    public BNImageCheckboxDialog setFirstItemMainText(String str) {
        TextView textView = this.mFirstItemMainTextView;
        if (textView != null) {
            textView.setText(str);
        }
        return this;
    }

    public BNImageCheckboxDialog setFirstItemSubText(String str) {
        TextView textView = this.mFirstItemSubTextView;
        if (textView != null) {
            textView.setText(str);
            this.mFirstItemSubTextView.setVisibility(0);
        }
        return this;
    }

    public BNImageCheckboxDialog setOnClickListener(OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
        return this;
    }

    public BNImageCheckboxDialog setSecondItemMainText(String str) {
        TextView textView = this.mSecondItemMainTextView;
        if (textView != null) {
            textView.setText(str);
        }
        return this;
    }

    public BNImageCheckboxDialog setSecondItemSubText(String str) {
        TextView textView = this.mSecondItemSubTextView;
        if (textView != null) {
            textView.setText(str);
            this.mSecondItemSubTextView.setVisibility(0);
        }
        return this;
    }

    public BNImageCheckboxDialog setTitle(String str) {
        TextView textView = this.mTitleTextView;
        if (textView != null) {
            textView.setText(str);
            this.mTitleTextView.setVisibility(0);
        }
        return this;
    }

    public BNImageCheckboxDialog setTopImageDrawable(int i) {
        this.mTopImageView.setVisibility(0);
        if (this.isSupportDayNight) {
            b.a(this.mTopImageView, i);
        } else {
            this.mTopImageView.setImageResource(i);
        }
        return this;
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        if (this.mAutoHideTime > 0) {
            runAutoHide();
        }
    }
}
