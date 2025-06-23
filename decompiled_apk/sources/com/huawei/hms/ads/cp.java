package com.huawei.hms.ads;

import android.content.Context;

/* loaded from: classes10.dex */
public class cp extends cm {
    private static cv I;
    private static final byte[] Z = new byte[0];
    private com.huawei.openalliance.ad.utils.l B;

    private cp(Context context) {
        super(context);
        this.B = new com.huawei.openalliance.ad.utils.l(context);
    }

    private static cv I(Context context) {
        cv cvVar;
        synchronized (Z) {
            try {
                if (I == null) {
                    I = new cp(context);
                }
                cvVar = I;
            } catch (Throwable th) {
                throw th;
            }
        }
        return cvVar;
    }

    public static cv V(Context context) {
        return I(context);
    }

    @Override // com.huawei.hms.ads.cm, com.huawei.hms.ads.cv
    public boolean Code() {
        return "CN".equalsIgnoreCase(this.B.Code());
    }

    @Override // com.huawei.hms.ads.cm, com.huawei.hms.ads.cv
    public boolean I() {
        return false;
    }

    @Override // com.huawei.hms.ads.cm, com.huawei.hms.ads.cv
    public boolean V() {
        return Code();
    }
}
