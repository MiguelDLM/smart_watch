package com.baidu.navisdk.module.vehiclemanager.widgets;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.annotation.IdRes;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.util.b;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes7.dex */
public class BNSettingTextRadioGroup extends RadioGroup implements RadioGroup.OnCheckedChangeListener {

    /* renamed from: a, reason: collision with root package name */
    private RadioButton[] f7613a;
    private CharSequence[] b;

    @IdRes
    private int[] c;
    private a d;
    private int e;
    private boolean f;

    /* loaded from: classes7.dex */
    public interface a {
        void a(CharSequence charSequence, int i);
    }

    public BNSettingTextRadioGroup(Context context) {
        this(context, null);
    }

    private void a(Context context, AttributeSet attributeSet) {
        if (context == null || attributeSet == null) {
            return;
        }
        this.e = context.getResources().getDimensionPixelSize(R.dimen.motor_setting_middle_radio_margin_left_right);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BNSettingTextRadioGroup);
        int i = R.styleable.BNSettingTextRadioGroup_nsdk_radio_init_daynight;
        if (obtainStyledAttributes.hasValue(i)) {
            this.f = obtainStyledAttributes.getBoolean(i, true);
        }
        int i2 = R.styleable.BNSettingTextRadioGroup_nsdk_radio_content_array;
        if (obtainStyledAttributes.hasValue(i2)) {
            CharSequence[] textArray = obtainStyledAttributes.getTextArray(i2);
            this.b = textArray;
            if (textArray != null && textArray.length > 0) {
                a(textArray);
            }
        }
        int i3 = R.styleable.BNSettingTextRadioGroup_nsdk_radio_button_margin;
        if (obtainStyledAttributes.hasValue(i3)) {
            this.e = obtainStyledAttributes.getDimensionPixelSize(i3, this.e);
        }
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        int[] iArr;
        a aVar;
        int[] iArr2 = this.c;
        if (iArr2 != null && iArr2.length > 0) {
            int i2 = 0;
            while (true) {
                iArr = this.c;
                if (i2 >= iArr.length || iArr[i2] == i) {
                    break;
                } else {
                    i2++;
                }
            }
            if (i2 < iArr.length && (aVar = this.d) != null) {
                aVar.a(this.b[i2], i2);
            }
        }
    }

    public void setOnCheckedChangeListener(a aVar) {
        this.d = aVar;
    }

    public BNSettingTextRadioGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = 0;
        this.f = true;
        a(context, attributeSet);
    }

    private void a(CharSequence[] charSequenceArr) {
        ColorStateList colorStateList;
        int i;
        LayoutInflater from = LayoutInflater.from(getContext());
        this.f7613a = new RadioButton[charSequenceArr.length];
        this.c = new int[charSequenceArr.length];
        Resources resources = getResources();
        if (this.f) {
            colorStateList = b.c(R.color.nsdk_color_more_setting_voice_selector);
        } else {
            colorStateList = JarUtils.getResources().getColorStateList(R.color.nsdk_color_more_setting_voice_selector);
        }
        int dimensionPixelSize = JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_13dp);
        for (int i2 = 0; i2 < charSequenceArr.length; i2++) {
            RadioButton radioButton = (RadioButton) from.inflate(R.layout.motor_layout_setting_radio_button_item, (ViewGroup) this, false);
            RadioGroup.LayoutParams layoutParams = (RadioGroup.LayoutParams) radioButton.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new RadioGroup.LayoutParams(0, resources.getDimensionPixelSize(R.dimen.navi_dimens_30dp), 1.0f);
                layoutParams.gravity = 17;
            }
            int i3 = this.e;
            if (i3 > 0) {
                layoutParams.leftMargin = i3;
                i = R.drawable.nsdk_drawable_rg_more_setting_toogle_button_bg;
            } else if (i2 == 0) {
                i = R.drawable.nsdk_drawable_rg_more_setting_toogle_button_left_bg;
            } else if (i2 == charSequenceArr.length - 1) {
                i = R.drawable.nsdk_drawable_rg_more_setting_toogle_button_right_bg;
            } else {
                int i4 = R.drawable.nsdk_drawable_rg_more_setting_toogle_button_middle_bg;
                layoutParams.rightMargin = i3;
                layoutParams.leftMargin = i3;
                i = i4;
            }
            if (this.f) {
                radioButton.setBackgroundDrawable(b.f(i));
            } else {
                radioButton.setBackgroundDrawable(JarUtils.getResources().getDrawable(i));
            }
            radioButton.setTextSize(0, dimensionPixelSize);
            radioButton.setTextColor(colorStateList);
            this.c[i2] = a(getContext(), resources, i2);
            radioButton.setId(this.c[i2]);
            radioButton.setText(charSequenceArr[i2]);
            addView(radioButton, i2, layoutParams);
            this.f7613a[i2] = radioButton;
        }
        setOnCheckedChangeListener(this);
    }

    private int a(Context context, Resources resources, int i) {
        return resources.getIdentifier("motor_text_radio_button_" + i, "id", context.getPackageName());
    }

    public void a(boolean z) {
        int childCount = getChildCount();
        if (childCount <= 0) {
            return;
        }
        ColorStateList c = b.c(R.color.nsdk_color_more_setting_voice_selector);
        for (int i = 0; i < childCount; i++) {
            RadioButton radioButton = (RadioButton) getChildAt(i);
            if (radioButton != null) {
                if (c != null) {
                    radioButton.setTextColor(c);
                }
                if (this.e > 0) {
                    radioButton.setBackgroundDrawable(b.f(R.drawable.nsdk_drawable_rg_more_setting_toogle_button_bg));
                } else if (i == 0) {
                    radioButton.setBackgroundDrawable(b.f(R.drawable.nsdk_drawable_rg_more_setting_toogle_button_left_bg));
                } else if (i == childCount - 1) {
                    radioButton.setBackgroundDrawable(b.f(R.drawable.nsdk_drawable_rg_more_setting_toogle_button_right_bg));
                } else {
                    radioButton.setBackgroundDrawable(b.f(R.drawable.nsdk_drawable_rg_more_setting_toogle_button_middle_bg));
                }
            }
        }
    }

    public void a(int i) {
        RadioButton[] radioButtonArr = this.f7613a;
        if (radioButtonArr != null && i >= 0 && i < radioButtonArr.length) {
            radioButtonArr[i].setChecked(true);
        } else if (LogUtil.LOGGABLE) {
            LogUtil.e("MotorSettingLayoutTextRadioGroup", "updateChecked failed, position:" + i);
        }
    }
}
