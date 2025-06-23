package com.baidu.platform.comapi.map.b.b;

import XIXIX.OOXIXo;
import android.graphics.Point;
import android.util.Pair;
import android.view.MotionEvent;
import com.baidu.mapsdkplatform.comapi.map.w;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.platform.comapi.map.MapStatus;
import com.baidu.platform.comapi.map.ak;
import com.baidu.platform.comapi.map.b.a;
import java.util.List;

/* loaded from: classes8.dex */
public class c extends a {
    private boolean b;
    private long c;
    private MapController d;

    public c(MapController mapController) {
        super(mapController);
        this.b = true;
        this.d = mapController;
    }

    @Override // com.baidu.platform.comapi.map.b.b.a
    public void a(com.baidu.platform.comapi.map.b.a.b bVar, MotionEvent motionEvent) {
        a.C0527a c0527a = bVar.b;
        a.C0527a c0527a2 = bVar.c;
        MapStatus mapStatus = this.d.getMapStatus();
        double d = c0527a2.f9642a.b - c0527a.f9642a.b;
        double d2 = c0527a2.b.b - c0527a.b.b;
        double d3 = d * d2;
        if (d3 > OOXIXo.f3760XO) {
            a(d, mapStatus);
        } else if (d3 == OOXIXo.f3760XO) {
            if (d != OOXIXo.f3760XO) {
                a(d, mapStatus);
            } else if (d2 != OOXIXo.f3760XO) {
                a(d2, mapStatus);
            }
        } else if (Math.abs(d) > Math.abs(d2)) {
            a(d, mapStatus);
        } else {
            a(d2, mapStatus);
        }
        float x = motionEvent.getX(1) - motionEvent.getX(0);
        float y = motionEvent.getY(1) - motionEvent.getY(0);
        Point point = new Point((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
        Point point2 = new Point((int) (motionEvent.getRawX() + x), (int) (motionEvent.getRawY() + y));
        List<ak> listeners = this.d.getListeners();
        if (listeners != null) {
            w mapStatusInner = this.d.getMapStatusInner();
            for (int i = 0; i < listeners.size(); i++) {
                ak akVar = listeners.get(i);
                if (akVar != null && akVar.c(point, point2, mapStatusInner)) {
                    return;
                }
            }
        }
        this.d.setMapStatus(mapStatus);
        if (this.b) {
            this.b = false;
            this.d.getGestureMonitor().d();
        }
    }

    @Override // com.baidu.platform.comapi.map.b.b.a
    public void a(com.baidu.platform.comapi.map.b.a.b bVar, Pair<a.d, a.d> pair) {
        MapStatus mapStatus = this.d.getMapStatus();
        if (mapStatus.bOverlookSpringback) {
            if (mapStatus.overlooking > 0) {
                mapStatus.overlooking = 0;
            } else {
                mapStatus.overlooking = mapStatus.minOverlooking;
            }
            this.d.setMapStatusWithAnimation(mapStatus, 200);
        }
    }

    private void a(double d, MapStatus mapStatus) {
        if (this.c == 0) {
            this.c = System.currentTimeMillis();
        }
        this.c = System.currentTimeMillis();
        if (0 > 50 || Math.abs(d) < 4.0d) {
            return;
        }
        if (d > OOXIXo.f3760XO) {
            mapStatus.overlooking -= 4;
        } else {
            mapStatus.overlooking = (int) (mapStatus.overlooking + 2.0d);
        }
    }
}
