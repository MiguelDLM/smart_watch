package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.routeguide.model.v;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.utils.a;
import java.util.ArrayList;

/* loaded from: classes8.dex */
public class m0 extends j {
    private View e;
    private TextView f;
    private TextView g;
    private TextView h;
    private RecyclerView i;
    private ImageView j;
    private ArrayList<v.a> k = new ArrayList<>();
    private com.baidu.navisdk.ui.routeguide.adapter.b l;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            m0.this.p();
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Animation.AnimationListener {
        public b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGMMRemainStallView", "onAnimationEnd: ");
            }
            if (m0.this.e != null) {
                m0.this.e.clearAnimation();
            }
            com.baidu.navisdk.ui.routeguide.control.i.g().b(1012);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public m0() {
        this.f8808a = 1012;
        s();
        q();
        a(com.baidu.navisdk.ui.util.b.b());
    }

    private void q() {
        a aVar = new a();
        this.j.setOnClickListener(aVar);
        this.h.setOnClickListener(aVar);
    }

    private void r() {
        this.i.setLayoutManager(new LinearLayoutManager(this.b, 0, false));
        com.baidu.navisdk.ui.routeguide.adapter.b bVar = this.l;
        if (bVar == null) {
            com.baidu.navisdk.ui.routeguide.adapter.b bVar2 = new com.baidu.navisdk.ui.routeguide.adapter.b(this.k);
            this.l = bVar2;
            this.i.setAdapter(bVar2);
            return;
        }
        bVar.a(this.k);
    }

    private void s() {
        View a2 = com.baidu.navisdk.ui.util.b.a(com.baidu.navisdk.framework.a.c().a(), R.layout.nsdk_layout_rg_remain_stall_card);
        this.e = a2;
        this.j = (ImageView) a2.findViewById(R.id.bnav_rg_close_iv);
        this.f = (TextView) this.e.findViewById(R.id.bnav_rg_title);
        this.g = (TextView) this.e.findViewById(R.id.bnav_rg_stall);
        this.h = (TextView) this.e.findViewById(R.id.bnav_confirm);
        this.i = (RecyclerView) this.e.findViewById(R.id.bnav_rg_recycler_view);
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

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.j
    public int l() {
        return 20000;
    }

    public void p() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMRemainStallView", "hideOnAnimation: ");
        }
        Animation a2 = com.baidu.navisdk.utils.a.a(a.b.ANIM_DOWN_OUT, 0L, 500L);
        a2.setFillAfter(true);
        a2.setAnimationListener(new b());
        View view = this.e;
        if (view != null) {
            view.startAnimation(a2);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.k
    public void a(boolean z) {
        com.baidu.navisdk.ui.util.b.a(this.f, R.color.nsdk_service_area_zone_type_item_text);
        com.baidu.navisdk.ui.util.b.a(this.j, R.drawable.nsdk_drawable_toolbox_icon_quit_nav);
        if (!com.baidu.navisdk.module.cloudconfig.f.c().c.C) {
            LogUtil.e("RGMMRemainStallView", "day night open");
        } else if (this.e == null) {
            LogUtil.e("RGMMRemainStallView", "rootview is null");
        }
    }

    public void a(com.baidu.navisdk.ui.routeguide.model.v vVar) {
        if (vVar == null || vVar.a() == null || vVar.a().size() <= 0) {
            return;
        }
        if (!TextUtils.isEmpty(vVar.b())) {
            String b2 = vVar.b();
            SpannableString spannableString = new SpannableString(String.valueOf(vVar.c()));
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#3377FF")), 0, spannableString.length(), 0);
            this.f.setText(b2);
            this.g.setText("剩余车位");
            this.g.append(spannableString);
            this.g.append("个");
        }
        this.k.clear();
        this.k.addAll(vVar.a());
        this.l.a(this.k);
    }
}
