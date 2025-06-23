package com.baidu.navisdk.ui.routeguide.model;

/* loaded from: classes8.dex */
public class c0 {

    /* renamed from: a, reason: collision with root package name */
    public int f8933a;
    public int b;
    public int c;

    public boolean a() {
        if (this.f8933a > 0 && this.b > 0) {
            return true;
        }
        return false;
    }

    public void b() {
        this.b = 0;
        this.f8933a = 0;
        this.c = 0;
    }

    public String toString() {
        return "RGViaPointEtaModel{viaRemainDistance=" + this.f8933a + ", viaRemainTime=" + this.b + ", viaTrafficLight=" + this.c + '}';
    }
}
