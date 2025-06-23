package androidx.collection;

import OXOo.OOXIXo;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nLongList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LongList.kt\nandroidx/collection/LongListKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 LongList.kt\nandroidx/collection/MutableLongList\n*L\n1#1,969:1\n1#2:970\n713#3,2:971\n713#3,2:973\n713#3,2:975\n713#3,2:977\n713#3,2:979\n713#3,2:981\n*S KotlinDebug\n*F\n+ 1 LongList.kt\nandroidx/collection/LongListKt\n*L\n938#1:971,2\n947#1:973,2\n948#1:975,2\n958#1:977,2\n959#1:979,2\n960#1:981,2\n*E\n"})
/* loaded from: classes.dex */
public final class LongListKt {

    @OOXIXo
    private static final LongList EmptyLongList = new MutableLongList(0);

    @OOXIXo
    public static final LongList emptyLongList() {
        return EmptyLongList;
    }

    @OOXIXo
    public static final LongList longListOf() {
        return EmptyLongList;
    }

    @OOXIXo
    public static final MutableLongList mutableLongListOf() {
        return new MutableLongList(0, 1, null);
    }

    @OOXIXo
    public static final LongList longListOf(long j) {
        return mutableLongListOf(j);
    }

    @OOXIXo
    public static final MutableLongList mutableLongListOf(long j) {
        MutableLongList mutableLongList = new MutableLongList(1);
        mutableLongList.add(j);
        return mutableLongList;
    }

    @OOXIXo
    public static final LongList longListOf(long j, long j2) {
        return mutableLongListOf(j, j2);
    }

    @OOXIXo
    public static final LongList longListOf(long j, long j2, long j3) {
        return mutableLongListOf(j, j2, j3);
    }

    @OOXIXo
    public static final MutableLongList mutableLongListOf(long j, long j2) {
        MutableLongList mutableLongList = new MutableLongList(2);
        mutableLongList.add(j);
        mutableLongList.add(j2);
        return mutableLongList;
    }

    @OOXIXo
    public static final LongList longListOf(@OOXIXo long... elements) {
        IIX0o.x0xO0oo(elements, "elements");
        MutableLongList mutableLongList = new MutableLongList(elements.length);
        mutableLongList.plusAssign(elements);
        return mutableLongList;
    }

    @OOXIXo
    public static final MutableLongList mutableLongListOf(long j, long j2, long j3) {
        MutableLongList mutableLongList = new MutableLongList(3);
        mutableLongList.add(j);
        mutableLongList.add(j2);
        mutableLongList.add(j3);
        return mutableLongList;
    }

    @OOXIXo
    public static final MutableLongList mutableLongListOf(@OOXIXo long... elements) {
        IIX0o.x0xO0oo(elements, "elements");
        MutableLongList mutableLongList = new MutableLongList(elements.length);
        mutableLongList.plusAssign(elements);
        return mutableLongList;
    }
}
