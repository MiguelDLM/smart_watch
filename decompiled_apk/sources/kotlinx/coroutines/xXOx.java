package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;

@kotlin.o0
/* loaded from: classes6.dex */
public final class xXOx<T> extends kotlinx.coroutines.internal.Xx000oIo<T> {

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final AtomicIntegerFieldUpdater f30484oI0IIXIo = AtomicIntegerFieldUpdater.newUpdater(xXOx.class, "_decision");

    @XO0OX.XO
    @XO0OX.o00
    private volatile int _decision;

    public xXOx(@OXOo.OOXIXo CoroutineContext coroutineContext, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super T> i0Io) {
        super(coroutineContext, i0Io);
    }

    @OXOo.OOXIXo
    public static final AtomicIntegerFieldUpdater OIx00oxx() {
        return f30484oI0IIXIo;
    }

    @Override // kotlinx.coroutines.internal.Xx000oIo, kotlinx.coroutines.JobSupport
    public void I0X0x0oIo(@OXOo.oOoXoXO Object obj) {
        OX(obj);
    }

    public final boolean O00() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f30484oI0IIXIo;
        do {
            int i = atomicIntegerFieldUpdater.get(this);
            if (i != 0) {
                if (i == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended");
            }
        } while (!f30484oI0IIXIo.compareAndSet(this, 0, 1));
        return true;
    }

    @Override // kotlinx.coroutines.internal.Xx000oIo, kotlinx.coroutines.oIX0oI
    public void OX(@OXOo.oOoXoXO Object obj) {
        if (xxxI()) {
            return;
        }
        kotlinx.coroutines.internal.ooOOo0oXI.X0o0xo(IntrinsicsKt__IntrinsicsJvmKt.X0o0xo(this.f30289Oxx0xo), xI.oIX0oI(obj, this.f30289Oxx0xo), null, 2, null);
    }

    @OXOo.oOoXoXO
    public final Object OooI() {
        if (O00()) {
            return kotlin.coroutines.intrinsics.II0xO0.oOoXoXO();
        }
        Object II0XooXoX2 = xI0oxI00.II0XooXoX(oXIO0o0XI());
        if (!(II0XooXoX2 instanceof xxX)) {
            return II0XooXoX2;
        }
        throw ((xxX) II0XooXoX2).f30502oIX0oI;
    }

    public final void xIXX(AtomicIntegerFieldUpdater atomicIntegerFieldUpdater, Oox.oOoXoXO<? super Integer, kotlin.oXIO0o0XI> oooxoxo, Object obj) {
        while (true) {
            oooxoxo.invoke(Integer.valueOf(atomicIntegerFieldUpdater.get(obj)));
        }
    }

    public final boolean xxxI() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f30484oI0IIXIo;
        do {
            int i = atomicIntegerFieldUpdater.get(this);
            if (i != 0) {
                if (i == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed");
            }
        } while (!f30484oI0IIXIo.compareAndSet(this, 0, 2));
        return true;
    }
}
