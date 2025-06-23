package com.baidu.baidunavis.baseline;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.InfoWindow;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.baidu.navisdk.adapter.IBNMapManager;
import com.baidu.navisdk.adapter.map.BNMapViewListener;
import com.baidu.navisdk.adapter.struct.BNLocationData;
import com.baidu.navisdk.adapter.struct.BNMapStatus;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.framework.a;
import com.baidu.navisdk.model.datastruct.g;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.o;
import com.baidu.navisdk.util.statistic.userop.b;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.nplatform.comapi.map.j;
import com.baidu.platform.comapi.longlink.BNLongLink;
import com.baidu.platform.comapi.longlink.BNLongLinkInitCallBack;
import com.baidu.platform.comapi.map.MapSurfaceView;
import com.baidu.platform.comjni.engine.NAEngine;

/* loaded from: classes7.dex */
public class BNOuterMapViewManager implements IBNMapManager {
    private static final String TAG = "BNOuterMapViewManager";
    private static boolean isInitialized = false;
    private static MapView mapView;
    private static BNOuterMapViewManager sInstance;
    private BNLongLinkInitCallBack mLongLinkInitCallBack = new BNLongLinkInitCallBack() { // from class: com.baidu.baidunavis.baseline.BNOuterMapViewManager.1
        @Override // com.baidu.platform.comapi.longlink.BNLongLinkInitCallBack
        public void onLongLinkInit() {
            NAEngine.initLongLinkClient();
        }
    };

    public static BNOuterMapViewManager getInstance() {
        if (sInstance == null) {
            synchronized (BNOuterMapViewManager.class) {
                sInstance = new BNOuterMapViewManager();
            }
        }
        return sInstance;
    }

    @Override // com.baidu.navisdk.adapter.IBNMapManager
    public void attach(ViewGroup viewGroup) {
        if (viewGroup == null) {
            b.r().a("32.0.4.1561", getMapViewParentHash(), (String) null);
            LogUtil.out(TAG, "attach params is null");
            return;
        }
        b.r().a("32.0.4.1561", getMapViewParentHash(), viewGroup.hashCode() + "");
        LogUtil.out(TAG, "attach parent = " + getMapViewParentHash() + ", params = " + viewGroup.hashCode());
        MapView mapView2 = getMapView();
        if (mapView2 == null) {
            return;
        }
        if (mapView2.getParent() == null) {
            viewGroup.addView(mapView2);
        } else if (mapView2.getParent() != null && mapView2.getParent() != viewGroup) {
            ((ViewGroup) mapView2.getParent()).removeView(mapView2);
            viewGroup.addView(mapView2);
        }
    }

    @Override // com.baidu.navisdk.adapter.IBNMapManager
    public void detach(ViewGroup viewGroup) {
        ViewGroup viewGroup2;
        if (viewGroup == null) {
            b.r().a("32.0.4.1562", getMapViewParentHash(), (String) null);
            LogUtil.out(TAG, "detach params is null");
            return;
        }
        b.r().a("32.0.4.1562", getMapViewParentHash(), viewGroup.hashCode() + "");
        LogUtil.out(TAG, "detach parent = " + getMapViewParentHash() + ", params = " + viewGroup.hashCode());
        MapView mapView2 = getMapView();
        if (mapView2 != null && mapView2.getParent() != null && viewGroup == (viewGroup2 = (ViewGroup) mapView2.getParent())) {
            viewGroup2.removeView(mapView2);
        }
    }

    public MapSurfaceView getGLSurfaceView() {
        return getMapView().getMap().getGLMapView();
    }

