package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.DeprecationLevel;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.XoX;

@kotlin.jvm.internal.XX({"SMAP\nEventLoop.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EventLoop.common.kt\nkotlinx/coroutines/EventLoopImplBase\n+ 2 ThreadSafeHeap.kt\nkotlinx/coroutines/internal/ThreadSafeHeap\n+ 3 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 4 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n+ 5 EventLoop.kt\nkotlinx/coroutines/EventLoopKt\n+ 6 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,543:1\n60#2:544\n61#2,7:550\n28#3,4:545\n20#4:549\n56#5:557\n1#6:558\n*S KotlinDebug\n*F\n+ 1 EventLoop.common.kt\nkotlinx/coroutines/EventLoopImplBase\n*L\n269#1:544\n269#1:550,7\n269#1:545,4\n269#1:549\n280#1:557\n*E\n"})
/* loaded from: classes6.dex */
public abstract class OO0x0xX extends XIo0oOXIx implements XoX {

    @OXOo.oOoXoXO
    @XO0OX.o00
    private volatile Object _delayed;

    @XO0OX.o00
    private volatile int _isCompleted = 0;

    @OXOo.oOoXoXO
    @XO0OX.o00
    private volatile Object _queue;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final AtomicReferenceFieldUpdater f29736Oxx0xo = AtomicReferenceFieldUpdater.newUpdater(OO0x0xX.class, Object.class, "_queue");

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final AtomicReferenceFieldUpdater f29738oI0IIXIo = AtomicReferenceFieldUpdater.newUpdater(OO0x0xX.class, Object.class, "_delayed");

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final AtomicIntegerFieldUpdater f29737OxxIIOOXO = AtomicIntegerFieldUpdater.newUpdater(OO0x0xX.class, "_isCompleted");

    @kotlin.jvm.internal.XX({"SMAP\nEventLoop.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EventLoop.common.kt\nkotlinx/coroutines/EventLoopImplBase$DelayedTask\n+ 2 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 3 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n+ 4 ThreadSafeHeap.kt\nkotlinx/coroutines/internal/ThreadSafeHeap\n*L\n1#1,543:1\n28#2,4:544\n28#2,4:550\n28#2,4:562\n20#3:548\n20#3:554\n20#3:566\n72#4:549\n73#4,7:555\n*S KotlinDebug\n*F\n+ 1 EventLoop.common.kt\nkotlinx/coroutines/EventLoopImplBase$DelayedTask\n*L\n437#1:544,4\n439#1:550,4\n479#1:562,4\n437#1:548\n439#1:554\n479#1:566\n439#1:549\n439#1:555,7\n*E\n"})
    /* loaded from: classes6.dex */
    public static abstract class I0Io implements Runnable, Comparable<I0Io>, I0oOIX, kotlinx.coroutines.internal.xXOx {

        /* renamed from: Oo, reason: collision with root package name */
        public int f29739Oo = -1;

        /* renamed from: XO, reason: collision with root package name */
        @XO0OX.XO
        public long f29740XO;

        @OXOo.oOoXoXO
        private volatile Object _heap;

        public I0Io(long j) {
            this.f29740XO = j;
        }

        @Override // kotlinx.coroutines.internal.xXOx
        public int I0Io() {
            return this.f29739Oo;
        }

        @Override // kotlinx.coroutines.internal.xXOx
        public void II0XooXoX(int i) {
            this.f29739Oo = i;
        }

