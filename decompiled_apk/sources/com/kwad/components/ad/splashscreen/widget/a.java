package com.kwad.components.ad.splashscreen.widget;

import android.content.Context;
import com.kwad.sdk.utils.ad;

/* loaded from: classes11.dex */
public final class a {
    private float Fa;
    private int Gm;
    private int Gn;
    private int Go;
    private int Gp;
    private int Gq;
    private int Gr;
    private Context mContext;

    private a(Context context) {
        this.Gm = 24;
        this.Gn = 12;
        this.Go = 16;
        this.Gp = 12;
        this.Gq = 6;
        this.Gr = 4;
        this.Fa = 1.0f;
        this.mContext = context;
    }

    public static a af(Context context) {
        return new a(context);
    }

    public static a ag(Context context) {
        return new a(context, 17, 10, 12, 8, 4, 3);
    }

    public final void d(float f) {
        this.Fa = f;
    }

    public final ad lO() {
        return new ad(0, (int) (com.kwad.sdk.c.a.a.a(this.mContext, this.Gm) * this.Fa));
    }

    public final int ml() {
        return (int) (((this.Gm - this.Go) / 2) * this.Fa);
    }

    public final int mm() {
        return (int) (this.Gp * this.Fa);
    }

    public final ad mn() {
        int a2 = (int) (com.kwad.sdk.c.a.a.a(this.mContext, this.Gq) * this.Fa);
        int a3 = (int) (com.kwad.sdk.c.a.a.a(this.mContext, this.Gr) * this.Fa);
        ad adVar = new ad(0, 0);
        adVar.ed(a2);
        adVar.ee(a3);
        return adVar;
    }

    public final int mo() {
        return (int) (com.kwad.sdk.c.a.a.b(this.mContext, this.Gn) * this.Fa);
    }

    public final float mp() {
        return (com.kwad.sdk.c.a.a.a(this.mContext, this.Gm) * this.Fa) / 2.0f;
    }

    public final ad mq() {
        int a2 = (int) (com.kwad.sdk.c.a.a.a(this.mContext, this.Go) * this.Fa);
        return new ad(a2, a2);
    }

    private a(Context context, int i, int i2, int i3, int i4, int i5, int i6) {
        this.Fa = 1.0f;
        this.mContext = context;
        this.Gm = 17;
        this.Gn = 10;
        this.Go = 12;
        this.Gp = 8;
        this.Gq = 4;
        this.Gr = 3;
    }
}
