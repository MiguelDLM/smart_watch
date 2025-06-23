package com.octopus.ad.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.octopus.ad.R;

/* loaded from: classes11.dex */
public class ShakeView extends LinearLayout {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public String f19382IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public TextView f19383Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public AnimationDrawable f19384Oxx0xo;

    /* renamed from: XO, reason: collision with root package name */
    public boolean f19385XO;

    public ShakeView(Context context, int i, float f, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f19385XO = false;
        oIX0oI(context, i, f);
    }

    public void I0Io() {
        AnimationDrawable animationDrawable = this.f19384Oxx0xo;
        if (animationDrawable != null) {
            animationDrawable.stop();
        }
    }

    public void II0xO0() {
        AnimationDrawable animationDrawable = this.f19384Oxx0xo;
        if (animationDrawable != null) {
            animationDrawable.start();
        }
    }

    public void oIX0oI(Context context, int i, float f) {
        if (this.f19385XO) {
            return;
        }
        this.f19385XO = true;
        setGravity(1);
        setOrientation(1);
        ImageView imageView = new ImageView(context);
        imageView.setBackgroundResource(R.drawable.oct_anim_shake);
        this.f19384Oxx0xo = (AnimationDrawable) imageView.getBackground();
        int i2 = (int) (i * 0.7d);
        addView(imageView, new LinearLayout.LayoutParams(i2, i2));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        TextView textView = new TextView(context);
        this.f19383Oo = textView;
        textView.getPaint().setFakeBoldText(true);
        this.f19383Oo.setGravity(1);
        this.f19383Oo.setTextColor(-1);
        this.f19383Oo.setTextSize(2, f);
        this.f19383Oo.setText(this.f19382IXxxXO);
        this.f19383Oo.setShadowLayer(5.0f, 1.0f, 1.0f, Color.parseColor("#80000000"));
        addView(this.f19383Oo, layoutParams);
    }

    public void setTitleText(String str) {
        this.f19382IXxxXO = str;
        TextView textView = this.f19383Oo;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public ShakeView(Context context, int i, float f, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f19385XO = false;
        oIX0oI(context, i, f);
    }

    public ShakeView(Context context, int i, float f) {
        super(context);
        this.f19385XO = false;
        oIX0oI(context, i, f);
    }
}
