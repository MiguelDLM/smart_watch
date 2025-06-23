package com.baidu.navisdk.module.newguide.subviews;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStore;

/* loaded from: classes7.dex */
public class c extends com.baidu.navisdk.module.newguide.widgets.c {
    private TextView j;
    private TextView k;
    private boolean l;
    private Handler m;
    private Runnable n;
    private Runnable o;
    private a p;
    private a q;
    private boolean r;

    /* loaded from: classes7.dex */
    public static class a {
        public void a() {
            throw null;
        }
    }

    public c(Context context, ViewGroup viewGroup, com.baidu.navisdk.ui.routeguide.subview.a aVar, LifecycleOwner lifecycleOwner, ViewModelStore viewModelStore, ViewGroup viewGroup2) {
        super(context, viewGroup, aVar, lifecycleOwner, viewModelStore);
        this.l = false;
        this.m = null;
        this.r = false;
        a(viewGroup2);
        b(viewGroup2);
        n0();
    }

    private boolean r0() {
        if (this.f == 1) {
            return true;
        }
        return false;
    }

    private void s0() {
        Runnable runnable;
        Runnable runnable2;
        TextView textView = this.j;
        if (textView != null && (runnable2 = this.n) != null) {
            textView.removeCallbacks(runnable2);
            this.n = null;
        }
        TextView textView2 = this.k;
        if (textView2 != null && (runnable = this.o) != null) {
            textView2.removeCallbacks(runnable);
            this.o = null;
        }
        a aVar = this.p;
        if (aVar != null) {
            aVar.a();
        }
        a aVar2 = this.q;
        if (aVar2 != null) {
            aVar2.a();
        }
    }

    public void a(ViewGroup viewGroup) {
        throw null;
    }

    public void b(View.OnClickListener onClickListener) {
        throw null;
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void c() {
        super.c();
    }

    @Override // com.baidu.navisdk.module.newguide.widgets.c, com.baidu.navisdk.ui.routeguide.widget.d
    public void i() {
        super.i();
        this.l = false;
        Handler handler = this.m;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.m = null;
        }
        s0();
    }

    public void n0() {
        throw null;
    }

    public ViewGroup o0() {
        throw null;
    }

    public void p0() {
        throw null;
    }

    public void q0() {
        throw null;
    }

    public void v(int i) {
        throw null;
    }

    public void w(int i) {
        throw null;
    }

    public void y(boolean z) {
        throw null;
    }

    public void a(ViewGroup viewGroup, int i, ViewGroup viewGroup2) {
        throw null;
    }

    public void b(ViewGroup viewGroup) {
        throw null;
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public boolean y() {
        if (!this.r || r0()) {
            return super.y();
        }
        return false;
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void a(boolean z) {
        super.a(z);
    }
}