        public final int OOXIXo(long j, @OXOo.OOXIXo oxoX oxox, @OXOo.OOXIXo OO0x0xX oO0x0xX) {
            kotlinx.coroutines.internal.x0o x0oVar;
            synchronized (this) {
                Object obj = this._heap;
                x0oVar = xxIO.f30499oIX0oI;
                if (obj == x0oVar) {
                    return 2;
                }
                synchronized (oxox) {
                    try {
                        I0Io XO2 = oxox.XO();
                        if (oO0x0xX.isCompleted()) {
                            return 1;
                        }
                        if (XO2 == null) {
                            oxox.f29744I0Io = j;
                        } else {
                            long j2 = XO2.f29740XO;
                            if (j2 - j < 0) {
                                j = j2;
                            }
                            if (j - oxox.f29744I0Io > 0) {
                                oxox.f29744I0Io = j;
                            }
                        }
                        long j3 = this.f29740XO;
                        long j4 = oxox.f29744I0Io;
                        if (j3 - j4 < 0) {
                            this.f29740XO = j4;
                        }
                        oxox.oIX0oI(this);
                        return 0;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }

        @Override // kotlinx.coroutines.internal.xXOx
        @OXOo.oOoXoXO
        public kotlinx.coroutines.internal.xo0x<?> Oxx0IOOO() {
            Object obj = this._heap;
            if (obj instanceof kotlinx.coroutines.internal.xo0x) {
                return (kotlinx.coroutines.internal.xo0x) obj;
            }
            return null;
        }

        @Override // kotlinx.coroutines.I0oOIX
        public final void dispose() {
            kotlinx.coroutines.internal.x0o x0oVar;
            oxoX oxox;
            kotlinx.coroutines.internal.x0o x0oVar2;
            synchronized (this) {
                try {
                    Object obj = this._heap;
                    x0oVar = xxIO.f30499oIX0oI;
                    if (obj == x0oVar) {
                        return;
                    }
                    if (obj instanceof oxoX) {
                        oxox = (oxoX) obj;
                    } else {
                        oxox = null;
                    }
                    if (oxox != null) {
                        oxox.OOXIXo(this);
                    }
                    x0oVar2 = xxIO.f30499oIX0oI;
                    this._heap = x0oVar2;
                    kotlin.oXIO0o0XI oxio0o0xi = kotlin.oXIO0o0XI.f29392oIX0oI;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final boolean oOoXoXO(long j) {
            if (j - this.f29740XO >= 0) {
                return true;
            }
            return false;
        }

        @Override // kotlinx.coroutines.internal.xXOx
        public void oxoX(@OXOo.oOoXoXO kotlinx.coroutines.internal.xo0x<?> xo0xVar) {
            kotlinx.coroutines.internal.x0o x0oVar;
            Object obj = this._heap;
            x0oVar = xxIO.f30499oIX0oI;
            if (obj != x0oVar) {
                this._heap = xo0xVar;
                return;
            }
            throw new IllegalArgumentException("Failed requirement.");
        }

        @OXOo.OOXIXo
        public String toString() {
            return "Delayed[nanos=" + this.f29740XO + ']';
        }

        @Override // java.lang.Comparable
        /* renamed from: xoIox, reason: merged with bridge method [inline-methods] */
        public int compareTo(@OXOo.OOXIXo I0Io i0Io) {
            long j = this.f29740XO - i0Io.f29740XO;
            if (j > 0) {
                return 1;
            }
            if (j < 0) {
                return -1;
            }
            return 0;
        }
    }

    /* loaded from: classes6.dex */
    public static final class II0xO0 extends I0Io {

        /* renamed from: IXxxXO, reason: collision with root package name */
        @OXOo.OOXIXo
        public final Runnable f29741IXxxXO;

        public II0xO0(long j, @OXOo.OOXIXo Runnable runnable) {
            super(j);
            this.f29741IXxxXO = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f29741IXxxXO.run();
        }

        @Override // kotlinx.coroutines.OO0x0xX.I0Io
        @OXOo.OOXIXo
        public String toString() {
            return super.toString() + this.f29741IXxxXO;
        }
    }

    @kotlin.jvm.internal.XX({"SMAP\nEventLoop.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EventLoop.common.kt\nkotlinx/coroutines/EventLoopImplBase$DelayedResumeTask\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,543:1\n1#2:544\n*E\n"})
    /* loaded from: classes6.dex */
    public final class oIX0oI extends I0Io {

        /* renamed from: IXxxXO, reason: collision with root package name */
        @OXOo.OOXIXo
        public final oO<kotlin.oXIO0o0XI> f29742IXxxXO;

        /* JADX WARN: Multi-variable type inference failed */
        public oIX0oI(long j, @OXOo.OOXIXo oO<? super kotlin.oXIO0o0XI> oOVar) {
            super(j);
            this.f29742IXxxXO = oOVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f29742IXxxXO.X00IoxXI(OO0x0xX.this, kotlin.oXIO0o0XI.f29392oIX0oI);
        }

        @Override // kotlinx.coroutines.OO0x0xX.I0Io
        @OXOo.OOXIXo
        public String toString() {
            return super.toString() + this.f29742IXxxXO;
        }
    }

    /* loaded from: classes6.dex */
    public static final class oxoX extends kotlinx.coroutines.internal.xo0x<I0Io> {

        /* renamed from: I0Io, reason: collision with root package name */
        @XO0OX.XO
        public long f29744I0Io;

        public oxoX(long j) {
            this.f29744I0Io = j;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isCompleted() {
        if (f29737OxxIIOOXO.get(this) != 0) {
            return true;
        }
        return false;
    }

    private final void oxXx0IX(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Oox.oOoXoXO<Object, kotlin.oXIO0o0XI> oooxoxo, Object obj) {
        while (true) {
            oooxoxo.invoke(atomicReferenceFieldUpdater.get(obj));
        }
    }

    public final int I0X0x0oIo(long j, I0Io i0Io) {
        if (isCompleted()) {
            return 1;
        }
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f29738oI0IIXIo;
        oxoX oxox = (oxoX) atomicReferenceFieldUpdater.get(this);
        if (oxox == null) {
            androidx.concurrent.futures.oIX0oI.oIX0oI(atomicReferenceFieldUpdater, this, null, new oxoX(j));
            Object obj = atomicReferenceFieldUpdater.get(this);
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(obj);
            oxox = (oxoX) obj;
        }
        return i0Io.OOXIXo(j, oxox, this);
    }

    public final Runnable I0oOoX() {
        kotlinx.coroutines.internal.x0o x0oVar;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f29736Oxx0xo;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                return null;
            }
            if (!(obj instanceof kotlinx.coroutines.internal.O0xOxO)) {
                x0oVar = xxIO.f30494II0XooXoX;
                if (obj == x0oVar) {
                    return null;
                }
                if (androidx.concurrent.futures.oIX0oI.oIX0oI(f29736Oxx0xo, this, obj, null)) {
                    kotlin.jvm.internal.IIX0o.x0XOIxOo(obj, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
                    return (Runnable) obj;
                }
            } else {
                kotlin.jvm.internal.IIX0o.x0XOIxOo(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }>{ kotlinx.coroutines.EventLoop_commonKt.Queue<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }> }");
                kotlinx.coroutines.internal.O0xOxO o0xOxO = (kotlinx.coroutines.internal.O0xOxO) obj;
                Object x0XOIxOo2 = o0xOxO.x0XOIxOo();
                if (x0XOIxOo2 != kotlinx.coroutines.internal.O0xOxO.f30246oI0IIXIo) {
                    return (Runnable) x0XOIxOo2;
                }
                androidx.concurrent.futures.oIX0oI.oIX0oI(f29736Oxx0xo, this, obj, o0xOxO.ooOOo0oXI());
            }
        }
    }

    @Override // kotlinx.coroutines.XoX
    public void OOXIXo(long j, @OXOo.OOXIXo oO<? super kotlin.oXIO0o0XI> oOVar) {
        long nanoTime;
        long oxoX2 = xxIO.oxoX(j);
        if (oxoX2 < 4611686018427387903L) {
            kotlinx.coroutines.II0xO0 II0xO02 = kotlinx.coroutines.I0Io.II0xO0();
            if (II0xO02 != null) {
                nanoTime = II0xO02.II0xO0();
            } else {
                nanoTime = System.nanoTime();
            }
            oIX0oI oix0oi = new oIX0oI(oxoX2 + nanoTime, oOVar);
            XX0(nanoTime, oix0oi);
            Oxx0xo.oIX0oI(oOVar, oix0oi);
        }
    }

    @Override // kotlinx.coroutines.XoX
    @OXOo.OOXIXo
    public I0oOIX Oxx0xo(long j, @OXOo.OOXIXo Runnable runnable, @OXOo.OOXIXo CoroutineContext coroutineContext) {
        return XoX.oIX0oI.II0xO0(this, j, runnable, coroutineContext);
    }

    @Override // kotlinx.coroutines.XoX
    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Deprecated without replacement as an internal method never intended for public use")
    @OXOo.oOoXoXO
    public Object OxxIIOOXO(long j, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super kotlin.oXIO0o0XI> i0Io) {
        return XoX.oIX0oI.oIX0oI(this, j, i0Io);
    }

    @Override // kotlinx.coroutines.x0xO
    public long X00IoxXI() {
        long nanoTime;
        I0Io i0Io;
        boolean z;
        if (IO()) {
            return 0L;
        }
        oxoX oxox = (oxoX) f29738oI0IIXIo.get(this);
        if (oxox != null && !oxox.II0XooXoX()) {
            kotlinx.coroutines.II0xO0 II0xO02 = kotlinx.coroutines.I0Io.II0xO0();
            if (II0xO02 != null) {
                nanoTime = II0xO02.II0xO0();
            } else {
                nanoTime = System.nanoTime();
            }
            do {
                synchronized (oxox) {
                    try {
                        I0Io XO2 = oxox.XO();
                        i0Io = null;
                        if (XO2 != null) {
                            I0Io i0Io2 = XO2;
                            if (i0Io2.oOoXoXO(nanoTime)) {
                                z = XoX(i0Io2);
                            } else {
                                z = false;
                            }
                            if (z) {
                                i0Io = oxox.oOoXoXO(0);
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } while (i0Io != null);
        }
        Runnable I0oOoX2 = I0oOoX();
        if (I0oOoX2 != null) {
            I0oOoX2.run();
            return 0L;
        }
        return XIxXXX0x0();
    }

    @Override // kotlinx.coroutines.x0xO
    public long XIxXXX0x0() {
        I0Io xxIXOIIO2;
        long nanoTime;
        kotlinx.coroutines.internal.x0o x0oVar;
        if (super.XIxXXX0x0() == 0) {
            return 0L;
        }
        Object obj = f29736Oxx0xo.get(this);
        if (obj != null) {
            if (!(obj instanceof kotlinx.coroutines.internal.O0xOxO)) {
                x0oVar = xxIO.f30494II0XooXoX;
                if (obj != x0oVar) {
                    return 0L;
                }
                return Long.MAX_VALUE;
            }
            if (!((kotlinx.coroutines.internal.O0xOxO) obj).II0XooXoX()) {
                return 0L;
            }
        }
        oxoX oxox = (oxoX) f29738oI0IIXIo.get(this);
        if (oxox == null || (xxIXOIIO2 = oxox.xxIXOIIO()) == null) {
            return Long.MAX_VALUE;
        }
        long j = xxIXOIIO2.f29740XO;
        kotlinx.coroutines.II0xO0 II0xO02 = kotlinx.coroutines.I0Io.II0xO0();
        if (II0xO02 != null) {
            nanoTime = II0xO02.II0xO0();
        } else {
            nanoTime = System.nanoTime();
        }
        return X0.IIXOooo.IIXOooo(j - nanoTime, 0L);
    }

    public final void XX() {
        kotlinx.coroutines.internal.x0o x0oVar;
        kotlinx.coroutines.internal.x0o x0oVar2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f29736Oxx0xo;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f29736Oxx0xo;
                x0oVar = xxIO.f30494II0XooXoX;
                if (androidx.concurrent.futures.oIX0oI.oIX0oI(atomicReferenceFieldUpdater2, this, null, x0oVar)) {
                    return;
                }
            } else if (!(obj instanceof kotlinx.coroutines.internal.O0xOxO)) {
                x0oVar2 = xxIO.f30494II0XooXoX;
                if (obj == x0oVar2) {
                    return;
                }
                kotlinx.coroutines.internal.O0xOxO o0xOxO = new kotlinx.coroutines.internal.O0xOxO(8, true);
                kotlin.jvm.internal.IIX0o.x0XOIxOo(obj, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
                o0xOxO.oIX0oI((Runnable) obj);
                if (androidx.concurrent.futures.oIX0oI.oIX0oI(f29736Oxx0xo, this, obj, o0xOxO)) {
                    return;
                }
            } else {
                ((kotlinx.coroutines.internal.O0xOxO) obj).oxoX();
                return;
            }
        }
    }

    public final void XX0(long j, @OXOo.OOXIXo I0Io i0Io) {
        int I0X0x0oIo2 = I0X0x0oIo(j, i0Io);
        if (I0X0x0oIo2 != 0) {
            if (I0X0x0oIo2 != 1) {
                if (I0X0x0oIo2 != 2) {
                    throw new IllegalStateException("unexpected result");
                }
                return;
            } else {
                XOxIOxOx(j, i0Io);
                return;
            }
        }
        if (XoI0Ixx0(i0Io)) {
            OI0();
        }
    }

    public final void Xo0(boolean z) {
        f29737OxxIIOOXO.set(this, z ? 1 : 0);
    }

    public final boolean XoI0Ixx0(I0Io i0Io) {
        I0Io i0Io2;
        oxoX oxox = (oxoX) f29738oI0IIXIo.get(this);
        if (oxox != null) {
            i0Io2 = oxox.xxIXOIIO();
        } else {
            i0Io2 = null;
        }
        if (i0Io2 == i0Io) {
            return true;
        }
        return false;
    }

    public final boolean XoX(Runnable runnable) {
        kotlinx.coroutines.internal.x0o x0oVar;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f29736Oxx0xo;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (isCompleted()) {
                return false;
            }
            if (obj == null) {
                if (androidx.concurrent.futures.oIX0oI.oIX0oI(f29736Oxx0xo, this, null, runnable)) {
                    return true;
                }
            } else if (!(obj instanceof kotlinx.coroutines.internal.O0xOxO)) {
                x0oVar = xxIO.f30494II0XooXoX;
                if (obj == x0oVar) {
                    return false;
                }
                kotlinx.coroutines.internal.O0xOxO o0xOxO = new kotlinx.coroutines.internal.O0xOxO(8, true);
                kotlin.jvm.internal.IIX0o.x0XOIxOo(obj, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
                o0xOxO.oIX0oI((Runnable) obj);
                o0xOxO.oIX0oI(runnable);
                if (androidx.concurrent.futures.oIX0oI.oIX0oI(f29736Oxx0xo, this, obj, o0xOxO)) {
                    return true;
                }
            } else {
                kotlin.jvm.internal.IIX0o.x0XOIxOo(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }>{ kotlinx.coroutines.EventLoop_commonKt.Queue<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }> }");
                kotlinx.coroutines.internal.O0xOxO o0xOxO2 = (kotlinx.coroutines.internal.O0xOxO) obj;
                int oIX0oI2 = o0xOxO2.oIX0oI(runnable);
                if (oIX0oI2 == 0) {
                    return true;
                }
                if (oIX0oI2 != 1) {
                    if (oIX0oI2 == 2) {
                        return false;
                    }
                } else {
                    androidx.concurrent.futures.oIX0oI.oIX0oI(f29736Oxx0xo, this, obj, o0xOxO2.ooOOo0oXI());
                }
            }
        }
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void dispatch(@OXOo.OOXIXo CoroutineContext coroutineContext, @OXOo.OOXIXo Runnable runnable) {
        oxxXoxO(runnable);
    }

    @OXOo.OOXIXo
    public final I0oOIX oX(long j, @OXOo.OOXIXo Runnable runnable) {
        long nanoTime;
        long oxoX2 = xxIO.oxoX(j);
        if (oxoX2 < 4611686018427387903L) {
            kotlinx.coroutines.II0xO0 II0xO02 = kotlinx.coroutines.I0Io.II0xO0();
            if (II0xO02 != null) {
                nanoTime = II0xO02.II0xO0();
            } else {
                nanoTime = System.nanoTime();
            }
            II0xO0 iI0xO0 = new II0xO0(oxoX2 + nanoTime, runnable);
            XX0(nanoTime, iI0xO0);
            return iI0xO0;
        }
        return x0OIX00oO.f30462XO;
    }

    @Override // kotlinx.coroutines.x0xO
    public boolean ooXIXxIX() {
        kotlinx.coroutines.internal.x0o x0oVar;
        if (!Xx000oIo()) {
            return false;
        }
        oxoX oxox = (oxoX) f29738oI0IIXIo.get(this);
        if (oxox != null && !oxox.II0XooXoX()) {
            return false;
        }
        Object obj = f29736Oxx0xo.get(this);
        if (obj != null) {
            if (!(obj instanceof kotlinx.coroutines.internal.O0xOxO)) {
                x0oVar = xxIO.f30494II0XooXoX;
                if (obj != x0oVar) {
                    return false;
                }
            } else {
                return ((kotlinx.coroutines.internal.O0xOxO) obj).II0XooXoX();
            }
        }
        return true;
    }

    public void oxxXoxO(@OXOo.OOXIXo Runnable runnable) {
        if (XoX(runnable)) {
            OI0();
        } else {
            o0.f30326IIXOooo.oxxXoxO(runnable);
        }
    }

    @Override // kotlinx.coroutines.x0xO
    public void shutdown() {
        IO0XoXxO.f29694oIX0oI.I0Io();
        Xo0(true);
        XX();
        do {
        } while (X00IoxXI() <= 0);
        xo0x();
    }

    public final void xXOx() {
        f29736Oxx0xo.set(this, null);
        f29738oI0IIXIo.set(this, null);
    }

    public final void xo0x() {
        long nanoTime;
        I0Io x0XOIxOo2;
        kotlinx.coroutines.II0xO0 II0xO02 = kotlinx.coroutines.I0Io.II0xO0();
        if (II0xO02 != null) {
            nanoTime = II0xO02.II0xO0();
        } else {
            nanoTime = System.nanoTime();
        }
        while (true) {
            oxoX oxox = (oxoX) f29738oI0IIXIo.get(this);
            if (oxox != null && (x0XOIxOo2 = oxox.x0XOIxOo()) != null) {
                XOxIOxOx(nanoTime, x0XOIxOo2);
            } else {
                return;
            }
        }
    }
}
