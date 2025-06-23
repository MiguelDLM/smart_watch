package androidx.collection;

import OXOo.OOXIXo;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nIntList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IntList.kt\nandroidx/collection/IntListKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 IntList.kt\nandroidx/collection/MutableIntList\n*L\n1#1,969:1\n1#2:970\n713#3,2:971\n713#3,2:973\n713#3,2:975\n713#3,2:977\n713#3,2:979\n713#3,2:981\n*S KotlinDebug\n*F\n+ 1 IntList.kt\nandroidx/collection/IntListKt\n*L\n938#1:971,2\n947#1:973,2\n948#1:975,2\n958#1:977,2\n959#1:979,2\n960#1:981,2\n*E\n"})
public final class IntListKt {
    @OOXIXo
    private static final IntList EmptyIntList = new MutableIntList(0);

    @OOXIXo
    public static final IntList emptyIntList() {
        return EmptyIntList;
    }

    @OOXIXo
    public static final IntList intListOf() {
        return EmptyIntList;
    }

    @OOXIXo
    public static final MutableIntList mutableIntListOf() {
        return new MutableIntList(0, 1, (IIXOooo) null);
    }

    @OOXIXo
    public static final IntList intListOf(int i) {
        return mutableIntListOf(i);
    }

    @OOXIXo
    public static final MutableIntList mutableIntListOf(int i) {
        MutableIntList mutableIntList = new MutableIntList(1);
        mutableIntList.add(i);
        return mutableIntList;
    }

    @OOXIXo
    public static final IntList intListOf(int i, int i2) {
        return mutableIntListOf(i, i2);
    }

    @OOXIXo
    public static final IntList intListOf(int i, int i2, int i3) {
        return mutableIntListOf(i, i2, i3);
    }

    @OOXIXo
    public static final MutableIntList mutableIntListOf(int i, int i2) {
        MutableIntList mutableIntList = new MutableIntList(2);
        mutableIntList.add(i);
        mutableIntList.add(i2);
        return mutableIntList;
    }

    @OOXIXo
    public static final IntList intListOf(@OOXIXo int... iArr) {
        IIX0o.x0xO0oo(iArr, "elements");
        MutableIntList mutableIntList = new MutableIntList(iArr.length);
        mutableIntList.plusAssign(iArr);
        return mutableIntList;
    }

    @OOXIXo
    public static final MutableIntList mutableIntListOf(int i, int i2, int i3) {
        MutableIntList mutableIntList = new MutableIntList(3);
        mutableIntList.add(i);
        mutableIntList.add(i2);
        mutableIntList.add(i3);
        return mutableIntList;
    }

    @OOXIXo
    public static final MutableIntList mutableIntListOf(@OOXIXo int... iArr) {
        IIX0o.x0xO0oo(iArr, "elements");
        MutableIntList mutableIntList = new MutableIntList(iArr.length);
        mutableIntList.plusAssign(iArr);
        return mutableIntList;
    }
}
