package com.baidu.navisdk.module.vehiclemanager.widgets;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.annotation.IdRes;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.util.b;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes7.dex */
public class BNSettingNewTextRadioGroup extends RadioGroup implements RadioGroup.OnCheckedChangeListener {

    /* renamed from: a, reason: collision with root package name */
    private RadioButton[] f7611a;
    private CharSequence[] b;

    @IdRes
    private int[] c;
    private int d;
    private boolean e;
    private a f;
    private int g;
    private View[] h;

    /* loaded from: classes7.dex */
    public interface a {
        void a(RadioGroup radioGroup, @IdRes int i, CharSequence charSequence, int i2);
    }

    public BNSettingNewTextRadioGroup(Context context) {
        this(context, null);
    }

    private void a(Context context, AttributeSet attributeSet) {
        if (context == null || attributeSet == null) {
            return;
        }
        this.d = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BNSettingNewTextRadioGroup);
        int i = R.styleable.BNSettingNewTextRadioGroup_nsdk_radio_init_daynight;
        if (obtainStyledAttributes.hasValue(i)) {
            this.e = obtainStyledAttributes.getBoolean(i, true);
        }
        int i2 = R.styleable.BNSettingNewTextRadioGroup_nsdk_radio_button_margin;
        if (obtainStyledAttributes.hasValue(i2)) {
            this.d = obtainStyledAttributes.getDimensionPixelSize(i2, this.d);
        }
        int i3 = R.styleable.BNSettingNewTextRadioGroup_nsdk_radio_content_array;
        if (obtainStyledAttributes.hasValue(i3)) {
            CharSequence[] charSequenceArr = this.b;
            if (charSequenceArr == null || charSequenceArr.length == 0) {
                this.b = obtainStyledAttributes.getTextArray(i3);
            }
            CharSequence[] charSequenceArr2 = this.b;
            if (charSequenceArr2 != null && charSequenceArr2.length > 0) {
                a(charSequenceArr2);
            }
        }
        obtainStyledAttributes.recycle();
    }

    private void b(int i) {
        if (this.h == null) {
            return;
        }
        int i2 = 0;
        while (true) {
            View[] viewArr = this.h;
            if (i2 < viewArr.length) {
                if (i2 != i && i2 != i - 1) {
                    viewArr[i2].setVisibility(0);
                } else {
                    viewArr[i2].setVisibility(4);
                }
                i2++;
            } else {
                return;
            }
        }
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        int[] iArr;
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
            if (this.g == i2) {
                g gVar = g.COMMON;
                if (gVar.d()) {
                    gVar.e("BNSettingNewTextRadioGr", "onCheckedChanged mCheckedPosition: " + this.g + ", index:" + i2);
                    return;
                }
                return;
            }
            if (i2 < iArr.length) {
                this.g = i2;
                b(i2);
                a aVar = this.f;
                if (aVar != null) {
                    aVar.a(radioGroup, i, this.b[i2], i2);
                }
            }
        }
    }

    public void setChildRadioContents(CharSequence[] charSequenceArr) {
        this.b = charSequenceArr;
        removeAllViews();
        if (charSequenceArr != null && charSequenceArr.length > 0) {
            a(charSequenceArr);
        }
        invalidate();
    }

    public void setOnRadioCheckedChangeListener(a aVar) {
        this.f = aVar;
    }

    public BNSettingNewTextRadioGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = 0;
        this.e = true;
        this.g = -1;
        a(context, attributeSet);
    }

    private void a(CharSequence[] charSequenceArr) {
        RadioButton radioButton;
        LayoutInflater from = LayoutInflater.from(getContext());
        this.f7611a = new RadioButton[charSequenceArr.length];
        this.c = new int[charSequenceArr.length];
        Resources resources = getResources();
        int dimensionPixelSize = JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_15dp);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.navi_dimens_10dp);
        Context context = getContext();
        if (charSequenceArr.length > 1) {
            this.h = new View[charSequenceArr.length - 1];
        }
        for (int i = 0; i < charSequenceArr.length; i++) {
            if (this.e) {
                radioButton = (RadioButton) b.a(context, R.layout.bnav_layout_setting_radio_button_item, this, false);
            } else {
                radioButton = (RadioButton) from.inflate(R.layout.bnav_layout_setting_radio_button_item, (ViewGroup) this, false);
            }
            RadioGroup.LayoutParams layoutParams = (RadioGroup.LayoutParams) radioButton.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new RadioGroup.LayoutParams(0, -1, 1.0f);
                layoutParams.gravity = 17;
            }
            radioButton.setTextSize(0, dimensionPixelSize);
            this.c[i] = a(getContext(), resources, i);
            radioButton.setId(this.c[i]);
            radioButton.setText(charSequenceArr[i]);
            addView(radioButton, layoutParams);
            this.f7611a[i] = radioButton;
            radioButton.setClickable(true);
            if (i != charSequenceArr.length - 1) {
                View view = new View(getContext());
                RadioGroup.LayoutParams layoutParams2 = new RadioGroup.LayoutParams(1, -1);
                layoutParams2.bottomMargin = dimensionPixelSize2;
                layoutParams2.topMargin = dimensionPixelSize2;
                if (this.e) {
                    b.a(view, R.color.nsdk_rg_radio_btn_line);
                } else {
                    view.setBackgroundColor(JarUtils.getResources().getColor(R.color.nsdk_rg_radio_btn_line));
                }
                addView(view, layoutParams2);
                this.h[i] = view;
            }
        }
        setOnCheckedChangeListener(this);
    }

    private int a(Context context, Resources resources, int i) {
        return resources.getIdentifier("motor_text_radio_button_" + i, "id", context.getPackageName());
    }

    public void a(int i) {
        RadioButton[] radioButtonArr = this.f7611a;
        if (radioButtonArr != null && i >= 0 && i < radioButtonArr.length) {
            g gVar = g.COMMON;
            if (gVar.d()) {
                gVar.e("BNSettingNewTextRadioGr", "updateChecked position: " + i + ", mCheckedPosition:" + this.g);
            }
            if (i != this.g) {
                this.g = i;
                this.f7611a[i].setChecked(true);
                b(i);
                return;
            }
            return;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BNSettingNewTextRadioGr", "updateChecked failed, position:" + i);
        }
    }
}
