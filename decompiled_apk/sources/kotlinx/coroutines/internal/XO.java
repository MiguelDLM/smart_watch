package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.oXIO0o0XI;

@kotlin.jvm.internal.XX({"SMAP\nConcurrentLinkedList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConcurrentLinkedList.kt\nkotlinx/coroutines/internal/ConcurrentLinkedListKt\n+ 2 ConcurrentLinkedList.kt\nkotlinx/coroutines/internal/ConcurrentLinkedListNode\n*L\n1#1,269:1\n46#1,8:284\n107#2,7:270\n107#2,7:277\n*S KotlinDebug\n*F\n+ 1 ConcurrentLinkedList.kt\nkotlinx/coroutines/internal/ConcurrentLinkedListKt\n*L\n74#1:284,8\n27#1:270,7\n85#1:277,7\n*E\n"})
/* loaded from: classes6.dex */
public final class XO {

    /* renamed from: II0xO0 */
    @OXOo.OOXIXo
    public static final x0o f30281II0xO0 = new x0o("CLOSED");

    /* renamed from: oIX0oI */
    public static final int f30282oIX0oI = 16;

    public static final boolean I0Io(Object obj, AtomicIntegerArray atomicIntegerArray, int i, int i2, Oox.oOoXoXO<? super Integer, Boolean> oooxoxo) {
        int i3;
        do {
            i3 = atomicIntegerArray.get(i);
            if (!oooxoxo.invoke(Integer.valueOf(i3)).booleanValue()) {
                return false;
            }
        } while (!atomicIntegerArray.compareAndSet(i, i3, i3 + i2));
        return true;
    }

    public static final void II0XooXoX(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Oox.oOoXoXO<Object, oXIO0o0XI> oooxoxo, Object obj) {
        while (true) {
            oooxoxo.invoke(atomicReferenceFieldUpdater.get(obj));
        }
    }

