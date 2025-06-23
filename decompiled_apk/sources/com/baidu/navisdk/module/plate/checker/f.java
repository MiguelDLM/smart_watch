package com.baidu.navisdk.module.plate.checker;

/* loaded from: classes7.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private String f7391a;
    private String b;
    private String c;
    private int d;

    public final String a() {
        return this.f7391a;
    }

    public void b(String str) {
        this.c = str;
    }

    public void c(String str) {
        this.b = str;
    }

    public String toString() {
        return "PlateCheckRet{desc='" + this.f7391a + "', plate='" + this.b + "', fullPlate='" + this.c + "', errorCode=" + this.d + '}';
    }

    public void a(String str) {
        this.f7391a = str;
    }

    public int b() {
        return this.d;
    }

    public void a(int i) {
        this.d = i;
    }
}
