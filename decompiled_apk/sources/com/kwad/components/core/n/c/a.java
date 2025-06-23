package com.kwad.components.core.n.c;

import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: classes11.dex */
public final class a {
    private static void a(b bVar) {
        a(bVar, false);
    }

    public static void b(String str, long j, int i) {
        try {
            a(new b().an(str).B(j).aw(i).A(2L));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void c(String str, long j) {
        try {
            a(new b().an(str).B(j).A(1L));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void d(String str, long j) {
        try {
            a(new b().an(str).B(j).A(6L));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private static void a(b bVar, boolean z) {
        com.kwad.sdk.commercial.b.d(com.kwad.sdk.commercial.c.Br().cz(z ? ILoggerReporter.Category.ERROR_LOG : ILoggerReporter.Category.APM_LOG).i(z ? 1.0d : 0.01d).N("ad_sdk_offline_component_monitor", "load_status").t(bVar).a(com.kwai.adclient.kscommerciallogger.model.a.aUS));
    }

    public static void c(String str, long j, String str2) {
        try {
            a(new b().an(str).B(j).ap(str2).A(4L));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void b(String str, long j, String str2) {
        try {
            a(new b().an(str).B(j).ap(str2).A(3L));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(String str, long j, int i, String str2, String str3) {
        try {
            a(new b().an(str).B(j).setErrorCode(i).ap(str3).ao(str2).A(7L), true);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void c(String str, long j, int i) {
        try {
            a(new b().an(str).A(8L).aw(i).B(j));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(String str, long j, String str2) {
        try {
            a(new b().an(str).ap(str2).B(j).A(5L));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
