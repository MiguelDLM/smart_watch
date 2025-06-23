package com.bytedance.pangle.util;

import android.content.SharedPreferences;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import java.util.Locale;

/* loaded from: classes8.dex */
public class l {
    private static volatile l b;

    /* renamed from: a, reason: collision with root package name */
    public SharedPreferences f10637a = Zeus.getAppApplication().getSharedPreferences("pangle_meta_data_sp", 0);

    private l() {
    }

    public static l a() {
        if (b == null) {
            synchronized (l.class) {
                try {
                    if (b == null) {
                        b = new l();
                    }
                } finally {
                }
            }
        }
        return b;
    }

    public final String b(String str) {
        String string = this.f10637a.getString("HOST_IDENTITY_".concat(String.valueOf(str)), "");
        ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils getHostIdentity pluginPKg = " + str + ", hostIdentity = " + string);
        return string;
    }

    public final void c(String str, int i, boolean z) {
        SharedPreferences.Editor edit = this.f10637a.edit();
        edit.putBoolean("dex_remove_state_" + str + "_" + i, z);
        edit.apply();
    }

    public final void b(String str, int i, boolean z) {
        SharedPreferences.Editor edit = this.f10637a.edit();
        edit.putBoolean("dex_opt_state_" + str + "_" + i, z);
        edit.apply();
    }

    public final int a(String str) {
        int i = this.f10637a.getInt("PLUGIN_API_VERSION_".concat(String.valueOf(str)), 0);
        ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils getPluginApiVersion pluginPKg = " + str + ", pluginApiVersion = " + i);
        return i;
    }

    public final int b(String str, int i) {
        return this.f10637a.getInt("remove_entry_flag_" + str + "_" + i, 0);
    }

    public final void a(String str, int i, boolean z) {
        SharedPreferences.Editor edit = this.f10637a.edit();
        String str2 = "INSTALLED_" + str + HelpFormatter.DEFAULT_OPT_PREFIX + i;
        if (z) {
            edit.putBoolean(str2, true);
        } else {
            edit.remove(str2);
        }
        edit.apply();
    }

    public final int b(String str, int i, String str2) {
        return this.f10637a.getInt(str2 + "_failed_count_when_rm_entry_" + str + "_" + i, 0);
    }

    public final boolean a(String str, int i) {
        return this.f10637a.getBoolean(String.format(Locale.getDefault(), "INSTALLED_%s-%d", str, Integer.valueOf(i)), false);
    }

    public final void a(String str, int i, String str2) {
        int b2 = b(str, i, str2);
        SharedPreferences.Editor edit = this.f10637a.edit();
        edit.putInt(str2 + "_failed_count_when_rm_entry_" + str + "_" + i, b2 + 1);
        edit.apply();
    }
}
