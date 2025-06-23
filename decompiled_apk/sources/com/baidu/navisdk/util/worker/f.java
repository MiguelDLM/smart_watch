package com.baidu.navisdk.util.worker;

/* loaded from: classes8.dex */
public abstract class f<K, T> extends g<K, T> {
    public f(String str, K k) {
        super(str, k);
    }

    @Override // com.baidu.navisdk.util.worker.g
    public abstract T execute();

    @Override // com.baidu.navisdk.util.worker.g
    public final void notifyResult(T t) {
    }

    public f(String str, K[] kArr, boolean z) {
        super(str, (Object[]) kArr);
    }
}
