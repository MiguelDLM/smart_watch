package com.huawei.hms.ads;

import android.content.Context;
import com.iab.omid.library.huawei.adsession.AdSessionContext;
import com.iab.omid.library.huawei.adsession.Partner;
import com.iab.omid.library.huawei.adsession.VerificationScriptResource;
import java.io.IOException;
import java.util.List;

/* loaded from: classes10.dex */
public class hb implements hh {
    private static final String Code = "AdSessionContextWrapper";
    private static boolean I = gw.Code(gw.i);
    private static final String V = "Huawei";
    private Context Z;

    public hb(Context context) {
        this.Z = context;
    }

    public AdSessionContext Code(hk hkVar, String str) {
        String str2;
        if (!gw.Code(gw.p) || !gw.Code(gw.q) || !gw.Code(gw.i)) {
            fb.I(Code, "createNativeAdSessionContext, not available ");
            return null;
        }
        List<VerificationScriptResource> V2 = hkVar.V();
        if (V2.isEmpty()) {
            return null;
        }
        try {
            str2 = com.huawei.openalliance.ad.utils.ay.Code("openmeasure/omsdk-v1.js", this.Z);
        } catch (IOException e) {
            fb.I(Code, "getNativeAdSession: " + com.huawei.openalliance.ad.utils.bh.Code(e.getMessage()));
            str2 = null;
        }
        if (str2 == null) {
            return null;
        }
        return AdSessionContext.createNativeAdSessionContext(Partner.createPartner(V, "13.4.72.300"), str2, V2, str, (String) null);
    }

    public static boolean Code() {
        return I;
    }
}
