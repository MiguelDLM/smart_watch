package com.kwad.sdk.utils;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import java.io.File;

/* loaded from: classes11.dex */
public final class bf {
    public static void NA() {
        y.l("ksadsdk_pref", "interstitial_aggregate_transfer", true);
    }

    public static boolean NB() {
        return y.m("ksadsdk_pref", "interstitial_aggregate_transfer", false);
    }

    public static boolean Nu() {
        return y.m("ksadsdk_pref", "config_data_transfer", false);
    }

    private static void Nv() {
        y.l("ksadsdk_pref", "config_data_transfer", true);
    }

    public static void Nw() {
        y.l("ksadsdk_pref", "splash_daily_transfer", true);
    }

    public static boolean Nx() {
        return y.m("ksadsdk_pref", "splash_daily_transfer", false);
    }

    public static void Ny() {
        y.l("ksadsdk_pref", "reward_auto_transfer", true);
    }

    public static boolean Nz() {
        return y.m("ksadsdk_pref", "reward_auto_transfer", false);
    }

    @Nullable
    @WorkerThread
    public static String au(Context context, String str) {
        if (context == null) {
            return "";
        }
        File file = new File(context.getFilesDir(), str);
        if (!file.exists()) {
            return "";
        }
        try {
            String I = com.kwad.sdk.crash.utils.h.I(file);
            if (TextUtils.isEmpty(I)) {
                return "";
            }
            return I;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static void i(final Context context, final String str, final String str2) {
        g.execute(new az() { // from class: com.kwad.sdk.utils.bf.1
            @Override // com.kwad.sdk.utils.az
            public final void doTask() {
                bf.j(context, str, str2);
            }
        });
    }

    public static void j(Context context, String str, String str2) {
        if (context != null) {
            com.kwad.sdk.crash.utils.h.k(new File(context.getFilesDir(), str).getAbsolutePath(), str2, false);
            Nv();
        }
    }
}
