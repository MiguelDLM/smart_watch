package kotlin.collections;

import java.util.Iterator;

/* loaded from: classes6.dex */
public abstract class Xx000oIo implements Iterator<Long>, OI0IXox.oIX0oI {
    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ Long next() {
        return Long.valueOf(nextLong());
    }

    public abstract long nextLong();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    @OXOo.OOXIXo
    public final Long next() {
        return Long.valueOf(nextLong());
    }
}
