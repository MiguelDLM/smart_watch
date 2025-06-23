package com.baidu.platform.comjni.map.basemap;

import com.google.android.exoplayer2.ExoPlayer;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class l implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ long f9992a;
    final /* synthetic */ NABaseMap b;

    public l(NABaseMap nABaseMap, long j) {
        this.b = nABaseMap;
        this.f9992a = j;
    }

    @Override // java.lang.Runnable
    public void run() {
        ReadWriteLock readWriteLock;
        ReadWriteLock readWriteLock2;
        ReadWriteLock readWriteLock3;
        boolean a2;
        long j;
        boolean z = false;
        try {
            readWriteLock3 = this.b.d;
            z = readWriteLock3.readLock().tryLock(ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS, TimeUnit.MILLISECONDS);
            if (z) {
                a2 = this.b.a(this.f9992a);
                if (!a2) {
                    NABaseMap nABaseMap = this.b;
                    j = nABaseMap.b;
                    nABaseMap.nativeUpdateLayers(j, this.f9992a);
                }
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
