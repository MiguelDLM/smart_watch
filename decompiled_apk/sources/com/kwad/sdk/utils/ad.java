package com.kwad.sdk.utils;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes11.dex */
public final class ad extends be {
    private int aQs;
    private int aQt;
    private int aQu;
    private int aQv;

    public ad(int i, int i2) {
        super(i, i2);
    }

    private int MH() {
        return this.aQs;
    }

    private int MI() {
        return this.aQt;
    }

    private int MJ() {
        return this.aQu;
    }

    private int MK() {
        return this.aQv;
    }

    public static ad a(int i, int i2, int i3, int i4, int i5, int i6) {
        ad adVar = new ad(i, i2);
        adVar.ed(0);
        adVar.ee(0);
        adVar.eb(i4);
        adVar.ec(0);
        return adVar;
    }

    private void ec(int i) {
        this.aQt = i;
    }

    public final ad c(Context context, float f) {
        ad adVar = new ad(com.kwad.sdk.c.a.a.a(context, this.mWidth * f), com.kwad.sdk.c.a.a.a(context, this.mHeight * f));
        adVar.aQu = com.kwad.sdk.c.a.a.a(context, this.aQu * f);
        adVar.aQt = com.kwad.sdk.c.a.a.a(context, this.aQt * f);
        adVar.aQv = com.kwad.sdk.c.a.a.a(context, this.aQv * f);
        adVar.aQs = com.kwad.sdk.c.a.a.a(context, this.aQs * f);
        return adVar;
    }

    public final void eb(int i) {
        this.aQs = i;
    }

    public final void ed(int i) {
        this.aQu = i;
    }

    public final void ee(int i) {
        this.aQv = i;
    }

    public static void a(View view, ad adVar) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (adVar.getHeight() > 0) {
            layoutParams.height = adVar.getHeight();
        }
        if (adVar.getWidth() > 0) {
            layoutParams.width = adVar.getWidth();
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            if (adVar.MJ() > 0) {
                marginLayoutParams.leftMargin = adVar.MJ();
            }
            if (adVar.MI() > 0) {
                marginLayoutParams.bottomMargin = adVar.MI();
            }
            if (adVar.MK() > 0) {
                marginLayoutParams.rightMargin = adVar.MK();
            }
            if (adVar.MH() > 0) {
                marginLayoutParams.topMargin = adVar.MH();
            }
        }
        view.setLayoutParams(layoutParams);
    }
}
