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
import com.baidu.navisdk.ui.routeguide.control.m;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.q;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.x0;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.z0;
import com.baidu.navisdk.ui.routeguide.model.w;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes7.dex */
public class i extends com.baidu.navisdk.module.newguide.abs.d {
    private g i;
    private z0 j;
    boolean k;
    private TTSPlayerControl.e l;

    /* loaded from: classes7.dex */
    public class a extends TTSPlayerControl.f {
        public a(i iVar) {
        }

        @Override // com.baidu.navisdk.comapi.tts.TTSPlayerControl.e
        public void a(String str) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGMMHighwayViewContrNew", "onTTSPlayStateListener,onPlayStart,rgRepeatBroadcastModel:" + m.f + ",,speechId:" + str);
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
                gVar.e("RGMMHighwayViewContrNew", "onTTSPlayStateListener,onPlayEnd,rgRepeatBroadcastModel:" + m.f + ",,speechId:" + str);
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
                m.f = new w(i.this.x0(), true);
            }
            if (m.f.b()) {
                x0.a(m.f);
            }
            if (i.this.w0() != null) {
                return i.this.w0().q0();
            }
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (motionEvent == null) {
                return false;
            }
            if (i.this.w0() != null) {
                if (motionEvent2.getY() - motionEvent.getRawY() > 30.0f) {
                    return i.this.w0().v(1);
                }
                if (motionEvent2.getY() - motionEvent.getY() < -30.0f) {
                    return i.this.w0().v(-1);
                }
            }
            return super.onFling(motionEvent, motionEvent2, f, f2);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (i.this.w0() != null) {
                return i.this.w0().q0();
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnTouchListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ GestureDetector f7351a;

        public c(i iVar, GestureDetector gestureDetector) {
            this.f7351a = gestureDetector;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            GestureDetector gestureDetector = this.f7351a;
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

    public i(Context context, ViewGroup viewGroup, com.baidu.navisdk.ui.routeguide.subview.a aVar) {
        super(context, viewGroup, aVar);
        this.k = false;
        this.l = new a(this);
        z0();
        y0();
    }

    private g A0() {
        if (this.i == null) {
            this.i = new g(this.f9165a, this.b, this.c);
        }
        return this.i;
    }

    private z0 B0() {
        if (this.j == null) {
            this.j = new z0(this.f9165a, this.b, this.c);
        }
        return this.j;
    }

    private void C0() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMHighwayViewContrNew", "register,onTTSPlayStateListener:" + this.l);
        }
        TTSPlayerControl.addTTSPlayStateListener(this.l);
    }

