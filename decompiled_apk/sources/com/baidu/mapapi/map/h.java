package com.baidu.mapapi.map;

import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.InfoWindow;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Lock;
import javax.microedition.khronos.opengles.GL10;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class h implements com.baidu.platform.comapi.map.ak {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ BaiduMap f5900a;

    public h(BaiduMap baiduMap) {
        this.f5900a = baiduMap;
    }

    @Override // com.baidu.platform.comapi.map.ak
    public void a() {
    }

    @Override // com.baidu.platform.comapi.map.ak
    public void b(com.baidu.mapsdkplatform.comapi.map.w wVar) {
        BaiduMap.OnMapStatusChangeListener onMapStatusChangeListener;
        BaiduMap.OnMapStatusChangeListener onMapStatusChangeListener2;
        onMapStatusChangeListener = this.f5900a.s;
        if (onMapStatusChangeListener != null) {
            MapStatus a2 = MapStatus.a(wVar);
            onMapStatusChangeListener2 = this.f5900a.s;
            onMapStatusChangeListener2.onMapStatusChange(a2);
        }
    }

    @Override // com.baidu.platform.comapi.map.ak
    public void c(com.baidu.mapsdkplatform.comapi.map.w wVar) {
        BaiduMap.OnMapStatusChangeListener onMapStatusChangeListener;
        BaiduMap.onMapGestureListener onmapgesturelistener;
        BaiduMap.onMapGestureListener onmapgesturelistener2;
        BaiduMap.OnMapStatusChangeListener onMapStatusChangeListener2;
        MapStatus a2 = MapStatus.a(wVar);
        onMapStatusChangeListener = this.f5900a.s;
        if (onMapStatusChangeListener != null) {
            onMapStatusChangeListener2 = this.f5900a.s;
            onMapStatusChangeListener2.onMapStatusChangeFinish(a2);
        }
        onmapgesturelistener = this.f5900a.u;
        if (onmapgesturelistener != null) {
            onmapgesturelistener2 = this.f5900a.u;
            onmapgesturelistener2.onMapStatusChangeFinish(a2);
        }
        BaiduMap.mapStatusReason = 0;
    }

    @Override // com.baidu.platform.comapi.map.ak
    public boolean d(Point point, Point point2, com.baidu.mapsdkplatform.comapi.map.w wVar) {
        BaiduMap.onMapGestureListener onmapgesturelistener;
        BaiduMap.onMapGestureListener onmapgesturelistener2;
        MapStatus a2 = MapStatus.a(wVar);
        onmapgesturelistener = this.f5900a.u;
        if (onmapgesturelistener == null) {
            return false;
        }
        BaiduMap.mapStatusReason = 1;
        onmapgesturelistener2 = this.f5900a.u;
        return onmapgesturelistener2.onMapTwoClick(point, point2, a2);
    }

    @Override // com.baidu.platform.comapi.map.ak
    public void e(GeoPoint geoPoint) {
        Marker marker;
        Marker marker2;
        Projection projection;
        Projection projection2;
        Marker marker3;
        BaiduMap.OnMarkerDragListener onMarkerDragListener;
        Marker marker4;
        BaiduMap.OnMarkerDragListener onMarkerDragListener2;
        Marker marker5;
        marker = this.f5900a.Y;
        if (marker != null) {
            marker2 = this.f5900a.Y;
            if (marker2.f) {
                LatLng mc2ll = CoordUtil.mc2ll(geoPoint);
                projection = this.f5900a.f;
                Point point = new Point(projection.toScreenLocation(mc2ll).x, r3.y - 60);
                projection2 = this.f5900a.f;
                LatLng fromScreenLocation = projection2.fromScreenLocation(point);
                marker3 = this.f5900a.Y;
                marker3.setPosition(fromScreenLocation);
                onMarkerDragListener = this.f5900a.I;
                if (onMarkerDragListener != null) {
                    marker4 = this.f5900a.Y;
                    if (marker4.f) {
                        onMarkerDragListener2 = this.f5900a.I;
                        marker5 = this.f5900a.Y;
                        onMarkerDragListener2.onMarkerDragEnd(marker5);
                    }
                }
                this.f5900a.Y = null;
            }
        }
    }

    @Override // com.baidu.platform.comapi.map.ak
    public void a(com.baidu.mapsdkplatform.comapi.map.w wVar) {
        BaiduMap.OnMapStatusChangeListener onMapStatusChangeListener;
        BaiduMap.OnSynchronizationListener onSynchronizationListener;
        BaiduMap.OnSynchronizationListener onSynchronizationListener2;
        BaiduMap.OnMapStatusChangeListener onMapStatusChangeListener2;
        BaiduMap.OnMapStatusChangeListener onMapStatusChangeListener3;
        int i = BaiduMap.mapStatusReason;
        int i2 = (i & 256) == 256 ? 3 : (i & 16) == 16 ? 2 : 1;
        onMapStatusChangeListener = this.f5900a.s;
        if (onMapStatusChangeListener != null) {
            MapStatus a2 = MapStatus.a(wVar);
            onMapStatusChangeListener2 = this.f5900a.s;
            onMapStatusChangeListener2.onMapStatusChangeStart(a2);
            onMapStatusChangeListener3 = this.f5900a.s;
            onMapStatusChangeListener3.onMapStatusChangeStart(a2, i2);
        }
        onSynchronizationListener = this.f5900a.R;
        if (onSynchronizationListener != null) {
            onSynchronizationListener2 = this.f5900a.R;
            onSynchronizationListener2.onMapStatusChangeReason(i2);
        }
        BaiduMap.mapStatusReason = 0;
    }

    @Override // com.baidu.platform.comapi.map.ak
    public boolean b(Point point, Point point2, com.baidu.mapsdkplatform.comapi.map.w wVar) {
        BaiduMap.onMapGestureListener onmapgesturelistener;
        BaiduMap.onMapGestureListener onmapgesturelistener2;
        MapStatus a2 = MapStatus.a(wVar);
        onmapgesturelistener = this.f5900a.u;
        if (onmapgesturelistener == null) {
            return false;
        }
        BaiduMap.mapStatusReason = 1;
        onmapgesturelistener2 = this.f5900a.u;
        return onmapgesturelistener2.onMapScroll(point, point2, a2);
    }

    @Override // com.baidu.platform.comapi.map.ak
    public void d(GeoPoint geoPoint) {
        Marker marker;
        Marker marker2;
        Projection projection;
        Projection projection2;
        Marker marker3;
        BaiduMap.OnMarkerDragListener onMarkerDragListener;
        Marker marker4;
        BaiduMap.OnMarkerDragListener onMarkerDragListener2;
        Marker marker5;
        marker = this.f5900a.Y;
        if (marker != null) {
            marker2 = this.f5900a.Y;
            if (marker2.f) {
                LatLng mc2ll = CoordUtil.mc2ll(geoPoint);
                projection = this.f5900a.f;
                Point point = new Point(projection.toScreenLocation(mc2ll).x, r3.y - 60);
                projection2 = this.f5900a.f;
                LatLng fromScreenLocation = projection2.fromScreenLocation(point);
                marker3 = this.f5900a.Y;
                marker3.setPosition(fromScreenLocation);
                onMarkerDragListener = this.f5900a.I;
                if (onMarkerDragListener != null) {
                    marker4 = this.f5900a.Y;
                    if (marker4.f) {
                        onMarkerDragListener2 = this.f5900a.I;
                        marker5 = this.f5900a.Y;
                        onMarkerDragListener2.onMarkerDrag(marker5);
                    }
                }
            }
        }
    }

    @Override // com.baidu.platform.comapi.map.ak
    public boolean c(Point point, Point point2, com.baidu.mapsdkplatform.comapi.map.w wVar) {
        BaiduMap.onMapGestureListener onmapgesturelistener;
        BaiduMap.onMapGestureListener onmapgesturelistener2;
        MapStatus a2 = MapStatus.a(wVar);
        onmapgesturelistener = this.f5900a.u;
        if (onmapgesturelistener == null) {
            return false;
        }
        BaiduMap.mapStatusReason = 1;
        onmapgesturelistener2 = this.f5900a.u;
        return onmapgesturelistener2.onMapOverLooking(point, point2, a2);
    }

    @Override // com.baidu.platform.comapi.map.ak
    public void b(GeoPoint geoPoint) {
        BaiduMap.OnMapDoubleClickListener onMapDoubleClickListener;
        BaiduMap.OnMapDoubleClickListener onMapDoubleClickListener2;
        onMapDoubleClickListener = this.f5900a.y;
        if (onMapDoubleClickListener != null) {
            LatLng mc2ll = CoordUtil.mc2ll(geoPoint);
            BaiduMap.mapStatusReason |= 1;
            onMapDoubleClickListener2 = this.f5900a.y;
            onMapDoubleClickListener2.onMapDoubleClick(mc2ll);
        }
    }

    @Override // com.baidu.platform.comapi.map.ak
    public void a(MotionEvent motionEvent) {
        BaiduMap.OnMapTouchListener onMapTouchListener;
        BaiduMap.OnMapTouchListener onMapTouchListener2;
        onMapTouchListener = this.f5900a.t;
        if (onMapTouchListener != null) {
            onMapTouchListener2 = this.f5900a.t;
            onMapTouchListener2.onTouch(motionEvent);
        }
    }

    @Override // com.baidu.platform.comapi.map.ak
    public void c(GeoPoint geoPoint) {
        BaiduMap.OnMapLongClickListener onMapLongClickListener;
        BaiduMap.OnMapLongClickListener onMapLongClickListener2;
        onMapLongClickListener = this.f5900a.z;
        if (onMapLongClickListener != null) {
            LatLng mc2ll = CoordUtil.mc2ll(geoPoint);
            onMapLongClickListener2 = this.f5900a.z;
            onMapLongClickListener2.onMapLongClick(mc2ll);
        }
    }

    @Override // com.baidu.platform.comapi.map.ak
    public boolean a(Point point, Point point2, com.baidu.mapsdkplatform.comapi.map.w wVar) {
        BaiduMap.onMapGestureListener onmapgesturelistener;
        BaiduMap.onMapGestureListener onmapgesturelistener2;
        MapStatus a2 = MapStatus.a(wVar);
        onmapgesturelistener = this.f5900a.u;
        if (onmapgesturelistener == null) {
            return false;
        }
        BaiduMap.mapStatusReason = 1;
        onmapgesturelistener2 = this.f5900a.u;
        return onmapgesturelistener2.onMapKneading(point, point2, a2);
    }

    @Override // com.baidu.platform.comapi.map.ak
    public void b() {
        com.baidu.mapsdkplatform.comapi.map.c cVar;
        BaiduMap.OnMapLoadedCallback onMapLoadedCallback;
        BaiduMap.OnMapLoadedCallback onMapLoadedCallback2;
        BaiduMap baiduMap = this.f5900a;
        cVar = baiduMap.j;
        baiduMap.f = new Projection(cVar);
        this.f5900a.af = true;
        onMapLoadedCallback = this.f5900a.w;
        if (onMapLoadedCallback != null) {
            onMapLoadedCallback2 = this.f5900a.w;
            onMapLoadedCallback2.onMapLoaded();
        }
    }

    @Override // com.baidu.platform.comapi.map.ak
    public void d() {
        com.baidu.mapsdkplatform.comapi.map.c cVar;
        Lock lock;
        Lock lock2;
        HeatMap heatMap;
        HeatMap heatMap2;
        com.baidu.mapsdkplatform.comapi.map.c cVar2;
        cVar = this.f5900a.j;
        if (cVar != null) {
            cVar2 = this.f5900a.j;
            cVar2.d(false);
        }
        lock = this.f5900a.U;
        lock.lock();
        try {
            heatMap = this.f5900a.T;
            if (heatMap != null) {
                BaiduMap baiduMap = this.f5900a;
                heatMap2 = baiduMap.T;
                baiduMap.a(heatMap2);
            }
        } finally {
            lock2 = this.f5900a.U;
            lock2.unlock();
        }
    }

    @Override // com.baidu.platform.comapi.map.ak
    public void c() {
        BaiduMap.OnMapRenderCallback onMapRenderCallback;
        BaiduMap.OnMapRenderCallback onMapRenderCallback2;
        onMapRenderCallback = this.f5900a.x;
        if (onMapRenderCallback != null) {
            onMapRenderCallback2 = this.f5900a.x;
            onMapRenderCallback2.onMapRenderFinished();
        }
    }

    @Override // com.baidu.platform.comapi.map.ak
    public boolean a(MotionEvent motionEvent, float f, float f2, com.baidu.mapsdkplatform.comapi.map.w wVar) {
        BaiduMap.onMapGestureListener onmapgesturelistener;
        BaiduMap.onMapGestureListener onmapgesturelistener2;
        MapStatus a2 = MapStatus.a(wVar);
        onmapgesturelistener = this.f5900a.u;
        if (onmapgesturelistener == null) {
            return false;
        }
        BaiduMap.mapStatusReason = 1;
        onmapgesturelistener2 = this.f5900a.u;
        return onmapgesturelistener2.onMapFling(motionEvent, f, f2, a2);
    }

    @Override // com.baidu.platform.comapi.map.ak
    public boolean b(String str) {
        JSONObject optJSONObject;
        Map map;
        List<Overlay> list;
        Projection projection;
        Marker marker;
        Projection projection2;
        Marker marker2;
        BaiduMap.OnMarkerDragListener onMarkerDragListener;
        BaiduMap.OnMarkerDragListener onMarkerDragListener2;
        Marker marker3;
        try {
            JSONArray optJSONArray = new JSONObject(str).optJSONArray("dataset");
            if (optJSONArray == null || (optJSONObject = optJSONArray.optJSONObject(0)) == null || optJSONObject.optInt("ty") != 90909) {
                return false;
            }
            String optString = optJSONObject.optString("marker_id");
            map = this.f5900a.W;
            Set keySet = map.keySet();
            if (!keySet.isEmpty() && keySet.contains(optString)) {
                return false;
            }
            list = this.f5900a.l;
            for (Overlay overlay : list) {
                if ((overlay instanceof Marker) && overlay.K.equals(optString)) {
                    Marker marker4 = (Marker) overlay;
                    if (!marker4.f) {
                        return false;
                    }
                    this.f5900a.Y = marker4;
                    projection = this.f5900a.f;
                    marker = this.f5900a.Y;
                    Point point = new Point(projection.toScreenLocation(marker.f5832a).x, r5.y - 60);
                    projection2 = this.f5900a.f;
                    LatLng fromScreenLocation = projection2.fromScreenLocation(point);
                    marker2 = this.f5900a.Y;
                    marker2.setPosition(fromScreenLocation);
                    onMarkerDragListener = this.f5900a.I;
                    if (onMarkerDragListener != null) {
                        onMarkerDragListener2 = this.f5900a.I;
                        marker3 = this.f5900a.Y;
                        onMarkerDragListener2.onMarkerDragStart(marker3);
                    }
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.baidu.platform.comapi.map.ak
    public boolean a(Point point, com.baidu.mapsdkplatform.comapi.map.w wVar) {
        BaiduMap.onMapGestureListener onmapgesturelistener;
        BaiduMap.onMapGestureListener onmapgesturelistener2;
        MapStatus a2 = MapStatus.a(wVar);
        onmapgesturelistener = this.f5900a.u;
        if (onmapgesturelistener == null) {
            return false;
        }
        BaiduMap.mapStatusReason = 1;
        onmapgesturelistener2 = this.f5900a.u;
        return onmapgesturelistener2.onMapDoubleTouch(point, a2);
    }

    @Override // com.baidu.platform.comapi.map.ak
    public void a(GeoPoint geoPoint) {
        BaiduMap.OnMapClickListener onMapClickListener;
        BaiduMap.OnMapClickListener onMapClickListener2;
        onMapClickListener = this.f5900a.v;
        if (onMapClickListener != null) {
            LatLng mc2ll = CoordUtil.mc2ll(geoPoint);
            onMapClickListener2 = this.f5900a.v;
            onMapClickListener2.onMapClick(mc2ll);
        }
    }

    @Override // com.baidu.platform.comapi.map.ak
    public void a(String str) {
        com.baidu.mapsdkplatform.comapi.map.c cVar;
        JSONObject jSONObject;
        List<Overlay> list;
        CopyOnWriteArrayList copyOnWriteArrayList;
        CopyOnWriteArrayList copyOnWriteArrayList2;
        List<Overlay> list2;
        CopyOnWriteArrayList copyOnWriteArrayList3;
        CopyOnWriteArrayList copyOnWriteArrayList4;
        List<Overlay> list3;
        CopyOnWriteArrayList copyOnWriteArrayList5;
        CopyOnWriteArrayList copyOnWriteArrayList6;
        List<Overlay> list4;
        CopyOnWriteArrayList copyOnWriteArrayList7;
        CopyOnWriteArrayList copyOnWriteArrayList8;
        List<Overlay> list5;
        CopyOnWriteArrayList copyOnWriteArrayList9;
        CopyOnWriteArrayList copyOnWriteArrayList10;
        List<Overlay> list6;
        CopyOnWriteArrayList copyOnWriteArrayList11;
        CopyOnWriteArrayList copyOnWriteArrayList12;
        List<Overlay> list7;
        CopyOnWriteArrayList copyOnWriteArrayList13;
        CopyOnWriteArrayList copyOnWriteArrayList14;
        List<Overlay> list8;
        CopyOnWriteArrayList copyOnWriteArrayList15;
        CopyOnWriteArrayList copyOnWriteArrayList16;
        Map map;
        List<Overlay> list9;
        CopyOnWriteArrayList copyOnWriteArrayList17;
        CopyOnWriteArrayList copyOnWriteArrayList18;
        Map map2;
        InfoWindow.OnInfoWindowClickListener onInfoWindowClickListener;
        com.baidu.mapsdkplatform.comapi.map.c cVar2;
        com.baidu.mapsdkplatform.comapi.map.c cVar3;
        com.baidu.mapsdkplatform.comapi.map.c cVar4;
        BaiduMap.OnMyLocationClickListener onMyLocationClickListener;
        BaiduMap.OnMyLocationClickListener onMyLocationClickListener2;
        BaiduMap.OnMapClickListener onMapClickListener;
        BaiduMap.OnMapClickListener onMapClickListener2;
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            cVar = this.f5900a.j;
            GeoPoint b = cVar.b(jSONObject2.optInt("px"), jSONObject2.optInt("py"));
            JSONArray optJSONArray = jSONObject2.optJSONArray("dataset");
            int i = -1;
            if (optJSONArray != null) {
                jSONObject = optJSONArray.optJSONObject(0);
                if (jSONObject != null) {
                    i = jSONObject.optInt("ty");
                }
            } else {
                jSONObject = null;
            }
            if (i == 17) {
                onMapClickListener = this.f5900a.v;
                if (onMapClickListener != null) {
                    MapPoi mapPoi = new MapPoi();
                    mapPoi.a(jSONObject);
                    onMapClickListener2 = this.f5900a.v;
                    onMapClickListener2.onMapPoiClick(mapPoi);
                    return;
                }
                return;
            }
            if (i == 18) {
                onMyLocationClickListener = this.f5900a.J;
                if (onMyLocationClickListener != null) {
                    onMyLocationClickListener2 = this.f5900a.J;
                    onMyLocationClickListener2.onMyLocationClick();
                    return;
                } else {
                    a(b);
                    return;
                }
            }
            if (i == 19) {
                cVar2 = this.f5900a.j;
                if (cVar2 != null) {
                    cVar3 = this.f5900a.j;
                    com.baidu.mapsdkplatform.comapi.map.w E = cVar3.E();
                    if (E == null) {
                        return;
                    }
                    E.c = 0;
                    E.b = 0;
                    BaiduMap.mapStatusReason |= 16;
                    cVar4 = this.f5900a.j;
                    cVar4.a(E, 300);
                    return;
                }
                return;
            }
            String str2 = "";
            if (i == 90909) {
                if (jSONObject != null) {
                    str2 = jSONObject.optString("marker_id");
                }
                map = this.f5900a.W;
                Set<String> keySet = map.keySet();
                if (keySet.isEmpty() || !keySet.contains(str2)) {
                    list9 = this.f5900a.l;
                    for (Overlay overlay : list9) {
                        if ((overlay instanceof Marker) && overlay.K.equals(str2)) {
                            copyOnWriteArrayList17 = this.f5900a.A;
                            if (!copyOnWriteArrayList17.isEmpty()) {
                                copyOnWriteArrayList18 = this.f5900a.A;
                                Iterator it = copyOnWriteArrayList18.iterator();
                                while (it.hasNext()) {
                                    ((BaiduMap.OnMarkerClickListener) it.next()).onMarkerClick((Marker) overlay);
                                }
                                return;
                            }
                            a(b);
                        }
                    }
                    return;
                }
                for (String str3 : keySet) {
                    if (str3 != null && str3.equals(str2)) {
                        map2 = this.f5900a.W;
                        InfoWindow infoWindow = (InfoWindow) map2.get(str3);
                        if (infoWindow != null && (onInfoWindowClickListener = infoWindow.e) != null) {
                            onInfoWindowClickListener.onInfoWindowClick();
                            return;
                        } else {
                            a(b);
                            return;
                        }
                    }
                }
                return;
            }
            if (i == 90910) {
                if (jSONObject != null) {
                    str2 = jSONObject.optString("polyline_id");
                }
                list8 = this.f5900a.l;
                for (Overlay overlay2 : list8) {
                    if ((overlay2 instanceof Polyline) && overlay2.K.equals(str2)) {
                        copyOnWriteArrayList15 = this.f5900a.B;
                        if (!copyOnWriteArrayList15.isEmpty()) {
                            copyOnWriteArrayList16 = this.f5900a.B;
                            Iterator it2 = copyOnWriteArrayList16.iterator();
                            while (it2.hasNext()) {
                                ((BaiduMap.OnPolylineClickListener) it2.next()).onPolylineClick((Polyline) overlay2);
                            }
                        } else {
                            a(b);
                        }
                    }
                }
                return;
            }
            if (i == 90911) {
                if (jSONObject != null) {
                    str2 = jSONObject.optString("multipoint_id");
                }
                list7 = this.f5900a.l;
                for (Overlay overlay3 : list7) {
                    if ((overlay3 instanceof MultiPoint) && overlay3.K.equals(str2)) {
                        copyOnWriteArrayList13 = this.f5900a.C;
                        if (!copyOnWriteArrayList13.isEmpty()) {
                            copyOnWriteArrayList14 = this.f5900a.C;
                            Iterator it3 = copyOnWriteArrayList14.iterator();
                            while (it3.hasNext()) {
                                BaiduMap.OnMultiPointClickListener onMultiPointClickListener = (BaiduMap.OnMultiPointClickListener) it3.next();
                                MultiPoint multiPoint = (MultiPoint) overlay3;
                                List<MultiPointItem> multiPointItems = multiPoint.getMultiPointItems();
                                if (jSONObject != null) {
                                    int optInt = jSONObject.optInt("multipoint_index");
                                    if (multiPointItems != null && optInt >= 0 && multiPointItems.size() > optInt) {
                                        onMultiPointClickListener.onMultiPointClick(multiPoint, multiPointItems.get(optInt));
                                    }
                                }
                            }
                        } else {
                            a(b);
                        }
                    }
                }
                return;
            }
            if (i == 90912) {
                if (jSONObject != null) {
                    str2 = jSONObject.optString("overlay_id");
                }
                list6 = this.f5900a.l;
                for (Overlay overlay4 : list6) {
                    if ((overlay4 instanceof Polygon) && overlay4.K.equals(str2)) {
                        copyOnWriteArrayList11 = this.f5900a.E;
                        if (!copyOnWriteArrayList11.isEmpty()) {
                            copyOnWriteArrayList12 = this.f5900a.E;
                            Iterator it4 = copyOnWriteArrayList12.iterator();
                            while (it4.hasNext()) {
                                BaiduMap.OnPolygonClickListener onPolygonClickListener = (BaiduMap.OnPolygonClickListener) it4.next();
                                if (jSONObject != null && jSONObject.has("hole_clicked_index")) {
                                    ((Polygon) overlay4).p = jSONObject.optInt("hole_clicked_index");
                                }
                                onPolygonClickListener.onPolygonClick((Polygon) overlay4);
                            }
                        } else {
                            a(b);
                        }
                    }
                }
                return;
            }
            if (i == 90914) {
                if (jSONObject != null) {
                    String optString = jSONObject.optString("overlay_id");
                    list5 = this.f5900a.l;
                    for (Overlay overlay5 : list5) {
                        if ((overlay5 instanceof Circle) && overlay5.K.equals(optString)) {
                            copyOnWriteArrayList9 = this.f5900a.D;
                            if (!copyOnWriteArrayList9.isEmpty()) {
                                copyOnWriteArrayList10 = this.f5900a.D;
                                Iterator it5 = copyOnWriteArrayList10.iterator();
                                while (it5.hasNext()) {
                                    BaiduMap.OnCircleClickListener onCircleClickListener = (BaiduMap.OnCircleClickListener) it5.next();
                                    if (jSONObject.has("hole_clicked_index")) {
                                        ((Circle) overlay5).k = jSONObject.optInt("hole_clicked_index");
                                    }
                                    onCircleClickListener.onCircleClick((Circle) overlay5);
                                }
                            }
                        } else {
                            a(b);
                        }
                    }
                    return;
                }
                return;
            }
            if (i == 90915) {
                if (jSONObject != null) {
                    str2 = jSONObject.optString("overlay_id");
                }
                list4 = this.f5900a.l;
                for (Overlay overlay6 : list4) {
                    if ((overlay6 instanceof GroundOverlay) && overlay6.K.equals(str2)) {
                        copyOnWriteArrayList7 = this.f5900a.F;
                        if (!copyOnWriteArrayList7.isEmpty()) {
                            copyOnWriteArrayList8 = this.f5900a.F;
                            Iterator it6 = copyOnWriteArrayList8.iterator();
                            while (it6.hasNext()) {
                                ((BaiduMap.OnGroundOverlayClickListener) it6.next()).onGroundOverlayClick((GroundOverlay) overlay6);
                            }
                        } else {
                            a(b);
                        }
                    }
                }
                return;
            }
            if (i == 90916) {
                if (jSONObject != null) {
                    str2 = jSONObject.optString("overlay_id");
                }
                list3 = this.f5900a.l;
                for (Overlay overlay7 : list3) {
                    if ((overlay7 instanceof Text) && overlay7.K.equals(str2)) {
                        copyOnWriteArrayList5 = this.f5900a.G;
                        if (!copyOnWriteArrayList5.isEmpty()) {
                            copyOnWriteArrayList6 = this.f5900a.G;
                            Iterator it7 = copyOnWriteArrayList6.iterator();
                            while (it7.hasNext()) {
                                ((BaiduMap.OnTextClickListener) it7.next()).onTextClick((Text) overlay7);
                            }
                        } else {
                            a(b);
                        }
                    }
                }
                return;
            }
            if (i == 90917) {
                if (jSONObject != null) {
                    str2 = jSONObject.optString("overlay_id");
                }
                list2 = this.f5900a.l;
                for (Overlay overlay8 : list2) {
                    if ((overlay8 instanceof Arc) && overlay8.K.equals(str2)) {
                        copyOnWriteArrayList3 = this.f5900a.H;
                        if (!copyOnWriteArrayList3.isEmpty()) {
                            copyOnWriteArrayList4 = this.f5900a.H;
                            Iterator it8 = copyOnWriteArrayList4.iterator();
                            while (it8.hasNext()) {
                                ((BaiduMap.OnArcClickListener) it8.next()).onArcClick((Arc) overlay8);
                            }
                        } else {
                            a(b);
                        }
                    }
                }
                return;
            }
            if (i == 90918) {
                if (jSONObject != null) {
                    str2 = jSONObject.optString("overlay_id");
                }
                list = this.f5900a.l;
                for (Overlay overlay9 : list) {
                    if ((overlay9 instanceof Polyline) && overlay9.K.equals(str2)) {
                        copyOnWriteArrayList = this.f5900a.B;
                        if (!copyOnWriteArrayList.isEmpty()) {
                            copyOnWriteArrayList2 = this.f5900a.B;
                            Iterator it9 = copyOnWriteArrayList2.iterator();
                            while (it9.hasNext()) {
                                ((BaiduMap.OnPolylineClickListener) it9.next()).onPolylineClick((Polyline) overlay9);
                            }
                        } else {
                            a(b);
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.baidu.platform.comapi.map.ak
    public void a(GL10 gl10, com.baidu.mapsdkplatform.comapi.map.w wVar) {
        Map map;
        BaiduMap.OnMapDrawFrameCallback onMapDrawFrameCallback;
        BaiduMap.OnMapDrawFrameCallback onMapDrawFrameCallback2;
        Map map2;
        Map map3;
        View view;
        map = this.f5900a.W;
        if (map != null) {
            map2 = this.f5900a.W;
            if (!map2.values().isEmpty()) {
                map3 = this.f5900a.W;
                for (InfoWindow infoWindow : map3.values()) {
                    if (infoWindow != null && (view = infoWindow.c) != null) {
                        view.post(new i(this, infoWindow));
                    }
                }
            }
        }
        onMapDrawFrameCallback = this.f5900a.N;
        if (onMapDrawFrameCallback != null) {
            MapStatus a2 = MapStatus.a(wVar);
            onMapDrawFrameCallback2 = this.f5900a.N;
            onMapDrawFrameCallback2.onMapDrawFrame(a2);
        }
    }

    @Override // com.baidu.platform.comapi.map.ak
    public void a(boolean z) {
        BaiduMap.OnBaseIndoorMapListener onBaseIndoorMapListener;
        BaiduMap.OnBaseIndoorMapListener onBaseIndoorMapListener2;
        onBaseIndoorMapListener = this.f5900a.O;
        if (onBaseIndoorMapListener != null) {
            MapBaseIndoorMapInfo focusedBaseIndoorMapInfo = this.f5900a.getFocusedBaseIndoorMapInfo();
            onBaseIndoorMapListener2 = this.f5900a.O;
            onBaseIndoorMapListener2.onBaseIndoorMapMode(z, focusedBaseIndoorMapInfo);
        }
    }

    @Override // com.baidu.platform.comapi.map.ak
    public void a(boolean z, int i) {
        BaiduMap.OnMapRenderValidDataListener onMapRenderValidDataListener;
        String a2;
        BaiduMap.OnMapRenderValidDataListener onMapRenderValidDataListener2;
        onMapRenderValidDataListener = this.f5900a.P;
        if (onMapRenderValidDataListener != null) {
            a2 = this.f5900a.a(i);
            onMapRenderValidDataListener2 = this.f5900a.P;
            onMapRenderValidDataListener2.onMapRenderValidData(z, i, a2);
        }
    }
}
