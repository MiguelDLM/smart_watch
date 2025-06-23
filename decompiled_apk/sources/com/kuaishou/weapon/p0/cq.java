package com.kuaishou.weapon.p0;

import android.os.Build;

/* loaded from: classes11.dex */
public class cq {

    /* renamed from: a, reason: collision with root package name */
    static cq f18361a;
    static cq b;
    static cq c;
    private long d;
    private a e;

    /* loaded from: classes11.dex */
    public enum a {
        DWORD(4),
        QWORD(8);

        int c;

        a(int i) {
            this.c = i;
        }
    }

    static {
        c();
    }

    private static void c() {
        f18361a = new cq();
        b = new cq();
        c = new cq();
        cq cqVar = b;
        a aVar = a.DWORD;
        cqVar.a(aVar);
        int i = Build.VERSION.SDK_INT;
        if (cr.a()) {
            cq cqVar2 = f18361a;
            a aVar2 = a.QWORD;
            cqVar2.a(aVar2);
            c.a(aVar2);
            switch (i) {
                case 21:
                    f18361a.a(40L);
                    f18361a.a(aVar2);
                    c.a(32L);
                    c.a(aVar2);
                    b.a(56L);
                    return;
                case 22:
                    f18361a.a(52L);
                    c.a(44L);
                    b.a(20L);
                    return;
                case 23:
                    f18361a.a(48L);
                    c.a(40L);
                    b.a(12L);
                    return;
                case 24:
                case 25:
                    f18361a.a(48L);
                    c.a(40L);
                    b.a(4L);
                    return;
                case 26:
                case 27:
                    f18361a.a(40L);
                    c.a(32L);
                    b.a(4L);
                    return;
                case 28:
                case 29:
                    f18361a.a(32L);
                    c.a(24L);
                    b.a(4L);
                    return;
                default:
                    throw new RuntimeException("API LEVEL: " + i + " is not supported now : (");
            }
        }
        f18361a.a(aVar);
        c.a(aVar);
        switch (i) {
            case 21:
                f18361a.a(40L);
                cq cqVar3 = f18361a;
                a aVar3 = a.QWORD;
                cqVar3.a(aVar3);
                c.a(32L);
                c.a(aVar3);
                b.a(56L);
                return;
            case 22:
                f18361a.a(44L);
                c.a(40L);
                b.a(20L);
                return;
            case 23:
                f18361a.a(36L);
                c.a(32L);
                b.a(12L);
                return;
            case 24:
            case 25:
                f18361a.a(32L);
                c.a(28L);
                b.a(4L);
                return;
            case 26:
            case 27:
                f18361a.a(28L);
                c.a(24L);
                b.a(4L);
                return;
            case 28:
            case 29:
                f18361a.a(24L);
                c.a(20L);
                b.a(4L);
                return;
            default:
                throw new RuntimeException("API LEVEL: " + i + " is not supported now : (");
        }
    }

    public long a() {
        return this.d;
    }

    public a b() {
        return this.e;
    }

    public void a(long j) {
        this.d = j;
    }

    public void a(a aVar) {
        this.e = aVar;
    }
}
