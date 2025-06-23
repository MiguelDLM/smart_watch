package com.baidu.navisdk.util.navimageloader;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import com.baidu.navisdk.embed.R;

/* loaded from: classes8.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private final int f9342a;
    private final int b;
    private final boolean c;
    private final boolean d;
    private final boolean e;
    private final boolean f;
    private final com.baidu.navisdk.util.navimageloader.a g;

    /* renamed from: com.baidu.navisdk.util.navimageloader.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0502b {

        /* renamed from: a, reason: collision with root package name */
        private int f9343a = R.drawable.nsdk_ugc_default_pic;
        private int b = -1;
        private boolean c = true;
        private boolean d = true;
        private com.baidu.navisdk.util.navimageloader.a e = c.d().a();
        private Handler f = null;
        private boolean g = false;
        private boolean h = false;

        public C0502b a(int i) {
            this.b = i;
            return this;
        }

        public C0502b b(int i) {
            this.f9343a = i;
            return this;
        }

        public b a() {
            return new b(this);
        }
    }

    public com.baidu.navisdk.util.navimageloader.a a() {
        return this.g;
    }

    public Drawable b() {
        return com.baidu.navisdk.ui.util.b.f(this.b);
    }

    public Drawable c() {
        return com.baidu.navisdk.ui.util.b.f(this.f9342a);
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

    private b(C0502b c0502b) {
        this.f9342a = c0502b.f9343a;
        this.b = c0502b.b;
        this.c = c0502b.c;
        this.d = c0502b.d;
        Handler unused = c0502b.f;
        this.f = c0502b.g;
        this.g = c0502b.e;
        this.e = c0502b.h;
    }
}
