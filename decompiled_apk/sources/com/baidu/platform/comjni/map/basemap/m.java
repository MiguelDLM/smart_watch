package com.baidu.platform.comjni.map.basemap;

import com.google.android.exoplayer2.ExoPlayer;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class m implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ long f9993a;
    final /* synthetic */ NABaseMap b;

    public m(NABaseMap nABaseMap, long j) {
        this.b = nABaseMap;
        this.f9993a = j;
    }

    @Override // java.lang.Runnable
    public void run() {
        ReadWriteLock readWriteLock;
        ReadWriteLock readWriteLock2;
        ReadWriteLock readWriteLock3;
        Set set;
        long j;
        boolean z = false;
        try {
            readWriteLock3 = this.b.d;
            z = readWriteLock3.writeLock().tryLock(ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS, TimeUnit.MILLISECONDS);
            if (z) {
                set = this.b.e;
                set.add(Long.valueOf(this.f9993a));
                NABaseMap nABaseMap = this.b;
                j = nABaseMap.b;
                nABaseMap.nativeRemoveLayer(j, this.f9993a);
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
                readWriteLock.writeLock().unlock();
            }
            throw th;
        }
        readWriteLock2 = this.b.d;
        readWriteLock2.writeLock().unlock();
    }
}
