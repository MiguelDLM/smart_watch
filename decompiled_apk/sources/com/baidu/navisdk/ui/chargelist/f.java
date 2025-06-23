package com.baidu.navisdk.ui.chargelist;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.chargelist.b;
import com.baidu.navisdk.ui.chargelist.interfaces.b;
import com.baidu.navisdk.ui.chargelist.model.a;
import com.baidu.navisdk.ui.chargelist.widget.ChargeListTabLayout;
import com.baidu.navisdk.ui.widget.BNHeadSelectedLayout;
import com.baidu.navisdk.ui.widget.BNRelativeLayout;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.utils.a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes8.dex */
public final class f extends BNRelativeLayout implements com.baidu.navisdk.ui.chargelist.interfaces.b, LifecycleOwner, b.c {

    @OOXIXo
    private final RecyclerView.SmoothScroller A;

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<com.baidu.navisdk.ui.chargelist.data.beans.c> f8377a;
    private final LifecycleRegistry b;

    @oOoXoXO
    private ViewGroup c;
    private boolean d;
    private com.baidu.navisdk.ui.chargelist.interfaces.a e;
    private com.baidu.navisdk.ui.chargelist.interfaces.b f;
    private View.OnClickListener g;
    private com.baidu.navisdk.ui.chargelist.c h;
    private RecyclerView i;
    private View j;
    private RecyclerView k;
    private com.baidu.navisdk.ui.chargelist.b l;
    private LinearLayoutManager m;
    private BNHeadSelectedLayout n;
    private FrameLayout o;
    private RelativeLayout p;
    private RelativeLayout q;
    private RelativeLayout r;
    private TextView s;
    private TextView t;
    private ChargeListTabLayout u;
    private RelativeLayout v;
    private RelativeLayout w;
    private ImageView x;
    private TextView y;
    private final com.baidu.navisdk.ui.chargelist.model.a z;

    /* loaded from: classes8.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(IIXOooo iIXOooo) {
            this();
        }
    }

    /* loaded from: classes8.dex */
    public static final class b implements Animation.AnimationListener {
        public b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(@OOXIXo Animation animation) {
            IIX0o.x0xO0oo(animation, "animation");
            if (f.this.getParentView() != null) {
                ViewGroup parentView = f.this.getParentView();
                IIX0o.ooOOo0oXI(parentView);
                parentView.clearAnimation();
            }
            f.this.c();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(@OOXIXo Animation animation) {
            IIX0o.x0xO0oo(animation, "animation");
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(@OOXIXo Animation animation) {
            IIX0o.x0xO0oo(animation, "animation");
        }
    }

    /* loaded from: classes8.dex */
    public static final class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            f.this.a();
        }
    }

