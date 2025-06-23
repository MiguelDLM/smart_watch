package com.baidu.navisdk.cmdrequest;

/* loaded from: classes7.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public int f6693a;
    public String b;
    public String c;
    public Object d;

    public f() {
        b();
    }

    public boolean a() {
        return this.f6693a == 0;
    }

    public void b() {
        this.f6693a = -10000;
        this.b = "";
        this.c = "";
        this.d = null;
    }

    public void c() {
        this.f6693a = 0;
    }

    public String toString() {
        return "CommandResult{mErrCode=" + this.f6693a + ", mErrDebug='" + this.b + "', mErrForUser='" + this.c + "', mUserObject=" + this.d + '}';
    }

    public void a(int i, String str, String str2) {
        this.f6693a = i;
        if (str == null) {
            str = "";
        }
        this.b = str;
        if (str2 == null) {
            str2 = "";
        }
        this.c = str2;
    }

    public f(int i) {
        this();
        a(i);
    }

    public void a(int i, String str) {
        a(i, str, null);
    }

    public void b(int i) {
        a(i + 5000, null, null);
    }

    public void a(int i) {
        a(i, null, null);
    }
}
