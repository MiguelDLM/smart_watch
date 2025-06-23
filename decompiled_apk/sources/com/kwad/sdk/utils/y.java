package com.kwad.sdk.utils;

import XIXIX.OOXIXo;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: classes11.dex */
public final class y {
    private static String sAppTag = "";

    public static int MA() {
        int b = b("ksadsdk_perf", "image_load_total", 0);
        com.kwad.sdk.core.e.c.d("Ks_UnionUtils", "imageLoadTotal:" + b);
        a("ksadsdk_perf", "image_load_total", 0);
        return b;
    }

    public static int MB() {
        int b = b("ksadsdk_perf", "image_load_suc", 0);
        com.kwad.sdk.core.e.c.d("Ks_UnionUtils", "imageLoadSuccess:" + b);
        a("ksadsdk_perf", "image_load_suc", 0);
        return b;
    }

    public static int MC() {
        int b = b("ksadsdk_perf", "image_load_failed", 0);
        com.kwad.sdk.core.e.c.d("Ks_UnionUtils", "imageLoadFailed:" + b);
        a("ksadsdk_perf", "image_load_failed", 0);
        return b;
    }

    public static String Mm() {
        Context context = getContext();
        if (context == null) {
            return "";
        }
        return b(context, "ksadsdk_interstitial_daily_show_count", "KEY_INTERSTITIAL_DAILY_SHOW_COUNT", "");
    }

    public static String Mn() {
        Context context = getContext();
        if (context == null) {
            return "";
        }
        if (bf.NB()) {
            return b(context, "ksadsdk_interstitial_daily_show_count", "KEY_INTERSTITIAL_AGGREGATE_DAILY_SHOW_COUNT", "");
        }
        return b(context, "ksadsdk_interstitial_aggregate_daily_show_count", "KEY_INTERSTITIAL_AGGREGATE_DAILY_SHOW_COUNT", "");
    }

    public static String Mo() {
        Context context = getContext();
        if (context == null) {
            return "";
        }
        return b(context, "ksadsdk_reward_full_ad_jump_direct", "KEY_REWARD_FULL_AD_JUMP_DIRECT", "");
    }

    public static String Mp() {
        Context context = getContext();
        if (context == null) {
            return "";
        }
        if (bf.Nx()) {
            return b(context, "ksadsdk_splash_local_ad_force_active", "KEY_SPLASH_DAILY_SHOW_COUNT", "");
        }
        return b(context, "ksadsdk_splash_daily_show_count", "KEY_SPLASH_DAILY_SHOW_COUNT", "");
    }

    public static String Mq() {
        Context context = getContext();
        if (context == null) {
            return "";
        }
        if (bf.Nz()) {
            return h("ksadsdk_reward_full_ad_jump_direct", "KEY_REWARD_AUTO_CALL_APP_CARD_SHOW_COUNT", "");
        }
        return b(context, "ksadsdk_reward_auto_call_app_card_show_count", "KEY_REWARD_AUTO_CALL_APP_CARD_SHOW_COUNT", "");
    }

    public static String Mr() {
        return h("ksadsdk_interstitial_daily_show_count", "KEY_INTERSTITIAL_AUTO_CALL_APP_CARD_SHOW_COUNT", "");
    }

    public static String Ms() {
        if (!TextUtils.isEmpty(sAppTag)) {
            return sAppTag;
        }
        Context context = getContext();
        if (context == null) {
            return "";
        }
        return b(context, "ksadsdk_pref", "appTag", "");
    }

    public static String Mt() {
        Context context = getContext();
        if (context == null) {
            return "";
        }
        return cl(context);
    }

    public static long Mu() {
        return b("ksadsdk_push_ad_common", "key_push_last_show_time", -1L);
    }

    public static String Mv() {
        if (getContext() == null) {
            return "";
        }
        return h("ksadsdk_install_tips_show_count", "init_install_tips_show_count", "");
    }

    public static void Mw() {
        a("ksadsdk_perf", "image_load_total", b("ksadsdk_perf", "image_load_total", 0) + 1);
    }

    public static void Mx() {
        a("ksadsdk_perf", "image_load_suc", b("ksadsdk_perf", "image_load_suc", 0) + 1);
    }

