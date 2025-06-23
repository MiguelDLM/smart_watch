package androidx.collection;

import OXOo.OOXIXo;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nLongSet.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LongSet.kt\nandroidx/collection/LongSetKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,853:1\n1#2:854\n*E\n"})
public final class LongSetKt {
    @OOXIXo
    private static final long[] EmptyLongArray = new long[0];
    @OOXIXo
    private static final MutableLongSet EmptyLongSet = new MutableLongSet(0);

    @OOXIXo
    public static final LongSet emptyLongSet() {
        return EmptyLongSet;
    }

    @OOXIXo
    public static final long[] getEmptyLongArray() {
        return EmptyLongArray;
    }

    public static final int hash(long j) {
        int oIX0oI2 = oIX0oI.oIX0oI(j) * ScatterMapKt.MurmurHashC1;
        return oIX0oI2 ^ (oIX0oI2 << 16);
    }

    @OOXIXo
    public static final LongSet longSetOf() {
        return EmptyLongSet;
    }

    @OOXIXo
    public static final MutableLongSet mutableLongSetOf() {
        return new MutableLongSet(0, 1, (IIXOooo) null);
    }

    @OOXIXo
    public static final LongSet longSetOf(long j) {
        return mutableLongSetOf(j);
    }

    @OOXIXo
    public static final MutableLongSet mutableLongSetOf(long j) {
        MutableLongSet mutableLongSet = new MutableLongSet(1);
        mutableLongSet.plusAssign(j);
        return mutableLongSet;
    }

    @OOXIXo
    public static final LongSet longSetOf(long j, long j2) {
        return mutableLongSetOf(j, j2);
    }

    @OOXIXo
    public static final LongSet longSetOf(long j, long j2, long j3) {
        return mutableLongSetOf(j, j2, j3);
    }

    @OOXIXo
    public static final MutableLongSet mutableLongSetOf(long j, long j2) {
        MutableLongSet mutableLongSet = new MutableLongSet(2);
        mutableLongSet.plusAssign(j);
        mutableLongSet.plusAssign(j2);
        return mutableLongSet;
    }

    @OOXIXo
    public static final LongSet longSetOf(@OOXIXo long... jArr) {
        IIX0o.x0xO0oo(jArr, "elements");
        MutableLongSet mutableLongSet = new MutableLongSet(jArr.length);
        mutableLongSet.plusAssign(jArr);
        return mutableLongSet;
    }

    @OOXIXo
    public static final MutableLongSet mutableLongSetOf(long j, long j2, long j3) {
        MutableLongSet mutableLongSet = new MutableLongSet(3);
        mutableLongSet.plusAssign(j);
        mutableLongSet.plusAssign(j2);
        mutableLongSet.plusAssign(j3);
        return mutableLongSet;
    }

    @OOXIXo
    public static final MutableLongSet mutableLongSetOf(@OOXIXo long... jArr) {
        IIX0o.x0xO0oo(jArr, "elements");
        MutableLongSet mutableLongSet = new MutableLongSet(jArr.length);
        mutableLongSet.plusAssign(jArr);
        return mutableLongSet;
    }
}
