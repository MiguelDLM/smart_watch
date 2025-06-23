package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.routeguide.adapter.c;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.utils.a;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes8.dex */
public class w0 extends j {
    private View e;
    private TextView f;
    private TextView g;
    private TextView h;
    private View i;
    private RecyclerView j;
    private ImageView k;
    private ImageView l;
    private ImageView m;
    private ImageView n;
    private ImageView o;
    private ImageView p;
    private ImageView q;
    private ImageView r;
    private ArrayList<ImageView> s;
    private ArrayList<com.baidu.navisdk.module.pronavi.model.e> t = new ArrayList<>();
    private RecyclerView.ItemDecoration u;
    private com.baidu.navisdk.ui.routeguide.adapter.c v;

    /* loaded from: classes8.dex */
    public class a implements c.InterfaceC0412c {
        public a() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.adapter.c.InterfaceC0412c
        public void a(int i, com.baidu.navisdk.module.pronavi.model.e eVar) {
            if (eVar != null && !TextUtils.isEmpty(eVar.a())) {
                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
                if (gVar.d()) {
                    gVar.e("RGArriveApproachParkController", "ServiceAreaZoneInfo-> selected zone type = " + eVar);
                }
                com.baidu.navisdk.ui.routeguide.control.e.o.a(eVar.a());
                String str = "好的，将为您导航到" + eVar.b() + "附近的停车位置";
                if (!com.baidu.navisdk.asr.query.a.a(com.baidu.navisdk.framework.a.c().a()).b("service_partition")) {
                    if (gVar.d()) {
                        gVar.e("RGMMServiceAreaZoneParkView", "itemClick BNAsrQueryFreq.query() false");
                    }
                    TTSPlayerControl.playTTS(str, 1);
                } else {
                    com.baidu.navisdk.asr.d.B().a(com.baidu.navisdk.module.asr.instructions.b.b(str));
                }
            }
            w0.this.p();
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            w0.this.p();
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Animation.AnimationListener {
        public c() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGMMServiceAreaZoneParkView", "onAnimationEnd: ");
            }
            if (w0.this.e != null) {
                w0.this.e.clearAnimation();
            }
            com.baidu.navisdk.ui.routeguide.control.i.g().b(1011);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* loaded from: classes8.dex */
    public class d extends RecyclerView.ItemDecoration {

        /* renamed from: a, reason: collision with root package name */
        private final int f8907a;
        private final int b;

        public d(w0 w0Var, int i, int i2) {
            this.f8907a = i;
            this.b = i2;
        }

        private boolean a(int i, int i2, int i3) {
            return i >= i3 - (i3 % i2);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            if (a(recyclerView.getChildAdapterPosition(view), a(recyclerView), recyclerView.getAdapter().getItemCount())) {
                int i = this.f8907a;
                rect.set(i, 0, i, 0);
            } else {
                int i2 = this.f8907a;
                rect.set(i2, 0, i2, this.b);
            }
        }

        private int a(RecyclerView recyclerView) {
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof GridLayoutManager) {
                return ((GridLayoutManager) layoutManager).getSpanCount();
            }
            return -1;
        }
    }

    /* loaded from: classes8.dex */
    public class e extends RecyclerView.ItemDecoration {

        /* renamed from: a, reason: collision with root package name */
        private final int f8908a;

        public e(w0 w0Var, int i) {
            this.f8908a = i;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            rect.set(0, 0, this.f8908a, 0);
        }
    }

    public w0() {
        this.f8808a = 1011;
        s();
        q();
        a(com.baidu.navisdk.ui.util.b.b());
    }

    private void q() {
        this.l.setOnClickListener(new b());
    }

    private void r() {
        boolean s2 = com.baidu.navisdk.ui.routeguide.control.x.b().s2();
        int d2 = com.baidu.navisdk.ui.util.b.d(R.dimen.navi_dimens_5dp);
        int d3 = com.baidu.navisdk.ui.util.b.d(R.dimen.navi_dimens_10dp);
        RecyclerView.ItemDecoration itemDecoration = this.u;
        if (itemDecoration != null) {
            this.j.removeItemDecoration(itemDecoration);
        }
        if (s2) {
            this.j.setLayoutManager(new GridLayoutManager(this.b, 3));
            this.u = new d(this, d2, d3);
            this.j.setPadding(0, 0, 0, 0);
        } else {
            this.u = new e(this, d3);
            this.j.setLayoutManager(new LinearLayoutManager(this.b, 0, false));
            this.j.setPadding(d2, 0, d2, 0);
        }
        this.j.addItemDecoration(this.u);
        com.baidu.navisdk.ui.routeguide.adapter.c cVar = this.v;
        if (cVar == null) {
            com.baidu.navisdk.ui.routeguide.adapter.c cVar2 = new com.baidu.navisdk.ui.routeguide.adapter.c(this.t);
            this.v = cVar2;
            this.j.setAdapter(cVar2);
        } else {
            cVar.a(this.t);
        }
        this.v.a(new a());
    }

