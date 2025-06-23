package com.baidu.navisdk.module.routeresult.model;

import android.view.ViewGroup;
import com.baidu.navisdk.module.routeresult.interfaces.a;

/* loaded from: classes7.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private ViewGroup f7501a;
    private ViewGroup b;
    private boolean c = true;
    private a.b d;
    private a.e e;
    private a.d f;
    private a.c g;
    private a.InterfaceC0284a h;

    public ViewGroup a() {
        return this.b;
    }

    public void b(ViewGroup viewGroup) {
        this.f7501a = viewGroup;
    }

    public a.c c() {
        return this.g;
    }

    public a.d d() {
        return this.f;
    }

    public a.b e() {
        return this.d;
    }

    public a.e f() {
        return this.e;
    }

    public ViewGroup g() {
        return this.f7501a;
    }

    public boolean h() {
        return this.c;
    }

    public String toString() {
        return "BaseParams{mRootView=" + this.f7501a + ", mContainerView=" + this.b + ", isUseInnerAnimation=" + this.c + ", mOnOutClickListener=" + this.d + ", mOnShowListener=" + this.e + ", mOnHideListener=" + this.f + ", mOnDismissListener=" + this.g + ", mOnCancelListener=" + this.h + '}';
    }

    public void a(ViewGroup viewGroup) {
        this.b = viewGroup;
    }

    public a.InterfaceC0284a b() {
        return this.h;
    }

    public void a(a.b bVar) {
        this.d = bVar;
    }
}
