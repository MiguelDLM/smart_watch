package com.baidu.navisdk.ui.routeguide.mapmode.subview.destrecommend;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.module.pronavi.model.h;
import com.baidu.navisdk.ui.routeguide.control.q;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.destrecommend.c;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.k;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.ui.widget.BNCommonProgressDialog;
import com.baidu.navisdk.util.common.ScreenUtil;
import java.util.List;

/* loaded from: classes8.dex */
public class b extends k implements f {
    com.baidu.navisdk.ui.routeguide.mapmode.subview.destrecommend.e c;
    private ViewGroup d;
    private final Context e;
    private GridView f;
    private com.baidu.navisdk.ui.routeguide.mapmode.subview.destrecommend.a g;
    private TextView h;
    private View i;
    private TextView j;
    private BNCommonProgressDialog k;
    private final com.baidu.navisdk.util.worker.lite.b l = new a("drc_l");

    /* loaded from: classes8.dex */
    public class a extends com.baidu.navisdk.util.worker.lite.b {
        public a(String str) {
            super(str);
        }

        @Override // com.baidu.navisdk.util.worker.lite.b, java.lang.Runnable
        public void run() {
            b.this.m();
        }
    }

    /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.subview.destrecommend.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class ViewOnClickListenerC0455b implements View.OnClickListener {
        public ViewOnClickListenerC0455b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.navisdk.ui.routeguide.mapmode.subview.destrecommend.e eVar = b.this.c;
            if (eVar != null) {
                eVar.c();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c extends com.baidu.navisdk.util.worker.lite.b {
        public c(String str) {
            super(str);
        }

        @Override // com.baidu.navisdk.util.worker.lite.b, java.lang.Runnable
        public void run() {
            int dip2px = ScreenUtil.getInstance().dip2px(20);
            if (1 == h.f7469a) {
                com.baidu.navisdk.pronavi.util.a aVar = com.baidu.navisdk.pronavi.util.a.h;
                int e = aVar.e() - dip2px;
                BNMapController.getInstance().setMapShowScreenRect(dip2px, ScreenUtil.getInstance().getStatusBarHeightFullScreen(b.this.e) + dip2px, e, (aVar.d() - b.this.d.getHeight()) - dip2px);
            } else {
                BNMapController.getInstance().setMapShowScreenRect(dip2px, dip2px, x.b().V() - dip2px, com.baidu.navisdk.ui.routeguide.utils.a.f9151a.a() - dip2px);
            }
            BNMapController.getInstance().resetRouteDetailIndex(false);
        }
    }

    /* loaded from: classes8.dex */
    public class d implements AdapterView.OnItemClickListener {
        public d() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            b.this.g.a(i);
            b.this.g.notifyDataSetChanged();
            b.this.c.a(i);
            b.this.c.a();
        }
    }

    /* loaded from: classes8.dex */
    public class e implements DialogInterface.OnCancelListener {
        public e() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            b.this.c.d();
        }
    }

    public b(Context context, com.baidu.navisdk.ui.routeguide.mapmode.subview.destrecommend.c cVar) {
        this.f8808a = 1008;
        this.e = context;
        l();
        a(com.baidu.navisdk.ui.util.b.b());
        com.baidu.navisdk.ui.routeguide.mapmode.subview.destrecommend.d dVar = new com.baidu.navisdk.ui.routeguide.mapmode.subview.destrecommend.d(this, cVar);
        this.c = dVar;
        dVar.b();
    }