    private void D0() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMHighwayViewContrNew", "unRegister,onTTSPlayStateListener:" + this.l);
        }
        TTSPlayerControl.removeTTSPlayStateListener(this.l);
    }

    private void u0() {
        z0 z0Var = this.j;
        if (z0Var != null) {
            z0Var.c();
            this.j.i();
            this.j = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.navisdk.ui.routeguide.widget.b w0() {
        if (com.baidu.navisdk.ui.routeguide.utils.b.x()) {
            return this.i;
        }
        return this.j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String x0() {
        return "repeat_broadcast";
    }

    private void y0() {
        D0();
        C0();
        TTSPlayerControl.addTTSPlayStateListener(this.l);
        GestureDetector gestureDetector = new GestureDetector(this.b.getContext(), new b());
        if (w0() != null && w0().o0() != null) {
            w0().o0().setOnTouchListener(new c(this, gestureDetector));
            return;
        }
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMHighwayViewContrNew", "getxxxView() is null!!!");
        }
    }

    private void z0() {
        if (this.b == null) {
            return;
        }
        if (com.baidu.navisdk.ui.routeguide.utils.b.x()) {
            u0();
            x.b().E4();
            this.i = new g(this.f9165a, this.b, this.c);
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGMMHighwayViewContrNew", "initViews: mDefaultModeHighwayView");
                return;
            }
            return;
        }
        this.j = new z0(this.f9165a, this.b, this.c);
        x.b().E1();
        com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar2.d()) {
            gVar2.e("RGMMHighwayViewContrNew", "initViews: mSimpleModeHighwayView");
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void c() {
        g gVar = this.i;
        if (gVar != null) {
            gVar.c();
        }
        z0 z0Var = this.j;
        if (z0Var != null) {
            z0Var.c();
        }
        super.c();
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void d(Bundle bundle) {
        com.baidu.navisdk.ui.routeguide.widget.b w0;
        if ((RouteGuideFSM.getInstance().getCurrentEvent() == null || !RouteGuideFSM.getInstance().getCurrentEvent().equals(RGFSMTable.FsmEvent.MSG_YAWING_START)) && (w0 = w0()) != null) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGMMHighwayViewContrNew", "updateData: " + w0);
            }
            w0.d(bundle);
        }
    }

    @Override // com.baidu.navisdk.module.newguide.abs.d
    public void f(String str) {
        com.baidu.navisdk.ui.routeguide.widget.b w0 = w0();
        if (w0 != null) {
            w0.f(str);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void i() {
        super.i();
        D0();
    }

    @Override // com.baidu.navisdk.module.newguide.abs.d
    public void n0() {
        com.baidu.navisdk.ui.routeguide.widget.b w0 = w0();
        if (w0 != null) {
            w0.n0();
        }
    }

    @Override // com.baidu.navisdk.module.newguide.abs.d
    public void o0() {
        com.baidu.navisdk.ui.routeguide.widget.b w0 = w0();
        if (w0 instanceof q) {
            q qVar = (q) w0;
            if (qVar.s0()) {
                qVar.r0();
            }
        }
    }

    @Override // com.baidu.navisdk.module.newguide.abs.d
    public int p0() {
        com.baidu.navisdk.ui.routeguide.widget.b w0 = w0();
        if (w0 != null) {
            return w0.p0();
        }
        if (com.baidu.navisdk.ui.routeguide.utils.b.x()) {
            return JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_default_top_guide_panel_total_min_height);
        }
        return JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_simple_model_guide_panel_height);
    }

    @Override // com.baidu.navisdk.module.newguide.abs.d
    public void q0() {
        z0 z0Var = this.j;
        if (z0Var != null) {
            z0Var.s0();
        }
    }

    @Override // com.baidu.navisdk.module.newguide.abs.d
    public boolean r0() {
        com.baidu.navisdk.ui.routeguide.widget.b w0 = w0();
        if (w0 != null && (w0 instanceof q)) {
            return ((q) w0).s0();
        }
        return false;
    }

    @Override // com.baidu.navisdk.module.newguide.abs.d
    public void s0() {
        z0 z0Var = this.j;
        if (z0Var != null) {
            z0Var.u0();
        }
    }

    @Override // com.baidu.navisdk.module.newguide.abs.d
    public void t0() {
        z0 z0Var = this.j;
        if (z0Var != null) {
            z0Var.w0();
        }
    }

    @Override // com.baidu.navisdk.module.newguide.abs.d
    public void v(int i) {
        z0 z0Var = this.j;
        if (z0Var != null) {
            z0Var.w(i);
        }
    }

    @Override // com.baidu.navisdk.module.newguide.abs.d
    public void w(int i) {
        z0 z0Var = this.j;
        if (z0Var != null) {
            z0Var.x(i);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public boolean y() {
        if (this.k || x.b().f2() || x.b().N2()) {
            return false;
        }
        if (com.baidu.navisdk.ui.routeguide.utils.b.x()) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGMMHighwayViewContrNew", "show: isDefaultGuidePanelMode");
            }
            u0();
            x.b().E4();
            A0().y();
        } else {
            x.b().E1();
            g gVar2 = this.i;
            if (gVar2 != null) {
                gVar2.c();
            }
            B0().y();
            com.baidu.navisdk.util.common.g gVar3 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar3.d()) {
                gVar3.e("RGMMHighwayViewContrNew", "show: obtainSimpleModeView");
            }
        }
        y0();
        super.y();
        return true;
    }

    @Override // com.baidu.navisdk.module.newguide.abs.d
    public void z(boolean z) {
        z0 z0Var = this.j;
        if (z0Var != null) {
            z0Var.y(z);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void a(ViewGroup viewGroup, int i) {
        super.a(viewGroup, i);
        g gVar = this.i;
        if (gVar != null) {
            gVar.i();
            this.i = null;
        }
        z0 z0Var = this.j;
        if (z0Var != null) {
            z0Var.i();
            this.j = null;
        }
        z0();
        y0();
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void a(boolean z) {
        super.a(z);
        g gVar = this.i;
        if (gVar != null) {
            gVar.a(z);
        }
        z0 z0Var = this.j;
        if (z0Var != null) {
            z0Var.a(z);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d, com.baidu.navisdk.module.newguide.interfaces.a
    public boolean a() {
        com.baidu.navisdk.ui.routeguide.widget.b w0 = w0();
        if (w0 != null) {
            return w0.a();
        }
        return false;
    }

    @Override // com.baidu.navisdk.module.newguide.abs.d
    public void a(Drawable drawable, String str, int i) {
        z0 z0Var = this.j;
        if (z0Var != null) {
            z0Var.a(drawable, str, i);
        }
    }

    @Override // com.baidu.navisdk.module.newguide.abs.d
    public void y(boolean z) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMHighwayViewContrNew", "openOrExitVdrLocationMode: " + com.baidu.navisdk.ui.routeguide.utils.b.x() + ", " + this.j);
        }
        z0 z0Var = this.j;
        if (z0Var != null) {
            if (z) {
                z0Var.t0();
            } else {
                z0Var.r0();
            }
        }
    }
}
