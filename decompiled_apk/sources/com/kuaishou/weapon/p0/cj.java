package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import androidx.room.RoomMasterTable;
import com.huawei.hms.ads.gb;
import com.kuaishou.weapon.p0.jni.Engine;
import com.sma.smartv3.ble.ProductManager;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public class cj {

    /* renamed from: a, reason: collision with root package name */
    private Context f18354a;

    public cj(Context context) {
        this.f18354a = context;
    }

    public JSONObject a() {
        int i;
        try {
            JSONObject jSONObject = new JSONObject();
            h a2 = h.a(this.f18354a, "re_po_rt");
            boolean e = a2.e("a1_p_s_p_s");
            boolean e2 = a2.e("a1_p_s_p_s_c_b");
            if (a2.b(df.G, 1) != 1) {
                return null;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (a2.b(df.K, 0) == 1 && Engine.loadSuccess) {
                ap apVar = new ap(this.f18354a);
                jSONObject.put("0", apVar.b("0"));
                jSONObject.put("1", apVar.b("1"));
                jSONObject.put("2", apVar.b("2"));
                jSONObject.put("4", apVar.b("4"));
                jSONObject.put("5", apVar.b("5"));
                jSONObject.put("6", apVar.b("6"));
                jSONObject.put("7", apVar.b("7"));
                jSONObject.put("8", apVar.b("8"));
                jSONObject.put("9", apVar.b("9"));
                jSONObject.put("10", apVar.b("10"));
                jSONObject.put("11", apVar.b("11"));
                jSONObject.put(com.tencent.connect.common.II0xO0.f26834o0IXXIx, apVar.b(com.tencent.connect.common.II0xO0.f26834o0IXXIx));
                jSONObject.put(com.tencent.connect.common.II0xO0.f26825XoIxOXIXo, apVar.b(com.tencent.connect.common.II0xO0.f26825XoIxOXIXo));
                jSONObject.put(com.tencent.connect.common.II0xO0.f26773OO0, apVar.b(com.tencent.connect.common.II0xO0.f26773OO0));
                jSONObject.put("15", apVar.b("15"));
                jSONObject.put("16", apVar.b("16"));
                jSONObject.put(com.tencent.connect.common.II0xO0.f26886xIXX, apVar.b(com.tencent.connect.common.II0xO0.f26886xIXX));
                jSONObject.put("18", apVar.b("18"));
                jSONObject.put(com.tencent.connect.common.II0xO0.f26837o0oxo0oI, apVar.b(com.tencent.connect.common.II0xO0.f26837o0oxo0oI));
                jSONObject.put("20", apVar.b("20"));
                jSONObject.put("21", apVar.b("21"));
                jSONObject.put(com.tencent.connect.common.II0xO0.f26892xOOxIO, apVar.b(com.tencent.connect.common.II0xO0.f26892xOOxIO));
                jSONObject.put(com.tencent.connect.common.II0xO0.f26768O0xxXxI, apVar.b(com.tencent.connect.common.II0xO0.f26768O0xxXxI));
                jSONObject.put(com.tencent.connect.common.II0xO0.f26868oxOXxoXII, apVar.b(com.tencent.connect.common.II0xO0.f26868oxOXxoXII));
                jSONObject.put(com.tencent.connect.common.II0xO0.f26759IxX00, apVar.b(com.tencent.connect.common.II0xO0.f26759IxX00));
                jSONObject.put(com.tencent.connect.common.II0xO0.f26813XO0o, apVar.b(com.tencent.connect.common.II0xO0.f26813XO0o));
                jSONObject.put("27", apVar.b("27"));
                jSONObject.put(com.tencent.connect.common.II0xO0.f26789OxXXx0X, apVar.b(com.tencent.connect.common.II0xO0.f26789OxXXx0X));
                jSONObject.put("29", apVar.b("29"));
                jSONObject.put("30", apVar.b("30"));
                jSONObject.put("31", apVar.b("31"));
                jSONObject.put("32", apVar.b("32"));
                jSONObject.put("33", apVar.b("33"));
                jSONObject.put("34", apVar.b("34"));
                jSONObject.put("35", apVar.b("35"));
                jSONObject.put("36", apVar.b("36"));
                jSONObject.put("37", apVar.b("37"));
                jSONObject.put("38", apVar.b("38"));
                jSONObject.put("39", apVar.b("39"));
                jSONObject.put("40", apVar.b("40"));
                jSONObject.put("41", apVar.b("41"));
                jSONObject.put(RoomMasterTable.DEFAULT_ID, apVar.b(RoomMasterTable.DEFAULT_ID));
                jSONObject.put("43", apVar.a("43"));
                jSONObject.put("44", apVar.a("44"));
                jSONObject.put("101", apVar.b("101"));
                jSONObject.put("102", apVar.b("102"));
                jSONObject.put("105", apVar.b("105"));
                jSONObject.put("106", apVar.b("106"));
                jSONObject.put(com.huawei.openalliance.ad.beans.inner.a.V, dl.b(this.f18354a));
            }
            if (a2.b(df.J, 1) == 1 && Engine.loadSuccess) {
                at atVar = new at(this.f18354a);
                jSONObject.put("45", atVar.d("45"));
                if (atVar.a()) {
                    i = 1;
                    jSONObject.put("93", 1);
                } else {
                    i = 1;
                }
                if (atVar.b()) {
                    jSONObject.put("94", i);
                }
                jSONObject.put("46", atVar.d("46"));
                jSONObject.put(com.huawei.openalliance.ad.beans.inner.a.Code, atVar.a(com.huawei.openalliance.ad.beans.inner.a.Code));
                jSONObject.put("51", atVar.b("51"));
                jSONObject.put("52", atVar.a(this.f18354a, "52", 0));
                jSONObject.put("55", atVar.c("55"));
                jSONObject.put("66", atVar.a("66"));
                jSONObject.put("67", di.d());
                jSONObject.put("78", atVar.a("78"));
                jSONObject.put("79", atVar.a("79"));
                az azVar = new az(this.f18354a, 200);
                jSONObject.put(gb.Code, azVar.a(gb.Code));
                jSONObject.put("71", azVar.a("71"));
                jSONObject.put("72", azVar.a("72"));
                jSONObject.put("73", azVar.a("73"));
                jSONObject.put("74", azVar.a("74"));
            }
            if (a2.b(df.M, 1) == 1) {
                ax axVar = new ax(this.f18354a);
                jSONObject.put("53", axVar.a(this.f18354a, "53", 1));
                jSONObject.put("56", axVar.a("56"));
                jSONObject.put("57", axVar.a("57"));
                jSONObject.put("64", di.a());
            }
            if (a2.b(df.N, 1) == 1) {
                cs csVar = new cs();
                jSONObject.put("98", csVar.a());
                jSONObject.put("107", csVar.b());
                String d = am.d();
                if (!TextUtils.isEmpty(d)) {
                    jSONObject.put("77", d);
                }
                jSONObject.put("104", am.c());
                jSONObject.put("109", dl.e(this.f18354a));
                aj ajVar = new aj(this.f18354a);
                jSONObject.put("82", ajVar.h());
                String i2 = ajVar.i();
                if (!TextUtils.isEmpty(i2)) {
                    jSONObject.put("83", i2);
                }
                String j = ajVar.j();
                if (!TextUtils.isEmpty(j)) {
                    jSONObject.put("84", j);
                }
                String k = ajVar.k();
                if (!TextUtils.isEmpty(k)) {
                    jSONObject.put(ProductManager.f20409OIoxIx, k);
                }
            }
            if (a2.b(df.L, 1) == 1) {
                au auVar = new au(this.f18354a);
                jSONObject.put("95", auVar.b("95"));
                jSONObject.put("96", auVar.a() ? 1 : 0);
                jSONObject.put("97", di.e());
                try {
                    jSONObject.put("11301", bh.c(com.kwad.sdk.e.b.Jd().Jc()));
                    jSONObject.put("11302", bh.c(com.kwad.sdk.e.b.Jd().getSdkVersion()));
                    jSONObject.put("11303", bh.c(com.kwad.sdk.e.b.Jd().getAppId()));
                } catch (Throwable unused) {
                }
            }
            jSONObject.put("11006", e ? 1 : 0);
            jSONObject.put("11029", e2 ? 1 : 0);
            jSONObject.put("11002", Engine.soVersion);
            jSONObject.put("11007", System.currentTimeMillis() - currentTimeMillis);
            jSONObject.put("11017", jSONObject.toString().length());
            return jSONObject;
        } catch (Throwable unused2) {
            return null;
        }
    }

    public String a(String str) {
        JSONObject a2;
        try {
            JSONObject a3 = new cm(str, ck.l).a(this.f18354a);
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
