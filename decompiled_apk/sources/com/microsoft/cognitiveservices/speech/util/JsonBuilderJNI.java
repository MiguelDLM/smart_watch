package com.microsoft.cognitiveservices.speech.util;

import com.microsoft.cognitiveservices.speech.util.JsonValueJNI;

/* loaded from: classes11.dex */
public final class JsonBuilderJNI {
    private static long INVALID_ARG = 5;

    public static int addItem(SafeHandle safeHandle, int i, int i2, String str) {
        return builderAdd(safeHandle, i, i2, str);
    }

    public static String asJsonCopy(SafeHandle safeHandle, int i) {
        return builderAsJsonCopy(safeHandle, i);
    }

    private static final native int builderAdd(SafeHandle safeHandle, int i, int i2, String str);

    private static final native String builderAsJsonCopy(SafeHandle safeHandle, int i);

    private static final native int builderSet(SafeHandle safeHandle, int i, String str, int i2, String str2, boolean z, int i3, double d);

    public static JsonBuilder createBuilder() {
        IntRef intRef = new IntRef(0L);
        return new JsonBuilder(new SafeHandle(intRef.getValue(), SafeHandleType.JSONBUILDER), createJsonBuilderHandle(intRef));
    }

    private static final native int createJsonBuilderHandle(IntRef intRef);

    public static int setItem(SafeHandle safeHandle, int i, String str, JsonValueJNI.ValueKind valueKind, String str2, boolean z, int i2, double d) {
        return builderSet(safeHandle, i, str, valueKind.getValue(), str2, z, i2, d);
    }
}
