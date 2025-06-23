package com.baidu.platform.comjni.map.basemap;

import com.google.android.exoplayer2.ExoPlayer;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class j implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ boolean f9990a;
    final /* synthetic */ NABaseMap b;

    public j(NABaseMap nABaseMap, boolean z) {
        this.b = nABaseMap;
        this.f9990a = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean b;
        ReadWriteLock readWriteLock;
        ReadWriteLock readWriteLock2;
        ReadWriteLock readWriteLock3;
        long j;
        long j2;
        b = this.b.b();
        if (!b) {
            return;
        }
        boolean z = false;
        try {
            readWriteLock3 = this.b.d;
            z = readWriteLock3.readLock().tryLock(ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS, TimeUnit.MILLISECONDS);
            if (z) {
                j = this.b.b;
                if (j != 0) {
                    NABaseMap nABaseMap = this.b;
                    j2 = nABaseMap.b;
                    nABaseMap.nativeSetCustomStyleEnable(j2, this.f9990a);
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
