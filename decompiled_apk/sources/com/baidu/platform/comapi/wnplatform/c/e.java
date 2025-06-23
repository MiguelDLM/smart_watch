package com.baidu.platform.comapi.wnplatform.c;

import android.location.GpsStatus;
import android.os.SystemClock;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class e implements GpsStatus.Listener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ d f9899a;

    public e(d dVar) {
        this.f9899a = dVar;
    }

    @Override // android.location.GpsStatus.Listener
    public void onGpsStatusChanged(int i) {
        int i2;
        this.f9899a.o = i;
        i2 = this.f9899a.o;
        if (i2 == 4) {
            this.f9899a.n = SystemClock.elapsedRealtime();
        }
    }
}
