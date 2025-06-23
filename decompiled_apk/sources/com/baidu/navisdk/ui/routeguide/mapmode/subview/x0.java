package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import com.jieli.jl_audio_decode.constant.ErrorCode;

/* loaded from: classes8.dex */
public class x0 extends com.baidu.navisdk.module.newguide.abs.e {
    private static boolean l = false;
    private p i;
    private y0 j;
    private TTSPlayerControl.e k;

    /* loaded from: classes8.dex */
    public class a extends TTSPlayerControl.f {
        public a(x0 x0Var) {
        }

        @Override // com.baidu.navisdk.comapi.tts.TTSPlayerControl.e
        public void a(String str) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGMMSimpleGuideController", "onTTSPlayStateListener,onPlayStart,rgRepeatBroadcastModel:" + com.baidu.navisdk.ui.routeguide.control.m.f + ",,speechId:" + str);
            }
            com.baidu.navisdk.ui.routeguide.model.w wVar = com.baidu.navisdk.ui.routeguide.control.m.f;
            if (wVar != null && wVar.a().equalsIgnoreCase(str)) {
                com.baidu.navisdk.ui.routeguide.control.m.f.a(false);
            }
            if (TTSPlayerControl.CAR_LIMIT_VOICE_TAG.equals(str)) {
                if (gVar.d()) {
                    gVar.e("RGMMSimpleGuideController", "CarLimitVoice-, onPlayStart(), speechId=" + str);
                }
                JNIGuidanceControl.getInstance().setVoicePlayResult(true, 1);
            }
        }

        @Override // com.baidu.navisdk.comapi.tts.TTSPlayerControl.e
        public void onPlayEnd(String str) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGMMSimpleGuideController", "onTTSPlayStateListener,onPlayEnd,rgRepeatBroadcastModel:" + com.baidu.navisdk.ui.routeguide.control.m.f + ",,speechId:" + str);
            }
            com.baidu.navisdk.ui.routeguide.model.w wVar = com.baidu.navisdk.ui.routeguide.control.m.f;
            if (wVar != null && wVar.a().equalsIgnoreCase(str)) {
                com.baidu.navisdk.ui.routeguide.control.m.f.a(true);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends GestureDetector.SimpleOnGestureListener {
        public b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGMMSimpleGuideController", "gestureDetector,onDoubleTap,rgRepeatBroadcastModel:" + com.baidu.navisdk.ui.routeguide.control.m.f);
            }
            if (com.baidu.navisdk.ui.routeguide.control.m.f == null) {
                com.baidu.navisdk.ui.routeguide.control.m.f = new com.baidu.navisdk.ui.routeguide.model.w(x0.this.z0(), true);
            }
            if (com.baidu.navisdk.ui.routeguide.control.m.f.b()) {
                x0.a(com.baidu.navisdk.ui.routeguide.control.m.f);
            }
            return super.onDoubleTap(motionEvent);
        }
    }

    /* loaded from: classes8.dex */
    public class c implements View.OnTouchListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ GestureDetector f8914a;

        public c(x0 x0Var, GestureDetector gestureDetector) {
            this.f8914a = gestureDetector;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            GestureDetector gestureDetector = this.f8914a;
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

    public x0(Context context, ViewGroup viewGroup, com.baidu.navisdk.ui.routeguide.subview.a aVar) {
        super(context, viewGroup, aVar);
        this.k = new a(this);
        com.baidu.navisdk.framework.interfaces.k k = com.baidu.navisdk.framework.interfaces.c.p().k();
        if (k != null) {
            l = k.h0();
        }
        B0();
        B(l);
    }

    private void A0() {
        F0();
        E0();
        GestureDetector gestureDetector = new GestureDetector(this.b.getContext(), new b());
        if (y0() != null && y0().p0() != null) {
            y0().p0().setOnTouchListener(new c(this, gestureDetector));
            return;
        }
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMSimpleGuideController", "getxxxView() is null!!!");
        }
    }

    private void B0() {
        if (this.b == null) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGMMSimpleGuideController", "RGMMSimpleGuideController mRootViewGroup == null!!!");
                return;
            }
            return;
        }
        if (com.baidu.navisdk.ui.routeguide.utils.b.x()) {
            this.i = new p(this.f9165a, this.b, this.c);
            y0 y0Var = this.j;
            if (y0Var != null) {
                y0Var.c();
            }
            com.baidu.navisdk.ui.routeguide.control.x.b().E4();
            return;
        }
        this.j = new y0(this.f9165a, this.b, this.c);
        com.baidu.navisdk.ui.routeguide.control.x.b().E1();
    }

    private p C0() {
        if (this.i == null) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGMMSimpleGuideController", "obtainDefaultModeView - mDefaultModeGuideView == null");
            }
            this.i = new p(this.f9165a, this.b, this.c);
        }
        return this.i;
    }

    private y0 D0() {
        if (this.j == null) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGMMSimpleGuideController", "obtainSimpleModeView - mSimpleModeGuideView == null");
            }
            this.j = new y0(this.f9165a, this.b, this.c);
        }
        return this.j;
    }

    private void E0() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMSimpleGuideController", "register,onTTSPlayStateListener:" + this.k);
        }
        TTSPlayerControl.addTTSPlayStateListener(this.k);
    }

    private void F0() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMSimpleGuideController", "unRegister,onTTSPlayStateListener:" + this.k);
        }
        TTSPlayerControl.removeTTSPlayStateListener(this.k);
    }

    private static int g(String str) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGMMSimpleGuideController", "repeatPlayGuideContentInner,speechIdStr:" + str);
        }
        if (com.baidu.navisdk.util.common.x.s()) {
            return ErrorCode.ERR_UNKNOWN_EXCEPTION;
        }
        if (com.baidu.navisdk.ui.routeguide.mapmode.a.o5().y2()) {
            return -998;
        }
        String nearestGPVoice = JNIGuidanceControl.getInstance().getNearestGPVoice();
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGMMSimpleGuideController", "repeatPlayGuideContentInner,s:" + nearestGPVoice);
        }
        if (TextUtils.isEmpty(nearestGPVoice)) {
            return -997;
        }
        return TTSPlayerControl.playTTS(nearestGPVoice, 1, str);
    }

    private com.baidu.navisdk.ui.routeguide.widget.a y0() {
        if (com.baidu.navisdk.ui.routeguide.utils.b.x()) {
            return this.i;
        }
        return this.j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String z0() {
        return "repeat_broadcast";
    }

    @Override // com.baidu.navisdk.module.newguide.abs.e
    public void A(boolean z) {
        y0 y0Var;
        if (!l && (y0Var = this.j) != null) {
            y0Var.A(z);
        }
    }

    public void B(boolean z) {
        l = z;
        if (z) {
            c();
            y0 y0Var = this.j;
            if (y0Var != null) {
                y0Var.w(0);
                this.j.B(true);
            }
            p pVar = this.i;
            if (pVar != null) {
                pVar.z(true);
                return;
            }
            return;
        }
        y();
        y0 y0Var2 = this.j;
        if (y0Var2 != null) {
            y0Var2.w(8);
            this.j.B(false);
        }
        p pVar2 = this.i;
        if (pVar2 != null) {
            pVar2.z(false);
        }
    }

    @Override // com.baidu.navisdk.module.newguide.abs.e
    public void b(Drawable drawable) {
        y0 y0Var;
        if (!l && (y0Var = this.j) != null) {
            y0Var.a(drawable);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void c() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMSimpleGuideController", "RGMMSimpleGuideController - hide()");
        }
        p pVar = this.i;
        if (pVar != null) {
            pVar.c();
        }
        y0 y0Var = this.j;
        if (y0Var != null) {
            y0Var.c();
        }
        super.c();
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void d(Bundle bundle) {
        String bundle2;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            StringBuilder sb = new StringBuilder();
            sb.append("RGMMSimpleGuideController updateData b = ");
            if (bundle == null) {
                bundle2 = "null";
            } else {
                bundle2 = bundle.toString();
            }
            sb.append(bundle2);
            gVar.e("RGMMSimpleGuideController", sb.toString());
        }
        com.baidu.navisdk.ui.routeguide.widget.a y0 = y0();
        if (y0 != null) {
            y0.d(bundle);
        }
    }

    @Override // com.baidu.navisdk.module.newguide.abs.e
    public void f(String str) {
        com.baidu.navisdk.ui.routeguide.widget.a y0;
        if (!l && (y0 = y0()) != null) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGMMSimpleGuideController", y0.getClass().getSimpleName() + " - showYawingProgressView");
            }
            y0.f(str);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void i() {
        F0();
        y0 y0Var = this.j;
        if (y0Var != null) {
            y0Var.i();
        }
        p pVar = this.i;
        if (pVar != null) {
            pVar.i();
        }
        this.i = null;
        this.j = null;
    }

    @Override // com.baidu.navisdk.module.newguide.abs.e
    public void n0() {
        com.baidu.navisdk.ui.routeguide.widget.a y0 = y0();
        if (y0 != null) {
            y0.o0();
        }
    }

    @Override // com.baidu.navisdk.module.newguide.abs.e
    public int o0() {
        com.baidu.navisdk.ui.routeguide.widget.a y0 = y0();
        if (y0 != null) {
            return y0.q0();
        }
        if (com.baidu.navisdk.ui.routeguide.utils.b.x()) {
            return JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_simple_model_guide_panel_height);
        }
        return JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_top_panel_height);
    }

    @Override // com.baidu.navisdk.module.newguide.abs.e
    public int p0() {
        com.baidu.navisdk.ui.routeguide.widget.a y0 = y0();
        if (y0 != null) {
            return y0.w0();
        }
        return 0;
    }

    @Override // com.baidu.navisdk.module.newguide.abs.e
    public void q0() {
        y0 y0Var = this.j;
        if (y0Var != null) {
            y0Var.c();
        }
    }

    @Override // com.baidu.navisdk.module.newguide.abs.e
    public void r0() {
        y0 y0Var = this.j;
        if (y0Var != null) {
            y0Var.z0();
        }
    }

    @Override // com.baidu.navisdk.module.newguide.abs.e
    public void s0() {
        y0 y0Var = this.j;
        if (y0Var != null) {
            y0Var.B0();
        }
    }

    @Override // com.baidu.navisdk.module.newguide.abs.e
    public void t0() {
        com.baidu.navisdk.ui.routeguide.widget.a y0 = y0();
        if (y0 != null) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGMMSimpleGuideController", "onRPWatting->");
            }
            y0.s0();
        }
    }

    @Override // com.baidu.navisdk.module.newguide.abs.e
    public void u0() {
        y0 y0Var;
        if (!l && (y0Var = this.j) != null) {
            y0Var.C0();
        }
    }

    @Override // com.baidu.navisdk.module.newguide.abs.e
    public void v(int i) {
        y0 y0Var = this.j;
        if (y0Var != null) {
            y0Var.v(i);
        }
    }

    @Override // com.baidu.navisdk.module.newguide.abs.e
    public void w(int i) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMSimpleGuideController", "随后-setSimpleModeNextTurnVisible - visibility = " + i);
        }
        y0 y0Var = this.j;
        if (y0Var != null) {
            y0Var.w(i);
        }
    }

    @Override // com.baidu.navisdk.module.newguide.abs.e
    public void w0() {
        com.baidu.navisdk.ui.routeguide.widget.a y0;
        if (!l && (y0 = y0()) != null) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGMMSimpleGuideController", y0.getClass().getSimpleName() + " - showSuitableView");
            }
            y0.t0();
        }
    }

    @Override // com.baidu.navisdk.module.newguide.abs.e
    public void x(int i) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMSimpleGuideController", "随后-setSimpleModeNextTurnVisibleWithAnim - visibility = " + i);
        }
        y0 y0Var = this.j;
        if (y0Var != null) {
            if (i == 0) {
                y0Var.D0();
            } else {
                y0Var.E0();
            }
        }
    }

    @Override // com.baidu.navisdk.module.newguide.abs.e
    public void x0() {
        com.baidu.navisdk.ui.routeguide.widget.a y0;
        if (!l && (y0 = y0()) != null) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGMMSimpleGuideController", y0.getClass().getSimpleName() + " - updateDataByLastest");
            }
            y0.u0();
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public boolean y() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMSimpleGuideController", "show()");
        }
        if (l || com.baidu.navisdk.ui.routeguide.control.x.b().f2() || com.baidu.navisdk.ui.routeguide.control.x.b().N2()) {
            return false;
        }
        super.y();
        if (com.baidu.navisdk.ui.routeguide.control.indoorpark.c.F().j()) {
            com.baidu.navisdk.ui.routeguide.control.x.b().E1();
            D0().y();
            if (gVar.d()) {
                gVar.e("RGMMSimpleGuideController", "SimpleModeView show()");
            }
        } else if (com.baidu.navisdk.ui.routeguide.utils.b.x()) {
            q0();
            com.baidu.navisdk.ui.routeguide.control.x.b().E4();
            C0().y();
            if (gVar.d()) {
                gVar.e("RGMMSimpleGuideController", "DefaultModeView show()");
            }
        } else {
            com.baidu.navisdk.ui.routeguide.control.x.b().E1();
            D0().y();
            if (gVar.d()) {
                gVar.e("RGMMSimpleGuideController", "SimpleModeView show()");
            }
        }
        A0();
        return true;
    }

    @Override // com.baidu.navisdk.module.newguide.abs.e
    public void z(int i) {
        y0 y0Var;
        if (l || (y0Var = this.j) == null) {
            return;
        }
        y0Var.y(i);
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void a(ViewGroup viewGroup, int i) {
        super.a(viewGroup, i);
        p pVar = this.i;
        if (pVar != null) {
            pVar.i();
            this.i = null;
        }
        y0 y0Var = this.j;
        if (y0Var != null) {
            y0Var.i();
            this.j = null;
        }
    }

    @Override // com.baidu.navisdk.module.newguide.abs.e
    public void z(boolean z) {
        y0 y0Var;
        if (l || (y0Var = this.j) == null) {
            return;
        }
        y0Var.z(z);
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void a(boolean z) {
        super.a(z);
        p pVar = this.i;
        if (pVar != null) {
            pVar.a(z);
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGMMSimpleGuideController", "mDefaultModeGuideView.updateStyle = " + z);
            }
        }
        y0 y0Var = this.j;
        if (y0Var != null) {
            y0Var.a(z);
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar2.d()) {
                gVar2.e("RGMMSimpleGuideController", "RGMMSimpleGuideController.updateStyle = " + z);
            }
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void a(com.baidu.navisdk.ui.routeguide.subview.a aVar) {
        super.a(aVar);
        p pVar = this.i;
        if (pVar != null) {
            pVar.a(aVar);
        }
        y0 y0Var = this.j;
        if (y0Var != null) {
            y0Var.a(aVar);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d, com.baidu.navisdk.module.newguide.interfaces.a
    public boolean a() {
        com.baidu.navisdk.ui.routeguide.widget.a y0 = y0();
        if (y0 != null) {
            return y0.a();
        }
        return false;
    }

    @Override // com.baidu.navisdk.module.newguide.abs.e
    public void y(int i) {
        y0 y0Var;
        if (l || (y0Var = this.j) == null) {
            return;
        }
        y0Var.x(i);
    }

    @Override // com.baidu.navisdk.module.newguide.abs.e
    public void a(Drawable drawable, String str, int i) {
        y0 y0Var;
        if (l || (y0Var = this.j) == null) {
            return;
        }
        y0Var.a(drawable, str, i);
    }

    @Override // com.baidu.navisdk.module.newguide.abs.e
    public void y(boolean z) {
        y0 y0Var = this.j;
        if (y0Var != null) {
            if (z) {
                y0Var.A0();
            } else {
                y0Var.y0();
            }
        }
    }

    public static void a(@NonNull com.baidu.navisdk.ui.routeguide.model.w wVar) {
        if (wVar == null) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("RGMMSimpleGuideController", "repeatPlayGuideContent,invalid arguments");
                return;
            }
            return;
        }
        int g = g(wVar.a());
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGMMSimpleGuideController", "repeatPlayGuideContent---end,ret:" + g);
        }
    }
}
