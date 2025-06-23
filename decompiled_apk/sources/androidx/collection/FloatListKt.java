package androidx.collection;

import OXOo.OOXIXo;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nFloatList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FloatList.kt\nandroidx/collection/FloatListKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 FloatList.kt\nandroidx/collection/MutableFloatList\n*L\n1#1,969:1\n1#2:970\n713#3,2:971\n713#3,2:973\n713#3,2:975\n713#3,2:977\n713#3,2:979\n713#3,2:981\n*S KotlinDebug\n*F\n+ 1 FloatList.kt\nandroidx/collection/FloatListKt\n*L\n938#1:971,2\n947#1:973,2\n948#1:975,2\n958#1:977,2\n959#1:979,2\n960#1:981,2\n*E\n"})
/* loaded from: classes.dex */
public final class FloatListKt {

    @OOXIXo
    private static final FloatList EmptyFloatList = new MutableFloatList(0);

    @OOXIXo
    public static final FloatList emptyFloatList() {
        return EmptyFloatList;
    }

    @OOXIXo
    public static final FloatList floatListOf() {
        return EmptyFloatList;
    }

    @OOXIXo
    public static final MutableFloatList mutableFloatListOf() {
        return new MutableFloatList(0, 1, null);
    }

    @OOXIXo
    public static final FloatList floatListOf(float f) {
        return mutableFloatListOf(f);
    }

    @OOXIXo
    public static final MutableFloatList mutableFloatListOf(float f) {
        MutableFloatList mutableFloatList = new MutableFloatList(1);
        mutableFloatList.add(f);
        return mutableFloatList;
    }

    @OOXIXo
    public static final FloatList floatListOf(float f, float f2) {
        return mutableFloatListOf(f, f2);
    }

    @OOXIXo
    public static final FloatList floatListOf(float f, float f2, float f3) {
        return mutableFloatListOf(f, f2, f3);
    }

    @OOXIXo
    public static final MutableFloatList mutableFloatListOf(float f, float f2) {
        MutableFloatList mutableFloatList = new MutableFloatList(2);
        mutableFloatList.add(f);
        mutableFloatList.add(f2);
        return mutableFloatList;
    }

    @OOXIXo
    public static final FloatList floatListOf(@OOXIXo float... elements) {
        IIX0o.x0xO0oo(elements, "elements");
        MutableFloatList mutableFloatList = new MutableFloatList(elements.length);
        mutableFloatList.plusAssign(elements);
        return mutableFloatList;
    }

    @OOXIXo
    public static final MutableFloatList mutableFloatListOf(float f, float f2, float f3) {
        MutableFloatList mutableFloatList = new MutableFloatList(3);
        mutableFloatList.add(f);
        mutableFloatList.add(f2);
        mutableFloatList.add(f3);
        return mutableFloatList;
    }

    @OOXIXo
    public static final MutableFloatList mutableFloatListOf(@OOXIXo float... elements) {
        IIX0o.x0xO0oo(elements, "elements");
        MutableFloatList mutableFloatList = new MutableFloatList(elements.length);
        mutableFloatList.plusAssign(elements);
        return mutableFloatList;
    }
}
