package com.baidu.platform.comapi.walknavi.e;

import XIXIX.OOXIXo;
import android.os.Handler;
import com.baidu.ar.npc.BaiduArView;
import com.baidu.platform.comapi.walknavi.e.g;
import java.io.File;

/* loaded from: classes8.dex */
public class e {
    private static Handler b = new Handler();
    private static final String c = e.class.getSimpleName();

    /* renamed from: a, reason: collision with root package name */
    final Runnable f9744a;
    private g d;

    /* loaded from: classes8.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        static final e f9745a = new e(null);
    }

    public /* synthetic */ e(f fVar) {
        this();
    }

    public static e c() {
        return a.f9745a;
    }

    public void b() {
        this.d.d();
    }

    public boolean d() {
        return this.d.e();
    }

    public void e() {
        if (this.d.e()) {
            this.d.f();
        }
    }

    public void f() {
        if (this.d.e()) {
            this.d.i();
        }
    }

    public void g() {
        if (this.d.e()) {
            this.d.g();
        }
    }

    public void h() {
        if (this.d.e()) {
            this.d.h();
        }
    }

    public void i() {
        if (this.d.e()) {
            this.d.j();
        }
    }

    public void j() {
        this.d.c(true);
        this.d.a(l.a(-90.0d), OOXIXo.f3760XO, OOXIXo.f3760XO, "mapNPC");
        this.d.c(false);
    }

    public boolean k() {
        return this.d.c();
    }

    public BaiduArView l() {
        return this.d.k();
    }

    public void m() {
        this.d.l();
    }

    public boolean n() {
        return this.d.m();
    }

    public boolean o() {
        return this.d.b();
    }

    private e() {
        this.f9744a = new f(this);
        this.d = new g();
    }

    public String a() {
        return this.d.a();
    }

    public void b(String str, String str2) {
        Runnable runnable;
        Handler handler = b;
        if (handler != null && (runnable = this.f9744a) != null) {
            handler.removeCallbacks(runnable);
        }
        this.d.a(str, str2);
        b.postDelayed(this.f9744a, 30000L);
    }

    public boolean c(String str) {
        return !c().e(c().d(str));
    }

    public String d(String str) {
        return this.d.c(str);
    }

    public void a(String str) {
        this.d.a(str);
    }

    public boolean e(String str) {
        try {
            return new File(str).exists();
        } catch (Exception unused) {
            return false;
        }
    }

    public void a(b bVar) {
        this.d.a(bVar);
    }

    public void c(boolean z) {
        this.d.a(z);
    }

    public void a(String str, c cVar) {
        this.d.a(str, cVar);
    }

    public void a(String str, String str2) {
        Runnable runnable;
        Handler handler = b;
        if (handler != null && (runnable = this.f9744a) != null) {
            handler.removeCallbacks(runnable);
        }
        this.d.a(str, str2);
    }

    public boolean b(String str) {
        return this.d.b(str);
    }

    public void b(boolean z) {
        this.d.b(z);
    }

    public void b(String str, c cVar) {
        this.d.b(str, cVar);
    }

    public void a(boolean z) {
        this.d.c(z);
    }

    public void a(double d, double d2, double d3) {
        this.d.a(d, d2, d3, "mapNPC");
    }

    public boolean a(String str, boolean z) {
        return this.d.a(str, z);
    }

    public void a(g.a aVar) {
        com.baidu.platform.comapi.wnplatform.d.a.a(c, "setNpcManagerStatusListener:" + aVar);
        this.d.a(aVar);
    }
}
