package com.baidu.navisdk.module.init;

import android.text.TextUtils;
import com.baidu.navisdk.debug.d;
import com.baidu.navisdk.framework.b;
import com.baidu.navisdk.util.http.center.j;
import com.baidu.navisdk.util.worker.d;
import com.baidu.navisdk.util.worker.loop.e;

/* loaded from: classes7.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public final String f7189a;
    public final String b;
    public final String c;
    public final String d;
    public final com.baidu.navisdk.framework.interfaces.b e;
    public final e f;
    public final d g;
    public final j h;
    public final b.a i;
    public final com.baidu.navisdk.module.page.b j;
    private final com.baidu.navisdk.framework.interfaces.walk.a k;
    public final String l;
    public final String m;
    public final int n;
    public d.f o;

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private String f7190a;
        private String b;
        private String c;
        private String d;
        private com.baidu.navisdk.framework.interfaces.b e;
        private e f;
        private com.baidu.navisdk.util.worker.d g;
        private j h;
        private b.a i;
        private com.baidu.navisdk.module.page.b j;
        private String k;
        private String l;
        private com.baidu.navisdk.framework.interfaces.voice.a m;
        private com.baidu.navisdk.framework.interfaces.walk.a n;
        private int o = -1;
        public d.f p;

        public a a(String str) {
            this.f7190a = str;
            return this;
        }

        public a b(String str) {
            this.b = str;
            return this;
        }

        public a c(String str) {
            this.d = str;
            return this;
        }

        public a d(String str) {
            this.c = str;
            return this;
        }

        public a a(com.baidu.navisdk.framework.interfaces.b bVar) {
            this.e = bVar;
            return this;
        }

        public a a(e eVar) {
            this.f = eVar;
            return this;
        }

        public a a(com.baidu.navisdk.util.worker.d dVar) {
            this.g = dVar;
            return this;
        }

        public a a(j jVar) {
            this.h = jVar;
            return this;
        }

        public a a(b.a aVar) {
            this.i = aVar;
            return this;
        }

        public c a() {
            return new c(this.f7190a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.o, this.p, this.m, this.n);
        }
    }

    public c(String str, String str2, String str3, String str4, com.baidu.navisdk.framework.interfaces.b bVar, e eVar, com.baidu.navisdk.util.worker.d dVar, j jVar, b.a aVar, com.baidu.navisdk.module.page.b bVar2, String str5, String str6, int i, d.f fVar, com.baidu.navisdk.framework.interfaces.voice.a aVar2, com.baidu.navisdk.framework.interfaces.walk.a aVar3) {
        this.f7189a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = bVar;
        this.f = eVar;
        this.g = dVar;
        this.h = jVar;
        this.i = aVar;
        this.j = bVar2;
        this.l = str5;
        this.m = str6;
        this.n = i;
        this.o = fVar;
        this.k = aVar3;
    }

    public boolean a() {
        if (!TextUtils.isEmpty(this.f7189a) && !TextUtils.isEmpty(this.b) && !TextUtils.isEmpty(this.c) && !TextUtils.isEmpty(this.d) && this.e != null && this.f != null && this.g != null && this.h != null && this.i != null) {
            return true;
        }
        return false;
    }

    public com.baidu.navisdk.framework.interfaces.walk.a b() {
        return this.k;
    }
}
