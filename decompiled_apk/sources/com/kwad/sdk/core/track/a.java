package com.kwad.sdk.core.track;

import androidx.annotation.NonNull;
import com.kwad.sdk.commercial.d;
import com.kwad.sdk.core.network.c;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.export.proxy.AdHttpProxy;
import com.kwad.sdk.g;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ab;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.bo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes11.dex */
public final class a {
    private static List<String> a(AdTemplate adTemplate, int i, @NonNull com.kwad.sdk.core.adlog.c.a aVar) {
        List<String> list;
        ArrayList arrayList = new ArrayList();
        AdInfo dS = e.dS(adTemplate);
        List<AdInfo.AdTrackInfo> list2 = dS.adTrackInfoList;
        if (ai.I(list2)) {
            return arrayList;
        }
        List<String> a2 = a(i, aVar, arrayList, dS, list2);
        if (a2 != null) {
            return a2;
        }
        Iterator<AdInfo.AdTrackInfo> it = list2.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            AdInfo.AdTrackInfo next = it.next();
            if (next.type == i && (list = next.urls) != null) {
                arrayList.addAll(list);
                break;
            }
        }
        return arrayList;
    }

    public static void d(@NonNull com.kwad.sdk.core.adlog.c.a aVar) {
        ac.a aVar2;
        int i;
        AdTemplate adTemplate = aVar.adTemplate;
        int i2 = aVar.apT;
        List<String> a2 = a(adTemplate, i2, aVar);
        if (ai.I(a2)) {
            return;
        }
        for (String str : a2) {
            com.kwad.sdk.commercial.j.a.o(adTemplate, i2, str);
            if (adTemplate.isCheatingFlow()) {
                com.kwad.sdk.commercial.j.a.n(adTemplate, i2, str);
                return;
            }
            if (bo.hk(str)) {
                com.kwad.sdk.commercial.j.a.a(adTemplate, i2, str, "", 100001, "", 0);
                return;
            }
            if (i2 == 2) {
                aVar2 = aVar.kn;
            } else {
                aVar2 = null;
            }
            String a3 = ab.a(ServiceProvider.getContext(), str, aVar2, com.kwad.sdk.core.response.b.a.aA(e.dS(adTemplate)));
            ab.f(adTemplate, str, a3);
            AdHttpProxy yy = g.yy();
            if (yy instanceof com.kwad.sdk.core.network.c.a) {
                i = 2;
            } else {
                i = 1;
            }
            c doGetWithoutResponse = yy.doGetWithoutResponse(a3, null);
            if (dp(doGetWithoutResponse.code)) {
                com.kwad.sdk.core.e.c.d("AdTrackUtil", "trackUrl request success actionType: " + i2);
                com.kwad.sdk.commercial.j.a.a(adTemplate, i2, str, doGetWithoutResponse.code, i);
            } else {
                com.kwad.sdk.commercial.j.a.a(adTemplate, i2, str, a3, d.cb(doGetWithoutResponse.code), doGetWithoutResponse.awE, i);
            }
        }
    }

    private static boolean dp(int i) {
        return i >= 200 && i < 300;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x004b, code lost:
    
        r4.addAll(r6);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.util.List<java.lang.String> a(int r2, com.kwad.sdk.core.adlog.c.a r3, java.util.List<java.lang.String> r4, com.kwad.sdk.core.response.model.AdInfo r5, java.util.List<com.kwad.sdk.core.response.model.AdInfo.AdTrackInfo> r6) {
        /*
            r0 = 402(0x192, float:5.63E-43)
            if (r2 != r0) goto L4f
            boolean r2 = com.kwad.sdk.core.response.b.a.bm(r5)
            if (r2 == 0) goto L4f
            java.lang.String r2 = r3.Lh     // Catch: java.lang.Throwable -> L4e
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L4e
            if (r2 != 0) goto L20
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L4e
            java.lang.String r3 = r3.Lh     // Catch: java.lang.Throwable -> L4e
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L4e
            java.lang.String r3 = "photoPlaySecond"
            int r2 = r2.optInt(r3)     // Catch: java.lang.Throwable -> L4e
            goto L22
        L20:
            int r2 = r3.aqO     // Catch: java.lang.Throwable -> L4e
        L22:
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L4e
            com.kwad.sdk.core.response.model.AdInfo$AdBaseInfo r5 = r5.adBaseInfo     // Catch: java.lang.Throwable -> L4e
            java.lang.String r5 = r5.videoPlayedNSConfig     // Catch: java.lang.Throwable -> L4e
            r3.<init>(r5)     // Catch: java.lang.Throwable -> L4e
            java.util.Iterator r5 = r6.iterator()     // Catch: java.lang.Throwable -> L4e
        L2f:
            boolean r6 = r5.hasNext()     // Catch: java.lang.Throwable -> L4e
            if (r6 == 0) goto L4e
            java.lang.Object r6 = r5.next()     // Catch: java.lang.Throwable -> L4e
            com.kwad.sdk.core.response.model.AdInfo$AdTrackInfo r6 = (com.kwad.sdk.core.response.model.AdInfo.AdTrackInfo) r6     // Catch: java.lang.Throwable -> L4e
            int r0 = r6.type     // Catch: java.lang.Throwable -> L4e
            java.lang.String r1 = java.lang.String.valueOf(r2)     // Catch: java.lang.Throwable -> L4e
            int r1 = r3.optInt(r1)     // Catch: java.lang.Throwable -> L4e
            if (r0 != r1) goto L2f
            java.util.List<java.lang.String> r6 = r6.urls     // Catch: java.lang.Throwable -> L4e
            if (r6 == 0) goto L2f
            r4.addAll(r6)     // Catch: java.lang.Throwable -> L4e
        L4e:
            return r4
        L4f:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.track.a.a(int, com.kwad.sdk.core.adlog.c.a, java.util.List, com.kwad.sdk.core.response.model.AdInfo, java.util.List):java.util.List");
    }
}
