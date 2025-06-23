package com.baidu.xclient.gdid;

import android.content.Context;
import android.util.Base64;
import com.baidu.mobads.sdk.api.IAdInterListener;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static volatile b f10223a;
    public Context b;

    public static b a() {
        if (f10223a == null) {
            synchronized (b.class) {
                try {
                    if (f10223a == null) {
                        f10223a = new b();
                    }
                } finally {
                }
            }
        }
        return f10223a;
    }

    public void b() {
        long b = f.a().b();
        if (System.currentTimeMillis() - b < f.a().c()) {
            return;
        }
        c();
    }

    public final void c() {
        String b;
        try {
            if (com.baidu.xclient.gdid.e.d.a(this.b) && com.baidu.mshield.b.e.a.c(this.b) && (b = new com.baidu.xclient.gdid.b.a(this.b, null).b()) != null) {
                f.a().a(System.currentTimeMillis());
                if ("".equals(b)) {
                    return;
                }
                JSONObject jSONObject = new JSONObject(b);
                f.a().a(jSONObject.optInt("1", 1));
                JSONObject optJSONObject = jSONObject.optJSONObject("2");
                if (optJSONObject != null) {
                    long optLong = optJSONObject.optLong("j");
                    if (optLong >= 0) {
                        f.a().d(optLong * com.baidu.xclient.gdid.c.a.f10226a);
                    }
                    int optInt = optJSONObject.optInt("m", -1);
                    if (optInt != -1) {
                        if (optInt == 1) {
                            f.a().a(true);
                        } else {
                            f.a().a(false);
                        }
                    }
                    int optInt2 = optJSONObject.optInt(com.kwad.sdk.m.e.TAG, -1);
                    if (optInt2 != -1) {
                        if (optInt2 == 1) {
                            f.a().b(true);
                        } else {
                            f.a().b(false);
                        }
                    }
                    int optInt3 = optJSONObject.optInt("d", -1);
                    if (optInt3 == 1) {
                        f.a().c(true);
                    } else if (optInt3 == 0) {
                        f.a().c(false);
                    }
                    int optInt4 = optJSONObject.optInt("i", -1);
                    if (optInt4 != -1) {
                        if (optInt4 == 1) {
                            f.a().g(true);
                        } else {
                            f.a().g(false);
                        }
                    }
                    int optInt5 = optJSONObject.optInt(IAdInterListener.AdReqParam.WIDTH, -1);
                    if (optInt5 != -1) {
                        if (optInt5 == 1) {
                            f.a().i(true);
                        } else {
                            f.a().i(false);
                        }
                    }
                    String optString = optJSONObject.optString("p", "-1");
                    if (!optString.equals("-1")) {
                        f.a().f(optString);
                    }
                    f.a().b(Base64.encodeToString(optJSONObject.toString().getBytes(), 1));
                    int optInt6 = optJSONObject.optInt("o", -1);
                    if (optInt6 == 1) {
                        f.a().h(true);
                    } else if (optInt6 == 0) {
                        f.a().h(false);
                    }
                    int optInt7 = optJSONObject.optInt("a", -1);
                    if (optInt7 == 1) {
                        f.a().j(true);
                    } else if (optInt7 == 0) {
                        f.a().j(false);
                    }
                    int optInt8 = optJSONObject.optInt("t", -1);
                    if (optInt8 == 1) {
                        f.a().k(true);
                    } else if (optInt8 == 0) {
                        f.a().k(false);
                    }
                    int optInt9 = optJSONObject.optInt("n", -1);
                    if (optInt9 == 1) {
                        f.a().l(true);
                    } else if (optInt9 == 0) {
                        f.a().l(false);
                    }
                    int optInt10 = optJSONObject.optInt(IAdInterListener.AdReqParam.HEIGHT, -1);
                    if (optInt10 == 1) {
                        f.a().e(true);
                    } else if (optInt10 == 0) {
                        f.a().e(false);
                    }
                    int optInt11 = optJSONObject.optInt(com.baidu.mapsdkplatform.comapi.f.f6163a, -1);
                    if (optInt11 == 1) {
                        f.a().f(true);
                    } else if (optInt11 == 0) {
                        f.a().f(false);
                    }
                    int optInt12 = optJSONObject.optInt("aa", -1);
                    if (optInt12 == 1) {
                        f.a().d(true);
                    } else if (optInt12 == 0) {
                        f.a().d(false);
                    }
                }
                if (jSONObject.optJSONObject("6") != null) {
                    f.a().b(r0.optInt("1", 0) * com.baidu.xclient.gdid.c.a.f10226a);
                    f.a().f(r0.optInt("2", 0) * com.baidu.xclient.gdid.c.a.f10226a);
                    f.a().h(r0.optInt("4", 0) * com.baidu.xclient.gdid.c.a.f10226a);
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("7");
                if (optJSONObject2 != null) {
                    f.a().e(optJSONObject2.optInt("s", -1));
                    f.a().b(optJSONObject2.optInt("d", -1));
                    f.a().c(optJSONObject2.optInt("j", -1));
                    f.a().d(optJSONObject2.optInt("c", -1));
                    f.a().f(optJSONObject2.optInt("o", -1));
                }
                String optString2 = jSONObject.optString("5");
                if (f.a().f().equals(optString2)) {
                    return;
                }
                f.a().a(optString2);
                String optString3 = jSONObject.optString("3", "");
                String optString4 = jSONObject.optString("4", "");
                String optString5 = jSONObject.optString("8", "");
                f.a().d(optString3);
                f.a().e(optString4);
                f.a().g(optString5);
            }
        } catch (Throwable th) {
            com.baidu.xclient.gdid.e.d.a(th);
        }
    }

    public void a(Context context) {
        this.b = context;
        b();
    }
}
