package com.baidu.platform.comapi.walknavi.e.a.a;

import java.io.Serializable;

/* loaded from: classes8.dex */
public class b implements Serializable {
    private String b;
    private String c;
    private String d;
    private String[] e;
    private String f;
    private String g;
    private int h;
    private String i;
    private String l;
    private String m;

    /* renamed from: a, reason: collision with root package name */
    private int f9715a = Integer.MIN_VALUE;
    private boolean j = false;
    private boolean k = true;

    public void a(int i) {
        this.f9715a = i;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    public String d() {
        return this.d;
    }

    public void e(String str) {
        this.g = str;
    }

    public void f(String str) {
        this.i = str;
    }

    public boolean g() {
        return this.k;
    }

    public String h() {
        return this.m;
    }

    public String toString() {
        return "ARResource [ err_code = " + this.f9715a + ", err_msg = " + this.b + ", , version_code = " + this.g + ", ar_resource = " + this.d + " ]";
    }

    public int a() {
        return this.f9715a;
    }

    public void b(String str) {
        this.c = str;
    }

    public void c(String str) {
        this.d = str;
    }

    public void d(String str) {
        this.f = str;
    }

    public int e() {
        return this.h;
    }

    public boolean f() {
        return this.j;
    }

    public void g(String str) {
        this.l = str;
    }

    public void h(String str) {
        this.m = str;
    }

    public void a(String str) {
        this.b = str;
    }

    public void b(int i) {
        this.h = i;
    }

    public void a(String[] strArr) {
        this.e = strArr;
    }

    public void b(boolean z) {
        this.k = z;
    }

    public void a(boolean z) {
        this.j = z;
    }
}
