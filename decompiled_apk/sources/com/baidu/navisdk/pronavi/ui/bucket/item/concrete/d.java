package com.baidu.navisdk.pronavi.ui.bucket.item.concrete;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes7.dex */
public final class d extends com.baidu.navisdk.pronavi.ui.bucket.item.a {
    private com.baidu.navisdk.pronavi.ui.buttoncollect.dynamic.c f;
    private int g;

    /* loaded from: classes7.dex */
    public static final class a<T> implements Observer<Integer> {
        public a(LifecycleOwner lifecycleOwner) {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(Integer it) {
            d dVar = d.this;
            IIX0o.oO(it, "it");
            dVar.g = it.intValue();
            d.this.refreshVisible();
        }
    }

    public d(@oOoXoXO com.baidu.navisdk.pronavi.ui.base.b bVar, @oOoXoXO com.baidu.navisdk.pronavi.ui.bucket.config.d dVar) {
        super(bVar, dVar);
        this.g = 8;
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public int c(int i) {
        com.baidu.navisdk.ui.routeguide.model.a0 I = com.baidu.navisdk.ui.routeguide.model.a0.I();
        IIX0o.oO(I, "RGSimpleGuideModel.getInstance()");
        if (I.D() || !com.baidu.navisdk.ui.routeguide.b.V().x()) {
            return 8;
        }
        com.baidu.navisdk.pronavi.ui.base.b uiContext = this.f7853a;
        IIX0o.oO(uiContext, "uiContext");
        if (uiContext.N()) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e(d(), "getVisibility: isShowXDVoicePanel");
            }
            return 8;
        }
        return this.g;
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public boolean n() {
        return true;
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a, com.baidu.navisdk.ui.widget.bucket.BNBucketItem
    public void onDestroy() {
        super.onDestroy();
        com.baidu.navisdk.pronavi.ui.buttoncollect.dynamic.c cVar = this.f;
        if (cVar != null) {
            cVar.p0();
        }
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a, com.baidu.navisdk.ui.widget.bucket.BNBucketItem
    public void onRefreshViewStyle(int i) {
        super.onRefreshViewStyle(i);
        com.baidu.navisdk.pronavi.ui.buttoncollect.dynamic.c cVar = this.f;
        if (cVar != null) {
            cVar.v(i);
        }
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    @OOXIXo
    public String[] r() {
        return new String[]{RGFSMTable.FsmState.Voice, RGFSMTable.FsmState.ArriveDest, RGFSMTable.FsmState.NaviReady, RGFSMTable.FsmState.IndoorPark, RGFSMTable.FsmState.IndoorParkBrowse, RGFSMTable.FsmState.IndoorParkChoose, RGFSMTable.FsmState.NearbySearch, RGFSMTable.FsmState.DynamicLayer};
    }

    public final boolean v() {
        com.baidu.navisdk.pronavi.ui.buttoncollect.dynamic.c cVar = this.f;
        if (cVar != null && cVar.n0()) {
            return true;
        }
        return false;
    }

    public final boolean w() {
        com.baidu.navisdk.pronavi.ui.buttoncollect.dynamic.c cVar = this.f;
        if (cVar != null && cVar.o0()) {
            return true;
        }
        return false;
    }

    public final void x() {
        com.baidu.navisdk.pronavi.ui.buttoncollect.dynamic.b bVar;
        com.baidu.navisdk.pronavi.ui.base.b bVar2 = this.f7853a;
        if (bVar2 != null && (bVar = (com.baidu.navisdk.pronavi.ui.buttoncollect.dynamic.b) bVar2.c(com.baidu.navisdk.pronavi.ui.buttoncollect.dynamic.b.class)) != null) {
            bVar.e();
        }
    }

    public final void y() {
        com.baidu.navisdk.pronavi.ui.buttoncollect.dynamic.c cVar = this.f;
        if (cVar != null) {
            cVar.q0();
        }
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    @oOoXoXO
    public View a(@OOXIXo ViewGroup parentView, int i, @OOXIXo Context context) {
        IIX0o.x0xO0oo(parentView, "parentView");
        IIX0o.x0xO0oo(context, "context");
        com.baidu.navisdk.pronavi.ui.base.b uiContext = this.f7853a;
        IIX0o.oO(uiContext, "uiContext");
        com.baidu.navisdk.pronavi.ui.buttoncollect.dynamic.c cVar = new com.baidu.navisdk.pronavi.ui.buttoncollect.dynamic.c(uiContext, null);
        this.f = cVar;
        View a2 = cVar.a(context, parentView, i);
        com.baidu.navisdk.ui.routeguide.b V = com.baidu.navisdk.ui.routeguide.b.V();
        IIX0o.oO(V, "BNavigator.getInstance()");
        LifecycleOwner f = V.f();
        com.baidu.navisdk.pronavi.ui.buttoncollect.dynamic.c cVar2 = this.f;
        if (cVar2 != null) {
            cVar2.a(f);
        }
        return a2;
    }

    public final void a(@oOoXoXO LifecycleOwner lifecycleOwner) {
        com.baidu.navisdk.pronavi.ui.base.b bVar = this.f7853a;
        com.baidu.navisdk.pronavi.ui.buttoncollect.dynamic.b bVar2 = bVar != null ? (com.baidu.navisdk.pronavi.ui.buttoncollect.dynamic.b) bVar.c(com.baidu.navisdk.pronavi.ui.buttoncollect.dynamic.b.class) : null;
        if (bVar2 != null) {
            com.baidu.navisdk.pronavi.ui.buttoncollect.dynamic.b bVar3 = lifecycleOwner != null ? bVar2 : null;
            if (bVar3 != null) {
                LiveData<Integer> d = bVar3.d();
                IIX0o.ooOOo0oXI(lifecycleOwner);
                d.observe(lifecycleOwner, new a(lifecycleOwner));
            }
        }
    }
}
