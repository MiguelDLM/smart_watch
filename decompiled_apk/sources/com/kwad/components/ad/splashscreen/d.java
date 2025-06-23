package com.kwad.components.ad.splashscreen;

import android.text.TextUtils;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: classes11.dex */
public final class d {
    public static int Cj;
    private String Ck;
    private int Cl = 2;

    private void T(String str) {
        this.Ck = str;
    }

    private void V(int i) {
        this.Cl = i;
    }

    public static d a(AdTemplate adTemplate, AdInfo adInfo, com.kwad.components.core.e.d.c cVar, int i) {
        d dVar = new d();
        Cj = i;
        if (adInfo != null && cVar != null) {
            if (i != 1 && i != 4) {
                if (com.kwad.sdk.core.response.b.a.aE(adInfo)) {
                    dVar.T("或点击" + a(adTemplate, adInfo, cVar.ov(), 0));
                } else {
                    String a2 = com.kwad.sdk.core.config.d.a(com.kwad.components.ad.splashscreen.b.a.CQ);
                    if (TextUtils.isEmpty(a2)) {
                        a2 = "点击跳转详情页或第三方应用";
                    }
                    dVar.T("或" + a2);
                }
            } else {
                dVar.T(a(adTemplate, adInfo, cVar));
            }
        }
        dVar.V(com.kwad.sdk.core.response.b.b.dz(adInfo));
        return dVar;
    }

    public final String kv() {
        return this.Ck;
    }

    public final int kw() {
        return this.Cl;
    }

    public static String a(AdTemplate adTemplate, AdInfo adInfo, int i, int i2) {
        String aD = com.kwad.sdk.core.response.b.a.aD(adInfo);
        if (i == 2) {
            return i2 + "%";
        }
        if (i == 4) {
            return "继续下载";
        }
        if (i != 8) {
            return i != 12 ? aD : com.kwad.sdk.core.response.b.a.ab(adInfo);
        }
        return com.kwad.sdk.core.response.b.a.ca(adTemplate);
    }

    private static String a(AdInfo adInfo, int i) {
        if (i == 1) {
            if (com.kwad.sdk.core.response.b.b.dt(adInfo) == null) {
                return "";
            }
            return com.kwad.sdk.core.response.b.b.dt(adInfo);
        }
        if (i != 4 || com.kwad.sdk.core.response.b.b.du(adInfo) == null) {
            return "";
        }
        return com.kwad.sdk.core.response.b.b.du(adInfo);
    }

    private static String a(AdTemplate adTemplate, AdInfo adInfo, com.kwad.components.core.e.d.c cVar) {
        if (com.kwad.sdk.core.response.b.a.aE(adInfo)) {
            return a(adTemplate, adInfo, cVar.ov(), 0);
        }
        String a2 = a(adInfo, Cj);
        return TextUtils.isEmpty(a2) ? "点击跳转详情页或第三方应用" : a2;
    }
}
