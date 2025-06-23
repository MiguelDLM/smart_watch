package com.kwad.components.ad.interstitial.report;

import androidx.annotation.NonNull;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;

/* loaded from: classes11.dex */
public final class b {

    /* loaded from: classes11.dex */
    public static class a {
        private static final b lr = new b();
    }

    private static void a(boolean z, com.kwad.sdk.commercial.c.a aVar) {
        double d;
        try {
            com.kwad.sdk.commercial.c cz = com.kwad.sdk.commercial.c.Br().cz(ILoggerReporter.Category.APM_LOG);
            if (z) {
                d = 1.0d;
            } else {
                d = 0.01d;
            }
            com.kwad.sdk.commercial.b.d(cz.i(d).N("ad_sdk_interstitial_download_error", "status").a(BusinessType.AD_INTERSTITIAL).t(aVar).a(com.kwai.adclient.kscommerciallogger.model.b.aVl));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static b dP() {
        return a.lr;
    }

    public final void b(@NonNull AdTemplate adTemplate, String str) {
        AdInfo dS = e.dS(adTemplate);
        a(true, new InterstitialReportInfo().setCreativeId(com.kwad.sdk.core.response.b.a.J(dS)).setVideoUrl(com.kwad.sdk.core.response.b.a.K(dS)).setDownloadSize(adTemplate.getDownloadSize()).setDownloadType(adTemplate.getDownloadType()).setVideoDuration(com.kwad.sdk.core.response.b.a.L(dS) * 1000).setStatus(2).setErrorMsg(str).setAdTemplate(adTemplate));
    }

    public final void o(@NonNull AdTemplate adTemplate) {
        a(false, new InterstitialReportInfo().setDownloadType(adTemplate.getDownloadType()).setStatus(1).setAdTemplate(adTemplate));
    }
}
