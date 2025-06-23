package com.baidu.mapapi.map;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.mapapi.OpenLogUtil;
import com.baidu.mapapi.PermissionUtils;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.mapapi.map.InfoWindow;
import com.baidu.mapapi.map.MapBaseIndoorMapInfo;
import com.baidu.mapapi.map.MapViewLayoutParams;
import com.baidu.mapapi.map.MyLocationConfiguration;
import com.baidu.mapapi.map.Overlay;
import com.baidu.mapapi.map.track.TraceAnimationListener;
import com.baidu.mapapi.map.track.TraceOptions;
import com.baidu.mapapi.map.track.TraceOverlay;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.bmsdk.BmDrawItem;
import com.baidu.platform.comapi.bmsdk.BmGeoElement;
import com.baidu.platform.comapi.bmsdk.BmLayer;
import com.baidu.platform.comapi.bmsdk.BmPolygon;
import com.baidu.platform.comapi.logstatistics.SDKLogFactory;
import com.baidu.platform.comapi.map.MapSurfaceView;
import com.baidu.platform.comapi.map.MapTextureView;
import com.baidu.platform.comapi.map.OverlayLocationData;
import com.sma.smartv3.util.xoIox;
import com.vtrump.vtble.Oxx0IOOO;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: classes7.dex */
public class BaiduMap {
    public static final int MAP_TYPE_NONE = 3;
    public static final int MAP_TYPE_NORMAL = 1;
    public static final int MAP_TYPE_SATELLITE = 2;
    public static final float REAL_MAX_ZOOM_LEVEL = 22.0f;
    public static final float REAL_MIN_ZOOM_LEVEL = 4.0f;
    private static volatile boolean aj = false;
    private static volatile boolean ak = false;
    private static final String e = "BaiduMap";
    public static int mapStatusReason = 256;
    private OnMarkerDragListener I;
    private OnMyLocationClickListener J;
    private SnapshotReadyCallback K;
    private Building3DListener L;
    private CopyOnWriteArrayList<Building> M;
    private OnMapDrawFrameCallback N;
    private OnBaseIndoorMapListener O;
    private OnMapRenderValidDataListener P;
    private OnHeatMapDrawFrameCallBack Q;
    private OnSynchronizationListener R;
    private TileOverlay S;
    private HeatMap T;
    private Map<String, InfoWindow> W;
    private Map<InfoWindow, Marker> X;
    private Marker Y;
    private MyLocationData Z;

    /* renamed from: a, reason: collision with root package name */
    MapView f5790a;
    private MyLocationConfiguration aa;
    private OnLocationModeChangeListener ab;
    private boolean ac;
    private boolean ad;
    private boolean ae;
    private boolean af;
    private Point ag;
    private com.baidu.mapsdkplatform.comapi.map.a.c al;
    TextureMapView b;
    WearMapView c;
    com.baidu.mapsdkplatform.comapi.map.v d;
    private Projection f;
    private UiSettings g;
    private MapSurfaceView h;
    private MapTextureView i;
    private com.baidu.mapsdkplatform.comapi.map.c j;
    private List<Overlay> l;
    private List<Marker> m;
    private List<Marker> n;
    private List<InfoWindow> o;
    private Overlay.a p;
    private InfoWindow.a q;
    private InfoWindowAdapter r;
    private OnMapStatusChangeListener s;
    private OnMapTouchListener t;
    private onMapGestureListener u;
    private OnMapClickListener v;
    private OnMapLoadedCallback w;
    private OnMapRenderCallback x;
    private OnMapDoubleClickListener y;
    private OnMapLongClickListener z;
    private CopyOnWriteArrayList<OnMarkerClickListener> A = new CopyOnWriteArrayList<>();
    private CopyOnWriteArrayList<OnPolylineClickListener> B = new CopyOnWriteArrayList<>();
    private CopyOnWriteArrayList<OnMultiPointClickListener> C = new CopyOnWriteArrayList<>();
    private CopyOnWriteArrayList<OnCircleClickListener> D = new CopyOnWriteArrayList<>();
    private CopyOnWriteArrayList<OnPolygonClickListener> E = new CopyOnWriteArrayList<>();
    private CopyOnWriteArrayList<OnGroundOverlayClickListener> F = new CopyOnWriteArrayList<>();
    private CopyOnWriteArrayList<OnTextClickListener> G = new CopyOnWriteArrayList<>();
    private CopyOnWriteArrayList<OnArcClickListener> H = new CopyOnWriteArrayList<>();
    private Lock U = new ReentrantLock();
    private Lock V = new ReentrantLock();
    private volatile boolean ah = false;
    private boolean ai = false;
    private BmLayer k = new BmLayer();

    /* loaded from: classes7.dex */
    public interface OnArcClickListener {
        boolean onArcClick(Arc arc);
    }

    /* loaded from: classes7.dex */
    public interface OnBaseIndoorMapListener {
        void onBaseIndoorMapMode(boolean z, MapBaseIndoorMapInfo mapBaseIndoorMapInfo);
    }

    /* loaded from: classes7.dex */
    public interface OnCircleClickListener {
        boolean onCircleClick(Circle circle);
    }

    /* loaded from: classes7.dex */
    public interface OnGroundOverlayClickListener {
        boolean onGroundOverlayClick(GroundOverlay groundOverlay);
    }

    /* loaded from: classes7.dex */
    public interface OnHeatMapDrawFrameCallBack {
        void frameIndex(int i);
    }

    /* loaded from: classes7.dex */
    public interface OnLocationModeChangeListener {
        void onLocationModeChange(MyLocationConfiguration.LocationMode locationMode);
    }

    /* loaded from: classes7.dex */
    public interface OnMapClickListener {
        void onMapClick(LatLng latLng);

        void onMapPoiClick(MapPoi mapPoi);
    }

    /* loaded from: classes7.dex */
    public interface OnMapDoubleClickListener {
        void onMapDoubleClick(LatLng latLng);
    }

    /* loaded from: classes7.dex */
    public interface OnMapDrawFrameCallback {
        void onMapDrawFrame(MapStatus mapStatus);

        @Deprecated
        void onMapDrawFrame(GL10 gl10, MapStatus mapStatus);
    }

    /* loaded from: classes7.dex */
    public interface OnMapLoadedCallback {
        void onMapLoaded();
    }

    /* loaded from: classes7.dex */
    public interface OnMapLongClickListener {
        void onMapLongClick(LatLng latLng);
    }

    /* loaded from: classes7.dex */
    public interface OnMapRenderCallback {
        void onMapRenderFinished();
    }

    /* loaded from: classes7.dex */
    public interface OnMapRenderValidDataListener {
        void onMapRenderValidData(boolean z, int i, String str);
    }

    /* loaded from: classes7.dex */
    public interface OnMapStatusChangeListener {
        public static final int REASON_API_ANIMATION = 2;
        public static final int REASON_DEVELOPER_ANIMATION = 3;
        public static final int REASON_GESTURE = 1;

        void onMapStatusChange(MapStatus mapStatus);

        void onMapStatusChangeFinish(MapStatus mapStatus);

        void onMapStatusChangeStart(MapStatus mapStatus);

        void onMapStatusChangeStart(MapStatus mapStatus, int i);
    }

    /* loaded from: classes7.dex */
    public interface OnMapTouchListener {
        void onTouch(MotionEvent motionEvent);
    }

    /* loaded from: classes7.dex */
    public interface OnMarkerClickListener {
        boolean onMarkerClick(Marker marker);
    }

    /* loaded from: classes7.dex */
    public interface OnMarkerDragListener {
        void onMarkerDrag(Marker marker);

        void onMarkerDragEnd(Marker marker);

        void onMarkerDragStart(Marker marker);
    }

    /* loaded from: classes7.dex */
    public interface OnMultiPointClickListener {
        boolean onMultiPointClick(MultiPoint multiPoint, MultiPointItem multiPointItem);
    }

    /* loaded from: classes7.dex */
    public interface OnMyLocationClickListener {
        boolean onMyLocationClick();
    }

    /* loaded from: classes7.dex */
    public interface OnPolygonClickListener {
        boolean onPolygonClick(Polygon polygon);
    }

    /* loaded from: classes7.dex */
    public interface OnPolylineClickListener {
        boolean onPolylineClick(Polyline polyline);
    }

    /* loaded from: classes7.dex */
    public interface OnSynchronizationListener {
        void onMapStatusChangeReason(int i);
    }

    /* loaded from: classes7.dex */
    public interface OnTextClickListener {
        boolean onTextClick(Text text);
    }

    /* loaded from: classes7.dex */
    public interface SnapshotReadyCallback {
        void onSnapshotReady(Bitmap bitmap);
    }

    /* loaded from: classes7.dex */
    public interface onMapGestureListener {
        boolean onMapDoubleTouch(Point point, MapStatus mapStatus);

        boolean onMapFling(MotionEvent motionEvent, float f, float f2, MapStatus mapStatus);

        boolean onMapKneading(Point point, Point point2, MapStatus mapStatus);

        boolean onMapOverLooking(Point point, Point point2, MapStatus mapStatus);

