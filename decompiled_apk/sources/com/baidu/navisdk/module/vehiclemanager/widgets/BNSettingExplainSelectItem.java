package com.baidu.navisdk.module.vehiclemanager.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.util.b;
import com.baidu.navisdk.util.common.LogUtil;

/* loaded from: classes7.dex */
public final class BNSettingExplainSelectItem extends ASettingAddView {
    private TextView g;
    private ImageView h;
    private boolean i;

    public BNSettingExplainSelectItem(Context context) {
        this(context, null);
    }

    @Override // com.baidu.navisdk.module.vehiclemanager.widgets.ASettingAddView
    public void a(Context context, AttributeSet attributeSet, boolean z) {
        if (context == null) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("MotorSettingLayoutExplainSelect", "init: context == null");
                return;
            }
            return;
        }
        a(context, R.layout.motor_layout_setting_explain_select_item, this, true, z);
        this.e = (TextView) findViewById(R.id.motor_setting_select_item_title);
        this.f = (TextView) findViewById(R.id.motor_setting_select_item_explain);
        this.g = (TextView) findViewById(R.id.motor_setting_select_item_select_tip);
        this.h = (ImageView) findViewById(R.id.motor_setting_select_item_image);
        if (attributeSet == null) {
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BNSettingExplainSelectItem);
        int i = R.styleable.BNSettingExplainSelectItem_nsdk_explain_item_title;
        if (obtainStyledAttributes.hasValue(i)) {
            this.e.setText(obtainStyledAttributes.getString(i));
        }
        int i2 = R.styleable.BNSettingExplainSelectItem_nsdk_explain_item_tip;
        if (obtainStyledAttributes.hasValue(i2)) {
            this.f.setText(obtainStyledAttributes.getString(i2));
        }
        int i3 = R.styleable.BNSettingExplainSelectItem_nsdk_explain_selected_tip_color;
        if (obtainStyledAttributes.hasValue(i3)) {
            this.g.setTextColor(obtainStyledAttributes.getColor(i3, -1));
        }
        obtainStyledAttributes.recycle();
    }

    @Override // com.baidu.navisdk.module.vehiclemanager.widgets.ASettingAddView
    public int getTitleId() {
        return R.id.motor_setting_select_item_title;
    }

    public BNSettingExplainSelectItem(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BNSettingExplainSelectItem(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.i = true;
    }

    public void a(boolean z) {
        if (this.i == z) {
            return;
        }
        this.i = z;
        TextView textView = this.e;
        if (textView != null) {
            textView.setTextColor(b.a(R.color.nsdk_cl_text_a, z));
        }
        TextView textView2 = this.f;
        if (textView2 != null) {
            textView2.setTextColor(b.a(R.color.nsdk_cl_text_f, z));
        }
        ImageView imageView = this.h;
        if (imageView != null) {
            imageView.setImageDrawable(b.f(R.drawable.nsdk_drawable_common_ic_setting_right_arrow));
        }
    }

    public void a(CharSequence charSequence) {
        if (this.g == null) {
            return;
        }
        if (TextUtils.isEmpty(charSequence)) {
            this.g.setVisibility(8);
        } else {
            this.g.setVisibility(0);
            this.g.setText(charSequence);
        }
    }
}
