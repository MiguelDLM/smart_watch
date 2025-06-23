package com.baidu.navisdk.pronavi.ui.base;

import android.app.Activity;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.navisdk.apicenter.h;
import com.baidu.navisdk.module.pronavi.model.f;
import com.baidu.navisdk.pronavi.base.logic.RGBaseLogicFrame;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.ui.routeguide.navicenter.c;
import java.lang.ref.WeakReference;

/* loaded from: classes7.dex */
public class b extends com.baidu.navisdk.pronavi.base.a {
    private WeakReference<ViewGroup> t;

    public b(@NonNull Activity activity, @NonNull com.baidu.navisdk.framework.data.a aVar, f fVar, com.baidu.navisdk.ui.routeguide.subview.a aVar2, com.baidu.navisdk.pageframe.store.i.b bVar, ViewGroup viewGroup, RGBaseLogicFrame rGBaseLogicFrame) {
        super(activity, "RGUiContext", aVar, bVar, rGBaseLogicFrame, fVar, aVar2);
        this.t = new WeakReference<>(viewGroup);
    }

    @Nullable
    public ViewGroup G() {
        WeakReference<ViewGroup> weakReference = this.t;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    @Nullable
    public ViewGroup H() {
        return x.b().s0();
    }

    public boolean I() {
        return false;
    }

    public boolean J() {
        return x.b().C2();
    }

    public boolean K() {
        boolean z;
        h a2 = j().e("RGParkingLotListComponent").a(3).a();
        if (a2 != null && a2.b("resultA")) {
            z = true;
        } else {
            z = false;
        }
        h a3 = j().e("RGSaveParkComponent").a(10003).a();
        if (!z && (a3 == null || !a3.b("resultA"))) {
            return false;
        }
        return true;
    }

    public boolean L() {
        h a2;
        if (!RGFSMTable.FsmState.DynamicLayer.equals(RouteGuideFSM.getInstance().getCurrentState()) || (a2 = j().e("RGParkingLotListComponent").a(3).a()) == null || !a2.b("resultA")) {
            return false;
        }
        return true;
    }

    public boolean M() {
        com.baidu.navisdk.framework.interfaces.pronavi.h hVar;
        c j = com.baidu.navisdk.ui.routeguide.b.V().j();
        if (j != null) {
            hVar = j.e();
        } else {
            hVar = null;
        }
        if (hVar != null && hVar.a() == 227) {
            return true;
        }
        return false;
    }

    public boolean N() {
        if (com.baidu.navisdk.ui.routeguide.asr.c.n().f() && x.b().H2()) {
            return true;
        }
        return false;
    }
}
