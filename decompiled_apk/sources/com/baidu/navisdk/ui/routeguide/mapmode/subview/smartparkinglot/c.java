package com.baidu.navisdk.ui.routeguide.mapmode.subview.smartparkinglot;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.xoIox;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.model.datastruct.destrec.f;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.smartparkinglot.b;
import com.baidu.navisdk.ui.routeguide.widget.d;
import com.baidu.navisdk.util.common.g;
import java.util.ArrayList;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes8.dex */
public final class c extends d {

    @oOoXoXO
    private View i;
    public TextView j;
    public View k;
    public RecyclerView l;

    @oOoXoXO
    private View.OnClickListener m;

    @oOoXoXO
    private final Context n;

    @OOXIXo
    private ArrayList<f> o;
    private final boolean p;

    @OOXIXo
    private final b.a q;

    /* loaded from: classes8.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(IIXOooo iIXOooo) {
            this();
        }
    }

    /* loaded from: classes8.dex */
    public static final class b implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public static final b f8882a = new b();

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
        }
    }

    static {
        new a(null);
    }

    public /* synthetic */ c(Context context, ViewGroup viewGroup, ArrayList arrayList, boolean z, b.a aVar, com.baidu.navisdk.ui.routeguide.subview.a aVar2, int i, int i2, IIXOooo iIXOooo) {
        this(context, viewGroup, arrayList, z, aVar, (i2 & 32) != 0 ? null : aVar2, (i2 & 64) != 0 ? 1 : i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void a(c cVar, boolean z, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            arrayList = null;
        }
        cVar.a(z, (ArrayList<com.baidu.navisdk.ui.routeguide.mapmode.subview.smartparkinglot.a>) arrayList);
    }

    public final void b(@oOoXoXO View.OnClickListener onClickListener) {
        this.m = onClickListener;
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void c() {
        ViewParent viewParent;
        super.c();
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            StringBuilder sb = new StringBuilder();
            sb.append("hide + ");
            sb.append(this.i);
            sb.append(" parent = ");
            View view = this.i;
            if (view != null) {
                viewParent = view.getParent();
            } else {
                viewParent = null;
            }
            sb.append(viewParent);
            gVar.e("RGMMParkingLotListView", sb.toString());
        }
        View view2 = this.i;
        if (view2 != null) {
            view2.setVisibility(8);
        }
    }

    public final void f(@oOoXoXO String str) {
        if (!TextUtils.isEmpty(str)) {
            TextView textView = this.j;
            if (textView == null) {
                IIX0o.XOxIOxOx("mTitleView");
            }
            textView.setText(str);
        }
    }

    @oOoXoXO
    public final com.baidu.navisdk.ui.routeguide.mapmode.subview.smartparkinglot.b n0() {
        RecyclerView recyclerView = this.l;
        if (recyclerView == null) {
            IIX0o.XOxIOxOx("mList");
        }
        if (recyclerView.getAdapter() != null) {
            RecyclerView recyclerView2 = this.l;
            if (recyclerView2 == null) {
                IIX0o.XOxIOxOx("mList");
            }
            if (recyclerView2.getAdapter() instanceof com.baidu.navisdk.ui.routeguide.mapmode.subview.smartparkinglot.b) {
                RecyclerView recyclerView3 = this.l;
                if (recyclerView3 == null) {
                    IIX0o.XOxIOxOx("mList");
                }
                RecyclerView.Adapter adapter = recyclerView3.getAdapter();
                if (adapter != null) {
                    return (com.baidu.navisdk.ui.routeguide.mapmode.subview.smartparkinglot.b) adapter;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.baidu.navisdk.ui.routeguide.mapmode.subview.smartparkinglot.ParkingLotListAdapter");
            }
            return null;
        }
        return null;
    }

    @OOXIXo
    public final RecyclerView o0() {
        RecyclerView recyclerView = this.l;
        if (recyclerView == null) {
            IIX0o.XOxIOxOx("mList");
        }
        return recyclerView;
    }

    public final void v(int i) {
        RecyclerView recyclerView = this.l;
        if (recyclerView == null) {
            IIX0o.XOxIOxOx("mList");
        }
        RecyclerView.ViewHolder findViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(i);
        if (findViewHolderForAdapterPosition instanceof b.C0463b) {
            ((b.C0463b) findViewHolderForAdapterPosition).b();
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public boolean y() {
        ViewParent viewParent;
        super.y();
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            StringBuilder sb = new StringBuilder();
            sb.append("show + ");
            sb.append(this.i);
            sb.append(" parent = ");
            View view = this.i;
            if (view != null) {
                viewParent = view.getParent();
            } else {
                viewParent = null;
            }
            sb.append(viewParent);
            gVar.e("RGMMParkingLotListView", sb.toString());
        }
        com.baidu.navisdk.ui.routeguide.mapmode.a b2 = x.b();
        IIX0o.oO(b2, "RGViewController.getInstance()");
        if (b2.L2()) {
            x.b().G1();
        }
        View view2 = this.i;
        if (view2 != null) {
            if (view2.getVisibility() != 8) {
                return false;
            }
            View view3 = this.i;
            if (view3 != null) {
                view3.setVisibility(0);
                return true;
            }
            return true;
        }
        a(this, false, null, 3, null);
        return true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @xoIox
    public c(@oOoXoXO Context context, @oOoXoXO ViewGroup viewGroup, @OOXIXo ArrayList<f> dataList, boolean z, @OOXIXo b.a clickListener, @oOoXoXO com.baidu.navisdk.ui.routeguide.subview.a aVar, int i) {
        super(context, viewGroup, aVar, i);
        IIX0o.x0xO0oo(dataList, "dataList");
        IIX0o.x0xO0oo(clickListener, "clickListener");
        this.n = context;
        this.o = dataList;
        this.p = z;
        this.q = clickListener;
    }

    public final void a(boolean z, @oOoXoXO ArrayList<com.baidu.navisdk.ui.routeguide.mapmode.subview.smartparkinglot.a> arrayList) {
        try {
            View findViewById = this.b.findViewById(R.id.navi_rg_parking_lot_list_stub);
            IIX0o.oO(findViewById, "mRootViewGroup.findViewB…rg_parking_lot_list_stub)");
            com.baidu.navisdk.ui.util.b.a((ViewStub) findViewById);
        } catch (Exception e) {
            g gVar = g.PRO_NAV;
            if (gVar.c()) {
                gVar.c("RGMMParkingLotListView", "load smart park list viewStub error : " + e);
            }
        }
        g gVar2 = g.PRO_NAV;
        if (gVar2.d()) {
            gVar2.e("RGMMParkingLotListView", "init");
        }
        this.i = this.b.findViewById(R.id.navi_rg_parking_list_layout);
        View findViewById2 = this.b.findViewById(R.id.parking_lot_title);
        IIX0o.oO(findViewById2, "mRootViewGroup.findViewB…d(R.id.parking_lot_title)");
        this.j = (TextView) findViewById2;
        View findViewById3 = this.b.findViewById(R.id.parking_lot_close);
        IIX0o.oO(findViewById3, "mRootViewGroup.findViewB…d(R.id.parking_lot_close)");
        this.k = findViewById3;
        View findViewById4 = this.b.findViewById(R.id.parking_lot_list);
        IIX0o.oO(findViewById4, "mRootViewGroup.findViewById(R.id.parking_lot_list)");
        this.l = (RecyclerView) findViewById4;
        View view = this.i;
        if (view != null) {
            view.setOnClickListener(b.f8882a);
        }
        View view2 = this.k;
        if (view2 == null) {
            IIX0o.XOxIOxOx("mCloseIcon");
        }
        view2.setOnClickListener(this.m);
        RecyclerView recyclerView = this.l;
        if (recyclerView == null) {
            IIX0o.XOxIOxOx("mList");
        }
        Context context = this.n;
        IIX0o.ooOOo0oXI(context);
        recyclerView.setAdapter(new com.baidu.navisdk.ui.routeguide.mapmode.subview.smartparkinglot.b(context, this.o, this.q, this.p, this.f));
        if (z && arrayList != null && arrayList.size() > 0) {
            RecyclerView recyclerView2 = this.l;
            if (recyclerView2 == null) {
                IIX0o.XOxIOxOx("mList");
            }
            RecyclerView.Adapter adapter = recyclerView2.getAdapter();
            if (adapter == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.baidu.navisdk.ui.routeguide.mapmode.subview.smartparkinglot.ParkingLotListAdapter");
            }
            ((com.baidu.navisdk.ui.routeguide.mapmode.subview.smartparkinglot.b) adapter).a(arrayList);
        }
        RecyclerView recyclerView3 = this.l;
        if (recyclerView3 == null) {
            IIX0o.XOxIOxOx("mList");
        }
        recyclerView3.setLayoutManager(new LinearLayoutManager(this.n, 0, false));
        if (this.f == 2) {
            View view3 = this.i;
            ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(view3 != null ? view3.getLayoutParams() : null);
            View view4 = this.i;
            ViewParent parent = view4 != null ? view4.getParent() : null;
            if (parent != null) {
                ViewGroup viewGroup = (ViewGroup) parent;
                View guidePanel = viewGroup.findViewById(R.id.bnav_rg_top_panel);
                IIX0o.oO(guidePanel, "guidePanel");
                layoutParams.leftToLeft = guidePanel.getId();
                layoutParams.rightToRight = guidePanel.getId();
                layoutParams.bottomToBottom = viewGroup.getId();
                Context mContext = this.f9165a;
                IIX0o.oO(mContext, "mContext");
                ((ViewGroup.MarginLayoutParams) layoutParams).height = mContext.getResources().getDimensionPixelSize(R.dimen.navi_dimens_210dp);
                Context mContext2 = this.f9165a;
                IIX0o.oO(mContext2, "mContext");
                Resources resources = mContext2.getResources();
                int i = R.dimen.navi_dimens_9dp;
                ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = resources.getDimensionPixelSize(i);
                Context mContext3 = this.f9165a;
                IIX0o.oO(mContext3, "mContext");
                ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = mContext3.getResources().getDimensionPixelSize(i);
                View view5 = this.i;
                if (view5 != null) {
                    view5.setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        }
    }

    public final void a(@oOoXoXO ViewGroup viewGroup, int i, @oOoXoXO ArrayList<com.baidu.navisdk.ui.routeguide.mapmode.subview.smartparkinglot.a> arrayList) {
        super.a(viewGroup, i);
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            StringBuilder sb = new StringBuilder();
            sb.append("ori change + ");
            sb.append(this.i);
            sb.append(" parent = ");
            View view = this.i;
            sb.append(view != null ? view.getParent() : null);
            gVar.e("RGMMParkingLotListView", sb.toString());
        }
        a(true, arrayList);
    }
}
