package com.baidu.tts;

/* loaded from: classes8.dex */
public class g4 {
    public static final String d = "g4";
    public static g4 e;

    /* renamed from: a, reason: collision with root package name */
    public int f10097a = 0;
    public int b = 0;
    public boolean c = false;

    public static g4 a() {
        if (e == null) {
            synchronized (g4.class) {
                try {
                    if (e == null) {
                        e = new g4();
                    }
                } finally {
                }
            }
        }
        return e;
    }

    public int b() {
        if (!this.c) {
            return 0;
        }
        int i = this.f10097a;
        if (i == 1) {
            return 10;
        }
        if (i == 9) {
            return 11;
        }
        int i2 = this.b;
        if (i2 != 1 && i2 != 2 && i2 != 4 && i2 != 7 && i2 != 11) {
            if (i2 != 3 && i2 != 5 && i2 != 6 && i2 != 8 && i2 != 9 && i2 != 10 && i2 != 12 && i2 != 14 && i2 != 15) {
                if (i2 == 13) {
                    return 4;
                }
                if (i2 != 20) {
                    return 0;
                }
                return 5;
            }
            return 3;
        }
        return 2;
    }
}
