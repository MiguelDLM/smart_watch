package com.baidu.navisdk.module.ar.jni;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.graphics.Bitmap;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes7.dex */
public final class JNIBNArService implements com.baidu.navisdk.module.ar.jni.a {

    /* renamed from: a, reason: collision with root package name */
    private long f6989a;
    private final ReadWriteLock b = new ReentrantReadWriteLock(true);

    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(IIXOooo iIXOooo) {
            this();
        }
    }

    static {
        new a(null);
        System.loadLibrary("Native");
    }

    public JNIBNArService() {
        b();
    }

    public boolean a(@oOoXoXO String str) {
        long j = this.f6989a;
        if (j == 0) {
            return false;
        }
        return nativeInit(j, str);
    }

    public boolean b() {
        try {
            this.b.writeLock().lock();
            long nativeCreate = nativeCreate();
            this.f6989a = nativeCreate;
            return nativeCreate == 0;
        } finally {
            this.b.writeLock().unlock();
        }
    }

    public boolean c() {
        boolean z;
        try {
            this.b.writeLock().lock();
            long j = this.f6989a;
            if (j == 0) {
                z = false;
            } else {
                nativeRelease(j);
                this.f6989a = 0L;
                z = true;
            }
            return z;
        } finally {
            this.b.writeLock().unlock();
        }
    }

    public final native long nativeCreate();

    public final native boolean nativeDeInitProcessor(long j, int i);

    public final native boolean nativeDrawFrame(long j);

    public final native boolean nativeInit(long j, @oOoXoXO String str);

    public final native boolean nativeInitNaMsg(long j, @OOXIXo Object obj);

    public final native boolean nativeInitProcessor(long j, int i);

    public final native boolean nativeProcessBitmap(long j, @OOXIXo Bitmap bitmap, int i, @oOoXoXO String str);

    public final native boolean nativeProcessYuv(long j, @OOXIXo byte[] bArr, int i, int i2, int i3, int i4);

    public final native boolean nativeRelease(long j);

    public final native boolean nativeSetCameraConfig(long j, float f, float f2);

    public final native boolean nativeSetCloudData(long j, @OOXIXo String str);

    public final native boolean nativeSurfaceChanged(long j, int i, int i2);

    public final native boolean nativeSurfaceCreated(long j, int i, int i2, float f);

    public final native boolean nativeUpdateGuideInfo(long j, int i, int i2, int i3);

    public final native boolean nativeUpdateLaneInfo(long j, @OOXIXo boolean[] zArr);

    public final native boolean nativeUpdateLocation(long j, double d, double d2, float f);

    public boolean a(float f, float f2) {
        long j = this.f6989a;
        if (j == 0) {
            return false;
        }
        return nativeSetCameraConfig(j, f, f2);
    }

    public boolean b(@OOXIXo String cloudData) {
        IIX0o.x0xO0oo(cloudData, "cloudData");
        long j = this.f6989a;
        if (j == 0) {
            return false;
        }
        return nativeSetCloudData(j, cloudData);
    }

    public boolean a(int i) {
        long j = this.f6989a;
        if (j == 0) {
            return false;
        }
        return nativeDeInitProcessor(j, i);
    }

    public boolean b(int i) {
        long j = this.f6989a;
        if (j == 0) {
            return false;
        }
        return nativeInitProcessor(j, i);
    }

    public boolean a(@OOXIXo Bitmap bitmap, int i, @oOoXoXO String str) {
        IIX0o.x0xO0oo(bitmap, "bitmap");
        try {
            this.b.readLock().lock();
            long j = this.f6989a;
            return j == 0 ? false : nativeProcessBitmap(j, bitmap, i, str);
        } finally {
            this.b.readLock().unlock();
        }
    }

    public boolean a(@OOXIXo byte[] yuv420sp, int i, int i2, int i3, int i4) {
        IIX0o.x0xO0oo(yuv420sp, "yuv420sp");
        try {
            this.b.readLock().lock();
            long j = this.f6989a;
            return j == 0 ? false : nativeProcessYuv(j, yuv420sp, i, i2, i3, i4);
        } finally {
            this.b.readLock().unlock();
        }
    }

    @Override // com.baidu.navisdk.module.ar.jni.a
    public boolean a(int i, int i2, float f) {
        try {
            this.b.readLock().lock();
            long j = this.f6989a;
            return j == 0 ? false : nativeSurfaceCreated(j, i, i2, f);
        } finally {
            this.b.readLock().unlock();
        }
    }

    @Override // com.baidu.navisdk.module.ar.jni.a
    public boolean a(int i, int i2) {
        try {
            this.b.readLock().lock();
            long j = this.f6989a;
            return j == 0 ? false : nativeSurfaceChanged(j, i, i2);
        } finally {
            this.b.readLock().unlock();
        }
    }

    @Override // com.baidu.navisdk.module.ar.jni.a
    public boolean a() {
        try {
            this.b.readLock().lock();
            long j = this.f6989a;
            return j == 0 ? false : nativeDrawFrame(j);
        } finally {
            this.b.readLock().unlock();
        }
    }

    public boolean a(int i, int i2, int i3) {
        try {
            this.b.readLock().lock();
            long j = this.f6989a;
            return j == 0 ? false : nativeUpdateGuideInfo(j, i, i2, i3);
        } finally {
            this.b.readLock().unlock();
        }
    }

    public boolean a(double d, double d2, float f) {
        try {
            this.b.readLock().lock();
            long j = this.f6989a;
            return j == 0 ? false : nativeUpdateLocation(j, d, d2, f);
        } finally {
            this.b.readLock().unlock();
        }
    }

    public boolean a(@OOXIXo boolean[] lanes) {
        IIX0o.x0xO0oo(lanes, "lanes");
        try {
            this.b.readLock().lock();
            long j = this.f6989a;
            return j == 0 ? false : nativeUpdateLaneInfo(j, lanes);
        } finally {
            this.b.readLock().unlock();
        }
    }

    public boolean a(@OOXIXo Object mNaMsgCenter) {
        IIX0o.x0xO0oo(mNaMsgCenter, "mNaMsgCenter");
        long j = this.f6989a;
        if (j == 0) {
            return false;
        }
        return nativeInitNaMsg(j, mNaMsgCenter);
    }
}
