package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlinx.coroutines.internal.Oxx0IOOO;

@kotlin.jvm.internal.XX({"SMAP\nConcurrentLinkedList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConcurrentLinkedList.kt\nkotlinx/coroutines/internal/ConcurrentLinkedListNode\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,269:1\n107#1,7:270\n1#2:277\n*S KotlinDebug\n*F\n+ 1 ConcurrentLinkedList.kt\nkotlinx/coroutines/internal/ConcurrentLinkedListNode\n*L\n115#1:270,7\n*E\n"})
/* loaded from: classes6.dex */
public abstract class Oxx0IOOO<N extends Oxx0IOOO<N>> {

    @OXOo.oOoXoXO
    @XO0OX.o00
    private volatile Object _next;

    @OXOo.oOoXoXO
    @XO0OX.o00
    private volatile Object _prev;

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final AtomicReferenceFieldUpdater f30262XO = AtomicReferenceFieldUpdater.newUpdater(Oxx0IOOO.class, Object.class, "_next");

    /* renamed from: Oo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final AtomicReferenceFieldUpdater f30261Oo = AtomicReferenceFieldUpdater.newUpdater(Oxx0IOOO.class, Object.class, "_prev");

    public Oxx0IOOO(@OXOo.oOoXoXO N n) {
        this._prev = n;
    }

    private final void x0XOIxOo(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Oox.oOoXoXO<Object, ? extends Object> oooxoxo, Object obj) {
        Object obj2;
        do {
            obj2 = atomicReferenceFieldUpdater.get(obj);
        } while (!androidx.concurrent.futures.oIX0oI.oIX0oI(atomicReferenceFieldUpdater, obj, obj2, oooxoxo.invoke(obj2)));
    }

    public final N I0Io() {
        N Oxx0IOOO2 = Oxx0IOOO();
        while (Oxx0IOOO2 != null && Oxx0IOOO2.II0XooXoX()) {
            Oxx0IOOO2 = (N) f30261Oo.get(Oxx0IOOO2);
        }
        return Oxx0IOOO2;
    }

    public abstract boolean II0XooXoX();

    public final void II0xO0() {
        f30261Oo.lazySet(this, null);
    }

    @OXOo.oOoXoXO
    public final N OOXIXo(@OXOo.OOXIXo Oox.oIX0oI oix0oi) {
        Object XO2 = XO();
        if (XO2 != XO.oIX0oI()) {
            return (N) XO2;
        }
        oix0oi.invoke();
        throw new KotlinNothingValueException();
    }

    @OXOo.oOoXoXO
    public final N Oxx0IOOO() {
        return (N) f30261Oo.get(this);
    }

    @OXOo.oOoXoXO
    public final N X0o0xo() {
        Object XO2 = XO();
        if (XO2 == XO.oIX0oI()) {
            return null;
        }
        return (N) XO2;
    }

    public final Object XO() {
        return f30262XO.get(this);
    }

    public final void oOoXoXO() {
        Object obj;
        N n;
        if (xxIXOIIO()) {
            return;
        }
        while (true) {
            N I0Io2 = I0Io();
            N oxoX2 = oxoX();
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f30261Oo;
            do {
                obj = atomicReferenceFieldUpdater.get(oxoX2);
                if (((Oxx0IOOO) obj) == null) {
                    n = null;
                } else {
                    n = I0Io2;
                }
            } while (!androidx.concurrent.futures.oIX0oI.oIX0oI(atomicReferenceFieldUpdater, oxoX2, obj, n));
            if (I0Io2 != null) {
                f30262XO.set(I0Io2, oxoX2);
            }
            if (!oxoX2.II0XooXoX() || oxoX2.xxIXOIIO()) {
                if (I0Io2 == null || !I0Io2.II0XooXoX()) {
                    return;
                }
            }
        }
    }

    public final boolean ooOOo0oXI(@OXOo.OOXIXo N n) {
        return androidx.concurrent.futures.oIX0oI.oIX0oI(f30262XO, this, null, n);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [kotlinx.coroutines.internal.Oxx0IOOO] */
    public final N oxoX() {
        N X0o0xo2 = X0o0xo();
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(X0o0xo2);
        while (X0o0xo2.II0XooXoX()) {
            ?? X0o0xo3 = X0o0xo2.X0o0xo();
            if (X0o0xo3 == 0) {
                return X0o0xo2;
            }
            X0o0xo2 = X0o0xo3;
        }
        return X0o0xo2;
    }

    public final boolean xoIox() {
        return androidx.concurrent.futures.oIX0oI.oIX0oI(f30262XO, this, null, XO.oIX0oI());
    }

    public final boolean xxIXOIIO() {
        if (X0o0xo() == null) {
            return true;
        }
        return false;
    }
}
