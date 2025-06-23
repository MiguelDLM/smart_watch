package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.an;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import o0oIxXOx.oO;

/* loaded from: classes7.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static volatile e f6324a;

    private e() {
    }

    public static e a() {
        if (f6324a == null) {
            synchronized (e.class) {
                try {
                    if (f6324a == null) {
                        f6324a = new e();
                    }
                } finally {
                }
            }
        }
        return f6324a;
    }

    public void a(double d, an.b bVar) {
        cs a2 = cs.a();
        String c = a2.c(x.f6361a);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(com.kuaishou.weapon.p0.t.c, "" + d);
        hashMap.put(oO.f31192XO, "android");
        hashMap.put("tp", a(bn.a((Context) null).d()));
        hashMap.put("bdr", a(bn.a((Context) null).b()));
        an anVar = new an(a2.a(c, hashMap));
        anVar.a(bVar);
        anVar.b();
    }

    public String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException | NullPointerException unused) {
            return str;
        }
    }

    public DexClassLoader a(String str, String str2, String str3, ClassLoader classLoader) {
        try {
            File file = new File(str);
            if (!file.exists()) {
                return null;
            }
            file.setReadOnly();
            return new DexClassLoader(str, str2, str3, classLoader);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
