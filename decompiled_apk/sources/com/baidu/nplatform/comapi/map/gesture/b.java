package com.baidu.nplatform.comapi.map.gesture;

import android.view.MotionEvent;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.nplatform.comapi.map.gesture.detector.a;
import com.baidu.nplatform.comapi.map.j;

/* loaded from: classes8.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private j f9505a;
    private com.baidu.nplatform.comapi.map.gesture.detector.b b;
    a.InterfaceC0525a d = new a();
    private com.baidu.nplatform.comapi.map.gesture.detector.a c = new com.baidu.nplatform.comapi.map.gesture.detector.a(this.d);

    /* loaded from: classes8.dex */
    public class a implements a.InterfaceC0525a {
        public a() {
        }

        @Override // com.baidu.nplatform.comapi.map.gesture.detector.a.InterfaceC0525a
        public boolean a(com.baidu.nplatform.comapi.map.gesture.detector.a aVar) {
            LogUtil.e("MapGesture", "onTwoTouchClick");
            com.baidu.navisdk.comapi.statistics.b.f().a(Math.max((int) (b.this.f9505a.o().f9474a - 1.0f), 3));
            com.baidu.navisdk.comapi.statistics.b.f().d("sd");
            b.this.f9505a.a(8193, 4, 0);
            if (BNMapController.getInstance().getMapController() != null) {
                BNMapController.getInstance().getMapController().v();
                return true;
            }
            return true;
        }
    }

    public b(j jVar) {
        this.f9505a = jVar;
        this.b = new com.baidu.nplatform.comapi.map.gesture.detector.b(new com.baidu.nplatform.comapi.map.gesture.opt.b(jVar));
    }

    public void a(MotionEvent motionEvent) {
        this.b.a(motionEvent);
        this.c.a(motionEvent);
    }
}
