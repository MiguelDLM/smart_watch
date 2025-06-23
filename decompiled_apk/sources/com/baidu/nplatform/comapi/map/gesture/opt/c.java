package com.baidu.nplatform.comapi.map.gesture.opt;

import XIXIX.OOXIXo;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.nplatform.comapi.map.gesture.a;
import com.baidu.nplatform.comapi.map.j;

/* loaded from: classes8.dex */
public class c extends a {
    private int b;

    public c(j jVar) {
        super(jVar);
    }

    private void a(double d, com.baidu.nplatform.comapi.basestruct.b bVar) {
        if (d > OOXIXo.f3760XO) {
            bVar.c -= 4;
        } else {
            bVar.c = (int) (bVar.c + 2.0d);
        }
    }

    @Override // com.baidu.nplatform.comapi.map.gesture.opt.a
    public void b(com.baidu.nplatform.comapi.map.gesture.detector.b bVar) {
        this.b = this.f9510a.o().c;
    }

    @Override // com.baidu.nplatform.comapi.map.gesture.opt.a
    public void c(com.baidu.nplatform.comapi.map.gesture.detector.b bVar) {
        a.C0524a c0524a = bVar.b;
        a.C0524a c0524a2 = bVar.c;
        com.baidu.nplatform.comapi.basestruct.b o = this.f9510a.o();
        double d = c0524a2.f9501a.b - c0524a.f9501a.b;
        double d2 = c0524a2.b.b - c0524a.b.b;
        double d3 = d * d2;
        if (d3 > OOXIXo.f3760XO) {
            a(d, o);
        } else if (d3 == OOXIXo.f3760XO) {
            if (d != OOXIXo.f3760XO) {
                a(d, o);
            } else if (d2 != OOXIXo.f3760XO) {
                a(d2, o);
            }
        } else if (Math.abs(d) > Math.abs(d2)) {
            a(d, o);
        } else {
            a(d2, o);
        }
        int i = o.c;
        if (i > 0) {
            o.c = 0;
        } else if (i < -45) {
            o.c = -45;
        }
        this.f9510a.a(o, j.b.eAnimationNone);
    }

    @Override // com.baidu.nplatform.comapi.map.gesture.opt.a
    public void a(com.baidu.nplatform.comapi.map.gesture.detector.b bVar) {
        int i = this.f9510a.o().c;
        int i2 = this.b;
        if (i > i2) {
            LogUtil.e("MapGesture", "OverLookOpt: finish event UP");
            com.baidu.navisdk.comapi.statistics.b.f().d("sst");
        } else if (i < i2) {
            LogUtil.e("MapGesture", "OverLookOpt: finish event DOWN");
            com.baidu.navisdk.comapi.statistics.b.f().d("sxt");
        }
    }
}
