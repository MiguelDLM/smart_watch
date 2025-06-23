package com.octopus.ad.widget;

import XIXIX.OOXIXo;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import x0.I0oOoX;

/* loaded from: classes11.dex */
public class RegionClickView extends LinearLayout {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public TextView f19355IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public GradientDrawable f19356Oo;

    /* renamed from: XO, reason: collision with root package name */
    public boolean f19357XO;

    public RegionClickView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f19357XO = false;
        II0xO0(context);
    }

    public void I0Io(String str, float f) {
        setTitle(str);
        setTitleColor("#FFFFFF");
        setTitleSize(f * 14.0f);
        setBackGroundAlpha(0.7d);
        setBackgroundColor("#80000000");
    }

    public void II0xO0(Context context) {
        if (this.f19357XO) {
            return;
        }
        this.f19357XO = true;
        oIX0oI(context, 1);
        TextView textView = new TextView(context);
        this.f19355IXxxXO = textView;
        textView.getPaint().setFakeBoldText(true);
        this.f19355IXxxXO.setLines(1);
        this.f19355IXxxXO.setTextSize(2, 14.0f);
        this.f19355IXxxXO.setTextColor(Color.parseColor("#949494"));
        this.f19355IXxxXO.setText("点击跳转至第三方应用或详情页");
        this.f19355IXxxXO.setGravity(17);
        setGravity(17);
        setOrientation(1);
        addView(this.f19355IXxxXO);
    }

    public final void oIX0oI(Context context, int i) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        this.f19356Oo = gradientDrawable;
        gradientDrawable.setColor(Color.parseColor("#80000000"));
        if (i == 1) {
            this.f19356Oo.setStroke(1, Color.parseColor("#E8E8E8"));
        }
        this.f19356Oo.setCornerRadius(I0oOoX.x0XOIxOo(context, 30.0f));
        setBackgroundDrawable(this.f19356Oo);
    }

    public void setBackGroundAlpha(double d) {
        GradientDrawable gradientDrawable = this.f19356Oo;
        if (gradientDrawable != null && d > OOXIXo.f3760XO) {
            gradientDrawable.setAlpha((int) (d * 255.0d));
        }
    }

    public void setBackgroundColor(String str) {
        GradientDrawable gradientDrawable = this.f19356Oo;
        if (gradientDrawable != null && str != null) {
            try {
                gradientDrawable.setColor(Color.parseColor(str));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void setTitle(String str) {
        TextView textView = this.f19355IXxxXO;
        if (textView != null && str != null) {
            try {
                textView.setText(str);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void setTitleColor(String str) {
        TextView textView = this.f19355IXxxXO;
        if (textView != null && str != null) {
            try {
                textView.setTextColor(Color.parseColor(str));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void setTitleSize(float f) {
        TextView textView = this.f19355IXxxXO;
        if (textView != null && f > 0.0f) {
            textView.setTextSize(2, f);
        }
    }

    public RegionClickView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f19357XO = false;
        II0xO0(context);
    }

    public RegionClickView(Context context) {
        super(context);
        this.f19357XO = false;
        II0xO0(context);
    }
}
