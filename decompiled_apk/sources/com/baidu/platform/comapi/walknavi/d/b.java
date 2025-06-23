package com.baidu.platform.comapi.walknavi.d;

import XIXIX.OOXIXo;
import android.content.Context;
import android.os.Bundle;
import com.baidu.mapapi.common.EnvironmentUtilities;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.platform.comapi.map.MapTextureView;
import com.baidu.platform.comapi.util.SysOSUtil;
import com.baidu.platform.comapi.wnplatform.walkmap.WNaviBaiduMap;

/* loaded from: classes8.dex */
public class b {
    private static MapController b;

    /* renamed from: a, reason: collision with root package name */
    private MapTextureView f9711a;

    public b(Context context) {
        this.f9711a = null;
        this.f9711a = new MapTextureView(context);
        if (b == null) {
            MapController mapController = new MapController();
            b = mapController;
            mapController.createByDuplicateAppBaseMap(WNaviBaiduMap.getId());
        }
        Bundle bundle = new Bundle();
        bundle.putDouble("level", 18.0d);
        bundle.putDouble("centerptx", 1.295815798E7d);
        bundle.putDouble("centerpty", 4825999.74d);
        bundle.putDouble("centerptz", OOXIXo.f3760XO);
        bundle.putInt("left", 0);
        bundle.putInt("top", 0);
        int screenHeight = SysOSUtil.getInstance().getScreenHeight();
        bundle.putInt("right", SysOSUtil.getInstance().getScreenWidth());
        bundle.putInt("bottom", screenHeight);
        bundle.putString("modulePath", SysOSUtil.getInstance().getOutputDirPath());
        bundle.putString("appSdcardPath", SysOSUtil.getInstance().getExternalFilesDir());
        bundle.putString("appCachePath", SysOSUtil.getInstance().getOutputCache());
        bundle.putString("appSecondCachePath", SysOSUtil.getInstance().getOutputCache());
        bundle.putInt("mapTmpMax", EnvironmentUtilities.getMapTmpStgMax());
        bundle.putInt("domTmpMax", EnvironmentUtilities.getDomTmpStgMax());
        bundle.putInt("itsTmpMax", EnvironmentUtilities.getItsTmpStgMax());
        bundle.putInt("ssgTmpMax", EnvironmentUtilities.getSsgTmpStgMax());
        MapController mapController2 = b;
        if (mapController2 != null) {
            mapController2.initMapResources(bundle);
            this.f9711a.attachBaseMapController(b);
        }
    }

    public MapTextureView a() {
        return this.f9711a;
    }

    public void b() {
        MapController mapController = b;
        if (mapController != null && mapController.getBaseMap() != null) {
            b.getBaseMap().ResetImageRes();
        }
    }
}
