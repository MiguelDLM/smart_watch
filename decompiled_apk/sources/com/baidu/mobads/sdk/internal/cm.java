package com.baidu.mobads.sdk.internal;

import XIXIX.OOXIXo;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import com.baidu.platform.comapi.map.MapBundleKey;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import o0oIxXOx.oO;

/* loaded from: classes7.dex */
public class cm {
    public static final String b = "404";
    public static final int c = 843;
    protected final bv d = bv.a();
    private Context h;

    /* renamed from: a, reason: collision with root package name */
    public static final String f6276a = x.b;
    private static cm g = new cm();
    public static volatile String e = "";
    public static volatile String f = "";
    private static AtomicBoolean i = new AtomicBoolean(false);
    private static String j = "";
    private static AtomicBoolean k = new AtomicBoolean(false);
    private static String l = "";

    private cm() {
    }

    public static cm a() {
        return g;
    }

    private String d() {
        String str = cn.e;
        if (cn.d.equals(str)) {
            try {
                double b2 = cb.b(cb.a(this.h));
                if (b2 > OOXIXo.f3760XO) {
                    return String.valueOf(b2);
                }
                return str;
            } catch (Throwable th) {
                this.d.a(th);
                return str;
            }
        }
        return str;
    }

    public String b() {
        try {
            if (i.compareAndSet(false, true)) {
                Class<?> cls = Class.forName("com.huawei.system.BuildEx");
                String str = (String) cls.getMethod("getOsBrand", null).invoke(cls, null);
                if (!TextUtils.isEmpty(str)) {
                    j = str;
                }
            }
            return j;
        } catch (Throwable th) {
            this.d.a(th);
            return j;
        }
    }

    public String c() {
        try {
            if (k.get()) {
                return l;
            }
            if (!i.get()) {
                b();
            }
            if (j.equalsIgnoreCase("")) {
                k.set(true);
                return "";
            }
            if (k.compareAndSet(false, true)) {
                String a2 = a("hw_sc.build.platform.version", "");
                if (!TextUtils.isEmpty(a2)) {
                    l = a2;
                }
            }
            return l;
        } catch (Throwable th) {
            this.d.a(th);
            return l;
        }
    }

    public void a(Context context) {
        if (this.h == null) {
            this.h = context;
        }
    }

    public void a(String str, String str2, String str3) {
        try {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put(MapBundleKey.MapObjKey.OBJ_AD, str3);
            hashMap.put("stacktrace", str2);
            a(str, b, hashMap);
        } catch (Exception e2) {
            this.d.a(e2);
        }
    }

    private void a(String str, String str2, HashMap<String, String> hashMap) {
        Uri.Builder builder = new Uri.Builder();
        try {
            Uri.Builder appendQueryParameter = builder.appendQueryParameter("type", str2).appendQueryParameter("subtype", String.valueOf(c)).appendQueryParameter("p_ver", "9.35").appendQueryParameter("appsid", a("appsid", new Object[0])).appendQueryParameter(com.kuaishou.weapon.p0.t.c, "android_" + d() + "_" + cn.f);
            Context context = this.h;
            appendQueryParameter.appendQueryParameter("pack", context != null ? context.getPackageName() : "").appendQueryParameter("sn", a("encodedSn", this.h)).appendQueryParameter("cuid", a("encodedCUID", this.h)).appendQueryParameter(oO.f31192XO, "android").appendQueryParameter("osv", bn.a(this.h).c()).appendQueryParameter("romn", b()).appendQueryParameter("romv", c()).appendQueryParameter("bdr", "" + bn.a(this.h).a()).appendQueryParameter("brd", "" + a(bn.a(this.h).e()));
            if (str != null && str.length() > 128) {
                int indexOf = str.indexOf(10);
                if (indexOf <= 0) {
                    indexOf = 127;
                }
                str = str.substring(0, indexOf);
            }
            builder.appendQueryParameter("reason", str);
            if (hashMap != null) {
                for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                    builder.appendQueryParameter(entry.getKey(), entry.getValue());
                }
            }
        } catch (Throwable th) {
            this.d.a(th);
        }
        an anVar = new an(f6276a, "POST");
        anVar.a(builder);
        anVar.b();
    }

    private String a(String str, Object... objArr) {
        IXAdContainerFactory c2;
        aa a2 = aa.a();
        if (a2 != null && (c2 = a2.c()) != null) {
            Object remoteParam = c2.getRemoteParam(str, objArr);
            if (remoteParam instanceof String) {
                return (String) remoteParam;
            }
            return "";
        }
        return "";
    }

    private String a(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    private String a(String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str3 = (String) cls.getDeclaredMethod("get", String.class).invoke(cls, str);
            return TextUtils.isEmpty(str3) ? str2 : str3;
        } catch (Throwable th) {
            this.d.a(th);
            return str2;
        }
    }
}
