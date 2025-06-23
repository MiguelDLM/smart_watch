package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes8.dex */
public class k1 extends g implements View.OnClickListener {
    private View e;
    private Button f;
    private Context g;
    private int h;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            k1.b(k1.this);
            k1 k1Var = k1.this;
            k1Var.a(k1Var.h);
        }
    }

    public k1() {
        this.f8808a = 1002;
        this.g = com.baidu.navisdk.ui.routeguide.b.V().c();
        r();
    }

    public static /* synthetic */ int b(k1 k1Var) {
        int i = k1Var.h - 1;
        k1Var.h = i;
        return i;
    }

    private void r() {
        View a2 = com.baidu.navisdk.ui.util.b.a(com.baidu.navisdk.ui.routeguide.b.V().b(), R.layout.motor_layout_dest_reminder_dest_arrive_card);
        this.e = a2;
        if (a2 != null) {
            Button button = (Button) a2.findViewById(R.id.motor_dest_arrive_finish_navi_btn);
            this.f = button;
            button.setOnClickListener(this);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.k
    public RelativeLayout.LayoutParams d() {
        int dimensionPixelOffset = JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_toolbox_margin_left);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        if (!com.baidu.navisdk.ui.routeguide.control.x.b().s2()) {
            layoutParams.width = com.baidu.navisdk.ui.routeguide.control.f.k().b();
        }
        layoutParams.setMargins(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        return layoutParams;
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.k
    public View e() {
        return this.e;
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.k
    public void h() {
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g, com.baidu.navisdk.ui.routeguide.mapmode.subview.k
    public void j() {
        super.j();
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMotorArriveDestRemindCard - DestRemind", "onHide!");
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g, com.baidu.navisdk.ui.routeguide.mapmode.subview.k
    public void k() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMotorArriveDestRemindCard - DestRemind", "onShow! isBackgroundNavi = " + com.baidu.navisdk.ui.routeguide.b.V().z() + ", mRootView = " + this.e);
        }
        if (this.e == null) {
            com.baidu.navisdk.ui.routeguide.b.V().Q();
            return;
        }
        this.h = 10;
        super.k();
        a(this.h);
        com.baidu.navisdk.ui.routeguide.control.f.k().a(true);
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g
    public int l() {
        return 10000;
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g
    public void n() {
        super.n();
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMotorArriveDestRemindCard - DestRemind", "onAutoHideCard!");
        }
        com.baidu.navisdk.ui.routeguide.b.V().Q();
        com.baidu.navisdk.util.statistic.userop.b.r().a("3.p.2", null, null, "");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        p();
        if (view.getId() == R.id.motor_dest_arrive_finish_navi_btn) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGMotorArriveDestRemindCard - DestRemind", "DestRemind clickFinishNaviBtn ->");
            }
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.p.2", null, "1", null);
            com.baidu.navisdk.ui.routeguide.b.V().Q();
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g
    public void p() {
        super.p();
        com.baidu.navisdk.util.worker.loop.a aVar = this.c;
        if (aVar != null) {
            aVar.removeCallbacksAndMessages(null);
            this.c = null;
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g
    public boolean q() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        Context context;
        if (i <= 0) {
            p();
            n();
            return;
        }
        Button button = this.f;
        if (button == null || (context = this.g) == null) {
            return;
        }
        button.setText(context.getString(R.string.motor_dest_arrive_btn, Integer.valueOf(i)));
        com.baidu.navisdk.util.worker.loop.a aVar = this.c;
        if (aVar != null) {
            aVar.postDelayed(new a(), 1000L);
        }
    }
}
