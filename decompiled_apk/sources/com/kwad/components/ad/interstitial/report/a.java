package com.kwad.components.ad.interstitial.report;

import com.facebook.share.internal.ShareConstants;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.l;
import com.kwad.sdk.service.ServiceProvider;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;

/* loaded from: classes11.dex */
public final class a {

    /* renamed from: com.kwad.components.ad.interstitial.report.a$a, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0746a {
        private static final a lq = new a();
    }

    private static void a(String str, com.kwad.sdk.commercial.c.a aVar) {
        if (l.zJ().yY()) {
            try {
                com.kwad.sdk.commercial.b.d(com.kwad.sdk.commercial.c.Br().cz(ILoggerReporter.Category.APM_LOG).i(0.01d).N("ad_sdk_interstitial_callback", str).a(BusinessType.AD_INTERSTITIAL).t(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.aUS));
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
    }

    public static a dN() {
        return C0746a.lq;
    }

    public final void b(AdTemplate adTemplate, long j, long j2) {
        a("callback_type", new InterstitialReportInfo().setCallbackType(2L).setClickSceneType(j).setItemClickType(j2).setAdTemplate(adTemplate));
    }

    public final void m(AdTemplate adTemplate) {
        a("callback_type", new InterstitialReportInfo().setCallbackType(1L).setAdTemplate(adTemplate));
    }

    public final void n(AdTemplate adTemplate) {
        a("callback_type", new InterstitialReportInfo().setCallbackType(3L).setAdTemplate(adTemplate));
    }

    public final void a(AdTemplate adTemplate, long j, long j2) {
        a(ShareConstants.WEB_DIALOG_PARAM_ACTION_TYPE, new InterstitialReportInfo().setActionType(1L).setClickSceneType(j).setItemClickType(j2).setAdTemplate(adTemplate));
    }

    public final void a(AdTemplate adTemplate, double d) {
        a(ShareConstants.WEB_DIALOG_PARAM_ACTION_TYPE, new InterstitialReportInfo().setActionType(2L).setVisiblePercent(d).setAdTemplate(adTemplate));
    }
}
