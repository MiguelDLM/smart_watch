package com.baidu.navisdk.pronavi.hd;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.widget.ImageView;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.TextureMapView;
import com.baidu.navisdk.framework.interfaces.pronavi.e;
import com.baidu.navisdk.pronavi.hd.RGHDMapGestureManager;
import com.baidu.navisdk.util.common.g;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.platform.comapi.map.MapTextureView;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes7.dex */
public abstract class b implements e, RGHDMapGestureManager.OnMapActionCallback {
    public static final long AUTO_ENTER_NAVI_MODE_TIME = 3000;

    @OOXIXo
    public static final a Companion = new a(null);
    private static final int DEFAULT_FPS = 60;
    private static final String TAG = "RGHDBaseMapView";
    private boolean isBrowseStatus;
    private long mAddrBaseMap;
    private com.baidu.navisdk.util.worker.lite.b mAutoEnterNaviMode;
    private int mCurHdState;

    @oOoXoXO
    private RGHDMapGestureManager mGestureManager;
    private TextureMapView mMapSurfaceView;

    @oOoXoXO
    private com.baidu.navisdk.navimap.a mNaviMapController;
    private boolean isPortrait = true;
    private int mMapFps = -1;
    private int mNativeFps = -1;

    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(IIXOooo iIXOooo) {
            this();
        }
    }

    /* renamed from: com.baidu.navisdk.pronavi.hd.b$b, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0316b extends com.baidu.navisdk.util.worker.lite.b {
        public C0316b(String str) {
            super(str);
        }

        @Override // com.baidu.navisdk.util.worker.lite.b, java.lang.Runnable
        public void run() {
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e(com.baidu.navisdk.util.worker.g.TAG, "startAutoEnterNaviMode: run...");
            }
            b.this.setBrowseStatus(false);
        }
    }

    public static final /* synthetic */ TextureMapView access$getMMapSurfaceView$p(b bVar) {
        TextureMapView textureMapView = bVar.mMapSurfaceView;
        if (textureMapView == null) {
            IIX0o.XOxIOxOx("mMapSurfaceView");
        }
        return textureMapView;
    }

    private final void cancelAutoEnterNaviMode() {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(TAG, "cancelAutoEnterNaviMode: ");
        }
        com.baidu.navisdk.util.worker.lite.b bVar = this.mAutoEnterNaviMode;
        if (bVar != null) {
            com.baidu.navisdk.util.worker.lite.a.a(bVar);
        }
    }

    private final void enableGesture() {
        TextureMapView textureMapView = this.mMapSurfaceView;
        if (textureMapView == null) {
            IIX0o.XOxIOxOx("mMapSurfaceView");
        }
        BaiduMap map = textureMapView.getMap();
        IIX0o.oO(map, "mMapSurfaceView.map");
        MapTextureView mapTextureView = map.getMapTextureView();
        IIX0o.oO(mapTextureView, "mMapSurfaceView.map.mapTextureView");
        TextureMapView textureMapView2 = this.mMapSurfaceView;
        if (textureMapView2 == null) {
            IIX0o.XOxIOxOx("mMapSurfaceView");
        }
        BaiduMap map2 = textureMapView2.getMap();
        IIX0o.oO(map2, "mMapSurfaceView.map");
        MapTextureView mapTextureView2 = map2.getMapTextureView();
        IIX0o.oO(mapTextureView2, "mMapSurfaceView.map.mapTextureView");
        MapController controller = mapTextureView2.getController();
        IIX0o.oO(controller, "mMapSurfaceView.map.mapTextureView.controller");
        TextureMapView textureMapView3 = this.mMapSurfaceView;
        if (textureMapView3 == null) {
            IIX0o.XOxIOxOx("mMapSurfaceView");
        }
        Context context = textureMapView3.getContext();
        IIX0o.oO(context, "mMapSurfaceView.context");
        RGHDMapGestureManager rGHDMapGestureManager = new RGHDMapGestureManager(mapTextureView, controller, context);
        this.mGestureManager = rGHDMapGestureManager;
        rGHDMapGestureManager.a(this);
        RGHDMapGestureManager rGHDMapGestureManager2 = this.mGestureManager;
        if (rGHDMapGestureManager2 != null) {
            rGHDMapGestureManager2.a();
        }
    }

    private final void setBaiduMapLogoVisible(TextureMapView textureMapView, boolean z) {
        int childCount = textureMapView.getChildCount();
        int i = 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = textureMapView.getChildAt(i2);
            IIX0o.oO(childAt, "mapView.getChildAt(i)");
            if (childAt instanceof ImageView) {
                if (!z) {
                    i = 8;
                }
                childAt.setVisibility(i);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setBrowseStatus(boolean z) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(TAG, "setBrowseStatus: " + z + ",cur status: " + this.isBrowseStatus);
        }
        if (z == this.isBrowseStatus) {
            return;
        }
        this.isBrowseStatus = z;
        if (!z) {
            setMapStatus(this.mCurHdState, 1000, this.isPortrait, true);
        }
        if (this.mNativeFps > -1) {
            if (z) {
                interruptFpsLimit();
            } else {
                recoveryFps();
            }
        }
        com.baidu.navisdk.navimap.a aVar = this.mNaviMapController;
        if (aVar != null) {
            IIX0o.ooOOo0oXI(aVar);
            aVar.b(z);
        }
    }

    private final void startAutoEnterNaviMode() {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(TAG, "startAutoEnterNaviMode: ");
        }
        cancelAutoEnterNaviMode();
        if (this.mAutoEnterNaviMode == null) {
            this.mAutoEnterNaviMode = new C0316b("HDAutoEnter");
        }
        com.baidu.navisdk.util.worker.lite.a.a(this.mAutoEnterNaviMode, getAutoExitBrowseStatusTime());
    }

    public final void enterNaviMode() {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(TAG, "enterNaviMode: ");
        }
        cancelAutoEnterNaviMode();
        setBrowseStatus(false);
    }

    public long getAutoExitBrowseStatusTime() {
        return 3000L;
    }

    @oOoXoXO
    public final RGHDMapGestureManager getMGestureManager() {
        return this.mGestureManager;
    }

    @oOoXoXO
    public final com.baidu.navisdk.navimap.a getMNaviMapController() {
        return this.mNaviMapController;
    }

    @oOoXoXO
    public final View getMapView() {
        TextureMapView textureMapView = this.mMapSurfaceView;
        if (textureMapView == null) {
            IIX0o.XOxIOxOx("mMapSurfaceView");
        }
        return textureMapView;
    }

    public final void hideMapViewRoundCorner() {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(TAG, "hideMapViewRoundCorner: ");
        }
        TextureMapView textureMapView = this.mMapSurfaceView;
        if (textureMapView == null) {
            IIX0o.XOxIOxOx("mMapSurfaceView");
        }
        if (textureMapView != null && textureMapView.getOutlineProvider() != null) {
            textureMapView.setOutlineProvider(null);
            textureMapView.setClipToOutline(false);
        }
    }

    public final void interruptFpsLimit() {
        BaiduMap baiduMap;
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(TAG, "interruptFpsLimit");
        }
        TextureMapView textureMapView = this.mMapSurfaceView;
        if (textureMapView == null) {
            IIX0o.XOxIOxOx("mMapSurfaceView");
        }
        if (textureMapView != null) {
            baiduMap = textureMapView.getMap();
        } else {
            baiduMap = null;
        }
        IIX0o.oO(baiduMap, "mMapSurfaceView?.map");
        MapTextureView mapTextureView = baiduMap.getMapTextureView();
        IIX0o.oO(mapTextureView, "mMapSurfaceView?.map.mapTextureView");
        mapTextureView.setFPS(60);
        com.baidu.navisdk.navimap.a aVar = this.mNaviMapController;
        if (aVar != null) {
            aVar.a(0);
        }
    }

    public final boolean isPortrait() {
        return this.isPortrait;
    }

    @OOXIXo
    public abstract c obtainMapConfig();

    @Override // com.baidu.navisdk.pronavi.hd.RGHDMapGestureManager.OnMapActionCallback
    public void onAction(int i) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(TAG, "onAction: " + i);
        }
        switch (i) {
            case 513:
            case 514:
            case 517:
            case 518:
            case 520:
            case 521:
                setBrowseStatus(true);
                if (this.mCurHdState != 3) {
                    startAutoEnterNaviMode();
                    return;
                }
                return;
            case 515:
            case 516:
            case 519:
            default:
                return;
        }
    }

    @OOXIXo
    public View onCreate(@OOXIXo Context context, int i, @OOXIXo String tag) {
        boolean z;
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(tag, "tag");
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(TAG, "onCreate: " + tag);
        }
        TextureMapView textureMapView = this.mMapSurfaceView;
        if (textureMapView != null) {
            return textureMapView;
        }
        if (i != 2) {
            z = true;
        } else {
            z = false;
        }
        this.isPortrait = z;
        TextureMapView textureMapView2 = new TextureMapView(context);
        this.mMapSurfaceView = textureMapView2;
        textureMapView2.showZoomControls(false);
        TextureMapView textureMapView3 = this.mMapSurfaceView;
        if (textureMapView3 == null) {
            IIX0o.XOxIOxOx("mMapSurfaceView");
        }
        textureMapView3.showScaleControl(false);
        TextureMapView textureMapView4 = this.mMapSurfaceView;
        if (textureMapView4 == null) {
            IIX0o.XOxIOxOx("mMapSurfaceView");
        }
        setBaiduMapLogoVisible(textureMapView4, false);
        TextureMapView textureMapView5 = this.mMapSurfaceView;
        if (textureMapView5 == null) {
            IIX0o.XOxIOxOx("mMapSurfaceView");
        }
        BaiduMap map = textureMapView5.getMap();
        IIX0o.oO(map, "mMapSurfaceView.map");
        MapTextureView mapTextureView = map.getMapTextureView();
        IIX0o.oO(mapTextureView, "mMapSurfaceView.map.mapTextureView");
        mapTextureView.setOpaque(false);
        c obtainMapConfig = obtainMapConfig();
        TextureMapView textureMapView6 = this.mMapSurfaceView;
        if (textureMapView6 == null) {
            IIX0o.XOxIOxOx("mMapSurfaceView");
        }
        BaiduMap map2 = textureMapView6.getMap();
        IIX0o.oO(map2, "mMapSurfaceView.map");
        MapTextureView mapTextureView2 = map2.getMapTextureView();
        IIX0o.oO(mapTextureView2, "mMapSurfaceView.map.mapTextureView");
        MapController controller = mapTextureView2.getController();
        controller.setMapTheme(14, new Bundle());
        IIX0o.oO(controller, "controller");
        controller.setMapScene(8);
        long mapId = controller.getMapId();
        this.mAddrBaseMap = mapId;
        com.baidu.navisdk.navimap.a a2 = com.baidu.navisdk.navimap.a.a(tag, mapId);
        this.mNaviMapController = a2;
        if (a2 != null) {
            a2.b(1);
        }
        TextureMapView textureMapView7 = this.mMapSurfaceView;
        if (textureMapView7 == null) {
            IIX0o.XOxIOxOx("mMapSurfaceView");
        }
        BaiduMap map3 = textureMapView7.getMap();
        IIX0o.oO(map3, "mMapSurfaceView.map");
        MapTextureView mapTextureView3 = map3.getMapTextureView();
        mapTextureView3.setTraffic(obtainMapConfig.g());
        mapTextureView3.setSatellite(obtainMapConfig.e());
        mapTextureView3.setStreetRoad(obtainMapConfig.f());
        mapTextureView3.setBaseIndoorMap(obtainMapConfig.b());
        AppBaseMap baseMap = controller.getBaseMap();
        if (baseMap != null) {
            baseMap.ShowHotMap(obtainMapConfig.c(), MapController.HeatMapType.CITY.getId());
            baseMap.ShowMistMap(obtainMapConfig.d(), com.baidu.navisdk.framework.b.e());
        }
        setMapNightMode(!com.baidu.navisdk.ui.util.b.c());
        if (obtainMapConfig.a()) {
            enableGesture();
        }
        TextureMapView textureMapView8 = this.mMapSurfaceView;
        if (textureMapView8 == null) {
            IIX0o.XOxIOxOx("mMapSurfaceView");
        }
        return textureMapView8;
    }

    public void onDestroy() {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(TAG, "onDestroy: ");
        }
        cancelAutoEnterNaviMode();
        RGHDMapGestureManager rGHDMapGestureManager = this.mGestureManager;
        if (rGHDMapGestureManager != null) {
            rGHDMapGestureManager.b();
        }
        com.baidu.navisdk.navimap.a aVar = this.mNaviMapController;
        if (aVar != null) {
            aVar.b(0);
        }
        com.baidu.navisdk.navimap.a aVar2 = this.mNaviMapController;
        if (aVar2 != null) {
            aVar2.a();
        }
        this.mNaviMapController = null;
        TextureMapView textureMapView = this.mMapSurfaceView;
        if (textureMapView == null) {
            IIX0o.XOxIOxOx("mMapSurfaceView");
        }
        if (textureMapView.getParent() instanceof ViewGroup) {
            TextureMapView textureMapView2 = this.mMapSurfaceView;
            if (textureMapView2 == null) {
                IIX0o.XOxIOxOx("mMapSurfaceView");
            }
            ViewParent parent = textureMapView2.getParent();
            if (parent != null) {
                ViewGroup viewGroup = (ViewGroup) parent;
                TextureMapView textureMapView3 = this.mMapSurfaceView;
                if (textureMapView3 == null) {
                    IIX0o.XOxIOxOx("mMapSurfaceView");
                }
                viewGroup.removeView(textureMapView3);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
            }
        }
        if (gVar.d()) {
            StringBuilder sb = new StringBuilder();
            sb.append("onDestroy --> mapController = ");
            TextureMapView textureMapView4 = this.mMapSurfaceView;
            if (textureMapView4 == null) {
                IIX0o.XOxIOxOx("mMapSurfaceView");
            }
            BaiduMap map = textureMapView4.getMap();
            IIX0o.oO(map, "mMapSurfaceView.map");
            MapTextureView mapTextureView = map.getMapTextureView();
            IIX0o.oO(mapTextureView, "mMapSurfaceView.map.mapTextureView");
            sb.append(mapTextureView.getController());
            sb.append(", mapAddr = ");
            TextureMapView textureMapView5 = this.mMapSurfaceView;
            if (textureMapView5 == null) {
                IIX0o.XOxIOxOx("mMapSurfaceView");
            }
            BaiduMap map2 = textureMapView5.getMap();
            IIX0o.oO(map2, "mMapSurfaceView.map");
            MapTextureView mapTextureView2 = map2.getMapTextureView();
            IIX0o.oO(mapTextureView2, "mMapSurfaceView.map.mapTextureView");
            MapController controller = mapTextureView2.getController();
            IIX0o.oO(controller, "mMapSurfaceView.map.mapTextureView.controller");
            sb.append(controller.getMapId());
            gVar.e(TAG, sb.toString());
        }
        try {
            TextureMapView textureMapView6 = this.mMapSurfaceView;
            if (textureMapView6 == null) {
                IIX0o.XOxIOxOx("mMapSurfaceView");
            }
            textureMapView6.onDestroy();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.mAddrBaseMap = 0L;
    }

    public void onHdStateSwitch(int i, int i2, boolean z) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(TAG, "onHdStateSwitch from:" + i + ", to:" + i2 + ',' + z);
        }
        this.isPortrait = z;
        this.mCurHdState = i2;
    }

    public void onOrientationChange(int i) {
        boolean z;
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(TAG, "onOrientationChange: " + i);
        }
        if (i != 2) {
            z = true;
        } else {
            z = false;
        }
        this.isPortrait = z;
        setShowRect(this.mCurHdState, z);
        setMapStatus(this.mCurHdState, 0, this.isPortrait);
    }

    public void onPause() {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(TAG, "onPause: ");
        }
        TextureMapView textureMapView = this.mMapSurfaceView;
        if (textureMapView == null) {
            IIX0o.XOxIOxOx("mMapSurfaceView");
        }
        textureMapView.onPause();
    }

    public void onResume() {
        g gVar = g.MAP;
        if (gVar.d()) {
            gVar.e(TAG, "onResume");
        }
        TextureMapView textureMapView = this.mMapSurfaceView;
        if (textureMapView == null) {
            IIX0o.XOxIOxOx("mMapSurfaceView");
        }
        BaiduMap map = textureMapView.getMap();
        IIX0o.oO(map, "mMapSurfaceView.map");
        map.getMapTextureView().onRecycle();
        TextureMapView textureMapView2 = this.mMapSurfaceView;
        if (textureMapView2 == null) {
            IIX0o.XOxIOxOx("mMapSurfaceView");
        }
        textureMapView2.onResume();
    }

    public final void recoveryFps() {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(TAG, "recoveryFps");
        }
        TextureMapView textureMapView = this.mMapSurfaceView;
        if (textureMapView == null) {
            IIX0o.XOxIOxOx("mMapSurfaceView");
        }
        if (textureMapView != null && this.mNativeFps > -1) {
            TextureMapView textureMapView2 = this.mMapSurfaceView;
            if (textureMapView2 == null) {
                IIX0o.XOxIOxOx("mMapSurfaceView");
            }
            IIX0o.ooOOo0oXI(textureMapView2);
            BaiduMap map = textureMapView2.getMap();
            IIX0o.oO(map, "mMapSurfaceView!!.map");
            MapTextureView mapTextureView = map.getMapTextureView();
            IIX0o.oO(mapTextureView, "mMapSurfaceView!!.map.mapTextureView");
            mapTextureView.setFPS(this.mNativeFps);
        }
        com.baidu.navisdk.navimap.a aVar = this.mNaviMapController;
        if (aVar != null && this.mMapFps > -1) {
            IIX0o.ooOOo0oXI(aVar);
            aVar.a(this.mMapFps);
        }
    }

    public abstract boolean setHdDataToMap(@OOXIXo Bundle bundle);

    public final void setMGestureManager(@oOoXoXO RGHDMapGestureManager rGHDMapGestureManager) {
        this.mGestureManager = rGHDMapGestureManager;
    }

    public final void setMNaviMapController(@oOoXoXO com.baidu.navisdk.navimap.a aVar) {
        this.mNaviMapController = aVar;
    }

    public void setMapFps(int i) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(TAG, "setMapFps: " + i);
        }
        if (i < 0) {
            return;
        }
        this.mMapFps = i;
        com.baidu.navisdk.navimap.a aVar = this.mNaviMapController;
        if (aVar != null) {
            IIX0o.ooOOo0oXI(aVar);
            aVar.a(i);
        }
    }

    public final void setMapNightMode(boolean z) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(TAG, "setMapNightMode: " + z);
        }
        com.baidu.navisdk.navimap.a aVar = this.mNaviMapController;
        if (aVar != null) {
            aVar.c(z);
        }
    }

    public void setMapStatus(int i, int i2, boolean z) {
        setMapStatus(i, i2, z, false);
    }

    public void setNativeFps(int i) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(TAG, "setNativeFps: " + i);
        }
        if (i < 0) {
            return;
        }
        this.mNativeFps = i;
        TextureMapView textureMapView = this.mMapSurfaceView;
        if (textureMapView == null) {
            IIX0o.XOxIOxOx("mMapSurfaceView");
        }
        BaiduMap map = textureMapView.getMap();
        IIX0o.oO(map, "mMapSurfaceView.map");
        MapTextureView mapTextureView = map.getMapTextureView();
        IIX0o.oO(mapTextureView, "mMapSurfaceView.map.mapTextureView");
        mapTextureView.setFPS(i);
    }

    public final void setPortrait(boolean z) {
        this.isPortrait = z;
    }

    public void setShowRect(@OOXIXo Rect rect) {
        IIX0o.x0xO0oo(rect, "rect");
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(TAG, "setShowRect: " + rect);
        }
        com.baidu.navisdk.navimap.a aVar = this.mNaviMapController;
        if (aVar != null) {
            aVar.a(rect);
        }
    }

    public abstract void setXYOffset(@oOoXoXO com.baidu.nplatform.comapi.basestruct.b bVar, int i, boolean z);

    public final void showMapViewRoundCorner(@oOoXoXO ViewOutlineProvider viewOutlineProvider) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(TAG, "showMapViewRoundCorner: ");
        }
        if (viewOutlineProvider == null) {
            hideMapViewRoundCorner();
            return;
        }
        TextureMapView textureMapView = this.mMapSurfaceView;
        if (textureMapView == null) {
            IIX0o.XOxIOxOx("mMapSurfaceView");
        }
        if (textureMapView != null) {
            textureMapView.setOutlineProvider(viewOutlineProvider);
            textureMapView.setClipToOutline(true);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x00e6, code lost:
    
        if (r6.f() != false) goto L36;
     */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00f5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void setMapStatus(int r12, int r13, boolean r14, boolean r15) {
        /*
            Method dump skipped, instructions count: 332
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.pronavi.hd.b.setMapStatus(int, int, boolean, boolean):void");
    }
}
