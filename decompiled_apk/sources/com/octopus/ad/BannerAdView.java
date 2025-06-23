package com.octopus.ad;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.octopus.ad.internal.XO;
import com.octopus.ad.internal.view.AdViewImpl;
import oOoIIO0.o00;
import xXoOI00O.II0xO0;

@SuppressLint({"ViewConstructor"})
/* loaded from: classes11.dex */
public class BannerAdView extends FrameLayout {

    /* renamed from: XO, reason: collision with root package name */
    public final AdViewImpl f18568XO;

    /* loaded from: classes11.dex */
    public class oIX0oI implements II0xO0 {
        public oIX0oI() {
        }

        @Override // xXoOI00O.II0xO0
        public void oIX0oI(boolean z) {
            AdViewImpl adViewImpl = BannerAdView.this.f18568XO;
            if (adViewImpl != null) {
                adViewImpl.o0oIxOo();
            }
        }
    }

    public BannerAdView(Context context, AdViewImpl adViewImpl) {
        super(context);
        this.f18568XO = adViewImpl;
        oIX0oI();
    }

    public void II0xO0() {
        XO.II0xO0(this, new oIX0oI());
    }

    public o00 getAdSize() {
        return this.f18568XO.getAdSize();
    }

    public boolean getResizeAdToFitContainer() {
        return false;
    }

    public final void oIX0oI() {
        setBackgroundColor(0);
        setPadding(0, 0, 0, 0);
        addView(this.f18568XO);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        AdViewImpl adViewImpl = this.f18568XO;
        if (adViewImpl != null) {
            adViewImpl.xXxxox0I();
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        o00 o00Var;
        int i3;
        if (getResizeAdToFitContainer()) {
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), 1073741824);
            super.onMeasure(makeMeasureSpec, View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(makeMeasureSpec) / 6, 1073741824));
            return;
        }
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int i4 = 0;
        View childAt = getChildAt(0);
        if (childAt != null && childAt.getVisibility() != 8) {
            measureChild(childAt, i, i2);
            i4 = childAt.getMeasuredWidth();
            i3 = childAt.getMeasuredHeight();
        } else {
            try {
                o00Var = getAdSize();
            } catch (NullPointerException e) {
                com.octopus.ad.internal.utilities.oIX0oI.X0o0xo(com.octopus.ad.internal.utilities.oIX0oI.f18685II0xO0, "Unable to retrieve ad size.", e);
                o00Var = null;
            }
            if (o00Var != null) {
                Context context = getContext();
                int oxoX2 = o00Var.oxoX(context);
                i3 = o00Var.II0xO0(context);
                i4 = oxoX2;
            } else {
                i3 = 0;
            }
        }
        int max = Math.max(i4, getSuggestedMinimumWidth());
        int max2 = Math.max(i3, getSuggestedMinimumHeight());
        if (mode == 1073741824) {
            max = View.MeasureSpec.getSize(i);
        }
        if (mode2 == 1073741824) {
            max2 = View.MeasureSpec.getSize(i2);
        }
        setMeasuredDimension(View.resolveSize(max, i), View.resolveSize(max2, i2));
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        if (i == 8) {
            this.f18568XO.IIX0o();
        } else {
            this.f18568XO.ooXIXxIX();
        }
    }
}
