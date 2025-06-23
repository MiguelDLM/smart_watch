package com.baidu.navisdk.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes8.dex */
public class BNPowerPlateTextView extends FrameLayout {
    private TextView mPlateNumberText;
    private TextView mProvinceText;

    public BNPowerPlateTextView(Context context) {
        this(context, null);
    }

    public String getText() {
        return this.mProvinceText.getText().toString() + this.mPlateNumberText.getText().toString();
    }

    public void setText(String str) {
        if (TextUtils.isEmpty(str)) {
            this.mProvinceText.setVisibility(8);
            this.mPlateNumberText.setText("车牌号待补充");
            this.mPlateNumberText.setPadding(0, 0, 0, 0);
            this.mPlateNumberText.setBackground(null);
            return;
        }
        this.mProvinceText.setVisibility(0);
        this.mProvinceText.setText(str.substring(0, 1));
        this.mPlateNumberText.setText(str.substring(1));
        TextView textView = this.mPlateNumberText;
        Resources resources = JarUtils.getResources();
        int i = R.dimen.navi_dimens_5dp;
        textView.setPadding(resources.getDimensionPixelSize(i), 0, JarUtils.getResources().getDimensionPixelSize(i), 0);
        this.mPlateNumberText.setBackground(JarUtils.getResources().getDrawable(R.drawable.bnav_drawable_plate_number_bg));
    }

    public BNPowerPlateTextView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public BNPowerPlateTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        View inflate = LayoutInflater.from(context).inflate(R.layout.nsdk_layout_plate_text_view, this);
        this.mProvinceText = (TextView) inflate.findViewById(R.id.tv_plate_province);
        this.mPlateNumberText = (TextView) inflate.findViewById(R.id.tv_plate_number);
    }
}
