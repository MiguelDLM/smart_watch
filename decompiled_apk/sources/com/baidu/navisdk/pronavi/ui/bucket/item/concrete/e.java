package com.baidu.navisdk.pronavi.ui.bucket.item.concrete;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes7.dex */
public final class e extends com.baidu.navisdk.pronavi.ui.bucket.item.a {
    private com.baidu.navisdk.pronavi.ui.buttoncollect.fixed.c f;

    public e(@oOoXoXO com.baidu.navisdk.pronavi.ui.base.b bVar, @oOoXoXO com.baidu.navisdk.pronavi.ui.bucket.config.d dVar) {
        super(bVar, dVar);
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    @oOoXoXO
    public View a(@OOXIXo ViewGroup parentView, int i, @OOXIXo Context context) {
        IIX0o.x0xO0oo(parentView, "parentView");
        IIX0o.x0xO0oo(context, "context");
        com.baidu.navisdk.pronavi.ui.base.b uiContext = this.f7853a;
        IIX0o.oO(uiContext, "uiContext");
        com.baidu.navisdk.pronavi.ui.buttoncollect.fixed.c cVar = new com.baidu.navisdk.pronavi.ui.buttoncollect.fixed.c(uiContext, null);
        this.f = cVar;
        View a2 = cVar.a(context, parentView, i);
        com.baidu.navisdk.pronavi.ui.buttoncollect.fixed.c cVar2 = this.f;
        if (cVar2 != null) {
            com.baidu.navisdk.ui.routeguide.b V = com.baidu.navisdk.ui.routeguide.b.V();
            IIX0o.oO(V, "BNavigator.getInstance()");
            cVar2.a(V.f());
        }
        return a2;
    }

    public final void b(boolean z) {
        com.baidu.navisdk.pronavi.ui.buttoncollect.fixed.b bVar = (com.baidu.navisdk.pronavi.ui.buttoncollect.fixed.b) this.f7853a.c(com.baidu.navisdk.pronavi.ui.buttoncollect.fixed.b.class);
        if (bVar != null) {
            bVar.a(z);
        }
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public int c(int i) {
        com.baidu.navisdk.ui.routeguide.model.a0 I = com.baidu.navisdk.ui.routeguide.model.a0.I();
        IIX0o.oO(I, "RGSimpleGuideModel.getInstance()");
        if (!I.D() && com.baidu.navisdk.ui.routeguide.b.V().x()) {
            com.baidu.navisdk.pronavi.ui.base.b uiContext = this.f7853a;
            IIX0o.oO(uiContext, "uiContext");
            if (uiContext.N()) {
                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
                if (gVar.d()) {
                    gVar.e(d(), "getVisibility: isShowXDVoicePanel");
                }
                return 8;
            }
            return 0;
        }
        com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar2.d()) {
            gVar2.e(d(), "is yawing: ");
        }
        return 8;
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public boolean o() {
        return true;
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a, com.baidu.navisdk.ui.widget.bucket.BNBucketItem
    public void onDestroy() {
        super.onDestroy();
        com.baidu.navisdk.pronavi.ui.buttoncollect.fixed.c cVar = this.f;
        if (cVar != null) {
            cVar.o0();
        }
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a, com.baidu.navisdk.ui.widget.bucket.BNBucketItem
    public void onRefreshViewStyle(int i) {
        super.onRefreshViewStyle(i);
        com.baidu.navisdk.pronavi.ui.buttoncollect.fixed.c cVar = this.f;
        if (cVar != null) {
            cVar.v(i);
        }
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    @OOXIXo
    public String[] r() {
        return new String[]{RGFSMTable.FsmState.Voice, RGFSMTable.FsmState.NaviReady, RGFSMTable.FsmState.NearbySearch, RGFSMTable.FsmState.DynamicLayer, RGFSMTable.FsmState.ArriveDest, RGFSMTable.FsmState.IndoorPark, RGFSMTable.FsmState.IndoorParkBrowse, RGFSMTable.FsmState.IndoorParkChoose};
    }

    public final void v() {
        com.baidu.navisdk.framework.lifecycle.b<Integer> f;
        com.baidu.navisdk.pronavi.ui.buttoncollect.fixed.b bVar = (com.baidu.navisdk.pronavi.ui.buttoncollect.fixed.b) this.f7853a.c(com.baidu.navisdk.pronavi.ui.buttoncollect.fixed.b.class);
        if (bVar != null && (f = bVar.f()) != null) {
            f.setValue(8);
        }
    }

    public final void w() {
        com.baidu.navisdk.pronavi.ui.buttoncollect.fixed.b bVar = (com.baidu.navisdk.pronavi.ui.buttoncollect.fixed.b) this.f7853a.c(com.baidu.navisdk.pronavi.ui.buttoncollect.fixed.b.class);
        if (bVar != null) {
            bVar.k();
        }
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public void a(@oOoXoXO String str, @oOoXoXO String str2) {
        super.a(str, str2);
        com.baidu.navisdk.pronavi.ui.buttoncollect.fixed.c cVar = this.f;
        if (cVar != null) {
            cVar.a(str, str2);
        }
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    @oOoXoXO
    public View a() {
        com.baidu.navisdk.pronavi.ui.buttoncollect.fixed.c cVar = this.f;
        if (cVar != null) {
            return cVar.n0();
        }
        return null;
    }
}
