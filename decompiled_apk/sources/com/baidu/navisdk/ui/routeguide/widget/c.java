package com.baidu.navisdk.ui.routeguide.widget;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes8.dex */
public abstract class c extends d {
    private String i;
    private boolean j;
    protected View k;
    protected ViewGroup l;

    public c(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
        this.i = "BNBaseOrientationView";
        this.j = false;
        this.k = null;
        this.l = null;
        this.i = s0();
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void a(ViewGroup viewGroup, int i) {
        v(i);
        super.a(viewGroup, i);
        z(true);
        if (r0() != q0()) {
            u0();
        }
        if (a()) {
            y(true);
            return;
        }
        ViewGroup viewGroup2 = (ViewGroup) this.k.getParent();
        if (viewGroup2 != null) {
            viewGroup2.removeView(this.k);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public boolean b(Bundle bundle) {
        super.b(bundle);
        if (!this.j || this.k == null) {
            u0();
        }
        z(false);
        y(false);
        ViewGroup viewGroup = this.l;
        if (viewGroup != null) {
            viewGroup.setVisibility(0);
            return true;
        }
        return true;
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void c() {
        super.c();
        ViewGroup viewGroup = this.l;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void i() {
        super.i();
        View view = this.k;
        if (view != null) {
            try {
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(this.k);
                }
            } catch (Exception unused) {
                LogUtil.e(this.i, "webview dispose exception");
            }
        }
        this.l = null;
        this.k = null;
        this.j = false;
    }

    public boolean n0() {
        return false;
    }

    public abstract ViewGroup.LayoutParams o0();

    public abstract int p0();

    public abstract int q0();

    public abstract int r0();

    public abstract String s0();

    public abstract void t0();

    public final void u0() {
        int q0;
        if (LogUtil.LOGGABLE) {
            LogUtil.e(this.i, "initView");
        }
        this.j = true;
        if (1 == x.b().d0()) {
            this.f = 1;
            q0 = r0();
        } else {
            this.f = 2;
            q0 = q0();
        }
        if (n0()) {
            this.k = com.baidu.navisdk.ui.util.b.a(this.f9165a, q0, null);
        } else {
            this.k = JarUtils.inflate(this.f9165a, q0, null);
        }
        if (this.k == null && LogUtil.LOGGABLE) {
            LogUtil.e(this.i, "initView -- mRootView == null!, mCurOrientation = " + this.f);
        }
        w0();
        t0();
        x0();
        if (!n0()) {
            a(com.baidu.navisdk.ui.util.b.b());
        }
    }

    public void v(int i) {
    }

    public abstract void w0();

    public abstract void x0();

    public void y(boolean z) {
        ViewGroup viewGroup = this.l;
        if (viewGroup == null) {
            LogUtil.e(this.i, "addToContainner mRootViewContainer is null");
            return;
        }
        if (viewGroup.getChildCount() != 0 && !z) {
            LogUtil.e(this.i, "addToContainner has done");
            return;
        }
        this.l.removeAllViews();
        View view = this.k;
        if (view == null) {
            LogUtil.e(this.i, "addToContainner mRootView is null");
            return;
        }
        ViewGroup viewGroup2 = (ViewGroup) view.getParent();
        if (viewGroup2 != null) {
            viewGroup2.removeView(this.k);
        }
        if (!a()) {
            this.l.setVisibility(8);
            LogUtil.e(this.i, "addToContainer isVisibility false");
            return;
        }
        ViewGroup.LayoutParams o02 = o0();
        if (o02 != null) {
            this.k.setLayoutParams(o02);
        }
        this.l.addView(this.k);
        this.l.setVisibility(0);
    }

    public void z(boolean z) {
        if (this.l == null || z) {
            if (this.b == null) {
                this.b = x.b().s0();
            }
            ViewGroup viewGroup = this.b;
            if (viewGroup == null) {
                LogUtil.e(this.i, "initViewContainner error mRootViewGroup is null");
            } else {
                this.l = (ViewGroup) viewGroup.findViewById(p0());
            }
        }
    }

    public c(Context context, ViewGroup viewGroup, com.baidu.navisdk.ui.routeguide.subview.a aVar) {
        super(context, viewGroup, aVar);
        this.i = "BNBaseOrientationView";
        this.j = false;
        this.k = null;
        this.l = null;
        this.i = s0();
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public final boolean y() {
        return b(null);
    }
}
