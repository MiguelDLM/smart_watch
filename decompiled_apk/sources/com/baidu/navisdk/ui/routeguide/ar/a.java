package com.baidu.navisdk.ui.routeguide.ar;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import Oox.oIX0oI;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.setting.BNCommSettingManager;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.module.abtest.model.k;
import com.baidu.navisdk.module.ar.c;
import com.baidu.navisdk.pronavi.style.d;
import com.baidu.navisdk.pronavi.style.e;
import com.baidu.navisdk.ui.routeguide.ar.g;
import com.baidu.navisdk.ui.routeguide.control.s;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.util.common.a0;
import com.baidu.navisdk.util.logic.n;
import com.baidu.navisdk.util.statistic.ProNaviStatItem;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.LazyThreadSafetyMode;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes8.dex */
public final class a implements com.baidu.navisdk.framework.interfaces.pronavi.multinavi.a, com.baidu.navisdk.module.ar.tracker.e, com.baidu.navisdk.module.pronavi.abs.b {

    /* renamed from: a, reason: collision with root package name */
    private com.baidu.navisdk.module.ar.e f8443a;
    private Activity b;
    private ViewGroup c;
    private boolean d;
    private int e;
    private ArrayList<com.baidu.navisdk.framework.interfaces.pronavi.hd.c> f;
    private ArrayList<com.baidu.navisdk.framework.interfaces.pronavi.hd.b> g;
    private ArrayList<com.baidu.navisdk.framework.interfaces.pronavi.hd.a> h;
    private final int i;
    private final int j;
    private AnimatorSet k;
    private int l;
    private com.baidu.navisdk.pronavi.hd.hdnavi.animator.a m;
    private com.baidu.navisdk.ui.routeguide.ar.e n;
    private com.baidu.navisdk.ui.routeguide.ar.g o;
    private WeakReference<com.baidu.navisdk.ui.routeguide.subview.a> p;
    private com.baidu.navisdk.ui.routeguide.ar.b q;
    private final X0IIOO r;
    private final X0IIOO s;
    private g t;

