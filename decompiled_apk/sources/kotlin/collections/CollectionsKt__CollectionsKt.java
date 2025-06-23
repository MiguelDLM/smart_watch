package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.IIX0;
import kotlin.oXIO0o0XI;
import kotlin.random.Random;

@kotlin.jvm.internal.XX({"SMAP\nCollections.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Collections.kt\nkotlin/collections/CollectionsKt__CollectionsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ArrayIntrinsics.kt\nkotlin/ArrayIntrinsicsKt\n*L\n1#1,522:1\n1#2:523\n26#3:524\n*S KotlinDebug\n*F\n+ 1 Collections.kt\nkotlin/collections/CollectionsKt__CollectionsKt\n*L\n484#1:524\n*E\n"})
/* loaded from: classes6.dex */
public class CollectionsKt__CollectionsKt extends oI0IIXIo {
    @OXOo.OOXIXo
    @kotlin.oxxXoxO(version = "1.3")
    public static final <T> List<T> I0oOoX(@OXOo.OOXIXo Iterable<? extends T> iterable, @OXOo.OOXIXo Random random) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(random, "random");
        List<T> IxoOxx = CollectionsKt___CollectionsKt.IxoOxx(iterable);
        CollectionsKt___CollectionsKt.OXOo(IxoOxx, random);
        return IxoOxx;
    }

    @xx0o0O.XO
    public static final <T> boolean IIX0o(Collection<? extends T> collection, Collection<? extends T> elements) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(collection, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(elements, "elements");
        return collection.containsAll(elements);
    }

    public static final <T extends Comparable<? super T>> int IIXOooo(@OXOo.OOXIXo List<? extends T> list, @OXOo.oOoXoXO T t, int i, int i2) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<this>");
        XX(list.size(), i, i2);
        int i3 = i2 - 1;
        while (i <= i3) {
            int i4 = (i + i3) >>> 1;
            int oOoXoXO2 = xX0ox.Oxx0IOOO.oOoXoXO(list.get(i4), t);
            if (oOoXoXO2 < 0) {
                i = i4 + 1;
            } else if (oOoXoXO2 > 0) {
                i3 = i4 - 1;
            } else {
                return i4;
            }
        }
        return -(i + 1);
    }

    @OXOo.OOXIXo
    public static final <T> List<T> IO(@OXOo.oOoXoXO T t) {
        if (t != null) {
            return oI0IIXIo.OOXIXo(t);
        }
        return ooXIXxIX();
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = "1.1")
    public static final <T> ArrayList<T> IXxxXO() {
        return new ArrayList<>();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @xx0o0O.XO
    public static final <T> Collection<T> Io(Collection<? extends T> collection) {
        if (collection == 0) {
            return ooXIXxIX();
        }
        return collection;
    }

    @xx0o0O.XO
    public static final <T> boolean IoOoX(Collection<? extends T> collection) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(collection, "<this>");
        return !collection.isEmpty();
    }

    public static /* synthetic */ int O0xOxO(List list, Object obj, Comparator comparator, int i, int i2, int i3, Object obj2) {
        if ((i3 & 4) != 0) {
            i = 0;
        }
        if ((i3 & 8) != 0) {
            i2 = list.size();
        }
        return xoXoI(list, obj, comparator, i, i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @OXOo.OOXIXo
    public static final <T> List<T> OI0(@OXOo.OOXIXo List<? extends T> list) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<this>");
        int size = list.size();
        if (size != 0) {
            if (size == 1) {
                return oI0IIXIo.OOXIXo(list.get(0));
            }
            return list;
        }
        return ooXIXxIX();
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = "1.1")
    public static final <T> List<T> Oo(int i, Oox.oOoXoXO<? super Integer, ? extends T> init) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(init, "init");
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(init.invoke(Integer.valueOf(i2)));
        }
        return arrayList;
    }

    public static /* synthetic */ int OxI(List list, Comparable comparable, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = list.size();
        }
        return IIXOooo(list, comparable, i, i2);
    }

    @OXOo.OOXIXo
    public static <T> ArrayList<T> Oxx0xo(@OXOo.OOXIXo T... elements) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(elements, "elements");
        if (elements.length == 0) {
            return new ArrayList<>();
        }
        return new ArrayList<>(new II0XooXoX(elements, true));
    }

    public static final <T> int OxxIIOOXO(@OXOo.OOXIXo List<? extends T> list, int i, int i2, @OXOo.OOXIXo Oox.oOoXoXO<? super T, Integer> comparison) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparison, "comparison");
        XX(list.size(), i, i2);
        int i3 = i2 - 1;
        while (i <= i3) {
            int i4 = (i + i3) >>> 1;
            int intValue = comparison.invoke(list.get(i4)).intValue();
            if (intValue < 0) {
                i = i4 + 1;
            } else if (intValue > 0) {
                i3 = i4 - 1;
            } else {
                return i4;
            }
        }
        return -(i + 1);
    }

    @OXOo.OOXIXo
    public static <T> List<T> X00IoxXI(@OXOo.OOXIXo T... elements) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(elements, "elements");
        if (elements.length > 0) {
            return ooOOo0oXI.oI0IIXIo(elements);
        }
        return ooXIXxIX();
    }

    public static final <T, K extends Comparable<? super K>> int X0IIOO(@OXOo.OOXIXo List<? extends T> list, @OXOo.oOoXoXO K k, int i, int i2, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends K> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        return OxxIIOOXO(list, i, i2, new CollectionsKt__CollectionsKt$binarySearchBy$1(selector, k));
    }

    public static /* synthetic */ int XI0IXoo(List list, Comparable comparable, int i, int i2, Oox.oOoXoXO selector, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = list.size();
        }
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        return OxxIIOOXO(list, i, i2, new CollectionsKt__CollectionsKt$binarySearchBy$1(selector, comparable));
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = "1.6")
    public static final <E> List<E> XIxXXX0x0(int i, @kotlin.II0xO0 Oox.oOoXoXO<? super List<E>, oXIO0o0XI> builderAction) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(builderAction, "builderAction");
        List xoIox2 = oI0IIXIo.xoIox(i);
        builderAction.invoke(xoIox2);
        return oI0IIXIo.oIX0oI(xoIox2);
    }

    @OXOo.OOXIXo
    public static <T> List<T> XOxIOxOx(@OXOo.OOXIXo T... elements) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(elements, "elements");
        if (elements.length == 0) {
            return new ArrayList();
        }
        return new ArrayList(new II0XooXoX(elements, true));
    }

    public static final void XX(int i, int i2, int i3) {
        if (i2 <= i3) {
            if (i2 >= 0) {
                if (i3 <= i) {
                    return;
                }
                throw new IndexOutOfBoundsException("toIndex (" + i3 + ") is greater than size (" + i + ").");
            }
            throw new IndexOutOfBoundsException("fromIndex (" + i2 + ") is less than zero.");
        }
        throw new IllegalArgumentException("fromIndex (" + i2 + ") is greater than toIndex (" + i3 + ").");
    }

    @kotlin.o0
    @kotlin.oxxXoxO(version = "1.3")
    public static void XoX() {
        throw new ArithmeticException("Index overflow has happened.");
    }

    @xx0o0O.XO
    public static final <T> List<T> Xx000oIo() {
        return ooXIXxIX();
    }

    @OXOo.OOXIXo
    public static final Object[] XxX0x0xxx(@OXOo.OOXIXo Collection<?> collection) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(collection, "collection");
        int i = 0;
        if (collection.isEmpty()) {
            return new Object[0];
        }
        Object[] objArr = new Object[collection.size()];
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            objArr[i] = it.next();
            i++;
        }
        return objArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @xx0o0O.XO
    public static final <T> List<T> o0(List<? extends T> list) {
        if (list == 0) {
            return ooXIXxIX();
        }
        return list;
    }

    public static /* synthetic */ int o00(List list, int i, int i2, Oox.oOoXoXO oooxoxo, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = list.size();
        }
        return OxxIIOOXO(list, i, i2, oooxoxo);
    }

    @OXOo.OOXIXo
    public static final <T> Collection<T> oI0IIXIo(@OXOo.OOXIXo T[] tArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        return new II0XooXoX(tArr, false);
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = "1.3")
    public static final <T> boolean oOXoIIIo(Collection<? extends T> collection) {
        if (collection != null && !collection.isEmpty()) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Incorrect types in method signature: <C::Ljava/util/Collection<*>;:TR;R:Ljava/lang/Object;>(TC;LOox/oIX0oI<+TR;>;)TR; */
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = "1.3")
    public static final Object oo(Collection collection, Oox.oIX0oI defaultValue) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(defaultValue, "defaultValue");
        if (collection.isEmpty()) {
            return defaultValue.invoke();
        }
        return collection;
    }

    public static <T> int oo0xXOI0I(@OXOo.OOXIXo List<? extends T> list) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<this>");
        return list.size() - 1;
    }

    @OXOo.OOXIXo
    public static <T> List<T> ooXIXxIX() {
        return EmptyList.INSTANCE;
    }

    @kotlin.o0
    @kotlin.oxxXoxO(version = "1.3")
    public static void oxxXoxO() {
        throw new ArithmeticException("Count overflow has happened.");
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = "1.1")
    public static final <T> List<T> x0o() {
        return new ArrayList();
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = "1.1")
    public static final <T> List<T> x0xO0oo(int i, Oox.oOoXoXO<? super Integer, ? extends T> init) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(init, "init");
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(init.invoke(Integer.valueOf(i2)));
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static X0.oOoXoXO xI(@OXOo.OOXIXo Collection<?> collection) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(collection, "<this>");
        return new X0.oOoXoXO(0, collection.size() - 1);
    }

    @OXOo.OOXIXo
    public static <T> List<T> xII(@OXOo.OOXIXo T... elements) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(elements, "elements");
        return ArraysKt___ArraysKt.OIOIxOO(elements);
    }

    @OXOo.OOXIXo
    public static final <T> T[] xXxxox0I(@OXOo.OOXIXo Collection<?> collection, @OXOo.OOXIXo T[] array) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(collection, "collection");
        kotlin.jvm.internal.IIX0o.x0xO0oo(array, "array");
        int i = 0;
        if (collection.isEmpty()) {
            return (T[]) oI0IIXIo.x0XOIxOo(0, array);
        }
        int length = array.length;
        Object[] objArr = array;
        if (length < collection.size()) {
            objArr = (T[]) OOXIXo.oIX0oI(array, collection.size());
        }
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            objArr[i] = it.next();
            i++;
        }
        return (T[]) oI0IIXIo.x0XOIxOo(collection.size(), objArr);
    }

    public static final <T> int xoXoI(@OXOo.OOXIXo List<? extends T> list, T t, @OXOo.OOXIXo Comparator<? super T> comparator, int i, int i2) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        XX(list.size(), i, i2);
        int i3 = i2 - 1;
        while (i <= i3) {
            int i4 = (i + i3) >>> 1;
            int compare = comparator.compare(list.get(i4), t);
            if (compare < 0) {
                i = i4 + 1;
            } else if (compare > 0) {
                i3 = i4 - 1;
            } else {
                return i4;
            }
        }
        return -(i + 1);
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = "1.6")
    public static final <E> List<E> xxX(@kotlin.II0xO0 Oox.oOoXoXO<? super List<E>, oXIO0o0XI> builderAction) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(builderAction, "builderAction");
        List xxIXOIIO2 = oI0IIXIo.xxIXOIIO();
        builderAction.invoke(xxIXOIIO2);
        return oI0IIXIo.oIX0oI(xxIXOIIO2);
    }
}
