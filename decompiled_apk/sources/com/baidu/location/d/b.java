package com.baidu.location.d;

import android.util.Log;
import java.lang.ref.WeakReference;

/* loaded from: classes7.dex */
class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ WeakReference f5718a;
    final /* synthetic */ a b;

    public b(a aVar, WeakReference weakReference) {
        this.b = aVar;
        this.f5718a = weakReference;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        a aVar = (a) this.f5718a.get();
        if (aVar != null) {
            i = aVar.h;
            if (i == 3) {
                Log.d("baidu_location_service", "baidu location service force stopped ...");
                aVar.i = false;
                aVar.b();
            }
        }
    }
}
