package kotlin.jvm.internal;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes6.dex */
public final class Oxx0IOOO<T> implements Iterator<T>, OI0IXox.oIX0oI {

    /* renamed from: Oo, reason: collision with root package name */
    public int f29300Oo;

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final T[] f29301XO;

    public Oxx0IOOO(@OXOo.OOXIXo T[] array) {
        IIX0o.x0xO0oo(array, "array");
        this.f29301XO = array;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.f29300Oo < this.f29301XO.length) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public T next() {
        try {
            T[] tArr = this.f29301XO;
            int i = this.f29300Oo;
            this.f29300Oo = i + 1;
            return tArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.f29300Oo--;
            throw new NoSuchElementException(e.getMessage());
        }
    }

    @OXOo.OOXIXo
    public final T[] oIX0oI() {
        return this.f29301XO;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
