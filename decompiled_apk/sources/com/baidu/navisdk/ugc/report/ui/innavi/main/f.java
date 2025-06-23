package com.baidu.navisdk.ugc.report.ui.innavi.main;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ugc.replenishdetails.UgcReplenishDetailsTipsLayout;
import com.baidu.navisdk.ugc.report.ui.innavi.main.a;
import com.baidu.navisdk.ugc.utils.k;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.z;
import com.baidu.navisdk.util.jar.JarUtils;
import com.google.android.exoplayer2.ui.DefaultTimeBar;

/* loaded from: classes8.dex */
public class f implements d, View.OnClickListener, UgcReplenishDetailsTipsLayout.d, UgcReplenishDetailsTipsLayout.c {

    /* renamed from: a, reason: collision with root package name */
    private Activity f8291a;
    private int c;
    private ViewGroup f;
    private com.baidu.navisdk.ugc.report.ui.innavi.main.a h;
    private UgcReplenishDetailsTipsLayout i;
    private com.baidu.navisdk.ugc.replenishdetails.b j;
    private com.baidu.navisdk.ugc.report.ui.innavi.verifyevent.a k;
    private com.baidu.navisdk.ugc.report.ui.innavi.main.b l;
    private View n;
    private com.baidu.navisdk.ugc.report.ui.innavi.main.c b = null;
    private View d = null;
    private View e = null;
    private RecyclerView g = null;
    private boolean m = false;

    /* loaded from: classes8.dex */
    public class a implements View.OnTouchListener {
        public a(f fVar) {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (f.this.b != null) {
                f.this.b.a(true);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements a.d {
        public c() {
        }

        @Override // com.baidu.navisdk.ugc.report.ui.innavi.main.a.d
        public void a(UgcReplenishDetailsTipsLayout ugcReplenishDetailsTipsLayout) {
            f.this.a(ugcReplenishDetailsTipsLayout);
        }
    }

    public f(Activity activity, int i, ViewGroup viewGroup) {
        this.f8291a = activity;
        this.c = i;
        this.f = viewGroup;
    }

    private int h() {
        com.baidu.navisdk.ugc.report.ui.innavi.main.c cVar = this.b;
        if (cVar != null) {
            return cVar.a();
        }
        return 0;
    }

    private boolean i() {
        if (!z.a(com.baidu.navisdk.framework.a.c().a())) {
            TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), JarUtils.getResources().getString(R.string.nsdk_string_ugc_report_fail_badwet));
            return false;
        }
        return true;
    }

    @Override // com.baidu.navisdk.ugc.report.ui.innavi.main.d
    public Activity b() {
        return this.f8291a;
    }

    @Override // com.baidu.navisdk.ugc.report.ui.innavi.main.d
    public int c() {
        return this.c;
    }

    @Override // com.baidu.navisdk.ugc.report.ui.innavi.main.d
    public ViewGroup d() {
        ViewGroup viewGroup = this.f;
        if (viewGroup != null) {
            return viewGroup;
        }
        View view = this.d;
        if (view != null && view.getParent() != null) {
            return (ViewGroup) this.d.getParent();
        }
        return null;
    }

    @Override // com.baidu.navisdk.ugc.report.ui.innavi.main.d
    public void e() {
        UgcReplenishDetailsTipsLayout ugcReplenishDetailsTipsLayout = this.i;
        if (ugcReplenishDetailsTipsLayout != null) {
            ugcReplenishDetailsTipsLayout.b();
        }
    }

