package com.huawei.hms.ads;

/* loaded from: classes10.dex */
public class eu {
    private static final String Code = "InterstitialGlobalDataShare";
    private static final byte[] I = new byte[0];
    private static et V;

    public static et Code() {
        et etVar;
        synchronized (I) {
            etVar = V;
        }
        return etVar;
    }

    public static void Code(et etVar) {
        synchronized (I) {
            try {
                if (etVar == null) {
                    fb.Code(Code, "set interstitial ad null");
                    V = null;
                } else {
                    V = etVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
