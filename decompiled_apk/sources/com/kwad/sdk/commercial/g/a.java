package com.kwad.sdk.commercial.g;

import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.c;
import com.kwad.sdk.commercial.d;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: classes11.dex */
public final class a {
    private static void a(AdTemplate adTemplate, com.kwad.sdk.commercial.c.a aVar) {
        a(adTemplate, false, aVar);
    }

    public static void j(AdTemplate adTemplate, int i, String str) {
        try {
            a(adTemplate, b.By().ck(1).cL(str).cl(i));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void k(AdTemplate adTemplate, int i, String str) {
        try {
            a(adTemplate, b.By().ck(2).cL(str).cl(i));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void l(AdTemplate adTemplate, int i, String str) {
        try {
            a(adTemplate, b.By().ck(4).cL(str).cl(i));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void m(AdTemplate adTemplate, int i, String str) {
        try {
            a(adTemplate, b.By().ck(5).cL(str).cl(i));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private static void a(AdTemplate adTemplate, boolean z, com.kwad.sdk.commercial.c.a aVar) {
        aVar.setAdTemplate(adTemplate);
        com.kwad.sdk.commercial.b.d(c.Br().cz(ILoggerReporter.Category.APM_LOG).i(z ? 0.1d : 0.01d).a(d.aT(adTemplate)).N("ad_sdk_landing_page_performance", "status").t(aVar));
    }

    public static void a(AdTemplate adTemplate, int i, String str, String str2) {
        try {
            a(adTemplate, true, b.By().ck(3).cL(str).cl(i).setErrorCode(100009).setErrorMsg(str2));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(AdTemplate adTemplate, int i, String str, int i2, String str2) {
        try {
            a(adTemplate, true, b.By().ck(6).cL(str).cl(i).setErrorCode(i2).setErrorMsg(str2));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
