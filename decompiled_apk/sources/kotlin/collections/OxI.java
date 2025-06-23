package kotlin.collections;

import com.goodix.ble.gr.libdfu.BuildConfig;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.DeprecationLevel;
import kotlin.IIX0;
import kotlin.sequences.SequencesKt___SequencesKt;

/* loaded from: classes6.dex */
public class OxI extends o00 {
    @xx0o0O.XO
    public static final <T> void I0(Collection<? super T> collection, Iterable<? extends T> elements) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(collection, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(elements, "elements");
        XIo0oOXIx(collection, elements);
    }

    public static final <T> boolean IIX0(@OXOo.OOXIXo Collection<? super T> collection, @OXOo.OOXIXo T[] elements) {
        boolean z;
        kotlin.jvm.internal.IIX0o.x0xO0oo(collection, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(elements, "elements");
        if (elements.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z || !collection.removeAll(ooOOo0oXI.oI0IIXIo(elements))) {
            return false;
        }
        return true;
    }

    @xx0o0O.XO
    public static final <T> void IIxOXoOo0(Collection<? super T> collection, T[] elements) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(collection, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(elements, "elements");
        IIX0(collection, elements);
    }

    public static <T> boolean IoIOOxIIo(@OXOo.OOXIXo Iterable<? extends T> iterable, @OXOo.OOXIXo Oox.oOoXoXO<? super T, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        return o0xxxXXxX(iterable, predicate, false);
    }

    public static <T> boolean Ioxxx(@OXOo.OOXIXo Collection<? super T> collection, @OXOo.OOXIXo kotlin.sequences.ooOOo0oXI<? extends T> elements) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(collection, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(elements, "elements");
        Iterator<? extends T> it = elements.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (collection.add(it.next())) {
                z = true;
            }
        }
        return z;
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final <T> T O0(@OXOo.OOXIXo List<T> list) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.remove(0);
    }

    public static final <T> boolean O00XxXI(List<T> list, Oox.oOoXoXO<? super T, Boolean> oooxoxo, boolean z) {
        if (!(list instanceof RandomAccess)) {
            kotlin.jvm.internal.IIX0o.x0XOIxOo(list, "null cannot be cast to non-null type kotlin.collections.MutableIterable<T of kotlin.collections.CollectionsKt__MutableCollectionsKt.filterInPlace>");
            return o0xxxXXxX(kotlin.jvm.internal.XoX.I0Io(list), oooxoxo, z);
        }
        oOXoIIIo it = new X0.oOoXoXO(0, CollectionsKt__CollectionsKt.oo0xXOI0I(list)).iterator();
        int i = 0;
        while (it.hasNext()) {
            int nextInt = it.nextInt();
            T t = list.get(nextInt);
            if (oooxoxo.invoke(t).booleanValue() != z) {
                if (i != nextInt) {
                    list.set(i, t);
                }
                i++;
            }
        }
        if (i >= list.size()) {
            return false;
        }
        int oo0xXOI0I2 = CollectionsKt__CollectionsKt.oo0xXOI0I(list);
        if (i > oo0xXOI0I2) {
            return true;
        }
        while (true) {
            list.remove(oo0xXOI0I2);
            if (oo0xXOI0I2 != i) {
                oo0xXOI0I2--;
            } else {
                return true;
            }
        }
    }

    public static final <T> boolean O0X(@OXOo.OOXIXo Collection<? super T> collection, @OXOo.OOXIXo kotlin.sequences.ooOOo0oXI<? extends T> elements) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(collection, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(elements, "elements");
        List oox000IX2 = SequencesKt___SequencesKt.oox000IX(elements);
        if (!oox000IX2.isEmpty() && collection.removeAll(oox000IX2)) {
            return true;
        }
        return false;
    }

    public static final <T> boolean OIOoIIOIx(@OXOo.OOXIXo List<T> list, @OXOo.OOXIXo Oox.oOoXoXO<? super T, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        return O00XxXI(list, predicate, false);
    }

    @xx0o0O.XO
    public static final <T> void OOXIxO0(Collection<? super T> collection, kotlin.sequences.ooOOo0oXI<? extends T> elements) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(collection, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(elements, "elements");
        O0X(collection, elements);
    }

    @xx0o0O.XO
    public static final <T> void OX00O0xII(Collection<? super T> collection, T[] elements) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(collection, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(elements, "elements");
        xxIO(collection, elements);
    }

    public static final <T> boolean OoO(@OXOo.OOXIXo Collection<? super T> collection, @OXOo.OOXIXo T[] elements) {
        boolean z;
        kotlin.jvm.internal.IIX0o.x0xO0oo(collection, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(elements, "elements");
        if (elements.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return collection.retainAll(ooOOo0oXI.oI0IIXIo(elements));
        }
        return x0OIX00oO(collection);
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static <T> T Ox0O(@OXOo.OOXIXo List<T> list) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<this>");
        if (!list.isEmpty()) {
            return list.remove(0);
        }
        throw new NoSuchElementException("List is empty.");
    }

    @xx0o0O.XO
    public static final <T> void XI0oooXX(Collection<? super T> collection, T t) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(collection, "<this>");
        collection.remove(t);
    }

