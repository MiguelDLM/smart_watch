package com.microsoft.cognitiveservices.speech.util;

import XIXIX.OOXIXo;

/* loaded from: classes11.dex */
public final class JsonValueJNI {
    private static long INVALID_ARG = 5;

    /* loaded from: classes11.dex */
    public enum ValueKind {
        ERROR(-1),
        END(0),
        OBJECT(123),
        ARRAY(91),
        STRING(34),
        NUMBER(49),
        BOOLEAN(98),
        NULL(110),
        UNSPECIFIED(63);

        private int id;

        ValueKind(int i) {
            this.id = i;
        }

        public int getValue() {
            return this.id;
        }
    }

    public static boolean asBoolean(SafeHandle safeHandle, int i) {
        if (kind(safeHandle, i) != ValueKind.BOOLEAN.getValue()) {
            Contracts.throwIfFail(INVALID_ARG);
        }
        return asBoolean(safeHandle, i, false);
    }

    private static final native boolean asBoolean(SafeHandle safeHandle, int i, boolean z);

    private static final native double asDouble(SafeHandle safeHandle, int i, double d);

    public static float asFloat(SafeHandle safeHandle, int i) {
        if (kind(safeHandle, i) != ValueKind.NUMBER.getValue()) {
            Contracts.throwIfFail(INVALID_ARG);
        }
        return (float) asDouble(safeHandle, i, OOXIXo.f3760XO);
    }

    public static long asInt(SafeHandle safeHandle, int i) {
        if (kind(safeHandle, i) != ValueKind.NUMBER.getValue()) {
            Contracts.throwIfFail(INVALID_ARG);
        }
        return asInt(safeHandle, i, 0L);
    }

    private static final native long asInt(SafeHandle safeHandle, int i, long j);

    public static final native String asJson(SafeHandle safeHandle, int i);

    public static String asString(SafeHandle safeHandle, int i) {
        if (kind(safeHandle, i) != ValueKind.STRING.getValue()) {
            Contracts.throwIfFail(INVALID_ARG);
        }
        return asString(safeHandle, i, null);
    }

    private static final native String asString(SafeHandle safeHandle, int i, String str);

    public static final native int count(SafeHandle safeHandle, int i);

    private static final native int createJsonParserHandle(String str, IntRef intRef);

    public static JsonValue createParser(String str) {
        IntRef intRef = new IntRef(0L);
        return new JsonValue(createJsonParserHandle(str, intRef), new SafeHandle(intRef.getValue(), SafeHandleType.JSONVALUE));
    }

    private static final native int get(SafeHandle safeHandle, int i, int i2, String str);

    private static final native String getName(SafeHandle safeHandle, int i, int i2);

    public static String getName(SafeHandle safeHandle, int i, int i2, String str) {
        return getName(safeHandle, i, i2);
    }

    public static JsonValue getValue(SafeHandle safeHandle, int i, int i2, String str) {
        return new JsonValue(get(safeHandle, i, i2, str), safeHandle);
    }

    public static boolean hasValue(SafeHandle safeHandle, int i, int i2, String str) {
        return get(safeHandle, i, i2, str) > 0;
    }

    private static final native int kind(SafeHandle safeHandle, int i);
}
