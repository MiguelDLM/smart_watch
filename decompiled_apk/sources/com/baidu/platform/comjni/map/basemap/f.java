package com.baidu.platform.comjni.map.basemap;

import android.os.Bundle;
import com.google.android.exoplayer2.ExoPlayer;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Bundle f9986a;
    final /* synthetic */ NABaseMap b;

    public f(NABaseMap nABaseMap, Bundle bundle) {
        this.b = nABaseMap;
        this.f9986a = bundle;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean b;
        ReadWriteLock readWriteLock;
        ReadWriteLock readWriteLock2;
        ReadWriteLock readWriteLock3;
        long j;
        b = this.b.b();
        if (!b) {
            return;
        }
        boolean z = false;
        try {
            readWriteLock3 = this.b.d;
            z = readWriteLock3.readLock().tryLock(ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS, TimeUnit.MILLISECONDS);
            if (z) {
                NABaseMap nABaseMap = this.b;
                j = nABaseMap.b;
                nABaseMap.nativeUpdateOneOverlayItem(j, this.f9986a);
            }
            if (!z) {
                return;
            }
        } catch (Exception unused) {
            if (!z) {
                return;
            }
        } catch (Throwable th) {
            if (z) {
                readWriteLock = this.b.d;
                readWriteLock.readLock().unlock();
            }
            throw th;
        }
        readWriteLock2 = this.b.d;
        readWriteLock2.readLock().unlock();
    }
}
