package com.kwad.sdk.commercial.j;

import android.text.TextUtils;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.d;
import com.kwad.sdk.core.c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.h;
import com.kwad.sdk.utils.t;
import java.util.List;

/* loaded from: classes11.dex */
public final class a {
    private static C0843a apR;

    @KsJson
    /* renamed from: com.kwad.sdk.commercial.j.a$a, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0843a extends com.kwad.sdk.core.response.a.a {
        public List<String> apS;
    }

    private static C0843a BC() {
        String zC = ((h) ServiceProvider.get(h.class)).zC();
        if (!TextUtils.isEmpty(zC)) {
            apR = (C0843a) t.b(zC, new c<C0843a>() { // from class: com.kwad.sdk.commercial.j.a.1
                private static C0843a BD() {
                    return new C0843a();
                }

                @Override // com.kwad.sdk.core.c
                public final /* synthetic */ C0843a BE() {
                    return BD();
                }
            });
        }
        return apR;
    }

    private static void a(AdTemplate adTemplate, b bVar) {
        a(adTemplate, false, bVar);
    }

    private static boolean cU(String str) {
        C0843a BC;
        List<String> list;
        if (TextUtils.isEmpty(str) || (BC = BC()) == null || (list = BC.apS) == null) {
            return false;
        }
        for (String str2 : list) {
            if (!TextUtils.isEmpty(str2) && str.contains(str2)) {
                return true;
            }
        }
        return false;
    }

    public static void n(AdTemplate adTemplate, int i, String str) {
        try {
            a(adTemplate, b.BF().cn(4).co(i).cV(str).setAdTemplate(adTemplate));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void o(AdTemplate adTemplate, int i, String str) {
        try {
            a(adTemplate, b.BF().cn(1).co(i).cV(str).setAdTemplate(adTemplate));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private static void a(AdTemplate adTemplate, boolean z, b bVar) {
        if (cU(bVar.apL)) {
            return;
        }
        com.kwad.sdk.commercial.b.d(com.kwad.sdk.commercial.c.Br().cz(z ? ILoggerReporter.Category.ERROR_LOG : ILoggerReporter.Category.APM_LOG).i(z ? 1.0d : 0.001d).a(d.aT(adTemplate)).N("ad_sdk_track_performance", "status").t(bVar));
    }

    public static void a(AdTemplate adTemplate, String str, String str2, String str3, String str4) {
        try {
            com.kwad.sdk.commercial.b.d(com.kwad.sdk.commercial.c.Br().cz(ILoggerReporter.Category.ERROR_LOG).i(1.0d).a(d.aT(adTemplate)).N("ad_sdk_macro_check_performance", "error_name").t(com.kwad.sdk.commercial.i.a.BB().cN(str).cP(str2).cQ(str3).cO(str4).setAdTemplate(adTemplate)));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(AdTemplate adTemplate, int i, String str, int i2, int i3) {
        try {
            a(adTemplate, b.BF().cn(2).co(i).cV(str).cp(i3).setErrorCode(i2).setAdTemplate(adTemplate));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(AdTemplate adTemplate, int i, String str, String str2, int i2, String str3, int i3) {
        try {
            a(adTemplate, true, b.BF().cn(3).co(i).cV(str).cW(str2).setErrorCode(i2).setErrorMsg(str3).cp(i3).setAdTemplate(adTemplate));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
