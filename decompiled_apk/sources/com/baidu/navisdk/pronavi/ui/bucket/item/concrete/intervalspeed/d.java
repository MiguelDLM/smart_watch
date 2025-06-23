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
import com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMRotatingSpeedView;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.z;
import com.baidu.navisdk.ui.routeguide.model.p;
import com.baidu.navisdk.ui.speed.interval.RGMMIntervalSpeedBgView;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.t;
import com.baidu.navisdk.util.jar.JarUtils;
import java.util.HashMap;

/* loaded from: classes7.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private View f7876a;
    private Context b;
    private int c;
    private TextView d;
    private TextView e;
    private TextView f;
    private TextView g;
    private z h;
    private View i;
    private View j;
    private RGMMIntervalSpeedBgView k;
    private View l;
    private RGMMRotatingSpeedView m;
    private com.baidu.navisdk.pronavi.style.i.a n;

    /* loaded from: classes7.dex */
    public class a extends com.baidu.navisdk.pronavi.style.c {
        public a(Integer... numArr) {
            super(numArr);
        }

        @Override // com.baidu.navisdk.pronavi.style.i.a
        @OOXIXo
        public String a() {
            return "IntervalSpeed";
        }

        @Override // com.baidu.navisdk.pronavi.style.i.a
        public void b(String str) {
            d.this.h();
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
                if (d.this.d != null && d.this.e != null && d.this.f != null && d.this.g != null) {
                    d.this.d.setTextColor(color);
                    d.this.e.setTextColor(color);
                    d.this.f.setTextColor(color);
                    d.this.g.setTextColor(color);
                }
            }
            if (d.this.l != null) {
                d.this.l.setBackgroundColor(JarUtils.getResources().getColor(d("line_color", hashMap)));
            }
            if (d.this.k != null) {
                d.C0334d b = b("portrait_bg", hashMap);
                d.C0334d b2 = b("land_bg", hashMap);
                if (b != null && b2 != null) {
                    d.this.k.b(b.a(), b2.a());
                }
            }
            d.this.j();
            return true;
        }
    }

    public d(Context context, View view, int i) {
        this.b = context;
        this.f7876a = view;
        this.c = i;
        f();
    }

    private void i() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        p f = g.o().f();
        if (f != null) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("IntervalSpeedHolder", "updateLastIntervalData, intervalCameraModel: " + f);
            }
            a(f.c());
        }
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

    private void e() {
        g.o().f().a();
    }

    private void f() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("IntervalSpeedHolder", "initViewById,mRootView:" + this.f7876a);
        }
        View view = this.f7876a;
        if (view == null) {
            LogUtil.e("IntervalSpeedHolder", "initViewById, mRootView == null");
            return;
        }
        RGMMIntervalSpeedBgView rGMMIntervalSpeedBgView = (RGMMIntervalSpeedBgView) view.findViewById(R.id.container_bg);
        this.k = rGMMIntervalSpeedBgView;
        rGMMIntervalSpeedBgView.b(R.drawable.bnav_interval_camera_bg_hs, R.drawable.bnav_interval_camera_land_bg);
        this.i = this.f7876a.findViewById(R.id.bnav_remain_dis_container);
        this.j = this.f7876a.findViewById(R.id.bnav_speed_limit_container);
        this.d = (TextView) this.f7876a.findViewById(R.id.bnav_remain_dis_tv);
        this.e = (TextView) this.f7876a.findViewById(R.id.bnav_remain_dis_desc);
        this.f = (TextView) this.f7876a.findViewById(R.id.bnav_interval_standard_speed_tv);
        this.g = (TextView) this.f7876a.findViewById(R.id.bnav_interval_limit_speed_desc);
        this.l = this.f7876a.findViewById(R.id.bnav_interval_divider);
        this.m = (RGMMRotatingSpeedView) this.f7876a.findViewById(R.id.speed_view);
        z zVar = new z();
        this.h = zVar;
        zVar.a(this.b, this.k, this.j, this.m, this.i, this.f7876a, this.l);
        this.h.a(this.b.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_215dp));
        g();
    }

    private void g() {
        if (this.n == null) {
            a aVar = new a(new Integer[0]);
            this.n = aVar;
            f.b.a("IntervalSpeed", aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        int color = JarUtils.getResources().getColor(R.color.nsdk_interval_speed_default_text_color);
        this.d.setTextColor(color);
        this.e.setTextColor(color);
        this.f.setTextColor(color);
        this.g.setTextColor(color);
        RGMMIntervalSpeedBgView rGMMIntervalSpeedBgView = this.k;
        if (rGMMIntervalSpeedBgView != null) {
            rGMMIntervalSpeedBgView.b(R.drawable.bnav_interval_camera_bg_hs, R.drawable.bnav_interval_camera_land_bg);
        }
        View view = this.l;
        if (view != null) {
            view.setBackgroundColor(Color.parseColor("#dddddd"));
        }
        j();
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
            if (this.f7876a == null) {
                LogUtil.e("IntervalSpeedHolder", "show->mRootView = null");
            } else {
                LogUtil.e("IntervalSpeedHolder", "show->mRootView.getVisibility:" + this.f7876a.getVisibility() + ", mRootView.isShown:" + this.f7876a.isShown());
            }
        }
        View view = this.f7876a;
        if (view != null) {
            view.setVisibility(0);
        }
        i();
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
        View view = this.f7876a;
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
            e();
        }
    }

    private void a(int i, int i2) {
        if (this.m != null) {
            if (i2 <= 0) {
                i2 = g.o().c();
            }
            this.m.setSpeed(i2 + "");
            if (i2 > i) {
                this.m.a(3);
            } else {
                this.m.a(1);
            }
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
        this.n = null;
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
