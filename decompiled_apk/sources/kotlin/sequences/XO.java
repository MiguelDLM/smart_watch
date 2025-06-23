package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes6.dex */
public final class XO<T> implements ooOOo0oXI<T> {

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Oox.oOoXoXO<T, Boolean> f29459II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public final ooOOo0oXI<T> f29460oIX0oI;

    /* loaded from: classes6.dex */
    public static final class oIX0oI implements Iterator<T>, OI0IXox.oIX0oI {

        /* renamed from: IXxxXO, reason: collision with root package name */
        @OXOo.oOoXoXO
        public T f29461IXxxXO;

        /* renamed from: Oo, reason: collision with root package name */
        public int f29462Oo = -1;

        /* renamed from: Oxx0xo, reason: collision with root package name */
        public final /* synthetic */ XO<T> f29463Oxx0xo;

        /* renamed from: XO, reason: collision with root package name */
        @OXOo.OOXIXo
        public final Iterator<T> f29464XO;

        public oIX0oI(XO<T> xo2) {
            this.f29463Oxx0xo = xo2;
            this.f29464XO = xo2.f29460oIX0oI.iterator();
        }

        private final void oIX0oI() {
            while (this.f29464XO.hasNext()) {
                T next = this.f29464XO.next();
                if (!((Boolean) this.f29463Oxx0xo.f29459II0xO0.invoke(next)).booleanValue()) {
                    this.f29461IXxxXO = next;
                    this.f29462Oo = 1;
                    return;
                }
            }
            this.f29462Oo = 0;
        }

        public final int II0xO0() {
            return this.f29462Oo;
        }

        public final void Oxx0IOOO(@OXOo.oOoXoXO T t) {
            this.f29461IXxxXO = t;
        }

        @OXOo.oOoXoXO
        public final T X0o0xo() {
            return this.f29461IXxxXO;
        }

        public final void XO(int i) {
            this.f29462Oo = i;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f29462Oo == -1) {
                oIX0oI();
            }
            if (this.f29462Oo == 1 || this.f29464XO.hasNext()) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.f29462Oo == -1) {
                oIX0oI();
            }
            if (this.f29462Oo == 1) {
                T t = this.f29461IXxxXO;
                this.f29461IXxxXO = null;
                this.f29462Oo = 0;
                return t;
            }
            return this.f29464XO.next();
        }

        @OXOo.OOXIXo
        public final Iterator<T> oxoX() {
            return this.f29464XO;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public XO(@OXOo.OOXIXo ooOOo0oXI<? extends T> sequence, @OXOo.OOXIXo Oox.oOoXoXO<? super T, Boolean> predicate) {
        IIX0o.x0xO0oo(sequence, "sequence");
        IIX0o.x0xO0oo(predicate, "predicate");
        this.f29460oIX0oI = sequence;
        this.f29459II0xO0 = predicate;
    }

    @Override // kotlin.sequences.ooOOo0oXI
    @OXOo.OOXIXo
    public Iterator<T> iterator() {
        return new oIX0oI(this);
    }
}