    @Override // com.baidu.navisdk.ugc.report.ui.innavi.main.d
    public void f() {
        com.baidu.navisdk.ugc.report.ui.innavi.main.a aVar = this.h;
        if (aVar != null) {
            aVar.a(this.b.k());
            this.h.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.navisdk.ugc.report.b
    public void g() {
        com.baidu.navisdk.ugc.report.ui.innavi.main.c cVar = this.b;
        if (cVar != null && this.g != null) {
            if (this.h == null) {
                this.h = new com.baidu.navisdk.ugc.report.ui.innavi.main.a(cVar, this.f8291a, this.c);
            }
            this.h.a(new c());
            this.g.setLayoutManager(new GridLayoutManager(this.f8291a, 3));
            this.g.setAdapter(this.h);
            if (this.j.f() || this.j.g()) {
                this.h.a(true);
                this.h.notifyDataSetChanged();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.b != null && view.getId() == R.id.ugc_map_navi_mayi_btn) {
            this.b.a(false, this.f);
        }
    }

    public void onDestroy() {
        this.f8291a = null;
        this.b = null;
        this.f = null;
        com.baidu.navisdk.ugc.report.ui.innavi.verifyevent.a aVar = this.k;
        if (aVar != null) {
            aVar.a();
            this.k = null;
        }
        com.baidu.navisdk.ugc.report.ui.innavi.main.b bVar = this.l;
        if (bVar != null) {
            bVar.a();
        }
        UgcReplenishDetailsTipsLayout ugcReplenishDetailsTipsLayout = this.i;
        if (ugcReplenishDetailsTipsLayout != null) {
            ugcReplenishDetailsTipsLayout.a();
        }
        this.m = false;
    }

    @Override // com.baidu.navisdk.ugc.report.ui.innavi.main.d
    public void updateView(int i) {
    }

    @Override // com.baidu.navisdk.ugc.report.ui.innavi.main.d
    public void c(int i) {
        if (this.l == null || this.b.j() != 1) {
            return;
        }
        this.l.a(i);
    }

    @Override // com.baidu.navisdk.ugc.report.ui.innavi.main.d
    public void a(int i, boolean z) {
        this.m = z;
        a(this.f8291a, this.c, i);
        View view = this.e;
        if (view != null && z) {
            view.setOnClickListener(this);
            k.a(this.e, DefaultTimeBar.DEFAULT_UNPLAYED_COLOR);
        }
        View view2 = this.d;
        if (view2 != null) {
            view2.setOnTouchListener(new a(this));
        }
        View view3 = this.n;
        if (view3 != null) {
            view3.setOnClickListener(new b());
        }
    }

    @Override // com.baidu.navisdk.ugc.report.ui.innavi.main.d
    public void a(com.baidu.navisdk.ugc.replenishdetails.b bVar) {
        this.j = bVar;
    }

    private void a(Context context, int i, int i2) {
        ViewGroup viewGroup;
        int i3;
        if (context == null || (viewGroup = this.f) == null) {
            return;
        }
        viewGroup.removeAllViews();
        if (i != 1) {
            i3 = R.layout.nsdk_layout_ugc_report_navi_main_view_land;
        } else if (i2 == 2) {
            i3 = R.layout.nsdk_layout_ugc_report_navi_main_view;
        } else {
            i3 = R.layout.nsdk_layout_ugc_report_navi_portrait_main_view;
        }
        JarUtils.inflate(context, i3, this.f);
        View findViewById = this.f.findViewById(R.id.ugc_map_navi_content);
        this.d = findViewById;
        if (findViewById == null) {
            return;
        }
        this.g = (RecyclerView) this.f.findViewById(R.id.ugc_map_navi_allitems_recycler);
        this.n = this.f.findViewById(R.id.ugc_report_navi_close);
        if (this.m) {
            this.e = (TextView) this.f.findViewById(R.id.ugc_map_navi_mayi_btn);
            View findViewById2 = this.f.findViewById(R.id.ugc_map_navi_mayi_layout);
            if (findViewById2 != null) {
                findViewById2.setVisibility(0);
            }
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.d.getLayoutParams();
        if (marginLayoutParams != null) {
            int dimensionPixelOffset = JarUtils.getResources().getDimensionPixelOffset(R.dimen.ugc_rg_toolbox_margin_left);
            if (i == 1) {
                marginLayoutParams.setMargins(dimensionPixelOffset, h(), dimensionPixelOffset, 0);
            } else {
                marginLayoutParams.setMargins(0, h(), dimensionPixelOffset, 0);
            }
            this.d.setLayoutParams(marginLayoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UgcReplenishDetailsTipsLayout ugcReplenishDetailsTipsLayout) {
        com.baidu.navisdk.ugc.replenishdetails.b bVar = this.j;
        if (bVar == null || this.b == null) {
            return;
        }
        if (bVar.f()) {
            ugcReplenishDetailsTipsLayout.a(this.j.b(), this.j.e(), this.j.h(), this.j.d(), this.j.c(), this, this.b.r());
        } else if (this.j.g()) {
            ugcReplenishDetailsTipsLayout.a(this.j.b(), this.j.a(), this.j.h(), this.j.c(), this, this.b.r());
        } else {
            ugcReplenishDetailsTipsLayout.setVisibility(8);
        }
    }

    @Override // com.baidu.navisdk.ugc.report.b
    public void a(com.baidu.navisdk.ugc.report.ui.innavi.main.c cVar) {
        this.b = cVar;
    }

    @Override // com.baidu.navisdk.ugc.report.ui.innavi.main.d
    public Context a() {
        return this.f8291a;
    }

    @Override // com.baidu.navisdk.ugc.report.ui.innavi.main.d
    public void a(int i) {
        if (this.f == null || this.f8291a == null || this.b == null) {
            return;
        }
        com.baidu.navisdk.ugc.report.ui.innavi.main.b bVar = this.l;
        if (bVar != null) {
            bVar.a();
        }
        com.baidu.navisdk.ugc.report.ui.innavi.main.b bVar2 = new com.baidu.navisdk.ugc.report.ui.innavi.main.b(this.b);
        this.l = bVar2;
        View a2 = bVar2.a(this.f8291a, i);
        ViewGroup viewGroup = this.f;
        if (viewGroup == null || a2 == null) {
            return;
        }
        viewGroup.removeAllViews();
        this.f.addView(a2, new ViewGroup.LayoutParams(-1, -1));
    }

    @Override // com.baidu.navisdk.ugc.report.ui.innavi.main.d
    public boolean a(com.baidu.navisdk.ugc.report.ui.innavi.verifyevent.b bVar) {
        if (this.f == null || this.f8291a == null || this.b == null || bVar == null) {
            return false;
        }
        com.baidu.navisdk.ugc.report.ui.innavi.verifyevent.a aVar = this.k;
        if (aVar != null) {
            aVar.a();
        }
        com.baidu.navisdk.ugc.report.ui.innavi.verifyevent.a aVar2 = new com.baidu.navisdk.ugc.report.ui.innavi.verifyevent.a(this.b, bVar);
        this.k = aVar2;
        com.baidu.navisdk.ugc.report.ui.innavi.main.c cVar = this.b;
        if (cVar != null) {
            aVar2.a(cVar.r());
        }
        View a2 = this.k.a(this.f8291a);
        if (a2 == null) {
            return false;
        }
        this.f.removeAllViews();
        this.f.addView(a2, new ViewGroup.LayoutParams(-1, -1));
        return true;
    }

    @Override // com.baidu.navisdk.ugc.replenishdetails.UgcReplenishDetailsTipsLayout.d
    public void a(String str, com.baidu.navisdk.ugc.report.data.datastatus.a aVar) {
        com.baidu.navisdk.ugc.report.ui.innavi.main.c cVar;
        if (i() && (cVar = this.b) != null) {
            cVar.a(str, aVar);
        }
    }

    @Override // com.baidu.navisdk.ugc.replenishdetails.UgcReplenishDetailsTipsLayout.c
    public void a(String str, int i, String str2) {
        com.baidu.navisdk.ugc.report.ui.innavi.main.c cVar = this.b;
        if (cVar != null) {
            cVar.a(str, i, str2, false, 4);
        }
    }

    @Override // com.baidu.navisdk.ugc.replenishdetails.UgcReplenishDetailsTipsLayout.c
    public void a(String str, int i) {
        com.baidu.navisdk.ugc.report.ui.innavi.main.c cVar;
        if (i() && (cVar = this.b) != null) {
            cVar.a(str, i, 0);
        }
    }
}
