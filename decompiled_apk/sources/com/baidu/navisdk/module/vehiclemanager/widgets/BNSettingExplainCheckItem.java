package com.baidu.navisdk.module.vehiclemanager.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.CheckBox;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.common.LogUtil;

/* loaded from: classes7.dex */
public final class BNSettingExplainCheckItem extends ASettingAddView {
    private CheckBox g;

    public BNSettingExplainCheckItem(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // com.baidu.navisdk.module.vehiclemanager.widgets.ASettingAddView
    public void a(Context context, AttributeSet attributeSet, boolean z) {
        if (context == null) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("MotorSettingLayoutExplainCheck", "init: context == null");
                return;
            }
            return;
        }
        a(context, R.layout.motor_layout_setting_explain_check_item, this, true, z);
        this.e = (TextView) findViewById(R.id.motor_setting_check_item_title);
        this.f = (TextView) findViewById(R.id.motor_setting_check_item_explain);
        this.g = (CheckBox) findViewById(R.id.motor_setting_check_item_checkbox);
        if (attributeSet == null) {
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BNSettingExplainCheckItem);
        int i = R.styleable.BNSettingExplainCheckItem_nsdk_explain_item_title;
        if (obtainStyledAttributes.hasValue(i)) {
            this.e.setText(obtainStyledAttributes.getString(i));
        }
        int i2 = R.styleable.BNSettingExplainCheckItem_nsdk_explain_item_tip;
        if (obtainStyledAttributes.hasValue(i2)) {
            this.f.setText(obtainStyledAttributes.getString(i2));
        }
        obtainStyledAttributes.recycle();
    }

    @Override // com.baidu.navisdk.module.vehiclemanager.widgets.ASettingAddView
    public int getTitleId() {
        return R.id.motor_setting_check_item_title;
    }

    public void setCheckBox(boolean z) {
        CheckBox checkBox = this.g;
        if (checkBox != null) {
            checkBox.setChecked(z);
        }
    }

    public BNSettingExplainCheckItem(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
