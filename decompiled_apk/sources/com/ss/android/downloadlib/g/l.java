package com.ss.android.downloadlib.g;

import android.text.TextUtils;
import android.util.Log;

/* loaded from: classes11.dex */
public class l {

    /* loaded from: classes11.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static l f26129a = new l();
    }

    public static l a() {
        return a.f26129a;
    }

    public void b(String str, String str2, String str3) {
        String str4;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            str4 = String.format("sdk:%s.%s:", str, str2);
        } else {
            str4 = "";
        }
        Log.e("[TTDownloaderLogger]", str4 + str3);
    }

    private l() {
    }

    public void a(String str, String str2, String str3) {
        String str4;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            str4 = String.format("sdk:%s.%s:", str, str2);
        } else {
            str4 = "";
        }
        Log.d("[TTDownloaderLogger]", str4 + str3);
    }
}
