package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.z;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes8.dex */
public class a0 extends com.baidu.navisdk.ui.routeguide.widget.c {
    private TextView m;
    private TextView n;
    private TextView o;
    private z p;
    private View q;
    private TextView r;
    private TextView s;
    private View t;
    private View u;
    private View v;
    private View w;
    private View x;
    private int y;
    private int z;

    public a0(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
        this.y = JarUtils.getResources().getColor(R.color.nsdk_interval_speed_progress_bar);
        this.z = JarUtils.getResources().getColor(R.color.nsdk_cl_text_g);
    }

    private void A0() {
        View view = this.q;
        if (view != null) {
            view.setBackground(com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_rg_interval_speed_normal_bg));
        } else {
            LogUtil.e("RGMMIntervalCameraView", "resetViews --> view == null!");
        }
    }

    private void B0() {
        com.baidu.navisdk.module.pronavi.model.g.o().f().a(true);
        TextView textView = this.r;
        if (textView != null) {
            textView.setTextColor(this.y);
            this.s.setTextColor(this.y);
        }
        View view = this.q;
        if (view != null) {
            view.setBackground(com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_rg_interval_speed_over_bg));
        }
    }

    private void e(Bundle bundle) {
        int i = bundle.getInt("KEY_INTERVAL_CAMERA_SPEED_LIMIT", 0);
        int i2 = bundle.getInt("KEY_INTERVAL_CAMERA_REMAIN_DIST", -1);
        com.baidu.navisdk.module.pronavi.model.g.o().f().c(i);
        w(i);
        x(100);
        com.baidu.navisdk.module.pronavi.model.g.o().f().a(bundle.getInt("KEY_INTERVAL_CAMERA_LENGTH", -1));
        d(i, com.baidu.navisdk.module.pronavi.model.g.o().c());
        y(i2);
    }

    private void f(Bundle bundle) {
        int i;
        int i2 = bundle.getInt("KEY_INTERVAL_CAMERA_REMAIN_DIST", -1);
        if (i2 != -1) {
            int b = com.baidu.navisdk.module.pronavi.model.g.o().f().b();
            if (b <= 0) {
                i = 100;
            } else {
                i = (i2 * 100) / b;
            }
            x(i);
            d(com.baidu.navisdk.module.pronavi.model.g.o().f().e(), bundle.getInt("KEY_INTERVAL_CAMERA_REMAIN_AVERAGE_SPEED", 0));
            y(i2);
        }
        w(com.baidu.navisdk.module.pronavi.model.g.o().f().e());
    }

    private void w(int i) {
        TextView textView = this.n;
        if (textView != null) {
            textView.setText(i + "");
        }
    }

    private void x(int i) {
        com.baidu.navisdk.module.pronavi.model.g.o().f().b(i);
    }

    private void y(int i) {
        TextView textView = this.m;
        if (textView != null) {
            textView.setText(com.baidu.navisdk.util.common.t.a(i));
            if (i > 999) {
                this.o.setText("剩余/公里");
            } else {
                this.o.setText("剩余/米");
            }
        }
    }

    private void y0() {
        com.baidu.navisdk.module.pronavi.model.g.o().f().a(false);
        TextView textView = this.r;
        if (textView != null) {
            textView.setTextColor(this.z);
            this.s.setTextColor(this.z);
        }
        View view = this.q;
        if (view != null) {
            view.setBackground(com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_rg_interval_speed_normal_bg));
        }
    }

    private void z0() {
        com.baidu.navisdk.module.pronavi.model.g.o().f().a();
    }

    public void a(z.i iVar) {
        z zVar = this.p;
        if (zVar != null) {
            zVar.a(iVar);
            this.p.b();
            this.p.c(this.f);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.c, com.baidu.navisdk.ui.routeguide.widget.d
    public boolean b(Bundle bundle) {
        super.b(bundle);
        if (LogUtil.LOGGABLE) {
            if (this.k == null) {
                LogUtil.e("RGMMIntervalCameraView", "show->mRootView = null");
            } else {
                LogUtil.e("RGMMIntervalCameraView", "show->mRootView.getVisibility:" + this.k.getVisibility() + ", mRootView.isShown:" + this.k.isShown());
            }
        }
        A0();
        z zVar = this.p;
        if (zVar != null) {
            zVar.a((z.i) null);
            this.p.b();
            this.p.b(this.f);
        }
        com.baidu.navisdk.util.statistic.userop.b.r().d("3.19.1", "0");
        return true;
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.c, com.baidu.navisdk.ui.routeguide.widget.d
    public void c() {
        super.c();
        com.baidu.navisdk.util.statistic.userop.b.r().d("3.19.1", "1");
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void d(Bundle bundle) {
        super.d(bundle);
        if (bundle == null) {
            LogUtil.e("RGMMIntervalCameraView", "RGMMIntervalCameraView, updateData b == null!, return.");
            return;
        }
        LogUtil.e("RGMMIntervalCameraView", bundle.toString());
        com.baidu.navisdk.module.pronavi.model.g.o().f().a(bundle);
        int i = bundle.getInt("KEY_TYPE", 0);
        if (i == 4383) {
            e(bundle);
        } else if (i == 4384) {
            f(bundle);
        } else if (i == 4385) {
            z0();
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.c, com.baidu.navisdk.ui.routeguide.widget.d
    public void i() {
        super.i();
        z zVar = this.p;
        if (zVar != null) {
            zVar.a();
            this.p = null;
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.c
    public ViewGroup.LayoutParams o0() {
        return null;
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.c
    public int p0() {
        return R.id.bnav_rg_interval_speed_container;
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.c
    public int q0() {
        return R.layout.bnav_interval_camera_layout_land;
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.c
    public int r0() {
        return R.layout.bnav_interval_camera_layout;
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.c
    public String s0() {
        return "RGMMIntervalCameraView";
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.c
    public void t0() {
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.c
    public void w0() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGMMIntervalCameraView", "initViewById,mRootView:" + this.k);
        }
        View view = this.k;
        if (view == null) {
            LogUtil.e("RGMMIntervalCameraView", "initViewById, mRootView == null");
            return;
        }
        this.w = view.findViewById(R.id.container_bg);
        this.t = this.k.findViewById(R.id.bnav_remain_dis_container);
        this.v = this.k.findViewById(R.id.bnav_speed_limit_container);
        this.m = (TextView) this.k.findViewById(R.id.bnav_remain_dis_tv);
        this.o = (TextView) this.k.findViewById(R.id.bnav_remain_dis_desc);
        this.n = (TextView) this.k.findViewById(R.id.bnav_interval_standard_speed_tv);
        this.x = this.k.findViewById(R.id.bnav_interval_divider);
        this.u = this.k.findViewById(R.id.bnav_ivel_container);
        this.q = this.k.findViewById(R.id.bnav_interval_ave_speed_bg);
        this.r = (TextView) this.k.findViewById(R.id.bnav_interval_ave_speed_value);
        this.s = (TextView) this.k.findViewById(R.id.bnav_interval_ave_speed_tag);
        z zVar = new z();
        this.p = zVar;
        zVar.a(this.f9165a, this.w, this.v, this.u, this.t, this.k, this.x);
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.c
    public void x0() {
        com.baidu.navisdk.ui.routeguide.model.p f = com.baidu.navisdk.module.pronavi.model.g.o().f();
        if (f != null) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("RGMMIntervalCameraView", "updateDataByLast, intervalCameraModel: " + f.toString());
            }
            w(f.e());
            x(f.d());
            d(f.c());
        }
    }

    private void d(int i, int i2) {
        if (this.r != null) {
            if (i2 <= 0) {
                i2 = com.baidu.navisdk.module.pronavi.model.g.o().c();
            }
            this.r.setText(i2 + "");
        }
        if (this.q == null || this.r == null || this.s == null) {
            return;
        }
        if (i2 > i) {
            B0();
        } else {
            y0();
        }
    }
}