        boolean onMapScroll(Point point, Point point2, MapStatus mapStatus);

        void onMapStatusChangeFinish(MapStatus mapStatus);

        boolean onMapTwoClick(Point point, Point point2, MapStatus mapStatus);
    }

    public BaiduMap(Context context, MapTextureView mapTextureView, com.baidu.mapsdkplatform.comapi.map.u uVar) {
        this.i = mapTextureView;
        com.baidu.mapsdkplatform.comapi.map.c cVar = new com.baidu.mapsdkplatform.comapi.map.c(context, mapTextureView, uVar, (String) null, 0);
        this.j = cVar;
        mapTextureView.setBaseMap(cVar);
        if (OverlayUtil.isOverlayUpgrade()) {
            this.i.addBmLayer(this.k);
            this.j.a(this.k);
        }
        this.d = com.baidu.mapsdkplatform.comapi.map.v.TextureView;
        d();
    }

    public void addHeatMap(HeatMap heatMap) {
        if (heatMap != null && this.j != null) {
            this.U.lock();
            try {
                HeatMap heatMap2 = this.T;
                if (heatMap == heatMap2) {
                    this.U.unlock();
                    return;
                }
                if (heatMap2 != null) {
                    heatMap2.b();
                    this.T.c();
                    this.T.f5811a = null;
                    this.j.q();
                }
                this.T = heatMap;
                heatMap.f5811a = this;
                Bundle bundle = heatMap.toBundle();
                this.j.s(true);
                this.j.i(bundle);
                HashMap hashMap = new HashMap();
                HeatMap heatMap3 = this.T;
                if (heatMap3 != null) {
                    hashMap.put(xoIox.f24717xXxxox0I, Integer.valueOf(heatMap3.getMaxHigh()));
                    hashMap.put(Oxx0IOOO.f27277xI, Integer.valueOf(this.T.isInitAnimation() ? 1 : 0));
                    hashMap.put("F", Integer.valueOf(this.T.isFrameAnimation() ? 1 : 0));
                }
                SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel("B", xoIox.f24717xXxxox0I, "0", hashMap);
                this.U.unlock();
            } catch (Throwable th) {
                this.U.unlock();
                throw th;
            }
        }
    }

    public final Overlay addOverlay(OverlayOptions overlayOptions) {
        Overlay a2;
        if (overlayOptions == null || this.ah || (a2 = overlayOptions.a()) == null) {
            return null;
        }
        a2.listener = this.p;
        if (OverlayUtil.isOverlayUpgrade() && ((a2 instanceof Arc) || (a2 instanceof Circle) || (a2 instanceof Polygon) || (a2 instanceof Polyline))) {
            a(a2);
            this.l.add(a2);
            return a2;
        }
        if (a2 instanceof Marker) {
            Marker marker = (Marker) a2;
            marker.D = this.q;
            ArrayList<BitmapDescriptor> arrayList = marker.v;
            if (arrayList != null && arrayList.size() != 0) {
                this.m.add(marker);
                com.baidu.mapsdkplatform.comapi.map.c cVar = this.j;
                if (cVar != null) {
                    cVar.d(true);
                }
            }
            this.n.add(marker);
            InfoWindow infoWindow = marker.C;
            if (infoWindow != null) {
                showInfoWindow(infoWindow, false);
            }
            if (a2 instanceof Building) {
                this.M.add((Building) a2);
            }
        }
        Bundle bundle = new Bundle();
        a2.a(bundle);
        if (this.j != null && !this.ah) {
            this.j.d(bundle);
        }
        this.l.add(a2);
        return a2;
    }

    public final List<Overlay> addOverlays(List<OverlayOptions> list) {
        int i;
        if (list == null || this.ah) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int size = list.size();
        int i2 = size / 400;
        for (int i3 = 0; i3 < i2 + 1; i3++) {
            for (int i4 = 0; i4 < 400 && (i = (i3 * 400) + i4) < size; i4++) {
                if (this.ah) {
                    return null;
                }
                OverlayOptions overlayOptions = list.get(i);
                if (overlayOptions != null) {
                    Bundle bundle = new Bundle();
                    Overlay a2 = overlayOptions.a();
                    a2.listener = this.p;
                    if (a2 instanceof Marker) {
                        Marker marker = (Marker) a2;
                        marker.D = this.q;
                        InfoWindowAdapter infoWindowAdapter = this.r;
                        if (infoWindowAdapter != null) {
                            marker.J = infoWindowAdapter;
                        }
                        ArrayList<BitmapDescriptor> arrayList3 = marker.v;
                        if (arrayList3 != null && arrayList3.size() != 0) {
                            this.m.add(marker);
                            com.baidu.mapsdkplatform.comapi.map.c cVar = this.j;
                            if (cVar != null) {
                                cVar.d(true);
                            }
                        }
                        this.n.add(marker);
                    }
                    if (a2 instanceof Building) {
                        this.M.add((Building) a2);
                    }
                    this.l.add(a2);
                    arrayList.add(a2);
                    if (OverlayUtil.isOverlayUpgrade()) {
                        if (!(a2 instanceof Arc) && !(a2 instanceof Circle) && !(a2 instanceof Polygon) && !(a2 instanceof Polyline)) {
                            a2.a(bundle);
                            com.baidu.mapsdkplatform.comapi.map.c cVar2 = this.j;
                            if (cVar2 != null) {
                                cVar2.h(bundle);
                                this.j.e(bundle);
                            }
                            arrayList2.add(bundle);
                        } else {
                            a(a2);
                        }
                    } else {
                        a2.a(bundle);
                        com.baidu.mapsdkplatform.comapi.map.c cVar3 = this.j;
                        if (cVar3 != null) {
                            cVar3.h(bundle);
                            this.j.e(bundle);
                        }
                        arrayList2.add(bundle);
                    }
                }
            }
            if (this.j != null && !arrayList2.isEmpty()) {
                int size2 = arrayList2.size();
                Bundle[] bundleArr = new Bundle[size2];
                for (int i5 = 0; i5 < size2; i5++) {
                    bundleArr[i5] = (Bundle) arrayList2.get(i5);
                }
                this.j.a(bundleArr);
            }
        }
        return arrayList;
    }