    public static final boolean II0xO0(Object obj, AtomicIntegerFieldUpdater atomicIntegerFieldUpdater, int i, Oox.oOoXoXO<? super Integer, Boolean> oooxoxo) {
        int i2;
        do {
            i2 = atomicIntegerFieldUpdater.get(obj);
            if (!oooxoxo.invoke(Integer.valueOf(i2)).booleanValue()) {
                return false;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(obj, i2, i2 + i));
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final boolean OOXIXo(@OXOo.oOoXoXO Object obj, @OXOo.OOXIXo AtomicReferenceArray atomicReferenceArray, int i, @OXOo.OOXIXo Object obj2) {
        while (true) {
            X00IoxXI x00IoxXI = (X00IoxXI) atomicReferenceArray.get(i);
            if (x00IoxXI.f30276IXxxXO >= obj2.f30276IXxxXO) {
                return true;
            }
            if (!obj2.Oxx0xo()) {
                return false;
            }
            if (com.google.common.util.concurrent.oxoX.oIX0oI(atomicReferenceArray, i, x00IoxXI, obj2)) {
                if (x00IoxXI.oO()) {
                    x00IoxXI.oOoXoXO();
                }
                return true;
            }
            if (obj2.oO()) {
                obj2.oOoXoXO();
            }
        }
    }

    @OXOo.OOXIXo
    public static final <S extends X00IoxXI<S>> Object Oxx0IOOO(@OXOo.OOXIXo S s, long j, @OXOo.OOXIXo Oox.x0xO0oo<? super Long, ? super S, ? extends S> x0xo0oo) {
        while (true) {
            if (s.f30276IXxxXO < j || s.II0XooXoX()) {
                Object XO2 = s.XO();
                if (XO2 == f30281II0xO0) {
                    return IO.II0xO0(f30281II0xO0);
                }
                S s2 = (S) ((Oxx0IOOO) XO2);
                if (s2 == null) {
                    s2 = x0xo0oo.invoke(Long.valueOf(s.f30276IXxxXO + 1), s);
                    if (s.ooOOo0oXI(s2)) {
                        if (s.II0XooXoX()) {
                            s.oOoXoXO();
                        }
                    }
                }
                s = s2;
            } else {
                return IO.II0xO0(s);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @OXOo.OOXIXo
    public static final Object X0o0xo(@OXOo.oOoXoXO Object obj, @OXOo.OOXIXo AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, long j, @OXOo.OOXIXo Object obj2, @OXOo.OOXIXo Oox.x0xO0oo<? super Long, Object, Object> x0xo0oo) {
        Object Oxx0IOOO2;
        loop0: while (true) {
            Oxx0IOOO2 = Oxx0IOOO(obj2, j, x0xo0oo);
            if (!IO.II0XooXoX(Oxx0IOOO2)) {
                X00IoxXI XO2 = IO.XO(Oxx0IOOO2);
                while (true) {
                    X00IoxXI x00IoxXI = (X00IoxXI) atomicReferenceFieldUpdater.get(obj);
                    if (x00IoxXI.f30276IXxxXO >= XO2.f30276IXxxXO) {
                        break loop0;
                    }
                    if (!XO2.Oxx0xo()) {
                        break;
                    }
                    if (androidx.concurrent.futures.oIX0oI.oIX0oI(atomicReferenceFieldUpdater, obj, x00IoxXI, XO2)) {
                        if (x00IoxXI.oO()) {
                            x00IoxXI.oOoXoXO();
                        }
                    } else if (XO2.oO()) {
                        XO2.oOoXoXO();
                    }
                }
            } else {
                break;
            }
        }
        return Oxx0IOOO2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @OXOo.OOXIXo
    public static final Object XO(@OXOo.oOoXoXO Object obj, @OXOo.OOXIXo AtomicReferenceArray atomicReferenceArray, int i, long j, @OXOo.OOXIXo Object obj2, @OXOo.OOXIXo Oox.x0xO0oo<? super Long, Object, Object> x0xo0oo) {
        Object Oxx0IOOO2;
        loop0: while (true) {
            Oxx0IOOO2 = Oxx0IOOO(obj2, j, x0xo0oo);
            if (!IO.II0XooXoX(Oxx0IOOO2)) {
                X00IoxXI XO2 = IO.XO(Oxx0IOOO2);
                while (true) {
                    X00IoxXI x00IoxXI = (X00IoxXI) atomicReferenceArray.get(i);
                    if (x00IoxXI.f30276IXxxXO >= XO2.f30276IXxxXO) {
                        break loop0;
                    }
                    if (!XO2.Oxx0xo()) {
                        break;
                    }
                    if (com.google.common.util.concurrent.oxoX.oIX0oI(atomicReferenceArray, i, x00IoxXI, XO2)) {
                        if (x00IoxXI.oO()) {
                            x00IoxXI.oOoXoXO();
                        }
                    } else if (XO2.oO()) {
                        XO2.oOoXoXO();
                    }
                }
            } else {
                break;
            }
        }
        return Oxx0IOOO2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [kotlinx.coroutines.internal.Oxx0IOOO] */
    @OXOo.OOXIXo
    public static final <N extends Oxx0IOOO<N>> N oxoX(@OXOo.OOXIXo N n) {
        while (true) {
            Object XO2 = n.XO();
            if (XO2 == f30281II0xO0) {
                return n;
            }
            ?? r0 = (Oxx0IOOO) XO2;
            if (r0 == 0) {
                if (n.xoIox()) {
                    return n;
                }
            } else {
                n = r0;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final boolean xoIox(@OXOo.oOoXoXO Object obj, @OXOo.OOXIXo AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, @OXOo.OOXIXo Object obj2) {
        while (true) {
            X00IoxXI x00IoxXI = (X00IoxXI) atomicReferenceFieldUpdater.get(obj);
            if (x00IoxXI.f30276IXxxXO >= obj2.f30276IXxxXO) {
                return true;
            }
            if (!obj2.Oxx0xo()) {
                return false;
            }
            if (androidx.concurrent.futures.oIX0oI.oIX0oI(atomicReferenceFieldUpdater, obj, x00IoxXI, obj2)) {
                if (x00IoxXI.oO()) {
                    x00IoxXI.oOoXoXO();
                }
                return true;
            }
            if (obj2.oO()) {
                obj2.oOoXoXO();
            }
        }
    }

    public static final void xxIXOIIO(AtomicReferenceArray atomicReferenceArray, int i, Oox.oOoXoXO<Object, oXIO0o0XI> oooxoxo) {
        while (true) {
            oooxoxo.invoke(atomicReferenceArray.get(i));
        }
    }
}
