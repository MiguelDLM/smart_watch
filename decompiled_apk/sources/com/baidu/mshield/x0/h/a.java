package com.baidu.mshield.x0.h;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.mshield.b.a.c;
import com.baidu.mshield.b.f.e;
import com.baidu.mshield.x0.EngineImpl;
import com.baidu.mshield.x0.b.d;
import com.baidu.mshield.x6.e.f;
import com.baidu.mshield.x6.e.l;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static a f6419a;
    public final Context b;

    /* renamed from: com.baidu.mshield.x0.h.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0148a {
        void a(int i);
    }

    public a(Context context) {
        this.b = context;
    }

    public final void b(JSONObject jSONObject) {
        try {
            com.baidu.mshield.b.c.a.b("handleRmfPolicy:" + jSONObject);
            if (jSONObject == null) {
                l.e = "";
                return;
            }
            boolean a2 = f.a(this.b, false);
            com.baidu.mshield.x6.a.b bVar = new com.baidu.mshield.x6.a.b(this.b);
            if (a2) {
                bVar.x(jSONObject.toString());
                l.e = "";
            } else {
                l.e = jSONObject.toString();
                bVar.O();
            }
            com.baidu.mshield.b.c.a.b("handleRmfPolicy ungz:" + new String(c.b(Base64.decode(jSONObject.optString("1").getBytes(), 0)), "utf-8"));
        } catch (Throwable th) {
            d.a(th);
        }
    }

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (a.class) {
            try {
                if (f6419a == null) {
                    f6419a = new a(context);
                }
                aVar = f6419a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return aVar;
    }

    public final int a(InterfaceC0148a interfaceC0148a) {
        boolean z;
        try {
            com.baidu.mshield.x0.j.a aVar = new com.baidu.mshield.x0.j.a(this.b);
            long b = aVar.b();
            long a2 = aVar.a() * 60000;
            long currentTimeMillis = System.currentTimeMillis();
            if (a2 <= 0) {
                if (interfaceC0148a != null) {
                    interfaceC0148a.a(1);
                }
                return 1;
            }
            if (currentTimeMillis - b >= a2) {
                z = d.b(this.b) ? a() : false;
                aVar.a(currentTimeMillis);
            } else {
                z = false;
            }
            if (z) {
                if (interfaceC0148a != null) {
                    interfaceC0148a.a(0);
                }
                return 0;
            }
            if (interfaceC0148a != null) {
                interfaceC0148a.a(1);
            }
            return 1;
        } catch (Throwable th) {
            d.a(th);
            if (interfaceC0148a != null) {
                interfaceC0148a.a(2);
            }
            return 2;
        }
    }

    public final void b(String str) {
        try {
            com.baidu.mshield.b.c.a.b("handleFgPolicy:" + str);
            l.b(this.b, str);
        } catch (Throwable th) {
            d.a(th);
        }
    }

    public int a(InterfaceC0148a interfaceC0148a, boolean z) {
        if (z) {
            com.baidu.mshield.x0.b.a.d.a().a(new b(this, interfaceC0148a));
            return 0;
        }
        return a(interfaceC0148a);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0059 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x005b A[Catch: all -> 0x017b, TRY_ENTER, TRY_LEAVE, TryCatch #11 {all -> 0x017b, blocks: (B:5:0x0008, B:19:0x004c, B:23:0x005b, B:74:0x00e1, B:59:0x0175, B:64:0x014e, B:68:0x0134, B:72:0x011a, B:78:0x00b8, B:82:0x009f, B:86:0x0088, B:91:0x0047, B:39:0x00bb, B:25:0x0074, B:27:0x007c, B:83:0x0082, B:50:0x0137, B:52:0x013f, B:61:0x0145, B:46:0x011d, B:48:0x0125, B:65:0x012b, B:35:0x00a2, B:37:0x00ab, B:75:0x00b1, B:42:0x00e4, B:44:0x00ed, B:69:0x0113, B:54:0x0151, B:31:0x008b, B:33:0x0093, B:79:0x0099), top: B:4:0x0008, inners: #0, #1, #3, #5, #6, #7, #8, #9 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized boolean a() {
        /*
            Method dump skipped, instructions count: 388
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mshield.x0.h.a.a():boolean");
    }

    public final void a(JSONObject jSONObject) {
        try {
            com.baidu.mshield.b.c.a.b("handleDrfPolicy:" + jSONObject);
            com.baidu.mshield.x6.a.b bVar = new com.baidu.mshield.x6.a.b(this.b);
            if (jSONObject == null) {
                l.d = "";
                return;
            }
            l.d = jSONObject.toString();
            com.baidu.mshield.b.c.a.b("handleDrfPolicy ungz:" + new String(c.b(Base64.decode(jSONObject.optString("1").getBytes(), 0)), "utf-8"));
            bVar.m(jSONObject.optString("2"));
        } catch (Throwable th) {
            d.a(th);
        }
    }

    public final void a(com.baidu.mshield.x0.j.a aVar, JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("5");
        if (optJSONObject != null) {
            int optInt = optJSONObject.optInt("1", 0);
            if (optInt == 0 && aVar.h()) {
                EngineImpl.getInstance(this.b).unload();
            }
            aVar.c(optInt);
            aVar.d(optJSONObject.optInt("9", 0));
            aVar.e(optJSONObject.optInt("15", 3));
        }
    }

    public final void a(JSONObject jSONObject, String str, String str2, String str3) {
        String str4;
        String str5;
        String str6;
        int i;
        try {
            com.baidu.mshield.b.c.a.b("handleSecPolicy:" + jSONObject.toString());
            com.baidu.mshield.x0.j.a aVar = new com.baidu.mshield.x0.j.a(this.b);
            JSONObject optJSONObject = jSONObject.optJSONObject("3");
            if (optJSONObject != null) {
                str4 = "95";
                try {
                    aVar.a("plc03", optJSONObject.toString());
                    com.baidu.mshield.b.c.a.b("3" + optJSONObject);
                } catch (Throwable th) {
                    th = th;
                    d.a(th);
                    return;
                }
            } else {
                str4 = "95";
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("15");
            if (optJSONObject2 != null) {
                aVar.a("plc15", optJSONObject2.toString());
                com.baidu.mshield.b.c.a.b("15" + optJSONObject2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("16");
            if (optJSONObject3 != null) {
                aVar.a("plc16", optJSONObject3.toString());
                com.baidu.mshield.b.c.a.b("16" + optJSONObject3);
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("18");
            if (optJSONObject4 != null) {
                aVar.a("plc18", optJSONObject4.toString());
                com.baidu.mshield.b.c.a.b("18" + optJSONObject4);
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("20");
            if (optJSONObject5 != null) {
                aVar.a("plc20", optJSONObject5.toString());
                com.baidu.mshield.b.c.a.b("20" + optJSONObject5);
            }
            JSONObject optJSONObject6 = jSONObject.optJSONObject("36");
            if (optJSONObject6 != null) {
                aVar.a("plc36", optJSONObject6.toString());
                com.baidu.mshield.b.c.a.b("36" + optJSONObject6);
            }
            JSONObject optJSONObject7 = jSONObject.optJSONObject("62");
            if (optJSONObject7 != null) {
                aVar.a("plc62", optJSONObject7.toString());
                com.baidu.mshield.b.c.a.b("62" + optJSONObject7.toString());
            }
            JSONObject optJSONObject8 = jSONObject.optJSONObject("71");
            if (optJSONObject8 != null) {
                aVar.a("plc71", optJSONObject8.toString());
                com.baidu.mshield.b.c.a.b("71" + optJSONObject8);
            }
            JSONObject optJSONObject9 = jSONObject.optJSONObject("83");
            if (optJSONObject9 != null) {
                aVar.a("plc83", optJSONObject9.toString());
                com.baidu.mshield.b.c.a.b("83" + optJSONObject9);
            }
            JSONObject optJSONObject10 = jSONObject.optJSONObject("84");
            if (optJSONObject10 != null) {
                aVar.a("plc84", optJSONObject10.toString());
                com.baidu.mshield.b.c.a.b("84" + optJSONObject10);
            }
            JSONObject optJSONObject11 = jSONObject.optJSONObject("94");
            if (optJSONObject11 != null) {
                aVar.a("plc94", optJSONObject11.toString());
                com.baidu.mshield.b.c.a.b("94" + optJSONObject11);
            }
            String str7 = str4;
            JSONObject optJSONObject12 = jSONObject.optJSONObject(str7);
            if (optJSONObject12 != null) {
                aVar.a("plc95", optJSONObject12.toString());
                com.baidu.mshield.b.c.a.b(str7 + optJSONObject12.toString());
            }
            JSONObject optJSONObject13 = jSONObject.optJSONObject("107");
            if (optJSONObject13 != null) {
                aVar.a("plc107", optJSONObject13.toString());
                com.baidu.mshield.b.c.a.b("107" + optJSONObject13.toString());
                if (optJSONObject13.has("5")) {
                    JSONObject optJSONObject14 = optJSONObject13.optJSONObject("5");
                    if (optJSONObject14.has("t")) {
                        aVar.b(optJSONObject14.optInt("t", 180));
                    }
                }
            }
            JSONObject optJSONObject15 = jSONObject.optJSONObject("51");
            if (optJSONObject15 != null) {
                aVar.a("plc51", optJSONObject15.toString());
                try {
                    a(aVar, optJSONObject15);
                    com.baidu.mshield.b.c.a.b("51" + optJSONObject15.toString());
                } catch (Throwable th2) {
                    th = th2;
                    d.a(th);
                    return;
                }
            }
            JSONObject optJSONObject16 = jSONObject.optJSONObject("102");
            if (optJSONObject16 != null) {
                aVar.a("plc102", optJSONObject16.toString());
                int optInt = optJSONObject16.optJSONObject("5").optInt("1", 60);
                aVar.g(optInt);
                com.baidu.mshield.x0.e.a.d = optInt;
                com.baidu.mshield.b.c.a.b("102" + optJSONObject16.toString());
            }
            JSONObject optJSONObject17 = jSONObject.optJSONObject("104");
            if (optJSONObject17 != null) {
                aVar.a("plc104", optJSONObject17.toString());
                com.baidu.mshield.b.c.a.b("104" + optJSONObject17.toString());
            }
            JSONObject optJSONObject18 = jSONObject.optJSONObject("114");
            if (optJSONObject18 != null) {
                com.baidu.mshield.b.c.a.b("114" + optJSONObject18.toString());
                JSONObject optJSONObject19 = optJSONObject18.optJSONObject("5");
                if (optJSONObject19.has("uv6") && optJSONObject19.optJSONObject("uv6").has("2")) {
                    com.baidu.mshield.x0.a.a.f6395a = optJSONObject19.optJSONObject("uv6").optString("2");
                    com.baidu.mshield.b.c.a.b("policy detect app encrypt===" + com.baidu.mshield.x0.a.a.f6395a);
                    optJSONObject19.optJSONObject("uv6").remove("2");
                    com.baidu.mshield.b.c.a.b("policy detect encryptStr====" + com.baidu.mshield.x0.a.a.f6395a);
                    aVar.a("plc114", optJSONObject18.toString());
                } else {
                    aVar.a("plc114", optJSONObject18.toString());
                }
            }
            JSONObject optJSONObject20 = jSONObject.optJSONObject("115");
            if (optJSONObject20 != null) {
                String a2 = aVar.a("plc115");
                String str8 = "";
                if (TextUtils.isEmpty(a2)) {
                    str5 = "";
                    str6 = str5;
                } else {
                    JSONObject jSONObject2 = new JSONObject(a2);
                    aVar.f(jSONObject2.optInt("3"));
                    JSONObject optJSONObject21 = jSONObject2.optJSONObject("5");
                    str6 = (optJSONObject21.has("uv4") && optJSONObject21.optJSONObject("uv4").has("2")) ? optJSONObject21.optJSONObject("uv4").optString("2") : "";
                    str5 = (optJSONObject21.has("uv4") && optJSONObject21.optJSONObject("uv4").has("4")) ? optJSONObject21.optJSONObject("uv4").optString("4") : "";
                }
                com.baidu.mshield.b.c.a.b("115" + optJSONObject20.toString());
                JSONObject optJSONObject22 = optJSONObject20.optJSONObject("5");
                if (optJSONObject22.has("uv4")) {
                    JSONObject optJSONObject23 = optJSONObject22.optJSONObject("uv4");
                    if (optJSONObject23.has("4")) {
                        str8 = optJSONObject23.optString("4");
                        aVar.g(str8);
                    }
                    int i2 = 0;
                    if (optJSONObject23.has("7")) {
                        int optInt2 = optJSONObject23.optJSONObject("7").optInt("2", 0);
                        i = optJSONObject23.optJSONObject("7").optInt("3", 0);
                        i2 = optInt2;
                    } else {
                        i = 0;
                    }
                    if (optJSONObject23.has("2")) {
                        String optString = optJSONObject23.optString("2");
                        if (i2 != 0 && !TextUtils.isEmpty(str8)) {
                            if (TextUtils.isEmpty(optString) && !TextUtils.isEmpty(str8) && str8.equals(str5)) {
                                optJSONObject23.put("2", str6);
                            }
                        }
                        com.baidu.mshield.x0.a.d.f6397a = optString;
                        optJSONObject23.remove("2");
                    }
                    if (!TextUtils.isEmpty(str8) && !str8.equals(str5) && i == 1) {
                        aVar.e(0L);
                    }
                    aVar.a("plc115", optJSONObject20.toString());
                } else {
                    aVar.a("plc115", optJSONObject20.toString());
                }
            }
            aVar.a(true);
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public final void a(String str) {
        try {
            com.baidu.mshield.b.c.a.b("handleEmulatorSig:" + str);
            if (!TextUtils.isEmpty(str)) {
                String a2 = e.a(str);
                l.c = a2;
                new com.baidu.mshield.x6.a.b(this.b).n(a2);
                String str2 = new String(c.b(Base64.decode(str.getBytes(), 0)), "utf-8");
                com.baidu.mshield.b.c.a.b("handleEmulatorSig ungz:" + str2);
                l.f6448a = str2;
            } else {
                f.j(this.b);
            }
        } catch (Throwable th) {
            d.a(th);
        }
    }
}
