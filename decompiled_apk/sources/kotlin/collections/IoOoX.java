package kotlin.collections;

import java.util.Iterator;

/* loaded from: classes6.dex */
public final class IoOoX<T> implements Iterator<xI<? extends T>>, OI0IXox.oIX0oI {

    /* renamed from: Oo, reason: collision with root package name */
    public int f29121Oo;

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Iterator<T> f29122XO;

    /* JADX WARN: Multi-variable type inference failed */
    public IoOoX(@OXOo.OOXIXo Iterator<? extends T> iterator) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterator, "iterator");
        this.f29122XO = iterator;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f29122XO.hasNext();
    }

    @Override // java.util.Iterator
    @OXOo.OOXIXo
    /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
    public final xI<T> next() {
        int i = this.f29121Oo;
        this.f29121Oo = i + 1;
        if (i < 0) {
            CollectionsKt__CollectionsKt.XoX();
        }
        return new xI<>(i, this.f29122XO.next());
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
