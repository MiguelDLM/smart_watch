package com.baidu.xclient.gdid.b;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.mshield.b.f.e;
import com.baidu.xclient.gdid.e.d;
import com.baidu.xclient.gdid.f;
import java.net.URLEncoder;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class a extends com.baidu.mshield.b.d.a {
    public b c;

    public a(Context context, Handler handler) {
        super(context, handler);
        this.b = context;
        this.c = b.a(context);
    }

    public String a(String str, String str2, boolean z) {
        String str3;
        String str4 = "";
        try {
            byte[] a2 = d.a();
            try {
                str3 = this.c.a(str, URLEncoder.encode(Base64.encodeToString(com.baidu.mshield.b.f.d.c(a2, e.a(com.baidu.mshield.b.b.a.a(this.b)).getBytes()), 0)));
            } catch (Throwable th) {
                d.a(th);
                str3 = "";
            }
            if (TextUtils.isEmpty(str3)) {
                return null;
            }
            try {
                String a3 = a(str3, this.c.a(a2, str2));
                if (TextUtils.isEmpty(a3)) {
                    return null;
                }
                if (!z) {
                    return a3;
                }
                try {
                    JSONObject jSONObject = new JSONObject(a3);
                    jSONObject.optString("request_id");
                    String optString = jSONObject.optString("skey");
                    str4 = jSONObject.optString("data");
                    return new String(com.baidu.mshield.b.f.d.b(Base64.decode(str4.getBytes(), 0), com.baidu.mshield.b.f.d.d(Base64.decode(optString.getBytes(), 0), e.a(com.baidu.mshield.b.b.a.a(this.b)).getBytes())));
                } catch (Throwable th2) {
                    d.a(th2);
                    return str4;
                }
            } catch (Throwable th3) {
                d.a(th3);
                return null;
            }
        } catch (Throwable th4) {
            d.a(th4);
            return null;
        }
    }

    public String b() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("2", f.a().f());
            jSONObject.put("1", 2);
            return a("s/3/gd/", jSONObject.toString(), true);
        } catch (Throwable th) {
            d.a(th);
            return null;
        }
    }

    public JSONObject a(JSONObject jSONObject) {
        try {
            String a2 = a("gd/2/pin/", jSONObject.toString(), true);
            if (TextUtils.isEmpty(a2)) {
                return null;
            }
            return new JSONObject(a2);
        } catch (Throwable th) {
            d.a(th);
            return null;
        }
    }

    public boolean a(String str) {
        try {
            String a2 = a("f/2/ejc/", str, false);
            if (TextUtils.isEmpty(a2)) {
                return false;
            }
            try {
                return !new JSONObject(a2).has("err_code");
            } catch (Throwable th) {
                d.a(th);
                return false;
            }
        } catch (Throwable th2) {
            d.a(th2);
        }
    }
}
