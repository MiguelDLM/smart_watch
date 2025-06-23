package com.baidu.navisdk.pronavi.ui.buttoncollect.fixed;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import Oox.oIX0oI;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.pronavi.style.d;
import com.baidu.navisdk.pronavi.ui.buttoncollect.naviplay.RGNaviPlayView;
import com.baidu.navisdk.ui.widget.expandlayout.BNExpandConstraintLayout;
import com.baidu.navisdk.ui.widget.expandlayout.IExpandItemOnClickListener;
import com.baidu.navisdk.ui.widget.expandlayout.IExpandLayoutChangeListener;
import com.baidu.navisdk.ui.widget.expandlayout.IExpandLayoutStatusCallback;
import com.baidu.navisdk.util.jar.JarUtils;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.LazyThreadSafetyMode;
import kotlin.Pair;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes7.dex */
public final class c extends com.baidu.navisdk.pronavi.ui.base.a implements IExpandItemOnClickListener, IExpandLayoutStatusCallback, IExpandLayoutChangeListener, RGNaviPlayView.b {
    private BNExpandConstraintLayout j;
    private com.baidu.navisdk.pronavi.ui.buttoncollect.fixed.a k;
    private int l;
    private RGNaviPlayView m;
    private final X0IIOO n;
    private com.baidu.navisdk.pronavi.style.i.a o;

    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(IIXOooo iIXOooo) {
            this();
        }
    }

    /* loaded from: classes7.dex */
    public static final class b<T> implements Observer<com.baidu.navisdk.pronavi.ui.buttoncollect.data.a> {
        public b(LifecycleOwner lifecycleOwner) {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(com.baidu.navisdk.pronavi.ui.buttoncollect.data.a it) {
            c cVar = c.this;
            IIX0o.oO(it, "it");
            cVar.a(it);
        }
    }

    /* renamed from: com.baidu.navisdk.pronavi.ui.buttoncollect.fixed.c$c, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0347c<T> implements Observer<ArrayList<com.baidu.navisdk.pronavi.ui.buttoncollect.data.a>> {
        public C0347c(LifecycleOwner lifecycleOwner) {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(ArrayList<com.baidu.navisdk.pronavi.ui.buttoncollect.data.a> it) {
            c cVar = c.this;
            IIX0o.oO(it, "it");
            cVar.a(it);
        }
    }

    /* loaded from: classes7.dex */
    public static final class d<T> implements Observer<Pair<? extends com.baidu.navisdk.pronavi.ui.buttoncollect.data.a, ? extends Integer>> {
        public d(LifecycleOwner lifecycleOwner) {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(Pair<com.baidu.navisdk.pronavi.ui.buttoncollect.data.a, Integer> it) {
            c cVar = c.this;
            IIX0o.oO(it, "it");
            cVar.a(it);
        }
    }

    /* loaded from: classes7.dex */
    public static final class e<T> implements Observer<Pair<? extends Boolean, ? extends Boolean>> {
        public e(LifecycleOwner lifecycleOwner) {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(Pair<Boolean, Boolean> it) {
            c cVar = c.this;
            IIX0o.oO(it, "it");
            cVar.b(it);
        }
    }

    /* loaded from: classes7.dex */
    public static final class f<T> implements Observer<Integer> {
        public f(LifecycleOwner lifecycleOwner) {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(Integer it) {
            c cVar = c.this;
            IIX0o.oO(it, "it");
            cVar.y(it.intValue());
        }
    }

    /* loaded from: classes7.dex */
    public static final class g<T> implements Observer<ArrayList<com.baidu.navisdk.pronavi.ui.buttoncollect.data.a>> {
        public g() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(ArrayList<com.baidu.navisdk.pronavi.ui.buttoncollect.data.a> it) {
            RGNaviPlayView rGNaviPlayView = c.this.m;
            if (rGNaviPlayView != null) {
                IIX0o.oO(it, "it");
                rGNaviPlayView.a(it, c.this.l);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class h extends Lambda implements oIX0oI<Runnable> {

        /* loaded from: classes7.dex */
        public static final class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                RGNaviPlayView rGNaviPlayView = c.this.m;
                if (rGNaviPlayView != null && rGNaviPlayView.getVisibility() == 0) {
                    c.this.s0();
                }
            }
        }

        public h() {
            super(0);
        }

        @Override // Oox.oIX0oI
        @OOXIXo
        public final Runnable invoke() {
            return new a();
        }
    }

    /* loaded from: classes7.dex */
    public static final class i extends com.baidu.navisdk.pronavi.style.c {
        public i(Integer[] numArr) {
            super(numArr);
        }

        @Override // com.baidu.navisdk.pronavi.style.i.a
        @OOXIXo
        public String a() {
            return "FixedBtnCollectView";
        }

        @Override // com.baidu.navisdk.pronavi.style.i.a
        public void b(@oOoXoXO String str) {
            c.this.r0();
        }

        @Override // com.baidu.navisdk.pronavi.style.i.a
        public void c() {
        }

        @Override // com.baidu.navisdk.pronavi.style.c
        public boolean e() {
            return false;
        }

        @Override // com.baidu.navisdk.pronavi.style.c
        public boolean h(@oOoXoXO String str, @OOXIXo HashMap<String, ? super com.baidu.navisdk.pronavi.style.d> styleMap) {
            d.C0334d b;
            IIX0o.x0xO0oo(styleMap, "styleMap");
            int a2 = com.baidu.navisdk.pronavi.style.c.a(this, "RGFixedBtnTitleColor", styleMap, 0, 4, null);
            BNExpandConstraintLayout bNExpandConstraintLayout = c.this.j;
            if (bNExpandConstraintLayout != null) {
                d.C0334d b2 = b("RGTopDynamicBg", styleMap);
                d.C0334d b3 = b("RGBottomFixedBg", styleMap);
                if (b2 != null && b3 != null) {
                    bNExpandConstraintLayout.setDynamicLayoutBg(b2.a());
                    bNExpandConstraintLayout.setBottomFixedLayoutBg(b3.a());
                }
                bNExpandConstraintLayout.setFixedViewIcon(e("RGDynamicHeadViewIcon", styleMap));
            }
            int e = e("RGFixedBtnRefreshIc", styleMap);
            int e2 = e("RGFixedBtnNPPlayIc", styleMap);
            int e3 = e("RGFixedBtnNPWarningIc", styleMap);
            int a3 = com.baidu.navisdk.pronavi.style.c.a(this, "RGFixedBtnUgcIcTintColor", styleMap, 0, 4, null);
            com.baidu.navisdk.pronavi.ui.buttoncollect.fixed.b bVar = (com.baidu.navisdk.pronavi.ui.buttoncollect.fixed.b) ((com.baidu.navisdk.pronavi.ui.base.a) c.this).i.c(com.baidu.navisdk.pronavi.ui.buttoncollect.fixed.b.class);
            if (bVar != null) {
                bVar.a(a2, JarUtils.getResources().getColor(a3));
                bVar.a("refresh", a2, e);
                bVar.a(a2, e2, e3);
                bVar.h();
            }
            RGNaviPlayView rGNaviPlayView = c.this.m;
            if (rGNaviPlayView != null && (b = b("RGFixedNaviPlayBg", styleMap)) != null) {
                com.baidu.navisdk.ui.util.b.a(rGNaviPlayView, b.a());
                return true;
            }
            return true;
        }
    }

    static {
        new a(null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@OOXIXo com.baidu.navisdk.pronavi.ui.base.b uiContext, @oOoXoXO ViewGroup viewGroup) {
        super(uiContext, viewGroup);
        IIX0o.x0xO0oo(uiContext, "uiContext");
        this.n = XIxXXX0x0.I0Io(LazyThreadSafetyMode.NONE, new h());
    }

    private final Runnable p0() {
        return (Runnable) this.n.getValue();
    }

    private final void q0() {
        if (this.o == null) {
            i iVar = new i(new Integer[0]);
            this.o = iVar;
            com.baidu.navisdk.pronavi.style.f.b.a("FixedBtnCollectView", iVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r0() {
        BNExpandConstraintLayout bNExpandConstraintLayout = this.j;
        if (bNExpandConstraintLayout != null) {
            bNExpandConstraintLayout.setDynamicLayoutBg(R.drawable.bnav_rg_btn_new_transparency_bg);
            bNExpandConstraintLayout.setBottomFixedLayoutBg(R.drawable.bnav_rg_btn_new_opaque_bg);
            bNExpandConstraintLayout.setFixedViewIcon(R.drawable.bnav_rg_2_whippletree);
        }
        RGNaviPlayView rGNaviPlayView = this.m;
        if (rGNaviPlayView != null) {
            com.baidu.navisdk.ui.util.b.a(rGNaviPlayView, R.drawable.bnav_rg_btn_new_transparency_bg);
        }
        com.baidu.navisdk.pronavi.ui.buttoncollect.fixed.b bVar = (com.baidu.navisdk.pronavi.ui.buttoncollect.fixed.b) this.i.c(com.baidu.navisdk.pronavi.ui.buttoncollect.fixed.b.class);
        if (bVar != null) {
            bVar.i();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s0() {
        int i2;
        RGNaviPlayView rGNaviPlayView = this.m;
        if (rGNaviPlayView != null) {
            ViewGroup.LayoutParams layoutParams = rGNaviPlayView.getLayoutParams();
            if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                layoutParams = null;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            Rect layoutBgShadow = rGNaviPlayView.getLayoutBgShadow();
            if (marginLayoutParams != null) {
                BNExpandConstraintLayout bNExpandConstraintLayout = this.j;
                if (bNExpandConstraintLayout != null) {
                    i2 = bNExpandConstraintLayout.getViewYForParentView("naviPlay");
                } else {
                    i2 = 0;
                }
                marginLayoutParams.topMargin = i2;
            }
            if (marginLayoutParams != null) {
                marginLayoutParams.setMarginStart(-layoutBgShadow.left);
            }
            rGNaviPlayView.requestLayout();
        }
    }

    private final void w(int i2) {
        int dimensionPixelSize;
        BNExpandConstraintLayout bNExpandConstraintLayout = this.j;
        IIX0o.ooOOo0oXI(bNExpandConstraintLayout);
        ViewGroup.LayoutParams layoutParams = bNExpandConstraintLayout.getLayoutParams();
        if (i2 == 2) {
            dimensionPixelSize = JarUtils.getResources().getDimensionPixelSize(R.dimen.nsdk_rg_control_panel_btn_width);
        } else {
            dimensionPixelSize = JarUtils.getResources().getDimensionPixelSize(R.dimen.nsdk_rg_control_panel_btn_height_new);
        }
        layoutParams.width = dimensionPixelSize;
    }

    private final void x(int i2) {
        int dimensionPixelSize;
        RGNaviPlayView rGNaviPlayView = this.m;
        IIX0o.ooOOo0oXI(rGNaviPlayView);
        ViewGroup.LayoutParams layoutParams = rGNaviPlayView.getLayoutParams();
        if (i2 == 2) {
            dimensionPixelSize = JarUtils.getResources().getDimensionPixelSize(R.dimen.nsdk_rg_control_panel_btn_width);
        } else {
            dimensionPixelSize = JarUtils.getResources().getDimensionPixelSize(R.dimen.nsdk_rg_control_panel_btn_height_new);
        }
        layoutParams.height = dimensionPixelSize;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y(int i2) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGFixedBtnCollectView", "setNaviPlayViewVisible: " + i2);
        }
        RGNaviPlayView rGNaviPlayView = this.m;
        if (rGNaviPlayView != null) {
            if (rGNaviPlayView.getVisibility() != i2) {
                rGNaviPlayView.setVisibility(i2);
            }
            if (i2 == 0) {
                s0();
            }
        }
    }

    @oOoXoXO
    public final View n0() {
        return this.j;
    }

    public final void o0() {
    }

    @Override // com.baidu.navisdk.ui.widget.expandlayout.IExpandLayoutStatusCallback
    public void onAnimStart4StatusChange(@OOXIXo BNExpandConstraintLayout.State curStatus) {
        String str;
        com.baidu.navisdk.pronavi.ui.base.b bVar;
        com.baidu.navisdk.pronavi.ui.buttoncollect.fixed.b bVar2;
        IIX0o.x0xO0oo(curStatus, "curStatus");
        if (curStatus == BNExpandConstraintLayout.State.CLOSE && (bVar = this.i) != null && (bVar2 = (com.baidu.navisdk.pronavi.ui.buttoncollect.fixed.b) bVar.c(com.baidu.navisdk.pronavi.ui.buttoncollect.fixed.b.class)) != null) {
            bVar2.f().setValue(8);
        }
        if (curStatus == BNExpandConstraintLayout.State.OPEN) {
            str = "1";
        } else {
            str = "2";
        }
        com.baidu.navisdk.util.statistic.userop.b.r().d("35.0.1.1425", str);
    }

    @Override // com.baidu.navisdk.ui.widget.expandlayout.IExpandItemOnClickListener
    public void onClickBottomFixedItem(@oOoXoXO String str, @OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGFixedBtnCollectView", "onClickBottomFixedItem: " + str);
        }
        com.baidu.navisdk.pronavi.ui.buttoncollect.fixed.b bVar = (com.baidu.navisdk.pronavi.ui.buttoncollect.fixed.b) this.i.c(com.baidu.navisdk.pronavi.ui.buttoncollect.fixed.b.class);
        if (bVar != null) {
            bVar.a(str, view);
        }
    }

    @Override // com.baidu.navisdk.ui.widget.expandlayout.IExpandItemOnClickListener
    public void onClickDynamicItem(@oOoXoXO String str, @OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGFixedBtnCollectView", "onClickDynamicItem: " + str);
        }
        com.baidu.navisdk.pronavi.ui.buttoncollect.fixed.b bVar = (com.baidu.navisdk.pronavi.ui.buttoncollect.fixed.b) this.i.c(com.baidu.navisdk.pronavi.ui.buttoncollect.fixed.b.class);
        if (bVar != null) {
            bVar.b(str, view);
        }
    }

    @Override // com.baidu.navisdk.ui.widget.expandlayout.IExpandItemOnClickListener
    public boolean onClickTopFixedItem(@OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        BNExpandConstraintLayout bNExpandConstraintLayout = this.j;
        if (bNExpandConstraintLayout == null) {
            return false;
        }
        if (bNExpandConstraintLayout.isOpen()) {
            BNExpandConstraintLayout.close$default(bNExpandConstraintLayout, false, 1, null);
            com.baidu.navisdk.util.statistic.userop.b.r().a("35.0.1.1426", "2", "1");
        } else {
            BNExpandConstraintLayout.open$default(bNExpandConstraintLayout, false, 1, null);
            com.baidu.navisdk.util.statistic.userop.b.r().a("35.0.1.1426", "1", "1");
        }
        return true;
    }

    @Override // com.baidu.navisdk.ui.widget.expandlayout.IExpandLayoutChangeListener
    public void onDynamicLayoutChange() {
        RGNaviPlayView rGNaviPlayView = this.m;
        if (rGNaviPlayView != null) {
            if (rGNaviPlayView.getVisibility() != 0) {
                rGNaviPlayView = null;
            }
            if (rGNaviPlayView != null) {
                rGNaviPlayView.removeCallbacks(p0());
                rGNaviPlayView.post(p0());
            }
        }
    }

    @Override // com.baidu.navisdk.ui.widget.expandlayout.IExpandLayoutStatusCallback
    public void onFlingStatusChange(@OOXIXo BNExpandConstraintLayout.State curStatus) {
        IIX0o.x0xO0oo(curStatus, "curStatus");
        if (curStatus == BNExpandConstraintLayout.State.OPEN) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("35.0.1.1426", "1", "2");
        } else {
            com.baidu.navisdk.util.statistic.userop.b.r().a("35.0.1.1426", "2", "2");
        }
    }

    @Override // com.baidu.navisdk.ui.widget.expandlayout.IExpandLayoutStatusCallback
    public void onStatusChange(@OOXIXo BNExpandConstraintLayout.State curStatus) {
        boolean z;
        IIX0o.x0xO0oo(curStatus, "curStatus");
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGFixedBtnCollectView", "onStatusChange: " + curStatus);
        }
        com.baidu.navisdk.pronavi.ui.buttoncollect.fixed.b bVar = (com.baidu.navisdk.pronavi.ui.buttoncollect.fixed.b) this.i.c(com.baidu.navisdk.pronavi.ui.buttoncollect.fixed.b.class);
        boolean z2 = false;
        if (bVar != null) {
            if (curStatus == BNExpandConstraintLayout.State.OPEN) {
                z = true;
            } else {
                z = false;
            }
            bVar.b(z);
        }
        com.baidu.navisdk.pronavi.ui.buttoncollect.dynamic.b bVar2 = (com.baidu.navisdk.pronavi.ui.buttoncollect.dynamic.b) this.i.c(com.baidu.navisdk.pronavi.ui.buttoncollect.dynamic.b.class);
        if (bVar2 != null) {
            if (curStatus == BNExpandConstraintLayout.State.OPEN) {
                z2 = true;
            }
            bVar2.c(z2);
        }
    }

    public final void v(int i2) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGFixedBtnCollectView", "onOrientationChange: " + this.l + "->" + i2);
        }
        this.l = i2;
        BNExpandConstraintLayout bNExpandConstraintLayout = this.j;
        if (bNExpandConstraintLayout != null) {
            w(i2);
            bNExpandConstraintLayout.onOrientationChange(i2);
            bNExpandConstraintLayout.requestLayout();
        }
        RGNaviPlayView rGNaviPlayView = this.m;
        if (rGNaviPlayView != null) {
            x(i2);
            rGNaviPlayView.a(i2);
            if (rGNaviPlayView.getVisibility() == 0) {
                rGNaviPlayView.removeCallbacks(p0());
                rGNaviPlayView.post(p0());
            }
            rGNaviPlayView.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(Pair<Boolean, Boolean> pair) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGFixedBtnCollectView", "updateLayoutState: " + pair);
        }
        if (pair.getFirst().booleanValue()) {
            BNExpandConstraintLayout bNExpandConstraintLayout = this.j;
            if (bNExpandConstraintLayout != null) {
                bNExpandConstraintLayout.open(pair.getSecond().booleanValue());
                return;
            }
            return;
        }
        BNExpandConstraintLayout bNExpandConstraintLayout2 = this.j;
        if (bNExpandConstraintLayout2 != null) {
            bNExpandConstraintLayout2.close(pair.getSecond().booleanValue());
        }
    }

    public final void a(@oOoXoXO LifecycleOwner lifecycleOwner) {
        com.baidu.navisdk.pronavi.ui.base.b bVar;
        com.baidu.navisdk.pronavi.ui.buttoncollect.naviplay.a aVar;
        LiveData<ArrayList<com.baidu.navisdk.pronavi.ui.buttoncollect.data.a>> c;
        com.baidu.navisdk.pronavi.ui.base.b bVar2 = this.i;
        com.baidu.navisdk.pronavi.ui.buttoncollect.fixed.b bVar3 = bVar2 != null ? (com.baidu.navisdk.pronavi.ui.buttoncollect.fixed.b) bVar2.c(com.baidu.navisdk.pronavi.ui.buttoncollect.fixed.b.class) : null;
        if (bVar3 != null) {
            com.baidu.navisdk.pronavi.ui.buttoncollect.fixed.b bVar4 = lifecycleOwner != null ? bVar3 : null;
            if (bVar4 != null) {
                LiveData<com.baidu.navisdk.pronavi.ui.buttoncollect.data.a> c2 = bVar4.c();
                IIX0o.ooOOo0oXI(lifecycleOwner);
                c2.observe(lifecycleOwner, new b(lifecycleOwner));
                bVar4.d().observe(lifecycleOwner, new C0347c(lifecycleOwner));
                bVar4.e().observe(lifecycleOwner, new d(lifecycleOwner));
                bVar4.g().observe(lifecycleOwner, new e(lifecycleOwner));
                bVar4.f().observe(lifecycleOwner, new f(lifecycleOwner));
                bVar4.a(this.i, lifecycleOwner);
            }
        }
        if (lifecycleOwner == null || (bVar = this.i) == null || (aVar = (com.baidu.navisdk.pronavi.ui.buttoncollect.naviplay.a) bVar.c(com.baidu.navisdk.pronavi.ui.buttoncollect.naviplay.a.class)) == null || (c = aVar.c()) == null) {
            return;
        }
        c.observe(lifecycleOwner, new g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(com.baidu.navisdk.pronavi.ui.buttoncollect.data.a aVar) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGFixedBtnCollectView", "handleBottomFixedBtn: " + aVar);
        }
        com.baidu.navisdk.pronavi.ui.buttoncollect.fixed.a aVar2 = this.k;
        if (aVar2 != null) {
            aVar2.a(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(ArrayList<com.baidu.navisdk.pronavi.ui.buttoncollect.data.a> arrayList) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGFixedBtnCollectView", "handleDynamicBtnList: " + arrayList);
        }
        com.baidu.navisdk.pronavi.ui.buttoncollect.fixed.a aVar = this.k;
        if (aVar != null) {
            aVar.a(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(Pair<com.baidu.navisdk.pronavi.ui.buttoncollect.data.a, Integer> pair) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGFixedBtnCollectView", "updateDynamicBtn: " + pair);
        }
        com.baidu.navisdk.pronavi.ui.buttoncollect.fixed.a aVar = this.k;
        if (aVar != null) {
            aVar.a(pair);
        }
    }

    @oOoXoXO
    public final View a(@OOXIXo Context context, @OOXIXo ViewGroup parentView, int i2) {
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(parentView, "parentView");
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGFixedBtnCollectView", "onCreateView: " + this.l + "->" + i2);
        }
        this.l = i2;
        this.k = new com.baidu.navisdk.pronavi.ui.buttoncollect.fixed.a();
        View a2 = com.baidu.navisdk.ui.util.b.a(context, R.layout.bnav_layout_rg_fixed_btn_collect, parentView, false);
        this.j = (BNExpandConstraintLayout) a2.findViewById(R.id.bnav_btn_collect_fixed_layout);
        w(i2);
        BNExpandConstraintLayout bNExpandConstraintLayout = this.j;
        if (bNExpandConstraintLayout != null) {
            bNExpandConstraintLayout.setOnClickItemListener(this);
        }
        BNExpandConstraintLayout bNExpandConstraintLayout2 = this.j;
        if (bNExpandConstraintLayout2 != null) {
            bNExpandConstraintLayout2.attachAdapter(this.k, i2);
        }
        BNExpandConstraintLayout bNExpandConstraintLayout3 = this.j;
        if (bNExpandConstraintLayout3 != null) {
            bNExpandConstraintLayout3.setStatusChangeCallback(this);
        }
        BNExpandConstraintLayout bNExpandConstraintLayout4 = this.j;
        if (bNExpandConstraintLayout4 != null) {
            bNExpandConstraintLayout4.setLayoutChangeCallback(this);
        }
        RGNaviPlayView rGNaviPlayView = (RGNaviPlayView) a2.findViewById(R.id.bnav_btn_collect_fixed_navi_play);
        this.m = rGNaviPlayView;
        if (rGNaviPlayView != null) {
            rGNaviPlayView.setOnClickListener(this);
        }
        x(i2);
        q0();
        return a2;
    }

    public final void a(@oOoXoXO String str, @oOoXoXO String str2) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGFixedBtnCollectView", "enterFSMState " + str2 + org.apache.commons.text.oIX0oI.f33048oxoX + str + ": ");
        }
        com.baidu.navisdk.pronavi.ui.buttoncollect.fixed.b bVar = (com.baidu.navisdk.pronavi.ui.buttoncollect.fixed.b) this.i.c(com.baidu.navisdk.pronavi.ui.buttoncollect.fixed.b.class);
        if (bVar != null) {
            bVar.a(str, str2);
        }
    }

    @Override // com.baidu.navisdk.pronavi.ui.buttoncollect.naviplay.RGNaviPlayView.b
    public void a(@OOXIXo com.baidu.navisdk.pronavi.ui.buttoncollect.data.a btnData, @OOXIXo View view) {
        com.baidu.navisdk.pronavi.ui.buttoncollect.fixed.b bVar;
        IIX0o.x0xO0oo(btnData, "btnData");
        IIX0o.x0xO0oo(view, "view");
        int parseInt = Integer.parseInt(view.getTag().toString());
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGFixedBtnCollectView", "onClickNaviPlayView: " + btnData + ", " + parseInt);
        }
        com.baidu.navisdk.pronavi.ui.base.b bVar2 = this.i;
        if (bVar2 != null && (bVar = (com.baidu.navisdk.pronavi.ui.buttoncollect.fixed.b) bVar2.c(com.baidu.navisdk.pronavi.ui.buttoncollect.fixed.b.class)) != null) {
            bVar.j();
            bVar.f().setValue(8);
        }
        com.baidu.navisdk.pronavi.ui.base.b uiContext = this.i;
        IIX0o.oO(uiContext, "uiContext");
        com.baidu.navisdk.ui.routeguide.subview.a w = uiContext.w();
        if (w != null) {
            w.a(6, 0, parseInt, null);
            if (parseInt == 0 || parseInt == 1) {
                com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b("asr_e_c_voice_mode_play"));
            } else if (parseInt == 2) {
                com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b("asr_e_c_voice_mode_quiet"));
            } else {
                if (parseInt != 3) {
                    return;
                }
                com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b("asr_e_c_voice_mode_justwarning"));
            }
        }
    }
}
