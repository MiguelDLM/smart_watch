package com.kuaishou.weapon.p0;

import XIXIX.OOXIXo;
import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public class bw {
    private static final byte[] d = new byte[0];

    /* renamed from: a, reason: collision with root package name */
    private Context f18339a;
    private boolean b;
    private int c;

    public bw(Context context, int i, boolean z) {
        this.f18339a = context;
        this.b = z;
        this.c = i;
    }

    public JSONObject a() {
        Object obj;
        Object obj2;
        Object obj3;
        try {
            JSONObject jSONObject = new JSONObject();
            h a2 = h.a(this.f18339a, "re_po_rt");
            boolean e = a2.e("a1_p_s_p_s");
            boolean e2 = a2.e("a1_p_s_p_s_c_b");
            jSONObject.put("11006", e ? 1 : 0);
            jSONObject.put("11029", e2 ? 1 : 0);
            if (a2.b(df.au, 1) == 1 && (e || e2)) {
                String a3 = bh.a(this.f18339a);
                if (!TextUtils.isEmpty(a3) && !a3.startsWith("RISK")) {
                    jSONObject.put("01001", f.a(a3));
                }
                String c = bh.c(this.f18339a);
                if (!TextUtils.isEmpty(c) && !c.startsWith("RISK")) {
                    jSONObject.put("01003", c);
                }
                String b = bh.b(this.f18339a, 0);
                if (!TextUtils.isEmpty(b) && !b.startsWith("RISK")) {
                    jSONObject.put("01019", b);
                }
                String b2 = bh.b(this.f18339a, 1);
                if (!TextUtils.isEmpty(b2) && !b2.startsWith("RISK")) {
                    jSONObject.put("01004", f.a(b2));
                }
            }
            int b3 = a2.b(df.at, 1);
            if (b3 == 1 && (e || e2)) {
                String f = bh.f(this.f18339a);
                if (!TextUtils.isEmpty(f) && !f.startsWith("RISK")) {
                    jSONObject.put("01013", f);
                }
            }
            if (a2.b(df.av, 1) == 1 && (e || e2)) {
                String d2 = bh.d(this.f18339a);
                if (!TextUtils.isEmpty(d2) && !d2.startsWith("RISK")) {
                    jSONObject.put("01007", d2);
                }
            }
            if (a2.b(df.aw, 1) == 1 && (e || e2)) {
                jSONObject.put("01011", bh.e(this.f18339a));
            }
            Object obj4 = "";
            if (e || e2) {
                String h = bh.h();
                if (!TextUtils.isEmpty(h) && !h.startsWith("RISK")) {
                    jSONObject.put("07005", h);
                } else if (h == null) {
                    jSONObject.put("07005", "");
                } else {
                    jSONObject.put("07005", h);
                }
                jSONObject.put("07006", bh.g());
            }
            if (a2.b(df.ay, 1) == 1 && (e || e2)) {
                String p = bh.p(this.f18339a);
                if (!TextUtils.isEmpty(p) && !p.startsWith("RISK")) {
                    jSONObject.put("01016", p);
                }
            }
            if (e || e2) {
                try {
                    double b4 = bh.b();
                    if (b4 > OOXIXo.f3760XO) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(b4);
                        jSONObject.put("09002", sb.toString());
                    }
                    double c2 = bh.c();
                    if (c2 > OOXIXo.f3760XO) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(c2);
                        jSONObject.put("09003", sb2.toString());
                    }
                } catch (Exception unused) {
                }
            }
            jSONObject.put("11013", Integer.parseInt(bx.a(this.f18339a.getApplicationContext()), 2));
            jSONObject.put("11012", bx.b(this.f18339a));
            try {
                jSONObject.put("11202", bh.b(com.kwad.sdk.e.b.Jd().IS()));
                jSONObject.put("11204", bh.b(com.kwad.sdk.e.b.Jd().IZ()));
                jSONObject.put("11205", bh.b(com.kwad.sdk.e.b.Jd().getDeviceId()));
                jSONObject.put("11206", bh.b(com.kwad.sdk.e.b.Jd().getIccId()));
                jSONObject.put("11207", bh.b(com.kwad.sdk.e.b.Jd().IR()));
                jSONObject.put("11208", bh.b(com.kwad.sdk.e.b.Jd().IU()));
                jSONObject.put("11209", bh.b(com.kwad.sdk.e.b.Jd().IV()));
                jSONObject.put("11210", bh.b(com.kwad.sdk.e.b.Jd().IW()));
                jSONObject.put("11211", bh.b(com.kwad.sdk.e.b.Jd().getIp()));
                jSONObject.put("11212", bh.b(com.kwad.sdk.e.b.Jd().getLocation()));
                jSONObject.put("11213", bh.b(com.kwad.sdk.e.b.Jd().getOaid()));
                jSONObject.put("11214", bh.b(com.kwad.sdk.e.b.Jd().IT()));
                jSONObject.put("11215", bh.b(com.kwad.sdk.e.b.Jd().IY()));
                jSONObject.put("11216", bh.b(com.kwad.sdk.e.b.Jd().IX()));
                jSONObject.put("11301", bh.c(com.kwad.sdk.e.b.Jd().Jc()));
                jSONObject.put("11302", bh.c(com.kwad.sdk.e.b.Jd().getSdkVersion()));
                jSONObject.put("11303", bh.c(com.kwad.sdk.e.b.Jd().getAppId()));
                jSONObject.put("11104", com.kwad.sdk.e.b.Jd().IZ());
                jSONObject.put("11105", com.kwad.sdk.e.b.Jd().getDeviceId());
                jSONObject.put("11106", com.kwad.sdk.e.b.Jd().getIccId());
                jSONObject.put("11107", com.kwad.sdk.e.b.Jd().IR());
                jSONObject.put("11108", com.kwad.sdk.e.b.Jd().IU());
                jSONObject.put("11109", com.kwad.sdk.e.b.Jd().IV());
                jSONObject.put("11110", com.kwad.sdk.e.b.Jd().IW());
                jSONObject.put("11111", com.kwad.sdk.e.b.Jd().getIp());
                jSONObject.put("11112", com.kwad.sdk.e.b.Jd().getLocation());
                jSONObject.put("11113", com.kwad.sdk.e.b.Jd().getOaid());
                jSONObject.put("11114", com.kwad.sdk.e.b.Jd().IT());
                jSONObject.put("11115", com.kwad.sdk.e.b.Jd().IY());
                jSONObject.put("11116", com.kwad.sdk.e.b.Jd().IX());
            } catch (Throwable unused2) {
            }
            String w = bh.w(this.f18339a);
            if (!TextUtils.isEmpty(w)) {
                jSONObject.put("01026", w);
            }
            if (b3 == 1) {
                try {
                    Object a4 = ai.a(this.f18339a);
                    if (a4 != null) {
                        jSONObject.put("11015", a4);
                    }
                    if (Engine.loadSuccess) {
                        ce ceVar = new ce(this.f18339a);
                        jSONObject.put("02001", ceVar.a("02001") != null ? ceVar.a("02001") : bl.a());
                        jSONObject.put("02002", ceVar.a("02002") != null ? ceVar.a("02002") : bl.b());
                        jSONObject.put("02003", ceVar.a("02003") != null ? ceVar.a("02003") : bl.c());
                        jSONObject.put("02007", ceVar.a("02007") != null ? ceVar.a("02007") : bl.g());
                        jSONObject.put("02006", ceVar.a("02006") != null ? ceVar.a("02006") : bl.f());
                        jSONObject.put("02004", ceVar.a("02004") != null ? ceVar.a("02004") : bl.d());
                        jSONObject.put("02005", ceVar.a("02005") != null ? ceVar.a("02005") : bl.e());
                        jSONObject.put("02018", ceVar.a("02018") != null ? ceVar.a("02018") : bl.s());
                        jSONObject.put("02013", ceVar.a("02013") != null ? ceVar.a("02013") : bl.m());
                        jSONObject.put("02016", ceVar.a("02016") != null ? ceVar.a("02016") : bl.q());
                    } else {
                        jSONObject.put("02001", bl.a());
                        jSONObject.put("02002", bl.b());
                        jSONObject.put("02003", bl.c());
                        jSONObject.put("02004", bl.d());
                        jSONObject.put("02005", bl.e());
                        jSONObject.put("02006", bl.f());
                        jSONObject.put("02007", bl.g());
                        jSONObject.put("02018", bl.s());
                        jSONObject.put("02013", bl.m());
                        jSONObject.put("02016", bl.q());
                    }
                    jSONObject.put("02021", bl.d(this.f18339a));
                    jSONObject.put("02022", bl.c(this.f18339a));
                    jSONObject.put("02044", bl.t());
                    jSONObject.put("11009", bs.a(this.f18339a.getApplicationContext()));
                    if (Engine.loadSuccess) {
                        bz bzVar = new bz(this.f18339a);
                        if (bzVar.a("04001") == null) {
                            obj = "";
                        } else {
                            obj = bzVar.a("04001");
                        }
                        jSONObject.put("04001", obj);
                        if (bzVar.a("04002") == null) {
                            obj2 = "";
                        } else {
                            obj2 = bzVar.a("04002");
                        }
                        jSONObject.put("04002", obj2);
                        if (bzVar.a("04003") == null) {
                            obj3 = "";
                        } else {
                            obj3 = bzVar.a("04003");
                        }
                        jSONObject.put("04003", obj3);
                        if (bzVar.a("04004") != null) {
                            obj4 = bzVar.a("04004");
                        }
                        jSONObject.put("04004", obj4);
                    } else {
                        try {
                            bj b5 = bk.b();
                            jSONObject.put("04001", bk.a());
                            jSONObject.put("04002", b5.b());
                            jSONObject.put("04003", b5.c());
                            jSONObject.put("04004", b5.a());
                        } catch (Exception unused3) {
                        }
                    }
                } catch (Throwable unused4) {
                    return null;
                }
            }
            if (this.b) {
                jSONObject.put("20004", 1);
            }
            jSONObject.put("11017", jSONObject.toString().length());
            jSONObject.put("20000", this.c);
            jSONObject.put("11028", WeaponHI.sKSSdkver);
            return jSONObject;
        } catch (Throwable unused5) {
            return null;
        }
    }

    public String a(String str) {
        try {
            synchronized (d) {
                try {
                    JSONObject a2 = new cm(str, ck.l).a(this.f18339a);
                    if (a2 == null) {
                        return null;
                    }
                    JSONObject a3 = a();
                    if (a3 == null) {
                        return null;
                    }
                    a2.put("module_section", a3);
                    return a2.toString();
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (Throwable unused) {
            return null;
        }
    }
}
