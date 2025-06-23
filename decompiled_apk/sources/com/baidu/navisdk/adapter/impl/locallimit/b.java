package com.baidu.navisdk.adapter.impl.locallimit;

import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.entity.pb.Cars;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.worker.g;
import com.baidu.nplatform.comapi.map.j;
import com.baidu.platform.comapi.map.LocalLimitMapOverlay;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public abstract class b implements com.baidu.navisdk.adapter.impl.locallimit.a {

    /* renamed from: a, reason: collision with root package name */
    private LocalLimitMapOverlay f6513a;
    private final d b;
    private final Object c = new Object();
    com.baidu.navisdk.util.worker.f d = new C0162b("CarNavi-autoHideLocalLimit", null);

    /* loaded from: classes7.dex */
    public class a extends com.baidu.navisdk.util.worker.f<String, String> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f6514a;
        final /* synthetic */ int b;
        final /* synthetic */ String c;
        final /* synthetic */ String d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, String str2, int i, int i2, String str3, String str4) {
            super(str, str2);
            this.f6514a = i;
            this.b = i2;
            this.c = str3;
            this.d = str4;
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            b.this.b(this.f6514a, this.b, this.c, this.d);
            return null;
        }
    }

    /* renamed from: com.baidu.navisdk.adapter.impl.locallimit.b$b, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0162b extends com.baidu.navisdk.util.worker.f<String, String> {
        public C0162b(String str, String str2) {
            super(str, str2);
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            LogUtil.e(g.TAG, "mAutoHideTask start");
            b.this.b();
            return null;
        }
    }

    public b(d dVar) {
        this.b = dVar;
    }

    private void b(int i) {
        List<String> list;
        List<String> list2;
        if (com.baidu.navisdk.pbprocess.a.a() == null) {
            LogUtil.e("NavBaseLocalLimitController", "requestLayerData getCars is null");
            return;
        }
        if (this.b.b[0] != null) {
            int selectRouteIdx = JNIGuidanceControl.getInstance().getSelectRouteIdx();
            f fVar = this.b.b[selectRouteIdx >= 0 ? selectRouteIdx : 0];
            if (fVar == null || (((list = fVar.b) == null || list.size() == 0) && ((list2 = fVar.f6528a) == null || list2.size() == 0))) {
                LogUtil.e("NavBaseLocalLimitController", "requestLayerData hit avoid is null");
                return;
            }
        }
        a(i, -1, "0");
    }

    private void c(int i, int i2, String str, String str2) {
        e eVar = new e();
        if (TextUtils.isEmpty(str2)) {
            LogUtil.e("NavBaseLocalLimitController", "requestLayerData interveneId is empty");
            return;
        }
        int selectRouteIdx = JNIGuidanceControl.getInstance().getSelectRouteIdx();
        if (selectRouteIdx < 0) {
            selectRouteIdx = 0;
        }
        f fVar = new f();
        ArrayList arrayList = new ArrayList();
        arrayList.add(str2);
        fVar.c = this.b.a(arrayList);
        eVar.c = fVar;
        eVar.b = i;
        eVar.f6527a = selectRouteIdx;
        com.baidu.navisdk.framework.message.a.a().a(eVar);
    }

    @Override // com.baidu.navisdk.adapter.impl.locallimit.a
    public void a(int i) {
        LogUtil.e("NavBaseLocalLimitController", "clearLayerData type:" + i);
        if (i != 0 && i != 1) {
            if (i == 2) {
                this.b.a();
                return;
            } else if (i != 3) {
                if (i != 4) {
                    return;
                }
                this.b.b();
                return;
            }
        }
        this.b.c();
    }

    public void a(e eVar) {
        f fVar;
        LogUtil.e("NavBaseLocalLimitController", "handleEvent");
        if (eVar.b == 3) {
            fVar = eVar.c;
        } else {
            fVar = this.b.b[eVar.f6527a];
        }
        if (fVar == null) {
            LogUtil.e("NavBaseLocalLimitController", "handleEvent fail 1");
            return;
        }
        if (fVar != eVar.c) {
            LogUtil.e("NavBaseLocalLimitController", "handleEvent fail 2");
        }
        com.baidu.navisdk.adapter.impl.locallimit.bean.c cVar = fVar.c;
        if (cVar != null && cVar.d.size() > 0) {
            a(eVar.b, fVar.c.d);
        } else {
            LogUtil.e("NavBaseLocalLimitController", "handleEvent fail 3");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, String str, String str2) {
        int i3;
        List<String> list;
        List<com.baidu.navisdk.adapter.impl.locallimit.bean.b> i4;
        e eVar = new e();
        if (i == 0) {
            if (com.baidu.navisdk.pbprocess.a.a() == null) {
                LogUtil.e("NavBaseLocalLimitController", "requestLayerData getCars is null");
                return;
            }
            if (this.b.b[0] == null) {
                a(com.baidu.navisdk.pbprocess.a.a());
            }
            int selectRouteIdx = JNIGuidanceControl.getInstance().getSelectRouteIdx();
            i3 = selectRouteIdx >= 0 ? selectRouteIdx : 0;
            f fVar = this.b.b[i3];
            if (fVar == null) {
                LogUtil.e("NavBaseLocalLimitController", "requestLayerData, item is null,idx:" + i3);
                return;
            }
            List<String> list2 = fVar.b;
            if ((list2 != null && list2.size() != 0) || ((list = fVar.f6528a) != null && list.size() != 0)) {
                if (fVar.c == null) {
                    if (fVar.a()) {
                        fVar.c = this.b.a(fVar.b);
                    } else {
                        fVar.c = this.b.a(fVar.f6528a);
                    }
                } else {
                    LogUtil.e("NavBaseLocalLimitController", "requestLayerData has mFirstHitCarRules");
                }
                eVar.c = fVar;
                eVar.b = i;
                eVar.f6527a = i3;
                a(eVar);
                return;
            }
            LogUtil.e("NavBaseLocalLimitController", "requestLayerData hit avoid is null");
            return;
        }
        if (i == 1) {
            if (com.baidu.navisdk.pbprocess.a.a() == null) {
                LogUtil.e("NavBaseLocalLimitController", "requestLayerData getCars is null");
                return;
            }
            if (this.b.b[0] == null) {
                a(com.baidu.navisdk.pbprocess.a.a());
            }
            int selectRouteIdx2 = JNIGuidanceControl.getInstance().getSelectRouteIdx();
            i3 = selectRouteIdx2 >= 0 ? selectRouteIdx2 : 0;
            d dVar = this.b;
            f fVar2 = dVar.b[i3];
            if (i2 == 0) {
                fVar2.d = dVar.a(fVar2.b, fVar2.f6528a, i3);
            } else if (1 == i2) {
                com.baidu.navisdk.adapter.impl.locallimit.bean.c a2 = dVar.a(str, i3);
                if (!a2.d.isEmpty()) {
                    fVar2.e.put(str, a2);
                }
            }
            eVar.b = i;
            eVar.f6527a = i3;
            com.baidu.navisdk.framework.message.a.a().a(eVar);
            return;
        }
        if (i == 2) {
            if (i2 == 0) {
                if (this.b.c.size() == 0 && (i4 = this.b.i()) != null) {
                    this.b.c.addAll(i4);
                }
            } else if (1 == i2) {
                String f = this.b.f();
                if (this.b.h() != null && !f.equals(this.b.h())) {
                    this.b.d.clear();
                }
                this.b.d(f);
                com.baidu.navisdk.adapter.impl.locallimit.bean.c cVar = this.b.d.get(str);
                if (cVar == null || cVar.d.size() == 0) {
                    this.b.d.put(str, this.b.a(str));
                }
            }
            eVar.b = i;
            com.baidu.navisdk.framework.message.a.a().a(eVar);
            return;
        }
        if (i == 3) {
            c(i, i2, str, str2);
            return;
        }
        if (i != 4) {
            return;
        }
        d dVar2 = this.b;
        com.baidu.navisdk.adapter.impl.locallimit.bean.a aVar = dVar2.f6522a;
        if (i2 == 0) {
            List<com.baidu.navisdk.adapter.impl.locallimit.bean.e> c = dVar2.c(str2);
            aVar.b = c;
            if (c.isEmpty() && LogUtil.LOGGABLE) {
                LogUtil.e("NavBaseLocalLimitController", "PAGE_CUSTOM cityList is null");
            }
        } else {
            com.baidu.navisdk.adapter.impl.locallimit.bean.c b = dVar2.b(str);
            if (!b.d.isEmpty()) {
                aVar.c.put(str, b);
            }
        }
        eVar.b = i;
        com.baidu.navisdk.framework.message.a.a().a(eVar);
    }

    private void a(Cars cars) {
        if (cars != null && cars.hasContent()) {
            d dVar = this.b;
            dVar.c();
            List<String> avoidCarRulesList = cars.getContent().getAvoidCarRulesList();
            int routesCount = cars.getContent().getRoutesCount();
            for (int i = 0; i < routesCount; i++) {
                f fVar = new f();
                fVar.b = cars.getContent().getRoutes(i).getHitCarRulesList();
                fVar.f6528a = avoidCarRulesList;
                dVar.b[i] = fVar;
                LogUtil.e("NavBaseLocalLimitController", "mHitCarRuleIds:" + fVar.b.size());
                LogUtil.e("NavBaseLocalLimitController", "mAvoidCarRuleIds:" + fVar.f6528a.size());
            }
        }
    }

    @Override // com.baidu.navisdk.adapter.impl.locallimit.a
    public void a() {
        b(0);
    }

    public void a(int i, int i2, String str) {
        a(i, i2, str, "");
    }

    public void a(int i, int i2, String str, String str2) {
        LogUtil.e("NavBaseLocalLimitController", "requestLayerData type:" + i);
        com.baidu.navisdk.util.worker.c.a().c(new a("NavLocalLimitController", null, i, i2, str, str2), new com.baidu.navisdk.util.worker.e(99, 0));
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x00f1, code lost:
    
        if (r18 != 4) goto L38;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean a(int r18, java.util.List<com.baidu.navisdk.adapter.impl.locallimit.bean.d> r19) {
        /*
            Method dump skipped, instructions count: 298
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.adapter.impl.locallimit.b.a(int, java.util.List):boolean");
    }

    @Override // com.baidu.navisdk.adapter.impl.locallimit.a
    public void b() {
        com.baidu.navisdk.util.worker.c.a().a((g) this.d, false);
        if (this.f6513a == null) {
            return;
        }
        LogUtil.e("NavBaseLocalLimitController", "clearLayer");
        synchronized (this.c) {
            try {
                LocalLimitMapOverlay localLimitMapOverlay = this.f6513a;
                if (localLimitMapOverlay != null) {
                    localLimitMapOverlay.setRouteExtData(new byte[]{0});
                    this.f6513a.clear();
                    this.f6513a.UpdateOverlay();
                    this.f6513a = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void a(long j, long j2, long j3, long j4) {
        long j5 = j / 100;
        long j6 = j2 / 100;
        long j7 = j3 / 100;
        long j8 = j4 / 100;
        Bundle bundle = new Bundle();
        bundle.putLong("left", j5);
        bundle.putLong("right", j7);
        bundle.putLong("top", j6);
        bundle.putLong("bottom", j8);
        Rect rect = new Rect(0, ScreenUtil.getInstance().getHeightPixels(), ScreenUtil.getInstance().getWidthPixels(), ScreenUtil.getInstance().dip2px(300));
        float GetZoomToBound = BNMapController.getInstance().GetZoomToBound(bundle, rect.right - rect.left, rect.top - rect.bottom) - 0.35f;
        float f = (float) ((j5 + j7) / 2);
        float f2 = (float) ((j6 + j8) / 2);
        float heightPixels = ((rect.top + rect.bottom) - ScreenUtil.getInstance().getHeightPixels()) / 2;
        float widthPixels = ((rect.right + rect.left) - ScreenUtil.getInstance().getWidthPixels()) / 2;
        com.baidu.nplatform.comapi.basestruct.b mapStatus = BNMapController.getInstance().getMapStatus();
        if (mapStatus == null) {
            LogUtil.e("NavBaseLocalLimitController", "updateMapView fail st is null");
            return;
        }
        mapStatus.j = heightPixels;
        mapStatus.i = widthPixels;
        mapStatus.d = (int) f;
        mapStatus.e = (int) f2;
        mapStatus.f9474a = GetZoomToBound;
        mapStatus.b = 0.0f;
        mapStatus.c = 0;
        BNMapController.getInstance().setMapStatus(mapStatus, j.b.eAnimationAll, 300);
    }
}
