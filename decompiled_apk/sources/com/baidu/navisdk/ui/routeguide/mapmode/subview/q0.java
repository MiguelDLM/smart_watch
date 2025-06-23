package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.model.datastruct.h;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes8.dex */
public class q0 extends com.baidu.navisdk.ui.routeguide.widget.d implements com.baidu.navisdk.ui.routeguide.mapmode.iview.e {
    private View i;
    private TextView j;
    private TextView k;
    private TextView l;
    private View.OnClickListener m;
    private a n;

    /* loaded from: classes8.dex */
    public interface a {
        void a(boolean z);
    }

    public q0(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
        o0();
    }

    private void n0() {
        View view = this.i;
        if (view != null && view.getVisibility() != 8) {
            super.c();
            this.i.setVisibility(8);
        }
    }

    private void o0() {
        this.i = ((ViewStub) this.b.findViewById(R.id.bnav_rg_weather_panel_stub)).inflate();
        this.j = (TextView) this.b.findViewById(R.id.bnav_rg_weather_panel_traffic);
        this.k = (TextView) this.b.findViewById(R.id.bnav_rg_weather_panel_dis);
        this.l = (TextView) this.b.findViewById(R.id.bnav_rg_weather_panel_dis_unit);
    }

    private boolean p0() {
        if (!com.baidu.navisdk.ui.routeguide.model.t.s().k()) {
            n0();
            return false;
        }
        com.baidu.navisdk.model.datastruct.h c = com.baidu.navisdk.ui.routeguide.model.t.s().c();
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGMMRouteWeatherView", "updatePanel: " + c);
        }
        if (c != null && c.f()) {
            if (this.j != null) {
                h.c cVar = c.e;
                if (cVar != null && (!TextUtils.isEmpty(cVar.d) || !TextUtils.isEmpty(c.e.e))) {
                    if (!TextUtils.isEmpty(c.e.d)) {
                        this.j.setText(c.e.d);
                    } else {
                        this.j.setText(c.e.e);
                    }
                    if (this.i.getVisibility() != 0) {
                        this.i.setVisibility(0);
                        com.baidu.navisdk.util.statistic.userop.b.r().a("3.u.e.5", null, null, null);
                    }
                    super.b(null);
                } else {
                    n0();
                    return false;
                }
            }
            TextView textView = this.k;
            if (textView != null) {
                textView.setText(c.c());
            }
            TextView textView2 = this.l;
            if (textView2 != null) {
                textView2.setText(c.d());
                return true;
            }
            return true;
        }
        n0();
        return false;
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d, com.baidu.navisdk.framework.interfaces.y
    public View[] B() {
        return new View[]{this.i};
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.iview.e
    public boolean G() {
        boolean a2 = a();
        boolean p0 = p0();
        a aVar = this.n;
        if (aVar != null && a2 != p0) {
            aVar.a(p0);
        }
        return p0;
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.iview.e
    public int N() {
        return JarUtils.getResources().getDimensionPixelSize(R.dimen.nsdk_rg_weather_panel_height) + JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_8dp);
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.iview.e
    public Rect X() {
        Rect rect = new Rect();
        View view = this.i;
        if (view != null) {
            view.getGlobalVisibleRect(rect);
        }
        return rect;
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.iview.e
    public void a(a aVar) {
        this.n = aVar;
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void c() {
        n0();
        a aVar = this.n;
        if (aVar != null) {
            aVar.a(false);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void i() {
        super.i();
        View view = this.i;
        if (view != null) {
            view.setOnClickListener(null);
            this.i = null;
        }
        this.l = null;
        this.k = null;
        this.j = null;
        this.m = null;
        a aVar = this.n;
        if (aVar != null) {
            aVar.a(false);
            this.n = null;
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public boolean y() {
        p0();
        a aVar = this.n;
        if (aVar != null) {
            aVar.a(a());
        }
        return a();
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.iview.e
    public void a(View.OnClickListener onClickListener) {
        this.m = onClickListener;
        View view = this.i;
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d, com.baidu.navisdk.module.newguide.interfaces.a
    public boolean a() {
        View view = this.i;
        return view != null && view.getVisibility() == 0;
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void a(boolean z) {
        super.a(z);
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void a(ViewGroup viewGroup, int i) {
        super.a(viewGroup, i);
        o0();
        View view = this.i;
        if (view != null) {
            view.setOnClickListener(this.m);
        }
        p0();
        a aVar = this.n;
        if (aVar != null) {
            aVar.a(a());
        }
    }
}
