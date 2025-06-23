package com.baidu.navisdk.comapi.ugc;

import XIXIX.OOXIXo;

/* loaded from: classes7.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public double f6758a;
    public double b;
    public double c;
    public double d;

    public boolean a() {
        if (this.f6758a > OOXIXo.f3760XO && this.b > OOXIXo.f3760XO && this.c > OOXIXo.f3760XO && this.d > OOXIXo.f3760XO) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "Bound{top=" + this.f6758a + ", bottom=" + this.b + ", left=" + this.c + ", right=" + this.d + '}';
    }
}
