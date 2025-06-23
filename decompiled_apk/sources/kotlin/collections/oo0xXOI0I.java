package kotlin.collections;

import java.util.Iterator;

/* loaded from: classes6.dex */
public final class oo0xXOI0I<T> implements Iterable<xI<? extends T>>, OI0IXox.oIX0oI {

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Oox.oIX0oI<Iterator<T>> f29155XO;

    /* JADX WARN: Multi-variable type inference failed */
    public oo0xXOI0I(@OXOo.OOXIXo Oox.oIX0oI<? extends Iterator<? extends T>> iteratorFactory) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iteratorFactory, "iteratorFactory");
        this.f29155XO = iteratorFactory;
    }

    @Override // java.lang.Iterable
    @OXOo.OOXIXo
    public Iterator<xI<T>> iterator() {
        return new IoOoX(this.f29155XO.invoke());
    }
}
