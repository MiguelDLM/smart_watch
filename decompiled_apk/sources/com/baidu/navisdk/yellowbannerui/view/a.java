package com.baidu.navisdk.yellowbannerui.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.view.ViewGroup;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.yellowbannerui.config.f;
import com.baidu.navisdk.yellowtipdata.model.data.d;

/* loaded from: classes8.dex */
public abstract class a extends com.baidu.navisdk.module.routeresult.ui.a<com.baidu.navisdk.yellowbannerui.view.params.a> {
    protected d p;
    protected f.b q;
    protected boolean r;
    protected ValueAnimator s;

    /* renamed from: com.baidu.navisdk.yellowbannerui.view.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0517a implements ValueAnimator.AnimatorUpdateListener {
        public C0517a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ViewGroup.LayoutParams layoutParams;
            Integer num = (Integer) valueAnimator.getAnimatedValue();
            ViewGroup viewGroup = ((com.baidu.navisdk.module.routeresult.ui.a) a.this).d;
            if (viewGroup == null || (layoutParams = viewGroup.getLayoutParams()) == null) {
                return;
            }
            layoutParams.height = ScreenUtil.getInstance().dip2px(num.intValue());
            LogUtil.e("RouteCarYBannerBaseView", "onAnimationUpdate-> " + num + ", " + layoutParams.height);
            viewGroup.requestLayout();
        }
    }

    public a(Context context, com.baidu.navisdk.yellowbannerui.view.params.a aVar) {
        super(context, aVar);
        this.s = null;
        this.p = aVar.j();
        if (aVar.k() == null) {
            this.q = new f.a();
        } else {
            this.q = aVar.k();
        }
        this.r = aVar.l();
    }

    private void r() {
        ViewGroup.LayoutParams layoutParams;
        ViewGroup viewGroup = this.d;
        if (viewGroup != null && (layoutParams = viewGroup.getLayoutParams()) != null) {
            layoutParams.height = -2;
            layoutParams.width = -1;
        }
    }

    public abstract void a(int i, boolean z);

    public void a(com.baidu.navisdk.yellowbannerui.view.params.a aVar) {
    }

    public int e(int i) {
        if (i == 1) {
            return Color.parseColor("#333333");
        }
        return Color.parseColor("#ffffff");
    }

    public int f(int i) {
        if (i == 0) {
            return R.drawable.bnav_route_banner_yellow_tips_notice_yellow_bg;
        }
        if (i == 2) {
            return R.drawable.bnav_route_banner_yellow_tips_notice_red_bg;
        }
        if (i == 4) {
            return R.drawable.bnav_route_banner_yellow_tips_notice_green_bg;
        }
        if (i == 5) {
            return R.drawable.bnav_route_banner_yellow_tips_notice_blue_bg;
        }
        return R.drawable.bnav_route_banner_yellow_tips_notice_yellow_bg;
    }

    public int g(int i) {
        if (i == 0) {
            return R.drawable.bnav_route_banner_yellow_yaw_overly_bg;
        }
        if (i == 2) {
            return R.drawable.bnav_route_banner_yellow_red_overly_bg;
        }
        if (i == 4) {
            return R.drawable.bnav_route_banner_yellow_green_overly_bg;
        }
        if (i == 5) {
            return R.drawable.bnav_route_banner_yellow_blue_overly_bg;
        }
        return R.drawable.bnav_route_banner_yellow_yaw_overly_bg;
    }

    @Override // com.baidu.navisdk.module.routeresult.ui.a
    public void h() {
        super.h();
        r();
    }

    @Override // com.baidu.navisdk.module.routeresult.ui.a
    public void n() {
        this.d.clearAnimation();
        ValueAnimator valueAnimator = this.s;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.s = null;
        }
        super.n();
    }

    @Override // com.baidu.navisdk.module.routeresult.ui.a
    public void o() {
        super.o();
        this.d.clearAnimation();
        ValueAnimator valueAnimator = this.s;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.s = null;
        }
        this.d.setVisibility(0);
        int q = q();
        if (q > 0) {
            ValueAnimator ofInt = ValueAnimator.ofInt(0, q);
            this.s = ofInt;
            ofInt.setDuration(500L);
            this.s.addUpdateListener(new C0517a());
            this.s.start();
        }
    }

    public com.baidu.navisdk.yellowbannerui.view.params.a p() {
        return (com.baidu.navisdk.yellowbannerui.view.params.a) this.b;
    }

    public abstract int q();

    public void h(int i) {
        a(i, this.r);
    }
}
