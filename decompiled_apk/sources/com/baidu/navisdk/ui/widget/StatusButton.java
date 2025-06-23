package com.baidu.navisdk.ui.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.ui.util.b;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes8.dex */
public class StatusButton extends LinearLayout {
    private onStatusButtonClickListener allListener;
    private RadioButton btn1;
    private RadioButton btn2;
    private RadioButton btn3;
    private RadioGroup btnGroup;
    private View.OnClickListener cl1;
    private View.OnClickListener cl2;
    private View.OnClickListener cl3;
    private boolean isMapMode;
    private Context mContext;
    private int setBtnFlag;

    /* loaded from: classes8.dex */
    public enum StatusButtonChild {
        LEFT,
        MID,
        RIGHT
    }

    /* loaded from: classes8.dex */
    public interface onStatusButtonClickListener {
        void onClick(StatusButton statusButton, StatusButtonChild statusButtonChild);
    }

    public StatusButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isMapMode = true;
        this.mContext = context;
        initView();
    }

    private ColorStateList createColorStateList(int i, int i2, int i3) {
        return new ColorStateList(new int[][]{new int[]{R.attr.state_pressed}, new int[]{R.attr.state_checked}, new int[0]}, new int[]{i2, i3, i});
    }

    private void initView() {
        boolean isUsingMapMode = BNSettingManager.isUsingMapMode();
        this.isMapMode = isUsingMapMode;
        if (isUsingMapMode) {
            JarUtils.inflate(this.mContext, com.baidu.navisdk.embed.R.layout.nsdk_layout_statusbutton, this);
        } else {
            JarUtils.inflate(this.mContext, com.baidu.navisdk.embed.R.layout.nsdk_layout_statusbutton_carmode, this);
        }
        RadioGroup radioGroup = (RadioGroup) findViewById(com.baidu.navisdk.embed.R.id.rbtngroup);
        this.btnGroup = radioGroup;
        this.btn1 = (RadioButton) radioGroup.getChildAt(0);
        this.btn2 = (RadioButton) this.btnGroup.getChildAt(1);
        this.btn3 = (RadioButton) this.btnGroup.getChildAt(2);
        if (!b.b()) {
            updateDayStyle();
        }
        this.btnGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.baidu.navisdk.ui.widget.StatusButton.1
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup radioGroup2, int i) {
                if (i == StatusButton.this.btn1.getId() && StatusButton.this.setBtnFlag != 1) {
                    StatusButton.this.setBtnFlag = 1;
                } else if (i == StatusButton.this.btn2.getId() && StatusButton.this.setBtnFlag != 2) {
                    StatusButton.this.setBtnFlag = 2;
                } else if (i == StatusButton.this.btn3.getId() && StatusButton.this.setBtnFlag != 3) {
                    StatusButton.this.setBtnFlag = 3;
                } else {
                    return;
                }
                if (StatusButton.this.allListener != null) {
                    int i2 = StatusButton.this.setBtnFlag;
                    if (i2 != 1) {
                        if (i2 != 2) {
                            if (i2 == 3) {
                                StatusButton.this.allListener.onClick(StatusButton.this, StatusButtonChild.RIGHT);
                                return;
                            }
                            return;
                        }
                        StatusButton.this.allListener.onClick(StatusButton.this, StatusButtonChild.MID);
                        return;
                    }
                    StatusButton.this.allListener.onClick(StatusButton.this, StatusButtonChild.LEFT);
                    return;
                }
                int i3 = StatusButton.this.setBtnFlag;
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 == 3 && StatusButton.this.cl3 != null) {
                            StatusButton.this.cl3.onClick(StatusButton.this.btn3);
                            return;
                        }
                        return;
                    }
                    if (StatusButton.this.cl2 != null) {
                        StatusButton.this.cl2.onClick(StatusButton.this.btn2);
                        return;
                    }
                    return;
                }
                if (StatusButton.this.cl1 != null) {
                    StatusButton.this.cl1.onClick(StatusButton.this.btn1);
                }
            }
        });
    }

    public StatusButton setAllBtnClickListener(onStatusButtonClickListener onstatusbuttonclicklistener) {
        this.allListener = onstatusbuttonclicklistener;
        return this;
    }

    public StatusButton setAllButtonText(String str, String str2, String str3) {
        this.btn1.setText(str);
        this.btn2.setText(str2);
        this.btn3.setText(str3);
        return this;
    }

    public StatusButton setLeftBtnChecked() {
        this.btn1.setChecked(true);
        this.setBtnFlag = 1;
        return this;
    }

    public StatusButton setLeftBtnClickListener(View.OnClickListener onClickListener) {
        this.cl1 = onClickListener;
        return this;
    }

    public StatusButton setLeftButtonText(String str) {
        this.btn1.setText(str);
        return this;
    }

    public StatusButton setMidBtnChecked() {
        this.btn2.setChecked(true);
        this.setBtnFlag = 2;
        return this;
    }

    public StatusButton setMidBtnClickListener(View.OnClickListener onClickListener) {
        this.cl2 = onClickListener;
        return this;
    }

    public StatusButton setMidBtnGone(boolean z) {
        this.btn2.setVisibility(8);
        return this;
    }

    public StatusButton setMidButtonText(String str) {
        this.btn2.setText(str);
        return this;
    }

    public StatusButton setRightBtnChecked() {
        this.btn3.setChecked(true);
        this.setBtnFlag = 3;
        return this;
    }

    public StatusButton setRightBtnClickListener(View.OnClickListener onClickListener) {
        this.cl3 = onClickListener;
        return this;
    }

    public StatusButton setRightButtonText(String str) {
        this.btn3.setText(str);
        return this;
    }

    public void updateDayStyle() {
        if (this.isMapMode) {
            int i = com.baidu.navisdk.embed.R.color.nsdk_statusbutton_tc_default;
            int b = b.b(i);
            int i2 = com.baidu.navisdk.embed.R.color.nsdk_statusbutton_tc_pressed;
            this.btn1.setTextColor(createColorStateList(b, b.b(i2), b.b(i2)));
            this.btn2.setTextColor(createColorStateList(b.b(i), b.b(i2), b.b(i2)));
            this.btn3.setTextColor(createColorStateList(b.b(i), b.b(i2), b.b(i2)));
            this.btn1.setBackground(b.f(com.baidu.navisdk.embed.R.drawable.nsdk_drawable_statusbutton_left_button));
            this.btn2.setBackground(b.f(com.baidu.navisdk.embed.R.drawable.nsdk_drawable_statusbutton_mid_button));
            this.btn3.setBackground(b.f(com.baidu.navisdk.embed.R.drawable.nsdk_drawable_statusbutton_right_button));
        }
    }

    public StatusButton setLeftButtonText(int i) {
        this.btn1.setText(i);
        return this;
    }

    public StatusButton setMidButtonText(int i) {
        this.btn2.setText(i);
        return this;
    }

    public StatusButton setRightButtonText(int i) {
        this.btn3.setText(i);
        return this;
    }

    public StatusButton setAllButtonText(int i, int i2, int i3) {
        this.btn1.setText(i);
        this.btn2.setText(i2);
        this.btn3.setText(i3);
        return this;
    }

    public StatusButton(Context context) {
        super(context);
        this.isMapMode = true;
        this.mContext = context;
        initView();
    }

    public StatusButton setAllButtonText(String str, String str2) {
        this.btn1.setText(str);
        this.btn2.setVisibility(8);
        this.btn3.setText(str2);
        return this;
    }

    public StatusButton setAllButtonText(int i, int i2) {
        this.btn1.setText(i);
        this.btn2.setVisibility(8);
        this.btn3.setText(i2);
        return this;
    }
}
