package com.baidu.platform.comapi.map;

/* loaded from: classes8.dex */
public class ap {

    /* renamed from: a, reason: collision with root package name */
    private int f9635a;
    private int b;
    private int c;
    private int d;

    public static int c(int i) {
        return ((i & 16711680) >> 16) | ((-16777216) & i) | ((i & 255) << 16) | (65280 & i);
    }

    public ap a(int i) {
        this.f9635a = i;
        return this;
    }

    public ap b(int i) {
        this.b = i;
        return this;
    }

    public int d() {
        return this.c;
    }

    public String toString() {
        return "Style: color:" + Integer.toHexString(this.f9635a) + " width:" + this.b + " fillcolor:" + Integer.toHexString(this.c);
    }

    public int a() {
        return this.d;
    }

    public int b() {
        return this.f9635a;
    }

    public int c() {
        return this.b;
    }
}