    @Override // com.baidu.navisdk.adapter.IBNMapManager
    public BNMapStatus getMapStatus() {
        com.baidu.nplatform.comapi.basestruct.b mapStatus = BNMapController.getInstance().getMapStatus();
        BNMapStatus bNMapStatus = new BNMapStatus();
        bNMapStatus.setLevel(mapStatus.f9474a);
        Bundle a2 = o.a((int) mapStatus.d, (int) mapStatus.e);
        if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
            bNMapStatus.setLongitude(a2.getDouble("LLx"));
            bNMapStatus.setLatitude(a2.getDouble("LLy"));
        } else {
            LatLng gcjToBaidu = CoordTrans.gcjToBaidu(new LatLng(a2.getDouble("LLy"), a2.getDouble("LLx")));
            bNMapStatus.setLongitude(gcjToBaidu.longitude);
            bNMapStatus.setLatitude(gcjToBaidu.latitude);
        }
        return bNMapStatus;
    }

    @Override // com.baidu.navisdk.adapter.IBNMapManager
    public MapView getMapView() {
        MapView mapView2;
        LogUtil.out(TAG, "BNOuterMapViewManager --> getMapView");
        if (isInitialized && (mapView2 = mapView) != null) {
            return mapView2;
        }
        MapView mapView3 = new MapView(a.c().a());
        mapView = mapView3;
        mapView3.showZoomControls(false);
        mapView.getMap().getGLMapView().getController().setMapViewListener(new BNMapViewListener());
        com.baidu.baidunavis.maplayer.a.h().a(mapView.getMap().getGLMapView());
        isInitialized = true;
        return mapView;
    }

    public String getMapViewParentHash() {
        MapView mapView2 = mapView;
        if (mapView2 == null || mapView2.getParent() == null) {
            return null;
        }
        return mapView.getParent().hashCode() + "";
    }

    @Override // com.baidu.navisdk.adapter.IBNMapManager
    public float getMaxZoomLevel() {
        return com.baidu.navisdk.ui.routeguide.control.b.k().d();
    }

    @Override // com.baidu.navisdk.adapter.IBNMapManager
    public float getMinZoomLevel() {
        return com.baidu.navisdk.ui.routeguide.control.b.k().e();
    }

    @Override // com.baidu.navisdk.adapter.IBNMapManager
    public int getZoomLevel() {
        return com.baidu.navisdk.ui.routeguide.control.b.k().f();
    }

    public void hideInfoWindow() {
        getMapView().getMap().hideInfoWindow();
    }

    @Override // com.baidu.navisdk.adapter.IBNMapManager
    public void onPause() {
        LogUtil.out(TAG, "BNOuterMapViewManager --> onPause");
        MapView mapView2 = mapView;
        if (mapView2 != null) {
            mapView2.onPause();
            getGLSurfaceView().onBackground();
        }
    }

    @Override // com.baidu.navisdk.adapter.IBNMapManager
    public void onResume() {
        LogUtil.out(TAG, "BNOuterMapViewManager --> onResume");
        MapView mapView2 = mapView;
        if (mapView2 != null) {
            mapView2.onResume();
            getGLSurfaceView().onForeground();
        }
    }

    public void preInitMapView() {
        BNLongLink.registerLongLinkInitCallBack(this.mLongLinkInitCallBack);
        getMapView();
    }

    public void setBaiduMapLogoVisible(boolean z) {
        MapView mapView2 = mapView;
        if (mapView2 == null) {
            return;
        }
        int childCount = mapView2.getChildCount();
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i2 >= childCount) {
                break;
            }
            View childAt = mapView.getChildAt(i2);
            if (childAt instanceof ImageView) {
                if (!z) {
                    i = 8;
                }
                childAt.setVisibility(i);
            } else {
                i2++;
            }
        }
        mapView.showScaleControl(z);
    }

    @Override // com.baidu.navisdk.adapter.IBNMapManager
    public void setDpiScale(float f) {
        BNMapController.getInstance().setDpiScale(f);
    }

    @Override // com.baidu.navisdk.adapter.IBNMapManager
    public void setMapStatus(BNMapStatus bNMapStatus) {
        Bundle b;
        if (bNMapStatus == null) {
            return;
        }
        if (SDKInitializer.getCoordType() == CoordType.BD09LL) {
            LatLng baiduToGcj = CoordTrans.baiduToGcj(new LatLng(bNMapStatus.getLatitude(), bNMapStatus.getLongitude()));
            b = o.b(baiduToGcj.longitude, baiduToGcj.latitude);
        } else {
            b = o.b(bNMapStatus.getLongitude(), bNMapStatus.getLatitude());
        }
        com.baidu.nplatform.comapi.basestruct.b mapStatus = BNMapController.getInstance().getMapStatus();
        if (mapStatus != null) {
            mapStatus.d = b.getInt("MCx");
            mapStatus.e = b.getInt("MCy");
            mapStatus.c = 0;
            mapStatus.f9474a = bNMapStatus.getLevel();
            BNMapController.getInstance().setMapStatus(mapStatus, j.b.eAnimationNone);
        }
    }

    @Override // com.baidu.navisdk.adapter.IBNMapManager
    public void setMyLocationData(BNLocationData bNLocationData) {
        if (com.baidu.navisdk.j.e()) {
            g gVar = new g();
            double d = bNLocationData.latitude;
            gVar.f6926a = d;
            double d2 = bNLocationData.longitude;
            gVar.b = d2;
            gVar.f = bNLocationData.accuracy;
            gVar.c = bNLocationData.speed;
            gVar.e = bNLocationData.direction;
            gVar.h = bNLocationData.altitude;
            gVar.g = bNLocationData.satellitesNum;
            gVar.j = bNLocationData.time;
            gVar.k = 1;
            GeoPoint e = o.e(d2, d);
            g gVar2 = new g();
            gVar2.f6926a = e.getLatitudeE6() / 100000.0d;
            gVar2.b = e.getLongitudeE6() / 100000.0d;
            gVar2.f = bNLocationData.accuracy;
            gVar2.c = bNLocationData.speed;
            gVar2.e = bNLocationData.direction;
            gVar2.h = bNLocationData.altitude;
            gVar2.g = bNLocationData.satellitesNum;
            gVar2.j = bNLocationData.time;
            gVar2.k = 1;
            com.baidu.navisdk.util.logic.a.j().b(gVar, gVar2);
            return;
        }
        LogUtil.out("location", "not use extra loc");
    }

    public void showInfoWindow(InfoWindow infoWindow) {
        getMapView().getMap().showInfoWindow(infoWindow);
    }

    public void unRegisterLongLink() {
        BNLongLink.unRegisterLongLinkInitCallBack(this.mLongLinkInitCallBack);
        this.mLongLinkInitCallBack = null;
    }

    @Override // com.baidu.navisdk.adapter.IBNMapManager
    public void zoomIn() {
        com.baidu.navisdk.ui.routeguide.control.b.k().g();
        BNMapController.getInstance().getMapController().d(true);
    }

    @Override // com.baidu.navisdk.adapter.IBNMapManager
    public void zoomOut() {
        com.baidu.navisdk.ui.routeguide.control.b.k().h();
        BNMapController.getInstance().getMapController().d(true);
    }
}
