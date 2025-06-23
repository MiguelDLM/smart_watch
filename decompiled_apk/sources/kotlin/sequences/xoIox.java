package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes6.dex */
public final class xoIox<T> implements ooOOo0oXI<T> {

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Oox.oOoXoXO<T, T> f29490II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Oox.oIX0oI<T> f29491oIX0oI;

    /* loaded from: classes6.dex */
    public static final class oIX0oI implements Iterator<T>, OI0IXox.oIX0oI {

        /* renamed from: IXxxXO, reason: collision with root package name */
        public final /* synthetic */ xoIox<T> f29492IXxxXO;

        /* renamed from: Oo, reason: collision with root package name */
        public int f29493Oo = -2;

        /* renamed from: XO, reason: collision with root package name */
        @OXOo.oOoXoXO
        public T f29494XO;

        public oIX0oI(xoIox<T> xoiox) {
            this.f29492IXxxXO = xoiox;
        }

        private final void oIX0oI() {
            T t;
            int i;
            if (this.f29493Oo != -2) {
                Oox.oOoXoXO oooxoxo = this.f29492IXxxXO.f29490II0xO0;
                T t2 = this.f29494XO;
                IIX0o.ooOOo0oXI(t2);
                t = (T) oooxoxo.invoke(t2);
            } else {
                t = (T) this.f29492IXxxXO.f29491oIX0oI.invoke();
            }
            this.f29494XO = t;
            if (t == null) {
                i = 0;
            } else {
                i = 1;
            }
            this.f29493Oo = i;
        }

        @OXOo.oOoXoXO
        public final T II0xO0() {
            return this.f29494XO;
        }

        public final void X0o0xo(@OXOo.oOoXoXO T t) {
            this.f29494XO = t;
        }

        public final void XO(int i) {
            this.f29493Oo = i;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f29493Oo < 0) {
                oIX0oI();
            }
            if (this.f29493Oo == 1) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        @OXOo.OOXIXo
        public T next() {
            if (this.f29493Oo < 0) {
                oIX0oI();
            }
            if (this.f29493Oo != 0) {
                T t = this.f29494XO;
                IIX0o.x0XOIxOo(t, "null cannot be cast to non-null type T of kotlin.sequences.GeneratorSequence");
                this.f29493Oo = -1;
                return t;
            }
            throw new NoSuchElementException();
        }

        public final int oxoX() {
            return this.f29493Oo;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public xoIox(@OXOo.OOXIXo Oox.oIX0oI<? extends T> getInitialValue, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends T> getNextValue) {
        IIX0o.x0xO0oo(getInitialValue, "getInitialValue");
        IIX0o.x0xO0oo(getNextValue, "getNextValue");
        this.f29491oIX0oI = getInitialValue;
        this.f29490II0xO0 = getNextValue;
    }

    @Override // kotlin.sequences.ooOOo0oXI
    @OXOo.OOXIXo
    public Iterator<T> iterator() {
        return new oIX0oI(this);
    }
}
