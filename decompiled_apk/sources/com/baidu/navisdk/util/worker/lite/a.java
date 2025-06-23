package com.baidu.navisdk.util.worker.lite;

import com.baidu.navisdk.util.worker.c;
import com.baidu.navisdk.util.worker.e;
import com.baidu.navisdk.util.worker.f;
import com.baidu.navisdk.util.worker.g;

/* loaded from: classes8.dex */
public class a {
    public static void a(b bVar, long j) {
        c.a().a(bVar, a(10000), j);
    }

    public static void b(b bVar) {
        a(bVar, 10001);
    }

    public static void c(b bVar) {
        c.a().a((f) bVar, a(10000));
    }

    public static void b(b bVar, int i) {
        c.a().b(bVar, a(i));
    }

    public static void a(b bVar, int i) {
        e a2 = a(i);
        if (i == 10000) {
            c.a().a((f) bVar, a2);
        } else {
            c.a().c(bVar, a2);
        }
    }

    public static void a(b bVar, int i, long j) {
        e a2 = a(i);
        if (i == 10000) {
            c.a().a(bVar, a2, j);
        } else {
            c.a().b(bVar, a2, j);
        }
    }

    public static void a(b bVar) {
        c.a().a((g) bVar, false);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0001. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:11:0x001d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static com.baidu.navisdk.util.worker.e a(int r2) {
        /*
            r0 = 0
            switch(r2) {
                case 10000: goto L25;
                case 10001: goto L1d;
                case 10002: goto L25;
                case 10003: goto L15;
                default: goto L4;
            }
        L4:
            switch(r2) {
                case 20000: goto L1d;
                case 20001: goto L25;
                case 20002: goto Ld;
                default: goto L7;
            }
        L7:
            com.baidu.navisdk.util.worker.e r1 = new com.baidu.navisdk.util.worker.e
            r1.<init>(r2, r0)
            return r1
        Ld:
            com.baidu.navisdk.util.worker.e r2 = new com.baidu.navisdk.util.worker.e
            r1 = 101(0x65, float:1.42E-43)
            r2.<init>(r1, r0)
            return r2
        L15:
            com.baidu.navisdk.util.worker.e r2 = new com.baidu.navisdk.util.worker.e
            r1 = 203(0xcb, float:2.84E-43)
            r2.<init>(r1, r0)
            return r2
        L1d:
            com.baidu.navisdk.util.worker.e r2 = new com.baidu.navisdk.util.worker.e
            r1 = 199(0xc7, float:2.79E-43)
            r2.<init>(r1, r0)
            return r2
        L25:
            com.baidu.navisdk.util.worker.e r2 = new com.baidu.navisdk.util.worker.e
            r1 = 99
            r2.<init>(r1, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.util.worker.lite.a.a(int):com.baidu.navisdk.util.worker.e");
    }
}
