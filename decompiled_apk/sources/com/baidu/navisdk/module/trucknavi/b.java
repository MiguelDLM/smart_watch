package com.baidu.navisdk.module.trucknavi;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.navisdk.framework.interfaces.pronavi.m;
import com.baidu.navisdk.module.cloudconfig.d;
import com.baidu.navisdk.module.cloudconfig.f;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.a0;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.common.v;
import com.baidu.navisdk.util.http.center.e;
import com.baidu.navisdk.util.http.center.i;
import com.baidu.navisdk.util.http.center.l;
import java.util.ArrayList;
import java.util.List;
import o0oIxXOx.oO;

/* loaded from: classes7.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private boolean f7575a;
    private boolean b;

    /* renamed from: com.baidu.navisdk.module.trucknavi.b$b, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0295b {

        /* renamed from: a, reason: collision with root package name */
        private static final b f7577a = new b(null);
    }

    public /* synthetic */ b(a aVar) {
        this();
    }

    private String c() {
        String b = com.baidu.navisdk.util.http.b.d().b("truckOperationActivity");
        g gVar = g.COMMON;
        if (gVar.d()) {
            gVar.e("TruckOperationActivitie", "getUrl --> url = " + b);
        }
        return b;
    }

    private b() {
        this.b = false;
    }

    public static b b() {
        return C0295b.f7577a;
    }

    public void a() {
        this.b = false;
    }

    private void b(String str) {
        g gVar = g.COMMON;
        if (gVar.d()) {
            gVar.e("TruckOperationActivitie", "postToService: " + str);
        }
        e eVar = new e();
        eVar.f9300a = true;
        com.baidu.navisdk.util.http.center.b.a().b(c(), com.baidu.navisdk.util.http.center.c.a(a(str)), new a(str), eVar);
    }

    public void a(long j, m mVar) {
        boolean z;
        int i;
        String str;
        if (f.c().c.h0) {
            return;
        }
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("TruckOperationActivitie", "naviMileageTask: " + j + ",isPostNaviMileageTask: " + this.b);
        }
        if (!this.b && j >= 10000) {
            if (mVar != null) {
                z = mVar.a();
                i = mVar.b();
            } else {
                z = false;
                i = 0;
            }
            if (gVar.d()) {
                gVar.e("TruckOperationActivitie", "naviMileageTask: " + z + ",trajectoryType: " + i);
            }
            if (!z) {
                str = "trucknavi";
            } else if (i != 2) {
                return;
            } else {
                str = "trajnavi";
            }
            b(str);
        }
    }

    /* loaded from: classes7.dex */
    public class a extends com.baidu.navisdk.util.http.center.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f7576a;

        public a(String str) {
            this.f7576a = str;
        }

        @Override // com.baidu.navisdk.util.http.center.f
        public void a(int i, String str, Throwable th) {
            g gVar = g.COMMON;
            if (gVar.d()) {
                gVar.e("TruckOperationActivitie", "report-onFailure --> statusCode = " + i + ", responseString = " + str);
            }
            if (gVar.b()) {
                TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), "货车运营：上传失败 statusCode:" + i);
            }
        }

        @Override // com.baidu.navisdk.util.http.center.f
        public void a(int i, String str) {
            g gVar = g.COMMON;
            if (gVar.d()) {
                gVar.e("TruckOperationActivitie", "report-onSuccess --> statusCode = " + i + ", responseString = " + str);
            }
            if (gVar.b()) {
                TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), "货车运营：成功");
            }
            if ("findroute".equals(this.f7576a)) {
                b.this.f7575a = true;
            } else {
                b.this.b = true;
            }
        }
    }

    public List<l> a(String str) {
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new i("type", "trucknavi"));
            arrayList.add(new i("taskType", str));
            String E = com.baidu.navisdk.framework.b.E();
            if (!TextUtils.isEmpty(E)) {
                arrayList.add(new i("bduid", E));
            }
            Bundle B = com.baidu.navisdk.framework.b.B();
            if (B != null) {
                String string = B.getString(oO.f31192XO);
                if (!TextUtils.isEmpty(string)) {
                    arrayList.add(new i(oO.f31192XO, string));
                }
                String string2 = B.getString("sv");
                if (!TextUtils.isEmpty(string2)) {
                    arrayList.add(new i("sv", string2));
                }
            }
            String e = a0.e();
            if (!TextUtils.isEmpty(e)) {
                arrayList.add(new i("cuid", e));
            }
            String e2 = com.baidu.navisdk.framework.b.e();
            if (!TextUtils.isEmpty(e2)) {
                arrayList.add(new i("bduss", e2));
            }
            com.baidu.navisdk.util.http.a.a(arrayList);
            String str2 = d.a(arrayList) + "924a8ceeac17f54d3be3f8cdf1c04eb2";
            g gVar = g.COMMON;
            if (gVar.d()) {
                gVar.e("TruckOperationActivitie", "getRequestParams --> sortString = " + str2);
            }
            String a2 = v.a(str2);
            if (TextUtils.isEmpty(a2)) {
                a2 = "";
            }
            if (gVar.d()) {
                gVar.e("TruckOperationActivitie", "getRequestParams --> sign = " + a2);
            }
            arrayList.add(new i(HttpConstants.SIGN, a2));
            return arrayList;
        } catch (Exception e3) {
            g gVar2 = g.COMMON;
            if (gVar2.d()) {
                gVar2.e("TruckOperationActivitie", "getRequestParams --> e = " + e3);
            }
            return new ArrayList();
        }
    }
}
