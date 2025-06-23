package com.baidu.navisdk.module.newguide.subviews.guides;

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
import com.baidu.navisdk.ui.routeguide.control.m;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.y0;
import com.baidu.navisdk.ui.routeguide.model.w;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import com.jieli.jl_audio_decode.constant.ErrorCode;

/* loaded from: classes7.dex */
public class j extends com.baidu.navisdk.module.newguide.abs.e {
    private static boolean l = false;
    private f i;
    private y0 j;
    private TTSPlayerControl.e k;

    /* loaded from: classes7.dex */
    public class a extends TTSPlayerControl.f {
        public a(j jVar) {
        }

        @Override // com.baidu.navisdk.comapi.tts.TTSPlayerControl.e
        public void a(String str) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGSimpleGuideControlNew", "onTTSPlayStateListener,onPlayStart,rgRepeatBroadcastModel:" + m.f + ",,speechId:" + str);
            }
            w wVar = m.f;
            if (wVar != null && wVar.a().equalsIgnoreCase(str)) {
                m.f.a(false);
            }
            if (TTSPlayerControl.CAR_LIMIT_VOICE_TAG.equals(str)) {
                if (gVar.d()) {
                    gVar.e("RGSimpleGuideControlNew", "CarLimitVoice-, onPlayStart(), speechId=" + str);
                }
                JNIGuidanceControl.getInstance().setVoicePlayResult(true, 1);
            }
        }

        @Override // com.baidu.navisdk.comapi.tts.TTSPlayerControl.e
        public void onPlayEnd(String str) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGSimpleGuideControlNew", "onTTSPlayStateListener,onPlayEnd,rgRepeatBroadcastModel:" + m.f + ",,speechId:" + str);
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
                gVar.e("RGSimpleGuideControlNew", "gestureDetector,onDoubleTap,rgRepeatBroadcastModel:" + m.f);
            }
            if (m.f == null) {
                m.f = new w(j.this.z0(), true);
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
        final /* synthetic */ GestureDetector f7353a;

        public c(j jVar, GestureDetector gestureDetector) {
            this.f7353a = gestureDetector;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            GestureDetector gestureDetector = this.f7353a;
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

    public j(Context context, ViewGroup viewGroup, com.baidu.navisdk.ui.routeguide.subview.a aVar) {
        super(context, viewGroup, aVar);
        this.k = new a(this);
        com.baidu.navisdk.framework.interfaces.k k = com.baidu.navisdk.framework.interfaces.c.p().k();
        if (k != null) {
            k.h0();
        }
        C0();
        B(l);
    }

    private void A0() {
        f fVar = this.i;
        if (fVar != null) {
            fVar.c();
        }
    }

    private void B0() {
        G0();
        F0();
        GestureDetector gestureDetector = new GestureDetector(this.b.getContext(), new b());
        if (y0() != null && y0().p0() != null) {
            y0().p0().setOnTouchListener(new c(this, gestureDetector));
            return;
        }
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGSimpleGuideControlNew", "getxxxView() is null!!!");
        }
    }

    private void C(boolean z) {
        y0 y0Var = this.j;
        if (y0Var != null) {
            y0Var.c();
            if (z) {
                this.j.i();
                this.j = null;
            }
        }
    }

    private void C0() {
        if (this.b == null) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGSimpleGuideControlNew", "RGMMSimpleGuideController mRootViewGroup == null!!!");
                return;
            }
            return;
        }
        if (com.baidu.navisdk.ui.routeguide.utils.b.x()) {
            this.i = new f(this.f9165a, this.b, this.c);
            x.b().E4();
            C(true);
        } else {
            this.j = new y0(this.f9165a, this.b, this.c);
            x.b().E1();
        }
    }

    private f D0() {
        if (this.i == null) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGSimpleGuideControlNew", "obtainDefaultModeView - mDefaultModeGuideView == null");
            }
            this.i = new f(this.f9165a, this.b, this.c);
        }
        return this.i;
    }

    private y0 E0() {
        if (this.j == null) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGSimpleGuideControlNew", "obtainSimpleModeView - mSimpleModeGuideView == null");
            }
            this.j = new y0(this.f9165a, this.b, this.c);
        }
        return this.j;
    }

    private void F0() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGSimpleGuideControlNew", "register,onTTSPlayStateListener:" + this.k);
        }
        TTSPlayerControl.addTTSPlayStateListener(this.k);
    }

    private void G0() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGSimpleGuideControlNew", "unRegister,onTTSPlayStateListener:" + this.k);
        }
        TTSPlayerControl.removeTTSPlayStateListener(this.k);
    }

    private static int g(String str) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGSimpleGuideControlNew", "repeatPlayGuideContentInner,speechIdStr:" + str);
        }
        if (com.baidu.navisdk.util.common.x.s()) {
            return ErrorCode.ERR_UNKNOWN_EXCEPTION;
        }
        if (com.baidu.navisdk.ui.routeguide.mapmode.a.o5().y2()) {
            return -998;
        }
        String nearestGPVoice = JNIGuidanceControl.getInstance().getNearestGPVoice();
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGSimpleGuideControlNew", "repeatPlayGuideContentInner,s:" + nearestGPVoice);
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
            f fVar = this.i;
            if (fVar != null) {
                fVar.z(true);
            }
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
            gVar.e("RGSimpleGuideControlNew", "RGMMSimpleGuideController - hide()");
        }
        A0();
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
            gVar.e("RGSimpleGuideControlNew", sb.toString());
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
                gVar.e("RGSimpleGuideControlNew", y0.getClass().getSimpleName() + " - showYawingProgressView");
            }
            y0.f(str);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void i() {
        G0();
        y0 y0Var = this.j;
        if (y0Var != null) {
            y0Var.i();
        }
        f fVar = this.i;
        if (fVar != null) {
            fVar.i();
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
            return JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_default_top_guide_panel_total_min_height);
        }
        return JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_simple_model_guide_panel_height);
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
        C(false);
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
                gVar.e("RGSimpleGuideControlNew", "onRPWatting->");
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
            gVar.e("RGSimpleGuideControlNew", "随后-setSimpleModeNextTurnVisible - visibility = " + i);
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
                gVar.e("RGSimpleGuideControlNew", y0.getClass().getSimpleName() + " - showSuitableView");
            }
            y0.t0();
        }
    }

    @Override // com.baidu.navisdk.module.newguide.abs.e
    public void x(int i) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGSimpleGuideControlNew", "随后-setSimpleModeNextTurnVisibleWithAnim - visibility = " + i);
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
                gVar.e("RGSimpleGuideControlNew", y0.getClass().getSimpleName() + " - updateDataByLastest");
            }
            y0.u0();
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public boolean y() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGSimpleGuideControlNew", "show()");
        }
        if (l || x.b().f2() || x.b().N2()) {
            return false;
        }
        super.y();
        if (com.baidu.navisdk.ui.routeguide.control.indoorpark.c.F().j()) {
            x.b().E1();
            E0().y();
            if (gVar.d()) {
                gVar.e("RGSimpleGuideControlNew", "SimpleModeView show()");
            }
        } else if (com.baidu.navisdk.ui.routeguide.utils.b.x()) {
            C(true);
            D0().y();
            x.b().E4();
            if (gVar.d()) {
                gVar.e("RGSimpleGuideControlNew", "DefaultModeView show()");
            }
        } else {
            x.b().E1();
            A0();
            E0().y();
            if (gVar.d()) {
                gVar.e("RGSimpleGuideControlNew", "SimpleModeView show()");
            }
        }
        B0();
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
        f fVar = this.i;
        if (fVar != null) {
            fVar.i();
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
        f fVar = this.i;
        if (fVar != null) {
            fVar.a(z);
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGSimpleGuideControlNew", "mDefaultModeGuideView.updateStyle = " + z);
            }
        }
        y0 y0Var = this.j;
        if (y0Var != null) {
            y0Var.a(z);
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar2.d()) {
                gVar2.e("RGSimpleGuideControlNew", "RGMMSimpleGuideController.updateStyle = " + z);
            }
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void a(com.baidu.navisdk.ui.routeguide.subview.a aVar) {
        super.a(aVar);
        f fVar = this.i;
        if (fVar != null) {
            fVar.a(aVar);
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

    public static void a(@NonNull w wVar) {
        if (wVar == null) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("RGSimpleGuideControlNew", "repeatPlayGuideContent,invalid arguments");
                return;
            }
            return;
        }
        int g = g(wVar.a());
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGSimpleGuideControlNew", "repeatPlayGuideContent---end,ret:" + g);
        }
    }
}
