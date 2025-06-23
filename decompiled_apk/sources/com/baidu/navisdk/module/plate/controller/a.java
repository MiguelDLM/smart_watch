package com.baidu.navisdk.module.plate.controller;

import android.view.View;

/* loaded from: classes7.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private b f7393a;

    /* loaded from: classes7.dex */
    public interface b {
        void a();

        void a(int i);

        void a(View view);

        void a(boolean z);

        void b();

        void b(int i);

        void b(String str);

        void d();
    }

    /* loaded from: classes7.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        private static final a f7394a = new a();
    }

    public static a e() {
        return c.f7394a;
    }

    public void a(b bVar) {
        if (bVar != null) {
            this.f7393a = bVar;
        }
    }

    public void b(int i) {
        b bVar = this.f7393a;
        if (bVar != null) {
            bVar.a(i);
        }
    }

    public void c() {
        this.f7393a = null;
    }

    public void d() {
        b bVar = this.f7393a;
        if (bVar != null) {
            bVar.a();
        }
    }

    private a() {
    }

    public void a(View view) {
        b bVar = this.f7393a;
        if (bVar != null) {
            bVar.a(view);
        }
    }

    public void b() {
        b bVar = this.f7393a;
        if (bVar != null) {
            bVar.d();
        }
    }

    public void a(String str) {
        b bVar = this.f7393a;
        if (bVar != null) {
            bVar.b(str);
        }
    }

    public void a(boolean z) {
        b bVar = this.f7393a;
        if (bVar != null) {
            bVar.a(z);
        }
    }

    public void a() {
        b bVar = this.f7393a;
        if (bVar != null) {
            bVar.b();
        }
    }

    public void a(int i) {
        b bVar = this.f7393a;
        if (bVar != null) {
            bVar.b(i);
        }
    }
}
