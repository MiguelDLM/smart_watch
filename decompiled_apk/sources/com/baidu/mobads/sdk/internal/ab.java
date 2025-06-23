package com.baidu.mobads.sdk.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class ab implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ aa f6216a;

    public ab(aa aaVar) {
        this.f6216a = aaVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f6216a.a("加载dex超过5秒");
    }
}
