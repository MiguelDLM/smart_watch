package com.huawei.openalliance.ad.inter;

import com.huawei.hms.ads.fb;
import com.huawei.hms.ads.s;

/* loaded from: classes10.dex */
public class b {
    private static final String Code = "AdATManager";
    private static b I;
    private static final byte[] V = new byte[0];
    private String B;
    private s Z;

    private b() {
    }

    public static b Code() {
        b bVar;
        synchronized (V) {
            try {
                if (I == null) {
                    I = new b();
                }
                bVar = I;
            } catch (Throwable th) {
                throw th;
            }
        }
        return bVar;
    }

    public String I() {
        return this.B;
    }

    public String V() {
        s sVar = this.Z;
        if (sVar != null) {
            return sVar.Code();
        }
        fb.V(Code, "accessTokenProvider is null, return");
        return null;
    }

    public void Code(s sVar) {
        this.Z = sVar;
    }

    public void Code(String str) {
        this.B = str;
    }
}
