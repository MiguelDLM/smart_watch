package com.baidu.mshield.x0.g;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.mshield.b.a.g;
import com.baidu.mshield.b.f.e;
import com.baidu.mshield.x0.EngineImpl;
import com.baidu.mshield.x0.b.d;
import com.baidu.mshield.x6.e.f;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class a extends com.baidu.mshield.b.d.a {
    public b c;

    public a(Context context, Handler handler) {
        super(context, handler);
        this.b = context;
        this.c = b.a(context);
    }

    public HashMap<String, String> b() {
        HashMap<String, String> hashMap;
        String str;
        String str2;
        HashMap<String, String> hashMap2 = new HashMap<>();
        String str3 = "";
        try {
            byte[] a2 = d.a();
            try {
                str = this.c.a(URLEncoder.encode(Base64.encodeToString(com.baidu.mshield.b.f.d.c(a2, e.a(com.baidu.mshield.utility.c.a(this.b)).getBytes()), 0)));
            } catch (Throwable th) {
                d.a(th);
                str = "";
            }
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                try {
                    JSONObject jSONObject = new JSONObject();
                    JSONObject jSONObject2 = new JSONObject();
                    com.baidu.mshield.x0.j.a aVar = new com.baidu.mshield.x0.j.a(this.b);
                    jSONObject2.put("so", aVar.g());
                    jSONObject.put("jwl", jSONObject2);
                    JSONObject jSONObject3 = new JSONObject();
                    JSONObject jSONObject4 = new JSONObject();
                    String a3 = aVar.a("plc114");
                    String str4 = str;
                    if (!TextUtils.isEmpty(a3)) {
                        JSONObject jSONObject5 = new JSONObject(a3);
                        if (jSONObject5.has("5") && jSONObject5.optJSONObject("5").has("uv6")) {
                            String optString = jSONObject5.optJSONObject("5").optJSONObject("uv6").optString("4", "");
                            String optString2 = jSONObject5.optJSONObject("5").optJSONObject("uv6").optString("5", "");
                            String optString3 = jSONObject5.optJSONObject("5").optJSONObject("uv6").optString("6", "");
                            jSONObject4.put("4", optString);
                            jSONObject4.put("5", optString2);
                            jSONObject4.put("6", optString3);
                        }
                    } else {
                        jSONObject4.put("4", "0");
                        jSONObject4.put("5", "0");
                        jSONObject4.put("6", "0");
                    }
                    jSONObject3.put("uv6", jSONObject4);
                    JSONObject jSONObject6 = new JSONObject();
                    jSONObject6.put("4", "");
                    String a4 = aVar.a("plc115");
                    if (!TextUtils.isEmpty(a4)) {
                        JSONObject optJSONObject = new JSONObject(a4).optJSONObject("5");
                        if (optJSONObject.has("uv4") && optJSONObject.optJSONObject("uv4").has("4")) {
                            jSONObject6.put("4", optJSONObject.optJSONObject("uv4").optString("4"));
                        }
                    }
                    jSONObject3.put("uv4", jSONObject6);
                    jSONObject.put("sec", jSONObject3);
                    try {
                        String w = new com.baidu.mshield.x6.a.b(this.b).w();
                        if (!TextUtils.isEmpty(w)) {
                            JSONObject jSONObject7 = new JSONObject();
                            jSONObject7.put("ver", w);
                            jSONObject.put("sig", jSONObject7);
                        }
                    } catch (Throwable th2) {
                        d.a(th2);
                    }
                    try {
                        com.baidu.mshield.x6.a.b bVar = new com.baidu.mshield.x6.a.b(this.b);
                        JSONObject jSONObject8 = new JSONObject();
                        jSONObject8.put("1", bVar.u());
                        String y = bVar.y();
                        if (TextUtils.isEmpty(y)) {
                            String a5 = g.a(this.b);
                            com.baidu.mshield.b.c.a.b(" manufacturer: " + a5.toLowerCase());
                            if (!TextUtils.isEmpty(a5)) {
                                y = e.a(a5.toLowerCase());
                                bVar.p(y);
                            }
                        }
                        jSONObject8.put("2", y);
                        String x = bVar.x();
                        if (TextUtils.isEmpty(x)) {
                            String propertyByType = EngineImpl.getInstance(this.b).getPropertyByType("mod");
                            com.baidu.mshield.b.c.a.b(" model: " + propertyByType.toLowerCase());
                            if (!TextUtils.isEmpty(propertyByType)) {
                                x = e.a(propertyByType.toLowerCase());
                                bVar.o(x);
                            }
                        }
                        jSONObject8.put("3", x);
                        String z = bVar.z();
                        if (TextUtils.isEmpty(z)) {
                            String lowerCase = Build.ID.toLowerCase();
                            com.baidu.mshield.b.c.a.b(" buildId: " + lowerCase);
                            z = e.a(lowerCase);
                            bVar.q(z);
                        }
                        jSONObject8.put("4", z);
                        String B = bVar.B();
                        if (TextUtils.isEmpty(B)) {
                            String b = g.b(this.b);
                            com.baidu.mshield.b.c.a.b(" romName: " + b.toLowerCase());
                            if (!TextUtils.isEmpty(b)) {
                                B = e.a(b.toLowerCase());
                                bVar.s(B);
                            }
                        }
                        jSONObject8.put("5", B);
                        String C = bVar.C();
                        if (TextUtils.isEmpty(C)) {
                            String c = g.c(this.b);
                            com.baidu.mshield.b.c.a.b(" romVersion: " + c.toLowerCase());
                            if (!TextUtils.isEmpty(c)) {
                                C = e.a(c.toLowerCase());
                                bVar.t(C);
                            }
                        }
                        jSONObject8.put("6", C);
                        String A = bVar.A();
                        if (TextUtils.isEmpty(A)) {
                            String propertyByType2 = EngineImpl.getInstance(this.b).getPropertyByType("arv");
                            com.baidu.mshield.b.c.a.b(" romVersion: " + propertyByType2.toLowerCase());
                            if (!TextUtils.isEmpty(propertyByType2)) {
                                A = e.a(propertyByType2.toLowerCase());
                                bVar.r(A);
                            }
                        }
                        jSONObject8.put("7", A);
                        String f = f.f(this.b);
                        if (TextUtils.isEmpty(f)) {
                            jSONObject8.put("9", "");
                        } else {
                            try {
                                jSONObject8.put("9", new JSONObject(f).optString("2", ""));
                            } catch (Throwable th3) {
                                d.a(th3);
                            }
                        }
                        jSONObject.put(com.baidu.mapsdkplatform.comapi.f.f6163a, jSONObject8);
                    } catch (Throwable th4) {
                        d.a(th4);
                    }
                    try {
                        jSONObject.put("prv", "1");
                        JSONObject jSONObject9 = new JSONObject();
                        jSONObject9.put("cu", d.j(this.b));
                        jSONObject9.put("zi", com.baidu.mshield.utility.c.a(this.b));
                        jSONObject9.put("cuw", new com.baidu.mshield.x6.a.c(this.b).f());
                        jSONObject.put("ids", jSONObject9);
                    } catch (Throwable th5) {
                        d.a(th5);
                    }
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.put(jSONObject);
                    String jSONObject10 = d.a(this.b, "1044103", jSONArray).toString();
                    byte[] a6 = this.c.a(a2, jSONObject10);
                    com.baidu.mshield.b.c.a.b("getPolicy: " + jSONObject10);
                    String a7 = a(str4, a6);
                    new com.baidu.mshield.x6.a.b(this.b).a(System.currentTimeMillis(), !TextUtils.isEmpty(a7));
                    com.baidu.mshield.b.c.a.b("get policy r: " + a7);
                    if (TextUtils.isEmpty(a7)) {
                        return null;
                    }
                    try {
                        JSONObject jSONObject11 = new JSONObject(a7);
                        String optString4 = jSONObject11.optString("skey");
                        str3 = jSONObject11.optString("data");
                        str2 = new String(com.baidu.mshield.b.a.c.b(com.baidu.mshield.b.f.d.b(Base64.decode(str3.getBytes(), 0), com.baidu.mshield.b.f.d.d(Base64.decode(optString4.getBytes(), 0), a().getBytes()))));
                    } catch (Throwable th6) {
                        d.a(th6);
                        str2 = str3;
                    }
                    if (TextUtils.isEmpty(str2)) {
                        return null;
                    }
                    com.baidu.mshield.b.c.a.b("policy d: " + str2);
                    hashMap2.put("url", str4);
                    hashMap2.put("source", a7);
                    hashMap2.put("decrpt", str2);
                    return hashMap2;
                } catch (Throwable th7) {
                    d.a(th7);
                    return null;
                }
            } catch (Throwable th8) {
                th = th8;
                hashMap = null;
                d.a(th);
                return hashMap;
            }
        } catch (Throwable th9) {
            th = th9;
            hashMap = null;
        }
    }
}
