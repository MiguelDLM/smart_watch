package com.baidu.platform.comjni.map.basemap;

import android.os.Bundle;
import com.google.android.exoplayer2.ExoPlayer;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Bundle f9983a;
    final /* synthetic */ NABaseMap b;

    public c(NABaseMap nABaseMap, Bundle bundle) {
        this.b = nABaseMap;
        this.f9983a = bundle;
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
            readWriteLock3 = this.b.d;
            z = readWriteLock3.readLock().tryLock(ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS, TimeUnit.MILLISECONDS);
            if (z) {
                Bundle bundle = this.f9983a;
                if (bundle != null) {
                    a2 = this.b.a(bundle.getLong("itemaddr", 0L));
                    if (a2) {
                        if (z) {
                            readWriteLock4 = this.b.d;
                            readWriteLock4.readLock().unlock();
                            return;
                        }
                        return;
                    }
                }
                NABaseMap nABaseMap = this.b;
                j = nABaseMap.b;
                nABaseMap.nativeRemoveItemData(j, this.f9983a);
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
