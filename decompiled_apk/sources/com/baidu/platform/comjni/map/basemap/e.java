package com.baidu.platform.comjni.map.basemap;

import android.os.Bundle;
import com.google.android.exoplayer2.ExoPlayer;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Bundle[] f9985a;
    final /* synthetic */ int b;
    final /* synthetic */ NABaseMap c;

    public e(NABaseMap nABaseMap, Bundle[] bundleArr, int i) {
        this.c = nABaseMap;
        this.f9985a = bundleArr;
        this.b = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean b;
        ReadWriteLock readWriteLock;
        ReadWriteLock readWriteLock2;
        ReadWriteLock readWriteLock3;
        long j;
        b = this.c.b();
        if (!b) {
            return;
        }
        boolean z = false;
        try {
            readWriteLock3 = this.c.d;
            z = readWriteLock3.readLock().tryLock(ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS, TimeUnit.MILLISECONDS);
            if (z) {
                NABaseMap nABaseMap = this.c;
                j = nABaseMap.b;
                nABaseMap.nativeAddOverlayItems(j, this.f9985a, this.b);
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
                readWriteLock = this.c.d;
                readWriteLock.readLock().unlock();
            }
            throw th;
        }
        readWriteLock2 = this.c.d;
        readWriteLock2.readLock().unlock();
    }
}
