package com.baidu.navisdk.pronavi.ui.guidepanel.fuzzy;

import OXOo.oOoXoXO;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.v;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes7.dex */
public final class c extends com.baidu.navisdk.module.newguide.abs.b {
    public c(@oOoXoXO Context context, @oOoXoXO ViewGroup viewGroup, @oOoXoXO com.baidu.navisdk.ui.routeguide.subview.a aVar, int i) {
        super(context, viewGroup, aVar, i);
        x0();
    }

    private final void x0() {
        a vVar;
        a o02 = o0();
        if (o02 != null) {
            o02.c();
            o02.i();
        }
        com.baidu.navisdk.module.newguide.a e = com.baidu.navisdk.module.newguide.a.e();
        IIX0o.oO(e, "RGNewOldFuncController.getInstance()");
        if (e.d()) {
            if (!com.baidu.navisdk.ui.routeguide.utils.b.x()) {
                x.b().E1();
                vVar = new e(this.f9165a, this.b);
            } else {
                x.b().E4();
                vVar = new d(this.f9165a, this.b);
            }
        } else {
            x.b().E4();
            vVar = new v(this.f9165a, this.b);
        }
        a(vVar);
    }

    @Override // com.baidu.navisdk.module.newguide.abs.b
    public void A(boolean z) {
        a o02 = o0();
        if (o02 != null) {
            o02.A(z);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void a(boolean z) {
        super.a(z);
        a o02 = o0();
        if (o02 != null) {
            o02.a(z);
        }
    }

    @Override // com.baidu.navisdk.module.newguide.abs.b
    public void b(@oOoXoXO Drawable drawable) {
        a o02 = o0();
        if (o02 != null) {
            o02.b(drawable);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void c() {
        super.c();
        a o02 = o0();
        if (o02 != null) {
            o02.c();
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void d(@oOoXoXO Bundle bundle) {
        super.d(bundle);
        a o02 = o0();
        if (o02 != null) {
            o02.d(bundle);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void i() {
        super.i();
        a o02 = o0();
        if (o02 != null) {
            o02.i();
        }
        a((a) null);
    }

    @Override // com.baidu.navisdk.module.newguide.abs.b
    public void n0() {
        a o02 = o0();
        if (o02 != null) {
            o02.n0();
        }
    }

    @Override // com.baidu.navisdk.module.newguide.abs.b
    @oOoXoXO
    public View p0() {
        a o02 = o0();
        if (o02 != null) {
            return o02.o0();
        }
        return null;
    }

    @Override // com.baidu.navisdk.module.newguide.abs.b
    public void q0() {
        a o02 = o0();
        if (o02 != null) {
            o02.p0();
        }
    }

    @Override // com.baidu.navisdk.module.newguide.abs.b
    public boolean r0() {
        boolean z;
        if (o0() instanceof e) {
            return false;
        }
        a o02 = o0();
        if (o02 != null) {
            z = o02.a();
        } else {
            z = false;
        }
        if (!z) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.navisdk.module.newguide.abs.b
    public void s0() {
        a o02 = o0();
        if (o02 != null) {
            o02.q0();
        }
    }

    @Override // com.baidu.navisdk.module.newguide.abs.b
    public void t0() {
        a o02 = o0();
        if (o02 != null) {
            o02.r0();
        }
    }

    @Override // com.baidu.navisdk.module.newguide.abs.b
    public void u0() {
        a o02 = o0();
        if (o02 != null) {
            o02.s0();
        }
    }

    @Override // com.baidu.navisdk.module.newguide.abs.b
    public void v(int i) {
        a o02 = o0();
        if (o02 != null) {
            o02.v(i);
        }
    }

    @Override // com.baidu.navisdk.module.newguide.abs.b
    public void w(int i) {
        a o02 = o0();
        if (o02 != null) {
            o02.w(i);
        }
    }

    @Override // com.baidu.navisdk.module.newguide.abs.b
    public void w0() {
        a o02 = o0();
        if (o02 != null) {
            o02.t0();
        }
    }

    @Override // com.baidu.navisdk.module.newguide.abs.b
    public void x(int i) {
        a o02 = o0();
        if (o02 != null) {
            o02.x(i);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public boolean y() {
        if (this.g) {
            return false;
        }
        com.baidu.navisdk.module.newguide.a e = com.baidu.navisdk.module.newguide.a.e();
        IIX0o.oO(e, "RGNewOldFuncController.getInstance()");
        if (e.d()) {
            if (com.baidu.navisdk.ui.routeguide.utils.b.s()) {
                if (!(o0() instanceof e)) {
                    a o02 = o0();
                    if (o02 != null) {
                        o02.c();
                    }
                    a o03 = o0();
                    if (o03 != null) {
                        o03.i();
                    }
                }
                x.b().E1();
                a(new e(this.f9165a, this.b));
            } else {
                if (!(o0() instanceof d)) {
                    a o04 = o0();
                    if (o04 != null) {
                        o04.c();
                    }
                    a o05 = o0();
                    if (o05 != null) {
                        o05.i();
                    }
                }
                x.b().E4();
                a(new d(this.f9165a, this.b));
            }
        } else {
            if (!(o0() instanceof v)) {
                a o06 = o0();
                if (o06 != null) {
                    o06.c();
                }
                a o07 = o0();
                if (o07 != null) {
                    o07.i();
                }
            }
            x.b().E4();
            a(new v(this.f9165a, this.b));
        }
        a o08 = o0();
        if (o08 != null) {
            o08.y();
        }
        return super.y();
    }

    @Override // com.baidu.navisdk.module.newguide.abs.b
    public void z(boolean z) {
        a o02 = o0();
        if (o02 != null) {
            o02.z(z);
        }
    }

    @Override // com.baidu.navisdk.module.newguide.abs.b
    public void z(int i) {
        a o02 = o0();
        if (o02 != null) {
            o02.z(i);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void a(@oOoXoXO ViewGroup viewGroup, int i) {
        super.a(viewGroup, i);
        a o02 = o0();
        if (o02 != null) {
            o02.a(viewGroup, i);
        }
    }

    @Override // com.baidu.navisdk.module.newguide.abs.b
    public void a(@oOoXoXO Drawable drawable, @oOoXoXO String str, int i) {
        a o02 = o0();
        if (o02 != null) {
            o02.a(drawable, str, i);
        }
    }

    @Override // com.baidu.navisdk.module.newguide.abs.b
    public void y(int i) {
        a o02 = o0();
        if (o02 != null) {
            o02.y(i);
        }
    }

    @Override // com.baidu.navisdk.module.newguide.abs.b
    public void y(boolean z) {
        a o02 = o0();
        if (o02 != null) {
            o02.y(z);
        }
    }
}
