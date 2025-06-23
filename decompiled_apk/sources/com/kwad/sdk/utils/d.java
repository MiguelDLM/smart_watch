package com.kwad.sdk.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.kwad.sdk.core.download.a.b;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes11.dex */
public final class d {
    private static final Map<String, String> aPh;

    static {
        HashMap hashMap = new HashMap();
        aPh = hashMap;
        hashMap.put("HUAWEI", com.huawei.openalliance.ad.constant.x.Y);
        hashMap.put("OPPO", "com.oppo.market");
        hashMap.put("vivo", "com.bbk.appstore");
        hashMap.put("xiaomi", "com.xiaomi.market");
        hashMap.put("OnePlus", "com.oppo.market");
        hashMap.put("Meizu", "com.meizu.mstore");
        hashMap.put("samsung", "com.sec.android.app.samsungapps");
        hashMap.put("SMARTISAN", "com.smartisanos.appstore");
        hashMap.put("Realme", "com.oppo.market");
        hashMap.put("HONOR", com.huawei.openalliance.ad.constant.x.Y);
    }

    public static boolean a(Context context, final String str, final AdTemplate adTemplate) {
        SceneImpl sceneImpl;
        if (au.MQ() && (sceneImpl = adTemplate.mAdScene) != null && sceneImpl.adStyle != 4) {
            if (TextUtils.isEmpty(str)) {
                com.kwad.sdk.commercial.b.a.a(adTemplate, "com.xiaomi.market", 0, 1);
                return false;
            }
            if (com.kwad.sdk.core.download.a.b.a(context, str, new b.C0852b() { // from class: com.kwad.sdk.utils.d.1
                @Override // com.kwad.sdk.core.download.a.b.C0852b, com.kwad.sdk.core.download.a.b.a
                public final void onError(Throwable th) {
                    super.onError(th);
                    com.kwad.sdk.commercial.b.a.a(AdTemplate.this, str, "com.xiaomi.market", 0, 1, bo.t(th));
                }

                @Override // com.kwad.sdk.core.download.a.b.C0852b, com.kwad.sdk.core.download.a.b.a
                public final void onStart() {
                    super.onStart();
                    com.kwad.sdk.commercial.b.a.a(AdTemplate.this, str, "com.xiaomi.market", 0, 1);
                }

                @Override // com.kwad.sdk.core.download.a.b.C0852b, com.kwad.sdk.core.download.a.b.a
                public final void onSuccess() {
                    super.onSuccess();
                    AdTemplate adTemplate2 = AdTemplate.this;
                    adTemplate2.mXiaomiAppStoreDetailViewOpen = true;
                    adTemplate2.mClickOpenAppStore = true;
                    com.kwad.sdk.commercial.b.a.b(adTemplate2, str, "com.xiaomi.market", 0, 1);
                }
            }) == 1) {
                return true;
            }
        }
        return false;
    }

    private static boolean gz(String str) {
        if ("OPPO".equals(Build.BRAND) && "com.heytap.market".equals(str)) {
            return true;
        }
        return false;
    }

    public static boolean h(Context context, AdTemplate adTemplate) {
        String str;
        int i;
        AdInfo dS = com.kwad.sdk.core.response.b.e.dS(adTemplate);
        String cR = com.kwad.sdk.core.response.b.a.cR(dS);
        String ax = com.kwad.sdk.core.response.b.a.ax(dS);
        Map<String, String> map = aPh;
        String str2 = Build.BRAND;
        String str3 = map.get(str2);
        if (context == null) {
            return false;
        }
        if (TextUtils.isEmpty(cR)) {
            com.kwad.sdk.commercial.b.a.a(adTemplate, str3, 1, 0);
            return false;
        }
        try {
            if ("samsung".equals(str2)) {
                cR = "http://apps.samsung.com/appquery/appDetail.as?appId=" + ax;
            }
            com.kwad.sdk.commercial.b.a.a(adTemplate, cR, str3, 1, 0);
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(cR));
            intent.addFlags(268435456);
            Iterator<PackageInfo> it = context.getPackageManager().getInstalledPackages(1).iterator();
            while (it.hasNext()) {
                String str4 = it.next().packageName;
                if (str4 != null && (str4.equals(str3) || gz(str3))) {
                    intent.setPackage(str4);
                    intent.setFlags(268435456);
                    context.startActivity(intent);
                    adTemplate.mClickOpenAppStore = true;
                    com.kwad.sdk.commercial.b.a.b(adTemplate, cR, str3, 1, 0);
                    return true;
                }
            }
            try {
                context.startActivity(intent);
                adTemplate.mClickOpenAppStore = true;
                com.kwad.sdk.commercial.b.a.b(adTemplate, cR, str3, 0, 0);
                return true;
            } catch (Throwable th) {
                th = th;
                str = cR;
                i = 0;
                com.kwad.sdk.commercial.b.a.a(adTemplate, str, str3, i, 0, bo.t(th));
                return false;
            }
        } catch (Throwable th2) {
            th = th2;
            str = cR;
            i = 1;
        }
    }
}
