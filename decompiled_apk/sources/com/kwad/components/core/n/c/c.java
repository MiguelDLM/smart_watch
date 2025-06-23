package com.kwad.components.core.n.c;

import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: classes11.dex */
public final class c {
    private static void a(d dVar, boolean z) {
        com.kwad.sdk.commercial.b.d(com.kwad.sdk.commercial.c.Br().cz(z ? ILoggerReporter.Category.ERROR_LOG : ILoggerReporter.Category.APM_LOG).i(z ? 1.0d : 0.01d).N("ad_sdk_offline_component_update", "load_status").t(dVar).a(com.kwai.adclient.kscommerciallogger.model.a.aUS));
    }

    public static void b(String str, long j, int i, String str2, String str3) {
        try {
            a(new d().aq(str).D(j).setErrorCode(i).as(str2).ar(str3).C(2L), true);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void d(String str, long j, String str2) {
        try {
            a(new d().aq(str).as(str2).D(j).C(1L), false);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(String str, long j, long j2, String str2) {
        try {
            a(new d().aq(str).D(j).E(j2).as(str2).C(3L), false);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
