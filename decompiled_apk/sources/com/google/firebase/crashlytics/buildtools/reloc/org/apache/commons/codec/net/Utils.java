package com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.net;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.DecoderException;

/* loaded from: classes10.dex */
class Utils {
    public static int digit16(byte b) throws DecoderException {
        int digit = Character.digit((char) b, 16);
        if (digit != -1) {
            return digit;
        }
        throw new DecoderException("Invalid URL encoding: not a valid digit (radix 16): " + ((int) b));
    }
}
