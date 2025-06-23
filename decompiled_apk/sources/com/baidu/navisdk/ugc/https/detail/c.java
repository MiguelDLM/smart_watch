package com.baidu.navisdk.ugc.https.detail;

/* loaded from: classes8.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private String f8190a;
    private String b;
    private int c;
    private String d;
    private int e;
    private int f;

    /* loaded from: classes8.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private String f8191a;
        private String b;
        private int c;
        private String d;
        private int e;
        private int f;

        private a() {
        }

        public static a b() {
            return new a();
        }

        public a a(String str) {
            this.d = str;
            return this;
        }

        public a c(String str) {
            this.b = str;
            return this;
        }

        public a a(int i) {
            this.e = i;
            return this;
        }

        public a b(String str) {
            this.f8191a = str;
            return this;
        }

        public a c(int i) {
            this.c = i;
            return this;
        }

        public c a() {
            c cVar = new c();
            cVar.d = this.d;
            cVar.e = this.e;
            cVar.c = this.c;
            cVar.b = this.b;
            cVar.f8190a = this.f8191a;
            cVar.f = this.f;
            return cVar;
        }

        public a b(int i) {
            this.f = i;
            return this;
        }
    }

    public String d() {
        return this.f8190a;
    }

    public int e() {
        return this.c;
    }

    public String f() {
        return this.b;
    }

    public int a() {
        return this.e;
    }

    public int b() {
        return this.f;
    }

    public String c() {
        return this.d;
    }
}
