package com.baidu.navisdk.module.roadcondition;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.model.datastruct.m;
import com.baidu.navisdk.module.cloudconfig.f;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.common.l0;
import com.baidu.navisdk.util.worker.e;
import com.baidu.navisdk.util.worker.f;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public class a implements com.baidu.navisdk.module.roadcondition.b {
    public static boolean f = false;

    /* renamed from: a, reason: collision with root package name */
    private List<m> f7473a;
    private List<com.baidu.navisdk.module.pronavi.model.c> b;
    private f<String, String> c;
    private volatile boolean d = false;
    private b e = new c(null);

    /* renamed from: com.baidu.navisdk.module.roadcondition.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0280a extends f<String, String> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f7474a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0280a(String str, String str2, d dVar) {
            super(str, str2);
            this.f7474a = dVar;
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            a.this.b(this.f7474a);
            a.this.d = true;
            return null;
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        boolean a();
    }

    /* loaded from: classes7.dex */
    public static class c implements b {
        private c() {
        }

        @Override // com.baidu.navisdk.module.roadcondition.a.b
        public boolean a() {
            return true;
        }

        public /* synthetic */ c(C0280a c0280a) {
            this();
        }
    }

    /* loaded from: classes7.dex */
    public interface d {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(d dVar) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNRoadConditionData", "getRoadConditionAndJamInfo: " + dVar);
        }
        Bundle bundle = new Bundle();
        boolean roadConditionAndJamInfo = BNRouteGuider.getInstance().getRoadConditionAndJamInfo(bundle);
        if (gVar.d()) {
            gVar.e("BNRoadConditionData", "getRoadConditionAndJamInfo1: " + roadConditionAndJamInfo + ", " + bundle);
        }
        ArrayList arrayList = null;
        if (roadConditionAndJamInfo && !bundle.isEmpty()) {
            Bundle[] bundleArr = (Bundle[]) bundle.getParcelableArray("road_condition_array");
            Bundle[] bundleArr2 = (Bundle[]) bundle.getParcelableArray("bar_icon_array");
            if (!f.p0.f7130a) {
                if (gVar.d()) {
                    gVar.e("BNRoadConditionData", "getRoadConditionAndJamInfo 云端控制不展示拥堵标签");
                }
                bundleArr2 = null;
            }
            if (bundleArr != null && bundleArr.length != 0) {
                ArrayList arrayList2 = new ArrayList(bundleArr.length);
                int i = 0;
                for (Bundle bundle2 : bundleArr) {
                    m b2 = b(bundle2);
                    g gVar2 = g.PRO_NAV;
                    if (gVar2.d()) {
                        gVar2.e("BNRoadConditionData", "getRoadCondition: " + b2);
                    }
                    if (b2 != null && b2.c > 0) {
                        arrayList2.add(b2);
                        i = b2.c;
                    }
                }
                if (bundleArr2 != null && bundleArr2.length > 0) {
                    int i2 = bundle.getInt("jamVersion", -1);
                    String string = bundle.getString("routeMD5", null);
                    arrayList = new ArrayList(bundleArr2.length);
                    boolean a2 = this.e.a();
                    for (Bundle bundle3 : bundleArr2) {
                        com.baidu.navisdk.module.pronavi.model.c a3 = a(bundle3);
                        g gVar3 = g.PRO_NAV;
                        if (gVar3.d()) {
                            gVar3.e("BNRoadConditionData", "getRoadConditionJam: " + a3);
                        }
                        if (a3 != null && a3.c() && a3.e <= i) {
                            if (!a2) {
                                if (gVar3.d()) {
                                    gVar3.e("BNRoadConditionData", "getRoadConditionAndJamInfo: not isSupportAvoid");
                                }
                                a3.n = false;
                            }
                            a3.i = i2;
                            a3.j = string;
                            a3.o = c(a3);
                            a3.p = b(a3);
                            if (a3.c != 3) {
                                a3.b = 3101;
                            }
                            if (a3.f <= 0) {
                                int i3 = a3.d;
                                a3.f = i3 + ((a3.e - i3) / 2);
                            }
                            if (a3.d <= 0 && a3.e <= 0) {
                                int i4 = a3.f;
                                a3.d = i4;
                                a3.e = i4;
                            }
                            arrayList.add(a3);
                        } else if (gVar3.d()) {
                            gVar3.e("BNRoadConditionData", "getRoadConditionJam: jammode 无效");
                        }
                    }
                }
                a(arrayList2, arrayList, dVar);
                return;
            }
            a(null, null, dVar);
            return;
        }
        a(null, null, dVar);
    }

    private String c(com.baidu.navisdk.module.pronavi.model.c cVar) {
        if (cVar == null) {
            return "";
        }
        if (cVar.n && BNSettingManager.isRoadConditionShowAvoid()) {
            return "避开";
        }
        if (cVar.c == 3) {
            int i = cVar.b;
            if (i != 107) {
                if (i != 110) {
                    if (i != 401) {
                        if (i != 504) {
                            if (i != 501) {
                                if (i != 502) {
                                    switch (i) {
                                        case 101:
                                            return a(cVar);
                                        case 102:
                                            return "事故";
                                        case 103:
                                            return "管制";
                                        case 104:
                                            return "封路";
                                        default:
                                            switch (i) {
                                                case 403:
                                                    return "结冰";
                                                case 404:
                                                    return "积雪";
                                                case 405:
                                                    return "积水";
                                                default:
                                                    if (!g.COMMON_UI.b()) {
                                                        return "";
                                                    }
                                                    return "未知";
                                            }
                                    }
                                }
                                return "山体滑坡";
                            }
                            return "山体崩塌";
                        }
                        return "泥石流";
                    }
                    return "团雾";
                }
                return "施工";
            }
            return "危险";
        }
        return a(cVar);
    }

    @Override // com.baidu.navisdk.module.roadcondition.b
    public void a(d dVar) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNRoadConditionData", "asyncLoadRoadConditionData: ");
        }
        if (this.c == null) {
            this.c = new C0280a("RoadCondition-load", null, dVar);
        } else {
            if (gVar.d()) {
                gVar.e("BNRoadConditionData", "loadRoadConditionData: " + this.d);
            }
            if (!this.d) {
                com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.g) this.c, true);
            }
        }
        this.d = false;
        com.baidu.navisdk.util.worker.c.a().c(this.c, new e(203, 0));
    }

    @Override // com.baidu.navisdk.module.roadcondition.b
    @Nullable
    public synchronized List<m> a() {
        return this.f7473a;
    }

    private synchronized void a(List<m> list, List<com.baidu.navisdk.module.pronavi.model.c> list2, d dVar) {
        try {
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("BNRoadConditionData", "handlerLoadDone: ");
            }
            synchronized (this) {
                this.f7473a = list;
                this.b = list2;
            }
        } catch (Throwable th) {
            throw th;
        }
        b();
        if (dVar != null) {
            dVar.a();
        }
    }

    @Nullable
    private com.baidu.navisdk.module.pronavi.model.c a(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        com.baidu.navisdk.module.pronavi.model.c cVar = new com.baidu.navisdk.module.pronavi.model.c();
        cVar.l = bundle.getInt("startShapeIdx", 0);
        cVar.m = bundle.getInt("endShapeIdx", 0);
        cVar.d = bundle.getInt("startAddDist", 0);
        cVar.e = bundle.getInt("endAddDist", 0);
        cVar.g = bundle.getInt("travelTime", 0);
        cVar.f = bundle.getInt("showAddDist", 0);
        cVar.h = bundle.getInt("jamIdx", 0);
        cVar.k = bundle.getInt("priority", 0);
        cVar.c = bundle.getInt("iconType", 0);
        cVar.b = bundle.getInt("eventType", 0);
        cVar.f7463a = bundle.getString("eventId", null);
        cVar.n = bundle.getBoolean("isAvoidJam", false);
        if (cVar.c()) {
            return cVar;
        }
        return null;
    }

    private String a(com.baidu.navisdk.module.pronavi.model.c cVar) {
        int i = cVar.e - cVar.d;
        if (i <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        l0.a(i, l0.a.EN, sb);
        return sb.toString();
    }

    @Nullable
    private m b(Bundle bundle) {
        if (bundle == null || !bundle.containsKey("unEndShapeIdx") || !bundle.containsKey("enRoadCondition")) {
            return null;
        }
        int i = bundle.getInt("unEndShapeIdx", -1);
        int i2 = bundle.getInt("enRoadCondition");
        int i3 = bundle.getInt("unEndAddDist");
        int i4 = bundle.getInt("unEndTravelTime");
        if (i2 < 0 || i2 > 4) {
            i2 = 0;
        }
        m mVar = new m();
        mVar.f6935a = i;
        mVar.b = i2;
        mVar.c = i3;
        mVar.d = i4;
        return mVar;
    }

    private int b(com.baidu.navisdk.module.pronavi.model.c cVar) {
        int i = cVar.c;
        if (i != 3) {
            if (i == 1) {
                return R.drawable.nsdk_ugc_man;
            }
            return R.drawable.nsdk_ugc_interaction_small_yongdu;
        }
        int i2 = cVar.b;
        if (i2 == 107) {
            return R.drawable.nsdk_ugc_interaction_small_weixian;
        }
        if (i2 == 110) {
            return R.drawable.nsdk_ugc_interaction_small_shigong;
        }
        if (i2 == 401) {
            return R.drawable.nsdk_ugc_interaction_small_dawu;
        }
        if (i2 != 504 && i2 != 501 && i2 != 502) {
            switch (i2) {
                case 101:
                    return R.drawable.nsdk_ugc_interaction_small_yongdu;
                case 102:
                    return R.drawable.nsdk_ugc_interaction_small_shigu;
                case 103:
                    return R.drawable.nsdk_ugc_interaction_small_guanzhi;
                case 104:
                    return R.drawable.nsdk_ugc_interaction_small_fenglu;
                default:
                    switch (i2) {
                        case 403:
                            return R.drawable.nsdk_ugc_jiebing;
                        case 404:
                            return R.drawable.nsdk_ugc_jiebing;
                        case 405:
                            return R.drawable.nsdk_ugc_interaction_small_jishui;
                        default:
                            return R.drawable.nsdk_ugc_interaction_small_yongdu;
                    }
            }
        }
        return R.drawable.nsdk_ugc_nishiliu;
    }

    private void b() {
        int i;
        int i2;
        g gVar = g.COMMON_UI;
        if (gVar.c() && f.p0.f7130a && f) {
            List<m> list = this.f7473a;
            if (list == null || list.isEmpty()) {
                i = 0;
            } else {
                List<m> list2 = this.f7473a;
                i = list2.get(list2.size() - 1).c;
            }
            List<com.baidu.navisdk.module.pronavi.model.c> list3 = this.b;
            if (list3 == null || list3.isEmpty()) {
                i2 = 100;
            } else {
                List<com.baidu.navisdk.module.pronavi.model.c> list4 = this.b;
                i2 = list4.get(list4.size() - 1).k - 1;
            }
            g gVar2 = g.PRO_NAV;
            if (gVar2.d()) {
                gVar2.e("BNRoadConditionData", "addTestData totalDistance: " + i + ",minPriority: " + i2);
            }
            int i3 = i / 6;
            int i4 = i3 / 2;
            if (this.b == null) {
                this.b = new ArrayList();
            }
            if (gVar.d()) {
                gVar.e("BNRoadConditionData", "addTestData: ");
            }
            com.baidu.navisdk.module.pronavi.model.c cVar = new com.baidu.navisdk.module.pronavi.model.c();
            cVar.b = 102;
            cVar.c = 3;
            cVar.f = i4;
            cVar.o = c(cVar) + "测4";
            cVar.p = b(cVar);
            cVar.f7463a = "12345678";
            cVar.k = i2;
            this.b.add(cVar);
            com.baidu.navisdk.module.pronavi.model.c cVar2 = new com.baidu.navisdk.module.pronavi.model.c();
            cVar2.b = 401;
            cVar2.c = 3;
            int i5 = i3 + i4;
            cVar2.f = i5;
            cVar2.e = i5;
            cVar2.d = i5;
            cVar2.o = c(cVar2) + "测";
            cVar2.p = b(cVar2);
            cVar2.f7463a = "12345678";
            cVar2.k = i2 + (-1);
            this.b.add(cVar2);
            com.baidu.navisdk.module.pronavi.model.c cVar3 = new com.baidu.navisdk.module.pronavi.model.c();
            cVar3.c = 1;
            int i6 = i3 * 2;
            cVar3.d = i6;
            cVar3.e = i6 + 5009;
            cVar3.o = c(cVar3) + "测0";
            cVar3.p = b(cVar3);
            cVar3.k = i2 + (-2);
            int i7 = cVar3.d;
            cVar3.f = i7 + ((cVar3.e - i7) / 2);
            cVar3.i = 4;
            cVar3.h = 3;
            cVar3.j = "12345qwer";
            cVar3.b = 3101;
            this.b.add(cVar3);
            com.baidu.navisdk.module.pronavi.model.c cVar4 = new com.baidu.navisdk.module.pronavi.model.c();
            cVar4.c = 2;
            int i8 = i3 * 3;
            cVar4.d = i8;
            cVar4.e = i8 + 2100;
            cVar4.o = c(cVar4) + "测1";
            cVar4.p = b(cVar4);
            cVar4.k = i2 + (-3);
            int i9 = cVar4.d;
            cVar4.f = i9 + ((cVar4.e - i9) / 2);
            cVar4.i = 4;
            cVar4.h = 3;
            cVar4.j = "12345qwer";
            cVar4.b = 3101;
            this.b.add(cVar4);
            com.baidu.navisdk.module.pronavi.model.c cVar5 = new com.baidu.navisdk.module.pronavi.model.c();
            cVar5.b = 104;
            cVar5.c = 3;
            int i10 = (i3 * 4) + i4;
            cVar5.f = i10;
            cVar5.e = i10;
            cVar5.d = i10;
            cVar5.o = c(cVar5) + "测2";
            cVar5.p = b(cVar5);
            cVar5.f7463a = "12345678";
            cVar5.k = i2 + (-4);
            this.b.add(cVar5);
            com.baidu.navisdk.module.pronavi.model.c cVar6 = new com.baidu.navisdk.module.pronavi.model.c();
            cVar6.b = 107;
            cVar6.c = 3;
            int i11 = (i3 * 5) + i4;
            cVar6.f = i11;
            cVar6.e = i11;
            cVar6.d = i11;
            cVar6.o = c(cVar6) + "测3";
            cVar6.p = b(cVar6);
            cVar6.f7463a = "12345678";
            cVar6.k = i2 + (-5);
            this.b.add(cVar6);
        }
    }
}
