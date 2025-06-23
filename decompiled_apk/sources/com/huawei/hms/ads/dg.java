package com.huawei.hms.ads;

/* loaded from: classes10.dex */
public abstract class dg {
    private static final byte[] I = new byte[0];
    private static com.huawei.openalliance.ad.inter.data.l V;

    public static com.huawei.openalliance.ad.inter.data.l Code() {
        com.huawei.openalliance.ad.inter.data.l lVar;
        synchronized (I) {
            lVar = V;
        }
        return lVar;
    }

    public static void Code(com.huawei.openalliance.ad.inter.data.l lVar) {
        synchronized (I) {
            try {
                if (lVar == null) {
                    fb.Code("GlobalDataShare", "set native ad null");
                    V = null;
                } else {
                    V = lVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
