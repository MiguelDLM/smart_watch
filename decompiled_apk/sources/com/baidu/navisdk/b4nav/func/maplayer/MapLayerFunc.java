package com.baidu.navisdk.b4nav.func.maplayer;

import android.graphics.Rect;
import androidx.lifecycle.Lifecycle;
import com.baidu.navisdk.b4nav.framework.func.CoreFunc;
import com.baidu.navisdk.b4nav.func.maplayer.b;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.framework.func.Func;
import com.baidu.navisdk.util.common.LogUtil;
import com.qq.e.comm.constants.ErrorCode;

/* loaded from: classes7.dex */
public abstract class MapLayerFunc<R extends com.baidu.navisdk.b4nav.func.maplayer.b> extends CoreFunc<R> {
    protected com.baidu.navisdk.b4nav.func.maplayer.a m;
    private final com.baidu.navisdk.util.worker.lite.b n;
    private final com.baidu.navisdk.util.worker.lite.b o;

    /* loaded from: classes7.dex */
    public class a extends com.baidu.navisdk.b4nav.service.rpmsg.c {
        public a() {
        }

        @Override // com.baidu.navisdk.b4nav.service.rpmsg.c
        public String a() {
            return ((Func) MapLayerFunc.this).g;
        }
    }

    /* loaded from: classes7.dex */
    public class b extends com.baidu.navisdk.b4nav.service.rpmsg.c {
        public b() {
        }

        @Override // com.baidu.navisdk.b4nav.service.rpmsg.c
        public String a() {
            return ((Func) MapLayerFunc.this).g;
        }
    }

    /* loaded from: classes7.dex */
    public class c extends com.baidu.navisdk.b4nav.service.rpmsg.c {
        public c() {
        }

        @Override // com.baidu.navisdk.b4nav.service.rpmsg.c
        public String a() {
            return ((Func) MapLayerFunc.this).g;
        }
    }

    /* loaded from: classes7.dex */
    public class d extends com.baidu.navisdk.b4nav.service.rpmsg.c {
        public d() {
        }

        @Override // com.baidu.navisdk.b4nav.service.rpmsg.c
        public String a() {
            return ((Func) MapLayerFunc.this).g;
        }
    }

    /* loaded from: classes7.dex */
    public class e extends com.baidu.navisdk.b4nav.service.rpmsg.c {
        public e() {
        }

        @Override // com.baidu.navisdk.b4nav.service.rpmsg.c
        public String a() {
            return ((Func) MapLayerFunc.this).g;
        }
    }

    /* loaded from: classes7.dex */
    public class f extends com.baidu.navisdk.b4nav.service.rpmsg.c {
        public f() {
        }

        @Override // com.baidu.navisdk.b4nav.service.rpmsg.c
        public String a() {
            return ((Func) MapLayerFunc.this).g;
        }
    }

    /* loaded from: classes7.dex */
    public class g extends com.baidu.navisdk.b4nav.service.rpmsg.c {
        public g() {
        }

        @Override // com.baidu.navisdk.b4nav.service.rpmsg.c
        public String a() {
            return ((Func) MapLayerFunc.this).g;
        }
    }

    /* loaded from: classes7.dex */
    public class h extends com.baidu.navisdk.b4nav.service.rpmsg.c {
        public h() {
        }

        @Override // com.baidu.navisdk.b4nav.service.rpmsg.c
        public String a() {
            return ((Func) MapLayerFunc.this).g;
        }
    }