    /* renamed from: com.baidu.navisdk.ui.routeguide.ar.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C0413a {
        private C0413a() {
        }

        public /* synthetic */ C0413a(IIXOooo iIXOooo) {
            this();
        }
    }

    /* loaded from: classes8.dex */
    public static final class b extends com.baidu.navisdk.util.worker.lite.b {
        public b(String str) {
            super(str);
        }

        @Override // com.baidu.navisdk.util.worker.lite.b, java.lang.Runnable
        public void run() {
            a.this.C();
        }
    }

    /* loaded from: classes8.dex */
    public static final class c extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f8445a;

        public c(int i) {
            this.f8445a = i;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@OOXIXo Animator animation) {
            IIX0o.x0xO0oo(animation, "animation");
            super.onAnimationCancel(animation);
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("BNArController", "enterDoubleMap onAnimationCancel from: " + this.f8445a);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@OOXIXo Animator animation) {
            IIX0o.x0xO0oo(animation, "animation");
            super.onAnimationEnd(animation);
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("BNArController", "enterDoubleMap onAnimationEnd from: " + this.f8445a);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(@OOXIXo Animator animation) {
            IIX0o.x0xO0oo(animation, "animation");
            super.onAnimationStart(animation);
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("BNArController", "enterDoubleMap onAnimationStart from: " + this.f8445a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class d extends AnimatorListenerAdapter {
        final /* synthetic */ int b;
        final /* synthetic */ boolean c;

        public d(int i, boolean z) {
            this.b = i;
            this.c = z;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@OOXIXo Animator animation) {
            IIX0o.x0xO0oo(animation, "animation");
            super.onAnimationCancel(animation);
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("BNArController", "enterFullHD onAnimationCancel from: " + this.b);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@OOXIXo Animator animation) {
            IIX0o.x0xO0oo(animation, "animation");
            super.onAnimationEnd(animation);
            com.baidu.navisdk.ui.routeguide.ar.e eVar = a.this.n;
            if (eVar != null) {
                eVar.b(this.c);
            }
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("BNArController", "enterFullHD onAnimationEnd from: " + this.b);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(@OOXIXo Animator animation) {
            IIX0o.x0xO0oo(animation, "animation");
            super.onAnimationStart(animation);
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("BNArController", "enterFullHD onAnimationStart from: " + this.b);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class e extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f8447a;

        public e(int i) {
            this.f8447a = i;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@OOXIXo Animator animation) {
            IIX0o.x0xO0oo(animation, "animation");
            super.onAnimationCancel(animation);
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("BNArController", "enterNormal onAnimationCancel from: " + this.f8447a);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@OOXIXo Animator animation) {
            IIX0o.x0xO0oo(animation, "animation");
            super.onAnimationEnd(animation);
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("BNArController", "enterNormal onAnimationEnd from: " + this.f8447a);
            }
            com.baidu.navisdk.ui.routeguide.utils.b.C();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(@OOXIXo Animator animation) {
            IIX0o.x0xO0oo(animation, "animation");
            super.onAnimationStart(animation);
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("BNArController", "enterNormal onAnimationStart from: " + this.f8447a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class f extends Lambda implements oIX0oI<C0414a> {

        /* renamed from: a, reason: collision with root package name */
        public static final f f8448a = new f();

        /* renamed from: com.baidu.navisdk.ui.routeguide.ar.a$f$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C0414a implements g.b {
            @Override // com.baidu.navisdk.ui.routeguide.ar.g.b
            public void a() {
                Bundle bundle = new Bundle();
                bundle.putBoolean(RGFSMTable.FsmParamsKey.IS_AR_NAVI, true);
                RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.MAP_MOVE, bundle);
            }
        }

        public f() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OOXIXo
        public final C0414a invoke() {
            return new C0414a();
        }
    }

    /* loaded from: classes8.dex */
    public static final class g {

        /* renamed from: com.baidu.navisdk.ui.routeguide.ar.a$g$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C0415a extends com.baidu.navisdk.util.worker.lite.b {
            public C0415a(String str) {
                super(str);
            }

            @Override // com.baidu.navisdk.util.worker.lite.b, java.lang.Runnable
            public void run() {
                View findViewById;
                ViewGroup viewGroup = a.this.c;
                if (viewGroup != null && (findViewById = viewGroup.findViewById(R.id.debug_gate_btn)) != null) {
                    findViewById.setBackgroundColor(viewGroup.getResources().getColor(android.R.color.holo_red_dark));
                }
            }
        }

        /* loaded from: classes8.dex */
        public static final class b extends com.baidu.navisdk.util.worker.lite.b {
            public b(String str) {
                super(str);
            }

            @Override // com.baidu.navisdk.util.worker.lite.b, java.lang.Runnable
            public void run() {
                View findViewById;
                ViewGroup viewGroup = a.this.c;
                if (viewGroup != null && (findViewById = viewGroup.findViewById(R.id.debug_gate_btn)) != null) {
                    findViewById.setBackgroundColor(viewGroup.getResources().getColor(android.R.color.darker_gray));
                }
            }
        }

        public g() {
        }

        public void a() {
            com.baidu.navisdk.util.worker.lite.a.c(new C0415a(""));
            a.this.i(101);
        }

        public void b() {
            com.baidu.navisdk.util.worker.lite.a.c(new b(""));
            a.this.i(102);
        }
    }

    /* loaded from: classes8.dex */
    public static final class h extends Lambda implements oIX0oI<com.baidu.navisdk.ui.routeguide.ar.f> {
        public h() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OOXIXo
        public final com.baidu.navisdk.ui.routeguide.ar.f invoke() {
            com.baidu.navisdk.ui.routeguide.ar.f fVar = new com.baidu.navisdk.ui.routeguide.ar.f();
            fVar.c = a.this.j;
            fVar.b = a.this.i;
            return fVar;
        }
    }

    static {
        new C0413a(null);
    }

    public a() {
        com.baidu.navisdk.pronavi.util.a aVar = com.baidu.navisdk.pronavi.util.a.h;
        this.i = aVar.d() / 3;
        this.j = aVar.d() / 3;
        this.l = 2;
        this.r = XIxXXX0x0.oIX0oI(f.f8448a);
        this.s = XIxXXX0x0.I0Io(LazyThreadSafetyMode.NONE, new h());
        this.t = new g();
    }

    private final void A() {
        com.baidu.navisdk.ui.routeguide.asr.c.n().b(10, true);
        BNCommSettingManager bNCommSettingManager = BNCommSettingManager.getInstance();
        IIX0o.oO(bNCommSettingManager, "BNCommSettingManager.getInstance()");
        if (bNCommSettingManager.getPrefRealEnlargementNavi()) {
            BNRouteGuider.getInstance().enableExpandmapDownload(true);
        }
    }

    private final void B() {
        com.baidu.navisdk.ui.routeguide.asr.c.n().b(10, false);
        BNRouteGuider.getInstance().enableExpandmapDownload(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C() {
        com.baidu.navisdk.module.ar.e eVar = this.f8443a;
        if (eVar != null && eVar.g()) {
            this.t.a();
        }
    }

    private final void D() {
        com.baidu.navisdk.module.ar.e eVar = this.f8443a;
        if (eVar != null && eVar.i()) {
            this.t.b();
        }
    }

    private final void E() {
        x.b().R(true);
        BNMapController.getInstance().setSimpleModeGuide(true ^ com.baidu.navisdk.ui.routeguide.utils.b.x());
    }

    private final void f(boolean z) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNArController", "onDestroy: " + z);
        }
        if (z) {
            p();
        }
        com.baidu.navisdk.ui.routeguide.ar.b bVar = this.q;
        if (bVar != null) {
            bVar.c();
        }
        com.baidu.navisdk.module.ar.e eVar = this.f8443a;
        if (eVar != null) {
            eVar.d();
        }
        this.f8443a = null;
        com.baidu.navisdk.ui.routeguide.ar.g gVar2 = this.o;
        if (gVar2 != null) {
            gVar2.b();
        }
        this.o = null;
        com.baidu.navisdk.ui.routeguide.ar.e eVar2 = this.n;
        if (eVar2 != null) {
            com.baidu.navisdk.ui.routeguide.mapmode.a b2 = x.b();
            IIX0o.oO(b2, "RGViewController.getInstance()");
            eVar2.a(b2.s2());
        }
        this.n = null;
        s();
        this.d = false;
        this.e = 0;
        v().f6817a = this.e;
        q();
        ArrayList<com.baidu.navisdk.framework.interfaces.pronavi.hd.a> arrayList = this.h;
        if (arrayList != null) {
            arrayList.clear();
        }
        this.b = null;
        this.c = null;
        z();
    }

    private final void g(int i) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNArController", "handlePreload: ");
        }
        if (BNSettingManager.isArMockEnable()) {
            com.baidu.navisdk.module.ar.e eVar = this.f8443a;
            if (eVar != null) {
                eVar.b("/sdcard/BaiduAr/tracker/01");
            }
            com.baidu.navisdk.module.ar.e eVar2 = this.f8443a;
            if (eVar2 != null) {
                eVar2.a(this);
            }
        }
        h(i);
    }

    private final void j(int i) {
        com.baidu.navisdk.ui.routeguide.subview.a aVar;
        com.baidu.navisdk.ui.routeguide.subview.a aVar2;
        com.baidu.navisdk.ui.routeguide.subview.a aVar3;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNArController", "onEnterArNavi");
        }
        B();
        if (!c(RGFSMTable.FsmState.SimpleGuide)) {
            WeakReference<com.baidu.navisdk.ui.routeguide.subview.a> weakReference = this.p;
            if (weakReference != null && (aVar3 = weakReference.get()) != null) {
                aVar3.a(3, 0, 0, null);
            }
            if (d(RGFSMTable.FsmState.Fullview)) {
                RouteGuideFSM.getInstance().setFullViewByUser(false);
                WeakReference<com.baidu.navisdk.ui.routeguide.subview.a> weakReference2 = this.p;
                if (weakReference2 != null && (aVar2 = weakReference2.get()) != null) {
                    aVar2.a(3, 0, 0, null);
                }
            }
        } else if (d(RGFSMTable.FsmState.Fullview)) {
            RouteGuideFSM.getInstance().setFullViewByUser(false);
            WeakReference<com.baidu.navisdk.ui.routeguide.subview.a> weakReference3 = this.p;
            if (weakReference3 != null && (aVar = weakReference3.get()) != null) {
                aVar.a(3, 0, 0, null);
            }
        }
        x.b().n(3);
        r();
        g(i);
        d(true);
    }

    private final void n() {
        boolean z;
        com.baidu.navisdk.ui.routeguide.mapmode.a b2 = x.b();
        IIX0o.oO(b2, "RGViewController.getInstance()");
        com.baidu.navisdk.framework.interfaces.pronavi.hd.b[] G = b2.G();
        if (G != null) {
            if (G.length == 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                a((com.baidu.navisdk.framework.interfaces.pronavi.hd.b[]) Arrays.copyOf(G, G.length));
            }
        }
        a(this.n, this.o);
        com.baidu.navisdk.ui.routeguide.mapmode.a b3 = x.b();
        IIX0o.oO(b3, "RGViewController.getInstance()");
        com.baidu.navisdk.framework.interfaces.pronavi.hd.c[] uiAnimators = b3.H();
        IIX0o.oO(uiAnimators, "uiAnimators");
        a((com.baidu.navisdk.framework.interfaces.pronavi.hd.c[]) Arrays.copyOf(uiAnimators, uiAnimators.length));
        o();
    }

    private final void o() {
        if (this.m == null) {
            com.baidu.navisdk.ui.routeguide.b V = com.baidu.navisdk.ui.routeguide.b.V();
            IIX0o.oO(V, "BNavigator.getInstance()");
            Context c2 = V.c();
            com.baidu.navisdk.ui.routeguide.mapmode.a b2 = x.b();
            IIX0o.oO(b2, "RGViewController.getInstance()");
            this.m = new com.baidu.navisdk.pronavi.hd.hdnavi.animator.a(c2, b2.s0());
        }
        a(this.m);
    }

    private final void p() {
        AnimatorSet animatorSet = this.k;
        if (animatorSet != null) {
            IIX0o.ooOOo0oXI(animatorSet);
            if (animatorSet.isRunning()) {
                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
                if (gVar.d()) {
                    gVar.e("BNArController", "cancelAnimator: ");
                }
                AnimatorSet animatorSet2 = this.k;
                IIX0o.ooOOo0oXI(animatorSet2);
                animatorSet2.cancel();
                this.k = null;
            }
        }
    }

    private final void q() {
        ArrayList<com.baidu.navisdk.framework.interfaces.pronavi.hd.c> arrayList = this.f;
        if (arrayList != null) {
            arrayList.clear();
        }
        ArrayList<com.baidu.navisdk.framework.interfaces.pronavi.hd.b> arrayList2 = this.g;
        if (arrayList2 != null) {
            arrayList2.clear();
        }
    }

    private final void r() {
        s.T().e(115);
    }

    private final void s() {
        D();
        com.baidu.navisdk.module.ar.e eVar = this.f8443a;
        if (eVar != null) {
            eVar.h();
        }
        this.f8443a = null;
    }

    private final com.baidu.navisdk.module.ar.model.a t() {
        com.baidu.navisdk.module.ar.model.a aVar = new com.baidu.navisdk.module.ar.model.a();
        aVar.b(a0.e());
        String k = a0.k();
        IIX0o.oO(k, "PackageUtil.getVersionName()");
        aVar.a(k);
        c.b bVar = com.baidu.navisdk.module.ar.c.h;
        aVar.a(bVar.a().c() | (bVar.a().b() << 8) | (bVar.a().d() << 16));
        HashMap<String, String> a2 = bVar.a().a();
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNArController", "getConfig: " + a2);
        }
        for (Map.Entry<String, String> entry : a2.entrySet()) {
            String key = entry.getKey();
            switch (key.hashCode()) {
                case -2026746937:
                    if (key.equals("lanesegment")) {
                        aVar.c(entry.getValue());
                        break;
                    } else {
                        break;
                    }
                case -1067310595:
                    if (key.equals("traffic")) {
                        aVar.h(entry.getValue());
                        break;
                    } else {
                        break;
                    }
                case -339647125:
                    if (key.equals("engine_resource")) {
                        aVar.g(entry.getValue());
                        break;
                    } else {
                        break;
                    }
                case 208254806:
                    if (key.equals("traffic_night")) {
                        aVar.i(entry.getValue());
                        break;
                    } else {
                        break;
                    }
                case 341959072:
                    if (key.equals("lanesegment_night")) {
                        aVar.d(entry.getValue());
                        break;
                    } else {
                        break;
                    }
                case 1048254406:
                    if (key.equals("detector")) {
                        aVar.e(entry.getValue());
                        break;
                    } else {
                        break;
                    }
                case 2012967519:
                    if (key.equals("detector_night")) {
                        aVar.f(entry.getValue());
                        break;
                    } else {
                        break;
                    }
            }
        }
        return aVar;
    }

    private final g.b u() {
        return (g.b) this.r.getValue();
    }

    private final com.baidu.navisdk.framework.interfaces.pronavi.hd.f v() {
        return (com.baidu.navisdk.framework.interfaces.pronavi.hd.f) this.s.getValue();
    }

    private final boolean w() {
        com.baidu.navisdk.ui.routeguide.mapmode.a b2 = x.b();
        IIX0o.oO(b2, "RGViewController.getInstance()");
        if (!b2.f2()) {
            com.baidu.navisdk.ui.routeguide.mapmode.a b3 = x.b();
            IIX0o.oO(b3, "RGViewController.getInstance()");
            if (!b3.N2()) {
                return false;
            }
        }
        return true;
    }

    private final boolean x() {
        if (this.l == 1) {
            return true;
        }
        return false;
    }

    private final void y() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNArController", "onExitArNavi");
        }
        A();
        d(false);
        com.baidu.navisdk.ui.routeguide.utils.b.B();
        com.baidu.navisdk.ui.routeguide.ace.a a2 = com.baidu.navisdk.ui.routeguide.ace.a.g.a();
        if (a2 != null) {
            a2.b();
        }
    }

    private final void z() {
        ProNaviStatItem.O().y();
        ProNaviStatItem.O().x();
        ProNaviStatItem.O().w();
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.multinavi.c
    public void h() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNArController", "onSizeChange");
        }
        com.baidu.navisdk.ui.routeguide.ar.e eVar = this.n;
        if (eVar != null) {
            eVar.b();
        }
        com.baidu.navisdk.ui.routeguide.ar.g gVar2 = this.o;
        if (gVar2 != null) {
            gVar2.c();
        }
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.multinavi.c
    public void i() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNArController", "destroy");
        }
        f(true);
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.multinavi.a
    public boolean k() {
        int i = this.e;
        if (i != 0 && i != -1) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.multinavi.a
    public void l() {
        WeakReference<com.baidu.navisdk.ui.routeguide.subview.a> weakReference;
        com.baidu.navisdk.ui.routeguide.subview.a aVar;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNArController", "exitARNavi: " + this.e + TokenParser.SP);
        }
        if (c(RGFSMTable.FsmState.BrowseMap) && (weakReference = this.p) != null && (aVar = weakReference.get()) != null) {
            aVar.a(3, 0, 0, null);
        }
        f(0);
        if (com.baidu.navisdk.ui.routeguide.utils.b.x() || w()) {
            E();
        }
        int c2 = com.baidu.navisdk.module.newguide.controllers.c.c(BNSettingManager.getArNavOrientation());
        int screenOrientationMode = BNCommSettingManager.getInstance().getScreenOrientationMode();
        if (gVar.d()) {
            gVar.e("BNArController", "exitARNavi: curARNaviMode: " + c2 + ", userSettingNaviMode:" + screenOrientationMode);
        }
        if (c2 != screenOrientationMode) {
            com.baidu.navisdk.module.newguide.controllers.c.a(screenOrientationMode);
        }
        f(false);
    }

    public void m() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNArController", "onResume");
        }
        com.baidu.navisdk.module.ar.e eVar = this.f8443a;
        if (eVar != null) {
            eVar.e();
        }
        com.baidu.navisdk.module.ar.e eVar2 = this.f8443a;
        if (eVar2 != null) {
            eVar2.f();
        }
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.multinavi.c
    public void onBackground() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNArController", "onBackground");
        }
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.multinavi.c
    public void onForeground() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNArController", "onForeground");
        }
    }

    @Override // com.baidu.navisdk.module.pronavi.abs.b
    public void release() {
    }

    private final void b(int i, boolean z) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNArController", "enterFullHD from: " + i + ',' + z);
        }
        p();
        ArrayList<com.baidu.navisdk.framework.interfaces.pronavi.hd.b> arrayList = this.g;
        if (arrayList != null) {
            IIX0o.ooOOo0oXI(arrayList);
            if (!arrayList.isEmpty()) {
                ArrayList<com.baidu.navisdk.framework.interfaces.pronavi.hd.b> arrayList2 = this.g;
                IIX0o.ooOOo0oXI(arrayList2);
                Iterator<com.baidu.navisdk.framework.interfaces.pronavi.hd.b> it = arrayList2.iterator();
                while (it.hasNext()) {
                    com.baidu.navisdk.framework.interfaces.pronavi.hd.b next = it.next();
                    if (next != null) {
                        next.b(i, e(z), z, v());
                    }
                }
            }
        }
        ArrayList<com.baidu.navisdk.framework.interfaces.pronavi.hd.c> arrayList3 = this.f;
        if (arrayList3 != null) {
            IIX0o.ooOOo0oXI(arrayList3);
            if (arrayList3.isEmpty()) {
                return;
            }
            this.k = new AnimatorSet();
            ArrayList<com.baidu.navisdk.framework.interfaces.pronavi.hd.c> arrayList4 = this.f;
            IIX0o.ooOOo0oXI(arrayList4);
            Iterator<com.baidu.navisdk.framework.interfaces.pronavi.hd.c> it2 = arrayList4.iterator();
            while (it2.hasNext()) {
                com.baidu.navisdk.framework.interfaces.pronavi.hd.c next2 = it2.next();
                List<Animator> d2 = next2 != null ? next2.d(i, e(z), z, v()) : null;
                if (d2 != null && !d2.isEmpty()) {
                    AnimatorSet animatorSet = this.k;
                    IIX0o.ooOOo0oXI(animatorSet);
                    animatorSet.playTogether(d2);
                }
            }
            AnimatorSet animatorSet2 = this.k;
            if (animatorSet2 != null) {
                animatorSet2.setDuration(300L);
                animatorSet2.addListener(new d(i, z));
                animatorSet2.start();
            }
        }
    }

    private final boolean c(String str) {
        RouteGuideFSM routeGuideFSM = RouteGuideFSM.getInstance();
        IIX0o.oO(routeGuideFSM, "RouteGuideFSM.getInstance()");
        return IIX0o.Oxx0IOOO(str, routeGuideFSM.getCurrentState());
    }

    private final boolean d(String str) {
        return IIX0o.Oxx0IOOO(str, RouteGuideFSM.getCurrentGlassState());
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.multinavi.a
    public void e(int i) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNArController", "onAngleAdjustEnter: :" + this.e + org.apache.commons.text.oIX0oI.f33048oxoX + i);
        }
        f(i);
        a(i, this.l);
    }

    private final void c(int i, boolean z) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNArController", "enterNormal from: " + i + ',' + z);
        }
        y();
        p();
        ArrayList<com.baidu.navisdk.framework.interfaces.pronavi.hd.b> arrayList = this.g;
        if (arrayList != null) {
            IIX0o.ooOOo0oXI(arrayList);
            if (!arrayList.isEmpty()) {
                ArrayList<com.baidu.navisdk.framework.interfaces.pronavi.hd.b> arrayList2 = this.g;
                IIX0o.ooOOo0oXI(arrayList2);
                Iterator<com.baidu.navisdk.framework.interfaces.pronavi.hd.b> it = arrayList2.iterator();
                while (it.hasNext()) {
                    com.baidu.navisdk.framework.interfaces.pronavi.hd.b next = it.next();
                    if (next != null) {
                        next.f(i, e(z), z, v());
                    }
                }
            }
        }
        ArrayList<com.baidu.navisdk.framework.interfaces.pronavi.hd.c> arrayList3 = this.f;
        if (arrayList3 != null) {
            IIX0o.ooOOo0oXI(arrayList3);
            if (!arrayList3.isEmpty()) {
                this.k = new AnimatorSet();
                ArrayList<com.baidu.navisdk.framework.interfaces.pronavi.hd.c> arrayList4 = this.f;
                IIX0o.ooOOo0oXI(arrayList4);
                Iterator<com.baidu.navisdk.framework.interfaces.pronavi.hd.c> it2 = arrayList4.iterator();
                while (it2.hasNext()) {
                    com.baidu.navisdk.framework.interfaces.pronavi.hd.c next2 = it2.next();
                    List<Animator> c2 = next2 != null ? next2.c(i, e(z), z, v()) : null;
                    if (c2 != null) {
                        Set singleton = Collections.singleton(null);
                        IIX0o.oO(singleton, "Collections.singleton(null)");
                        c2.removeAll(singleton);
                    }
                    if (c2 != null && !c2.isEmpty()) {
                        AnimatorSet animatorSet = this.k;
                        IIX0o.ooOOo0oXI(animatorSet);
                        animatorSet.playTogether(c2);
                    }
                }
                AnimatorSet animatorSet2 = this.k;
                if (animatorSet2 != null) {
                    animatorSet2.setDuration(300L);
                    animatorSet2.addListener(new e(i));
                    animatorSet2.start();
                }
            }
        }
        f(false);
    }

    private final void d(boolean z) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNArController", "changeWidgetStyle " + z);
        }
        com.baidu.navisdk.pronavi.style.i.b g2 = com.baidu.navisdk.ui.routeguide.utils.b.g();
        if (g2 != null) {
            if (z) {
                e.a aVar = com.baidu.navisdk.pronavi.style.e.b;
                com.baidu.navisdk.pronavi.style.e a2 = e.a.a(aVar, 0, 0.0f, 3, null);
                int i = R.color.bnav_ar_navi_btn_txt_color;
                g2.a("RGCommonWidget", com.baidu.navisdk.pronavi.style.e.d(com.baidu.navisdk.pronavi.style.e.c(a2, i, null, 2, null), R.drawable.bnav_ic_ar_btn_bg, null, 2, null).a(), 0);
                com.baidu.navisdk.pronavi.style.e a3 = e.a.a(aVar, 0, 0.0f, 3, null);
                int i2 = R.color.nsdk_white_color;
                g2.a("RGSpeedKey", "RGNormalSpeed", com.baidu.navisdk.pronavi.style.e.d(com.baidu.navisdk.pronavi.style.e.c(a3, i2, null, 2, null), R.drawable.bnav_ic_ar_normal_speed, null, 2, null).a(), false, 0);
                g2.a("RGSpeedKey", "RGOverSpeed", com.baidu.navisdk.pronavi.style.e.d(com.baidu.navisdk.pronavi.style.e.c(e.a.a(aVar, 0, 0.0f, 3, null), i2, null, 2, null), R.drawable.bnav_ic_ar_over_speed, null, 2, null).a(), true, 0);
                com.baidu.navisdk.pronavi.style.e e2 = e.a.a(aVar, 0, 0.0f, 3, null).e(i2, "text_color");
                int i3 = R.drawable.bnav_ar_navi_interval_camera_bg;
                g2.a("IntervalSpeed", e2.f(i3, "portrait_bg").f(i3, "land_bg").c(R.drawable.bnav_ar_navi_interval_speed_normal_bg, "average_speed_bg").c(R.drawable.bnav_ar_interval_speed_over_bg, "over_speed_bg").b(R.color.bnav_ar_interval_line, "line_color").a(), 0);
                d.a.C0333a a4 = e.a.a(aVar, 0, 0.0f, 3, null).a("bridge_on");
                int i4 = R.drawable.bnav_ic_white_bridge_on;
                d.a.C0333a a5 = a4.b(i4).d(R.string.nsdk_string_rg_on_bridge).a().a("bridge_under");
                int i5 = R.drawable.bnav_ic_white_bridge_under;
                g2.a("bridge", a5.b(i5).d(R.string.nsdk_string_rg_under_bridge).a().a(), 0);
                d.a.C0333a a6 = e.a.a(aVar, 0, 0.0f, 3, null).a("main_road");
                int i6 = R.drawable.bnav_ic_white_main_road;
                d.a.C0333a a7 = a6.b(i6).d(R.string.nsdk_string_rg_in_main_road).a().a("road_auxiliary");
                int i7 = R.drawable.bnav_ic_white_auxiliary_road;
                g2.a("road", a7.b(i7).d(R.string.nsdk_string_rg_in_auxiliary_road).a().a(), 0);
                g2.a("DynamicBtnCollectView", e.a.a(aVar, 0, 0.0f, 3, null).b(i, "RGDynamicBtnTitleColor").f(R.drawable.bnav_rg_btn_hd_new_transparency_bg, "RGDynamicBg").c(i4, "dynamic_bridge_on").c(i5, "dynamic_bridge_under").c(i6, "dynamic_main_road").c(i7, "dynamic_road_auxiliary").b(i2, "RGDynamicBtnUgcIc").a(), 0);
                return;
            }
            g2.a("RGCommonWidget");
            g2.a("RGContinueNavi");
            g2.a("RGNormalSpeed");
            g2.a("RGOverSpeed");
            g2.a("IntervalSpeed");
            g2.a("NormalSimpleGuidePanel");
            g2.a("road");
            g2.a("bridge");
            g2.a("DynamicBtnCollectView");
        }
    }

    public void a(@NonNull @OOXIXo Activity activity, @OOXIXo ViewGroup parentViewGroup, @oOoXoXO com.baidu.navisdk.ui.routeguide.subview.a aVar) {
        com.baidu.navisdk.module.ar.e eVar;
        com.baidu.navisdk.module.ar.e eVar2;
        IIX0o.x0xO0oo(activity, "activity");
        IIX0o.x0xO0oo(parentViewGroup, "parentViewGroup");
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNArController", "enterARNavi: " + this.e);
        }
        com.baidu.navisdk.util.statistic.userop.b.r().b("3.1.5.1");
        boolean z = false;
        BNRouteGuider.getInstance().setHdLaneMapMode(false);
        BNRouteGuider.getInstance().setCommonRoadHDLaneMapMode(false);
        com.baidu.navisdk.ui.routeguide.utils.b.b("arNavi", false);
        com.baidu.navisdk.ui.routeguide.ace.a a2 = com.baidu.navisdk.ui.routeguide.ace.a.g.a();
        if (a2 != null) {
            a2.a();
        }
        this.b = activity;
        this.c = parentViewGroup;
        this.p = new WeakReference<>(aVar);
        if (this.f8443a == null) {
            Activity activity2 = this.b;
            IIX0o.ooOOo0oXI(activity2);
            this.f8443a = new com.baidu.navisdk.module.ar.e(activity2);
        }
        if (!com.baidu.navisdk.ui.routeguide.utils.b.x() && !w()) {
            z = true;
        }
        this.d = z;
        int arNavOrientation = com.baidu.navisdk.module.abtest.model.a.v() ? 2 : BNSettingManager.getArNavOrientation();
        com.baidu.navisdk.ui.routeguide.mapmode.a b2 = x.b();
        IIX0o.oO(b2, "RGViewController.getInstance()");
        this.l = b2.d0();
        j(3);
        com.baidu.navisdk.module.ar.e eVar3 = this.f8443a;
        if (eVar3 != null) {
            eVar3.a(t());
        }
        com.baidu.navisdk.module.abtest.model.a w = com.baidu.navisdk.module.abtest.model.a.w();
        IIX0o.oO(w, "ABARNaviData.getInstance()");
        if (!TextUtils.isEmpty(w.t()) && (eVar2 = this.f8443a) != null) {
            com.baidu.navisdk.module.abtest.model.a w2 = com.baidu.navisdk.module.abtest.model.a.w();
            IIX0o.oO(w2, "ABARNaviData.getInstance()");
            eVar2.a(w2.t());
        }
        com.baidu.navisdk.module.ar.e eVar4 = this.f8443a;
        if (eVar4 != null) {
            eVar4.c();
        }
        com.baidu.navisdk.module.ar.e eVar5 = this.f8443a;
        if (eVar5 != null) {
            eVar5.f();
        }
        if (BNSettingManager.isArRecordEnable()) {
            com.baidu.navisdk.util.worker.lite.a.a((com.baidu.navisdk.util.worker.lite.b) new b("ArRecord"), 5000L);
        }
        f(3);
        if (!this.d) {
            E();
        }
        this.l = arNavOrientation;
        com.baidu.navisdk.module.newguide.controllers.c.a(com.baidu.navisdk.module.newguide.controllers.c.c(arNavOrientation));
        if (this.q == null && (eVar = this.f8443a) != null) {
            IIX0o.ooOOo0oXI(eVar);
            this.q = new com.baidu.navisdk.ui.routeguide.ar.b(eVar);
        }
        com.baidu.navisdk.ui.routeguide.ar.b bVar = this.q;
        if (bVar != null) {
            bVar.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(int i) {
        com.baidu.navisdk.util.logic.g j = com.baidu.navisdk.util.logic.g.j();
        IIX0o.oO(j, "BNLocationManagerProxy.getInstance()");
        com.baidu.navisdk.model.datastruct.g a2 = j.a();
        if (a2 == null) {
            a2 = new com.baidu.navisdk.model.datastruct.g();
            a2.b = 113.938418d;
            a2.f6926a = 22.527962d;
            a2.o = 0;
            a2.j = System.currentTimeMillis();
        }
        a2.k = i;
        double d2 = 100000;
        BNRouteGuider.getInstance().triggerGPSDataChange((int) (a2.b * d2), (int) (a2.f6926a * d2), a2.c, a2.e, a2.f, (float) a2.h, a2.g, a2.k, a2.j, 2, a2.o, a2.a());
    }

    private final void h(int i) {
        if (this.o == null) {
            com.baidu.navisdk.ui.routeguide.ar.g gVar = new com.baidu.navisdk.ui.routeguide.ar.g(this.i, this.j, u());
            this.o = gVar;
            IIX0o.ooOOo0oXI(gVar);
            com.baidu.navisdk.ui.routeguide.b V = com.baidu.navisdk.ui.routeguide.b.V();
            IIX0o.oO(V, "BNavigator.getInstance()");
            Context c2 = V.c();
            IIX0o.oO(c2, "BNavigator.getInstance().context");
            ViewGroup viewGroup = this.c;
            com.baidu.navisdk.module.ar.e eVar = this.f8443a;
            View b2 = eVar != null ? eVar.b() : null;
            boolean x = x();
            com.baidu.navisdk.ui.routeguide.mapmode.a b3 = x.b();
            IIX0o.oO(b3, "RGViewController.getInstance()");
            gVar.a(c2, viewGroup, b2, i, x, b3.s0(), this);
            a(this.o);
        }
        if (this.n == null) {
            com.baidu.navisdk.ui.routeguide.ar.e eVar2 = new com.baidu.navisdk.ui.routeguide.ar.e(this.i, this.j, x());
            this.n = eVar2;
            IIX0o.ooOOo0oXI(eVar2);
            eVar2.a();
            a(this.n);
        }
    }

    private final int e(boolean z) {
        return z ? this.i : this.j;
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.multinavi.c
    public int j() {
        return this.e;
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.multinavi.a
    public int b(boolean z) {
        return z ? this.i : this.j;
    }

    private final void f(int i) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNArController", "handleHDStateSwitch toState: " + i + " ,mCurrentState:" + this.e);
        }
        if (i == this.e) {
            return;
        }
        q();
        n();
        int i2 = this.e;
        this.e = i;
        v().f6817a = this.e;
        com.baidu.navisdk.ui.routeguide.mapmode.a b2 = x.b();
        IIX0o.oO(b2, "RGViewController.getInstance()");
        boolean s2 = b2.s2();
        a(i2, this.e, s2);
        if (i == 0) {
            x.b().n(3);
        }
        if (i == 0 || i2 == 0) {
            x.b().r3();
        }
        if (i == 0) {
            c(i2, s2);
        } else if (i == 2) {
            a(i2, s2);
        } else {
            if (i != 3) {
                return;
            }
            b(i2, s2);
        }
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.multinavi.a
    public void c(int i) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNArController", "switchOrientation " + i + TokenParser.SP);
        }
        BNSettingManager.setArNavOrientation(i);
        com.baidu.navisdk.module.newguide.controllers.c.a(com.baidu.navisdk.module.newguide.controllers.c.c(i));
        if (i == 2) {
            ProNaviStatItem.O().x();
        } else {
            ProNaviStatItem.O().A();
        }
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.multinavi.c
    public void a(int i) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNArController", "onUserSwitchState:" + this.e + org.apache.commons.text.oIX0oI.f33048oxoX + i);
        }
        BNSettingManager.setArNavState(i);
        f(i);
        if (i == 2) {
            ProNaviStatItem.O().w();
        } else {
            ProNaviStatItem.O().z();
        }
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.multinavi.c
    public void a(@oOoXoXO ViewGroup viewGroup, int i) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNArController", "orientationChange: " + i);
        }
        this.l = i;
        com.baidu.navisdk.module.ar.e eVar = this.f8443a;
        if (eVar != null) {
            eVar.a(i);
        }
        com.baidu.navisdk.ui.routeguide.ar.g gVar2 = this.o;
        if (gVar2 != null) {
            com.baidu.navisdk.ui.routeguide.mapmode.a b2 = x.b();
            IIX0o.oO(b2, "RGViewController.getInstance()");
            gVar2.a(i, viewGroup, b2.s0());
        }
        com.baidu.navisdk.ui.routeguide.ar.e eVar2 = this.n;
        if (eVar2 != null) {
            eVar2.a(i);
        }
        com.baidu.navisdk.pronavi.hd.hdnavi.animator.a aVar = this.m;
        if (aVar != null) {
            aVar.a(viewGroup, i);
        }
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.multinavi.c
    public void a(boolean z) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNArController", "updateStyle: " + z);
        }
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.multinavi.c
    public void a(@OOXIXo com.baidu.navisdk.framework.interfaces.pronavi.hd.c... uiAnimators) {
        IIX0o.x0xO0oo(uiAnimators, "uiAnimators");
        if (uiAnimators.length == 0) {
            return;
        }
        if (this.f == null) {
            this.f = new ArrayList<>(12);
        }
        for (com.baidu.navisdk.framework.interfaces.pronavi.hd.c cVar : uiAnimators) {
            if (cVar != null) {
                ArrayList<com.baidu.navisdk.framework.interfaces.pronavi.hd.c> arrayList = this.f;
                IIX0o.ooOOo0oXI(arrayList);
                if (!arrayList.contains(cVar)) {
                    ArrayList<com.baidu.navisdk.framework.interfaces.pronavi.hd.c> arrayList2 = this.f;
                    IIX0o.ooOOo0oXI(arrayList2);
                    arrayList2.add(cVar);
                }
            }
        }
    }

    public void a(@OOXIXo com.baidu.navisdk.framework.interfaces.pronavi.hd.b... uiSwitches) {
        IIX0o.x0xO0oo(uiSwitches, "uiSwitches");
        if (uiSwitches.length == 0) {
            return;
        }
        if (this.g == null) {
            this.g = new ArrayList<>(8);
        }
        for (com.baidu.navisdk.framework.interfaces.pronavi.hd.b bVar : uiSwitches) {
            if (bVar != null) {
                ArrayList<com.baidu.navisdk.framework.interfaces.pronavi.hd.b> arrayList = this.g;
                IIX0o.ooOOo0oXI(arrayList);
                if (!arrayList.contains(bVar)) {
                    ArrayList<com.baidu.navisdk.framework.interfaces.pronavi.hd.b> arrayList2 = this.g;
                    IIX0o.ooOOo0oXI(arrayList2);
                    arrayList2.add(bVar);
                }
            }
        }
    }

    public void a(@oOoXoXO com.baidu.navisdk.framework.interfaces.pronavi.hd.a aVar) {
        if (aVar == null) {
            return;
        }
        if (this.h == null) {
            this.h = new ArrayList<>(8);
        }
        ArrayList<com.baidu.navisdk.framework.interfaces.pronavi.hd.a> arrayList = this.h;
        IIX0o.ooOOo0oXI(arrayList);
        if (arrayList.contains(aVar)) {
            return;
        }
        ArrayList<com.baidu.navisdk.framework.interfaces.pronavi.hd.a> arrayList2 = this.h;
        IIX0o.ooOOo0oXI(arrayList2);
        arrayList2.add(aVar);
    }

    private final void a(int i, int i2, boolean z) {
        ArrayList<com.baidu.navisdk.framework.interfaces.pronavi.hd.a> arrayList = this.h;
        if (arrayList != null) {
            IIX0o.ooOOo0oXI(arrayList);
            Iterator<com.baidu.navisdk.framework.interfaces.pronavi.hd.a> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().onHdStateSwitch(i, i2, z);
            }
        }
    }

    private final void a(int i, boolean z) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNArController", "enterDoubleMap from: " + i + ',' + z);
        }
        p();
        ArrayList<com.baidu.navisdk.framework.interfaces.pronavi.hd.b> arrayList = this.g;
        if (arrayList != null) {
            IIX0o.ooOOo0oXI(arrayList);
            if (!arrayList.isEmpty()) {
                ArrayList<com.baidu.navisdk.framework.interfaces.pronavi.hd.b> arrayList2 = this.g;
                IIX0o.ooOOo0oXI(arrayList2);
                Iterator<com.baidu.navisdk.framework.interfaces.pronavi.hd.b> it = arrayList2.iterator();
                while (it.hasNext()) {
                    com.baidu.navisdk.framework.interfaces.pronavi.hd.b next = it.next();
                    if (next != null) {
                        next.e(i, e(z), z, v());
                    }
                }
            }
        }
        ArrayList<com.baidu.navisdk.framework.interfaces.pronavi.hd.c> arrayList3 = this.f;
        if (arrayList3 != null) {
            IIX0o.ooOOo0oXI(arrayList3);
            if (arrayList3.isEmpty()) {
                return;
            }
            this.k = new AnimatorSet();
            ArrayList<com.baidu.navisdk.framework.interfaces.pronavi.hd.c> arrayList4 = this.f;
            IIX0o.ooOOo0oXI(arrayList4);
            Iterator<com.baidu.navisdk.framework.interfaces.pronavi.hd.c> it2 = arrayList4.iterator();
            while (it2.hasNext()) {
                com.baidu.navisdk.framework.interfaces.pronavi.hd.c next2 = it2.next();
                List<Animator> a2 = next2 != null ? next2.a(i, e(z), z, v()) : null;
                if (a2 != null && !a2.isEmpty()) {
                    AnimatorSet animatorSet = this.k;
                    IIX0o.ooOOo0oXI(animatorSet);
                    animatorSet.playTogether(a2);
                }
            }
            AnimatorSet animatorSet2 = this.k;
            if (animatorSet2 != null) {
                animatorSet2.setDuration(300L);
                animatorSet2.addListener(new c(i));
                animatorSet2.start();
            }
        }
    }

    @Override // com.baidu.navisdk.module.ar.tracker.e
    public void a(@OOXIXo Location loc) {
        IIX0o.x0xO0oo(loc, "loc");
        n.a(loc);
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.multinavi.a
    public void a(@oOoXoXO com.baidu.navisdk.ui.routeguide.subview.a aVar) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNArController", "exitNavi: " + aVar);
        }
        if (aVar != null) {
            aVar.m();
            k.x().t();
        }
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.multinavi.c
    @OOXIXo
    public com.baidu.navisdk.framework.interfaces.pronavi.hd.f a() {
        return v();
    }

    private final void a(int i, int i2) {
        ProNaviStatItem.O().B();
        if (i == 3) {
            ProNaviStatItem.O().z();
        }
        if (i2 != 2) {
            ProNaviStatItem.O().A();
        }
    }
}
