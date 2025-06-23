package com.huawei.openalliance.ad.ipc;

import android.content.ComponentName;
import android.content.Context;

/* loaded from: classes10.dex */
public class d extends g {
    private static d B = null;
    private static final byte[] C = new byte[0];
    private static final String Z = "ExPPSApiServiceManager";

    private d(Context context) {
        super(context);
    }

    public static d Code(Context context) {
        d dVar;
        synchronized (C) {
            try {
                if (B == null) {
                    B = new d(context);
                }
                dVar = B;
            } catch (Throwable th) {
                throw th;
            }
        }
        return dVar;
    }

    @Override // com.huawei.openalliance.ad.ipc.g, com.huawei.openalliance.ad.ipc.c
    public String V() {
        return Z;
    }

    @Override // com.huawei.openalliance.ad.ipc.g, com.huawei.openalliance.ad.ipc.c
    public String Z() {
        return com.huawei.openalliance.ad.utils.g.I(this.V);
    }

    @Override // com.huawei.openalliance.ad.ipc.g, com.huawei.openalliance.ad.ipc.c
    public void Code(ComponentName componentName) {
    }
}
