package com.jd.ad.sdk.jad_mz;

/* loaded from: classes10.dex */
public class jad_fs implements Runnable {
    public final /* synthetic */ String jad_an;

    public jad_fs(String str) {
        this.jad_an = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!com.jd.ad.sdk.jad_tg.jad_an.jad_bo) {
            jad_er.jad_an(this.jad_an);
        }
    }
}
