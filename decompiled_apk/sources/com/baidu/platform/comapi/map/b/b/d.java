package com.baidu.platform.comapi.map.b.b;

import XIXIX.OOXIXo;
import android.util.Pair;
import android.view.MotionEvent;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapsdkplatform.comapi.map.w;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.platform.comapi.map.MapStatus;
import com.baidu.platform.comapi.map.MapViewInterface;
import com.baidu.platform.comapi.map.ak;
import com.baidu.platform.comapi.map.b.a;
import com.baidu.platform.comapi.util.SysOSUtil;
import com.garmin.fit.X0xOO;
import com.google.firebase.crashlytics.buildtools.ndk.internal.elf.EMachine;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* loaded from: classes8.dex */
public class d extends a {
    private GeoPoint b;
    private int c;
    private float d;
    private Queue<a.c> e;
    private a.c f;
    private a.c g;
    private boolean h;
    private com.baidu.platform.comapi.map.b.a.b i;
    private boolean j;
    private double k;
    private boolean l;
    private long m;

    public d(MapController mapController) {
        super(mapController);
        this.e = new LinkedList();
        this.h = false;
        this.j = false;
        this.k = OOXIXo.f3760XO;
        this.l = false;
        this.m = 0L;
    }

    private void b(MapStatus mapStatus) {
        MapViewInterface mapView;
        a.b a2;
        Point pixels;
        a.b a3;
        Point pixels2;
        if (this.b != null) {
            if (Math.abs(this.g.c.f9646a) > OOXIXo.f3760XO || Math.abs(this.g.c.b) > OOXIXo.f3760XO) {
                a.b a4 = this.i.f9643a.a();
                a.b a5 = this.i.c.a();
                double d = a5.f9644a;
                double d2 = a4.f9644a;
                double d3 = a5.b;
                double d4 = a4.b;
                double sqrt = Math.sqrt(((d - d2) * (d - d2)) + ((d3 - d4) * (d3 - d4)));
                if ((MapController.isCompass && sqrt < 100.0d) || (mapView = this.f9648a.getMapView()) == null) {
                    return;
                }
                if (!MapController.isCompass && !this.l) {
                    MapController mapController = this.f9648a;
                    if (mapController != null && mapController.getPointGesturesCenter() != null) {
                        android.graphics.Point pointGesturesCenter = this.f9648a.getPointGesturesCenter();
                        if (pointGesturesCenter == null) {
                            return;
                        }
                        this.b = mapView.getProjection().fromPixels(pointGesturesCenter.x, pointGesturesCenter.y);
                        a3 = new a.b(pointGesturesCenter.x, pointGesturesCenter.y);
                    } else {
                        MapController mapController2 = this.f9648a;
                        if (mapController2 != null && mapController2.getLatLngGesturesCenter() != null) {
                            GeoPoint ll2mc = CoordUtil.ll2mc(this.f9648a.getLatLngGesturesCenter());
                            if (ll2mc == null || (pixels2 = this.f9648a.getMapView().getProjection().toPixels(ll2mc, null)) == null) {
                                return;
                            }
                            android.graphics.Point point = new android.graphics.Point(pixels2.getIntX(), pixels2.getIntY());
                            this.b = ll2mc;
                            a3 = new a.b(point.x, point.y);
                        } else {
                            a3 = this.i.c.a();
                        }
                    }
                    if (a3 == null) {
                        return;
                    }
                    mapStatus.centerPtX = this.b.getLongitude();
                    mapStatus.centerPtY = this.b.getLatitude();
                    mapStatus.xOffset = (float) (a3.f9644a - ((mapStatus.winRound.left + (this.f9648a.getScreenWidth() / 2)) + mapStatus.xScreenOffset));
                    mapStatus.yOffset = ((float) (a3.b - ((mapStatus.winRound.top + (this.f9648a.getScreenHeight() / 2)) + mapStatus.yScreenOffset))) * (-1.0f);
                    return;
                }
                this.l = false;
                com.baidu.platform.comapi.util.a.a().a(new com.baidu.platform.comapi.map.a.a());
                MapController mapController3 = this.f9648a;
                if (mapController3 != null && mapController3.getPointGesturesCenter() != null) {
                    if (this.f9648a.getPointGesturesCenter() == null) {
                        return;
                    } else {
                        a2 = new a.b(r11.x, r11.y);
                    }
                } else {
                    MapController mapController4 = this.f9648a;
                    if (mapController4 != null && mapController4.getLatLngGesturesCenter() != null) {
                        GeoPoint ll2mc2 = CoordUtil.ll2mc(this.f9648a.getLatLngGesturesCenter());
                        if (ll2mc2 == null || (pixels = this.f9648a.getMapView().getProjection().toPixels(ll2mc2, null)) == null) {
                            return;
                        }
                        android.graphics.Point point2 = new android.graphics.Point(pixels.getIntX(), pixels.getIntY());
                        this.b = ll2mc2;
                        a2 = new a.b(point2.x, point2.y);
                    } else {
                        a2 = this.i.c.a();
                    }
                }
                if (a2 == null) {
                    return;
                }
                this.b = mapView.getProjection().fromPixels((int) a2.f9644a, (int) a2.b);
            }
        }
    }

