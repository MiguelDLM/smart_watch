package com.kwad.components.ad.interstitial.report;

import androidx.annotation.NonNull;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;

/* loaded from: classes11.dex */
public final class d {

    /* loaded from: classes11.dex */
    public static class a {
        private static final d lt = new d();
    }

    private static void a(boolean z, com.kwad.sdk.commercial.c.a aVar) {
        try {
            com.kwad.sdk.commercial.b.d(com.kwad.sdk.commercial.c.Br().cz(ILoggerReporter.Category.APM_LOG).i(z ? 1.0d : 0.01d).N("ad_sdk_interstitial_play", "status").a(BusinessType.AD_INTERSTITIAL).t(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.aUS));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static d dT() {
        return a.lt;
    }

    public final void b(@NonNull AdTemplate adTemplate, int i, String str) {
        AdInfo dS = e.dS(adTemplate);
        a(true, new InterstitialReportInfo(adTemplate).setCreativeId(com.kwad.sdk.core.response.b.a.J(dS)).setVideoUrl(com.kwad.sdk.core.response.b.a.K(dS)).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setVideoDuration(com.kwad.sdk.core.response.b.a.L(dS) * 1000).setStatus(2).setErrorMsg(str).setErrorCode(i).setAdTemplate(adTemplate));
    }

    public final void v(@NonNull AdTemplate adTemplate) {
        a(false, new InterstitialReportInfo(adTemplate).setStatus(1).setAdTemplate(adTemplate));
    }

    public final void a(@NonNull AdTemplate adTemplate, long j) {
        a(false, new InterstitialReportInfo(adTemplate).setStatus(3).setCreativeId(e.ec(adTemplate)).setVideoUrl(com.kwad.sdk.core.response.b.a.K(e.dS(adTemplate))).setVideoDuration(com.kwad.sdk.core.response.b.a.L(r0) * 1000).setPlayStartedDuration(j).setAdTemplate(adTemplate));
    }
}
