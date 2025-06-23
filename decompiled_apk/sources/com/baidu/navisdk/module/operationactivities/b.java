package com.baidu.navisdk.module.operationactivities;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.framework.message.a;
import com.baidu.navisdk.framework.message.bean.d;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.a0;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.common.v;
import com.baidu.navisdk.util.common.y;
import com.baidu.navisdk.util.http.center.e;
import com.baidu.navisdk.util.http.center.f;
import com.baidu.navisdk.util.http.center.i;
import com.baidu.navisdk.util.http.center.l;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.util.ArrayList;
import java.util.List;
import o0oIxXOx.oO;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class b implements com.baidu.navisdk.module.operationactivities.a, a.InterfaceC0201a {

    /* renamed from: a, reason: collision with root package name */
    private SparseArray<c> f7370a;
    private volatile boolean b;
    private final int[] c;

    /* renamed from: com.baidu.navisdk.module.operationactivities.b$b, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0271b {

        /* renamed from: a, reason: collision with root package name */
        private static final b f7372a = new b(null);
    }

    public /* synthetic */ b(a aVar) {
        this();
    }

    private void b(c cVar, int i) {
        g gVar = g.COMMON;
        if (gVar.d()) {
            gVar.e("OperationActivitiesCont", "postDoneTaskToServer: " + cVar + ",taskType:" + i);
        }
        cVar.f = true;
        e eVar = new e();
        eVar.f9300a = true;
        com.baidu.navisdk.util.http.center.b.a().b(b(), com.baidu.navisdk.util.http.center.c.a(a(cVar, i)), new a(i), eVar);
    }

    private String c(int i) {
        return b(i, "");
    }

    private String d(int i) {
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? "" : "newenergy_calculation_road" : "record_voice" : "view_smart_navi" : "moss_navi" : "quick_navi";
    }

    private void e() {
        g gVar = g.COMMON;
        if (gVar.d()) {
            gVar.e("OperationActivitiesCont", "loadTaskDataFromLocal: ");
        }
        int[] iArr = this.c;
        if (iArr != null && iArr.length > 0) {
            for (int i : iArr) {
                String b = b(i);
                if (BNSettingManager.containsKey(b)) {
                    a(i, BNSettingManager.getString(b, null));
                }
            }
            return;
        }
        if (gVar.d()) {
            gVar.e("OperationActivitiesCont", "loadTaskDataFromLocal: mAllTaskType == null || mAllTaskType.length <= 0");
        }
    }

    private void f() {
        int[] iArr = this.c;
        if (iArr != null && iArr.length > 0) {
            for (int i : iArr) {
                String b = b(i);
                if (BNSettingManager.containsKey(b)) {
                    BNSettingManager.removeKey(b);
                }
            }
            return;
        }
        g gVar = g.COMMON;
        if (gVar.d()) {
            gVar.e("OperationActivitiesCont", "removeAllTaskDataFromLocal: mAllTaskType == null || mAllTaskType.length <= 0");
        }
    }

    private void g() {
        int[] iArr = this.c;
        if (iArr != null && iArr.length > 0) {
            for (int i : iArr) {
                String c = c(i);
                if (BNSettingManager.containsKey(c)) {
                    BNSettingManager.removeKey(c);
                }
            }
            return;
        }
        g gVar = g.COMMON;
        if (gVar.d()) {
            gVar.e("OperationActivitiesCont", "removeOldVersionLocalData: mAllTaskType == null || mAllTaskType.length <= 0");
        }
    }

    @Override // com.baidu.navisdk.framework.message.a.InterfaceC0201a
    public void onEvent(Object obj) {
        if (obj instanceof d) {
            a(((d) obj).f6826a);
        }
    }

    private b() {
        this.b = false;
        this.c = new int[]{1, 2, 3, 4};
        c();
        if (com.baidu.navisdk.module.cloudconfig.a.b().a("bn_is_finish_haoqiye_2020", false)) {
            g gVar = g.COMMON;
            if (gVar.d()) {
                gVar.e("OperationActivitiesCont", "OperationActivitiesController init isFinishHaoQiYe2020");
            }
            f();
            return;
        }
        d();
    }

    private void c() {
        if (TextUtils.equals("", com.huawei.hms.ads.dynamicloader.b.f)) {
            return;
        }
        g();
    }

    private void d() {
        if (this.b) {
            return;
        }
        this.b = true;
        if (this.f7370a == null) {
            this.f7370a = new SparseArray<>(4);
        }
        e();
        com.baidu.navisdk.framework.message.a.a().a(this, d.class, new Class[0]);
    }

    public static com.baidu.navisdk.module.operationactivities.a a() {
        return C0271b.f7372a;
    }

    private void a(String str) {
        g gVar = g.COMMON;
        if (gVar.d()) {
            gVar.e("OperationActivitiesCont", "removeTaskDataFromLocal: " + str);
        }
        BNSettingManager.removeKey(str);
    }

    /* loaded from: classes7.dex */
    public class a extends f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f7371a;

        public a(int i) {
            this.f7371a = i;
        }

        @Override // com.baidu.navisdk.util.http.center.f
        public void a(int i, String str, Throwable th) {
            b.this.a(this.f7371a, false);
            g gVar = g.COMMON;
            if (gVar.d()) {
                gVar.e("OperationActivitiesCont", "report-onFailure --> statusCode = " + i + ", responseString = " + str);
            }
            if (gVar.b()) {
                TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), "好奇夜2020：上传失败 statusCode:" + i);
            }
        }

        @Override // com.baidu.navisdk.util.http.center.f
        public void a(int i, String str) {
            g gVar = g.COMMON;
            if (gVar.d()) {
                gVar.e("OperationActivitiesCont", "report-onSuccess --> statusCode = " + i + ", responseString = " + str);
            }
            try {
                int optInt = new JSONObject(str).optInt("code");
                if (optInt == 2000) {
                    b.this.e(this.f7371a);
                    if (gVar.b()) {
                        TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), "好奇夜2020：成功");
                    }
                } else if (gVar.b()) {
                    TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), "好奇夜2020：上传失败 code:" + optInt);
                }
            } catch (JSONException e) {
                e.printStackTrace();
                if (g.COMMON.b()) {
                    TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), "好奇夜2020：上传失败 statusCode:" + i);
                }
            }
            b.this.a(this.f7371a, false);
        }
    }

    private boolean a(int i, String str) {
        g gVar = g.COMMON;
        if (gVar.d()) {
            gVar.e("OperationActivitiesCont", "addTask: " + i + ", jsonStr:" + str);
        }
        if (!TextUtils.isEmpty(str) && this.f7370a != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                c cVar = new c();
                cVar.f7373a = jSONObject.optInt("taskid", -1);
                cVar.b = jSONObject.optString("token", null);
                cVar.d = jSONObject.optString("src", null);
                cVar.c = jSONObject.optInt(ConstantsAPI.WXWebPage.KEY_ACTIVITY_ID, -1);
                cVar.e = jSONObject.optString("source", d(i));
                cVar.f = false;
                if (!cVar.a()) {
                    return true;
                }
                this.f7370a.put(i, cVar);
                return true;
            } catch (Exception e) {
                g.COMMON.a("operationAddTask", e);
            }
        }
        return false;
    }

    private String b() {
        String b = com.baidu.navisdk.util.http.b.d().b("HaoQiYe2020Operation");
        g gVar = g.COMMON;
        if (gVar.d()) {
            gVar.e("OperationActivitiesCont", "getUrl --> url = " + b);
        }
        return b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(int i) {
        g gVar = g.COMMON;
        if (gVar.d()) {
            gVar.e("OperationActivitiesCont", "removeTask: " + i);
        }
        SparseArray<c> sparseArray = this.f7370a;
        if (sparseArray != null) {
            sparseArray.delete(i);
        }
        a(b(i));
    }

    private String b(int i) {
        return b(i, com.huawei.hms.ads.dynamicloader.b.f);
    }

    private String b(int i, String str) {
        if (i == 1) {
            return str + "bn_operation_fast_navi";
        }
        if (i == 2) {
            return str + "bn_operation_commute";
        }
        if (i == 3) {
            return str + "bn_operation_new_route_result";
        }
        if (i != 4) {
            return str + "bn_operation_activities_" + i;
        }
        return str + "bn_operation_record_voice";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z) {
        c cVar;
        SparseArray<c> sparseArray = this.f7370a;
        if (sparseArray == null || (cVar = sparseArray.get(i)) == null) {
            return;
        }
        cVar.f = z;
    }

    public List<l> a(c cVar, int i) {
        String str = "";
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new i(ConstantsAPI.WXWebPage.KEY_ACTIVITY_ID, cVar.c + ""));
            arrayList.add(new i("tkid", cVar.b));
            arrayList.add(new i("source", cVar.e));
            String E = com.baidu.navisdk.framework.b.E();
            if (!TextUtils.isEmpty(E)) {
                arrayList.add(new i("bduid", E));
            }
            Bundle B = com.baidu.navisdk.framework.b.B();
            if (B != null) {
                String string = B.getString("zid");
                if (!TextUtils.isEmpty(string)) {
                    arrayList.add(new i("zid", string));
                }
                String string2 = B.getString(oO.f31192XO);
                if (!TextUtils.isEmpty(string2)) {
                    arrayList.add(new i(oO.f31192XO, string2));
                }
                String string3 = B.getString("sv");
                if (!TextUtils.isEmpty(string3)) {
                    arrayList.add(new i("sv", string3));
                }
            }
            String e = a0.e();
            if (!TextUtils.isEmpty(e)) {
                arrayList.add(new i("cuid", e));
            }
            com.baidu.navisdk.util.http.a.a(arrayList);
            String str2 = com.baidu.navisdk.module.cloudconfig.d.a(arrayList) + "cebdde3a9bdab3eb91bbec98058cb3bf";
            g gVar = g.COMMON;
            if (gVar.d()) {
                gVar.e("OperationActivitiesCont", "getRequestParams --> sortString = " + str2);
            }
            String a2 = v.a(str2);
            if (!TextUtils.isEmpty(a2)) {
                str = a2;
            }
            if (gVar.d()) {
                gVar.e("OperationActivitiesCont", "getRequestParams --> sign = " + str);
            }
            arrayList.add(new i(HttpConstants.SIGN, str));
            return arrayList;
        } catch (Exception e2) {
            g gVar2 = g.COMMON;
            if (gVar2.d()) {
                gVar2.e("OperationActivitiesCont", "getRequestParams --> e = " + e2);
            }
            return new ArrayList();
        }
    }

    public void a(int i) {
        g gVar = g.COMMON;
        if (gVar.d()) {
            gVar.e("OperationActivitiesCont", "handleDoneTask taskType:" + i);
        }
        if (com.baidu.navisdk.module.cloudconfig.a.b().a("bn_is_finish_haoqiye_2020", false)) {
            if (gVar.d()) {
                gVar.e("OperationActivitiesCont", "handleDoneTask isFinishHaoQiYe2020:");
                return;
            }
            return;
        }
        SparseArray<c> sparseArray = this.f7370a;
        c cVar = sparseArray != null ? sparseArray.get(i) : null;
        if (gVar.d()) {
            gVar.e("OperationActivitiesCont", "handleDoneTask:" + cVar);
        }
        if (cVar == null || cVar.f) {
            return;
        }
        if (y.b == 0) {
            gVar.e("OperationActivitiesCont", "handleDoneTask isNetworkAvailable = false!");
        } else {
            b(cVar, i);
        }
    }
}
