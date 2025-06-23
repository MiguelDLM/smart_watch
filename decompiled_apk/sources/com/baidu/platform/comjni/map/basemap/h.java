package com.baidu.platform.comjni.map.basemap;

import android.os.Bundle;
import com.google.android.exoplayer2.ExoPlayer;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class h implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Bundle[] f9988a;
    final /* synthetic */ NABaseMap b;

    public h(NABaseMap nABaseMap, Bundle[] bundleArr) {
        this.b = nABaseMap;
        this.f9988a = bundleArr;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean b;
        Throwable th;
        boolean z;
        ReadWriteLock readWriteLock;
        ReadWriteLock readWriteLock2;
        ReadWriteLock readWriteLock3;
        boolean z2;
        long j;
        b = this.b.b();
        if (!b) {
            return;
        }
        int i = 0;
        try {
            readWriteLock3 = this.b.d;
            z = readWriteLock3.readLock().tryLock(ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS, TimeUnit.MILLISECONDS);
            if (z) {
                try {
                    Bundle[] bundleArr = this.f9988a;
                    int length = bundleArr.length;
                    while (i < length) {
                        Bundle bundle = bundleArr[i];
                        z2 = this.b.c;
                        if (z2) {
                            break;
                        }
                        NABaseMap nABaseMap = this.b;
                        j = nABaseMap.b;
                        nABaseMap.nativeRemoveOneOverlayItem(j, bundle);
                        i++;
                    }
                } catch (Exception unused) {
                    i = z ? 1 : 0;
                    if (i == 0) {
                        return;
                    }
                    readWriteLock2 = this.b.d;
                    readWriteLock2.readLock().unlock();
                } catch (Throwable th2) {
                    th = th2;
                    if (z) {
                        readWriteLock = this.b.d;
                        readWriteLock.readLock().unlock();
                    }
                    throw th;
                }
            }
            if (!z) {
                return;
            }
        } catch (Exception unused2) {
        } catch (Throwable th3) {
            th = th3;
            z = false;
        }
        readWriteLock2 = this.b.d;
        readWriteLock2.readLock().unlock();
    }
}
