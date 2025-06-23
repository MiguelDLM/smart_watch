package com.baidu.navisdk.pronavi.ui.guidepanel.lottie;

import OXOo.OOXIXo;
import android.view.ViewGroup;
import com.airbnb.lottie.LottieAnimationView;
import com.baidu.navisdk.pronavi.data.vm.b;
import com.baidu.navisdk.ui.routeguide.widget.e;
import com.baidu.navisdk.util.common.g;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private LottieAnimationView f7920a;
    private e b;

    @OOXIXo
    private ViewGroup c;
    private int d;

    /* renamed from: com.baidu.navisdk.pronavi.ui.guidepanel.lottie.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0354a {
        private C0354a() {
        }

        public /* synthetic */ C0354a(IIXOooo iIXOooo) {
            this();
        }
    }

    static {
        new C0354a(null);
    }

    public a(@OOXIXo ViewGroup mRootViewGroup, int i) {
        IIX0o.x0xO0oo(mRootViewGroup, "mRootViewGroup");
        this.c = mRootViewGroup;
        this.d = i;
        c();
    }

    private final void c() {
        LottieAnimationView lottieAnimationView = (LottieAnimationView) this.c.findViewById(this.d);
        this.f7920a = lottieAnimationView;
        e eVar = this.b;
        if (eVar == null) {
            this.b = new e(this.f7920a, "RGGuide");
        } else {
            eVar.a(lottieAnimationView, false);
        }
    }

    public final void a(@OOXIXo b.C0313b lottieAnimatorData) {
        IIX0o.x0xO0oo(lottieAnimatorData, "lottieAnimatorData");
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGGuidePanelLottieHolder", "showLottieAnimator: " + lottieAnimatorData);
        }
        if (this.c == null) {
            return;
        }
        a(lottieAnimatorData.a(), lottieAnimatorData.b(), lottieAnimatorData.c(), lottieAnimatorData.d());
    }

    public final void b() {
    }

    public final void a() {
        e eVar = this.b;
        if (eVar != null) {
            eVar.a();
        }
    }

    public final void a(@OOXIXo ViewGroup rootViewGroup, int i) {
        IIX0o.x0xO0oo(rootViewGroup, "rootViewGroup");
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGGuidePanelLottieHolder", "onConfigurationChange: " + i);
        }
        this.c = rootViewGroup;
        c();
    }

    public final void a(int i) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGGuidePanelLottieHolder", "changeGuidePanelModel: " + i);
        }
        this.d = i;
        c();
    }

    private final void a(String str, long j, int i, int i2) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGGuidePanelLottieHolder", "playLottieAnimator: " + str + ", " + j + ",  " + i + ", " + i2);
        }
        e eVar = this.b;
        if (eVar != null) {
            eVar.a(str, j, i, i2);
        }
    }
}
