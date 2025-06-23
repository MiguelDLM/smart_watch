package com.baidu.platform.comapi.map;

import XIXIX.OOXIXo;
import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import androidx.core.text.util.LocalePreferences;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.mapapi.OpenLogUtil;
import com.baidu.mapapi.map.OverlayUtil;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.JNIInitializer;
import com.baidu.platform.comapi.UIMsg;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.logstatistics.SDKLogFactory;
import com.baidu.platform.comapi.map.MapStatus;
import com.baidu.platform.comapi.util.SysOSUtil;
import com.baidu.platform.comjni.engine.MessageProxy;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.common.util.GmsVersion;
import com.iflytek.sparkchain.plugins.map.tools.MapPlugin;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class MapController {
    public static final String ANDROID_SDK_LAYER_TAG = "android_sdk";
    private static boolean C = true;
    public static final String CITY_AREA_TAG = "cityarea";
    public static final String COMPASS_LAYER_TAG = "compass";
    private static float D = 0.0f;
    public static final String DEFAULT_LAYER_TAG = "default";
    public static final String DYNAMIC_MAP_LAYER_TAG = "dynamicmap";
    private static float E = 0.0f;
    private static boolean F = false;
    public static final String FOOTSURFACE_LAYER_TAG = "footsurface";
    public static final String HEATMAP_LAYER_TAG = "heatmap";
    public static final String ITEM_LAYER_TAG = "item";
    public static final String ITSROUTE_LAYER_TAG = "itsroute";
    public static final String LOCAL_LIMIT_MAP_LAYER_TAG = "dynamiclimit";
    public static final String LOCATION_LAYER_TAG = "location";
    public static final int MSG_LONGLINK_CONNECT = 1;
    public static final int MSG_LONGLINK_DISCONNECT = 2;
    public static final String POISON_LAYER_TAG = "poison";
    public static final String POPUP_LAYER_TAG = "popup";
    public static final String RTPOPUP_LAYER_TAG = "rtpopup";
    public static final String RT_POPUP_LAYER_TAG = "rtpopup";
    public static final String SHARELOCATION_BUBBLE = "smshare";
    public static final String STREETPOPUP_LAYER_TAG = "streetpopup";
    public static final String STREETROUTE_LAYER_TAG = "streetroute";
    private static long X = 0;
    private static List<AppBaseMap> ad = new ArrayList();
    public static boolean isCompass = false;
    private static final String k = "MapController";
    public static boolean mLocIconOnScreen = true;
    public static boolean m_registered_SENSOR_ORIENTATION;
    private long T;
    private long ae;
    SoftReference<MapViewInterface> i;
    NaviMapViewListener j;
    private com.baidu.platform.comapi.map.b.d l;
    public boolean mHasMapObjDraging;
    public boolean mIsMapLoadFinish;
    public boolean mIsMapLoadStart;
    public al mOverlayListener;
    private MapFirstFrameCallback r;
    private Point t;
    private LatLng u;
    private Handler z;
    private boolean m = true;
    private boolean n = true;

    /* renamed from: a, reason: collision with root package name */
    int f9611a = 0;
    private int o = 1;
    private int p = 1;
    private boolean q = false;
    private boolean s = false;
    private boolean v = false;
    private boolean w = false;
    private AppBaseMap x = null;
    private long y = 0;
    public int nearlyRadius = 20;
    private boolean G = false;
    private boolean H = false;
    private boolean I = false;
    private boolean J = false;
    private a K = new a();
    private boolean L = true;
    private boolean M = false;
    private boolean N = true;
    private boolean O = true;
    private boolean P = false;
    private float Q = -1.0f;
    private float R = -1.0f;
    private float S = 0.0f;
    private boolean U = false;
    private boolean V = false;
    private boolean W = false;
    private boolean Y = true;
    private boolean Z = true;
    private boolean aa = true;
    private boolean ab = true;
    public boolean mIsInertialAnimation = true;
    private boolean ac = false;
    MapViewListener b = null;
    CaptureMapListener c = null;
    j d = null;
    an e = null;
    MapRenderModeChangeListener f = null;
    EngineMsgListener g = null;
    MapViewSurfaceListener h = null;
    public float mMaxZoomLevel = 22.0f;
    public float mMinZoomLevel = 4.0f;
    public boolean mIsMoving = false;
    public boolean mIsAnimating = false;
    private boolean af = false;
    private boolean ag = false;
    private com.baidu.platform.comapi.map.b.b ah = new com.baidu.platform.comapi.map.b.b(this);
    private MapControlMode ai = MapControlMode.DEFAULT;
    public List<ak> mListeners = new CopyOnWriteArrayList();
    private int A = SysOSUtil.getInstance().getScreenWidth();
    private int B = SysOSUtil.getInstance().getScreenHeight();

    /* loaded from: classes8.dex */
    public enum HeatMapType {
        CITY(0),
        SCENERY(1),
        CEMETERY(2);


        /* renamed from: a, reason: collision with root package name */
        private final int f9612a;

        HeatMapType(int i) {
            this.f9612a = i;
        }

        public int getId() {
            return this.f9612a;
        }
    }

    /* loaded from: classes8.dex */
    public enum MapControlMode {
        DEFAULT(1),
        INDOOR(2),
        STREET(3),
        STREET_WAITING(4);


        /* renamed from: a, reason: collision with root package name */
        private final int f9613a;

        MapControlMode(int i) {
            this.f9613a = i;
        }
    }

    /* loaded from: classes8.dex */
    public interface MapFirstFrameCallback {
        void onFirstFrameDrawing(MapController mapController);
    }

    /* loaded from: classes8.dex */
    public enum MapLayerType {
        DEFAULT(1),
        SATELLITE(2),
        INDOOR(3),
        STREET(5);


        /* renamed from: a, reason: collision with root package name */
        private final int f9614a;

        MapLayerType(int i) {
            this.f9614a = i;
        }
    }

    /* loaded from: classes8.dex */
    public enum MapSceneMode {
        DEFAULT(0),
        POI(1),
        ROUTE(2),
        INTERNAL(3),
        INDOOR(7);


        /* renamed from: a, reason: collision with root package name */
        private final int f9615a;

        MapSceneMode(int i) {
            this.f9615a = i;
        }

        public int getMode() {
            return this.f9615a;
        }
    }

    /* loaded from: classes8.dex */
    public enum MapStyleMode {
        DEFAULT(1),
        SEARCH_POI(2),
        SEARCH_ROUTE(3),
        NAV_DAY(4),
        NAV_NIGHT(5),
        WALK_DAY(6),
        INTERNAL(7),
        INTERNAL_SPECIAL(8),
        FOOT_PRINT(9);


        /* renamed from: a, reason: collision with root package name */
        private final int f9616a;

        MapStyleMode(int i) {
            this.f9616a = i;
        }

        public int getMode() {
            return this.f9616a;
        }
    }

    /* loaded from: classes8.dex */
    public enum RecommendPoiScene {
        BASE(0),
        INTERNATIONAL(1);

        public int value;

        RecommendPoiScene(int i) {
            this.value = i;
        }
    }

    /* loaded from: classes8.dex */
    public enum RecycleMemoryLevel {
        NORMAL(0),
        FULL(1);


        /* renamed from: a, reason: collision with root package name */
        private final int f9618a;

        RecycleMemoryLevel(int i) {
            this.f9618a = i;
        }

        public int getLevel() {
            return this.f9618a;
        }
    }

    /* loaded from: classes8.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        public boolean f9619a = false;
        float b = 0.0f;
        GeoPoint c;
        com.baidu.platform.comapi.basestruct.Point d;

        public a() {
        }

        public void a() {
            this.f9619a = false;
            this.b = 0.0f;
            this.c = null;
            this.d = null;
        }
    }

    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes8.dex */
    public class b extends com.baidu.platform.comapi.util.i {
        public b() {
            super(Looper.getMainLooper());
        }

        @Override // com.baidu.platform.comapi.util.i
        public void a(Message message) {
            boolean z;
            NaviMapViewListener naviMapViewListener;
            NaviMapViewListener naviMapViewListener2;
            al alVar;
            j jVar;
            CaptureMapListener captureMapListener;
            boolean z2;
            if (message.what == 4000 && (captureMapListener = MapController.this.c) != null) {
                if (message.arg2 == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                captureMapListener.onGetCaptureMap(z2);
            }
            if (message.what == 519 && (jVar = MapController.this.d) != null) {
                jVar.a();
            }
            if (message.what == 65304 && (alVar = MapController.this.mOverlayListener) != null) {
                alVar.a(message.arg2);
            }
            int i = message.what;
            if (i == 39) {
                if (((Long) message.obj).longValue() != MapController.this.y) {
                    return;
                }
                int i2 = message.arg1;
                if (i2 != 2) {
                    if (i2 != 100) {
                        if (i2 != 200) {
                            if (i2 != 300) {
                                MapRenderModeChangeListener mapRenderModeChangeListener = MapController.this.f;
                                if (mapRenderModeChangeListener != null) {
                                    mapRenderModeChangeListener.onMapRenderModeChange(i2);
                                }
                                if (MapController.this.isNaviMode() && (naviMapViewListener2 = MapController.this.j) != null) {
                                    naviMapViewListener2.onMapRenderModeChange(message.arg1);
                                }
                            } else if (MapController.this.r != null) {
                                MapController.this.r.onFirstFrameDrawing(MapController.this);
                            }
                        } else {
                            MapController.this.mIsMoving = false;
                        }
                    } else {
                        if (MapController.this.V) {
                            SoftReference<MapViewInterface> softReference = MapController.this.i;
                            if (softReference != null && softReference.get() != null) {
                                com.baidu.platform.comapi.util.j.b().execute(new l(this, MapController.this.getMapStatus()));
                            } else {
                                return;
                            }
                        }
                        if (MapController.this.W) {
                            MapController.this.W = false;
                        }
                        MapController.this.H = false;
                        MapController mapController = MapController.this;
                        mapController.mIsMoving = false;
                        mapController.mIsAnimating = false;
                        if (mapController.getMapViewListener() != null) {
                            MapController.this.getMapViewListener().onMapAnimationFinish();
                        }
                        if (MapController.this.isNaviMode() && (naviMapViewListener = MapController.this.j) != null) {
                            naviMapViewListener.onMapAnimationFinish();
                        }
                        MapController mapController2 = MapController.this;
                        if (mapController2.mListeners != null && mapController2.U) {
                            com.baidu.mapsdkplatform.comapi.map.w mapStatusInner = MapController.this.getMapStatusInner();
                            for (int i3 = 0; i3 < MapController.this.mListeners.size(); i3++) {
                                ak akVar = MapController.this.mListeners.get(i3);
                                if (akVar != null) {
                                    akVar.c(mapStatusInner);
                                }
                            }
                        }
                    }
                } else {
                    if (MapController.this.mListeners == null) {
                        return;
                    }
                    for (int i4 = 0; i4 < MapController.this.mListeners.size(); i4++) {
                        ak akVar2 = MapController.this.mListeners.get(i4);
                        if (akVar2 != null) {
                            akVar2.c();
                        }
                    }
                    MapController mapController3 = MapController.this;
                    mapController3.mIsMoving = false;
                    mapController3.mIsAnimating = false;
                }
                MapController mapController4 = MapController.this;
                if (!mapController4.mIsMapLoadFinish && mapController4.B > 0 && MapController.this.A > 0 && MapController.this.getMapView() != null && MapController.this.getMapView().getProjection() != null && MapController.this.getMapView().getProjection().fromPixels(0, 0) != null) {
                    MapController.this.mIsMapLoadFinish = true;
                    com.baidu.platform.comapi.util.j.a(new m(this), 0L);
                }
                if (MapController.this.mListeners != null) {
                    for (int i5 = 0; i5 < MapController.this.mListeners.size(); i5++) {
                        ak akVar3 = MapController.this.mListeners.get(i5);
                        if (akVar3 != null) {
                            akVar3.a();
                        }
                    }
                }
            } else if (i == 41) {
                if (((Long) message.obj).longValue() != MapController.this.y) {
                    return;
                }
                MapController mapController5 = MapController.this;
                if (mapController5.mListeners == null) {
                    return;
                }
                if (mapController5.mIsMoving || mapController5.mIsAnimating) {
                    com.baidu.mapsdkplatform.comapi.map.w mapStatusInner2 = mapController5.getMapStatusInner();
                    for (int i6 = 0; i6 < MapController.this.mListeners.size(); i6++) {
                        ak akVar4 = MapController.this.mListeners.get(i6);
                        if (akVar4 != null) {
                            akVar4.b(mapStatusInner2);
                        }
                    }
                }
            } else if (i == 2082) {
                int i7 = message.arg1;
                if (i7 == 1003) {
                    i7 = 0;
                    z = true;
                } else {
                    z = false;
                }
                if (OpenLogUtil.isMapLogEnable()) {
                    com.baidu.mapsdkplatform.comapi.commonutils.b.a().a("onMapRenderValidFrame isValid = " + z + "; errorCode = " + i7);
                }
                if (MapController.this.mListeners != null) {
                    for (int i8 = 0; i8 < MapController.this.mListeners.size(); i8++) {
                        ak akVar5 = MapController.this.mListeners.get(i8);
                        if (akVar5 != null) {
                            akVar5.a(z, i7);
                        }
                    }
                }
            }
            if (message.what == 512) {
                int i9 = message.arg1;
                if (MapController.this.getMapViewListener() != null) {
                    MapController.this.getMapViewListener().onClickedPopup(i9);
                }
            }
            if (message.what == 50) {
                if (OpenLogUtil.isMapLogEnable()) {
                    com.baidu.mapsdkplatform.comapi.commonutils.b.a().a("EngineMeassage IndoorMap msg.what = " + message.what + "; msg.arg1 = " + message.arg1);
                }
                MapController mapController6 = MapController.this;
                EngineMsgListener engineMsgListener = mapController6.g;
                if (engineMsgListener != null) {
                    int i10 = message.arg1;
                    if (i10 == 1) {
                        MapController.this.g.onEnterIndoorMapMode(mapController6.getFocusedBaseIndoorMapInfo());
                    } else if (i10 == 0) {
                        engineMsgListener.onExitIndoorMapMode();
                    }
                }
                MapController mapController7 = MapController.this;
                if (mapController7.mListeners == null) {
                    return;
                }
                IndoorMapInfo focusedBaseIndoorMapInfo = mapController7.getFocusedBaseIndoorMapInfo();
                for (int i11 = 0; i11 < MapController.this.mListeners.size(); i11++) {
                    ak akVar6 = MapController.this.mListeners.get(i11);
                    if (akVar6 != null) {
                        int i12 = message.arg1;
                        if (i12 == 0) {
                            akVar6.a(false);
                            MapController.this.mMaxZoomLevel = 22.0f;
                        } else if (i12 == 1) {
                            if (MapController.this.getMapStatus().level >= 18.0f && focusedBaseIndoorMapInfo != null) {
                                akVar6.a(true);
                                MapController.this.mMaxZoomLevel = 22.0f;
                            } else {
                                akVar6.a(false);
                                MapController.this.mMaxZoomLevel = 22.0f;
                            }
                        }
                    }
                }
            }
            if (message.what == 51) {
                MapController.this.setNetStatus(message.arg1);
            }
            if (message.what == 65301) {
                MapController mapController8 = MapController.this;
                if (mapController8.g != null) {
                    int i13 = message.arg1;
                    if (i13 == 1) {
                        mapController8.getMapBarData();
                    } else if (i13 == 0) {
                        com.baidu.platform.comapi.util.a.a().a(new com.baidu.platform.comapi.map.a());
                    }
                }
            }
        }
    }

    public MapController() {
        this.z = null;
        this.z = new b();
        c();
    }

    public static native int CleanAfterDBClick(long j, float f, float f2);

    public static int GetAdaptKeyCode(int i) {
        switch (i) {
            case 19:
                return 17;
            case 20:
                return 19;
            case 21:
                return 16;
            case 22:
                return 18;
            default:
                return 0;
        }
    }

    public static native int MapProc(long j, int i, int i2, int i3, int i4, int i5, double d, double d2, double d3, double d4);

    public static int getScaleDis(int i) {
        switch (i) {
            case 1:
                return 10000000;
            case 2:
                return GmsVersion.VERSION_LONGHORN;
            case 3:
                return 2000000;
            case 4:
                return 1000000;
            case 5:
                return 500000;
            case 6:
                return 200000;
            case 7:
                return 100000;
            case 8:
                return 50000;
            case 9:
                return 25000;
            case 10:
                return 20000;
            case 11:
                return 10000;
            case 12:
                return 5000;
            case 13:
                return 2000;
            case 14:
                return 1000;
            case 15:
                return 500;
            case 16:
                return 200;
            case 17:
                return 100;
            case 18:
                return 50;
            case 19:
                return 20;
            case 20:
                return 10;
            case 21:
                return 5;
            case 22:
                return 2;
            default:
                return 0;
        }
    }

    public float GetFZoomToBoundF(Bundle bundle, Bundle bundle2) {
        if (!a()) {
            return 0.0f;
        }
        return this.x.GetFZoomToBoundF(bundle, bundle2);
    }

    public int MapMsgProc(int i, int i2, int i3) {
        return MapMsgProc(i, i2, i3, 0, 0, OOXIXo.f3760XO, OOXIXo.f3760XO, OOXIXo.f3760XO, OOXIXo.f3760XO);
    }

    public void SetStyleMode(int i) {
        setMapScene(i);
    }

    public void addOneOverlayItem(Bundle bundle) {
        this.x.addOneOverlayItem(bundle);
    }

    public void addStreetCustomMarker(Bundle bundle, Bitmap bitmap) {
        if (!a()) {
            return;
        }
        this.x.AddStreetCustomMarker(bundle, bitmap);
    }

    public void animateTo(GeoPoint geoPoint, int i) {
        if (!a()) {
            return;
        }
        MapStatus mapStatus = getMapStatus();
        mapStatus.centerPtX = geoPoint.getLongitude();
        mapStatus.centerPtY = geoPoint.getLatitude();
        setMapStatusWithAnimation(mapStatus, i);
    }

    public boolean cleanCache(MapLayerType mapLayerType) {
        AppBaseMap appBaseMap = this.x;
        if (appBaseMap == null || !appBaseMap.cleanCache(mapLayerType.f9614a, false)) {
            return false;
        }
        return true;
    }

    public void clearUniversalLayer() {
        if (a()) {
            this.x.clearUniversalLayer();
        }
    }

    public boolean createByDuplicateAppBaseMap(long j) {
        AppBaseMap appBaseMap = new AppBaseMap();
        this.x = appBaseMap;
        if (appBaseMap.CreateByDuplicate(j)) {
            this.ag = true;
            this.y = this.x.GetId();
            List<AppBaseMap> list = ad;
            if (list != null) {
                list.add(this.x);
            }
            return true;
        }
        this.x = null;
        this.y = 0L;
        return false;
    }

    public void enablePOIAnimation(boolean z) {
        if (a()) {
            this.x.enablePOIAnimation(z);
        }
    }

    public void forceSetMapScene(int i) {
        this.o = i;
        if (a()) {
            this.x.setMapScene(this.o);
        }
    }

    public boolean forceSetMapThemeScene(int i, int i2, Bundle bundle) {
        this.p = i;
        this.o = i2;
        if (!a()) {
            return false;
        }
        return this.x.setMapThemeScene(i, i2, bundle);
    }

    public float getAdapterZoomUnitsEx() {
        if (!a()) {
            return 0.0f;
        }
        return this.x.GetAdapterZoomUnitsEx();
    }

    public AppBaseMap getBaseMap() {
        return this.x;
    }

    public int getCacheSize(MapLayerType mapLayerType) {
        AppBaseMap appBaseMap = this.x;
        if (appBaseMap == null) {
            return 0;
        }
        return appBaseMap.GetCacheSize(mapLayerType.f9614a);
    }

    public CaptureMapListener getCaptureMapListener() {
        return this.c;
    }

    public String getCityInfoByID(int i) {
        AppBaseMap appBaseMap = this.x;
        if (appBaseMap != null) {
            return appBaseMap.GetCityInfoByID(i);
        }
        return null;
    }

    public MapStatus getCurrentMapStatus() {
        return a(false);
    }

    public float getCurrentZoomLevel() {
        Bundle GetMapStatus;
        AppBaseMap appBaseMap = this.x;
        if (appBaseMap == null || (GetMapStatus = appBaseMap.GetMapStatus(false)) == null) {
            return 4.0f;
        }
        return (float) GetMapStatus.getDouble("level");
    }

    public IndoorMapInfo getFocusedBaseIndoorMapInfo() {
        String[] strArr;
        int[] iArr;
        if (!a()) {
            return null;
        }
        String GetFocusedBaseIndoorMapInfo = this.x.GetFocusedBaseIndoorMapInfo();
        if (!TextUtils.isEmpty(GetFocusedBaseIndoorMapInfo)) {
            try {
                JSONObject jSONObject = new JSONObject(GetFocusedBaseIndoorMapInfo);
                String optString = jSONObject.optString("focusindoorid");
                String optString2 = jSONObject.optString("curfloor");
                int optInt = jSONObject.optInt("idrtype");
                JSONArray optJSONArray = jSONObject.optJSONArray("floorlist");
                if (optJSONArray != null) {
                    strArr = new String[optJSONArray.length()];
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        arrayList.add(optJSONArray.getString(i));
                    }
                    arrayList.toArray(strArr);
                } else {
                    strArr = null;
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("floorattribute");
                if (optJSONArray2 != null) {
                    iArr = new int[optJSONArray2.length()];
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        iArr[i2] = optJSONArray2.optInt(i2);
                    }
                } else {
                    iArr = null;
                }
                return new IndoorMapInfo(optString, optString2, strArr, iArr, optInt, jSONObject.optInt("idrguide"), jSONObject.optString("idrsearch"));
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    public com.baidu.platform.comapi.map.b.d getGestureMonitor() {
        if (this.l == null) {
            this.l = new com.baidu.platform.comapi.map.b.d(this);
        }
        return this.l;
    }

    public Bundle getGestureOptInfoForLog() {
        boolean z;
        Bundle bundle = null;
        if (!this.K.f9619a) {
            return null;
        }
        MapStatus mapStatus = getMapStatus();
        int intX = this.K.d.getIntX();
        int intY = this.K.d.getIntY();
        boolean z2 = false;
        if (Math.sqrt((intX * intX) + (intY * intY)) > 100.0d) {
            z = true;
        } else {
            z = false;
        }
        if (this.K.b > 0.0f && Math.abs(mapStatus.level - r3) >= 0.5d) {
            z2 = true;
        }
        if (z || z2) {
            bundle = new Bundle();
            bundle.putDouble("pre_x", this.K.c.getLongitude());
            bundle.putDouble("pre_y", this.K.c.getLatitude());
            bundle.putFloat("pre_level", this.K.b);
        }
        this.K.a();
        return bundle;
    }

    public j getHideIndoorPopupListener() {
        return this.d;
    }

    public EngineMsgListener getIndoorMapListener() {
        return this.g;
    }

    public LatLng getLatLngGesturesCenter() {
        return this.u;
    }

    public List<ak> getListeners() {
        return this.mListeners;
    }

    public boolean getMapBarData() {
        String str;
        String str2;
        if (!a()) {
            return false;
        }
        Bundle bundle = new Bundle();
        this.x.getMapBarData(bundle);
        byte[] bArr = new byte[0];
        String str3 = null;
        if (bundle.containsKey("uid")) {
            str = bundle.getString("uid");
        } else {
            str = null;
        }
        if (bundle.containsKey("searchbound")) {
            str2 = bundle.getString("searchbound");
        } else {
            str2 = null;
        }
        if (bundle.containsKey("curfloor")) {
            str3 = bundle.getString("curfloor");
        }
        if (bundle.containsKey("barinfo")) {
            bArr = bundle.getByteArray("barinfo");
        }
        com.baidu.platform.comapi.util.a.a().a(new com.baidu.platform.comapi.map.b(str, str2, str3, bArr));
        return true;
    }

    public boolean getMapBarShowData() {
        if (!a()) {
            return false;
        }
        return this.x.getMapBarData(new Bundle());
    }

    public boolean getMapClickEnable() {
        return this.G;
    }

    public MapControlMode getMapControlMode() {
        return this.ai;
    }

    public long getMapId() {
        return this.y;
    }

    public MapRenderModeChangeListener getMapRenderModeChangeListener() {
        return this.f;
    }

    public int getMapScene() {
        if (!a()) {
            return 0;
        }
        return this.x.getMapScene();
    }

    public MapStatus getMapStatus() {
        return a(true);
    }

    public com.baidu.mapsdkplatform.comapi.map.w getMapStatusInner() {
        if (!a()) {
            return null;
        }
        Bundle GetMapStatus = this.x.GetMapStatus();
        com.baidu.mapsdkplatform.comapi.map.w wVar = new com.baidu.mapsdkplatform.comapi.map.w();
        wVar.a(GetMapStatus);
        return wVar;
    }

    public int getMapTheme() {
        if (!a()) {
            return 0;
        }
        return this.x.getMapTheme();
    }

    public MapViewInterface getMapView() {
        SoftReference<MapViewInterface> softReference = this.i;
        if (softReference != null) {
            return softReference.get();
        }
        return null;
    }

    public MapViewListener getMapViewListener() {
        return this.b;
    }

    public MapViewSurfaceListener getMapViewSurfaceListener() {
        return this.h;
    }

    public NaviMapViewListener getNaviMapViewListener() {
        return this.j;
    }

    public Point getPointGesturesCenter() {
        return this.t;
    }

    public String getProjectionPt(String str) {
        if (!a()) {
            return null;
        }
        return this.x.getProjectionPt(str);
    }

    public int getScaleLevel(int i, int i2) {
        if (!a()) {
            return 0;
        }
        return this.x.getScaleLevel(i, i2);
    }

    public int getSceneLayerScene() {
        return this.o;
    }

    public int getSceneLayerTheme() {
        return this.p;
    }

    public int getScreenHeight() {
        MapStatus.WinRound winRound = getMapStatus().winRound;
        int i = winRound.bottom - winRound.top;
        this.B = i;
        return i;
    }

    public int getScreenWidth() {
        MapStatus.WinRound winRound = getMapStatus().winRound;
        int i = winRound.right - winRound.left;
        this.A = i;
        return i;
    }

    public an getStreetArrowClickListener() {
        return this.e;
    }

    public int getVMPMapCityCode() {
        if (this.x != null) {
            Bundle bundle = new Bundle();
            bundle.putString("querytype", MapPlugin.MapSearchTool);
            this.x.GetVMPMapCityInfo(bundle);
            return bundle.getInt("code");
        }
        return 0;
    }

    public int getVMPMapCityItsInfo() {
        if (this.x != null) {
            Bundle bundle = new Bundle();
            bundle.putString("querytype", "its");
            this.x.GetVMPMapCityInfo(bundle);
            return bundle.getInt("rst");
        }
        return 0;
    }

    public int getVMPMapCityLevel() {
        if (this.x != null) {
            Bundle bundle = new Bundle();
            bundle.putString("querytype", MapPlugin.MapSearchTool);
            this.x.GetVMPMapCityInfo(bundle);
            return bundle.getInt("level");
        }
        return 0;
    }

    public int getVMPMapCitySatInfo() {
        if (this.x != null) {
            Bundle bundle = new Bundle();
            bundle.putString("querytype", LocalePreferences.FirstDayOfWeek.SATURDAY);
            this.x.GetVMPMapCityInfo(bundle);
            return bundle.getInt("rst");
        }
        return 0;
    }

    public float getZoomLevel() {
        Bundle GetMapStatus;
        AppBaseMap appBaseMap = this.x;
        if (appBaseMap == null || (GetMapStatus = appBaseMap.GetMapStatus()) == null) {
            return 4.0f;
        }
        return (float) GetMapStatus.getDouble("level");
    }

    public float getZoomToBound(Bundle bundle, int i, int i2) {
        if (!a()) {
            return 0.0f;
        }
        return this.x.GetZoomToBound(bundle, i, i2);
    }

    public float getZoomToBoundF(Bundle bundle) {
        if (!a()) {
            return 0.0f;
        }
        return this.x.GetZoomToBoundF(bundle);
    }

    public double getZoomUnitsInMeter() {
        Bundle GetMapStatus;
        AppBaseMap baseMap = getBaseMap();
        if (baseMap != null && (GetMapStatus = baseMap.GetMapStatus()) != null) {
            double d = GetMapStatus.getFloat("adapterZoomUnits");
            if (d > 1.0E-4d) {
                return d;
            }
        }
        return Math.pow(2.0d, 18.0f - getZoomLevel());
    }

    public void handleClick(MotionEvent motionEvent) {
        MapMsgProc(UIMsg.KEvent.V_WM_LBUTTONCLICK, 0, ((int) motionEvent.getX()) | (((int) motionEvent.getY()) << 16));
    }

    public void handleDoubleClickZoom(MotionEvent motionEvent) {
        if (!this.N || System.currentTimeMillis() - this.T < 100) {
            return;
        }
        mapStatusChangeStart();
        this.mIsAnimating = true;
        float y = motionEvent.getY();
        float f = this.R - y;
        MapMsgProc(8193, 3, (int) ((f / (getScreenHeight() / 9.0f)) * 10000.0f));
        this.S = f;
        this.R = y;
        com.baidu.platform.comapi.util.a.a().a(new com.baidu.platform.comapi.map.a.d());
        if (isNaviMode() && getNaviMapViewListener() != null) {
            getNaviMapViewListener().onAction(521, null);
        }
    }

    public void handleDoubleDownClick(MotionEvent motionEvent) {
        this.M = true;
        this.Q = motionEvent.getX();
        this.R = motionEvent.getY();
        this.T = System.currentTimeMillis();
        com.baidu.platform.comapi.util.a.a().a(new com.baidu.platform.comapi.map.a.d());
    }

    public void handleDoubleTouch(MotionEvent motionEvent) {
        SoftReference<MapViewInterface> softReference;
        GeoPoint fromPixels;
        float f;
        NaviMapViewListener naviMapViewListener;
        if (System.currentTimeMillis() - this.T > 150) {
            return;
        }
        if (isNaviMode() && (naviMapViewListener = this.j) != null) {
            naviMapViewListener.onAction(513, motionEvent);
            return;
        }
        if (this.L && (softReference = this.i) != null && softReference.get() != null && this.i.get().getProjection() != null) {
            MapStatus mapStatus = getMapStatus();
            float x = motionEvent.getX() - (mapStatus.winRound.left + (getScreenWidth() / 2));
            float y = (motionEvent.getY() - (mapStatus.winRound.top + (getScreenHeight() / 2))) * (-1.0f);
            float f2 = 0.0f;
            if (!isCompass && !this.P) {
                if (this.t != null) {
                    Projection projection = this.i.get().getProjection();
                    Point point = this.t;
                    fromPixels = projection.fromPixels(point.x, point.y);
                } else {
                    LatLng latLng = this.u;
                    if (latLng != null) {
                        fromPixels = CoordUtil.ll2mc(latLng);
                    } else {
                        fromPixels = this.i.get().getProjection().fromPixels((int) motionEvent.getX(), (int) motionEvent.getY());
                    }
                }
            } else {
                fromPixels = this.i.get().getProjection().fromPixels(mapStatus.winRound.left + (getScreenWidth() / 2), mapStatus.winRound.top + (getScreenHeight() / 2));
                x = 0.0f;
                y = 0.0f;
            }
            if (fromPixels != null) {
                f2 = (float) fromPixels.getLongitudeE6();
                f = (float) fromPixels.getLatitudeE6();
            } else {
                f = 0.0f;
            }
            this.V = true;
            Point point2 = new Point((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
            if (fromPixels != null && this.mListeners != null) {
                for (int i = 0; i < this.mListeners.size(); i++) {
                    ak akVar = this.mListeners.get(i);
                    if (akVar != null) {
                        akVar.b(fromPixels);
                        if (akVar.a(point2, getMapStatusInner())) {
                            return;
                        }
                    }
                }
            }
            getGestureMonitor().b(this.i.get().getZoomLevel() + 1.0f);
            mapStatusChangeStart();
            MapMsgProc(8195, ((int) motionEvent.getX()) | (((int) motionEvent.getY()) << 16), (this.A / 2) | ((this.B / 2) << 16), 0, 0, f2, f, x, y);
            X = System.currentTimeMillis();
            procGestureForLog(false, null);
        }
    }

    @SuppressLint({"FloatMath"})
    public boolean handleFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (!C || !this.ab || !this.n) {
            return false;
        }
        float sqrt = (float) ((((float) Math.sqrt((f * f) + (f2 * f2))) / (SysOSUtil.getInstance().getDensityDPI() / 310.0f)) * 1.3d);
        if (getMapControlMode() != MapControlMode.STREET && sqrt < 300.0f) {
            this.H = false;
            return false;
        }
        this.H = true;
        if (this.mListeners != null) {
            com.baidu.mapsdkplatform.comapi.map.w mapStatusInner = getMapStatusInner();
            for (int i = 0; i < this.mListeners.size(); i++) {
                ak akVar = this.mListeners.get(i);
                if (akVar != null && akVar.a(motionEvent2, f, f2, mapStatusInner)) {
                    this.af = false;
                    return false;
                }
            }
        }
        getGestureMonitor().a();
        mapStatusChangeStart();
        MapMsgProc(34, (int) sqrt, (((int) motionEvent2.getY()) << 16) | ((int) motionEvent2.getX()));
        if (getMapViewListener() != null) {
            com.baidu.platform.comapi.util.a.a().a(new com.baidu.platform.comapi.map.a.c());
        }
        this.af = false;
        if (this.mListeners != null) {
            for (int i2 = 0; i2 < this.mListeners.size(); i2++) {
                ak akVar2 = this.mListeners.get(i2);
                if (akVar2 != null) {
                    akVar2.a(motionEvent2);
                }
            }
        }
        return true;
    }

    public boolean handleKeyEvent(int i, KeyEvent keyEvent) {
        int GetAdaptKeyCode = GetAdaptKeyCode(i);
        if (GetAdaptKeyCode == 0) {
            return false;
        }
        MapMsgProc(1, GetAdaptKeyCode, 0);
        return true;
    }

    public void handleLongClick(MotionEvent motionEvent) {
        MapMsgProc(UIMsg.KEvent.V_WM_LBUTTONLONGCLICK, 0, ((int) motionEvent.getX()) | (((int) motionEvent.getY()) << 16));
    }

    public int handleMapModeGet() {
        return MapMsgProc(4113, 0, 0);
    }

    public boolean handlePopupClick(int i, int i2) {
        return false;
    }

    public void handleRightClick() {
        MapMsgProc(UIMsg.KEvent.V_WM_RBUTTONCLICK, 0, 0);
    }

    public void handleStreetscapeDoubleTouch(MotionEvent motionEvent) {
        float f;
        float f2;
        SoftReference<MapViewInterface> softReference = this.i;
        if (softReference != null && softReference.get() != null && this.i.get().getProjection() != null) {
            MapStatus mapStatus = getMapStatus();
            Projection projection = this.i.get().getProjection();
            MapStatus.WinRound winRound = mapStatus.winRound;
            GeoPoint fromPixels = projection.fromPixels(winRound.left + (this.A / 2), winRound.top + (this.B / 2));
            if (fromPixels != null) {
                f = (float) fromPixels.getLongitudeE6();
                f2 = (float) fromPixels.getLatitudeE6();
            } else {
                f = 0.0f;
                f2 = 0.0f;
            }
            MapMsgProc(8195, (((int) motionEvent.getY()) << 16) | ((int) motionEvent.getX()), ((this.B / 2) << 16) | (this.A / 2), 0, 0, f, f2, OOXIXo.f3760XO, OOXIXo.f3760XO);
        }
    }

    public boolean handleTouchEvent(MotionEvent motionEvent) {
        if (!a()) {
            return false;
        }
        if (!this.H) {
            this.ah.a(motionEvent);
        }
        if (motionEvent.getPointerCount() == 2) {
            this.m = true;
            C = false;
            b();
            procGestureForLog(false, null);
        }
        if (motionEvent.getAction() != 2 && this.M) {
            this.m = true;
            b();
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    return false;
                }
                if (this.M) {
                    handleDoubleClickZoom(motionEvent);
                } else if (this.ab) {
                    handleTouchMove(motionEvent);
                }
            } else {
                C = true;
                this.m = true;
                handleTouchUp(motionEvent);
            }
        } else {
            this.m = true;
            a(motionEvent);
        }
        if (this.mListeners != null) {
            for (int i = 0; i < this.mListeners.size(); i++) {
                ak akVar = this.mListeners.get(i);
                if (akVar != null) {
                    akVar.a(motionEvent);
                }
            }
        }
        return true;
    }

    public boolean handleTouchMove(MotionEvent motionEvent) {
        if (!C || System.currentTimeMillis() - X < 300) {
            return true;
        }
        if (this.mHasMapObjDraging) {
            if (getMapView() != null && getMapView().getProjection() != null) {
                GeoPoint fromPixels = getMapView().getProjection().fromPixels((int) motionEvent.getX(), (int) motionEvent.getY());
                if (this.mListeners != null) {
                    for (int i = 0; i < this.mListeners.size(); i++) {
                        ak akVar = this.mListeners.get(i);
                        if (akVar != null && fromPixels != null) {
                            akVar.d(fromPixels);
                        }
                    }
                }
            }
            return true;
        }
        float abs = Math.abs(motionEvent.getX() - D);
        float abs2 = Math.abs(motionEvent.getY() - E);
        double density = SysOSUtil.getInstance().getDensity();
        if (density > 1.5d) {
            density *= 1.5d;
        }
        float f = (float) density;
        if (F && abs / f <= 3.0f && abs2 / f <= 3.0f) {
            return true;
        }
        F = false;
        if (isCompass) {
            com.baidu.platform.comapi.util.a.a().a(new com.baidu.platform.comapi.map.a.a());
        }
        procGestureForLog(true, new com.baidu.platform.comapi.basestruct.Point(abs, abs2));
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        float x2 = D - motionEvent.getX();
        float y2 = E - motionEvent.getY();
        Point point = new Point((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
        Point point2 = new Point((int) (motionEvent.getRawX() + x2), (int) (motionEvent.getRawY() + y2));
        if (x < 0) {
            x = 0;
        }
        if (y < 0) {
            y = 0;
        }
        if (this.mListeners != null) {
            com.baidu.mapsdkplatform.comapi.map.w mapStatusInner = getMapStatusInner();
            for (int i2 = 0; i2 < this.mListeners.size(); i2++) {
                ak akVar2 = this.mListeners.get(i2);
                if (akVar2 != null && akVar2.b(point2, point, mapStatusInner)) {
                    this.H = false;
                    this.s = true;
                    this.af = true;
                    return false;
                }
            }
        }
        if (this.m) {
            getGestureMonitor().b();
            this.m = false;
        }
        mapStatusChangeStart();
        MapMsgProc(3, 0, (y << 16) | x);
        com.baidu.platform.comapi.util.a.a().a(new com.baidu.platform.comapi.map.a.b(false, true));
        this.H = false;
        this.s = true;
        this.af = true;
        return false;
    }

    public boolean handleTouchSingleClick(MotionEvent motionEvent) {
        NaviMapViewListener naviMapViewListener;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        this.w = c(x, y);
        if (d(x, y) || handlePopupClick(x, y)) {
            return true;
        }
        if ((OverlayUtil.isOverlayUpgrade() && a(x, y, this.w)) || a(1, x, y)) {
            return true;
        }
        if (this.G && b(x, y)) {
            return true;
        }
        if (isNaviMode() && (naviMapViewListener = this.j) != null) {
            naviMapViewListener.onAction(514, motionEvent);
        }
        if (getMapViewListener() != null) {
            getMapViewListener().onClickedBackground((int) motionEvent.getX(), (int) motionEvent.getY());
            return false;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x00cd, code lost:
    
        if (r8 >= r7.mMinZoomLevel) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00d5, code lost:
    
        if (r7.V != false) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00d9, code lost:
    
        if (r7.W != false) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00dd, code lost:
    
        if (r7.mIsAnimating != false) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00e1, code lost:
    
        if (r7.mListeners == null) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00e3, code lost:
    
        r8 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00ea, code lost:
    
        if (r8 >= r7.mListeners.size()) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00ec, code lost:
    
        r1 = r7.mListeners.get(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00f4, code lost:
    
        if (r1 == null) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00f6, code lost:
    
        r1.c(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00f9, code lost:
    
        r8 = r8 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00fc, code lost:
    
        r7.mIsMoving = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x00d1, code lost:
    
        if (r7.af != false) goto L57;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean handleTouchUp(android.view.MotionEvent r8) {
        /*
            Method dump skipped, instructions count: 283
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.platform.comapi.map.MapController.handleTouchUp(android.view.MotionEvent):boolean");
    }

    public boolean handleTrackballEvent(MotionEvent motionEvent) {
        int i;
        if (!a()) {
            return false;
        }
        if (motionEvent.getAction() == 2) {
            float rawX = motionEvent.getRawX();
            float rawY = motionEvent.getRawY();
            if (rawX > 0.0f) {
                i = 18;
            } else if (rawX < 0.0f) {
                i = 16;
            } else {
                i = 0;
            }
            if (rawY > 0.0f) {
                i = 19;
            } else if (rawY < 0.0f) {
                i = 17;
            }
            if (i == 0) {
                return false;
            }
            MapMsgProc(1, i, 0);
        }
        return true;
    }

    public boolean handleZoomTo(int i) {
        if (i != 0) {
            if (i == 1) {
                MapMsgProc(4096, -1, 0);
            }
        } else {
            MapMsgProc(4097, -1, 0);
        }
        return false;
    }

    public boolean importMapTheme(int i) {
        if (!a()) {
            return false;
        }
        return this.x.importMapTheme(i);
    }

    public void initAppBaseMap() {
        if (ad.size() == 0) {
            initBaseMap();
        } else {
            createByDuplicateAppBaseMap(ad.get(0).GetId());
        }
    }

    public void initBaseMap() {
        AppBaseMap appBaseMap = new AppBaseMap();
        this.x = appBaseMap;
        appBaseMap.Create();
        this.y = this.x.GetId();
        List<AppBaseMap> list = ad;
        if (list != null) {
            list.add(this.x);
        }
    }

    public void initMapResources(Bundle bundle) {
        boolean z;
        String str;
        if (!this.I && bundle != null && this.x != null) {
            if (SysOSUtil.getInstance().getDensityDPI() >= 180) {
                z = true;
            } else {
                z = false;
            }
            this.nearlyRadius = (SysOSUtil.getInstance().getDensityDPI() * 25) / 240;
            String string = bundle.getString("modulePath");
            String string2 = bundle.getString("appSdcardPath");
            String string3 = bundle.getString("appCachePath");
            String string4 = bundle.getString("appSecondCachePath");
            String string5 = bundle.getString("engineErrorPath");
            int i = bundle.getInt("mapTmpMax");
            int i2 = bundle.getInt("domTmpMax");
            int i3 = bundle.getInt("itsTmpMax");
            int i4 = bundle.getInt("ssgTmpMax");
            if (z) {
                str = "/h/";
            } else {
                str = "/l/";
            }
            String str2 = string + "/cfg";
            String str3 = string2 + "/vmp";
            String str4 = str2 + "/a/";
            String str5 = str3 + str;
            String str6 = str3 + str;
            String str7 = string3 + "/tmp/";
            String str8 = string4 + "/tmp/";
            Bundle bundle2 = new Bundle();
            bundle2.putString("cfgdataroot", str4);
            bundle2.putString("vmpdataroot", str5);
            bundle2.putString("tmpdataroot", str7);
            bundle2.putString("tmpdatapast", str8);
            bundle2.putString("importroot", str6);
            bundle2.putString("stylerespath", str2 + "/a/");
            if (string5 != null && string5.length() > 0) {
                bundle2.putString("engineerrorpath", string5);
            }
            if (this.A <= 0 || this.B <= 0) {
                this.A = SysOSUtil.getInstance().getScreenWidth();
                this.B = SysOSUtil.getInstance().getScreenWidth();
            }
            if (OpenLogUtil.isMapLogEnable()) {
                com.baidu.mapsdkplatform.comapi.commonutils.b.a().a("MapControl init screenWidth: " + this.A + "; screenHeight: " + this.B);
            }
            bundle2.putInt("cx", this.A);
            bundle2.putInt("cy", this.B);
            bundle2.putInt("ndpi", SysOSUtil.getInstance().getDensityDPI());
            bundle2.putFloat("fdpi", SysOSUtil.getInstance().getDensityDPI());
            bundle2.putInt("maptmpmax", i);
            bundle2.putInt("domtmpmax", i2);
            bundle2.putInt("itstmpmax", i3);
            bundle2.putInt("ssgtmpmax", i4);
            bundle2.putInt("pathchange", 0);
            if (bundle.containsKey("maptheme")) {
                bundle2.putInt("maptheme", bundle.getInt("maptheme"));
            }
            if (bundle.containsKey("mapscene")) {
                bundle2.putInt("mapscene", bundle.getInt("mapscene"));
            }
            if (bundle.containsKey("fontsizelevel")) {
                bundle2.putInt("fontsizelevel", bundle.getInt("fontsizelevel"));
            }
            if (!JNIInitializer.isUserTest()) {
                JNIInitializer.isDebug();
            }
            if (!this.x.initWithOptions(bundle2, false)) {
                Log.e(k, "MapControl init fail!");
                if (OpenLogUtil.isMapLogEnable()) {
                    com.baidu.mapsdkplatform.comapi.commonutils.b.a().a("MapControl init fail");
                }
                HashMap hashMap = new HashMap();
                hashMap.put(ExifInterface.LONGITUDE_EAST, "0");
                SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel("B", "M", "0.2", hashMap);
                return;
            }
            this.x.SetMapStatus(bundle);
            this.I = true;
        }
    }

    public boolean is3DGestureEnable() {
        return this.Y;
    }

    public boolean isBaseIndoorMapMode() {
        if (!a()) {
            return false;
        }
        return this.x.IsBaseIndoorMapMode();
    }

    public boolean isCanTouchMove() {
        return this.ab;
    }

    public boolean isDoubleClickMoveZoom() {
        return this.N;
    }

    public boolean isDoubleClickZoom() {
        return this.L;
    }

    public boolean isDuplicate() {
        return this.ag;
    }

    public boolean isEnableDMoveZoom() {
        return this.M;
    }

    public boolean isEnableIndoor3D() {
        if (a()) {
            return this.x.isEnableIndoor3D();
        }
        return true;
    }

    public boolean isEnableZoom() {
        return this.aa;
    }

    public boolean isEnlargeCenterWithDoubleClickEnabled() {
        return this.P;
    }

    public boolean isFlingEnabled() {
        return this.n;
    }

    public boolean isInFocusBarBorder(GeoPoint geoPoint, double d) {
        if (!a() || geoPoint == null || !this.x.IsPointInFocusBarBorder(geoPoint.getLongitude(), geoPoint.getLatitude(), d)) {
            return false;
        }
        return true;
    }

    public boolean isInFocusIndoorBuilding(GeoPoint geoPoint) {
        if (!a() || geoPoint == null || !this.x.IsPointInFocusIDRBorder(geoPoint.getLongitude(), geoPoint.getLatitude())) {
            return false;
        }
        return true;
    }

    public boolean isMapAnimationRunning() {
        if (!a()) {
            return false;
        }
        return this.x.isAnimationRunning();
    }

    public boolean isMovedMap() {
        return this.s;
    }

    public boolean isNaviMode() {
        if (a()) {
            return this.x.isNaviMode();
        }
        return false;
    }

    public boolean isOverlookGestureEnable() {
        return this.Z;
    }

    public boolean isPressedOnPopup(int i, int i2) {
        return false;
    }

    public boolean isStreetArrowShown() {
        if (!a()) {
            return false;
        }
        return this.x.IsStreetArrowShown();
    }

    public boolean isStreetCustomMarkerShown() {
        if (!a()) {
            return false;
        }
        return this.x.IsStreetCustomMarkerShown();
    }

    public boolean isStreetPOIMarkerShown() {
        if (!a()) {
            return false;
        }
        return this.x.IsStreetPOIMarkerShown();
    }

    public boolean isStreetRoadClickable() {
        if (!a()) {
            return false;
        }
        return this.x.IsStreetRoadClickable();
    }

    public boolean isTwoTouchClickZoomEnabled() {
        return this.O;
    }

    public void mapStatusChangeStart() {
        if (this.mIsMoving) {
            return;
        }
        this.mIsMoving = true;
        this.mIsAnimating = false;
        if (this.mListeners != null) {
            com.baidu.mapsdkplatform.comapi.map.w mapStatusInner = getMapStatusInner();
            for (int i = 0; i < this.mListeners.size(); i++) {
                ak akVar = this.mListeners.get(i);
                if (akVar != null) {
                    akVar.a(mapStatusInner);
                }
            }
        }
    }

    public void onPause() {
        if (a()) {
            this.x.OnPause();
        }
    }

    public void onResume() {
        if (a()) {
            this.x.OnResume();
        }
    }

    public void procGestureForLog(boolean z, com.baidu.platform.comapi.basestruct.Point point) {
        if (!this.K.f9619a) {
            MapStatus mapStatus = getMapStatus();
            a aVar = this.K;
            aVar.f9619a = true;
            aVar.b = mapStatus.level;
            aVar.c = new GeoPoint(mapStatus.centerPtX, mapStatus.centerPtY);
            this.K.d = new com.baidu.platform.comapi.basestruct.Point(0, 0);
        }
        if (z) {
            int abs = Math.abs(point.getIntX());
            int abs2 = Math.abs(point.getIntY());
            com.baidu.platform.comapi.basestruct.Point point2 = this.K.d;
            point2.setIntX(point2.getIntX() + abs);
            com.baidu.platform.comapi.basestruct.Point point3 = this.K.d;
            point3.setIntY(point3.getIntY() + abs2);
        }
    }

    public void recycleMemory(RecycleMemoryLevel recycleMemoryLevel) {
        if (a()) {
            this.x.recycleMemory(recycleMemoryLevel.getLevel());
        }
    }

    public void registMapViewListener(ak akVar) {
        List<ak> list;
        if (akVar != null && (list = this.mListeners) != null) {
            list.add(akVar);
        }
    }

    public void removeOneOverlayItem(Bundle bundle) {
        this.x.removeOneOverlayItem(bundle);
    }

    public void removeStreetAllCustomMarker() {
        if (!a()) {
            return;
        }
        this.x.RemoveStreetAllCustomMarker();
    }

    public void removeStreetCustomMarker(String str) {
        if (!a()) {
            return;
        }
        this.x.RemoveStreetCustomMaker(str);
    }

    public void saveScreenToLocal(String str, int i, int i2, int i3, int i4) {
        if (!a() || TextUtils.isEmpty(str)) {
            return;
        }
        String str2 = null;
        if (i3 != 0 && i4 != 0) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("x", i);
                jSONObject.put("y", i2);
                jSONObject.put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, i3);
                jSONObject.put("height", i4);
                str2 = jSONObject.toString();
            } catch (Exception unused) {
            }
        }
        this.x.SaveScreenToLocal(str, str2);
    }

    public void scrollBy(int i, int i2) {
        if (i == 0 && i2 == 0) {
            return;
        }
        MapStatus.WinRound winRound = getMapStatus().winRound;
        a(winRound.left + (this.A / 2) + i, winRound.top + (this.B / 2) + i2);
    }

    public void set3DGestureEnable(boolean z) {
        this.Y = z;
    }

    public void setActingTwoClickZoom(boolean z) {
        this.W = z;
    }

    public void setAllStreetCustomMarkerVisibility(boolean z) {
        if (!a()) {
            return;
        }
        this.x.SetAllStreetCustomMarkerVisibility(z);
    }

    public void setCanTouchMove(boolean z) {
        this.ab = z;
    }

    public void setCaptureMapListener(CaptureMapListener captureMapListener) {
        this.c = captureMapListener;
    }

    public void setDoubleClickMoveZoomEnable(boolean z) {
        this.N = z;
    }

    public void setDoubleClickZoom(boolean z) {
        this.L = z;
    }

    public void setEnableIndoor3D(boolean z) {
        if (a()) {
            this.x.setEnableIndoor3D(z);
        }
    }

    public void setEnableZoom(boolean z) {
        this.aa = z;
    }

    public void setEngineMsgListener(EngineMsgListener engineMsgListener) {
        this.g = engineMsgListener;
    }

    public void setEnlargeCenterWithDoubleClickEnable(boolean z) {
        this.P = z;
    }

    public void setFlingEnable(boolean z) {
        this.n = z;
    }

    public void setHideIndoorPopupListener(j jVar) {
        this.d = jVar;
    }

    public void setInertialAnimation(boolean z) {
        this.mIsInertialAnimation = z;
        this.V = z;
        this.W = z;
    }

    public void setLatLngGesturesCenter(LatLng latLng) {
        this.u = latLng;
    }

    public boolean setLayerSceneMode(long j, MapSceneMode mapSceneMode) {
        if (!a()) {
            return false;
        }
        return this.x.SetLayerSceneMode(j, mapSceneMode.getMode());
    }

    public void setMapClickEnable(boolean z) {
        this.G = z;
    }

    public int setMapControlMode(MapControlMode mapControlMode) {
        if (!a()) {
            return -1;
        }
        this.ai = mapControlMode;
        return this.x.SetMapControlMode(mapControlMode.f9613a);
    }

    public void setMapFirstFrameCallback(MapFirstFrameCallback mapFirstFrameCallback) {
        this.r = mapFirstFrameCallback;
    }

    public void setMapRenderModeChangeListener(MapRenderModeChangeListener mapRenderModeChangeListener) {
        this.f = mapRenderModeChangeListener;
    }

    public void setMapScene(int i) {
        if (i == getMapScene()) {
            return;
        }
        this.o = i;
        if (a()) {
            this.x.setMapScene(this.o);
        }
    }

    public void setMapStatus(MapStatus mapStatus, boolean z) {
        if (!a() || mapStatus == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putDouble("level", mapStatus.level);
        bundle.putDouble("rotation", mapStatus.rotation);
        bundle.putDouble("overlooking", mapStatus.overlooking);
        bundle.putDouble("centerptx", mapStatus.centerPtX);
        bundle.putDouble("centerpty", mapStatus.centerPtY);
        bundle.putDouble("centerptz", mapStatus.centerPtZ);
        bundle.putInt("left", mapStatus.winRound.left);
        bundle.putInt("right", mapStatus.winRound.right);
        bundle.putInt("top", mapStatus.winRound.top);
        bundle.putInt("bottom", mapStatus.winRound.bottom);
        bundle.putLong("gleft", mapStatus.geoRound.left);
        bundle.putLong("gbottom", mapStatus.geoRound.bottom);
        bundle.putLong("gtop", mapStatus.geoRound.top);
        bundle.putLong("gright", mapStatus.geoRound.right);
        bundle.putFloat("yoffset", mapStatus.yOffset);
        bundle.putFloat("xoffset", mapStatus.xOffset);
        bundle.putInt("animation", 0);
        bundle.putInt("animatime", 0);
        bundle.putInt("bfpp", mapStatus.bfpp ? 1 : 0);
        bundle.putString("panoid", mapStatus.panoId);
        bundle.putInt("autolink", z ? 1 : 0);
        bundle.putFloat("siangle", mapStatus.streetIndicateAngle);
        bundle.putInt("isbirdeye", mapStatus.isBirdEye ? 1 : 0);
        bundle.putInt("ssext", mapStatus.streetExt);
        this.x.SetMapStatus(bundle);
    }

    public void setMapStatusWithAnimation(MapStatus mapStatus, int i, boolean z) {
        if (!a() || this.x == null || mapStatus == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putDouble("level", mapStatus.level);
        bundle.putDouble("rotation", mapStatus.rotation);
        bundle.putDouble("overlooking", mapStatus.overlooking);
        bundle.putDouble("centerptx", mapStatus.centerPtX);
        bundle.putDouble("centerpty", mapStatus.centerPtY);
        bundle.putDouble("centerptz", mapStatus.centerPtZ);
        bundle.putInt("left", mapStatus.winRound.left);
        bundle.putInt("right", mapStatus.winRound.right);
        bundle.putInt("top", mapStatus.winRound.top);
        bundle.putInt("bottom", mapStatus.winRound.bottom);
        bundle.putLong("gleft", mapStatus.geoRound.left);
        bundle.putLong("gright", mapStatus.geoRound.right);
        bundle.putLong("gbottom", mapStatus.geoRound.bottom);
        bundle.putLong("gtop", mapStatus.geoRound.top);
        bundle.putFloat("xoffset", mapStatus.xOffset);
        bundle.putFloat("yoffset", mapStatus.yOffset);
        bundle.putInt("animation", 1);
        bundle.putInt("animatime", i);
        bundle.putInt("bfpp", mapStatus.bfpp ? 1 : 0);
        bundle.putString("panoid", mapStatus.panoId);
        bundle.putInt("autolink", z ? 1 : 0);
        bundle.putFloat("siangle", mapStatus.streetIndicateAngle);
        bundle.putInt("isbirdeye", mapStatus.isBirdEye ? 1 : 0);
        bundle.putInt("ssext", mapStatus.streetExt);
        bundle.putFloat("roadOffsetX", mapStatus.roadOffsetX);
        bundle.putFloat("roadOffsetY", mapStatus.roadOffsetY);
        this.x.SetMapStatus(bundle);
    }

    public boolean setMapTheme(int i, Bundle bundle) {
        if (!a()) {
            return false;
        }
        if (this.x.getMapTheme() == i) {
            return true;
        }
        this.p = i;
        return this.x.setMapTheme(i, bundle);
    }

    public boolean setMapThemeScene(int i, int i2, Bundle bundle) {
        if (!a()) {
            return false;
        }
        if (this.x.getMapTheme() == i && this.x.getMapScene() == i2) {
            return true;
        }
        this.p = i;
        this.o = i2;
        return this.x.setMapThemeScene(i, i2, bundle);
    }

    public void setMapViewInterface(MapViewInterface mapViewInterface) {
        this.i = new SoftReference<>(mapViewInterface);
    }

    public void setMapViewListener(MapViewListener mapViewListener) {
        this.b = mapViewListener;
    }

    public void setMapViewSurfaceListener(MapViewSurfaceListener mapViewSurfaceListener) {
        this.h = mapViewSurfaceListener;
    }

    public void setMaxAndMinZoomLevel(float f, float f2) {
        this.mMaxZoomLevel = f;
        this.mMinZoomLevel = f2;
    }

    public void setNaviMapViewListener(NaviMapViewListener naviMapViewListener) {
        this.j = naviMapViewListener;
    }

    public void setNetStatus(int i) {
        EngineMsgListener engineMsgListener = this.g;
        if (engineMsgListener == null) {
            return;
        }
        if (i == 1) {
            engineMsgListener.onLongLinkConnect();
        } else if (i == 2 && this.f9611a != i) {
            engineMsgListener.onLongLinkDisConnect();
        }
        this.f9611a = i;
    }

    public void setOverlayListener(al alVar) {
        this.mOverlayListener = alVar;
    }

    public void setOverlayMapCallBack(ae aeVar) {
        AppBaseMap appBaseMap;
        if (aeVar != null && (appBaseMap = this.x) != null) {
            appBaseMap.SetCallback(aeVar);
        }
    }

    public void setOverlookGestureEnable(boolean z) {
        this.Z = z;
    }

    public void setPointGesturesCenter(Point point) {
        this.t = point;
    }

    public void setRecommendPOIScene(RecommendPoiScene recommendPoiScene) {
        if (a()) {
            this.x.setRecommendPOIScene(recommendPoiScene.value);
        }
    }

    public void setSDKLayerBelowBmLayer(boolean z) {
        this.ac = z;
    }

    public void setScreenSize(int i, int i2) {
        this.A = i;
        this.B = i2;
    }

    public void setStreetArrowClickListener(an anVar) {
        this.e = anVar;
    }

    public void setStreetArrowShow(boolean z) {
        if (a()) {
            this.x.SetStreetArrowShow(z);
        }
    }

    public void setStreetMarkerClickable(String str, boolean z) {
        if (!a()) {
            return;
        }
        this.x.SetStreetMarkerClickable(str, z);
    }

    public void setStreetRoadClickable(boolean z) {
        if (a()) {
            this.x.SetStreetRoadClickable(z);
        }
    }

    public void setStyleMode(MapStyleMode mapStyleMode) {
        if (!a()) {
            return;
        }
        this.x.SetStyleMode(mapStyleMode.getMode());
    }

    public void setTargetStreetCustomMarkerVisibility(boolean z, String str) {
        if (!a()) {
            return;
        }
        this.x.SetTargetStreetCustomMarkerVisibility(z, str);
    }

    public void setTravelMode(boolean z) {
        this.q = z;
    }

    public void setTwoTouchClickZoomEnabled(boolean z) {
        this.O = z;
    }

    public void setUniversalFilter(String str) {
        if (a()) {
            this.x.setUniversalFilter(str);
        }
    }

    public void showBaseIndoorMap(boolean z) {
        if (!a()) {
            return;
        }
        this.x.ShowBaseIndoorMap(z);
    }

    public void showStreetPOIMarker(boolean z) {
        if (!a()) {
            return;
        }
        this.x.ShowStreetPOIMarker(z);
    }

    public void showUniversalLayer(Bundle bundle) {
        if (a()) {
            this.x.showUniversalLayer(bundle);
        }
    }

    public void startIndoorAnimation() {
        if (!a()) {
            return;
        }
        this.x.StartIndoorAnimation();
    }

    public boolean switchBaseIndoorMapFloor(String str, String str2) {
        if (!a()) {
            return false;
        }
        return this.x.SwitchBaseIndoorMapFloor(str, str2);
    }

    public void unInit() {
        AppBaseMap appBaseMap;
        d();
        Handler handler = this.z;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.z = null;
        }
        List<AppBaseMap> list = ad;
        if (list != null) {
            list.remove(this.x);
        }
        List<ak> list2 = this.mListeners;
        if (list2 != null) {
            list2.clear();
        }
        if (this.I && (appBaseMap = this.x) != null) {
            appBaseMap.Release();
            this.x = null;
            this.I = false;
        }
        if (this.f != null) {
            this.f = null;
        }
    }

    public void unInitForMultiTextureView() {
        AppBaseMap appBaseMap;
        if (this.I && (appBaseMap = this.x) != null) {
            appBaseMap.Release();
            this.x = null;
            this.I = false;
        }
    }

    public void updateDrawFPS() {
        if (a()) {
            this.x.updateDrawFPS();
        }
    }

    public void updateOneOverlayItem(Bundle bundle) {
        this.x.updateOneOverlayItem(bundle);
    }

    public int MapMsgProc(int i, int i2, int i3, int i4, int i5, double d, double d2, double d3, double d4) {
        if (a()) {
            return MapProc(this.y, i, i2, i3, i4, i5, d, d2, d3, d4);
        }
        return -1;
    }

    private boolean a() {
        return this.I && this.x != null;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x02e2 A[Catch: JSONException -> 0x009d, TryCatch #1 {JSONException -> 0x009d, blocks: (B:28:0x0068, B:31:0x007a, B:33:0x0080, B:35:0x0094, B:36:0x00a0, B:38:0x00a8, B:39:0x00b0, B:41:0x00b6, B:42:0x00bc, B:44:0x00c5, B:46:0x00cd, B:48:0x00f2, B:55:0x0192, B:57:0x0198, B:61:0x068e, B:62:0x01bb, B:64:0x01c8, B:65:0x01d5, B:68:0x01dd, B:69:0x01e6, B:71:0x01f5, B:72:0x0210, B:74:0x0218, B:79:0x0244, B:81:0x0276, B:83:0x027e, B:84:0x0287, B:86:0x028f, B:87:0x0297, B:89:0x029f, B:90:0x02a7, B:92:0x02af, B:93:0x02b7, B:95:0x02c0, B:96:0x02c9, B:98:0x02d1, B:99:0x02d9, B:101:0x02e2, B:102:0x02eb, B:104:0x02f5, B:105:0x02fd, B:107:0x0305, B:108:0x030d, B:110:0x0315, B:111:0x031d, B:113:0x0323, B:114:0x0329, B:116:0x0331, B:117:0x0339, B:119:0x0341, B:120:0x0349, B:122:0x0352, B:123:0x0367, B:125:0x0370, B:126:0x0385, B:128:0x038e, B:129:0x0397, B:131:0x039f, B:132:0x03a7, B:134:0x03af, B:135:0x03b7, B:137:0x03bf, B:138:0x03c7, B:140:0x03cf, B:141:0x03dd, B:143:0x03e5, B:144:0x03f1, B:146:0x03f9, B:147:0x0405, B:149:0x040d, B:150:0x0418, B:152:0x0420, B:153:0x042b, B:155:0x0433, B:156:0x043f, B:158:0x0447, B:159:0x0453, B:161:0x045b, B:162:0x0463, B:164:0x046b, B:165:0x0476, B:167:0x047f, B:168:0x048b, B:170:0x0493, B:171:0x049f, B:173:0x04a7, B:174:0x04b4, B:176:0x04bc, B:177:0x04c7, B:179:0x04cf, B:180:0x04da, B:182:0x04e2, B:185:0x04ee, B:187:0x050f, B:221:0x068b, B:234:0x057d, B:240:0x058f, B:379:0x05b5, B:381:0x05bb, B:329:0x06f9, B:332:0x06ff, B:334:0x0705, B:335:0x070e, B:337:0x0714, B:338:0x071c, B:340:0x0722, B:341:0x072a, B:343:0x0730, B:344:0x0738, B:346:0x073e, B:347:0x0746, B:349:0x074c, B:350:0x0754, B:354:0x075e, B:355:0x0766, B:356:0x076e, B:358:0x0774, B:359:0x077c, B:361:0x0782, B:362:0x078b, B:364:0x0791, B:374:0x05ce, B:377:0x05d4, B:369:0x05e4, B:370:0x05e7, B:372:0x05ed, B:289:0x05fb, B:365:0x0601, B:262:0x0612, B:266:0x061f, B:268:0x0625, B:281:0x0654, B:285:0x065c, B:287:0x0662, B:384:0x066a, B:390:0x0679, B:392:0x04d8, B:393:0x04c5, B:394:0x04b1, B:401:0x0489, B:402:0x0474, B:403:0x0450, B:404:0x043c, B:405:0x0429, B:406:0x0416, B:407:0x0402, B:408:0x03ee, B:409:0x03da, B:410:0x023e, B:411:0x022f, B:412:0x024b, B:414:0x0256, B:416:0x025e, B:417:0x01fc, B:419:0x0204, B:420:0x020d, B:421:0x01e4, B:422:0x01d2, B:453:0x0138, B:456:0x0149, B:459:0x015c, B:463:0x016b, B:465:0x017f, B:466:0x0185), top: B:27:0x0068 }] */
    /* JADX WARN: Removed duplicated region for block: B:104:0x02f5 A[Catch: JSONException -> 0x009d, TryCatch #1 {JSONException -> 0x009d, blocks: (B:28:0x0068, B:31:0x007a, B:33:0x0080, B:35:0x0094, B:36:0x00a0, B:38:0x00a8, B:39:0x00b0, B:41:0x00b6, B:42:0x00bc, B:44:0x00c5, B:46:0x00cd, B:48:0x00f2, B:55:0x0192, B:57:0x0198, B:61:0x068e, B:62:0x01bb, B:64:0x01c8, B:65:0x01d5, B:68:0x01dd, B:69:0x01e6, B:71:0x01f5, B:72:0x0210, B:74:0x0218, B:79:0x0244, B:81:0x0276, B:83:0x027e, B:84:0x0287, B:86:0x028f, B:87:0x0297, B:89:0x029f, B:90:0x02a7, B:92:0x02af, B:93:0x02b7, B:95:0x02c0, B:96:0x02c9, B:98:0x02d1, B:99:0x02d9, B:101:0x02e2, B:102:0x02eb, B:104:0x02f5, B:105:0x02fd, B:107:0x0305, B:108:0x030d, B:110:0x0315, B:111:0x031d, B:113:0x0323, B:114:0x0329, B:116:0x0331, B:117:0x0339, B:119:0x0341, B:120:0x0349, B:122:0x0352, B:123:0x0367, B:125:0x0370, B:126:0x0385, B:128:0x038e, B:129:0x0397, B:131:0x039f, B:132:0x03a7, B:134:0x03af, B:135:0x03b7, B:137:0x03bf, B:138:0x03c7, B:140:0x03cf, B:141:0x03dd, B:143:0x03e5, B:144:0x03f1, B:146:0x03f9, B:147:0x0405, B:149:0x040d, B:150:0x0418, B:152:0x0420, B:153:0x042b, B:155:0x0433, B:156:0x043f, B:158:0x0447, B:159:0x0453, B:161:0x045b, B:162:0x0463, B:164:0x046b, B:165:0x0476, B:167:0x047f, B:168:0x048b, B:170:0x0493, B:171:0x049f, B:173:0x04a7, B:174:0x04b4, B:176:0x04bc, B:177:0x04c7, B:179:0x04cf, B:180:0x04da, B:182:0x04e2, B:185:0x04ee, B:187:0x050f, B:221:0x068b, B:234:0x057d, B:240:0x058f, B:379:0x05b5, B:381:0x05bb, B:329:0x06f9, B:332:0x06ff, B:334:0x0705, B:335:0x070e, B:337:0x0714, B:338:0x071c, B:340:0x0722, B:341:0x072a, B:343:0x0730, B:344:0x0738, B:346:0x073e, B:347:0x0746, B:349:0x074c, B:350:0x0754, B:354:0x075e, B:355:0x0766, B:356:0x076e, B:358:0x0774, B:359:0x077c, B:361:0x0782, B:362:0x078b, B:364:0x0791, B:374:0x05ce, B:377:0x05d4, B:369:0x05e4, B:370:0x05e7, B:372:0x05ed, B:289:0x05fb, B:365:0x0601, B:262:0x0612, B:266:0x061f, B:268:0x0625, B:281:0x0654, B:285:0x065c, B:287:0x0662, B:384:0x066a, B:390:0x0679, B:392:0x04d8, B:393:0x04c5, B:394:0x04b1, B:401:0x0489, B:402:0x0474, B:403:0x0450, B:404:0x043c, B:405:0x0429, B:406:0x0416, B:407:0x0402, B:408:0x03ee, B:409:0x03da, B:410:0x023e, B:411:0x022f, B:412:0x024b, B:414:0x0256, B:416:0x025e, B:417:0x01fc, B:419:0x0204, B:420:0x020d, B:421:0x01e4, B:422:0x01d2, B:453:0x0138, B:456:0x0149, B:459:0x015c, B:463:0x016b, B:465:0x017f, B:466:0x0185), top: B:27:0x0068 }] */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0305 A[Catch: JSONException -> 0x009d, TryCatch #1 {JSONException -> 0x009d, blocks: (B:28:0x0068, B:31:0x007a, B:33:0x0080, B:35:0x0094, B:36:0x00a0, B:38:0x00a8, B:39:0x00b0, B:41:0x00b6, B:42:0x00bc, B:44:0x00c5, B:46:0x00cd, B:48:0x00f2, B:55:0x0192, B:57:0x0198, B:61:0x068e, B:62:0x01bb, B:64:0x01c8, B:65:0x01d5, B:68:0x01dd, B:69:0x01e6, B:71:0x01f5, B:72:0x0210, B:74:0x0218, B:79:0x0244, B:81:0x0276, B:83:0x027e, B:84:0x0287, B:86:0x028f, B:87:0x0297, B:89:0x029f, B:90:0x02a7, B:92:0x02af, B:93:0x02b7, B:95:0x02c0, B:96:0x02c9, B:98:0x02d1, B:99:0x02d9, B:101:0x02e2, B:102:0x02eb, B:104:0x02f5, B:105:0x02fd, B:107:0x0305, B:108:0x030d, B:110:0x0315, B:111:0x031d, B:113:0x0323, B:114:0x0329, B:116:0x0331, B:117:0x0339, B:119:0x0341, B:120:0x0349, B:122:0x0352, B:123:0x0367, B:125:0x0370, B:126:0x0385, B:128:0x038e, B:129:0x0397, B:131:0x039f, B:132:0x03a7, B:134:0x03af, B:135:0x03b7, B:137:0x03bf, B:138:0x03c7, B:140:0x03cf, B:141:0x03dd, B:143:0x03e5, B:144:0x03f1, B:146:0x03f9, B:147:0x0405, B:149:0x040d, B:150:0x0418, B:152:0x0420, B:153:0x042b, B:155:0x0433, B:156:0x043f, B:158:0x0447, B:159:0x0453, B:161:0x045b, B:162:0x0463, B:164:0x046b, B:165:0x0476, B:167:0x047f, B:168:0x048b, B:170:0x0493, B:171:0x049f, B:173:0x04a7, B:174:0x04b4, B:176:0x04bc, B:177:0x04c7, B:179:0x04cf, B:180:0x04da, B:182:0x04e2, B:185:0x04ee, B:187:0x050f, B:221:0x068b, B:234:0x057d, B:240:0x058f, B:379:0x05b5, B:381:0x05bb, B:329:0x06f9, B:332:0x06ff, B:334:0x0705, B:335:0x070e, B:337:0x0714, B:338:0x071c, B:340:0x0722, B:341:0x072a, B:343:0x0730, B:344:0x0738, B:346:0x073e, B:347:0x0746, B:349:0x074c, B:350:0x0754, B:354:0x075e, B:355:0x0766, B:356:0x076e, B:358:0x0774, B:359:0x077c, B:361:0x0782, B:362:0x078b, B:364:0x0791, B:374:0x05ce, B:377:0x05d4, B:369:0x05e4, B:370:0x05e7, B:372:0x05ed, B:289:0x05fb, B:365:0x0601, B:262:0x0612, B:266:0x061f, B:268:0x0625, B:281:0x0654, B:285:0x065c, B:287:0x0662, B:384:0x066a, B:390:0x0679, B:392:0x04d8, B:393:0x04c5, B:394:0x04b1, B:401:0x0489, B:402:0x0474, B:403:0x0450, B:404:0x043c, B:405:0x0429, B:406:0x0416, B:407:0x0402, B:408:0x03ee, B:409:0x03da, B:410:0x023e, B:411:0x022f, B:412:0x024b, B:414:0x0256, B:416:0x025e, B:417:0x01fc, B:419:0x0204, B:420:0x020d, B:421:0x01e4, B:422:0x01d2, B:453:0x0138, B:456:0x0149, B:459:0x015c, B:463:0x016b, B:465:0x017f, B:466:0x0185), top: B:27:0x0068 }] */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0315 A[Catch: JSONException -> 0x009d, TryCatch #1 {JSONException -> 0x009d, blocks: (B:28:0x0068, B:31:0x007a, B:33:0x0080, B:35:0x0094, B:36:0x00a0, B:38:0x00a8, B:39:0x00b0, B:41:0x00b6, B:42:0x00bc, B:44:0x00c5, B:46:0x00cd, B:48:0x00f2, B:55:0x0192, B:57:0x0198, B:61:0x068e, B:62:0x01bb, B:64:0x01c8, B:65:0x01d5, B:68:0x01dd, B:69:0x01e6, B:71:0x01f5, B:72:0x0210, B:74:0x0218, B:79:0x0244, B:81:0x0276, B:83:0x027e, B:84:0x0287, B:86:0x028f, B:87:0x0297, B:89:0x029f, B:90:0x02a7, B:92:0x02af, B:93:0x02b7, B:95:0x02c0, B:96:0x02c9, B:98:0x02d1, B:99:0x02d9, B:101:0x02e2, B:102:0x02eb, B:104:0x02f5, B:105:0x02fd, B:107:0x0305, B:108:0x030d, B:110:0x0315, B:111:0x031d, B:113:0x0323, B:114:0x0329, B:116:0x0331, B:117:0x0339, B:119:0x0341, B:120:0x0349, B:122:0x0352, B:123:0x0367, B:125:0x0370, B:126:0x0385, B:128:0x038e, B:129:0x0397, B:131:0x039f, B:132:0x03a7, B:134:0x03af, B:135:0x03b7, B:137:0x03bf, B:138:0x03c7, B:140:0x03cf, B:141:0x03dd, B:143:0x03e5, B:144:0x03f1, B:146:0x03f9, B:147:0x0405, B:149:0x040d, B:150:0x0418, B:152:0x0420, B:153:0x042b, B:155:0x0433, B:156:0x043f, B:158:0x0447, B:159:0x0453, B:161:0x045b, B:162:0x0463, B:164:0x046b, B:165:0x0476, B:167:0x047f, B:168:0x048b, B:170:0x0493, B:171:0x049f, B:173:0x04a7, B:174:0x04b4, B:176:0x04bc, B:177:0x04c7, B:179:0x04cf, B:180:0x04da, B:182:0x04e2, B:185:0x04ee, B:187:0x050f, B:221:0x068b, B:234:0x057d, B:240:0x058f, B:379:0x05b5, B:381:0x05bb, B:329:0x06f9, B:332:0x06ff, B:334:0x0705, B:335:0x070e, B:337:0x0714, B:338:0x071c, B:340:0x0722, B:341:0x072a, B:343:0x0730, B:344:0x0738, B:346:0x073e, B:347:0x0746, B:349:0x074c, B:350:0x0754, B:354:0x075e, B:355:0x0766, B:356:0x076e, B:358:0x0774, B:359:0x077c, B:361:0x0782, B:362:0x078b, B:364:0x0791, B:374:0x05ce, B:377:0x05d4, B:369:0x05e4, B:370:0x05e7, B:372:0x05ed, B:289:0x05fb, B:365:0x0601, B:262:0x0612, B:266:0x061f, B:268:0x0625, B:281:0x0654, B:285:0x065c, B:287:0x0662, B:384:0x066a, B:390:0x0679, B:392:0x04d8, B:393:0x04c5, B:394:0x04b1, B:401:0x0489, B:402:0x0474, B:403:0x0450, B:404:0x043c, B:405:0x0429, B:406:0x0416, B:407:0x0402, B:408:0x03ee, B:409:0x03da, B:410:0x023e, B:411:0x022f, B:412:0x024b, B:414:0x0256, B:416:0x025e, B:417:0x01fc, B:419:0x0204, B:420:0x020d, B:421:0x01e4, B:422:0x01d2, B:453:0x0138, B:456:0x0149, B:459:0x015c, B:463:0x016b, B:465:0x017f, B:466:0x0185), top: B:27:0x0068 }] */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0323 A[Catch: JSONException -> 0x009d, TryCatch #1 {JSONException -> 0x009d, blocks: (B:28:0x0068, B:31:0x007a, B:33:0x0080, B:35:0x0094, B:36:0x00a0, B:38:0x00a8, B:39:0x00b0, B:41:0x00b6, B:42:0x00bc, B:44:0x00c5, B:46:0x00cd, B:48:0x00f2, B:55:0x0192, B:57:0x0198, B:61:0x068e, B:62:0x01bb, B:64:0x01c8, B:65:0x01d5, B:68:0x01dd, B:69:0x01e6, B:71:0x01f5, B:72:0x0210, B:74:0x0218, B:79:0x0244, B:81:0x0276, B:83:0x027e, B:84:0x0287, B:86:0x028f, B:87:0x0297, B:89:0x029f, B:90:0x02a7, B:92:0x02af, B:93:0x02b7, B:95:0x02c0, B:96:0x02c9, B:98:0x02d1, B:99:0x02d9, B:101:0x02e2, B:102:0x02eb, B:104:0x02f5, B:105:0x02fd, B:107:0x0305, B:108:0x030d, B:110:0x0315, B:111:0x031d, B:113:0x0323, B:114:0x0329, B:116:0x0331, B:117:0x0339, B:119:0x0341, B:120:0x0349, B:122:0x0352, B:123:0x0367, B:125:0x0370, B:126:0x0385, B:128:0x038e, B:129:0x0397, B:131:0x039f, B:132:0x03a7, B:134:0x03af, B:135:0x03b7, B:137:0x03bf, B:138:0x03c7, B:140:0x03cf, B:141:0x03dd, B:143:0x03e5, B:144:0x03f1, B:146:0x03f9, B:147:0x0405, B:149:0x040d, B:150:0x0418, B:152:0x0420, B:153:0x042b, B:155:0x0433, B:156:0x043f, B:158:0x0447, B:159:0x0453, B:161:0x045b, B:162:0x0463, B:164:0x046b, B:165:0x0476, B:167:0x047f, B:168:0x048b, B:170:0x0493, B:171:0x049f, B:173:0x04a7, B:174:0x04b4, B:176:0x04bc, B:177:0x04c7, B:179:0x04cf, B:180:0x04da, B:182:0x04e2, B:185:0x04ee, B:187:0x050f, B:221:0x068b, B:234:0x057d, B:240:0x058f, B:379:0x05b5, B:381:0x05bb, B:329:0x06f9, B:332:0x06ff, B:334:0x0705, B:335:0x070e, B:337:0x0714, B:338:0x071c, B:340:0x0722, B:341:0x072a, B:343:0x0730, B:344:0x0738, B:346:0x073e, B:347:0x0746, B:349:0x074c, B:350:0x0754, B:354:0x075e, B:355:0x0766, B:356:0x076e, B:358:0x0774, B:359:0x077c, B:361:0x0782, B:362:0x078b, B:364:0x0791, B:374:0x05ce, B:377:0x05d4, B:369:0x05e4, B:370:0x05e7, B:372:0x05ed, B:289:0x05fb, B:365:0x0601, B:262:0x0612, B:266:0x061f, B:268:0x0625, B:281:0x0654, B:285:0x065c, B:287:0x0662, B:384:0x066a, B:390:0x0679, B:392:0x04d8, B:393:0x04c5, B:394:0x04b1, B:401:0x0489, B:402:0x0474, B:403:0x0450, B:404:0x043c, B:405:0x0429, B:406:0x0416, B:407:0x0402, B:408:0x03ee, B:409:0x03da, B:410:0x023e, B:411:0x022f, B:412:0x024b, B:414:0x0256, B:416:0x025e, B:417:0x01fc, B:419:0x0204, B:420:0x020d, B:421:0x01e4, B:422:0x01d2, B:453:0x0138, B:456:0x0149, B:459:0x015c, B:463:0x016b, B:465:0x017f, B:466:0x0185), top: B:27:0x0068 }] */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0331 A[Catch: JSONException -> 0x009d, TryCatch #1 {JSONException -> 0x009d, blocks: (B:28:0x0068, B:31:0x007a, B:33:0x0080, B:35:0x0094, B:36:0x00a0, B:38:0x00a8, B:39:0x00b0, B:41:0x00b6, B:42:0x00bc, B:44:0x00c5, B:46:0x00cd, B:48:0x00f2, B:55:0x0192, B:57:0x0198, B:61:0x068e, B:62:0x01bb, B:64:0x01c8, B:65:0x01d5, B:68:0x01dd, B:69:0x01e6, B:71:0x01f5, B:72:0x0210, B:74:0x0218, B:79:0x0244, B:81:0x0276, B:83:0x027e, B:84:0x0287, B:86:0x028f, B:87:0x0297, B:89:0x029f, B:90:0x02a7, B:92:0x02af, B:93:0x02b7, B:95:0x02c0, B:96:0x02c9, B:98:0x02d1, B:99:0x02d9, B:101:0x02e2, B:102:0x02eb, B:104:0x02f5, B:105:0x02fd, B:107:0x0305, B:108:0x030d, B:110:0x0315, B:111:0x031d, B:113:0x0323, B:114:0x0329, B:116:0x0331, B:117:0x0339, B:119:0x0341, B:120:0x0349, B:122:0x0352, B:123:0x0367, B:125:0x0370, B:126:0x0385, B:128:0x038e, B:129:0x0397, B:131:0x039f, B:132:0x03a7, B:134:0x03af, B:135:0x03b7, B:137:0x03bf, B:138:0x03c7, B:140:0x03cf, B:141:0x03dd, B:143:0x03e5, B:144:0x03f1, B:146:0x03f9, B:147:0x0405, B:149:0x040d, B:150:0x0418, B:152:0x0420, B:153:0x042b, B:155:0x0433, B:156:0x043f, B:158:0x0447, B:159:0x0453, B:161:0x045b, B:162:0x0463, B:164:0x046b, B:165:0x0476, B:167:0x047f, B:168:0x048b, B:170:0x0493, B:171:0x049f, B:173:0x04a7, B:174:0x04b4, B:176:0x04bc, B:177:0x04c7, B:179:0x04cf, B:180:0x04da, B:182:0x04e2, B:185:0x04ee, B:187:0x050f, B:221:0x068b, B:234:0x057d, B:240:0x058f, B:379:0x05b5, B:381:0x05bb, B:329:0x06f9, B:332:0x06ff, B:334:0x0705, B:335:0x070e, B:337:0x0714, B:338:0x071c, B:340:0x0722, B:341:0x072a, B:343:0x0730, B:344:0x0738, B:346:0x073e, B:347:0x0746, B:349:0x074c, B:350:0x0754, B:354:0x075e, B:355:0x0766, B:356:0x076e, B:358:0x0774, B:359:0x077c, B:361:0x0782, B:362:0x078b, B:364:0x0791, B:374:0x05ce, B:377:0x05d4, B:369:0x05e4, B:370:0x05e7, B:372:0x05ed, B:289:0x05fb, B:365:0x0601, B:262:0x0612, B:266:0x061f, B:268:0x0625, B:281:0x0654, B:285:0x065c, B:287:0x0662, B:384:0x066a, B:390:0x0679, B:392:0x04d8, B:393:0x04c5, B:394:0x04b1, B:401:0x0489, B:402:0x0474, B:403:0x0450, B:404:0x043c, B:405:0x0429, B:406:0x0416, B:407:0x0402, B:408:0x03ee, B:409:0x03da, B:410:0x023e, B:411:0x022f, B:412:0x024b, B:414:0x0256, B:416:0x025e, B:417:0x01fc, B:419:0x0204, B:420:0x020d, B:421:0x01e4, B:422:0x01d2, B:453:0x0138, B:456:0x0149, B:459:0x015c, B:463:0x016b, B:465:0x017f, B:466:0x0185), top: B:27:0x0068 }] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0341 A[Catch: JSONException -> 0x009d, TryCatch #1 {JSONException -> 0x009d, blocks: (B:28:0x0068, B:31:0x007a, B:33:0x0080, B:35:0x0094, B:36:0x00a0, B:38:0x00a8, B:39:0x00b0, B:41:0x00b6, B:42:0x00bc, B:44:0x00c5, B:46:0x00cd, B:48:0x00f2, B:55:0x0192, B:57:0x0198, B:61:0x068e, B:62:0x01bb, B:64:0x01c8, B:65:0x01d5, B:68:0x01dd, B:69:0x01e6, B:71:0x01f5, B:72:0x0210, B:74:0x0218, B:79:0x0244, B:81:0x0276, B:83:0x027e, B:84:0x0287, B:86:0x028f, B:87:0x0297, B:89:0x029f, B:90:0x02a7, B:92:0x02af, B:93:0x02b7, B:95:0x02c0, B:96:0x02c9, B:98:0x02d1, B:99:0x02d9, B:101:0x02e2, B:102:0x02eb, B:104:0x02f5, B:105:0x02fd, B:107:0x0305, B:108:0x030d, B:110:0x0315, B:111:0x031d, B:113:0x0323, B:114:0x0329, B:116:0x0331, B:117:0x0339, B:119:0x0341, B:120:0x0349, B:122:0x0352, B:123:0x0367, B:125:0x0370, B:126:0x0385, B:128:0x038e, B:129:0x0397, B:131:0x039f, B:132:0x03a7, B:134:0x03af, B:135:0x03b7, B:137:0x03bf, B:138:0x03c7, B:140:0x03cf, B:141:0x03dd, B:143:0x03e5, B:144:0x03f1, B:146:0x03f9, B:147:0x0405, B:149:0x040d, B:150:0x0418, B:152:0x0420, B:153:0x042b, B:155:0x0433, B:156:0x043f, B:158:0x0447, B:159:0x0453, B:161:0x045b, B:162:0x0463, B:164:0x046b, B:165:0x0476, B:167:0x047f, B:168:0x048b, B:170:0x0493, B:171:0x049f, B:173:0x04a7, B:174:0x04b4, B:176:0x04bc, B:177:0x04c7, B:179:0x04cf, B:180:0x04da, B:182:0x04e2, B:185:0x04ee, B:187:0x050f, B:221:0x068b, B:234:0x057d, B:240:0x058f, B:379:0x05b5, B:381:0x05bb, B:329:0x06f9, B:332:0x06ff, B:334:0x0705, B:335:0x070e, B:337:0x0714, B:338:0x071c, B:340:0x0722, B:341:0x072a, B:343:0x0730, B:344:0x0738, B:346:0x073e, B:347:0x0746, B:349:0x074c, B:350:0x0754, B:354:0x075e, B:355:0x0766, B:356:0x076e, B:358:0x0774, B:359:0x077c, B:361:0x0782, B:362:0x078b, B:364:0x0791, B:374:0x05ce, B:377:0x05d4, B:369:0x05e4, B:370:0x05e7, B:372:0x05ed, B:289:0x05fb, B:365:0x0601, B:262:0x0612, B:266:0x061f, B:268:0x0625, B:281:0x0654, B:285:0x065c, B:287:0x0662, B:384:0x066a, B:390:0x0679, B:392:0x04d8, B:393:0x04c5, B:394:0x04b1, B:401:0x0489, B:402:0x0474, B:403:0x0450, B:404:0x043c, B:405:0x0429, B:406:0x0416, B:407:0x0402, B:408:0x03ee, B:409:0x03da, B:410:0x023e, B:411:0x022f, B:412:0x024b, B:414:0x0256, B:416:0x025e, B:417:0x01fc, B:419:0x0204, B:420:0x020d, B:421:0x01e4, B:422:0x01d2, B:453:0x0138, B:456:0x0149, B:459:0x015c, B:463:0x016b, B:465:0x017f, B:466:0x0185), top: B:27:0x0068 }] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0352 A[Catch: JSONException -> 0x009d, TryCatch #1 {JSONException -> 0x009d, blocks: (B:28:0x0068, B:31:0x007a, B:33:0x0080, B:35:0x0094, B:36:0x00a0, B:38:0x00a8, B:39:0x00b0, B:41:0x00b6, B:42:0x00bc, B:44:0x00c5, B:46:0x00cd, B:48:0x00f2, B:55:0x0192, B:57:0x0198, B:61:0x068e, B:62:0x01bb, B:64:0x01c8, B:65:0x01d5, B:68:0x01dd, B:69:0x01e6, B:71:0x01f5, B:72:0x0210, B:74:0x0218, B:79:0x0244, B:81:0x0276, B:83:0x027e, B:84:0x0287, B:86:0x028f, B:87:0x0297, B:89:0x029f, B:90:0x02a7, B:92:0x02af, B:93:0x02b7, B:95:0x02c0, B:96:0x02c9, B:98:0x02d1, B:99:0x02d9, B:101:0x02e2, B:102:0x02eb, B:104:0x02f5, B:105:0x02fd, B:107:0x0305, B:108:0x030d, B:110:0x0315, B:111:0x031d, B:113:0x0323, B:114:0x0329, B:116:0x0331, B:117:0x0339, B:119:0x0341, B:120:0x0349, B:122:0x0352, B:123:0x0367, B:125:0x0370, B:126:0x0385, B:128:0x038e, B:129:0x0397, B:131:0x039f, B:132:0x03a7, B:134:0x03af, B:135:0x03b7, B:137:0x03bf, B:138:0x03c7, B:140:0x03cf, B:141:0x03dd, B:143:0x03e5, B:144:0x03f1, B:146:0x03f9, B:147:0x0405, B:149:0x040d, B:150:0x0418, B:152:0x0420, B:153:0x042b, B:155:0x0433, B:156:0x043f, B:158:0x0447, B:159:0x0453, B:161:0x045b, B:162:0x0463, B:164:0x046b, B:165:0x0476, B:167:0x047f, B:168:0x048b, B:170:0x0493, B:171:0x049f, B:173:0x04a7, B:174:0x04b4, B:176:0x04bc, B:177:0x04c7, B:179:0x04cf, B:180:0x04da, B:182:0x04e2, B:185:0x04ee, B:187:0x050f, B:221:0x068b, B:234:0x057d, B:240:0x058f, B:379:0x05b5, B:381:0x05bb, B:329:0x06f9, B:332:0x06ff, B:334:0x0705, B:335:0x070e, B:337:0x0714, B:338:0x071c, B:340:0x0722, B:341:0x072a, B:343:0x0730, B:344:0x0738, B:346:0x073e, B:347:0x0746, B:349:0x074c, B:350:0x0754, B:354:0x075e, B:355:0x0766, B:356:0x076e, B:358:0x0774, B:359:0x077c, B:361:0x0782, B:362:0x078b, B:364:0x0791, B:374:0x05ce, B:377:0x05d4, B:369:0x05e4, B:370:0x05e7, B:372:0x05ed, B:289:0x05fb, B:365:0x0601, B:262:0x0612, B:266:0x061f, B:268:0x0625, B:281:0x0654, B:285:0x065c, B:287:0x0662, B:384:0x066a, B:390:0x0679, B:392:0x04d8, B:393:0x04c5, B:394:0x04b1, B:401:0x0489, B:402:0x0474, B:403:0x0450, B:404:0x043c, B:405:0x0429, B:406:0x0416, B:407:0x0402, B:408:0x03ee, B:409:0x03da, B:410:0x023e, B:411:0x022f, B:412:0x024b, B:414:0x0256, B:416:0x025e, B:417:0x01fc, B:419:0x0204, B:420:0x020d, B:421:0x01e4, B:422:0x01d2, B:453:0x0138, B:456:0x0149, B:459:0x015c, B:463:0x016b, B:465:0x017f, B:466:0x0185), top: B:27:0x0068 }] */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0370 A[Catch: JSONException -> 0x009d, TryCatch #1 {JSONException -> 0x009d, blocks: (B:28:0x0068, B:31:0x007a, B:33:0x0080, B:35:0x0094, B:36:0x00a0, B:38:0x00a8, B:39:0x00b0, B:41:0x00b6, B:42:0x00bc, B:44:0x00c5, B:46:0x00cd, B:48:0x00f2, B:55:0x0192, B:57:0x0198, B:61:0x068e, B:62:0x01bb, B:64:0x01c8, B:65:0x01d5, B:68:0x01dd, B:69:0x01e6, B:71:0x01f5, B:72:0x0210, B:74:0x0218, B:79:0x0244, B:81:0x0276, B:83:0x027e, B:84:0x0287, B:86:0x028f, B:87:0x0297, B:89:0x029f, B:90:0x02a7, B:92:0x02af, B:93:0x02b7, B:95:0x02c0, B:96:0x02c9, B:98:0x02d1, B:99:0x02d9, B:101:0x02e2, B:102:0x02eb, B:104:0x02f5, B:105:0x02fd, B:107:0x0305, B:108:0x030d, B:110:0x0315, B:111:0x031d, B:113:0x0323, B:114:0x0329, B:116:0x0331, B:117:0x0339, B:119:0x0341, B:120:0x0349, B:122:0x0352, B:123:0x0367, B:125:0x0370, B:126:0x0385, B:128:0x038e, B:129:0x0397, B:131:0x039f, B:132:0x03a7, B:134:0x03af, B:135:0x03b7, B:137:0x03bf, B:138:0x03c7, B:140:0x03cf, B:141:0x03dd, B:143:0x03e5, B:144:0x03f1, B:146:0x03f9, B:147:0x0405, B:149:0x040d, B:150:0x0418, B:152:0x0420, B:153:0x042b, B:155:0x0433, B:156:0x043f, B:158:0x0447, B:159:0x0453, B:161:0x045b, B:162:0x0463, B:164:0x046b, B:165:0x0476, B:167:0x047f, B:168:0x048b, B:170:0x0493, B:171:0x049f, B:173:0x04a7, B:174:0x04b4, B:176:0x04bc, B:177:0x04c7, B:179:0x04cf, B:180:0x04da, B:182:0x04e2, B:185:0x04ee, B:187:0x050f, B:221:0x068b, B:234:0x057d, B:240:0x058f, B:379:0x05b5, B:381:0x05bb, B:329:0x06f9, B:332:0x06ff, B:334:0x0705, B:335:0x070e, B:337:0x0714, B:338:0x071c, B:340:0x0722, B:341:0x072a, B:343:0x0730, B:344:0x0738, B:346:0x073e, B:347:0x0746, B:349:0x074c, B:350:0x0754, B:354:0x075e, B:355:0x0766, B:356:0x076e, B:358:0x0774, B:359:0x077c, B:361:0x0782, B:362:0x078b, B:364:0x0791, B:374:0x05ce, B:377:0x05d4, B:369:0x05e4, B:370:0x05e7, B:372:0x05ed, B:289:0x05fb, B:365:0x0601, B:262:0x0612, B:266:0x061f, B:268:0x0625, B:281:0x0654, B:285:0x065c, B:287:0x0662, B:384:0x066a, B:390:0x0679, B:392:0x04d8, B:393:0x04c5, B:394:0x04b1, B:401:0x0489, B:402:0x0474, B:403:0x0450, B:404:0x043c, B:405:0x0429, B:406:0x0416, B:407:0x0402, B:408:0x03ee, B:409:0x03da, B:410:0x023e, B:411:0x022f, B:412:0x024b, B:414:0x0256, B:416:0x025e, B:417:0x01fc, B:419:0x0204, B:420:0x020d, B:421:0x01e4, B:422:0x01d2, B:453:0x0138, B:456:0x0149, B:459:0x015c, B:463:0x016b, B:465:0x017f, B:466:0x0185), top: B:27:0x0068 }] */
    /* JADX WARN: Removed duplicated region for block: B:128:0x038e A[Catch: JSONException -> 0x009d, TryCatch #1 {JSONException -> 0x009d, blocks: (B:28:0x0068, B:31:0x007a, B:33:0x0080, B:35:0x0094, B:36:0x00a0, B:38:0x00a8, B:39:0x00b0, B:41:0x00b6, B:42:0x00bc, B:44:0x00c5, B:46:0x00cd, B:48:0x00f2, B:55:0x0192, B:57:0x0198, B:61:0x068e, B:62:0x01bb, B:64:0x01c8, B:65:0x01d5, B:68:0x01dd, B:69:0x01e6, B:71:0x01f5, B:72:0x0210, B:74:0x0218, B:79:0x0244, B:81:0x0276, B:83:0x027e, B:84:0x0287, B:86:0x028f, B:87:0x0297, B:89:0x029f, B:90:0x02a7, B:92:0x02af, B:93:0x02b7, B:95:0x02c0, B:96:0x02c9, B:98:0x02d1, B:99:0x02d9, B:101:0x02e2, B:102:0x02eb, B:104:0x02f5, B:105:0x02fd, B:107:0x0305, B:108:0x030d, B:110:0x0315, B:111:0x031d, B:113:0x0323, B:114:0x0329, B:116:0x0331, B:117:0x0339, B:119:0x0341, B:120:0x0349, B:122:0x0352, B:123:0x0367, B:125:0x0370, B:126:0x0385, B:128:0x038e, B:129:0x0397, B:131:0x039f, B:132:0x03a7, B:134:0x03af, B:135:0x03b7, B:137:0x03bf, B:138:0x03c7, B:140:0x03cf, B:141:0x03dd, B:143:0x03e5, B:144:0x03f1, B:146:0x03f9, B:147:0x0405, B:149:0x040d, B:150:0x0418, B:152:0x0420, B:153:0x042b, B:155:0x0433, B:156:0x043f, B:158:0x0447, B:159:0x0453, B:161:0x045b, B:162:0x0463, B:164:0x046b, B:165:0x0476, B:167:0x047f, B:168:0x048b, B:170:0x0493, B:171:0x049f, B:173:0x04a7, B:174:0x04b4, B:176:0x04bc, B:177:0x04c7, B:179:0x04cf, B:180:0x04da, B:182:0x04e2, B:185:0x04ee, B:187:0x050f, B:221:0x068b, B:234:0x057d, B:240:0x058f, B:379:0x05b5, B:381:0x05bb, B:329:0x06f9, B:332:0x06ff, B:334:0x0705, B:335:0x070e, B:337:0x0714, B:338:0x071c, B:340:0x0722, B:341:0x072a, B:343:0x0730, B:344:0x0738, B:346:0x073e, B:347:0x0746, B:349:0x074c, B:350:0x0754, B:354:0x075e, B:355:0x0766, B:356:0x076e, B:358:0x0774, B:359:0x077c, B:361:0x0782, B:362:0x078b, B:364:0x0791, B:374:0x05ce, B:377:0x05d4, B:369:0x05e4, B:370:0x05e7, B:372:0x05ed, B:289:0x05fb, B:365:0x0601, B:262:0x0612, B:266:0x061f, B:268:0x0625, B:281:0x0654, B:285:0x065c, B:287:0x0662, B:384:0x066a, B:390:0x0679, B:392:0x04d8, B:393:0x04c5, B:394:0x04b1, B:401:0x0489, B:402:0x0474, B:403:0x0450, B:404:0x043c, B:405:0x0429, B:406:0x0416, B:407:0x0402, B:408:0x03ee, B:409:0x03da, B:410:0x023e, B:411:0x022f, B:412:0x024b, B:414:0x0256, B:416:0x025e, B:417:0x01fc, B:419:0x0204, B:420:0x020d, B:421:0x01e4, B:422:0x01d2, B:453:0x0138, B:456:0x0149, B:459:0x015c, B:463:0x016b, B:465:0x017f, B:466:0x0185), top: B:27:0x0068 }] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x039f A[Catch: JSONException -> 0x009d, TryCatch #1 {JSONException -> 0x009d, blocks: (B:28:0x0068, B:31:0x007a, B:33:0x0080, B:35:0x0094, B:36:0x00a0, B:38:0x00a8, B:39:0x00b0, B:41:0x00b6, B:42:0x00bc, B:44:0x00c5, B:46:0x00cd, B:48:0x00f2, B:55:0x0192, B:57:0x0198, B:61:0x068e, B:62:0x01bb, B:64:0x01c8, B:65:0x01d5, B:68:0x01dd, B:69:0x01e6, B:71:0x01f5, B:72:0x0210, B:74:0x0218, B:79:0x0244, B:81:0x0276, B:83:0x027e, B:84:0x0287, B:86:0x028f, B:87:0x0297, B:89:0x029f, B:90:0x02a7, B:92:0x02af, B:93:0x02b7, B:95:0x02c0, B:96:0x02c9, B:98:0x02d1, B:99:0x02d9, B:101:0x02e2, B:102:0x02eb, B:104:0x02f5, B:105:0x02fd, B:107:0x0305, B:108:0x030d, B:110:0x0315, B:111:0x031d, B:113:0x0323, B:114:0x0329, B:116:0x0331, B:117:0x0339, B:119:0x0341, B:120:0x0349, B:122:0x0352, B:123:0x0367, B:125:0x0370, B:126:0x0385, B:128:0x038e, B:129:0x0397, B:131:0x039f, B:132:0x03a7, B:134:0x03af, B:135:0x03b7, B:137:0x03bf, B:138:0x03c7, B:140:0x03cf, B:141:0x03dd, B:143:0x03e5, B:144:0x03f1, B:146:0x03f9, B:147:0x0405, B:149:0x040d, B:150:0x0418, B:152:0x0420, B:153:0x042b, B:155:0x0433, B:156:0x043f, B:158:0x0447, B:159:0x0453, B:161:0x045b, B:162:0x0463, B:164:0x046b, B:165:0x0476, B:167:0x047f, B:168:0x048b, B:170:0x0493, B:171:0x049f, B:173:0x04a7, B:174:0x04b4, B:176:0x04bc, B:177:0x04c7, B:179:0x04cf, B:180:0x04da, B:182:0x04e2, B:185:0x04ee, B:187:0x050f, B:221:0x068b, B:234:0x057d, B:240:0x058f, B:379:0x05b5, B:381:0x05bb, B:329:0x06f9, B:332:0x06ff, B:334:0x0705, B:335:0x070e, B:337:0x0714, B:338:0x071c, B:340:0x0722, B:341:0x072a, B:343:0x0730, B:344:0x0738, B:346:0x073e, B:347:0x0746, B:349:0x074c, B:350:0x0754, B:354:0x075e, B:355:0x0766, B:356:0x076e, B:358:0x0774, B:359:0x077c, B:361:0x0782, B:362:0x078b, B:364:0x0791, B:374:0x05ce, B:377:0x05d4, B:369:0x05e4, B:370:0x05e7, B:372:0x05ed, B:289:0x05fb, B:365:0x0601, B:262:0x0612, B:266:0x061f, B:268:0x0625, B:281:0x0654, B:285:0x065c, B:287:0x0662, B:384:0x066a, B:390:0x0679, B:392:0x04d8, B:393:0x04c5, B:394:0x04b1, B:401:0x0489, B:402:0x0474, B:403:0x0450, B:404:0x043c, B:405:0x0429, B:406:0x0416, B:407:0x0402, B:408:0x03ee, B:409:0x03da, B:410:0x023e, B:411:0x022f, B:412:0x024b, B:414:0x0256, B:416:0x025e, B:417:0x01fc, B:419:0x0204, B:420:0x020d, B:421:0x01e4, B:422:0x01d2, B:453:0x0138, B:456:0x0149, B:459:0x015c, B:463:0x016b, B:465:0x017f, B:466:0x0185), top: B:27:0x0068 }] */
    /* JADX WARN: Removed duplicated region for block: B:134:0x03af A[Catch: JSONException -> 0x009d, TryCatch #1 {JSONException -> 0x009d, blocks: (B:28:0x0068, B:31:0x007a, B:33:0x0080, B:35:0x0094, B:36:0x00a0, B:38:0x00a8, B:39:0x00b0, B:41:0x00b6, B:42:0x00bc, B:44:0x00c5, B:46:0x00cd, B:48:0x00f2, B:55:0x0192, B:57:0x0198, B:61:0x068e, B:62:0x01bb, B:64:0x01c8, B:65:0x01d5, B:68:0x01dd, B:69:0x01e6, B:71:0x01f5, B:72:0x0210, B:74:0x0218, B:79:0x0244, B:81:0x0276, B:83:0x027e, B:84:0x0287, B:86:0x028f, B:87:0x0297, B:89:0x029f, B:90:0x02a7, B:92:0x02af, B:93:0x02b7, B:95:0x02c0, B:96:0x02c9, B:98:0x02d1, B:99:0x02d9, B:101:0x02e2, B:102:0x02eb, B:104:0x02f5, B:105:0x02fd, B:107:0x0305, B:108:0x030d, B:110:0x0315, B:111:0x031d, B:113:0x0323, B:114:0x0329, B:116:0x0331, B:117:0x0339, B:119:0x0341, B:120:0x0349, B:122:0x0352, B:123:0x0367, B:125:0x0370, B:126:0x0385, B:128:0x038e, B:129:0x0397, B:131:0x039f, B:132:0x03a7, B:134:0x03af, B:135:0x03b7, B:137:0x03bf, B:138:0x03c7, B:140:0x03cf, B:141:0x03dd, B:143:0x03e5, B:144:0x03f1, B:146:0x03f9, B:147:0x0405, B:149:0x040d, B:150:0x0418, B:152:0x0420, B:153:0x042b, B:155:0x0433, B:156:0x043f, B:158:0x0447, B:159:0x0453, B:161:0x045b, B:162:0x0463, B:164:0x046b, B:165:0x0476, B:167:0x047f, B:168:0x048b, B:170:0x0493, B:171:0x049f, B:173:0x04a7, B:174:0x04b4, B:176:0x04bc, B:177:0x04c7, B:179:0x04cf, B:180:0x04da, B:182:0x04e2, B:185:0x04ee, B:187:0x050f, B:221:0x068b, B:234:0x057d, B:240:0x058f, B:379:0x05b5, B:381:0x05bb, B:329:0x06f9, B:332:0x06ff, B:334:0x0705, B:335:0x070e, B:337:0x0714, B:338:0x071c, B:340:0x0722, B:341:0x072a, B:343:0x0730, B:344:0x0738, B:346:0x073e, B:347:0x0746, B:349:0x074c, B:350:0x0754, B:354:0x075e, B:355:0x0766, B:356:0x076e, B:358:0x0774, B:359:0x077c, B:361:0x0782, B:362:0x078b, B:364:0x0791, B:374:0x05ce, B:377:0x05d4, B:369:0x05e4, B:370:0x05e7, B:372:0x05ed, B:289:0x05fb, B:365:0x0601, B:262:0x0612, B:266:0x061f, B:268:0x0625, B:281:0x0654, B:285:0x065c, B:287:0x0662, B:384:0x066a, B:390:0x0679, B:392:0x04d8, B:393:0x04c5, B:394:0x04b1, B:401:0x0489, B:402:0x0474, B:403:0x0450, B:404:0x043c, B:405:0x0429, B:406:0x0416, B:407:0x0402, B:408:0x03ee, B:409:0x03da, B:410:0x023e, B:411:0x022f, B:412:0x024b, B:414:0x0256, B:416:0x025e, B:417:0x01fc, B:419:0x0204, B:420:0x020d, B:421:0x01e4, B:422:0x01d2, B:453:0x0138, B:456:0x0149, B:459:0x015c, B:463:0x016b, B:465:0x017f, B:466:0x0185), top: B:27:0x0068 }] */
    /* JADX WARN: Removed duplicated region for block: B:137:0x03bf A[Catch: JSONException -> 0x009d, TryCatch #1 {JSONException -> 0x009d, blocks: (B:28:0x0068, B:31:0x007a, B:33:0x0080, B:35:0x0094, B:36:0x00a0, B:38:0x00a8, B:39:0x00b0, B:41:0x00b6, B:42:0x00bc, B:44:0x00c5, B:46:0x00cd, B:48:0x00f2, B:55:0x0192, B:57:0x0198, B:61:0x068e, B:62:0x01bb, B:64:0x01c8, B:65:0x01d5, B:68:0x01dd, B:69:0x01e6, B:71:0x01f5, B:72:0x0210, B:74:0x0218, B:79:0x0244, B:81:0x0276, B:83:0x027e, B:84:0x0287, B:86:0x028f, B:87:0x0297, B:89:0x029f, B:90:0x02a7, B:92:0x02af, B:93:0x02b7, B:95:0x02c0, B:96:0x02c9, B:98:0x02d1, B:99:0x02d9, B:101:0x02e2, B:102:0x02eb, B:104:0x02f5, B:105:0x02fd, B:107:0x0305, B:108:0x030d, B:110:0x0315, B:111:0x031d, B:113:0x0323, B:114:0x0329, B:116:0x0331, B:117:0x0339, B:119:0x0341, B:120:0x0349, B:122:0x0352, B:123:0x0367, B:125:0x0370, B:126:0x0385, B:128:0x038e, B:129:0x0397, B:131:0x039f, B:132:0x03a7, B:134:0x03af, B:135:0x03b7, B:137:0x03bf, B:138:0x03c7, B:140:0x03cf, B:141:0x03dd, B:143:0x03e5, B:144:0x03f1, B:146:0x03f9, B:147:0x0405, B:149:0x040d, B:150:0x0418, B:152:0x0420, B:153:0x042b, B:155:0x0433, B:156:0x043f, B:158:0x0447, B:159:0x0453, B:161:0x045b, B:162:0x0463, B:164:0x046b, B:165:0x0476, B:167:0x047f, B:168:0x048b, B:170:0x0493, B:171:0x049f, B:173:0x04a7, B:174:0x04b4, B:176:0x04bc, B:177:0x04c7, B:179:0x04cf, B:180:0x04da, B:182:0x04e2, B:185:0x04ee, B:187:0x050f, B:221:0x068b, B:234:0x057d, B:240:0x058f, B:379:0x05b5, B:381:0x05bb, B:329:0x06f9, B:332:0x06ff, B:334:0x0705, B:335:0x070e, B:337:0x0714, B:338:0x071c, B:340:0x0722, B:341:0x072a, B:343:0x0730, B:344:0x0738, B:346:0x073e, B:347:0x0746, B:349:0x074c, B:350:0x0754, B:354:0x075e, B:355:0x0766, B:356:0x076e, B:358:0x0774, B:359:0x077c, B:361:0x0782, B:362:0x078b, B:364:0x0791, B:374:0x05ce, B:377:0x05d4, B:369:0x05e4, B:370:0x05e7, B:372:0x05ed, B:289:0x05fb, B:365:0x0601, B:262:0x0612, B:266:0x061f, B:268:0x0625, B:281:0x0654, B:285:0x065c, B:287:0x0662, B:384:0x066a, B:390:0x0679, B:392:0x04d8, B:393:0x04c5, B:394:0x04b1, B:401:0x0489, B:402:0x0474, B:403:0x0450, B:404:0x043c, B:405:0x0429, B:406:0x0416, B:407:0x0402, B:408:0x03ee, B:409:0x03da, B:410:0x023e, B:411:0x022f, B:412:0x024b, B:414:0x0256, B:416:0x025e, B:417:0x01fc, B:419:0x0204, B:420:0x020d, B:421:0x01e4, B:422:0x01d2, B:453:0x0138, B:456:0x0149, B:459:0x015c, B:463:0x016b, B:465:0x017f, B:466:0x0185), top: B:27:0x0068 }] */
    /* JADX WARN: Removed duplicated region for block: B:140:0x03cf A[Catch: JSONException -> 0x009d, TryCatch #1 {JSONException -> 0x009d, blocks: (B:28:0x0068, B:31:0x007a, B:33:0x0080, B:35:0x0094, B:36:0x00a0, B:38:0x00a8, B:39:0x00b0, B:41:0x00b6, B:42:0x00bc, B:44:0x00c5, B:46:0x00cd, B:48:0x00f2, B:55:0x0192, B:57:0x0198, B:61:0x068e, B:62:0x01bb, B:64:0x01c8, B:65:0x01d5, B:68:0x01dd, B:69:0x01e6, B:71:0x01f5, B:72:0x0210, B:74:0x0218, B:79:0x0244, B:81:0x0276, B:83:0x027e, B:84:0x0287, B:86:0x028f, B:87:0x0297, B:89:0x029f, B:90:0x02a7, B:92:0x02af, B:93:0x02b7, B:95:0x02c0, B:96:0x02c9, B:98:0x02d1, B:99:0x02d9, B:101:0x02e2, B:102:0x02eb, B:104:0x02f5, B:105:0x02fd, B:107:0x0305, B:108:0x030d, B:110:0x0315, B:111:0x031d, B:113:0x0323, B:114:0x0329, B:116:0x0331, B:117:0x0339, B:119:0x0341, B:120:0x0349, B:122:0x0352, B:123:0x0367, B:125:0x0370, B:126:0x0385, B:128:0x038e, B:129:0x0397, B:131:0x039f, B:132:0x03a7, B:134:0x03af, B:135:0x03b7, B:137:0x03bf, B:138:0x03c7, B:140:0x03cf, B:141:0x03dd, B:143:0x03e5, B:144:0x03f1, B:146:0x03f9, B:147:0x0405, B:149:0x040d, B:150:0x0418, B:152:0x0420, B:153:0x042b, B:155:0x0433, B:156:0x043f, B:158:0x0447, B:159:0x0453, B:161:0x045b, B:162:0x0463, B:164:0x046b, B:165:0x0476, B:167:0x047f, B:168:0x048b, B:170:0x0493, B:171:0x049f, B:173:0x04a7, B:174:0x04b4, B:176:0x04bc, B:177:0x04c7, B:179:0x04cf, B:180:0x04da, B:182:0x04e2, B:185:0x04ee, B:187:0x050f, B:221:0x068b, B:234:0x057d, B:240:0x058f, B:379:0x05b5, B:381:0x05bb, B:329:0x06f9, B:332:0x06ff, B:334:0x0705, B:335:0x070e, B:337:0x0714, B:338:0x071c, B:340:0x0722, B:341:0x072a, B:343:0x0730, B:344:0x0738, B:346:0x073e, B:347:0x0746, B:349:0x074c, B:350:0x0754, B:354:0x075e, B:355:0x0766, B:356:0x076e, B:358:0x0774, B:359:0x077c, B:361:0x0782, B:362:0x078b, B:364:0x0791, B:374:0x05ce, B:377:0x05d4, B:369:0x05e4, B:370:0x05e7, B:372:0x05ed, B:289:0x05fb, B:365:0x0601, B:262:0x0612, B:266:0x061f, B:268:0x0625, B:281:0x0654, B:285:0x065c, B:287:0x0662, B:384:0x066a, B:390:0x0679, B:392:0x04d8, B:393:0x04c5, B:394:0x04b1, B:401:0x0489, B:402:0x0474, B:403:0x0450, B:404:0x043c, B:405:0x0429, B:406:0x0416, B:407:0x0402, B:408:0x03ee, B:409:0x03da, B:410:0x023e, B:411:0x022f, B:412:0x024b, B:414:0x0256, B:416:0x025e, B:417:0x01fc, B:419:0x0204, B:420:0x020d, B:421:0x01e4, B:422:0x01d2, B:453:0x0138, B:456:0x0149, B:459:0x015c, B:463:0x016b, B:465:0x017f, B:466:0x0185), top: B:27:0x0068 }] */
    /* JADX WARN: Removed duplicated region for block: B:143:0x03e5 A[Catch: JSONException -> 0x009d, TryCatch #1 {JSONException -> 0x009d, blocks: (B:28:0x0068, B:31:0x007a, B:33:0x0080, B:35:0x0094, B:36:0x00a0, B:38:0x00a8, B:39:0x00b0, B:41:0x00b6, B:42:0x00bc, B:44:0x00c5, B:46:0x00cd, B:48:0x00f2, B:55:0x0192, B:57:0x0198, B:61:0x068e, B:62:0x01bb, B:64:0x01c8, B:65:0x01d5, B:68:0x01dd, B:69:0x01e6, B:71:0x01f5, B:72:0x0210, B:74:0x0218, B:79:0x0244, B:81:0x0276, B:83:0x027e, B:84:0x0287, B:86:0x028f, B:87:0x0297, B:89:0x029f, B:90:0x02a7, B:92:0x02af, B:93:0x02b7, B:95:0x02c0, B:96:0x02c9, B:98:0x02d1, B:99:0x02d9, B:101:0x02e2, B:102:0x02eb, B:104:0x02f5, B:105:0x02fd, B:107:0x0305, B:108:0x030d, B:110:0x0315, B:111:0x031d, B:113:0x0323, B:114:0x0329, B:116:0x0331, B:117:0x0339, B:119:0x0341, B:120:0x0349, B:122:0x0352, B:123:0x0367, B:125:0x0370, B:126:0x0385, B:128:0x038e, B:129:0x0397, B:131:0x039f, B:132:0x03a7, B:134:0x03af, B:135:0x03b7, B:137:0x03bf, B:138:0x03c7, B:140:0x03cf, B:141:0x03dd, B:143:0x03e5, B:144:0x03f1, B:146:0x03f9, B:147:0x0405, B:149:0x040d, B:150:0x0418, B:152:0x0420, B:153:0x042b, B:155:0x0433, B:156:0x043f, B:158:0x0447, B:159:0x0453, B:161:0x045b, B:162:0x0463, B:164:0x046b, B:165:0x0476, B:167:0x047f, B:168:0x048b, B:170:0x0493, B:171:0x049f, B:173:0x04a7, B:174:0x04b4, B:176:0x04bc, B:177:0x04c7, B:179:0x04cf, B:180:0x04da, B:182:0x04e2, B:185:0x04ee, B:187:0x050f, B:221:0x068b, B:234:0x057d, B:240:0x058f, B:379:0x05b5, B:381:0x05bb, B:329:0x06f9, B:332:0x06ff, B:334:0x0705, B:335:0x070e, B:337:0x0714, B:338:0x071c, B:340:0x0722, B:341:0x072a, B:343:0x0730, B:344:0x0738, B:346:0x073e, B:347:0x0746, B:349:0x074c, B:350:0x0754, B:354:0x075e, B:355:0x0766, B:356:0x076e, B:358:0x0774, B:359:0x077c, B:361:0x0782, B:362:0x078b, B:364:0x0791, B:374:0x05ce, B:377:0x05d4, B:369:0x05e4, B:370:0x05e7, B:372:0x05ed, B:289:0x05fb, B:365:0x0601, B:262:0x0612, B:266:0x061f, B:268:0x0625, B:281:0x0654, B:285:0x065c, B:287:0x0662, B:384:0x066a, B:390:0x0679, B:392:0x04d8, B:393:0x04c5, B:394:0x04b1, B:401:0x0489, B:402:0x0474, B:403:0x0450, B:404:0x043c, B:405:0x0429, B:406:0x0416, B:407:0x0402, B:408:0x03ee, B:409:0x03da, B:410:0x023e, B:411:0x022f, B:412:0x024b, B:414:0x0256, B:416:0x025e, B:417:0x01fc, B:419:0x0204, B:420:0x020d, B:421:0x01e4, B:422:0x01d2, B:453:0x0138, B:456:0x0149, B:459:0x015c, B:463:0x016b, B:465:0x017f, B:466:0x0185), top: B:27:0x0068 }] */
    /* JADX WARN: Removed duplicated region for block: B:146:0x03f9 A[Catch: JSONException -> 0x009d, TryCatch #1 {JSONException -> 0x009d, blocks: (B:28:0x0068, B:31:0x007a, B:33:0x0080, B:35:0x0094, B:36:0x00a0, B:38:0x00a8, B:39:0x00b0, B:41:0x00b6, B:42:0x00bc, B:44:0x00c5, B:46:0x00cd, B:48:0x00f2, B:55:0x0192, B:57:0x0198, B:61:0x068e, B:62:0x01bb, B:64:0x01c8, B:65:0x01d5, B:68:0x01dd, B:69:0x01e6, B:71:0x01f5, B:72:0x0210, B:74:0x0218, B:79:0x0244, B:81:0x0276, B:83:0x027e, B:84:0x0287, B:86:0x028f, B:87:0x0297, B:89:0x029f, B:90:0x02a7, B:92:0x02af, B:93:0x02b7, B:95:0x02c0, B:96:0x02c9, B:98:0x02d1, B:99:0x02d9, B:101:0x02e2, B:102:0x02eb, B:104:0x02f5, B:105:0x02fd, B:107:0x0305, B:108:0x030d, B:110:0x0315, B:111:0x031d, B:113:0x0323, B:114:0x0329, B:116:0x0331, B:117:0x0339, B:119:0x0341, B:120:0x0349, B:122:0x0352, B:123:0x0367, B:125:0x0370, B:126:0x0385, B:128:0x038e, B:129:0x0397, B:131:0x039f, B:132:0x03a7, B:134:0x03af, B:135:0x03b7, B:137:0x03bf, B:138:0x03c7, B:140:0x03cf, B:141:0x03dd, B:143:0x03e5, B:144:0x03f1, B:146:0x03f9, B:147:0x0405, B:149:0x040d, B:150:0x0418, B:152:0x0420, B:153:0x042b, B:155:0x0433, B:156:0x043f, B:158:0x0447, B:159:0x0453, B:161:0x045b, B:162:0x0463, B:164:0x046b, B:165:0x0476, B:167:0x047f, B:168:0x048b, B:170:0x0493, B:171:0x049f, B:173:0x04a7, B:174:0x04b4, B:176:0x04bc, B:177:0x04c7, B:179:0x04cf, B:180:0x04da, B:182:0x04e2, B:185:0x04ee, B:187:0x050f, B:221:0x068b, B:234:0x057d, B:240:0x058f, B:379:0x05b5, B:381:0x05bb, B:329:0x06f9, B:332:0x06ff, B:334:0x0705, B:335:0x070e, B:337:0x0714, B:338:0x071c, B:340:0x0722, B:341:0x072a, B:343:0x0730, B:344:0x0738, B:346:0x073e, B:347:0x0746, B:349:0x074c, B:350:0x0754, B:354:0x075e, B:355:0x0766, B:356:0x076e, B:358:0x0774, B:359:0x077c, B:361:0x0782, B:362:0x078b, B:364:0x0791, B:374:0x05ce, B:377:0x05d4, B:369:0x05e4, B:370:0x05e7, B:372:0x05ed, B:289:0x05fb, B:365:0x0601, B:262:0x0612, B:266:0x061f, B:268:0x0625, B:281:0x0654, B:285:0x065c, B:287:0x0662, B:384:0x066a, B:390:0x0679, B:392:0x04d8, B:393:0x04c5, B:394:0x04b1, B:401:0x0489, B:402:0x0474, B:403:0x0450, B:404:0x043c, B:405:0x0429, B:406:0x0416, B:407:0x0402, B:408:0x03ee, B:409:0x03da, B:410:0x023e, B:411:0x022f, B:412:0x024b, B:414:0x0256, B:416:0x025e, B:417:0x01fc, B:419:0x0204, B:420:0x020d, B:421:0x01e4, B:422:0x01d2, B:453:0x0138, B:456:0x0149, B:459:0x015c, B:463:0x016b, B:465:0x017f, B:466:0x0185), top: B:27:0x0068 }] */
    /* JADX WARN: Removed duplicated region for block: B:149:0x040d A[Catch: JSONException -> 0x009d, TryCatch #1 {JSONException -> 0x009d, blocks: (B:28:0x0068, B:31:0x007a, B:33:0x0080, B:35:0x0094, B:36:0x00a0, B:38:0x00a8, B:39:0x00b0, B:41:0x00b6, B:42:0x00bc, B:44:0x00c5, B:46:0x00cd, B:48:0x00f2, B:55:0x0192, B:57:0x0198, B:61:0x068e, B:62:0x01bb, B:64:0x01c8, B:65:0x01d5, B:68:0x01dd, B:69:0x01e6, B:71:0x01f5, B:72:0x0210, B:74:0x0218, B:79:0x0244, B:81:0x0276, B:83:0x027e, B:84:0x0287, B:86:0x028f, B:87:0x0297, B:89:0x029f, B:90:0x02a7, B:92:0x02af, B:93:0x02b7, B:95:0x02c0, B:96:0x02c9, B:98:0x02d1, B:99:0x02d9, B:101:0x02e2, B:102:0x02eb, B:104:0x02f5, B:105:0x02fd, B:107:0x0305, B:108:0x030d, B:110:0x0315, B:111:0x031d, B:113:0x0323, B:114:0x0329, B:116:0x0331, B:117:0x0339, B:119:0x0341, B:120:0x0349, B:122:0x0352, B:123:0x0367, B:125:0x0370, B:126:0x0385, B:128:0x038e, B:129:0x0397, B:131:0x039f, B:132:0x03a7, B:134:0x03af, B:135:0x03b7, B:137:0x03bf, B:138:0x03c7, B:140:0x03cf, B:141:0x03dd, B:143:0x03e5, B:144:0x03f1, B:146:0x03f9, B:147:0x0405, B:149:0x040d, B:150:0x0418, B:152:0x0420, B:153:0x042b, B:155:0x0433, B:156:0x043f, B:158:0x0447, B:159:0x0453, B:161:0x045b, B:162:0x0463, B:164:0x046b, B:165:0x0476, B:167:0x047f, B:168:0x048b, B:170:0x0493, B:171:0x049f, B:173:0x04a7, B:174:0x04b4, B:176:0x04bc, B:177:0x04c7, B:179:0x04cf, B:180:0x04da, B:182:0x04e2, B:185:0x04ee, B:187:0x050f, B:221:0x068b, B:234:0x057d, B:240:0x058f, B:379:0x05b5, B:381:0x05bb, B:329:0x06f9, B:332:0x06ff, B:334:0x0705, B:335:0x070e, B:337:0x0714, B:338:0x071c, B:340:0x0722, B:341:0x072a, B:343:0x0730, B:344:0x0738, B:346:0x073e, B:347:0x0746, B:349:0x074c, B:350:0x0754, B:354:0x075e, B:355:0x0766, B:356:0x076e, B:358:0x0774, B:359:0x077c, B:361:0x0782, B:362:0x078b, B:364:0x0791, B:374:0x05ce, B:377:0x05d4, B:369:0x05e4, B:370:0x05e7, B:372:0x05ed, B:289:0x05fb, B:365:0x0601, B:262:0x0612, B:266:0x061f, B:268:0x0625, B:281:0x0654, B:285:0x065c, B:287:0x0662, B:384:0x066a, B:390:0x0679, B:392:0x04d8, B:393:0x04c5, B:394:0x04b1, B:401:0x0489, B:402:0x0474, B:403:0x0450, B:404:0x043c, B:405:0x0429, B:406:0x0416, B:407:0x0402, B:408:0x03ee, B:409:0x03da, B:410:0x023e, B:411:0x022f, B:412:0x024b, B:414:0x0256, B:416:0x025e, B:417:0x01fc, B:419:0x0204, B:420:0x020d, B:421:0x01e4, B:422:0x01d2, B:453:0x0138, B:456:0x0149, B:459:0x015c, B:463:0x016b, B:465:0x017f, B:466:0x0185), top: B:27:0x0068 }] */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0420 A[Catch: JSONException -> 0x009d, TryCatch #1 {JSONException -> 0x009d, blocks: (B:28:0x0068, B:31:0x007a, B:33:0x0080, B:35:0x0094, B:36:0x00a0, B:38:0x00a8, B:39:0x00b0, B:41:0x00b6, B:42:0x00bc, B:44:0x00c5, B:46:0x00cd, B:48:0x00f2, B:55:0x0192, B:57:0x0198, B:61:0x068e, B:62:0x01bb, B:64:0x01c8, B:65:0x01d5, B:68:0x01dd, B:69:0x01e6, B:71:0x01f5, B:72:0x0210, B:74:0x0218, B:79:0x0244, B:81:0x0276, B:83:0x027e, B:84:0x0287, B:86:0x028f, B:87:0x0297, B:89:0x029f, B:90:0x02a7, B:92:0x02af, B:93:0x02b7, B:95:0x02c0, B:96:0x02c9, B:98:0x02d1, B:99:0x02d9, B:101:0x02e2, B:102:0x02eb, B:104:0x02f5, B:105:0x02fd, B:107:0x0305, B:108:0x030d, B:110:0x0315, B:111:0x031d, B:113:0x0323, B:114:0x0329, B:116:0x0331, B:117:0x0339, B:119:0x0341, B:120:0x0349, B:122:0x0352, B:123:0x0367, B:125:0x0370, B:126:0x0385, B:128:0x038e, B:129:0x0397, B:131:0x039f, B:132:0x03a7, B:134:0x03af, B:135:0x03b7, B:137:0x03bf, B:138:0x03c7, B:140:0x03cf, B:141:0x03dd, B:143:0x03e5, B:144:0x03f1, B:146:0x03f9, B:147:0x0405, B:149:0x040d, B:150:0x0418, B:152:0x0420, B:153:0x042b, B:155:0x0433, B:156:0x043f, B:158:0x0447, B:159:0x0453, B:161:0x045b, B:162:0x0463, B:164:0x046b, B:165:0x0476, B:167:0x047f, B:168:0x048b, B:170:0x0493, B:171:0x049f, B:173:0x04a7, B:174:0x04b4, B:176:0x04bc, B:177:0x04c7, B:179:0x04cf, B:180:0x04da, B:182:0x04e2, B:185:0x04ee, B:187:0x050f, B:221:0x068b, B:234:0x057d, B:240:0x058f, B:379:0x05b5, B:381:0x05bb, B:329:0x06f9, B:332:0x06ff, B:334:0x0705, B:335:0x070e, B:337:0x0714, B:338:0x071c, B:340:0x0722, B:341:0x072a, B:343:0x0730, B:344:0x0738, B:346:0x073e, B:347:0x0746, B:349:0x074c, B:350:0x0754, B:354:0x075e, B:355:0x0766, B:356:0x076e, B:358:0x0774, B:359:0x077c, B:361:0x0782, B:362:0x078b, B:364:0x0791, B:374:0x05ce, B:377:0x05d4, B:369:0x05e4, B:370:0x05e7, B:372:0x05ed, B:289:0x05fb, B:365:0x0601, B:262:0x0612, B:266:0x061f, B:268:0x0625, B:281:0x0654, B:285:0x065c, B:287:0x0662, B:384:0x066a, B:390:0x0679, B:392:0x04d8, B:393:0x04c5, B:394:0x04b1, B:401:0x0489, B:402:0x0474, B:403:0x0450, B:404:0x043c, B:405:0x0429, B:406:0x0416, B:407:0x0402, B:408:0x03ee, B:409:0x03da, B:410:0x023e, B:411:0x022f, B:412:0x024b, B:414:0x0256, B:416:0x025e, B:417:0x01fc, B:419:0x0204, B:420:0x020d, B:421:0x01e4, B:422:0x01d2, B:453:0x0138, B:456:0x0149, B:459:0x015c, B:463:0x016b, B:465:0x017f, B:466:0x0185), top: B:27:0x0068 }] */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0433 A[Catch: JSONException -> 0x009d, TryCatch #1 {JSONException -> 0x009d, blocks: (B:28:0x0068, B:31:0x007a, B:33:0x0080, B:35:0x0094, B:36:0x00a0, B:38:0x00a8, B:39:0x00b0, B:41:0x00b6, B:42:0x00bc, B:44:0x00c5, B:46:0x00cd, B:48:0x00f2, B:55:0x0192, B:57:0x0198, B:61:0x068e, B:62:0x01bb, B:64:0x01c8, B:65:0x01d5, B:68:0x01dd, B:69:0x01e6, B:71:0x01f5, B:72:0x0210, B:74:0x0218, B:79:0x0244, B:81:0x0276, B:83:0x027e, B:84:0x0287, B:86:0x028f, B:87:0x0297, B:89:0x029f, B:90:0x02a7, B:92:0x02af, B:93:0x02b7, B:95:0x02c0, B:96:0x02c9, B:98:0x02d1, B:99:0x02d9, B:101:0x02e2, B:102:0x02eb, B:104:0x02f5, B:105:0x02fd, B:107:0x0305, B:108:0x030d, B:110:0x0315, B:111:0x031d, B:113:0x0323, B:114:0x0329, B:116:0x0331, B:117:0x0339, B:119:0x0341, B:120:0x0349, B:122:0x0352, B:123:0x0367, B:125:0x0370, B:126:0x0385, B:128:0x038e, B:129:0x0397, B:131:0x039f, B:132:0x03a7, B:134:0x03af, B:135:0x03b7, B:137:0x03bf, B:138:0x03c7, B:140:0x03cf, B:141:0x03dd, B:143:0x03e5, B:144:0x03f1, B:146:0x03f9, B:147:0x0405, B:149:0x040d, B:150:0x0418, B:152:0x0420, B:153:0x042b, B:155:0x0433, B:156:0x043f, B:158:0x0447, B:159:0x0453, B:161:0x045b, B:162:0x0463, B:164:0x046b, B:165:0x0476, B:167:0x047f, B:168:0x048b, B:170:0x0493, B:171:0x049f, B:173:0x04a7, B:174:0x04b4, B:176:0x04bc, B:177:0x04c7, B:179:0x04cf, B:180:0x04da, B:182:0x04e2, B:185:0x04ee, B:187:0x050f, B:221:0x068b, B:234:0x057d, B:240:0x058f, B:379:0x05b5, B:381:0x05bb, B:329:0x06f9, B:332:0x06ff, B:334:0x0705, B:335:0x070e, B:337:0x0714, B:338:0x071c, B:340:0x0722, B:341:0x072a, B:343:0x0730, B:344:0x0738, B:346:0x073e, B:347:0x0746, B:349:0x074c, B:350:0x0754, B:354:0x075e, B:355:0x0766, B:356:0x076e, B:358:0x0774, B:359:0x077c, B:361:0x0782, B:362:0x078b, B:364:0x0791, B:374:0x05ce, B:377:0x05d4, B:369:0x05e4, B:370:0x05e7, B:372:0x05ed, B:289:0x05fb, B:365:0x0601, B:262:0x0612, B:266:0x061f, B:268:0x0625, B:281:0x0654, B:285:0x065c, B:287:0x0662, B:384:0x066a, B:390:0x0679, B:392:0x04d8, B:393:0x04c5, B:394:0x04b1, B:401:0x0489, B:402:0x0474, B:403:0x0450, B:404:0x043c, B:405:0x0429, B:406:0x0416, B:407:0x0402, B:408:0x03ee, B:409:0x03da, B:410:0x023e, B:411:0x022f, B:412:0x024b, B:414:0x0256, B:416:0x025e, B:417:0x01fc, B:419:0x0204, B:420:0x020d, B:421:0x01e4, B:422:0x01d2, B:453:0x0138, B:456:0x0149, B:459:0x015c, B:463:0x016b, B:465:0x017f, B:466:0x0185), top: B:27:0x0068 }] */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0447 A[Catch: JSONException -> 0x009d, TryCatch #1 {JSONException -> 0x009d, blocks: (B:28:0x0068, B:31:0x007a, B:33:0x0080, B:35:0x0094, B:36:0x00a0, B:38:0x00a8, B:39:0x00b0, B:41:0x00b6, B:42:0x00bc, B:44:0x00c5, B:46:0x00cd, B:48:0x00f2, B:55:0x0192, B:57:0x0198, B:61:0x068e, B:62:0x01bb, B:64:0x01c8, B:65:0x01d5, B:68:0x01dd, B:69:0x01e6, B:71:0x01f5, B:72:0x0210, B:74:0x0218, B:79:0x0244, B:81:0x0276, B:83:0x027e, B:84:0x0287, B:86:0x028f, B:87:0x0297, B:89:0x029f, B:90:0x02a7, B:92:0x02af, B:93:0x02b7, B:95:0x02c0, B:96:0x02c9, B:98:0x02d1, B:99:0x02d9, B:101:0x02e2, B:102:0x02eb, B:104:0x02f5, B:105:0x02fd, B:107:0x0305, B:108:0x030d, B:110:0x0315, B:111:0x031d, B:113:0x0323, B:114:0x0329, B:116:0x0331, B:117:0x0339, B:119:0x0341, B:120:0x0349, B:122:0x0352, B:123:0x0367, B:125:0x0370, B:126:0x0385, B:128:0x038e, B:129:0x0397, B:131:0x039f, B:132:0x03a7, B:134:0x03af, B:135:0x03b7, B:137:0x03bf, B:138:0x03c7, B:140:0x03cf, B:141:0x03dd, B:143:0x03e5, B:144:0x03f1, B:146:0x03f9, B:147:0x0405, B:149:0x040d, B:150:0x0418, B:152:0x0420, B:153:0x042b, B:155:0x0433, B:156:0x043f, B:158:0x0447, B:159:0x0453, B:161:0x045b, B:162:0x0463, B:164:0x046b, B:165:0x0476, B:167:0x047f, B:168:0x048b, B:170:0x0493, B:171:0x049f, B:173:0x04a7, B:174:0x04b4, B:176:0x04bc, B:177:0x04c7, B:179:0x04cf, B:180:0x04da, B:182:0x04e2, B:185:0x04ee, B:187:0x050f, B:221:0x068b, B:234:0x057d, B:240:0x058f, B:379:0x05b5, B:381:0x05bb, B:329:0x06f9, B:332:0x06ff, B:334:0x0705, B:335:0x070e, B:337:0x0714, B:338:0x071c, B:340:0x0722, B:341:0x072a, B:343:0x0730, B:344:0x0738, B:346:0x073e, B:347:0x0746, B:349:0x074c, B:350:0x0754, B:354:0x075e, B:355:0x0766, B:356:0x076e, B:358:0x0774, B:359:0x077c, B:361:0x0782, B:362:0x078b, B:364:0x0791, B:374:0x05ce, B:377:0x05d4, B:369:0x05e4, B:370:0x05e7, B:372:0x05ed, B:289:0x05fb, B:365:0x0601, B:262:0x0612, B:266:0x061f, B:268:0x0625, B:281:0x0654, B:285:0x065c, B:287:0x0662, B:384:0x066a, B:390:0x0679, B:392:0x04d8, B:393:0x04c5, B:394:0x04b1, B:401:0x0489, B:402:0x0474, B:403:0x0450, B:404:0x043c, B:405:0x0429, B:406:0x0416, B:407:0x0402, B:408:0x03ee, B:409:0x03da, B:410:0x023e, B:411:0x022f, B:412:0x024b, B:414:0x0256, B:416:0x025e, B:417:0x01fc, B:419:0x0204, B:420:0x020d, B:421:0x01e4, B:422:0x01d2, B:453:0x0138, B:456:0x0149, B:459:0x015c, B:463:0x016b, B:465:0x017f, B:466:0x0185), top: B:27:0x0068 }] */
    /* JADX WARN: Removed duplicated region for block: B:161:0x045b A[Catch: JSONException -> 0x009d, TryCatch #1 {JSONException -> 0x009d, blocks: (B:28:0x0068, B:31:0x007a, B:33:0x0080, B:35:0x0094, B:36:0x00a0, B:38:0x00a8, B:39:0x00b0, B:41:0x00b6, B:42:0x00bc, B:44:0x00c5, B:46:0x00cd, B:48:0x00f2, B:55:0x0192, B:57:0x0198, B:61:0x068e, B:62:0x01bb, B:64:0x01c8, B:65:0x01d5, B:68:0x01dd, B:69:0x01e6, B:71:0x01f5, B:72:0x0210, B:74:0x0218, B:79:0x0244, B:81:0x0276, B:83:0x027e, B:84:0x0287, B:86:0x028f, B:87:0x0297, B:89:0x029f, B:90:0x02a7, B:92:0x02af, B:93:0x02b7, B:95:0x02c0, B:96:0x02c9, B:98:0x02d1, B:99:0x02d9, B:101:0x02e2, B:102:0x02eb, B:104:0x02f5, B:105:0x02fd, B:107:0x0305, B:108:0x030d, B:110:0x0315, B:111:0x031d, B:113:0x0323, B:114:0x0329, B:116:0x0331, B:117:0x0339, B:119:0x0341, B:120:0x0349, B:122:0x0352, B:123:0x0367, B:125:0x0370, B:126:0x0385, B:128:0x038e, B:129:0x0397, B:131:0x039f, B:132:0x03a7, B:134:0x03af, B:135:0x03b7, B:137:0x03bf, B:138:0x03c7, B:140:0x03cf, B:141:0x03dd, B:143:0x03e5, B:144:0x03f1, B:146:0x03f9, B:147:0x0405, B:149:0x040d, B:150:0x0418, B:152:0x0420, B:153:0x042b, B:155:0x0433, B:156:0x043f, B:158:0x0447, B:159:0x0453, B:161:0x045b, B:162:0x0463, B:164:0x046b, B:165:0x0476, B:167:0x047f, B:168:0x048b, B:170:0x0493, B:171:0x049f, B:173:0x04a7, B:174:0x04b4, B:176:0x04bc, B:177:0x04c7, B:179:0x04cf, B:180:0x04da, B:182:0x04e2, B:185:0x04ee, B:187:0x050f, B:221:0x068b, B:234:0x057d, B:240:0x058f, B:379:0x05b5, B:381:0x05bb, B:329:0x06f9, B:332:0x06ff, B:334:0x0705, B:335:0x070e, B:337:0x0714, B:338:0x071c, B:340:0x0722, B:341:0x072a, B:343:0x0730, B:344:0x0738, B:346:0x073e, B:347:0x0746, B:349:0x074c, B:350:0x0754, B:354:0x075e, B:355:0x0766, B:356:0x076e, B:358:0x0774, B:359:0x077c, B:361:0x0782, B:362:0x078b, B:364:0x0791, B:374:0x05ce, B:377:0x05d4, B:369:0x05e4, B:370:0x05e7, B:372:0x05ed, B:289:0x05fb, B:365:0x0601, B:262:0x0612, B:266:0x061f, B:268:0x0625, B:281:0x0654, B:285:0x065c, B:287:0x0662, B:384:0x066a, B:390:0x0679, B:392:0x04d8, B:393:0x04c5, B:394:0x04b1, B:401:0x0489, B:402:0x0474, B:403:0x0450, B:404:0x043c, B:405:0x0429, B:406:0x0416, B:407:0x0402, B:408:0x03ee, B:409:0x03da, B:410:0x023e, B:411:0x022f, B:412:0x024b, B:414:0x0256, B:416:0x025e, B:417:0x01fc, B:419:0x0204, B:420:0x020d, B:421:0x01e4, B:422:0x01d2, B:453:0x0138, B:456:0x0149, B:459:0x015c, B:463:0x016b, B:465:0x017f, B:466:0x0185), top: B:27:0x0068 }] */
    /* JADX WARN: Removed duplicated region for block: B:164:0x046b A[Catch: JSONException -> 0x009d, TryCatch #1 {JSONException -> 0x009d, blocks: (B:28:0x0068, B:31:0x007a, B:33:0x0080, B:35:0x0094, B:36:0x00a0, B:38:0x00a8, B:39:0x00b0, B:41:0x00b6, B:42:0x00bc, B:44:0x00c5, B:46:0x00cd, B:48:0x00f2, B:55:0x0192, B:57:0x0198, B:61:0x068e, B:62:0x01bb, B:64:0x01c8, B:65:0x01d5, B:68:0x01dd, B:69:0x01e6, B:71:0x01f5, B:72:0x0210, B:74:0x0218, B:79:0x0244, B:81:0x0276, B:83:0x027e, B:84:0x0287, B:86:0x028f, B:87:0x0297, B:89:0x029f, B:90:0x02a7, B:92:0x02af, B:93:0x02b7, B:95:0x02c0, B:96:0x02c9, B:98:0x02d1, B:99:0x02d9, B:101:0x02e2, B:102:0x02eb, B:104:0x02f5, B:105:0x02fd, B:107:0x0305, B:108:0x030d, B:110:0x0315, B:111:0x031d, B:113:0x0323, B:114:0x0329, B:116:0x0331, B:117:0x0339, B:119:0x0341, B:120:0x0349, B:122:0x0352, B:123:0x0367, B:125:0x0370, B:126:0x0385, B:128:0x038e, B:129:0x0397, B:131:0x039f, B:132:0x03a7, B:134:0x03af, B:135:0x03b7, B:137:0x03bf, B:138:0x03c7, B:140:0x03cf, B:141:0x03dd, B:143:0x03e5, B:144:0x03f1, B:146:0x03f9, B:147:0x0405, B:149:0x040d, B:150:0x0418, B:152:0x0420, B:153:0x042b, B:155:0x0433, B:156:0x043f, B:158:0x0447, B:159:0x0453, B:161:0x045b, B:162:0x0463, B:164:0x046b, B:165:0x0476, B:167:0x047f, B:168:0x048b, B:170:0x0493, B:171:0x049f, B:173:0x04a7, B:174:0x04b4, B:176:0x04bc, B:177:0x04c7, B:179:0x04cf, B:180:0x04da, B:182:0x04e2, B:185:0x04ee, B:187:0x050f, B:221:0x068b, B:234:0x057d, B:240:0x058f, B:379:0x05b5, B:381:0x05bb, B:329:0x06f9, B:332:0x06ff, B:334:0x0705, B:335:0x070e, B:337:0x0714, B:338:0x071c, B:340:0x0722, B:341:0x072a, B:343:0x0730, B:344:0x0738, B:346:0x073e, B:347:0x0746, B:349:0x074c, B:350:0x0754, B:354:0x075e, B:355:0x0766, B:356:0x076e, B:358:0x0774, B:359:0x077c, B:361:0x0782, B:362:0x078b, B:364:0x0791, B:374:0x05ce, B:377:0x05d4, B:369:0x05e4, B:370:0x05e7, B:372:0x05ed, B:289:0x05fb, B:365:0x0601, B:262:0x0612, B:266:0x061f, B:268:0x0625, B:281:0x0654, B:285:0x065c, B:287:0x0662, B:384:0x066a, B:390:0x0679, B:392:0x04d8, B:393:0x04c5, B:394:0x04b1, B:401:0x0489, B:402:0x0474, B:403:0x0450, B:404:0x043c, B:405:0x0429, B:406:0x0416, B:407:0x0402, B:408:0x03ee, B:409:0x03da, B:410:0x023e, B:411:0x022f, B:412:0x024b, B:414:0x0256, B:416:0x025e, B:417:0x01fc, B:419:0x0204, B:420:0x020d, B:421:0x01e4, B:422:0x01d2, B:453:0x0138, B:456:0x0149, B:459:0x015c, B:463:0x016b, B:465:0x017f, B:466:0x0185), top: B:27:0x0068 }] */
    /* JADX WARN: Removed duplicated region for block: B:167:0x047f A[Catch: JSONException -> 0x009d, TryCatch #1 {JSONException -> 0x009d, blocks: (B:28:0x0068, B:31:0x007a, B:33:0x0080, B:35:0x0094, B:36:0x00a0, B:38:0x00a8, B:39:0x00b0, B:41:0x00b6, B:42:0x00bc, B:44:0x00c5, B:46:0x00cd, B:48:0x00f2, B:55:0x0192, B:57:0x0198, B:61:0x068e, B:62:0x01bb, B:64:0x01c8, B:65:0x01d5, B:68:0x01dd, B:69:0x01e6, B:71:0x01f5, B:72:0x0210, B:74:0x0218, B:79:0x0244, B:81:0x0276, B:83:0x027e, B:84:0x0287, B:86:0x028f, B:87:0x0297, B:89:0x029f, B:90:0x02a7, B:92:0x02af, B:93:0x02b7, B:95:0x02c0, B:96:0x02c9, B:98:0x02d1, B:99:0x02d9, B:101:0x02e2, B:102:0x02eb, B:104:0x02f5, B:105:0x02fd, B:107:0x0305, B:108:0x030d, B:110:0x0315, B:111:0x031d, B:113:0x0323, B:114:0x0329, B:116:0x0331, B:117:0x0339, B:119:0x0341, B:120:0x0349, B:122:0x0352, B:123:0x0367, B:125:0x0370, B:126:0x0385, B:128:0x038e, B:129:0x0397, B:131:0x039f, B:132:0x03a7, B:134:0x03af, B:135:0x03b7, B:137:0x03bf, B:138:0x03c7, B:140:0x03cf, B:141:0x03dd, B:143:0x03e5, B:144:0x03f1, B:146:0x03f9, B:147:0x0405, B:149:0x040d, B:150:0x0418, B:152:0x0420, B:153:0x042b, B:155:0x0433, B:156:0x043f, B:158:0x0447, B:159:0x0453, B:161:0x045b, B:162:0x0463, B:164:0x046b, B:165:0x0476, B:167:0x047f, B:168:0x048b, B:170:0x0493, B:171:0x049f, B:173:0x04a7, B:174:0x04b4, B:176:0x04bc, B:177:0x04c7, B:179:0x04cf, B:180:0x04da, B:182:0x04e2, B:185:0x04ee, B:187:0x050f, B:221:0x068b, B:234:0x057d, B:240:0x058f, B:379:0x05b5, B:381:0x05bb, B:329:0x06f9, B:332:0x06ff, B:334:0x0705, B:335:0x070e, B:337:0x0714, B:338:0x071c, B:340:0x0722, B:341:0x072a, B:343:0x0730, B:344:0x0738, B:346:0x073e, B:347:0x0746, B:349:0x074c, B:350:0x0754, B:354:0x075e, B:355:0x0766, B:356:0x076e, B:358:0x0774, B:359:0x077c, B:361:0x0782, B:362:0x078b, B:364:0x0791, B:374:0x05ce, B:377:0x05d4, B:369:0x05e4, B:370:0x05e7, B:372:0x05ed, B:289:0x05fb, B:365:0x0601, B:262:0x0612, B:266:0x061f, B:268:0x0625, B:281:0x0654, B:285:0x065c, B:287:0x0662, B:384:0x066a, B:390:0x0679, B:392:0x04d8, B:393:0x04c5, B:394:0x04b1, B:401:0x0489, B:402:0x0474, B:403:0x0450, B:404:0x043c, B:405:0x0429, B:406:0x0416, B:407:0x0402, B:408:0x03ee, B:409:0x03da, B:410:0x023e, B:411:0x022f, B:412:0x024b, B:414:0x0256, B:416:0x025e, B:417:0x01fc, B:419:0x0204, B:420:0x020d, B:421:0x01e4, B:422:0x01d2, B:453:0x0138, B:456:0x0149, B:459:0x015c, B:463:0x016b, B:465:0x017f, B:466:0x0185), top: B:27:0x0068 }] */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0493 A[Catch: JSONException -> 0x009d, TRY_LEAVE, TryCatch #1 {JSONException -> 0x009d, blocks: (B:28:0x0068, B:31:0x007a, B:33:0x0080, B:35:0x0094, B:36:0x00a0, B:38:0x00a8, B:39:0x00b0, B:41:0x00b6, B:42:0x00bc, B:44:0x00c5, B:46:0x00cd, B:48:0x00f2, B:55:0x0192, B:57:0x0198, B:61:0x068e, B:62:0x01bb, B:64:0x01c8, B:65:0x01d5, B:68:0x01dd, B:69:0x01e6, B:71:0x01f5, B:72:0x0210, B:74:0x0218, B:79:0x0244, B:81:0x0276, B:83:0x027e, B:84:0x0287, B:86:0x028f, B:87:0x0297, B:89:0x029f, B:90:0x02a7, B:92:0x02af, B:93:0x02b7, B:95:0x02c0, B:96:0x02c9, B:98:0x02d1, B:99:0x02d9, B:101:0x02e2, B:102:0x02eb, B:104:0x02f5, B:105:0x02fd, B:107:0x0305, B:108:0x030d, B:110:0x0315, B:111:0x031d, B:113:0x0323, B:114:0x0329, B:116:0x0331, B:117:0x0339, B:119:0x0341, B:120:0x0349, B:122:0x0352, B:123:0x0367, B:125:0x0370, B:126:0x0385, B:128:0x038e, B:129:0x0397, B:131:0x039f, B:132:0x03a7, B:134:0x03af, B:135:0x03b7, B:137:0x03bf, B:138:0x03c7, B:140:0x03cf, B:141:0x03dd, B:143:0x03e5, B:144:0x03f1, B:146:0x03f9, B:147:0x0405, B:149:0x040d, B:150:0x0418, B:152:0x0420, B:153:0x042b, B:155:0x0433, B:156:0x043f, B:158:0x0447, B:159:0x0453, B:161:0x045b, B:162:0x0463, B:164:0x046b, B:165:0x0476, B:167:0x047f, B:168:0x048b, B:170:0x0493, B:171:0x049f, B:173:0x04a7, B:174:0x04b4, B:176:0x04bc, B:177:0x04c7, B:179:0x04cf, B:180:0x04da, B:182:0x04e2, B:185:0x04ee, B:187:0x050f, B:221:0x068b, B:234:0x057d, B:240:0x058f, B:379:0x05b5, B:381:0x05bb, B:329:0x06f9, B:332:0x06ff, B:334:0x0705, B:335:0x070e, B:337:0x0714, B:338:0x071c, B:340:0x0722, B:341:0x072a, B:343:0x0730, B:344:0x0738, B:346:0x073e, B:347:0x0746, B:349:0x074c, B:350:0x0754, B:354:0x075e, B:355:0x0766, B:356:0x076e, B:358:0x0774, B:359:0x077c, B:361:0x0782, B:362:0x078b, B:364:0x0791, B:374:0x05ce, B:377:0x05d4, B:369:0x05e4, B:370:0x05e7, B:372:0x05ed, B:289:0x05fb, B:365:0x0601, B:262:0x0612, B:266:0x061f, B:268:0x0625, B:281:0x0654, B:285:0x065c, B:287:0x0662, B:384:0x066a, B:390:0x0679, B:392:0x04d8, B:393:0x04c5, B:394:0x04b1, B:401:0x0489, B:402:0x0474, B:403:0x0450, B:404:0x043c, B:405:0x0429, B:406:0x0416, B:407:0x0402, B:408:0x03ee, B:409:0x03da, B:410:0x023e, B:411:0x022f, B:412:0x024b, B:414:0x0256, B:416:0x025e, B:417:0x01fc, B:419:0x0204, B:420:0x020d, B:421:0x01e4, B:422:0x01d2, B:453:0x0138, B:456:0x0149, B:459:0x015c, B:463:0x016b, B:465:0x017f, B:466:0x0185), top: B:27:0x0068 }] */
    /* JADX WARN: Removed duplicated region for block: B:173:0x04a7 A[Catch: JSONException -> 0x009d, TryCatch #1 {JSONException -> 0x009d, blocks: (B:28:0x0068, B:31:0x007a, B:33:0x0080, B:35:0x0094, B:36:0x00a0, B:38:0x00a8, B:39:0x00b0, B:41:0x00b6, B:42:0x00bc, B:44:0x00c5, B:46:0x00cd, B:48:0x00f2, B:55:0x0192, B:57:0x0198, B:61:0x068e, B:62:0x01bb, B:64:0x01c8, B:65:0x01d5, B:68:0x01dd, B:69:0x01e6, B:71:0x01f5, B:72:0x0210, B:74:0x0218, B:79:0x0244, B:81:0x0276, B:83:0x027e, B:84:0x0287, B:86:0x028f, B:87:0x0297, B:89:0x029f, B:90:0x02a7, B:92:0x02af, B:93:0x02b7, B:95:0x02c0, B:96:0x02c9, B:98:0x02d1, B:99:0x02d9, B:101:0x02e2, B:102:0x02eb, B:104:0x02f5, B:105:0x02fd, B:107:0x0305, B:108:0x030d, B:110:0x0315, B:111:0x031d, B:113:0x0323, B:114:0x0329, B:116:0x0331, B:117:0x0339, B:119:0x0341, B:120:0x0349, B:122:0x0352, B:123:0x0367, B:125:0x0370, B:126:0x0385, B:128:0x038e, B:129:0x0397, B:131:0x039f, B:132:0x03a7, B:134:0x03af, B:135:0x03b7, B:137:0x03bf, B:138:0x03c7, B:140:0x03cf, B:141:0x03dd, B:143:0x03e5, B:144:0x03f1, B:146:0x03f9, B:147:0x0405, B:149:0x040d, B:150:0x0418, B:152:0x0420, B:153:0x042b, B:155:0x0433, B:156:0x043f, B:158:0x0447, B:159:0x0453, B:161:0x045b, B:162:0x0463, B:164:0x046b, B:165:0x0476, B:167:0x047f, B:168:0x048b, B:170:0x0493, B:171:0x049f, B:173:0x04a7, B:174:0x04b4, B:176:0x04bc, B:177:0x04c7, B:179:0x04cf, B:180:0x04da, B:182:0x04e2, B:185:0x04ee, B:187:0x050f, B:221:0x068b, B:234:0x057d, B:240:0x058f, B:379:0x05b5, B:381:0x05bb, B:329:0x06f9, B:332:0x06ff, B:334:0x0705, B:335:0x070e, B:337:0x0714, B:338:0x071c, B:340:0x0722, B:341:0x072a, B:343:0x0730, B:344:0x0738, B:346:0x073e, B:347:0x0746, B:349:0x074c, B:350:0x0754, B:354:0x075e, B:355:0x0766, B:356:0x076e, B:358:0x0774, B:359:0x077c, B:361:0x0782, B:362:0x078b, B:364:0x0791, B:374:0x05ce, B:377:0x05d4, B:369:0x05e4, B:370:0x05e7, B:372:0x05ed, B:289:0x05fb, B:365:0x0601, B:262:0x0612, B:266:0x061f, B:268:0x0625, B:281:0x0654, B:285:0x065c, B:287:0x0662, B:384:0x066a, B:390:0x0679, B:392:0x04d8, B:393:0x04c5, B:394:0x04b1, B:401:0x0489, B:402:0x0474, B:403:0x0450, B:404:0x043c, B:405:0x0429, B:406:0x0416, B:407:0x0402, B:408:0x03ee, B:409:0x03da, B:410:0x023e, B:411:0x022f, B:412:0x024b, B:414:0x0256, B:416:0x025e, B:417:0x01fc, B:419:0x0204, B:420:0x020d, B:421:0x01e4, B:422:0x01d2, B:453:0x0138, B:456:0x0149, B:459:0x015c, B:463:0x016b, B:465:0x017f, B:466:0x0185), top: B:27:0x0068 }] */
    /* JADX WARN: Removed duplicated region for block: B:176:0x04bc A[Catch: JSONException -> 0x009d, TryCatch #1 {JSONException -> 0x009d, blocks: (B:28:0x0068, B:31:0x007a, B:33:0x0080, B:35:0x0094, B:36:0x00a0, B:38:0x00a8, B:39:0x00b0, B:41:0x00b6, B:42:0x00bc, B:44:0x00c5, B:46:0x00cd, B:48:0x00f2, B:55:0x0192, B:57:0x0198, B:61:0x068e, B:62:0x01bb, B:64:0x01c8, B:65:0x01d5, B:68:0x01dd, B:69:0x01e6, B:71:0x01f5, B:72:0x0210, B:74:0x0218, B:79:0x0244, B:81:0x0276, B:83:0x027e, B:84:0x0287, B:86:0x028f, B:87:0x0297, B:89:0x029f, B:90:0x02a7, B:92:0x02af, B:93:0x02b7, B:95:0x02c0, B:96:0x02c9, B:98:0x02d1, B:99:0x02d9, B:101:0x02e2, B:102:0x02eb, B:104:0x02f5, B:105:0x02fd, B:107:0x0305, B:108:0x030d, B:110:0x0315, B:111:0x031d, B:113:0x0323, B:114:0x0329, B:116:0x0331, B:117:0x0339, B:119:0x0341, B:120:0x0349, B:122:0x0352, B:123:0x0367, B:125:0x0370, B:126:0x0385, B:128:0x038e, B:129:0x0397, B:131:0x039f, B:132:0x03a7, B:134:0x03af, B:135:0x03b7, B:137:0x03bf, B:138:0x03c7, B:140:0x03cf, B:141:0x03dd, B:143:0x03e5, B:144:0x03f1, B:146:0x03f9, B:147:0x0405, B:149:0x040d, B:150:0x0418, B:152:0x0420, B:153:0x042b, B:155:0x0433, B:156:0x043f, B:158:0x0447, B:159:0x0453, B:161:0x045b, B:162:0x0463, B:164:0x046b, B:165:0x0476, B:167:0x047f, B:168:0x048b, B:170:0x0493, B:171:0x049f, B:173:0x04a7, B:174:0x04b4, B:176:0x04bc, B:177:0x04c7, B:179:0x04cf, B:180:0x04da, B:182:0x04e2, B:185:0x04ee, B:187:0x050f, B:221:0x068b, B:234:0x057d, B:240:0x058f, B:379:0x05b5, B:381:0x05bb, B:329:0x06f9, B:332:0x06ff, B:334:0x0705, B:335:0x070e, B:337:0x0714, B:338:0x071c, B:340:0x0722, B:341:0x072a, B:343:0x0730, B:344:0x0738, B:346:0x073e, B:347:0x0746, B:349:0x074c, B:350:0x0754, B:354:0x075e, B:355:0x0766, B:356:0x076e, B:358:0x0774, B:359:0x077c, B:361:0x0782, B:362:0x078b, B:364:0x0791, B:374:0x05ce, B:377:0x05d4, B:369:0x05e4, B:370:0x05e7, B:372:0x05ed, B:289:0x05fb, B:365:0x0601, B:262:0x0612, B:266:0x061f, B:268:0x0625, B:281:0x0654, B:285:0x065c, B:287:0x0662, B:384:0x066a, B:390:0x0679, B:392:0x04d8, B:393:0x04c5, B:394:0x04b1, B:401:0x0489, B:402:0x0474, B:403:0x0450, B:404:0x043c, B:405:0x0429, B:406:0x0416, B:407:0x0402, B:408:0x03ee, B:409:0x03da, B:410:0x023e, B:411:0x022f, B:412:0x024b, B:414:0x0256, B:416:0x025e, B:417:0x01fc, B:419:0x0204, B:420:0x020d, B:421:0x01e4, B:422:0x01d2, B:453:0x0138, B:456:0x0149, B:459:0x015c, B:463:0x016b, B:465:0x017f, B:466:0x0185), top: B:27:0x0068 }] */
    /* JADX WARN: Removed duplicated region for block: B:179:0x04cf A[Catch: JSONException -> 0x009d, TryCatch #1 {JSONException -> 0x009d, blocks: (B:28:0x0068, B:31:0x007a, B:33:0x0080, B:35:0x0094, B:36:0x00a0, B:38:0x00a8, B:39:0x00b0, B:41:0x00b6, B:42:0x00bc, B:44:0x00c5, B:46:0x00cd, B:48:0x00f2, B:55:0x0192, B:57:0x0198, B:61:0x068e, B:62:0x01bb, B:64:0x01c8, B:65:0x01d5, B:68:0x01dd, B:69:0x01e6, B:71:0x01f5, B:72:0x0210, B:74:0x0218, B:79:0x0244, B:81:0x0276, B:83:0x027e, B:84:0x0287, B:86:0x028f, B:87:0x0297, B:89:0x029f, B:90:0x02a7, B:92:0x02af, B:93:0x02b7, B:95:0x02c0, B:96:0x02c9, B:98:0x02d1, B:99:0x02d9, B:101:0x02e2, B:102:0x02eb, B:104:0x02f5, B:105:0x02fd, B:107:0x0305, B:108:0x030d, B:110:0x0315, B:111:0x031d, B:113:0x0323, B:114:0x0329, B:116:0x0331, B:117:0x0339, B:119:0x0341, B:120:0x0349, B:122:0x0352, B:123:0x0367, B:125:0x0370, B:126:0x0385, B:128:0x038e, B:129:0x0397, B:131:0x039f, B:132:0x03a7, B:134:0x03af, B:135:0x03b7, B:137:0x03bf, B:138:0x03c7, B:140:0x03cf, B:141:0x03dd, B:143:0x03e5, B:144:0x03f1, B:146:0x03f9, B:147:0x0405, B:149:0x040d, B:150:0x0418, B:152:0x0420, B:153:0x042b, B:155:0x0433, B:156:0x043f, B:158:0x0447, B:159:0x0453, B:161:0x045b, B:162:0x0463, B:164:0x046b, B:165:0x0476, B:167:0x047f, B:168:0x048b, B:170:0x0493, B:171:0x049f, B:173:0x04a7, B:174:0x04b4, B:176:0x04bc, B:177:0x04c7, B:179:0x04cf, B:180:0x04da, B:182:0x04e2, B:185:0x04ee, B:187:0x050f, B:221:0x068b, B:234:0x057d, B:240:0x058f, B:379:0x05b5, B:381:0x05bb, B:329:0x06f9, B:332:0x06ff, B:334:0x0705, B:335:0x070e, B:337:0x0714, B:338:0x071c, B:340:0x0722, B:341:0x072a, B:343:0x0730, B:344:0x0738, B:346:0x073e, B:347:0x0746, B:349:0x074c, B:350:0x0754, B:354:0x075e, B:355:0x0766, B:356:0x076e, B:358:0x0774, B:359:0x077c, B:361:0x0782, B:362:0x078b, B:364:0x0791, B:374:0x05ce, B:377:0x05d4, B:369:0x05e4, B:370:0x05e7, B:372:0x05ed, B:289:0x05fb, B:365:0x0601, B:262:0x0612, B:266:0x061f, B:268:0x0625, B:281:0x0654, B:285:0x065c, B:287:0x0662, B:384:0x066a, B:390:0x0679, B:392:0x04d8, B:393:0x04c5, B:394:0x04b1, B:401:0x0489, B:402:0x0474, B:403:0x0450, B:404:0x043c, B:405:0x0429, B:406:0x0416, B:407:0x0402, B:408:0x03ee, B:409:0x03da, B:410:0x023e, B:411:0x022f, B:412:0x024b, B:414:0x0256, B:416:0x025e, B:417:0x01fc, B:419:0x0204, B:420:0x020d, B:421:0x01e4, B:422:0x01d2, B:453:0x0138, B:456:0x0149, B:459:0x015c, B:463:0x016b, B:465:0x017f, B:466:0x0185), top: B:27:0x0068 }] */
    /* JADX WARN: Removed duplicated region for block: B:182:0x04e2 A[Catch: JSONException -> 0x009d, TryCatch #1 {JSONException -> 0x009d, blocks: (B:28:0x0068, B:31:0x007a, B:33:0x0080, B:35:0x0094, B:36:0x00a0, B:38:0x00a8, B:39:0x00b0, B:41:0x00b6, B:42:0x00bc, B:44:0x00c5, B:46:0x00cd, B:48:0x00f2, B:55:0x0192, B:57:0x0198, B:61:0x068e, B:62:0x01bb, B:64:0x01c8, B:65:0x01d5, B:68:0x01dd, B:69:0x01e6, B:71:0x01f5, B:72:0x0210, B:74:0x0218, B:79:0x0244, B:81:0x0276, B:83:0x027e, B:84:0x0287, B:86:0x028f, B:87:0x0297, B:89:0x029f, B:90:0x02a7, B:92:0x02af, B:93:0x02b7, B:95:0x02c0, B:96:0x02c9, B:98:0x02d1, B:99:0x02d9, B:101:0x02e2, B:102:0x02eb, B:104:0x02f5, B:105:0x02fd, B:107:0x0305, B:108:0x030d, B:110:0x0315, B:111:0x031d, B:113:0x0323, B:114:0x0329, B:116:0x0331, B:117:0x0339, B:119:0x0341, B:120:0x0349, B:122:0x0352, B:123:0x0367, B:125:0x0370, B:126:0x0385, B:128:0x038e, B:129:0x0397, B:131:0x039f, B:132:0x03a7, B:134:0x03af, B:135:0x03b7, B:137:0x03bf, B:138:0x03c7, B:140:0x03cf, B:141:0x03dd, B:143:0x03e5, B:144:0x03f1, B:146:0x03f9, B:147:0x0405, B:149:0x040d, B:150:0x0418, B:152:0x0420, B:153:0x042b, B:155:0x0433, B:156:0x043f, B:158:0x0447, B:159:0x0453, B:161:0x045b, B:162:0x0463, B:164:0x046b, B:165:0x0476, B:167:0x047f, B:168:0x048b, B:170:0x0493, B:171:0x049f, B:173:0x04a7, B:174:0x04b4, B:176:0x04bc, B:177:0x04c7, B:179:0x04cf, B:180:0x04da, B:182:0x04e2, B:185:0x04ee, B:187:0x050f, B:221:0x068b, B:234:0x057d, B:240:0x058f, B:379:0x05b5, B:381:0x05bb, B:329:0x06f9, B:332:0x06ff, B:334:0x0705, B:335:0x070e, B:337:0x0714, B:338:0x071c, B:340:0x0722, B:341:0x072a, B:343:0x0730, B:344:0x0738, B:346:0x073e, B:347:0x0746, B:349:0x074c, B:350:0x0754, B:354:0x075e, B:355:0x0766, B:356:0x076e, B:358:0x0774, B:359:0x077c, B:361:0x0782, B:362:0x078b, B:364:0x0791, B:374:0x05ce, B:377:0x05d4, B:369:0x05e4, B:370:0x05e7, B:372:0x05ed, B:289:0x05fb, B:365:0x0601, B:262:0x0612, B:266:0x061f, B:268:0x0625, B:281:0x0654, B:285:0x065c, B:287:0x0662, B:384:0x066a, B:390:0x0679, B:392:0x04d8, B:393:0x04c5, B:394:0x04b1, B:401:0x0489, B:402:0x0474, B:403:0x0450, B:404:0x043c, B:405:0x0429, B:406:0x0416, B:407:0x0402, B:408:0x03ee, B:409:0x03da, B:410:0x023e, B:411:0x022f, B:412:0x024b, B:414:0x0256, B:416:0x025e, B:417:0x01fc, B:419:0x0204, B:420:0x020d, B:421:0x01e4, B:422:0x01d2, B:453:0x0138, B:456:0x0149, B:459:0x015c, B:463:0x016b, B:465:0x017f, B:466:0x0185), top: B:27:0x0068 }] */
    /* JADX WARN: Removed duplicated region for block: B:185:0x04ee A[Catch: JSONException -> 0x009d, TryCatch #1 {JSONException -> 0x009d, blocks: (B:28:0x0068, B:31:0x007a, B:33:0x0080, B:35:0x0094, B:36:0x00a0, B:38:0x00a8, B:39:0x00b0, B:41:0x00b6, B:42:0x00bc, B:44:0x00c5, B:46:0x00cd, B:48:0x00f2, B:55:0x0192, B:57:0x0198, B:61:0x068e, B:62:0x01bb, B:64:0x01c8, B:65:0x01d5, B:68:0x01dd, B:69:0x01e6, B:71:0x01f5, B:72:0x0210, B:74:0x0218, B:79:0x0244, B:81:0x0276, B:83:0x027e, B:84:0x0287, B:86:0x028f, B:87:0x0297, B:89:0x029f, B:90:0x02a7, B:92:0x02af, B:93:0x02b7, B:95:0x02c0, B:96:0x02c9, B:98:0x02d1, B:99:0x02d9, B:101:0x02e2, B:102:0x02eb, B:104:0x02f5, B:105:0x02fd, B:107:0x0305, B:108:0x030d, B:110:0x0315, B:111:0x031d, B:113:0x0323, B:114:0x0329, B:116:0x0331, B:117:0x0339, B:119:0x0341, B:120:0x0349, B:122:0x0352, B:123:0x0367, B:125:0x0370, B:126:0x0385, B:128:0x038e, B:129:0x0397, B:131:0x039f, B:132:0x03a7, B:134:0x03af, B:135:0x03b7, B:137:0x03bf, B:138:0x03c7, B:140:0x03cf, B:141:0x03dd, B:143:0x03e5, B:144:0x03f1, B:146:0x03f9, B:147:0x0405, B:149:0x040d, B:150:0x0418, B:152:0x0420, B:153:0x042b, B:155:0x0433, B:156:0x043f, B:158:0x0447, B:159:0x0453, B:161:0x045b, B:162:0x0463, B:164:0x046b, B:165:0x0476, B:167:0x047f, B:168:0x048b, B:170:0x0493, B:171:0x049f, B:173:0x04a7, B:174:0x04b4, B:176:0x04bc, B:177:0x04c7, B:179:0x04cf, B:180:0x04da, B:182:0x04e2, B:185:0x04ee, B:187:0x050f, B:221:0x068b, B:234:0x057d, B:240:0x058f, B:379:0x05b5, B:381:0x05bb, B:329:0x06f9, B:332:0x06ff, B:334:0x0705, B:335:0x070e, B:337:0x0714, B:338:0x071c, B:340:0x0722, B:341:0x072a, B:343:0x0730, B:344:0x0738, B:346:0x073e, B:347:0x0746, B:349:0x074c, B:350:0x0754, B:354:0x075e, B:355:0x0766, B:356:0x076e, B:358:0x0774, B:359:0x077c, B:361:0x0782, B:362:0x078b, B:364:0x0791, B:374:0x05ce, B:377:0x05d4, B:369:0x05e4, B:370:0x05e7, B:372:0x05ed, B:289:0x05fb, B:365:0x0601, B:262:0x0612, B:266:0x061f, B:268:0x0625, B:281:0x0654, B:285:0x065c, B:287:0x0662, B:384:0x066a, B:390:0x0679, B:392:0x04d8, B:393:0x04c5, B:394:0x04b1, B:401:0x0489, B:402:0x0474, B:403:0x0450, B:404:0x043c, B:405:0x0429, B:406:0x0416, B:407:0x0402, B:408:0x03ee, B:409:0x03da, B:410:0x023e, B:411:0x022f, B:412:0x024b, B:414:0x0256, B:416:0x025e, B:417:0x01fc, B:419:0x0204, B:420:0x020d, B:421:0x01e4, B:422:0x01d2, B:453:0x0138, B:456:0x0149, B:459:0x015c, B:463:0x016b, B:465:0x017f, B:466:0x0185), top: B:27:0x0068 }] */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0520  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x06b9  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x06c5  */
    /* JADX WARN: Removed duplicated region for block: B:356:0x076e A[Catch: JSONException -> 0x009d, TryCatch #1 {JSONException -> 0x009d, blocks: (B:28:0x0068, B:31:0x007a, B:33:0x0080, B:35:0x0094, B:36:0x00a0, B:38:0x00a8, B:39:0x00b0, B:41:0x00b6, B:42:0x00bc, B:44:0x00c5, B:46:0x00cd, B:48:0x00f2, B:55:0x0192, B:57:0x0198, B:61:0x068e, B:62:0x01bb, B:64:0x01c8, B:65:0x01d5, B:68:0x01dd, B:69:0x01e6, B:71:0x01f5, B:72:0x0210, B:74:0x0218, B:79:0x0244, B:81:0x0276, B:83:0x027e, B:84:0x0287, B:86:0x028f, B:87:0x0297, B:89:0x029f, B:90:0x02a7, B:92:0x02af, B:93:0x02b7, B:95:0x02c0, B:96:0x02c9, B:98:0x02d1, B:99:0x02d9, B:101:0x02e2, B:102:0x02eb, B:104:0x02f5, B:105:0x02fd, B:107:0x0305, B:108:0x030d, B:110:0x0315, B:111:0x031d, B:113:0x0323, B:114:0x0329, B:116:0x0331, B:117:0x0339, B:119:0x0341, B:120:0x0349, B:122:0x0352, B:123:0x0367, B:125:0x0370, B:126:0x0385, B:128:0x038e, B:129:0x0397, B:131:0x039f, B:132:0x03a7, B:134:0x03af, B:135:0x03b7, B:137:0x03bf, B:138:0x03c7, B:140:0x03cf, B:141:0x03dd, B:143:0x03e5, B:144:0x03f1, B:146:0x03f9, B:147:0x0405, B:149:0x040d, B:150:0x0418, B:152:0x0420, B:153:0x042b, B:155:0x0433, B:156:0x043f, B:158:0x0447, B:159:0x0453, B:161:0x045b, B:162:0x0463, B:164:0x046b, B:165:0x0476, B:167:0x047f, B:168:0x048b, B:170:0x0493, B:171:0x049f, B:173:0x04a7, B:174:0x04b4, B:176:0x04bc, B:177:0x04c7, B:179:0x04cf, B:180:0x04da, B:182:0x04e2, B:185:0x04ee, B:187:0x050f, B:221:0x068b, B:234:0x057d, B:240:0x058f, B:379:0x05b5, B:381:0x05bb, B:329:0x06f9, B:332:0x06ff, B:334:0x0705, B:335:0x070e, B:337:0x0714, B:338:0x071c, B:340:0x0722, B:341:0x072a, B:343:0x0730, B:344:0x0738, B:346:0x073e, B:347:0x0746, B:349:0x074c, B:350:0x0754, B:354:0x075e, B:355:0x0766, B:356:0x076e, B:358:0x0774, B:359:0x077c, B:361:0x0782, B:362:0x078b, B:364:0x0791, B:374:0x05ce, B:377:0x05d4, B:369:0x05e4, B:370:0x05e7, B:372:0x05ed, B:289:0x05fb, B:365:0x0601, B:262:0x0612, B:266:0x061f, B:268:0x0625, B:281:0x0654, B:285:0x065c, B:287:0x0662, B:384:0x066a, B:390:0x0679, B:392:0x04d8, B:393:0x04c5, B:394:0x04b1, B:401:0x0489, B:402:0x0474, B:403:0x0450, B:404:0x043c, B:405:0x0429, B:406:0x0416, B:407:0x0402, B:408:0x03ee, B:409:0x03da, B:410:0x023e, B:411:0x022f, B:412:0x024b, B:414:0x0256, B:416:0x025e, B:417:0x01fc, B:419:0x0204, B:420:0x020d, B:421:0x01e4, B:422:0x01d2, B:453:0x0138, B:456:0x0149, B:459:0x015c, B:463:0x016b, B:465:0x017f, B:466:0x0185), top: B:27:0x0068 }] */
    /* JADX WARN: Removed duplicated region for block: B:361:0x0782 A[Catch: JSONException -> 0x009d, TryCatch #1 {JSONException -> 0x009d, blocks: (B:28:0x0068, B:31:0x007a, B:33:0x0080, B:35:0x0094, B:36:0x00a0, B:38:0x00a8, B:39:0x00b0, B:41:0x00b6, B:42:0x00bc, B:44:0x00c5, B:46:0x00cd, B:48:0x00f2, B:55:0x0192, B:57:0x0198, B:61:0x068e, B:62:0x01bb, B:64:0x01c8, B:65:0x01d5, B:68:0x01dd, B:69:0x01e6, B:71:0x01f5, B:72:0x0210, B:74:0x0218, B:79:0x0244, B:81:0x0276, B:83:0x027e, B:84:0x0287, B:86:0x028f, B:87:0x0297, B:89:0x029f, B:90:0x02a7, B:92:0x02af, B:93:0x02b7, B:95:0x02c0, B:96:0x02c9, B:98:0x02d1, B:99:0x02d9, B:101:0x02e2, B:102:0x02eb, B:104:0x02f5, B:105:0x02fd, B:107:0x0305, B:108:0x030d, B:110:0x0315, B:111:0x031d, B:113:0x0323, B:114:0x0329, B:116:0x0331, B:117:0x0339, B:119:0x0341, B:120:0x0349, B:122:0x0352, B:123:0x0367, B:125:0x0370, B:126:0x0385, B:128:0x038e, B:129:0x0397, B:131:0x039f, B:132:0x03a7, B:134:0x03af, B:135:0x03b7, B:137:0x03bf, B:138:0x03c7, B:140:0x03cf, B:141:0x03dd, B:143:0x03e5, B:144:0x03f1, B:146:0x03f9, B:147:0x0405, B:149:0x040d, B:150:0x0418, B:152:0x0420, B:153:0x042b, B:155:0x0433, B:156:0x043f, B:158:0x0447, B:159:0x0453, B:161:0x045b, B:162:0x0463, B:164:0x046b, B:165:0x0476, B:167:0x047f, B:168:0x048b, B:170:0x0493, B:171:0x049f, B:173:0x04a7, B:174:0x04b4, B:176:0x04bc, B:177:0x04c7, B:179:0x04cf, B:180:0x04da, B:182:0x04e2, B:185:0x04ee, B:187:0x050f, B:221:0x068b, B:234:0x057d, B:240:0x058f, B:379:0x05b5, B:381:0x05bb, B:329:0x06f9, B:332:0x06ff, B:334:0x0705, B:335:0x070e, B:337:0x0714, B:338:0x071c, B:340:0x0722, B:341:0x072a, B:343:0x0730, B:344:0x0738, B:346:0x073e, B:347:0x0746, B:349:0x074c, B:350:0x0754, B:354:0x075e, B:355:0x0766, B:356:0x076e, B:358:0x0774, B:359:0x077c, B:361:0x0782, B:362:0x078b, B:364:0x0791, B:374:0x05ce, B:377:0x05d4, B:369:0x05e4, B:370:0x05e7, B:372:0x05ed, B:289:0x05fb, B:365:0x0601, B:262:0x0612, B:266:0x061f, B:268:0x0625, B:281:0x0654, B:285:0x065c, B:287:0x0662, B:384:0x066a, B:390:0x0679, B:392:0x04d8, B:393:0x04c5, B:394:0x04b1, B:401:0x0489, B:402:0x0474, B:403:0x0450, B:404:0x043c, B:405:0x0429, B:406:0x0416, B:407:0x0402, B:408:0x03ee, B:409:0x03da, B:410:0x023e, B:411:0x022f, B:412:0x024b, B:414:0x0256, B:416:0x025e, B:417:0x01fc, B:419:0x0204, B:420:0x020d, B:421:0x01e4, B:422:0x01d2, B:453:0x0138, B:456:0x0149, B:459:0x015c, B:463:0x016b, B:465:0x017f, B:466:0x0185), top: B:27:0x0068 }] */
    /* JADX WARN: Removed duplicated region for block: B:364:0x0791 A[Catch: JSONException -> 0x009d, TRY_LEAVE, TryCatch #1 {JSONException -> 0x009d, blocks: (B:28:0x0068, B:31:0x007a, B:33:0x0080, B:35:0x0094, B:36:0x00a0, B:38:0x00a8, B:39:0x00b0, B:41:0x00b6, B:42:0x00bc, B:44:0x00c5, B:46:0x00cd, B:48:0x00f2, B:55:0x0192, B:57:0x0198, B:61:0x068e, B:62:0x01bb, B:64:0x01c8, B:65:0x01d5, B:68:0x01dd, B:69:0x01e6, B:71:0x01f5, B:72:0x0210, B:74:0x0218, B:79:0x0244, B:81:0x0276, B:83:0x027e, B:84:0x0287, B:86:0x028f, B:87:0x0297, B:89:0x029f, B:90:0x02a7, B:92:0x02af, B:93:0x02b7, B:95:0x02c0, B:96:0x02c9, B:98:0x02d1, B:99:0x02d9, B:101:0x02e2, B:102:0x02eb, B:104:0x02f5, B:105:0x02fd, B:107:0x0305, B:108:0x030d, B:110:0x0315, B:111:0x031d, B:113:0x0323, B:114:0x0329, B:116:0x0331, B:117:0x0339, B:119:0x0341, B:120:0x0349, B:122:0x0352, B:123:0x0367, B:125:0x0370, B:126:0x0385, B:128:0x038e, B:129:0x0397, B:131:0x039f, B:132:0x03a7, B:134:0x03af, B:135:0x03b7, B:137:0x03bf, B:138:0x03c7, B:140:0x03cf, B:141:0x03dd, B:143:0x03e5, B:144:0x03f1, B:146:0x03f9, B:147:0x0405, B:149:0x040d, B:150:0x0418, B:152:0x0420, B:153:0x042b, B:155:0x0433, B:156:0x043f, B:158:0x0447, B:159:0x0453, B:161:0x045b, B:162:0x0463, B:164:0x046b, B:165:0x0476, B:167:0x047f, B:168:0x048b, B:170:0x0493, B:171:0x049f, B:173:0x04a7, B:174:0x04b4, B:176:0x04bc, B:177:0x04c7, B:179:0x04cf, B:180:0x04da, B:182:0x04e2, B:185:0x04ee, B:187:0x050f, B:221:0x068b, B:234:0x057d, B:240:0x058f, B:379:0x05b5, B:381:0x05bb, B:329:0x06f9, B:332:0x06ff, B:334:0x0705, B:335:0x070e, B:337:0x0714, B:338:0x071c, B:340:0x0722, B:341:0x072a, B:343:0x0730, B:344:0x0738, B:346:0x073e, B:347:0x0746, B:349:0x074c, B:350:0x0754, B:354:0x075e, B:355:0x0766, B:356:0x076e, B:358:0x0774, B:359:0x077c, B:361:0x0782, B:362:0x078b, B:364:0x0791, B:374:0x05ce, B:377:0x05d4, B:369:0x05e4, B:370:0x05e7, B:372:0x05ed, B:289:0x05fb, B:365:0x0601, B:262:0x0612, B:266:0x061f, B:268:0x0625, B:281:0x0654, B:285:0x065c, B:287:0x0662, B:384:0x066a, B:390:0x0679, B:392:0x04d8, B:393:0x04c5, B:394:0x04b1, B:401:0x0489, B:402:0x0474, B:403:0x0450, B:404:0x043c, B:405:0x0429, B:406:0x0416, B:407:0x0402, B:408:0x03ee, B:409:0x03da, B:410:0x023e, B:411:0x022f, B:412:0x024b, B:414:0x0256, B:416:0x025e, B:417:0x01fc, B:419:0x0204, B:420:0x020d, B:421:0x01e4, B:422:0x01d2, B:453:0x0138, B:456:0x0149, B:459:0x015c, B:463:0x016b, B:465:0x017f, B:466:0x0185), top: B:27:0x0068 }] */
    /* JADX WARN: Removed duplicated region for block: B:392:0x04d8 A[Catch: JSONException -> 0x009d, TryCatch #1 {JSONException -> 0x009d, blocks: (B:28:0x0068, B:31:0x007a, B:33:0x0080, B:35:0x0094, B:36:0x00a0, B:38:0x00a8, B:39:0x00b0, B:41:0x00b6, B:42:0x00bc, B:44:0x00c5, B:46:0x00cd, B:48:0x00f2, B:55:0x0192, B:57:0x0198, B:61:0x068e, B:62:0x01bb, B:64:0x01c8, B:65:0x01d5, B:68:0x01dd, B:69:0x01e6, B:71:0x01f5, B:72:0x0210, B:74:0x0218, B:79:0x0244, B:81:0x0276, B:83:0x027e, B:84:0x0287, B:86:0x028f, B:87:0x0297, B:89:0x029f, B:90:0x02a7, B:92:0x02af, B:93:0x02b7, B:95:0x02c0, B:96:0x02c9, B:98:0x02d1, B:99:0x02d9, B:101:0x02e2, B:102:0x02eb, B:104:0x02f5, B:105:0x02fd, B:107:0x0305, B:108:0x030d, B:110:0x0315, B:111:0x031d, B:113:0x0323, B:114:0x0329, B:116:0x0331, B:117:0x0339, B:119:0x0341, B:120:0x0349, B:122:0x0352, B:123:0x0367, B:125:0x0370, B:126:0x0385, B:128:0x038e, B:129:0x0397, B:131:0x039f, B:132:0x03a7, B:134:0x03af, B:135:0x03b7, B:137:0x03bf, B:138:0x03c7, B:140:0x03cf, B:141:0x03dd, B:143:0x03e5, B:144:0x03f1, B:146:0x03f9, B:147:0x0405, B:149:0x040d, B:150:0x0418, B:152:0x0420, B:153:0x042b, B:155:0x0433, B:156:0x043f, B:158:0x0447, B:159:0x0453, B:161:0x045b, B:162:0x0463, B:164:0x046b, B:165:0x0476, B:167:0x047f, B:168:0x048b, B:170:0x0493, B:171:0x049f, B:173:0x04a7, B:174:0x04b4, B:176:0x04bc, B:177:0x04c7, B:179:0x04cf, B:180:0x04da, B:182:0x04e2, B:185:0x04ee, B:187:0x050f, B:221:0x068b, B:234:0x057d, B:240:0x058f, B:379:0x05b5, B:381:0x05bb, B:329:0x06f9, B:332:0x06ff, B:334:0x0705, B:335:0x070e, B:337:0x0714, B:338:0x071c, B:340:0x0722, B:341:0x072a, B:343:0x0730, B:344:0x0738, B:346:0x073e, B:347:0x0746, B:349:0x074c, B:350:0x0754, B:354:0x075e, B:355:0x0766, B:356:0x076e, B:358:0x0774, B:359:0x077c, B:361:0x0782, B:362:0x078b, B:364:0x0791, B:374:0x05ce, B:377:0x05d4, B:369:0x05e4, B:370:0x05e7, B:372:0x05ed, B:289:0x05fb, B:365:0x0601, B:262:0x0612, B:266:0x061f, B:268:0x0625, B:281:0x0654, B:285:0x065c, B:287:0x0662, B:384:0x066a, B:390:0x0679, B:392:0x04d8, B:393:0x04c5, B:394:0x04b1, B:401:0x0489, B:402:0x0474, B:403:0x0450, B:404:0x043c, B:405:0x0429, B:406:0x0416, B:407:0x0402, B:408:0x03ee, B:409:0x03da, B:410:0x023e, B:411:0x022f, B:412:0x024b, B:414:0x0256, B:416:0x025e, B:417:0x01fc, B:419:0x0204, B:420:0x020d, B:421:0x01e4, B:422:0x01d2, B:453:0x0138, B:456:0x0149, B:459:0x015c, B:463:0x016b, B:465:0x017f, B:466:0x0185), top: B:27:0x0068 }] */
    /* JADX WARN: Removed duplicated region for block: B:393:0x04c5 A[Catch: JSONException -> 0x009d, TryCatch #1 {JSONException -> 0x009d, blocks: (B:28:0x0068, B:31:0x007a, B:33:0x0080, B:35:0x0094, B:36:0x00a0, B:38:0x00a8, B:39:0x00b0, B:41:0x00b6, B:42:0x00bc, B:44:0x00c5, B:46:0x00cd, B:48:0x00f2, B:55:0x0192, B:57:0x0198, B:61:0x068e, B:62:0x01bb, B:64:0x01c8, B:65:0x01d5, B:68:0x01dd, B:69:0x01e6, B:71:0x01f5, B:72:0x0210, B:74:0x0218, B:79:0x0244, B:81:0x0276, B:83:0x027e, B:84:0x0287, B:86:0x028f, B:87:0x0297, B:89:0x029f, B:90:0x02a7, B:92:0x02af, B:93:0x02b7, B:95:0x02c0, B:96:0x02c9, B:98:0x02d1, B:99:0x02d9, B:101:0x02e2, B:102:0x02eb, B:104:0x02f5, B:105:0x02fd, B:107:0x0305, B:108:0x030d, B:110:0x0315, B:111:0x031d, B:113:0x0323, B:114:0x0329, B:116:0x0331, B:117:0x0339, B:119:0x0341, B:120:0x0349, B:122:0x0352, B:123:0x0367, B:125:0x0370, B:126:0x0385, B:128:0x038e, B:129:0x0397, B:131:0x039f, B:132:0x03a7, B:134:0x03af, B:135:0x03b7, B:137:0x03bf, B:138:0x03c7, B:140:0x03cf, B:141:0x03dd, B:143:0x03e5, B:144:0x03f1, B:146:0x03f9, B:147:0x0405, B:149:0x040d, B:150:0x0418, B:152:0x0420, B:153:0x042b, B:155:0x0433, B:156:0x043f, B:158:0x0447, B:159:0x0453, B:161:0x045b, B:162:0x0463, B:164:0x046b, B:165:0x0476, B:167:0x047f, B:168:0x048b, B:170:0x0493, B:171:0x049f, B:173:0x04a7, B:174:0x04b4, B:176:0x04bc, B:177:0x04c7, B:179:0x04cf, B:180:0x04da, B:182:0x04e2, B:185:0x04ee, B:187:0x050f, B:221:0x068b, B:234:0x057d, B:240:0x058f, B:379:0x05b5, B:381:0x05bb, B:329:0x06f9, B:332:0x06ff, B:334:0x0705, B:335:0x070e, B:337:0x0714, B:338:0x071c, B:340:0x0722, B:341:0x072a, B:343:0x0730, B:344:0x0738, B:346:0x073e, B:347:0x0746, B:349:0x074c, B:350:0x0754, B:354:0x075e, B:355:0x0766, B:356:0x076e, B:358:0x0774, B:359:0x077c, B:361:0x0782, B:362:0x078b, B:364:0x0791, B:374:0x05ce, B:377:0x05d4, B:369:0x05e4, B:370:0x05e7, B:372:0x05ed, B:289:0x05fb, B:365:0x0601, B:262:0x0612, B:266:0x061f, B:268:0x0625, B:281:0x0654, B:285:0x065c, B:287:0x0662, B:384:0x066a, B:390:0x0679, B:392:0x04d8, B:393:0x04c5, B:394:0x04b1, B:401:0x0489, B:402:0x0474, B:403:0x0450, B:404:0x043c, B:405:0x0429, B:406:0x0416, B:407:0x0402, B:408:0x03ee, B:409:0x03da, B:410:0x023e, B:411:0x022f, B:412:0x024b, B:414:0x0256, B:416:0x025e, B:417:0x01fc, B:419:0x0204, B:420:0x020d, B:421:0x01e4, B:422:0x01d2, B:453:0x0138, B:456:0x0149, B:459:0x015c, B:463:0x016b, B:465:0x017f, B:466:0x0185), top: B:27:0x0068 }] */
    /* JADX WARN: Removed duplicated region for block: B:394:0x04b1 A[Catch: JSONException -> 0x009d, TryCatch #1 {JSONException -> 0x009d, blocks: (B:28:0x0068, B:31:0x007a, B:33:0x0080, B:35:0x0094, B:36:0x00a0, B:38:0x00a8, B:39:0x00b0, B:41:0x00b6, B:42:0x00bc, B:44:0x00c5, B:46:0x00cd, B:48:0x00f2, B:55:0x0192, B:57:0x0198, B:61:0x068e, B:62:0x01bb, B:64:0x01c8, B:65:0x01d5, B:68:0x01dd, B:69:0x01e6, B:71:0x01f5, B:72:0x0210, B:74:0x0218, B:79:0x0244, B:81:0x0276, B:83:0x027e, B:84:0x0287, B:86:0x028f, B:87:0x0297, B:89:0x029f, B:90:0x02a7, B:92:0x02af, B:93:0x02b7, B:95:0x02c0, B:96:0x02c9, B:98:0x02d1, B:99:0x02d9, B:101:0x02e2, B:102:0x02eb, B:104:0x02f5, B:105:0x02fd, B:107:0x0305, B:108:0x030d, B:110:0x0315, B:111:0x031d, B:113:0x0323, B:114:0x0329, B:116:0x0331, B:117:0x0339, B:119:0x0341, B:120:0x0349, B:122:0x0352, B:123:0x0367, B:125:0x0370, B:126:0x0385, B:128:0x038e, B:129:0x0397, B:131:0x039f, B:132:0x03a7, B:134:0x03af, B:135:0x03b7, B:137:0x03bf, B:138:0x03c7, B:140:0x03cf, B:141:0x03dd, B:143:0x03e5, B:144:0x03f1, B:146:0x03f9, B:147:0x0405, B:149:0x040d, B:150:0x0418, B:152:0x0420, B:153:0x042b, B:155:0x0433, B:156:0x043f, B:158:0x0447, B:159:0x0453, B:161:0x045b, B:162:0x0463, B:164:0x046b, B:165:0x0476, B:167:0x047f, B:168:0x048b, B:170:0x0493, B:171:0x049f, B:173:0x04a7, B:174:0x04b4, B:176:0x04bc, B:177:0x04c7, B:179:0x04cf, B:180:0x04da, B:182:0x04e2, B:185:0x04ee, B:187:0x050f, B:221:0x068b, B:234:0x057d, B:240:0x058f, B:379:0x05b5, B:381:0x05bb, B:329:0x06f9, B:332:0x06ff, B:334:0x0705, B:335:0x070e, B:337:0x0714, B:338:0x071c, B:340:0x0722, B:341:0x072a, B:343:0x0730, B:344:0x0738, B:346:0x073e, B:347:0x0746, B:349:0x074c, B:350:0x0754, B:354:0x075e, B:355:0x0766, B:356:0x076e, B:358:0x0774, B:359:0x077c, B:361:0x0782, B:362:0x078b, B:364:0x0791, B:374:0x05ce, B:377:0x05d4, B:369:0x05e4, B:370:0x05e7, B:372:0x05ed, B:289:0x05fb, B:365:0x0601, B:262:0x0612, B:266:0x061f, B:268:0x0625, B:281:0x0654, B:285:0x065c, B:287:0x0662, B:384:0x066a, B:390:0x0679, B:392:0x04d8, B:393:0x04c5, B:394:0x04b1, B:401:0x0489, B:402:0x0474, B:403:0x0450, B:404:0x043c, B:405:0x0429, B:406:0x0416, B:407:0x0402, B:408:0x03ee, B:409:0x03da, B:410:0x023e, B:411:0x022f, B:412:0x024b, B:414:0x0256, B:416:0x025e, B:417:0x01fc, B:419:0x0204, B:420:0x020d, B:421:0x01e4, B:422:0x01d2, B:453:0x0138, B:456:0x0149, B:459:0x015c, B:463:0x016b, B:465:0x017f, B:466:0x0185), top: B:27:0x0068 }] */
    /* JADX WARN: Removed duplicated region for block: B:395:0x049c  */
    /* JADX WARN: Removed duplicated region for block: B:401:0x0489 A[Catch: JSONException -> 0x009d, TryCatch #1 {JSONException -> 0x009d, blocks: (B:28:0x0068, B:31:0x007a, B:33:0x0080, B:35:0x0094, B:36:0x00a0, B:38:0x00a8, B:39:0x00b0, B:41:0x00b6, B:42:0x00bc, B:44:0x00c5, B:46:0x00cd, B:48:0x00f2, B:55:0x0192, B:57:0x0198, B:61:0x068e, B:62:0x01bb, B:64:0x01c8, B:65:0x01d5, B:68:0x01dd, B:69:0x01e6, B:71:0x01f5, B:72:0x0210, B:74:0x0218, B:79:0x0244, B:81:0x0276, B:83:0x027e, B:84:0x0287, B:86:0x028f, B:87:0x0297, B:89:0x029f, B:90:0x02a7, B:92:0x02af, B:93:0x02b7, B:95:0x02c0, B:96:0x02c9, B:98:0x02d1, B:99:0x02d9, B:101:0x02e2, B:102:0x02eb, B:104:0x02f5, B:105:0x02fd, B:107:0x0305, B:108:0x030d, B:110:0x0315, B:111:0x031d, B:113:0x0323, B:114:0x0329, B:116:0x0331, B:117:0x0339, B:119:0x0341, B:120:0x0349, B:122:0x0352, B:123:0x0367, B:125:0x0370, B:126:0x0385, B:128:0x038e, B:129:0x0397, B:131:0x039f, B:132:0x03a7, B:134:0x03af, B:135:0x03b7, B:137:0x03bf, B:138:0x03c7, B:140:0x03cf, B:141:0x03dd, B:143:0x03e5, B:144:0x03f1, B:146:0x03f9, B:147:0x0405, B:149:0x040d, B:150:0x0418, B:152:0x0420, B:153:0x042b, B:155:0x0433, B:156:0x043f, B:158:0x0447, B:159:0x0453, B:161:0x045b, B:162:0x0463, B:164:0x046b, B:165:0x0476, B:167:0x047f, B:168:0x048b, B:170:0x0493, B:171:0x049f, B:173:0x04a7, B:174:0x04b4, B:176:0x04bc, B:177:0x04c7, B:179:0x04cf, B:180:0x04da, B:182:0x04e2, B:185:0x04ee, B:187:0x050f, B:221:0x068b, B:234:0x057d, B:240:0x058f, B:379:0x05b5, B:381:0x05bb, B:329:0x06f9, B:332:0x06ff, B:334:0x0705, B:335:0x070e, B:337:0x0714, B:338:0x071c, B:340:0x0722, B:341:0x072a, B:343:0x0730, B:344:0x0738, B:346:0x073e, B:347:0x0746, B:349:0x074c, B:350:0x0754, B:354:0x075e, B:355:0x0766, B:356:0x076e, B:358:0x0774, B:359:0x077c, B:361:0x0782, B:362:0x078b, B:364:0x0791, B:374:0x05ce, B:377:0x05d4, B:369:0x05e4, B:370:0x05e7, B:372:0x05ed, B:289:0x05fb, B:365:0x0601, B:262:0x0612, B:266:0x061f, B:268:0x0625, B:281:0x0654, B:285:0x065c, B:287:0x0662, B:384:0x066a, B:390:0x0679, B:392:0x04d8, B:393:0x04c5, B:394:0x04b1, B:401:0x0489, B:402:0x0474, B:403:0x0450, B:404:0x043c, B:405:0x0429, B:406:0x0416, B:407:0x0402, B:408:0x03ee, B:409:0x03da, B:410:0x023e, B:411:0x022f, B:412:0x024b, B:414:0x0256, B:416:0x025e, B:417:0x01fc, B:419:0x0204, B:420:0x020d, B:421:0x01e4, B:422:0x01d2, B:453:0x0138, B:456:0x0149, B:459:0x015c, B:463:0x016b, B:465:0x017f, B:466:0x0185), top: B:27:0x0068 }] */
    /* JADX WARN: Removed duplicated region for block: B:402:0x0474 A[Catch: JSONException -> 0x009d, TryCatch #1 {JSONException -> 0x009d, blocks: (B:28:0x0068, B:31:0x007a, B:33:0x0080, B:35:0x0094, B:36:0x00a0, B:38:0x00a8, B:39:0x00b0, B:41:0x00b6, B:42:0x00bc, B:44:0x00c5, B:46:0x00cd, B:48:0x00f2, B:55:0x0192, B:57:0x0198, B:61:0x068e, B:62:0x01bb, B:64:0x01c8, B:65:0x01d5, B:68:0x01dd, B:69:0x01e6, B:71:0x01f5, B:72:0x0210, B:74:0x0218, B:79:0x0244, B:81:0x0276, B:83:0x027e, B:84:0x0287, B:86:0x028f, B:87:0x0297, B:89:0x029f, B:90:0x02a7, B:92:0x02af, B:93:0x02b7, B:95:0x02c0, B:96:0x02c9, B:98:0x02d1, B:99:0x02d9, B:101:0x02e2, B:102:0x02eb, B:104:0x02f5, B:105:0x02fd, B:107:0x0305, B:108:0x030d, B:110:0x0315, B:111:0x031d, B:113:0x0323, B:114:0x0329, B:116:0x0331, B:117:0x0339, B:119:0x0341, B:120:0x0349, B:122:0x0352, B:123:0x0367, B:125:0x0370, B:126:0x0385, B:128:0x038e, B:129:0x0397, B:131:0x039f, B:132:0x03a7, B:134:0x03af, B:135:0x03b7, B:137:0x03bf, B:138:0x03c7, B:140:0x03cf, B:141:0x03dd, B:143:0x03e5, B:144:0x03f1, B:146:0x03f9, B:147:0x0405, B:149:0x040d, B:150:0x0418, B:152:0x0420, B:153:0x042b, B:155:0x0433, B:156:0x043f, B:158:0x0447, B:159:0x0453, B:161:0x045b, B:162:0x0463, B:164:0x046b, B:165:0x0476, B:167:0x047f, B:168:0x048b, B:170:0x0493, B:171:0x049f, B:173:0x04a7, B:174:0x04b4, B:176:0x04bc, B:177:0x04c7, B:179:0x04cf, B:180:0x04da, B:182:0x04e2, B:185:0x04ee, B:187:0x050f, B:221:0x068b, B:234:0x057d, B:240:0x058f, B:379:0x05b5, B:381:0x05bb, B:329:0x06f9, B:332:0x06ff, B:334:0x0705, B:335:0x070e, B:337:0x0714, B:338:0x071c, B:340:0x0722, B:341:0x072a, B:343:0x0730, B:344:0x0738, B:346:0x073e, B:347:0x0746, B:349:0x074c, B:350:0x0754, B:354:0x075e, B:355:0x0766, B:356:0x076e, B:358:0x0774, B:359:0x077c, B:361:0x0782, B:362:0x078b, B:364:0x0791, B:374:0x05ce, B:377:0x05d4, B:369:0x05e4, B:370:0x05e7, B:372:0x05ed, B:289:0x05fb, B:365:0x0601, B:262:0x0612, B:266:0x061f, B:268:0x0625, B:281:0x0654, B:285:0x065c, B:287:0x0662, B:384:0x066a, B:390:0x0679, B:392:0x04d8, B:393:0x04c5, B:394:0x04b1, B:401:0x0489, B:402:0x0474, B:403:0x0450, B:404:0x043c, B:405:0x0429, B:406:0x0416, B:407:0x0402, B:408:0x03ee, B:409:0x03da, B:410:0x023e, B:411:0x022f, B:412:0x024b, B:414:0x0256, B:416:0x025e, B:417:0x01fc, B:419:0x0204, B:420:0x020d, B:421:0x01e4, B:422:0x01d2, B:453:0x0138, B:456:0x0149, B:459:0x015c, B:463:0x016b, B:465:0x017f, B:466:0x0185), top: B:27:0x0068 }] */
    /* JADX WARN: Removed duplicated region for block: B:403:0x0450 A[Catch: JSONException -> 0x009d, TryCatch #1 {JSONException -> 0x009d, blocks: (B:28:0x0068, B:31:0x007a, B:33:0x0080, B:35:0x0094, B:36:0x00a0, B:38:0x00a8, B:39:0x00b0, B:41:0x00b6, B:42:0x00bc, B:44:0x00c5, B:46:0x00cd, B:48:0x00f2, B:55:0x0192, B:57:0x0198, B:61:0x068e, B:62:0x01bb, B:64:0x01c8, B:65:0x01d5, B:68:0x01dd, B:69:0x01e6, B:71:0x01f5, B:72:0x0210, B:74:0x0218, B:79:0x0244, B:81:0x0276, B:83:0x027e, B:84:0x0287, B:86:0x028f, B:87:0x0297, B:89:0x029f, B:90:0x02a7, B:92:0x02af, B:93:0x02b7, B:95:0x02c0, B:96:0x02c9, B:98:0x02d1, B:99:0x02d9, B:101:0x02e2, B:102:0x02eb, B:104:0x02f5, B:105:0x02fd, B:107:0x0305, B:108:0x030d, B:110:0x0315, B:111:0x031d, B:113:0x0323, B:114:0x0329, B:116:0x0331, B:117:0x0339, B:119:0x0341, B:120:0x0349, B:122:0x0352, B:123:0x0367, B:125:0x0370, B:126:0x0385, B:128:0x038e, B:129:0x0397, B:131:0x039f, B:132:0x03a7, B:134:0x03af, B:135:0x03b7, B:137:0x03bf, B:138:0x03c7, B:140:0x03cf, B:141:0x03dd, B:143:0x03e5, B:144:0x03f1, B:146:0x03f9, B:147:0x0405, B:149:0x040d, B:150:0x0418, B:152:0x0420, B:153:0x042b, B:155:0x0433, B:156:0x043f, B:158:0x0447, B:159:0x0453, B:161:0x045b, B:162:0x0463, B:164:0x046b, B:165:0x0476, B:167:0x047f, B:168:0x048b, B:170:0x0493, B:171:0x049f, B:173:0x04a7, B:174:0x04b4, B:176:0x04bc, B:177:0x04c7, B:179:0x04cf, B:180:0x04da, B:182:0x04e2, B:185:0x04ee, B:187:0x050f, B:221:0x068b, B:234:0x057d, B:240:0x058f, B:379:0x05b5, B:381:0x05bb, B:329:0x06f9, B:332:0x06ff, B:334:0x0705, B:335:0x070e, B:337:0x0714, B:338:0x071c, B:340:0x0722, B:341:0x072a, B:343:0x0730, B:344:0x0738, B:346:0x073e, B:347:0x0746, B:349:0x074c, B:350:0x0754, B:354:0x075e, B:355:0x0766, B:356:0x076e, B:358:0x0774, B:359:0x077c, B:361:0x0782, B:362:0x078b, B:364:0x0791, B:374:0x05ce, B:377:0x05d4, B:369:0x05e4, B:370:0x05e7, B:372:0x05ed, B:289:0x05fb, B:365:0x0601, B:262:0x0612, B:266:0x061f, B:268:0x0625, B:281:0x0654, B:285:0x065c, B:287:0x0662, B:384:0x066a, B:390:0x0679, B:392:0x04d8, B:393:0x04c5, B:394:0x04b1, B:401:0x0489, B:402:0x0474, B:403:0x0450, B:404:0x043c, B:405:0x0429, B:406:0x0416, B:407:0x0402, B:408:0x03ee, B:409:0x03da, B:410:0x023e, B:411:0x022f, B:412:0x024b, B:414:0x0256, B:416:0x025e, B:417:0x01fc, B:419:0x0204, B:420:0x020d, B:421:0x01e4, B:422:0x01d2, B:453:0x0138, B:456:0x0149, B:459:0x015c, B:463:0x016b, B:465:0x017f, B:466:0x0185), top: B:27:0x0068 }] */
    /* JADX WARN: Removed duplicated region for block: B:404:0x043c A[Catch: JSONException -> 0x009d, TryCatch #1 {JSONException -> 0x009d, blocks: (B:28:0x0068, B:31:0x007a, B:33:0x0080, B:35:0x0094, B:36:0x00a0, B:38:0x00a8, B:39:0x00b0, B:41:0x00b6, B:42:0x00bc, B:44:0x00c5, B:46:0x00cd, B:48:0x00f2, B:55:0x0192, B:57:0x0198, B:61:0x068e, B:62:0x01bb, B:64:0x01c8, B:65:0x01d5, B:68:0x01dd, B:69:0x01e6, B:71:0x01f5, B:72:0x0210, B:74:0x0218, B:79:0x0244, B:81:0x0276, B:83:0x027e, B:84:0x0287, B:86:0x028f, B:87:0x0297, B:89:0x029f, B:90:0x02a7, B:92:0x02af, B:93:0x02b7, B:95:0x02c0, B:96:0x02c9, B:98:0x02d1, B:99:0x02d9, B:101:0x02e2, B:102:0x02eb, B:104:0x02f5, B:105:0x02fd, B:107:0x0305, B:108:0x030d, B:110:0x0315, B:111:0x031d, B:113:0x0323, B:114:0x0329, B:116:0x0331, B:117:0x0339, B:119:0x0341, B:120:0x0349, B:122:0x0352, B:123:0x0367, B:125:0x0370, B:126:0x0385, B:128:0x038e, B:129:0x0397, B:131:0x039f, B:132:0x03a7, B:134:0x03af, B:135:0x03b7, B:137:0x03bf, B:138:0x03c7, B:140:0x03cf, B:141:0x03dd, B:143:0x03e5, B:144:0x03f1, B:146:0x03f9, B:147:0x0405, B:149:0x040d, B:150:0x0418, B:152:0x0420, B:153:0x042b, B:155:0x0433, B:156:0x043f, B:158:0x0447, B:159:0x0453, B:161:0x045b, B:162:0x0463, B:164:0x046b, B:165:0x0476, B:167:0x047f, B:168:0x048b, B:170:0x0493, B:171:0x049f, B:173:0x04a7, B:174:0x04b4, B:176:0x04bc, B:177:0x04c7, B:179:0x04cf, B:180:0x04da, B:182:0x04e2, B:185:0x04ee, B:187:0x050f, B:221:0x068b, B:234:0x057d, B:240:0x058f, B:379:0x05b5, B:381:0x05bb, B:329:0x06f9, B:332:0x06ff, B:334:0x0705, B:335:0x070e, B:337:0x0714, B:338:0x071c, B:340:0x0722, B:341:0x072a, B:343:0x0730, B:344:0x0738, B:346:0x073e, B:347:0x0746, B:349:0x074c, B:350:0x0754, B:354:0x075e, B:355:0x0766, B:356:0x076e, B:358:0x0774, B:359:0x077c, B:361:0x0782, B:362:0x078b, B:364:0x0791, B:374:0x05ce, B:377:0x05d4, B:369:0x05e4, B:370:0x05e7, B:372:0x05ed, B:289:0x05fb, B:365:0x0601, B:262:0x0612, B:266:0x061f, B:268:0x0625, B:281:0x0654, B:285:0x065c, B:287:0x0662, B:384:0x066a, B:390:0x0679, B:392:0x04d8, B:393:0x04c5, B:394:0x04b1, B:401:0x0489, B:402:0x0474, B:403:0x0450, B:404:0x043c, B:405:0x0429, B:406:0x0416, B:407:0x0402, B:408:0x03ee, B:409:0x03da, B:410:0x023e, B:411:0x022f, B:412:0x024b, B:414:0x0256, B:416:0x025e, B:417:0x01fc, B:419:0x0204, B:420:0x020d, B:421:0x01e4, B:422:0x01d2, B:453:0x0138, B:456:0x0149, B:459:0x015c, B:463:0x016b, B:465:0x017f, B:466:0x0185), top: B:27:0x0068 }] */
    /* JADX WARN: Removed duplicated region for block: B:405:0x0429 A[Catch: JSONException -> 0x009d, TryCatch #1 {JSONException -> 0x009d, blocks: (B:28:0x0068, B:31:0x007a, B:33:0x0080, B:35:0x0094, B:36:0x00a0, B:38:0x00a8, B:39:0x00b0, B:41:0x00b6, B:42:0x00bc, B:44:0x00c5, B:46:0x00cd, B:48:0x00f2, B:55:0x0192, B:57:0x0198, B:61:0x068e, B:62:0x01bb, B:64:0x01c8, B:65:0x01d5, B:68:0x01dd, B:69:0x01e6, B:71:0x01f5, B:72:0x0210, B:74:0x0218, B:79:0x0244, B:81:0x0276, B:83:0x027e, B:84:0x0287, B:86:0x028f, B:87:0x0297, B:89:0x029f, B:90:0x02a7, B:92:0x02af, B:93:0x02b7, B:95:0x02c0, B:96:0x02c9, B:98:0x02d1, B:99:0x02d9, B:101:0x02e2, B:102:0x02eb, B:104:0x02f5, B:105:0x02fd, B:107:0x0305, B:108:0x030d, B:110:0x0315, B:111:0x031d, B:113:0x0323, B:114:0x0329, B:116:0x0331, B:117:0x0339, B:119:0x0341, B:120:0x0349, B:122:0x0352, B:123:0x0367, B:125:0x0370, B:126:0x0385, B:128:0x038e, B:129:0x0397, B:131:0x039f, B:132:0x03a7, B:134:0x03af, B:135:0x03b7, B:137:0x03bf, B:138:0x03c7, B:140:0x03cf, B:141:0x03dd, B:143:0x03e5, B:144:0x03f1, B:146:0x03f9, B:147:0x0405, B:149:0x040d, B:150:0x0418, B:152:0x0420, B:153:0x042b, B:155:0x0433, B:156:0x043f, B:158:0x0447, B:159:0x0453, B:161:0x045b, B:162:0x0463, B:164:0x046b, B:165:0x0476, B:167:0x047f, B:168:0x048b, B:170:0x0493, B:171:0x049f, B:173:0x04a7, B:174:0x04b4, B:176:0x04bc, B:177:0x04c7, B:179:0x04cf, B:180:0x04da, B:182:0x04e2, B:185:0x04ee, B:187:0x050f, B:221:0x068b, B:234:0x057d, B:240:0x058f, B:379:0x05b5, B:381:0x05bb, B:329:0x06f9, B:332:0x06ff, B:334:0x0705, B:335:0x070e, B:337:0x0714, B:338:0x071c, B:340:0x0722, B:341:0x072a, B:343:0x0730, B:344:0x0738, B:346:0x073e, B:347:0x0746, B:349:0x074c, B:350:0x0754, B:354:0x075e, B:355:0x0766, B:356:0x076e, B:358:0x0774, B:359:0x077c, B:361:0x0782, B:362:0x078b, B:364:0x0791, B:374:0x05ce, B:377:0x05d4, B:369:0x05e4, B:370:0x05e7, B:372:0x05ed, B:289:0x05fb, B:365:0x0601, B:262:0x0612, B:266:0x061f, B:268:0x0625, B:281:0x0654, B:285:0x065c, B:287:0x0662, B:384:0x066a, B:390:0x0679, B:392:0x04d8, B:393:0x04c5, B:394:0x04b1, B:401:0x0489, B:402:0x0474, B:403:0x0450, B:404:0x043c, B:405:0x0429, B:406:0x0416, B:407:0x0402, B:408:0x03ee, B:409:0x03da, B:410:0x023e, B:411:0x022f, B:412:0x024b, B:414:0x0256, B:416:0x025e, B:417:0x01fc, B:419:0x0204, B:420:0x020d, B:421:0x01e4, B:422:0x01d2, B:453:0x0138, B:456:0x0149, B:459:0x015c, B:463:0x016b, B:465:0x017f, B:466:0x0185), top: B:27:0x0068 }] */
    /* JADX WARN: Removed duplicated region for block: B:406:0x0416 A[Catch: JSONException -> 0x009d, TryCatch #1 {JSONException -> 0x009d, blocks: (B:28:0x0068, B:31:0x007a, B:33:0x0080, B:35:0x0094, B:36:0x00a0, B:38:0x00a8, B:39:0x00b0, B:41:0x00b6, B:42:0x00bc, B:44:0x00c5, B:46:0x00cd, B:48:0x00f2, B:55:0x0192, B:57:0x0198, B:61:0x068e, B:62:0x01bb, B:64:0x01c8, B:65:0x01d5, B:68:0x01dd, B:69:0x01e6, B:71:0x01f5, B:72:0x0210, B:74:0x0218, B:79:0x0244, B:81:0x0276, B:83:0x027e, B:84:0x0287, B:86:0x028f, B:87:0x0297, B:89:0x029f, B:90:0x02a7, B:92:0x02af, B:93:0x02b7, B:95:0x02c0, B:96:0x02c9, B:98:0x02d1, B:99:0x02d9, B:101:0x02e2, B:102:0x02eb, B:104:0x02f5, B:105:0x02fd, B:107:0x0305, B:108:0x030d, B:110:0x0315, B:111:0x031d, B:113:0x0323, B:114:0x0329, B:116:0x0331, B:117:0x0339, B:119:0x0341, B:120:0x0349, B:122:0x0352, B:123:0x0367, B:125:0x0370, B:126:0x0385, B:128:0x038e, B:129:0x0397, B:131:0x039f, B:132:0x03a7, B:134:0x03af, B:135:0x03b7, B:137:0x03bf, B:138:0x03c7, B:140:0x03cf, B:141:0x03dd, B:143:0x03e5, B:144:0x03f1, B:146:0x03f9, B:147:0x0405, B:149:0x040d, B:150:0x0418, B:152:0x0420, B:153:0x042b, B:155:0x0433, B:156:0x043f, B:158:0x0447, B:159:0x0453, B:161:0x045b, B:162:0x0463, B:164:0x046b, B:165:0x0476, B:167:0x047f, B:168:0x048b, B:170:0x0493, B:171:0x049f, B:173:0x04a7, B:174:0x04b4, B:176:0x04bc, B:177:0x04c7, B:179:0x04cf, B:180:0x04da, B:182:0x04e2, B:185:0x04ee, B:187:0x050f, B:221:0x068b, B:234:0x057d, B:240:0x058f, B:379:0x05b5, B:381:0x05bb, B:329:0x06f9, B:332:0x06ff, B:334:0x0705, B:335:0x070e, B:337:0x0714, B:338:0x071c, B:340:0x0722, B:341:0x072a, B:343:0x0730, B:344:0x0738, B:346:0x073e, B:347:0x0746, B:349:0x074c, B:350:0x0754, B:354:0x075e, B:355:0x0766, B:356:0x076e, B:358:0x0774, B:359:0x077c, B:361:0x0782, B:362:0x078b, B:364:0x0791, B:374:0x05ce, B:377:0x05d4, B:369:0x05e4, B:370:0x05e7, B:372:0x05ed, B:289:0x05fb, B:365:0x0601, B:262:0x0612, B:266:0x061f, B:268:0x0625, B:281:0x0654, B:285:0x065c, B:287:0x0662, B:384:0x066a, B:390:0x0679, B:392:0x04d8, B:393:0x04c5, B:394:0x04b1, B:401:0x0489, B:402:0x0474, B:403:0x0450, B:404:0x043c, B:405:0x0429, B:406:0x0416, B:407:0x0402, B:408:0x03ee, B:409:0x03da, B:410:0x023e, B:411:0x022f, B:412:0x024b, B:414:0x0256, B:416:0x025e, B:417:0x01fc, B:419:0x0204, B:420:0x020d, B:421:0x01e4, B:422:0x01d2, B:453:0x0138, B:456:0x0149, B:459:0x015c, B:463:0x016b, B:465:0x017f, B:466:0x0185), top: B:27:0x0068 }] */
    /* JADX WARN: Removed duplicated region for block: B:407:0x0402 A[Catch: JSONException -> 0x009d, TryCatch #1 {JSONException -> 0x009d, blocks: (B:28:0x0068, B:31:0x007a, B:33:0x0080, B:35:0x0094, B:36:0x00a0, B:38:0x00a8, B:39:0x00b0, B:41:0x00b6, B:42:0x00bc, B:44:0x00c5, B:46:0x00cd, B:48:0x00f2, B:55:0x0192, B:57:0x0198, B:61:0x068e, B:62:0x01bb, B:64:0x01c8, B:65:0x01d5, B:68:0x01dd, B:69:0x01e6, B:71:0x01f5, B:72:0x0210, B:74:0x0218, B:79:0x0244, B:81:0x0276, B:83:0x027e, B:84:0x0287, B:86:0x028f, B:87:0x0297, B:89:0x029f, B:90:0x02a7, B:92:0x02af, B:93:0x02b7, B:95:0x02c0, B:96:0x02c9, B:98:0x02d1, B:99:0x02d9, B:101:0x02e2, B:102:0x02eb, B:104:0x02f5, B:105:0x02fd, B:107:0x0305, B:108:0x030d, B:110:0x0315, B:111:0x031d, B:113:0x0323, B:114:0x0329, B:116:0x0331, B:117:0x0339, B:119:0x0341, B:120:0x0349, B:122:0x0352, B:123:0x0367, B:125:0x0370, B:126:0x0385, B:128:0x038e, B:129:0x0397, B:131:0x039f, B:132:0x03a7, B:134:0x03af, B:135:0x03b7, B:137:0x03bf, B:138:0x03c7, B:140:0x03cf, B:141:0x03dd, B:143:0x03e5, B:144:0x03f1, B:146:0x03f9, B:147:0x0405, B:149:0x040d, B:150:0x0418, B:152:0x0420, B:153:0x042b, B:155:0x0433, B:156:0x043f, B:158:0x0447, B:159:0x0453, B:161:0x045b, B:162:0x0463, B:164:0x046b, B:165:0x0476, B:167:0x047f, B:168:0x048b, B:170:0x0493, B:171:0x049f, B:173:0x04a7, B:174:0x04b4, B:176:0x04bc, B:177:0x04c7, B:179:0x04cf, B:180:0x04da, B:182:0x04e2, B:185:0x04ee, B:187:0x050f, B:221:0x068b, B:234:0x057d, B:240:0x058f, B:379:0x05b5, B:381:0x05bb, B:329:0x06f9, B:332:0x06ff, B:334:0x0705, B:335:0x070e, B:337:0x0714, B:338:0x071c, B:340:0x0722, B:341:0x072a, B:343:0x0730, B:344:0x0738, B:346:0x073e, B:347:0x0746, B:349:0x074c, B:350:0x0754, B:354:0x075e, B:355:0x0766, B:356:0x076e, B:358:0x0774, B:359:0x077c, B:361:0x0782, B:362:0x078b, B:364:0x0791, B:374:0x05ce, B:377:0x05d4, B:369:0x05e4, B:370:0x05e7, B:372:0x05ed, B:289:0x05fb, B:365:0x0601, B:262:0x0612, B:266:0x061f, B:268:0x0625, B:281:0x0654, B:285:0x065c, B:287:0x0662, B:384:0x066a, B:390:0x0679, B:392:0x04d8, B:393:0x04c5, B:394:0x04b1, B:401:0x0489, B:402:0x0474, B:403:0x0450, B:404:0x043c, B:405:0x0429, B:406:0x0416, B:407:0x0402, B:408:0x03ee, B:409:0x03da, B:410:0x023e, B:411:0x022f, B:412:0x024b, B:414:0x0256, B:416:0x025e, B:417:0x01fc, B:419:0x0204, B:420:0x020d, B:421:0x01e4, B:422:0x01d2, B:453:0x0138, B:456:0x0149, B:459:0x015c, B:463:0x016b, B:465:0x017f, B:466:0x0185), top: B:27:0x0068 }] */
    /* JADX WARN: Removed duplicated region for block: B:408:0x03ee A[Catch: JSONException -> 0x009d, TryCatch #1 {JSONException -> 0x009d, blocks: (B:28:0x0068, B:31:0x007a, B:33:0x0080, B:35:0x0094, B:36:0x00a0, B:38:0x00a8, B:39:0x00b0, B:41:0x00b6, B:42:0x00bc, B:44:0x00c5, B:46:0x00cd, B:48:0x00f2, B:55:0x0192, B:57:0x0198, B:61:0x068e, B:62:0x01bb, B:64:0x01c8, B:65:0x01d5, B:68:0x01dd, B:69:0x01e6, B:71:0x01f5, B:72:0x0210, B:74:0x0218, B:79:0x0244, B:81:0x0276, B:83:0x027e, B:84:0x0287, B:86:0x028f, B:87:0x0297, B:89:0x029f, B:90:0x02a7, B:92:0x02af, B:93:0x02b7, B:95:0x02c0, B:96:0x02c9, B:98:0x02d1, B:99:0x02d9, B:101:0x02e2, B:102:0x02eb, B:104:0x02f5, B:105:0x02fd, B:107:0x0305, B:108:0x030d, B:110:0x0315, B:111:0x031d, B:113:0x0323, B:114:0x0329, B:116:0x0331, B:117:0x0339, B:119:0x0341, B:120:0x0349, B:122:0x0352, B:123:0x0367, B:125:0x0370, B:126:0x0385, B:128:0x038e, B:129:0x0397, B:131:0x039f, B:132:0x03a7, B:134:0x03af, B:135:0x03b7, B:137:0x03bf, B:138:0x03c7, B:140:0x03cf, B:141:0x03dd, B:143:0x03e5, B:144:0x03f1, B:146:0x03f9, B:147:0x0405, B:149:0x040d, B:150:0x0418, B:152:0x0420, B:153:0x042b, B:155:0x0433, B:156:0x043f, B:158:0x0447, B:159:0x0453, B:161:0x045b, B:162:0x0463, B:164:0x046b, B:165:0x0476, B:167:0x047f, B:168:0x048b, B:170:0x0493, B:171:0x049f, B:173:0x04a7, B:174:0x04b4, B:176:0x04bc, B:177:0x04c7, B:179:0x04cf, B:180:0x04da, B:182:0x04e2, B:185:0x04ee, B:187:0x050f, B:221:0x068b, B:234:0x057d, B:240:0x058f, B:379:0x05b5, B:381:0x05bb, B:329:0x06f9, B:332:0x06ff, B:334:0x0705, B:335:0x070e, B:337:0x0714, B:338:0x071c, B:340:0x0722, B:341:0x072a, B:343:0x0730, B:344:0x0738, B:346:0x073e, B:347:0x0746, B:349:0x074c, B:350:0x0754, B:354:0x075e, B:355:0x0766, B:356:0x076e, B:358:0x0774, B:359:0x077c, B:361:0x0782, B:362:0x078b, B:364:0x0791, B:374:0x05ce, B:377:0x05d4, B:369:0x05e4, B:370:0x05e7, B:372:0x05ed, B:289:0x05fb, B:365:0x0601, B:262:0x0612, B:266:0x061f, B:268:0x0625, B:281:0x0654, B:285:0x065c, B:287:0x0662, B:384:0x066a, B:390:0x0679, B:392:0x04d8, B:393:0x04c5, B:394:0x04b1, B:401:0x0489, B:402:0x0474, B:403:0x0450, B:404:0x043c, B:405:0x0429, B:406:0x0416, B:407:0x0402, B:408:0x03ee, B:409:0x03da, B:410:0x023e, B:411:0x022f, B:412:0x024b, B:414:0x0256, B:416:0x025e, B:417:0x01fc, B:419:0x0204, B:420:0x020d, B:421:0x01e4, B:422:0x01d2, B:453:0x0138, B:456:0x0149, B:459:0x015c, B:463:0x016b, B:465:0x017f, B:466:0x0185), top: B:27:0x0068 }] */
    /* JADX WARN: Removed duplicated region for block: B:409:0x03da A[Catch: JSONException -> 0x009d, TryCatch #1 {JSONException -> 0x009d, blocks: (B:28:0x0068, B:31:0x007a, B:33:0x0080, B:35:0x0094, B:36:0x00a0, B:38:0x00a8, B:39:0x00b0, B:41:0x00b6, B:42:0x00bc, B:44:0x00c5, B:46:0x00cd, B:48:0x00f2, B:55:0x0192, B:57:0x0198, B:61:0x068e, B:62:0x01bb, B:64:0x01c8, B:65:0x01d5, B:68:0x01dd, B:69:0x01e6, B:71:0x01f5, B:72:0x0210, B:74:0x0218, B:79:0x0244, B:81:0x0276, B:83:0x027e, B:84:0x0287, B:86:0x028f, B:87:0x0297, B:89:0x029f, B:90:0x02a7, B:92:0x02af, B:93:0x02b7, B:95:0x02c0, B:96:0x02c9, B:98:0x02d1, B:99:0x02d9, B:101:0x02e2, B:102:0x02eb, B:104:0x02f5, B:105:0x02fd, B:107:0x0305, B:108:0x030d, B:110:0x0315, B:111:0x031d, B:113:0x0323, B:114:0x0329, B:116:0x0331, B:117:0x0339, B:119:0x0341, B:120:0x0349, B:122:0x0352, B:123:0x0367, B:125:0x0370, B:126:0x0385, B:128:0x038e, B:129:0x0397, B:131:0x039f, B:132:0x03a7, B:134:0x03af, B:135:0x03b7, B:137:0x03bf, B:138:0x03c7, B:140:0x03cf, B:141:0x03dd, B:143:0x03e5, B:144:0x03f1, B:146:0x03f9, B:147:0x0405, B:149:0x040d, B:150:0x0418, B:152:0x0420, B:153:0x042b, B:155:0x0433, B:156:0x043f, B:158:0x0447, B:159:0x0453, B:161:0x045b, B:162:0x0463, B:164:0x046b, B:165:0x0476, B:167:0x047f, B:168:0x048b, B:170:0x0493, B:171:0x049f, B:173:0x04a7, B:174:0x04b4, B:176:0x04bc, B:177:0x04c7, B:179:0x04cf, B:180:0x04da, B:182:0x04e2, B:185:0x04ee, B:187:0x050f, B:221:0x068b, B:234:0x057d, B:240:0x058f, B:379:0x05b5, B:381:0x05bb, B:329:0x06f9, B:332:0x06ff, B:334:0x0705, B:335:0x070e, B:337:0x0714, B:338:0x071c, B:340:0x0722, B:341:0x072a, B:343:0x0730, B:344:0x0738, B:346:0x073e, B:347:0x0746, B:349:0x074c, B:350:0x0754, B:354:0x075e, B:355:0x0766, B:356:0x076e, B:358:0x0774, B:359:0x077c, B:361:0x0782, B:362:0x078b, B:364:0x0791, B:374:0x05ce, B:377:0x05d4, B:369:0x05e4, B:370:0x05e7, B:372:0x05ed, B:289:0x05fb, B:365:0x0601, B:262:0x0612, B:266:0x061f, B:268:0x0625, B:281:0x0654, B:285:0x065c, B:287:0x0662, B:384:0x066a, B:390:0x0679, B:392:0x04d8, B:393:0x04c5, B:394:0x04b1, B:401:0x0489, B:402:0x0474, B:403:0x0450, B:404:0x043c, B:405:0x0429, B:406:0x0416, B:407:0x0402, B:408:0x03ee, B:409:0x03da, B:410:0x023e, B:411:0x022f, B:412:0x024b, B:414:0x0256, B:416:0x025e, B:417:0x01fc, B:419:0x0204, B:420:0x020d, B:421:0x01e4, B:422:0x01d2, B:453:0x0138, B:456:0x0149, B:459:0x015c, B:463:0x016b, B:465:0x017f, B:466:0x0185), top: B:27:0x0068 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0198 A[Catch: JSONException -> 0x009d, TryCatch #1 {JSONException -> 0x009d, blocks: (B:28:0x0068, B:31:0x007a, B:33:0x0080, B:35:0x0094, B:36:0x00a0, B:38:0x00a8, B:39:0x00b0, B:41:0x00b6, B:42:0x00bc, B:44:0x00c5, B:46:0x00cd, B:48:0x00f2, B:55:0x0192, B:57:0x0198, B:61:0x068e, B:62:0x01bb, B:64:0x01c8, B:65:0x01d5, B:68:0x01dd, B:69:0x01e6, B:71:0x01f5, B:72:0x0210, B:74:0x0218, B:79:0x0244, B:81:0x0276, B:83:0x027e, B:84:0x0287, B:86:0x028f, B:87:0x0297, B:89:0x029f, B:90:0x02a7, B:92:0x02af, B:93:0x02b7, B:95:0x02c0, B:96:0x02c9, B:98:0x02d1, B:99:0x02d9, B:101:0x02e2, B:102:0x02eb, B:104:0x02f5, B:105:0x02fd, B:107:0x0305, B:108:0x030d, B:110:0x0315, B:111:0x031d, B:113:0x0323, B:114:0x0329, B:116:0x0331, B:117:0x0339, B:119:0x0341, B:120:0x0349, B:122:0x0352, B:123:0x0367, B:125:0x0370, B:126:0x0385, B:128:0x038e, B:129:0x0397, B:131:0x039f, B:132:0x03a7, B:134:0x03af, B:135:0x03b7, B:137:0x03bf, B:138:0x03c7, B:140:0x03cf, B:141:0x03dd, B:143:0x03e5, B:144:0x03f1, B:146:0x03f9, B:147:0x0405, B:149:0x040d, B:150:0x0418, B:152:0x0420, B:153:0x042b, B:155:0x0433, B:156:0x043f, B:158:0x0447, B:159:0x0453, B:161:0x045b, B:162:0x0463, B:164:0x046b, B:165:0x0476, B:167:0x047f, B:168:0x048b, B:170:0x0493, B:171:0x049f, B:173:0x04a7, B:174:0x04b4, B:176:0x04bc, B:177:0x04c7, B:179:0x04cf, B:180:0x04da, B:182:0x04e2, B:185:0x04ee, B:187:0x050f, B:221:0x068b, B:234:0x057d, B:240:0x058f, B:379:0x05b5, B:381:0x05bb, B:329:0x06f9, B:332:0x06ff, B:334:0x0705, B:335:0x070e, B:337:0x0714, B:338:0x071c, B:340:0x0722, B:341:0x072a, B:343:0x0730, B:344:0x0738, B:346:0x073e, B:347:0x0746, B:349:0x074c, B:350:0x0754, B:354:0x075e, B:355:0x0766, B:356:0x076e, B:358:0x0774, B:359:0x077c, B:361:0x0782, B:362:0x078b, B:364:0x0791, B:374:0x05ce, B:377:0x05d4, B:369:0x05e4, B:370:0x05e7, B:372:0x05ed, B:289:0x05fb, B:365:0x0601, B:262:0x0612, B:266:0x061f, B:268:0x0625, B:281:0x0654, B:285:0x065c, B:287:0x0662, B:384:0x066a, B:390:0x0679, B:392:0x04d8, B:393:0x04c5, B:394:0x04b1, B:401:0x0489, B:402:0x0474, B:403:0x0450, B:404:0x043c, B:405:0x0429, B:406:0x0416, B:407:0x0402, B:408:0x03ee, B:409:0x03da, B:410:0x023e, B:411:0x022f, B:412:0x024b, B:414:0x0256, B:416:0x025e, B:417:0x01fc, B:419:0x0204, B:420:0x020d, B:421:0x01e4, B:422:0x01d2, B:453:0x0138, B:456:0x0149, B:459:0x015c, B:463:0x016b, B:465:0x017f, B:466:0x0185), top: B:27:0x0068 }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x027e A[Catch: JSONException -> 0x009d, TryCatch #1 {JSONException -> 0x009d, blocks: (B:28:0x0068, B:31:0x007a, B:33:0x0080, B:35:0x0094, B:36:0x00a0, B:38:0x00a8, B:39:0x00b0, B:41:0x00b6, B:42:0x00bc, B:44:0x00c5, B:46:0x00cd, B:48:0x00f2, B:55:0x0192, B:57:0x0198, B:61:0x068e, B:62:0x01bb, B:64:0x01c8, B:65:0x01d5, B:68:0x01dd, B:69:0x01e6, B:71:0x01f5, B:72:0x0210, B:74:0x0218, B:79:0x0244, B:81:0x0276, B:83:0x027e, B:84:0x0287, B:86:0x028f, B:87:0x0297, B:89:0x029f, B:90:0x02a7, B:92:0x02af, B:93:0x02b7, B:95:0x02c0, B:96:0x02c9, B:98:0x02d1, B:99:0x02d9, B:101:0x02e2, B:102:0x02eb, B:104:0x02f5, B:105:0x02fd, B:107:0x0305, B:108:0x030d, B:110:0x0315, B:111:0x031d, B:113:0x0323, B:114:0x0329, B:116:0x0331, B:117:0x0339, B:119:0x0341, B:120:0x0349, B:122:0x0352, B:123:0x0367, B:125:0x0370, B:126:0x0385, B:128:0x038e, B:129:0x0397, B:131:0x039f, B:132:0x03a7, B:134:0x03af, B:135:0x03b7, B:137:0x03bf, B:138:0x03c7, B:140:0x03cf, B:141:0x03dd, B:143:0x03e5, B:144:0x03f1, B:146:0x03f9, B:147:0x0405, B:149:0x040d, B:150:0x0418, B:152:0x0420, B:153:0x042b, B:155:0x0433, B:156:0x043f, B:158:0x0447, B:159:0x0453, B:161:0x045b, B:162:0x0463, B:164:0x046b, B:165:0x0476, B:167:0x047f, B:168:0x048b, B:170:0x0493, B:171:0x049f, B:173:0x04a7, B:174:0x04b4, B:176:0x04bc, B:177:0x04c7, B:179:0x04cf, B:180:0x04da, B:182:0x04e2, B:185:0x04ee, B:187:0x050f, B:221:0x068b, B:234:0x057d, B:240:0x058f, B:379:0x05b5, B:381:0x05bb, B:329:0x06f9, B:332:0x06ff, B:334:0x0705, B:335:0x070e, B:337:0x0714, B:338:0x071c, B:340:0x0722, B:341:0x072a, B:343:0x0730, B:344:0x0738, B:346:0x073e, B:347:0x0746, B:349:0x074c, B:350:0x0754, B:354:0x075e, B:355:0x0766, B:356:0x076e, B:358:0x0774, B:359:0x077c, B:361:0x0782, B:362:0x078b, B:364:0x0791, B:374:0x05ce, B:377:0x05d4, B:369:0x05e4, B:370:0x05e7, B:372:0x05ed, B:289:0x05fb, B:365:0x0601, B:262:0x0612, B:266:0x061f, B:268:0x0625, B:281:0x0654, B:285:0x065c, B:287:0x0662, B:384:0x066a, B:390:0x0679, B:392:0x04d8, B:393:0x04c5, B:394:0x04b1, B:401:0x0489, B:402:0x0474, B:403:0x0450, B:404:0x043c, B:405:0x0429, B:406:0x0416, B:407:0x0402, B:408:0x03ee, B:409:0x03da, B:410:0x023e, B:411:0x022f, B:412:0x024b, B:414:0x0256, B:416:0x025e, B:417:0x01fc, B:419:0x0204, B:420:0x020d, B:421:0x01e4, B:422:0x01d2, B:453:0x0138, B:456:0x0149, B:459:0x015c, B:463:0x016b, B:465:0x017f, B:466:0x0185), top: B:27:0x0068 }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x028f A[Catch: JSONException -> 0x009d, TryCatch #1 {JSONException -> 0x009d, blocks: (B:28:0x0068, B:31:0x007a, B:33:0x0080, B:35:0x0094, B:36:0x00a0, B:38:0x00a8, B:39:0x00b0, B:41:0x00b6, B:42:0x00bc, B:44:0x00c5, B:46:0x00cd, B:48:0x00f2, B:55:0x0192, B:57:0x0198, B:61:0x068e, B:62:0x01bb, B:64:0x01c8, B:65:0x01d5, B:68:0x01dd, B:69:0x01e6, B:71:0x01f5, B:72:0x0210, B:74:0x0218, B:79:0x0244, B:81:0x0276, B:83:0x027e, B:84:0x0287, B:86:0x028f, B:87:0x0297, B:89:0x029f, B:90:0x02a7, B:92:0x02af, B:93:0x02b7, B:95:0x02c0, B:96:0x02c9, B:98:0x02d1, B:99:0x02d9, B:101:0x02e2, B:102:0x02eb, B:104:0x02f5, B:105:0x02fd, B:107:0x0305, B:108:0x030d, B:110:0x0315, B:111:0x031d, B:113:0x0323, B:114:0x0329, B:116:0x0331, B:117:0x0339, B:119:0x0341, B:120:0x0349, B:122:0x0352, B:123:0x0367, B:125:0x0370, B:126:0x0385, B:128:0x038e, B:129:0x0397, B:131:0x039f, B:132:0x03a7, B:134:0x03af, B:135:0x03b7, B:137:0x03bf, B:138:0x03c7, B:140:0x03cf, B:141:0x03dd, B:143:0x03e5, B:144:0x03f1, B:146:0x03f9, B:147:0x0405, B:149:0x040d, B:150:0x0418, B:152:0x0420, B:153:0x042b, B:155:0x0433, B:156:0x043f, B:158:0x0447, B:159:0x0453, B:161:0x045b, B:162:0x0463, B:164:0x046b, B:165:0x0476, B:167:0x047f, B:168:0x048b, B:170:0x0493, B:171:0x049f, B:173:0x04a7, B:174:0x04b4, B:176:0x04bc, B:177:0x04c7, B:179:0x04cf, B:180:0x04da, B:182:0x04e2, B:185:0x04ee, B:187:0x050f, B:221:0x068b, B:234:0x057d, B:240:0x058f, B:379:0x05b5, B:381:0x05bb, B:329:0x06f9, B:332:0x06ff, B:334:0x0705, B:335:0x070e, B:337:0x0714, B:338:0x071c, B:340:0x0722, B:341:0x072a, B:343:0x0730, B:344:0x0738, B:346:0x073e, B:347:0x0746, B:349:0x074c, B:350:0x0754, B:354:0x075e, B:355:0x0766, B:356:0x076e, B:358:0x0774, B:359:0x077c, B:361:0x0782, B:362:0x078b, B:364:0x0791, B:374:0x05ce, B:377:0x05d4, B:369:0x05e4, B:370:0x05e7, B:372:0x05ed, B:289:0x05fb, B:365:0x0601, B:262:0x0612, B:266:0x061f, B:268:0x0625, B:281:0x0654, B:285:0x065c, B:287:0x0662, B:384:0x066a, B:390:0x0679, B:392:0x04d8, B:393:0x04c5, B:394:0x04b1, B:401:0x0489, B:402:0x0474, B:403:0x0450, B:404:0x043c, B:405:0x0429, B:406:0x0416, B:407:0x0402, B:408:0x03ee, B:409:0x03da, B:410:0x023e, B:411:0x022f, B:412:0x024b, B:414:0x0256, B:416:0x025e, B:417:0x01fc, B:419:0x0204, B:420:0x020d, B:421:0x01e4, B:422:0x01d2, B:453:0x0138, B:456:0x0149, B:459:0x015c, B:463:0x016b, B:465:0x017f, B:466:0x0185), top: B:27:0x0068 }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x029f A[Catch: JSONException -> 0x009d, TryCatch #1 {JSONException -> 0x009d, blocks: (B:28:0x0068, B:31:0x007a, B:33:0x0080, B:35:0x0094, B:36:0x00a0, B:38:0x00a8, B:39:0x00b0, B:41:0x00b6, B:42:0x00bc, B:44:0x00c5, B:46:0x00cd, B:48:0x00f2, B:55:0x0192, B:57:0x0198, B:61:0x068e, B:62:0x01bb, B:64:0x01c8, B:65:0x01d5, B:68:0x01dd, B:69:0x01e6, B:71:0x01f5, B:72:0x0210, B:74:0x0218, B:79:0x0244, B:81:0x0276, B:83:0x027e, B:84:0x0287, B:86:0x028f, B:87:0x0297, B:89:0x029f, B:90:0x02a7, B:92:0x02af, B:93:0x02b7, B:95:0x02c0, B:96:0x02c9, B:98:0x02d1, B:99:0x02d9, B:101:0x02e2, B:102:0x02eb, B:104:0x02f5, B:105:0x02fd, B:107:0x0305, B:108:0x030d, B:110:0x0315, B:111:0x031d, B:113:0x0323, B:114:0x0329, B:116:0x0331, B:117:0x0339, B:119:0x0341, B:120:0x0349, B:122:0x0352, B:123:0x0367, B:125:0x0370, B:126:0x0385, B:128:0x038e, B:129:0x0397, B:131:0x039f, B:132:0x03a7, B:134:0x03af, B:135:0x03b7, B:137:0x03bf, B:138:0x03c7, B:140:0x03cf, B:141:0x03dd, B:143:0x03e5, B:144:0x03f1, B:146:0x03f9, B:147:0x0405, B:149:0x040d, B:150:0x0418, B:152:0x0420, B:153:0x042b, B:155:0x0433, B:156:0x043f, B:158:0x0447, B:159:0x0453, B:161:0x045b, B:162:0x0463, B:164:0x046b, B:165:0x0476, B:167:0x047f, B:168:0x048b, B:170:0x0493, B:171:0x049f, B:173:0x04a7, B:174:0x04b4, B:176:0x04bc, B:177:0x04c7, B:179:0x04cf, B:180:0x04da, B:182:0x04e2, B:185:0x04ee, B:187:0x050f, B:221:0x068b, B:234:0x057d, B:240:0x058f, B:379:0x05b5, B:381:0x05bb, B:329:0x06f9, B:332:0x06ff, B:334:0x0705, B:335:0x070e, B:337:0x0714, B:338:0x071c, B:340:0x0722, B:341:0x072a, B:343:0x0730, B:344:0x0738, B:346:0x073e, B:347:0x0746, B:349:0x074c, B:350:0x0754, B:354:0x075e, B:355:0x0766, B:356:0x076e, B:358:0x0774, B:359:0x077c, B:361:0x0782, B:362:0x078b, B:364:0x0791, B:374:0x05ce, B:377:0x05d4, B:369:0x05e4, B:370:0x05e7, B:372:0x05ed, B:289:0x05fb, B:365:0x0601, B:262:0x0612, B:266:0x061f, B:268:0x0625, B:281:0x0654, B:285:0x065c, B:287:0x0662, B:384:0x066a, B:390:0x0679, B:392:0x04d8, B:393:0x04c5, B:394:0x04b1, B:401:0x0489, B:402:0x0474, B:403:0x0450, B:404:0x043c, B:405:0x0429, B:406:0x0416, B:407:0x0402, B:408:0x03ee, B:409:0x03da, B:410:0x023e, B:411:0x022f, B:412:0x024b, B:414:0x0256, B:416:0x025e, B:417:0x01fc, B:419:0x0204, B:420:0x020d, B:421:0x01e4, B:422:0x01d2, B:453:0x0138, B:456:0x0149, B:459:0x015c, B:463:0x016b, B:465:0x017f, B:466:0x0185), top: B:27:0x0068 }] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x02af A[Catch: JSONException -> 0x009d, TryCatch #1 {JSONException -> 0x009d, blocks: (B:28:0x0068, B:31:0x007a, B:33:0x0080, B:35:0x0094, B:36:0x00a0, B:38:0x00a8, B:39:0x00b0, B:41:0x00b6, B:42:0x00bc, B:44:0x00c5, B:46:0x00cd, B:48:0x00f2, B:55:0x0192, B:57:0x0198, B:61:0x068e, B:62:0x01bb, B:64:0x01c8, B:65:0x01d5, B:68:0x01dd, B:69:0x01e6, B:71:0x01f5, B:72:0x0210, B:74:0x0218, B:79:0x0244, B:81:0x0276, B:83:0x027e, B:84:0x0287, B:86:0x028f, B:87:0x0297, B:89:0x029f, B:90:0x02a7, B:92:0x02af, B:93:0x02b7, B:95:0x02c0, B:96:0x02c9, B:98:0x02d1, B:99:0x02d9, B:101:0x02e2, B:102:0x02eb, B:104:0x02f5, B:105:0x02fd, B:107:0x0305, B:108:0x030d, B:110:0x0315, B:111:0x031d, B:113:0x0323, B:114:0x0329, B:116:0x0331, B:117:0x0339, B:119:0x0341, B:120:0x0349, B:122:0x0352, B:123:0x0367, B:125:0x0370, B:126:0x0385, B:128:0x038e, B:129:0x0397, B:131:0x039f, B:132:0x03a7, B:134:0x03af, B:135:0x03b7, B:137:0x03bf, B:138:0x03c7, B:140:0x03cf, B:141:0x03dd, B:143:0x03e5, B:144:0x03f1, B:146:0x03f9, B:147:0x0405, B:149:0x040d, B:150:0x0418, B:152:0x0420, B:153:0x042b, B:155:0x0433, B:156:0x043f, B:158:0x0447, B:159:0x0453, B:161:0x045b, B:162:0x0463, B:164:0x046b, B:165:0x0476, B:167:0x047f, B:168:0x048b, B:170:0x0493, B:171:0x049f, B:173:0x04a7, B:174:0x04b4, B:176:0x04bc, B:177:0x04c7, B:179:0x04cf, B:180:0x04da, B:182:0x04e2, B:185:0x04ee, B:187:0x050f, B:221:0x068b, B:234:0x057d, B:240:0x058f, B:379:0x05b5, B:381:0x05bb, B:329:0x06f9, B:332:0x06ff, B:334:0x0705, B:335:0x070e, B:337:0x0714, B:338:0x071c, B:340:0x0722, B:341:0x072a, B:343:0x0730, B:344:0x0738, B:346:0x073e, B:347:0x0746, B:349:0x074c, B:350:0x0754, B:354:0x075e, B:355:0x0766, B:356:0x076e, B:358:0x0774, B:359:0x077c, B:361:0x0782, B:362:0x078b, B:364:0x0791, B:374:0x05ce, B:377:0x05d4, B:369:0x05e4, B:370:0x05e7, B:372:0x05ed, B:289:0x05fb, B:365:0x0601, B:262:0x0612, B:266:0x061f, B:268:0x0625, B:281:0x0654, B:285:0x065c, B:287:0x0662, B:384:0x066a, B:390:0x0679, B:392:0x04d8, B:393:0x04c5, B:394:0x04b1, B:401:0x0489, B:402:0x0474, B:403:0x0450, B:404:0x043c, B:405:0x0429, B:406:0x0416, B:407:0x0402, B:408:0x03ee, B:409:0x03da, B:410:0x023e, B:411:0x022f, B:412:0x024b, B:414:0x0256, B:416:0x025e, B:417:0x01fc, B:419:0x0204, B:420:0x020d, B:421:0x01e4, B:422:0x01d2, B:453:0x0138, B:456:0x0149, B:459:0x015c, B:463:0x016b, B:465:0x017f, B:466:0x0185), top: B:27:0x0068 }] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x02c0 A[Catch: JSONException -> 0x009d, TryCatch #1 {JSONException -> 0x009d, blocks: (B:28:0x0068, B:31:0x007a, B:33:0x0080, B:35:0x0094, B:36:0x00a0, B:38:0x00a8, B:39:0x00b0, B:41:0x00b6, B:42:0x00bc, B:44:0x00c5, B:46:0x00cd, B:48:0x00f2, B:55:0x0192, B:57:0x0198, B:61:0x068e, B:62:0x01bb, B:64:0x01c8, B:65:0x01d5, B:68:0x01dd, B:69:0x01e6, B:71:0x01f5, B:72:0x0210, B:74:0x0218, B:79:0x0244, B:81:0x0276, B:83:0x027e, B:84:0x0287, B:86:0x028f, B:87:0x0297, B:89:0x029f, B:90:0x02a7, B:92:0x02af, B:93:0x02b7, B:95:0x02c0, B:96:0x02c9, B:98:0x02d1, B:99:0x02d9, B:101:0x02e2, B:102:0x02eb, B:104:0x02f5, B:105:0x02fd, B:107:0x0305, B:108:0x030d, B:110:0x0315, B:111:0x031d, B:113:0x0323, B:114:0x0329, B:116:0x0331, B:117:0x0339, B:119:0x0341, B:120:0x0349, B:122:0x0352, B:123:0x0367, B:125:0x0370, B:126:0x0385, B:128:0x038e, B:129:0x0397, B:131:0x039f, B:132:0x03a7, B:134:0x03af, B:135:0x03b7, B:137:0x03bf, B:138:0x03c7, B:140:0x03cf, B:141:0x03dd, B:143:0x03e5, B:144:0x03f1, B:146:0x03f9, B:147:0x0405, B:149:0x040d, B:150:0x0418, B:152:0x0420, B:153:0x042b, B:155:0x0433, B:156:0x043f, B:158:0x0447, B:159:0x0453, B:161:0x045b, B:162:0x0463, B:164:0x046b, B:165:0x0476, B:167:0x047f, B:168:0x048b, B:170:0x0493, B:171:0x049f, B:173:0x04a7, B:174:0x04b4, B:176:0x04bc, B:177:0x04c7, B:179:0x04cf, B:180:0x04da, B:182:0x04e2, B:185:0x04ee, B:187:0x050f, B:221:0x068b, B:234:0x057d, B:240:0x058f, B:379:0x05b5, B:381:0x05bb, B:329:0x06f9, B:332:0x06ff, B:334:0x0705, B:335:0x070e, B:337:0x0714, B:338:0x071c, B:340:0x0722, B:341:0x072a, B:343:0x0730, B:344:0x0738, B:346:0x073e, B:347:0x0746, B:349:0x074c, B:350:0x0754, B:354:0x075e, B:355:0x0766, B:356:0x076e, B:358:0x0774, B:359:0x077c, B:361:0x0782, B:362:0x078b, B:364:0x0791, B:374:0x05ce, B:377:0x05d4, B:369:0x05e4, B:370:0x05e7, B:372:0x05ed, B:289:0x05fb, B:365:0x0601, B:262:0x0612, B:266:0x061f, B:268:0x0625, B:281:0x0654, B:285:0x065c, B:287:0x0662, B:384:0x066a, B:390:0x0679, B:392:0x04d8, B:393:0x04c5, B:394:0x04b1, B:401:0x0489, B:402:0x0474, B:403:0x0450, B:404:0x043c, B:405:0x0429, B:406:0x0416, B:407:0x0402, B:408:0x03ee, B:409:0x03da, B:410:0x023e, B:411:0x022f, B:412:0x024b, B:414:0x0256, B:416:0x025e, B:417:0x01fc, B:419:0x0204, B:420:0x020d, B:421:0x01e4, B:422:0x01d2, B:453:0x0138, B:456:0x0149, B:459:0x015c, B:463:0x016b, B:465:0x017f, B:466:0x0185), top: B:27:0x0068 }] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x02d1 A[Catch: JSONException -> 0x009d, TryCatch #1 {JSONException -> 0x009d, blocks: (B:28:0x0068, B:31:0x007a, B:33:0x0080, B:35:0x0094, B:36:0x00a0, B:38:0x00a8, B:39:0x00b0, B:41:0x00b6, B:42:0x00bc, B:44:0x00c5, B:46:0x00cd, B:48:0x00f2, B:55:0x0192, B:57:0x0198, B:61:0x068e, B:62:0x01bb, B:64:0x01c8, B:65:0x01d5, B:68:0x01dd, B:69:0x01e6, B:71:0x01f5, B:72:0x0210, B:74:0x0218, B:79:0x0244, B:81:0x0276, B:83:0x027e, B:84:0x0287, B:86:0x028f, B:87:0x0297, B:89:0x029f, B:90:0x02a7, B:92:0x02af, B:93:0x02b7, B:95:0x02c0, B:96:0x02c9, B:98:0x02d1, B:99:0x02d9, B:101:0x02e2, B:102:0x02eb, B:104:0x02f5, B:105:0x02fd, B:107:0x0305, B:108:0x030d, B:110:0x0315, B:111:0x031d, B:113:0x0323, B:114:0x0329, B:116:0x0331, B:117:0x0339, B:119:0x0341, B:120:0x0349, B:122:0x0352, B:123:0x0367, B:125:0x0370, B:126:0x0385, B:128:0x038e, B:129:0x0397, B:131:0x039f, B:132:0x03a7, B:134:0x03af, B:135:0x03b7, B:137:0x03bf, B:138:0x03c7, B:140:0x03cf, B:141:0x03dd, B:143:0x03e5, B:144:0x03f1, B:146:0x03f9, B:147:0x0405, B:149:0x040d, B:150:0x0418, B:152:0x0420, B:153:0x042b, B:155:0x0433, B:156:0x043f, B:158:0x0447, B:159:0x0453, B:161:0x045b, B:162:0x0463, B:164:0x046b, B:165:0x0476, B:167:0x047f, B:168:0x048b, B:170:0x0493, B:171:0x049f, B:173:0x04a7, B:174:0x04b4, B:176:0x04bc, B:177:0x04c7, B:179:0x04cf, B:180:0x04da, B:182:0x04e2, B:185:0x04ee, B:187:0x050f, B:221:0x068b, B:234:0x057d, B:240:0x058f, B:379:0x05b5, B:381:0x05bb, B:329:0x06f9, B:332:0x06ff, B:334:0x0705, B:335:0x070e, B:337:0x0714, B:338:0x071c, B:340:0x0722, B:341:0x072a, B:343:0x0730, B:344:0x0738, B:346:0x073e, B:347:0x0746, B:349:0x074c, B:350:0x0754, B:354:0x075e, B:355:0x0766, B:356:0x076e, B:358:0x0774, B:359:0x077c, B:361:0x0782, B:362:0x078b, B:364:0x0791, B:374:0x05ce, B:377:0x05d4, B:369:0x05e4, B:370:0x05e7, B:372:0x05ed, B:289:0x05fb, B:365:0x0601, B:262:0x0612, B:266:0x061f, B:268:0x0625, B:281:0x0654, B:285:0x065c, B:287:0x0662, B:384:0x066a, B:390:0x0679, B:392:0x04d8, B:393:0x04c5, B:394:0x04b1, B:401:0x0489, B:402:0x0474, B:403:0x0450, B:404:0x043c, B:405:0x0429, B:406:0x0416, B:407:0x0402, B:408:0x03ee, B:409:0x03da, B:410:0x023e, B:411:0x022f, B:412:0x024b, B:414:0x0256, B:416:0x025e, B:417:0x01fc, B:419:0x0204, B:420:0x020d, B:421:0x01e4, B:422:0x01d2, B:453:0x0138, B:456:0x0149, B:459:0x015c, B:463:0x016b, B:465:0x017f, B:466:0x0185), top: B:27:0x0068 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean b(int r30, int r31) {
        /*
            Method dump skipped, instructions count: 1968
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.platform.comapi.map.MapController.b(int, int):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0092  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean c(int r12, int r13) {
        /*
            Method dump skipped, instructions count: 261
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.platform.comapi.map.MapController.c(int, int):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x02a8 A[Catch: JSONException -> 0x031d, TryCatch #1 {JSONException -> 0x031d, blocks: (B:13:0x006b, B:15:0x0085, B:16:0x008b, B:24:0x02f4, B:25:0x00bd, B:28:0x00cc, B:32:0x00dd, B:33:0x00e8, B:35:0x00f7, B:36:0x010e, B:38:0x0114, B:43:0x0144, B:45:0x016f, B:47:0x0175, B:48:0x017b, B:50:0x0181, B:51:0x0187, B:53:0x018d, B:54:0x0193, B:56:0x019c, B:57:0x01a2, B:59:0x01aa, B:60:0x01b0, B:62:0x01b8, B:63:0x01be, B:65:0x01c4, B:66:0x01ca, B:68:0x01d2, B:69:0x01d8, B:71:0x01e0, B:72:0x01ef, B:74:0x01f7, B:76:0x0210, B:78:0x0216, B:79:0x021c, B:81:0x0224, B:82:0x0233, B:84:0x023b, B:85:0x0243, B:87:0x024b, B:88:0x0253, B:90:0x025c, B:91:0x0267, B:93:0x026f, B:94:0x027a, B:96:0x0282, B:97:0x028d, B:99:0x0295, B:100:0x02a0, B:102:0x02a8, B:103:0x02b3, B:105:0x02bb, B:106:0x02c6, B:108:0x02cf, B:109:0x02db, B:111:0x02e3, B:113:0x02f1, B:115:0x02ee, B:116:0x02d9, B:117:0x02c4, B:118:0x02b1, B:119:0x029e, B:120:0x028b, B:121:0x0278, B:122:0x0265, B:125:0x013d, B:126:0x012b, B:127:0x0149, B:129:0x0157, B:131:0x015d, B:132:0x00fe, B:134:0x0104, B:135:0x010b, B:136:0x00e4, B:141:0x0313, B:139:0x0099, B:19:0x0091), top: B:12:0x006b, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:105:0x02bb A[Catch: JSONException -> 0x031d, TryCatch #1 {JSONException -> 0x031d, blocks: (B:13:0x006b, B:15:0x0085, B:16:0x008b, B:24:0x02f4, B:25:0x00bd, B:28:0x00cc, B:32:0x00dd, B:33:0x00e8, B:35:0x00f7, B:36:0x010e, B:38:0x0114, B:43:0x0144, B:45:0x016f, B:47:0x0175, B:48:0x017b, B:50:0x0181, B:51:0x0187, B:53:0x018d, B:54:0x0193, B:56:0x019c, B:57:0x01a2, B:59:0x01aa, B:60:0x01b0, B:62:0x01b8, B:63:0x01be, B:65:0x01c4, B:66:0x01ca, B:68:0x01d2, B:69:0x01d8, B:71:0x01e0, B:72:0x01ef, B:74:0x01f7, B:76:0x0210, B:78:0x0216, B:79:0x021c, B:81:0x0224, B:82:0x0233, B:84:0x023b, B:85:0x0243, B:87:0x024b, B:88:0x0253, B:90:0x025c, B:91:0x0267, B:93:0x026f, B:94:0x027a, B:96:0x0282, B:97:0x028d, B:99:0x0295, B:100:0x02a0, B:102:0x02a8, B:103:0x02b3, B:105:0x02bb, B:106:0x02c6, B:108:0x02cf, B:109:0x02db, B:111:0x02e3, B:113:0x02f1, B:115:0x02ee, B:116:0x02d9, B:117:0x02c4, B:118:0x02b1, B:119:0x029e, B:120:0x028b, B:121:0x0278, B:122:0x0265, B:125:0x013d, B:126:0x012b, B:127:0x0149, B:129:0x0157, B:131:0x015d, B:132:0x00fe, B:134:0x0104, B:135:0x010b, B:136:0x00e4, B:141:0x0313, B:139:0x0099, B:19:0x0091), top: B:12:0x006b, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x02cf A[Catch: JSONException -> 0x031d, TryCatch #1 {JSONException -> 0x031d, blocks: (B:13:0x006b, B:15:0x0085, B:16:0x008b, B:24:0x02f4, B:25:0x00bd, B:28:0x00cc, B:32:0x00dd, B:33:0x00e8, B:35:0x00f7, B:36:0x010e, B:38:0x0114, B:43:0x0144, B:45:0x016f, B:47:0x0175, B:48:0x017b, B:50:0x0181, B:51:0x0187, B:53:0x018d, B:54:0x0193, B:56:0x019c, B:57:0x01a2, B:59:0x01aa, B:60:0x01b0, B:62:0x01b8, B:63:0x01be, B:65:0x01c4, B:66:0x01ca, B:68:0x01d2, B:69:0x01d8, B:71:0x01e0, B:72:0x01ef, B:74:0x01f7, B:76:0x0210, B:78:0x0216, B:79:0x021c, B:81:0x0224, B:82:0x0233, B:84:0x023b, B:85:0x0243, B:87:0x024b, B:88:0x0253, B:90:0x025c, B:91:0x0267, B:93:0x026f, B:94:0x027a, B:96:0x0282, B:97:0x028d, B:99:0x0295, B:100:0x02a0, B:102:0x02a8, B:103:0x02b3, B:105:0x02bb, B:106:0x02c6, B:108:0x02cf, B:109:0x02db, B:111:0x02e3, B:113:0x02f1, B:115:0x02ee, B:116:0x02d9, B:117:0x02c4, B:118:0x02b1, B:119:0x029e, B:120:0x028b, B:121:0x0278, B:122:0x0265, B:125:0x013d, B:126:0x012b, B:127:0x0149, B:129:0x0157, B:131:0x015d, B:132:0x00fe, B:134:0x0104, B:135:0x010b, B:136:0x00e4, B:141:0x0313, B:139:0x0099, B:19:0x0091), top: B:12:0x006b, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:111:0x02e3 A[Catch: JSONException -> 0x031d, TryCatch #1 {JSONException -> 0x031d, blocks: (B:13:0x006b, B:15:0x0085, B:16:0x008b, B:24:0x02f4, B:25:0x00bd, B:28:0x00cc, B:32:0x00dd, B:33:0x00e8, B:35:0x00f7, B:36:0x010e, B:38:0x0114, B:43:0x0144, B:45:0x016f, B:47:0x0175, B:48:0x017b, B:50:0x0181, B:51:0x0187, B:53:0x018d, B:54:0x0193, B:56:0x019c, B:57:0x01a2, B:59:0x01aa, B:60:0x01b0, B:62:0x01b8, B:63:0x01be, B:65:0x01c4, B:66:0x01ca, B:68:0x01d2, B:69:0x01d8, B:71:0x01e0, B:72:0x01ef, B:74:0x01f7, B:76:0x0210, B:78:0x0216, B:79:0x021c, B:81:0x0224, B:82:0x0233, B:84:0x023b, B:85:0x0243, B:87:0x024b, B:88:0x0253, B:90:0x025c, B:91:0x0267, B:93:0x026f, B:94:0x027a, B:96:0x0282, B:97:0x028d, B:99:0x0295, B:100:0x02a0, B:102:0x02a8, B:103:0x02b3, B:105:0x02bb, B:106:0x02c6, B:108:0x02cf, B:109:0x02db, B:111:0x02e3, B:113:0x02f1, B:115:0x02ee, B:116:0x02d9, B:117:0x02c4, B:118:0x02b1, B:119:0x029e, B:120:0x028b, B:121:0x0278, B:122:0x0265, B:125:0x013d, B:126:0x012b, B:127:0x0149, B:129:0x0157, B:131:0x015d, B:132:0x00fe, B:134:0x0104, B:135:0x010b, B:136:0x00e4, B:141:0x0313, B:139:0x0099, B:19:0x0091), top: B:12:0x006b, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:115:0x02ee A[Catch: JSONException -> 0x031d, TryCatch #1 {JSONException -> 0x031d, blocks: (B:13:0x006b, B:15:0x0085, B:16:0x008b, B:24:0x02f4, B:25:0x00bd, B:28:0x00cc, B:32:0x00dd, B:33:0x00e8, B:35:0x00f7, B:36:0x010e, B:38:0x0114, B:43:0x0144, B:45:0x016f, B:47:0x0175, B:48:0x017b, B:50:0x0181, B:51:0x0187, B:53:0x018d, B:54:0x0193, B:56:0x019c, B:57:0x01a2, B:59:0x01aa, B:60:0x01b0, B:62:0x01b8, B:63:0x01be, B:65:0x01c4, B:66:0x01ca, B:68:0x01d2, B:69:0x01d8, B:71:0x01e0, B:72:0x01ef, B:74:0x01f7, B:76:0x0210, B:78:0x0216, B:79:0x021c, B:81:0x0224, B:82:0x0233, B:84:0x023b, B:85:0x0243, B:87:0x024b, B:88:0x0253, B:90:0x025c, B:91:0x0267, B:93:0x026f, B:94:0x027a, B:96:0x0282, B:97:0x028d, B:99:0x0295, B:100:0x02a0, B:102:0x02a8, B:103:0x02b3, B:105:0x02bb, B:106:0x02c6, B:108:0x02cf, B:109:0x02db, B:111:0x02e3, B:113:0x02f1, B:115:0x02ee, B:116:0x02d9, B:117:0x02c4, B:118:0x02b1, B:119:0x029e, B:120:0x028b, B:121:0x0278, B:122:0x0265, B:125:0x013d, B:126:0x012b, B:127:0x0149, B:129:0x0157, B:131:0x015d, B:132:0x00fe, B:134:0x0104, B:135:0x010b, B:136:0x00e4, B:141:0x0313, B:139:0x0099, B:19:0x0091), top: B:12:0x006b, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:116:0x02d9 A[Catch: JSONException -> 0x031d, TryCatch #1 {JSONException -> 0x031d, blocks: (B:13:0x006b, B:15:0x0085, B:16:0x008b, B:24:0x02f4, B:25:0x00bd, B:28:0x00cc, B:32:0x00dd, B:33:0x00e8, B:35:0x00f7, B:36:0x010e, B:38:0x0114, B:43:0x0144, B:45:0x016f, B:47:0x0175, B:48:0x017b, B:50:0x0181, B:51:0x0187, B:53:0x018d, B:54:0x0193, B:56:0x019c, B:57:0x01a2, B:59:0x01aa, B:60:0x01b0, B:62:0x01b8, B:63:0x01be, B:65:0x01c4, B:66:0x01ca, B:68:0x01d2, B:69:0x01d8, B:71:0x01e0, B:72:0x01ef, B:74:0x01f7, B:76:0x0210, B:78:0x0216, B:79:0x021c, B:81:0x0224, B:82:0x0233, B:84:0x023b, B:85:0x0243, B:87:0x024b, B:88:0x0253, B:90:0x025c, B:91:0x0267, B:93:0x026f, B:94:0x027a, B:96:0x0282, B:97:0x028d, B:99:0x0295, B:100:0x02a0, B:102:0x02a8, B:103:0x02b3, B:105:0x02bb, B:106:0x02c6, B:108:0x02cf, B:109:0x02db, B:111:0x02e3, B:113:0x02f1, B:115:0x02ee, B:116:0x02d9, B:117:0x02c4, B:118:0x02b1, B:119:0x029e, B:120:0x028b, B:121:0x0278, B:122:0x0265, B:125:0x013d, B:126:0x012b, B:127:0x0149, B:129:0x0157, B:131:0x015d, B:132:0x00fe, B:134:0x0104, B:135:0x010b, B:136:0x00e4, B:141:0x0313, B:139:0x0099, B:19:0x0091), top: B:12:0x006b, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x02c4 A[Catch: JSONException -> 0x031d, TryCatch #1 {JSONException -> 0x031d, blocks: (B:13:0x006b, B:15:0x0085, B:16:0x008b, B:24:0x02f4, B:25:0x00bd, B:28:0x00cc, B:32:0x00dd, B:33:0x00e8, B:35:0x00f7, B:36:0x010e, B:38:0x0114, B:43:0x0144, B:45:0x016f, B:47:0x0175, B:48:0x017b, B:50:0x0181, B:51:0x0187, B:53:0x018d, B:54:0x0193, B:56:0x019c, B:57:0x01a2, B:59:0x01aa, B:60:0x01b0, B:62:0x01b8, B:63:0x01be, B:65:0x01c4, B:66:0x01ca, B:68:0x01d2, B:69:0x01d8, B:71:0x01e0, B:72:0x01ef, B:74:0x01f7, B:76:0x0210, B:78:0x0216, B:79:0x021c, B:81:0x0224, B:82:0x0233, B:84:0x023b, B:85:0x0243, B:87:0x024b, B:88:0x0253, B:90:0x025c, B:91:0x0267, B:93:0x026f, B:94:0x027a, B:96:0x0282, B:97:0x028d, B:99:0x0295, B:100:0x02a0, B:102:0x02a8, B:103:0x02b3, B:105:0x02bb, B:106:0x02c6, B:108:0x02cf, B:109:0x02db, B:111:0x02e3, B:113:0x02f1, B:115:0x02ee, B:116:0x02d9, B:117:0x02c4, B:118:0x02b1, B:119:0x029e, B:120:0x028b, B:121:0x0278, B:122:0x0265, B:125:0x013d, B:126:0x012b, B:127:0x0149, B:129:0x0157, B:131:0x015d, B:132:0x00fe, B:134:0x0104, B:135:0x010b, B:136:0x00e4, B:141:0x0313, B:139:0x0099, B:19:0x0091), top: B:12:0x006b, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x02b1 A[Catch: JSONException -> 0x031d, TryCatch #1 {JSONException -> 0x031d, blocks: (B:13:0x006b, B:15:0x0085, B:16:0x008b, B:24:0x02f4, B:25:0x00bd, B:28:0x00cc, B:32:0x00dd, B:33:0x00e8, B:35:0x00f7, B:36:0x010e, B:38:0x0114, B:43:0x0144, B:45:0x016f, B:47:0x0175, B:48:0x017b, B:50:0x0181, B:51:0x0187, B:53:0x018d, B:54:0x0193, B:56:0x019c, B:57:0x01a2, B:59:0x01aa, B:60:0x01b0, B:62:0x01b8, B:63:0x01be, B:65:0x01c4, B:66:0x01ca, B:68:0x01d2, B:69:0x01d8, B:71:0x01e0, B:72:0x01ef, B:74:0x01f7, B:76:0x0210, B:78:0x0216, B:79:0x021c, B:81:0x0224, B:82:0x0233, B:84:0x023b, B:85:0x0243, B:87:0x024b, B:88:0x0253, B:90:0x025c, B:91:0x0267, B:93:0x026f, B:94:0x027a, B:96:0x0282, B:97:0x028d, B:99:0x0295, B:100:0x02a0, B:102:0x02a8, B:103:0x02b3, B:105:0x02bb, B:106:0x02c6, B:108:0x02cf, B:109:0x02db, B:111:0x02e3, B:113:0x02f1, B:115:0x02ee, B:116:0x02d9, B:117:0x02c4, B:118:0x02b1, B:119:0x029e, B:120:0x028b, B:121:0x0278, B:122:0x0265, B:125:0x013d, B:126:0x012b, B:127:0x0149, B:129:0x0157, B:131:0x015d, B:132:0x00fe, B:134:0x0104, B:135:0x010b, B:136:0x00e4, B:141:0x0313, B:139:0x0099, B:19:0x0091), top: B:12:0x006b, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x029e A[Catch: JSONException -> 0x031d, TryCatch #1 {JSONException -> 0x031d, blocks: (B:13:0x006b, B:15:0x0085, B:16:0x008b, B:24:0x02f4, B:25:0x00bd, B:28:0x00cc, B:32:0x00dd, B:33:0x00e8, B:35:0x00f7, B:36:0x010e, B:38:0x0114, B:43:0x0144, B:45:0x016f, B:47:0x0175, B:48:0x017b, B:50:0x0181, B:51:0x0187, B:53:0x018d, B:54:0x0193, B:56:0x019c, B:57:0x01a2, B:59:0x01aa, B:60:0x01b0, B:62:0x01b8, B:63:0x01be, B:65:0x01c4, B:66:0x01ca, B:68:0x01d2, B:69:0x01d8, B:71:0x01e0, B:72:0x01ef, B:74:0x01f7, B:76:0x0210, B:78:0x0216, B:79:0x021c, B:81:0x0224, B:82:0x0233, B:84:0x023b, B:85:0x0243, B:87:0x024b, B:88:0x0253, B:90:0x025c, B:91:0x0267, B:93:0x026f, B:94:0x027a, B:96:0x0282, B:97:0x028d, B:99:0x0295, B:100:0x02a0, B:102:0x02a8, B:103:0x02b3, B:105:0x02bb, B:106:0x02c6, B:108:0x02cf, B:109:0x02db, B:111:0x02e3, B:113:0x02f1, B:115:0x02ee, B:116:0x02d9, B:117:0x02c4, B:118:0x02b1, B:119:0x029e, B:120:0x028b, B:121:0x0278, B:122:0x0265, B:125:0x013d, B:126:0x012b, B:127:0x0149, B:129:0x0157, B:131:0x015d, B:132:0x00fe, B:134:0x0104, B:135:0x010b, B:136:0x00e4, B:141:0x0313, B:139:0x0099, B:19:0x0091), top: B:12:0x006b, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x028b A[Catch: JSONException -> 0x031d, TryCatch #1 {JSONException -> 0x031d, blocks: (B:13:0x006b, B:15:0x0085, B:16:0x008b, B:24:0x02f4, B:25:0x00bd, B:28:0x00cc, B:32:0x00dd, B:33:0x00e8, B:35:0x00f7, B:36:0x010e, B:38:0x0114, B:43:0x0144, B:45:0x016f, B:47:0x0175, B:48:0x017b, B:50:0x0181, B:51:0x0187, B:53:0x018d, B:54:0x0193, B:56:0x019c, B:57:0x01a2, B:59:0x01aa, B:60:0x01b0, B:62:0x01b8, B:63:0x01be, B:65:0x01c4, B:66:0x01ca, B:68:0x01d2, B:69:0x01d8, B:71:0x01e0, B:72:0x01ef, B:74:0x01f7, B:76:0x0210, B:78:0x0216, B:79:0x021c, B:81:0x0224, B:82:0x0233, B:84:0x023b, B:85:0x0243, B:87:0x024b, B:88:0x0253, B:90:0x025c, B:91:0x0267, B:93:0x026f, B:94:0x027a, B:96:0x0282, B:97:0x028d, B:99:0x0295, B:100:0x02a0, B:102:0x02a8, B:103:0x02b3, B:105:0x02bb, B:106:0x02c6, B:108:0x02cf, B:109:0x02db, B:111:0x02e3, B:113:0x02f1, B:115:0x02ee, B:116:0x02d9, B:117:0x02c4, B:118:0x02b1, B:119:0x029e, B:120:0x028b, B:121:0x0278, B:122:0x0265, B:125:0x013d, B:126:0x012b, B:127:0x0149, B:129:0x0157, B:131:0x015d, B:132:0x00fe, B:134:0x0104, B:135:0x010b, B:136:0x00e4, B:141:0x0313, B:139:0x0099, B:19:0x0091), top: B:12:0x006b, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0278 A[Catch: JSONException -> 0x031d, TryCatch #1 {JSONException -> 0x031d, blocks: (B:13:0x006b, B:15:0x0085, B:16:0x008b, B:24:0x02f4, B:25:0x00bd, B:28:0x00cc, B:32:0x00dd, B:33:0x00e8, B:35:0x00f7, B:36:0x010e, B:38:0x0114, B:43:0x0144, B:45:0x016f, B:47:0x0175, B:48:0x017b, B:50:0x0181, B:51:0x0187, B:53:0x018d, B:54:0x0193, B:56:0x019c, B:57:0x01a2, B:59:0x01aa, B:60:0x01b0, B:62:0x01b8, B:63:0x01be, B:65:0x01c4, B:66:0x01ca, B:68:0x01d2, B:69:0x01d8, B:71:0x01e0, B:72:0x01ef, B:74:0x01f7, B:76:0x0210, B:78:0x0216, B:79:0x021c, B:81:0x0224, B:82:0x0233, B:84:0x023b, B:85:0x0243, B:87:0x024b, B:88:0x0253, B:90:0x025c, B:91:0x0267, B:93:0x026f, B:94:0x027a, B:96:0x0282, B:97:0x028d, B:99:0x0295, B:100:0x02a0, B:102:0x02a8, B:103:0x02b3, B:105:0x02bb, B:106:0x02c6, B:108:0x02cf, B:109:0x02db, B:111:0x02e3, B:113:0x02f1, B:115:0x02ee, B:116:0x02d9, B:117:0x02c4, B:118:0x02b1, B:119:0x029e, B:120:0x028b, B:121:0x0278, B:122:0x0265, B:125:0x013d, B:126:0x012b, B:127:0x0149, B:129:0x0157, B:131:0x015d, B:132:0x00fe, B:134:0x0104, B:135:0x010b, B:136:0x00e4, B:141:0x0313, B:139:0x0099, B:19:0x0091), top: B:12:0x006b, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0265 A[Catch: JSONException -> 0x031d, TryCatch #1 {JSONException -> 0x031d, blocks: (B:13:0x006b, B:15:0x0085, B:16:0x008b, B:24:0x02f4, B:25:0x00bd, B:28:0x00cc, B:32:0x00dd, B:33:0x00e8, B:35:0x00f7, B:36:0x010e, B:38:0x0114, B:43:0x0144, B:45:0x016f, B:47:0x0175, B:48:0x017b, B:50:0x0181, B:51:0x0187, B:53:0x018d, B:54:0x0193, B:56:0x019c, B:57:0x01a2, B:59:0x01aa, B:60:0x01b0, B:62:0x01b8, B:63:0x01be, B:65:0x01c4, B:66:0x01ca, B:68:0x01d2, B:69:0x01d8, B:71:0x01e0, B:72:0x01ef, B:74:0x01f7, B:76:0x0210, B:78:0x0216, B:79:0x021c, B:81:0x0224, B:82:0x0233, B:84:0x023b, B:85:0x0243, B:87:0x024b, B:88:0x0253, B:90:0x025c, B:91:0x0267, B:93:0x026f, B:94:0x027a, B:96:0x0282, B:97:0x028d, B:99:0x0295, B:100:0x02a0, B:102:0x02a8, B:103:0x02b3, B:105:0x02bb, B:106:0x02c6, B:108:0x02cf, B:109:0x02db, B:111:0x02e3, B:113:0x02f1, B:115:0x02ee, B:116:0x02d9, B:117:0x02c4, B:118:0x02b1, B:119:0x029e, B:120:0x028b, B:121:0x0278, B:122:0x0265, B:125:0x013d, B:126:0x012b, B:127:0x0149, B:129:0x0157, B:131:0x015d, B:132:0x00fe, B:134:0x0104, B:135:0x010b, B:136:0x00e4, B:141:0x0313, B:139:0x0099, B:19:0x0091), top: B:12:0x006b, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0175 A[Catch: JSONException -> 0x031d, TryCatch #1 {JSONException -> 0x031d, blocks: (B:13:0x006b, B:15:0x0085, B:16:0x008b, B:24:0x02f4, B:25:0x00bd, B:28:0x00cc, B:32:0x00dd, B:33:0x00e8, B:35:0x00f7, B:36:0x010e, B:38:0x0114, B:43:0x0144, B:45:0x016f, B:47:0x0175, B:48:0x017b, B:50:0x0181, B:51:0x0187, B:53:0x018d, B:54:0x0193, B:56:0x019c, B:57:0x01a2, B:59:0x01aa, B:60:0x01b0, B:62:0x01b8, B:63:0x01be, B:65:0x01c4, B:66:0x01ca, B:68:0x01d2, B:69:0x01d8, B:71:0x01e0, B:72:0x01ef, B:74:0x01f7, B:76:0x0210, B:78:0x0216, B:79:0x021c, B:81:0x0224, B:82:0x0233, B:84:0x023b, B:85:0x0243, B:87:0x024b, B:88:0x0253, B:90:0x025c, B:91:0x0267, B:93:0x026f, B:94:0x027a, B:96:0x0282, B:97:0x028d, B:99:0x0295, B:100:0x02a0, B:102:0x02a8, B:103:0x02b3, B:105:0x02bb, B:106:0x02c6, B:108:0x02cf, B:109:0x02db, B:111:0x02e3, B:113:0x02f1, B:115:0x02ee, B:116:0x02d9, B:117:0x02c4, B:118:0x02b1, B:119:0x029e, B:120:0x028b, B:121:0x0278, B:122:0x0265, B:125:0x013d, B:126:0x012b, B:127:0x0149, B:129:0x0157, B:131:0x015d, B:132:0x00fe, B:134:0x0104, B:135:0x010b, B:136:0x00e4, B:141:0x0313, B:139:0x0099, B:19:0x0091), top: B:12:0x006b, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0181 A[Catch: JSONException -> 0x031d, TryCatch #1 {JSONException -> 0x031d, blocks: (B:13:0x006b, B:15:0x0085, B:16:0x008b, B:24:0x02f4, B:25:0x00bd, B:28:0x00cc, B:32:0x00dd, B:33:0x00e8, B:35:0x00f7, B:36:0x010e, B:38:0x0114, B:43:0x0144, B:45:0x016f, B:47:0x0175, B:48:0x017b, B:50:0x0181, B:51:0x0187, B:53:0x018d, B:54:0x0193, B:56:0x019c, B:57:0x01a2, B:59:0x01aa, B:60:0x01b0, B:62:0x01b8, B:63:0x01be, B:65:0x01c4, B:66:0x01ca, B:68:0x01d2, B:69:0x01d8, B:71:0x01e0, B:72:0x01ef, B:74:0x01f7, B:76:0x0210, B:78:0x0216, B:79:0x021c, B:81:0x0224, B:82:0x0233, B:84:0x023b, B:85:0x0243, B:87:0x024b, B:88:0x0253, B:90:0x025c, B:91:0x0267, B:93:0x026f, B:94:0x027a, B:96:0x0282, B:97:0x028d, B:99:0x0295, B:100:0x02a0, B:102:0x02a8, B:103:0x02b3, B:105:0x02bb, B:106:0x02c6, B:108:0x02cf, B:109:0x02db, B:111:0x02e3, B:113:0x02f1, B:115:0x02ee, B:116:0x02d9, B:117:0x02c4, B:118:0x02b1, B:119:0x029e, B:120:0x028b, B:121:0x0278, B:122:0x0265, B:125:0x013d, B:126:0x012b, B:127:0x0149, B:129:0x0157, B:131:0x015d, B:132:0x00fe, B:134:0x0104, B:135:0x010b, B:136:0x00e4, B:141:0x0313, B:139:0x0099, B:19:0x0091), top: B:12:0x006b, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x018d A[Catch: JSONException -> 0x031d, TryCatch #1 {JSONException -> 0x031d, blocks: (B:13:0x006b, B:15:0x0085, B:16:0x008b, B:24:0x02f4, B:25:0x00bd, B:28:0x00cc, B:32:0x00dd, B:33:0x00e8, B:35:0x00f7, B:36:0x010e, B:38:0x0114, B:43:0x0144, B:45:0x016f, B:47:0x0175, B:48:0x017b, B:50:0x0181, B:51:0x0187, B:53:0x018d, B:54:0x0193, B:56:0x019c, B:57:0x01a2, B:59:0x01aa, B:60:0x01b0, B:62:0x01b8, B:63:0x01be, B:65:0x01c4, B:66:0x01ca, B:68:0x01d2, B:69:0x01d8, B:71:0x01e0, B:72:0x01ef, B:74:0x01f7, B:76:0x0210, B:78:0x0216, B:79:0x021c, B:81:0x0224, B:82:0x0233, B:84:0x023b, B:85:0x0243, B:87:0x024b, B:88:0x0253, B:90:0x025c, B:91:0x0267, B:93:0x026f, B:94:0x027a, B:96:0x0282, B:97:0x028d, B:99:0x0295, B:100:0x02a0, B:102:0x02a8, B:103:0x02b3, B:105:0x02bb, B:106:0x02c6, B:108:0x02cf, B:109:0x02db, B:111:0x02e3, B:113:0x02f1, B:115:0x02ee, B:116:0x02d9, B:117:0x02c4, B:118:0x02b1, B:119:0x029e, B:120:0x028b, B:121:0x0278, B:122:0x0265, B:125:0x013d, B:126:0x012b, B:127:0x0149, B:129:0x0157, B:131:0x015d, B:132:0x00fe, B:134:0x0104, B:135:0x010b, B:136:0x00e4, B:141:0x0313, B:139:0x0099, B:19:0x0091), top: B:12:0x006b, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x019c A[Catch: JSONException -> 0x031d, TryCatch #1 {JSONException -> 0x031d, blocks: (B:13:0x006b, B:15:0x0085, B:16:0x008b, B:24:0x02f4, B:25:0x00bd, B:28:0x00cc, B:32:0x00dd, B:33:0x00e8, B:35:0x00f7, B:36:0x010e, B:38:0x0114, B:43:0x0144, B:45:0x016f, B:47:0x0175, B:48:0x017b, B:50:0x0181, B:51:0x0187, B:53:0x018d, B:54:0x0193, B:56:0x019c, B:57:0x01a2, B:59:0x01aa, B:60:0x01b0, B:62:0x01b8, B:63:0x01be, B:65:0x01c4, B:66:0x01ca, B:68:0x01d2, B:69:0x01d8, B:71:0x01e0, B:72:0x01ef, B:74:0x01f7, B:76:0x0210, B:78:0x0216, B:79:0x021c, B:81:0x0224, B:82:0x0233, B:84:0x023b, B:85:0x0243, B:87:0x024b, B:88:0x0253, B:90:0x025c, B:91:0x0267, B:93:0x026f, B:94:0x027a, B:96:0x0282, B:97:0x028d, B:99:0x0295, B:100:0x02a0, B:102:0x02a8, B:103:0x02b3, B:105:0x02bb, B:106:0x02c6, B:108:0x02cf, B:109:0x02db, B:111:0x02e3, B:113:0x02f1, B:115:0x02ee, B:116:0x02d9, B:117:0x02c4, B:118:0x02b1, B:119:0x029e, B:120:0x028b, B:121:0x0278, B:122:0x0265, B:125:0x013d, B:126:0x012b, B:127:0x0149, B:129:0x0157, B:131:0x015d, B:132:0x00fe, B:134:0x0104, B:135:0x010b, B:136:0x00e4, B:141:0x0313, B:139:0x0099, B:19:0x0091), top: B:12:0x006b, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01aa A[Catch: JSONException -> 0x031d, TryCatch #1 {JSONException -> 0x031d, blocks: (B:13:0x006b, B:15:0x0085, B:16:0x008b, B:24:0x02f4, B:25:0x00bd, B:28:0x00cc, B:32:0x00dd, B:33:0x00e8, B:35:0x00f7, B:36:0x010e, B:38:0x0114, B:43:0x0144, B:45:0x016f, B:47:0x0175, B:48:0x017b, B:50:0x0181, B:51:0x0187, B:53:0x018d, B:54:0x0193, B:56:0x019c, B:57:0x01a2, B:59:0x01aa, B:60:0x01b0, B:62:0x01b8, B:63:0x01be, B:65:0x01c4, B:66:0x01ca, B:68:0x01d2, B:69:0x01d8, B:71:0x01e0, B:72:0x01ef, B:74:0x01f7, B:76:0x0210, B:78:0x0216, B:79:0x021c, B:81:0x0224, B:82:0x0233, B:84:0x023b, B:85:0x0243, B:87:0x024b, B:88:0x0253, B:90:0x025c, B:91:0x0267, B:93:0x026f, B:94:0x027a, B:96:0x0282, B:97:0x028d, B:99:0x0295, B:100:0x02a0, B:102:0x02a8, B:103:0x02b3, B:105:0x02bb, B:106:0x02c6, B:108:0x02cf, B:109:0x02db, B:111:0x02e3, B:113:0x02f1, B:115:0x02ee, B:116:0x02d9, B:117:0x02c4, B:118:0x02b1, B:119:0x029e, B:120:0x028b, B:121:0x0278, B:122:0x0265, B:125:0x013d, B:126:0x012b, B:127:0x0149, B:129:0x0157, B:131:0x015d, B:132:0x00fe, B:134:0x0104, B:135:0x010b, B:136:0x00e4, B:141:0x0313, B:139:0x0099, B:19:0x0091), top: B:12:0x006b, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01b8 A[Catch: JSONException -> 0x031d, TryCatch #1 {JSONException -> 0x031d, blocks: (B:13:0x006b, B:15:0x0085, B:16:0x008b, B:24:0x02f4, B:25:0x00bd, B:28:0x00cc, B:32:0x00dd, B:33:0x00e8, B:35:0x00f7, B:36:0x010e, B:38:0x0114, B:43:0x0144, B:45:0x016f, B:47:0x0175, B:48:0x017b, B:50:0x0181, B:51:0x0187, B:53:0x018d, B:54:0x0193, B:56:0x019c, B:57:0x01a2, B:59:0x01aa, B:60:0x01b0, B:62:0x01b8, B:63:0x01be, B:65:0x01c4, B:66:0x01ca, B:68:0x01d2, B:69:0x01d8, B:71:0x01e0, B:72:0x01ef, B:74:0x01f7, B:76:0x0210, B:78:0x0216, B:79:0x021c, B:81:0x0224, B:82:0x0233, B:84:0x023b, B:85:0x0243, B:87:0x024b, B:88:0x0253, B:90:0x025c, B:91:0x0267, B:93:0x026f, B:94:0x027a, B:96:0x0282, B:97:0x028d, B:99:0x0295, B:100:0x02a0, B:102:0x02a8, B:103:0x02b3, B:105:0x02bb, B:106:0x02c6, B:108:0x02cf, B:109:0x02db, B:111:0x02e3, B:113:0x02f1, B:115:0x02ee, B:116:0x02d9, B:117:0x02c4, B:118:0x02b1, B:119:0x029e, B:120:0x028b, B:121:0x0278, B:122:0x0265, B:125:0x013d, B:126:0x012b, B:127:0x0149, B:129:0x0157, B:131:0x015d, B:132:0x00fe, B:134:0x0104, B:135:0x010b, B:136:0x00e4, B:141:0x0313, B:139:0x0099, B:19:0x0091), top: B:12:0x006b, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01c4 A[Catch: JSONException -> 0x031d, TryCatch #1 {JSONException -> 0x031d, blocks: (B:13:0x006b, B:15:0x0085, B:16:0x008b, B:24:0x02f4, B:25:0x00bd, B:28:0x00cc, B:32:0x00dd, B:33:0x00e8, B:35:0x00f7, B:36:0x010e, B:38:0x0114, B:43:0x0144, B:45:0x016f, B:47:0x0175, B:48:0x017b, B:50:0x0181, B:51:0x0187, B:53:0x018d, B:54:0x0193, B:56:0x019c, B:57:0x01a2, B:59:0x01aa, B:60:0x01b0, B:62:0x01b8, B:63:0x01be, B:65:0x01c4, B:66:0x01ca, B:68:0x01d2, B:69:0x01d8, B:71:0x01e0, B:72:0x01ef, B:74:0x01f7, B:76:0x0210, B:78:0x0216, B:79:0x021c, B:81:0x0224, B:82:0x0233, B:84:0x023b, B:85:0x0243, B:87:0x024b, B:88:0x0253, B:90:0x025c, B:91:0x0267, B:93:0x026f, B:94:0x027a, B:96:0x0282, B:97:0x028d, B:99:0x0295, B:100:0x02a0, B:102:0x02a8, B:103:0x02b3, B:105:0x02bb, B:106:0x02c6, B:108:0x02cf, B:109:0x02db, B:111:0x02e3, B:113:0x02f1, B:115:0x02ee, B:116:0x02d9, B:117:0x02c4, B:118:0x02b1, B:119:0x029e, B:120:0x028b, B:121:0x0278, B:122:0x0265, B:125:0x013d, B:126:0x012b, B:127:0x0149, B:129:0x0157, B:131:0x015d, B:132:0x00fe, B:134:0x0104, B:135:0x010b, B:136:0x00e4, B:141:0x0313, B:139:0x0099, B:19:0x0091), top: B:12:0x006b, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01d2 A[Catch: JSONException -> 0x031d, TryCatch #1 {JSONException -> 0x031d, blocks: (B:13:0x006b, B:15:0x0085, B:16:0x008b, B:24:0x02f4, B:25:0x00bd, B:28:0x00cc, B:32:0x00dd, B:33:0x00e8, B:35:0x00f7, B:36:0x010e, B:38:0x0114, B:43:0x0144, B:45:0x016f, B:47:0x0175, B:48:0x017b, B:50:0x0181, B:51:0x0187, B:53:0x018d, B:54:0x0193, B:56:0x019c, B:57:0x01a2, B:59:0x01aa, B:60:0x01b0, B:62:0x01b8, B:63:0x01be, B:65:0x01c4, B:66:0x01ca, B:68:0x01d2, B:69:0x01d8, B:71:0x01e0, B:72:0x01ef, B:74:0x01f7, B:76:0x0210, B:78:0x0216, B:79:0x021c, B:81:0x0224, B:82:0x0233, B:84:0x023b, B:85:0x0243, B:87:0x024b, B:88:0x0253, B:90:0x025c, B:91:0x0267, B:93:0x026f, B:94:0x027a, B:96:0x0282, B:97:0x028d, B:99:0x0295, B:100:0x02a0, B:102:0x02a8, B:103:0x02b3, B:105:0x02bb, B:106:0x02c6, B:108:0x02cf, B:109:0x02db, B:111:0x02e3, B:113:0x02f1, B:115:0x02ee, B:116:0x02d9, B:117:0x02c4, B:118:0x02b1, B:119:0x029e, B:120:0x028b, B:121:0x0278, B:122:0x0265, B:125:0x013d, B:126:0x012b, B:127:0x0149, B:129:0x0157, B:131:0x015d, B:132:0x00fe, B:134:0x0104, B:135:0x010b, B:136:0x00e4, B:141:0x0313, B:139:0x0099, B:19:0x0091), top: B:12:0x006b, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01e0 A[Catch: JSONException -> 0x031d, TryCatch #1 {JSONException -> 0x031d, blocks: (B:13:0x006b, B:15:0x0085, B:16:0x008b, B:24:0x02f4, B:25:0x00bd, B:28:0x00cc, B:32:0x00dd, B:33:0x00e8, B:35:0x00f7, B:36:0x010e, B:38:0x0114, B:43:0x0144, B:45:0x016f, B:47:0x0175, B:48:0x017b, B:50:0x0181, B:51:0x0187, B:53:0x018d, B:54:0x0193, B:56:0x019c, B:57:0x01a2, B:59:0x01aa, B:60:0x01b0, B:62:0x01b8, B:63:0x01be, B:65:0x01c4, B:66:0x01ca, B:68:0x01d2, B:69:0x01d8, B:71:0x01e0, B:72:0x01ef, B:74:0x01f7, B:76:0x0210, B:78:0x0216, B:79:0x021c, B:81:0x0224, B:82:0x0233, B:84:0x023b, B:85:0x0243, B:87:0x024b, B:88:0x0253, B:90:0x025c, B:91:0x0267, B:93:0x026f, B:94:0x027a, B:96:0x0282, B:97:0x028d, B:99:0x0295, B:100:0x02a0, B:102:0x02a8, B:103:0x02b3, B:105:0x02bb, B:106:0x02c6, B:108:0x02cf, B:109:0x02db, B:111:0x02e3, B:113:0x02f1, B:115:0x02ee, B:116:0x02d9, B:117:0x02c4, B:118:0x02b1, B:119:0x029e, B:120:0x028b, B:121:0x0278, B:122:0x0265, B:125:0x013d, B:126:0x012b, B:127:0x0149, B:129:0x0157, B:131:0x015d, B:132:0x00fe, B:134:0x0104, B:135:0x010b, B:136:0x00e4, B:141:0x0313, B:139:0x0099, B:19:0x0091), top: B:12:0x006b, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01f7 A[Catch: JSONException -> 0x031d, TryCatch #1 {JSONException -> 0x031d, blocks: (B:13:0x006b, B:15:0x0085, B:16:0x008b, B:24:0x02f4, B:25:0x00bd, B:28:0x00cc, B:32:0x00dd, B:33:0x00e8, B:35:0x00f7, B:36:0x010e, B:38:0x0114, B:43:0x0144, B:45:0x016f, B:47:0x0175, B:48:0x017b, B:50:0x0181, B:51:0x0187, B:53:0x018d, B:54:0x0193, B:56:0x019c, B:57:0x01a2, B:59:0x01aa, B:60:0x01b0, B:62:0x01b8, B:63:0x01be, B:65:0x01c4, B:66:0x01ca, B:68:0x01d2, B:69:0x01d8, B:71:0x01e0, B:72:0x01ef, B:74:0x01f7, B:76:0x0210, B:78:0x0216, B:79:0x021c, B:81:0x0224, B:82:0x0233, B:84:0x023b, B:85:0x0243, B:87:0x024b, B:88:0x0253, B:90:0x025c, B:91:0x0267, B:93:0x026f, B:94:0x027a, B:96:0x0282, B:97:0x028d, B:99:0x0295, B:100:0x02a0, B:102:0x02a8, B:103:0x02b3, B:105:0x02bb, B:106:0x02c6, B:108:0x02cf, B:109:0x02db, B:111:0x02e3, B:113:0x02f1, B:115:0x02ee, B:116:0x02d9, B:117:0x02c4, B:118:0x02b1, B:119:0x029e, B:120:0x028b, B:121:0x0278, B:122:0x0265, B:125:0x013d, B:126:0x012b, B:127:0x0149, B:129:0x0157, B:131:0x015d, B:132:0x00fe, B:134:0x0104, B:135:0x010b, B:136:0x00e4, B:141:0x0313, B:139:0x0099, B:19:0x0091), top: B:12:0x006b, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0216 A[Catch: JSONException -> 0x031d, TryCatch #1 {JSONException -> 0x031d, blocks: (B:13:0x006b, B:15:0x0085, B:16:0x008b, B:24:0x02f4, B:25:0x00bd, B:28:0x00cc, B:32:0x00dd, B:33:0x00e8, B:35:0x00f7, B:36:0x010e, B:38:0x0114, B:43:0x0144, B:45:0x016f, B:47:0x0175, B:48:0x017b, B:50:0x0181, B:51:0x0187, B:53:0x018d, B:54:0x0193, B:56:0x019c, B:57:0x01a2, B:59:0x01aa, B:60:0x01b0, B:62:0x01b8, B:63:0x01be, B:65:0x01c4, B:66:0x01ca, B:68:0x01d2, B:69:0x01d8, B:71:0x01e0, B:72:0x01ef, B:74:0x01f7, B:76:0x0210, B:78:0x0216, B:79:0x021c, B:81:0x0224, B:82:0x0233, B:84:0x023b, B:85:0x0243, B:87:0x024b, B:88:0x0253, B:90:0x025c, B:91:0x0267, B:93:0x026f, B:94:0x027a, B:96:0x0282, B:97:0x028d, B:99:0x0295, B:100:0x02a0, B:102:0x02a8, B:103:0x02b3, B:105:0x02bb, B:106:0x02c6, B:108:0x02cf, B:109:0x02db, B:111:0x02e3, B:113:0x02f1, B:115:0x02ee, B:116:0x02d9, B:117:0x02c4, B:118:0x02b1, B:119:0x029e, B:120:0x028b, B:121:0x0278, B:122:0x0265, B:125:0x013d, B:126:0x012b, B:127:0x0149, B:129:0x0157, B:131:0x015d, B:132:0x00fe, B:134:0x0104, B:135:0x010b, B:136:0x00e4, B:141:0x0313, B:139:0x0099, B:19:0x0091), top: B:12:0x006b, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0224 A[Catch: JSONException -> 0x031d, TryCatch #1 {JSONException -> 0x031d, blocks: (B:13:0x006b, B:15:0x0085, B:16:0x008b, B:24:0x02f4, B:25:0x00bd, B:28:0x00cc, B:32:0x00dd, B:33:0x00e8, B:35:0x00f7, B:36:0x010e, B:38:0x0114, B:43:0x0144, B:45:0x016f, B:47:0x0175, B:48:0x017b, B:50:0x0181, B:51:0x0187, B:53:0x018d, B:54:0x0193, B:56:0x019c, B:57:0x01a2, B:59:0x01aa, B:60:0x01b0, B:62:0x01b8, B:63:0x01be, B:65:0x01c4, B:66:0x01ca, B:68:0x01d2, B:69:0x01d8, B:71:0x01e0, B:72:0x01ef, B:74:0x01f7, B:76:0x0210, B:78:0x0216, B:79:0x021c, B:81:0x0224, B:82:0x0233, B:84:0x023b, B:85:0x0243, B:87:0x024b, B:88:0x0253, B:90:0x025c, B:91:0x0267, B:93:0x026f, B:94:0x027a, B:96:0x0282, B:97:0x028d, B:99:0x0295, B:100:0x02a0, B:102:0x02a8, B:103:0x02b3, B:105:0x02bb, B:106:0x02c6, B:108:0x02cf, B:109:0x02db, B:111:0x02e3, B:113:0x02f1, B:115:0x02ee, B:116:0x02d9, B:117:0x02c4, B:118:0x02b1, B:119:0x029e, B:120:0x028b, B:121:0x0278, B:122:0x0265, B:125:0x013d, B:126:0x012b, B:127:0x0149, B:129:0x0157, B:131:0x015d, B:132:0x00fe, B:134:0x0104, B:135:0x010b, B:136:0x00e4, B:141:0x0313, B:139:0x0099, B:19:0x0091), top: B:12:0x006b, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x023b A[Catch: JSONException -> 0x031d, TryCatch #1 {JSONException -> 0x031d, blocks: (B:13:0x006b, B:15:0x0085, B:16:0x008b, B:24:0x02f4, B:25:0x00bd, B:28:0x00cc, B:32:0x00dd, B:33:0x00e8, B:35:0x00f7, B:36:0x010e, B:38:0x0114, B:43:0x0144, B:45:0x016f, B:47:0x0175, B:48:0x017b, B:50:0x0181, B:51:0x0187, B:53:0x018d, B:54:0x0193, B:56:0x019c, B:57:0x01a2, B:59:0x01aa, B:60:0x01b0, B:62:0x01b8, B:63:0x01be, B:65:0x01c4, B:66:0x01ca, B:68:0x01d2, B:69:0x01d8, B:71:0x01e0, B:72:0x01ef, B:74:0x01f7, B:76:0x0210, B:78:0x0216, B:79:0x021c, B:81:0x0224, B:82:0x0233, B:84:0x023b, B:85:0x0243, B:87:0x024b, B:88:0x0253, B:90:0x025c, B:91:0x0267, B:93:0x026f, B:94:0x027a, B:96:0x0282, B:97:0x028d, B:99:0x0295, B:100:0x02a0, B:102:0x02a8, B:103:0x02b3, B:105:0x02bb, B:106:0x02c6, B:108:0x02cf, B:109:0x02db, B:111:0x02e3, B:113:0x02f1, B:115:0x02ee, B:116:0x02d9, B:117:0x02c4, B:118:0x02b1, B:119:0x029e, B:120:0x028b, B:121:0x0278, B:122:0x0265, B:125:0x013d, B:126:0x012b, B:127:0x0149, B:129:0x0157, B:131:0x015d, B:132:0x00fe, B:134:0x0104, B:135:0x010b, B:136:0x00e4, B:141:0x0313, B:139:0x0099, B:19:0x0091), top: B:12:0x006b, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x024b A[Catch: JSONException -> 0x031d, TryCatch #1 {JSONException -> 0x031d, blocks: (B:13:0x006b, B:15:0x0085, B:16:0x008b, B:24:0x02f4, B:25:0x00bd, B:28:0x00cc, B:32:0x00dd, B:33:0x00e8, B:35:0x00f7, B:36:0x010e, B:38:0x0114, B:43:0x0144, B:45:0x016f, B:47:0x0175, B:48:0x017b, B:50:0x0181, B:51:0x0187, B:53:0x018d, B:54:0x0193, B:56:0x019c, B:57:0x01a2, B:59:0x01aa, B:60:0x01b0, B:62:0x01b8, B:63:0x01be, B:65:0x01c4, B:66:0x01ca, B:68:0x01d2, B:69:0x01d8, B:71:0x01e0, B:72:0x01ef, B:74:0x01f7, B:76:0x0210, B:78:0x0216, B:79:0x021c, B:81:0x0224, B:82:0x0233, B:84:0x023b, B:85:0x0243, B:87:0x024b, B:88:0x0253, B:90:0x025c, B:91:0x0267, B:93:0x026f, B:94:0x027a, B:96:0x0282, B:97:0x028d, B:99:0x0295, B:100:0x02a0, B:102:0x02a8, B:103:0x02b3, B:105:0x02bb, B:106:0x02c6, B:108:0x02cf, B:109:0x02db, B:111:0x02e3, B:113:0x02f1, B:115:0x02ee, B:116:0x02d9, B:117:0x02c4, B:118:0x02b1, B:119:0x029e, B:120:0x028b, B:121:0x0278, B:122:0x0265, B:125:0x013d, B:126:0x012b, B:127:0x0149, B:129:0x0157, B:131:0x015d, B:132:0x00fe, B:134:0x0104, B:135:0x010b, B:136:0x00e4, B:141:0x0313, B:139:0x0099, B:19:0x0091), top: B:12:0x006b, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x025c A[Catch: JSONException -> 0x031d, TryCatch #1 {JSONException -> 0x031d, blocks: (B:13:0x006b, B:15:0x0085, B:16:0x008b, B:24:0x02f4, B:25:0x00bd, B:28:0x00cc, B:32:0x00dd, B:33:0x00e8, B:35:0x00f7, B:36:0x010e, B:38:0x0114, B:43:0x0144, B:45:0x016f, B:47:0x0175, B:48:0x017b, B:50:0x0181, B:51:0x0187, B:53:0x018d, B:54:0x0193, B:56:0x019c, B:57:0x01a2, B:59:0x01aa, B:60:0x01b0, B:62:0x01b8, B:63:0x01be, B:65:0x01c4, B:66:0x01ca, B:68:0x01d2, B:69:0x01d8, B:71:0x01e0, B:72:0x01ef, B:74:0x01f7, B:76:0x0210, B:78:0x0216, B:79:0x021c, B:81:0x0224, B:82:0x0233, B:84:0x023b, B:85:0x0243, B:87:0x024b, B:88:0x0253, B:90:0x025c, B:91:0x0267, B:93:0x026f, B:94:0x027a, B:96:0x0282, B:97:0x028d, B:99:0x0295, B:100:0x02a0, B:102:0x02a8, B:103:0x02b3, B:105:0x02bb, B:106:0x02c6, B:108:0x02cf, B:109:0x02db, B:111:0x02e3, B:113:0x02f1, B:115:0x02ee, B:116:0x02d9, B:117:0x02c4, B:118:0x02b1, B:119:0x029e, B:120:0x028b, B:121:0x0278, B:122:0x0265, B:125:0x013d, B:126:0x012b, B:127:0x0149, B:129:0x0157, B:131:0x015d, B:132:0x00fe, B:134:0x0104, B:135:0x010b, B:136:0x00e4, B:141:0x0313, B:139:0x0099, B:19:0x0091), top: B:12:0x006b, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x026f A[Catch: JSONException -> 0x031d, TryCatch #1 {JSONException -> 0x031d, blocks: (B:13:0x006b, B:15:0x0085, B:16:0x008b, B:24:0x02f4, B:25:0x00bd, B:28:0x00cc, B:32:0x00dd, B:33:0x00e8, B:35:0x00f7, B:36:0x010e, B:38:0x0114, B:43:0x0144, B:45:0x016f, B:47:0x0175, B:48:0x017b, B:50:0x0181, B:51:0x0187, B:53:0x018d, B:54:0x0193, B:56:0x019c, B:57:0x01a2, B:59:0x01aa, B:60:0x01b0, B:62:0x01b8, B:63:0x01be, B:65:0x01c4, B:66:0x01ca, B:68:0x01d2, B:69:0x01d8, B:71:0x01e0, B:72:0x01ef, B:74:0x01f7, B:76:0x0210, B:78:0x0216, B:79:0x021c, B:81:0x0224, B:82:0x0233, B:84:0x023b, B:85:0x0243, B:87:0x024b, B:88:0x0253, B:90:0x025c, B:91:0x0267, B:93:0x026f, B:94:0x027a, B:96:0x0282, B:97:0x028d, B:99:0x0295, B:100:0x02a0, B:102:0x02a8, B:103:0x02b3, B:105:0x02bb, B:106:0x02c6, B:108:0x02cf, B:109:0x02db, B:111:0x02e3, B:113:0x02f1, B:115:0x02ee, B:116:0x02d9, B:117:0x02c4, B:118:0x02b1, B:119:0x029e, B:120:0x028b, B:121:0x0278, B:122:0x0265, B:125:0x013d, B:126:0x012b, B:127:0x0149, B:129:0x0157, B:131:0x015d, B:132:0x00fe, B:134:0x0104, B:135:0x010b, B:136:0x00e4, B:141:0x0313, B:139:0x0099, B:19:0x0091), top: B:12:0x006b, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0282 A[Catch: JSONException -> 0x031d, TryCatch #1 {JSONException -> 0x031d, blocks: (B:13:0x006b, B:15:0x0085, B:16:0x008b, B:24:0x02f4, B:25:0x00bd, B:28:0x00cc, B:32:0x00dd, B:33:0x00e8, B:35:0x00f7, B:36:0x010e, B:38:0x0114, B:43:0x0144, B:45:0x016f, B:47:0x0175, B:48:0x017b, B:50:0x0181, B:51:0x0187, B:53:0x018d, B:54:0x0193, B:56:0x019c, B:57:0x01a2, B:59:0x01aa, B:60:0x01b0, B:62:0x01b8, B:63:0x01be, B:65:0x01c4, B:66:0x01ca, B:68:0x01d2, B:69:0x01d8, B:71:0x01e0, B:72:0x01ef, B:74:0x01f7, B:76:0x0210, B:78:0x0216, B:79:0x021c, B:81:0x0224, B:82:0x0233, B:84:0x023b, B:85:0x0243, B:87:0x024b, B:88:0x0253, B:90:0x025c, B:91:0x0267, B:93:0x026f, B:94:0x027a, B:96:0x0282, B:97:0x028d, B:99:0x0295, B:100:0x02a0, B:102:0x02a8, B:103:0x02b3, B:105:0x02bb, B:106:0x02c6, B:108:0x02cf, B:109:0x02db, B:111:0x02e3, B:113:0x02f1, B:115:0x02ee, B:116:0x02d9, B:117:0x02c4, B:118:0x02b1, B:119:0x029e, B:120:0x028b, B:121:0x0278, B:122:0x0265, B:125:0x013d, B:126:0x012b, B:127:0x0149, B:129:0x0157, B:131:0x015d, B:132:0x00fe, B:134:0x0104, B:135:0x010b, B:136:0x00e4, B:141:0x0313, B:139:0x0099, B:19:0x0091), top: B:12:0x006b, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0295 A[Catch: JSONException -> 0x031d, TryCatch #1 {JSONException -> 0x031d, blocks: (B:13:0x006b, B:15:0x0085, B:16:0x008b, B:24:0x02f4, B:25:0x00bd, B:28:0x00cc, B:32:0x00dd, B:33:0x00e8, B:35:0x00f7, B:36:0x010e, B:38:0x0114, B:43:0x0144, B:45:0x016f, B:47:0x0175, B:48:0x017b, B:50:0x0181, B:51:0x0187, B:53:0x018d, B:54:0x0193, B:56:0x019c, B:57:0x01a2, B:59:0x01aa, B:60:0x01b0, B:62:0x01b8, B:63:0x01be, B:65:0x01c4, B:66:0x01ca, B:68:0x01d2, B:69:0x01d8, B:71:0x01e0, B:72:0x01ef, B:74:0x01f7, B:76:0x0210, B:78:0x0216, B:79:0x021c, B:81:0x0224, B:82:0x0233, B:84:0x023b, B:85:0x0243, B:87:0x024b, B:88:0x0253, B:90:0x025c, B:91:0x0267, B:93:0x026f, B:94:0x027a, B:96:0x0282, B:97:0x028d, B:99:0x0295, B:100:0x02a0, B:102:0x02a8, B:103:0x02b3, B:105:0x02bb, B:106:0x02c6, B:108:0x02cf, B:109:0x02db, B:111:0x02e3, B:113:0x02f1, B:115:0x02ee, B:116:0x02d9, B:117:0x02c4, B:118:0x02b1, B:119:0x029e, B:120:0x028b, B:121:0x0278, B:122:0x0265, B:125:0x013d, B:126:0x012b, B:127:0x0149, B:129:0x0157, B:131:0x015d, B:132:0x00fe, B:134:0x0104, B:135:0x010b, B:136:0x00e4, B:141:0x0313, B:139:0x0099, B:19:0x0091), top: B:12:0x006b, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean d(int r32, int r33) {
        /*
            Method dump skipped, instructions count: 799
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.platform.comapi.map.MapController.d(int, int):boolean");
    }

    public void a(int i, int i2) {
        if (a()) {
            this.x.MoveToScrPoint(i, i2);
        }
    }

    private void a(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        D = x;
        E = y;
        MapMsgProc(4, 0, x | (y << 16));
        F = true;
        this.ae = motionEvent.getDownTime();
    }

    public void saveScreenToLocal(String str) {
        saveScreenToLocal(str, 0, 0, 0, 0);
    }

    private boolean a(int i, int i2, boolean z) {
        SoftReference<MapViewInterface> softReference = this.i;
        if (softReference != null && softReference.get() != null) {
            int zoomUnitsInMeter = (int) (this.nearlyRadius * getZoomUnitsInMeter());
            MapViewInterface mapViewInterface = this.i.get();
            for (int size = mapViewInterface.getBmlayers().size() - 1; size >= 0; size--) {
                if (mapViewInterface.getBmlayers().get(size).a(i, i2, zoomUnitsInMeter, z, this.ac)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0063, code lost:
    
        r7 = (org.json.JSONObject) new org.json.JSONObject(r8).getJSONArray("dataset").get(0);
        r8 = r7.getInt("itemindex");
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x007a, code lost:
    
        r2 = r7.optInt("clickindex", -1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0080, code lost:
    
        r6 = r5;
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0096, code lost:
    
        r13 = r5;
        r10 = r8;
        r11 = -1;
     */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00c8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean a(int r18, int r19, int r20) {
        /*
            r17 = this;
            r0 = r17
            boolean r1 = r17.a()
            r2 = 0
            if (r1 != 0) goto La
            return r2
        La:
            java.lang.ref.SoftReference<com.baidu.platform.comapi.map.MapViewInterface> r1 = r0.i
            if (r1 == 0) goto Lcf
            java.lang.Object r1 = r1.get()
            if (r1 != 0) goto L16
            goto Lcf
        L16:
            java.lang.ref.SoftReference<com.baidu.platform.comapi.map.MapViewInterface> r1 = r0.i
            java.lang.Object r1 = r1.get()
            com.baidu.platform.comapi.map.MapViewInterface r1 = (com.baidu.platform.comapi.map.MapViewInterface) r1
            r3 = 1
            r4 = -1
            r5 = 0
            java.util.List r7 = r1.getOverlays()     // Catch: org.json.JSONException -> L85
            int r7 = r7.size()     // Catch: org.json.JSONException -> L85
            int r7 = r7 - r3
        L2b:
            if (r7 < 0) goto L8b
            java.util.List r8 = r1.getOverlays()     // Catch: org.json.JSONException -> L85
            java.lang.Object r8 = r8.get(r7)     // Catch: org.json.JSONException -> L85
            com.baidu.platform.comapi.map.Overlay r8 = (com.baidu.platform.comapi.map.Overlay) r8     // Catch: org.json.JSONException -> L85
            int r9 = r8.mType     // Catch: org.json.JSONException -> L85
            r10 = 27
            if (r9 == r10) goto L3e
            goto L88
        L3e:
            long r5 = r8.mLayerID     // Catch: org.json.JSONException -> L85
            int r8 = r0.nearlyRadius     // Catch: org.json.JSONException -> L85
            double r8 = (double) r8     // Catch: org.json.JSONException -> L85
            double r10 = r17.getZoomUnitsInMeter()     // Catch: org.json.JSONException -> L85
            double r8 = r8 * r10
            int r8 = (int) r8     // Catch: org.json.JSONException -> L85
            com.baidu.platform.comjni.map.basemap.AppBaseMap r11 = r0.x     // Catch: org.json.JSONException -> L85
            if (r11 == 0) goto L88
            r12 = r5
            r14 = r19
            r15 = r20
            r16 = r8
            java.lang.String r8 = r11.GetNearlyObjID(r12, r14, r15, r16)     // Catch: org.json.JSONException -> L85
            if (r8 == 0) goto L88
            java.lang.String r9 = ""
            boolean r9 = r8.equals(r9)     // Catch: org.json.JSONException -> L85
            if (r9 != 0) goto L88
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch: org.json.JSONException -> L85
            r7.<init>(r8)     // Catch: org.json.JSONException -> L85
            java.lang.String r8 = "dataset"
            org.json.JSONArray r7 = r7.getJSONArray(r8)     // Catch: org.json.JSONException -> L85
            java.lang.Object r7 = r7.get(r2)     // Catch: org.json.JSONException -> L85
            org.json.JSONObject r7 = (org.json.JSONObject) r7     // Catch: org.json.JSONException -> L85
            java.lang.String r8 = "itemindex"
            int r8 = r7.getInt(r8)     // Catch: org.json.JSONException -> L85
            java.lang.String r9 = "clickindex"
            int r2 = r7.optInt(r9, r4)     // Catch: org.json.JSONException -> L83
            r6 = r5
            r5 = 1
            goto L8f
        L83:
            goto L96
        L85:
            r8 = -1
            goto L96
        L88:
            int r7 = r7 + (-1)
            goto L2b
        L8b:
            r6 = r5
            r2 = -1
            r5 = 0
            r8 = -1
        L8f:
            r11 = r2
            r2 = r5
            r13 = r6
            r10 = r8
        L93:
            r5 = r18
            goto L9a
        L96:
            r13 = r5
            r10 = r8
            r11 = -1
            goto L93
        L9a:
            if (r5 != r3) goto Lcf
            com.baidu.platform.comapi.map.MapViewListener r3 = r17.getMapViewListener()
            if (r3 == 0) goto Lcf
            com.baidu.platform.comapi.map.MapViewInterface r3 = r17.getMapView()
            if (r3 == 0) goto Lcf
            com.baidu.platform.comapi.map.MapViewInterface r3 = r17.getMapView()
            com.baidu.platform.comapi.map.Projection r3 = r3.getProjection()
            if (r3 == 0) goto Lcf
            com.baidu.platform.comapi.map.Projection r1 = r1.getProjection()
            r3 = r19
            r5 = r20
            com.baidu.platform.comapi.basestruct.GeoPoint r12 = r1.fromPixels(r3, r5)
            if (r11 == r4) goto Lc8
            com.baidu.platform.comapi.map.MapViewListener r9 = r17.getMapViewListener()
            r9.onClickedItem(r10, r11, r12, r13)
            goto Lcf
        Lc8:
            com.baidu.platform.comapi.map.MapViewListener r1 = r17.getMapViewListener()
            r1.onClickedItem(r10, r12, r13)
        Lcf:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.platform.comapi.map.MapController.a(int, int, int):boolean");
    }

    public void setMapStatus(Bundle bundle) {
        if (a()) {
            this.x.SetMapStatus(bundle);
        }
    }

    public void setMapStatus(MapStatus mapStatus) {
        if (!a() || mapStatus == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putDouble("level", mapStatus.level);
        bundle.putDouble("rotation", mapStatus.rotation);
        bundle.putDouble("overlooking", mapStatus.overlooking);
        bundle.putDouble("centerptx", mapStatus.centerPtX);
        bundle.putDouble("centerpty", mapStatus.centerPtY);
        bundle.putDouble("centerptz", mapStatus.centerPtZ);
        bundle.putInt("left", mapStatus.winRound.left);
        bundle.putInt("right", mapStatus.winRound.right);
        bundle.putInt("top", mapStatus.winRound.top);
        bundle.putInt("bottom", mapStatus.winRound.bottom);
        bundle.putLong("gleft", mapStatus.geoRound.left);
        bundle.putLong("gbottom", mapStatus.geoRound.bottom);
        bundle.putLong("gtop", mapStatus.geoRound.top);
        bundle.putLong("gright", mapStatus.geoRound.right);
        bundle.putFloat("yoffset", mapStatus.yOffset);
        bundle.putFloat("xoffset", mapStatus.xOffset);
        bundle.putInt("animatime", mapStatus.animationTime);
        bundle.putInt("animation", mapStatus.hasAnimation);
        bundle.putInt("animationType", mapStatus.animationType);
        bundle.putInt("bfpp", mapStatus.bfpp ? 1 : 0);
        bundle.putString("panoid", mapStatus.panoId);
        bundle.putInt("autolink", 0);
        bundle.putFloat("siangle", mapStatus.streetIndicateAngle);
        bundle.putInt("isbirdeye", mapStatus.isBirdEye ? 1 : 0);
        bundle.putInt("ssext", mapStatus.streetExt);
        bundle.putFloat("roadOffsetX", mapStatus.roadOffsetX);
        bundle.putFloat("roadOffsetY", mapStatus.roadOffsetY);
        mapStatusChangeStart();
        this.x.SetMapStatus(bundle);
    }

    public void setMapStatusWithAnimation(MapStatus mapStatus, int i) {
        if (!a() || this.x == null || mapStatus == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putDouble("level", mapStatus.level);
        bundle.putDouble("rotation", mapStatus.rotation);
        bundle.putDouble("overlooking", mapStatus.overlooking);
        bundle.putDouble("centerptx", mapStatus.centerPtX);
        bundle.putDouble("centerpty", mapStatus.centerPtY);
        bundle.putDouble("centerptz", mapStatus.centerPtZ);
        bundle.putInt("left", mapStatus.winRound.left);
        bundle.putInt("right", mapStatus.winRound.right);
        bundle.putInt("top", mapStatus.winRound.top);
        bundle.putInt("bottom", mapStatus.winRound.bottom);
        bundle.putLong("gleft", mapStatus.geoRound.left);
        bundle.putLong("gright", mapStatus.geoRound.right);
        bundle.putLong("gbottom", mapStatus.geoRound.bottom);
        bundle.putLong("gtop", mapStatus.geoRound.top);
        bundle.putFloat("xoffset", mapStatus.xOffset);
        bundle.putFloat("yoffset", mapStatus.yOffset);
        bundle.putInt("animation", 1);
        bundle.putInt("animatime", i);
        bundle.putInt("bfpp", mapStatus.bfpp ? 1 : 0);
        bundle.putString("panoid", mapStatus.panoId);
        bundle.putInt("autolink", 0);
        bundle.putFloat("siangle", mapStatus.streetIndicateAngle);
        bundle.putInt("isbirdeye", mapStatus.isBirdEye ? 1 : 0);
        bundle.putInt("ssext", mapStatus.streetExt);
        bundle.putFloat("roadOffsetX", mapStatus.roadOffsetX);
        bundle.putFloat("roadOffsetY", mapStatus.roadOffsetY);
        mapStatusChangeStart();
        this.mIsAnimating = true;
        this.x.SetMapStatus(bundle);
    }

    private void c() {
        MessageProxy.registerMessageHandler(4000, this.z);
        MessageProxy.registerMessageHandler(519, this.z);
        MessageProxy.registerMessageHandler(39, this.z);
        MessageProxy.registerMessageHandler(512, this.z);
        MessageProxy.registerMessageHandler(65297, this.z);
        MessageProxy.registerMessageHandler(UIMsg.MsgDefine.V_WM_VSTREETCLICKBACKGROUND, this.z);
        MessageProxy.registerMessageHandler(50, this.z);
        MessageProxy.registerMessageHandler(51, this.z);
        MessageProxy.registerMessageHandler(65301, this.z);
        MessageProxy.registerMessageHandler(41, this.z);
        MessageProxy.registerMessageHandler(UIMsg.MsgDefine.MSG_MAP_DATA_NET_RESPONSE, this.z);
        MessageProxy.registerMessageHandler(UIMsg.MsgDefine.V_WM_PRISM_FLOOR_ANIMATE_STOP, this.z);
    }

    private MapStatus a(boolean z) {
        if (!a()) {
            return new MapStatus();
        }
        Bundle GetMapStatus = this.x.GetMapStatus(z);
        if (GetMapStatus == null) {
            return new MapStatus();
        }
        MapStatus mapStatus = new MapStatus();
        mapStatus.level = (float) GetMapStatus.getDouble("level");
        mapStatus.rotation = (int) GetMapStatus.getDouble("rotation");
        mapStatus.overlooking = (int) GetMapStatus.getDouble("overlooking");
        mapStatus.centerPtX = GetMapStatus.getDouble("centerptx");
        mapStatus.centerPtY = GetMapStatus.getDouble("centerpty");
        mapStatus.centerPtZ = GetMapStatus.getDouble("centerptz");
        mapStatus.winRound.left = GetMapStatus.getInt("left");
        mapStatus.winRound.right = GetMapStatus.getInt("right");
        mapStatus.winRound.top = GetMapStatus.getInt("top");
        mapStatus.winRound.bottom = GetMapStatus.getInt("bottom");
        mapStatus.geoRound.left = GetMapStatus.getLong("gleft");
        mapStatus.geoRound.right = GetMapStatus.getLong("gright");
        mapStatus.geoRound.top = GetMapStatus.getLong("gtop");
        mapStatus.geoRound.bottom = GetMapStatus.getLong("gbottom");
        mapStatus.xOffset = GetMapStatus.getFloat("xoffset");
        mapStatus.yOffset = GetMapStatus.getFloat("yoffset");
        mapStatus.bfpp = GetMapStatus.getInt("bfpp") == 1;
        mapStatus.panoId = GetMapStatus.getString("panoid");
        mapStatus.streetIndicateAngle = GetMapStatus.getFloat("siangle");
        mapStatus.isBirdEye = GetMapStatus.getInt("isbirdeye") == 1;
        mapStatus.streetExt = GetMapStatus.getInt("ssext");
        mapStatus.roadOffsetX = GetMapStatus.getFloat("roadOffsetX");
        mapStatus.roadOffsetY = GetMapStatus.getFloat("roadOffsetY");
        mapStatus.bOverlookSpringback = GetMapStatus.getInt("boverlookback") == 1;
        mapStatus.minOverlooking = (int) GetMapStatus.getFloat("minoverlook");
        mapStatus.xScreenOffset = GetMapStatus.getFloat("xScreenOffset");
        mapStatus.yScreenOffset = GetMapStatus.getFloat("yScreenOffset");
        MapStatus.GeoBound geoBound = mapStatus.geoRound;
        if (geoBound.left <= -20037508) {
            geoBound.left = -20037508L;
        }
        if (geoBound.right >= 20037508) {
            geoBound.right = 20037508L;
        }
        if (geoBound.top >= 20037508) {
            geoBound.top = 20037508L;
        }
        if (geoBound.bottom <= -20037508) {
            geoBound.bottom = -20037508L;
        }
        return mapStatus;
    }

    public void setMapStatusWithAnimation(MapStatus mapStatus, int i, int i2) {
        if (!a() || this.x == null || mapStatus == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("animationType", i);
        bundle.putInt("animatime", i2);
        bundle.putInt("left", mapStatus.winRound.left);
        bundle.putInt("right", mapStatus.winRound.right);
        bundle.putInt("top", mapStatus.winRound.top);
        bundle.putInt("bottom", mapStatus.winRound.bottom);
        if (i != 4) {
            bundle.putDouble("level", mapStatus.level);
            bundle.putDouble("rotation", mapStatus.rotation);
            bundle.putDouble("overlooking", mapStatus.overlooking);
            bundle.putDouble("centerptx", mapStatus.centerPtX);
            bundle.putDouble("centerpty", mapStatus.centerPtY);
            bundle.putDouble("centerptz", mapStatus.centerPtZ);
            bundle.putLong("gleft", mapStatus.geoRound.left);
            bundle.putLong("gright", mapStatus.geoRound.right);
            bundle.putLong("gbottom", mapStatus.geoRound.bottom);
            bundle.putLong("gtop", mapStatus.geoRound.top);
            bundle.putFloat("xoffset", mapStatus.xOffset);
            bundle.putFloat("yoffset", mapStatus.yOffset);
            bundle.putInt("bfpp", mapStatus.bfpp ? 1 : 0);
            bundle.putString("panoid", mapStatus.panoId);
            bundle.putInt("autolink", 0);
            bundle.putFloat("siangle", mapStatus.streetIndicateAngle);
            bundle.putInt("isbirdeye", mapStatus.isBirdEye ? 1 : 0);
            bundle.putInt("ssext", mapStatus.streetExt);
            bundle.putFloat("roadOffsetX", mapStatus.roadOffsetX);
            bundle.putFloat("roadOffsetY", mapStatus.roadOffsetY);
        }
        this.x.SetNewMapStatus(bundle);
    }

    private void d() {
        MessageProxy.unRegisterMessageHandler(4000, this.z);
        MessageProxy.unRegisterMessageHandler(519, this.z);
        MessageProxy.unRegisterMessageHandler(39, this.z);
        MessageProxy.unRegisterMessageHandler(512, this.z);
        MessageProxy.unRegisterMessageHandler(65297, this.z);
        MessageProxy.unRegisterMessageHandler(UIMsg.MsgDefine.V_WM_VSTREETCLICKBACKGROUND, this.z);
        MessageProxy.unRegisterMessageHandler(50, this.z);
        MessageProxy.unRegisterMessageHandler(51, this.z);
        MessageProxy.unRegisterMessageHandler(65301, this.z);
        MessageProxy.unRegisterMessageHandler(41, this.z);
        MessageProxy.unRegisterMessageHandler(UIMsg.MsgDefine.MSG_MAP_DATA_NET_RESPONSE, this.z);
        MessageProxy.unRegisterMessageHandler(UIMsg.MsgDefine.V_WM_PRISM_FLOOR_ANIMATE_STOP, this.z);
    }

    private void b() {
        this.M = false;
        this.S = 0.0f;
        this.Q = -1.0f;
        this.R = -1.0f;
    }
}
