package com.kuaishou.weapon.p0;

import XIXIX.OOXIXo;
import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.A;
import com.kuaishou.weapon.p0.jni.Engine;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public class cn {

    /* renamed from: a, reason: collision with root package name */
    private Context f18358a;
    private int b;

    public cn(Context context, int i) {
        this.f18358a = context;
        this.b = i;
    }

    public JSONObject a() {
        long j;
        h hVar;
        boolean z;
        boolean z2;
        String str;
        String str2;
        cn cnVar;
        String str3;
        Object obj;
        Object obj2;
        Object obj3;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            h a2 = h.a(this.f18358a, "re_po_rt");
            boolean e = a2.e("a1_p_s_p_s");
            boolean e2 = a2.e("a1_p_s_p_s_c_b");
            if (a2.b(df.aO, 1) == 1 && (e || e2)) {
                String a3 = bh.a(this.f18358a);
                if (!TextUtils.isEmpty(a3) && !a3.startsWith("RISK")) {
                    jSONObject.put("01001", a3);
                }
                String c = bh.c(this.f18358a);
                if (!TextUtils.isEmpty(c) && !c.startsWith("RISK")) {
                    jSONObject.put("01003", c);
                }
                String b = bh.b(this.f18358a, 0);
                if (!TextUtils.isEmpty(b) && !b.startsWith("RISK")) {
                    jSONObject.put("01019", b);
                }
                String b2 = bh.b(this.f18358a, 1);
                if (!TextUtils.isEmpty(b2) && !b2.startsWith("RISK")) {
                    jSONObject.put("01004", b2);
                }
                String d = bh.d(this.f18358a);
                if (!TextUtils.isEmpty(d) && !d.startsWith("RISK")) {
                    jSONObject.put("01007", d);
                }
            }
            if (a2.b(df.aP, 0) == 1 && (e || e2)) {
                bg bgVar = new bg();
                if (a2.b(df.bc, 1) == 1) {
                    jSONObject.put("10020", bgVar.f(this.f18358a));
                }
            }
            if (a2.b(df.aQ, 1) == 1 && (e || e2)) {
                jSONObject.put("01011", bh.e(this.f18358a));
            }
            if (a2.b(df.aR, 1) == 1 && (e || e2)) {
                String p = bh.p(this.f18358a);
                if (!TextUtils.isEmpty(p) && !p.startsWith("RISK")) {
                    jSONObject.put("01016", p);
                }
            }
            if (a2.b(df.aF, 1) == 1) {
                if (e || e2) {
                    String f = bh.f(this.f18358a);
                    if (!TextUtils.isEmpty(f) && !f.startsWith("RISK")) {
                        jSONObject.put("01013", f);
                    }
                    jSONObject.put("02042", bh.u(this.f18358a));
                }
                j = currentTimeMillis;
                str = "RISK";
                z2 = e2;
                z = e;
                try {
                    if (Engine.loadSuccess) {
                        try {
                            jSONObject.put("02019", bl.b(this.f18358a));
                            jSONObject.put("02021", bl.d(this.f18358a));
                            jSONObject.put("02022", bl.c(this.f18358a));
                            jSONObject.put("02030", bl.f(this.f18358a));
                            ce ceVar = new ce(this.f18358a);
                            if (ceVar.a("01014") == null) {
                                obj = "";
                            } else {
                                obj = ceVar.a("01014");
                            }
                            jSONObject.put("01014", obj);
                            jSONObject.put("02001", ceVar.a("02001") != null ? ceVar.a("02001") : bl.a());
                            jSONObject.put("02002", ceVar.a("02002") != null ? ceVar.a("02002") : bl.b());
                            jSONObject.put("02003", ceVar.a("02003") != null ? ceVar.a("02003") : bl.c());
                            jSONObject.put("02004", ceVar.a("02004") != null ? ceVar.a("02004") : bl.d());
                            jSONObject.put("02005", ceVar.a("02005") != null ? ceVar.a("02005") : bl.e());
                            jSONObject.put("02006", ceVar.a("02006") != null ? ceVar.a("02006") : bl.f());
                            jSONObject.put("02007", ceVar.a("02007") != null ? ceVar.a("02007") : bl.g());
                            jSONObject.put("02008", ceVar.a("02008") != null ? ceVar.a("02008") : bl.h());
                            jSONObject.put("02009", ceVar.a("02009") != null ? ceVar.a("02009") : bl.i());
                            jSONObject.put("02010", ceVar.a("02010") != null ? ceVar.a("02010") : bl.j());
                            jSONObject.put("02011", ceVar.a("02011") != null ? ceVar.a("02011") : bl.k());
                            jSONObject.put("02012", ceVar.a("02012") != null ? ceVar.a("02012") : bl.l());
                            jSONObject.put("02013", ceVar.a("02013") != null ? ceVar.a("02013") : bl.m());
                            jSONObject.put("02014", ceVar.a("02014") != null ? ceVar.a("02014") : bl.n());
                            jSONObject.put("02015", ceVar.a("02015") != null ? ceVar.a("02015") : bl.p());
                            jSONObject.put("02016", ceVar.a("02016") != null ? ceVar.a("02016") : bl.q());
                            jSONObject.put("02017", ceVar.a("02017") != null ? ceVar.a("02017") : Integer.valueOf(bl.r()));
                            jSONObject.put("02018", ceVar.a("02018") != null ? ceVar.a("02018") : bl.s());
                            jSONObject.put("02020", ceVar.a("02020") != null ? ceVar.a("02020") : bl.u());
                            if (ceVar.a("02023") == null) {
                                obj2 = "";
                            } else {
                                obj2 = ceVar.a("02023");
                            }
                            jSONObject.put("02023", obj2);
                            jSONObject.put("02031", ceVar.a("02031") != null ? ceVar.a("02031") : bl.y());
                            jSONObject.put("02032", ceVar.a("02032") != null ? ceVar.a("02032") : bl.o());
                            jSONObject.put("02033", ceVar.a("02033") != null ? ceVar.a("02033") : bl.x());
                            jSONObject.put("02034", ceVar.a("02034") != null ? ceVar.a("02034") : bl.z());
                            jSONObject.put("02035", ceVar.a("02035") != null ? ceVar.a("02035") : bl.A());
                            if (ceVar.a("02036") == null) {
                                obj3 = "";
                            } else {
                                obj3 = ceVar.a("02036");
                            }
                            jSONObject.put("02036", obj3);
                            jSONObject.put("02037", ceVar.a("02037") != null ? ceVar.a("02037") : bl.w());
                            jSONObject.put("02038", ceVar.a("02038") != null ? ceVar.a("02038") : bl.v());
                            jSONObject.put("02045", ceVar.a("02045") != null ? ceVar.a("02045") : bl.B());
                        } catch (Exception unused) {
                        }
                        cnVar = this;
                    } else {
                        jSONObject.put("02001", bl.a());
                        jSONObject.put("02002", bl.b());
                        jSONObject.put("02003", bl.c());
                        jSONObject.put("02004", bl.d());
                        jSONObject.put("02005", bl.e());
                        jSONObject.put("02006", bl.f());
                        jSONObject.put("02007", bl.g());
                        jSONObject.put("02008", bl.h());
                        jSONObject.put("02009", bl.i());
                        jSONObject.put("02010", bl.j());
                        jSONObject.put("02011", bl.k());
                        jSONObject.put("02012", bl.l());
                        jSONObject.put("02013", bl.m());
                        jSONObject.put("02014", bl.n());
                        jSONObject.put("02015", bl.p());
                        jSONObject.put("02016", bl.q());
                        jSONObject.put("02017", bl.r());
                        jSONObject.put("02018", bl.s());
                        cnVar = this;
                        try {
                            jSONObject.put("02019", bl.b(cnVar.f18358a));
                            jSONObject.put("02020", bl.u());
                            jSONObject.put("02021", bl.d(cnVar.f18358a));
                            jSONObject.put("02022", bl.c(cnVar.f18358a));
                            jSONObject.put("02030", bl.f(cnVar.f18358a));
                            jSONObject.put("02031", bl.y());
                            jSONObject.put("02032", bl.o());
                            jSONObject.put("02033", bl.x());
                            jSONObject.put("02034", bl.z());
                            jSONObject.put("02035", bl.A());
                            jSONObject.put("02037", bl.w());
                            jSONObject.put("02038", bl.v());
                            jSONObject.put("02045", bl.B());
                        } catch (Throwable unused2) {
                            return null;
                        }
                    }
                    str2 = "";
                    jSONObject.put("02067", cnVar.f18358a.getApplicationContext().getPackageResourcePath().replace("/data/app/", str2).replace("/base.apk", str2));
                    jSONObject.put("02039", bh.i());
                    jSONObject.put("02040", bh.j());
                    jSONObject.put("02041", bh.t(cnVar.f18358a));
                    jSONObject.put("02044", bl.t());
                    jSONObject.put("02046", bl.C());
                    String a4 = bh.a("persist.service.adb.enable");
                    if (!TextUtils.isEmpty(a4)) {
                        jSONObject.put("03058", a4);
                    }
                    String a5 = bh.a("sys.resettype");
                    if (!TextUtils.isEmpty(a5)) {
                        jSONObject.put("03057", a5);
                    }
                    String a6 = bh.a("ro.boot.bootreason");
                    if (!TextUtils.isEmpty(a6)) {
                        jSONObject.put("03056", a6);
                    }
                    String a7 = bh.a("ro.runtime.firstboot");
                    if (!TextUtils.isEmpty(a7)) {
                        jSONObject.put("03055", a7);
                    }
                    String a8 = bh.a("init.svc.atcmdserver");
                    if (!TextUtils.isEmpty(a8)) {
                        jSONObject.put("03054", a8);
                    }
                    String a9 = bh.a("ro.build.date.utc");
                    if (!TextUtils.isEmpty(a9)) {
                        jSONObject.put("03061", a9);
                    }
                    String a10 = bh.a("ro.bootimage.build.date.utc");
                    if (!TextUtils.isEmpty(a10)) {
                        jSONObject.put("03062", a10);
                    }
                    String a11 = bh.a("ro.build.date.YmdHM");
                    if (!TextUtils.isEmpty(a11)) {
                        jSONObject.put("03063", a11);
                    }
                    String a12 = bh.a("dhcp.ipv6.wlan0.dns1");
                    if (!TextUtils.isEmpty(a12)) {
                        jSONObject.put("03067", a12);
                    }
                    String a13 = bh.a("dhcp.ipv6.wlan0.dns2");
                    if (!TextUtils.isEmpty(a13)) {
                        jSONObject.put("03068", a13);
                    }
                    String a14 = bh.a("dhcp.wlan0.dns1");
                    if (!TextUtils.isEmpty(a14)) {
                        jSONObject.put("03069", a14);
                    }
                    String a15 = bh.a("dhcp.wlan0.dns2");
                    if (!TextUtils.isEmpty(a15)) {
                        jSONObject.put("03070", a15);
                    }
                    String a16 = bh.a("net.change");
                    if (!TextUtils.isEmpty(a16)) {
                        jSONObject.put("03071", a16);
                    }
                    String a17 = bh.a("net.dns1");
                    if (!TextUtils.isEmpty(a17)) {
                        jSONObject.put("03072", a17);
                    }
                    String a18 = bh.a("net.dns2");
                    if (!TextUtils.isEmpty(a18)) {
                        jSONObject.put("03073", a18);
                    }
                    hVar = a2;
                    long a19 = hVar.a(df.d, -1L);
                    if (a19 != -1) {
                        jSONObject.put("03074", a19 + System.currentTimeMillis());
                    }
                    try {
                        jSONObject.put("03064", Settings.System.getInt(cnVar.f18358a.getContentResolver(), "screen_brightness_mode"));
                        jSONObject.put("03065", Settings.System.getInt(cnVar.f18358a.getContentResolver(), "accelerometer_rotation"));
                    } catch (Throwable unused3) {
                    }
                    jSONObject.put("03081", bl.L());
                    jSONObject.put("03052", bl.i(cnVar.f18358a));
                    jSONObject.put("03050", bl.h(cnVar.f18358a));
                    jSONObject.put("03049", bl.g(cnVar.f18358a));
                    jSONObject.put("02027", bl.H());
                    jSONObject.put("02028", bl.D());
                    jSONObject.put("02029", bl.E());
                    jSONObject.put("02057", bl.F());
                    jSONObject.put("02058", bl.G());
                } catch (Throwable unused4) {
                    return null;
                }
            } else {
                j = currentTimeMillis;
                hVar = a2;
                z = e;
                z2 = e2;
                str = "RISK";
                str2 = "";
                cnVar = this;
            }
            if (hVar.b(df.aG, 1) == 1) {
                jSONObject.put("03001", bo.a());
                jSONObject.put("03002", bo.b());
                jSONObject.put("03001", bo.a());
                jSONObject.put("03043", SystemClock.elapsedRealtime());
                jSONObject.put("03044", SystemClock.uptimeMillis());
                jSONObject.put("03045", System.currentTimeMillis() - SystemClock.elapsedRealtime());
                by byVar = new by(cnVar.f18358a);
                if (Engine.loadSuccess) {
                    jSONObject.put("03004", byVar.a("03004") != null ? byVar.a("03004") : str2);
                    jSONObject.put("03036", byVar.b("03036") != null ? byVar.b("03036") : str2);
                    jSONObject.put("03039", byVar.a("03039") != null ? byVar.a("03039") : str2);
                    jSONObject.put("03040", byVar.a("03040") != null ? byVar.a("03040") : str2);
                    jSONObject.put("03041", byVar.a("03041") != null ? byVar.a("03041") : str2);
                    jSONObject.put("03042", byVar.a("03042") != null ? byVar.a("03042") : str2);
                    jSONObject.put("03079", byVar.a("03079") != null ? byVar.a("03079") : null);
                    jSONObject.put("03080", byVar.a("03080") != null ? byVar.a("03080") : null);
                }
                jSONObject.put("03007", bv.a(cnVar.f18358a));
                jSONObject.put("03008", bv.c(cnVar.f18358a));
                jSONObject.put("03011", am.b(cnVar.f18358a));
                jSONObject.put("03012", am.b());
                jSONObject.put("03014", bh.g(cnVar.f18358a));
                jSONObject.put("03034", bh.h(cnVar.f18358a));
                jSONObject.put("03020", bv.b(cnVar.f18358a));
                jSONObject.put("03037", bl.I());
                jSONObject.put("03038", bl.J());
                jSONObject.put("03077", bl.K());
                try {
                    bg bgVar2 = new bg();
                    jSONObject.put("03006", bgVar2.a(cnVar.f18358a));
                    jSONObject.put("03010", bgVar2.b(cnVar.f18358a));
                    jSONObject.put("03033", bgVar2.c(cnVar.f18358a));
                    jSONObject.put("03021", bgVar2.e(cnVar.f18358a));
                    jSONObject.put("03030", bg.d(cnVar.f18358a));
                    jSONObject.put("10031", bgVar2.a());
                } catch (Exception unused5) {
                }
            }
            if (hVar.b(df.aU, 0) == 1) {
                jSONObject.put("03019", bh.k(cnVar.f18358a));
                String m = bh.m(cnVar.f18358a);
                if (!TextUtils.isEmpty(m)) {
                    jSONObject.put("03047", m);
                }
                jSONObject.put("03018", bh.i(cnVar.f18358a));
            }
            if (hVar.b(df.aV, 1) == 1) {
                jSONObject.put("02059", bm.a(cnVar.f18358a));
                jSONObject.put("02060", bm.a());
                jSONObject.put("02062", bm.c());
                if (Engine.loadSuccess) {
                    ca caVar = new ca(cnVar.f18358a);
                    jSONObject.put("08001", caVar.a("08001") != null ? caVar.a("08001") : str2);
                }
                JSONObject d2 = bm.d();
                if (d2 != null && d2.length() > 0) {
                    jSONObject.put("10050", d2);
                }
            }
            if (hVar.b(df.aT, 1) == 1 && (z || z2)) {
                jSONObject.put("03029", bh.j(cnVar.f18358a));
            }
            if (hVar.b(df.aH, 1) == 1) {
                if (Engine.loadSuccess) {
                    bz bzVar = new bz(cnVar.f18358a);
                    jSONObject.put("04001", bzVar.a("04001") != null ? bzVar.a("04001") : str2);
                    jSONObject.put("04002", bzVar.a("04002") != null ? bzVar.a("04002") : str2);
                    jSONObject.put("04003", bzVar.a("04003") != null ? bzVar.a("04003") : str2);
                    jSONObject.put("04004", bzVar.a("04004") != null ? bzVar.a("04004") : str2);
                } else {
                    try {
                        bj b3 = bk.b();
                        jSONObject.put("04001", bk.a());
                        jSONObject.put("04002", b3.b());
                        jSONObject.put("04003", b3.c());
                        jSONObject.put("04004", b3.a());
                    } catch (Exception unused6) {
                    }
                }
            }
            if (hVar.b(df.aK, 0) == 1 && (z || z2)) {
                Object f2 = bh.f();
                if (f2 != null) {
                    jSONObject.put("06014", f2);
                }
                if (Engine.loadSuccess) {
                    cf cfVar = new cf(cnVar.f18358a);
                    jSONObject.put("06015", cfVar.b("06015") != null ? cfVar.b("06015") : str2);
                }
            }
            if (z || z2) {
                String h = bh.h();
                if (!TextUtils.isEmpty(h) && !h.startsWith(str)) {
                    jSONObject.put("07005", h);
                } else if (h == null) {
                    jSONObject.put("07005", str2);
                } else {
                    jSONObject.put("07005", h);
                }
            }
            if (hVar.b(df.aI, 0) == 1 && (z || z2)) {
                if (Engine.loadSuccess) {
                    jSONObject.put("07007", new cc(cnVar.f18358a).a("07007"));
                }
                JSONArray a20 = br.a(cnVar.f18358a);
                if (a20 != null && a20.length() > 0) {
                    jSONObject.put("03035", a20);
                }
            }
            if (z || z2) {
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
                    jSONObject.put("09001", bh.d());
                } catch (Exception unused7) {
                }
            }
            if (hVar.b(df.aM, 0) == 1 && (z || z2)) {
                jSONObject.put("10002", new w(cnVar.f18358a).a(1));
            }
            if (hVar.b(df.aJ, 1) == 1 && Engine.loadSuccess) {
                String a21 = new cd(cnVar.f18358a).a("05001");
                try {
                    if (!TextUtils.isEmpty(a21) && a21.length() > 10) {
                        jSONObject.put("05001", new JSONArray(a21));
                    }
                } catch (Exception unused8) {
                }
            }
            if (Engine.loadSuccess) {
                cb cbVar = new cb(cnVar.f18358a);
                jSONObject.put("13001", cbVar.a("13001") != null ? cbVar.a("13001") : str2);
            }
            jSONObject.put("11000", Engine.loadSuccess ? 1 : 0);
            jSONObject.put("11002", Engine.soVersion);
            jSONObject.put("11003", bi.v);
            jSONObject.put("11004", Engine.loadSoCount);
            jSONObject.put("11006", z ? 1 : 0);
            jSONObject.put("11029", z2 ? 1 : 0);
            jSONObject.put("11008", hVar.b(df.g, bq.e));
            jSONObject.put("11009", bs.a(cnVar.f18358a.getApplicationContext()));
            try {
                String w = bh.w(cnVar.f18358a);
                if (!TextUtils.isEmpty(w)) {
                    jSONObject.put("01026", w);
                }
                if (hVar.b(df.aL, 1) == 1) {
                    String IS = com.kwad.sdk.e.b.Jd().IS();
                    if (!TextUtils.isEmpty(IS)) {
                        jSONObject.put("11102", IS);
                    }
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
                }
            } catch (Throwable unused9) {
            }
            try {
                jSONObject.put("02078", A.getE("W_S_V"));
                jSONObject.put("02079", A.getE("W_S_S_V"));
                if (Build.VERSION.SDK_INT > 21) {
                    StringBuilder sb3 = new StringBuilder();
                    str3 = Build.VERSION.SECURITY_PATCH;
                    sb3.append(str3);
                    jSONObject.put("02069", sb3.toString());
                }
                String string = Settings.Global.getString(cnVar.f18358a.getContentResolver(), "Phenotype_boot_count");
                if (!TextUtils.isEmpty(string)) {
                    jSONObject.put("03085", string);
                }
                String string2 = Settings.Global.getString(cnVar.f18358a.getContentResolver(), "boot_count");
                if (!TextUtils.isEmpty(string2)) {
                    jSONObject.put("03086", string2);
                }
                String string3 = Settings.System.getString(cnVar.f18358a.getContentResolver(), "power_on_times");
                if (!TextUtils.isEmpty(string3)) {
                    jSONObject.put("03091", string3);
                }
                String string4 = Settings.System.getString(cnVar.f18358a.getContentResolver(), "first_boot_flag");
                if (!TextUtils.isEmpty(string4)) {
                    jSONObject.put("03104", string4);
                }
            } catch (Throwable unused10) {
            }
            jSONObject.put("11007", System.currentTimeMillis() - j);
            jSONObject.put("11017", jSONObject.toString().length());
            return jSONObject;
        } catch (Throwable unused11) {
            return null;
        }
    }

    public String a(String str) {
        JSONObject a2;
        try {
            JSONObject a3 = new cm(str, ck.l).a(this.f18358a);
            if (a3 == null || (a2 = a()) == null) {
                return null;
            }
            a3.put("module_section", a2);
            return a3.toString();
        } catch (Throwable unused) {
            return null;
        }
    }
}
