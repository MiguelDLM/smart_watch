package com.baidu.platform.comjni.map.basemap;

import android.os.Bundle;
import com.google.android.exoplayer2.ExoPlayer;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class q implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ long f9997a;
    final /* synthetic */ long b;
    final /* synthetic */ boolean c;
    final /* synthetic */ Bundle d;
    final /* synthetic */ NABaseMap e;

    public q(NABaseMap nABaseMap, long j, long j2, boolean z, Bundle bundle) {
        this.e = nABaseMap;
        this.f9997a = j;
        this.b = j2;
        this.c = z;
        this.d = bundle;
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
            readWriteLock3 = this.e.d;
            z = readWriteLock3.readLock().tryLock(ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS, TimeUnit.MILLISECONDS);
            if (z) {
                a2 = this.e.a(this.f9997a);
                if (!a2) {
                    NABaseMap nABaseMap = this.e;
                    j = nABaseMap.b;
                    nABaseMap.nativeSetFocus(j, this.f9997a, this.b, this.c, this.d);
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
                readWriteLock = this.e.d;
                readWriteLock.readLock().unlock();
            }
            throw th;
        }
        readWriteLock2 = this.e.d;
        readWriteLock2.readLock().unlock();
    }
}