    private void s() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(this.g, "clearMapRouteLayer!!!");
        }
        com.baidu.navisdk.b4nav.func.maplayer.a aVar = this.m;
        if (aVar == null) {
            return;
        }
        aVar.a();
    }

    private void t() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(this.g, "hideNavRouteLayer!!!");
        }
        BNMapController.getInstance().showCarResultLayer(false);
    }

    private void u() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(this.g, "showMapRouteLayer!!!");
        }
        com.baidu.navisdk.b4nav.func.maplayer.a aVar = this.m;
        if (aVar == null) {
            return;
        }
        aVar.a(a(((com.baidu.navisdk.b4nav.func.maplayer.b) this.j).b()), true);
    }

    private void v() {
        boolean isAtLeast = getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED);
        if (LogUtil.LOGGABLE) {
            LogUtil.e(this.g, "showNavRouteLayer --> isPageExist = " + isAtLeast);
        }
        if (isAtLeast) {
            BNMapController.getInstance().showCarResultLayer(true);
        }
    }

    @Override // com.baidu.navisdk.b4nav.framework.func.CoreFunc, com.baidu.navisdk.logicframe.LogicFunc, com.baidu.navisdk.framework.func.BaseFunc
    public void i() {
        super.i();
    }

    @Override // com.baidu.navisdk.b4nav.framework.func.CoreFunc, com.baidu.navisdk.logicframe.LogicFunc, com.baidu.navisdk.framework.func.BaseFunc
    public void j() {
        super.j();
        this.k.k();
        throw null;
    }

    @Override // com.baidu.navisdk.b4nav.framework.func.CoreFunc, com.baidu.navisdk.logicframe.LogicFunc, com.baidu.navisdk.framework.func.BaseFunc
    public void l() {
        super.l();
    }

    @Override // com.baidu.navisdk.framework.func.Func
    public String o() {
        return "MapLayerFunc";
    }

    public void r() {
        a(1000, new b());
        a(1002, new c());
        a(1003, new d());
        a(1014, new e());
        a(4001, new f());
        a(4007, new g());
        a(ErrorCode.CONTENT_FORCE_EXPOSURE, new h());
        a(4002, new a());
    }

    private Rect a(Rect rect) {
        Rect rect2 = new Rect();
        if (rect != null) {
            rect2.left = rect.left;
            rect2.right = ((com.baidu.navisdk.b4nav.c) this.i).m() - rect.right;
            rect2.top = rect.top;
            rect2.bottom = ((com.baidu.navisdk.b4nav.c) this.i).l() - rect.bottom;
        }
        return rect2;
    }

    @Override // com.baidu.navisdk.b4nav.framework.func.CoreFunc
    public void b(boolean z) {
        super.b(z);
        if (this.m == null) {
            if (com.baidu.navisdk.module.init.a.a()) {
                BNRouteGuider.getInstance().SetFullViewState(false);
            }
            com.baidu.navisdk.util.worker.lite.a.a(this.o);
            com.baidu.navisdk.framework.interfaces.locationshare.a j = com.baidu.navisdk.framework.interfaces.c.p().j();
            if (j != null) {
                j.g();
                return;
            }
            return;
        }
        this.k.k();
        throw null;
    }

    public void c(boolean z) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(this.g, "setMapRouteLayerVisible --> visible = " + z);
        }
        s();
        if (z) {
            u();
        }
    }

    public void d(boolean z) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(this.g, "setNavRouteLayerVisible --> visible = " + z);
        }
        if (z) {
            v();
        } else {
            t();
        }
    }

    @Override // com.baidu.navisdk.b4nav.framework.func.CoreFunc, com.baidu.navisdk.logicframe.LogicFunc, com.baidu.navisdk.framework.func.BaseFunc
    public void g() {
        super.g();
        this.m = (com.baidu.navisdk.b4nav.func.maplayer.a) ((com.baidu.navisdk.b4nav.c) this.i).a(com.baidu.navisdk.b4nav.func.maplayer.a.class);
        r();
    }

    @Override // com.baidu.navisdk.b4nav.framework.func.CoreFunc, com.baidu.navisdk.logicframe.LogicFunc, com.baidu.navisdk.framework.func.BaseFunc
    public void h() {
        super.h();
        com.baidu.navisdk.b4nav.func.maplayer.a aVar = this.m;
        if (aVar != null) {
            aVar.a(false);
        }
        if (com.baidu.navisdk.module.init.a.a() && !((com.baidu.navisdk.b4nav.c) this.i).p()) {
            d(false);
        }
        c(false);
        com.baidu.navisdk.util.worker.lite.a.a(this.n);
        this.m = null;
    }
}
