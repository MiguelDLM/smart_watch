package com.baidu.navisdk.adapter.map;

import android.os.Bundle;
import com.baidu.baidunavis.baseline.BNOuterMapViewManager;
import com.baidu.baidunavis.maplayer.e;
import com.baidu.navisdk.adapter.impl.BNRouteResultManager;
import com.baidu.navisdk.f;
import com.baidu.navisdk.module.routeresultbase.logic.longdistance.d;
import com.baidu.navisdk.util.common.g;
import com.baidu.nplatform.comapi.basestruct.c;
import com.baidu.nplatform.comjni.tools.JNITools;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.map.ItemizedOverlay;
import com.baidu.platform.comapi.map.ItsMapObj;
import com.baidu.platform.comapi.map.MapObj;
import com.baidu.platform.comapi.map.MapSurfaceView;
import com.baidu.platform.comapi.map.MapViewListener;
import com.baidu.platform.comapi.map.Overlay;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class BNMapViewListener implements MapViewListener {
    private static final String TAG = "BNMapViewListener";

    @Override // com.baidu.platform.comapi.map.MapViewListener
    public void onClickPolymericMapObj(List<MapObj> list) {
    }

    @Override // com.baidu.platform.comapi.map.MapViewListener
    public void onClickSdkMapObj(int i, JSONObject jSONObject) {
    }

    @Override // com.baidu.platform.comapi.map.MapViewListener
    public void onClickStreetArrow(MapObj mapObj) {
    }

    @Override // com.baidu.platform.comapi.map.MapViewListener
    public void onClickStreetSurface(MapObj mapObj) {
    }

    @Override // com.baidu.platform.comapi.map.MapViewListener
    public void onClickedBackground(int i, int i2) {
        c a2 = e.k().a(i, i2);
        Bundle Bd09mcToGcj02 = JNITools.Bd09mcToGcj02(a2.c(), a2.d());
        f.a().onMapClicked(Bd09mcToGcj02.getDouble("LLy"), Bd09mcToGcj02.getDouble("LLx"));
    }

    @Override // com.baidu.platform.comapi.map.MapViewListener
    public void onClickedItem(int i, GeoPoint geoPoint, long j) {
        if (g.c0) {
            g.OPEN_SDK.f(TAG, "onClickedItem");
        }
        MapSurfaceView gLSurfaceView = BNOuterMapViewManager.getInstance().getGLSurfaceView();
        ArrayList<Overlay> arrayList = new ArrayList(gLSurfaceView.getOverlays());
        if (arrayList.isEmpty()) {
            if (g.c0) {
                g.OPEN_SDK.f(TAG, "overlays.isEmpty");
                return;
            }
            return;
        }
        if (g.c0) {
            g.OPEN_SDK.f(TAG, "overlays" + arrayList.size());
        }
        for (Overlay overlay : arrayList) {
            if (overlay.mType != 27) {
                if (g.c0) {
                    g.OPEN_SDK.f(TAG, "overlays != EMAP_ITEM");
                }
            } else if (geoPoint != null && (overlay instanceof ItemizedOverlay)) {
                ItemizedOverlay itemizedOverlay = (ItemizedOverlay) overlay;
                boolean onTap = itemizedOverlay.onTap(geoPoint, gLSurfaceView);
                if (g.c0) {
                    g.OPEN_SDK.f(TAG, "overlays flag" + onTap);
                }
                if (!onTap && i != -1 && j == overlay.mLayerID) {
                    if (g.c0) {
                        g.OPEN_SDK.f(TAG, "onTap：" + i);
                    }
                    itemizedOverlay.onTap(i);
                }
            }
        }
    }

    @Override // com.baidu.platform.comapi.map.MapViewListener
    public void onClickedItsMapObj(List<ItsMapObj> list) {
    }

    @Override // com.baidu.platform.comapi.map.MapViewListener
    public void onClickedMapObj(List<MapObj> list) {
    }

    @Override // com.baidu.platform.comapi.map.MapViewListener
    public void onClickedOPPoiEventMapObj(MapObj mapObj) {
    }

    @Override // com.baidu.platform.comapi.map.MapViewListener
    public void onClickedParticleEventMapObj(List<MapObj> list) {
    }

    @Override // com.baidu.platform.comapi.map.MapViewListener
    public void onClickedPoiObj(List<MapObj> list) {
    }

    @Override // com.baidu.platform.comapi.map.MapViewListener
    public void onClickedPopup(int i) {
    }

    @Override // com.baidu.platform.comapi.map.MapViewListener
    public void onClickedRouteLabelObj(List<MapObj> list) {
    }

    @Override // com.baidu.platform.comapi.map.MapViewListener
    public void onClickedRouteObj(List<MapObj> list) {
    }

    @Override // com.baidu.platform.comapi.map.MapViewListener
    public void onClickedStreetIndoorPoi(MapObj mapObj) {
    }

    @Override // com.baidu.platform.comapi.map.MapViewListener
    public void onClickedStreetPopup(String str) {
    }

    @Override // com.baidu.platform.comapi.map.MapViewListener
    public void onClickedTrafficUgcEventMapObj(MapObj mapObj, boolean z) {
    }

    @Override // com.baidu.platform.comapi.map.MapViewListener
    public void onClickedUniversalLayerPoiEventMapObj(List<MapObj> list) {
    }

    @Override // com.baidu.platform.comapi.map.MapViewListener
    public void onMapAnimationFinish() {
        d b = BNRouteResultManager.f().b();
        if (b != null) {
            b.b(BNRouteResultManager.f().a());
        }
    }

    @Override // com.baidu.platform.comapi.map.MapViewListener
    public void onClickedItem(int i, int i2, GeoPoint geoPoint, long j) {
        if (g.c0) {
            g.OPEN_SDK.f(TAG, "onClickedItem" + geoPoint);
        }
        MapSurfaceView gLSurfaceView = BNOuterMapViewManager.getInstance().getGLSurfaceView();
        ArrayList<Overlay> arrayList = new ArrayList(gLSurfaceView.getOverlays());
        if (arrayList.isEmpty()) {
            return;
        }
        for (Overlay overlay : arrayList) {
            if (overlay.mType == 27 && geoPoint != null && (overlay instanceof ItemizedOverlay)) {
                ItemizedOverlay itemizedOverlay = (ItemizedOverlay) overlay;
                if (!itemizedOverlay.onTap(geoPoint, gLSurfaceView) && i != -1 && i2 != -1 && j == overlay.mLayerID) {
                    if (g.c0) {
                        g.OPEN_SDK.f(TAG, "onTap：geoPoint = " + geoPoint);
                    }
                    itemizedOverlay.onTap(i, i2, geoPoint);
                }
            }
        }
    }
}
