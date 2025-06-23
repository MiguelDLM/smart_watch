package com.baidu.navisdk.adapter.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.baidunavis.baseline.BNOuterMapViewManager;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.InfoWindow;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.baidu.navisdk.adapter.BNRoutePlanNode;
import com.baidu.navisdk.adapter.IBNRouteResultManager;
import com.baidu.navisdk.adapter.struct.BNSearchPoi;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.mapcontrol.BNMapObserver;
import com.baidu.navisdk.comapi.mapcontrol.NavMapManager;
import com.baidu.navisdk.comapi.mapcontrol.NavMapModeManager;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.framework.interfaces.k;
import com.baidu.navisdk.model.datastruct.s;
import com.baidu.navisdk.ui.routeguide.control.l;
import com.baidu.navisdk.ui.routeguide.control.r;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.l0;
import com.baidu.navisdk.util.common.o;
import com.baidu.navisdk.util.common.z;
import com.baidu.navisdk.util.logic.j;
import com.baidu.nplatform.comapi.MapItem;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comjni.engine.NAEngine;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes7.dex */
public final class BNRouteResultManager implements IBNRouteResultManager {
    private static BNRouteResultManager p;

    /* renamed from: a, reason: collision with root package name */
    private Context f6472a;
    private com.baidu.navisdk.comapi.routeplan.v2.a d;
    private com.baidu.navisdk.adapter.impl.longdistance.a e;
    private com.baidu.navisdk.yellowbannerui.controller.b f;
    private com.baidu.navisdk.yellowbannerui.c g;
    private com.baidu.navisdk.yellowbannerui.interfaces.b h;
    private IBNRouteResultManager.PoiSearchListener o;
    private int b = 0;
    private boolean c = false;
    private IBNRouteResultManager.ICalcRouteByViaListener i = null;
    private IBNRouteResultManager.IRouteClickedListener j = null;
    private IBNRouteResultManager.IThroughNodeClickedListener k = null;
    private final BNMapObserver l = new a();
    private final com.baidu.navisdk.comapi.geolocate.b m = new c();
    private final BroadcastReceiver n = new BroadcastReceiver() { // from class: com.baidu.navisdk.adapter.impl.BNRouteResultManager.4
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            LogUtil.e("BNRouteResultManager", "network changed.");
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction()) && BNRouteResultManager.this.f != null) {
                if (z.b(BNRouteResultManager.this.f6472a)) {
                    BNRouteResultManager.this.f.b(2);
                } else {
                    BNRouteResultManager.this.f.a(2, "网络异常，请检查网络设置", BNRouteResultManager.this.b);
                }
            }
        }
    };

    /* loaded from: classes7.dex */
    public class a implements BNMapObserver {

        /* renamed from: com.baidu.navisdk.adapter.impl.BNRouteResultManager$a$a, reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0154a implements com.baidu.navisdk.poisearch.d {

            /* renamed from: com.baidu.navisdk.adapter.impl.BNRouteResultManager$a$a$a, reason: collision with other inner class name */
            /* loaded from: classes7.dex */
            public class C0155a extends com.baidu.navisdk.util.worker.f<String, String> {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ s f6476a;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C0155a(String str, String str2, s sVar) {
                    super(str, str2);
                    this.f6476a = sVar;
                }

                @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
                public String execute() {
                    BNRouteResultManager.this.a(this.f6476a);
                    return null;
                }
            }

            public C0154a() {
            }

            @Override // com.baidu.navisdk.poisearch.d
            public void a(int i, s sVar, boolean z) {
                LogUtil.out("BNRouteResultManager", "handleBkgClick");
                com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.f) new C0155a("handleRoutePlanMessage-BNRouteResultManager", null, sVar), new com.baidu.navisdk.util.worker.e(1, 0));
            }
        }

        public a() {
        }

        @Override // com.baidu.navisdk.comapi.base.b
        public void update(com.baidu.navisdk.comapi.base.c cVar, int i, int i2, Object obj) {
            if (1 == i) {
                if (i2 != 265) {
                    if (i2 != 514) {
                        if (i2 == 517) {
                            LogUtil.out("BNRouteResultManager", "update: TYPE_MAP_VIEW --> EVENT_CLICKED_THROUGH_NODE_LAYER");
                            if (BNRouteResultManager.this.k != null) {
                                Bundle bundle = (Bundle) obj;
                                if (bundle.getSerializable("item") != null) {
                                    MapItem mapItem = (MapItem) bundle.getSerializable("item");
                                    LatLng Coordinate_encryptEx = CoordUtil.Coordinate_encryptEx((float) mapItem.mLongitudeMc, (float) mapItem.mLatitudeMc, "bd09mc");
                                    int i3 = mapItem.mItemID - 1;
                                    String name = com.baidu.navisdk.module.nearbysearch.model.b.INSTANCE.e().get(i3).getName();
                                    BNRoutePlanNode build = new BNRoutePlanNode.Builder().latitude(Coordinate_encryptEx.latitude).longitude(Coordinate_encryptEx.longitude).name(name).build();
                                    if (SDKInitializer.getCoordType().equals(CoordType.GCJ02)) {
                                        LatLng baiduToGcj = CoordTrans.baiduToGcj(Coordinate_encryptEx);
                                        build = new BNRoutePlanNode.Builder().latitude(baiduToGcj.latitude).longitude(baiduToGcj.longitude).name(name).build();
                                    }
                                    BNRouteResultManager.this.k.onThroughNodeClicked(i3, build);
                                    return;
                                }
                                return;
                            }
                            if (BNRouteResultManager.this.e != null) {
                                BNRouteResultManager.this.e.a((Bundle) obj);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    MapItem mapItem2 = (MapItem) obj;
                    LogUtil.out("BNRouteResultManager", "EVENT_CLICKED_ROUTE item= " + mapItem2.mItemID);
                    if (BNRouteResultManager.this.j != null) {
                        BNRouteResultManager.this.j.routeClicked(mapItem2.mItemID);
                    }
                    BNRouteResultManager.this.a(mapItem2.mItemID);
                    return;
                }
                LogUtil.out("BNRouteResultManager", "update: TYPE_MAP_VIEW --> EVENT_CLICKED_POI_BKG_LAYER");
                com.baidu.navisdk.poisearch.b.a((MapItem) obj, new C0154a());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ s f6477a;

        public b(s sVar) {
            this.f6477a = sVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BNRouteResultManager.this.b(this.f6477a);
            BNOuterMapViewManager.getInstance().hideInfoWindow();
        }
    }

    /* loaded from: classes7.dex */
    public class c implements com.baidu.navisdk.comapi.geolocate.b {
        public c() {
        }

        @Override // com.baidu.navisdk.comapi.geolocate.b
        public void onGpsStatusChange(boolean z, boolean z2) {
        }

        @Override // com.baidu.navisdk.comapi.geolocate.b
        public void onLocationChange(com.baidu.navisdk.model.datastruct.g gVar) {
            BNRouteResultManager.this.a(gVar);
        }

        @Override // com.baidu.navisdk.comapi.geolocate.b
        public void onWGS84LocationChange(com.baidu.navisdk.model.datastruct.g gVar, com.baidu.navisdk.model.datastruct.g gVar2) {
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BNRouteResultManager.this.fullView();
        }
    }

    /* loaded from: classes7.dex */
    public class e implements com.baidu.navisdk.yellowbannerui.interfaces.a {
        public e(BNRouteResultManager bNRouteResultManager) {
        }

        @Override // com.baidu.navisdk.yellowbannerui.interfaces.a
        public void a(boolean z) {
        }

        @Override // com.baidu.navisdk.yellowbannerui.interfaces.a
        public int b() {
            return BNSettingManager.getPreferenceLocalCountTime();
        }

        @Override // com.baidu.navisdk.yellowbannerui.interfaces.a
        public boolean c() {
            return false;
        }

        @Override // com.baidu.navisdk.yellowbannerui.interfaces.a
        public String d() {
            return com.baidu.navisdk.h.a();
        }

        @Override // com.baidu.navisdk.yellowbannerui.interfaces.a
        public long e() {
            return BNSettingManager.getICBCCommercializeYellowBannerTime();
        }

        @Override // com.baidu.navisdk.yellowbannerui.interfaces.a
        public int f() {
            return 1;
        }

        @Override // com.baidu.navisdk.yellowbannerui.interfaces.a
        public boolean a(int i, String str) {
            return BNSettingManager.saveLocalPreferenceLocal(i, str);
        }

        @Override // com.baidu.navisdk.yellowbannerui.interfaces.a
        public void d(boolean z) {
            com.baidu.navisdk.module.routepreference.d.j().b(z);
        }

        @Override // com.baidu.navisdk.yellowbannerui.interfaces.a
        public String a() {
            return BNSettingManager.getPreferenceLocalSubTitle();
        }

        @Override // com.baidu.navisdk.yellowbannerui.interfaces.a
        public void a(long j) {
            BNSettingManager.setICBCCommercializeYellowBannerTime(j);
        }
    }

    /* loaded from: classes7.dex */
    public class f extends com.baidu.navisdk.comapi.routeplan.v2.a {

        /* loaded from: classes7.dex */
        public class a extends com.baidu.navisdk.util.worker.f<String, String> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f6481a;
            final /* synthetic */ int b;
            final /* synthetic */ com.baidu.navisdk.comapi.routeplan.v2.d c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String str, String str2, int i, int i2, com.baidu.navisdk.comapi.routeplan.v2.d dVar) {
                super(str, str2);
                this.f6481a = i;
                this.b = i2;
                this.c = dVar;
            }

            @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
            public String execute() {
                BNRouteResultManager.this.a(this.f6481a, this.b, this.c);
                return null;
            }
        }

        public f() {
        }

        @Override // com.baidu.navisdk.comapi.routeplan.v2.a
        public String getName() {
            return "BNRouteResultManager-BNRoutePlanListenerV2: " + hashCode();
        }

        @Override // com.baidu.navisdk.comapi.routeplan.v2.a
        public boolean isPersist() {
            return true;
        }

        @Override // com.baidu.navisdk.comapi.routeplan.v2.a
        public void onRoutePlan(int i, int i2, com.baidu.navisdk.comapi.routeplan.v2.d dVar, Bundle bundle) {
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                BNRouteResultManager.this.a(i, i2, dVar);
            } else {
                com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.f) new a("handleRoutePlanMessage-BNRouteResultManager", null, i, i2, dVar), new com.baidu.navisdk.util.worker.e(1, 0));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g extends com.baidu.navisdk.yellowbannerui.a {
        public g(BNRouteResultManager bNRouteResultManager) {
        }

        @Override // com.baidu.navisdk.yellowbannerui.a, com.baidu.navisdk.yellowbannerui.interfaces.b
        public void a(int i, com.baidu.navisdk.yellowtipdata.model.data.d dVar) {
            super.a(i, dVar);
        }

        @Override // com.baidu.navisdk.yellowbannerui.a, com.baidu.navisdk.yellowbannerui.interfaces.b
        public void b(int i, com.baidu.navisdk.yellowtipdata.model.data.d dVar) {
            super.b(i, dVar);
        }

        @Override // com.baidu.navisdk.yellowbannerui.a
        public String n() {
            return "BNRouteResultManager";
        }
    }

    /* loaded from: classes7.dex */
    public class h implements k.a {
        public h() {
        }

        @Override // com.baidu.navisdk.framework.interfaces.k.a
        public void a(ArrayList<s> arrayList) {
            if (arrayList != null && arrayList.size() != 0) {
                ArrayList arrayList2 = new ArrayList();
                Iterator<s> it = arrayList.iterator();
                while (it.hasNext()) {
                    s next = it.next();
                    BNSearchPoi bNSearchPoi = new BNSearchPoi();
                    bNSearchPoi.mAddress = next.g;
                    bNSearchPoi.mDistrictId = next.l;
                    bNSearchPoi.mGuidePoint = next.j;
                    bNSearchPoi.mName = next.e;
                    bNSearchPoi.mUid = next.p;
                    bNSearchPoi.mPhone = next.i;
                    bNSearchPoi.mPoiTag = next.t;
                    bNSearchPoi.mRouteCost = next.u;
                    arrayList2.add(bNSearchPoi);
                }
                if (BNRouteResultManager.this.o != null) {
                    BNRouteResultManager.this.fullView();
                    BNRouteResultManager.this.o.onSuccess(arrayList2);
                    return;
                }
                return;
            }
            if (BNRouteResultManager.this.o != null) {
                BNRouteResultManager.this.fullView();
                BNRouteResultManager.this.o.onFailed();
            }
        }

        @Override // com.baidu.navisdk.framework.interfaces.k.a
        public void onSearchExit() {
            if (BNRouteResultManager.this.o != null) {
                BNRouteResultManager.this.o.onStart();
            }
        }

        @Override // com.baidu.navisdk.framework.interfaces.k.a
        public void onSearchFailed() {
            if (BNRouteResultManager.this.o != null) {
                BNRouteResultManager.this.o.onFailed();
            }
        }
    }

    private void h() {
        if (this.g == null) {
            return;
        }
        com.baidu.navisdk.yellowtipdata.model.b bVar = new com.baidu.navisdk.yellowtipdata.model.b();
        bVar.a(com.baidu.navisdk.pbprocess.a.b(), com.baidu.navisdk.pbprocess.a.c());
        this.g.a(bVar.b(), isLongDistance(), false);
    }

    private void i() {
        if (this.d == null) {
            this.d = new f();
        }
        BNRoutePlaner.getInstance().a(this.d);
    }

    @Override // com.baidu.navisdk.adapter.IBNRouteResultManager
    public void addYellowTipsToContainer(ViewGroup viewGroup) {
        com.baidu.navisdk.yellowbannerui.controller.b bVar;
        if (viewGroup != null && (bVar = this.f) != null) {
            ViewGroup c2 = bVar.c();
            if (c2 != null && c2.getParent() != null) {
                ((ViewGroup) c2.getParent()).removeAllViews();
            }
            viewGroup.addView(c2);
        }
    }

    @Override // com.baidu.navisdk.adapter.IBNRouteResultManager
    public void fullView() {
        Rect a2 = com.baidu.navisdk.adapter.impl.b.d().a();
        if (a2 == null) {
            a2 = new Rect();
            a2.left = 0;
            a2.top = 0;
            a2.right = 0;
            a2.bottom = 0;
        }
        BNMapController.getInstance().setMapShowScreenRect(a2.left, a2.top, BNOuterMapViewManager.getInstance().getGLSurfaceView().getController().getScreenWidth() - a2.right, BNOuterMapViewManager.getInstance().getGLSurfaceView().getController().getScreenHeight() - a2.bottom);
        BNMapController.getInstance().resetRouteDetailIndex();
    }

    @Override // com.baidu.navisdk.adapter.IBNRouteResultManager
    public void fullViewByNode(List<BNRoutePlanNode> list) {
        if (list != null && list.size() >= 2) {
            BNRouteGuider.getInstance().SetFullViewState(true);
            BNRouteGuider.getInstance().setBrowseStatus(true);
            Rect a2 = com.baidu.navisdk.adapter.impl.b.d().a();
            if (a2 == null) {
                a2 = new Rect(0, 0, 0, 0);
            }
            ArrayList<GeoPoint> arrayList = new ArrayList<>();
            Iterator<BNRoutePlanNode> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(com.baidu.navisdk.adapter.impl.d.b().a(it.next()));
            }
            BNMapController.getInstance().updateReservationMap(arrayList, a2, true);
            return;
        }
        LogUtil.out("BNRouteResultManager", "fullviewByNode() return for nodes is invalid.");
    }

    @Override // com.baidu.navisdk.adapter.IBNRouteResultManager
    public void handleCheckpointClick(boolean z) {
        com.baidu.navisdk.adapter.impl.longdistance.a aVar = this.e;
        if (aVar != null) {
            aVar.b(z);
        }
    }

    @Override // com.baidu.navisdk.adapter.IBNRouteResultManager
    public void handleCityClick(boolean z) {
        com.baidu.navisdk.adapter.impl.longdistance.a aVar = this.e;
        if (aVar != null) {
            aVar.c(z);
        }
    }

    @Override // com.baidu.navisdk.adapter.IBNRouteResultManager
    public void handleRouteClick(boolean z) {
        com.baidu.navisdk.adapter.impl.longdistance.a aVar = this.e;
        if (aVar != null) {
            aVar.d(z);
        }
    }

    @Override // com.baidu.navisdk.adapter.IBNRouteResultManager
    public void handleServiceClick(boolean z) {
        com.baidu.navisdk.adapter.impl.longdistance.a aVar = this.e;
        if (aVar != null) {
            aVar.e(z);
        }
    }

    @Override // com.baidu.navisdk.adapter.IBNRouteResultManager
    public void handleWeatherClick(boolean z) {
        com.baidu.navisdk.adapter.impl.longdistance.a aVar = this.e;
        if (aVar != null) {
            aVar.f(z);
        }
    }

    @Override // com.baidu.navisdk.adapter.IBNRouteResultManager
    public boolean isLongDistance() {
        return BNRoutePlaner.getInstance().A();
    }

    @Override // com.baidu.navisdk.adapter.IBNRouteResultManager
    public void onCreate(Context context) {
        LogUtil.out("BNRouteResultManager", "onCreate");
        this.f6472a = context;
        new Handler().post(new d());
        com.baidu.navisdk.adapter.impl.b.d().setRealRoadCondition(context, true);
        j.r().a(context);
        i();
        NAEngine.restartLongLink();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        this.f6472a.registerReceiver(this.n, intentFilter);
        com.baidu.navisdk.yellowbannerui.c cVar = new com.baidu.navisdk.yellowbannerui.c(1, new e(this));
        this.g = cVar;
        this.f = new com.baidu.navisdk.yellowbannerui.controller.b(context, cVar);
        g();
        if (this.e == null) {
            this.e = new com.baidu.navisdk.adapter.impl.longdistance.a();
        }
    }

    @Override // com.baidu.navisdk.adapter.IBNRouteResultManager
    public void onDestroy() {
        LogUtil.out("BNRouteResultManager", "onDestroy");
        NAEngine.stopLongLink();
        try {
            this.f6472a.unregisterReceiver(this.n);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        com.baidu.navisdk.yellowbannerui.controller.b bVar = this.f;
        if (bVar != null) {
            bVar.a();
        }
        this.h = null;
        this.f = null;
        this.g = null;
        com.baidu.navisdk.adapter.impl.longdistance.a aVar = this.e;
        if (aVar != null) {
            aVar.a();
            this.e = null;
        }
        j.r().i();
        BNRoutePlaner.getInstance().b(this.d);
        if (!this.c) {
            BNRouteGuider.getInstance().removeRoute(0);
        }
        if (com.baidu.navisdk.module.init.a.a()) {
            NavMapManager.getInstance().handleRoadCondition(0);
            NavMapManager.getInstance().setNaviMapMode(0);
        }
        NavMapManager.getInstance().handleMapOverlays(0);
        BNOuterMapViewManager.getInstance().hideInfoWindow();
        this.o = null;
        com.baidu.navisdk.poisearch.b.c();
    }

    @Override // com.baidu.navisdk.adapter.IBNRouteResultManager
    public void onPause() {
        LogUtil.out("BNRouteResultManager", "onPause");
        BNMapController.getInstance().deleteObserver(this.l);
    }

    @Override // com.baidu.navisdk.adapter.IBNRouteResultManager
    public void onResume() {
        LogUtil.out("BNRouteResultManager", "onResume");
        this.c = false;
        BNOuterMapViewManager.getInstance().getGLSurfaceView().getController().setMapTheme(1, new Bundle());
        NavMapModeManager.getInstance().changeMode(true, null);
        BNOuterMapViewManager.getInstance().getGLSurfaceView().getController().set3DGestureEnable(false);
        BNMapController.getInstance().addObserver(this.l);
        j.r().a(this.f6472a);
        j.r().a(this.m);
    }

    @Override // com.baidu.navisdk.adapter.IBNRouteResultManager
    public void poiSearch(ArrayList<String> arrayList, IBNRouteResultManager.PoiSearchListener poiSearchListener) {
        this.o = poiSearchListener;
        k k = com.baidu.navisdk.framework.interfaces.c.p().k();
        if (k != null) {
            k.a(new h());
        }
        r.i().a(arrayList, (ArrayList<String>) null, 20, 0);
    }

    @Override // com.baidu.navisdk.adapter.IBNRouteResultManager
    public void removeYellowTipsFromContainer() {
        ViewGroup c2;
        com.baidu.navisdk.yellowbannerui.controller.b bVar = this.f;
        if (bVar != null && (c2 = bVar.c()) != null && c2.getParent() != null) {
            ((ViewGroup) c2.getParent()).removeView(c2);
        }
    }

    @Override // com.baidu.navisdk.adapter.IBNRouteResultManager
    public void selectRoute(int i) {
        a(i);
    }

    @Override // com.baidu.navisdk.adapter.IBNRouteResultManager
    public void setCalcRouteByViaListener(IBNRouteResultManager.ICalcRouteByViaListener iCalcRouteByViaListener) {
        this.i = iCalcRouteByViaListener;
    }

    @Override // com.baidu.navisdk.adapter.IBNRouteResultManager
    public void setOnThroughNodeClickListener(IBNRouteResultManager.IThroughNodeClickedListener iThroughNodeClickedListener) {
        this.k = iThroughNodeClickedListener;
    }

    @Override // com.baidu.navisdk.adapter.IBNRouteResultManager
    public void setRouteClickedListener(IBNRouteResultManager.IRouteClickedListener iRouteClickedListener) {
        this.j = iRouteClickedListener;
    }

    @Override // com.baidu.navisdk.adapter.IBNRouteResultManager
    public void showTruckLimitIcon(boolean z) {
        if (z) {
            BNMapController.getInstance().setMapFuncTruckLimitInfo(com.baidu.navisdk.module.trucknavi.a.f7574a, true);
        } else {
            BNMapController.getInstance().setMapFuncTruckLimitInfo(null, false);
        }
    }

    @Override // com.baidu.navisdk.adapter.IBNRouteResultManager
    public boolean startNavi() {
        this.c = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(s sVar) {
        if (sVar == null) {
            return;
        }
        LogUtil.e("BNRouteResultManager", "addThroughNode: poiNode --> " + sVar);
        GeoPoint geoPoint = sVar.j;
        if (geoPoint != null) {
            if (com.baidu.navisdk.module.nearbysearch.model.b.INSTANCE.b(new com.baidu.navisdk.module.nearbysearch.model.a(geoPoint)) == -1) {
                if (!e()) {
                    TipTool.onCreateToastDialog(this.f6472a, com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_add_via_exceeded));
                    return;
                }
                BNRoutePlaner.getInstance().t = 25;
                String str = sVar.e;
                if (TextUtils.equals("正在获取地址...", str)) {
                    str = "地图上的点";
                }
                l.l().a(geoPoint, str, 25, sVar.p, true);
                return;
            }
            BNRoutePlaner.getInstance().t = 25;
            l.l().a(geoPoint, 25);
        }
    }

    private boolean e() {
        return com.baidu.navisdk.module.nearbysearch.model.b.INSTANCE.b().size() < 3;
    }

    public static BNRouteResultManager f() {
        if (p == null) {
            synchronized (BNRouteResultManager.class) {
                try {
                    if (p == null) {
                        p = new BNRouteResultManager();
                    }
                } finally {
                }
            }
        }
        return p;
    }

    private void g() {
        g gVar = new g(this);
        this.h = gVar;
        this.f.a(gVar, this.g);
        this.f.a(this.h);
    }

    public com.baidu.navisdk.yellowbannerui.controller.b c() {
        return this.f;
    }

    public int d() {
        return this.b;
    }

    public void a(int i) {
        if (this.b == i) {
            return;
        }
        this.b = i;
        BNRoutePlaner.getInstance().n(i);
        com.baidu.navisdk.adapter.impl.longdistance.a aVar = this.e;
        if (aVar != null) {
            aVar.c().q = i;
            if (this.e.c().r) {
                this.e.a(this.f6472a, i);
            } else {
                b(i);
            }
        }
        com.baidu.navisdk.adapter.impl.locallimit.c.a().a(0);
        com.baidu.navisdk.adapter.impl.locallimit.c.a().b();
        com.baidu.navisdk.adapter.impl.locallimit.c.a().a();
        com.baidu.navisdk.poisearch.b.c();
        BNOuterMapViewManager.getInstance().hideInfoWindow();
    }

    private void b(int i) {
        if (this.f == null) {
            return;
        }
        if (!z.b(this.f6472a)) {
            this.f.a(2, "网络异常，请检查网络设置", i);
        } else {
            this.f.b(2);
            this.f.c(i);
        }
    }

    public void a(s sVar) {
        String str;
        View inflate = ((LayoutInflater) this.f6472a.getSystemService("layout_inflater")).inflate(R.layout.nsdk_rr_navi_pass_service_info, (ViewGroup) null);
        StringBuilder sb = new StringBuilder();
        ((TextView) inflate.findViewById(R.id.car_remain_dis)).setText("距您" + ((Object) sb) + l0.a(sVar.h, sb));
        TextView textView = (TextView) inflate.findViewById(R.id.car_remain_time);
        if (sVar.u != null) {
            str = " " + sVar.u;
        } else {
            str = "";
        }
        textView.setText(str);
        ((TextView) inflate.findViewById(R.id.car_service_tx)).setText(sVar.e);
        inflate.findViewById(R.id.add_node_rl).setOnClickListener(new b(sVar));
        Bundle c2 = o.c(sVar.k.getLongitudeE6(), sVar.k.getLatitudeE6());
        BNOuterMapViewManager.getInstance().showInfoWindow(new InfoWindow(inflate, com.baidu.navisdk.a.a(c2.getInt("MCx"), c2.getInt("MCy")), -100));
    }

    public com.baidu.navisdk.module.routeresultbase.logic.longdistance.d b() {
        com.baidu.navisdk.adapter.impl.longdistance.a aVar = this.e;
        if (aVar != null) {
            return aVar.b();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, com.baidu.navisdk.comapi.routeplan.v2.d dVar) {
        IBNRouteResultManager.ICalcRouteByViaListener iCalcRouteByViaListener;
        IBNRouteResultManager.ICalcRouteByViaListener iCalcRouteByViaListener2;
        IBNRouteResultManager.ICalcRouteByViaListener iCalcRouteByViaListener3;
        LogUtil.out("BNRouteResultManager", "resultType = " + i + ", subType = " + i2);
        Handler handler = dVar != null ? dVar.e().q : null;
        if (i == 1) {
            BNOuterMapViewManager.getInstance().hideInfoWindow();
            com.baidu.navisdk.poisearch.b.c();
            this.o = null;
            if (handler == null && dVar != null && !this.c && (iCalcRouteByViaListener = this.i) != null) {
                iCalcRouteByViaListener.onStart();
            }
            com.baidu.navisdk.adapter.impl.longdistance.a aVar = this.e;
            if (aVar != null) {
                aVar.e();
                return;
            }
            return;
        }
        if (i == 4097) {
            h();
            b(0);
            com.baidu.navisdk.adapter.impl.locallimit.c.a().a(0);
            com.baidu.navisdk.adapter.impl.locallimit.c.a().b();
            com.baidu.navisdk.adapter.impl.locallimit.c.a().a();
            return;
        }
        if (i == 4099) {
            if (handler == null && dVar != null && !this.c && (iCalcRouteByViaListener2 = this.i) != null) {
                iCalcRouteByViaListener2.onSuccess();
            }
            com.baidu.navisdk.adapter.impl.longdistance.a aVar2 = this.e;
            if (aVar2 != null) {
                aVar2.g(false);
            }
            a(dVar, i);
            return;
        }
        if (i == 4103) {
            com.baidu.navisdk.adapter.impl.longdistance.a aVar3 = this.e;
            if (aVar3 != null) {
                aVar3.g(true);
            }
            a(dVar, i);
            return;
        }
        if (i == 4109) {
            b(this.b);
            return;
        }
        if (i == 3 || i == 4) {
            if (handler != null || dVar == null || this.c || (iCalcRouteByViaListener3 = this.i) == null) {
                return;
            }
            iCalcRouteByViaListener3.onFailed(i2);
            return;
        }
        if (i == 177) {
            LogUtil.out("BNRouteResultManager", "WEATHER_UPDATE_SUCCESS");
            a(dVar, i);
        } else {
            if (i != 178) {
                return;
            }
            LogUtil.out("BNRouteResultManager", "WEATHER_UPDATE_FAILED");
        }
    }

    public void a(com.baidu.navisdk.comapi.routeplan.v2.d dVar, int i) {
        com.baidu.navisdk.adapter.impl.longdistance.a aVar = this.e;
        if (aVar != null) {
            aVar.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.navisdk.model.datastruct.g gVar) {
        if (this.c || gVar == null) {
            return;
        }
        com.baidu.navisdk.util.logic.a.j().c(gVar);
    }

    public Context a() {
        return this.f6472a;
    }
}
