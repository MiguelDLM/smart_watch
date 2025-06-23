package com.baidu.navisdk.pageframe;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.baidu.navisdk.framework.interfaces.i;
import com.baidu.navisdk.logicframe.LogicFrame;
import com.baidu.navisdk.logicframe.b;
import com.baidu.navisdk.uiframe.ModularUiFrame;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes7.dex */
public abstract class a<U extends ModularUiFrame<?>, L extends LogicFrame<?>> implements i {

    /* renamed from: a, reason: collision with root package name */
    @oOoXoXO
    private U f7628a;

    @oOoXoXO
    private L b;

    @oOoXoXO
    private Activity c;

    @OOXIXo
    public abstract L a();

    @Override // com.baidu.navisdk.framework.interfaces.i
    public void a(@oOoXoXO Context context, @oOoXoXO Bundle bundle) {
        if (context != null) {
            this.c = (Activity) context;
            L a2 = a();
            this.b = a2;
            IIX0o.ooOOo0oXI(a2);
            a2.create();
            this.f7628a = b2();
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    }

    @OOXIXo
    /* renamed from: b */
    public abstract U b2();

    @oOoXoXO
    public final Activity c() {
        return this.c;
    }

    @oOoXoXO
    public final b d() {
        L l = this.b;
        if (l != null) {
            return (b) l.n();
        }
        return null;
    }

    @oOoXoXO
    public final L e() {
        return this.b;
    }

    @oOoXoXO
    public final com.baidu.navisdk.uiframe.framework.a f() {
        U u = this.f7628a;
        if (u != null) {
            return u.b();
        }
        return null;
    }

    @oOoXoXO
    public final U g() {
        return this.f7628a;
    }

    public boolean h() {
        U u = this.f7628a;
        if (u != null) {
            return u.d();
        }
        return false;
    }

    @Override // com.baidu.navisdk.framework.interfaces.i
    public void onDestroy() {
        U u = this.f7628a;
        if (u != null) {
            u.destroy();
        }
        L l = this.b;
        if (l != null) {
            l.destroy();
        }
    }

    @Override // com.baidu.navisdk.framework.interfaces.i
    public void onPause() {
        U u = this.f7628a;
        if (u != null) {
            u.pause();
        }
        L l = this.b;
        if (l != null) {
            l.pause();
        }
    }

    @Override // com.baidu.navisdk.framework.interfaces.i
    public void onResume() {
        U u = this.f7628a;
        if (u != null) {
            u.resume();
        }
        L l = this.b;
        if (l != null) {
            l.resume();
        }
    }

    @Override // com.baidu.navisdk.framework.interfaces.i
    public void onStart() {
        U u = this.f7628a;
        if (u != null) {
            u.start();
        }
        L l = this.b;
        if (l != null) {
            l.start();
        }
    }

    @Override // com.baidu.navisdk.framework.interfaces.i
    public void onStop() {
        U u = this.f7628a;
        if (u != null) {
            u.stop();
        }
        L l = this.b;
        if (l != null) {
            l.stop();
        }
    }

    @Override // com.baidu.navisdk.framework.interfaces.i
    @oOoXoXO
    public View a(@oOoXoXO Activity activity, @oOoXoXO Bundle bundle, @oOoXoXO View view) {
        U u = this.f7628a;
        IIX0o.ooOOo0oXI(u);
        u.create();
        return null;
    }
}
