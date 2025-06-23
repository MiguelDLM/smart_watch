package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;

@kotlin.jvm.internal.XX({"SMAP\nCollections.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Collections.kt\nkotlin/collections/ArrayAsCollection\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,522:1\n1726#2,3:523\n*S KotlinDebug\n*F\n+ 1 Collections.kt\nkotlin/collections/ArrayAsCollection\n*L\n62#1:523,3\n*E\n"})
/* loaded from: classes6.dex */
public final class II0XooXoX<T> implements Collection<T>, OI0IXox.oIX0oI {

    /* renamed from: Oo, reason: collision with root package name */
    public final boolean f29112Oo;

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final T[] f29113XO;

    public II0XooXoX(@OXOo.OOXIXo T[] values, boolean z) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(values, "values");
        this.f29113XO = values;
        this.f29112Oo = z;
    }

    @OXOo.OOXIXo
    public final T[] II0xO0() {
        return this.f29113XO;
    }

    @Override // java.util.Collection
    public boolean add(T t) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends T> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean contains(Object obj) {
        return ArraysKt___ArraysKt.OXO0oX(this.f29113XO, obj);
    }

    @Override // java.util.Collection
    public boolean containsAll(@OXOo.OOXIXo Collection<? extends Object> elements) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(elements, "elements");
        Collection<? extends Object> collection = elements;
        if (collection.isEmpty()) {
            return true;
        }
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        if (this.f29113XO.length == 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.lang.Iterable
    @OXOo.OOXIXo
    public Iterator<T> iterator() {
        return kotlin.jvm.internal.II0XooXoX.oIX0oI(this.f29113XO);
    }

    public int oIX0oI() {
        return this.f29113XO.length;
    }

    public final boolean oxoX() {
        return this.f29112Oo;
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ int size() {
        return oIX0oI();
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] array) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(array, "array");
        return (T[]) kotlin.jvm.internal.OxxIIOOXO.II0xO0(this, array);
    }

    @Override // java.util.Collection
    @OXOo.OOXIXo
    public final Object[] toArray() {
        return oI0IIXIo.II0XooXoX(this.f29113XO, this.f29112Oo);
    }
}
