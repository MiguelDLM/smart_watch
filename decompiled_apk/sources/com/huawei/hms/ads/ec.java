package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.hms.ads.common.inter.LoaderSpHandlerInter;

/* loaded from: classes10.dex */
public class ec implements LoaderSpHandlerInter {
    private static ec Code;
    private static final byte[] I = new byte[0];
    private static ed V;

    private ec(Context context) {
        V = ed.Code(context);
    }

    public static ec Code(Context context) {
        return V(context);
    }

    private static ec V(Context context) {
        ec ecVar;
        synchronized (I) {
            try {
                if (Code == null) {
                    Code = new ec(context);
                }
                ecVar = Code;
            } catch (Throwable th) {
                throw th;
            }
        }
        return ecVar;
    }

    @Override // com.huawei.hms.ads.common.inter.LoaderSpHandlerInter
    public long getKitloaderLastCheckTime() {
        return V.ao();
    }

    @Override // com.huawei.hms.ads.common.inter.LoaderSpHandlerInter
    public int getLoaderEngin2KitUpdate(String str) {
        return V.L(str);
    }

    @Override // com.huawei.hms.ads.common.inter.LoaderSpHandlerInter
    public int getLoaderEngineInterval(String str) {
        return V.a(str);
    }

    @Override // com.huawei.hms.ads.common.inter.LoaderSpHandlerInter
    public boolean getLoaderEngineUpdate(String str) {
        return V.D(str);
    }

    @Override // com.huawei.hms.ads.common.inter.LoaderSpHandlerInter
    public void setKitloaderLastCheckTime(long j) {
        V.Z(j);
    }
}