    public static void My() {
        a("ksadsdk_perf", "image_load_failed", b("ksadsdk_perf", "image_load_failed", 0) + 1);
    }

    public static double Mz() {
        int b = b("ksadsdk_perf", "image_load_complete_count", 0);
        long b2 = b("ksadsdk_perf", "image_load_complete_total", 0L);
        a("ksadsdk_perf", "image_load_complete_count", 0);
        a("ksadsdk_perf", "image_load_complete_total", 0L);
        if (b == 0) {
            return OOXIXo.f3760XO;
        }
        return b2 / b;
    }

    public static long U(Context context, String str) {
        if (context == null) {
            return 0L;
        }
        return b(context, "ksadsdk_pref", str, 0L);
    }

    public static long V(Context context, String str) {
        if (context == null) {
            return 0L;
        }
        return b(context, "ksadsdk_download_package_length", str, 0L);
    }

    public static String W(Context context, String str) {
        if (context == null) {
            return "";
        }
        return b(context, "ksadsdk_download_package_md5", str, "");
    }

    public static void X(@NonNull Context context, String str) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_egid", "KEY_SDK_EGID", str);
    }

    public static void Y(@NonNull Context context, String str) {
        if (context == null) {
            return;
        }
        a("ksadsdk_model", "KEY_SDK_MODEL", str, true);
    }

    public static void Z(Context context, String str) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_interstitial_daily_show_count", "KEY_INTERSTITIAL_DAILY_SHOW_COUNT", str);
    }

    public static void a(String str, String str2, String str3, boolean z) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        a(context, str, str2, str3, true);
    }

    public static void aM(long j) {
        a("ksadsdk_push_ad_common", "key_push_last_show_time", j);
    }

    public static void aN(long j) {
        a("ksadsdk_perf", "image_load_complete_count", b("ksadsdk_perf", "image_load_complete_count", 0) + 1);
        a("ksadsdk_perf", "image_load_complete_total", b("ksadsdk_perf", "image_load_complete_total", 0L) + j);
    }

    public static void aa(Context context, String str) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_interstitial_daily_show_count", "KEY_INTERSTITIAL_AGGREGATE_DAILY_SHOW_COUNT", str);
        bf.NA();
    }

    public static void ab(@NonNull Context context, String str) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_reward_full_ad_jump_direct", "KEY_REWARD_INTERACT_AD_SHOW_INFO", str);
    }

    public static void ac(Context context, String str) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_reward_full_ad_jump_direct", "KEY_REWARD_FULL_AD_JUMP_DIRECT", str);
    }

    public static void ad(@NonNull Context context, String str) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_splash_local_ad_force_active", "KEY_SPLASH_DAILY_SHOW_COUNT", str);
        bf.Nw();
    }

    public static void ae(Context context, String str) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_reward_full_ad_jump_direct", "KEY_REWARD_AUTO_CALL_APP_CARD_SHOW_COUNT", str);
        bf.Ny();
    }

    public static void af(Context context, String str) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_interstitial_daily_show_count", "KEY_INTERSTITIAL_AUTO_CALL_APP_CARD_SHOW_COUNT", str);
    }

    public static void ag(@NonNull Context context, String str) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_device_sig", "KEY_SDK_DEVICE_SIG", str);
    }

    public static void ah(Context context, final String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            g.execute(new az() { // from class: com.kwad.sdk.utils.y.1
                @Override // com.kwad.sdk.utils.az
                public final void doTask() {
                    y.ai(ServiceProvider.getContext(), str);
                }
            });
        }
    }

    public static void ai(Context context, String str) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_pref", "appTag", str);
    }

    public static void aj(Context context, String str) {
        if (context == null) {
            return;
        }
        a("ksadsdk_pref", "webview_ua", str, true);
    }

    @WorkerThread
    public static void ak(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        bf.j(context.getApplicationContext(), "ksadsdk_sdk_config_data", str);
    }

    public static void al(Context context, String str) {
        if (context == null) {
            return;
        }
        g("ksadsdk_install_tips_show_count", "init_install_tips_show_count", str);
    }

    private static long b(String str, String str2, long j) {
        Context context = getContext();
        return context == null ? j : b(context, str, str2, j);
    }

    private static boolean c(Context context, String str, String str2, boolean z) {
        if (context == null) {
            return z;
        }
        if (x.Mf()) {
            return bg.m(str, str2, z);
        }
        return com.kwad.sdk.utils.a.e.av(context, str).getBoolean(str2, z);
    }

    public static String cl(@NonNull Context context) {
        if (context == null) {
            return "";
        }
        return b(context, "ksadsdk_egid", "KEY_SDK_EGID", "");
    }

    public static long cm(@NonNull Context context) {
        if (context == null) {
            return 0L;
        }
        return b(context, "ksadsdk_gidExpireTimeMs", "KEY_SDK_EGID", 0L);
    }

    public static int cn(@NonNull Context context) {
        if (context == null) {
            return 0;
        }
        return b(context, "ksadsdk_config_request", "KEY_CONFIG_REQUEST_FAIL", 0);
    }

    public static String co(@NonNull Context context) {
        if (context == null) {
            return "";
        }
        String b = b(context, "ksadsdk_model", "KEY_SDK_MODEL", "");
        bg.i(b, "ksadsdk_model", "KEY_SDK_MODEL");
        return b;
    }

    public static int cp(@NonNull Context context) {
        if (context == null) {
            return 0;
        }
        return b(context, "ksadsdk_reward_full_ad_jump_direct", "KEY_REWARD_AD_SHOW_INTERACT_INTERVAL_SHOW_COUNT", 0);
    }

    public static String cq(@NonNull Context context) {
        if (context == null) {
            return "";
        }
        return b(context, "ksadsdk_reward_full_ad_jump_direct", "KEY_REWARD_INTERACT_AD_SHOW_INFO", "");
    }

    public static String cr(@NonNull Context context) {
        if (context == null) {
            return "";
        }
        return b(context, "ksadsdk_device_sig", "KEY_SDK_DEVICE_SIG", "");
    }

    public static String cs(Context context) {
        if (context == null) {
            return "";
        }
        String h = h("ksadsdk_pref", "webview_ua", "");
        bg.i(h, "ksadsdk_pref", "webview_ua");
        return h;
    }

    @WorkerThread
    public static String ct(Context context) {
        if (bf.Nu()) {
            return bf.au(context.getApplicationContext(), "ksadsdk_sdk_config_data");
        }
        String h = bg.h("ksadsdk_sdk_config_data", "config_str", "");
        bf.i(context.getApplicationContext(), "ksadsdk_sdk_config_data", h);
        return h;
    }

    public static void d(@NonNull Context context, long j) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_gidExpireTimeMs", "KEY_SDK_EGID", j);
    }

    public static void e(Context context, String str, long j) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_pref", str, j);
    }

    public static void f(Context context, String str, long j) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_download_package_length", str, j);
    }

    public static void g(Context context, String str, String str2) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_download_package_md5", str, str2);
    }

    @Nullable
    public static Context getContext() {
        return ServiceProvider.Lw();
    }

    public static String h(String str, String str2, String str3) {
        Context context = getContext();
        return context == null ? str3 : b(context, str, str2, str3);
    }

    public static void i(String str, String str2, String str3) {
        if (!x.Mf()) {
            return;
        }
        bg.i(str, str2, str3);
    }

    public static void l(@NonNull Context context, int i) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_config_request", "KEY_CONFIG_REQUEST_FAIL", i);
    }

    public static void m(@NonNull Context context, int i) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_reward_full_ad_jump_direct", "KEY_REWARD_AD_SHOW_INTERACT_INTERVAL_SHOW_COUNT", i);
    }

    public static void g(String str, String str2, String str3) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        a(context, str, str2, str3);
    }

    public static void l(String str, String str2, boolean z) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        b(context, str, str2, true);
    }

    public static boolean m(String str, String str2, boolean z) {
        Context context = getContext();
        if (context == null) {
            return false;
        }
        return c(context, str, str2, false);
    }

    private static void a(String str, String str2, long j) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        a(context, str, str2, j);
    }

    public static int b(String str, String str2, int i) {
        Context context = getContext();
        if (context == null) {
            return 0;
        }
        return b(context, str, str2, 0);
    }

    public static void h(Context context, String str, String str2) {
        if (context == null) {
            return;
        }
        if (x.Mf()) {
            bg.aw(str, str2);
        } else {
            com.kwad.sdk.utils.a.e.av(context, str).remove(str2);
            x.ar(str2, "");
        }
    }

    public static void a(String str, String str2, int i) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        a(context, str, str2, i);
    }

    public static String b(Context context, String str, String str2, String str3) {
        String string;
        if (context == null) {
            return str3;
        }
        if (x.Mf()) {
            string = bg.h(str, str2, str3);
            if (com.kwad.framework.a.a.md.booleanValue()) {
                com.kwad.sdk.core.e.c.d("Ks_UnionUtils", "getString From Sp key:" + str2 + " value:" + string);
            }
        } else {
            com.kwad.sdk.utils.a.e.av(context, str);
            string = com.kwad.sdk.utils.a.e.av(context, str).getString(str2, str3);
            x.as(str2, string);
            if (com.kwad.framework.a.a.md.booleanValue()) {
                com.kwad.sdk.core.e.c.d("Ks_UnionUtils", "getString key:" + str2 + " value:" + string);
            }
        }
        return com.kwad.sdk.core.a.c.dT(string) ? com.kwad.sdk.core.a.c.dS(string) : string;
    }

    public static void a(Context context, @NonNull String str, @NonNull String str2, String str3) {
        if (context == null) {
            return;
        }
        if (x.Mf()) {
            bg.g(str, str2, str3);
            if (com.kwad.framework.a.a.md.booleanValue()) {
                com.kwad.sdk.core.e.c.d("Ks_UnionUtils", "putString Sp key:" + str2 + " value:" + str3);
                return;
            }
            return;
        }
        com.kwad.sdk.utils.a.e.av(context, str).putString(str2, str3);
        if (com.kwad.framework.a.a.md.booleanValue()) {
            com.kwad.sdk.core.e.c.d("Ks_UnionUtils", "putString key:" + str2 + " value:" + str3);
        }
        x.ar(str2, str3);
    }

    private static void a(Context context, @NonNull String str, @NonNull String str2, String str3, boolean z) {
        if (context == null) {
            return;
        }
        if (x.Mf()) {
            bg.a(str, str2, str3, z);
            if (com.kwad.framework.a.a.md.booleanValue()) {
                com.kwad.sdk.core.e.c.d("Ks_UnionUtils", "putString Sp key:" + str2 + " value:" + str3);
                return;
            }
            return;
        }
        com.kwad.sdk.utils.a.e.av(context, str).putString(str2, str3);
        if (com.kwad.framework.a.a.md.booleanValue()) {
            com.kwad.sdk.core.e.c.d("Ks_UnionUtils", "putString key:" + str2 + " value:" + str3);
        }
        x.ar(str2, str3);
    }

    private static long b(Context context, String str, String str2, long j) {
        if (context == null) {
            return j;
        }
        if (x.Mf()) {
            return bg.b(str, str2, j);
        }
        return com.kwad.sdk.utils.a.e.av(context, str).getLong(str2, j);
    }

    private static int b(Context context, String str, String str2, int i) {
        if (context == null) {
            return i;
        }
        if (x.Mf()) {
            return bg.b(str, str2, i);
        }
        return com.kwad.sdk.utils.a.e.av(context, str).getInt(str2, i);
    }

    private static void b(Context context, String str, String str2, boolean z) {
        if (context == null) {
            return;
        }
        if (x.Mf()) {
            bg.l(str, str2, z);
        } else {
            com.kwad.sdk.utils.a.e.av(context, str).putBoolean(str2, z);
        }
    }

    private static void a(Context context, String str, String str2, long j) {
        if (context == null) {
            return;
        }
        if (x.Mf()) {
            bg.a(str, str2, j);
        } else {
            com.kwad.sdk.utils.a.e.av(context, str).putLong(str2, j);
        }
    }

    private static void a(Context context, String str, String str2, int i) {
        if (context == null) {
            return;
        }
        if (x.Mf()) {
            bg.a(str, str2, i);
        } else {
            com.kwad.sdk.utils.a.e.av(context, str).putInt(str2, i);
        }
    }
}
