package kotlinx.coroutines.internal;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.oXIO0o0XI;

@kotlin.jvm.internal.XX({"SMAP\nLockFreeTaskQueue.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LockFreeTaskQueue.kt\nkotlinx/coroutines/internal/LockFreeTaskQueueCore\n+ 2 LockFreeTaskQueue.kt\nkotlinx/coroutines/internal/LockFreeTaskQueueCore$Companion\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,308:1\n299#2,3:309\n299#2,3:312\n299#2,3:315\n299#2,3:318\n299#2,3:321\n299#2,3:325\n299#2,3:328\n1#3:324\n*S KotlinDebug\n*F\n+ 1 LockFreeTaskQueue.kt\nkotlinx/coroutines/internal/LockFreeTaskQueueCore\n*L\n91#1:309,3\n92#1:312,3\n107#1:315,3\n167#1:318,3\n200#1:321,3\n231#1:325,3\n247#1:328,3\n*E\n"})
/* loaded from: classes6.dex */
public final class O0xOxO<E> {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f30236II0XooXoX = 8;

    /* renamed from: IIXOooo, reason: collision with root package name */
    public static final int f30237IIXOooo = 1;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static final long f30238IXxxXO = 2305843009213693952L;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f30239OOXIXo = 0;

    /* renamed from: Oo, reason: collision with root package name */
    public static final int f30240Oo = 61;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static final int f30242Oxx0xo = 1024;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public static final int f30243OxxIIOOXO = 0;

    /* renamed from: oO, reason: collision with root package name */
    public static final int f30247oO = 60;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final long f30248oOoXoXO = 1073741823;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final int f30249ooOOo0oXI = 30;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final long f30250x0XOIxOo = 1152921503533105152L;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static final long f30251x0xO0oo = 1152921504606846976L;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f30252xoIox = 1073741823;

    /* renamed from: xoXoI, reason: collision with root package name */
    public static final int f30253xoXoI = 2;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f30254xxIXOIIO = 30;

    /* renamed from: I0Io, reason: collision with root package name */
    public final int f30255I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public final boolean f30256II0xO0;

    @OXOo.oOoXoXO
    @XO0OX.o00
    private volatile Object _next;

    @XO0OX.o00
    private volatile long _state;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final int f30257oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    @OXOo.OOXIXo
    public final AtomicReferenceArray f30258oxoX;

    /* renamed from: X0o0xo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final oIX0oI f30244X0o0xo = new oIX0oI(null);

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final AtomicReferenceFieldUpdater f30245XO = AtomicReferenceFieldUpdater.newUpdater(O0xOxO.class, Object.class, "_next");

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final AtomicLongFieldUpdater f30241Oxx0IOOO = AtomicLongFieldUpdater.newUpdater(O0xOxO.class, "_state");

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    @OXOo.OOXIXo
    @XO0OX.XO
    public static final x0o f30246oI0IIXIo = new x0o("REMOVE_FROZEN");

    /* loaded from: classes6.dex */
    public static final class II0xO0 {

        /* renamed from: oIX0oI, reason: collision with root package name */
        @XO0OX.XO
        public final int f30259oIX0oI;

        public II0xO0(int i) {
            this.f30259oIX0oI = i;
        }
    }

