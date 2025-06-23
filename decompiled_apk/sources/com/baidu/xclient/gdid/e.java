package com.baidu.xclient.gdid;

/* loaded from: classes8.dex */
public class e implements Runnable {
    public e(c cVar) {
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            h.a().a(c.b);
        } catch (Throwable th) {
            com.baidu.xclient.gdid.e.d.a(th);
        }
    }
}
