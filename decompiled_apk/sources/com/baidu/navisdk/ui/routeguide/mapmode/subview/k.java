package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;

/* loaded from: classes8.dex */
public abstract class k {

    /* renamed from: a, reason: collision with root package name */
    public int f8808a;
    protected Context b;

    public void a(boolean z) {
    }

    public abstract RelativeLayout.LayoutParams d();

    public abstract View e();

    public boolean f() {
        return true;
    }

    public void g() {
    }

    public abstract void h();

    public void i() {
    }

    public abstract void j();

    public abstract void k();

    public String toString() {
        return "RGMMBaseCardView{mType=" + this.f8808a + ", getView = " + e() + '}';
    }
}
