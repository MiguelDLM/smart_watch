package com.baidu.platform.comapi.map;

import com.baidu.platform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes8.dex */
public class af extends i {
    private List<GeoPoint> u;

    public af(ap apVar) {
        super(apVar);
        this.u = new ArrayList();
        this.s = 0;
        this.t = 2;
    }

    private boolean b() {
        synchronized (this.u) {
            try {
                if (this.u.size() < 2) {
                    return false;
                }
                int size = this.u.size();
                this.m = new double[this.u.size() * 3];
                this.l = new double[(this.u.size() * 2) + 5];
                if (c()) {
                    this.l[0] = this.o.getLongitude();
                    this.l[1] = this.o.getLatitude();
                    this.l[2] = this.p.getLongitude();
                    this.l[3] = this.p.getLatitude();
                }
                this.l[4] = 2.0d;
                for (int i = 0; i < size; i++) {
                    if (i == 0) {
                        this.l[5] = this.u.get(0).getLongitude();
                        this.l[6] = this.u.get(0).getLatitude();
                    } else {
                        int i2 = i * 2;
                        int i3 = i - 1;
                        this.l[i2 + 5] = this.u.get(i).getLongitude() - this.u.get(i3).getLongitude();
                        this.l[i2 + 6] = this.u.get(i).getLatitude() - this.u.get(i3).getLatitude();
                    }
                    int i4 = i * 3;
                    this.m[i4] = this.u.get(i).getLongitude();
                    this.m[i4 + 1] = this.u.get(i).getLatitude();
                    this.m[i4 + 2] = 0.0d;
                }
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private boolean c() {
        synchronized (this.u) {
            try {
                if (this.u.size() < 2) {
                    return false;
                }
                this.o.setLatitude(this.u.get(0).getLatitude());
                this.o.setLongitude(this.u.get(0).getLongitude());
                this.p.setLatitude(this.u.get(0).getLatitude());
                this.p.setLongitude(this.u.get(0).getLongitude());
                for (GeoPoint geoPoint : this.u) {
                    if (this.o.getLatitude() >= geoPoint.getLatitude()) {
                        this.o.setLatitude(geoPoint.getLatitude());
                    }
                    if (this.o.getLongitude() >= geoPoint.getLongitude()) {
                        this.o.setLongitude(geoPoint.getLongitude());
                    }
                    if (this.p.getLatitude() <= geoPoint.getLatitude()) {
                        this.p.setLatitude(geoPoint.getLatitude());
                    }
                    if (this.p.getLongitude() <= geoPoint.getLongitude()) {
                        this.p.setLongitude(geoPoint.getLongitude());
                    }
                }
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void a(List<GeoPoint> list) {
        if (list != null) {
            if (list.size() >= 2) {
                synchronized (this.u) {
                    this.u.clear();
                    this.u.addAll(list);
                    this.q = true;
                }
                return;
            }
            throw new IllegalArgumentException("points count can not be less than two!");
        }
        throw new IllegalArgumentException("points list can not be null!");
    }

    public void a(int[] iArr) {
        if (iArr == null || iArr.length == 0) {
            return;
        }
        this.n = iArr;
    }

    public void a(boolean z) {
        this.g = z;
    }

    public void a(ap apVar) {
        this.f9663a = apVar;
    }

    @Override // com.baidu.platform.comapi.map.i
    public String a() {
        String a2;
        synchronized (this.u) {
            try {
                if (this.q) {
                    this.q = !b();
                }
                a2 = a(this.s);
            } catch (Throwable th) {
                throw th;
            }
        }
        return a2;
    }
}
