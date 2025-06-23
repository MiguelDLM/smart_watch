package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.I0oOoX;
import kotlin.Result;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.IIX0o;
import kotlin.oXIO0o0XI;

/* loaded from: classes6.dex */
public final class x0XOIxOo<T> extends oO<T> implements Iterator<T>, kotlin.coroutines.I0Io<oXIO0o0XI>, OI0IXox.oIX0oI {

    /* renamed from: IXxxXO, reason: collision with root package name */
    @OXOo.oOoXoXO
    public Iterator<? extends T> f29486IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    @OXOo.oOoXoXO
    public T f29487Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    @OXOo.oOoXoXO
    public kotlin.coroutines.I0Io<? super oXIO0o0XI> f29488Oxx0xo;

    /* renamed from: XO, reason: collision with root package name */
    public int f29489XO;

    @Override // kotlin.sequences.oO
    @OXOo.oOoXoXO
    public Object II0xO0(T t, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        this.f29487Oo = t;
        this.f29489XO = 3;
        this.f29488Oxx0xo = i0Io;
        Object oOoXoXO2 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO();
        if (oOoXoXO2 == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
            IXIxx0.XO.I0Io(i0Io);
        }
        if (oOoXoXO2 == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
            return oOoXoXO2;
        }
        return oXIO0o0XI.f29392oIX0oI;
    }

    public final void OOXIXo(@OXOo.oOoXoXO kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        this.f29488Oxx0xo = i0Io;
    }

    public final Throwable Oxx0IOOO() {
        int i = this.f29489XO;
        if (i != 4) {
            if (i != 5) {
                return new IllegalStateException("Unexpected state of the iterator: " + this.f29489XO);
            }
            return new IllegalStateException("Iterator has failed.");
        }
        return new NoSuchElementException();
    }

    @Override // kotlin.sequences.oO
    @OXOo.oOoXoXO
    public Object X0o0xo(@OXOo.OOXIXo Iterator<? extends T> it, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        if (!it.hasNext()) {
            return oXIO0o0XI.f29392oIX0oI;
        }
        this.f29486IXxxXO = it;
        this.f29489XO = 2;
        this.f29488Oxx0xo = i0Io;
        Object oOoXoXO2 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO();
        if (oOoXoXO2 == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
            IXIxx0.XO.I0Io(i0Io);
        }
        if (oOoXoXO2 == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
            return oOoXoXO2;
        }
        return oXIO0o0XI.f29392oIX0oI;
    }

    @Override // kotlin.coroutines.I0Io
    @OXOo.OOXIXo
    public CoroutineContext getContext() {
        return EmptyCoroutineContext.INSTANCE;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        while (true) {
            int i = this.f29489XO;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2 || i == 3) {
                        return true;
                    }
                    if (i == 4) {
                        return false;
                    }
                    throw Oxx0IOOO();
                }
                Iterator<? extends T> it = this.f29486IXxxXO;
                IIX0o.ooOOo0oXI(it);
                if (it.hasNext()) {
                    this.f29489XO = 2;
                    return true;
                }
                this.f29486IXxxXO = null;
            }
            this.f29489XO = 5;
            kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io = this.f29488Oxx0xo;
            IIX0o.ooOOo0oXI(i0Io);
            this.f29488Oxx0xo = null;
            Result.oIX0oI oix0oi = Result.Companion;
            i0Io.resumeWith(Result.m287constructorimpl(oXIO0o0XI.f29392oIX0oI));
        }
    }

    @Override // java.util.Iterator
    public T next() {
        int i = this.f29489XO;
        if (i != 0 && i != 1) {
            if (i != 2) {
                if (i == 3) {
                    this.f29489XO = 0;
                    T t = this.f29487Oo;
                    this.f29487Oo = null;
                    return t;
                }
                throw Oxx0IOOO();
            }
            this.f29489XO = 1;
            Iterator<? extends T> it = this.f29486IXxxXO;
            IIX0o.ooOOo0oXI(it);
            return it.next();
        }
        return xoIox();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // kotlin.coroutines.I0Io
    public void resumeWith(@OXOo.OOXIXo Object obj) {
        I0oOoX.x0XOIxOo(obj);
        this.f29489XO = 4;
    }

    public final T xoIox() {
        if (hasNext()) {
            return next();
        }
        throw new NoSuchElementException();
    }

    @OXOo.oOoXoXO
    public final kotlin.coroutines.I0Io<oXIO0o0XI> xxIXOIIO() {
        return this.f29488Oxx0xo;
    }
}