    /* loaded from: classes8.dex */
    public static final class d implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public static final d f8380a = new d();

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
        }
    }

    /* loaded from: classes8.dex */
    public static final class e<T> implements Observer<com.baidu.navisdk.model.datastruct.chargestation.d> {
        public e() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(com.baidu.navisdk.model.datastruct.chargestation.d dVar) {
            if (dVar != null) {
                f.e(f.this).a(dVar, f.this.z.k());
            }
        }
    }

    /* renamed from: com.baidu.navisdk.ui.chargelist.f$f, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C0407f<T> implements Observer<ArrayList<com.baidu.navisdk.ui.chargelist.data.beans.b>> {
        public C0407f() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(ArrayList<com.baidu.navisdk.ui.chargelist.data.beans.b> arrayList) {
            boolean z;
            if (arrayList != null) {
                f fVar = f.this;
                if (arrayList.size() <= 0) {
                    z = true;
                } else {
                    z = false;
                }
                fVar.setShowDefaultLayout(z);
                f.this.r();
                f.c(f.this).a(arrayList);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class g<T> implements Observer<Integer> {
        public g() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(Integer num) {
            int i;
            f fVar = f.this;
            if (num != null) {
                i = num.intValue();
            } else {
                i = 0;
            }
            fVar.a(i);
        }
    }

    /* loaded from: classes8.dex */
    public static final class h<T> implements Observer<Boolean> {
        public h() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(Boolean bool) {
            boolean z;
            f fVar = f.this;
            if (bool != null) {
                z = bool.booleanValue();
            } else {
                z = false;
            }
            fVar.setCompleteBtnClickable(z);
        }
    }

    /* loaded from: classes8.dex */
    public static final class i<T> implements Observer<a.c> {
        public i() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(a.c cVar) {
            if (cVar != null) {
                int b = cVar.b();
                if (b < 0) {
                    b = 0;
                }
                f.this.a(b, cVar.a());
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class j<T> implements Observer<Boolean> {
        public j() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(Boolean bool) {
            boolean z;
            f fVar = f.this;
            if (bool != null) {
                z = bool.booleanValue();
            } else {
                z = false;
            }
            fVar.b(z);
        }
    }

    /* loaded from: classes8.dex */
    public static final class k implements View.OnClickListener {
        public k() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (IIX0o.Oxx0IOOO(f.this.z.j().getValue(), Boolean.TRUE)) {
                f.this.z.a(false);
                if (f.this.e != null) {
                    com.baidu.navisdk.ui.chargelist.interfaces.a aVar = f.this.e;
                    IIX0o.ooOOo0oXI(aVar);
                    aVar.a(false);
                    com.baidu.navisdk.util.statistic.userop.b.r().d("11.11.1", "0");
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class l implements View.OnClickListener {
        public l() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (!IIX0o.Oxx0IOOO(f.this.z.j().getValue(), Boolean.TRUE)) {
                f.this.z.a(true);
                if (f.this.e != null) {
                    com.baidu.navisdk.ui.chargelist.interfaces.a aVar = f.this.e;
                    IIX0o.ooOOo0oXI(aVar);
                    aVar.a(true);
                    com.baidu.navisdk.util.statistic.userop.b.r().d("11.11.1", "1");
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class m implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public static final m f8389a = new m();

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.B4NAV;
            if (gVar.d()) {
                gVar.e("ChargeListView", "click charge list view background!");
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class n implements View.OnClickListener {
        public n() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (!f.this.z.k()) {
                com.baidu.navisdk.ui.chargelist.interfaces.a aVar = f.this.e;
                if (aVar != null) {
                    aVar.c();
                }
                com.baidu.navisdk.util.statistic.userop.b.r().b("11.11.2");
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class o implements Animation.AnimationListener {
        public o() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(@OOXIXo Animation animation) {
            IIX0o.x0xO0oo(animation, "animation");
            ViewGroup parentView = f.this.getParentView();
            if (parentView != null) {
                parentView.clearAnimation();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(@OOXIXo Animation animation) {
            IIX0o.x0xO0oo(animation, "animation");
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(@OOXIXo Animation animation) {
            IIX0o.x0xO0oo(animation, "animation");
        }
    }

    /* loaded from: classes8.dex */
    public static final class p extends com.baidu.navisdk.util.worker.lite.b {
        final /* synthetic */ boolean b;
        final /* synthetic */ int c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(boolean z, int i, String str) {
            super(str);
            this.b = z;
            this.c = i;
        }

        @Override // com.baidu.navisdk.util.worker.lite.b, java.lang.Runnable
        public void run() {
            if (this.b) {
                f.this.getSmoothScroller().setTargetPosition(this.c);
                RecyclerView.LayoutManager layoutManager = f.d(f.this).getLayoutManager();
                if (layoutManager != null) {
                    layoutManager.startSmoothScroll(f.this.getSmoothScroller());
                    return;
                }
                return;
            }
            int findFirstVisibleItemPosition = f.f(f.this).findFirstVisibleItemPosition();
            int findLastVisibleItemPosition = f.f(f.this).findLastVisibleItemPosition();
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.COMMON_UI;
            if (gVar.d()) {
                gVar.e("ChargeListView", "smoothScrollToPosition --> position = " + this.c + ", firstVisibleItemPosition = " + findFirstVisibleItemPosition + ", lastVisibleItemPosition = " + findLastVisibleItemPosition);
            }
            int i = this.c;
            if (findFirstVisibleItemPosition > i || findLastVisibleItemPosition < i) {
                f.this.getSmoothScroller().setTargetPosition(this.c);
                RecyclerView.LayoutManager layoutManager2 = f.d(f.this).getLayoutManager();
                if (layoutManager2 != null) {
                    layoutManager2.startSmoothScroll(f.this.getSmoothScroller());
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class q extends LinearSmoothScroller {
        public q(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public int getVerticalSnapPreference() {
            return -1;
        }
    }

    /* loaded from: classes8.dex */
    public static final class r implements View.OnClickListener {
        public r() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (f.this.g != null) {
                View.OnClickListener onClickListener = f.this.g;
                IIX0o.ooOOo0oXI(onClickListener);
                onClickListener.onClick(view);
            } else {
                f.this.a(true);
            }
            com.baidu.navisdk.util.statistic.userop.b.r().b("11.11.11");
        }
    }

    static {
        new a(null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public f(@OOXIXo Context context, int i2, boolean z, int i3, int i4, @oOoXoXO ArrayList<com.baidu.navisdk.ui.chargelist.data.beans.c> arrayList) {
        this(context, null, i2, z, i3, i4, arrayList);
        IIX0o.x0xO0oo(context, "context");
    }

    public static final /* synthetic */ com.baidu.navisdk.ui.chargelist.c c(f fVar) {
        com.baidu.navisdk.ui.chargelist.c cVar = fVar.h;
        if (cVar == null) {
            IIX0o.XOxIOxOx("chargeListAdapter");
        }
        return cVar;
    }

    public static final /* synthetic */ RecyclerView d(f fVar) {
        RecyclerView recyclerView = fVar.i;
        if (recyclerView == null) {
            IIX0o.XOxIOxOx("chargeListRecyclerView");
        }
        return recyclerView;
    }

    public static final /* synthetic */ ChargeListTabLayout e(f fVar) {
        ChargeListTabLayout chargeListTabLayout = fVar.u;
        if (chargeListTabLayout == null) {
            IIX0o.XOxIOxOx("chargeListTabLayout");
        }
        return chargeListTabLayout;
    }

    public static final /* synthetic */ LinearLayoutManager f(f fVar) {
        LinearLayoutManager linearLayoutManager = fVar.m;
        if (linearLayoutManager == null) {
            IIX0o.XOxIOxOx("layoutManager");
        }
        return linearLayoutManager;
    }

    private final ArrayList<com.baidu.navisdk.model.datastruct.chargestation.b> getAddCsInfoList() {
        ArrayList<com.baidu.navisdk.model.datastruct.chargestation.b> arrayList = new ArrayList<>();
        for (com.baidu.navisdk.ui.chargelist.data.beans.b bVar : this.z.a()) {
            if (bVar instanceof com.baidu.navisdk.ui.chargelist.data.beans.e) {
                arrayList.add(((com.baidu.navisdk.ui.chargelist.data.beans.e) bVar).j());
            }
        }
        return arrayList;
    }

    private final ArrayList<com.baidu.navisdk.model.datastruct.chargestation.b> getRemoveCsInfoList() {
        ArrayList<com.baidu.navisdk.model.datastruct.chargestation.b> arrayList = new ArrayList<>();
        for (com.baidu.navisdk.ui.chargelist.data.beans.b bVar : this.z.b()) {
            if (bVar instanceof com.baidu.navisdk.ui.chargelist.data.beans.e) {
                arrayList.add(((com.baidu.navisdk.ui.chargelist.data.beans.e) bVar).j());
            }
        }
        return arrayList;
    }

    private final void i() {
        View findViewById = findViewById(R.id.bnav_layout_charge_list_layout_container);
        IIX0o.oO(findViewById, "findViewById(R.id.bnav_l…ge_list_layout_container)");
        this.r = (RelativeLayout) findViewById;
        k();
        l();
        h();
    }

    private final void j() {
        View findViewById = findViewById(R.id.bnav_layout_charge_list_view_default_container);
        IIX0o.oO(findViewById, "findViewById(R.id.bnav_l…t_view_default_container)");
        this.v = (RelativeLayout) findViewById;
        View findViewById2 = findViewById(R.id.charge_list_back_container);
        IIX0o.oO(findViewById2, "findViewById(R.id.charge_list_back_container)");
        this.w = (RelativeLayout) findViewById2;
        View findViewById3 = findViewById(R.id.charge_list_default_icon);
        IIX0o.oO(findViewById3, "findViewById(R.id.charge_list_default_icon)");
        this.x = (ImageView) findViewById3;
        View findViewById4 = findViewById(R.id.charge_list_default_text);
        IIX0o.oO(findViewById4, "findViewById(R.id.charge_list_default_text)");
        this.y = (TextView) findViewById4;
    }

    private final void k() {
        View findViewById = findViewById(R.id.charge_list_head_selected_container);
        IIX0o.oO(findViewById, "findViewById(R.id.charge…_head_selected_container)");
        BNHeadSelectedLayout bNHeadSelectedLayout = (BNHeadSelectedLayout) findViewById;
        this.n = bNHeadSelectedLayout;
        if (bNHeadSelectedLayout == null) {
            IIX0o.XOxIOxOx("headSelectedLayout");
        }
        bNHeadSelectedLayout.setFirstBtnClickListener(new k());
        BNHeadSelectedLayout bNHeadSelectedLayout2 = this.n;
        if (bNHeadSelectedLayout2 == null) {
            IIX0o.XOxIOxOx("headSelectedLayout");
        }
        bNHeadSelectedLayout2.setSecondBtnClickListener(new l());
    }

    private final void l() {
        int i2;
        View findViewById = findViewById(R.id.charge_list_container);
        IIX0o.oO(findViewById, "findViewById(R.id.charge_list_container)");
        this.q = (RelativeLayout) findViewById;
        View findViewById2 = findViewById(R.id.charge_list_tab_layout);
        IIX0o.oO(findViewById2, "findViewById(R.id.charge_list_tab_layout)");
        ChargeListTabLayout chargeListTabLayout = (ChargeListTabLayout) findViewById2;
        this.u = chargeListTabLayout;
        if (chargeListTabLayout == null) {
            IIX0o.XOxIOxOx("chargeListTabLayout");
        }
        if (!n() && !o()) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        chargeListTabLayout.setVisibility(i2);
        RelativeLayout relativeLayout = this.q;
        if (relativeLayout == null) {
            IIX0o.XOxIOxOx("chargeListContainer");
        }
        relativeLayout.setOnClickListener(m.f8389a);
        ChargeListTabLayout chargeListTabLayout2 = this.u;
        if (chargeListTabLayout2 == null) {
            IIX0o.XOxIOxOx("chargeListTabLayout");
        }
        chargeListTabLayout2.setContainerClickListener(new n());
        m();
    }

    private final void m() {
        ArrayList<com.baidu.navisdk.ui.chargelist.data.beans.c> arrayList;
        View findViewById = findViewById(R.id.charge_list_recycle_view);
        IIX0o.oO(findViewById, "findViewById(R.id.charge_list_recycle_view)");
        this.i = (RecyclerView) findViewById;
        this.m = new LinearLayoutManager(getContext(), 1, false);
        RecyclerView recyclerView = this.i;
        if (recyclerView == null) {
            IIX0o.XOxIOxOx("chargeListRecyclerView");
        }
        LinearLayoutManager linearLayoutManager = this.m;
        if (linearLayoutManager == null) {
            IIX0o.XOxIOxOx("layoutManager");
        }
        recyclerView.setLayoutManager(linearLayoutManager);
        Context context = getContext();
        IIX0o.oO(context, "context");
        com.baidu.navisdk.ui.chargelist.c cVar = new com.baidu.navisdk.ui.chargelist.c(context, this.z.h());
        this.h = cVar;
        cVar.setHasStableIds(true);
        RecyclerView recyclerView2 = this.i;
        if (recyclerView2 == null) {
            IIX0o.XOxIOxOx("chargeListRecyclerView");
        }
        com.baidu.navisdk.ui.chargelist.c cVar2 = this.h;
        if (cVar2 == null) {
            IIX0o.XOxIOxOx("chargeListAdapter");
        }
        recyclerView2.setAdapter(cVar2);
        View findViewById2 = findViewById(R.id.charge_list_choose_electric_view_container);
        IIX0o.oO(findViewById2, "findViewById(R.id.charge…_electric_view_container)");
        this.j = findViewById2;
        View findViewById3 = findViewById(R.id.charge_list_choose_electric_view);
        IIX0o.oO(findViewById3, "findViewById(R.id.charge…ist_choose_electric_view)");
        this.k = (RecyclerView) findViewById3;
        if (o() && (arrayList = this.f8377a) != null && !arrayList.isEmpty()) {
            View view = this.j;
            if (view == null) {
                IIX0o.XOxIOxOx("chargeElectricRecyclerViewContainer");
            }
            view.setVisibility(0);
            LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(getContext(), 0, false);
            RecyclerView recyclerView3 = this.k;
            if (recyclerView3 == null) {
                IIX0o.XOxIOxOx("chargeElectricRecyclerView");
            }
            recyclerView3.setLayoutManager(linearLayoutManager2);
            this.l = new com.baidu.navisdk.ui.chargelist.b(getContext(), this.f8377a);
            RecyclerView recyclerView4 = this.k;
            if (recyclerView4 == null) {
                IIX0o.XOxIOxOx("chargeElectricRecyclerView");
            }
            recyclerView4.addItemDecoration(new com.baidu.navisdk.ui.chargelist.a());
            RecyclerView recyclerView5 = this.k;
            if (recyclerView5 == null) {
                IIX0o.XOxIOxOx("chargeElectricRecyclerView");
            }
            com.baidu.navisdk.ui.chargelist.b bVar = this.l;
            if (bVar == null) {
                IIX0o.XOxIOxOx("chargeElectricRecyclerViewAdapter");
            }
            recyclerView5.setAdapter(bVar);
            com.baidu.navisdk.ui.chargelist.b bVar2 = this.l;
            if (bVar2 == null) {
                IIX0o.XOxIOxOx("chargeElectricRecyclerViewAdapter");
            }
            bVar2.a(this);
            return;
        }
        View view2 = this.j;
        if (view2 == null) {
            IIX0o.XOxIOxOx("chargeElectricRecyclerViewContainer");
        }
        view2.setVisibility(8);
    }

    private final boolean n() {
        if (this.z.h() == 2) {
            return true;
        }
        return false;
    }

    private final boolean o() {
        if (this.z.h() == 3) {
            return true;
        }
        return false;
    }

    private final boolean p() {
        if (this.z.h() == 2) {
            return true;
        }
        return false;
    }

    private final void q() {
        int i2;
        com.baidu.navisdk.ui.chargelist.e eVar = com.baidu.navisdk.ui.chargelist.e.f8376a;
        RelativeLayout relativeLayout = this.p;
        if (relativeLayout == null) {
            IIX0o.XOxIOxOx("completeContainer");
        }
        eVar.a(relativeLayout, p(), R.drawable.bnav_energy_item_normal_bg);
        TextView textView = this.s;
        if (textView == null) {
            IIX0o.XOxIOxOx("selectApproachNodeInfo");
        }
        eVar.a(textView, p(), R.color.bnav_charge_list_complete_text_color);
        RelativeLayout relativeLayout2 = this.p;
        if (relativeLayout2 == null) {
            IIX0o.XOxIOxOx("completeContainer");
        }
        if (n()) {
            i2 = 8;
        } else {
            i2 = 0;
        }
        relativeLayout2.setVisibility(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r() {
        HashSet hashSet;
        com.baidu.navisdk.ui.chargelist.e eVar = com.baidu.navisdk.ui.chargelist.e.f8376a;
        RelativeLayout relativeLayout = this.v;
        if (relativeLayout == null) {
            IIX0o.XOxIOxOx("defaultContainer");
        }
        eVar.a(relativeLayout, p(), R.color.bnav_charge_list_default_bg);
        RelativeLayout relativeLayout2 = this.w;
        if (relativeLayout2 == null) {
            IIX0o.XOxIOxOx("defaultBackContainer");
        }
        relativeLayout2.setOnClickListener(new r());
        int i2 = 0;
        if (this.d) {
            RelativeLayout relativeLayout3 = this.w;
            if (relativeLayout3 == null) {
                IIX0o.XOxIOxOx("defaultBackContainer");
            }
            relativeLayout3.setVisibility(0);
            RelativeLayout relativeLayout4 = this.v;
            if (relativeLayout4 == null) {
                IIX0o.XOxIOxOx("defaultContainer");
            }
            relativeLayout4.setVisibility(0);
            RelativeLayout relativeLayout5 = this.r;
            if (relativeLayout5 == null) {
                IIX0o.XOxIOxOx("listContainer");
            }
            relativeLayout5.setVisibility(8);
            ChargeListTabLayout chargeListTabLayout = this.u;
            if (chargeListTabLayout == null) {
                IIX0o.XOxIOxOx("chargeListTabLayout");
            }
            chargeListTabLayout.setVisibility(8);
            TextView textView = this.y;
            if (textView == null) {
                IIX0o.XOxIOxOx("defaultText");
            }
            textView.setText("后续行程充电站可能不足");
            if (o()) {
                RelativeLayout relativeLayout6 = this.w;
                if (relativeLayout6 == null) {
                    IIX0o.XOxIOxOx("defaultBackContainer");
                }
                relativeLayout6.setVisibility(8);
                Set<Integer> e2 = this.z.e();
                if (e2 != null) {
                    hashSet = new HashSet(e2);
                } else {
                    hashSet = null;
                }
                if (hashSet != null) {
                    hashSet.remove(0);
                }
                if (hashSet != null && !hashSet.isEmpty()) {
                    TextView textView2 = this.y;
                    if (textView2 == null) {
                        IIX0o.XOxIOxOx("defaultText");
                    }
                    textView2.setText("未搜索到沿途充电站");
                    return;
                }
                TextView textView3 = this.y;
                if (textView3 == null) {
                    IIX0o.XOxIOxOx("defaultText");
                }
                textView3.setText("当前筛选条件无充电站");
                return;
            }
            return;
        }
        if (n()) {
            RelativeLayout relativeLayout7 = this.w;
            if (relativeLayout7 == null) {
                IIX0o.XOxIOxOx("defaultBackContainer");
            }
            relativeLayout7.setVisibility(0);
            RelativeLayout relativeLayout8 = this.v;
            if (relativeLayout8 == null) {
                IIX0o.XOxIOxOx("defaultContainer");
            }
            relativeLayout8.setVisibility(8);
            RelativeLayout relativeLayout9 = this.r;
            if (relativeLayout9 == null) {
                IIX0o.XOxIOxOx("listContainer");
            }
            relativeLayout9.setVisibility(0);
            ChargeListTabLayout chargeListTabLayout2 = this.u;
            if (chargeListTabLayout2 == null) {
                IIX0o.XOxIOxOx("chargeListTabLayout");
            }
            chargeListTabLayout2.setVisibility(8);
            return;
        }
        RelativeLayout relativeLayout10 = this.w;
        if (relativeLayout10 == null) {
            IIX0o.XOxIOxOx("defaultBackContainer");
        }
        relativeLayout10.setVisibility(8);
        RelativeLayout relativeLayout11 = this.v;
        if (relativeLayout11 == null) {
            IIX0o.XOxIOxOx("defaultContainer");
        }
        relativeLayout11.setVisibility(8);
        RelativeLayout relativeLayout12 = this.r;
        if (relativeLayout12 == null) {
            IIX0o.XOxIOxOx("listContainer");
        }
        relativeLayout12.setVisibility(0);
        ChargeListTabLayout chargeListTabLayout3 = this.u;
        if (chargeListTabLayout3 == null) {
            IIX0o.XOxIOxOx("chargeListTabLayout");
        }
        if (o()) {
            i2 = 8;
        }
        chargeListTabLayout3.setVisibility(i2);
    }

    private final void s() {
        int i2;
        BNHeadSelectedLayout bNHeadSelectedLayout = this.n;
        if (bNHeadSelectedLayout == null) {
            IIX0o.XOxIOxOx("headSelectedLayout");
        }
        if (!n() && !o()) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        bNHeadSelectedLayout.setVisibility(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setCompleteBtnClickable(boolean z) {
        int i2;
        FrameLayout frameLayout = this.o;
        if (frameLayout == null) {
            IIX0o.XOxIOxOx("completeLayout");
        }
        frameLayout.setClickable(z);
        if (z) {
            i2 = R.drawable.nsdk_energy_charge_complete_bg;
        } else {
            i2 = R.drawable.nsdk_energy_charge_complete_unselected_bg;
        }
        FrameLayout frameLayout2 = this.o;
        if (frameLayout2 == null) {
            IIX0o.XOxIOxOx("completeLayout");
        }
        frameLayout2.setBackground(ContextCompat.getDrawable(getContext(), i2));
    }

    private final void t() {
        int i2;
        com.baidu.navisdk.ui.chargelist.e eVar = com.baidu.navisdk.ui.chargelist.e.f8376a;
        RelativeLayout relativeLayout = this.q;
        if (relativeLayout == null) {
            IIX0o.XOxIOxOx("chargeListContainer");
        }
        eVar.a(relativeLayout, p(), R.drawable.nsdk_drawable_energy_container_background);
        ChargeListTabLayout chargeListTabLayout = this.u;
        if (chargeListTabLayout == null) {
            IIX0o.XOxIOxOx("chargeListTabLayout");
        }
        eVar.a(chargeListTabLayout, p(), R.drawable.nsdk_energy_charge_tab_green);
        ChargeListTabLayout chargeListTabLayout2 = this.u;
        if (chargeListTabLayout2 == null) {
            IIX0o.XOxIOxOx("chargeListTabLayout");
        }
        if (!n() && !o()) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        chargeListTabLayout2.setVisibility(i2);
        u();
    }

    private final void u() {
        com.baidu.navisdk.ui.chargelist.e eVar = com.baidu.navisdk.ui.chargelist.e.f8376a;
        RecyclerView recyclerView = this.i;
        if (recyclerView == null) {
            IIX0o.XOxIOxOx("chargeListRecyclerView");
        }
        eVar.a(recyclerView, p(), R.color.bnav_charge_list_recycle_bg);
        com.baidu.navisdk.ui.chargelist.c cVar = this.h;
        if (cVar == null) {
            IIX0o.XOxIOxOx("chargeListAdapter");
        }
        cVar.notifyDataSetChanged();
    }

    @Override // androidx.lifecycle.LifecycleOwner
    @OOXIXo
    public Lifecycle getLifecycle() {
        return this.b;
    }

    @oOoXoXO
    public final ViewGroup getParentView() {
        return this.c;
    }

    @OOXIXo
    public final RecyclerView.SmoothScroller getSmoothScroller() {
        return this.A;
    }

    public final void setBackBtnClickListener(@OOXIXo View.OnClickListener clickListener) {
        IIX0o.x0xO0oo(clickListener, "clickListener");
        this.g = clickListener;
    }

    public final void setChargeListContainerHeight(int i2) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, i2);
        layoutParams.addRule(12);
        RelativeLayout relativeLayout = this.q;
        if (relativeLayout == null) {
            IIX0o.XOxIOxOx("chargeListContainer");
        }
        relativeLayout.setLayoutParams(layoutParams);
    }

    public final void setParentView(@oOoXoXO ViewGroup viewGroup) {
        this.c = viewGroup;
    }

    public final void setShowDefaultLayout(boolean z) {
        this.d = z;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public f(@OOXIXo Context context, @oOoXoXO AttributeSet attributeSet, int i2, boolean z, int i3, int i4, @oOoXoXO ArrayList<com.baidu.navisdk.ui.chargelist.data.beans.c> arrayList) {
        this(context, attributeSet, 0, i2, z, i3, i4, arrayList);
        IIX0o.x0xO0oo(context, "context");
    }

    private final void h() {
        View findViewById = findViewById(R.id.charge_list_complete_container);
        IIX0o.oO(findViewById, "findViewById(R.id.charge_list_complete_container)");
        this.p = (RelativeLayout) findViewById;
        View findViewById2 = findViewById(R.id.charge_list_complete);
        IIX0o.oO(findViewById2, "findViewById(R.id.charge_list_complete)");
        this.o = (FrameLayout) findViewById2;
        View findViewById3 = findViewById(R.id.charge_list_select_approach_node);
        IIX0o.oO(findViewById3, "findViewById(R.id.charge…ist_select_approach_node)");
        this.s = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.charge_list_complete_text);
        IIX0o.oO(findViewById4, "findViewById(R.id.charge_list_complete_text)");
        this.t = (TextView) findViewById4;
        FrameLayout frameLayout = this.o;
        if (frameLayout == null) {
            IIX0o.XOxIOxOx("completeLayout");
        }
        frameLayout.setOnClickListener(new c());
        RelativeLayout relativeLayout = this.p;
        if (relativeLayout == null) {
            IIX0o.XOxIOxOx("completeContainer");
        }
        relativeLayout.setOnClickListener(d.f8380a);
    }

    public final void c() {
        ViewGroup viewGroup = this.c;
        if (viewGroup != null) {
            IIX0o.ooOOo0oXI(viewGroup);
            viewGroup.setVisibility(8);
            ViewGroup viewGroup2 = this.c;
            IIX0o.ooOOo0oXI(viewGroup2);
            viewGroup2.removeAllViews();
            this.c = null;
        }
    }

    public final boolean d() {
        ViewGroup viewGroup = this.c;
        if (viewGroup != null) {
            IIX0o.ooOOo0oXI(viewGroup);
            if (viewGroup.getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public final void e() {
        this.e = null;
        com.baidu.navisdk.ui.chargelist.c cVar = this.h;
        if (cVar == null) {
            IIX0o.XOxIOxOx("chargeListAdapter");
        }
        cVar.a();
    }

    public final void f() {
        this.f = null;
    }

    public final void g() {
        r();
        s();
        t();
        q();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(@OOXIXo Context context, @oOoXoXO AttributeSet attributeSet, int i2, int i3, boolean z, int i4, int i5, @oOoXoXO ArrayList<com.baidu.navisdk.ui.chargelist.data.beans.c> arrayList) {
        super(context, attributeSet, i2);
        IIX0o.x0xO0oo(context, "context");
        this.b = new LifecycleRegistry(this);
        this.z = new com.baidu.navisdk.ui.chargelist.model.a();
        this.A = new q(getContext());
        this.f8377a = arrayList;
        a(i3, z, i4, i5);
        a(context);
    }

    @Override // com.baidu.navisdk.ui.chargelist.interfaces.b
    public void b() {
        b.a.a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(boolean z) {
        if (z) {
            BNHeadSelectedLayout bNHeadSelectedLayout = this.n;
            if (bNHeadSelectedLayout == null) {
                IIX0o.XOxIOxOx("headSelectedLayout");
            }
            bNHeadSelectedLayout.getHeadSecondBtn().setBackground(ContextCompat.getDrawable(getContext(), R.drawable.bnav_charge_head_selected_bg));
            BNHeadSelectedLayout bNHeadSelectedLayout2 = this.n;
            if (bNHeadSelectedLayout2 == null) {
                IIX0o.XOxIOxOx("headSelectedLayout");
            }
            bNHeadSelectedLayout2.getHeadFirstBtn().setBackground(null);
            BNHeadSelectedLayout bNHeadSelectedLayout3 = this.n;
            if (bNHeadSelectedLayout3 == null) {
                IIX0o.XOxIOxOx("headSelectedLayout");
            }
            bNHeadSelectedLayout3.getHeadSecondBtn().setTextColor(Color.parseColor("#FFFFFFFF"));
            BNHeadSelectedLayout bNHeadSelectedLayout4 = this.n;
            if (bNHeadSelectedLayout4 == null) {
                IIX0o.XOxIOxOx("headSelectedLayout");
            }
            bNHeadSelectedLayout4.getHeadFirstBtn().setTextColor(Color.parseColor("#FF11141A"));
            return;
        }
        BNHeadSelectedLayout bNHeadSelectedLayout5 = this.n;
        if (bNHeadSelectedLayout5 == null) {
            IIX0o.XOxIOxOx("headSelectedLayout");
        }
        bNHeadSelectedLayout5.getHeadFirstBtn().setBackground(ContextCompat.getDrawable(getContext(), R.drawable.bnav_charge_head_selected_bg));
        BNHeadSelectedLayout bNHeadSelectedLayout6 = this.n;
        if (bNHeadSelectedLayout6 == null) {
            IIX0o.XOxIOxOx("headSelectedLayout");
        }
        bNHeadSelectedLayout6.getHeadSecondBtn().setBackground(null);
        BNHeadSelectedLayout bNHeadSelectedLayout7 = this.n;
        if (bNHeadSelectedLayout7 == null) {
            IIX0o.XOxIOxOx("headSelectedLayout");
        }
        bNHeadSelectedLayout7.getHeadFirstBtn().setTextColor(Color.parseColor("#FFFFFFFF"));
        BNHeadSelectedLayout bNHeadSelectedLayout8 = this.n;
        if (bNHeadSelectedLayout8 == null) {
            IIX0o.XOxIOxOx("headSelectedLayout");
        }
        bNHeadSelectedLayout8.getHeadSecondBtn().setTextColor(Color.parseColor("#FF11141A"));
    }

    private final void a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.bnav_layout_charge_list_view, (ViewGroup) this, true);
        j();
        i();
        setChargeListContainerHeight(-1);
    }

    @Override // com.baidu.navisdk.ui.chargelist.interfaces.b
    public void c(@OOXIXo com.baidu.navisdk.ui.chargelist.data.beans.e stationWrapper) {
        IIX0o.x0xO0oo(stationWrapper, "stationWrapper");
        if (!this.z.a(stationWrapper)) {
            com.baidu.navisdk.ui.chargelist.interfaces.b bVar = this.f;
            if (bVar != null) {
                bVar.b();
            }
            com.baidu.navisdk.ui.chargelist.interfaces.a aVar = this.e;
            if (aVar != null) {
                aVar.b();
            }
        } else {
            com.baidu.navisdk.ui.chargelist.interfaces.b bVar2 = this.f;
            if (bVar2 != null) {
                bVar2.c(stationWrapper);
            }
        }
        com.baidu.navisdk.util.statistic.userop.b.r().a("11.11.4", n() ? "1" : "0", o() ? "1" : "0");
    }

    private final void a(int i2, boolean z, int i3, int i4) {
        this.z.b(z);
        this.z.c(i2);
        this.z.a(i3);
        this.z.b(i4);
        this.z.i().observe(this, new e());
        this.z.c().observe(this, new C0407f());
        this.z.f().observe(this, new g());
        this.z.d().observe(this, new h());
        this.z.g().observe(this, new i());
        this.z.j().observe(this, new j());
    }

    @Override // com.baidu.navisdk.ui.chargelist.interfaces.b
    public void b(@OOXIXo com.baidu.navisdk.ui.chargelist.data.beans.b chargeWrapper) {
        IIX0o.x0xO0oo(chargeWrapper, "chargeWrapper");
        if (this.z.a(chargeWrapper) != null) {
            com.baidu.navisdk.ui.chargelist.interfaces.a aVar = this.e;
            if (aVar != null) {
                aVar.a(chargeWrapper);
            }
            com.baidu.navisdk.ui.chargelist.interfaces.b bVar = this.f;
            if (bVar != null) {
                bVar.a(chargeWrapper);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(int i2) {
        String str;
        TextView textView = this.s;
        if (textView == null) {
            IIX0o.XOxIOxOx("selectApproachNodeInfo");
        }
        if (i2 > 0) {
            str = "已选" + i2 + (char) 20010;
        } else {
            str = "请选择途经点";
        }
        textView.setText(str);
    }

    @Override // com.baidu.navisdk.ui.chargelist.interfaces.b
    public void b(@OOXIXo com.baidu.navisdk.ui.chargelist.data.beans.e stationWrapper) {
        IIX0o.x0xO0oo(stationWrapper, "stationWrapper");
        com.baidu.navisdk.ui.chargelist.interfaces.a aVar = this.e;
        if (aVar != null) {
            IIX0o.ooOOo0oXI(aVar);
            aVar.a(stationWrapper.j());
        }
    }

    public final void a(@OOXIXo com.baidu.navisdk.ui.chargelist.interfaces.b changedCallBack) {
        IIX0o.x0xO0oo(changedCallBack, "changedCallBack");
        this.f = changedCallBack;
    }

    public final void a(@OOXIXo ViewGroup rootView) {
        IIX0o.x0xO0oo(rootView, "rootView");
        if (LogUtil.LOGGABLE) {
            LogUtil.e("ChargeListView", "show: ");
        }
        this.c = rootView;
        if (rootView != null) {
            g();
            ViewGroup viewGroup = this.c;
            IIX0o.ooOOo0oXI(viewGroup);
            viewGroup.setVisibility(0);
            Animation a2 = com.baidu.navisdk.utils.a.a(a.b.ANIM_DOWN_IN, 0L, 300L);
            ViewGroup viewGroup2 = this.c;
            IIX0o.ooOOo0oXI(viewGroup2);
            viewGroup2.setLayoutAnimationListener(new o());
            ViewGroup viewGroup3 = this.c;
            if (viewGroup3 != null) {
                viewGroup3.startAnimation(a2);
            }
            com.baidu.navisdk.ui.chargelist.c cVar = this.h;
            if (cVar == null) {
                IIX0o.XOxIOxOx("chargeListAdapter");
            }
            cVar.a(this);
            a(Lifecycle.Event.ON_CREATE);
            a(Lifecycle.Event.ON_START);
            a(Lifecycle.Event.ON_RESUME);
        }
    }

    public final void a(@oOoXoXO String str, @oOoXoXO com.baidu.navisdk.model.datastruct.chargestation.e eVar, int i2, boolean z) {
        this.z.a(null, null, str, eVar, i2, z);
    }

    public final boolean a(@oOoXoXO String str) {
        return this.z.a(str);
    }

    public final void a(boolean z) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("ChargeListView", "hide: " + z);
        }
        a(Lifecycle.Event.ON_PAUSE);
        a(Lifecycle.Event.ON_STOP);
        a(Lifecycle.Event.ON_DESTROY);
        com.baidu.navisdk.ui.chargelist.c cVar = this.h;
        if (cVar == null) {
            IIX0o.XOxIOxOx("chargeListAdapter");
        }
        cVar.b();
        if (z) {
            Animation animOut = com.baidu.navisdk.utils.a.a(a.b.ANIM_DOWN_OUT, 0L, 300L);
            IIX0o.oO(animOut, "animOut");
            animOut.setFillAfter(true);
            animOut.setAnimationListener(new b());
            ViewGroup viewGroup = this.c;
            if (viewGroup != null) {
                viewGroup.startAnimation(animOut);
                return;
            }
            return;
        }
        c();
    }

    private final void a(Lifecycle.Event event) {
        this.b.handleLifecycleEvent(event);
    }

    @Override // com.baidu.navisdk.ui.chargelist.interfaces.b
    public void a(@OOXIXo com.baidu.navisdk.ui.chargelist.data.beans.e stationWrapper) {
        IIX0o.x0xO0oo(stationWrapper, "stationWrapper");
        if (!this.z.a(stationWrapper)) {
            com.baidu.navisdk.ui.chargelist.interfaces.b bVar = this.f;
            if (bVar != null) {
                bVar.b();
            }
            com.baidu.navisdk.ui.chargelist.interfaces.a aVar = this.e;
            if (aVar != null) {
                aVar.b();
            }
        }
        com.baidu.navisdk.ui.chargelist.interfaces.b bVar2 = this.f;
        if (bVar2 != null) {
            bVar2.a(stationWrapper);
        }
        com.baidu.navisdk.util.statistic.userop.b.r().a("11.11.10", n() ? "1" : "0", o() ? "1" : "0");
    }

    @Override // com.baidu.navisdk.ui.chargelist.interfaces.b
    public void a(@OOXIXo com.baidu.navisdk.ui.chargelist.data.beans.b chargeWrapper) {
        IIX0o.x0xO0oo(chargeWrapper, "chargeWrapper");
        this.z.a(chargeWrapper, false);
        com.baidu.navisdk.ui.chargelist.interfaces.a aVar = this.e;
        if (aVar != null) {
            aVar.a(chargeWrapper);
        }
        com.baidu.navisdk.ui.chargelist.interfaces.b bVar = this.f;
        if (bVar != null) {
            bVar.a(chargeWrapper);
        }
        com.baidu.navisdk.util.statistic.userop.b.r().a("11.11.8", n() ? "1" : "0", o() ? "1" : "0");
    }

    public void a() {
        com.baidu.navisdk.ui.chargelist.interfaces.a aVar = this.e;
        if (aVar != null) {
            IIX0o.ooOOo0oXI(aVar);
            ArrayList<com.baidu.navisdk.model.datastruct.chargestation.b> addCsInfoList = getAddCsInfoList();
            ArrayList<com.baidu.navisdk.model.datastruct.chargestation.b> removeCsInfoList = getRemoveCsInfoList();
            Integer value = this.z.f().getValue();
            if (value == null) {
                value = 0;
            }
            IIX0o.oO(value, "model.pickedCountData.value ?: 0");
            aVar.a(addCsInfoList, removeCsInfoList, value.intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(int i2, boolean z) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.COMMON_UI;
        if (gVar.d()) {
            gVar.e("ChargeListView", "smoothScrollToPosition --> position = " + i2 + ", force = " + z);
        }
        com.baidu.navisdk.util.worker.lite.a.c(new p(z, i2, "smoothScrollToPosition"));
    }

    @Override // com.baidu.navisdk.ui.chargelist.b.c
    public void a(@OOXIXo Set<Integer> filterSet) {
        IIX0o.x0xO0oo(filterSet, "filterSet");
        this.z.a(filterSet);
        com.baidu.navisdk.ui.chargelist.interfaces.a aVar = this.e;
        if (aVar != null) {
            aVar.a(filterSet);
        }
    }
}
