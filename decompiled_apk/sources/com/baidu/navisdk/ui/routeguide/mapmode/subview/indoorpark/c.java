package com.baidu.navisdk.ui.routeguide.mapmode.subview.indoorpark;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes8.dex */
public class c extends com.baidu.navisdk.ui.routeguide.widget.d implements View.OnClickListener {
    private View i;
    private View j;
    private TextView k;
    private ViewGroup l;
    private com.baidu.navisdk.ui.routeguide.control.indoorpark.a m;

    public c(Context context, ViewGroup viewGroup, com.baidu.navisdk.ui.routeguide.control.indoorpark.a aVar) {
        super(context, viewGroup);
        this.m = aVar;
    }

    private void p0() {
        View inflate = JarUtils.inflate(this.f9165a, R.layout.nsdk_layout_rg_indoor_park_bottombar, null);
        this.i = inflate;
        this.j = inflate.findViewById(R.id.bnav_indoor_bottombar_quit_ly);
        this.k = (TextView) this.i.findViewById(R.id.bnav_indoor_bottombar_main_text);
        this.l = (ViewGroup) this.i.findViewById(R.id.bnav_indoor_bottombar_stall_status_layout);
        this.b.addView(this.i);
        this.j.setOnClickListener(this);
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void c() {
        super.c();
        View view = this.i;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public void f(String str) {
        this.k.setText(str);
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void i() {
        super.i();
    }

    public void n0() {
        this.l.setVisibility(8);
        this.k.setVisibility(0);
    }

    public void o0() {
        this.k.setVisibility(8);
        this.l.setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.bnav_indoor_bottombar_quit_ly) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.v.a", "1", "2", null);
            if (com.baidu.navisdk.ui.routeguide.control.d.e.a()) {
                return;
            }
            this.m.a(!com.baidu.navisdk.ui.routeguide.control.indoorpark.c.F().j());
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public boolean y() {
        super.y();
        if (this.i == null) {
            p0();
        }
        this.i.setVisibility(0);
        return true;
    }
}