    private void c(MapStatus mapStatus) {
        boolean z;
        int i;
        com.baidu.platform.comapi.map.b.a.b bVar = this.i;
        double abs = Math.abs(new a.c(new a.C0527a(bVar.b.f9642a, bVar.c.f9642a), this.i.b).f9645a);
        com.baidu.platform.comapi.map.b.a.b bVar2 = this.i;
        double abs2 = Math.abs(new a.c(new a.C0527a(bVar2.b.b, bVar2.c.b), this.i.b).f9645a);
        double d = this.k;
        if (d != OOXIXo.f3760XO && d * this.g.b < OOXIXo.f3760XO) {
            return;
        }
        if (this.j) {
            mapStatus.rotation = (int) ((this.c + this.f.f9645a) % 360.0d);
        } else {
            double d2 = this.g.b;
            boolean z2 = false;
            if ((d2 < 1.0d && abs > 60.0d) || (d2 > 1.0d && Math.abs(abs - 180.0d) > 60.0d)) {
                z = true;
            } else {
                z = false;
            }
            double d3 = this.g.b;
            if ((d3 > 1.0d && abs2 > 60.0d) || (d3 < 1.0d && Math.abs(abs2 - 180.0d) > 60.0d)) {
                z2 = true;
            }
            if (z || z2) {
                double abs3 = Math.abs(this.f.f9645a);
                if (MapController.isCompass) {
                    i = 30;
                } else {
                    i = 10;
                }
                if (abs3 > i) {
                    this.j = true;
                    this.f9648a.getGestureMonitor().c();
                    this.c = (int) (this.c - this.f.f9645a);
                    if (MapController.isCompass) {
                        this.l = true;
                        com.baidu.platform.comapi.util.a.a().a(new com.baidu.platform.comapi.map.a.a());
                    }
                }
            }
        }
        this.k = this.g.b;
    }

    @Override // com.baidu.platform.comapi.map.b.b.a
    public void a(com.baidu.platform.comapi.map.b.a.b bVar) {
        MapViewInterface mapView = this.f9648a.getMapView();
        if (mapView == null) {
            return;
        }
        MapStatus mapStatus = this.f9648a.getMapStatus();
        a.b a2 = bVar.f9643a.a();
        this.b = mapView.getProjection().fromPixels((int) a2.f9644a, (int) a2.b);
        this.d = this.f9648a.getZoomLevel();
        this.c = mapStatus.rotation;
        this.k = OOXIXo.f3760XO;
    }

