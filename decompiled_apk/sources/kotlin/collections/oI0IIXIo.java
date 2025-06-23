package kotlin.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Random;
import kotlin.collections.builders.ListBuilder;
import kotlin.oXIO0o0XI;

@kotlin.jvm.internal.XX({"SMAP\nCollectionsJVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CollectionsJVM.kt\nkotlin/collections/CollectionsKt__CollectionsJVMKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,131:1\n1#2:132\n*E\n"})
/* loaded from: classes6.dex */
public class oI0IIXIo {
    @xx0o0O.XO
    @kotlin.o0
    @kotlin.oxxXoxO(version = "1.3")
    public static final <E> List<E> I0Io(Oox.oOoXoXO<? super List<E>, oXIO0o0XI> builderAction) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(builderAction, "builderAction");
        List xxIXOIIO2 = xxIXOIIO();
        builderAction.invoke(xxIXOIIO2);
        return oIX0oI(xxIXOIIO2);
    }

    @OXOo.OOXIXo
    public static final <T> Object[] II0XooXoX(@OXOo.OOXIXo T[] tArr, boolean z) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        if (!z || !kotlin.jvm.internal.IIX0o.Oxx0IOOO(tArr.getClass(), Object[].class)) {
            Object[] copyOf = Arrays.copyOf(tArr, tArr.length, Object[].class);
            kotlin.jvm.internal.IIX0o.oO(copyOf, "copyOf(...)");
            return copyOf;
        }
        return tArr;
    }

    @xx0o0O.XO
    @kotlin.o0
    @kotlin.oxxXoxO(version = "1.3")
    public static final <E> List<E> II0xO0(int i, Oox.oOoXoXO<? super List<E>, oXIO0o0XI> builderAction) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(builderAction, "builderAction");
        List xoIox2 = xoIox(i);
        builderAction.invoke(xoIox2);
        return oIX0oI(xoIox2);
    }

    @OXOo.OOXIXo
    public static <T> List<T> OOXIXo(T t) {
        List<T> singletonList = Collections.singletonList(t);
        kotlin.jvm.internal.IIX0o.oO(singletonList, "singletonList(...)");
        return singletonList;
    }

    @xx0o0O.XO
    public static final <T> T[] Oxx0IOOO(Collection<?> collection, T[] array) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(collection, "collection");
        kotlin.jvm.internal.IIX0o.x0xO0oo(array, "array");
        return (T[]) kotlin.jvm.internal.OxxIIOOXO.II0xO0(collection, array);
    }

    @xx0o0O.XO
    @kotlin.o0
    @kotlin.oxxXoxO(version = "1.3")
    public static final int X0o0xo(int i) {
        if (i < 0) {
            if (xx0o0O.ooOOo0oXI.oIX0oI(1, 3, 0)) {
                CollectionsKt__CollectionsKt.XoX();
            } else {
                throw new ArithmeticException("Index overflow has happened.");
            }
        }
        return i;
    }

    @xx0o0O.XO
    public static final Object[] XO(Collection<?> collection) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(collection, "collection");
        return kotlin.jvm.internal.OxxIIOOXO.oIX0oI(collection);
    }

    @OXOo.OOXIXo
    @kotlin.o0
    @kotlin.oxxXoxO(version = "1.3")
    public static <E> List<E> oIX0oI(@OXOo.OOXIXo List<E> builder) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(builder, "builder");
        return ((ListBuilder) builder).build();
    }

    @xx0o0O.XO
    public static final <T> List<T> oO(Enumeration<T> enumeration) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(enumeration, "<this>");
        ArrayList list = Collections.list(enumeration);
        kotlin.jvm.internal.IIX0o.oO(list, "list(...)");
        return list;
    }

    @OXOo.OOXIXo
    @kotlin.oxxXoxO(version = "1.2")
    public static final <T> List<T> oOoXoXO(@OXOo.OOXIXo Iterable<? extends T> iterable) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        List<T> IxoOxx = CollectionsKt___CollectionsKt.IxoOxx(iterable);
        Collections.shuffle(IxoOxx);
        return IxoOxx;
    }

    @OXOo.OOXIXo
    @kotlin.oxxXoxO(version = "1.2")
    public static final <T> List<T> ooOOo0oXI(@OXOo.OOXIXo Iterable<? extends T> iterable, @OXOo.OOXIXo Random random) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(random, "random");
        List<T> IxoOxx = CollectionsKt___CollectionsKt.IxoOxx(iterable);
        Collections.shuffle(IxoOxx, random);
        return IxoOxx;
    }

    @xx0o0O.XO
    @kotlin.o0
    @kotlin.oxxXoxO(version = "1.3")
    public static final int oxoX(int i) {
        if (i < 0) {
            if (xx0o0O.ooOOo0oXI.oIX0oI(1, 3, 0)) {
                CollectionsKt__CollectionsKt.oxxXoxO();
            } else {
                throw new ArithmeticException("Count overflow has happened.");
            }
        }
        return i;
    }

    @OXOo.OOXIXo
    public static <T> T[] x0XOIxOo(int i, @OXOo.OOXIXo T[] array) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(array, "array");
        if (i < array.length) {
            array[i] = null;
        }
        return array;
    }

    @OXOo.OOXIXo
    @kotlin.o0
    @kotlin.oxxXoxO(version = "1.3")
    public static <E> List<E> xoIox(int i) {
        return new ListBuilder(i);
    }

    @OXOo.OOXIXo
    @kotlin.o0
    @kotlin.oxxXoxO(version = "1.3")
    public static <E> List<E> xxIXOIIO() {
        return new ListBuilder();
    }
}
