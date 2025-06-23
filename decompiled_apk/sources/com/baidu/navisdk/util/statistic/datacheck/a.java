package com.baidu.navisdk.util.statistic.datacheck;

import com.baidu.navisdk.module.statistics.b;
import java.util.ArrayList;

/* loaded from: classes8.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static a f9371a;
    private static Object b = new Object();

    private a() {
        new ArrayList();
    }

    public boolean a(b bVar) {
        return false;
    }

    public static a a() {
        if (f9371a == null) {
            synchronized (b) {
                try {
                    if (f9371a == null) {
                        f9371a = new a();
                    }
                } finally {
                }
            }
        }
        return f9371a;
    }
}
