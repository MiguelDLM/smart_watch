package com.baidu.navisdk.ui.routeguide.mapmode.subview.indoorpark;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.indoorpark.a;
import com.baidu.navisdk.util.jar.JarUtils;
import java.util.List;

/* loaded from: classes8.dex */
public class d extends com.baidu.navisdk.ui.routeguide.widget.d {
    private View i;
    private View j;
    private View k;
    private ImageView l;
    private ImageView m;
    private LinearLayout n;
    private RecyclerView o;
    private a p;
    private LinearLayoutManager q;

    public d(Context context, ViewGroup viewGroup, com.baidu.navisdk.ui.routeguide.control.indoorpark.a aVar) {
        super(context, viewGroup);
    }

    private View v(int i) {
        return this.i.findViewById(i);
    }

    public void a(a.c cVar) {
        this.p.a(cVar);
    }

    public void b(List<String> list) {
        this.p.a(list);
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void c() {
        super.c();
        View view = this.i;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void i() {
        super.i();
    }

    public void n0() {
        View inflate = JarUtils.inflate(this.f9165a, R.layout.nsdk_layout_indoor_park_filter_view, null);
        this.i = inflate;
        this.b.addView(inflate);
        this.j = v(R.id.floor_start_arrow_layout);
        this.k = v(R.id.floor_end_arrow_layout);
        this.l = (ImageView) v(R.id.floor_start_arrow);
        this.m = (ImageView) v(R.id.floor_end_arrow);
        this.n = (LinearLayout) v(R.id.floor_filter_brands);
        this.o = (RecyclerView) v(R.id.floor_filter_brands_recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.f9165a);
        this.q = linearLayoutManager;
        linearLayoutManager.setOrientation(1);
        this.o.setLayoutManager(this.q);
        a aVar = new a(this.f9165a);
        this.p = aVar;
        this.o.setAdapter(aVar);
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public boolean y() {
        super.y();
        if (this.i == null) {
            n0();
        }
        this.i.setVisibility(0);
        return true;
    }

    public void b(String str) {
        a aVar = this.p;
        if (aVar != null) {
            aVar.a(str);
        }
    }
}
