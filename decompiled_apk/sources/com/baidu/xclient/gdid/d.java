package com.baidu.xclient.gdid;

/* loaded from: classes8.dex */
public class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f10229a;

    public d(c cVar) {
        this.f10229a = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f10229a.g();
            this.f10229a.a(true, true);
        } catch (Throwable th) {
            com.baidu.xclient.gdid.e.d.a(th);
        }
    }
}
