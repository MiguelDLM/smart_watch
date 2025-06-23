package kotlin.collections;

import java.util.Iterator;

/* loaded from: classes6.dex */
public abstract class oO implements Iterator<Boolean>, OI0IXox.oIX0oI {
    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ Boolean next() {
        return Boolean.valueOf(nextBoolean());
    }

    public abstract boolean nextBoolean();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    @OXOo.OOXIXo
    public final Boolean next() {
        return Boolean.valueOf(nextBoolean());
    }
}
