package com.baidu.platform.comjni.map.basemap;

import com.google.android.exoplayer2.ExoPlayer;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class k implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ long f9991a;
    final /* synthetic */ boolean b;
    final /* synthetic */ NABaseMap c;

    public k(NABaseMap nABaseMap, long j, boolean z) {
        this.c = nABaseMap;
        this.f9991a = j;
        this.b = z;
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
            readWriteLock3 = this.c.d;
            z = readWriteLock3.readLock().tryLock(ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS, TimeUnit.MILLISECONDS);
            if (z) {
                a2 = this.c.a(this.f9991a);
                if (!a2) {
                    NABaseMap nABaseMap = this.c;
                    j = nABaseMap.b;
                    nABaseMap.nativeSetLayersClickable(j, this.f9991a, this.b);
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
