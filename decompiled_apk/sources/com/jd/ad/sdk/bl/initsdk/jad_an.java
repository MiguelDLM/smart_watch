package com.jd.ad.sdk.bl.initsdk;

import com.jd.ad.sdk.bl.initsdk.JADYunSdk;

/* loaded from: classes10.dex */
public class jad_an implements Runnable {
    public jad_an(JADYunSdk.jad_cp jad_cpVar) {
    }

    @Override // java.lang.Runnable
    public void run() {
        JADInitCallback jADInitCallback;
        JADInitCallback jADInitCallback2;
        jADInitCallback = JADYunSdk.mInitCallback;
        if (jADInitCallback != null) {
            jADInitCallback2 = JADYunSdk.mInitCallback;
            jADInitCallback2.onInitSuccess();
        }
    }
}
