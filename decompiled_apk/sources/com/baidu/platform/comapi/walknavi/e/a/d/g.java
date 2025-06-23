package com.baidu.platform.comapi.walknavi.e.a.d;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.tts.emstatistics.TtsStatsUploadBag;

/* loaded from: classes8.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private final Context f9730a;

    public g(Context context) {
        this.f9730a = context;
    }

    private SharedPreferences c() {
        return this.f9730a.getSharedPreferences("ar_so_info", 0);
    }

    public String a() {
        return c().getString(TtsStatsUploadBag.KEY_ENGINE_VERSION, "");
    }

    public void b(String str) {
        c().edit().putString("ar_sdk_version", str).commit();
    }

    public void a(String str) {
        c().edit().putString(TtsStatsUploadBag.KEY_ENGINE_VERSION, str).commit();
    }

    public String b() {
        return c().getString("ar_sdk_version", "");
    }
}