    @Override // com.baidu.platform.comapi.map.b.b.a
    public void a(com.baidu.platform.comapi.map.b.a.b bVar, MotionEvent motionEvent) {
        this.i = bVar;
        this.f = new a.c(bVar.f9643a, bVar.c);
        this.g = new a.c(bVar.b, bVar.c);
        List<ak> listeners = this.f9648a.getListeners();
        if (listeners != null) {
            w mapStatusInner = this.f9648a.getMapStatusInner();
            float x = motionEvent.getX(1) - motionEvent.getX(0);
            float y = motionEvent.getY(1) - motionEvent.getY(0);
            android.graphics.Point point = new android.graphics.Point((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
            android.graphics.Point point2 = new android.graphics.Point((int) (motionEvent.getRawX() + x), (int) (motionEvent.getRawY() + y));
            for (int i = 0; i < listeners.size(); i++) {
                ak akVar = listeners.get(i);
                if (akVar != null && akVar.a(point, point2, mapStatusInner)) {
                    return;
                }
            }
        }
        MapStatus mapStatus = this.f9648a.getMapStatus();
        if (this.f9648a.isEnableZoom()) {
            a(mapStatus);
        }
        if (this.f9648a.is3DGestureEnable() && this.f9648a.getMapControlMode() != MapController.MapControlMode.STREET) {
            if (mapStatus.overlooking == 0 && this.f9648a.isCanTouchMove()) {
                b(mapStatus);
            }
            c(mapStatus);
        }
        this.f9648a.setMapStatus(mapStatus);
        if (this.f9648a.isNaviMode() && this.f9648a.getNaviMapViewListener() != null) {
            this.f9648a.getNaviMapViewListener().onAction(520, null);
        }
        this.f9648a.mapStatusChangeStart();
        if (this.e.size() >= 10) {
            this.e.poll();
        }
        this.e.offer(this.g);
        com.baidu.platform.comapi.util.a.a().a(new com.baidu.platform.comapi.map.a.d());
        this.m = System.currentTimeMillis();
    }

    private void a(MapStatus mapStatus) {
        float log = this.d + ((float) (Math.log(this.f.b) / Math.log(2.0d)));
        mapStatus.level = log;
        if (log < 4.0f) {
            log = 4.0f;
        }
        mapStatus.level = log;
        if (log > 22.0f) {
            log = 22.0f;
        }
        mapStatus.level = log;
    }

    @Override // com.baidu.platform.comapi.map.b.b.a
    public void a(com.baidu.platform.comapi.map.b.a.b bVar, Pair<a.d, a.d> pair) {
        double d;
        double d2;
        MapViewInterface mapView = this.f9648a.getMapView();
        if (mapView == null) {
            return;
        }
        MapStatus mapStatus = this.f9648a.getMapStatus();
        int x = (int) bVar.d.getX();
        int y = (int) bVar.d.getY();
        if (x < 0) {
            x = 0;
        }
        if (y < 0) {
            y = 0;
        }
        GeoPoint fromPixels = mapView.getProjection().fromPixels((int) ((this.f9648a.getScreenWidth() / 2) + mapStatus.winRound.left + mapStatus.xScreenOffset), (int) ((this.f9648a.getScreenHeight() / 2) + mapStatus.winRound.top + mapStatus.yScreenOffset));
        if (fromPixels != null) {
            double longitude = fromPixels.getLongitude();
            d2 = fromPixels.getLatitude();
            d = longitude;
        } else {
            d = 0.0d;
            d2 = 0.0d;
        }
        this.f9648a.MapMsgProc(5, 1, (y << 16) | x, 0, 0, d, d2, OOXIXo.f3760XO, OOXIXo.f3760XO);
        this.f9648a.getGestureMonitor().a(this.f9648a.getZoomLevel());
        if (System.currentTimeMillis() - this.m <= 100) {
            MapController mapController = this.f9648a;
            if (mapController.mIsInertialAnimation && mapController.isEnableZoom()) {
                a(this.f9648a.getMapStatus(), bVar, pair);
            }
        }
    }

    private int a() {
        if (!this.j) {
            return 0;
        }
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(this.e);
        if (linkedList.size() < 2) {
            return 0;
        }
        int i = (int) (((a.c) linkedList.get(linkedList.size() - 2)).f9645a * 8.0d);
        if (i >= 180) {
            return EMachine.EM_SLE9X;
        }
        if (i <= -180) {
            return -179;
        }
        return i;
    }

    private void a(MapStatus mapStatus, int i) {
        if (i != 0) {
            mapStatus.rotation = (mapStatus.rotation + i) % 360;
            this.f9648a.setMapStatusWithAnimation(mapStatus, 600);
        }
    }

    public void a(MapStatus mapStatus, com.baidu.platform.comapi.map.b.a.b bVar, Pair<a.d, a.d> pair) {
        double d;
        int i;
        double d2;
        if (pair != null) {
            int a2 = a();
            Object obj = pair.first;
            double d3 = ((a.d) obj).f9646a;
            Object obj2 = pair.second;
            if (d3 * ((a.d) obj2).f9646a > OOXIXo.f3760XO && ((a.d) obj).b * ((a.d) obj2).b > OOXIXo.f3760XO) {
                a(mapStatus, a2);
                return;
            }
            if (Math.abs(((a.d) obj).f9646a - ((a.d) obj2).f9646a) >= 1.0d && Math.abs(((a.d) pair.first).b - ((a.d) pair.second).b) >= 1.0d) {
                double abs = Math.abs(new a.c(new a.C0527a(bVar.b.f9642a, bVar.c.f9642a), bVar.b).f9645a);
                double abs2 = Math.abs(new a.c(new a.C0527a(bVar.b.b, bVar.c.b), bVar.b).f9645a);
                double d4 = this.k;
                if (d4 != OOXIXo.f3760XO && d4 * this.g.b < OOXIXo.f3760XO) {
                    a(mapStatus, a2);
                    return;
                }
                Object obj3 = pair.first;
                double d5 = ((a.d) obj3).f9646a * ((a.d) obj3).f9646a;
                Object obj4 = pair.second;
                float sqrt = ((float) Math.sqrt(d5 + (((a.d) obj4).f9646a * ((a.d) obj4).f9646a) + (((a.d) obj3).b * ((a.d) obj3).b) + (((a.d) obj4).b * ((a.d) obj4).b))) * 2.0f;
                if (sqrt > (SysOSUtil.getInstance().getDensityDPI() * 100) / X0xOO.f13583O0o0) {
                    mapStatus.hasAnimation = 1;
                    mapStatus.animationTime = 600;
                    a.c cVar = null;
                    a.c cVar2 = null;
                    int i2 = 0;
                    int i3 = 0;
                    int i4 = 0;
                    while (i3 < this.e.size()) {
                        a.c poll = this.e.poll();
                        if (poll != null) {
                            if (this.e.isEmpty()) {
                                i = a2;
                                d2 = 1.0d;
                                if (Math.abs(poll.b - 1.0d) < 0.01d) {
                                    a(mapStatus, i);
                                    return;
                                }
                            } else {
                                i = a2;
                                d2 = 1.0d;
                            }
                            if (poll.b > d2) {
                                i4++;
                                cVar2 = poll;
                            } else {
                                i2++;
                                cVar = poll;
                            }
                        } else {
                            i = a2;
                        }
                        i3++;
                        a2 = i;
                    }
                    int i5 = a2;
                    if (i4 >= i2) {
                        cVar = cVar2;
                    }
                    if (cVar != null) {
                        d = 1.0d;
                        if (Math.abs(cVar.b - 1.0d) < 0.01d) {
                            a(mapStatus, i5);
                            return;
                        }
                    } else {
                        d = 1.0d;
                    }
                    double d6 = cVar.b;
                    boolean z = (d6 < d && abs > 60.0d) || (d6 > d && Math.abs(abs - 180.0d) > 60.0d);
                    double d7 = cVar.b;
                    boolean z2 = (d7 > 1.0d && abs2 > 60.0d) || (d7 < 1.0d && Math.abs(abs2 - 180.0d) > 60.0d);
                    if (z || z2) {
                        if (Math.abs(this.f.f9645a) > (MapController.isCompass ? 30 : 15)) {
                            a(mapStatus, i5);
                            return;
                        }
                    }
                    this.h = cVar.b > 1.0d;
                    float densityDPI = sqrt / (800000 / SysOSUtil.getInstance().getDensityDPI());
                    float f = densityDPI <= 2.0f ? densityDPI : 2.0f;
                    if (!this.h) {
                        mapStatus.level -= f;
                    } else {
                        mapStatus.level += f;
                    }
                    float f2 = mapStatus.level;
                    if (f2 < 4.0f) {
                        f2 = 4.0f;
                    }
                    mapStatus.level = f2;
                    if (f2 > 22.0f) {
                        f2 = 22.0f;
                    }
                    mapStatus.level = f2;
                    if (i5 != 0) {
                        mapStatus.rotation = (mapStatus.rotation + i5) % 360;
                    }
                    this.f9648a.setMapStatus(mapStatus);
                    this.f9648a.mIsAnimating = true;
                    return;
                }
                return;
            }
            a(mapStatus, a2);
        }
    }
}
