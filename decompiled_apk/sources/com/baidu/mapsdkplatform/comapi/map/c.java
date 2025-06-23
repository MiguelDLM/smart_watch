package com.baidu.mapsdkplatform.comapi.map;

import O0IoXXOx.XO;
import XIXIX.OOXIXo;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.mapapi.OpenLogUtil;
import com.baidu.mapapi.common.EnvironmentUtilities;
import com.baidu.mapapi.map.EncodePointType;
import com.baidu.mapapi.map.MapBaseIndoorMapInfo;
import com.baidu.mapapi.map.MapLanguage;
import com.baidu.mapapi.map.MapLayer;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.ParticleEffectType;
import com.baidu.mapapi.map.PoiTagType;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.platform.comapi.JNIInitializer;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.bmsdk.BmLayer;
import com.baidu.platform.comapi.map.LocationOverlay;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.platform.comapi.map.MapSurfaceView;
import com.baidu.platform.comapi.map.MapTextureView;
import com.baidu.platform.comapi.map.MapViewInterface;
import com.baidu.platform.comapi.map.OverlayLocationData;
import com.baidu.platform.comapi.map.ak;
import com.baidu.platform.comapi.map.al;
import com.baidu.platform.comapi.util.SysOSUtil;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressLint({"NewApi"})
/* loaded from: classes7.dex */
public class c implements com.baidu.mapsdkplatform.comjni.a.a.a {
    private static int E = 0;
    private static int F = 0;
    public static float d = 1096.0f;
    static long j = 0;
    private static final String l = "c";
    private BmLayer A;
    private k C;
    private l D;
    private int G;
    private int H;
    private MapController R;
    private LocationOverlay S;
    private com.baidu.platform.comapi.map.d T;
    AppBaseMap i;
    private boolean m;
    private boolean n;
    private ab v;
    private aa w;
    private List<b> x;
    private HashMap<MapLayer, b> y;
    private z z;

    /* renamed from: a, reason: collision with root package name */
    public float f6178a = 22.0f;
    public float b = 4.0f;
    public float c = 22.0f;
    private boolean o = true;
    private boolean p = false;
    private boolean q = false;
    private boolean r = false;
    private boolean s = true;
    boolean e = true;
    boolean f = true;
    boolean g = false;
    private boolean t = true;
    private boolean u = false;
    private boolean B = false;
    private boolean I = false;
    private boolean J = false;
    private long K = 0;
    private long L = 0;
    private boolean M = false;
    private Queue<a> N = new LinkedList();
    public MapStatusUpdate k = null;
    private boolean O = false;
    private boolean P = false;
    private boolean Q = false;
    private boolean U = false;
    public List<ak> h = new CopyOnWriteArrayList();

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public Bundle f6179a;

