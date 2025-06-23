package com.baidu.tts;

import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes8.dex */
public class e2 {
    public static volatile e2 d;

    /* renamed from: a, reason: collision with root package name */
    public ConcurrentHashMap<String, d2> f10079a = new ConcurrentHashMap<>();
    public ConcurrentHashMap<String, c2> b = new ConcurrentHashMap<>();
    public ConcurrentHashMap<String, b2> c = new ConcurrentHashMap<>();

    public static e2 a() {
        if (d == null) {
            synchronized (e2.class) {
                try {
                    if (d == null) {
                        d = new e2();
                    }
                } finally {
                }
            }
        }
        return d;
    }

    public c2 b(String str) {
        try {
            c2 c2Var = new c2(str);
            c2 putIfAbsent = this.b.putIfAbsent(str, c2Var);
            if (putIfAbsent != null) {
                return putIfAbsent;
            }
            return c2Var;
        } catch (Exception unused) {
            return null;
        }
    }

    public b2 a(String str) {
        try {
            b2 b2Var = new b2(str);
            b2 putIfAbsent = this.c.putIfAbsent(str, b2Var);
            return putIfAbsent == null ? b2Var : putIfAbsent;
        } catch (Exception unused) {
            return null;
        }
    }
}
