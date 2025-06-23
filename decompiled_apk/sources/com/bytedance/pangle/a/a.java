package com.bytedance.pangle.a;

import com.bytedance.pangle.d.e;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes8.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    final CountDownLatch f10513a;
    Throwable b;

    /* renamed from: com.bytedance.pangle.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0555a {
        void a();
    }

    private a(InterfaceC0555a[] interfaceC0555aArr) {
        this.f10513a = new CountDownLatch(interfaceC0555aArr.length);
        for (final InterfaceC0555a interfaceC0555a : interfaceC0555aArr) {
            e.a(new Runnable() { // from class: com.bytedance.pangle.a.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        interfaceC0555a.a();
                    } catch (Throwable th) {
                        a.this.b = th;
                    }
                    a.this.f10513a.countDown();
                }
            });
        }
    }

    public static void a(InterfaceC0555a... interfaceC0555aArr) {
        a aVar = new a(interfaceC0555aArr);
        try {
            aVar.f10513a.await();
            Throwable th = aVar.b;
            if (th == null) {
            } else {
                throw th;
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
