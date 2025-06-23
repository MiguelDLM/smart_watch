package kotlinx.coroutines.internal;

import java.lang.Comparable;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.OX00O0xII;
import kotlinx.coroutines.internal.xXOx;

@kotlin.jvm.internal.XX({"SMAP\nThreadSafeHeap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ThreadSafeHeap.kt\nkotlinx/coroutines/internal/ThreadSafeHeap\n+ 2 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 3 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,168:1\n28#2,4:169\n28#2,4:174\n28#2,4:179\n28#2,4:184\n28#2,4:189\n28#2,4:194\n28#2,4:199\n28#2,4:204\n20#3:173\n20#3:178\n20#3:183\n20#3:188\n20#3:193\n20#3:198\n20#3:203\n20#3:208\n1#4:209\n*S KotlinDebug\n*F\n+ 1 ThreadSafeHeap.kt\nkotlinx/coroutines/internal/ThreadSafeHeap\n*L\n35#1:169,4\n42#1:174,4\n50#1:179,4\n52#1:184,4\n60#1:189,4\n69#1:194,4\n72#1:199,4\n81#1:204,4\n35#1:173\n42#1:178\n50#1:183\n52#1:188\n60#1:193\n69#1:198\n72#1:203\n81#1:208\n*E\n"})
@OX00O0xII
/* loaded from: classes6.dex */
public class xo0x<T extends xXOx & Comparable<? super T>> {

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final AtomicIntegerFieldUpdater f30321II0xO0 = AtomicIntegerFieldUpdater.newUpdater(xo0x.class, "_size");

    @XO0OX.o00
    private volatile int _size;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.oOoXoXO
    public T[] f30322oIX0oI;

    public final boolean I0Io(@OXOo.OOXIXo T t, @OXOo.OOXIXo Oox.oOoXoXO<? super T, Boolean> oooxoxo) {
        boolean z;
        synchronized (this) {
            try {
                if (oooxoxo.invoke(XO()).booleanValue()) {
                    oIX0oI(t);
                    z = true;
                } else {
                    z = false;
                }
                kotlin.jvm.internal.xxX.oxoX(1);
            } catch (Throwable th) {
                kotlin.jvm.internal.xxX.oxoX(1);
                kotlin.jvm.internal.xxX.I0Io(1);
                throw th;
            }
        }
        kotlin.jvm.internal.xxX.I0Io(1);
        return z;
    }

    public final boolean II0XooXoX() {
        if (Oxx0IOOO() == 0) {
            return true;
        }
        return false;
    }

    public final void II0xO0(@OXOo.OOXIXo T t) {
        synchronized (this) {
            oIX0oI(t);
            oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
        }
    }

    public final void IXxxXO(int i, int i2) {
        T[] tArr = this.f30322oIX0oI;
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(tArr);
        T t = tArr[i2];
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(t);
        T t2 = tArr[i];
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(t2);
        tArr[i] = t;
        tArr[i2] = t2;
        t.II0XooXoX(i);
        t2.II0XooXoX(i2);
    }

    public final boolean OOXIXo(@OXOo.OOXIXo T t) {
        boolean z;
        synchronized (this) {
            if (t.Oxx0IOOO() == null) {
                z = false;
            } else {
                oOoXoXO(t.I0Io());
                z = true;
            }
        }
        return z;
    }

    public final void Oo(int i) {
        while (i > 0) {
            T[] tArr = this.f30322oIX0oI;
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(tArr);
            int i2 = (i - 1) / 2;
            T t = tArr[i2];
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(t);
            T t2 = tArr[i];
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(t2);
            if (((Comparable) t).compareTo(t2) <= 0) {
                return;
            }
            IXxxXO(i, i2);
            i = i2;
        }
    }

    public final int Oxx0IOOO() {
        return f30321II0xO0.get(this);
    }

