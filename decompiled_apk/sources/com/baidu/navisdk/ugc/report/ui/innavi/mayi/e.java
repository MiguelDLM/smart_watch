package com.baidu.navisdk.ugc.report.ui.innavi.mayi;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ugc.report.ui.innavi.mayi.a;
import com.baidu.navisdk.util.jar.JarUtils;
import java.util.ArrayList;

/* loaded from: classes8.dex */
public class e implements c {

    /* renamed from: a, reason: collision with root package name */
    private Context f8300a;
    private int b;
    private ArrayList<com.baidu.navisdk.ugc.report.data.datarepository.b> c;
    private com.baidu.navisdk.ugc.report.ui.innavi.mayi.b d = null;
    private View e;
    private View f;
    private RecyclerView g;
    private a.b h;
    private com.baidu.navisdk.ugc.report.ui.innavi.mayi.a i;

    /* loaded from: classes8.dex */
    public class a implements a.b {
        public a() {
        }

        @Override // com.baidu.navisdk.ugc.report.ui.innavi.mayi.a.b
        public void onItemClick(int i) {
            if (e.this.d != null) {
                e.this.d.a(i);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnTouchListener {
        public b(e eVar) {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    public e(Context context, int i) {
        this.f8300a = context;
        this.b = i;
        j();
        i();
    }

    private void i() {
        this.h = new a();
        View view = this.f;
        if (view != null && this.g != null) {
            view.setOnTouchListener(new b(this));
        }
    }

    private void j() {
        if (this.b == 1) {
            this.e = JarUtils.inflate(this.f8300a, R.layout.nsdk_layout_ugc_report_navi_mayi_main_view, null);
        } else {
            this.e = JarUtils.inflate(this.f8300a, R.layout.nsdk_layout_ugc_report_navi_mayi_main_view_land, null);
        }
        View view = this.e;
        if (view == null) {
            return;
        }
        this.f = view.findViewById(R.id.ugc_map_navi_content);
        this.g = (RecyclerView) this.e.findViewById(R.id.ugc_report_navi_mayi_recyclerview);
        this.g.setLayoutManager(new GridLayoutManager(this.f8300a, 3));
    }

    @Override // com.baidu.navisdk.ugc.report.ui.innavi.mayi.c
    public void b(int i) {
    }

    @Override // com.baidu.navisdk.ugc.report.ui.innavi.mayi.c
    public int c() {
        return this.b;
    }

    @Override // com.baidu.navisdk.ugc.report.ui.innavi.mayi.c
    public ViewGroup d() {
        View view = this.e;
        if (view != null && view.getParent() != null) {
            return (ViewGroup) this.e.getParent();
        }
        return null;
    }

    @Override // com.baidu.navisdk.ugc.report.b
    public void g() {
        com.baidu.navisdk.ugc.report.ui.innavi.mayi.b bVar = this.d;
        if (bVar == null) {
            return;
        }
        ArrayList<com.baidu.navisdk.ugc.report.data.datarepository.b> v = bVar.v();
        this.c = v;
        if (this.i == null) {
            com.baidu.navisdk.ugc.report.ui.innavi.mayi.a aVar = new com.baidu.navisdk.ugc.report.ui.innavi.mayi.a(this.f8300a, this.b, v, this.h);
            this.i = aVar;
            RecyclerView recyclerView = this.g;
            if (recyclerView != null) {
                recyclerView.setAdapter(aVar);
            }
        }
    }

    public View h() {
        return this.e;
    }

    @Override // com.baidu.navisdk.ugc.report.ui.innavi.mayi.c
    public Context a() {
        return this.f8300a;
    }

    @Override // com.baidu.navisdk.ugc.report.b
    public void a(com.baidu.navisdk.ugc.report.ui.innavi.mayi.b bVar) {
        this.d = bVar;
    }
}