    private void s() {
        View a2 = com.baidu.navisdk.ui.util.b.a(com.baidu.navisdk.framework.a.c().a(), R.layout.nsdk_layout_rg_mapmode_service_area_zone_park_card);
        this.e = a2;
        this.l = (ImageView) a2.findViewById(R.id.bnav_rg_close_iv);
        this.k = (ImageView) this.e.findViewById(R.id.bnav_rg_icon);
        this.f = (TextView) this.e.findViewById(R.id.bnav_rg_title);
        this.g = (TextView) this.e.findViewById(R.id.bnav_rg_subtitle);
        this.h = (TextView) this.e.findViewById(R.id.bnav_rg_empty_parking_place);
        this.i = this.e.findViewById(R.id.bnav_rg_service_icon_layout);
        this.j = (RecyclerView) this.e.findViewById(R.id.bnav_rg_recycler_view);
        this.m = (ImageView) this.e.findViewById(R.id.hw_item_icon_park);
        this.n = (ImageView) this.e.findViewById(R.id.hw_item_icon_petrol_station);
        this.o = (ImageView) this.e.findViewById(R.id.hw_item_icon_diningroom);
        this.p = (ImageView) this.e.findViewById(R.id.hw_item_icon_wc);
        this.q = (ImageView) this.e.findViewById(R.id.hw_item_icon_garage);
        this.r = (ImageView) this.e.findViewById(R.id.hw_item_icon_shop);
        ArrayList<ImageView> arrayList = new ArrayList<>();
        this.s = arrayList;
        arrayList.add(this.m);
        this.s.add(this.n);
        this.s.add(this.o);
        this.s.add(this.p);
        this.s.add(this.q);
        this.s.add(this.r);
        this.k.setImageDrawable(com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_notification_service_area));
        r();
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.k
    public RelativeLayout.LayoutParams d() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        if (com.baidu.navisdk.ui.routeguide.control.x.b().s2()) {
            layoutParams.setMargins(0, 0, 0, 0);
        } else {
            layoutParams.setMargins(com.baidu.navisdk.ui.routeguide.control.x.b().V(), 0, 0, 0);
        }
        layoutParams.addRule(12);
        return layoutParams;
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.k
    public View e() {
        return this.e;
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.k
    public void h() {
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.j, com.baidu.navisdk.ui.routeguide.mapmode.subview.k
    public void j() {
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.j, com.baidu.navisdk.ui.routeguide.mapmode.subview.k
    public void k() {
        super.k();
        r();
        if (this.e != null) {
            this.e.startAnimation(com.baidu.navisdk.utils.a.a(a.b.ANIM_DOWN_IN, 0L, 600L));
        }
    }

    public void p() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMServiceAreaZoneParkView", "hideOnAnimation: ");
        }
        Animation a2 = com.baidu.navisdk.utils.a.a(a.b.ANIM_DOWN_OUT, 0L, 500L);
        a2.setFillAfter(true);
        a2.setAnimationListener(new c());
        View view = this.e;
        if (view != null) {
            view.startAnimation(a2);
        }
    }

    public void a(com.baidu.navisdk.module.pronavi.model.d dVar, List<com.baidu.navisdk.module.pronavi.model.e> list) {
        if (dVar != null) {
            this.f.setText(dVar.h());
        }
        a(dVar);
        this.t.clear();
        if (list != null) {
            this.t.addAll(list);
        }
        com.baidu.navisdk.ui.routeguide.adapter.c cVar = this.v;
        if (cVar != null) {
            cVar.a(this.t);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.k
    public void a(boolean z) {
        com.baidu.navisdk.ui.util.b.a(this.f, R.color.nsdk_service_area_zone_type_item_text);
        com.baidu.navisdk.ui.util.b.a(this.g, R.color.nsdk_service_area_zone_card_subtitle);
        if (!com.baidu.navisdk.module.cloudconfig.f.c().c.C) {
            LogUtil.e("RGMMServiceAreaZoneParkView", "day night open");
        } else if (this.e == null) {
            LogUtil.e("RGMMServiceAreaZoneParkView", "rootview is null");
        }
    }

    public void a(com.baidu.navisdk.module.pronavi.model.d dVar) {
        if (dVar != null && dVar.p() == 4) {
            this.i.setVisibility(0);
            this.h.setVisibility(dVar.r() ? 0 : 8);
            if (dVar.r()) {
                com.baidu.navisdk.module.pronavi.model.a aVar = (com.baidu.navisdk.module.pronavi.model.a) dVar.a("parking_lot_info");
                if (aVar != null && aVar.a() > 0) {
                    this.h.setVisibility(0);
                    this.h.setText("空车位: " + aVar.a());
                } else {
                    this.h.setVisibility(8);
                }
            } else {
                this.h.setVisibility(8);
            }
            com.baidu.navisdk.ui.routeguide.mapmode.subview.highway.i.a(new ArrayList(dVar.o()), this.s, com.baidu.navisdk.ui.routeguide.mapmode.subview.highway.i.f8769a);
            return;
        }
        this.i.setVisibility(8);
        this.h.setVisibility(8);
    }
}
