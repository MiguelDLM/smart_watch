package kotlin.collections;

import java.util.Iterator;

/* loaded from: classes6.dex */
public abstract class IXxxXO implements Iterator<Character>, OI0IXox.oIX0oI {
    public abstract char II0xO0();

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ Character next() {
        return Character.valueOf(II0xO0());
    }

    @OXOo.OOXIXo
    public final Character oIX0oI() {
        return Character.valueOf(II0xO0());
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
