package com.baidu.navisdk.util.task;

import com.baidu.navisdk.util.worker.f;

/* loaded from: classes8.dex */
public abstract class b<K, T> extends f<K, T> {

    /* renamed from: a, reason: collision with root package name */
    public int f9389a;
    private a b;

    /* loaded from: classes8.dex */
    public interface a {
        void a(b<?, ?> bVar);
    }

    public b(String str, K k, int i) {
        super(str, k);
        this.f9389a = i;
    }

    public abstract void a();

    public void a(a aVar) {
        this.b = aVar;
    }

    @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
    public T execute() {
        a();
        a aVar = this.b;
        if (aVar != null) {
            aVar.a(this);
            return null;
        }
        return null;
    }
}
