package kotlinx.coroutines.scheduling;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import XO0OX.XO;
import XO0OX.o00;
import XXIoX0.oO;
import XXIoX0.ooOOo0oXI;
import XXIoX0.oxoX;
import XXIoX0.xoIox;
import XXIoX0.xxIXOIIO;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import kotlin.random.Random;
import kotlinx.coroutines.OI0;
import kotlinx.coroutines.internal.oOXoIIIo;
import kotlinx.coroutines.internal.x0o;
import org.apache.commons.lang3.ObjectUtils;

@XX({"SMAP\nCoroutineScheduler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoroutineScheduler.kt\nkotlinx/coroutines/scheduling/CoroutineScheduler\n+ 2 Tasks.kt\nkotlinx/coroutines/scheduling/TasksKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 5 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n+ 6 Tasks.kt\nkotlinx/coroutines/scheduling/Task\n+ 7 CoroutineScheduler.kt\nkotlinx/coroutines/scheduling/CoroutineScheduler$Worker\n*L\n1#1,1033:1\n285#1:1036\n283#1:1037\n283#1:1038\n285#1:1039\n280#1:1045\n281#1,5:1046\n291#1:1052\n283#1:1053\n284#1:1054\n283#1:1060\n284#1:1061\n280#1:1062\n288#1:1063\n283#1:1064\n283#1:1067\n284#1:1068\n285#1:1069\n93#2:1034\n93#2:1051\n1#3:1035\n28#4,4:1040\n28#4,4:1055\n20#5:1044\n20#5:1059\n90#6:1065\n610#7:1066\n*S KotlinDebug\n*F\n+ 1 CoroutineScheduler.kt\nkotlinx/coroutines/scheduling/CoroutineScheduler\n*L\n281#1:1036\n288#1:1037\n289#1:1038\n298#1:1039\n347#1:1045\n375#1:1046,5\n398#1:1052\n445#1:1053\n446#1:1054\n482#1:1060\n483#1:1061\n489#1:1062\n498#1:1063\n498#1:1064\n576#1:1067\n577#1:1068\n578#1:1069\n119#1:1034\n395#1:1051\n347#1:1040,4\n478#1:1055,4\n347#1:1044\n478#1:1059\n515#1:1065\n522#1:1066\n*E\n"})
/* loaded from: classes6.dex */
public final class CoroutineScheduler implements Executor, Closeable {

    /* renamed from: IIX0o, reason: collision with root package name */
    public static final long f30352IIX0o = 4398044413952L;

    /* renamed from: IoOoX, reason: collision with root package name */
    public static final long f30353IoOoX = 2097151;

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public static final int f30357XI0IXoo = -1;

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public static final int f30358XIxXXX0x0 = 0;

    /* renamed from: Xx000oIo, reason: collision with root package name */
    public static final long f30359Xx000oIo = 2097152;

    /* renamed from: XxX0x0xxx, reason: collision with root package name */
    public static final int f30360XxX0x0xxx = 21;

    /* renamed from: oOXoIIIo, reason: collision with root package name */
    public static final long f30362oOXoIIIo = -2097152;

    /* renamed from: oo, reason: collision with root package name */
    public static final int f30363oo = 2097150;

    /* renamed from: oo0xXOI0I, reason: collision with root package name */
    public static final int f30364oo0xXOI0I = 1;

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    public static final int f30365ooXIXxIX = 42;

    /* renamed from: xI, reason: collision with root package name */
    public static final long f30366xI = 9223367638808264704L;

    /* renamed from: xXxxox0I, reason: collision with root package name */
    public static final long f30367xXxxox0I = 2097151;

    /* renamed from: xxX, reason: collision with root package name */
    public static final int f30369xxX = 1;

    /* renamed from: IIXOooo, reason: collision with root package name */
    @OOXIXo
    @XO
    public final oOXoIIIo<I0Io> f30370IIXOooo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    @XO
    public final long f30371IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    @XO
    public final int f30372Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    @OOXIXo
    @XO
    public final String f30373Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    @OOXIXo
    @XO
    public final oxoX f30374OxxIIOOXO;

    /* renamed from: XO, reason: collision with root package name */
    @XO
    public final int f30375XO;

    @o00
    private volatile int _isTerminated;

    @o00
    private volatile long controlState;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    @OOXIXo
    @XO
    public final oxoX f30376oI0IIXIo;

    @o00
    private volatile long parkedWorkersStack;

    /* renamed from: xoXoI, reason: collision with root package name */
    @OOXIXo
    public static final oIX0oI f30368xoXoI = new oIX0oI(null);

