package com.baidu.navisdk.ui.routeguide.model;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.iflytek.sparkchain.utils.constants.ErrorCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class d {
    public static boolean f = false;

    /* renamed from: a, reason: collision with root package name */
    private HashMap<String, String> f8934a;
    private final HashSet<String> b;
    private com.baidu.navisdk.model.datastruct.chargestation.e c;
    private final MutableLiveData<com.baidu.navisdk.pronavi.newenergy.logic.data.a> d;
    private final com.baidu.navisdk.module.userclassification.e e;

    /* loaded from: classes8.dex */
    public class b extends com.baidu.navisdk.util.worker.lite.b {
        public b(String str) {
            super(str);
        }

        @Override // com.baidu.navisdk.util.worker.lite.b, java.lang.Runnable
        public void run() {
            d dVar = d.this;
            dVar.c = dVar.h();
            int addDist = BNRouteGuider.getInstance().getAddDist();
            if (d.f) {
                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
                if (gVar.d() && gVar.c()) {
                    gVar.e(com.baidu.navisdk.util.worker.g.TAG, "requestCsInfoData: use test data");
                    d.this.d.postValue(d.this.f());
                    return;
                }
            }
            d dVar2 = d.this;
            d.this.d.postValue(dVar2.a(addDist, dVar2.c));
        }
    }

    /* loaded from: classes8.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        private static final d f8937a = new d(null);
    }

    public /* synthetic */ d(a aVar) {
        this();
    }

    private int b(int i) {
        if (i == 1) {
            return 1;
        }
        if (i == 2) {
            return 5;
        }
        if (i == 3) {
            return 4;
        }
        return i == 4 ? 3 : 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.navisdk.pronavi.newenergy.logic.data.a f() {
        if (com.baidu.navisdk.util.common.g.PRO_NAV.d()) {
            com.baidu.navisdk.pronavi.newenergy.logic.data.a aVar = new com.baidu.navisdk.pronavi.newenergy.logic.data.a();
            int nextInt = new Random().nextInt(7);
            aVar.g(nextInt);
            if (nextInt != 1) {
                if (nextInt != 2) {
                    if (nextInt != 3) {
                        if (nextInt != 4) {
                            if (nextInt == 5) {
                                aVar.d(20);
                                aVar.c(0);
                                aVar.a(14);
                                aVar.b(450);
                            }
                        } else {
                            aVar.f(7);
                            aVar.e(5);
                            aVar.b(233000);
                        }
                    } else {
                        aVar.b(ErrorCode.MSP_ERROR_ISV_NO_USER);
                    }
                } else {
                    aVar.a(23);
                    aVar.b(ErrorCode.MSP_ERROR_HTTP_BASE);
                }
            } else {
                aVar.d(10);
                aVar.c(8);
                aVar.f(7);
                aVar.e(7);
                aVar.a(23);
                aVar.b(11000);
            }
            return aVar;
        }
        return null;
    }

    public static d g() {
        return c.f8937a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.navisdk.model.datastruct.chargestation.e h() {
        int selectRouteIdx = JNIGuidanceControl.getInstance().getSelectRouteIdx();
        ArrayList<Bundle> arrayList = new ArrayList<>();
        ArrayList<Bundle> arrayList2 = new ArrayList<>();
        Bundle bundle = new Bundle();
        BNRoutePlaner.getInstance().a(selectRouteIdx, arrayList, bundle, 2);
        BNRoutePlaner.getInstance().a(selectRouteIdx, arrayList2);
        return com.baidu.navisdk.model.datastruct.chargestation.e.l.a(arrayList, arrayList2, bundle, null);
    }

    public void e() {
        com.baidu.navisdk.module.userclassification.f.a().b(this.e);
        HashMap<String, String> hashMap = this.f8934a;
        if (hashMap != null) {
            hashMap.clear();
            this.f8934a = null;
        }
        this.b.clear();
    }

    /* loaded from: classes8.dex */
    public class a implements com.baidu.navisdk.module.userclassification.e {
        public a() {
        }

        @Override // com.baidu.navisdk.module.userclassification.e
        public Set<String> a() {
            HashSet hashSet = new HashSet();
            hashSet.add("new_eng_charge_station_config_info");
            return hashSet;
        }

        @Override // com.baidu.navisdk.module.userclassification.e
        public void a(@NonNull Map<String, JSONObject> map, boolean z, long j) {
            d.this.a(map.get("new_eng_charge_station_config_info"));
        }
    }

    private d() {
        this.b = new HashSet<>();
        this.d = new MutableLiveData<>();
        this.e = new a();
    }

    public void c() {
        com.baidu.navisdk.module.userclassification.f.a().a(this.e);
        this.b.clear();
    }

    public void d() {
        com.baidu.navisdk.util.worker.lite.a.b(new b("updateByAddDist"), 10002);
    }

    public boolean b(String str) {
        return this.b.contains(str);
    }

    public static com.baidu.navisdk.model.datastruct.chargestation.b c(String str) {
        Bundle a2 = BNRoutePlaner.getInstance().a(JNIGuidanceControl.getInstance().getSelectRouteIdx(), str);
        com.baidu.navisdk.model.datastruct.chargestation.b a3 = com.baidu.navisdk.model.datastruct.chargestation.b.B.a(a2);
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGChargeStationModel", "getChargeStationFromEngine --> data = " + a2 + ", info = " + a3);
        }
        return a3;
    }

    public com.baidu.navisdk.model.datastruct.chargestation.e b() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            JSONObject optJSONObject = jSONObject.optJSONObject(next);
            if (optJSONObject != null) {
                hashMap.put(next, optJSONObject.optString("icon_url", ""));
            }
        }
        this.f8934a = new HashMap<>(hashMap);
    }

    public String a(int i) {
        HashMap<String, String> hashMap = this.f8934a;
        return hashMap == null ? "" : hashMap.get(String.valueOf(i));
    }

    public void a(String str) {
        this.b.add(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.navisdk.pronavi.newenergy.logic.data.a a(int i, com.baidu.navisdk.model.datastruct.chargestation.e eVar) {
        int b2;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGChargeStationModel", "obtainNearestCsTipData --> carAddDist = " + i + ", isRecommendCharge = " + eVar.e());
        }
        ArrayList<Object> c2 = eVar.c();
        com.baidu.navisdk.pronavi.newenergy.logic.data.a aVar = new com.baidu.navisdk.pronavi.newenergy.logic.data.a();
        if (!eVar.e()) {
            Iterator<Object> it = c2.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                Object next = it.next();
                com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
                if (gVar2.d()) {
                    gVar2.e("RGChargeStationModel", "obtainNearestCsTipData --> 第" + i2 + "个: oriObject = " + next);
                }
                i2++;
                if (next instanceof com.baidu.navisdk.model.datastruct.chargestation.b) {
                    com.baidu.navisdk.model.datastruct.chargestation.b bVar = (com.baidu.navisdk.model.datastruct.chargestation.b) next;
                    if (i <= bVar.a() && (bVar.q() || bVar.k() == 4)) {
                        if (bVar.q()) {
                            aVar.g(2);
                        } else {
                            aVar.g(b(bVar.k()));
                        }
                        com.baidu.navisdk.model.datastruct.chargestation.c a2 = eVar.a(bVar.p());
                        b2 = a2 != null ? a2.b() : 0;
                        aVar.b(bVar.a() - i);
                        aVar.a(b2);
                        aVar.d(bVar.d().c());
                        aVar.c(bVar.d().b());
                        aVar.f(bVar.d().g());
                        aVar.e(bVar.d().f());
                        aVar.a(bVar.j());
                        aVar.b(bVar.p());
                        return aVar;
                    }
                }
            }
            return aVar;
        }
        Iterator<Object> it2 = c2.iterator();
        int i3 = 0;
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Object next2 = it2.next();
            com.baidu.navisdk.util.common.g gVar3 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar3.d()) {
                gVar3.e("RGChargeStationModel", "obtainNearestCsTipData --> 第" + i3 + "个: oriObject = " + next2);
            }
            i3++;
            if (next2 instanceof com.baidu.navisdk.model.datastruct.chargestation.b) {
                com.baidu.navisdk.model.datastruct.chargestation.b bVar2 = (com.baidu.navisdk.model.datastruct.chargestation.b) next2;
                if (i <= bVar2.a() && bVar2.r()) {
                    if (bVar2.q()) {
                        aVar.g(2);
                    } else {
                        aVar.g(b(bVar2.k()));
                    }
                    com.baidu.navisdk.model.datastruct.chargestation.c a3 = eVar.a(bVar2.p());
                    b2 = a3 != null ? a3.b() : 0;
                    aVar.b(bVar2.a() - i);
                    aVar.a(b2);
                    aVar.d(bVar2.d().c());
                    aVar.c(bVar2.d().b());
                    aVar.f(bVar2.d().g());
                    aVar.e(bVar2.d().f());
                    aVar.a(bVar2.j());
                    aVar.b(bVar2.p());
                }
            } else if (next2 instanceof com.baidu.navisdk.model.datastruct.chargestation.a) {
                com.baidu.navisdk.model.datastruct.chargestation.a aVar2 = (com.baidu.navisdk.model.datastruct.chargestation.a) next2;
                if (aVar2.f() == 2) {
                    if (i <= aVar2.d()) {
                        break;
                    }
                    if (i <= aVar2.b()) {
                        aVar.b(aVar2.g());
                        aVar.g(6);
                        break;
                    }
                } else {
                    continue;
                }
            } else {
                continue;
            }
        }
        com.baidu.navisdk.util.common.g gVar4 = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar4.d()) {
            gVar4.e("RGChargeStationModel", "obtainNearestCsTipData --> tipData = " + aVar);
        }
        return aVar;
    }

    public MutableLiveData<com.baidu.navisdk.pronavi.newenergy.logic.data.a> a() {
        return this.d;
    }
}
