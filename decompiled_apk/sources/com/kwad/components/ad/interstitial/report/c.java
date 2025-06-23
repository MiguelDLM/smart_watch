package com.kwad.components.ad.interstitial.report;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.l;
import com.kwad.sdk.service.ServiceProvider;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;

/* loaded from: classes11.dex */
public final class c {

    /* loaded from: classes11.dex */
    public static class a {
        private static final c ls = new c();
    }

    private static void a(boolean z, com.kwad.sdk.commercial.c.a aVar) {
        if (l.zJ().yY()) {
            com.kwad.sdk.commercial.b.d(com.kwad.sdk.commercial.c.Br().cz(z ? ILoggerReporter.Category.ERROR_LOG : ILoggerReporter.Category.APM_LOG).i(z ? 1.0d : 0.01d).N("ad_sdk_interstitial_load", "status").a(BusinessType.AD_INTERSTITIAL).t(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.aUS));
        }
    }

    public static c dR() {
        return a.ls;
    }

    public final void b(@NonNull AdTemplate adTemplate, boolean z) {
        int i;
        adTemplate.notNetworkRequest = z;
        InterstitialReportInfo status = new InterstitialReportInfo(adTemplate).setStatus(3);
        if (adTemplate.notNetworkRequest) {
            i = 2;
        } else {
            i = 1;
        }
        a(false, status.setType(i).setDownloadDuration(adTemplate.downloadDuration).setDownloadSize(adTemplate.getDownloadSize()).setDownloadType(adTemplate.getDownloadType()).setAdTemplate(adTemplate));
    }

    public final void i(long j) {
        a(false, new InterstitialReportInfo().setStatus(1).setPosId(j));
    }

    public final void p(AdTemplate adTemplate) {
        a(false, new InterstitialReportInfo(adTemplate).setStatus(6).setAdTemplate(adTemplate));
    }

    public final void q(AdTemplate adTemplate) {
        int i;
        try {
            AdInfo dS = e.dS(adTemplate);
            InterstitialReportInfo status = new InterstitialReportInfo(adTemplate).setStatus(8);
            if (adTemplate.notNetworkRequest) {
                i = 2;
            } else {
                i = 1;
            }
            a(false, status.setType(i).setMaterialType(com.kwad.sdk.core.response.b.a.bd(dS)).setAdTemplate(adTemplate));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public final void r(@NonNull AdTemplate adTemplate) {
        a(false, new InterstitialReportInfo(adTemplate).setStatus(10).setAdTemplate(adTemplate));
    }

    public final void s(@NonNull AdTemplate adTemplate) {
        a(false, new InterstitialReportInfo(adTemplate).setStatus(7).setAdTemplate(adTemplate));
    }

    public final void t(@NonNull AdTemplate adTemplate) {
        int i;
        InterstitialReportInfo status = new InterstitialReportInfo(adTemplate).setStatus(12);
        if (com.kwad.sdk.core.response.b.b.cU(adTemplate)) {
            i = 3;
        } else {
            i = 1;
        }
        a(true, status.setRenderType(i).setAdTemplate(adTemplate));
    }

    public final void u(@NonNull AdTemplate adTemplate) {
        a(true, new InterstitialReportInfo(adTemplate).setStatus(11).setRenderType(1).setAdTemplate(adTemplate));
    }

    public final void a(AdTemplate adTemplate, int i, String str) {
        a(true, new InterstitialReportInfo(adTemplate).setStatus(9).setErrorCode(i).setErrorMsg(str).setAdTemplate(adTemplate));
    }

    public final void a(@NonNull AdTemplate adTemplate, boolean z) {
        a(false, new InterstitialReportInfo(adTemplate).setStatus(2).setType(z ? 2 : 1).setLoadDataTime(adTemplate.loadDataTime).setExpectedRenderType().setAdTemplate(adTemplate));
    }

    public final void a(@NonNull AdTemplate adTemplate, int i) {
        a(false, new InterstitialReportInfo(adTemplate).setStatus(4).setType(adTemplate.notNetworkRequest ? 2 : 1).setMaterialType(com.kwad.sdk.core.response.b.a.bd(e.dS(adTemplate))).setRenderDuration(SystemClock.elapsedRealtime() - adTemplate.adShowStartTimeStamp).setRenderType(i).setExpectedRenderType().setAdTemplate(adTemplate));
    }

    public final void a(int i, String str, long j) {
        a(true, new InterstitialReportInfo().setStatus(5).setErrorCode(i).setErrorMsg(str).setPosId(j));
    }
}
