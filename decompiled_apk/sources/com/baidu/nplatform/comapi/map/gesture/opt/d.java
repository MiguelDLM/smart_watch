package com.baidu.nplatform.comapi.map.gesture.opt;

import XIXIX.OOXIXo;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.nplatform.comapi.map.gesture.a;
import com.baidu.nplatform.comapi.map.j;

/* loaded from: classes8.dex */
public class d extends a {
    public static boolean l = false;
    private GeoPoint b;
    private int c;
    private float d;
    private a.c e;
    private a.c f;
    private com.baidu.nplatform.comapi.map.gesture.detector.b g;
    private boolean h;
    private double i;
    private int j;
    private float k;

    public d(j jVar) {
        super(jVar);
        this.h = false;
        this.i = OOXIXo.f3760XO;
    }

    private void a(com.baidu.nplatform.comapi.basestruct.b bVar) {
        if (bVar == null || this.b == null) {
            return;
        }
        if (Math.abs(this.f.c.f9504a) > OOXIXo.f3760XO || Math.abs(this.f.c.b) > OOXIXo.f3760XO) {
            bVar.d = this.b.getLongitudeE6();
            bVar.e = this.b.getLatitudeE6();
            a.b a2 = this.g.c.a();
            int i = this.f9510a.o().g.b - this.f9510a.o().g.f9476a;
            int i2 = this.f9510a.o().g.d - this.f9510a.o().g.c;
            bVar.i = (long) (a2.f9502a - (i / 2));
            bVar.j = ((long) (a2.b - (i2 / 2))) * (-1);
        }
    }

    @Override // com.baidu.nplatform.comapi.map.gesture.opt.a
    public void b(com.baidu.nplatform.comapi.map.gesture.detector.b bVar) {
        com.baidu.nplatform.comapi.basestruct.b o;
        if (this.f9510a.p() == null || (o = this.f9510a.o()) == null) {
            return;
        }
        a.b a2 = bVar.f9509a.a();
        this.b = this.f9510a.e((int) a2.f9502a, (int) a2.b);
        float l2 = this.f9510a.l();
        this.d = l2;
        int i = (int) o.b;
        this.c = i;
        this.k = l2;
        this.j = i;
        this.i = OOXIXo.f3760XO;
    }

    @Override // com.baidu.nplatform.comapi.map.gesture.opt.a
    public void c(com.baidu.nplatform.comapi.map.gesture.detector.b bVar) {
        this.g = bVar;
        this.e = new a.c(bVar.f9509a, bVar.c);
        this.f = new a.c(bVar.b, bVar.c);
        com.baidu.nplatform.comapi.basestruct.b o = this.f9510a.o();
        if (o == null) {
            return;
        }
        c(o);
        if (this.f9510a.j() && this.f9510a.m() != j.c.STREET) {
            a(o);
            b(o);
        }
        LogUtil.e("dingbbinpage", "zoomrotateopt perform level is " + o.f9474a);
        LogUtil.e("mytestmapStatus", o.f9474a + "");
        this.f9510a.a(o, j.b.eAnimationNone);
        l = true;
        this.f9510a.v();
        l = false;
    }

    @Override // com.baidu.nplatform.comapi.map.gesture.opt.a
    public void a(com.baidu.nplatform.comapi.map.gesture.detector.b bVar) {
        double d;
        double d2;
        this.h = false;
        if (this.f9510a.p() == null || this.f9510a.o() == null) {
            return;
        }
        int x = (int) bVar.d.getX();
        int y = (int) bVar.d.getY();
        if (x < 0) {
            x = 0;
        }
        int i = y >= 0 ? y : 0;
        GeoPoint e = this.f9510a.e((this.f9510a.o().g.b - this.f9510a.o().g.f9476a) / 2, (this.f9510a.o().g.d - this.f9510a.o().g.c) / 2);
        if (e != null) {
            d = e.getLongitudeE6();
            d2 = e.getLatitudeE6();
        } else {
            d = 0.0d;
            d2 = 0.0d;
        }
        this.f9510a.a(5, 1, (i << 16) | x, 0, 0, d, d2, OOXIXo.f3760XO, OOXIXo.f3760XO);
        if (this.j != this.c) {
            com.baidu.navisdk.comapi.statistics.b.f().d("sx");
        }
        float f = this.k;
        float f2 = this.d;
        if (f - f2 > 0.5d) {
            com.baidu.navisdk.comapi.statistics.b.f().a((int) this.k);
            com.baidu.navisdk.comapi.statistics.b.f().d("gb");
        } else if (f2 - f > 0.5d) {
            com.baidu.navisdk.comapi.statistics.b.f().a((int) this.k);
            com.baidu.navisdk.comapi.statistics.b.f().d("gs");
        }
    }

    private void b(com.baidu.nplatform.comapi.basestruct.b bVar) {
        if (bVar == null) {
            return;
        }
        com.baidu.nplatform.comapi.map.gesture.detector.b bVar2 = this.g;
        double abs = Math.abs(new a.c(new a.C0524a(bVar2.b.f9501a, bVar2.c.f9501a), this.g.b).f9503a);
        com.baidu.nplatform.comapi.map.gesture.detector.b bVar3 = this.g;
        double abs2 = Math.abs(new a.c(new a.C0524a(bVar3.b.b, bVar3.c.b), this.g.b).f9503a);
        double d = this.i;
        if (d == OOXIXo.f3760XO || d * this.f.b >= OOXIXo.f3760XO) {
            if (this.h) {
                float f = (float) ((this.c + this.e.f9503a) % 360.0d);
                bVar.b = f;
                this.j = (int) f;
            } else {
                double d2 = this.f.b;
                boolean z = false;
                boolean z2 = (d2 < 1.0d && abs > 60.0d) || (d2 > 1.0d && Math.abs(abs - 180.0d) > 60.0d);
                double d3 = this.f.b;
                if ((d3 > 1.0d && abs2 > 60.0d) || (d3 < 1.0d && Math.abs(abs2 - 180.0d) > 60.0d)) {
                    z = true;
                }
                if ((z2 || z) && Math.abs(this.e.f9503a) > 10.0d) {
                    this.h = true;
                    this.c = (int) (this.c - this.e.f9503a);
                }
            }
            this.i = this.f.b;
        }
    }

    private void c(com.baidu.nplatform.comapi.basestruct.b bVar) {
        double log = Math.log(2.0d);
        if (log > 1.0E-7d || log < -1.0E-7d) {
            float log2 = this.d + ((float) (Math.log(this.e.b) / log));
            bVar.f9474a = log2;
            this.k = log2;
        }
    }
}
