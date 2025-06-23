package com.jd.ad.sdk.jad_js;

import android.content.Context;
import java.util.concurrent.Callable;

/* loaded from: classes10.dex */
public class jad_jw implements Callable<jad_sf<jad_jt>> {
    public final /* synthetic */ Context jad_an;
    public final /* synthetic */ String jad_bo;
    public final /* synthetic */ String jad_cp;

    public jad_jw(Context context, String str, String str2) {
        this.jad_an = context;
        this.jad_bo = str;
        this.jad_cp = str2;
    }

    @Override // java.util.concurrent.Callable
    public jad_sf<jad_jt> call() {
        return jad_hu.jad_an(this.jad_an, this.jad_bo, this.jad_cp);
    }
}