    /* renamed from: o00, reason: collision with root package name */
    @OOXIXo
    public static final AtomicLongFieldUpdater f30361o00 = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "parkedWorkersStack");

    /* renamed from: OxI, reason: collision with root package name */
    @OOXIXo
    public static final AtomicLongFieldUpdater f30355OxI = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "controlState");

    /* renamed from: O0xOxO, reason: collision with root package name */
    @OOXIXo
    public static final AtomicIntegerFieldUpdater f30354O0xOxO = AtomicIntegerFieldUpdater.newUpdater(CoroutineScheduler.class, "_isTerminated");

    /* renamed from: X0IIOO, reason: collision with root package name */
    @OOXIXo
    @XO
    public static final x0o f30356X0IIOO = new x0o("NOT_IN_STACK");

    /* loaded from: classes6.dex */
    public /* synthetic */ class II0xO0 {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public static final /* synthetic */ int[] f30386oIX0oI;

        static {
            int[] iArr = new int[WorkerState.values().length];
            try {
                iArr[WorkerState.PARKING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[WorkerState.BLOCKING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[WorkerState.CPU_ACQUIRED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[WorkerState.DORMANT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[WorkerState.TERMINATED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f30386oIX0oI = iArr;
        }
    }

    /* loaded from: classes6.dex */
    public enum WorkerState {
        CPU_ACQUIRED,
        BLOCKING,
        PARKING,
        DORMANT,
        TERMINATED
    }

    /* loaded from: classes6.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(IIXOooo iIXOooo) {
            this();
        }

        public oIX0oI() {
        }
    }

    public CoroutineScheduler(int i, int i2, long j, @OOXIXo String str) {
        this.f30375XO = i;
        this.f30372Oo = i2;
        this.f30371IXxxXO = j;
        this.f30373Oxx0xo = str;
        if (i < 1) {
            throw new IllegalArgumentException(("Core pool size " + i + " should be at least 1").toString());
        }
        if (i2 < i) {
            throw new IllegalArgumentException(("Max pool size " + i2 + " should be greater than or equals to core pool size " + i).toString());
        }
        if (i2 > 2097150) {
            throw new IllegalArgumentException(("Max pool size " + i2 + " should not exceed maximal supported number of threads 2097150").toString());
        }
        if (j > 0) {
            this.f30376oI0IIXIo = new oxoX();
            this.f30374OxxIIOOXO = new oxoX();
            this.f30370IIXOooo = new oOXoIIIo<>((i + 1) * 2);
            this.controlState = i << 42;
            this._isTerminated = 0;
            return;
        }
        throw new IllegalArgumentException(("Idle worker keep alive time " + j + " must be positive").toString());
    }

    public static /* synthetic */ void oOoXoXO(CoroutineScheduler coroutineScheduler, Runnable runnable, xoIox xoiox, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            xoiox = ooOOo0oXI.f4070xxIXOIIO;
        }
        if ((i & 4) != 0) {
            z = false;
        }
        coroutineScheduler.OOXIXo(runnable, xoiox, z);
    }

    public static /* synthetic */ boolean xXxxox0I(CoroutineScheduler coroutineScheduler, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = f30355OxI.get(coroutineScheduler);
        }
        return coroutineScheduler.XxX0x0xxx(j);
    }

    public final int I0Io(long j) {
        return (int) ((j & f30366xI) >> 42);
    }

    public final I0Io II0XooXoX() {
        I0Io i0Io;
        Thread currentThread = Thread.currentThread();
        if (currentThread instanceof I0Io) {
            i0Io = (I0Io) currentThread;
        } else {
            i0Io = null;
        }
        if (i0Io == null || !IIX0o.Oxx0IOOO(CoroutineScheduler.this, this)) {
            return null;
        }
        return i0Io;
    }

    public final boolean II0xO0(xxIXOIIO xxixoiio) {
        if (xxixoiio.f4080Oo.oI0IIXIo() == 1) {
            return this.f30374OxxIIOOXO.oIX0oI(xxixoiio);
        }
        return this.f30376oI0IIXIo.oIX0oI(xxixoiio);
    }

    public final boolean IIX0o() {
        I0Io OxxIIOOXO2;
        do {
            OxxIIOOXO2 = OxxIIOOXO();
            if (OxxIIOOXO2 == null) {
                return false;
            }
        } while (!I0Io.ooOOo0oXI().compareAndSet(OxxIIOOXO2, -1, 0));
        LockSupport.unpark(OxxIIOOXO2);
        return true;
    }

    public final boolean IIXOooo(@OOXIXo I0Io i0Io) {
        long j;
        long j2;
        int xxIXOIIO2;
        if (i0Io.xoIox() != f30356X0IIOO) {
            return false;
        }
        AtomicLongFieldUpdater atomicLongFieldUpdater = f30361o00;
        do {
            j = atomicLongFieldUpdater.get(this);
            j2 = (2097152 + j) & f30362oOXoIIIo;
            xxIXOIIO2 = i0Io.xxIXOIIO();
            i0Io.xoXoI(this.f30370IIXOooo.II0xO0((int) (2097151 & j)));
        } while (!f30361o00.compareAndSet(this, j, j2 | xxIXOIIO2));
        return true;
    }

    public final int IXxxXO() {
        return (int) (f30355OxI.incrementAndGet(this) & 2097151);
    }

    public final void O0xOxO(long j) {
        int i;
        xxIXOIIO II0XooXoX2;
        if (!f30354O0xOxO.compareAndSet(this, 0, 1)) {
            return;
        }
        I0Io II0XooXoX3 = II0XooXoX();
        synchronized (this.f30370IIXOooo) {
            i = (int) (f30355OxI.get(this) & 2097151);
        }
        if (1 <= i) {
            int i2 = 1;
            while (true) {
                I0Io II0xO02 = this.f30370IIXOooo.II0xO0(i2);
                IIX0o.ooOOo0oXI(II0xO02);
                I0Io i0Io = II0xO02;
                if (i0Io != II0XooXoX3) {
                    while (i0Io.isAlive()) {
                        LockSupport.unpark(i0Io);
                        i0Io.join(j);
                    }
                    i0Io.f30383XO.Oxx0IOOO(this.f30374OxxIIOOXO);
                }
                if (i2 == i) {
                    break;
                } else {
                    i2++;
                }
            }
        }
        this.f30374OxxIIOOXO.II0xO0();
        this.f30376oI0IIXIo.II0xO0();
        while (true) {
            if (II0XooXoX3 != null) {
                II0XooXoX2 = II0XooXoX3.II0XooXoX(true);
                if (II0XooXoX2 != null) {
                    continue;
                    OxI(II0XooXoX2);
                }
            }
            II0XooXoX2 = this.f30376oI0IIXIo.II0XooXoX();
            if (II0XooXoX2 == null && (II0XooXoX2 = this.f30374OxxIIOOXO.II0XooXoX()) == null) {
                break;
            }
            OxI(II0XooXoX2);
        }
        if (II0XooXoX3 != null) {
            II0XooXoX3.O0xOxO(WorkerState.TERMINATED);
        }
        f30361o00.set(this, 0L);
        f30355OxI.set(this, 0L);
    }

    public final void OOXIXo(@OOXIXo Runnable runnable, @OOXIXo xoIox xoiox, boolean z) {
        boolean z2;
        long j;
        kotlinx.coroutines.II0xO0 II0xO02 = kotlinx.coroutines.I0Io.II0xO0();
        if (II0xO02 != null) {
            II0xO02.X0o0xo();
        }
        xxIXOIIO XO2 = XO(runnable, xoiox);
        boolean z3 = false;
        if (XO2.f4080Oo.oI0IIXIo() == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            j = f30355OxI.addAndGet(this, 2097152L);
        } else {
            j = 0;
        }
        I0Io II0XooXoX2 = II0XooXoX();
        xxIXOIIO XIxXXX0x02 = XIxXXX0x0(II0XooXoX2, XO2, z);
        if (XIxXXX0x02 != null && !II0xO0(XIxXXX0x02)) {
            throw new RejectedExecutionException(this.f30373Oxx0xo + " was terminated");
        }
        if (z && II0XooXoX2 != null) {
            z3 = true;
        }
        if (z2) {
            X0IIOO(j, z3);
        } else {
            if (z3) {
                return;
            }
            XI0IXoo();
        }
    }

    public final long Oo() {
        return f30355OxI.addAndGet(this, 2097152L);
    }

    public final void OxI(@OOXIXo xxIXOIIO xxixoiio) {
        try {
            xxixoiio.run();
        } catch (Throwable th) {
            try {
                Thread currentThread = Thread.currentThread();
                currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
                kotlinx.coroutines.II0xO0 II0xO02 = kotlinx.coroutines.I0Io.II0xO0();
                if (II0xO02 == null) {
                }
            } finally {
                kotlinx.coroutines.II0xO0 II0xO03 = kotlinx.coroutines.I0Io.II0xO0();
                if (II0xO03 != null) {
                    II0xO03.XO();
                }
            }
        }
    }

    public final int Oxx0IOOO(long j) {
        return (int) (j & 2097151);
    }

    public final void Oxx0xo(AtomicLongFieldUpdater atomicLongFieldUpdater, oOoXoXO<? super Long, oXIO0o0XI> oooxoxo, Object obj) {
        while (true) {
            oooxoxo.invoke(Long.valueOf(atomicLongFieldUpdater.get(obj)));
        }
    }

    public final I0Io OxxIIOOXO() {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f30361o00;
        while (true) {
            long j = atomicLongFieldUpdater.get(this);
            I0Io II0xO02 = this.f30370IIXOooo.II0xO0((int) (2097151 & j));
            if (II0xO02 == null) {
                return null;
            }
            long j2 = (2097152 + j) & f30362oOXoIIIo;
            int oI0IIXIo2 = oI0IIXIo(II0xO02);
            if (oI0IIXIo2 >= 0 && f30361o00.compareAndSet(this, j, oI0IIXIo2 | j2)) {
                II0xO02.xoXoI(f30356X0IIOO);
                return II0xO02;
            }
        }
    }

    public final void X0IIOO(long j, boolean z) {
        if (z || IIX0o() || XxX0x0xxx(j)) {
            return;
        }
        IIX0o();
    }

    public final int X0o0xo() {
        synchronized (this.f30370IIXOooo) {
            try {
                if (isTerminated()) {
                    return -1;
                }
                AtomicLongFieldUpdater atomicLongFieldUpdater = f30355OxI;
                long j = atomicLongFieldUpdater.get(this);
                int i = (int) (j & 2097151);
                int OxxIIOOXO2 = X0.IIXOooo.OxxIIOOXO(i - ((int) ((j & f30352IIX0o) >> 21)), 0);
                if (OxxIIOOXO2 >= this.f30375XO) {
                    return 0;
                }
                if (i >= this.f30372Oo) {
                    return 0;
                }
                int i2 = ((int) (f30355OxI.get(this) & 2097151)) + 1;
                if (i2 > 0 && this.f30370IIXOooo.II0xO0(i2) == null) {
                    I0Io i0Io = new I0Io(this, i2);
                    this.f30370IIXOooo.I0Io(i2, i0Io);
                    if (i2 == ((int) (2097151 & atomicLongFieldUpdater.incrementAndGet(this)))) {
                        int i3 = OxxIIOOXO2 + 1;
                        i0Io.start();
                        return i3;
                    }
                    throw new IllegalArgumentException("Failed requirement.");
                }
                throw new IllegalArgumentException("Failed requirement.");
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void XI0IXoo() {
        if (IIX0o() || xXxxox0I(this, 0L, 1, null)) {
            return;
        }
        IIX0o();
    }

    public final xxIXOIIO XIxXXX0x0(I0Io i0Io, xxIXOIIO xxixoiio, boolean z) {
        if (i0Io == null) {
            return xxixoiio;
        }
        if (i0Io.f30379IXxxXO == WorkerState.TERMINATED) {
            return xxixoiio;
        }
        if (xxixoiio.f4080Oo.oI0IIXIo() == 0 && i0Io.f30379IXxxXO == WorkerState.BLOCKING) {
            return xxixoiio;
        }
        i0Io.f30378IIXOooo = true;
        return i0Io.f30383XO.oIX0oI(xxixoiio, z);
    }

    @OOXIXo
    public final xxIXOIIO XO(@OOXIXo Runnable runnable, @OOXIXo xoIox xoiox) {
        long oIX0oI2 = ooOOo0oXI.f4066XO.oIX0oI();
        if (runnable instanceof xxIXOIIO) {
            xxIXOIIO xxixoiio = (xxIXOIIO) runnable;
            xxixoiio.f4081XO = oIX0oI2;
            xxixoiio.f4080Oo = xoiox;
            return xxixoiio;
        }
        return new XXIoX0.oOoXoXO(runnable, oIX0oI2, xoiox);
    }

    public final boolean XxX0x0xxx(long j) {
        if (X0.IIXOooo.OxxIIOOXO(((int) (2097151 & j)) - ((int) ((j & f30352IIX0o) >> 21)), 0) < this.f30375XO) {
            int X0o0xo2 = X0o0xo();
            if (X0o0xo2 == 1 && this.f30375XO > 1) {
                X0o0xo();
            }
            if (X0o0xo2 > 0) {
                return true;
            }
        }
        return false;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        O0xOxO(10000L);
    }

    @Override // java.util.concurrent.Executor
    public void execute(@OOXIXo Runnable runnable) {
        oOoXoXO(this, runnable, null, false, 6, null);
    }

    public final boolean isTerminated() {
        if (f30354O0xOxO.get(this) != 0) {
            return true;
        }
        return false;
    }

    public final long o00() {
        return f30355OxI.addAndGet(this, 4398046511104L);
    }

    public final int oI0IIXIo(I0Io i0Io) {
        Object xoIox2 = i0Io.xoIox();
        while (xoIox2 != f30356X0IIOO) {
            if (xoIox2 == null) {
                return 0;
            }
            I0Io i0Io2 = (I0Io) xoIox2;
            int xxIXOIIO2 = i0Io2.xxIXOIIO();
            if (xxIXOIIO2 != 0) {
                return xxIXOIIO2;
            }
            xoIox2 = i0Io2.xoIox();
        }
        return -1;
    }

    public final int oO() {
        return (int) (f30355OxI.get(this) & 2097151);
    }

    public final int oxoX(long j) {
        return (int) ((j & f30352IIX0o) >> 21);
    }

    @OOXIXo
    public String toString() {
        ArrayList arrayList = new ArrayList();
        int oIX0oI2 = this.f30370IIXOooo.oIX0oI();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 1; i6 < oIX0oI2; i6++) {
            I0Io II0xO02 = this.f30370IIXOooo.II0xO0(i6);
            if (II0xO02 != null) {
                int XO2 = II0xO02.f30383XO.XO();
                int i7 = II0xO0.f30386oIX0oI[II0xO02.f30379IXxxXO.ordinal()];
                if (i7 != 1) {
                    if (i7 != 2) {
                        if (i7 != 3) {
                            if (i7 != 4) {
                                if (i7 == 5) {
                                    i5++;
                                }
                            } else {
                                i4++;
                                if (XO2 > 0) {
                                    StringBuilder sb = new StringBuilder();
                                    sb.append(XO2);
                                    sb.append('d');
                                    arrayList.add(sb.toString());
                                }
                            }
                        } else {
                            i++;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(XO2);
                            sb2.append('c');
                            arrayList.add(sb2.toString());
                        }
                    } else {
                        i2++;
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(XO2);
                        sb3.append('b');
                        arrayList.add(sb3.toString());
                    }
                } else {
                    i3++;
                }
            }
        }
        long j = f30355OxI.get(this);
        return this.f30373Oxx0xo + ObjectUtils.f32506oIX0oI + OI0.II0xO0(this) + "[Pool Size {core = " + this.f30375XO + ", max = " + this.f30372Oo + "}, Worker States {CPU = " + i + ", blocking = " + i2 + ", parked = " + i3 + ", dormant = " + i4 + ", terminated = " + i5 + "}, running workers queues = " + arrayList + ", global CPU queue size = " + this.f30376oI0IIXIo.I0Io() + ", global blocking queue size = " + this.f30374OxxIIOOXO.I0Io() + ", Control State {created workers= " + ((int) (2097151 & j)) + ", blocking tasks = " + ((int) ((f30352IIX0o & j) >> 21)) + ", CPUs acquired = " + (this.f30375XO - ((int) ((f30366xI & j) >> 42))) + "}]";
    }

    public final int x0XOIxOo() {
        return (int) ((f30355OxI.get(this) & f30366xI) >> 42);
    }

    public final int xoIox() {
        return (int) (f30355OxI.getAndDecrement(this) & 2097151);
    }

    public final void xoXoI(@OOXIXo I0Io i0Io, int i, int i2) {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f30361o00;
        while (true) {
            long j = atomicLongFieldUpdater.get(this);
            int i3 = (int) (2097151 & j);
            long j2 = (2097152 + j) & f30362oOXoIIIo;
            if (i3 == i) {
                if (i2 == 0) {
                    i3 = oI0IIXIo(i0Io);
                } else {
                    i3 = i2;
                }
            }
            if (i3 >= 0 && f30361o00.compareAndSet(this, j, j2 | i3)) {
                return;
            }
        }
    }

    public final void xxIXOIIO() {
        f30355OxI.addAndGet(this, f30362oOXoIIIo);
    }

    public final boolean xxX() {
        long j;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f30355OxI;
        do {
            j = atomicLongFieldUpdater.get(this);
            if (((int) ((f30366xI & j) >> 42)) != 0) {
            } else {
                return false;
            }
        } while (!f30355OxI.compareAndSet(this, j, j - 4398046511104L));
        return true;
    }

    @XX({"SMAP\nCoroutineScheduler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoroutineScheduler.kt\nkotlinx/coroutines/scheduling/CoroutineScheduler$Worker\n+ 2 CoroutineScheduler.kt\nkotlinx/coroutines/scheduling/CoroutineScheduler\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Tasks.kt\nkotlinx/coroutines/scheduling/Task\n+ 5 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 6 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n*L\n1#1,1033:1\n298#2:1034\n285#2:1035\n299#2,4:1036\n304#2:1040\n294#2,2:1041\n294#2,2:1045\n280#2:1052\n289#2:1053\n283#2:1054\n280#2:1055\n1#3:1043\n90#4:1044\n28#5,4:1047\n20#6:1051\n*S KotlinDebug\n*F\n+ 1 CoroutineScheduler.kt\nkotlinx/coroutines/scheduling/CoroutineScheduler$Worker\n*L\n665#1:1034\n665#1:1035\n665#1:1036,4\n679#1:1040\n753#1:1041,2\n807#1:1045,2\n855#1:1052\n881#1:1053\n881#1:1054\n963#1:1055\n790#1:1044\n851#1:1047,4\n851#1:1051\n*E\n"})
    /* loaded from: classes6.dex */
    public final class I0Io extends Thread {

        /* renamed from: o00, reason: collision with root package name */
        @OOXIXo
        public static final AtomicIntegerFieldUpdater f30377o00 = AtomicIntegerFieldUpdater.newUpdater(I0Io.class, "workerCtl");

        /* renamed from: IIXOooo, reason: collision with root package name */
        @XO
        public boolean f30378IIXOooo;

        /* renamed from: IXxxXO, reason: collision with root package name */
        @OOXIXo
        @XO
        public WorkerState f30379IXxxXO;

        /* renamed from: Oo, reason: collision with root package name */
        @OOXIXo
        public final Ref.ObjectRef<xxIXOIIO> f30380Oo;

        /* renamed from: Oxx0xo, reason: collision with root package name */
        public long f30381Oxx0xo;

        /* renamed from: OxxIIOOXO, reason: collision with root package name */
        public int f30382OxxIIOOXO;

        /* renamed from: XO, reason: collision with root package name */
        @OOXIXo
        @XO
        public final oO f30383XO;
        private volatile int indexInArray;

        @OXOo.oOoXoXO
        private volatile Object nextParkedWorker;

        /* renamed from: oI0IIXIo, reason: collision with root package name */
        public long f30384oI0IIXIo;

        @o00
        private volatile int workerCtl;

        public I0Io() {
            setDaemon(true);
            this.f30383XO = new oO();
            this.f30380Oo = new Ref.ObjectRef<>();
            this.f30379IXxxXO = WorkerState.DORMANT;
            this.nextParkedWorker = CoroutineScheduler.f30356X0IIOO;
            this.f30382OxxIIOOXO = Random.Default.nextInt();
        }

        @OOXIXo
        public static final AtomicIntegerFieldUpdater ooOOo0oXI() {
            return f30377o00;
        }

        public final void I0Io(int i) {
            if (i != 0 && O0xOxO(WorkerState.BLOCKING)) {
                CoroutineScheduler.this.XI0IXoo();
            }
        }

        @OXOo.oOoXoXO
        public final xxIXOIIO II0XooXoX(boolean z) {
            if (o00()) {
                return X0o0xo(z);
            }
            return XO();
        }

        public final void II0xO0(int i) {
            if (i == 0) {
                return;
            }
            CoroutineScheduler.f30355OxI.addAndGet(CoroutineScheduler.this, CoroutineScheduler.f30362oOXoIIIo);
            if (this.f30379IXxxXO != WorkerState.TERMINATED) {
                this.f30379IXxxXO = WorkerState.DORMANT;
            }
        }

        public final void IIXOooo(int i) {
            String valueOf;
            StringBuilder sb = new StringBuilder();
            sb.append(CoroutineScheduler.this.f30373Oxx0xo);
            sb.append("-worker-");
            if (i == 0) {
                valueOf = "TERMINATED";
            } else {
                valueOf = String.valueOf(i);
            }
            sb.append(valueOf);
            setName(sb.toString());
            this.indexInArray = i;
        }

        public final void IXxxXO() {
            if (this.f30381Oxx0xo == 0) {
                this.f30381Oxx0xo = System.nanoTime() + CoroutineScheduler.this.f30371IXxxXO;
            }
            LockSupport.parkNanos(CoroutineScheduler.this.f30371IXxxXO);
            if (System.nanoTime() - this.f30381Oxx0xo >= 0) {
                this.f30381Oxx0xo = 0L;
                XI0IXoo();
            }
        }

        public final boolean O0xOxO(@OOXIXo WorkerState workerState) {
            boolean z;
            WorkerState workerState2 = this.f30379IXxxXO;
            if (workerState2 == WorkerState.CPU_ACQUIRED) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                CoroutineScheduler.f30355OxI.addAndGet(CoroutineScheduler.this, 4398046511104L);
            }
            if (workerState2 != workerState) {
                this.f30379IXxxXO = workerState;
            }
            return z;
        }

        @OOXIXo
        public final CoroutineScheduler OOXIXo() {
            return CoroutineScheduler.this;
        }

        public final int Oo(int i) {
            int i2 = this.f30382OxxIIOOXO;
            int i3 = i2 ^ (i2 << 13);
            int i4 = i3 ^ (i3 >> 17);
            int i5 = i4 ^ (i4 << 5);
            this.f30382OxxIIOOXO = i5;
            int i6 = i - 1;
            if ((i6 & i) == 0) {
                return i5 & i6;
            }
            return (i5 & Integer.MAX_VALUE) % i;
        }

        public final void OxI() {
            if (!oO()) {
                CoroutineScheduler.this.IIXOooo(this);
                return;
            }
            f30377o00.set(this, -1);
            while (oO() && f30377o00.get(this) == -1 && !CoroutineScheduler.this.isTerminated() && this.f30379IXxxXO != WorkerState.TERMINATED) {
                O0xOxO(WorkerState.PARKING);
                Thread.interrupted();
                IXxxXO();
            }
        }

        public final xxIXOIIO Oxx0IOOO() {
            xxIXOIIO OOXIXo2 = this.f30383XO.OOXIXo();
            if (OOXIXo2 == null) {
                xxIXOIIO II0XooXoX2 = CoroutineScheduler.this.f30374OxxIIOOXO.II0XooXoX();
                if (II0XooXoX2 == null) {
                    return X0IIOO(2);
                }
                return II0XooXoX2;
            }
            return OOXIXo2;
        }

        public final xxIXOIIO Oxx0xo() {
            if (Oo(2) == 0) {
                xxIXOIIO II0XooXoX2 = CoroutineScheduler.this.f30376oI0IIXIo.II0XooXoX();
                if (II0XooXoX2 != null) {
                    return II0XooXoX2;
                }
                return CoroutineScheduler.this.f30374OxxIIOOXO.II0XooXoX();
            }
            xxIXOIIO II0XooXoX3 = CoroutineScheduler.this.f30374OxxIIOOXO.II0XooXoX();
            if (II0XooXoX3 != null) {
                return II0XooXoX3;
            }
            return CoroutineScheduler.this.f30376oI0IIXIo.II0XooXoX();
        }

        public final void OxxIIOOXO() {
            loop0: while (true) {
                boolean z = false;
                while (!CoroutineScheduler.this.isTerminated() && this.f30379IXxxXO != WorkerState.TERMINATED) {
                    xxIXOIIO II0XooXoX2 = II0XooXoX(this.f30378IIXOooo);
                    if (II0XooXoX2 != null) {
                        this.f30384oI0IIXIo = 0L;
                        oxoX(II0XooXoX2);
                    } else {
                        this.f30378IIXOooo = false;
                        if (this.f30384oI0IIXIo != 0) {
                            if (!z) {
                                z = true;
                            } else {
                                O0xOxO(WorkerState.PARKING);
                                Thread.interrupted();
                                LockSupport.parkNanos(this.f30384oI0IIXIo);
                                this.f30384oI0IIXIo = 0L;
                            }
                        } else {
                            OxI();
                        }
                    }
                }
            }
            O0xOxO(WorkerState.TERMINATED);
        }

        public final xxIXOIIO X0IIOO(int i) {
            int i2 = (int) (CoroutineScheduler.f30355OxI.get(CoroutineScheduler.this) & 2097151);
            if (i2 < 2) {
                return null;
            }
            int Oo2 = Oo(i2);
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            long j = Long.MAX_VALUE;
            for (int i3 = 0; i3 < i2; i3++) {
                Oo2++;
                if (Oo2 > i2) {
                    Oo2 = 1;
                }
                I0Io II0xO02 = coroutineScheduler.f30370IIXOooo.II0xO0(Oo2);
                if (II0xO02 != null && II0xO02 != this) {
                    long x0xO0oo2 = II0xO02.f30383XO.x0xO0oo(i, this.f30380Oo);
                    if (x0xO0oo2 == -1) {
                        Ref.ObjectRef<xxIXOIIO> objectRef = this.f30380Oo;
                        xxIXOIIO xxixoiio = objectRef.element;
                        objectRef.element = null;
                        return xxixoiio;
                    }
                    if (x0xO0oo2 > 0) {
                        j = Math.min(j, x0xO0oo2);
                    }
                }
            }
            if (j == Long.MAX_VALUE) {
                j = 0;
            }
            this.f30384oI0IIXIo = j;
            return null;
        }

        public final xxIXOIIO X0o0xo(boolean z) {
            boolean z2;
            xxIXOIIO Oxx0xo2;
            xxIXOIIO Oxx0xo3;
            if (z) {
                if (Oo(CoroutineScheduler.this.f30375XO * 2) == 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2 && (Oxx0xo3 = Oxx0xo()) != null) {
                    return Oxx0xo3;
                }
                xxIXOIIO II0XooXoX2 = this.f30383XO.II0XooXoX();
                if (II0XooXoX2 != null) {
                    return II0XooXoX2;
                }
                if (!z2 && (Oxx0xo2 = Oxx0xo()) != null) {
                    return Oxx0xo2;
                }
            } else {
                xxIXOIIO Oxx0xo4 = Oxx0xo();
                if (Oxx0xo4 != null) {
                    return Oxx0xo4;
                }
            }
            return X0IIOO(3);
        }

        public final void XI0IXoo() {
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            synchronized (coroutineScheduler.f30370IIXOooo) {
                try {
                    if (coroutineScheduler.isTerminated()) {
                        return;
                    }
                    if (((int) (CoroutineScheduler.f30355OxI.get(coroutineScheduler) & 2097151)) <= coroutineScheduler.f30375XO) {
                        return;
                    }
                    if (!f30377o00.compareAndSet(this, -1, 1)) {
                        return;
                    }
                    int i = this.indexInArray;
                    IIXOooo(0);
                    coroutineScheduler.xoXoI(this, i, 0);
                    int andDecrement = (int) (CoroutineScheduler.f30355OxI.getAndDecrement(coroutineScheduler) & 2097151);
                    if (andDecrement != i) {
                        I0Io II0xO02 = coroutineScheduler.f30370IIXOooo.II0xO0(andDecrement);
                        IIX0o.ooOOo0oXI(II0xO02);
                        I0Io i0Io = II0xO02;
                        coroutineScheduler.f30370IIXOooo.I0Io(i, i0Io);
                        i0Io.IIXOooo(i);
                        coroutineScheduler.xoXoI(i0Io, andDecrement, i);
                    }
                    coroutineScheduler.f30370IIXOooo.I0Io(andDecrement, null);
                    oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
                    this.f30379IXxxXO = WorkerState.TERMINATED;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final xxIXOIIO XO() {
            xxIXOIIO xxIXOIIO2 = this.f30383XO.xxIXOIIO();
            if (xxIXOIIO2 == null) {
                xxIXOIIO II0XooXoX2 = CoroutineScheduler.this.f30374OxxIIOOXO.II0XooXoX();
                if (II0XooXoX2 == null) {
                    return X0IIOO(1);
                }
                return II0XooXoX2;
            }
            return xxIXOIIO2;
        }

        public final boolean o00() {
            long j;
            if (this.f30379IXxxXO == WorkerState.CPU_ACQUIRED) {
                return true;
            }
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            AtomicLongFieldUpdater atomicLongFieldUpdater = CoroutineScheduler.f30355OxI;
            do {
                j = atomicLongFieldUpdater.get(coroutineScheduler);
                if (((int) ((CoroutineScheduler.f30366xI & j) >> 42)) != 0) {
                } else {
                    return false;
                }
            } while (!CoroutineScheduler.f30355OxI.compareAndSet(coroutineScheduler, j, j - 4398046511104L));
            this.f30379IXxxXO = WorkerState.CPU_ACQUIRED;
            return true;
        }

        public final long oI0IIXIo() {
            boolean z;
            xxIXOIIO XO2;
            if (this.f30379IXxxXO == WorkerState.CPU_ACQUIRED) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                XO2 = Oxx0IOOO();
            } else {
                XO2 = XO();
            }
            if (XO2 == null) {
                long j = this.f30384oI0IIXIo;
                if (j == 0) {
                    return -1L;
                }
                return j;
            }
            CoroutineScheduler.this.OxI(XO2);
            if (!z) {
                CoroutineScheduler.f30355OxI.addAndGet(CoroutineScheduler.this, CoroutineScheduler.f30362oOXoIIIo);
            }
            return 0L;
        }

        public final boolean oO() {
            if (this.nextParkedWorker != CoroutineScheduler.f30356X0IIOO) {
                return true;
            }
            return false;
        }

        public final int oOoXoXO() {
            return this.workerCtl;
        }

        public final void oxoX(xxIXOIIO xxixoiio) {
            int oI0IIXIo2 = xxixoiio.f4080Oo.oI0IIXIo();
            x0XOIxOo(oI0IIXIo2);
            I0Io(oI0IIXIo2);
            CoroutineScheduler.this.OxI(xxixoiio);
            II0xO0(oI0IIXIo2);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            OxxIIOOXO();
        }

        public final void x0XOIxOo(int i) {
            this.f30381Oxx0xo = 0L;
            if (this.f30379IXxxXO == WorkerState.PARKING) {
                this.f30379IXxxXO = WorkerState.BLOCKING;
            }
        }

        public final boolean x0xO0oo() {
            if (this.f30379IXxxXO == WorkerState.BLOCKING) {
                return true;
            }
            return false;
        }

        @OXOo.oOoXoXO
        public final Object xoIox() {
            return this.nextParkedWorker;
        }

        public final void xoXoI(@OXOo.oOoXoXO Object obj) {
            this.nextParkedWorker = obj;
        }

        public final int xxIXOIIO() {
            return this.indexInArray;
        }

        public I0Io(CoroutineScheduler coroutineScheduler, int i) {
            this();
            IIXOooo(i);
        }
    }

    public /* synthetic */ CoroutineScheduler(int i, int i2, long j, String str, int i3, IIXOooo iIXOooo) {
        this(i, i2, (i3 & 4) != 0 ? ooOOo0oXI.f4065X0o0xo : j, (i3 & 8) != 0 ? ooOOo0oXI.f4067oIX0oI : str);
    }
}
