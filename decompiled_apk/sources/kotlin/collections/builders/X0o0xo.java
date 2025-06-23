package kotlin.collections.builders;

import OXOo.OOXIXo;
import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes6.dex */
public final class X0o0xo<V> extends kotlin.collections.I0Io<V> implements Collection<V>, OI0IXox.II0xO0 {

    /* renamed from: XO, reason: collision with root package name */
    @OOXIXo
    public final MapBuilder<?, V> f29150XO;

    public X0o0xo(@OOXIXo MapBuilder<?, V> backing) {
        IIX0o.x0xO0oo(backing, "backing");
        this.f29150XO = backing;
    }

    @OOXIXo
    public final MapBuilder<?, V> II0xO0() {
        return this.f29150XO;
    }

    @Override // kotlin.collections.I0Io, java.util.AbstractCollection, java.util.Collection
    public boolean add(V v) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean addAll(@OOXIXo Collection<? extends V> elements) {
        IIX0o.x0xO0oo(elements, "elements");
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public void clear() {
        this.f29150XO.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        return this.f29150XO.containsValue(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return this.f29150XO.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    @OOXIXo
    public Iterator<V> iterator() {
        return this.f29150XO.valuesIterator$kotlin_stdlib();
    }

    @Override // kotlin.collections.I0Io
    public int oIX0oI() {
        return this.f29150XO.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean remove(Object obj) {
        return this.f29150XO.removeValue$kotlin_stdlib(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean removeAll(@OOXIXo Collection<? extends Object> elements) {
        IIX0o.x0xO0oo(elements, "elements");
        this.f29150XO.checkIsMutable$kotlin_stdlib();
        return super.removeAll(elements);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean retainAll(@OOXIXo Collection<? extends Object> elements) {
        IIX0o.x0xO0oo(elements, "elements");
        this.f29150XO.checkIsMutable$kotlin_stdlib();
        return super.retainAll(elements);
    }
}
