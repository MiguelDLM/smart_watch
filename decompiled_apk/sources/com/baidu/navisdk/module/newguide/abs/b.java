package com.baidu.navisdk.module.newguide.abs;

import OXOo.oOoXoXO;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes7.dex */
public abstract class b extends com.baidu.navisdk.ui.routeguide.widget.d {

    @oOoXoXO
    private com.baidu.navisdk.pronavi.ui.guidepanel.fuzzy.a i;

    public b(@oOoXoXO Context context, @oOoXoXO ViewGroup viewGroup, @oOoXoXO com.baidu.navisdk.ui.routeguide.subview.a aVar, int i) {
        super(context, viewGroup, aVar, i);
    }

    public abstract void A(boolean z);

    public abstract void a(@oOoXoXO Drawable drawable, @oOoXoXO String str, int i);

    public final void a(@oOoXoXO com.baidu.navisdk.pronavi.ui.guidepanel.fuzzy.a aVar) {
        this.i = aVar;
    }

    public abstract void b(@oOoXoXO Drawable drawable);

    public abstract void n0();

    @oOoXoXO
    public final com.baidu.navisdk.pronavi.ui.guidepanel.fuzzy.a o0() {
        return this.i;
    }

    @oOoXoXO
    public abstract View p0();

    public abstract void q0();

    public abstract boolean r0();

    public abstract void s0();

    public abstract void t0();

    public abstract void u0();

    public abstract void v(int i);

    public abstract void w(int i);

    public abstract void w0();

    public abstract void x(int i);

    public abstract void y(int i);

    public abstract void y(boolean z);

    public abstract void z(int i);

    public abstract void z(boolean z);
}
