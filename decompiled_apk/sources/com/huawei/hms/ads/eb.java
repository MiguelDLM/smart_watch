package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.hms.ads.common.inter.LoaderCommonInter;

/* loaded from: classes10.dex */
public class eb implements LoaderCommonInter {
    private static final String Code = "LoaderCommonHandler";
    private static eb V;
    private static final byte[] Z = new byte[0];
    private Context I;

    private eb(Context context) {
        this.I = context;
    }

    public static eb Code(Context context) {
        return V(context);
    }

    private static eb V(Context context) {
        eb ebVar;
        synchronized (Z) {
            try {
                if (V == null) {
                    V = new eb(context);
                }
                ebVar = V;
            } catch (Throwable th) {
                throw th;
            }
        }
        return ebVar;
    }

    @Override // com.huawei.hms.ads.common.inter.LoaderCommonInter
    public boolean isTrustApp(String str, String str2) {
        return com.huawei.openalliance.ad.constant.cy.Code(this.I, str, str2);
    }

    @Override // com.huawei.hms.ads.common.inter.LoaderCommonInter
    public void saveReportPoint(int i, Integer num, Integer num2) {
        if (fb.Code()) {
            fb.Code(Code, "saveReportPoint");
        }
        cy.Code(this.I, i, num, num2);
    }
}
