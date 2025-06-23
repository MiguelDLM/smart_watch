package com.baidu.navisdk.ui.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.jar.JarUtils;
import com.bumptech.glide.Glide;

/* loaded from: classes8.dex */
public class BNTabLabelTextView extends FrameLayout {
    private final ImageView labelIcon;
    private final LinearLayout labelLayout;
    private final TextView labelPartA;
    private final TextView labelPartB;
    private final TextView labelText;

    public BNTabLabelTextView(@NonNull Context context) {
        this(context, null);
    }

    public void setBackgroundColor(String str) {
        if (this.labelText.getVisibility() == 0) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(Color.parseColor(str));
            gradientDrawable.setCornerRadius(JarUtils.getResources().getDimension(R.dimen.navi_dimens_2dp));
            gradientDrawable.setShape(0);
            this.labelText.setBackground(gradientDrawable);
        }
        if (this.labelLayout.getVisibility() == 0) {
            float dimension = JarUtils.getResources().getDimension(R.dimen.navi_dimens_2dp);
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setColor(Color.parseColor(str));
            gradientDrawable2.setCornerRadii(new float[]{dimension, dimension, 0.0f, 0.0f, 0.0f, 0.0f, dimension, dimension});
            gradientDrawable2.setShape(0);
            this.labelPartA.setBackground(gradientDrawable2);
            GradientDrawable gradientDrawable3 = new GradientDrawable();
            gradientDrawable3.setStroke(1, Color.parseColor(str));
            gradientDrawable2.setCornerRadii(new float[]{0.0f, 0.0f, dimension, dimension, dimension, dimension, 0.0f, 0.0f});
            gradientDrawable3.setShape(0);
            this.labelPartB.setBackground(gradientDrawable3);
        }
    }

    public void setLabelIcon(String str) {
        if (TextUtils.isEmpty(str)) {
            this.labelIcon.setVisibility(8);
        } else {
            this.labelIcon.setVisibility(0);
            Glide.with(getContext()).load(str).into(this.labelIcon);
        }
    }

    public void setText(String str) {
        g gVar = g.COMMON_UI;
        if (gVar.d()) {
            gVar.e("label title = " + str);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.labelLayout.setVisibility(8);
        this.labelText.setVisibility(0);
        this.labelText.setText(str);
    }

    public void setTextColor(int i) {
        if (this.labelText.getVisibility() == 0) {
            this.labelText.setTextColor(i);
        }
        if (this.labelLayout.getVisibility() == 0) {
            this.labelPartA.setTextColor(i);
            this.labelPartB.setTextColor(i);
        }
    }

    public BNTabLabelTextView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public BNTabLabelTextView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        View inflate = LayoutInflater.from(context).inflate(R.layout.bnav_layout_route_tab_label_view, this);
        this.labelIcon = (ImageView) inflate.findViewById(R.id.label_icon);
        this.labelText = (TextView) inflate.findViewById(R.id.label_title);
        this.labelLayout = (LinearLayout) inflate.findViewById(R.id.label_layout);
        this.labelPartA = (TextView) inflate.findViewById(R.id.label_partA);
        this.labelPartB = (TextView) inflate.findViewById(R.id.label_partB);
    }

    public void setText(String str, String str2) {
        g gVar = g.COMMON_UI;
        if (gVar.d()) {
            gVar.e("label title = " + str + ", des = " + str2);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!TextUtils.isEmpty(str2)) {
            this.labelText.setVisibility(8);
            this.labelLayout.setVisibility(0);
            this.labelPartA.setText(str);
            this.labelPartB.setText(str2);
            return;
        }
        setText(str);
    }
}
