package com.baidu.location.b;

import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class p extends Thread {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ n f5655a;

    public p(n nVar) {
        this.f5655a = nVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        this.f5655a.a(new File(com.baidu.location.e.o.h() + "/baidu/tempdata", "intime.dat"), "https://itsdata.map.baidu.com/long-conn-gps/sdk.php");
    }
}
