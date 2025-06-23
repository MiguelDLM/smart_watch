package com.baidu.location.c.a;

import com.baidu.location.c.k;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f5686a;

    public b(a aVar) {
        this.f5686a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Object obj;
        Object obj2;
        try {
            this.f5686a.f();
            obj = this.f5686a.H;
            synchronized (obj) {
                try {
                    obj2 = this.f5686a.H;
                    obj2.notifyAll();
                    if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d) {
                        k.h().a("update mCellInfo completed");
                    }
                } finally {
                }
            }
        } catch (Exception e) {
            if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d) {
                k.h().a("handleCellInfo error = " + e);
            }
        }
    }
}
