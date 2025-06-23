package com.kwad.components.ad.splashscreen.presenter.playcard;

import android.content.Context;
import com.google.firebase.crashlytics.buildtools.ndk.internal.elf.EMachine;
import com.kwad.sdk.utils.ad;

/* loaded from: classes11.dex */
public final class c {
    private ad Fk;
    private ad Fl;
    private ad Fm;
    private ad Fn;
    private ad Fo;
    private ad Fp;
    private float Fa = 1.0f;
    private int Fq = 34;
    private int Fr = 19;
    private int Fs = 8;
    private int Ft = 12;

    public static c c(float f) {
        c cVar = new c();
        cVar.Fk = ad.a(174, 0, 0, 0, 0, 0);
        cVar.Fl = ad.a(33, 33, 0, 0, 0, 0);
        cVar.Fm = ad.a(0, 26, 0, 11, 0, 0);
        cVar.Fn = ad.a(174, EMachine.EM_MANIK, 0, 6, 0, 0);
        cVar.Fo = ad.a(0, 0, 0, 6, 0, 0);
        cVar.Fp = ad.a(0, 0, 0, 7, 0, 0);
        cVar.Fq = 21;
        cVar.Fr = 12;
        cVar.Fs = 6;
        cVar.Fa = f;
        cVar.Ft = 8;
        return cVar;
    }

    public static c lZ() {
        c cVar = new c();
        cVar.Fk = ad.a(278, 0, 0, 0, 0, 0);
        cVar.Fl = ad.a(53, 53, 0, 0, 0, 0);
        cVar.Fm = ad.a(0, 43, 0, 11, 0, 0);
        cVar.Fn = ad.a(278, 274, 0, 8, 0, 0);
        cVar.Fo = ad.a(0, 0, 0, 8, 0, 0);
        cVar.Fp = ad.a(0, 0, 0, 10, 0, 0);
        return cVar;
    }

    public final ad S(Context context) {
        return this.Fk.c(context, this.Fa);
    }

    public final ad T(Context context) {
        return this.Fl.c(context, this.Fa);
    }

    public final ad U(Context context) {
        return this.Fm.c(context, this.Fa);
    }

    public final ad V(Context context) {
        return this.Fn.c(context, this.Fa);
    }

    public final ad W(Context context) {
        return this.Fo.c(context, this.Fa);
    }

    public final ad X(Context context) {
        return this.Fp.c(context, this.Fa);
    }

    public final int Y(Context context) {
        return (int) (com.kwad.sdk.c.a.a.b(context, this.Fq) * this.Fa);
    }

    public final int Z(Context context) {
        return (int) (com.kwad.sdk.c.a.a.b(context, this.Fr) * this.Fa);
    }

    public final int aa(Context context) {
        return (int) (com.kwad.sdk.c.a.a.b(context, this.Fs) * this.Fa);
    }

    public final int ma() {
        return this.Ft;
    }
}
