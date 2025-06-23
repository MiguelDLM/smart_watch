package androidx.collection;

import OXOo.OOXIXo;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nIntSet.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IntSet.kt\nandroidx/collection/IntSetKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,853:1\n1#2:854\n*E\n"})
/* loaded from: classes.dex */
public final class IntSetKt {

    @OOXIXo
    private static final MutableIntSet EmptyIntSet = new MutableIntSet(0);

    @OOXIXo
    private static final int[] EmptyIntArray = new int[0];

    @OOXIXo
    public static final IntSet emptyIntSet() {
        return EmptyIntSet;
    }

    @OOXIXo
    public static final int[] getEmptyIntArray() {
        return EmptyIntArray;
    }

    public static final int hash(int i) {
        int i2 = i * ScatterMapKt.MurmurHashC1;
        return i2 ^ (i2 << 16);
    }

    @OOXIXo
    public static final IntSet intSetOf() {
        return EmptyIntSet;
    }

    @OOXIXo
    public static final MutableIntSet mutableIntSetOf() {
        return new MutableIntSet(0, 1, null);
    }

    @OOXIXo
    public static final IntSet intSetOf(int i) {
        return mutableIntSetOf(i);
    }

    @OOXIXo
    public static final MutableIntSet mutableIntSetOf(int i) {
        MutableIntSet mutableIntSet = new MutableIntSet(1);
        mutableIntSet.plusAssign(i);
        return mutableIntSet;
    }

    @OOXIXo
    public static final IntSet intSetOf(int i, int i2) {
        return mutableIntSetOf(i, i2);
    }

    @OOXIXo
    public static final IntSet intSetOf(int i, int i2, int i3) {
        return mutableIntSetOf(i, i2, i3);
    }

    @OOXIXo
    public static final MutableIntSet mutableIntSetOf(int i, int i2) {
        MutableIntSet mutableIntSet = new MutableIntSet(2);
        mutableIntSet.plusAssign(i);
        mutableIntSet.plusAssign(i2);
        return mutableIntSet;
    }

    @OOXIXo
    public static final IntSet intSetOf(@OOXIXo int... elements) {
        IIX0o.x0xO0oo(elements, "elements");
        MutableIntSet mutableIntSet = new MutableIntSet(elements.length);
        mutableIntSet.plusAssign(elements);
        return mutableIntSet;
    }

    @OOXIXo
    public static final MutableIntSet mutableIntSetOf(int i, int i2, int i3) {
        MutableIntSet mutableIntSet = new MutableIntSet(3);
        mutableIntSet.plusAssign(i);
        mutableIntSet.plusAssign(i2);
        mutableIntSet.plusAssign(i3);
        return mutableIntSet;
    }

    @OOXIXo
    public static final MutableIntSet mutableIntSetOf(@OOXIXo int... elements) {
        IIX0o.x0xO0oo(elements, "elements");
        MutableIntSet mutableIntSet = new MutableIntSet(elements.length);
        mutableIntSet.plusAssign(elements);
        return mutableIntSet;
    }
}