        public a(Bundle bundle) {
            this.f6179a = bundle;
        }
    }

    public c(Context context, MapTextureView mapTextureView, u uVar, String str, int i) {
        MapController mapController = new MapController();
        this.R = mapController;
        mapController.initAppBaseMap();
        a(this.R);
        mapTextureView.attachBaseMapController(this.R);
        this.i = this.R.getBaseMap();
        V();
        this.i = this.R.getBaseMap();
        a(uVar);
        this.R.getBaseMap().SetSDKLayerCallback(this);
        this.R.onResume();
    }

    private void T() {
        try {
            E = (int) (SysOSUtil.getInstance().getDensity() * 40.0f);
            F = (int) (SysOSUtil.getInstance().getDensity() * 40.0f);
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("x", E);
            jSONObject2.put("y", E);
            jSONObject2.put("hidetime", 1000);
            jSONArray.put(jSONObject2);
            jSONObject.put("dataset", jSONArray);
            com.baidu.platform.comapi.map.d dVar = this.T;
            if (dVar != null) {
                dVar.setData(jSONObject.toString());
                this.T.UpdateOverlay();
            }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    private void U() {
        if (!this.q && !this.n && !this.m && !this.r) {
            float f = this.c;
            this.f6178a = f;
            MapController mapController = this.R;
            if (mapController != null) {
                mapController.mMaxZoomLevel = f;
                return;
            }
            return;
        }
        if (this.f6178a > 20.0f) {
            this.f6178a = 20.0f;
            MapController mapController2 = this.R;
            if (mapController2 != null) {
                mapController2.mMaxZoomLevel = 20.0f;
            }
        }
        if (E().f6196a > 20.0f) {
            w E2 = E();
            E2.f6196a = 20.0f;
            a(E2);
        }
    }

    private void V() {
        this.x = new CopyOnWriteArrayList();
        this.y = new HashMap<>();
        z zVar = new z();
        this.z = zVar;
        a(zVar);
        this.y.put(MapLayer.MAP_LAYER_OVERLAY, this.z);
        p(false);
        AppBaseMap appBaseMap = this.i;
        if (appBaseMap != null) {
            appBaseMap.setDEMEnable(false);
        }
    }

    private void W() {
        MapController mapController = this.R;
        if (mapController != null && !mapController.mIsMoving) {
            mapController.mIsMoving = true;
            mapController.mIsAnimating = false;
            if (this.h != null) {
                w E2 = E();
                for (int i = 0; i < this.h.size(); i++) {
                    ak akVar = this.h.get(i);
                    if (akVar != null) {
                        akVar.a(E2);
                    }
                }
            }
        }
    }

    private boolean k(Bundle bundle) {
        AppBaseMap appBaseMap = this.i;
        if (appBaseMap == null) {
            return false;
        }
        return appBaseMap.addSDKTileData(bundle);
    }

    private boolean l(Bundle bundle) {
        AppBaseMap appBaseMap;
        if (bundle == null || (appBaseMap = this.i) == null) {
            return false;
        }
        boolean updateSDKTile = appBaseMap.updateSDKTile(bundle);
        if (updateSDKTile) {
            j(updateSDKTile);
            this.i.UpdateLayers(this.v.f6177a);
        }
        return updateSDKTile;
    }

    public void A(boolean z) {
        MapController mapController = this.R;
        if (mapController == null) {
            return;
        }
        mapController.setFlingEnable(z);
    }

    public void B(boolean z) {
        MapController mapController = this.R;
        if (mapController == null) {
            return;
        }
        mapController.set3DGestureEnable(z);
        this.t = z;
    }

    public void C(boolean z) {
        MapController mapController = this.R;
        if (mapController == null) {
            return;
        }
        mapController.setOverlookGestureEnable(z);
        this.s = z;
    }

    public boolean D() {
        AppBaseMap appBaseMap = this.i;
        if (appBaseMap != null) {
            return appBaseMap.LayersIsShow(appBaseMap.getLayerIDByTag("poiindoormarklayer"));
        }
        return false;
    }

    public void E(boolean z) {
        AppBaseMap appBaseMap = this.i;
        if (appBaseMap != null) {
            appBaseMap.ShowLayers(appBaseMap.getLayerIDByTag("poiindoormarklayer"), z);
        }
    }

    public LatLngBounds F() {
        AppBaseMap appBaseMap = this.i;
        if (appBaseMap == null) {
            return null;
        }
        Bundle mapStatusLimits = appBaseMap.getMapStatusLimits();
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        int i = mapStatusLimits.getInt("maxCoorx");
        int i2 = mapStatusLimits.getInt("minCoorx");
        builder.include(CoordUtil.mc2ll(new GeoPoint(mapStatusLimits.getInt("minCoory"), i))).include(CoordUtil.mc2ll(new GeoPoint(mapStatusLimits.getInt("maxCoory"), i2)));
        return builder.build();
    }

    public MapStatusUpdate G() {
        return this.k;
    }

    public int H() {
        AppBaseMap appBaseMap = this.i;
        if (appBaseMap != null) {
            appBaseMap.getFontSizeLevel();
            return 1;
        }
        return 1;
    }

    public int I() {
        return this.G;
    }

    public int J() {
        return this.H;
    }

    public w K() {
        AppBaseMap appBaseMap = this.i;
        if (appBaseMap == null) {
            return null;
        }
        Bundle GetMapStatus = appBaseMap.GetMapStatus(false);
        w wVar = new w();
        wVar.a(GetMapStatus);
        return wVar;
    }

    public double L() {
        return E().m;
    }

    public void M() {
    }

    public float[] N() {
        AppBaseMap appBaseMap = this.i;
        if (appBaseMap == null) {
            return null;
        }
        return appBaseMap.getProjectionMatrix();
    }

    public float[] O() {
        AppBaseMap appBaseMap = this.i;
        if (appBaseMap == null) {
            return null;
        }
        return appBaseMap.getViewMatrix();
    }

    public String P() {
        if (this.U) {
            return "";
        }
        return "GS(2022)460号";
    }

    public String Q() {
        if (this.U) {
            return "";
        }
        return "甲测资字11111342";
    }

    public String R() {
        if (this.U) {
            return "";
        }
        return "长地万方\nMapbox\nMapKin\n樂客LocalKing PalmCit\nESO DigitalGlobal spaceview\nOSRM Copyright ©2017, Project OSRMcontributors, all rights reserved\nHERE© 2019 HERE, all rights reserved\nOpenStreetMap© OpenStreetMapContributor;(OSMF)";
    }

    public int S() {
        AppBaseMap appBaseMap = this.i;
        if (appBaseMap == null) {
            return 0;
        }
        return appBaseMap.getMapLanguage();
    }

    public void a(long j2, long j3, long j4, long j5, boolean z) {
    }

    public void b(boolean z) {
        if (this.i == null) {
            return;
        }
        this.n = z;
        U();
        this.i.ShowSatelliteMap(this.n);
        MapController mapController = this.R;
        if (mapController != null) {
            if (z) {
                mapController.setMapTheme(2, new Bundle());
            } else {
                mapController.setMapTheme(1, new Bundle());
            }
        }
    }

    public void c(boolean z) {
        AppBaseMap appBaseMap = this.i;
        if (appBaseMap != null) {
            appBaseMap.setDEMEnable(z);
        }
    }

    public void d(boolean z) {
        this.u = z;
    }

    public void e(boolean z) {
        AppBaseMap appBaseMap = this.i;
        if (appBaseMap == null) {
            return;
        }
        this.i.ShowLayers(appBaseMap.getLayerIDByTag("opgrid"), z);
    }

    public void f(boolean z) {
        AppBaseMap appBaseMap = this.i;
        if (appBaseMap == null) {
            return;
        }
        if (z) {
            if (this.O) {
                return;
            }
            appBaseMap.SwitchLayer(appBaseMap.getLayerIDByTag("indoorlayer"), this.z.f6177a);
            this.O = true;
            return;
        }
        if (this.O) {
            appBaseMap.SwitchLayer(this.z.f6177a, appBaseMap.getLayerIDByTag("indoorlayer"));
            this.O = false;
        }
    }

    public void g(boolean z) {
        LocationOverlay locationOverlay;
        LocationOverlay locationOverlay2;
        AppBaseMap appBaseMap = this.i;
        if (appBaseMap == null) {
            return;
        }
        if (z) {
            if (this.P || (locationOverlay2 = this.S) == null) {
                return;
            }
            appBaseMap.SwitchLayer(this.z.f6177a, locationOverlay2.mLayerID);
            this.P = true;
            return;
        }
        if (!this.P || (locationOverlay = this.S) == null) {
            return;
        }
        appBaseMap.SwitchLayer(locationOverlay.mLayerID, this.z.f6177a);
        this.P = false;
    }

    public String h() {
        return null;
    }

    public void i(boolean z) {
        AppBaseMap appBaseMap = this.i;
        if (appBaseMap == null) {
            return;
        }
        if (this.T == null) {
            this.T = new com.baidu.platform.comapi.map.d(appBaseMap);
            MapViewInterface mapView = this.R.getMapView();
            if (mapView != null) {
                mapView.addOverlay(this.T);
                T();
            }
        }
        this.i.ShowLayers(this.T.mLayerID, z);
    }

    public boolean j() {
        return false;
    }

    public void m(boolean z) {
        AppBaseMap appBaseMap = this.i;
        if (appBaseMap == null) {
            return;
        }
        this.m = z;
        appBaseMap.ShowTrafficMap(z);
    }

    public void n(boolean z) {
        AppBaseMap appBaseMap = this.i;
        if (appBaseMap == null) {
            return;
        }
        appBaseMap.setDrawHouseHeightEnable(z);
    }

    public void o(boolean z) {
        AppBaseMap appBaseMap = this.i;
        if (appBaseMap == null) {
            return;
        }
        this.o = z;
        if (this.T == null) {
            this.T = new com.baidu.platform.comapi.map.d(appBaseMap);
            MapViewInterface mapView = this.R.getMapView();
            if (mapView != null) {
                mapView.addOverlay(this.T);
                T();
            }
        }
        this.i.ShowLayers(this.T.mLayerID, z);
    }

    public void p() {
        k kVar;
        AppBaseMap appBaseMap = this.i;
        if (appBaseMap == null || (kVar = this.C) == null) {
            return;
        }
        appBaseMap.stopHeatMapFrameAnimation(kVar.f6177a);
    }

    public void q() {
        k kVar;
        AppBaseMap appBaseMap = this.i;
        if (appBaseMap == null || (kVar = this.C) == null) {
            return;
        }
        appBaseMap.clearHeatMapLayerCache(kVar.f6177a);
        this.i.UpdateLayers(this.C.f6177a);
    }

    public MapBaseIndoorMapInfo r() {
        String GetFocusedBaseIndoorMapInfo;
        String str;
        String str2;
        String str3 = "";
        AppBaseMap appBaseMap = this.i;
        if (appBaseMap == null || (GetFocusedBaseIndoorMapInfo = appBaseMap.GetFocusedBaseIndoorMapInfo()) == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(1);
        try {
            JSONObject jSONObject = new JSONObject(GetFocusedBaseIndoorMapInfo);
            str2 = jSONObject.optString("focusindoorid");
            try {
                str3 = jSONObject.optString("curfloor");
                JSONArray optJSONArray = jSONObject.optJSONArray("floorlist");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        arrayList.add(optJSONArray.get(i).toString());
                    }
                }
            } catch (JSONException e) {
                e = e;
                str = str3;
                str3 = str2;
                e.printStackTrace();
                String str4 = str;
                str2 = str3;
                str3 = str4;
                return new MapBaseIndoorMapInfo(str2, str3, arrayList);
            }
        } catch (JSONException e2) {
            e = e2;
            str = "";
        }
        return new MapBaseIndoorMapInfo(str2, str3, arrayList);
    }

    public boolean s() {
        AppBaseMap appBaseMap = this.i;
        if (appBaseMap == null) {
            return false;
        }
        return appBaseMap.IsBaseIndoorMapMode();
    }

    public boolean t() {
        return this.o;
    }

    public void u() {
        LocationOverlay locationOverlay = this.S;
        if (locationOverlay != null) {
            locationOverlay.clearLocationLayerData(null);
        }
    }

    public boolean v() {
        return this.p;
    }

    public void w() {
        k kVar;
        AppBaseMap appBaseMap = this.i;
        if (appBaseMap == null || (kVar = this.C) == null) {
            return;
        }
        appBaseMap.UpdateLayers(kVar.f6177a);
    }

    public boolean x() {
        return this.e;
    }

    public boolean y() {
        return this.f;
    }

    public void z(boolean z) {
        MapController mapController = this.R;
        if (mapController == null) {
            return;
        }
        mapController.setEnlargeCenterWithDoubleClickEnable(z);
    }

    public void a(boolean z) {
        MapController mapController = this.R;
        if (mapController != null) {
            mapController.setSDKLayerBelowBmLayer(z);
        }
    }

    public void d() {
        if (this.i == null) {
            return;
        }
        synchronized (this.x) {
            try {
                for (b bVar : this.x) {
                    if (!(bVar instanceof com.baidu.mapsdkplatform.comapi.map.a) && !(bVar instanceof k)) {
                        this.i.ShowLayers(bVar.f6177a, true);
                    }
                    this.i.ShowLayers(bVar.f6177a, false);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.i.ShowTrafficMap(false);
    }

    public boolean h(boolean z) {
        AppBaseMap appBaseMap = this.i;
        if (appBaseMap == null) {
            return false;
        }
        long layerIDByTag = appBaseMap.getLayerIDByTag("carnavinode");
        long layerIDByTag2 = this.i.getLayerIDByTag(MapController.ANDROID_SDK_LAYER_TAG);
        if (layerIDByTag == 0 || layerIDByTag2 == 0) {
            return false;
        }
        if (z) {
            if (this.Q) {
                return false;
            }
            boolean SwitchLayer = this.i.SwitchLayer(layerIDByTag, layerIDByTag2);
            this.Q = true;
            return SwitchLayer;
        }
        if (!this.Q) {
            return false;
        }
        boolean SwitchLayer2 = this.i.SwitchLayer(layerIDByTag2, layerIDByTag);
        this.Q = false;
        return SwitchLayer2;
    }

    public void j(boolean z) {
        ab abVar;
        AppBaseMap appBaseMap = this.i;
        if (appBaseMap == null || (abVar = this.v) == null) {
            return;
        }
        appBaseMap.ShowLayers(abVar.f6177a, z);
    }

    public void t(boolean z) {
        MapController mapController = this.R;
        if (mapController == null) {
            return;
        }
        mapController.setCanTouchMove(z);
        this.e = z;
    }

    public void v(boolean z) {
        this.R.setInertialAnimation(z);
    }

    public void x(boolean z) {
        MapController mapController = this.R;
        if (mapController == null) {
            return;
        }
        mapController.setTwoTouchClickZoomEnabled(z);
    }

    public void y(boolean z) {
        MapController mapController = this.R;
        if (mapController == null) {
            return;
        }
        mapController.setDoubleClickMoveZoomEnable(z);
    }

    public boolean A() {
        return this.s;
    }

    public void D(boolean z) {
        AppBaseMap appBaseMap = this.i;
        if (appBaseMap != null) {
            appBaseMap.ShowLayers(appBaseMap.getLayerIDByTag("basepoi"), z);
        }
    }

    public w E() {
        AppBaseMap appBaseMap = this.i;
        if (appBaseMap == null) {
            return null;
        }
        Bundle GetMapStatus = appBaseMap.GetMapStatus();
        w wVar = new w();
        wVar.a(GetMapStatus);
        return wVar;
    }

    public void c() {
        if (this.i == null) {
            return;
        }
        synchronized (this.x) {
            try {
                Iterator<b> it = this.x.iterator();
                while (it.hasNext()) {
                    this.i.ShowLayers(it.next().f6177a, false);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void k(boolean z) {
        AppBaseMap appBaseMap = this.i;
        if (appBaseMap == null) {
            return;
        }
        appBaseMap.ShowLayers(appBaseMap.getLayerIDByTag("basemap"), z);
    }

    public void n() {
        AppBaseMap appBaseMap = this.i;
        if (appBaseMap == null) {
            return;
        }
        appBaseMap.ClearSDKLayer(this.z.f6177a);
    }

    public void p(boolean z) {
        AppBaseMap appBaseMap = this.i;
        if (appBaseMap == null) {
            return;
        }
        if (z) {
            this.f6178a = 22.0f;
            this.c = 22.0f;
            MapController mapController = this.R;
            if (mapController != null) {
                mapController.mMaxZoomLevel = 22.0f;
            }
        } else {
            this.f6178a = 22.0f;
            this.c = 22.0f;
            MapController mapController2 = this.R;
            if (mapController2 != null) {
                mapController2.mMaxZoomLevel = 22.0f;
            }
        }
        appBaseMap.ShowBaseIndoorMap(z);
    }

    public void s(boolean z) {
        if (this.i == null) {
            return;
        }
        if (this.C == null) {
            k kVar = new k();
            this.C = kVar;
            a(kVar);
        }
        this.q = z;
        this.i.ShowLayers(this.C.f6177a, z);
    }

    public void u(boolean z) {
        MapController mapController = this.R;
        if (mapController == null) {
            return;
        }
        mapController.setEnableZoom(z);
        this.f = z;
    }

    public void w(boolean z) {
        MapController mapController = this.R;
        if (mapController == null) {
            return;
        }
        mapController.setDoubleClickZoom(z);
    }

    public boolean z() {
        return this.t;
    }

    public void B() {
        MapController mapController = this.R;
        if (mapController == null || mapController.mIsMoving || mapController.mIsAnimating) {
            return;
        }
        mapController.mIsAnimating = true;
        if (this.h == null) {
            return;
        }
        w E2 = E();
        for (int i = 0; i < this.h.size(); i++) {
            ak akVar = this.h.get(i);
            if (akVar != null) {
                akVar.a(E2);
            }
        }
    }

    public boolean C() {
        AppBaseMap appBaseMap = this.i;
        if (appBaseMap != null) {
            return appBaseMap.LayersIsShow(appBaseMap.getLayerIDByTag("basepoi"));
        }
        return false;
    }

    public void a(BmLayer bmLayer) {
        this.A = bmLayer;
    }

    public void e() {
        ab abVar;
        AppBaseMap appBaseMap = this.i;
        if (appBaseMap == null || (abVar = this.v) == null) {
            return;
        }
        appBaseMap.RemoveLayer(abVar.f6177a);
        this.x.remove(this.v);
    }

    public void j(Bundle bundle) {
        k kVar;
        AppBaseMap appBaseMap = this.i;
        if (appBaseMap == null || (kVar = this.C) == null) {
            return;
        }
        appBaseMap.updateHeatMapData(kVar.f6177a, bundle);
    }

    public boolean m() {
        AppBaseMap appBaseMap = this.i;
        if (appBaseMap == null) {
            return false;
        }
        return appBaseMap.getDrawHouseHeightEnable();
    }

    public void q(boolean z) {
        if (this.i != null && S() != MapLanguage.ENGLISH.ordinal()) {
            this.U = z;
            this.i.setCustomStyleEnable(z);
            if (OpenLogUtil.isMapLogEnable()) {
                com.baidu.mapsdkplatform.comapi.commonutils.b.a().a("CustomMap setMapCustomEnable enable = " + z);
                return;
            }
            return;
        }
        Log.e("baidumapsdk", "Opening custom map is not support after setting English map");
    }

    private void a(MapController mapController) {
        if (!JNIInitializer.isResourceInited()) {
            synchronized (JNIInitializer.class) {
            }
        }
        Bundle bundle = new Bundle();
        bundle.putInt("animation", 1);
        bundle.putDouble("level", 12.0d);
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
        mapController.initMapResources(bundle);
    }

    public boolean k() {
        return this.n;
    }

    public void l(boolean z) {
        AppBaseMap appBaseMap = this.i;
        if (appBaseMap == null) {
            return;
        }
        this.r = z;
        appBaseMap.ShowHotMap(z, 0);
    }

    public void e(Bundle bundle) {
        if (bundle != null && bundle.containsKey("encodedPoints") && bundle.containsKey("encodePointType") && bundle.getInt("encodePointType") == EncodePointType.BUILDINGINFO.ordinal()) {
            a(bundle, bundle.getString("encodedPoints"));
        }
    }

    public float b() {
        MapController mapController = this.R;
        if (mapController != null) {
            return mapController.mMaxZoomLevel;
        }
        return this.f6178a;
    }

    public LatLngBounds c(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        int i = bundle.getInt("type");
        String string = bundle.getString("encodedPoints");
        LatLngBounds build = new LatLngBounds.Builder().build();
        if (string == null || string.length() <= 0 || i != h.prism.ordinal()) {
            return build;
        }
        ArrayList<LatLng> a2 = a(string);
        if (a2 == null || a2.size() <= 0) {
            return null;
        }
        int size = a2.size();
        double[] dArr = new double[size];
        double[] dArr2 = new double[size];
        for (int i2 = 0; i2 < size; i2++) {
            GeoPoint ll2mcDirect = CoordUtil.ll2mcDirect(a2.get(i2));
            dArr[i2] = ll2mcDirect.getLongitudeE6();
            dArr2[i2] = ll2mcDirect.getLatitudeE6();
        }
        Point point = new Point();
        GeoPoint ll2mcDirect2 = CoordUtil.ll2mcDirect(a2.get(0));
        Rect rect = new Rect((int) ll2mcDirect2.getLongitudeE6(), (int) ll2mcDirect2.getLatitudeE6(), (int) ll2mcDirect2.getLongitudeE6(), (int) ll2mcDirect2.getLatitudeE6());
        for (int i3 = 1; i3 < size; i3++) {
            int i4 = (int) dArr[i3];
            point.x = i4;
            point.y = (int) dArr2[i3];
            rect.set(Math.min(rect.left, i4), Math.max(rect.top, point.y), Math.max(rect.right, point.x), Math.min(rect.bottom, point.y));
        }
        GeoPoint geoPoint = new GeoPoint(rect.bottom, rect.left);
        GeoPoint geoPoint2 = new GeoPoint(rect.top, rect.right);
        LatLng mc2ll = CoordUtil.mc2ll(geoPoint);
        return new LatLngBounds.Builder().include(mc2ll).include(CoordUtil.mc2ll(geoPoint2)).build();
    }

    public boolean g() {
        return this.m;
    }

    public boolean i() {
        return this.r;
    }

    public boolean l() {
        AppBaseMap appBaseMap = this.i;
        if (appBaseMap == null) {
            return false;
        }
        return appBaseMap.LayersIsShow(appBaseMap.getLayerIDByTag("basemap"));
    }

    public boolean f() {
        AppBaseMap appBaseMap;
        ab abVar = this.v;
        if (abVar == null || (appBaseMap = this.i) == null) {
            return false;
        }
        return appBaseMap.cleanSDKTileDataCache(abVar.f6177a);
    }

    public void g(Bundle bundle) {
        if (this.i == null) {
            return;
        }
        h(bundle);
        this.i.removeOneOverlayItem(bundle);
    }

    public void i(Bundle bundle) {
        k kVar;
        AppBaseMap appBaseMap = this.i;
        if (appBaseMap == null || (kVar = this.C) == null) {
            return;
        }
        appBaseMap.initHeatMapData(kVar.f6177a, bundle);
    }

    public void o() {
        k kVar;
        AppBaseMap appBaseMap = this.i;
        if (appBaseMap == null || (kVar = this.C) == null) {
            return;
        }
        appBaseMap.startHeatMapFrameAnimation(kVar.f6177a);
    }

    public boolean b(ParticleEffectType particleEffectType) {
        AppBaseMap appBaseMap = this.i;
        if (appBaseMap != null) {
            return appBaseMap.showParticleEffectByType(particleEffectType.getType());
        }
        return false;
    }

    public void d(Bundle bundle) {
        if (this.i == null) {
            return;
        }
        h(bundle);
        e(bundle);
        this.i.addOneOverlayItem(bundle);
    }

    public void f(Bundle bundle) {
        if (this.i == null) {
            return;
        }
        h(bundle);
        e(bundle);
        this.i.updateOneOverlayItem(bundle);
    }

    public void h(Bundle bundle) {
        if (bundle.get(XO.f1160OOXIXo) != null) {
            Bundle bundle2 = (Bundle) bundle.get(XO.f1160OOXIXo);
            int i = bundle2.getInt("type");
            if (i == h.ground.ordinal()) {
                bundle2.putLong("layer_addr", this.z.f6177a);
                return;
            }
            if (i >= h.arc.ordinal()) {
                bundle2.putLong("layer_addr", this.z.f6177a);
                return;
            } else if (i == h.popup.ordinal()) {
                bundle2.putLong("layer_addr", this.z.f6177a);
                return;
            } else {
                bundle2.putLong("layer_addr", this.z.f6177a);
                return;
            }
        }
        int i2 = bundle.getInt("type");
        if (i2 == h.ground.ordinal()) {
            bundle.putLong("layer_addr", this.z.f6177a);
            return;
        }
        if (i2 >= h.arc.ordinal()) {
            bundle.putLong("layer_addr", this.z.f6177a);
        } else if (i2 == h.popup.ordinal()) {
            bundle.putLong("layer_addr", this.z.f6177a);
        } else {
            bundle.putLong("layer_addr", this.z.f6177a);
        }
    }

    public void e(int i) {
        if (this.i != null && (!this.U || i != MapLanguage.ENGLISH.ordinal())) {
            this.i.setMapLanguage(i);
        } else {
            Log.e("baidumapsdk", "Opening English map is not supported after setting custom map");
        }
    }

    public void b(Bundle bundle) {
        AppBaseMap appBaseMap = this.i;
        if (appBaseMap == null) {
            return;
        }
        appBaseMap.setMapBackgroundImage(bundle);
    }

    public void r(boolean z) {
        AppBaseMap appBaseMap = this.i;
        if (appBaseMap == null) {
            return;
        }
        this.p = z;
        LocationOverlay locationOverlay = this.S;
        if (locationOverlay == null) {
            MapViewInterface mapView = this.R.getMapView();
            if (mapView != null) {
                LocationOverlay locationOverlay2 = new LocationOverlay(this.i);
                this.S = locationOverlay2;
                mapView.addOverlay(locationOverlay2);
                return;
            }
            return;
        }
        appBaseMap.ShowLayers(locationOverlay.mLayerID, z);
    }

    public void b(int i) {
        AppBaseMap appBaseMap = this.i;
        if (appBaseMap == null) {
            return;
        }
        appBaseMap.setBackgroundColor(i);
    }

    public void d(int i) {
        AppBaseMap appBaseMap = this.i;
        if (appBaseMap != null) {
            appBaseMap.setFontSizeLevel(i);
        }
    }

    public GeoPoint b(int i, int i2) {
        return this.R.getMapView().getProjection().fromPixels(i, i2);
    }

    public void b(Bundle[] bundleArr) {
        AppBaseMap appBaseMap = this.i;
        if (appBaseMap == null) {
            return;
        }
        appBaseMap.removeOverlayItems(bundleArr);
    }

    public void b(String str, String str2) {
        AppBaseMap appBaseMap = this.i;
        if (appBaseMap == null) {
            return;
        }
        appBaseMap.initCustomStyle(str, str2);
    }

    public void b(Point point) {
        MapController mapController = this.R;
        if (mapController == null || point == null) {
            return;
        }
        mapController.setPointGesturesCenter(point);
    }

    private void a(String str, String str2, long j2) {
        try {
            Class<?> cls = Class.forName(str);
            cls.getMethod(str2, Long.TYPE).invoke(cls.newInstance(), Long.valueOf(j2));
        } catch (Exception unused) {
        }
    }

    public AppBaseMap a() {
        return this.i;
    }

    private void a(u uVar) {
        if (uVar == null) {
            uVar = new u();
        }
        boolean z = uVar.f;
        this.s = z;
        this.t = uVar.d;
        this.e = uVar.e;
        this.f = uVar.g;
        C(z);
        B(this.t);
        t(this.e);
        u(this.f);
        AppBaseMap appBaseMap = this.i;
        if (appBaseMap == null) {
            return;
        }
        appBaseMap.SetMapControlMode(t.DEFAULT.ordinal());
        boolean z2 = uVar.b;
        this.o = z2;
        if (z2) {
            if (this.T == null) {
                this.T = new com.baidu.platform.comapi.map.d(this.i);
                MapViewInterface mapView = this.R.getMapView();
                if (mapView != null) {
                    mapView.addOverlay(this.T);
                    T();
                }
            }
            this.i.ShowLayers(this.T.mLayerID, true);
            this.i.ResetImageRes();
        }
        int i = uVar.c;
        if (i == 2) {
            b(true);
        }
        if (i == 3) {
            if (C()) {
                D(false);
            }
            if (D()) {
                E(false);
            }
            k(false);
            p(false);
        }
    }

    public void c(int i) {
        k kVar;
        AppBaseMap appBaseMap = this.i;
        if (appBaseMap == null || (kVar = this.C) == null) {
            return;
        }
        appBaseMap.setHeatMapFrameAnimationIndex(kVar.f6177a, i);
    }

    public c(Context context, MapSurfaceView mapSurfaceView, u uVar, String str, int i) {
        MapController mapController = new MapController();
        this.R = mapController;
        mapController.initAppBaseMap();
        a(this.R);
        mapSurfaceView.setMapController(this.R);
        this.i = this.R.getBaseMap();
        a("com.baidu.platform.comapi.wnplatform.walkmap.WNaviBaiduMap", "setId", this.R.getMapId());
        V();
        a(uVar);
        this.R.getBaseMap().SetSDKLayerCallback(this);
        this.R.onResume();
    }

    public void a(int i, int i2) {
        this.G = i;
        this.H = i2;
    }

    public boolean a(Point point) {
        int i;
        int i2;
        if (point != null && this.i != null && (i = point.x) >= 0 && (i2 = point.y) >= 0) {
            E = i;
            F = i2;
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("x", E);
                jSONObject2.put("y", F);
                jSONObject2.put("hidetime", 1000);
                jSONArray.put(jSONObject2);
                jSONObject.put("dataset", jSONArray);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (this.T != null) {
                if (!TextUtils.isEmpty(jSONObject.toString())) {
                    this.T.setData(jSONObject.toString());
                }
                this.T.UpdateOverlay();
                return true;
            }
        }
        return false;
    }

    public void a(Bitmap bitmap) {
        Bundle bundle;
        if (this.i == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("type", 0);
            jSONObject2.put("x", E);
            jSONObject2.put("y", F);
            jSONObject2.put("hidetime", 1000);
            jSONArray.put(jSONObject2);
            jSONObject.put("dataset", jSONArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (bitmap == null) {
            bundle = null;
        } else {
            Bundle bundle2 = new Bundle();
            Bundle bundle3 = new Bundle();
            ByteBuffer allocate = ByteBuffer.allocate(bitmap.getWidth() * bitmap.getHeight() * 4);
            bitmap.copyPixelsToBuffer(allocate);
            bundle3.putByteArray("imgData", allocate.array());
            bundle3.putString("imgKey", bitmap.hashCode() + "_" + System.currentTimeMillis());
            bundle3.putInt("imgH", bitmap.getHeight());
            bundle3.putInt("imgW", bitmap.getWidth());
            bundle3.putInt("hasIcon", 1);
            bundle2.putBundle("iconData", bundle3);
            bundle = bundle2;
        }
        if (this.T != null) {
            if (!TextUtils.isEmpty(jSONObject.toString())) {
                this.T.setData(jSONObject.toString());
            }
            if (bundle != null) {
                this.T.setParam(bundle);
            }
            this.T.UpdateOverlay();
        }
    }

    public void a(float f, float f2) {
        this.f6178a = f;
        this.c = f;
        this.b = f2;
        MapController mapController = this.R;
        if (mapController != null) {
            mapController.setMaxAndMinZoomLevel(f, f2);
        }
        if (this.i != null) {
            Bundle bundle = new Bundle();
            bundle.putInt("maxLevel", (int) f);
            bundle.putInt("minLevel", (int) f2);
            this.i.setMaxAndMinZoomLevel(bundle);
        }
    }

    public void a(PoiTagType poiTagType, boolean z) {
        AppBaseMap appBaseMap = this.i;
        if (appBaseMap != null) {
            appBaseMap.setPoiTagEnable(poiTagType.ordinal(), z);
        }
    }

    public boolean a(PoiTagType poiTagType) {
        AppBaseMap appBaseMap = this.i;
        if (appBaseMap != null) {
            return appBaseMap.getPoiTagEnable(poiTagType.ordinal());
        }
        return false;
    }

    public void a(ParticleEffectType particleEffectType) {
        AppBaseMap appBaseMap = this.i;
        if (appBaseMap != null) {
            appBaseMap.closeParticleEffectByType(particleEffectType.getType());
        }
    }

    public boolean a(ParticleEffectType particleEffectType, Bundle bundle) {
        AppBaseMap appBaseMap = this.i;
        if (appBaseMap != null) {
            return appBaseMap.customParticleEffectByType(particleEffectType.getType(), bundle);
        }
        return false;
    }

    private void a(b bVar) {
        AppBaseMap appBaseMap = this.i;
        if (appBaseMap == null) {
            return;
        }
        bVar.f6177a = appBaseMap.AddLayer(bVar.c, bVar.d, bVar.b);
        synchronized (this.x) {
            this.x.add(bVar);
        }
    }

    public boolean a(MapLayer mapLayer, MapLayer mapLayer2) {
        if (this.i == null) {
            return false;
        }
        long a2 = a(mapLayer);
        long a3 = a(mapLayer2);
        if (a2 == -1 || a3 == -1) {
            return false;
        }
        boolean SwitchLayer = this.i.SwitchLayer(a2, a3);
        this.i.UpdateLayers(a3);
        return SwitchLayer;
    }

    public void a(MapLayer mapLayer, boolean z) {
        if (this.i == null) {
            return;
        }
        long a2 = a(mapLayer);
        if (a2 == -1) {
            return;
        }
        this.i.SetLayersClickable(a2, z);
    }

    private long a(MapLayer mapLayer) {
        if (this.i == null) {
            return -1L;
        }
        switch (d.f6180a[mapLayer.ordinal()]) {
            case 1:
                LocationOverlay locationOverlay = this.S;
                if (locationOverlay != null) {
                    return locationOverlay.mLayerID;
                }
                return -1L;
            case 2:
                z zVar = this.z;
                if (zVar != null) {
                    return zVar.f6177a;
                }
                return -1L;
            case 3:
                BmLayer bmLayer = this.A;
                if (bmLayer != null) {
                    return bmLayer.a();
                }
                return -1L;
            case 4:
                if (this.z != null) {
                    return this.C.f6177a;
                }
                return -1L;
            case 5:
                return this.i.getLayerIDByTag("poiindoormarklayer");
            case 6:
                return this.i.getLayerIDByTag("basepoi");
            default:
                return -1L;
        }
    }

    public void a(int i) {
        AppBaseMap appBaseMap = this.i;
        if (appBaseMap == null) {
            return;
        }
        appBaseMap.cleanCache(i, true);
    }

    public boolean a(Bundle bundle) {
        if (this.i == null) {
            return false;
        }
        ab abVar = new ab();
        this.v = abVar;
        long AddLayer = this.i.AddLayer(abVar.c, abVar.d, abVar.b);
        if (AddLayer != 0) {
            this.v.f6177a = AddLayer;
            synchronized (this.x) {
                this.x.add(this.v);
            }
            bundle.putLong("sdktileaddr", AddLayer);
            if (k(bundle) && l(bundle)) {
                return true;
            }
        }
        return false;
    }

    public void a(aa aaVar) {
        this.w = aaVar;
    }

    public Point a(GeoPoint geoPoint) {
        com.baidu.platform.comapi.basestruct.Point pixels = this.R.getMapView().getProjection().toPixels(geoPoint, null);
        if (pixels != null) {
            return new Point(pixels.getIntX(), pixels.getIntY());
        }
        return new Point();
    }

    public Point a(GeoPoint geoPoint, int i) {
        com.baidu.platform.comapi.basestruct.Point pixels = this.R.getMapView().getProjection().toPixels(geoPoint, i, null);
        if (pixels != null) {
            return new Point(pixels.getIntX(), pixels.getIntY());
        }
        return new Point();
    }

    public void a(Bundle bundle, String str) {
        ArrayList<LatLng> a2;
        if (bundle == null || str == null || str.length() <= 0 || (a2 = a(str)) == null || a2.size() <= 0) {
            return;
        }
        int size = a2.size();
        double[] dArr = new double[size];
        double[] dArr2 = new double[size];
        for (int i = 0; i < size; i++) {
            GeoPoint ll2mcDirect = CoordUtil.ll2mcDirect(a2.get(i));
            dArr[i] = ll2mcDirect.getLongitudeE6();
            dArr2[i] = ll2mcDirect.getLatitudeE6();
        }
        bundle.putDoubleArray("x_array", dArr);
        bundle.putDoubleArray("y_array", dArr2);
        GeoPoint ll2mcDirect2 = CoordUtil.ll2mcDirect(a2.get(0));
        bundle.putDouble("location_x", ll2mcDirect2.getLongitudeE6());
        bundle.putDouble("location_y", ll2mcDirect2.getLatitudeE6());
        if (bundle.getInt("has_dotted_stroke") == 1) {
            bundle.putDouble("dotted_stroke_location_x", ll2mcDirect2.getLongitudeE6());
            bundle.putDouble("dotted_stroke_location_y", ll2mcDirect2.getLatitudeE6());
        }
    }

    public ArrayList<LatLng> a(String str) {
        return new x().a(str);
    }

    public void a(Bundle[] bundleArr) {
        AppBaseMap appBaseMap = this.i;
        if (appBaseMap == null || bundleArr == null) {
            return;
        }
        appBaseMap.addOverlayItems(bundleArr, bundleArr.length);
    }

    public boolean a(String str, String str2) {
        AppBaseMap appBaseMap = this.i;
        if (appBaseMap == null) {
            return false;
        }
        return appBaseMap.SwitchBaseIndoorMapFloor(str, str2);
    }

    public float a(int i, int i2, int i3, int i4, int i5, int i6) {
        if (!this.R.mIsMapLoadFinish) {
            return 12.0f;
        }
        if (this.i == null) {
            return 0.0f;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("left", i);
        bundle.putInt("right", i3);
        bundle.putInt("bottom", i4);
        bundle.putInt("top", i2);
        bundle.putInt("hasHW", 1);
        bundle.putInt(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, i5);
        bundle.putInt("height", i6);
        Bundle bundle2 = new Bundle();
        bundle2.putInt("left", 0);
        bundle2.putInt("bottom", i6);
        bundle2.putInt("right", i5);
        bundle2.putInt("top", 0);
        return this.i.GetFZoomToBoundF(bundle, bundle2);
    }

    public void a(List<OverlayLocationData> list) {
        LocationOverlay locationOverlay = this.S;
        if (locationOverlay == null) {
            return;
        }
        locationOverlay.setLocationLayerData(list);
        this.S.UpdateOverlay();
    }

    public void a(String str, Bundle bundle) {
        LocationOverlay locationOverlay = this.S;
        if (locationOverlay == null) {
            return;
        }
        locationOverlay.setData(str);
        this.S.setParam(bundle);
        this.S.UpdateOverlay();
    }

    public void a(LatLng latLng) {
        MapController mapController = this.R;
        if (mapController == null || latLng == null) {
            return;
        }
        mapController.setLatLngGesturesCenter(latLng);
    }

    public void a(ak akVar) {
        if (akVar == null || this.h == null) {
            return;
        }
        this.R.registMapViewListener(akVar);
        this.h.add(akVar);
    }

    public void a(al alVar) {
        if (alVar == null) {
            return;
        }
        this.R.setOverlayListener(alVar);
    }

    public void a(l lVar) {
        this.D = lVar;
    }

    public void a(w wVar) {
        if (this.i == null || wVar == null) {
            return;
        }
        Bundle a2 = wVar.a(this);
        a2.putInt("animation", 0);
        a2.putInt("animatime", 0);
        W();
        this.i.SetMapStatus(a2);
    }

    public void a(w wVar, int i) {
        if (this.i == null || wVar == null) {
            return;
        }
        Bundle a2 = wVar.a(this);
        a2.putInt("animation", 1);
        a2.putInt("animatime", i);
        if (this.M) {
            this.N.add(new a(a2));
        } else {
            B();
            this.i.SetMapStatus(a2);
        }
    }

    public void a(LatLngBounds latLngBounds) {
        if (latLngBounds == null || this.i == null) {
            return;
        }
        LatLng latLng = latLngBounds.northeast;
        LatLng latLng2 = latLngBounds.southwest;
        GeoPoint ll2mc = CoordUtil.ll2mc(latLng);
        GeoPoint ll2mc2 = CoordUtil.ll2mc(latLng2);
        int longitudeE6 = (int) ll2mc.getLongitudeE6();
        int latitudeE6 = (int) ll2mc2.getLatitudeE6();
        int longitudeE62 = (int) ll2mc2.getLongitudeE6();
        int latitudeE62 = (int) ll2mc.getLatitudeE6();
        Bundle bundle = new Bundle();
        bundle.putInt("maxCoorx", longitudeE6);
        bundle.putInt("minCoory", latitudeE6);
        bundle.putInt("minCoorx", longitudeE62);
        bundle.putInt("maxCoory", latitudeE62);
        this.i.setMapStatusLimits(bundle);
    }

    public void a(MapStatusUpdate mapStatusUpdate) {
        this.k = mapStatusUpdate;
    }

    @Override // com.baidu.mapsdkplatform.comjni.a.a.a, com.baidu.platform.comjni.map.basemap.a
    public int a(Bundle bundle, long j2, int i) {
        k kVar = this.C;
        if (kVar != null && j2 == kVar.f6177a && this.D != null) {
            int i2 = bundle.getInt("zoom");
            bundle.putBundle(XO.f1160OOXIXo, this.D.a(bundle.getInt(MapBundleKey.MapObjKey.OBJ_SL_INDEX), i2));
            return this.C.e;
        }
        ab abVar = this.v;
        if (abVar == null || j2 != abVar.f6177a) {
            return 0;
        }
        bundle.putBundle(XO.f1160OOXIXo, this.w.a(bundle.getInt("x"), bundle.getInt("y"), bundle.getInt("zoom"), null));
        return this.v.e;
    }

    @Override // com.baidu.mapsdkplatform.comjni.a.a.a, com.baidu.platform.comjni.map.basemap.a
    public boolean a(long j2) {
        synchronized (this.x) {
            try {
                Iterator<b> it = this.x.iterator();
                while (it.hasNext()) {
                    if (it.next().f6177a == j2) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
