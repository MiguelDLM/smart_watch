package kotlin.collections;

import java.util.Iterator;

/* loaded from: classes6.dex */
public abstract class O0Xx implements Iterator<Short>, OI0IXox.oIX0oI {
    public abstract short II0xO0();

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ Short next() {
        return Short.valueOf(II0xO0());
    }

    @OXOo.OOXIXo
    public final Short oIX0oI() {
        return Short.valueOf(II0xO0());
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
