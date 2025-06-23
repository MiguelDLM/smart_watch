package com.baidu.navisdk.comapi.mapcontrol;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.baidu.navisdk.comapi.base.a;
import com.baidu.navisdk.comapi.mapcontrol.BNMapObserver;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.common.o;
import com.baidu.navisdk.util.common.s;
import com.baidu.navisdk.util.worker.loop.b;
import com.baidu.nplatform.comapi.MapItem;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.nplatform.comapi.basestruct.b;
import com.baidu.nplatform.comapi.basestruct.c;
import com.baidu.nplatform.comapi.map.gesture.opt.d;
import com.baidu.nplatform.comapi.map.j;
import com.baidu.nplatform.comapi.map.k;
import com.baidu.nplatform.comapi.map.n;
import com.baidu.nplatform.comapi.map.u;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.tenmeter.smlibrary.utils.DateFormatUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public class BNMapController extends a {
    private static final String TAG = "BNMapController";
    private static BNDynamicOverlay sDynamicMap;
    private final b mHandler;
    private int mLayerMode;
    private j mMapController;
    private k mSDKMapController;
    private final BNMapOperationStatistic mapOperation;

    /* renamed from: me, reason: collision with root package name */
    private static volatile BNMapController f6710me = new BNMapController();
    public static int sSpeedyLeftBlankLandscape = 150;
    public static int sSpeedyTopBlankHeightPortrait = 85;

    /* loaded from: classes7.dex */
    public class BNMapConfigParams {
        public static final String KEY_SCREEN_HEIGHT = "screen_height";
        public static final String KEY_SCREEN_WIDTH = "screen_width";

        public BNMapConfigParams() {
        }
    }

    /* loaded from: classes7.dex */
    public class NavMapViewListener implements u {
        private long mLastTime = 0;

        public NavMapViewListener() {
        }

        @Override // com.baidu.nplatform.comapi.map.u
        public void onClickDestNodeBubble(MapItem mapItem) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e(BNMapController.TAG, "onClickDestNodeBubble: " + mapItem);
            }
            BNMapController.getInstance().notifyMapObservers(1, BNMapObserver.EventMapView.EVENT_CLICKED_DEST_NODE_BUBBLE, mapItem);
        }

        @Override // com.baidu.nplatform.comapi.map.u
        public void onClickIndoorParkspace(MapItem mapItem) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e(BNMapController.TAG, "onClickIndoorParkspace: " + mapItem);
            }
            BNMapController.getInstance().notifyMapObservers(1, 530, mapItem);
        }

        @Override // com.baidu.nplatform.comapi.map.u
        public void onClickedBackground(int i, int i2) {
            BNMapController.getInstance().notifyMapObservers(1, 272, null);
        }

        @Override // com.baidu.nplatform.comapi.map.u
        public void onClickedBaseLayer() {
            LogUtil.e("Map", "onClickedBaseLayer");
            BNMapController.getInstance().notifyMapObservers(1, 261, null);
        }

        @Override // com.baidu.nplatform.comapi.map.u
        public void onClickedBasePOILayer(MapItem mapItem) {
            LogUtil.e("Map", "onClickedBasePOILayer");
            BNMapController.getInstance().notifyMapObservers(1, 264, mapItem);
        }

        @Override // com.baidu.nplatform.comapi.map.u
        public void onClickedCarLogo(MapItem mapItem) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e(BNMapController.TAG, "onClickedCarLogo: " + mapItem);
            }
            BNMapController.getInstance().notifyMapObservers(1, 521, mapItem);
        }

        @Override // com.baidu.nplatform.comapi.map.u
        public void onClickedCompassLayer() {
            LogUtil.e("Map", "onClickedCompassLayer");
            BNMapController.getInstance().notifyMapObservers(1, 262, null);
        }

        public void onClickedCustomLayer(MapItem mapItem, int i, int i2) {
            Bundle bundle = new Bundle();
            bundle.putSerializable("item", mapItem);
            bundle.putInt("clickedX", i);
            bundle.putInt("clickedY", i2);
            BNMapController.getInstance().notifyMapObservers(1, 512, bundle);
        }

        @Override // com.baidu.nplatform.comapi.map.u
        public void onClickedEndLayer(MapItem mapItem, int i, int i2) {
            Bundle bundle = new Bundle();
            bundle.putSerializable("item", mapItem);
            bundle.putInt("clickedX", i);
            bundle.putInt("clickedY", i2);
            BNMapController.getInstance().notifyMapObservers(1, 513, bundle);
        }

        @Override // com.baidu.nplatform.comapi.map.u
        public void onClickedFavPoiLayer(MapItem mapItem) {
            LogUtil.e("Map", "onClickedFavPoiLayer");
            BNMapController.getInstance().notifyMapObservers(1, 276, mapItem);
        }

        @Override // com.baidu.nplatform.comapi.map.u
        public void onClickedMgData(MapItem mapItem) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e(BNMapController.TAG, "onClickedMgData: " + mapItem);
            }
            BNMapController.getInstance().notifyMapObservers(1, BNMapObserver.EventMapView.EVENT_CLICKED_DYNAMIC_LAYER_ITEM, mapItem);
            if (BNMapController.sDynamicMap != null) {
                BNMapController.sDynamicMap.onClicked(mapItem);
            }
        }

        @Override // com.baidu.nplatform.comapi.map.u
        public void onClickedPOIBkgLayer(MapItem mapItem) {
            LogUtil.e("Map", "onClickedPOIBkgLayer");
            BNMapController.getInstance().notifyMapObservers(1, 265, mapItem);
        }

        @Override // com.baidu.nplatform.comapi.map.u
        public void onClickedPOILayer(MapItem mapItem) {
            LogUtil.e("Map", "onClickedPOILayer");
            BNMapController.getInstance().notifyMapObservers(1, 277, mapItem);
        }

        @Override // com.baidu.nplatform.comapi.map.u
        public void onClickedPopupLayer() {
            LogUtil.e("Map", "onClickedPopupLayer");
            BNMapController.getInstance().notifyMapObservers(1, 263, null);
        }

        @Override // com.baidu.nplatform.comapi.map.u
        public void onClickedRcPredictionElement(MapItem mapItem) {
            BNMapController.getInstance().notifyMapObservers(1, 520, mapItem);
        }

        @Override // com.baidu.nplatform.comapi.map.u
        public void onClickedRoute(MapItem mapItem) {
            BNMapController.getInstance().notifyMapObservers(1, 514, mapItem);
        }

        @Override // com.baidu.nplatform.comapi.map.u
        public void onClickedRouteAroundElement(MapItem mapItem) {
            BNMapController.getInstance().notifyMapObservers(1, 518, mapItem);
        }

        @Override // com.baidu.nplatform.comapi.map.u
        public void onClickedRoutePanItem(MapItem mapItem) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e(BNMapController.TAG, "onClickedRoutePanItem: " + mapItem);
            }
            BNMapController.getInstance().notifyMapObservers(1, BNMapObserver.EventMapView.EVENT_CLICKED_ROUTE_PAN_ITEM, mapItem);
        }

        @Override // com.baidu.nplatform.comapi.map.u
        public void onClickedRouteSpecLayer(MapItem mapItem) {
            BNMapController.getInstance().notifyMapObservers(1, 278, mapItem);
        }

        @Override // com.baidu.nplatform.comapi.map.u
        public void onClickedRouteUgcItem(MapItem mapItem) {
            BNMapController.getInstance().notifyMapObservers(1, 515, mapItem);
        }

        @Override // com.baidu.nplatform.comapi.map.u
        public void onClickedStartLayer(MapItem mapItem, int i, int i2) {
            Bundle bundle = new Bundle();
            bundle.putSerializable("item", mapItem);
            bundle.putInt("clickedX", i);
            bundle.putInt("clickedY", i2);
            BNMapController.getInstance().notifyMapObservers(1, 516, bundle);
        }

        public void onClickedStreetIndoorPoi(n nVar) {
        }

        public void onClickedStreetPopup(String str) {
        }

        @Override // com.baidu.nplatform.comapi.map.u
        public void onClickedThroughNodeLayer(MapItem mapItem, int i, int i2) {
            Bundle bundle = new Bundle();
            bundle.putSerializable("item", mapItem);
            bundle.putInt("clickedX", i);
            bundle.putInt("clickedY", i2);
            BNMapController.getInstance().notifyMapObservers(1, 517, bundle);
        }

        @Override // com.baidu.nplatform.comapi.map.u
        public void onClickedTrafficLightItem(MapItem mapItem) {
            BNMapController.getInstance().notifyMapObservers(1, 519, mapItem);
        }

        @Override // com.baidu.nplatform.comapi.map.u
        public void onClickedUgcItem(MapItem mapItem) {
            BNMapController.getInstance().notifyMapObservers(1, 515, mapItem);
        }

        public void onDoubleFingerRotate() {
            BNMapController.getInstance().notifyMapObservers(2, 521, null);
        }

        @Override // com.baidu.nplatform.comapi.map.u
        public void onDoubleFingerZoom() {
            LogUtil.e("Map", "onDoubleFingerZoom");
            BNMapController.getInstance().notifyMapObservers(2, 520, null);
        }

        @Override // com.baidu.nplatform.comapi.map.u
        public void onMapAnimationFinish() {
            g gVar = g.MAP;
            if (gVar.d()) {
                gVar.e("onMapAnimationFinish");
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (elapsedRealtime - this.mLastTime < 100) {
                return;
            }
            this.mLastTime = elapsedRealtime;
            BNMapController.getInstance().notifyMapObservers(1, 257, null);
            if (BNMapController.this.mMapController != null) {
                BNMapController.this.mMapController.n(10);
                BNMapController.this.mMapController.d();
            }
        }

        @Override // com.baidu.nplatform.comapi.map.u
        public void onMapNetworkingChanged(boolean z) {
            LogUtil.e("Map", "onMapNetworkingChanged");
            if (z) {
                BNMapController.getInstance().notifyMapObservers(1, 258, null);
            }
        }

        public void onMapObviousMove() {
            LogUtil.e("Map", "onMapObviousMove");
            BNMapController.getInstance().notifyMapObservers(2, 519, null);
        }
    }

    public BNMapController() {
        b bVar = new b("MC") { // from class: com.baidu.navisdk.comapi.mapcontrol.BNMapController.1
            @Override // com.baidu.navisdk.comapi.base.d
            public void careAbout() {
                observe(TTAdConstant.INIT_FAILED_LOAD_PLUGIN_FAILED);
                observe(4097);
                observe(4196);
                observe(4138);
                observe(TTAdConstant.INIT_FAILED_CREATE_INITIALIZER_FAILED);
                observe(4611);
            }

            @Override // com.baidu.navisdk.util.worker.loop.b
            public void onMessage(Message message) {
                int i = message.what;
                if (i != 4097) {
                    if (i != 4138) {
                        if (i != 4196) {
                            if (i != 4611) {
                                if (i != 4200) {
                                    if (i == 4201) {
                                        BNMapController.this.notifyObservers(1, 260, message);
                                        return;
                                    }
                                    return;
                                }
                                BNMapController.this.notifyObservers(1, 259, Integer.valueOf(message.arg2));
                                return;
                            }
                        } else {
                            BNMapController.this.notifyObservers(1, 275, message);
                            return;
                        }
                    } else {
                        BNMapController.this.UpdataBaseLayers();
                        return;
                    }
                }
                BNMapController.this.notifyObservers(1, 274, null);
            }
        };
        this.mHandler = bVar;
        this.mapOperation = new BNMapOperationStatistic();
        com.baidu.navisdk.vi.b.a(bVar);
    }

    private static byte[] bitmap2Bytes(Bitmap bitmap) {
        if (bitmap != null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (IOException unused) {
            }
            return byteArray;
        }
        return null;
    }

    private void checkMapSize() {
        if (this.mMapController == null) {
            return;
        }
        int e = com.baidu.baidunavis.maplayer.a.h().e();
        int d = com.baidu.baidunavis.maplayer.a.h().d();
        if (this.mMapController.s() != e || this.mMapController.r() != d) {
            g gVar = g.MAP;
            if (gVar.d()) {
                gVar.e(TAG, "check map size, not match, resize it");
            }
            resizeScreen(e, d);
        }
    }

    public static void destory() {
        if (f6710me != null) {
            synchronized (BNMapController.class) {
                try {
                    if (f6710me != null) {
                        f6710me.dispose();
                        f6710me = null;
                    }
                } finally {
                }
            }
        }
    }

    private void dispose() {
        j jVar = this.mMapController;
        if (jVar != null) {
            jVar.H();
            this.mMapController = null;
        }
        k kVar = this.mSDKMapController;
        if (kVar != null) {
            kVar.b();
            this.mSDKMapController = null;
        }
    }

    public static BNDynamicOverlay getDynamicOverlay() {
        if (sDynamicMap == null) {
            sDynamicMap = new BNDynamicOverlay();
        }
        return sDynamicMap;
    }

    public static BNMapController getInstance() {
        if (f6710me == null) {
            synchronized (BNMapController.class) {
                try {
                    if (f6710me == null) {
                        f6710me = new BNMapController();
                    }
                } finally {
                }
            }
        }
        return f6710me;
    }

    public float GetZoomToBound(Bundle bundle, float f, float f2) {
        j jVar = this.mMapController;
        if (jVar != null) {
            return jVar.a(bundle, f, f2);
        }
        return 0.0f;
    }

    public void ResetGLHandleWhenCreateOrDestroyContext(boolean z) {
        if (this.mMapController != null) {
            LogUtil.e("BaiduGLSurfaceView", " BNMapController --> ResetGLHandleWhenCreateOrDestroyContext");
            this.mMapController.a(z);
        } else {
            LogUtil.e("MinimapTexture", "BNMapController ReleaseMinimap mMapController == null");
        }
    }

    public void ResetImageRes() {
        j jVar = this.mMapController;
        if (jVar != null) {
            jVar.A();
        }
    }

    public void SaveCache() {
        j jVar = this.mMapController;
        if (jVar != null) {
            jVar.a();
        }
    }

    public boolean SetMinimapWinSize(int i, int i2) {
        j jVar = this.mMapController;
        if (jVar != null) {
            return jVar.a(i, i2);
        }
        return false;
    }

    public void StartMapDataRequest() {
        j jVar = this.mMapController;
        if (jVar != null) {
            jVar.b();
        }
    }

    public void StopMapDataRequest() {
        j jVar = this.mMapController;
        if (jVar != null) {
            jVar.c();
        }
    }

    public boolean UpdataBaseLayers() {
        j jVar = this.mMapController;
        if (jVar != null) {
            jVar.d();
            return true;
        }
        return false;
    }

    public boolean allViewSerialAnimation() {
        LogUtil.e(TAG, "allViewSerialAnimation: mMapController --> " + this.mMapController);
        j jVar = this.mMapController;
        if (jVar == null) {
            return false;
        }
        return jVar.e();
    }

    public void awakeDrawWaitEvent() {
        j jVar = this.mMapController;
        if (jVar == null) {
            return;
        }
        jVar.f();
    }

    public boolean checkMapViewCameraAvailable(long j) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(TAG, "checkMapViewCameraAvailable --> baseMapAddr = " + j + ", mMapController = " + this.mMapController);
        }
        j jVar = this.mMapController;
        if (jVar == null) {
            return false;
        }
        return jVar.a(j);
    }

    public boolean checkRoadConditionSupport(int i) {
        return true;
    }

    public boolean clearLayer(int i) {
        j jVar = this.mMapController;
        if (jVar != null) {
            jVar.a(i);
            return true;
        }
        return false;
    }

    public void createMiniMapControl() {
        j jVar = this.mMapController;
        if (jVar == null) {
            return;
        }
        jVar.g();
    }

    public void destroyMiniMapControl() {
        j jVar = this.mMapController;
        if (jVar == null) {
            return;
        }
        jVar.h();
    }

    public void dynamicWindowChange(int i, int i2, int i3) {
        j jVar = this.mMapController;
        if (jVar == null) {
            return;
        }
        jVar.b(i, i2, i3);
    }

    public void dynamicWindowDraw(int i) {
        j jVar = this.mMapController;
        if (jVar == null) {
            return;
        }
        jVar.b(i);
    }

    public boolean dynamicWindowInit(int i, Bundle bundle) {
        j jVar = this.mMapController;
        if (jVar == null) {
            return false;
        }
        return jVar.a(i, bundle);
    }

    public void dynamicWindowShutDown(int i) {
        j jVar = this.mMapController;
        if (jVar == null) {
            return;
        }
        jVar.c(i);
    }

    public void enableTouchEventLookover(boolean z) {
        j jVar = this.mMapController;
        if (jVar != null) {
            jVar.f(z);
        }
    }

    public void enterCarPlayMode(long j) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(TAG, "enterCarPlayMode --> baseMapAddr = " + j + ", mMapController = " + this.mMapController);
        }
        j jVar = this.mMapController;
        if (jVar == null) {
            return;
        }
        jVar.b(j);
    }

    public void enterNavi() {
        setMap2DLook(false);
    }

    public void exitCarPlayMode() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(TAG, "exitCarPlayMode --> mMapController = " + this.mMapController);
        }
        j jVar = this.mMapController;
        if (jVar == null) {
            return;
        }
        jVar.i();
    }

    public boolean focusItem(int i, int i2, boolean z) {
        j jVar = this.mMapController;
        if (jVar != null) {
            return jVar.a(i, i2, z);
        }
        return false;
    }

    public boolean getCameraStatus(int i) {
        if (this.mMapController == null) {
            return false;
        }
        LogUtil.e(TAG, "setCameraStatus --> type =" + i);
        return this.mMapController.d(i);
    }

    public float getDpiScale() {
        j jVar = this.mMapController;
        if (jVar == null) {
            return 0.0f;
        }
        return jVar.k();
    }

    public GeoPoint getGeoPosByScreenPos(int i, int i2) {
        j jVar = this.mMapController;
        if (jVar != null) {
            return jVar.b(i, i2);
        }
        return null;
    }

    public b.a getGeoRound() {
        j jVar = this.mMapController;
        if (jVar == null) {
            return null;
        }
        return jVar.o().h;
    }

    public int getLayerMode() {
        return this.mLayerMode;
    }

    public j getMapController() {
        return this.mMapController;
    }

    public MapItem getMapItemByGeoPos(int i, int i2, int i3) {
        j jVar = this.mMapController;
        if (jVar != null) {
            int[] iArr = new int[1];
            int[] iArr2 = new int[1];
            if (jVar.a(i, i2, iArr, iArr2)) {
                return this.mMapController.e(iArr[0], iArr2[0], i3);
            }
            return null;
        }
        return null;
    }

    public float getMapLevel() {
        return getMapStatus().f9474a;
    }

    public com.baidu.nplatform.comapi.basestruct.b getMapStatus() {
        j jVar = this.mMapController;
        if (jVar != null) {
            return jVar.o();
        }
        return null;
    }

    public k getSDKMapController() {
        return this.mSDKMapController;
    }

    public int getScreenHeight() {
        int i;
        checkMapSize();
        j jVar = this.mMapController;
        if (jVar != null) {
            i = jVar.r();
        } else {
            i = 0;
        }
        if (i <= 0) {
            g gVar = g.MAP;
            if (gVar.d()) {
                gVar.e(TAG, "getScreenHeight,height invalid, will use ScreenUtil instead");
            }
            i = ScreenUtil.getInstance().getHeightPixels();
        }
        g gVar2 = g.MAP;
        if (gVar2.d()) {
            gVar2.e(TAG, "getScreenHeight,height:" + i);
        }
        return i;
    }

    public boolean getScreenMask(int i, int i2, int i3, int i4, boolean z, Bitmap bitmap) {
        j jVar = this.mMapController;
        if (jVar == null) {
            return false;
        }
        return jVar.a(i, i2, i3, i4, z, bitmap);
    }

    public c getScreenPosByGeoPos(GeoPoint geoPoint) {
        j jVar = this.mMapController;
        if (jVar != null) {
            return jVar.a(geoPoint);
        }
        return null;
    }

    public boolean getScreenShot(int i, int i2, int i3, Bitmap bitmap) {
        j jVar = this.mMapController;
        if (jVar == null) {
            return false;
        }
        return jVar.a(i, i2, i3, bitmap);
    }

    public boolean getScreenShotImage(Bundle bundle) {
        j jVar = this.mMapController;
        if (jVar == null) {
            return false;
        }
        return jVar.a(bundle);
    }

    public int getScreenWidth() {
        int i;
        checkMapSize();
        j jVar = this.mMapController;
        if (jVar != null) {
            i = jVar.s();
        } else {
            i = 0;
        }
        if (i <= 0) {
            g gVar = g.MAP;
            if (gVar.d()) {
                gVar.e(TAG, "getScreenWidth,width invalid, will use ScreenUtil instead");
            }
            i = ScreenUtil.getInstance().getWidthPixels();
        }
        g gVar2 = g.MAP;
        if (gVar2.d()) {
            gVar2.e(TAG, "getScreenWidth,width:" + i);
        }
        return i;
    }

    public Rect getShowScreenRect() {
        j jVar = this.mMapController;
        if (jVar == null) {
            return new Rect();
        }
        return jVar.n();
    }

    public int getZoomLevel() {
        j jVar = this.mMapController;
        if (jVar != null) {
            return jVar.t();
        }
        return 18;
    }

    public double getZoomUnitsInMeter() {
        double d;
        j jVar = this.mMapController;
        if (jVar != null) {
            d = jVar.u();
        } else {
            d = 1.0d;
        }
        return d / (ScreenUtil.getInstance().getDPI() / 310.0d);
    }

    public boolean handleDoubleTouch(Object obj) {
        if (this.mMapController != null) {
            com.baidu.navisdk.comapi.statistics.b.f().d("ds");
            if (obj != null) {
                this.mMapController.b((MotionEvent) obj);
            }
            getInstance().notifyMapObservers(2, 513, null);
            return true;
        }
        return true;
    }

    public boolean handleSingleTouch(Object obj) {
        if (this.mMapController != null) {
            com.baidu.navisdk.comapi.statistics.b.f().d(DateFormatUtils.DD);
            if (obj != null) {
                this.mMapController.a((MotionEvent) obj);
            }
            getInstance().notifyMapObservers(2, 514, obj);
            return true;
        }
        return true;
    }

    public void initMapController(Context context, Bundle bundle) {
        if (this.mMapController == null) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("right", bundle.getInt(BNMapConfigParams.KEY_SCREEN_WIDTH));
            bundle2.putInt("bottom", bundle.getInt(BNMapConfigParams.KEY_SCREEN_HEIGHT));
            j jVar = new j(context);
            this.mMapController = jVar;
            jVar.b(bundle2);
            this.mMapController.a(new NavMapViewListener());
            getDynamicOverlay().setMapController(this.mMapController);
        }
        if (this.mSDKMapController == null) {
            k kVar = new k();
            this.mSDKMapController = kVar;
            kVar.a();
        }
    }

    public void initMiniRenderEngine(int i, int i2, int i3) {
        j jVar = this.mMapController;
        if (jVar == null) {
            return;
        }
        jVar.c(i, i2, i3);
    }

    public void injectRenderMsg() {
        com.baidu.navisdk.util.worker.loop.b bVar = this.mHandler;
        if (bVar != null) {
            bVar.sendEmptyMessage(4196);
        }
    }

    public void mapClickEvent(int i) {
        j jVar = this.mMapController;
        if (jVar == null) {
            return;
        }
        jVar.e(i);
    }

    public void notifyMapObservers(int i, int i2, Object obj) {
        notifyObservers(i, i2, obj);
        if (d.l && i2 == 520) {
            this.mapOperation.addMapOP(i, 521);
        } else {
            this.mapOperation.addMapOP(i, i2);
        }
    }

    public void notifyOrientation(boolean z) {
        if (this.mMapController == null) {
            g.MAP.e(TAG, "notifyOrientation controller = null");
            return;
        }
        g gVar = g.MAP;
        if (gVar.d()) {
            gVar.e(TAG, "notifyOrientation, isPortrait = " + z);
        }
        this.mMapController.h(z);
    }

    public void onMapAnimationFinish() {
        j jVar = this.mMapController;
        if (jVar != null) {
            jVar.w();
        }
    }

    public boolean onMapItemClick(String str, int i, int i2) {
        j jVar = this.mMapController;
        if (jVar != null) {
            return jVar.a(str, i, i2);
        }
        return false;
    }

    public void onPause() {
        j jVar = this.mMapController;
        if (jVar != null) {
            jVar.x();
        }
    }

    public void onResume() {
        j jVar = this.mMapController;
        if (jVar != null) {
            jVar.y();
        }
    }

    public boolean preNextRouteDetail(boolean z) {
        LogUtil.e(TAG, "preNextRouteDetail: mMapController --> " + this.mMapController + ", bPre=" + z);
        j jVar = this.mMapController;
        if (jVar == null) {
            return false;
        }
        return jVar.i(z);
    }

    public void recoveryHighLightRoute() {
        j jVar = this.mMapController;
        if (jVar == null) {
            return;
        }
        jVar.f(0, 0);
        getInstance().updateLayer(10);
        if (LogUtil.LOGGABLE) {
            int selectRouteIdx = JNIGuidanceControl.getInstance().getSelectRouteIdx();
            LogUtil.e(TAG, "recoveryHighLightRoute mainRouteIdx:" + selectRouteIdx);
        }
    }

    public boolean releaseSharedMapData() {
        j jVar = this.mMapController;
        if (jVar != null) {
            return jVar.z();
        }
        return false;
    }

    public void resetCompassPosition(int i, int i2, int i3) {
        j jVar = this.mMapController;
        if (jVar != null) {
            jVar.d(i, i2, i3);
        }
    }

    public boolean resetRouteDetailIndex() {
        String str = TAG;
        LogUtil.e(str, "resetRouteDetailIndex: mMapController --> " + this.mMapController);
        g gVar = g.ROUTE_RESULT;
        if (gVar.d()) {
            gVar.e(str, "resetRouteDetailIndex()");
        }
        j jVar = this.mMapController;
        if (jVar == null) {
            return false;
        }
        return jVar.j(true);
    }

    public void resetScalePosition(int i, int i2) {
        j jVar = this.mMapController;
        if (jVar != null) {
            jVar.c(i, i2);
        }
    }

    public void resizeScreen(int i, int i2) {
        j jVar = this.mMapController;
        if (jVar != null) {
            jVar.d(i, i2);
        }
        notifyMapObservers(1, 256, null);
    }

    public boolean saveScreen(String str) {
        return this.mMapController.a(str);
    }

    public boolean saveScreenToBuffer() {
        j jVar = this.mMapController;
        if (jVar == null) {
            return false;
        }
        return jVar.B();
    }

    public GeoPoint scrPtToGeoPoint(int i, int i2) {
        if (this.mMapController == null) {
            LogUtil.e(TAG, "scrPtToGeoPoint mMapController is null");
            return new GeoPoint();
        }
        LogUtil.e(TAG, "scrPtToGeoPoint --> inX = " + i + ", inY = " + i2);
        return this.mMapController.e(i, i2);
    }

    public void sendCommandToMapEngine(int i, Bundle bundle) {
        j jVar = this.mMapController;
        if (jVar == null) {
            return;
        }
        jVar.b(i, bundle);
    }

    public boolean set3DCarLogoToMap(String str, String str2) {
        if (LogUtil.LOGGABLE) {
            g.ROUTE_GUIDE.e(TAG, "set3DCarLogoToMap(), filePath = " + str + " configFileName = " + str2);
        }
        boolean z = false;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String str3 = File.separator;
            if (!str.endsWith(str3)) {
                str = str + str3;
            }
            if (!s.d(str + str2)) {
                if (LogUtil.LOGGABLE) {
                    g.ROUTE_GUIDE.e(TAG, "set3DCarLogoToMap config file not exist");
                }
                return false;
            }
            j jVar = this.mMapController;
            if (jVar != null && jVar.a(str, str2)) {
                z = true;
            }
            if (LogUtil.LOGGABLE) {
                g.ROUTE_GUIDE.e(TAG, "set3DCarLogoToMap result:" + z);
            }
        }
        return z;
    }

    public boolean set3DCarToMap(List<Bitmap> list) {
        if (list == null) {
            return false;
        }
        int size = list.size();
        int i = size / 4;
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < size; i2++) {
            Bitmap bitmap = list.get((i2 + i) % size);
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int byteCount = (bitmap.getByteCount() * 8) / (width * height);
            byte[] a2 = com.baidu.navisdk.ui.util.d.a(bitmap);
            Bundle bundle = new Bundle();
            bundle.putInt("imageWidth", width);
            bundle.putInt("imageHeight", height);
            bundle.putInt("imageLen", bitmap.getByteCount());
            bundle.putInt("bits", byteCount);
            bundle.putByteArray("imageBytes", a2);
            arrayList.add(bundle);
        }
        return this.mMapController.a((List<Bundle>) arrayList);
    }

    public void setACEParkViewMode(int i) {
        String str = TAG;
        LogUtil.e(str, "setACEParkViewVisible: mMapController --> " + this.mMapController + ", viewMode = " + i);
        g gVar = g.ROUTE_RESULT;
        if (gVar.d()) {
            gVar.e(str, "setACEParkViewMode() --> viewMode = " + i);
        }
        j jVar = this.mMapController;
        if (jVar == null) {
            return;
        }
        jVar.f(i);
    }

    public boolean setAnimationGlobalSwitch(boolean z) {
        j jVar = this.mMapController;
        if (jVar != null) {
            return jVar.l(z);
        }
        return false;
    }

    public boolean setBarrageInfo(String str, String[] strArr, String[] strArr2) {
        if (!TextUtils.isEmpty(str) && strArr != null && strArr2 != null) {
            Bundle bundle = new Bundle();
            long uidCodecDecode = JNIGuidanceControl.getInstance().uidCodecDecode(str);
            bundle.putString("eventId", str);
            bundle.putLong("eventLongId", uidCodecDecode);
            bundle.putStringArray("iconList", strArr);
            bundle.putStringArray("textList", strArr2);
            j jVar = this.mMapController;
            if (jVar != null) {
                return jVar.c(bundle);
            }
        }
        return false;
    }

    public boolean setCameraStatus(int i, boolean z) {
        if (this.mMapController == null) {
            return false;
        }
        LogUtil.e(TAG, "setCameraStatus --> type =" + i + ", isShow =" + z);
        return this.mMapController.a(i, z);
    }

    public void setCarImageToMap(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int byteCount = (bitmap.getByteCount() * 8) / (width * height);
        byte[] bitmap2Bytes = bitmap2Bytes(bitmap);
        if (bitmap2Bytes != null && width > 0 && height > 0 && byteCount > 0) {
            g gVar = g.ROUTE_GUIDE;
            if (gVar.e()) {
                gVar.g("guide_info", "setCarImageToMap() showCurCarSpeedView()");
            }
            j jVar = this.mMapController;
            if (jVar != null) {
                jVar.a(width, height, byteCount, bitmap2Bytes);
                return;
            }
            return;
        }
        g gVar2 = g.ROUTE_GUIDE;
        gVar2.a("guide_info", "width=" + width + ", height=" + height + ", bits=" + byteCount);
        if (gVar2.b()) {
            gVar2.b("guide_info", "imageBytes = " + bitmap2Bytes);
        }
    }

    public boolean setCarLogoSpeed() {
        j jVar = this.mMapController;
        if (jVar != null) {
            jVar.C();
            return true;
        }
        return false;
    }

    public boolean setCarLogoTriangle() {
        j jVar = this.mMapController;
        if (jVar != null) {
            jVar.D();
            return true;
        }
        return false;
    }

    public boolean setCarLogoVisible(boolean z) {
        j jVar = this.mMapController;
        if (jVar == null) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e(TAG, "setCarLogoVisible,mMapController is null");
                return false;
            }
            return false;
        }
        return jVar.b(z);
    }

    public boolean setCharsetEncodeType(boolean z) {
        j jVar = this.mMapController;
        if (jVar == null) {
            return false;
        }
        return jVar.n(z);
    }

    public void setCompassVisible(boolean z) {
        if (this.mMapController == null) {
            LogUtil.e(TAG, "mMapController is null");
            return;
        }
        LogUtil.e(TAG, "setCompassVisible: " + z);
        this.mMapController.c(z);
    }

    public boolean setDIYDataToMap(int i, String str, String str2) {
        if (LogUtil.LOGGABLE) {
            g.ROUTE_GUIDE.e(TAG, "setDIYDataToMap(), filePath = " + str + " configFileName = " + str2 + ", type:" + i);
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String str3 = File.separator;
        if (!str.endsWith(str3)) {
            str = str + str3;
        }
        if (str2 != null) {
            if (!s.d(str + str2)) {
                if (LogUtil.LOGGABLE) {
                    g.ROUTE_GUIDE.e(TAG, "setDIYDataToMap config file not exist");
                }
                return false;
            }
        }
        boolean a2 = this.mMapController.a(i, str, str2);
        if (LogUtil.LOGGABLE) {
            g.ROUTE_GUIDE.e(TAG, "setDIYDataToMap result:" + a2);
            return true;
        }
        return true;
    }

    public boolean setDIYImageToMap(List<Bitmap> list, int[] iArr) {
        j jVar = this.mMapController;
        if (jVar != null) {
            return jVar.a(list, iArr);
        }
        return false;
    }

    public void setDpiScale(float f) {
        j jVar = this.mMapController;
        if (jVar == null) {
            return;
        }
        jVar.a(f);
    }

    public boolean setDragMapStatus(boolean z) {
        j jVar = this.mMapController;
        if (jVar == null) {
            return false;
        }
        return jVar.o(z);
    }

    public boolean setDrawHouse(boolean z) {
        j jVar = this.mMapController;
        if (jVar == null) {
            return false;
        }
        return jVar.a(z, true);
    }

    public void setDrawNaviLogo(boolean z) {
        LogUtil.e(TAG, "setDrawNaviLogo mMapController=" + this.mMapController + " bDrawNaviLogo=" + z);
        j jVar = this.mMapController;
        if (jVar != null) {
            jVar.p(z);
        }
    }

    public void setDynamicWindowShowSize(int i, int i2, int i3, int i4, int i5) {
        j jVar = this.mMapController;
        if (jVar == null) {
            return;
        }
        jVar.a(i, i2, i3, i4, i5);
    }

    public void setEndNodeIconVisible(boolean z) {
        String str = TAG;
        LogUtil.e(str, "setEndNodeIconVisible: mMapController --> " + this.mMapController);
        g gVar = g.ROUTE_RESULT;
        if (gVar.d()) {
            gVar.e(str, "setEndNodeIconVisible()");
        }
        j jVar = this.mMapController;
        if (jVar == null) {
            return;
        }
        jVar.q(z);
    }

    public void setEndNodeNameVisible(boolean z) {
        String str = TAG;
        LogUtil.e(str, "setEndNodeNameVisible: mMapController --> " + this.mMapController);
        g gVar = g.ROUTE_RESULT;
        if (gVar.d()) {
            gVar.e(str, "setEndNodeNameVisible()");
        }
        j jVar = this.mMapController;
        if (jVar == null) {
            return;
        }
        jVar.r(z);
    }

    public void setEnlargedStatus(boolean z) {
        j jVar = this.mMapController;
        if (jVar != null) {
            jVar.s(z);
        }
    }

    public boolean setHDDataToMap(Bundle bundle) {
        g gVar = g.MAP;
        if (gVar.d()) {
            gVar.e(TAG, "setHDDataToMap(): " + bundle);
        }
        return this.mMapController.d(bundle);
    }

    public void setHighLightAvoidTrafficRoute(int i) {
        j jVar = this.mMapController;
        if (jVar == null) {
            return;
        }
        jVar.f(2, i);
        getInstance().updateLayer(10);
        int selectRouteIdx = JNIGuidanceControl.getInstance().getSelectRouteIdx();
        if (LogUtil.LOGGABLE) {
            LogUtil.e(TAG, "setHighLightAvoidTrafficRoute routeIdx: " + i + ",mainRouteIdx: " + selectRouteIdx);
        }
        com.baidu.navisdk.util.statistic.userop.b.r().a("3.s.a", selectRouteIdx + "", i + "", "2");
    }

    public void setHighLightRoute(int i) {
        j jVar = this.mMapController;
        if (jVar == null) {
            return;
        }
        jVar.f(1, i);
        getInstance().updateLayer(10);
        int selectRouteIdx = JNIGuidanceControl.getInstance().getSelectRouteIdx();
        com.baidu.navisdk.util.statistic.userop.b.r().a("3.s.a", selectRouteIdx + "", i + "", "1");
    }

    public void setLabelBreathing(int i, boolean z) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(TAG, "routeId = " + i + " isBreathing = " + z);
        }
        if (i < 0) {
            return;
        }
        this.mMapController.b(i, z);
    }

    public void setLayerMode(int i) {
        j jVar = this.mMapController;
        if (jVar == null) {
            return;
        }
        this.mLayerMode = i;
        switch (i) {
            case 0:
                jVar.c(9, false);
                this.mMapController.c(3, false);
                this.mMapController.c(4, false);
                this.mMapController.c(10, false);
                this.mMapController.c(8, false);
                this.mMapController.c(35, false);
                this.mMapController.c(15, false);
                this.mMapController.c(14, true);
                this.mMapController.c(13, false);
                this.mMapController.c(16, true);
                this.mMapController.c(11, false);
                this.mMapController.c(17, false);
                this.mMapController.n(17);
                this.mMapController.c(19, false);
                this.mMapController.c(31, false);
                this.mMapController.c(32, false);
                this.mMapController.c(33, false);
                this.mMapController.c(20, false);
                break;
            case 1:
                jVar.c(9, false);
                this.mMapController.c(3, false);
                this.mMapController.c(4, false);
                this.mMapController.c(10, false);
                this.mMapController.c(8, false);
                this.mMapController.c(35, false);
                this.mMapController.c(15, false);
                this.mMapController.c(14, true);
                this.mMapController.c(13, false);
                this.mMapController.c(16, true);
                this.mMapController.c(11, false);
                this.mMapController.c(17, false);
                this.mMapController.n(17);
                this.mMapController.c(19, false);
                this.mMapController.c(31, false);
                this.mMapController.c(32, false);
                this.mMapController.c(33, false);
                this.mMapController.c(20, false);
                break;
            case 2:
                jVar.c(9, false);
                this.mMapController.c(3, true);
                this.mMapController.n(3);
                this.mMapController.c(4, true);
                this.mMapController.n(4);
                this.mMapController.c(15, false);
                this.mMapController.c(10, false);
                this.mMapController.c(8, false);
                this.mMapController.c(35, false);
                this.mMapController.c(14, true);
                this.mMapController.c(13, false);
                this.mMapController.c(16, true);
                this.mMapController.c(11, false);
                this.mMapController.c(17, false);
                this.mMapController.n(17);
                this.mMapController.c(19, false);
                this.mMapController.c(31, false);
                this.mMapController.c(32, false);
                this.mMapController.c(33, false);
                this.mMapController.c(20, false);
                break;
            case 3:
                jVar.c(9, true);
                this.mMapController.n(9);
                this.mMapController.c(3, false);
                this.mMapController.c(4, false);
                this.mMapController.c(10, true);
                this.mMapController.n(10);
                this.mMapController.c(8, true);
                this.mMapController.c(15, true);
                this.mMapController.n(8);
                this.mMapController.c(35, true);
                this.mMapController.n(35);
                this.mMapController.c(14, false);
                this.mMapController.c(13, false);
                this.mMapController.c(16, true);
                this.mMapController.c(11, false);
                this.mMapController.c(17, false);
                this.mMapController.n(17);
                this.mMapController.c(19, false);
                this.mMapController.c(31, false);
                this.mMapController.c(32, false);
                this.mMapController.c(33, false);
                this.mMapController.c(20, false);
                this.mMapController.c(24, true);
                this.mMapController.c(25, true);
                this.mMapController.c(26, true);
                this.mMapController.c(27, true);
                break;
            case 4:
                jVar.c(9, false);
                this.mMapController.c(3, false);
                this.mMapController.c(4, false);
                this.mMapController.c(10, false);
                this.mMapController.c(8, false);
                this.mMapController.c(35, false);
                this.mMapController.c(15, false);
                this.mMapController.c(14, true);
                this.mMapController.c(13, false);
                this.mMapController.c(16, true);
                this.mMapController.c(11, true);
                this.mMapController.c(17, false);
                this.mMapController.n(17);
                this.mMapController.c(19, false);
                this.mMapController.c(31, false);
                this.mMapController.c(32, false);
                this.mMapController.c(33, false);
                this.mMapController.c(20, false);
                break;
            case 5:
                jVar.c(9, false);
                this.mMapController.c(3, false);
                this.mMapController.c(4, false);
                this.mMapController.c(10, false);
                this.mMapController.c(8, true);
                this.mMapController.c(35, false);
                this.mMapController.c(15, false);
                this.mMapController.c(14, false);
                this.mMapController.c(13, true);
                this.mMapController.n(13);
                this.mMapController.c(16, true);
                this.mMapController.c(11, true);
                this.mMapController.c(17, true);
                this.mMapController.n(17);
                this.mMapController.c(19, false);
                this.mMapController.c(31, false);
                this.mMapController.c(32, false);
                this.mMapController.c(33, false);
                this.mMapController.c(20, false);
                break;
            case 6:
                jVar.c(9, false);
                this.mMapController.c(3, false);
                this.mMapController.c(4, false);
                this.mMapController.c(10, false);
                this.mMapController.c(8, true);
                this.mMapController.c(35, false);
                this.mMapController.c(15, false);
                this.mMapController.c(14, false);
                this.mMapController.c(13, true);
                this.mMapController.n(13);
                this.mMapController.c(16, true);
                this.mMapController.c(11, true);
                this.mMapController.c(17, false);
                this.mMapController.n(17);
                this.mMapController.c(19, false);
                this.mMapController.c(31, false);
                this.mMapController.c(32, false);
                this.mMapController.c(33, false);
                this.mMapController.c(20, false);
                break;
            case 7:
                jVar.c(9, false);
                this.mMapController.c(3, false);
                this.mMapController.c(4, false);
                this.mMapController.c(10, false);
                this.mMapController.c(8, false);
                this.mMapController.n(8);
                this.mMapController.c(35, false);
                this.mMapController.n(35);
                this.mMapController.c(15, false);
                this.mMapController.c(14, false);
                this.mMapController.c(13, false);
                this.mMapController.c(16, true);
                this.mMapController.c(11, false);
                this.mMapController.c(17, false);
                this.mMapController.n(17);
                this.mMapController.c(19, false);
                this.mMapController.c(31, false);
                this.mMapController.c(32, false);
                this.mMapController.c(33, false);
                this.mMapController.c(20, true);
                this.mMapController.n(20);
                break;
            case 8:
                jVar.c(9, false);
                this.mMapController.c(3, false);
                this.mMapController.c(4, false);
                this.mMapController.c(10, false);
                this.mMapController.c(8, false);
                this.mMapController.n(8);
                this.mMapController.c(35, false);
                this.mMapController.n(35);
                this.mMapController.c(15, false);
                this.mMapController.c(14, false);
                this.mMapController.c(13, false);
                this.mMapController.c(16, false);
                this.mMapController.c(11, false);
                this.mMapController.c(17, false);
                this.mMapController.c(19, true);
                this.mMapController.n(19);
                this.mMapController.c(31, false);
                this.mMapController.c(32, false);
                this.mMapController.c(33, false);
                this.mMapController.c(20, false);
                break;
            case 9:
                jVar.c(9, false);
                this.mMapController.c(3, false);
                this.mMapController.c(4, false);
                this.mMapController.c(10, false);
                this.mMapController.c(8, true);
                this.mMapController.n(8);
                this.mMapController.c(35, false);
                this.mMapController.n(35);
                this.mMapController.c(15, false);
                this.mMapController.c(14, false);
                this.mMapController.c(13, false);
                this.mMapController.n(13);
                this.mMapController.c(16, false);
                this.mMapController.c(11, false);
                this.mMapController.c(17, false);
                this.mMapController.c(19, false);
                this.mMapController.c(31, false);
                this.mMapController.c(32, false);
                this.mMapController.c(33, false);
                this.mMapController.c(20, false);
                break;
            case 10:
                jVar.c(9, false);
                this.mMapController.c(3, false);
                this.mMapController.c(4, false);
                this.mMapController.c(10, false);
                this.mMapController.c(8, false);
                this.mMapController.c(35, false);
                this.mMapController.c(15, false);
                this.mMapController.c(14, true);
                this.mMapController.c(13, false);
                this.mMapController.c(16, true);
                this.mMapController.c(11, false);
                this.mMapController.c(17, false);
                this.mMapController.n(17);
                this.mMapController.c(19, false);
                this.mMapController.c(31, false);
                this.mMapController.c(32, false);
                this.mMapController.c(33, false);
                this.mMapController.c(20, false);
                break;
            case 11:
                jVar.c(9, false);
                this.mMapController.c(3, false);
                this.mMapController.c(4, false);
                this.mMapController.c(10, false);
                this.mMapController.c(8, false);
                this.mMapController.c(35, false);
                this.mMapController.c(15, false);
                this.mMapController.c(14, true);
                this.mMapController.c(13, false);
                this.mMapController.c(16, true);
                this.mMapController.c(11, false);
                this.mMapController.c(17, false);
                this.mMapController.n(17);
                this.mMapController.c(19, false);
                this.mMapController.c(31, false);
                this.mMapController.c(32, true);
                this.mMapController.c(33, false);
                this.mMapController.c(20, false);
                break;
            case 12:
                jVar.c(9, false);
                this.mMapController.c(3, false);
                this.mMapController.c(4, false);
                this.mMapController.c(10, false);
                this.mMapController.c(8, false);
                this.mMapController.c(35, false);
                this.mMapController.c(15, false);
                this.mMapController.c(14, true);
                this.mMapController.c(13, false);
                this.mMapController.c(16, true);
                this.mMapController.c(11, true);
                this.mMapController.c(17, false);
                this.mMapController.n(17);
                this.mMapController.c(19, false);
                this.mMapController.c(31, false);
                this.mMapController.c(32, false);
                this.mMapController.c(33, true);
                this.mMapController.c(20, false);
                break;
        }
        this.mMapController.c(27, true);
        this.mMapController.c(34, true);
    }

    @Deprecated
    public void setLevel(float f) {
        com.baidu.nplatform.comapi.basestruct.b mapStatus = getMapStatus();
        if (mapStatus != null) {
            mapStatus.f9474a = f;
            setMapStatus(mapStatus, j.b.eAnimationLevel);
        }
    }

    public void setMap2DLook(boolean z) {
        if (this.mMapController == null) {
            LogUtil.e(TAG, "mMapController is null");
            return;
        }
        LogUtil.e(TAG, "setMapFuncInfo:" + z);
        this.mMapController.t(z);
    }

    public void setMapElementShow(int i, boolean z) {
        if (this.mMapController == null) {
            LogUtil.e(TAG, "setMapElementShow mMapController is null");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("bShow", z);
        LogUtil.e(TAG, "setMapElementShow --> mapElementType = " + i + ", bShow = " + z);
        setMapFuncInfo(i, bundle);
    }

    public boolean setMapForceSwitchStrategy(boolean z) {
        j jVar = this.mMapController;
        if (jVar != null) {
            return jVar.v(z);
        }
        return false;
    }

    public void setMapFuncInfo(int i, Bundle bundle) {
        if (this.mMapController == null) {
            LogUtil.e(TAG, "mMapController is null");
            return;
        }
        LogUtil.e(TAG, "setMapFuncInfo --> mapElementType = " + i + ", mapElementAttr = " + bundle);
        this.mMapController.c(i, bundle);
    }

    public boolean setMapFuncInfoFastRoute(boolean z, int i, int i2, int i3) {
        j jVar = this.mMapController;
        if (jVar == null) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e(TAG, "setMapFuncInfoMapClass,mMapController is null");
                return false;
            }
            return false;
        }
        return jVar.a(z, i, i2, i3);
    }

    public void setMapFuncInfoMapClass(int i, Bundle bundle) {
        if (this.mMapController == null) {
            LogUtil.e(TAG, "setMapFuncInfoMapClass,mMapController is null");
            return;
        }
        LogUtil.e(TAG, "setMapFuncInfoMapClass --> mapClassType = " + i + ", bundle = " + bundle);
        this.mMapController.d(i, bundle);
    }

    public void setMapFuncInfoMapStrategy(int i, Bundle bundle) {
        if (this.mMapController == null) {
            LogUtil.e(TAG, "setMapFuncInfoMapStrategy,mMapController is null");
            return;
        }
        LogUtil.e(TAG, "setMapFuncInfoMapStrategy --> mapStrategyType = " + i + ", bundle = " + bundle);
        this.mMapController.e(i, bundle);
    }

    public boolean setMapFuncInfoPartRouteZoom(boolean z, int i, int i2, int i3) {
        j jVar = this.mMapController;
        if (jVar != null) {
            return jVar.b(z, i, i2, i3);
        }
        return false;
    }

    public void setMapFuncTruckLimitInfo(int[] iArr, boolean z) {
        j jVar = this.mMapController;
        if (jVar == null) {
            return;
        }
        jVar.a(iArr, z);
    }

    public void setMapFuncTruckUgcInfo(int[] iArr, boolean z) {
        j jVar = this.mMapController;
        if (jVar == null) {
            return;
        }
        jVar.b(iArr, z);
    }

    public void setMapPoiScene(boolean z) {
        if (this.mMapController == null) {
            LogUtil.e(TAG, "mMapController is null");
            return;
        }
        LogUtil.e(TAG, "setMapFuncInfo:" + z);
        this.mMapController.w(z);
    }

    public void setMapShowScreenRect(int i, int i2, int i3, int i4) {
        if (this.mMapController != null) {
            try {
                this.mMapController.a(new Rect(i, i2, i3, i4));
            } catch (Exception e) {
                if (LogUtil.LOGGABLE) {
                    LogUtil.e(TAG, "setMapShowScreenRect error:" + e);
                }
            }
        }
    }

    public void setMapStatus(com.baidu.nplatform.comapi.basestruct.b bVar, j.b bVar2) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(TAG, "setMapStatus -> " + bVar.toString());
        }
        j jVar = this.mMapController;
        if (jVar != null) {
            jVar.a(bVar, bVar2);
        }
    }

    public void setMemoryScale(int i) {
        j jVar = this.mMapController;
        if (jVar != null) {
            jVar.h(i);
        }
    }

    public void setNaviCarPos() {
        j jVar = this.mMapController;
        if (jVar == null) {
            return;
        }
        jVar.E();
    }

    public boolean setNaviMapMode(int i) {
        if (this.mMapController != null && com.baidu.navisdk.module.init.a.a()) {
            return this.mMapController.i(i);
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e(TAG, "setNaviMapMode,mMapController is null");
            return false;
        }
        return false;
    }

    public void setNaviStatus(boolean z) {
        j jVar = this.mMapController;
        if (jVar == null) {
            return;
        }
        jVar.x(z);
    }

    public boolean setNightMode(boolean z) {
        j jVar = this.mMapController;
        if (jVar != null) {
            return jVar.y(z);
        }
        return false;
    }

    public boolean setPreFinishStatus(boolean z) {
        if (this.mMapController == null) {
            return false;
        }
        LogUtil.e(TAG, "setPreFinishStatus :" + z);
        return this.mMapController.z(z);
    }

    public boolean setPreRoutePlanStatus(boolean z) {
        j jVar = this.mMapController;
        if (jVar == null) {
            return false;
        }
        return jVar.A(z);
    }

    public boolean setQuitMossPartZoom(boolean z) {
        j jVar = this.mMapController;
        if (jVar != null) {
            return jVar.B(z);
        }
        return false;
    }

    public void setRealGraphInfo(long j, String str, String str2) {
        g gVar = g.ROUTE_RESULT;
        if (gVar.d()) {
            gVar.e(TAG, "setRealGraphInfo(), decodeEventId = " + j + " imageUrl = " + str + " text = " + str2);
        }
        j jVar = this.mMapController;
        if (jVar == null) {
            return;
        }
        jVar.a(j, str, str2);
    }

    public void setRedLineRender(boolean z) {
        j jVar = this.mMapController;
        if (jVar == null) {
            return;
        }
        jVar.C(z);
    }

    public boolean setRouteDetailIndex(int i) {
        LogUtil.e(TAG, "setRouteDetailIndex: mMapController --> " + this.mMapController + ", index=" + i);
        j jVar = this.mMapController;
        if (jVar == null) {
            return false;
        }
        return jVar.j(i);
    }

    public boolean setRouteSearchStatus(boolean z) {
        if (this.mMapController == null) {
            return false;
        }
        LogUtil.e(TAG, "setRouteSearchStatus(), isHasNearbySearchResult : " + z);
        return this.mMapController.D(z);
    }

    public boolean setScreenShotParam(int i, int i2, int i3, long j, long j2, int i4) {
        j jVar = this.mMapController;
        if (jVar == null) {
            return false;
        }
        return jVar.a(i, i2, i3, j, j2, i4);
    }

    public boolean setScreenShow(int i, int i2, int i3, int i4, int i5, int i6) {
        LogUtil.e(TAG, "setScreenShow: mMapController --> " + this.mMapController);
        if (this.mMapController == null) {
            return false;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("unScreenWidth", i);
        bundle.putInt("unScreenHeight", i2);
        bundle.putInt("nTopHeight", i3);
        bundle.putInt("nBottomHeight", i4);
        bundle.putInt("nLeftWidth", i5);
        bundle.putInt("nRightWidth", i6);
        return this.mMapController.e(bundle);
    }

    public void setShowTrackBrake(boolean z) {
        j jVar = this.mMapController;
        if (jVar != null) {
            jVar.E(z);
            updateLayer(19);
        }
    }

    public void setShowTrackCurve(boolean z) {
        j jVar = this.mMapController;
        if (jVar != null) {
            jVar.F(z);
            updateLayer(19);
        }
    }

    public void setShowTrackMaxSpeed(boolean z) {
        j jVar = this.mMapController;
        if (jVar != null) {
            jVar.G(z);
            updateLayer(19);
        }
    }

    public void setShowTrackOverSpeed(boolean z) {
        j jVar = this.mMapController;
        if (jVar != null) {
            jVar.H(z);
            updateLayer(19);
        }
    }

    public void setShowTrackRapidAcc(boolean z) {
        j jVar = this.mMapController;
        if (jVar != null) {
            jVar.I(z);
            updateLayer(19);
        }
    }

    public boolean setSimpleModeGuide(boolean z) {
        j jVar = this.mMapController;
        if (jVar == null) {
            return false;
        }
        return jVar.J(z);
    }

    public void setSlightModeZoomToFullView() {
        String str = TAG;
        LogUtil.e(str, "setSlightModeZoomToFullView: mMapController --> " + this.mMapController);
        g gVar = g.ROUTE_RESULT;
        if (gVar.d()) {
            gVar.e(str, "setSlightModeZoomToFullView()");
        }
        j jVar = this.mMapController;
        if (jVar == null) {
            return;
        }
        jVar.F();
    }

    public boolean setSlightScreenStatus(int i) {
        j jVar = this.mMapController;
        if (jVar != null) {
            return jVar.k(i);
        }
        return false;
    }

    public void setStrategyVisible(boolean z) {
        if (this.mMapController == null) {
            LogUtil.e(TAG, "mMapController is null");
            return;
        }
        LogUtil.e(TAG, "SetStrategyVisible: " + z);
        this.mMapController.e(z);
    }

    public void setTranslucentHeight(int i) {
        j jVar = this.mMapController;
        if (jVar != null) {
            jVar.l(i);
        }
    }

    public boolean setUIViewBound(ArrayList<Bundle> arrayList) {
        j jVar = this.mMapController;
        if (jVar == null) {
            return false;
        }
        return jVar.a(arrayList);
    }

    public void showCarResultLayer(boolean z) {
        if (this.mMapController == null) {
            g.MAP.a("showCarResultLayer is null");
            return;
        }
        g.MAP.a("showCarResultLayer " + z);
        this.mMapController.c(10, z);
        if (!z) {
            this.mMapController.a(10);
        }
        this.mMapController.n(10);
        this.mMapController.c(8, z);
        if (!z) {
            this.mMapController.a(8);
        }
        this.mMapController.n(8);
        this.mMapController.c(27, z);
        if (!z) {
            this.mMapController.a(27);
        }
        this.mMapController.n(27);
        this.mMapController.c(35, z);
        if (!z) {
            this.mMapController.a(35);
        }
        this.mMapController.n(35);
    }

    public boolean showLayer(int i, boolean z) {
        if (this.mMapController != null) {
            LogUtil.e("RGUgcRoadModel", "ugcpopup  showLayer  show: " + z + "   layerType " + i);
            return this.mMapController.c(i, z);
        }
        return false;
    }

    public void showTrafficMap(boolean z) {
        j jVar = this.mMapController;
        if (jVar != null) {
            jVar.b(z, true);
        }
    }

    public void switchITSMode(boolean z) {
        j jVar = this.mMapController;
        if (jVar != null) {
            jVar.K(z);
        }
    }

    public void updateChosenMultiRouteID(int i) {
        j jVar = this.mMapController;
        if (jVar != null) {
            jVar.m(i);
        }
    }

    public boolean updateLayer(int i) {
        j jVar = this.mMapController;
        if (jVar != null) {
            jVar.n(i);
            return true;
        }
        return false;
    }

    public void updateMapViewByBound(Rect rect, Rect rect2, boolean z, j.b bVar, int i) {
        updateMapViewByBound(rect, rect2, z, bVar, i, 0);
    }

    public void updateReservationMap(ArrayList<GeoPoint> arrayList, Rect rect, boolean z) {
        float widthPixels;
        int heightPixels;
        int i;
        LogUtil.e(TAG, "updateReservationMap searchPois size :" + arrayList.size());
        int size = arrayList.size();
        int i2 = Integer.MAX_VALUE;
        int i3 = Integer.MAX_VALUE;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < size; i6++) {
            GeoPoint geoPoint = arrayList.get(i6);
            if (geoPoint != null) {
                if (i2 > geoPoint.getLongitudeE6()) {
                    i2 = geoPoint.getLongitudeE6();
                }
                if (i4 < geoPoint.getLongitudeE6()) {
                    i4 = geoPoint.getLongitudeE6();
                }
                if (i5 < geoPoint.getLatitudeE6()) {
                    i5 = geoPoint.getLatitudeE6();
                }
                if (i3 > geoPoint.getLatitudeE6()) {
                    i3 = geoPoint.getLatitudeE6();
                }
            }
        }
        Bundle c = o.c(i4, i3);
        Bundle c2 = o.c(i2, i5);
        int i7 = c.getInt("MCx");
        int i8 = c.getInt("MCy");
        int i9 = c2.getInt("MCx");
        int i10 = c2.getInt("MCy");
        Bundle bundle = new Bundle();
        bundle.putLong("left", i9);
        bundle.putLong("right", i7);
        bundle.putLong("top", i10);
        bundle.putLong("bottom", i8);
        if (!z) {
            widthPixels = (ScreenUtil.getInstance().getHeightPixels() - rect.left) - rect.right;
            heightPixels = ScreenUtil.getInstance().getWidthPixels() - rect.top;
            i = rect.bottom;
        } else {
            widthPixels = (ScreenUtil.getInstance().getWidthPixels() - rect.left) - rect.right;
            heightPixels = ScreenUtil.getInstance().getHeightPixels() - rect.top;
            i = rect.bottom;
        }
        float f = heightPixels - i;
        if (LogUtil.LOGGABLE) {
            LogUtil.e(TAG, "updateReservationMap() s.w=" + ScreenUtil.getInstance().getWidthPixels() + ", s.h=" + ScreenUtil.getInstance().getHeightPixels() + ", r.left=" + rect.left + ", r.right=" + rect.right + ", r.top=" + rect.top + ", r.bottom=" + rect.bottom + ", width=" + widthPixels + ", height=" + f);
        }
        if (widthPixels <= 0.0f || f <= 0.0f) {
            LogUtil.e(TAG, "updateReservationMap() w or h <= 0");
            widthPixels = 0.0f;
            f = 0.0f;
        }
        float GetZoomToBound = GetZoomToBound(bundle, widthPixels, f) - 0.35f;
        String str = TAG;
        LogUtil.e(str, "updateReservationMap() level=" + GetZoomToBound);
        float f2 = (float) ((i7 + i9) / 2);
        float f3 = (float) ((i10 + i8) / 2);
        float f4 = (float) ((rect.bottom - rect.top) / 2);
        float f5 = (rect.left - rect.right) / 2;
        com.baidu.nplatform.comapi.basestruct.b mapStatus = getMapStatus();
        if (mapStatus == null) {
            LogUtil.e(str, "updateMapView fail st is null");
            return;
        }
        mapStatus.j = f4;
        mapStatus.i = f5;
        mapStatus.d = (int) f2;
        mapStatus.e = (int) f3;
        mapStatus.f9474a = GetZoomToBound;
        mapStatus.b = 1.0f;
        mapStatus.c = 0;
        setMapStatus(mapStatus, j.b.eAnimationNone, -1);
    }

    public boolean updateShareMapData() {
        j jVar = this.mMapController;
        if (jVar != null) {
            return jVar.I();
        }
        return false;
    }

    public boolean zoomIn() {
        j jVar = this.mMapController;
        if (jVar != null) {
            com.baidu.navisdk.comapi.statistics.b.f().a(Math.min(jVar.t() + 1, 21));
            return this.mMapController.J();
        }
        return false;
    }

    public boolean zoomOut() {
        if (this.mMapController != null) {
            com.baidu.navisdk.comapi.statistics.b.f().a(Math.max(r0.t() - 1, 4));
            return this.mMapController.K();
        }
        return false;
    }

    public boolean zoomToBound(Bundle bundle) {
        j jVar = this.mMapController;
        if (jVar != null) {
            return jVar.f(bundle);
        }
        return false;
    }

    public void zoomToFullView(Rect rect, boolean z, int i, int i2, boolean z2) {
        j jVar = this.mMapController;
        if (jVar != null) {
            jVar.a(rect, z, i, i2, z2);
        }
    }

    public void zoomToSlightNaviFullView(Bundle bundle, boolean z) {
        j jVar = this.mMapController;
        if (jVar != null) {
            jVar.a(bundle, z);
        }
    }

    public boolean zoomToTrajectory() {
        j jVar = this.mMapController;
        if (jVar != null) {
            return jVar.L();
        }
        return false;
    }

    public void updateMapViewByBound(Rect rect, Rect rect2, boolean z, j.b bVar, int i, int i2) {
        updateMapViewByBound(rect, rect2, z, bVar, i, i2, false);
    }

    public com.baidu.nplatform.comapi.basestruct.b getMapStatus(boolean z) {
        j jVar = this.mMapController;
        if (jVar != null) {
            return jVar.g(z);
        }
        return null;
    }

    public boolean setDrawHouse(boolean z, boolean z2) {
        j jVar = this.mMapController;
        if (jVar == null) {
            return false;
        }
        return jVar.a(z, z2);
    }

    public boolean setUIViewBound(ArrayList<Bundle> arrayList, int i) {
        if (LogUtil.LOGGABLE) {
            String str = TAG;
            LogUtil.e(str, "setUIViewBound --> dealy = " + i);
            LogUtil.printList(str, "setUIViewBound", "viewArray", arrayList);
            LogUtil.printCallStack();
        }
        j jVar = this.mMapController;
        if (jVar == null) {
            return false;
        }
        return jVar.a(arrayList, i);
    }

    public void showTrafficMap(boolean z, boolean z2) {
        j jVar = this.mMapController;
        if (jVar != null) {
            jVar.b(z, z2);
        }
    }

    public void updateMapViewByBound(Rect rect, Rect rect2, boolean z, j.b bVar, int i, int i2, boolean z2) {
        float f;
        int i3;
        Bundle bundle = new Bundle();
        bundle.putLong("left", rect.left);
        bundle.putLong("right", rect.right);
        bundle.putLong("top", rect.top);
        bundle.putLong("bottom", rect.bottom);
        float f2 = rect2.right - rect2.left;
        float f3 = rect2.top - rect2.bottom;
        float GetZoomToBound = GetZoomToBound(bundle, f2, f3) - 0.35f;
        float f4 = (rect.right + rect.left) / 2;
        float f5 = (rect.top + rect.bottom) / 2;
        int heightPixels = ScreenUtil.getInstance().getHeightPixels();
        int widthPixels = ScreenUtil.getInstance().getWidthPixels();
        int i4 = heightPixels - i2;
        if (z) {
            f = ((rect2.top + rect2.bottom) - i4) / 2;
            i3 = ((rect2.right + rect2.left) - widthPixels) / 2;
        } else {
            f = ((rect2.top + rect2.bottom) - widthPixels) / 2;
            i3 = ((rect2.right + rect2.left) - i4) / 2;
        }
        float f6 = i3;
        com.baidu.nplatform.comapi.basestruct.b mapStatus = getMapStatus();
        if (mapStatus == null) {
            LogUtil.e(TAG, "updateMapView fail st is null");
            return;
        }
        mapStatus.j = f;
        mapStatus.i = f6;
        mapStatus.d = (int) f4;
        mapStatus.e = (int) f5;
        mapStatus.f9474a = GetZoomToBound;
        mapStatus.b = 0.0f;
        mapStatus.c = 0;
        if (g.MAP.d()) {
            String str = TAG;
            LogUtil.e(str, "updateMapView() --> bundle = " + bundle + ", width = " + f2 + ", height = " + f3 + ", st = " + mapStatus);
            LogUtil.e(str, "updateMapView() --> st._WinRound: left = " + mapStatus.g.f9476a + ", top = " + mapStatus.g.c + ", right = " + mapStatus.g.b + ", bottom = " + mapStatus.g.d);
        }
        setMapStatus(mapStatus, bVar, i, z2);
    }

    public void setMapStatus(com.baidu.nplatform.comapi.basestruct.b bVar, j.b bVar2, int i) {
        j jVar = this.mMapController;
        if (jVar != null) {
            jVar.a(bVar, bVar2, i);
        }
    }

    public boolean resetRouteDetailIndex(boolean z) {
        LogUtil.e(TAG, "resetRouteDetailIndex: mMapController --> " + this.mMapController + ", bAnimation=" + z);
        j jVar = this.mMapController;
        if (jVar == null) {
            return false;
        }
        return jVar.j(z);
    }

    public void setHighLightRoute(int i, int i2) {
        j jVar = this.mMapController;
        if (jVar == null) {
            return;
        }
        jVar.f(i, i2);
    }

    public void setMapStatus(com.baidu.nplatform.comapi.basestruct.b bVar, j.b bVar2, int i, boolean z) {
        j jVar = this.mMapController;
        if (jVar != null) {
            jVar.a(bVar, bVar2, i, z);
            if (LogUtil.LOGGABLE) {
                LogUtil.e(TAG, "俯仰角:" + bVar.c);
            }
        }
    }
}
