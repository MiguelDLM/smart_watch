package com.baidu.navisdk;

/* loaded from: classes7.dex */
public enum m {
    INVALID(Integer.MIN_VALUE),
    UI(3001),
    UI_DATA(3002),
    BRULE(3003);


    /* renamed from: a, reason: collision with root package name */
    private int f6896a;

    m(int i) {
        this.f6896a = i;
    }

    public int a() {
        return this.f6896a;
    }

    public static m a(int i) {
        for (m mVar : values()) {
            if (mVar.a() == i) {
                return mVar;
            }
        }
        return INVALID;
    }
}
