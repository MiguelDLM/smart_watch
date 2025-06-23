package com.kwad.sdk.commercial.a;

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

    public static void aV(AdTemplate adTemplate) {
        a(adTemplate, b.Bs().cc(3).setAdTemplate(adTemplate));
    }

    public static void aW(AdTemplate adTemplate) {
        a(adTemplate, b.Bs().cc(4).setAdTemplate(adTemplate));
    }

    public static void aX(AdTemplate adTemplate) {
        a(adTemplate, b.Bs().cc(5).setAdTemplate(adTemplate));
    }

    public static void aY(AdTemplate adTemplate) {
        h(adTemplate, 100002, "");
    }

    public static void aZ(AdTemplate adTemplate) {
        int i;
        b cc = b.Bs().cc(7);
        if (adTemplate.mInstallApkFormUser) {
            i = 1;
        } else {
            i = 2;
        }
        a(adTemplate, cc.cd(i).setAdTemplate(adTemplate));
    }

    public static void ba(AdTemplate adTemplate) {
        int i;
        b cc = b.Bs().cc(8);
        int i2 = 2;
        if (adTemplate.mInstallApkFormUser) {
            i = 1;
        } else {
            i = 2;
        }
        b cd = cc.cd(i);
        if (adTemplate.mInstallApkFromSDK) {
            i2 = 1;
        } else if (!adTemplate.mClickOpenAppStore) {
            i2 = 0;
        }
        a(adTemplate, cd.ce(i2).setAdTemplate(adTemplate));
    }

    public static void bb(AdTemplate adTemplate) {
        int i;
        b cc = b.Bs().cc(10);
        if (adTemplate.mInstallApkFromSDK) {
            i = 1;
        } else if (adTemplate.mClickOpenAppStore) {
            i = 2;
        } else {
            i = 0;
        }
        a(adTemplate, cc.ce(i).setAdTemplate(adTemplate));
    }

    public static void h(AdTemplate adTemplate, int i, String str) {
        a(adTemplate, true, b.Bs().cc(6).setAdTemplate(adTemplate).setErrorCode(i).setErrorMsg(str));
    }

    public static void i(AdTemplate adTemplate, int i, String str) {
        int i2;
        b cc = b.Bs().cc(9);
        if (adTemplate.mInstallApkFormUser) {
            i2 = 1;
        } else {
            i2 = 2;
        }
        a(adTemplate, true, cc.cd(i2).setAdTemplate(adTemplate).setErrorCode(100003).setErrorMsg(str));
    }

    public static void j(AdTemplate adTemplate, long j) {
        a(adTemplate, b.Bs().cc(2).aj(j).setAdTemplate(adTemplate));
    }

    public static void o(AdTemplate adTemplate) {
        a(adTemplate, b.Bs().cc(1).setAdTemplate(adTemplate));
    }

    private static void a(AdTemplate adTemplate, boolean z, com.kwad.sdk.commercial.c.a aVar) {
        String str;
        try {
            c Br = c.Br();
            if (z) {
                str = ILoggerReporter.Category.ERROR_LOG;
            } else {
                str = ILoggerReporter.Category.APM_LOG;
            }
            com.kwad.sdk.commercial.b.d(Br.cz(str).i(z ? 1.0d : 0.1d).a(d.aT(adTemplate)).N("ad_sdk_download_performance", "status").t(aVar));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
