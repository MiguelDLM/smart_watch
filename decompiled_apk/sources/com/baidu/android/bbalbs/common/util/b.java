package com.baidu.android.bbalbs.common.util;

import IIIxO.oIX0oI;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.bbalbs.common.security.Base64;
import java.io.File;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
final class b {
    private static final String e = a(new byte[]{81, 72, 116, 79, 75, 72, 69, 52, 76, 51, 103, oIX0oI.f236II0XooXoX}, new byte[]{82, 51, 104, 90, 83, 122, 65, 105, 101, 49, 107, oIX0oI.f236II0XooXoX});
    private static final String f = a(new byte[]{76, 67, 77, 53, 77, 70, 90, 73, 81, 107, 107, oIX0oI.f236II0XooXoX}, new byte[]{90, 105, 108, 121, 79, 68, 100, 81, 86, 121, 89, oIX0oI.f236II0XooXoX});

    /* renamed from: a, reason: collision with root package name */
    private String f5558a;
    private String b;
    private int c = 3;
    private int d;

    public static b a(Context context, String str) {
        return b(context, str);
    }

    public static b b(Context context) {
        File d = d(context);
        if (d.exists()) {
            return d(d.a(d));
        }
        return null;
    }

    public static b c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString(i("ZmxhZw=="), "0");
            String string = jSONObject.getString(i("ZGV2aWNlaWQ="));
            int optInt = jSONObject.optInt(i("c2Rr"), 0);
            if (!TextUtils.isEmpty(string)) {
                b bVar = new b();
                bVar.a(string);
                bVar.b(optString);
                bVar.a(optInt);
                return bVar;
            }
        } catch (JSONException e2) {
            d.a(e2);
        }
        return null;
    }

    public static b d(String str) {
        return c(f(str));
    }

    private static String e(Context context) {
        return h(d.a(context, "XL5g0WZAHpIaKspIHIHYg5k"));
    }

    public static String f(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new String(com.baidu.android.bbalbs.common.security.a.b(e, f, Base64.decode(str.getBytes())));
        } catch (Exception e2) {
            d.a(e2);
            return "";
        }
    }

    public static String g(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return Base64.encode(com.baidu.android.bbalbs.common.security.a.a(f, e, str.getBytes()), "utf-8");
        } catch (UnsupportedEncodingException | Exception e2) {
            d.a(e2);
            return "";
        }
    }

    public static String h(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new String(com.baidu.android.bbalbs.common.security.a.b(f, e, Base64.decode(str.getBytes())));
        } catch (Exception e2) {
            d.a(e2);
            return "";
        }
    }

    public static String i(String str) {
        return new String(Base64.decode(str.getBytes()));
    }

    public static b a(a aVar) {
        if (aVar == null) {
            throw new IllegalArgumentException("arg non-nullable is expected");
        }
        b bVar = new b();
        bVar.a(aVar.a());
        bVar.b(aVar.b());
        return bVar;
    }

    private static b b(Context context, String str) {
        StringBuilder sb;
        b bVar = new b();
        int i = Build.VERSION.SDK_INT;
        boolean z = i < 23;
        String a2 = d.a(context);
        if (z) {
            String e2 = e(context);
            if (TextUtils.isEmpty(e2)) {
                e2 = UUID.randomUUID().toString();
                c(context, e2);
            }
            sb = new StringBuilder();
            sb.append(a2);
            sb.append(e2);
        } else {
            sb = new StringBuilder();
            sb.append("com.baidu");
            sb.append(a2);
        }
        bVar.a(com.baidu.android.bbalbs.common.security.b.a(sb.toString().getBytes(), true));
        bVar.b(str);
        bVar.a(i);
        return bVar;
    }

    private static void c(Context context, String str) {
        if (TextUtils.isEmpty(d.a(context, "XL5g0WZAHpIaKspIHIHYg5k")) && d.b(context)) {
            d.a(context, "XL5g0WZAHpIaKspIHIHYg5k", g(str));
        }
    }

    private static File d(Context context) {
        return new File(context.getFilesDir(), "libcuid_v3.so");
    }

    public static String e(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return Base64.encode(com.baidu.android.bbalbs.common.security.a.a(e, f, str.getBytes()), "utf-8");
        } catch (UnsupportedEncodingException | Exception e2) {
            d.a(e2);
            return "";
        }
    }

    private String b() {
        try {
            JSONObject put = new JSONObject().put(i("ZGV2aWNlaWQ="), this.f5558a);
            String i = i("ZmxhZw==");
            String str = this.b;
            if (str == null) {
                str = "0";
            }
            return put.put(i, str).put(i("dmVy"), this.c).put(i("c2Rr"), this.d).toString();
        } catch (JSONException e2) {
            d.a(e2);
            return null;
        }
    }

    private boolean c(Context context) {
        String e2 = e(b());
        FileOutputStream fileOutputStream = null;
        try {
            try {
                fileOutputStream = context.openFileOutput("libcuid_v3.so", 0);
                fileOutputStream.write(e2.getBytes());
                fileOutputStream.flush();
                try {
                    fileOutputStream.close();
                    return true;
                } catch (Exception e3) {
                    d.a(e3);
                    return true;
                }
            } catch (Throwable th) {
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception e4) {
                        d.a(e4);
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            d.a(e5);
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (Exception e6) {
                    d.a(e6);
                }
            }
            return false;
        }
    }

    public String a() {
        if (TextUtils.isEmpty(this.b)) {
            this.b = "0";
        }
        return this.f5558a + "|" + this.b;
    }

    private static String a(byte[]... bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte[] bArr2 : bArr) {
            sb.append(new String(Base64.decode(bArr2)));
        }
        return sb.toString();
    }

    public void b(String str) {
        this.b = str;
    }

    public void a(int i) {
        this.d = i;
    }

    public void a(String str) {
        this.f5558a = str;
    }

    public boolean a(Context context) {
        return c(context);
    }
}