    public static <T> boolean XIXIX(@OXOo.OOXIXo Iterable<? extends T> iterable, @OXOo.OOXIXo Oox.oOoXoXO<? super T, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        return o0xxxXXxX(iterable, predicate, true);
    }

    public static final <T> boolean XIXIxO(@OXOo.OOXIXo Collection<? super T> collection, @OXOo.OOXIXo kotlin.sequences.ooOOo0oXI<? extends T> elements) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(collection, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(elements, "elements");
        List oox000IX2 = SequencesKt___SequencesKt.oox000IX(elements);
        if (!oox000IX2.isEmpty()) {
            return collection.retainAll(oox000IX2);
        }
        return x0OIX00oO(collection);
    }

    public static <T> boolean XIo0oOXIx(@OXOo.OOXIXo Collection<? super T> collection, @OXOo.OOXIXo Iterable<? extends T> elements) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(collection, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(elements, "elements");
        if (elements instanceof Collection) {
            return collection.addAll((Collection) elements);
        }
        Iterator<? extends T> it = elements.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (collection.add(it.next())) {
                z = true;
            }
        }
        return z;
    }

    @OXOo.OOXIXo
    public static <T> Collection<T> XX0xXo(@OXOo.OOXIXo Iterable<? extends T> iterable) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            iterable = CollectionsKt___CollectionsKt.oOo0o(iterable);
        }
        return (Collection) iterable;
    }

    @xx0o0O.XO
    public static final <T> boolean o0oIxOo(Collection<? extends T> collection, Collection<? extends T> elements) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(collection, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(elements, "elements");
        return kotlin.jvm.internal.XoX.oIX0oI(collection).retainAll(elements);
    }

    public static final <T> boolean o0xxxXXxX(Iterable<? extends T> iterable, Oox.oOoXoXO<? super T, Boolean> oooxoxo, boolean z) {
        Iterator<? extends T> it = iterable.iterator();
        boolean z2 = false;
        while (it.hasNext()) {
            if (oooxoxo.invoke(it.next()).booleanValue() == z) {
                it.remove();
                z2 = true;
            }
        }
        return z2;
    }

    @xx0o0O.XO
    public static final <T> boolean oOo(Collection<? extends T> collection, Collection<? extends T> elements) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(collection, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(elements, "elements");
        return kotlin.jvm.internal.XoX.oIX0oI(collection).removeAll(elements);
    }

    public static final <T> boolean oXIO0o0XI(@OXOo.OOXIXo Collection<? super T> collection, @OXOo.OOXIXo Iterable<? extends T> elements) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(collection, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(elements, "elements");
        return collection.removeAll(XX0xXo(elements));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @xx0o0O.XO
    public static final <T> void ooOx(Collection<? super T> collection, T t) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(collection, "<this>");
        collection.add(t);
    }

    @xx0o0O.XO
    public static final <T> void ox(Collection<? super T> collection, Iterable<? extends T> elements) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(collection, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(elements, "elements");
        oXIO0o0XI(collection, elements);
    }

    public static final <T> boolean oxIIX0o(@OXOo.OOXIXo Collection<? super T> collection, @OXOo.OOXIXo Iterable<? extends T> elements) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(collection, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(elements, "elements");
        return collection.retainAll(XX0xXo(elements));
    }

    public static final boolean x0OIX00oO(Collection<?> collection) {
        boolean z = !collection.isEmpty();
        collection.clear();
        return z;
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static <T> T xI0oxI00(@OXOo.OOXIXo List<T> list) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.remove(CollectionsKt__CollectionsKt.oo0xXOI0I(list));
    }

    @xx0o0O.XO
    public static final <T> boolean xOOOX(Collection<? extends T> collection, T t) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(collection, "<this>");
        return kotlin.jvm.internal.XoX.oIX0oI(collection).remove(t);
    }

    public static <T> boolean xOoOIoI(@OXOo.OOXIXo List<T> list, @OXOo.OOXIXo Oox.oOoXoXO<? super T, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        return O00XxXI(list, predicate, true);
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Use removeAt(index) instead.", replaceWith = @kotlin.XX(expression = "removeAt(index)", imports = {}))
    @xx0o0O.XO
    public static final <T> T xX0IIXIx0(List<T> list, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<this>");
        return list.remove(i);
    }

    @xx0o0O.XO
    public static final <T> void xoO0xx0(Collection<? super T> collection, kotlin.sequences.ooOOo0oXI<? extends T> elements) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(collection, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(elements, "elements");
        Ioxxx(collection, elements);
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static <T> T xx0X0(@OXOo.OOXIXo List<T> list) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<this>");
        if (!list.isEmpty()) {
            return list.remove(CollectionsKt__CollectionsKt.oo0xXOI0I(list));
        }
        throw new NoSuchElementException("List is empty.");
    }

    public static <T> boolean xxIO(@OXOo.OOXIXo Collection<? super T> collection, @OXOo.OOXIXo T[] elements) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(collection, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(elements, "elements");
        return collection.addAll(ooOOo0oXI.oI0IIXIo(elements));
    }
}
