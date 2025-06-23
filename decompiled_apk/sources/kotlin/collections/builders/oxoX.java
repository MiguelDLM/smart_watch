package kotlin.collections.builders;

import OI0IXox.II0XooXoX;
import OXOo.OOXIXo;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.XO;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes6.dex */
public final class oxoX<E> extends XO<E> implements Set<E>, II0XooXoX {

    /* renamed from: XO, reason: collision with root package name */
    @OOXIXo
    public final MapBuilder<E, ?> f29151XO;

    public oxoX(@OOXIXo MapBuilder<E, ?> backing) {
        IIX0o.x0xO0oo(backing, "backing");
        this.f29151XO = backing;
    }

    @Override // kotlin.collections.XO, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(E e) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(@OOXIXo Collection<? extends E> elements) {
        IIX0o.x0xO0oo(elements, "elements");
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.f29151XO.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return this.f29151XO.containsKey(obj);
    }

    @Override // kotlin.collections.XO
    public int getSize() {
        return this.f29151XO.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f29151XO.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    @OOXIXo
    public Iterator<E> iterator() {
        return this.f29151XO.keysIterator$kotlin_stdlib();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        if (this.f29151XO.removeKey$kotlin_stdlib(obj) >= 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(@OOXIXo Collection<? extends Object> elements) {
        IIX0o.x0xO0oo(elements, "elements");
        this.f29151XO.checkIsMutable$kotlin_stdlib();
        return super.removeAll(elements);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(@OOXIXo Collection<? extends Object> elements) {
        IIX0o.x0xO0oo(elements, "elements");
        this.f29151XO.checkIsMutable$kotlin_stdlib();
        return super.retainAll(elements);
    }
}
