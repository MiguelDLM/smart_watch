package com.baidu.navisdk.poisearch.model;

import com.baidu.navisdk.model.datastruct.t;
import com.baidu.navisdk.util.common.LogUtil;

/* loaded from: classes7.dex */
public class a {
    private static a k;

    /* renamed from: a, reason: collision with root package name */
    private int f7636a = 0;
    private boolean b = false;
    public boolean c = false;
    private int d = -1;
    private String e = "";
    private String f = "";
    private int g = -1;
    private int h = -1;
    private int i = -1;
    public t j;

    public static a k() {
        if (k == null) {
            k = new a();
        }
        return k;
    }

    public void a(com.baidu.navisdk.poisearch.view.interfaces.a aVar) {
    }

    public String b() {
        return this.e;
    }

    public void c(int i) {
        this.d = i;
    }

    public void d(int i) {
        this.f7636a = i;
    }

    public int e() {
        return this.d;
    }

    public int f() {
        return this.f7636a;
    }

    public int g() {
        return this.i;
    }

    public boolean h() {
        return this.b;
    }

    public void i() {
        LogUtil.e("BNNearbySearchModel", "reset");
        this.b = false;
        this.c = false;
        this.d = -1;
        this.e = "";
        this.f = "";
        this.i = -1;
        this.g = -1;
        this.h = -1;
        this.j = null;
    }

    public void j() {
        this.d = -1;
    }

    public void a(boolean z) {
        this.b = z;
    }

    public void b(String str) {
        this.f = str;
    }

    public int c() {
        return this.g;
    }

    public String d() {
        return this.f;
    }

    public void e(int i) {
        this.i = i;
    }

    public void a(String str) {
        this.e = str;
    }

    public void b(int i) {
        this.g = i;
    }

    public int a() {
        return this.h;
    }

    public void a(int i) {
        this.h = i;
    }
}
