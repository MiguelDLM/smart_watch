package com.baidu.platform.comjni.map.basemap;

import android.os.Bundle;
import com.google.android.exoplayer2.ExoPlayer;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class r implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Bundle f9998a;
    final /* synthetic */ boolean b;
    final /* synthetic */ NABaseMap c;

    public r(NABaseMap nABaseMap, Bundle bundle, boolean z) {
        this.c = nABaseMap;
        this.f9998a = bundle;
        this.b = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        ReadWriteLock readWriteLock;
        ReadWriteLock readWriteLock2;
        ReadWriteLock readWriteLock3;
        long j;
        boolean a2;
        ReadWriteLock readWriteLock4;
        boolean z = false;
        try {
            readWriteLock3 = this.c.d;
            z = readWriteLock3.readLock().tryLock(ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS, TimeUnit.MILLISECONDS);
            if (z) {
                Bundle bundle = this.f9998a;
                if (bundle != null) {
                    a2 = this.c.a(bundle.getLong("itemaddr", 0L));
                    if (a2) {
                        if (z) {
                            readWriteLock4 = this.c.d;
                            readWriteLock4.readLock().unlock();
                            return;
                        }
                        return;
                    }
                }
                NABaseMap nABaseMap = this.c;
                j = nABaseMap.b;
                nABaseMap.nativeAddItemData(j, this.f9998a, this.b);
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