    /* loaded from: classes6.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        public final long I0Io(long j, int i) {
            return X0o0xo(j, O0xOxO.f30250x0XOIxOo) | (i << 30);
        }

        public final long II0xO0(long j, int i) {
            return X0o0xo(j, O0xOxO.f30248oOoXoXO) | i;
        }

        public final long X0o0xo(long j, long j2) {
            return j & (~j2);
        }

        public final int oIX0oI(long j) {
            return (j & O0xOxO.f30238IXxxXO) != 0 ? 2 : 1;
        }

        public final <T> T oxoX(long j, @OXOo.OOXIXo Oox.x0xO0oo<? super Integer, ? super Integer, ? extends T> x0xo0oo) {
            return x0xo0oo.invoke(Integer.valueOf((int) (O0xOxO.f30248oOoXoXO & j)), Integer.valueOf((int) ((j & O0xOxO.f30250x0XOIxOo) >> 30)));
        }

        public oIX0oI() {
        }
    }

    public O0xOxO(int i, boolean z) {
        this.f30257oIX0oI = i;
        this.f30256II0xO0 = z;
        int i2 = i - 1;
        this.f30255I0Io = i2;
        this.f30258oxoX = new AtomicReferenceArray(i);
        if (i2 <= 1073741823) {
            if ((i & i2) == 0) {
                return;
            } else {
                throw new IllegalStateException("Check failed.");
            }
        }
        throw new IllegalStateException("Check failed.");
    }

    public final O0xOxO<E> I0Io(long j) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f30245XO;
        while (true) {
            O0xOxO<E> o0xOxO = (O0xOxO) atomicReferenceFieldUpdater.get(this);
            if (o0xOxO != null) {
                return o0xOxO;
            }
            androidx.concurrent.futures.oIX0oI.oIX0oI(f30245XO, this, null, II0xO0(j));
        }
    }

    public final boolean II0XooXoX() {
        long j = f30241Oxx0IOOO.get(this);
        if (((int) (f30248oOoXoXO & j)) == ((int) ((j & f30250x0XOIxOo) >> 30))) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final O0xOxO<E> II0xO0(long j) {
        O0xOxO<E> o0xOxO = new O0xOxO<>(this.f30257oIX0oI * 2, this.f30256II0xO0);
        int i = (int) (f30248oOoXoXO & j);
        int i2 = (int) ((f30250x0XOIxOo & j) >> 30);
        while (true) {
            int i3 = this.f30255I0Io;
            if ((i & i3) != (i2 & i3)) {
                Object obj = this.f30258oxoX.get(i3 & i);
                if (obj == null) {
                    obj = new II0xO0(i);
                }
                o0xOxO.f30258oxoX.set(o0xOxO.f30255I0Io & i, obj);
                i++;
            } else {
                f30241Oxx0IOOO.set(o0xOxO, f30244X0o0xo.X0o0xo(j, 1152921504606846976L));
                return o0xOxO;
            }
        }
    }

    @OXOo.OOXIXo
    public final <R> List<R> OOXIXo(@OXOo.OOXIXo Oox.oOoXoXO<? super E, ? extends R> oooxoxo) {
        ArrayList arrayList = new ArrayList(this.f30257oIX0oI);
        long j = f30241Oxx0IOOO.get(this);
        int i = (int) (f30248oOoXoXO & j);
        int i2 = (int) ((j & f30250x0XOIxOo) >> 30);
        while (true) {
            int i3 = this.f30255I0Io;
            if ((i & i3) != (i2 & i3)) {
                I00O.II0xO0 iI0xO0 = (Object) this.f30258oxoX.get(i3 & i);
                if (iI0xO0 != null && !(iI0xO0 instanceof II0xO0)) {
                    arrayList.add(oooxoxo.invoke(iI0xO0));
                }
                i++;
            } else {
                return arrayList;
            }
        }
    }

    public final long Oo(AtomicLongFieldUpdater atomicLongFieldUpdater, Oox.oOoXoXO<? super Long, Long> oooxoxo, Object obj) {
        long j;
        Long invoke;
        do {
            j = atomicLongFieldUpdater.get(obj);
            invoke = oooxoxo.invoke(Long.valueOf(j));
        } while (!atomicLongFieldUpdater.compareAndSet(obj, j, invoke.longValue()));
        return invoke.longValue();
    }

    public final boolean Oxx0IOOO() {
        if ((f30241Oxx0IOOO.get(this) & f30238IXxxXO) != 0) {
            return true;
        }
        return false;
    }

    public final O0xOxO<E> X0o0xo(int i, E e) {
        Object obj = this.f30258oxoX.get(this.f30255I0Io & i);
        if ((obj instanceof II0xO0) && ((II0xO0) obj).f30259oIX0oI == i) {
            this.f30258oxoX.set(i & this.f30255I0Io, e);
            return this;
        }
        return null;
    }

    public final int XO() {
        long j = f30241Oxx0IOOO.get(this);
        return 1073741823 & (((int) ((j & f30250x0XOIxOo) >> 30)) - ((int) (f30248oOoXoXO & j)));
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x004e, code lost:
    
        return 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int oIX0oI(@OXOo.OOXIXo E r13) {
        /*
            r12 = this;
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = kotlinx.coroutines.internal.O0xOxO.f30241Oxx0IOOO
        L2:
            long r3 = r0.get(r12)
            r1 = 3458764513820540928(0x3000000000000000, double:1.727233711018889E-77)
            long r1 = r1 & r3
            r7 = 0
            int r5 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r5 == 0) goto L16
            kotlinx.coroutines.internal.O0xOxO$oIX0oI r13 = kotlinx.coroutines.internal.O0xOxO.f30244X0o0xo
            int r13 = r13.oIX0oI(r3)
            return r13
        L16:
            r1 = 1073741823(0x3fffffff, double:5.304989472E-315)
            long r1 = r1 & r3
            int r2 = (int) r1
            r5 = 1152921503533105152(0xfffffffc0000000, double:1.2882296003504729E-231)
            long r5 = r5 & r3
            r1 = 30
            long r5 = r5 >> r1
            int r9 = (int) r5
            int r10 = r12.f30255I0Io
            int r1 = r9 + 2
            r1 = r1 & r10
            r5 = r2 & r10
            r6 = 1
            if (r1 != r5) goto L30
            return r6
        L30:
            boolean r1 = r12.f30256II0xO0
            r5 = 1073741823(0x3fffffff, float:1.9999999)
            if (r1 != 0) goto L4f
            java.util.concurrent.atomic.AtomicReferenceArray r1 = r12.f30258oxoX
            r11 = r9 & r10
            java.lang.Object r1 = r1.get(r11)
            if (r1 == 0) goto L4f
            int r1 = r12.f30257oIX0oI
            r3 = 1024(0x400, float:1.435E-42)
            if (r1 < r3) goto L4e
            int r9 = r9 - r2
            r2 = r9 & r5
            int r1 = r1 >> 1
            if (r2 <= r1) goto L2
        L4e:
            return r6
        L4f:
            int r1 = r9 + 1
            r1 = r1 & r5
            java.util.concurrent.atomic.AtomicLongFieldUpdater r2 = kotlinx.coroutines.internal.O0xOxO.f30241Oxx0IOOO
            kotlinx.coroutines.internal.O0xOxO$oIX0oI r5 = kotlinx.coroutines.internal.O0xOxO.f30244X0o0xo
            long r5 = r5.I0Io(r3, r1)
            r1 = r2
            r2 = r12
            boolean r1 = r1.compareAndSet(r2, r3, r5)
            if (r1 == 0) goto L2
            java.util.concurrent.atomic.AtomicReferenceArray r0 = r12.f30258oxoX
            r1 = r9 & r10
            r0.set(r1, r13)
            r0 = r12
        L6a:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = kotlinx.coroutines.internal.O0xOxO.f30241Oxx0IOOO
            long r1 = r1.get(r0)
            r3 = 1152921504606846976(0x1000000000000000, double:1.2882297539194267E-231)
            long r1 = r1 & r3
            int r3 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r3 == 0) goto L81
            kotlinx.coroutines.internal.O0xOxO r0 = r0.ooOOo0oXI()
            kotlinx.coroutines.internal.O0xOxO r0 = r0.X0o0xo(r9, r13)
            if (r0 != 0) goto L6a
        L81:
            r13 = 0
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.O0xOxO.oIX0oI(java.lang.Object):int");
    }

    public final O0xOxO<E> oO(int i, int i2) {
        long j;
        int i3;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f30241Oxx0IOOO;
        do {
            j = atomicLongFieldUpdater.get(this);
            i3 = (int) (f30248oOoXoXO & j);
            if ((1152921504606846976L & j) != 0) {
                return ooOOo0oXI();
            }
        } while (!f30241Oxx0IOOO.compareAndSet(this, j, f30244X0o0xo.II0xO0(j, i2)));
        this.f30258oxoX.set(this.f30255I0Io & i3, null);
        return null;
    }

    public final long oOoXoXO() {
        long j;
        long j2;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f30241Oxx0IOOO;
        do {
            j = atomicLongFieldUpdater.get(this);
            if ((j & 1152921504606846976L) != 0) {
                return j;
            }
            j2 = j | 1152921504606846976L;
        } while (!atomicLongFieldUpdater.compareAndSet(this, j, j2));
        return j2;
    }

    @OXOo.OOXIXo
    public final O0xOxO<E> ooOOo0oXI() {
        return I0Io(oOoXoXO());
    }

    public final boolean oxoX() {
        long j;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f30241Oxx0IOOO;
        do {
            j = atomicLongFieldUpdater.get(this);
            if ((j & f30238IXxxXO) != 0) {
                return true;
            }
            if ((1152921504606846976L & j) != 0) {
                return false;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j, j | f30238IXxxXO));
        return true;
    }

    @OXOo.oOoXoXO
    public final Object x0XOIxOo() {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f30241Oxx0IOOO;
        while (true) {
            long j = atomicLongFieldUpdater.get(this);
            if ((1152921504606846976L & j) != 0) {
                return f30246oI0IIXIo;
            }
            int i = (int) (f30248oOoXoXO & j);
            int i2 = (int) ((f30250x0XOIxOo & j) >> 30);
            int i3 = this.f30255I0Io;
            if ((i2 & i3) == (i & i3)) {
                return null;
            }
            Object obj = this.f30258oxoX.get(i3 & i);
            if (obj == null) {
                if (this.f30256II0xO0) {
                    return null;
                }
            } else {
                if (obj instanceof II0xO0) {
                    return null;
                }
                int i4 = (i + 1) & f30252xoIox;
                if (f30241Oxx0IOOO.compareAndSet(this, j, f30244X0o0xo.II0xO0(j, i4))) {
                    this.f30258oxoX.set(this.f30255I0Io & i, null);
                    return obj;
                }
                if (this.f30256II0xO0) {
                    O0xOxO<E> o0xOxO = this;
                    do {
                        o0xOxO = o0xOxO.oO(i, i4);
                    } while (o0xOxO != null);
                    return obj;
                }
            }
        }
    }

    public final void x0xO0oo(AtomicLongFieldUpdater atomicLongFieldUpdater, Oox.oOoXoXO<? super Long, Long> oooxoxo, Object obj) {
        long j;
        do {
            j = atomicLongFieldUpdater.get(obj);
        } while (!atomicLongFieldUpdater.compareAndSet(obj, j, oooxoxo.invoke(Long.valueOf(j)).longValue()));
    }

    public final void xoIox(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Oox.oOoXoXO<Object, oXIO0o0XI> oooxoxo, Object obj) {
        while (true) {
            oooxoxo.invoke(atomicReferenceFieldUpdater.get(obj));
        }
    }

    public final void xxIXOIIO(AtomicLongFieldUpdater atomicLongFieldUpdater, Oox.oOoXoXO<? super Long, oXIO0o0XI> oooxoxo, Object obj) {
        while (true) {
            oooxoxo.invoke(Long.valueOf(atomicLongFieldUpdater.get(obj)));
        }
    }
}