    public TileOverlay addTileLayer(TileOverlayOptions tileOverlayOptions) {
        if (tileOverlayOptions == null) {
            return null;
        }
        TileOverlay tileOverlay = this.S;
        if (tileOverlay != null) {
            tileOverlay.b();
            this.S.f5867a = null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(ExifInterface.GPS_DIRECTION_TRUE, Integer.valueOf(tileOverlayOptions.datasource));
        SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel("B", ExifInterface.GPS_DIRECTION_TRUE, "0", hashMap);
        com.baidu.mapsdkplatform.comapi.map.c cVar = this.j;
        if (cVar == null || !cVar.a(tileOverlayOptions.a())) {
            return null;
        }
        TileOverlay a2 = tileOverlayOptions.a(this);
        this.S = a2;
        return a2;
    }

    public final TraceOverlay addTraceOverlay(TraceOptions traceOptions, TraceAnimationListener traceAnimationListener) {
        if (traceOptions == null) {
            return null;
        }
        SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel("B", "TO", "0", null);
        com.baidu.mapsdkplatform.comapi.map.a.c cVar = this.al;
        if (cVar == null || cVar.d()) {
            com.baidu.mapsdkplatform.comapi.map.v vVar = this.d;
            if (vVar == com.baidu.mapsdkplatform.comapi.map.v.GLSurfaceView) {
                this.al = new com.baidu.mapsdkplatform.comapi.map.a.c(this.h);
            } else {
                if (vVar != com.baidu.mapsdkplatform.comapi.map.v.TextureView) {
                    return null;
                }
                this.al = new com.baidu.mapsdkplatform.comapi.map.a.c(this.i);
            }
            this.al.a();
        }
        this.al.a(traceAnimationListener);
        return this.al.a(traceOptions);
    }

    public final void animateMapStatus(MapStatusUpdate mapStatusUpdate, int i) {
        if (mapStatusUpdate == null || i < 0) {
            return;
        }
        com.baidu.mapsdkplatform.comapi.map.w a2 = a(mapStatusUpdate);
        com.baidu.mapsdkplatform.comapi.map.c cVar = this.j;
        if (cVar == null) {
            return;
        }
        mapStatusReason |= 256;
        if (!this.af) {
            cVar.a(a2);
        } else {
            cVar.a(a2, i);
        }
    }

    public void changeLocationLayerOrder(boolean z) {
        com.baidu.mapsdkplatform.comapi.map.c cVar = this.j;
        if (cVar == null) {
            return;
        }
        cVar.g(z);
    }

    public void cleanCache(int i) {
        com.baidu.mapsdkplatform.comapi.map.c cVar = this.j;
        if (cVar == null) {
            return;
        }
        cVar.a(i);
    }

    public final void clear() {
        if (this.ah) {
            return;
        }
        this.l.clear();
        this.m.clear();
        this.n.clear();
        this.M.clear();
        com.baidu.mapsdkplatform.comapi.map.c cVar = this.j;
        if (cVar != null) {
            cVar.d(false);
            this.j.n();
        }
        BmLayer bmLayer = this.k;
        if (bmLayer != null) {
            bmLayer.b();
            this.k.c();
        }
        hideInfoWindow();
    }

    public void closeParticleEffectByType(ParticleEffectType particleEffectType) {
        com.baidu.mapsdkplatform.comapi.map.c cVar = this.j;
        if (cVar != null) {
            cVar.a(particleEffectType);
        }
    }

    public boolean customParticleEffectByType(ParticleEffectType particleEffectType, ParticleOptions particleOptions) {
        if (this.j == null) {
            return false;
        }
        if (particleEffectType == ParticleEffectType.Fireworks || particleEffectType == ParticleEffectType.Flower) {
            a(particleEffectType);
        }
        Bundle bundle = new Bundle();
        if (particleOptions != null) {
            if (particleOptions.getParticleImgs() != null) {
                int size = particleOptions.getParticleImgs().size();
                bundle.putInt("total", size);
                for (int i = 0; i < size; i++) {
                    if (particleOptions.getParticleImgs().get(i) != null) {
                        bundle.putBundle(String.format("texture_%d", Integer.valueOf(i)), particleOptions.getParticleImgs().get(i).b());
                    }
                }
            }
            if (particleOptions.getParticlePos() != null) {
                GeoPoint ll2mc = CoordUtil.ll2mc(particleOptions.getParticlePos());
                bundle.putDouble("location_x", ll2mc.getLongitudeE6());
                bundle.putDouble("location_y", ll2mc.getLatitudeE6());
            }
        }
        return this.j.a(particleEffectType, bundle);
    }

    public List<InfoWindow> getAllInfoWindows() {
        return this.o;
    }

    public final Point getCompassPosition() {
        com.baidu.mapsdkplatform.comapi.map.c cVar = this.j;
        if (cVar != null) {
            return a(cVar.h());
        }
        return null;
    }

    public MapBaseIndoorMapInfo getFocusedBaseIndoorMapInfo() {
        com.baidu.mapsdkplatform.comapi.map.c cVar = this.j;
        if (cVar == null) {
            return null;
        }
        return cVar.r();
    }

    public final int getFontSizeLevel() {
        com.baidu.mapsdkplatform.comapi.map.c cVar = this.j;
        if (cVar != null) {
            return cVar.H();
        }
        return 1;
    }

    public MapSurfaceView getGLMapView() {
        return this.h;
    }

    public OnHeatMapDrawFrameCallBack getHeatMapDrawFrameCallBack() {
        return this.Q;
    }

    public boolean getIsSDKLayerBelowBmLayer() {
        return this.ai;
    }

    @Deprecated
    public final MyLocationConfiguration getLocationConfigeration() {
        return getLocationConfiguration();
    }

    public final MyLocationConfiguration getLocationConfiguration() {
        return this.aa;
    }

    public final MyLocationData getLocationData() {
        return this.Z;
    }

    public final String getMapApprovalNumber() {
        com.baidu.mapsdkplatform.comapi.map.c cVar = this.j;
        if (cVar == null) {
            return "";
        }
        return cVar.P();
    }

    public final String getMapCopyrightInfo() {
        com.baidu.mapsdkplatform.comapi.map.c cVar = this.j;
        if (cVar == null) {
            return "";
        }
        return cVar.R();
    }

    public MapLanguage getMapLanguage() {
        com.baidu.mapsdkplatform.comapi.map.c cVar = this.j;
        if (cVar != null) {
            return MapLanguage.values()[cVar.S()];
        }
        return MapLanguage.CHINESE;
    }

    public final String getMapMappingQualificationInfo() {
        com.baidu.mapsdkplatform.comapi.map.c cVar = this.j;
        if (cVar == null) {
            return "";
        }
        return cVar.Q();
    }

    public final MapStatus getMapStatus() {
        com.baidu.mapsdkplatform.comapi.map.c cVar = this.j;
        if (cVar == null) {
            return null;
        }
        return MapStatus.a(cVar.E());
    }

    public final LatLngBounds getMapStatusLimit() {
        com.baidu.mapsdkplatform.comapi.map.c cVar = this.j;
        if (cVar == null) {
            return null;
        }
        return cVar.F();
    }

    public MapTextureView getMapTextureView() {
        return this.i;
    }

    public final int getMapType() {
        com.baidu.mapsdkplatform.comapi.map.c cVar = this.j;
        if (cVar == null) {
            return 1;
        }
        if (!cVar.l()) {
            return 3;
        }
        if (!this.j.k()) {
            return 1;
        }
        return 2;
    }

    public List<Marker> getMarkersInBounds(LatLngBounds latLngBounds) {
        if (getMapStatus() == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (this.n.size() == 0) {
            return null;
        }
        for (Marker marker : this.n) {
            if (latLngBounds.contains(marker.getPosition())) {
                arrayList.add(marker);
            }
        }
        return arrayList;
    }

    public final float getMaxZoomLevel() {
        com.baidu.mapsdkplatform.comapi.map.c cVar = this.j;
        if (cVar == null) {
            return 0.0f;
        }
        return cVar.b();
    }

    public final float getMinZoomLevel() {
        com.baidu.mapsdkplatform.comapi.map.c cVar = this.j;
        if (cVar == null) {
            return 0.0f;
        }
        return cVar.b;
    }

    public LatLngBounds getOverlayLatLngBounds(OverlayOptions overlayOptions) {
        if (overlayOptions != null && this.j != null) {
            Overlay a2 = overlayOptions.a();
            Bundle bundle = new Bundle();
            a2.a(bundle);
            return this.j.c(bundle);
        }
        return null;
    }

    public boolean getPoiTagEnable(PoiTagType poiTagType) {
        com.baidu.mapsdkplatform.comapi.map.c cVar = this.j;
        if (cVar != null) {
            return cVar.a(poiTagType);
        }
        return false;
    }

    public final Projection getProjection() {
        return this.f;
    }

    public float[] getProjectionMatrix() {
        com.baidu.mapsdkplatform.comapi.map.c cVar = this.j;
        if (cVar == null) {
            return null;
        }
        return cVar.N();
    }

    public final UiSettings getUiSettings() {
        return this.g;
    }

    public float[] getViewMatrix() {
        com.baidu.mapsdkplatform.comapi.map.c cVar = this.j;
        if (cVar == null) {
            return null;
        }
        return cVar.O();
    }

    public float getZoomToBound(int i, int i2, int i3, int i4, int i5, int i6) {
        com.baidu.mapsdkplatform.comapi.map.c cVar = this.j;
        if (cVar == null) {
            return 0.0f;
        }
        return cVar.a(i, i2, i3, i4, i5, i6);
    }

    @Deprecated
    public MapSurfaceView getmGLMapView() {
        return this.h;
    }

    public void hideInfoWindow() {
        View view;
        MapView mapView;
        Collection<InfoWindow> values = this.W.values();
        if (!values.isEmpty()) {
            for (InfoWindow infoWindow : values) {
                if (infoWindow != null && (view = infoWindow.c) != null) {
                    int i = d.b[this.d.ordinal()];
                    if (i == 1) {
                        TextureMapView textureMapView = this.b;
                        if (textureMapView != null) {
                            textureMapView.removeView(view);
                        }
                    } else if (i == 2 && (mapView = this.f5790a) != null) {
                        mapView.removeView(view);
                    }
                }
            }
        }
        for (Overlay overlay : this.l) {
            Set<String> keySet = this.W.keySet();
            String str = overlay.K;
            if ((overlay instanceof Marker) && !keySet.isEmpty() && keySet.contains(str)) {
                overlay.remove();
            }
        }
        this.W.clear();
        this.X.clear();
        this.o.clear();
    }

    public void hideSDKLayer() {
        com.baidu.mapsdkplatform.comapi.map.c cVar = this.j;
        if (cVar == null) {
            return;
        }
        cVar.c();
    }

    public final boolean isBaiduHeatMapEnabled() {
        com.baidu.mapsdkplatform.comapi.map.c cVar = this.j;
        if (cVar == null) {
            return false;
        }
        return cVar.i();
    }

    public boolean isBaseIndoorMapMode() {
        com.baidu.mapsdkplatform.comapi.map.c cVar = this.j;
        if (cVar == null) {
            return false;
        }
        return cVar.s();
    }

    public final boolean isBuildingsEnabled() {
        com.baidu.mapsdkplatform.comapi.map.c cVar = this.j;
        if (cVar == null) {
            return false;
        }
        return cVar.m();
    }

    public final boolean isMyLocationEnabled() {
        com.baidu.mapsdkplatform.comapi.map.c cVar = this.j;
        if (cVar == null) {
            return false;
        }
        return cVar.v();
    }

    public final boolean isShowMapPoi() {
        return this.ac;
    }

    public final boolean isSupportBaiduHeatMap() {
        com.baidu.mapsdkplatform.comapi.map.c cVar = this.j;
        if (cVar == null) {
            return false;
        }
        return cVar.j();
    }

    public final boolean isTrafficEnabled() {
        com.baidu.mapsdkplatform.comapi.map.c cVar = this.j;
        if (cVar == null) {
            return false;
        }
        return cVar.g();
    }

    public final void removeMarkerClickListener(OnMarkerClickListener onMarkerClickListener) {
        if (this.A.contains(onMarkerClickListener)) {
            this.A.remove(onMarkerClickListener);
        }
    }

    public void removeOverLays(List<Overlay> list) {
        int i;
        com.baidu.mapsdkplatform.comapi.map.c cVar;
        if (list != null && !this.ah) {
            ArrayList arrayList = new ArrayList();
            int size = list.size();
            int i2 = size / 400;
            for (int i3 = 0; i3 < i2 + 1; i3++) {
                for (int i4 = 0; i4 < 400 && (i = (i3 * 400) + i4) < size; i4++) {
                    if (this.ah) {
                        return;
                    }
                    Overlay overlay = list.get(i);
                    if (overlay != null) {
                        if (OverlayUtil.isOverlayUpgrade()) {
                            if (!(overlay instanceof Arc) && !(overlay instanceof Circle) && !(overlay instanceof Polygon) && !(overlay instanceof Polyline)) {
                                Bundle a2 = overlay.a();
                                com.baidu.mapsdkplatform.comapi.map.c cVar2 = this.j;
                                if (cVar2 != null) {
                                    cVar2.h(a2);
                                }
                                arrayList.add(a2);
                            } else {
                                b(overlay);
                            }
                        } else {
                            Bundle a3 = overlay.a();
                            com.baidu.mapsdkplatform.comapi.map.c cVar3 = this.j;
                            if (cVar3 != null) {
                                cVar3.h(a3);
                            }
                            arrayList.add(a3);
                        }
                        List<Marker> list2 = this.n;
                        if (list2 != null && list2.contains(overlay)) {
                            this.n.remove(overlay);
                        }
                        CopyOnWriteArrayList<Building> copyOnWriteArrayList = this.M;
                        if (copyOnWriteArrayList != null && copyOnWriteArrayList.contains(overlay)) {
                            this.M.remove(overlay);
                        }
                        if (this.m.contains(overlay)) {
                            Marker marker = (Marker) overlay;
                            if (marker.v != null) {
                                this.m.remove(marker);
                                if (this.m.size() == 0 && (cVar = this.j) != null) {
                                    cVar.d(false);
                                }
                            }
                        }
                    }
                }
                if (this.j != null && !arrayList.isEmpty()) {
                    int size2 = arrayList.size();
                    Bundle[] bundleArr = new Bundle[size2];
                    for (int i5 = 0; i5 < size2; i5++) {
                        bundleArr[i5] = (Bundle) arrayList.get(i5);
                    }
                    this.j.b(bundleArr);
                }
            }
            this.l.removeAll(list);
        }
    }

    public final void setBaiduHeatMapEnabled(boolean z) {
        if (this.j != null) {
            SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel("B", xoIox.f24717xXxxox0I, "0", null);
            this.j.l(z);
        }
    }

    public final void setBuildingsEnabled(boolean z) {
        com.baidu.mapsdkplatform.comapi.map.c cVar = this.j;
        if (cVar != null) {
            cVar.n(z);
        }
    }

    public void setCompassEnable(boolean z) {
        com.baidu.mapsdkplatform.comapi.map.c cVar = this.j;
        if (cVar == null) {
            return;
        }
        cVar.i(z);
    }

    public void setCompassIcon(Bitmap bitmap) {
        if (bitmap != null) {
            com.baidu.mapsdkplatform.comapi.map.c cVar = this.j;
            if (cVar == null) {
                return;
            }
            cVar.a(bitmap);
            return;
        }
        throw new IllegalArgumentException("BDMapSDKException: compass's icon can not be null");
    }

    public void setCompassPosition(Point point) {
        if (this.j == null) {
            return;
        }
        if (this.j.a(new Point(point.x, point.y))) {
            this.ag = point;
        }
    }

    @Deprecated
    public boolean setCustomTrafficColor(String str, String str2, String str3, String str4) {
        if (this.j == null) {
            return false;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
            if (str.matches("^#[0-9a-fA-F]{8}$") && str2.matches("^#[0-9a-fA-F]{8}$") && str3.matches("^#[0-9a-fA-F]{8}$") && str4.matches("^#[0-9a-fA-F]{8}$")) {
                this.j.a(Color.parseColor(str), Color.parseColor(str2), Color.parseColor(str3), Color.parseColor(str4), true);
                return true;
            }
            Log.e(e, "the string of the input customTrafficColor is error");
            return false;
        }
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3) && TextUtils.isEmpty(str4)) {
            this.j.a(Color.parseColor("#ffffffff"), Color.parseColor("#ffffffff"), Color.parseColor("#ffffffff"), Color.parseColor("#ffffffff"), false);
            return true;
        }
        return true;
    }

