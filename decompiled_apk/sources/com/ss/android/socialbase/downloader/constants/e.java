package com.ss.android.socialbase.downloader.constants;

import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: classes13.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public static volatile String f26241a = "";
    public static volatile String b = "";
    public static volatile String c = "";
    public static long d = 512000;
    public static long e = 50;
    public static long f = 5242880;
    public static long g = 31457280;
    public static long h = 10485760;
    public static final JSONObject i = new JSONObject();

    public static void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f26241a = str;
    }
}
