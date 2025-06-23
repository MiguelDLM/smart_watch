package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;

@kotlin.jvm.internal.XX({"SMAP\nAbstractCollection.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbstractCollection.kt\nkotlin/collections/AbstractCollection\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,50:1\n1747#2,3:51\n1726#2,3:54\n*S KotlinDebug\n*F\n+ 1 AbstractCollection.kt\nkotlin/collections/AbstractCollection\n*L\n19#1:51,3\n22#1:54,3\n*E\n"})
@kotlin.oxxXoxO(version = "1.1")
/* loaded from: classes6.dex */
public abstract class AbstractCollection<E> implements Collection<E>, OI0IXox.oIX0oI {
    @Override // java.util.Collection
    public boolean add(E e) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean contains(E e) {
        if (isEmpty()) {
            return false;
        }
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(it.next(), e)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
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

    public abstract int getSize();

    @Override // java.util.Collection
    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.lang.Iterable
    @OXOo.OOXIXo
    public abstract Iterator<E> iterator();

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
        return getSize();
    }

    @Override // java.util.Collection
    @OXOo.OOXIXo
    public Object[] toArray() {
        return kotlin.jvm.internal.OxxIIOOXO.oIX0oI(this);
    }

    @OXOo.OOXIXo
    public String toString() {
        return CollectionsKt___CollectionsKt.OoIXo(this, ", ", "[", "]", 0, null, new Oox.oOoXoXO<E, CharSequence>(this) { // from class: kotlin.collections.AbstractCollection$toString$1
            final /* synthetic */ AbstractCollection<E> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
                this.this$0 = this;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ CharSequence invoke(Object obj) {
                return invoke((AbstractCollection$toString$1<E>) obj);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oOoXoXO
            @OXOo.OOXIXo
            public final CharSequence invoke(E e) {
                return e == this.this$0 ? "(this Collection)" : String.valueOf(e);
            }
        }, 24, null);
    }

    @Override // java.util.Collection
    @OXOo.OOXIXo
    public <T> T[] toArray(@OXOo.OOXIXo T[] array) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(array, "array");
        return (T[]) kotlin.jvm.internal.OxxIIOOXO.II0xO0(this, array);
    }
}
