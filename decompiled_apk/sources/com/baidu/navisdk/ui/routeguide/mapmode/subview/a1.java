package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.TextView;
import com.baidu.navisdk.comapi.setting.BNCommSettingManager;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;

/* loaded from: classes8.dex */
public class a1 extends com.baidu.navisdk.ui.routeguide.widget.d {
    private TextView i;
    private TextView j;
    private View k;
    private View l;
    private View m;
    private Animation n;
    private com.baidu.navisdk.pronavi.style.i.a o;
    private com.baidu.navisdk.pronavi.style.i.b p;
    private int q;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a1.this.r0();
        }
    }

    public a1(Context context, ViewGroup viewGroup, com.baidu.navisdk.ui.routeguide.subview.a aVar) {
        this(context, viewGroup, aVar, 0);
    }

    private void o0() {
        int i;
        n0();
        View view = this.k;
        if (view != null) {
            i = view.getVisibility();
            this.k.setVisibility(8);
        } else {
            i = 0;
        }
        this.k = this.b.findViewById(R.id.bnav_rg_cp_cur_car_speed_rl);
        this.i = (TextView) this.b.findViewById(R.id.bnav_rg_cp_cur_car_speed);
        this.l = this.b.findViewById(R.id.bnav_rg_cp_car_speed_bg);
        this.m = this.b.findViewById(R.id.bnav_rg_cp_cur_overspeed_anim_view);
        this.j = (TextView) this.b.findViewById(R.id.bnav_rg_cp_cur_car_speed_tv);
        View view2 = this.k;
        if (view2 != null) {
            view2.setVisibility(i);
        }
        p0();
    }

    private void p0() {
        if (this.o == null) {
            b bVar = new b(new Integer[0]);
            this.o = bVar;
            com.baidu.navisdk.pronavi.style.f.b.a("RGSpeedKey", bVar);
        }
    }

    private void q0() {
        if (this.m != null) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("RGMMSpeedView", "startCurCarOverSpeedAnim->");
            }
            if (this.m.getWidth() > 0 && this.m.getHeight() > 0) {
                r0();
            } else {
                this.m.post(new a());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r0() {
        View view;
        if (this.n == null) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.1f, 1.0f, 1.1f, 1, 0.5f, 1, 0.5f);
            this.n = scaleAnimation;
            scaleAnimation.setDuration(600L);
            this.n.setRepeatMode(2);
            this.n.setRepeatCount(-1);
        }
        if ((this.n.hasStarted() && !this.n.hasEnded()) || (view = this.m) == null) {
            return;
        }
        view.startAnimation(this.n);
    }

    public void n0() {
        Animation animation;
        View view = this.m;
        if (view != null) {
            view.clearAnimation();
            Animation animation2 = this.n;
            if (animation2 != null) {
                animation2.cancel();
                this.n = null;
            }
        }
        View view2 = this.l;
        if (view2 != null && (animation = view2.getAnimation()) != null) {
            animation.cancel();
            this.l.clearAnimation();
        }
    }

    public void q() {
        int i;
        if (!BNCommSettingManager.getInstance().isShowSpeedClock()) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGMMSpeedView", "updateCurCarSpeed user setting not show");
                return;
            }
            return;
        }
        if (this.i != null && this.k != null && this.j != null) {
            String b2 = com.baidu.navisdk.module.pronavi.model.g.o().b();
            this.i.setText(b2);
            try {
                if (b2.length() >= 3) {
                    this.i.setTextSize(1, ScreenUtil.getInstance().getDp(this.f9165a, R.dimen.navi_dimens_28dp));
                } else {
                    this.i.setTextSize(1, ScreenUtil.getInstance().getDp(this.f9165a, R.dimen.navi_dimens_28dp));
                }
            } catch (Exception unused) {
                com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
                if (gVar2.c()) {
                    gVar2.c("RGMMSpeedView", "updateCurCarSpeed: setTextSize exception");
                }
                this.i.setTextSize(1, 28.0f);
            }
            com.baidu.navisdk.util.common.g gVar3 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar3.d()) {
                gVar3.e("RGMMSpeedView", "updateCurCarSpeed-> isSpeedValueShow=" + com.baidu.navisdk.module.pronavi.model.g.o().k() + ",isOverSpeed=" + com.baidu.navisdk.module.pronavi.model.g.o().j() + ",mIsGPSEnable=" + com.baidu.navisdk.module.pronavi.model.g.o().g + ",mIsGPSFix=" + com.baidu.navisdk.module.pronavi.model.g.o().h);
            }
            boolean j = com.baidu.navisdk.module.pronavi.model.g.o().j();
            if (this.p == null) {
                this.p = com.baidu.navisdk.ui.routeguide.utils.b.g();
            }
            com.baidu.navisdk.pronavi.style.i.b bVar = this.p;
            if (bVar != null) {
                bVar.b("RGSpeedKey", this.o);
            } else {
                y(j);
            }
            View view = this.m;
            if (view != null) {
                if (j) {
                    i = 0;
                } else {
                    i = 8;
                }
                view.setVisibility(i);
            }
            if (j) {
                q0();
            } else {
                n0();
            }
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public boolean y() {
        if (!BNCommSettingManager.getInstance().isShowSpeedClock()) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGMMSpeedView", "show user setting not show");
            }
            return false;
        }
        super.y();
        View view = this.k;
        if (view != null) {
            view.setVisibility(0);
        }
        q();
        return true;
    }

    public a1(Context context, ViewGroup viewGroup, com.baidu.navisdk.ui.routeguide.subview.a aVar, int i) {
        super(context, viewGroup, aVar);
        this.q = i;
        o0();
    }

    public boolean b(int i) {
        if (!BNCommSettingManager.getInstance().isShowSpeedClock()) {
            i = 8;
        }
        if (i == 0) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGMMSpeedView", "setCurCarSpeedVisibility() mCurCarSpeedVisiable = " + com.baidu.navisdk.module.pronavi.model.g.o().i() + ", hasIntervalCamera = " + com.baidu.navisdk.module.pronavi.model.g.o().g());
            }
            if (this.k != null) {
                if (com.baidu.navisdk.module.pronavi.model.g.o().i() && !com.baidu.navisdk.module.pronavi.model.g.o().g() && RouteGuideFSM.getInstance().isEqualCurrentState(RGFSMTable.FsmState.SimpleGuide, RGFSMTable.FsmState.EnlargeRoadmap)) {
                    y();
                    return true;
                }
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("RGMMSpeedView", "setCurCarSpeedVisibility(), visibility=" + i);
                }
                c();
            }
        } else if (i == 8) {
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar2.d()) {
                gVar2.e("RGMMSpeedView", "setCurCarSpeedVisibility() BNavigator.mCurCarSpeedVisiable = " + com.baidu.navisdk.module.pronavi.model.g.o().i());
            }
            c();
        }
        return false;
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void c() {
        super.c();
        n0();
        View view = this.k;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void a(ViewGroup viewGroup, int i) {
        super.a(viewGroup, i);
        o0();
        q();
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void a(boolean z) {
        super.a(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(boolean z) {
        Animation animation = this.l.getAnimation();
        if (animation != null) {
            animation.cancel();
        }
        this.l.clearAnimation();
        if (z) {
            TextView textView = this.i;
            int i = R.color.nsdk_cl_link_b;
            textView.setTextColor(com.baidu.navisdk.ui.util.b.b(i));
            this.j.setTextColor(com.baidu.navisdk.ui.util.b.b(i));
            this.l.setBackgroundDrawable(com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_drawable_rg_assist_over_speed));
        } else {
            TextView textView2 = this.i;
            int i2 = R.color.nsdk_cl_link_a;
            textView2.setTextColor(com.baidu.navisdk.ui.util.b.b(i2));
            this.j.setTextColor(com.baidu.navisdk.ui.util.b.b(i2));
            this.l.setBackgroundDrawable(com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_drawable_rg_assist_normal_speed));
        }
        View view = this.m;
        if (view != null) {
            view.setBackground(com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_drawable_rg_assist_overspeed_anim_bg));
        }
    }

    /* loaded from: classes8.dex */
    public class b extends com.baidu.navisdk.pronavi.style.c {
        public b(Integer... numArr) {
            super(numArr);
        }

        @Override // com.baidu.navisdk.pronavi.style.i.a
        @OOXIXo
        public String a() {
            return "RGMMSpeedView_" + a1.this.q;
        }

        @Override // com.baidu.navisdk.pronavi.style.i.a
        public void b(String str) {
            a1.this.y(com.baidu.navisdk.module.pronavi.model.g.o().j());
        }

        @Override // com.baidu.navisdk.pronavi.style.i.a
        public void c() {
            a(a1.this.i);
            a(a1.this.j);
            a(a1.this.l);
            a("RGOverSpeedAnimBg", (String) a1.this.m);
            c("RGOverSpeedViewAnimator", (String) a1.this.l);
        }

        @Override // com.baidu.navisdk.pronavi.style.c
        public boolean e() {
            return false;
        }

        @Override // com.baidu.navisdk.pronavi.style.c, com.baidu.navisdk.pronavi.style.i.a
        @oOoXoXO
        public String c(String str) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGEnableChangeStyleHelper", "speedView getCurrentStyleItemKey: " + str);
            }
            return "RGSpeedKey".equals(str) ? com.baidu.navisdk.module.pronavi.model.g.o().j() ? "RGOverSpeed" : "RGNormalSpeed" : str;
        }
    }
}