    private void l() {
        if (this.d == null) {
            this.d = (ViewGroup) LayoutInflater.from(this.e).inflate(R.layout.nsdk_layout_dest_recommend_card, (ViewGroup) null);
        }
        this.f = (GridView) this.d.findViewById(R.id.grid_view);
        TextView textView = (TextView) this.d.findViewById(R.id.card_title);
        this.h = textView;
        textView.getPaint().setFakeBoldText(true);
        TextView textView2 = (TextView) this.d.findViewById(R.id.finish_navi);
        this.j = textView2;
        textView2.getPaint().setFakeBoldText(true);
        this.j.setOnClickListener(new ViewOnClickListenerC0455b());
        this.i = this.d.findViewById(R.id.divide_line);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        if (this.k == null) {
            Activity b = com.baidu.navisdk.ui.routeguide.b.V().b();
            if (b != null && !b.isFinishing()) {
                BNCommonProgressDialog bNCommonProgressDialog = new BNCommonProgressDialog(b);
                this.k = bNCommonProgressDialog;
                bNCommonProgressDialog.setMessage("路线规划中...");
                this.k.setOnCancelListener(new e());
            } else {
                return;
            }
        }
        this.k.show();
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.k
    public View e() {
        return this.d;
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.k
    public void h() {
        this.c.onDestroy();
        this.k = null;
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.k
    public void j() {
        q.c().b();
        this.c.onDestroy();
        this.k = null;
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.k
    public void k() {
        com.baidu.navisdk.util.worker.lite.a.c(new c("drc_s"));
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.destrecommend.f
    public void a(String str) {
        this.h.setText(str);
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.destrecommend.f
    public void b() {
        com.baidu.navisdk.util.worker.lite.a.a(this.l);
        BNCommonProgressDialog bNCommonProgressDialog = this.k;
        if (bNCommonProgressDialog != null) {
            bNCommonProgressDialog.dismiss();
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.k
    public RelativeLayout.LayoutParams d() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        if (x.b().s2()) {
            layoutParams.setMargins(0, 0, 0, 0);
        } else {
            layoutParams.setMargins(x.b().V(), 0, 0, 0);
        }
        layoutParams.addRule(12);
        return layoutParams;
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.destrecommend.f
    public void a(List<c.b> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        this.f.setVisibility(0);
        if (list.size() == 1) {
            this.f.setNumColumns(1);
        }
        com.baidu.navisdk.ui.routeguide.mapmode.subview.destrecommend.a aVar = new com.baidu.navisdk.ui.routeguide.mapmode.subview.destrecommend.a(this.e, list);
        this.g = aVar;
        aVar.a(com.baidu.navisdk.ui.util.b.b());
        int dimension = (int) this.e.getResources().getDimension(R.dimen.navi_dimens_10dp);
        this.f.setHorizontalSpacing(dimension);
        this.f.setVerticalSpacing(dimension);
        this.f.setAdapter((ListAdapter) this.g);
        this.f.setVisibility(0);
        this.f.setOnItemClickListener(new d());
        this.i.setVisibility(0);
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.destrecommend.f
    public void b(String str) {
        TipTool.toast(str);
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.destrecommend.f
    public synchronized void a() {
        if (!com.baidu.navisdk.ui.routeguide.b.V().B()) {
            com.baidu.navisdk.util.worker.lite.a.a(this.l, 300L);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.k
    public void a(boolean z) {
        if (z) {
            this.h.setTextColor(Color.parseColor("#222222"));
            this.j.setTextColor(Color.parseColor("#222222"));
            this.i.setBackgroundColor(Color.parseColor("#E3E3E3"));
        } else {
            this.h.setTextColor(Color.parseColor("#FFFFFF"));
            this.j.setTextColor(Color.parseColor("#FFFFFF"));
            this.i.setBackgroundColor(Color.parseColor("#2B323D"));
        }
        this.d.setBackground(com.baidu.navisdk.ui.util.b.c(R.drawable.nsdk_dest_recommend_card_bg, z));
        this.j.setBackground(com.baidu.navisdk.ui.util.b.c(R.drawable.nsdk_dest_recommend_finish_button_bg, z));
        com.baidu.navisdk.ui.routeguide.mapmode.subview.destrecommend.a aVar = this.g;
        if (aVar != null) {
            aVar.a(z);
            this.g.notifyDataSetChanged();
        }
    }
}
