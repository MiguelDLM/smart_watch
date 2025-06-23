package com.kwad.sdk.commercial.d;

import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: classes11.dex */
public final class d {
    private static void a(SceneImpl sceneImpl, com.kwad.sdk.commercial.c.a aVar) {
        com.kwad.sdk.commercial.b.d(com.kwad.sdk.commercial.c.Br().cz(ILoggerReporter.Category.APM_LOG).i(0.001d).a(com.kwad.sdk.commercial.d.ca(sceneImpl.getAdStyle())).N("ad_convert_method_call", "method_name").t(aVar));
    }

    public static void b(SceneImpl sceneImpl) {
        try {
            a(sceneImpl, b.Bu().cD("loadRequest").ci(sceneImpl.getAdNum()).setPosId(sceneImpl.getPosId()));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void b(SceneImpl sceneImpl, String str) {
        try {
            a(sceneImpl, b.Bu().cD("requestStart").ci(sceneImpl.getAdNum()).cE(str).setPosId(sceneImpl.getPosId()));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(SceneImpl sceneImpl, String str, String str2) {
        try {
            a(sceneImpl, b.Bu().cD("requestFinish").ci(sceneImpl.getAdNum()).cE(str).cF(str2).setPosId(sceneImpl.getPosId()));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(SceneImpl sceneImpl, int i) {
        try {
            a(sceneImpl, b.Bu().cD("dataReady").ci(i));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(int i, int i2, String str, String str2) {
        try {
            com.kwad.sdk.commercial.b.d(com.kwad.sdk.commercial.c.Br().cz(ILoggerReporter.Category.ERROR_LOG).i(1.0d).a(com.kwad.sdk.commercial.d.ca(i)).N("ad_convert_method_call", "method_name").t(b.Bu().cD("requestError").cE(str2).setErrorCode(com.kwad.sdk.commercial.d.cb(i2)).setErrorMsg(str)));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
