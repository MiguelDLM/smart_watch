package com.baidu.navisdk.pronavi.ui.bucket.item.concrete.intervalspeed;

import OXOo.OOXIXo;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.module.pronavi.model.g;
import com.baidu.navisdk.pronavi.style.d;
import com.baidu.navisdk.pronavi.style.f;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.z;
import com.baidu.navisdk.ui.routeguide.model.p;
import com.baidu.navisdk.ui.speed.interval.RGMMIntervalSpeedBgView;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.t;
import com.baidu.navisdk.util.jar.JarUtils;
import java.util.HashMap;

/* loaded from: classes7.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private View f7872a;
    private Context b;
    private int c;
    private TextView d;
    private TextView e;
    private TextView f;
    private TextView g;
    private z h;
    private View i;
    private TextView j;
    private TextView k;
    private View l;
    private View m;
    private View n;
    private RGMMIntervalSpeedBgView o;
    private View p;
    private com.baidu.navisdk.pronavi.style.i.a q;
    private int r;
    private int s;
    private int t;
    private int u;

    /* renamed from: com.baidu.navisdk.pronavi.ui.bucket.item.concrete.intervalspeed.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0340a extends com.baidu.navisdk.pronavi.style.c {
        public C0340a(Integer... numArr) {
            super(numArr);
        }

        @Override // com.baidu.navisdk.pronavi.style.i.a
        @OOXIXo
        public String a() {
            return "IntervalSpeed";
        }

        @Override // com.baidu.navisdk.pronavi.style.i.a
        public void b(String str) {
            a.this.j();
        }

        @Override // com.baidu.navisdk.pronavi.style.i.a
        public void c() {
        }

        @Override // com.baidu.navisdk.pronavi.style.c
        public boolean e() {
            return false;
        }

        @Override // com.baidu.navisdk.pronavi.style.c
        public boolean h(String str, @OOXIXo HashMap<String, ? super com.baidu.navisdk.pronavi.style.d> hashMap) {
            if (hashMap == null) {
                return false;
            }
            d.i g = g("text_color", hashMap);
            if (g != null) {
                int color = JarUtils.getResources().getColor(g.a());
                a.this.r = color;
                a.this.t = color;
                if (a.this.d != null && a.this.e != null && a.this.f != null && a.this.g != null) {
                    a.this.d.setTextColor(color);
                    a.this.e.setTextColor(color);
                    a.this.f.setTextColor(color);
                    a.this.g.setTextColor(color);
                }
            }
            if (a.this.p != null) {
                a.this.p.setBackgroundColor(JarUtils.getResources().getColor(d("line_color", hashMap)));
            }
            if (a.this.o != null) {
                d.C0334d b = b("portrait_bg", hashMap);
                d.C0334d b2 = b("land_bg", hashMap);
                if (b != null && b2 != null) {
                    a.this.o.b(b.a(), b2.a());
                }
            }
            a.this.s = e("over_speed_bg", hashMap);
            a.this.u = e("average_speed_bg", hashMap);
            a.this.m();
            return true;
        }
    }

    public a(Context context, View view, int i) {
        this.b = context;
        this.f7872a = view;
        this.c = i;
        g();
        h();
    }

    private void i() {
        if (this.q == null) {
            C0340a c0340a = new C0340a(new Integer[0]);
            this.q = c0340a;
            f.b.a("IntervalSpeed", c0340a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        g();
        int color = JarUtils.getResources().getColor(R.color.nsdk_interval_speed_default_text_color);
        this.d.setTextColor(color);
        this.e.setTextColor(color);
        this.f.setTextColor(color);
        this.g.setTextColor(color);
        RGMMIntervalSpeedBgView rGMMIntervalSpeedBgView = this.o;
        if (rGMMIntervalSpeedBgView != null) {
            rGMMIntervalSpeedBgView.a();
        }
        View view = this.p;
        if (view != null) {
            view.setBackgroundColor(Color.parseColor("#dddddd"));
        }
        m();
    }

    private void k() {
        View view = this.i;
        if (view != null) {
            view.setBackgroundResource(R.drawable.nsdk_rg_interval_speed_normal_bg);
        }
    }

    private void l() {
        g.o().f().a(true);
        TextView textView = this.j;
        if (textView != null) {
            textView.setTextColor(this.r);
            this.k.setTextColor(this.r);
        }
        View view = this.i;
        if (view != null) {
            view.setBackground(com.baidu.navisdk.ui.util.b.f(this.s));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        p f = g.o().f();
        if (f != null) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("IntervalSpeedHolder", "updateLastIntervalData, intervalCameraModel: " + f);
            }
            a(f.c());
        }
    }

    private void e() {
        g.o().f().a(false);
        TextView textView = this.j;
        if (textView != null) {
            textView.setTextColor(this.t);
            this.k.setTextColor(this.t);
        }
        View view = this.i;
        if (view != null) {
            view.setBackground(com.baidu.navisdk.ui.util.b.f(this.u));
        }
    }

    private void f() {
        g.o().f().a();
    }

    private void g() {
        this.u = R.drawable.nsdk_rg_interval_speed_normal_bg;
        this.t = JarUtils.getResources().getColor(R.color.nsdk_cl_text_g);
        this.s = R.drawable.nsdk_rg_interval_speed_over_bg;
        this.r = JarUtils.getResources().getColor(R.color.nsdk_interval_speed_progress_bar);
    }

    private void h() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("IntervalSpeedHolder", "initViewById,mRootView:" + this.f7872a);
        }
        View view = this.f7872a;
        if (view == null) {
            LogUtil.e("IntervalSpeedHolder", "initViewById, mRootView == null");
            return;
        }
        this.o = (RGMMIntervalSpeedBgView) view.findViewById(R.id.container_bg);
        this.l = this.f7872a.findViewById(R.id.bnav_remain_dis_container);
        this.n = this.f7872a.findViewById(R.id.bnav_speed_limit_container);
        this.d = (TextView) this.f7872a.findViewById(R.id.bnav_remain_dis_tv);
        this.e = (TextView) this.f7872a.findViewById(R.id.bnav_remain_dis_desc);
        this.f = (TextView) this.f7872a.findViewById(R.id.bnav_interval_standard_speed_tv);
        this.g = (TextView) this.f7872a.findViewById(R.id.bnav_interval_limit_speed_desc);
        this.p = this.f7872a.findViewById(R.id.bnav_interval_divider);
        this.m = this.f7872a.findViewById(R.id.bnav_ivel_container);
        this.j = (TextView) this.f7872a.findViewById(R.id.bnav_interval_ave_speed_value);
        this.k = (TextView) this.f7872a.findViewById(R.id.bnav_interval_ave_speed_tag);
        this.i = this.f7872a.findViewById(R.id.bnav_interval_ave_speed_bg);
        z zVar = new z();
        this.h = zVar;
        zVar.a(this.b, this.o, this.n, this.m, this.l, this.f7872a, this.p);
        i();
    }

    private void b(Bundle bundle) {
        int i = bundle.getInt("KEY_INTERVAL_CAMERA_SPEED_LIMIT", 0);
        int i2 = bundle.getInt("KEY_INTERVAL_CAMERA_REMAIN_DIST", -1);
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("IntervalSpeedHolder", "startIntervalCamera: " + bundle + ", " + i);
        }
        g.o().f().c(i);
        a(i);
        b(100);
        g.o().f().a(bundle.getInt("KEY_INTERVAL_CAMERA_LENGTH", -1));
        a(i, g.o().c());
        c(i2);
    }

    public void a(z.i iVar) {
        z zVar = this.h;
        if (zVar != null) {
            zVar.a(iVar);
            this.h.b();
            this.h.c(this.c);
        }
    }

    public boolean c() {
        if (LogUtil.LOGGABLE) {
            if (this.f7872a == null) {
                LogUtil.e("IntervalSpeedHolder", "show->mRootView = null");
            } else {
                LogUtil.e("IntervalSpeedHolder", "show->mRootView.getVisibility:" + this.f7872a.getVisibility() + ", mRootView.isShown:" + this.f7872a.isShown());
            }
        }
        View view = this.f7872a;
        if (view != null) {
            view.setVisibility(0);
        }
        k();
        z zVar = this.h;
        if (zVar == null) {
            return true;
        }
        zVar.a((z.i) null);
        this.h.b();
        this.h.b(this.c);
        return true;
    }

    public void d() {
        p f = g.o().f();
        if (f != null) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("IntervalSpeedHolder", "updateDataByLast, intervalCameraModel: " + f.toString());
            }
            a(f.e());
            b(f.d());
            a(f.c());
        }
    }

    public void a() {
        View view = this.f7872a;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public void a(Bundle bundle) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("IntervalSpeedHolder", "updateData: " + bundle);
        }
        if (bundle == null) {
            return;
        }
        g.o().f().a(bundle);
        int i = bundle.getInt("KEY_TYPE", 0);
        if (i == 4383) {
            b(bundle);
        } else if (i == 4384) {
            c(bundle);
        } else if (i == 4385) {
            f();
        }
    }

    private void a(int i, int i2) {
        if (this.j != null) {
            if (i2 <= 0) {
                i2 = g.o().c();
            }
            this.j.setText(i2 + "");
        }
        if (this.i == null || this.j == null || this.k == null) {
            return;
        }
        if (i2 > i) {
            l();
        } else {
            e();
        }
    }

    private void b(int i) {
        g.o().f().b(i);
    }

    private void c(Bundle bundle) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("IntervalSpeedHolder", "updateSpeedCameraDate: " + bundle);
        }
        int i = bundle.getInt("KEY_INTERVAL_CAMERA_REMAIN_DIST", -1);
        if (i != -1) {
            int b = g.o().f().b();
            b(b <= 0 ? 100 : (i * 100) / b);
            a(g.o().f().e(), bundle.getInt("KEY_INTERVAL_CAMERA_REMAIN_AVERAGE_SPEED", 0));
            c(i);
        }
        a(g.o().f().e());
    }

    public void b() {
        z zVar = this.h;
        if (zVar != null) {
            zVar.a();
            this.h = null;
        }
        this.b = null;
        this.q = null;
    }

    private void a(int i) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("IntervalSpeedHolder", "setIntervalSpeedLimit: " + i);
        }
        TextView textView = this.f;
        if (textView != null) {
            textView.setText(i + "");
        }
    }

    private void c(int i) {
        TextView textView = this.d;
        if (textView != null) {
            textView.setText(t.a(i));
            if (i > 999) {
                this.e.setText("剩余/公里");
            } else {
                this.e.setText("剩余/米");
            }
        }
    }
}
