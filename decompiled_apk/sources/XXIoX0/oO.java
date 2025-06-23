package XXIoX0;

import XO0OX.o00;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nWorkQueue.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WorkQueue.kt\nkotlinx/coroutines/scheduling/WorkQueue\n+ 2 Tasks.kt\nkotlinx/coroutines/scheduling/TasksKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 WorkQueue.kt\nkotlinx/coroutines/scheduling/WorkQueueKt\n*L\n1#1,255:1\n93#2:256\n93#2:257\n93#2:258\n93#2:261\n93#2:262\n1#3:259\n25#4:260\n*S KotlinDebug\n*F\n+ 1 WorkQueue.kt\nkotlinx/coroutines/scheduling/WorkQueue\n*L\n95#1:256\n162#1:257\n185#1:258\n205#1:261\n249#1:262\n205#1:260\n*E\n"})
/* loaded from: classes6.dex */
public final class oO {

    @o00
    private volatile int blockingTasksInBuffer;

    @o00
    private volatile int consumerIndex;

    @OXOo.oOoXoXO
    @o00
    private volatile Object lastScheduledTask;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public final AtomicReferenceArray<xxIXOIIO> f4059oIX0oI = new AtomicReferenceArray<>(128);

    @o00
    private volatile int producerIndex;

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final AtomicReferenceFieldUpdater f4056II0xO0 = AtomicReferenceFieldUpdater.newUpdater(oO.class, Object.class, "lastScheduledTask");

    /* renamed from: I0Io, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final AtomicIntegerFieldUpdater f4055I0Io = AtomicIntegerFieldUpdater.newUpdater(oO.class, "producerIndex");

    /* renamed from: oxoX, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final AtomicIntegerFieldUpdater f4058oxoX = AtomicIntegerFieldUpdater.newUpdater(oO.class, "consumerIndex");

    /* renamed from: X0o0xo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final AtomicIntegerFieldUpdater f4057X0o0xo = AtomicIntegerFieldUpdater.newUpdater(oO.class, "blockingTasksInBuffer");

    public static /* synthetic */ xxIXOIIO II0xO0(oO oOVar, xxIXOIIO xxixoiio, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return oOVar.oIX0oI(xxixoiio, z);
    }

    public final xxIXOIIO I0Io(xxIXOIIO xxixoiio) {
        if (X0o0xo() == 127) {
            return xxixoiio;
        }
        if (xxixoiio.f4080Oo.oI0IIXIo() == 1) {
            f4057X0o0xo.incrementAndGet(this);
        }
        int i = f4055I0Io.get(this) & 127;
        while (this.f4059oIX0oI.get(i) != null) {
            Thread.yield();
        }
        this.f4059oIX0oI.lazySet(i, xxixoiio);
        f4055I0Io.incrementAndGet(this);
        return null;
    }

    @OXOo.oOoXoXO
    public final xxIXOIIO II0XooXoX() {
        xxIXOIIO xxixoiio = (xxIXOIIO) f4056II0xO0.getAndSet(this, null);
        if (xxixoiio == null) {
            return xoIox();
        }
        return xxixoiio;
    }

