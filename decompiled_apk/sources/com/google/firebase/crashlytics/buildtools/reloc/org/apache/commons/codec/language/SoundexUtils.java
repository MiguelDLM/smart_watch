package com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.language;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.EncoderException;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.StringEncoder;
import java.util.Locale;

/* loaded from: classes10.dex */
final class SoundexUtils {
    public static String clean(String str) {
        if (str != null && str.length() != 0) {
            int length = str.length();
            char[] cArr = new char[length];
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                if (Character.isLetter(str.charAt(i2))) {
                    cArr[i] = str.charAt(i2);
                    i++;
                }
            }
            if (i == length) {
                return str.toUpperCase(Locale.ENGLISH);
            }
            return new String(cArr, 0, i).toUpperCase(Locale.ENGLISH);
        }
        return str;
    }

    public static int difference(StringEncoder stringEncoder, String str, String str2) throws EncoderException {
        return differenceEncoded(stringEncoder.encode(str), stringEncoder.encode(str2));
    }

    public static int differenceEncoded(String str, String str2) {
        if (str == null || str2 == null) {
            return 0;
        }
        int min = Math.min(str.length(), str2.length());
        int i = 0;
        for (int i2 = 0; i2 < min; i2++) {
            if (str.charAt(i2) == str2.charAt(i2)) {
                i++;
            }
        }
        return i;
    }
}
