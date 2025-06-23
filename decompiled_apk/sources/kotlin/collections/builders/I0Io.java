package kotlin.collections.builders;

import OXOo.OOXIXo;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes6.dex */
public final class I0Io<K, V> extends oIX0oI<Map.Entry<K, V>, K, V> {

    /* renamed from: XO, reason: collision with root package name */
    @OOXIXo
    public final MapBuilder<K, V> f29139XO;

    public I0Io(@OOXIXo MapBuilder<K, V> backing) {
        IIX0o.x0xO0oo(backing, "backing");
        this.f29139XO = backing;
    }

    @Override // kotlin.collections.builders.oIX0oI
    public boolean II0xO0(@OOXIXo Map.Entry<? extends K, ? extends V> element) {
        IIX0o.x0xO0oo(element, "element");
        return this.f29139XO.containsEntry$kotlin_stdlib(element);
    }

    @Override // kotlin.collections.XO, java.util.AbstractCollection, java.util.Collection, java.util.Set
    /* renamed from: X0o0xo, reason: merged with bridge method [inline-methods] */
    public boolean add(@OOXIXo Map.Entry<K, V> element) {
        IIX0o.x0xO0oo(element, "element");
        throw new UnsupportedOperationException();
    }

    @OOXIXo
    public final MapBuilder<K, V> XO() {
        return this.f29139XO;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(@OOXIXo Collection<? extends Map.Entry<K, V>> elements) {
        IIX0o.x0xO0oo(elements, "elements");
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.f29139XO.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(@OOXIXo Collection<? extends Object> elements) {
        IIX0o.x0xO0oo(elements, "elements");
        return this.f29139XO.containsAllEntries$kotlin_stdlib(elements);
    }

    @Override // kotlin.collections.XO
    public int getSize() {
        return this.f29139XO.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f29139XO.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    @OOXIXo
    public Iterator<Map.Entry<K, V>> iterator() {
        return this.f29139XO.entriesIterator$kotlin_stdlib();
    }

    @Override // kotlin.collections.builders.oIX0oI
    public boolean oxoX(@OOXIXo Map.Entry element) {
        IIX0o.x0xO0oo(element, "element");
        return this.f29139XO.removeEntry$kotlin_stdlib(element);
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(@OOXIXo Collection<? extends Object> elements) {
        IIX0o.x0xO0oo(elements, "elements");
        this.f29139XO.checkIsMutable$kotlin_stdlib();
        return super.removeAll(elements);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(@OOXIXo Collection<? extends Object> elements) {
        IIX0o.x0xO0oo(elements, "elements");
        this.f29139XO.checkIsMutable$kotlin_stdlib();
        return super.retainAll(elements);
    }
}
