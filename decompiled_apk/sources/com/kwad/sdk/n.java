package com.kwad.sdk;

import android.content.Context;
import android.os.SystemClock;
import android.util.Log;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: classes11.dex */
public final class n {
    private static long alW;
    private static boolean amo;

    public static void Ao() {
        if (amo) {
            return;
        }
        amo = true;
        alW = SystemClock.elapsedRealtime();
    }

    public static void a(Throwable th, String str) {
        try {
            m.a(com.kwai.adclient.kscommerciallogger.model.a.aUY, str);
            com.kwad.components.core.d.a.reportSdkCaughtException(th);
        } catch (Throwable unused) {
        }
        aG(ServiceProvider.Lw());
        com.kwad.sdk.core.e.c.d("SDKRevertHelper", "onInitError revert");
    }

    public static void aF(Context context) {
        long elapsedRealtime = SystemClock.elapsedRealtime() - alW;
        com.kwad.sdk.core.e.c.d("SDKRevertHelper", "onException revert time: " + elapsedRealtime);
        if (elapsedRealtime < 10000) {
            aG(context);
        }
    }

    private static void aG(Context context) {
        try {
            context.getSharedPreferences("kssdk_api_pref", 0).edit().putString("curversion", "").putBoolean("initFail", true).apply();
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
        }
    }

    public static void aH(Context context) {
        try {
            context.getSharedPreferences("kssdk_api_pref", 0).edit().putBoolean("initFail", false).apply();
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
        }
    }

    public static boolean aI(Context context) {
        try {
            return context.getSharedPreferences("kssdk_api_pref", 0).getBoolean("initFail", false);
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
            return false;
        }
    }

    private static SdkConfig aJ(Context context) {
        SdkConfig sdkConfig;
        try {
            sdkConfig = SdkConfig.create(b(context, "sdkconfig", ""));
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
            sdkConfig = null;
        }
        if (sdkConfig == null) {
            return new SdkConfig.Builder().build();
        }
        return sdkConfig;
    }

    private static String b(Context context, String str, String str2) {
        try {
            return context.getSharedPreferences("kssdk_api_pref", 0).getString(str, str2);
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
            return str2;
        }
    }

    public static void checkInitSDK(Context context) {
        try {
            if (l.zJ().yY()) {
                return;
            }
            KsAdSDK.init(context, aJ(context));
        } catch (Throwable th) {
            com.kwad.components.core.d.a.reportSdkCaughtException(th);
        }
    }

    public static void l(Throwable th) {
        a(th, Log.getStackTraceString(th));
    }
}
