package com.baidu.navisdk.pronavi.logic.base;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.os.Message;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.pageframe.logic.BNLogicService;
import com.baidu.navisdk.pronavi.logic.base.a;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.worker.loop.d;
import com.baidu.navisdk.vi.b;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes7.dex */
public abstract class RGBaseLogicService<C extends com.baidu.navisdk.pronavi.logic.base.a> extends BNLogicService<C> {
    private d k;
    private com.baidu.navisdk.comapi.routeplan.v2.a l;

    /* loaded from: classes7.dex */
    public static final class a extends d {
        final /* synthetic */ int[] b;

        public a(int[] iArr) {
            this.b = iArr;
        }

        @Override // com.baidu.navisdk.comapi.base.d
        public void careAbout() {
            observe(this.b);
        }

        @Override // com.baidu.navisdk.util.worker.loop.d
        public void onMessage(@oOoXoXO Message message) {
            if (message != null) {
                RGBaseLogicService.this.c(message);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RGBaseLogicService(@OOXIXo C context) {
        super(context);
        IIX0o.x0xO0oo(context, "context");
    }

    private final void a(int[] iArr) {
        if (iArr != null && iArr.length != 0) {
            if (this.k == null) {
                this.k = new a(iArr);
            }
            b.a(this.k);
        }
    }

    public void c(@OOXIXo Message msg) {
        IIX0o.x0xO0oo(msg, "msg");
        g gVar = g.F_BASE;
        if (gVar.d()) {
            gVar.e(this.g, "handleRouteGuideMsg:" + msg.what + ',' + msg.arg1 + ',' + msg.arg2);
        }
    }

    @Override // com.baidu.navisdk.pageframe.logic.BNLogicService, com.baidu.navisdk.logicframe.LogicService, com.baidu.navisdk.framework.func.BaseFunc
    public void g() {
        g gVar = g.F_BASE;
        if (gVar.d()) {
            gVar.e(this.g, "onCreate");
        }
        a(p());
        com.baidu.navisdk.comapi.routeplan.v2.a q = q();
        this.l = q;
        if (q != null) {
            BNRoutePlaner.getInstance().a(this.l, true);
        }
    }

    @Override // com.baidu.navisdk.pageframe.logic.BNLogicService, com.baidu.navisdk.logicframe.LogicService, com.baidu.navisdk.framework.func.BaseFunc
    public void h() {
        g gVar = g.F_BASE;
        if (gVar.d()) {
            gVar.e(this.g, "onDestroy");
        }
        d dVar = this.k;
        if (dVar != null) {
            b.b(dVar);
        }
        if (this.l != null) {
            BNRoutePlaner.getInstance().b(this.l);
        }
    }

    @oOoXoXO
    public int[] p() {
        return null;
    }

    @oOoXoXO
    public com.baidu.navisdk.comapi.routeplan.v2.a q() {
        return null;
    }
}
