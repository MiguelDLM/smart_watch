package com.baidu.tts;

/* loaded from: classes8.dex */
public class i0 {

    /* renamed from: a, reason: collision with root package name */
    public static volatile i0 f10106a;

    public static i0 b() {
        if (f10106a == null) {
            synchronized (i0.class) {
                try {
                    if (f10106a == null) {
                        f10106a = new i0();
                    }
                } finally {
                }
            }
        }
        return f10106a;
    }

    public s0 a() {
        return new t0();
    }
}