    public void setDEMEnable(boolean z) {
        com.baidu.mapsdkplatform.comapi.map.c cVar = this.j;
        if (cVar != null) {
            cVar.c(z);
        }
    }

    public final void setFontSizeLevel(int i) {
        com.baidu.mapsdkplatform.comapi.map.c cVar = this.j;
        if (cVar != null) {
            cVar.d(i);
        }
    }

    public void setHeatMapFrameAnimationIndex(int i) {
        com.baidu.mapsdkplatform.comapi.map.c cVar = this.j;
        if (cVar == null) {
            return;
        }
        cVar.c(i);
    }

    public final void setIndoorEnable(boolean z) {
        if (this.j != null) {
            SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel("B", "C", "3", null);
            this.ae = z;
            this.j.p(z);
        }
        OnBaseIndoorMapListener onBaseIndoorMapListener = this.O;
        if (onBaseIndoorMapListener != null && !z) {
            onBaseIndoorMapListener.onBaseIndoorMapMode(false, null);
        }
    }

    public final void setInfoWindowAdapter(InfoWindowAdapter infoWindowAdapter) {
        this.r = infoWindowAdapter;
    }

    public void setLayerClickable(MapLayer mapLayer, boolean z) {
        com.baidu.mapsdkplatform.comapi.map.c cVar = this.j;
        if (cVar == null) {
            return;
        }
        cVar.a(mapLayer, z);
    }

    public void setMapBackgroundColor(int i) {
        com.baidu.mapsdkplatform.comapi.map.c cVar = this.j;
        if (cVar == null) {
            return;
        }
        cVar.b(i);
    }

    public void setMapBackgroundImage(BitmapDescriptor bitmapDescriptor) {
        if (this.j == null) {
            return;
        }
        if (bitmapDescriptor == null) {
            Bundle bundle = new Bundle();
            bundle.putInt("reset", 1);
            this.j.b(bundle);
        } else {
            if (bitmapDescriptor.getBitmap().getByteCount() > 10240000) {
                return;
            }
            Bundle b = bitmapDescriptor.b();
            b.putInt("reset", 0);
            this.j.b(b);
        }
    }

    public final void setMapLanguage(MapLanguage mapLanguage) {
        if (mapLanguage == MapLanguage.ENGLISH && !PermissionUtils.getInstance().isEnglishMapAuthorized()) {
            Log.e("baidumapsdk", " No advanced permission to set English map");
            return;
        }
        com.baidu.mapsdkplatform.comapi.map.c cVar = this.j;
        if (cVar != null) {
            cVar.e(mapLanguage.ordinal());
        }
    }

    public final void setMapStatus(MapStatusUpdate mapStatusUpdate) {
        if (mapStatusUpdate == null) {
            return;
        }
        com.baidu.mapsdkplatform.comapi.map.w a2 = a(mapStatusUpdate);
        com.baidu.mapsdkplatform.comapi.map.c cVar = this.j;
        if (cVar == null) {
            return;
        }
        mapStatusReason |= 256;
        cVar.a(a2);
        OnMapStatusChangeListener onMapStatusChangeListener = this.s;
        if (onMapStatusChangeListener != null) {
            onMapStatusChangeListener.onMapStatusChange(getMapStatus());
        }
    }

    public final void setMapStatusLimits(LatLngBounds latLngBounds) {
        com.baidu.mapsdkplatform.comapi.map.c cVar = this.j;
        if (cVar == null) {
            return;
        }
        cVar.a(latLngBounds);
        setMapStatus(MapStatusUpdateFactory.newLatLngBounds(latLngBounds));
    }

