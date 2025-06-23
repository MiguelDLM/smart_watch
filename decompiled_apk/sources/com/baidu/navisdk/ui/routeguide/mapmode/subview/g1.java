package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.navisdk.ui.routeguide.asr.view.BNVoiceAidView;
import com.baidu.navisdk.util.common.LogUtil;

/* loaded from: classes8.dex */
public class g1 extends com.baidu.navisdk.ui.routeguide.widget.d implements BNVoiceAidView.i {
    private BNVoiceAidView i;
    private boolean j;

    public g1(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
        this.j = false;
        r0();
    }

    private void p0() {
        BNVoiceAidView bNVoiceAidView = this.i;
        if (bNVoiceAidView != null) {
            bNVoiceAidView.a();
        }
    }

    private void q0() {
        ViewGroup viewGroup = this.b;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
        BNVoiceAidView bNVoiceAidView = this.i;
        if (bNVoiceAidView != null) {
            bNVoiceAidView.setVisibility(8);
        }
    }

    private void r0() {
        if (this.b == null) {
            return;
        }
        if (this.i == null) {
            this.i = new BNVoiceAidView(this.f9165a);
        }
        BNVoiceAidView bNVoiceAidView = this.i;
        if (bNVoiceAidView != null && bNVoiceAidView.getParent() != null) {
            ((ViewGroup) this.i.getParent()).removeView(this.i);
        }
        this.b.addView(this.i);
        this.i.setOnAidSceneAnimChangedListener(this);
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void a(ViewGroup viewGroup, int i) {
        super.a(viewGroup, i);
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGMMVoiceAidView", "orientationChanged(), p = " + viewGroup + " orien = " + i);
        }
        BNVoiceAidView bNVoiceAidView = this.i;
        if (bNVoiceAidView != null) {
            bNVoiceAidView.b();
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void c() {
        y(true);
    }

    @Override // com.baidu.navisdk.ui.routeguide.asr.view.BNVoiceAidView.i
    public void n(boolean z) {
        int i;
        com.baidu.navisdk.ui.routeguide.mapmode.presenter.a I = com.baidu.navisdk.ui.routeguide.control.x.b().I();
        if (!z) {
            i = 0;
        } else {
            i = 4;
        }
        I.d(i);
        com.baidu.navisdk.ui.routeguide.control.x.b().w3();
    }

    public boolean n0() {
        return this.j;
    }

    public void o0() {
        ViewGroup viewGroup = this.b;
        if (viewGroup != null) {
            viewGroup.setVisibility(0);
        }
        BNVoiceAidView bNVoiceAidView = this.i;
        if (bNVoiceAidView != null) {
            bNVoiceAidView.setVisibility(0);
            this.i.c();
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public boolean y() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGMMVoiceAidView", "show(), isShowing = " + this.j);
        }
        if (this.i != null) {
            com.baidu.navisdk.asr.d.B().a(this.i);
        }
        if (this.j) {
            ViewGroup viewGroup = this.b;
            if (viewGroup != null) {
                viewGroup.setVisibility(0);
            }
            BNVoiceAidView bNVoiceAidView = this.i;
            if (bNVoiceAidView != null) {
                bNVoiceAidView.setVisibility(0);
            }
        } else {
            o0();
        }
        this.j = true;
        return super.y();
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void a(boolean z) {
        super.a(z);
        BNVoiceAidView bNVoiceAidView = this.i;
        if (bNVoiceAidView != null) {
            bNVoiceAidView.d();
        }
    }

    public void a(BNVoiceAidView.j jVar) {
        BNVoiceAidView bNVoiceAidView = this.i;
        if (bNVoiceAidView != null) {
            bNVoiceAidView.setVisibilityCallBack(jVar);
        }
    }

    private void y(boolean z) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGMMVoiceAidView", "closePanel(), withAnim = " + z + "," + this.j);
        }
        if (this.j) {
            if (z) {
                p0();
            } else {
                q0();
            }
        }
        this.j = false;
        super.c(null);
    }
}
