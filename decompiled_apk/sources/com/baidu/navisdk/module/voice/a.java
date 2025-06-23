package com.baidu.navisdk.module.voice;

import android.text.TextUtils;

/* loaded from: classes7.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private String f7620a = null;
    private String b = null;
    private String c = null;
    private String d = null;
    private String e = null;
    private String f = null;
    private int g = 5000;
    private int h = 1;
    private String i;
    private String j;

    public void a(int i) {
        this.g = i;
    }

    public void b(int i) {
        this.h = i;
    }

    public void c(String str) {
        this.f7620a = str;
    }

    public void d(String str) {
        this.b = str;
    }

    public String e() {
        return this.f7620a;
    }

    public String f() {
        return this.b;
    }

    public String g() {
        return this.c;
    }

    public void h(String str) {
        this.e = str;
    }

    public int i() {
        return this.h;
    }

    public String j() {
        return this.d;
    }

    public String k() {
        return this.e;
    }

    public void a(String str) {
        this.i = str;
    }

    public String b() {
        return this.i;
    }

    public String c() {
        return this.j;
    }

    public int d() {
        return this.g;
    }

    public void e(String str) {
        this.c = str;
    }

    public void f(String str) {
        this.f = str;
    }

    public void g(String str) {
        this.d = str;
    }

    public String h() {
        return this.f;
    }

    public boolean a() {
        return (TextUtils.isEmpty(e()) || TextUtils.isEmpty(f()) || TextUtils.isEmpty(g()) || TextUtils.isEmpty(j()) || TextUtils.isEmpty(k()) || TextUtils.isEmpty(h())) ? false : true;
    }

    public void b(String str) {
        this.j = str;
    }
}
