package androidx.collection;

import OXOo.OOXIXo;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nFloatSet.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FloatSet.kt\nandroidx/collection/FloatSetKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,853:1\n1#2:854\n*E\n"})
public final class FloatSetKt {
    @OOXIXo
    private static final float[] EmptyFloatArray = new float[0];
    @OOXIXo
    private static final MutableFloatSet EmptyFloatSet = new MutableFloatSet(0);

    @OOXIXo
    public static final FloatSet emptyFloatSet() {
        return EmptyFloatSet;
    }

    @OOXIXo
    public static final FloatSet floatSetOf() {
        return EmptyFloatSet;
    }

    @OOXIXo
    public static final float[] getEmptyFloatArray() {
        return EmptyFloatArray;
    }

    public static final int hash(float f) {
        int floatToIntBits = Float.floatToIntBits(f) * ScatterMapKt.MurmurHashC1;
        return floatToIntBits ^ (floatToIntBits << 16);
    }

    @OOXIXo
    public static final MutableFloatSet mutableFloatSetOf() {
        return new MutableFloatSet(0, 1, (IIXOooo) null);
    }

    @OOXIXo
    public static final FloatSet floatSetOf(float f) {
        return mutableFloatSetOf(f);
    }

    @OOXIXo
    public static final MutableFloatSet mutableFloatSetOf(float f) {
        MutableFloatSet mutableFloatSet = new MutableFloatSet(1);
        mutableFloatSet.plusAssign(f);
        return mutableFloatSet;
    }

    @OOXIXo
    public static final FloatSet floatSetOf(float f, float f2) {
        return mutableFloatSetOf(f, f2);
    }

    @OOXIXo
    public static final FloatSet floatSetOf(float f, float f2, float f3) {
        return mutableFloatSetOf(f, f2, f3);
    }

    @OOXIXo
    public static final MutableFloatSet mutableFloatSetOf(float f, float f2) {
        MutableFloatSet mutableFloatSet = new MutableFloatSet(2);
        mutableFloatSet.plusAssign(f);
        mutableFloatSet.plusAssign(f2);
        return mutableFloatSet;
    }

    @OOXIXo
    public static final FloatSet floatSetOf(@OOXIXo float... fArr) {
        IIX0o.x0xO0oo(fArr, "elements");
        MutableFloatSet mutableFloatSet = new MutableFloatSet(fArr.length);
        mutableFloatSet.plusAssign(fArr);
        return mutableFloatSet;
    }

    @OOXIXo
    public static final MutableFloatSet mutableFloatSetOf(float f, float f2, float f3) {
        MutableFloatSet mutableFloatSet = new MutableFloatSet(3);
        mutableFloatSet.plusAssign(f);
        mutableFloatSet.plusAssign(f2);
        mutableFloatSet.plusAssign(f3);
        return mutableFloatSet;
    }

    @OOXIXo
    public static final MutableFloatSet mutableFloatSetOf(@OOXIXo float... fArr) {
        IIX0o.x0xO0oo(fArr, "elements");
        MutableFloatSet mutableFloatSet = new MutableFloatSet(fArr.length);
        mutableFloatSet.plusAssign(fArr);
        return mutableFloatSet;
    }
}
