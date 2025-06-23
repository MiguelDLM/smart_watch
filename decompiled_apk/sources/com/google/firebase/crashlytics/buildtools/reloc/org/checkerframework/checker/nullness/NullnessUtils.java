package com.google.firebase.crashlytics.buildtools.reloc.org.checkerframework.checker.nullness;

import com.google.firebase.crashlytics.buildtools.reloc.org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* loaded from: classes10.dex */
public final class NullnessUtils {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    private NullnessUtils() {
        throw new AssertionError("shouldn't be instantiated");
    }

    @EnsuresNonNull({"#1"})
    public static <T> T castNonNull(T t) {
        return t;
    }

    private static <T> T[] castNonNullArray(T[] tArr) {
        for (T t : tArr) {
            checkIfArray(t);
        }
        return tArr;
    }

    @EnsuresNonNull({"#1"})
    public static <T> T[] castNonNullDeep(T[] tArr) {
        return (T[]) castNonNullArray(tArr);
    }

    private static void checkIfArray(Object obj) {
        Class<?> componentType = obj.getClass().getComponentType();
        if (componentType != null && !componentType.isPrimitive()) {
            castNonNullArray((Object[]) obj);
        }
    }

    @EnsuresNonNull({"#1"})
    public static <T> T[][] castNonNullDeep(T[][] tArr) {
        return (T[][]) ((Object[][]) castNonNullArray(tArr));
    }

    @EnsuresNonNull({"#1"})
    public static <T> T[][][] castNonNullDeep(T[][][] tArr) {
        return (T[][][]) ((Object[][][]) castNonNullArray(tArr));
    }

    @EnsuresNonNull({"#1"})
    public static <T> T[][][][] castNonNullDeep(T[][][][] tArr) {
        return (T[][][][]) ((Object[][][][]) castNonNullArray(tArr));
    }

    @EnsuresNonNull({"#1"})
    public static <T> T[][][][][] castNonNullDeep(T[][][][][] tArr) {
        return (T[][][][][]) ((Object[][][][][]) castNonNullArray(tArr));
    }
}