    public final void setMapType(int i) {
        if (this.j == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(ExifInterface.GPS_DIRECTION_TRUE, Integer.valueOf(i));
        SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel("B", "M", "4", hashMap);
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    if (this.j.C()) {
                        this.j.D(false);
                    }
                    if (this.j.D()) {
                        this.j.E(false);
                    }
                    this.j.k(false);
                    this.j.p(false);
                }
            } else {
                this.j.b(true);
                this.j.D(this.ac);
                this.j.E(this.ad);
                this.j.k(true);
            }
        } else {
            this.j.b(false);
            this.j.D(this.ac);
            this.j.E(this.ad);
            this.j.k(true);
            this.j.p(this.ae);
        }
        if (OpenLogUtil.isMapLogEnable()) {
            com.baidu.mapsdkplatform.comapi.commonutils.b.a().a("BasicMap setMapType type = " + i);
        }
    }

    public final void setMaxAndMinZoomLevel(float f, float f2) {
        com.baidu.mapsdkplatform.comapi.map.c cVar;
        if (f <= 22.0f && f2 >= 4.0f && f >= f2 && (cVar = this.j) != null) {
            cVar.a(f, f2);
        }
    }

    @Deprecated
    public final void setMyLocationConfigeration(MyLocationConfiguration myLocationConfiguration) {
        setMyLocationConfiguration(myLocationConfiguration);
    }

    public final void setMyLocationConfiguration(MyLocationConfiguration myLocationConfiguration) {
        OnLocationModeChangeListener onLocationModeChangeListener;
        this.aa = myLocationConfiguration;
        a(this.Z, myLocationConfiguration);
        a(this.aa);
        if (myLocationConfiguration != null && isMyLocationEnabled() && (onLocationModeChangeListener = this.ab) != null) {
            onLocationModeChangeListener.onLocationModeChange(myLocationConfiguration.locationMode);
        }
    }

    public final void setMyLocationData(MyLocationData myLocationData) {
        this.Z = myLocationData;
        if (this.aa == null) {
            this.aa = new MyLocationConfiguration(MyLocationConfiguration.LocationMode.NORMAL, false, null);
        }
        a(myLocationData, this.aa);
    }

    public final void setMyLocationEnabled(boolean z) {
        com.baidu.mapsdkplatform.comapi.map.c cVar = this.j;
        if (cVar != null) {
            cVar.r(z);
        }
    }

    public final void setOn3DBuildingListener(Building3DListener building3DListener) {
        this.L = building3DListener;
    }

    public final void setOnArcClickListener(OnArcClickListener onArcClickListener) {
        if (onArcClickListener != null) {
            this.H.add(onArcClickListener);
        }
    }

    public final void setOnBaseIndoorMapListener(OnBaseIndoorMapListener onBaseIndoorMapListener) {
        SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel("B", "C", "3.2", null);
        this.O = onBaseIndoorMapListener;
    }

    public final void setOnCircleClickListener(OnCircleClickListener onCircleClickListener) {
        if (onCircleClickListener != null) {
            this.D.add(onCircleClickListener);
        }
    }

    public final void setOnGroundOverlayClickListener(OnGroundOverlayClickListener onGroundOverlayClickListener) {
        if (onGroundOverlayClickListener != null) {
            this.F.add(onGroundOverlayClickListener);
        }
    }

    public void setOnHeatMapDrawFrameCallBack(OnHeatMapDrawFrameCallBack onHeatMapDrawFrameCallBack) {
        this.Q = onHeatMapDrawFrameCallBack;
    }

    public final void setOnLocationModeChangeListener(OnLocationModeChangeListener onLocationModeChangeListener) {
        this.ab = onLocationModeChangeListener;
    }

    public final void setOnMapClickListener(OnMapClickListener onMapClickListener) {
        this.v = onMapClickListener;
    }

    public final void setOnMapDoubleClickListener(OnMapDoubleClickListener onMapDoubleClickListener) {
        this.y = onMapDoubleClickListener;
    }

    public final void setOnMapDrawFrameCallback(OnMapDrawFrameCallback onMapDrawFrameCallback) {
        this.N = onMapDrawFrameCallback;
    }

    public final void setOnMapGestureListener(onMapGestureListener onmapgesturelistener) {
        SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel("B", "GD", "0", null);
        this.u = onmapgesturelistener;
    }

    public void setOnMapLoadedCallback(OnMapLoadedCallback onMapLoadedCallback) {
        this.w = onMapLoadedCallback;
    }

    public final void setOnMapLongClickListener(OnMapLongClickListener onMapLongClickListener) {
        this.z = onMapLongClickListener;
    }

    public void setOnMapRenderCallbadk(OnMapRenderCallback onMapRenderCallback) {
        this.x = onMapRenderCallback;
    }

    public final void setOnMapRenderValidDataListener(OnMapRenderValidDataListener onMapRenderValidDataListener) {
        this.P = onMapRenderValidDataListener;
    }

    public final void setOnMapStatusChangeListener(OnMapStatusChangeListener onMapStatusChangeListener) {
        this.s = onMapStatusChangeListener;
    }

    public final void setOnMapTouchListener(OnMapTouchListener onMapTouchListener) {
        this.t = onMapTouchListener;
    }

    public final void setOnMarkerClickListener(OnMarkerClickListener onMarkerClickListener) {
        if (onMarkerClickListener != null && !this.A.contains(onMarkerClickListener)) {
            this.A.add(onMarkerClickListener);
        }
    }

    public final void setOnMarkerDragListener(OnMarkerDragListener onMarkerDragListener) {
        this.I = onMarkerDragListener;
    }

    public final void setOnMultiPointClickListener(OnMultiPointClickListener onMultiPointClickListener) {
        if (onMultiPointClickListener != null) {
            this.C.add(onMultiPointClickListener);
        }
    }

    public final void setOnMyLocationClickListener(OnMyLocationClickListener onMyLocationClickListener) {
        this.J = onMyLocationClickListener;
    }

    public final void setOnPolygonClickListener(OnPolygonClickListener onPolygonClickListener) {
        if (onPolygonClickListener != null) {
            this.E.add(onPolygonClickListener);
        }
    }

    public final void setOnPolylineClickListener(OnPolylineClickListener onPolylineClickListener) {
        if (onPolylineClickListener != null) {
            this.B.add(onPolylineClickListener);
        }
    }

    public final void setOnSynchronizationListener(OnSynchronizationListener onSynchronizationListener) {
        this.R = onSynchronizationListener;
    }

    public final void setOnTextClickListener(OnTextClickListener onTextClickListener) {
        if (onTextClickListener != null) {
            this.G.add(onTextClickListener);
        }
    }

    public void setOverlayUnderPoi(boolean z) {
        com.baidu.mapsdkplatform.comapi.map.c cVar = this.j;
        if (cVar == null) {
            return;
        }
        cVar.f(z);
    }

    @Deprecated
    public final void setPadding(int i, int i2, int i3, int i4) {
        setViewPadding(i, i2, i3, i4);
    }

    public void setPixelFormatTransparent(boolean z) {
        MapSurfaceView mapSurfaceView = this.h;
        if (mapSurfaceView == null) {
            return;
        }
        if (z) {
            mapSurfaceView.setPixelFormatTransparent(true);
        } else {
            mapSurfaceView.setPixelFormatTransparent(false);
        }
    }

    public void setPoiTagEnable(PoiTagType poiTagType, boolean z) {
        com.baidu.mapsdkplatform.comapi.map.c cVar = this.j;
        if (cVar != null) {
            cVar.a(poiTagType, z);
        }
    }

    public final void setTrafficEnabled(boolean z) {
        if (this.j != null) {
            SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel("B", "C", "1", null);
            this.j.m(z);
        }
    }

    public final void setViewPadding(int i, int i2, int i3, int i4) {
        MapView mapView;
        if (i < 0 || i2 < 0 || i3 < 0 || i4 < 0 || this.j == null) {
            return;
        }
        int i5 = d.b[this.d.ordinal()];
        if (i5 != 1) {
            if (i5 != 2 || (mapView = this.f5790a) == null) {
                return;
            }
            com.baidu.mapsdkplatform.comapi.map.c cVar = this.j;
            Point point = this.ag;
            cVar.a(new Point((int) (i + (point.x * (((mapView.getWidth() - i) - i3) / this.f5790a.getWidth()))), (int) (i2 + (point.y * (((this.f5790a.getHeight() - i2) - i4) / this.f5790a.getHeight())))));
            this.f5790a.setPadding(i, i2, i3, i4);
            this.f5790a.invalidate();
            return;
        }
        if (this.b == null) {
            return;
        }
        com.baidu.mapsdkplatform.comapi.map.c cVar2 = this.j;
        Point point2 = this.ag;
        cVar2.a(new Point((int) (i + (point2.x * (((r0.getWidth() - i) - i3) / this.b.getWidth()))), (int) (i2 + (point2.y * (((this.b.getHeight() - i2) - i4) / this.b.getHeight())))));
        this.b.setPadding(i, i2, i3, i4);
        this.b.invalidate();
    }

    public void showInfoWindow(InfoWindow infoWindow) {
        showInfoWindow(infoWindow, true);
    }

    public void showInfoWindows(List<InfoWindow> list) {
        if (list != null && !list.isEmpty()) {
            Iterator<InfoWindow> it = list.iterator();
            while (it.hasNext()) {
                showInfoWindow(it.next(), false);
            }
        }
    }

    public final void showMapIndoorPoi(boolean z) {
        com.baidu.mapsdkplatform.comapi.map.c cVar = this.j;
        if (cVar != null) {
            cVar.E(z);
            this.ad = z;
        }
    }

    public final void showMapPoi(boolean z) {
        com.baidu.mapsdkplatform.comapi.map.c cVar = this.j;
        if (cVar != null) {
            cVar.D(z);
            this.ac = z;
        }
    }

    public void showOperateLayer(boolean z) {
        if (this.j == null) {
            return;
        }
        SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel("B", "C", "2", null);
        this.j.e(z);
    }

    public boolean showParticleEffectByType(ParticleEffectType particleEffectType) {
        if (this.j != null) {
            if (particleEffectType == ParticleEffectType.Fireworks || particleEffectType == ParticleEffectType.Flower) {
                a(particleEffectType);
            }
            return this.j.b(particleEffectType);
        }
        return false;
    }

    public void showSDKLayer() {
        com.baidu.mapsdkplatform.comapi.map.c cVar = this.j;
        if (cVar == null) {
            return;
        }
        cVar.d();
    }

    public final void snapshot(SnapshotReadyCallback snapshotReadyCallback) {
        MapSurfaceView mapSurfaceView;
        this.K = snapshotReadyCallback;
        int i = d.b[this.d.ordinal()];
        if (i != 1) {
            if (i == 2 && (mapSurfaceView = this.h) != null && mapSurfaceView.getController() != null) {
                this.h.doCaptureMapView(new m(this), new Rect(0, 0, this.h.getController().getScreenWidth(), this.h.getController().getScreenHeight()), Bitmap.Config.ARGB_8888);
                this.h.requestRender();
                return;
            }
            return;
        }
        MapTextureView mapTextureView = this.i;
        if (mapTextureView != null && mapTextureView.getController() != null) {
            this.i.doCaptureMapView(new l(this), new Rect(0, 0, this.i.getController().getScreenWidth(), this.i.getController().getScreenHeight()), Bitmap.Config.ARGB_8888);
            this.i.requestRender();
        }
    }

    public final void snapshotScope(Rect rect, SnapshotReadyCallback snapshotReadyCallback) {
        MapSurfaceView mapSurfaceView;
        if (this.j == null) {
            return;
        }
        this.K = snapshotReadyCallback;
        int i = d.b[this.d.ordinal()];
        if (i != 1) {
            if (i == 2 && (mapSurfaceView = this.h) != null) {
                mapSurfaceView.doCaptureMapView(new c(this), rect, Bitmap.Config.ARGB_8888);
                this.h.requestRender();
                return;
            }
            return;
        }
        MapTextureView mapTextureView = this.i;
        if (mapTextureView != null) {
            mapTextureView.doCaptureMapView(new b(this), rect, Bitmap.Config.ARGB_8888);
            this.i.requestRender();
        }
    }

    public void startHeatMapFrameAnimation() {
        if (this.j == null) {
            return;
        }
        SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel("B", xoIox.f24717xXxxox0I, "1", null);
        this.j.o();
    }

    public void stopHeatMapFrameAnimation() {
        com.baidu.mapsdkplatform.comapi.map.c cVar = this.j;
        if (cVar == null) {
            return;
        }
        cVar.p();
    }

    public MapBaseIndoorMapInfo.SwitchFloorError switchBaseIndoorMapFloor(String str, String str2) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            MapBaseIndoorMapInfo focusedBaseIndoorMapInfo = getFocusedBaseIndoorMapInfo();
            if (focusedBaseIndoorMapInfo == null) {
                MapBaseIndoorMapInfo.SwitchFloorError switchFloorError = MapBaseIndoorMapInfo.SwitchFloorError.SWITCH_ERROR;
                hashMap.put(ExifInterface.LATITUDE_SOUTH, switchFloorError.name());
                SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel("B", "C", "3.1", hashMap);
                return switchFloorError;
            }
            if (!str2.equals(focusedBaseIndoorMapInfo.f5819a)) {
                MapBaseIndoorMapInfo.SwitchFloorError switchFloorError2 = MapBaseIndoorMapInfo.SwitchFloorError.FOCUSED_ID_ERROR;
                hashMap.put(ExifInterface.LATITUDE_SOUTH, switchFloorError2.name());
                SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel("B", "C", "3.1", hashMap);
                return switchFloorError2;
            }
            ArrayList<String> floors = focusedBaseIndoorMapInfo.getFloors();
            if (floors != null && floors.contains(str)) {
                com.baidu.mapsdkplatform.comapi.map.c cVar = this.j;
                if (cVar != null && cVar.a(str, str2)) {
                    MapBaseIndoorMapInfo.SwitchFloorError switchFloorError3 = MapBaseIndoorMapInfo.SwitchFloorError.SWITCH_OK;
                    hashMap.put(ExifInterface.LATITUDE_SOUTH, switchFloorError3.name());
                    SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel("B", "C", "3.1", hashMap);
                    return switchFloorError3;
                }
                MapBaseIndoorMapInfo.SwitchFloorError switchFloorError4 = MapBaseIndoorMapInfo.SwitchFloorError.SWITCH_ERROR;
                hashMap.put(ExifInterface.LATITUDE_SOUTH, switchFloorError4.name());
                SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel("B", "C", "3.1", hashMap);
                return switchFloorError4;
            }
            MapBaseIndoorMapInfo.SwitchFloorError switchFloorError5 = MapBaseIndoorMapInfo.SwitchFloorError.FLOOR_OVERLFLOW;
            hashMap.put(ExifInterface.LATITUDE_SOUTH, switchFloorError5.name());
            SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel("B", "C", "3.1", hashMap);
            return switchFloorError5;
        }
        MapBaseIndoorMapInfo.SwitchFloorError switchFloorError6 = MapBaseIndoorMapInfo.SwitchFloorError.FLOOR_INFO_ERROR;
        hashMap.put(ExifInterface.LATITUDE_SOUTH, switchFloorError6.name());
        SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel("B", "C", "3.1", hashMap);
        return switchFloorError6;
    }

    public void switchLayerOrder(MapLayer mapLayer, MapLayer mapLayer2) {
        if (this.j == null) {
            return;
        }
        SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel("B", "C", "5", null);
        if ((this.j.a(mapLayer, mapLayer2) && mapLayer == MapLayer.BM_LAYER_OVERLAY && mapLayer2 == MapLayer.MAP_LAYER_OVERLAY) || (mapLayer == MapLayer.MAP_LAYER_OVERLAY && mapLayer2 == MapLayer.BM_LAYER_OVERLAY)) {
            boolean z = !this.ai;
            this.ai = z;
            this.j.a(z);
        }
    }

    public boolean switchOverlayLayerAndNavigationLayer(boolean z) {
        if (this.j == null) {
            return false;
        }
        SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel("B", "C", "4", null);
        return this.j.h(z);
    }

    public void updateHeatMap(HeatMap heatMap) {
        if (heatMap != null && this.j != null) {
            this.U.lock();
            try {
                this.T = heatMap;
                heatMap.f5811a = this;
                this.j.j(heatMap.toBundle());
            } finally {
                this.U.unlock();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Overlay overlay) {
        BmLayer bmLayer;
        BmDrawItem a2;
        if (overlay == null || this.ah || (bmLayer = this.k) == null || (a2 = bmLayer.a(overlay.getName())) == null) {
            return;
        }
        this.k.a(a2);
        BmDrawItem drawItem = overlay.toDrawItem();
        a(overlay, drawItem);
        this.k.a(drawItem, drawItem.c());
        this.k.c();
    }

    private void d() {
        this.ah = false;
        this.l = new CopyOnWriteArrayList();
        this.m = new CopyOnWriteArrayList();
        this.n = new CopyOnWriteArrayList();
        this.M = new CopyOnWriteArrayList<>();
        this.W = new ConcurrentHashMap();
        this.X = new ConcurrentHashMap();
        this.o = new CopyOnWriteArrayList();
        this.ag = new Point((int) (SysOSUtil.getDensity() * 40.0f), (int) (SysOSUtil.getDensity() * 40.0f));
        this.g = new UiSettings(this.j);
        BmLayer bmLayer = this.k;
        if (bmLayer != null) {
            bmLayer.a(new a(this));
        }
        this.p = new e(this);
        this.q = new f(this);
        this.j.a(new g(this));
        this.j.a(new h(this));
        this.j.a(new j(this));
        this.j.a(new k(this));
        this.ac = this.j.C();
        this.ad = this.j.D();
    }

    public void showInfoWindow(InfoWindow infoWindow, boolean z) {
        boolean z2;
        MapView mapView;
        Set<InfoWindow> keySet = this.X.keySet();
        if (infoWindow == null || keySet.contains(infoWindow) || this.ah) {
            return;
        }
        if (z) {
            hideInfoWindow();
        }
        infoWindow.f = this.q;
        View view = infoWindow.c;
        if (view == null || !infoWindow.k) {
            z2 = true;
        } else {
            view.destroyDrawingCache();
            MapViewLayoutParams build = new MapViewLayoutParams.Builder().layoutMode(MapViewLayoutParams.ELayoutMode.mapMode).position(infoWindow.d).yOffset(infoWindow.g).build();
            int i = d.b[this.d.ordinal()];
            if (i == 1) {
                TextureMapView textureMapView = this.b;
                if (textureMapView != null) {
                    textureMapView.addView(view, build);
                }
            } else if (i == 2 && (mapView = this.f5790a) != null) {
                mapView.addView(view, build);
            }
            z2 = false;
        }
        BitmapDescriptor b = b(infoWindow);
        if (b == null) {
            return;
        }
        Overlay a2 = new MarkerOptions().perspective(false).icon(b).position(infoWindow.d).zIndex(Integer.MAX_VALUE).yOffset(infoWindow.g).infoWindow(infoWindow).a();
        a2.listener = this.p;
        a2.type = com.baidu.mapsdkplatform.comapi.map.h.popup;
        Bundle bundle = new Bundle();
        a2.a(bundle);
        if (infoWindow.c != null) {
            bundle.putInt("draw_with_view", 1);
        } else {
            bundle.putInt("draw_with_view", 0);
        }
        if (this.j != null && z2 && !this.ah) {
            this.j.d(bundle);
            this.l.add(a2);
        }
        Marker marker = (Marker) a2;
        marker.D = this.q;
        this.W.put(marker.K, infoWindow);
        this.X.put(infoWindow, marker);
        this.o.add(infoWindow);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Overlay overlay) {
        BmLayer bmLayer;
        BmDrawItem a2;
        if (overlay == null || this.ah || (bmLayer = this.k) == null || (a2 = bmLayer.a(overlay.getName())) == null) {
            return;
        }
        this.k.a(a2);
        this.k.c();
    }

    private BitmapDescriptor b(InfoWindow infoWindow) {
        View view = infoWindow.c;
        if (view != null && infoWindow.k) {
            if (infoWindow.h) {
                if (infoWindow.i <= 0) {
                    infoWindow.i = SysOSUtil.getDensityDpi();
                }
                return BitmapDescriptorFactory.fromViewWithDpi(infoWindow.c, infoWindow.i);
            }
            return BitmapDescriptorFactory.fromView(view);
        }
        return infoWindow.b;
    }

    public final void animateMapStatus(MapStatusUpdate mapStatusUpdate) {
        animateMapStatus(mapStatusUpdate, 300);
    }

    private Overlay a(Overlay overlay) {
        BmLayer bmLayer;
        if (overlay == null || this.ah || (bmLayer = this.k) == null || this.j == null) {
            return null;
        }
        BmDrawItem a2 = bmLayer.a(overlay.getName());
        if (a2 != null) {
            this.k.a(a2);
        }
        BmDrawItem drawItem = overlay.toDrawItem();
        a(overlay, drawItem);
        this.k.a(drawItem, drawItem.c());
        this.k.c();
        return overlay;
    }

    public void c() {
        this.ah = true;
        com.baidu.mapsdkplatform.comapi.map.a.c cVar = this.al;
        if (cVar != null) {
            cVar.c();
            this.al = null;
        }
        hideInfoWindow();
    }

    public boolean b() {
        com.baidu.mapsdkplatform.comapi.map.c cVar = this.j;
        if (cVar == null) {
            return false;
        }
        return cVar.f();
    }

    private void a(Overlay overlay, BmDrawItem bmDrawItem) {
        if (overlay == null || bmDrawItem == null || !(overlay instanceof Polygon) || !(bmDrawItem instanceof BmPolygon)) {
            return;
        }
        BmPolygon bmPolygon = (BmPolygon) bmDrawItem;
        BmGeoElement geoElement = ((Polygon) overlay).getGeoElement();
        if (geoElement == null || geoElement.a() == null || geoElement.a().length() <= 0) {
            return;
        }
        ArrayList<LatLng> a2 = this.j.a(geoElement.a());
        if (a2 == null || a2.size() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<LatLng> it = a2.iterator();
        while (it.hasNext()) {
            GeoPoint ll2mc = CoordUtil.ll2mc(it.next());
            arrayList.add(new com.baidu.platform.comapi.bmsdk.b(ll2mc.getLongitudeE6(), ll2mc.getLatitudeE6()));
        }
        geoElement.a(arrayList);
        bmPolygon.a(geoElement);
    }

    public void hideInfoWindow(InfoWindow infoWindow) {
        MapView mapView;
        Set<InfoWindow> keySet = this.X.keySet();
        if (infoWindow == null || keySet.isEmpty() || !keySet.contains(infoWindow)) {
            return;
        }
        View view = infoWindow.c;
        if (view != null) {
            int i = d.b[this.d.ordinal()];
            if (i == 1) {
                TextureMapView textureMapView = this.b;
                if (textureMapView != null) {
                    textureMapView.removeView(view);
                }
            } else if (i == 2 && (mapView = this.f5790a) != null) {
                mapView.removeView(view);
            }
        }
        Marker marker = this.X.get(infoWindow);
        if (marker != null) {
            marker.remove();
            this.W.remove(marker.K);
        }
        this.X.remove(infoWindow);
        this.o.remove(infoWindow);
    }

    public BaiduMap(Context context, MapSurfaceView mapSurfaceView, com.baidu.mapsdkplatform.comapi.map.u uVar) {
        this.h = mapSurfaceView;
        com.baidu.mapsdkplatform.comapi.map.c cVar = new com.baidu.mapsdkplatform.comapi.map.c(context, mapSurfaceView, uVar, (String) null, 0);
        this.j = cVar;
        mapSurfaceView.setBaseMap(cVar);
        if (OverlayUtil.isOverlayUpgrade()) {
            this.h.addBmLayer(this.k);
            this.j.a(this.k);
        }
        this.d = com.baidu.mapsdkplatform.comapi.map.v.GLSurfaceView;
        d();
    }

    private com.baidu.mapsdkplatform.comapi.map.w a(MapStatusUpdate mapStatusUpdate) {
        com.baidu.mapsdkplatform.comapi.map.c cVar = this.j;
        if (cVar == null) {
            return null;
        }
        com.baidu.mapsdkplatform.comapi.map.w E = cVar.E();
        MapStatus a2 = mapStatusUpdate.a(this.j, getMapStatus());
        if (a2 == null) {
            return null;
        }
        return a2.b(E);
    }

    private final void a(MyLocationConfiguration myLocationConfiguration) {
        Bitmap bitmap;
        com.baidu.mapsdkplatform.comapi.map.c cVar;
        Bitmap bitmap2;
        Bitmap bitmap3;
        com.baidu.mapsdkplatform.comapi.map.c cVar2 = this.j;
        if (cVar2 != null) {
            cVar2.u();
        }
        ArrayList arrayList = new ArrayList();
        if (myLocationConfiguration.isEnableCustom()) {
            if (myLocationConfiguration.getArrow() != null && (bitmap3 = myLocationConfiguration.getArrow().getBitmap()) != null && !bitmap3.isRecycled()) {
                OverlayLocationData overlayLocationData = new OverlayLocationData();
                overlayLocationData.setImage(bitmap3);
                overlayLocationData.setImgHeight(bitmap3.getHeight());
                overlayLocationData.setImgWidth(bitmap3.getWidth());
                overlayLocationData.setImgType("arrowicon");
                overlayLocationData.setImgName("arrowicon_" + bitmap3.hashCode());
                overlayLocationData.setArrowSize(myLocationConfiguration.getArrowSize());
                overlayLocationData.setRotation(1);
                arrayList.add(overlayLocationData);
            }
            if (myLocationConfiguration.getCustomMarker() != null && (bitmap2 = myLocationConfiguration.getCustomMarker().getBitmap()) != null && !bitmap2.isRecycled()) {
                OverlayLocationData overlayLocationData2 = new OverlayLocationData();
                overlayLocationData2.setImage(bitmap2);
                overlayLocationData2.setImgHeight(bitmap2.getHeight());
                overlayLocationData2.setImgWidth(bitmap2.getWidth());
                overlayLocationData2.setImgType(com.huawei.openalliance.ad.constant.x.cD);
                overlayLocationData2.setImgName("icon_" + bitmap2.hashCode());
                overlayLocationData2.setMarkerSize(myLocationConfiguration.getMarkerSize());
                overlayLocationData2.setRotation(myLocationConfiguration.isEnableRotation() ? 1 : 0);
                overlayLocationData2.setAnimation(myLocationConfiguration.isNeedAnimation() ? 1 : 0);
                arrayList.add(overlayLocationData2);
            }
            if (myLocationConfiguration.getGifMarker() != null) {
                OverlayLocationData overlayLocationData3 = new OverlayLocationData();
                overlayLocationData3.setImgType("gificon");
                overlayLocationData3.setImgName("gificon");
                overlayLocationData3.setGIFImgPath(myLocationConfiguration.getGifMarker());
                overlayLocationData3.setMarkerSize(myLocationConfiguration.getMarkerSize());
                overlayLocationData3.setRotation(myLocationConfiguration.isEnableRotation() ? 1 : 0);
                overlayLocationData3.setAnimation(myLocationConfiguration.isNeedAnimation() ? 1 : 0);
                arrayList.add(overlayLocationData3);
            }
        } else if (myLocationConfiguration.getCustomMarker() != null && (bitmap = myLocationConfiguration.getCustomMarker().getBitmap()) != null && !bitmap.isRecycled()) {
            OverlayLocationData overlayLocationData4 = new OverlayLocationData();
            overlayLocationData4.setImage(bitmap);
            overlayLocationData4.setImgHeight(bitmap.getHeight());
            overlayLocationData4.setImgWidth(bitmap.getWidth());
            overlayLocationData4.setImgName(com.huawei.openalliance.ad.constant.x.cD);
            overlayLocationData4.setRotation(myLocationConfiguration.enableDirection ? 1 : 0);
            arrayList.add(overlayLocationData4);
        }
        if (arrayList.size() <= 0 || (cVar = this.j) == null) {
            return;
        }
        cVar.a(arrayList);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0170  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void a(com.baidu.mapapi.map.MyLocationData r21, com.baidu.mapapi.map.MyLocationConfiguration r22) {
        /*
            Method dump skipped, instructions count: 432
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapapi.map.BaiduMap.a(com.baidu.mapapi.map.MyLocationData, com.baidu.mapapi.map.MyLocationConfiguration):void");
    }

    public void a(HeatMap heatMap) {
        this.U.lock();
        try {
            HeatMap heatMap2 = this.T;
            if (heatMap2 != null && this.j != null && heatMap == heatMap2) {
                heatMap2.b();
                this.T.c();
                this.T.f5811a = null;
                this.j.q();
                this.T = null;
                this.j.s(false);
            }
        } finally {
            this.U.unlock();
        }
    }

    public void a() {
        com.baidu.mapsdkplatform.comapi.map.c cVar = this.j;
        if (cVar == null) {
            return;
        }
        cVar.w();
    }

    private Point a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int i = 0;
        int i2 = 0;
        for (String str2 : str.replaceAll("^\\{", "").replaceAll("\\}$", "").split(",")) {
            String[] split = str2.replaceAll("\"", "").split(":");
            if ("x".equals(split[0])) {
                i = Integer.valueOf(split[1]).intValue();
            }
            if ("y".equals(split[0])) {
                i2 = Integer.valueOf(split[1]).intValue();
            }
        }
        return new Point(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(com.baidu.mapapi.map.InfoWindow r8) {
        /*
            r7 = this;
            if (r8 == 0) goto Lb5
            boolean r0 = r7.ah
            if (r0 == 0) goto L8
            goto Lb5
        L8:
            java.util.Map<com.baidu.mapapi.map.InfoWindow, com.baidu.mapapi.map.Marker> r0 = r7.X
            java.util.Set r0 = r0.keySet()
            boolean r1 = r0.isEmpty()
            r2 = 0
            if (r1 != 0) goto Lb2
            boolean r0 = r0.contains(r8)
            if (r0 != 0) goto L1d
            goto Lb2
        L1d:
            android.view.View r0 = r8.c
            r1 = 1
            if (r0 == 0) goto L6c
            boolean r3 = r8.k
            if (r3 == 0) goto L6c
            r0.destroyDrawingCache()
            com.baidu.mapapi.map.MapViewLayoutParams$Builder r3 = new com.baidu.mapapi.map.MapViewLayoutParams$Builder
            r3.<init>()
            com.baidu.mapapi.map.MapViewLayoutParams$ELayoutMode r4 = com.baidu.mapapi.map.MapViewLayoutParams.ELayoutMode.mapMode
            com.baidu.mapapi.map.MapViewLayoutParams$Builder r3 = r3.layoutMode(r4)
            com.baidu.mapapi.model.LatLng r4 = r8.d
            com.baidu.mapapi.map.MapViewLayoutParams$Builder r3 = r3.position(r4)
            int r4 = r8.g
            com.baidu.mapapi.map.MapViewLayoutParams$Builder r3 = r3.yOffset(r4)
            com.baidu.mapapi.map.MapViewLayoutParams r3 = r3.build()
            int[] r4 = com.baidu.mapapi.map.d.b
            com.baidu.mapsdkplatform.comapi.map.v r5 = r7.d
            int r5 = r5.ordinal()
            r4 = r4[r5]
            if (r4 == r1) goto L5c
            r5 = 2
            if (r4 == r5) goto L54
            goto L66
        L54:
            com.baidu.mapapi.map.MapView r4 = r7.f5790a
            if (r4 == 0) goto L66
            r4.addView(r0, r3)
            goto L66
        L5c:
            com.baidu.mapapi.map.TextureMapView r4 = r7.b
            if (r4 == 0) goto L66
            r4.addView(r0, r3)
            r0.setLayoutParams(r3)
        L66:
            boolean r0 = r8.j
            if (r0 == 0) goto L6c
            r0 = 0
            goto L6d
        L6c:
            r0 = 1
        L6d:
            com.baidu.mapapi.map.BitmapDescriptor r3 = r7.b(r8)
            java.util.Map<com.baidu.mapapi.map.InfoWindow, com.baidu.mapapi.map.Marker> r4 = r7.X
            java.lang.Object r4 = r4.get(r8)
            com.baidu.mapapi.map.Marker r4 = (com.baidu.mapapi.map.Marker) r4
            if (r4 == 0) goto Lb1
            android.os.Bundle r5 = new android.os.Bundle
            r5.<init>()
            com.baidu.mapapi.map.BitmapDescriptor r6 = r8.b
            if (r6 == 0) goto L97
            com.baidu.mapsdkplatform.comapi.map.h r6 = com.baidu.mapsdkplatform.comapi.map.h.popup
            r4.type = r6
            r4.b = r3
            android.view.View r3 = r8.c
            java.lang.String r6 = "draw_with_view"
            if (r3 == 0) goto L94
            r5.putInt(r6, r1)
            goto L97
        L94:
            r5.putInt(r6, r2)
        L97:
            com.baidu.mapapi.model.LatLng r1 = r8.d
            r4.f5832a = r1
            int r8 = r8.g
            r4.j = r8
            r4.a(r5)
            com.baidu.mapsdkplatform.comapi.map.c r8 = r7.j
            if (r8 == 0) goto Lb1
            if (r0 == 0) goto Lb1
            boolean r8 = r7.ah
            if (r8 != 0) goto Lb1
            com.baidu.mapsdkplatform.comapi.map.c r8 = r7.j
            r8.f(r5)
        Lb1:
            return
        Lb2:
            r7.showInfoWindow(r8, r2)
        Lb5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapapi.map.BaiduMap.a(com.baidu.mapapi.map.InfoWindow):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(int i) {
        if (i != 0) {
            switch (i) {
                case 1004:
                    return "网络连接错误";
                case 1005:
                    return "请求发送错误";
                case 1006:
                    return "响应数据读取失败";
                case 1007:
                    return "返回响应数据过大，数据溢出";
                case 1008:
                    return "当前网络类型有问题";
                case 1009:
                    return "数据不一致";
                case 1010:
                    return "请求取消";
                case 1011:
                    return "网络超时错误";
                case 1012:
                    return "网络连接超时";
                case 1013:
                    return "网络发送超时";
                case 1014:
                    return "网络接收超时";
                case 1015:
                    return "DNS解析错误";
                case 1016:
                    return "DNS解析超时";
                case 1017:
                    return "网络写错误";
                case 1018:
                    return "SSL握手错误";
                case 1019:
                    return "SSL握手超时";
                default:
                    return "";
            }
        }
        return "数据请求成功";
    }

    public void a(TileOverlay tileOverlay) {
        this.V.lock();
        if (tileOverlay != null) {
            try {
                if (this.S == tileOverlay) {
                    tileOverlay.b();
                    tileOverlay.f5867a = null;
                    com.baidu.mapsdkplatform.comapi.map.c cVar = this.j;
                    if (cVar != null) {
                        cVar.e();
                    }
                }
            } finally {
                this.S = null;
                this.V.unlock();
            }
        }
    }

    private void a(ParticleEffectType particleEffectType) {
        BitmapDescriptor fromAsset;
        if (ParticleEffectType.Flower == particleEffectType && !aj && (fromAsset = BitmapDescriptorFactory.fromAsset("flower.png")) != null) {
            Bundle bundle = new Bundle();
            bundle.putInt("total", 1);
            bundle.putBundle(String.format("texture_%d", 0), fromAsset.b());
            if (this.j.a(particleEffectType, bundle)) {
                aj = true;
            }
        }
        if (ParticleEffectType.Fireworks != particleEffectType || ak) {
            return;
        }
        BitmapDescriptor fromAsset2 = BitmapDescriptorFactory.fromAsset("firework_bullet.png");
        BitmapDescriptor fromAsset3 = BitmapDescriptorFactory.fromAsset("firework_tail.png");
        if (fromAsset2 == null || fromAsset3 == null) {
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putInt("total", 2);
        bundle2.putBundle(String.format("texture_%d", 0), fromAsset2.b());
        bundle2.putBundle(String.format("texture_%d", 1), fromAsset3.b());
        if (this.j.a(particleEffectType, bundle2)) {
            ak = true;
        }
    }
}
