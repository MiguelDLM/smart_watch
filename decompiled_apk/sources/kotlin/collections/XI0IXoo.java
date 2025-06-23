package kotlin.collections;

import java.util.Iterator;

/* loaded from: classes6.dex */
public abstract class XI0IXoo implements Iterator<Double>, OI0IXox.oIX0oI {
    public abstract double II0xO0();

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ Double next() {
        return Double.valueOf(II0xO0());
    }

    @OXOo.OOXIXo
    public final Double oIX0oI() {
        return Double.valueOf(II0xO0());
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
