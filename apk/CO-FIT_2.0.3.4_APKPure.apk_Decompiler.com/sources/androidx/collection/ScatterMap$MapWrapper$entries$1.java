package androidx.collection;

import OI0IXox.oIX0oI;
import OXOo.OOXIXo;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.coroutines.I0Io;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.OxxIIOOXO;
import kotlin.jvm.internal.XX;
import kotlin.sequences.IXxxXO;

@XX({"SMAP\nScatterMap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ScatterMap.kt\nandroidx/collection/ScatterMap$MapWrapper$entries$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1850:1\n1726#2,3:1851\n*S KotlinDebug\n*F\n+ 1 ScatterMap.kt\nandroidx/collection/ScatterMap$MapWrapper$entries$1\n*L\n712#1:1851,3\n*E\n"})
public final class ScatterMap$MapWrapper$entries$1 implements Set<Map.Entry<? extends K, ? extends V>>, oIX0oI {
    final /* synthetic */ ScatterMap<K, V> this$0;

    public ScatterMap$MapWrapper$entries$1(ScatterMap<K, V> scatterMap) {
        this.this$0 = scatterMap;
    }

    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(Collection<? extends Map.Entry<? extends K, ? extends V>> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        return contains((Map.Entry) obj);
    }

    public boolean containsAll(@OOXIXo Collection<? extends Object> collection) {
        IIX0o.x0xO0oo(collection, "elements");
        Iterable<Map.Entry> iterable = collection;
        ScatterMap<K, V> scatterMap = this.this$0;
        if (((Collection) iterable).isEmpty()) {
            return true;
        }
        for (Map.Entry entry : iterable) {
            if (!IIX0o.Oxx0IOOO(scatterMap.get(entry.getKey()), entry.getValue())) {
                return false;
            }
        }
        return true;
    }

    public int getSize() {
        return this.this$0._size;
    }

    public boolean isEmpty() {
        return this.this$0.isEmpty();
    }

    @OOXIXo
    public Iterator<Map.Entry<K, V>> iterator() {
        return IXxxXO.oIX0oI(new ScatterMap$MapWrapper$entries$1$iterator$1(this.this$0, (I0Io<? super ScatterMap$MapWrapper$entries$1$iterator$1>) null));
    }

    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final /* bridge */ int size() {
        return getSize();
    }

    public Object[] toArray() {
        return OxxIIOOXO.oIX0oI(this);
    }

    public boolean add(Map.Entry<? extends K, ? extends V> entry) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean contains(@OOXIXo Map.Entry<? extends K, ? extends V> entry) {
        IIX0o.x0xO0oo(entry, "element");
        return IIX0o.Oxx0IOOO(this.this$0.get(entry.getKey()), entry.getValue());
    }

    public <T> T[] toArray(T[] tArr) {
        IIX0o.x0xO0oo(tArr, "array");
        return OxxIIOOXO.II0xO0(this, tArr);
    }
}
