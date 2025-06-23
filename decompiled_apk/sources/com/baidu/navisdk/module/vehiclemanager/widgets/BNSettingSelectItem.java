package com.baidu.navisdk.module.vehiclemanager.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.common.LogUtil;

/* loaded from: classes7.dex */
public final class BNSettingSelectItem extends ASettingAddView {
    private TextView g;

    public BNSettingSelectItem(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // com.baidu.navisdk.module.vehiclemanager.widgets.ASettingAddView
    public void a(Context context, AttributeSet attributeSet, boolean z) {
        int color;
        if (context == null) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("MotorSettingLayoutExplainSelect", "init: context == null");
                return;
            }
            return;
        }
        a(context, R.layout.motor_layout_setting_select_item, this, true, z);
        this.e = (TextView) findViewById(R.id.motor_setting_select_item_title);
        this.g = (TextView) findViewById(R.id.motor_setting_select_item_selected_tip);
        if (attributeSet == null) {
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BNSettingSelectItem);
        int i = R.styleable.BNSettingSelectItem_nsdk_explain_item_title;
        if (obtainStyledAttributes.hasValue(i)) {
            this.e.setText(obtainStyledAttributes.getString(i));
        }
        int i2 = R.styleable.BNSettingSelectItem_nsdk_explain_item_tip;
        if (obtainStyledAttributes.hasValue(i2)) {
            this.g.setText(obtainStyledAttributes.getString(i2));
        }
        int i3 = R.styleable.BNSettingSelectItem_nsdk_explain_selected_tip_color;
        if (obtainStyledAttributes.hasValue(i3) && (color = obtainStyledAttributes.getColor(i3, -1)) > 0) {
            this.g.setTextColor(color);
        }
        obtainStyledAttributes.recycle();
    }

    @Override // com.baidu.navisdk.module.vehiclemanager.widgets.ASettingAddView
    public int getTitleId() {
        return R.id.motor_setting_select_item_title;
    }

    public BNSettingSelectItem(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
