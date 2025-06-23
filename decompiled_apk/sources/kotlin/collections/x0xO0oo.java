package kotlin.collections;

import java.util.Iterator;

/* loaded from: classes6.dex */
public abstract class x0xO0oo implements Iterator<Byte>, OI0IXox.oIX0oI {
    public abstract byte II0xO0();

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ Byte next() {
        return Byte.valueOf(II0xO0());
    }

    @OXOo.OOXIXo
    public final Byte oIX0oI() {
        return Byte.valueOf(II0xO0());
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
