package com.baidu.navisdk.pronavi.logic.service.roadcondition;

import OXOo.OOXIXo;
import android.os.Bundle;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.model.datastruct.m;
import com.baidu.navisdk.module.cloudconfig.f;
import com.baidu.navisdk.pronavi.data.model.g;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.oXIO0o0XI;

/* loaded from: classes7.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final g f7795a;
    private final com.baidu.navisdk.pronavi.logic.service.roadcondition.a b;

    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(IIXOooo iIXOooo) {
            this();
        }
    }

    static {
        new a(null);
    }

    public c(@OOXIXo g mModel, @OOXIXo com.baidu.navisdk.pronavi.logic.service.roadcondition.a mConfig) {
        IIX0o.x0xO0oo(mModel, "mModel");
        IIX0o.x0xO0oo(mConfig, "mConfig");
        this.f7795a = mModel;
        this.b = mConfig;
    }

    private final void b() {
        Bundle bundle = new Bundle();
        boolean roadConditionAndJamInfo = BNRouteGuider.getInstance().getRoadConditionAndJamInfo(bundle);
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGRoadConditionRepository", "getRoadConditionAndJamInfo1: " + roadConditionAndJamInfo + ", " + bundle);
        }
        List<? extends com.baidu.navisdk.module.pronavi.model.c> list = null;
        if (roadConditionAndJamInfo && !bundle.isEmpty()) {
            Bundle[] bundleArr = (Bundle[]) bundle.getParcelableArray("road_condition_array");
            Bundle[] bundleArr2 = (Bundle[]) bundle.getParcelableArray("bar_icon_array");
            if (!f.p0.f7130a) {
                if (gVar.d()) {
                    gVar.e("RGRoadConditionRepository", "getRoadConditionAndJamInfo 云端控制不展示拥堵标签");
                }
                bundleArr2 = null;
            }
            if (bundleArr != null && bundleArr.length != 0) {
                ArrayList arrayList = new ArrayList(bundleArr.length);
                int i = 0;
                for (Bundle bundle2 : bundleArr) {
                    m b = b(bundle2);
                    if (b != null && b.c > 0) {
                        arrayList.add(b);
                        i = b.c;
                    }
                    com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
                    if (gVar2.d()) {
                        gVar2.e("RGRoadConditionRepository", "getRoadCondition: " + b);
                    }
                }
                if (bundleArr2 != null) {
                    ArrayList arrayList2 = new ArrayList(bundleArr2.length);
                    int i2 = bundle.getInt("jamVersion", -1);
                    String string = bundle.getString("routeMD5", null);
                    boolean a2 = this.b.a();
                    com.baidu.navisdk.util.common.g gVar3 = com.baidu.navisdk.util.common.g.PRO_NAV;
                    if (gVar3.d()) {
                        gVar3.e("RGRoadConditionRepository", "getRoadConditionAndJamInfo: isSupportAvoid " + a2);
                    }
                    for (Bundle bundle3 : bundleArr2) {
                        com.baidu.navisdk.module.pronavi.model.c a3 = a(bundle3);
                        com.baidu.navisdk.util.common.g gVar4 = com.baidu.navisdk.util.common.g.PRO_NAV;
                        if (gVar4.d()) {
                            gVar4.e("RGRoadConditionRepository", "getRoadConditionJam: " + a3);
                        }
                        if (a3 != null && a3.c() && a3.e <= i) {
                            if (!a2) {
                                a3.n = false;
                            }
                            a3.i = i2;
                            a3.j = string;
                            b bVar = b.f7794a;
                            a3.o = bVar.b(a3);
                            a3.p = bVar.a(a3);
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
                            arrayList2.add(a3);
                        } else if (gVar4.d()) {
                            gVar4.e("RGRoadConditionRepository", "getRoadConditionJam: jammode 无效");
                        }
                    }
                    list = arrayList2;
                }
                a(arrayList, list);
                return;
            }
            a(null, null);
            return;
        }
        a(null, null);
    }

    public final void a() {
        b();
    }

    private final synchronized void a(List<? extends m> list, List<? extends com.baidu.navisdk.module.pronavi.model.c> list2) {
        try {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGRoadConditionRepository", "handlerLoadDone roadList= " + list + " ; jamList = " + list2 + TokenParser.SP);
            }
            synchronized (this) {
                this.f7795a.a(list);
                this.f7795a.b(list2);
                oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private final com.baidu.navisdk.module.pronavi.model.c a(Bundle bundle) {
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

    private final m b(Bundle bundle) {
        if (!bundle.containsKey("unEndShapeIdx") || !bundle.containsKey("enRoadCondition")) {
            return null;
        }
        m mVar = new m();
        mVar.f6935a = bundle.getInt("unEndShapeIdx", -1);
        mVar.c = bundle.getInt("unEndAddDist");
        mVar.d = bundle.getInt("unEndTravelTime");
        int i = bundle.getInt("enRoadCondition");
        if (i < 0 || i > 4) {
            i = 0;
        }
        mVar.b = i;
        return mVar;
    }
}
