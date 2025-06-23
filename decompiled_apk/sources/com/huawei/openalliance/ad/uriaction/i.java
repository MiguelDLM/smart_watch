package com.huawei.openalliance.ad.uriaction;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import com.huawei.hms.ads.fb;
import com.huawei.hms.ads.jc;
import com.huawei.hms.ads.jn;
import com.huawei.openalliance.ad.constant.ai;
import com.huawei.openalliance.ad.constant.v;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import java.util.Map;

/* loaded from: classes10.dex */
public class i extends p {
    private static final String C = "HwMarketAction";
    public static final String Code = "appId";
    private static final String F = "com.huawei.appmarket";
    private static final String S = "com.huawei.appmarket.appmarket.intent.action.AppDetail.withid";
    public static final String V = "thirdId";
    private String D;
    private String L;

    public i(Context context, AdContentData adContentData, Map<String, String> map) {
        super(context, adContentData);
        this.D = map.get(Code);
        this.L = map.get(V);
    }

    private void Z() {
        jc.Code(this.I, this.Z, ai.D, (Integer) 3, Integer.valueOf(com.huawei.openalliance.ad.utils.g.Code(this.I, "com.huawei.appmarket") ? 2 : 1));
    }

    @Override // com.huawei.openalliance.ad.uriaction.p
    public boolean Code() {
        fb.V(C, "handle hw app market action");
        Intent intent = new Intent(S);
        intent.setPackage("com.huawei.appmarket");
        intent.putExtra(Code, this.D);
        intent.putExtra(V, this.L);
        intent.addFlags(268435456);
        try {
            PackageManager packageManager = this.I.getPackageManager();
            if (packageManager != null && !packageManager.queryIntentActivities(intent, 65536).isEmpty()) {
                jn.a aVar = new jn.a();
                aVar.Code(this.Z).Code(intent);
                com.huawei.openalliance.ad.utils.g.Code(this.I, intent, aVar.Code());
                Code(v.Code);
                jc.Code(this.I, this.Z, "intentSuccess", (Integer) 3, (Integer) null);
                return true;
            }
        } catch (ActivityNotFoundException unused) {
            fb.Z(C, "fail to open market detail page");
        }
        Z();
        return V();
    }
}
