package com.baidu.location.e;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class j implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f5741a;
    final /* synthetic */ g b;

    public j(g gVar, String str) {
        this.b = gVar;
        this.f5741a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.a(this.f5741a);
    }
}
