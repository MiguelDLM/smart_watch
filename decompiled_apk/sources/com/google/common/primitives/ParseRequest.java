package com.google.common.primitives;

import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.google.common.annotations.GwtCompatible;

@ElementTypesAreNonnullByDefault
@GwtCompatible
/* loaded from: classes8.dex */
final class ParseRequest {
    final int radix;
    final String rawValue;

    private ParseRequest(String str, int i) {
        this.rawValue = str;
        this.radix = i;
    }

    public static ParseRequest fromString(String str) {
        if (str.length() != 0) {
            char charAt = str.charAt(0);
            int i = 16;
            if (!str.startsWith(HexStringBuilder.DEFAULT_PREFIX) && !str.startsWith("0X")) {
                if (charAt == '#') {
                    str = str.substring(1);
                } else if (charAt == '0' && str.length() > 1) {
                    str = str.substring(1);
                    i = 8;
                } else {
                    i = 10;
                }
            } else {
                str = str.substring(2);
            }
            return new ParseRequest(str, i);
        }
        throw new NumberFormatException("empty string");
    }
}
