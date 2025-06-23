package com.baidu.navisdk.model;

import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import com.baidu.navisdk.cmdrequest.i;
import com.baidu.navisdk.cmdrequest.j;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.framework.message.a;
import com.baidu.navisdk.framework.message.bean.r;
import com.baidu.navisdk.model.datastruct.f;
import com.baidu.navisdk.model.datastruct.g;
import com.baidu.navisdk.util.common.x;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public class a {
    private f b;
    private f d;
    private g f;
    private boolean h;
    private final a.InterfaceC0201a k;

    /* renamed from: a, reason: collision with root package name */
    private long f6897a = -1;
    private f c = null;
    public g e = null;
    private Boolean g = Boolean.FALSE;
    private final List<c> i = new ArrayList();
    private final com.baidu.navisdk.util.worker.loop.a j = new HandlerC0207a("GLM");

    /* renamed from: com.baidu.navisdk.model.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class HandlerC0207a extends com.baidu.navisdk.util.worker.loop.a {
        public HandlerC0207a(String str) {
            super(str);
        }

        @Override // com.baidu.navisdk.util.worker.loop.a
        public void onMessage(Message message) {
            if (message.what == 1003) {
                synchronized (a.this.g) {
                    a.this.g = Boolean.FALSE;
                }
                if (message.arg1 == 0) {
                    j jVar = (j) message.obj;
                    i iVar = jVar.f6695a;
                    Bundle bundle = (Bundle) jVar.b;
                    int i = bundle.getInt("city");
                    int i2 = bundle.getInt("provice");
                    f a2 = com.baidu.navisdk.poisearch.c.a(i);
                    f a3 = com.baidu.navisdk.poisearch.c.a(i2);
                    if (a2 != null) {
                        a.this.h = true;
                        a.this.c = a2;
                        f fVar = a.this.c;
                        a aVar = a.this;
                        fVar.c = aVar.a(aVar.c.c);
                        BNSettingManager.setDistrictId(a.this.c.b);
                        BNSettingManager.setDistrictName(a.this.c.c);
                        a.this.b = a3;
                        a.this.a(a2, a3);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements a.InterfaceC0201a {
        public b() {
        }

        @Override // com.baidu.navisdk.framework.message.a.InterfaceC0201a
        public void onEvent(Object obj) {
            if (obj instanceof r) {
                r rVar = (r) obj;
                a.this.a(rVar.b, rVar.c, rVar.d);
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface c {
        void a(f fVar, f fVar2);
    }

    /* loaded from: classes7.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        private static final a f6900a = new a();
    }

    public a() {
        b bVar = new b();
        this.k = bVar;
        com.baidu.navisdk.framework.message.a.a().a(bVar, r.class, new Class[0]);
    }

    public static a g() {
        return d.f6900a;
    }

    public int c() {
        f fVar = this.c;
        if (fVar != null) {
            return fVar.b;
        }
        return Integer.MIN_VALUE;
    }

    public f d() {
        f fVar = this.c;
        if (fVar == null) {
            int districtId = BNSettingManager.getDistrictId();
            String districtName = BNSettingManager.getDistrictName();
            f fVar2 = new f();
            fVar2.b = districtId;
            fVar2.c = districtName;
            fVar2.f6925a = 3;
            return fVar2;
        }
        return fVar;
    }

    public GeoPoint e() {
        g gVar = this.e;
        if (gVar != null && gVar.b()) {
            GeoPoint geoPoint = new GeoPoint();
            geoPoint.setLatitudeE6((int) (this.e.f6926a * 100000.0d));
            geoPoint.setLongitudeE6((int) (this.e.b * 100000.0d));
            return geoPoint;
        }
        return null;
    }

    public g f() {
        return this.e;
    }

    public String b() {
        f fVar = this.d;
        if (fVar == null) {
            fVar = d();
        }
        if (fVar != null) {
            return a(fVar.c);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(f fVar, f fVar2) {
        for (int i = 0; i < this.i.size(); i++) {
            c cVar = this.i.get(i);
            if (cVar != null) {
                cVar.a(fVar, fVar2);
            }
        }
        this.i.clear();
    }

    public void a(g gVar) {
        g gVar2;
        if (gVar != null) {
            synchronized (this) {
                this.e = gVar;
                System.currentTimeMillis();
            }
            if (x.t()) {
                return;
            }
            if (this.c == null) {
                if (!com.baidu.navisdk.j.d() || this.f6897a < 0 || SystemClock.elapsedRealtime() - this.f6897a > 300000) {
                    this.f6897a = SystemClock.elapsedRealtime();
                    a();
                    return;
                }
                return;
            }
            g gVar3 = this.f;
            if (gVar3 == null || !gVar3.b() || (gVar2 = this.e) == null || !gVar2.b() || a(this.f, this.e)) {
                return;
            }
            a();
        }
    }

    public boolean a(g gVar, g gVar2) {
        double d2 = (gVar.b * 100000.0d) - (gVar2.b * 100000.0d);
        double d3 = (gVar.f6926a * 100000.0d) - (gVar2.f6926a * 100000.0d);
        return Math.sqrt((d2 * d2) + (d3 * d3)) <= 10000.0d;
    }

    public boolean a(GeoPoint geoPoint, GeoPoint geoPoint2) {
        int longitudeE6 = geoPoint.getLongitudeE6() - geoPoint2.getLongitudeE6();
        int latitudeE6 = geoPoint.getLatitudeE6() - geoPoint2.getLatitudeE6();
        return Math.sqrt((double) ((longitudeE6 * longitudeE6) + (latitudeE6 * latitudeE6))) <= 10000.0d;
    }

    public void a(GeoPoint geoPoint, f fVar, f fVar2) {
        if (a(geoPoint, e())) {
            this.c = fVar;
        }
    }

    public boolean a() {
        g gVar = this.e;
        if (gVar == null || !gVar.b()) {
            return true;
        }
        synchronized (this.g) {
            try {
                if (this.g.booleanValue()) {
                    return false;
                }
                if (com.baidu.navisdk.poisearch.c.a(this.e.c(), 10000, this.j)) {
                    this.g = Boolean.TRUE;
                }
                this.f = this.e;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str) {
        return str == null ? str : str.equals("澳门特别行政区") ? "澳门" : str.equals("香港特别行政区") ? "香港" : str.equals("北京市") ? "北京" : str.equals("重庆市") ? "重庆" : str.equals("上海市") ? "上海" : str.equals("天津市") ? "天津" : str.equals("深圳市") ? "深圳" : str.equals("广西壮族自治区") ? "广西" : str.equals("内蒙古自治区") ? "内蒙古" : str.equals("宁夏回族自治区") ? "宁夏" : str.equals("青海省") ? "青海" : str.equals("西藏自治区") ? "西藏" : str.equals("新疆维吾尔自治区") ? "新疆" : str;
    }
}
