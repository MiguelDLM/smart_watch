package com.baidu.navisdk.module.newguide.subviews.guides;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.module.newguide.subviews.guides.c;
import com.baidu.navisdk.ui.routeguide.control.m;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.ui.routeguide.model.w;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes7.dex */
public class e extends com.baidu.navisdk.module.newguide.abs.a {
    private com.baidu.navisdk.module.newguide.subviews.guides.c j;
    private k k;
    boolean l;
    private c.InterfaceC0268c m;
    private TTSPlayerControl.e n;

    /* loaded from: classes7.dex */
    public class a extends TTSPlayerControl.f {
        public a(e eVar) {
        }

        @Override // com.baidu.navisdk.comapi.tts.TTSPlayerControl.e
        public void a(String str) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGExitMainRoadGuideCont", "onTTSPlayStateListener,onPlayStart,rgRepeatBroadcastModel:" + m.f + ",,speechId:" + str);
            }
            w wVar = m.f;
            if (wVar != null && wVar.a().equalsIgnoreCase(str)) {
                m.f.a(false);
            }
        }

        @Override // com.baidu.navisdk.comapi.tts.TTSPlayerControl.e
        public void onPlayEnd(String str) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGExitMainRoadGuideCont", "onTTSPlayStateListener,onPlayEnd,rgRepeatBroadcastModel:" + m.f + ",,speechId:" + str);
            }
            w wVar = m.f;
            if (wVar != null && wVar.a().equalsIgnoreCase(str)) {
                m.f.a(true);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends GestureDetector.SimpleOnGestureListener {
        public b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("initPanelTouchListener", "gestureDetector,onDoubleTap,rgRepeatBroadcastModel:" + m.f);
            }
            if (m.f == null) {
                m.f = new w(e.this.y0(), true);
            }
            if (m.f.b()) {
                j.a(m.f);
            }
            return super.onDoubleTap(motionEvent);
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnTouchListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ GestureDetector f7349a;

        public c(e eVar, GestureDetector gestureDetector) {
            this.f7349a = gestureDetector;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            GestureDetector gestureDetector = this.f7349a;
            if (gestureDetector != null) {
                gestureDetector.onTouchEvent(motionEvent);
                com.baidu.navisdk.framework.interfaces.k k = com.baidu.navisdk.framework.interfaces.c.p().k();
                if (k != null) {
                    k.s();
                    return true;
                }
                return true;
            }
            return true;
        }
    }

    public e(Context context, ViewGroup viewGroup, com.baidu.navisdk.ui.routeguide.subview.a aVar) {
        super(context, viewGroup, aVar);
        this.l = false;
        this.n = new a(this);
        A0();
    }

    private void A0() {
        if (this.b == null) {
            return;
        }
        if (com.baidu.navisdk.ui.routeguide.utils.b.x()) {
            w0();
            x.b().E4();
            com.baidu.navisdk.module.newguide.subviews.guides.c cVar = new com.baidu.navisdk.module.newguide.subviews.guides.c(this.f9165a, this.b, this.c);
            this.j = cVar;
            c.InterfaceC0268c interfaceC0268c = this.m;
            if (interfaceC0268c != null) {
                cVar.a(interfaceC0268c);
                return;
            }
            return;
        }
        this.k = new k(this.f9165a, this.b, this.c);
        x.b().E1();
    }

    private com.baidu.navisdk.module.newguide.subviews.guides.c B0() {
        if (this.j == null) {
            com.baidu.navisdk.module.newguide.subviews.guides.c cVar = new com.baidu.navisdk.module.newguide.subviews.guides.c(this.f9165a, this.b, this.c);
            this.j = cVar;
            cVar.a(this.m);
        }
        return this.j;
    }

    private k C0() {
        if (this.k == null) {
            this.k = new k(this.f9165a, this.b, this.c);
        }
        return this.k;
    }

    private void D0() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGExitMainRoadGuideCont", "register,onTTSPlayStateListener:" + this.n);
        }
        TTSPlayerControl.addTTSPlayStateListener(this.n);
    }

    private void E0() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGExitMainRoadGuideCont", "unRegister,onTTSPlayStateListener:" + this.n);
        }
        TTSPlayerControl.removeTTSPlayStateListener(this.n);
    }

    private void w0() {
        k kVar = this.k;
        if (kVar != null) {
            kVar.c();
            this.k.i();
            this.k = null;
        }
    }

    private com.baidu.navisdk.ui.routeguide.widget.a x0() {
        if (com.baidu.navisdk.ui.routeguide.utils.b.x()) {
            return this.j;
        }
        return this.k;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String y0() {
        return "repeat_broadcast";
    }

    private void z0() {
        E0();
        D0();
        TTSPlayerControl.addTTSPlayStateListener(this.n);
        GestureDetector gestureDetector = new GestureDetector(this.b.getContext(), new b());
        if (x0() != null && x0().p0() != null) {
            x0().p0().setOnTouchListener(new c(this, gestureDetector));
            return;
        }
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGExitMainRoadGuideCont", "getxxxView() is null!!!");
        }
    }

    @Override // com.baidu.navisdk.module.newguide.abs.a
    public void A(boolean z) {
        k kVar = this.k;
        if (kVar != null) {
            kVar.A(z);
        }
    }

    @Override // com.baidu.navisdk.module.newguide.abs.a
    public void b(Drawable drawable) {
        k kVar = this.k;
        if (kVar != null) {
            kVar.a(drawable);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void c() {
        w wVar;
        com.baidu.navisdk.module.newguide.subviews.guides.c cVar = this.j;
        if (cVar != null) {
            cVar.c();
        }
        k kVar = this.k;
        if (kVar != null) {
            kVar.c();
        }
        if (a() && (wVar = m.f) != null) {
            wVar.a(true);
        }
        super.c();
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void d(Bundle bundle) {
        com.baidu.navisdk.ui.routeguide.widget.a x02;
        if ((RouteGuideFSM.getInstance().getCurrentEvent() == null || !RouteGuideFSM.getInstance().getCurrentEvent().equals(RGFSMTable.FsmEvent.MSG_YAWING_START)) && (x02 = x0()) != null) {
            x02.d(bundle);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void i() {
        super.i();
        E0();
        k kVar = this.k;
        if (kVar != null) {
            kVar.i();
        }
        com.baidu.navisdk.module.newguide.subviews.guides.c cVar = this.j;
        if (cVar != null) {
            cVar.i();
        }
        this.j = null;
        this.k = null;
        this.i = false;
        this.m = null;
    }

    @Override // com.baidu.navisdk.module.newguide.abs.a
    public void n0() {
        com.baidu.navisdk.ui.routeguide.widget.a x02 = x0();
        if (x02 != null) {
            x02.o0();
        }
    }

    @Override // com.baidu.navisdk.module.newguide.abs.a
    public int o0() {
        com.baidu.navisdk.ui.routeguide.widget.a x02 = x0();
        if (x02 != null) {
            return x02.q0();
        }
        if (com.baidu.navisdk.ui.routeguide.utils.b.x()) {
            return com.baidu.navisdk.module.newguide.a.e().c();
        }
        return JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_simple_model_guide_panel_height);
    }

    @Override // com.baidu.navisdk.module.newguide.abs.a
    public boolean p0() {
        return this.i;
    }

    @Override // com.baidu.navisdk.module.newguide.abs.a
    public void q0() {
        k kVar = this.k;
        if (kVar != null) {
            kVar.z0();
        }
    }

    @Override // com.baidu.navisdk.module.newguide.abs.a
    public void r0() {
        k kVar = this.k;
        if (kVar != null) {
            kVar.B0();
        }
    }

    @Override // com.baidu.navisdk.module.newguide.abs.a
    public void s0() {
        k kVar = this.k;
        if (kVar != null) {
            kVar.C0();
        }
    }

    @Override // com.baidu.navisdk.module.newguide.abs.a
    public void t0() {
        com.baidu.navisdk.ui.routeguide.widget.a x02;
        if (!this.l && (x02 = x0()) != null) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGExitMainRoadGuideCont", x02.getClass().getSimpleName() + " - showSuitableView");
            }
            x02.t0();
        }
    }

    @Override // com.baidu.navisdk.module.newguide.abs.a
    public void u0() {
        com.baidu.navisdk.ui.routeguide.widget.a x02 = x0();
        if (x02 != null) {
            x02.u0();
        }
    }

    @Override // com.baidu.navisdk.module.newguide.abs.a
    public void v(int i) {
        k kVar = this.k;
        if (kVar != null) {
            kVar.v(i);
        }
    }

    @Override // com.baidu.navisdk.module.newguide.abs.a
    public void w(int i) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGExitMainRoadGuideCont", "随后-setSimpleModeNextTurnVisible - visibility = " + i);
        }
        k kVar = this.k;
        if (kVar != null) {
            kVar.w(i);
        }
    }

    @Override // com.baidu.navisdk.module.newguide.abs.a
    public void x(int i) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGExitMainRoadGuideCont", "setSimpleModeNextTurnVisibleWithAnim: " + i);
        }
        k kVar = this.k;
        if (kVar != null) {
            if (i == 0) {
                kVar.D0();
            } else {
                kVar.E0();
            }
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public boolean y() {
        if (this.l || x.b().f2() || x.b().N2()) {
            return false;
        }
        if (com.baidu.navisdk.ui.routeguide.utils.b.x()) {
            w0();
            x.b().E4();
            B0().y();
        } else {
            x.b().E1();
            com.baidu.navisdk.module.newguide.subviews.guides.c cVar = this.j;
            if (cVar != null) {
                cVar.c();
            }
            C0().y();
        }
        z0();
        return super.y();
    }

    @Override // com.baidu.navisdk.module.newguide.abs.a
    public void z(boolean z) {
        k kVar;
        if (this.l || (kVar = this.k) == null) {
            return;
        }
        kVar.z(z);
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void a(ViewGroup viewGroup, int i) {
        super.a(viewGroup, i);
        com.baidu.navisdk.module.newguide.subviews.guides.c cVar = this.j;
        if (cVar != null) {
            cVar.i();
            this.j = null;
        }
        k kVar = this.k;
        if (kVar != null) {
            kVar.i();
            this.k = null;
        }
        A0();
    }

    @Override // com.baidu.navisdk.module.newguide.abs.a
    public void z(int i) {
        k kVar = this.k;
        if (kVar != null) {
            kVar.y(i);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void a(boolean z) {
        super.a(z);
        com.baidu.navisdk.module.newguide.subviews.guides.c cVar = this.j;
        if (cVar != null) {
            cVar.a(z);
        }
        k kVar = this.k;
        if (kVar != null) {
            kVar.a(z);
        }
    }

    @Override // com.baidu.navisdk.module.newguide.abs.a
    public void y(int i) {
        k kVar;
        if (this.l || (kVar = this.k) == null) {
            return;
        }
        kVar.x(i);
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d, com.baidu.navisdk.module.newguide.interfaces.a
    public boolean a() {
        com.baidu.navisdk.ui.routeguide.widget.a x02 = x0();
        if (x02 != null) {
            return x02.a();
        }
        return false;
    }

    @Override // com.baidu.navisdk.module.newguide.abs.a
    public void a(Drawable drawable, String str, int i) {
        k kVar = this.k;
        if (kVar != null) {
            kVar.a(drawable, str, i);
        }
    }

    @Override // com.baidu.navisdk.module.newguide.abs.a
    public void y(boolean z) {
        k kVar = this.k;
        if (kVar != null) {
            if (z) {
                kVar.A0();
            } else {
                kVar.y0();
            }
        }
    }

    @Override // com.baidu.navisdk.module.newguide.abs.a
    public void a(c.InterfaceC0268c interfaceC0268c) {
        com.baidu.navisdk.module.newguide.subviews.guides.c cVar = this.j;
        if (cVar != null) {
            cVar.a(interfaceC0268c);
        }
        this.m = interfaceC0268c;
    }
}
