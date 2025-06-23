package com.baidu.navisdk.util.worker;

/* loaded from: classes8.dex */
public abstract class b<K, T> extends g<K, T> {

    /* loaded from: classes8.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f9392a;

        public a(Object obj) {
            this.f9392a = obj;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            b.this.callback(this.f9392a);
        }
    }

    public b(String str, K k) {
        super(str, k);
    }

    public abstract void callback(T t);

    public boolean notifyOnMainThread() {
        return false;
    }

    @Override // com.baidu.navisdk.util.worker.g
    public final void notifyResult(T t) {
        if (notifyOnMainThread()) {
            new com.baidu.navisdk.util.worker.loop.a().post(new a(t));
        } else {
            callback(t);
        }
    }
}
