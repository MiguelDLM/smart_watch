package com.baidu.mshield.x6.c;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.mshield.b.a.c;
import com.baidu.mshield.b.d.d;
import com.baidu.mshield.b.f.e;
import com.baidu.mshield.x6.e.f;
import com.baidu.mshield.x6.e.h;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class a extends com.baidu.mshield.b.d.a {
    public b c;

    public a(Context context, Handler handler) {
        super(context, handler);
        this.b = context;
        this.c = b.a(context);
    }

    public String a(String str) {
        String a2;
        String a3;
        try {
            try {
                a2 = h.a(16);
                a3 = this.c.a(a2);
            } catch (Throwable th) {
                f.a(th);
                return "";
            }
        } catch (Throwable th2) {
            f.a(th2);
        }
        if (TextUtils.isEmpty(a3)) {
            return "";
        }
        String a4 = a(a3, h.a(c.a(str.getBytes()), a2.getBytes()));
        com.baidu.mshield.b.c.a.a("getBdid:" + a4);
        if (TextUtils.isEmpty(a4)) {
            return "";
        }
        try {
            JSONObject jSONObject = new JSONObject(a4);
            String string = jSONObject.getString("data");
            com.baidu.mshield.b.c.a.a("dataStr:" + string);
            String string2 = jSONObject.getString("skey");
            if (string != null && string2 != null) {
                String str2 = new String(h.b(Base64.decode(string, 0), h.d(Base64.decode(string2.getBytes(), 0), e.a(com.baidu.mshield.utility.c.a(this.b)).getBytes())));
                com.baidu.mshield.b.c.a.a("dataDecrypt:" + str2);
                return str2;
            }
            return "";
        } catch (Throwable th3) {
            f.a(th3);
            return "";
        }
    }

    public String b(String str) {
        com.baidu.mshield.x6.a.b bVar;
        String a2;
        String b;
        try {
            bVar = new com.baidu.mshield.x6.a.b(this.b);
            try {
                try {
                    try {
                        a2 = h.a(16);
                        b = this.c.b(a2);
                    } catch (d unused) {
                        com.baidu.mshield.b.c.a.a("getCheckZipResponse:NetworkErrorWrongResponseCodeException");
                        if (bVar.E() == 0) {
                            bVar.h(-3);
                        }
                        return "";
                    }
                } catch (Throwable th) {
                    f.a(th);
                    return "";
                }
            } catch (InterruptedException e) {
                bVar.a(0);
                f.a(e);
                return "";
            }
        } catch (Throwable th2) {
            f.a(th2);
        }
        if (TextUtils.isEmpty(b)) {
            return "";
        }
        String a3 = a(b, h.a(c.a(str.getBytes()), a2.getBytes()));
        com.baidu.mshield.b.c.a.a("getCheckZipResponse:" + a3);
        if (TextUtils.isEmpty(a3)) {
            return "";
        }
        bVar.v("");
        bVar.m(0);
        bVar.w("");
        bVar.i(0);
        bVar.u("");
        bVar.a(1);
        try {
            JSONObject jSONObject = new JSONObject(a3);
            String string = jSONObject.getString("data");
            com.baidu.mshield.b.c.a.a("dataStr:" + string);
            String string2 = jSONObject.getString("skey");
            if (string != null && string2 != null) {
                String str2 = new String(h.b(Base64.decode(string, 0), h.d(Base64.decode(string2.getBytes(), 0), e.a(com.baidu.mshield.utility.c.a(this.b)).getBytes())));
                com.baidu.mshield.b.c.a.a("dataDecrypt:" + str2);
                return str2;
            }
            return "";
        } catch (Throwable th3) {
            f.a(th3);
            if (bVar.E() == 0) {
                bVar.h(-3);
            }
            return "";
        }
    }

    public String c(String str) {
        String str2;
        String a2;
        String d;
        try {
            try {
                a2 = h.a(16);
                d = this.c.d(a2);
            } catch (Throwable th) {
                f.a(th);
                str2 = "";
            }
            if (TextUtils.isEmpty(d)) {
                return "";
            }
            byte[] a3 = h.a(c.a(str.getBytes()), a2.getBytes());
            com.baidu.mshield.b.c.a.a("getCharacter:" + d);
            str2 = a(d, a3);
            com.baidu.mshield.b.c.a.a("getCharacter resp:" + str2);
            if (TextUtils.isEmpty(str2)) {
                return "";
            }
            try {
                JSONObject jSONObject = new JSONObject(str2);
                String optString = jSONObject.optString("skey");
                String str3 = new String(h.b(Base64.decode(jSONObject.optString("data").getBytes(), 0), h.d(Base64.decode(optString.getBytes(), 0), e.a(com.baidu.mshield.utility.c.a(this.b)).getBytes())));
                if (TextUtils.isEmpty(str3)) {
                    return "";
                }
                com.baidu.mshield.b.c.a.a("getCharacter sdata:" + str3);
                return str3;
            } catch (Throwable th2) {
                f.a(th2);
                return "";
            }
        } catch (Throwable th3) {
            f.a(th3);
            return "";
        }
    }
}
