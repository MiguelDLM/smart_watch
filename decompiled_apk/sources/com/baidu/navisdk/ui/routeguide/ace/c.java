package com.baidu.navisdk.ui.routeguide.ace;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.os.Bundle;
import android.os.Message;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.baidu.navisdk.comapi.mapcontrol.BNDynamicOverlay;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.garmin.fit.OxXXx0X;
import java.util.List;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes8.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final com.baidu.navisdk.module.ace.a f8423a;
    private boolean b;
    private final C0410c c;
    private final b d;
    private final com.baidu.navisdk.ui.routeguide.ace.a e;

    /* loaded from: classes8.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(IIXOooo iIXOooo) {
            this();
        }
    }

    /* loaded from: classes8.dex */
    public static final class b extends com.baidu.navisdk.util.worker.loop.b {
        public b(String str) {
            super(str);
        }

        @Override // com.baidu.navisdk.comapi.base.d
        public void careAbout() {
            observe(OxXXx0X.Xx0OXIoI);
        }

        @Override // com.baidu.navisdk.util.worker.loop.b
        public void onMessage(@oOoXoXO Message message) {
            Integer num;
            if (message != null) {
                num = Integer.valueOf(message.what);
            } else {
                num = null;
            }
            if (num != null && num.intValue() == 4432) {
                c.this.g();
            }
        }
    }

    /* renamed from: com.baidu.navisdk.ui.routeguide.ace.c$c, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C0410c implements Observer<g> {
        public C0410c() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(@oOoXoXO g gVar) {
            if (gVar == null) {
                return;
            }
            if (gVar.b()) {
                c.this.e();
            } else {
                c.this.f();
            }
        }
    }

    static {
        new a(null);
    }

    public c(@OOXIXo com.baidu.navisdk.ui.routeguide.ace.a mData) {
        IIX0o.x0xO0oo(mData, "mData");
        this.e = mData;
        this.f8423a = new com.baidu.navisdk.module.ace.a();
        this.c = new C0410c();
        this.d = new b("RGACEAction");
    }

    private final void a(List<Bundle> list) {
        JNIGuidanceControl jNIGuidanceControl = JNIGuidanceControl.getInstance();
        IIX0o.oO(jNIGuidanceControl, "JNIGuidanceControl.getInstance()");
        int selectRouteIdx = jNIGuidanceControl.getSelectRouteIdx();
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.ACE;
        if (gVar.d()) {
            gVar.e("RGACEAction", "drawAOI(), aoiData = " + list + " index = " + selectRouteIdx);
        }
        if (list == null || selectRouteIdx >= list.size() || selectRouteIdx < 0 || com.baidu.navisdk.module.ace.b.a(list.get(selectRouteIdx)).size() == 0) {
            return;
        }
        this.f8423a.a(com.baidu.navisdk.module.ace.b.a(list.get(selectRouteIdx)));
        BNMapController.getDynamicOverlay().showAll(BNDynamicOverlay.Key.ROUTE_ACE_BUBBLE);
    }

    private final List<Bundle> i() {
        BNRouteGuider bNRouteGuider = BNRouteGuider.getInstance();
        IIX0o.oO(bNRouteGuider, "BNRouteGuider.getInstance()");
        return bNRouteGuider.getDemonstrationAreaInfo();
    }

    public final void b() {
        a(i());
    }

    public final boolean c() {
        JNIGuidanceControl jNIGuidanceControl = JNIGuidanceControl.getInstance();
        IIX0o.oO(jNIGuidanceControl, "JNIGuidanceControl.getInstance()");
        int selectRouteIdx = jNIGuidanceControl.getSelectRouteIdx();
        List<Bundle> i = i();
        if (i != null && selectRouteIdx < i.size() && selectRouteIdx >= 0 && com.baidu.navisdk.module.ace.b.a(i.get(selectRouteIdx)).size() != 0) {
            return true;
        }
        return false;
    }

    public final void d() {
        if (this.e.i()) {
            return;
        }
        MutableLiveData<g> g = this.e.g();
        com.baidu.navisdk.ui.routeguide.b V = com.baidu.navisdk.ui.routeguide.b.V();
        IIX0o.oO(V, "BNavigator.getInstance()");
        LifecycleOwner f = V.f();
        IIX0o.ooOOo0oXI(f);
        g.observe(f, this.c);
        com.baidu.navisdk.vi.b.a(this.d);
    }

    public final void e() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.ACE;
        if (gVar.d()) {
            gVar.e("RGACEAction", "exitArea(), mStatus = " + this.e.g() + " isEnterArea = " + this.b);
        }
        a();
        com.baidu.navisdk.ui.routeguide.mapmode.a b2 = x.b();
        IIX0o.oO(b2, "RGViewController.getInstance()");
        boolean s2 = b2.s2();
        if (com.baidu.navisdk.ui.routeguide.utils.b.s()) {
            s2 = false;
        }
        BNRouteGuider.getInstance().setCommonRoadHDLaneMapMode(s2);
        BNRouteGuider.getInstance().setHdLaneMapMode(false);
        com.baidu.navisdk.ui.routeguide.utils.b.a("ace", false);
        this.b = false;
    }

    public final void f() {
        g value;
        g gVar;
        com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.ACE;
        if (gVar2.d()) {
            StringBuilder sb = new StringBuilder();
            sb.append("enterArea(), mStatus = ");
            MutableLiveData<g> g = this.e.g();
            if (g != null) {
                gVar = g.getValue();
            } else {
                gVar = null;
            }
            sb.append(gVar);
            sb.append(" isEnterArea = ");
            sb.append(this.b);
            gVar2.e("RGACEAction", sb.toString());
        }
        if (this.b) {
            return;
        }
        MutableLiveData<g> g2 = this.e.g();
        if (g2 != null && (value = g2.getValue()) != null && value.b()) {
            return;
        }
        if (!c()) {
            if (gVar2.d()) {
                gVar2.e("RGACEAction", "enterArea(), emptyAoiData");
            }
        } else {
            b();
            boolean s = com.baidu.navisdk.ui.routeguide.utils.b.s();
            com.baidu.navisdk.ui.routeguide.utils.b.d(s);
            com.baidu.navisdk.ui.routeguide.utils.b.e(s);
            this.b = true;
        }
    }

    public final void g() {
        g value;
        g gVar;
        com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.ACE;
        if (gVar2.d()) {
            StringBuilder sb = new StringBuilder();
            sb.append("onRouteChanged(), mStatus = ");
            MutableLiveData<g> g = this.e.g();
            if (g != null) {
                gVar = g.getValue();
            } else {
                gVar = null;
            }
            sb.append(gVar);
            sb.append(" isEnterArea = ");
            sb.append(this.b);
            gVar2.e("RGACEAction", sb.toString());
        }
        MutableLiveData<g> g2 = this.e.g();
        if (g2 != null && (value = g2.getValue()) != null && !value.b()) {
            a();
            if (c()) {
                b();
            }
        }
    }

    public final void h() {
        a();
        this.e.g().removeObserver(this.c);
        com.baidu.navisdk.vi.b.b(this.d);
    }

    public final void a() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.ACE;
        if (gVar.d()) {
            gVar.e("RGACEAction", "clearAOI()");
        }
        this.f8423a.a();
        BNMapController.getDynamicOverlay().hideAll(BNDynamicOverlay.Key.ROUTE_ACE_BUBBLE);
    }

    public final void a(int i) {
        g value;
        MutableLiveData<g> g = this.e.g();
        if (g == null || (value = g.getValue()) == null || !value.b()) {
            return;
        }
        boolean z = i == 1;
        if (com.baidu.navisdk.ui.routeguide.utils.b.s()) {
            z = false;
        }
        BNRouteGuider.getInstance().setCommonRoadHDLaneMapMode(z);
        if (i != 1) {
            com.baidu.navisdk.ui.routeguide.utils.b.b("ace", false);
        }
    }
}
