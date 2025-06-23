package com.baidu.navisdk.widget.naviimageloader;

import android.graphics.drawable.Drawable;
import android.os.Handler;

/* loaded from: classes8.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private final int f9411a;
    private final int b;
    private final boolean c;
    private final boolean d;
    private final boolean e;
    private final boolean f;
    private final com.baidu.navisdk.widget.naviimageloader.a g;

    /* renamed from: com.baidu.navisdk.widget.naviimageloader.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0513b {

        /* renamed from: a, reason: collision with root package name */
        private int f9412a = 0;
        private int b = -1;
        private boolean c = true;
        private boolean d = true;
        private com.baidu.navisdk.widget.naviimageloader.a e = c.d().a();
        private Handler f = null;
        private boolean g = false;
        private boolean h = false;

        public C0513b a(int i) {
            this.f9412a = i;
            return this;
        }

        public b a() {
            return new b(this);
        }
    }

    public com.baidu.navisdk.widget.naviimageloader.a a() {
        return this.g;
    }

    public Drawable b() {
        return com.baidu.navisdk.ui.util.b.f(this.b);
    }

    public Drawable c() {
        return com.baidu.navisdk.ui.util.b.f(this.f9411a);
    }

    public boolean d() {
        return this.c;
    }

    public boolean e() {
        return this.d;
    }

    public boolean f() {
        return this.e;
    }

    public boolean g() {
        return this.f;
    }

    private b(C0513b c0513b) {
        this.f9411a = c0513b.f9412a;
        this.b = c0513b.b;
        this.c = c0513b.c;
        this.d = c0513b.d;
        Handler unused = c0513b.f;
        this.f = c0513b.g;
        this.g = c0513b.e;
        this.e = c0513b.h;
    }
}
