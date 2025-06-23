package com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io;

import java.nio.ByteOrder;

/* loaded from: classes10.dex */
public final class ByteOrderParser {
    private ByteOrderParser() {
    }

    public static ByteOrder parseByteOrder(String str) {
        ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
        if (byteOrder.toString().equals(str)) {
            return byteOrder;
        }
        ByteOrder byteOrder2 = ByteOrder.LITTLE_ENDIAN;
        if (byteOrder2.toString().equals(str)) {
            return byteOrder2;
        }
        throw new IllegalArgumentException("Unsupported byte order setting: " + str + ", expeced one of " + byteOrder2 + ", " + byteOrder);
    }
}
