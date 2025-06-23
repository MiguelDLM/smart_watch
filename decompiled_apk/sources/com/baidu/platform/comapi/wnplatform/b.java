package com.baidu.platform.comapi.wnplatform;

import com.baidu.ar.marker.model.Segments;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f9893a;

    public b(a aVar) {
        this.f9893a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        List<Segments> list;
        a a2 = a.a();
        list = this.f9893a.k;
        a2.a(list, "runVIOIMU");
    }
}
