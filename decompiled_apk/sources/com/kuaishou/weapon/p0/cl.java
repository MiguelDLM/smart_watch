package com.kuaishou.weapon.p0;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.room.RoomMasterTable;
import com.huawei.hms.ads.gb;
import com.huawei.openalliance.ad.activity.PPSLauncherActivity;
import com.kuaishou.weapon.p0.jni.A;
import com.kuaishou.weapon.p0.jni.Engine;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public class cl {

    /* renamed from: a, reason: collision with root package name */
    private Context f18356a;
    private int b;
    private int c;

    public cl(Context context, int i, int i2) {
        this.f18356a = context;
        this.b = i;
        this.c = i2;
    }

    public JSONObject a() {
        String str;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            h a2 = h.a(this.f18356a, "re_po_rt");
            boolean e = a2.e("a1_p_s_p_s");
            boolean e2 = a2.e("a1_p_s_p_s_c_b");
            aj ajVar = new aj(this.f18356a);
            jSONObject.put("0", ajVar.d());
            jSONObject.put("1", ajVar.a());
            jSONObject.put("2", ajVar.c());
            jSONObject.put("3", ajVar.f());
            jSONObject.put(com.tencent.connect.common.II0xO0.f26868oxOXxoXII, ajVar.e());
            jSONObject.put("35", ab.b() ? 1 : 0);
            jSONObject.put("36", ab.a(this.f18356a) ? 1 : 0);
            Object a3 = ai.a(this.f18356a);
            if (a3 != null) {
                jSONObject.put("4", a3);
            }
            z zVar = new z();
            JSONArray a4 = zVar.a(this.f18356a);
            jSONObject.put(com.huawei.openalliance.ad.beans.inner.a.V, a4);
            jSONObject.put("146", zVar.e());
            jSONObject.put("154", zVar.a());
            jSONObject.put("168", dj.b(a4));
            jSONObject.put("169", dj.a(a4));
            jSONObject.put("185", zVar.d());
            jSONObject.put("191", zVar.c());
            if (zVar.b() != null) {
                jSONObject.put("161", zVar.b());
            }
            jSONObject.put(com.tencent.connect.common.II0xO0.f26892xOOxIO, ab.a());
            ac acVar = new ac();
            jSONObject.put("7", acVar.a() ? 1 : 0);
            boolean a5 = acVar.a(this.f18356a);
            jSONObject.put("8", a5 ? 1 : 0);
            if (a5) {
                jSONObject.put("61", acVar.b(this.f18356a));
            }
            jSONObject.put("181", acVar.f(this.f18356a) ? 1 : 0);
            jSONObject.put("9", acVar.d(this.f18356a));
            jSONObject.put("10", acVar.e(this.f18356a));
            jSONObject.put("11", acVar.c(this.f18356a));
            ae aeVar = new ae();
            jSONObject.put(com.tencent.connect.common.II0xO0.f26813XO0o, aeVar.a("cpuinfo") ? 1 : 0);
            jSONObject.put("27", aeVar.a("meminfo") ? 1 : 0);
            jSONObject.put(com.tencent.connect.common.II0xO0.f26789OxXXx0X, aeVar.b("/proc/cpuinfo") ? 1 : 0);
            jSONObject.put("29", aeVar.b("/proc/meminfo") ? 1 : 0);
            jSONObject.put("96", aeVar.a());
            jSONObject.put("134", aeVar.b());
            an anVar = new an();
            Set<String> b = anVar.b();
            Set<String> c = anVar.c();
            if (c != null) {
                str = "45";
                jSONObject.put("30", 1);
                jSONObject.put("32", new JSONArray((Collection) c));
            } else {
                str = "45";
                jSONObject.put("30", 0);
            }
            if (b != null) {
                jSONObject.put("31", 1);
                jSONObject.put("33", new JSONArray((Collection) b));
            } else {
                jSONObject.put("31", 0);
            }
            Object a6 = anVar.a();
            if (a6 != null) {
                jSONObject.put("34", a6);
                if (b != null || c != null) {
                    HashSet hashSet = new HashSet();
                    if (b != null) {
                        hashSet.add(b);
                    }
                    if (c != null) {
                        hashSet.add(c);
                    }
                    jSONObject.put(com.tencent.connect.common.II0xO0.f26825XoIxOXIXo, anVar.a(this.f18356a, 13, hashSet));
                    jSONObject.put(com.tencent.connect.common.II0xO0.f26773OO0, anVar.a(this.f18356a, 14, hashSet));
                    jSONObject.put("15", anVar.a(this.f18356a, 15, hashSet));
                    jSONObject.put("16", anVar.a(this.f18356a, 16, hashSet));
                    jSONObject.put(com.tencent.connect.common.II0xO0.f26886xIXX, anVar.a(this.f18356a, 17, hashSet));
                    jSONObject.put("18", anVar.a(this.f18356a, 18, hashSet));
                    jSONObject.put(com.tencent.connect.common.II0xO0.f26837o0oxo0oI, anVar.a(this.f18356a, 19, hashSet));
                    jSONObject.put("20", anVar.a(this.f18356a, 20, hashSet));
                    jSONObject.put("21", anVar.a(this.f18356a, 21, hashSet));
                    jSONObject.put("130", anVar.b(hashSet));
                }
            }
            ao aoVar = new ao();
            jSONObject.put("65", aoVar.d() ? 1 : 0);
            boolean b2 = aoVar.b();
            jSONObject.put("66", b2 ? 1 : 0);
            if (b2) {
                jSONObject.put("67", aoVar.a() ? 1 : 0);
            }
            jSONObject.put("68", aoVar.f() ? 1 : 0);
            jSONObject.put(PPSLauncherActivity.Code, aoVar.e());
            jSONObject.put("101", aoVar.c() ? 1 : 0);
            jSONObject.put("102", aoVar.g() ? 1 : 0);
            jSONObject.put("99", new af().a());
            jSONObject.put("103", new ad().a() ? 1 : 0);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("03007", bv.a(this.f18356a));
            jSONObject2.put("03014", bh.g(this.f18356a));
            jSONObject2.put("03020", bv.b(this.f18356a));
            jSONObject2.put("03030", bg.d(this.f18356a));
            jSONObject.put("51", jSONObject2);
            an anVar2 = new an();
            jSONObject.put("107", anVar2.d());
            jSONObject.put("155", anVar2.e());
            jSONObject.put("170", anVar2.g());
            jSONObject.put("190", anVar2.f());
            ah ahVar = new ah();
            jSONObject.put("131", ahVar.a());
            jSONObject.put("145", ahVar.a(this.f18356a));
            jSONObject.put("132", dk.a());
            jSONObject.put("133", new aj(this.f18356a).g());
            if (a2.b(df.an, 1) == 1) {
                jSONObject.put("139", dl.c(this.f18356a));
                jSONObject.put("140", dl.d(this.f18356a));
                jSONObject.put("147", dl.a());
                jSONObject.put("148", di.b());
                jSONObject.put("149", di.c());
                jSONObject.put("151", dk.b());
            }
            if (a2.b(df.ac, 0) == 1) {
                jSONObject.put("128", ad.b() ? 1 : 0);
            }
            if (Engine.loadSuccess) {
                as asVar = new as(this.f18356a, 100);
                jSONObject.put("6", asVar.a("6"));
                JSONArray a7 = asVar.a(asVar.a(), "41");
                if (a7 != null && a7.length() > 0) {
                    JSONArray c2 = asVar.c(asVar.a(), "41");
                    JSONArray b3 = asVar.b(asVar.a(), "41");
                    jSONObject.put(RoomMasterTable.DEFAULT_ID, c2);
                    jSONObject.put("43", b3);
                    jSONObject.put("41", asVar.a(asVar.a(a7, c2), b3));
                }
                jSONObject.put("47", asVar.a("47"));
                jSONObject.put(com.huawei.openalliance.ad.beans.inner.a.Code, asVar.a(com.huawei.openalliance.ad.beans.inner.a.Code));
                jSONObject.put(com.tencent.connect.common.II0xO0.f26768O0xxXxI, asVar.a(com.tencent.connect.common.II0xO0.f26768O0xxXxI));
                jSONObject.put("37", asVar.a("37"));
                jSONObject.put("38", asVar.a("38"));
                jSONObject.put("40", asVar.b("40"));
                String str2 = str;
                jSONObject.put(str2, asVar.b(str2));
                jSONObject.put("46", asVar.e("46"));
                jSONObject.put("91", asVar.a("91"));
                jSONObject.put("62", asVar.c("62"));
                jSONObject.put("63", asVar.c("63"));
                jSONObject.put("64", asVar.c("64"));
                jSONObject.put("85", asVar.d("85"));
                jSONObject.put("50", asVar.a("50"));
                jSONObject.put(gb.Code, asVar.c(gb.Code));
                jSONObject.put("39", asVar.a("39"));
                jSONObject.put("52", asVar.a("52"));
                jSONObject.put("53", asVar.a("53"));
                jSONObject.put("54", asVar.a("54"));
                jSONObject.put("55", asVar.a("55"));
                jSONObject.put("73", asVar.a("73"));
                jSONObject.put("74", asVar.a("74"));
                jSONObject.put("104", asVar.a("104"));
                if (a2.b(df.X, 1) == 1 && Build.VERSION.SDK_INT < 23) {
                    ar arVar = new ar(this.f18356a);
                    String a8 = arVar.a("57");
                    if (!TextUtils.isEmpty(a8)) {
                        jSONObject.put("57", a8);
                        jSONObject.put("56", arVar.a("56"));
                    }
                }
                jSONObject.put("77", asVar.a("77"));
                jSONObject.put("78", asVar.a("78"));
                jSONObject.put("79", asVar.a("79"));
                jSONObject.put("84", asVar.a("84"));
                jSONObject.put("80", asVar.a("80"));
                jSONObject.put("81", asVar.a("81"));
                jSONObject.put("82", asVar.a("82"));
                jSONObject.put("83", asVar.a("83"));
                jSONObject.put("87", asVar.a("87"));
                jSONObject.put("89", asVar.a("89"));
                jSONObject.put("90", asVar.d("90"));
                jSONObject.put("75", asVar.a("75"));
                jSONObject.put("88", asVar.a("88"));
                jSONObject.put("92", asVar.a("92"));
                jSONObject.put("93", asVar.a("93"));
                jSONObject.put("94", asVar.a("94"));
                jSONObject.put("95", asVar.a("95"));
                jSONObject.put("98", asVar.a("98"));
                jSONObject.put("100", asVar.a("100"));
                jSONObject.put("105", asVar.a("105"));
                if (a2.b(df.Z, 1) == 1) {
                    aq aqVar = new aq(this.f18356a, 0);
                    jSONObject.put("108", aqVar.a("108"));
                    jSONObject.put("109", aqVar.a("109"));
                    jSONObject.put("111", aqVar.a("111"));
                }
                if (a2.b(df.ab, 1) == 1) {
                    aq aqVar2 = new aq(this.f18356a, 1);
                    jSONObject.put("112", aqVar2.b("112"));
                    jSONObject.put("113", aqVar2.a("113"));
                    jSONObject.put("114", aqVar2.a("114"));
                    jSONObject.put("115", aqVar2.a("115"));
                    jSONObject.put("116", aqVar2.a("116"));
                    jSONObject.put("117", aqVar2.a("117"));
                    jSONObject.put("120", aqVar2.a("120"));
                    aq aqVar3 = new aq(this.f18356a, 4);
                    jSONObject.put("124", aqVar3.a("124"));
                    jSONObject.put("125", aqVar3.a("125"));
                    jSONObject.put("126", aqVar3.a("126"));
                    jSONObject.put("127", aqVar3.a("127"));
                }
                if (a2.b(df.aj, 0) == 1) {
                    av avVar = new av(this.f18356a, 100);
                    jSONObject.put("97", avVar.a("97"));
                    jSONObject.put("118", avVar.a("118"));
                    jSONObject.put("119", avVar.a("119"));
                    jSONObject.put("135", avVar.a("135"));
                    jSONObject.put("174", avVar.a("174"));
                    av avVar2 = new av(this.f18356a, 200);
                    jSONObject.put("173", avVar2.a("173"));
                    jSONObject.put("182", avVar2.a("182"));
                }
                if (a2.b(df.Y, 1) == 1) {
                    jSONObject.put("129", new be(this.f18356a, 4).a("129"));
                    be beVar = new be(this.f18356a, 1);
                    jSONObject.put("121", beVar.a(beVar.a(), "121"));
                    be beVar2 = new be(this.f18356a, 2);
                    jSONObject.put("137", beVar2.a("137"));
                    jSONObject.put("138", beVar2.a("138"));
                    jSONObject.put("141", beVar2.a("141"));
                    jSONObject.put("142", beVar2.a("142"));
                    bf bfVar = new bf(this.f18356a, 3);
                    JSONArray b4 = bfVar.b("150");
                    jSONObject.put("150", b4);
                    if (b4 != null) {
                        jSONObject.put("188", bfVar.a(b4));
                    }
                }
                if (a2.b(df.U, 1) == 1) {
                    ba baVar = new ba(this.f18356a, 100);
                    jSONObject.put("152", baVar.a("152"));
                    jSONObject.put("153", baVar.a("153"));
                    jSONObject.put("156", baVar.a("156"));
                    jSONObject.put("157", baVar.a("157"));
                    jSONObject.put("163", baVar.a("163"));
                    jSONObject.put("171", baVar.a("171", true));
                    jSONObject.put("172", baVar.b("172"));
                    jSONObject.put("177", new ba(this.f18356a, 500).d("177"));
                }
                if ((e || e2) && a2.b(df.W, 0) == 1) {
                    jSONObject.put("158", new ba(this.f18356a, 300).b("158"));
                }
                if (a2.b(df.am, 0) == 1) {
                    bd bdVar = new bd(this.f18356a);
                    jSONObject.put("162", bdVar.a("162"));
                    jSONObject.put("160", bdVar.a(bdVar.a(), "160"));
                    ba baVar2 = new ba(this.f18356a, 400);
                    jSONObject.put("164", baVar2.a("164"));
                    jSONObject.put("165", baVar2.a("165"));
                    jSONObject.put("166", baVar2.c("166"));
                    jSONObject.put("167", baVar2.a("167"));
                }
                if (a2.b(df.ak, 1) == 1) {
                    ay ayVar = new ay(this.f18356a, 600);
                    jSONObject.put("179", ayVar.a("179"));
                    jSONObject.put("186", ayVar.a("186"));
                    jSONObject.put("189", ayVar.a("189"));
                }
            }
            jSONObject.put("60", ab.b(this.f18356a) ? 1 : 0);
            jSONObject.put("11000", Engine.loadSuccess ? 1 : 0);
            jSONObject.put("11002", Engine.soVersion);
            jSONObject.put("11008", a2.b(df.g, bq.e));
            jSONObject.put("11009", bs.a(this.f18356a.getApplicationContext()));
            try {
                jSONObject.put("11301", bh.c(com.kwad.sdk.e.b.Jd().Jc()));
                jSONObject.put("11302", bh.c(com.kwad.sdk.e.b.Jd().getSdkVersion()));
                jSONObject.put("11303", bh.c(com.kwad.sdk.e.b.Jd().getAppId()));
            } catch (Throwable unused) {
            }
            String b5 = a2.b(df.m, "", true);
            if (!TextUtils.isEmpty(b5)) {
                jSONObject.put("183", b5);
                a2.c(df.m, "");
            }
            jSONObject.put("11006", e ? 1 : 0);
            jSONObject.put("11029", e2 ? 1 : 0);
            jSONObject.put("11028", WeaponHI.sKSSdkver);
            jSONObject.put("20000", this.b);
            jSONObject.put("20001", this.c);
            try {
                jSONObject.put("02078", A.getE("W_S_V"));
                jSONObject.put("02079", A.getE("W_S_S_V"));
            } catch (Throwable unused2) {
            }
            jSONObject.put("11007", System.currentTimeMillis() - currentTimeMillis);
            jSONObject.put("11017", jSONObject.toString().length());
            return jSONObject;
        } catch (Throwable unused3) {
            return null;
        }
    }

    public String a(String str) {
        JSONObject a2;
        try {
            JSONObject a3 = new cm(str, ck.l).a(this.f18356a);
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
