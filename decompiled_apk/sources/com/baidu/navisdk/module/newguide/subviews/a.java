package com.baidu.navisdk.module.newguide.subviews;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/* loaded from: classes7.dex */
public class a extends com.baidu.navisdk.ui.routeguide.widget.d implements View.OnClickListener {
    protected TextView i;
    protected View j;
    protected boolean k;
    protected b l;
    protected InterfaceC0265a m;

    /* renamed from: com.baidu.navisdk.module.newguide.subviews.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0265a {
        void a();

        void b();
    }

    /* loaded from: classes7.dex */
    public interface b {
        void a();

        void a(boolean z);
    }

    public a(Context context, ViewGroup viewGroup, ViewGroup viewGroup2) {
        super(context, viewGroup);
        this.k = false;
        a(viewGroup2);
    }

    public void A(boolean z) {
        throw null;
    }

    public void a(ViewGroup viewGroup) {
        throw null;
    }

    public void b(boolean z, boolean z2) {
        throw null;
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void i() {
        super.i();
        z(false);
        TextView textView = this.i;
        if (textView != null) {
            textView.setOnClickListener(null);
        }
        this.l = null;
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void i0() {
        super.i0();
        z(false);
    }

    public boolean n0() {
        if (this.f == 1) {
            return true;
        }
        return false;
    }

    public boolean o0() {
        View view = this.j;
        if (view == null || !(view.getParent() instanceof ViewGroup) || this.j.getVisibility() != 0) {
            return false;
        }
        return true;
    }

    public boolean p0() {
        throw null;
    }

    public void y(boolean z) {
        throw null;
    }

    public void z(boolean z) {
        throw null;
    }

    public void a(ViewGroup viewGroup, int i, ViewGroup viewGroup2) {
        throw null;
    }

    public void a(InterfaceC0265a interfaceC0265a) {
        throw null;
    }

    public void a(b bVar) {
        throw null;
    }
}
