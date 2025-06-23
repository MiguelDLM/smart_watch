package com.kwad.components.ad.splashscreen.monitor;

import androidx.annotation.NonNull;
import com.facebook.share.internal.ShareConstants;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.l;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;

/* loaded from: classes11.dex */
public final class a {

    /* renamed from: com.kwad.components.ad.splashscreen.monitor.a$a, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0766a {
        private static final a CV = new a();
    }

    private static SplashMonitorInfo V(@NonNull AdTemplate adTemplate) {
        int i;
        AdInfo dS = e.dS(adTemplate);
        SplashMonitorInfo creativeId = new SplashMonitorInfo().setPreloadId(com.kwad.sdk.core.response.b.a.aY(dS)).setCreativeId(com.kwad.sdk.core.response.b.a.J(dS));
        if (com.kwad.sdk.core.response.b.a.bb(dS)) {
            i = 1;
        } else {
            i = 2;
        }
        return creativeId.setMaterialType(i).setAdTemplate(adTemplate);
    }

    private static void c(com.kwad.sdk.commercial.c.a aVar) {
        if (!l.zJ().yY()) {
            return;
        }
        com.kwad.sdk.commercial.b.d(com.kwad.sdk.commercial.c.Br().cz(ILoggerReporter.Category.APM_LOG).i(0.01d).N("ad_sdk_splash_callback", "callback_type").a(BusinessType.AD_SPLASH).t(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.aUS));
    }

    private static void d(com.kwad.sdk.commercial.c.a aVar) {
        if (!l.zJ().yY()) {
            return;
        }
        com.kwad.sdk.commercial.b.d(com.kwad.sdk.commercial.c.Br().cz(ILoggerReporter.Category.APM_LOG).i(0.01d).N("ad_sdk_splash_action", ShareConstants.WEB_DIALOG_PARAM_ACTION_TYPE).a(BusinessType.AD_SPLASH).t(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.aUS));
    }

    public static a kU() {
        return C0766a.CV;
    }

    public final void W(@NonNull AdTemplate adTemplate) {
        c(V(adTemplate).setCallbackType(2));
    }

    public final void X(@NonNull AdTemplate adTemplate) {
        c(V(adTemplate).setCallbackType(5));
    }

    public final void Y(@NonNull AdTemplate adTemplate) {
        d(V(adTemplate).setActionType(1));
    }

    public final void Z(@NonNull AdTemplate adTemplate) {
        d(V(adTemplate).setActionType(2));
    }

    public final void m(@NonNull AdTemplate adTemplate) {
        c(V(adTemplate).setCallbackType(1));
    }

    public final void n(@NonNull AdTemplate adTemplate) {
        c(V(adTemplate).setCallbackType(3));
    }

    public final void o(long j) {
        c(new SplashMonitorInfo().setCallbackType(4).setPosId(j));
    }
}
