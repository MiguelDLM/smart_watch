package androidx.collection;

import OXOo.OOXIXo;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nScatterSet.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ScatterSet.kt\nandroidx/collection/ScatterSetKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1100:1\n1#2:1101\n*E\n"})
public final class ScatterSetKt {
    @OOXIXo
    private static final MutableScatterSet<Object> EmptyScatterSet = new MutableScatterSet<>(0);

    @OOXIXo
    public static final <E> ScatterSet<E> emptyScatterSet() {
        MutableScatterSet<Object> mutableScatterSet = EmptyScatterSet;
        IIX0o.x0XOIxOo(mutableScatterSet, "null cannot be cast to non-null type androidx.collection.ScatterSet<E of androidx.collection.ScatterSetKt.emptyScatterSet>");
        return mutableScatterSet;
    }

    @OOXIXo
    public static final <E> MutableScatterSet<E> mutableScatterSetOf() {
        return new MutableScatterSet<>(0, 1, (IIXOooo) null);
    }

    @OOXIXo
    public static final <E> ScatterSet<E> scatterSetOf() {
        MutableScatterSet<Object> mutableScatterSet = EmptyScatterSet;
        IIX0o.x0XOIxOo(mutableScatterSet, "null cannot be cast to non-null type androidx.collection.ScatterSet<E of androidx.collection.ScatterSetKt.scatterSetOf>");
        return mutableScatterSet;
    }

    @OOXIXo
    public static final <E> MutableScatterSet<E> mutableScatterSetOf(E e) {
        MutableScatterSet<E> mutableScatterSet = new MutableScatterSet<>(1);
        mutableScatterSet.plusAssign(e);
        return mutableScatterSet;
    }

    @OOXIXo
    public static final <E> ScatterSet<E> scatterSetOf(E e) {
        return mutableScatterSetOf(e);
    }

    @OOXIXo
    public static final <E> ScatterSet<E> scatterSetOf(E e, E e2) {
        return mutableScatterSetOf(e, e2);
    }

    @OOXIXo
    public static final <E> MutableScatterSet<E> mutableScatterSetOf(E e, E e2) {
        MutableScatterSet<E> mutableScatterSet = new MutableScatterSet<>(2);
        mutableScatterSet.plusAssign(e);
        mutableScatterSet.plusAssign(e2);
        return mutableScatterSet;
    }

    @OOXIXo
    public static final <E> ScatterSet<E> scatterSetOf(E e, E e2, E e3) {
        return mutableScatterSetOf(e, e2, e3);
    }

    @OOXIXo
    public static final <E> ScatterSet<E> scatterSetOf(@OOXIXo E... eArr) {
        IIX0o.x0xO0oo(eArr, "elements");
        MutableScatterSet mutableScatterSet = new MutableScatterSet(eArr.length);
        mutableScatterSet.plusAssign(eArr);
        return mutableScatterSet;
    }

    @OOXIXo
    public static final <E> MutableScatterSet<E> mutableScatterSetOf(E e, E e2, E e3) {
        MutableScatterSet<E> mutableScatterSet = new MutableScatterSet<>(3);
        mutableScatterSet.plusAssign(e);
        mutableScatterSet.plusAssign(e2);
        mutableScatterSet.plusAssign(e3);
        return mutableScatterSet;
    }

    @OOXIXo
    public static final <E> MutableScatterSet<E> mutableScatterSetOf(@OOXIXo E... eArr) {
        IIX0o.x0xO0oo(eArr, "elements");
        MutableScatterSet<E> mutableScatterSet = new MutableScatterSet<>(eArr.length);
        mutableScatterSet.plusAssign(eArr);
        return mutableScatterSet;
    }
}
