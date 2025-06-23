package com.baidu.navisdk.ui.routeguide.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.navisdk.framework.interfaces.y;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.util.common.u;

/* loaded from: classes8.dex */
public abstract class d implements y {

    /* renamed from: a, reason: collision with root package name */
    protected Context f9165a;
    protected ViewGroup b;
    protected com.baidu.navisdk.ui.routeguide.subview.a c;
    protected int f;
    private boolean d = false;
    protected boolean e = true;
    protected boolean g = false;
    private com.baidu.navisdk.util.worker.f<String, String> h = new a("BNBaseView-autoHideTask", null);

    /* loaded from: classes8.dex */
    public class a extends com.baidu.navisdk.util.worker.f<String, String> {
        public a(String str, String str2) {
            super(str, str2);
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            d.this.i0();
            return null;
        }
    }

    /* loaded from: classes8.dex */
    public class b extends com.baidu.navisdk.util.worker.f<String, String> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Runnable f9167a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(d dVar, String str, String str2, Runnable runnable) {
            super(str, str2);
            this.f9167a = runnable;
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            this.f9167a.run();
            return null;
        }
    }

    /* loaded from: classes8.dex */
    public class c extends com.baidu.navisdk.util.worker.f<String, String> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Runnable f9168a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(d dVar, String str, String str2, Runnable runnable) {
            super(str, str2);
            this.f9168a = runnable;
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            this.f9168a.run();
            return null;
        }
    }

    public d(Context context, ViewGroup viewGroup) {
        a(context, viewGroup, null);
    }

    private void a(Context context, ViewGroup viewGroup, com.baidu.navisdk.ui.routeguide.subview.a aVar) {
        this.f9165a = context;
        this.b = viewGroup;
        this.c = aVar;
        this.e = com.baidu.navisdk.ui.util.b.b();
        this.f = x.b().e0();
        u.a(this);
    }

    @Override // com.baidu.navisdk.framework.interfaces.y
    public View[] B() {
        return null;
    }

    public boolean b(Bundle bundle) {
        this.d = true;
        return true;
    }

    public void c() {
        c(null);
    }

    public void d(Bundle bundle) {
    }

    public void e0() {
        com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.g) this.h, false);
    }

    public void f0() {
    }

    public String g0() {
        return RouteGuideFSM.getCurrentGlassState();
    }

    public void h() {
    }

    public com.baidu.navisdk.framework.interfaces.pronavi.hd.f h0() {
        return com.baidu.navisdk.ui.routeguide.utils.b.o();
    }

    public void i() {
        this.c = null;
        this.f9165a = null;
    }

    public void i0() {
    }

    public boolean j0() {
        if (this.f != 2) {
            return true;
        }
        return false;
    }

    public void k0() {
    }

    public void l0() {
    }

    public void m0() {
    }

    public void onResume() {
    }

    public int s(int i) {
        return com.baidu.navisdk.ui.util.b.a(i, this.e);
    }

    public Drawable t(int i) {
        return com.baidu.navisdk.ui.util.b.c(i, this.e);
    }

    public void u(int i) {
        com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.g) this.h, false);
        com.baidu.navisdk.util.worker.c.a().a(this.h, new com.baidu.navisdk.util.worker.e(2, 0), i);
    }

    public boolean y() {
        return b(null);
    }

    public void b(String str, Runnable runnable) {
        com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.f) new b(this, str, null, runnable), new com.baidu.navisdk.util.worker.e(2, 0));
    }

    public void c(Bundle bundle) {
        this.d = false;
    }

    public d(Context context, ViewGroup viewGroup, com.baidu.navisdk.ui.routeguide.subview.a aVar) {
        a(context, viewGroup, aVar);
    }

    public void a(com.baidu.navisdk.ui.routeguide.subview.a aVar) {
        this.c = aVar;
    }

    public void a(boolean z) {
        this.e = z;
    }

    public void a(ViewGroup viewGroup, int i) {
        this.b = viewGroup;
        this.f = i;
    }

    public boolean a() {
        return this.d;
    }

    public void a(String str, Runnable runnable) {
        com.baidu.navisdk.util.worker.c.a().c(new c(this, str, null, runnable), new com.baidu.navisdk.util.worker.e(2, 0));
    }

    public d(Context context, ViewGroup viewGroup, com.baidu.navisdk.ui.routeguide.subview.a aVar, int i) {
        a(context, viewGroup, aVar);
    }

    public void a(boolean z, View view) {
        x.b().a(true, !z, view);
    }

    public boolean a(String... strArr) {
        if (strArr == null) {
            return false;
        }
        String g0 = g0();
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(getClass().getName(), "isCurrentGlassState: " + g0);
        }
        if (TextUtils.isEmpty(g0)) {
            return false;
        }
        for (String str : strArr) {
            if (g0.equals(str)) {
                return true;
            }
        }
        return false;
    }
}
