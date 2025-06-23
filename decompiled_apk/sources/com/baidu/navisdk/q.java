package com.baidu.navisdk;

/* loaded from: classes7.dex */
public class q {
    public static com.baidu.navisdk.function.f a(int i) {
        return a(i, 1);
    }

    public static com.baidu.navisdk.function.f a(int i, int i2) {
        if (com.baidu.navisdk.framework.b.e(i) instanceof com.baidu.navisdk.function.f) {
            return (com.baidu.navisdk.function.f) com.baidu.navisdk.framework.b.e(i);
        }
        if (i2 == 7 && i == 1) {
            return new com.baidu.navisdk.function.h();
        }
        if (i2 == 2 && i == 1) {
            return new com.baidu.navisdk.function.e();
        }
        if (i2 == 3 && i == 1) {
            return new com.baidu.navisdk.function.i();
        }
        if (i2 == 6) {
            return new com.baidu.navisdk.function.d();
        }
        if (i == 2) {
            return new com.baidu.navisdk.function.g();
        }
        if (i == 3) {
            return new com.baidu.navisdk.function.j();
        }
        return new com.baidu.navisdk.function.a();
    }
}
