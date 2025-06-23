package com.baidu.platform.comjni.map.basemap;

import com.google.android.exoplayer2.ExoPlayer;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class i implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f9989a;
    final /* synthetic */ String b;
    final /* synthetic */ NABaseMap c;

    public i(NABaseMap nABaseMap, String str, String str2) {
        this.c = nABaseMap;
        this.f9989a = str;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean b;
        ReadWriteLock readWriteLock;
        ReadWriteLock readWriteLock2;
        ReadWriteLock readWriteLock3;
        long j;
        long j2;
        b = this.c.b();
        if (!b) {
            return;
        }
        boolean z = false;
        try {
            readWriteLock3 = this.c.d;
            z = readWriteLock3.readLock().tryLock(ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS, TimeUnit.MILLISECONDS);
            if (z) {
                j = this.c.b;
                if (j != 0) {
                    NABaseMap nABaseMap = this.c;
                    j2 = nABaseMap.b;
                    nABaseMap.nativeInitCustomStyle(j2, this.f9989a, this.b);
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
                readWriteLock = this.c.d;
                readWriteLock.readLock().unlock();
            }
            throw th;
        }
        readWriteLock2 = this.c.d;
        readWriteLock2.readLock().unlock();
    }
}
