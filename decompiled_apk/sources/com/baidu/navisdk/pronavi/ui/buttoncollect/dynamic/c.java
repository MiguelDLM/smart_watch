package com.baidu.navisdk.pronavi.ui.buttoncollect.dynamic;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.pronavi.style.d;
import com.baidu.navisdk.pronavi.style.f;
import com.baidu.navisdk.ui.widget.expandlayout.BNExpandConstraintLayout;
import com.baidu.navisdk.ui.widget.expandlayout.IExpandItemOnClickListener;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.jar.JarUtils;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes7.dex */
public final class c extends com.baidu.navisdk.pronavi.ui.base.a implements IExpandItemOnClickListener {
    private BNExpandConstraintLayout j;
    private com.baidu.navisdk.pronavi.ui.buttoncollect.dynamic.a k;
    private int l;
    private com.baidu.navisdk.pronavi.style.i.a m;

    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(IIXOooo iIXOooo) {
            this();
        }
    }

    /* loaded from: classes7.dex */
    public static final class b<T> implements Observer<ArrayList<com.baidu.navisdk.pronavi.ui.buttoncollect.data.a>> {
        public b(LifecycleOwner lifecycleOwner) {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(ArrayList<com.baidu.navisdk.pronavi.ui.buttoncollect.data.a> it) {
            c cVar = c.this;
            IIX0o.oO(it, "it");
            cVar.a(it);
        }
    }

    /* renamed from: com.baidu.navisdk.pronavi.ui.buttoncollect.dynamic.c$c, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0344c extends com.baidu.navisdk.pronavi.style.c {
        public C0344c(Integer[] numArr) {
            super(numArr);
        }

        @Override // com.baidu.navisdk.pronavi.style.i.a
        @OOXIXo
        public String a() {
            return "DynamicBtnCollectView";
        }

        @Override // com.baidu.navisdk.pronavi.style.i.a
        public void b(@oOoXoXO String str) {
            c.this.s0();
        }

        @Override // com.baidu.navisdk.pronavi.style.i.a
        public void c() {
        }

        @Override // com.baidu.navisdk.pronavi.style.c
        public boolean e() {
            return false;
        }

        @Override // com.baidu.navisdk.pronavi.style.c
        public boolean h(@oOoXoXO String str, @OOXIXo HashMap<String, ? super d> styleMap) {
            d.C0334d b;
            IIX0o.x0xO0oo(styleMap, "styleMap");
            int a2 = com.baidu.navisdk.pronavi.style.c.a(this, "RGDynamicBtnTitleColor", styleMap, 0, 4, null);
            BNExpandConstraintLayout bNExpandConstraintLayout = c.this.j;
            if (bNExpandConstraintLayout != null && (b = b("RGDynamicBg", styleMap)) != null) {
                bNExpandConstraintLayout.setDynamicLayoutBg(b.a());
            }
            int e = e("dynamic_bridge_on", styleMap);
            int e2 = e("dynamic_bridge_under", styleMap);
            int e3 = e("dynamic_main_road", styleMap);
            int e4 = e("dynamic_road_auxiliary", styleMap);
            int a3 = com.baidu.navisdk.pronavi.style.c.a(this, "RGDynamicBtnUgcIc", styleMap, 0, 4, null);
            int e5 = e("RGDynamicBtnParkIc", styleMap);
            int e6 = e("RGDynamicBtnSaveParkIc", styleMap);
            com.baidu.navisdk.pronavi.ui.buttoncollect.dynamic.b bVar = (com.baidu.navisdk.pronavi.ui.buttoncollect.dynamic.b) ((com.baidu.navisdk.pronavi.ui.base.a) c.this).i.c(com.baidu.navisdk.pronavi.ui.buttoncollect.dynamic.b.class);
            if (bVar != null) {
                bVar.a(a2, JarUtils.getResources().getColor(a3));
                bVar.a("parkBtn", a2, e5);
                bVar.a("saveParkBtn", a2, e6);
                bVar.a(a2, e, e2);
                bVar.b(a2, e3, e4);
                bVar.h();
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
    }

    private final void r0() {
        if (this.m == null) {
            C0344c c0344c = new C0344c(new Integer[0]);
            this.m = c0344c;
            f.b.a("DynamicBtnCollectView", c0344c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s0() {
        BNExpandConstraintLayout bNExpandConstraintLayout = this.j;
        if (bNExpandConstraintLayout != null) {
            bNExpandConstraintLayout.setDynamicLayoutBg(R.drawable.bnav_rg_btn_new_transparency_bg);
        }
        com.baidu.navisdk.pronavi.ui.buttoncollect.dynamic.b bVar = (com.baidu.navisdk.pronavi.ui.buttoncollect.dynamic.b) this.i.c(com.baidu.navisdk.pronavi.ui.buttoncollect.dynamic.b.class);
        if (bVar != null) {
            bVar.f();
        }
    }

    private final void w(int i) {
        int dimensionPixelSize;
        BNExpandConstraintLayout bNExpandConstraintLayout = this.j;
        IIX0o.ooOOo0oXI(bNExpandConstraintLayout);
        ViewGroup.LayoutParams layoutParams = bNExpandConstraintLayout.getLayoutParams();
        if (i == 2) {
            dimensionPixelSize = JarUtils.getResources().getDimensionPixelSize(R.dimen.nsdk_rg_control_panel_btn_width);
        } else {
            dimensionPixelSize = JarUtils.getResources().getDimensionPixelSize(R.dimen.nsdk_rg_control_panel_btn_height_new);
        }
        layoutParams.width = dimensionPixelSize;
    }

    public final boolean n0() {
        com.baidu.navisdk.pronavi.ui.buttoncollect.dynamic.a aVar = this.k;
        if (aVar != null && aVar.a()) {
            return true;
        }
        return false;
    }

    public final boolean o0() {
        com.baidu.navisdk.pronavi.ui.buttoncollect.dynamic.a aVar = this.k;
        if (aVar != null && aVar.b()) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.navisdk.ui.widget.expandlayout.IExpandItemOnClickListener
    public void onClickBottomFixedItem(@oOoXoXO String str, @OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
    }

    @Override // com.baidu.navisdk.ui.widget.expandlayout.IExpandItemOnClickListener
    public void onClickDynamicItem(@oOoXoXO String str, @OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGDynamicBtnCollectView", "onClickDynamicItem: " + str);
        }
        if (IIX0o.Oxx0IOOO(str, "scenicBroadcast")) {
            com.baidu.navisdk.pronavi.ui.buttoncollect.dynamic.a aVar = this.k;
            if (aVar != null) {
                aVar.c();
                return;
            }
            return;
        }
        com.baidu.navisdk.pronavi.ui.buttoncollect.dynamic.b bVar = (com.baidu.navisdk.pronavi.ui.buttoncollect.dynamic.b) this.i.c(com.baidu.navisdk.pronavi.ui.buttoncollect.dynamic.b.class);
        if (bVar != null) {
            bVar.a(str, view);
        }
    }

    @Override // com.baidu.navisdk.ui.widget.expandlayout.IExpandItemOnClickListener
    public boolean onClickTopFixedItem(@OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        return IExpandItemOnClickListener.DefaultImpls.onClickTopFixedItem(this, view);
    }

    public final void p0() {
        com.baidu.navisdk.pronavi.ui.buttoncollect.dynamic.a aVar = this.k;
        if (aVar != null) {
            aVar.d();
        }
    }

    public final void q0() {
        com.baidu.navisdk.pronavi.ui.buttoncollect.dynamic.a aVar = this.k;
        if (aVar != null) {
            aVar.e();
        }
    }

    public final void v(int i) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGDynamicBtnCollectView", "onOrientationChange: " + this.l + "->" + i);
        }
        this.l = i;
        BNExpandConstraintLayout bNExpandConstraintLayout = this.j;
        if (bNExpandConstraintLayout != null) {
            w(i);
            bNExpandConstraintLayout.onOrientationChange(i);
            bNExpandConstraintLayout.requestLayout();
        }
    }

    public final void a(@oOoXoXO LifecycleOwner lifecycleOwner) {
        com.baidu.navisdk.pronavi.ui.base.b bVar = this.i;
        com.baidu.navisdk.pronavi.ui.buttoncollect.dynamic.b bVar2 = bVar != null ? (com.baidu.navisdk.pronavi.ui.buttoncollect.dynamic.b) bVar.c(com.baidu.navisdk.pronavi.ui.buttoncollect.dynamic.b.class) : null;
        if (bVar2 != null) {
            com.baidu.navisdk.pronavi.ui.buttoncollect.dynamic.b bVar3 = lifecycleOwner != null ? bVar2 : null;
            if (bVar3 != null) {
                LiveData<ArrayList<com.baidu.navisdk.pronavi.ui.buttoncollect.data.a>> c = bVar3.c();
                IIX0o.ooOOo0oXI(lifecycleOwner);
                c.observe(lifecycleOwner, new b(lifecycleOwner));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(ArrayList<com.baidu.navisdk.pronavi.ui.buttoncollect.data.a> arrayList) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGDynamicBtnAdapter", "handleDynamicBtnList: " + arrayList);
        }
        com.baidu.navisdk.pronavi.ui.buttoncollect.dynamic.a aVar = this.k;
        if (aVar != null) {
            aVar.a(arrayList);
        }
    }

    @oOoXoXO
    public final View a(@OOXIXo Context context, @OOXIXo ViewGroup parentView, int i) {
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(parentView, "parentView");
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGDynamicBtnCollectView", "onCreateView: " + this.l + "->" + i);
        }
        this.l = i;
        com.baidu.navisdk.pronavi.ui.base.b uiContext = this.i;
        IIX0o.oO(uiContext, "uiContext");
        this.k = new com.baidu.navisdk.pronavi.ui.buttoncollect.dynamic.a(uiContext);
        this.j = (BNExpandConstraintLayout) LayoutInflater.from(context).inflate(R.layout.bnav_layout_rg_dynamic_btn_collect, parentView, false);
        w(i);
        BNExpandConstraintLayout bNExpandConstraintLayout = this.j;
        if (bNExpandConstraintLayout != null) {
            bNExpandConstraintLayout.setOnClickItemListener(this);
        }
        BNExpandConstraintLayout bNExpandConstraintLayout2 = this.j;
        if (bNExpandConstraintLayout2 != null) {
            bNExpandConstraintLayout2.attachAdapter(this.k, i);
        }
        r0();
        return this.j;
    }
}
