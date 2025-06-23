package kotlin.collections;

import java.util.Iterator;

/* loaded from: classes6.dex */
public abstract class oOXoIIIo implements Iterator<Integer>, OI0IXox.oIX0oI {
    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ Integer next() {
        return Integer.valueOf(nextInt());
    }

    public abstract int nextInt();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    @OXOo.OOXIXo
    public final Integer next() {
        return Integer.valueOf(nextInt());
    }
}