    @OXOo.oOoXoXO
    public final T X0o0xo(@OXOo.OOXIXo Oox.oOoXoXO<? super T, Boolean> oooxoxo) {
        T t;
        synchronized (this) {
            try {
                int Oxx0IOOO2 = Oxx0IOOO();
                int i = 0;
                while (true) {
                    t = null;
                    if (i >= Oxx0IOOO2) {
                        break;
                    }
                    T[] tArr = this.f30322oIX0oI;
                    if (tArr != null) {
                        t = (Object) tArr[i];
                    }
                    kotlin.jvm.internal.IIX0o.ooOOo0oXI(t);
                    if (oooxoxo.invoke(t).booleanValue()) {
                        break;
                    }
                    i++;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return t;
    }

    @kotlin.o0
    @OXOo.oOoXoXO
    public final T XO() {
        T[] tArr = this.f30322oIX0oI;
        if (tArr != null) {
            return tArr[0];
        }
        return null;
    }

    @kotlin.o0
    public final void oIX0oI(@OXOo.OOXIXo T t) {
        t.oxoX(this);
        T[] xoIox2 = xoIox();
        int Oxx0IOOO2 = Oxx0IOOO();
        oO(Oxx0IOOO2 + 1);
        xoIox2[Oxx0IOOO2] = t;
        t.II0XooXoX(Oxx0IOOO2);
        Oo(Oxx0IOOO2);
    }

    public final void oO(int i) {
        f30321II0xO0.set(this, i);
    }

    @OXOo.OOXIXo
    @kotlin.o0
    public final T oOoXoXO(int i) {
        T[] tArr = this.f30322oIX0oI;
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(tArr);
        oO(Oxx0IOOO() - 1);
        if (i < Oxx0IOOO()) {
            IXxxXO(i, Oxx0IOOO());
            int i2 = (i - 1) / 2;
            if (i > 0) {
                T t = tArr[i];
                kotlin.jvm.internal.IIX0o.ooOOo0oXI(t);
                T t2 = tArr[i2];
                kotlin.jvm.internal.IIX0o.ooOOo0oXI(t2);
                if (((Comparable) t).compareTo(t2) < 0) {
                    IXxxXO(i, i2);
                    Oo(i2);
                }
            }
            x0xO0oo(i);
        }
        T t3 = tArr[Oxx0IOOO()];
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(t3);
        t3.oxoX(null);
        t3.II0XooXoX(-1);
        tArr[Oxx0IOOO()] = null;
        return t3;
    }

    @OXOo.oOoXoXO
    public final T ooOOo0oXI(@OXOo.OOXIXo Oox.oOoXoXO<? super T, Boolean> oooxoxo) {
        synchronized (this) {
            try {
                T XO2 = XO();
                T t = null;
                if (XO2 == null) {
                    kotlin.jvm.internal.xxX.oxoX(2);
                    kotlin.jvm.internal.xxX.I0Io(2);
                    return null;
                }
                if (oooxoxo.invoke(XO2).booleanValue()) {
                    t = oOoXoXO(0);
                }
                kotlin.jvm.internal.xxX.oxoX(1);
                kotlin.jvm.internal.xxX.I0Io(1);
                return t;
            } catch (Throwable th) {
                kotlin.jvm.internal.xxX.oxoX(1);
                kotlin.jvm.internal.xxX.I0Io(1);
                throw th;
            }
        }
    }

    public final void oxoX() {
        synchronized (this) {
            try {
                T[] tArr = this.f30322oIX0oI;
                if (tArr != null) {
                    kotlin.collections.ooOOo0oXI.o0Xo(tArr, null, 0, 0, 6, null);
                }
                f30321II0xO0.set(this, 0);
                oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @OXOo.oOoXoXO
    public final T x0XOIxOo() {
        T t;
        synchronized (this) {
            if (Oxx0IOOO() > 0) {
                t = oOoXoXO(0);
            } else {
                t = null;
            }
        }
        return t;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0028, code lost:
    
        if (((java.lang.Comparable) r3).compareTo(r4) < 0) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void x0xO0oo(int r6) {
        /*
            r5 = this;
        L0:
            int r0 = r6 * 2
            int r1 = r0 + 1
            int r2 = r5.Oxx0IOOO()
            if (r1 < r2) goto Lb
            return
        Lb:
            T extends kotlinx.coroutines.internal.xXOx & java.lang.Comparable<? super T>[] r2 = r5.f30322oIX0oI
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(r2)
            int r0 = r0 + 2
            int r3 = r5.Oxx0IOOO()
            if (r0 >= r3) goto L2b
            r3 = r2[r0]
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(r3)
            java.lang.Comparable r3 = (java.lang.Comparable) r3
            r4 = r2[r1]
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(r4)
            int r3 = r3.compareTo(r4)
            if (r3 >= 0) goto L2b
            goto L2c
        L2b:
            r0 = r1
        L2c:
            r1 = r2[r6]
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(r1)
            java.lang.Comparable r1 = (java.lang.Comparable) r1
            r2 = r2[r0]
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(r2)
            int r1 = r1.compareTo(r2)
            if (r1 > 0) goto L3f
            return
        L3f:
            r5.IXxxXO(r6, r0)
            r6 = r0
            goto L0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.xo0x.x0xO0oo(int):void");
    }

    public final T[] xoIox() {
        T[] tArr = this.f30322oIX0oI;
        if (tArr == null) {
            T[] tArr2 = (T[]) new xXOx[4];
            this.f30322oIX0oI = tArr2;
            return tArr2;
        }
        if (Oxx0IOOO() >= tArr.length) {
            Object[] copyOf = Arrays.copyOf(tArr, Oxx0IOOO() * 2);
            kotlin.jvm.internal.IIX0o.oO(copyOf, "copyOf(this, newSize)");
            T[] tArr3 = (T[]) ((xXOx[]) copyOf);
            this.f30322oIX0oI = tArr3;
            return tArr3;
        }
        return tArr;
    }

    @OXOo.oOoXoXO
    public final T xxIXOIIO() {
        T XO2;
        synchronized (this) {
            XO2 = XO();
        }
        return XO2;
    }
}
