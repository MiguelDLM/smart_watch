package com.huawei.hms.ads;

/* loaded from: classes10.dex */
public abstract class df {
    private static final byte[] I = new byte[0];
    private static com.huawei.openalliance.ad.inter.data.i V;

    public static com.huawei.openalliance.ad.inter.data.i Code() {
        com.huawei.openalliance.ad.inter.data.i iVar;
        synchronized (I) {
            iVar = V;
        }
        return iVar;
    }

    public static void Code(com.huawei.openalliance.ad.inter.data.i iVar) {
        synchronized (I) {
            try {
                if (iVar == null) {
                    fb.Code("GlobalDataShare", "set reward ad null");
                    V = null;
                } else {
                    V = iVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
