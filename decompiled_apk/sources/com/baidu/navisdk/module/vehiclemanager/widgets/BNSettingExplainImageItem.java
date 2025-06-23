package com.baidu.navisdk.module.vehiclemanager.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.imageloader.ImageLoader;
import com.baidu.navisdk.ui.util.b;
import com.baidu.navisdk.util.common.LogUtil;

/* loaded from: classes7.dex */
public class BNSettingExplainImageItem extends ASettingAddView {
    private ImageView g;
    private ImageView h;
    private boolean i;
    private TextView j;

    public BNSettingExplainImageItem(Context context) {
        this(context, null);
    }

    @Override // com.baidu.navisdk.module.vehiclemanager.widgets.ASettingAddView
    public void a(Context context, AttributeSet attributeSet, boolean z) {
        ConstraintLayout.LayoutParams layoutParams;
        int resourceId;
        if (context == null) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("MotorSettingLayoutExplainImage", "init: context == null");
                return;
            }
            return;
        }
        a(context, R.layout.motor_layout_setting_explain_image_item, this, true, z);
        this.e = (TextView) findViewById(R.id.motor_setting_select_item_title);
        this.j = (TextView) findViewById(R.id.motor_setting_select_item_title2);
        this.f = (TextView) findViewById(R.id.motor_setting_select_item_explain);
        this.g = (ImageView) findViewById(R.id.motor_setting_select_item_image);
        this.h = (ImageView) findViewById(R.id.motor_setting_select_item_tip_img);
        if (attributeSet == null) {
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BNSettingExplainImageItem);
        int i = R.styleable.BNSettingExplainImageItem_nsdk_explain_item_title;
        if (obtainStyledAttributes.hasValue(i)) {
            this.e.setText(obtainStyledAttributes.getString(i));
        }
        int i2 = R.styleable.BNSettingExplainImageItem_nsdk_explain_item_tip;
        if (obtainStyledAttributes.hasValue(i2)) {
            this.f.setText(obtainStyledAttributes.getString(i2));
        }
        int i3 = R.styleable.BNSettingExplainImageItem_nsdk_explain_item_img_width;
        int dimensionPixelSize = obtainStyledAttributes.hasValue(i3) ? obtainStyledAttributes.getDimensionPixelSize(i3, -2) : -2;
        int i4 = R.styleable.BNSettingExplainImageItem_nsdk_explain_item_img_height;
        int dimensionPixelSize2 = obtainStyledAttributes.hasValue(i4) ? obtainStyledAttributes.getDimensionPixelSize(i4, -2) : -2;
        if ((dimensionPixelSize != -2 || dimensionPixelSize2 != -2) && (layoutParams = (ConstraintLayout.LayoutParams) this.h.getLayoutParams()) != null) {
            ((ViewGroup.MarginLayoutParams) layoutParams).width = dimensionPixelSize;
            ((ViewGroup.MarginLayoutParams) layoutParams).height = dimensionPixelSize2;
        }
        int i5 = R.styleable.BNSettingExplainImageItem_nsdk_explain_item_src;
        if (obtainStyledAttributes.hasValue(i5) && (resourceId = obtainStyledAttributes.getResourceId(i5, 0)) > 0) {
            this.h.setImageResource(resourceId);
        }
        int i6 = R.styleable.BNSettingExplainImageItem_nsdk_explain_title2_color;
        if (obtainStyledAttributes.hasValue(i6)) {
            this.j.setTextColor(obtainStyledAttributes.getColor(i6, -1));
        }
        obtainStyledAttributes.recycle();
    }

    @Override // com.baidu.navisdk.module.vehiclemanager.widgets.ASettingAddView
    public int getTitleId() {
        return R.id.motor_setting_select_item_title2;
    }

    public void setTipImage(@DrawableRes int i) {
        ImageView imageView = this.h;
        if (imageView != null) {
            imageView.setImageResource(i);
        }
    }

    public void setTipImageVisibility(int i) {
        ImageView imageView = this.h;
        if (imageView != null) {
            imageView.setVisibility(i);
        }
    }

    public void setTitle2(CharSequence charSequence) {
        if (this.j == null) {
            return;
        }
        if (TextUtils.isEmpty(charSequence)) {
            this.j.setVisibility(8);
        } else {
            this.j.setText(charSequence);
            this.j.setVisibility(0);
        }
    }

    public void setTitle2Color(int i) {
        TextView textView = this.j;
        if (textView == null) {
            return;
        }
        textView.setTextColor(i);
    }

    public BNSettingExplainImageItem(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BNSettingExplainImageItem(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.i = true;
    }

    public void setTipImage(String str) {
        if (this.h == null || TextUtils.isEmpty(str)) {
            return;
        }
        ImageLoader.with(getContext()).load(str).into(this.h);
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
        ImageView imageView = this.g;
        if (imageView != null) {
            imageView.setImageDrawable(b.f(R.drawable.nsdk_drawable_common_ic_setting_right_arrow));
        }
    }
}
