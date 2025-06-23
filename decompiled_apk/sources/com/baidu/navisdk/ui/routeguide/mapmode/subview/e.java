package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import java.util.ArrayList;

/* loaded from: classes8.dex */
public class e extends k {
    private View c;
    private TextView d;
    private View e;
    private TextView f;
    private ImageView g;
    private RecyclerView h;
    private com.baidu.navisdk.ui.routeguide.mapmode.subview.parkinglot.b i;
    private com.baidu.navisdk.ui.routeguide.mapmode.subview.parkinglot.a j;
    private View k;
    private TextView l;
    private View m;
    private TextView n;
    private View o;

    /* loaded from: classes8.dex */
    public class a implements View.OnTouchListener {
        public a(e eVar) {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                com.baidu.navisdk.ui.routeguide.control.f.k().j();
                return false;
            }
            return false;
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public b(e eVar) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.navisdk.util.statistic.userop.b.r().b("3.y.2.6");
            com.baidu.navisdk.ui.routeguide.b.V().k().d();
        }
    }

    /* loaded from: classes8.dex */
    public class c implements View.OnClickListener {
        public c(e eVar) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.navisdk.ui.routeguide.control.f.k().d();
            com.baidu.navisdk.util.statistic.userop.b.r().b("3.y.2.3");
        }
    }

    /* loaded from: classes8.dex */
    public class d implements View.OnClickListener {
        public d(e eVar) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.navisdk.util.statistic.userop.b.r().b("3.y.2.5");
            com.baidu.navisdk.ui.routeguide.b.V().k().b();
        }
    }

    /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.subview.e$e, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0457e implements com.baidu.navisdk.ui.routeguide.mapmode.subview.parkinglot.a {
        public C0457e() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.parkinglot.a
        public void a(View view, int i) {
            if (view.getId() == R.id.parking_item) {
                com.baidu.navisdk.ui.routeguide.model.a.c().a(i);
                e.this.n();
                BNMapController.getInstance().focusItem(4, i, true);
            } else if (view.getId() == R.id.parking_goto) {
                com.baidu.navisdk.ui.routeguide.model.a.c().a(i);
                com.baidu.navisdk.ui.routeguide.control.f.k().g();
                com.baidu.navisdk.util.statistic.userop.b.r().a("3.y.2.2", "" + (com.baidu.navisdk.ui.routeguide.model.a.c().b + 1), null, null);
            }
        }
    }

    public e() {
        this.f8808a = 1000;
        m();
        l();
        a(com.baidu.navisdk.ui.util.b.b());
    }

    private void l() {
        this.o.setOnTouchListener(new a(this));
        this.e.setOnClickListener(new b(this));
        this.k.setOnClickListener(new c(this));
        this.m.setOnClickListener(new d(this));
        this.j = new C0457e();
    }

    private void m() {
        Context a2 = com.baidu.navisdk.framework.a.c().a();
        View a3 = com.baidu.navisdk.ui.util.b.a(a2, R.layout.nsdk_layout_rg_mapmode_arrive_dest_park_card);
        this.c = a3;
        this.d = (TextView) a3.findViewById(R.id.bnav_rg_arrive_dest_park_main_title);
        this.e = this.c.findViewById(R.id.bnav_rg_arrive_dest_park_more);
        this.f = (TextView) this.c.findViewById(R.id.bnav_rg_arrive_dest_park_more_tv);
        this.g = (ImageView) this.c.findViewById(R.id.bnav_rg_arrive_dest_park_more_iv);
        this.h = (RecyclerView) this.c.findViewById(R.id.bnav_rg_arrive_dest_park_recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(a2);
        linearLayoutManager.setOrientation(1);
        this.h.setLayoutManager(linearLayoutManager);
        this.k = this.c.findViewById(R.id.bnav_rg_arrive_dest_park_cancel_btn_layout);
        this.l = (TextView) this.c.findViewById(R.id.bnav_rg_arrive_dest_park_cancel_btn);
        this.m = this.c.findViewById(R.id.bnav_rg_arrive_dest_park_record_btn_layout);
        this.n = (TextView) this.c.findViewById(R.id.bnav_rg_arrive_dest_park_record_btn);
        this.o = this.c.findViewById(R.id.bnav_rg_arrive_dest_park_mask);
        com.baidu.navisdk.ui.util.b.a(this.d, R.color.nsdk_cl_text_b_mm_title);
        com.baidu.navisdk.ui.util.b.a(this.f, R.color.nsdk_cl_text_b);
        com.baidu.navisdk.ui.util.b.a(this.g, R.drawable.bnav_rg_arrive_dest_park_more_arrow);
        com.baidu.navisdk.ui.util.b.a(this.k, R.drawable.nsdk_drawable_rg_operable_notification_cancel_btn);
        com.baidu.navisdk.ui.util.b.a(this.l, R.color.nsdk_cl_text_b_mm);
        com.baidu.navisdk.ui.util.b.a(this.m, R.drawable.nsdk_drawable_rg_operable_notification_confirm_btn);
        com.baidu.navisdk.ui.util.b.a(this.n, R.color.nsdk_rg_operable_notification_low_priority_confirm_text);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        ArrayList<com.baidu.navisdk.model.datastruct.r> arrayList = com.baidu.navisdk.ui.routeguide.model.a.c().f8926a;
        if (LogUtil.LOGGABLE) {
            LogUtil.printList("RGMMArriveDestParkView", "refreshParkingLotView", "mDestParkPoiList", arrayList);
        }
        int i = com.baidu.navisdk.ui.routeguide.model.a.c().b;
        com.baidu.navisdk.ui.routeguide.mapmode.subview.parkinglot.b bVar = this.i;
        if (bVar == null) {
            com.baidu.navisdk.ui.routeguide.mapmode.subview.parkinglot.b bVar2 = new com.baidu.navisdk.ui.routeguide.mapmode.subview.parkinglot.b(com.baidu.navisdk.framework.a.c().a(), this.j, arrayList, i);
            this.i = bVar2;
            this.h.setAdapter(bVar2);
            return;
        }
        bVar.a(arrayList, i);
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.k
    public RelativeLayout.LayoutParams d() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        if (!com.baidu.navisdk.ui.routeguide.control.x.b().s2()) {
            layoutParams.width = com.baidu.navisdk.ui.routeguide.control.f.k().b();
        }
        int dimensionPixelOffset = JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_toolbox_margin_left);
        layoutParams.setMargins(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        return layoutParams;
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.k
    public View e() {
        return this.c;
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.k
    public void h() {
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.k
    public void j() {
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.k
    public void k() {
        n();
        ViewGroup.LayoutParams layoutParams = this.h.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(-1, -2);
        }
        layoutParams.height = com.baidu.navisdk.ui.routeguide.mapmode.subview.parkinglot.c.b(com.baidu.navisdk.ui.routeguide.model.a.c().f8926a, com.baidu.navisdk.ui.routeguide.control.x.b().s2());
        this.h.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.k
    public void a(boolean z) {
        if (!com.baidu.navisdk.module.cloudconfig.f.c().c.C) {
            LogUtil.e("RGMMArriveDestParkView", "day night open");
        } else if (this.c == null) {
            LogUtil.e("RGMMArriveDestParkView", "rootview is null");
        }
    }
}
