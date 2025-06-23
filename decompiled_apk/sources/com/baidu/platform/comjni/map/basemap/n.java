package com.baidu.platform.comjni.map.basemap;

import com.google.android.exoplayer2.ExoPlayer;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class n implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ long f9994a;
    final /* synthetic */ long b;
    final /* synthetic */ NABaseMap c;

    public n(NABaseMap nABaseMap, long j, long j2) {
        this.c = nABaseMap;
        this.f9994a = j;
        this.b = j2;
    }

    @Override // java.lang.Runnable
    public void run() {
        ReadWriteLock readWriteLock;
        ReadWriteLock readWriteLock2;
        ReadWriteLock readWriteLock3;
        boolean a2;
        boolean a3;
        long j;
        boolean z = false;
        try {
            readWriteLock3 = this.c.d;
            z = readWriteLock3.readLock().tryLock(ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS, TimeUnit.MILLISECONDS);
            if (z) {
                a2 = this.c.a(this.f9994a);
                if (!a2) {
                    a3 = this.c.a(this.b);
                    if (!a3) {
                        NABaseMap nABaseMap = this.c;
                        j = nABaseMap.b;
                        nABaseMap.nativeSwitchLayer(j, this.f9994a, this.b);
                    }
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