    @OXOo.oOoXoXO
    public final xxIXOIIO OOXIXo() {
        return ooOOo0oXI(false);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.Object, XXIoX0.xxIXOIIO] */
    public final long Oo(int i, Ref.ObjectRef<xxIXOIIO> objectRef) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        ?? r1;
        do {
            atomicReferenceFieldUpdater = f4056II0xO0;
            r1 = (xxIXOIIO) atomicReferenceFieldUpdater.get(this);
            if (r1 == 0) {
                return -2L;
            }
            int i2 = 1;
            if (r1.f4080Oo.oI0IIXIo() != 1) {
                i2 = 2;
            }
            if ((i2 & i) == 0) {
                return -2L;
            }
            long oIX0oI2 = ooOOo0oXI.f4066XO.oIX0oI() - r1.f4081XO;
            long j = ooOOo0oXI.f4063II0xO0;
            if (oIX0oI2 < j) {
                return j - oIX0oI2;
            }
        } while (!androidx.concurrent.futures.oIX0oI.oIX0oI(atomicReferenceFieldUpdater, this, r1, null));
        objectRef.element = r1;
        return -1L;
    }

    public final void Oxx0IOOO(@OXOo.OOXIXo oxoX oxox) {
        xxIXOIIO xxixoiio = (xxIXOIIO) f4056II0xO0.getAndSet(this, null);
        if (xxixoiio != null) {
            oxox.oIX0oI(xxixoiio);
        }
        do {
        } while (oOoXoXO(oxox));
    }

    public final int X0o0xo() {
        return f4055I0Io.get(this) - f4058oxoX.get(this);
    }

    public final int XO() {
        if (f4056II0xO0.get(this) != null) {
            return X0o0xo() + 1;
        }
        return X0o0xo();
    }

    @OXOo.oOoXoXO
    public final xxIXOIIO oIX0oI(@OXOo.OOXIXo xxIXOIIO xxixoiio, boolean z) {
        if (z) {
            return I0Io(xxixoiio);
        }
        xxIXOIIO xxixoiio2 = (xxIXOIIO) f4056II0xO0.getAndSet(this, xxixoiio);
        if (xxixoiio2 == null) {
            return null;
        }
        return I0Io(xxixoiio2);
    }

    public final xxIXOIIO oO(int i, boolean z) {
        int i2 = i & 127;
        xxIXOIIO xxixoiio = this.f4059oIX0oI.get(i2);
        if (xxixoiio != null) {
            boolean z2 = true;
            if (xxixoiio.f4080Oo.oI0IIXIo() != 1) {
                z2 = false;
            }
            if (z2 == z && com.google.common.util.concurrent.oxoX.oIX0oI(this.f4059oIX0oI, i2, xxixoiio, null)) {
                if (z) {
                    f4057X0o0xo.decrementAndGet(this);
                }
                return xxixoiio;
            }
        }
        return null;
    }

    public final boolean oOoXoXO(oxoX oxox) {
        xxIXOIIO xoIox2 = xoIox();
        if (xoIox2 == null) {
            return false;
        }
        oxox.oIX0oI(xoIox2);
        return true;
    }

    public final xxIXOIIO ooOOo0oXI(boolean z) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        xxIXOIIO xxixoiio;
        do {
            atomicReferenceFieldUpdater = f4056II0xO0;
            xxixoiio = (xxIXOIIO) atomicReferenceFieldUpdater.get(this);
            if (xxixoiio != null) {
                boolean z2 = true;
                if (xxixoiio.f4080Oo.oI0IIXIo() != 1) {
                    z2 = false;
                }
                if (z2 == z) {
                }
            }
            int i = f4058oxoX.get(this);
            int i2 = f4055I0Io.get(this);
            while (i != i2) {
                if (z && f4057X0o0xo.get(this) == 0) {
                    return null;
                }
                i2--;
                xxIXOIIO oO2 = oO(i2, z);
                if (oO2 != null) {
                    return oO2;
                }
            }
            return null;
        } while (!androidx.concurrent.futures.oIX0oI.oIX0oI(atomicReferenceFieldUpdater, this, xxixoiio, null));
        return xxixoiio;
    }

    public final void oxoX(xxIXOIIO xxixoiio) {
        if (xxixoiio != null && xxixoiio.f4080Oo.oI0IIXIo() == 1) {
            f4057X0o0xo.decrementAndGet(this);
        }
    }

    public final xxIXOIIO x0XOIxOo(int i) {
        int i2 = f4058oxoX.get(this);
        int i3 = f4055I0Io.get(this);
        boolean z = true;
        if (i != 1) {
            z = false;
        }
        while (i2 != i3) {
            if (z && f4057X0o0xo.get(this) == 0) {
                return null;
            }
            int i4 = i2 + 1;
            xxIXOIIO oO2 = oO(i2, z);
            if (oO2 == null) {
                i2 = i4;
            } else {
                return oO2;
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final long x0xO0oo(int i, @OXOo.OOXIXo Ref.ObjectRef<xxIXOIIO> objectRef) {
        T t;
        if (i == 3) {
            t = xoIox();
        } else {
            t = x0XOIxOo(i);
        }
        if (t != 0) {
            objectRef.element = t;
            return -1L;
        }
        return Oo(i, objectRef);
    }

    public final xxIXOIIO xoIox() {
        xxIXOIIO andSet;
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f4058oxoX;
            int i = atomicIntegerFieldUpdater.get(this);
            if (i - f4055I0Io.get(this) == 0) {
                return null;
            }
            int i2 = i & 127;
            if (atomicIntegerFieldUpdater.compareAndSet(this, i, i + 1) && (andSet = this.f4059oIX0oI.getAndSet(i2, null)) != null) {
                oxoX(andSet);
                return andSet;
            }
        }
    }

    @OXOo.oOoXoXO
    public final xxIXOIIO xxIXOIIO() {
        return ooOOo0oXI(true);
    }
}
