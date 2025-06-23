package com.baidu.platform.comapi.bmsdk;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ long f9582a;
    final /* synthetic */ BmObject b;

    public c(BmObject bmObject, long j) {
        this.b = bmObject;
        this.f9582a = j;
    }

    @Override // java.lang.Runnable
    public void run() {
        BmObject.nativeFinalizer(this.f9582a);
    }
}
