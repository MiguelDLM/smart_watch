package kotlin.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes6.dex */
public abstract class oIX0oI<T> implements Iterator<T>, OI0IXox.oIX0oI {

    /* renamed from: Oo, reason: collision with root package name */
    @OXOo.oOoXoXO
    public T f29152Oo;

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public State f29153XO = State.NotReady;

    /* renamed from: kotlin.collections.oIX0oI$oIX0oI, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public /* synthetic */ class C1104oIX0oI {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public static final /* synthetic */ int[] f29154oIX0oI;

        static {
            int[] iArr = new int[State.values().length];
            try {
                iArr[State.Done.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[State.Ready.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f29154oIX0oI = iArr;
        }
    }

    public final void II0xO0() {
        this.f29153XO = State.Done;
    }

    public final boolean X0o0xo() {
        this.f29153XO = State.Failed;
        oIX0oI();
        if (this.f29153XO == State.Ready) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        State state = this.f29153XO;
        if (state != State.Failed) {
            int i = C1104oIX0oI.f29154oIX0oI[state.ordinal()];
            if (i != 1) {
                if (i == 2) {
                    return true;
                }
                return X0o0xo();
            }
            return false;
        }
        throw new IllegalArgumentException("Failed requirement.");
    }

    @Override // java.util.Iterator
    public T next() {
        if (hasNext()) {
            this.f29153XO = State.NotReady;
            return this.f29152Oo;
        }
        throw new NoSuchElementException();
    }

    public abstract void oIX0oI();

    public final void oxoX(T t) {
        this.f29152Oo = t;
        this.f29153XO = State.Ready;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
