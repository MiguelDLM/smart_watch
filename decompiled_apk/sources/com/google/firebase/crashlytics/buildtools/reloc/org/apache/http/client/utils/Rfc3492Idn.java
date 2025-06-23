package com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.utils;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.annotation.Contract;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.annotation.ThreadingBehavior;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.util.StringTokenizer;

@Contract(threading = ThreadingBehavior.IMMUTABLE)
@Deprecated
/* loaded from: classes10.dex */
public class Rfc3492Idn implements Idn {
    private static final String ACE_PREFIX = "xn--";
    private static final int base = 36;
    private static final int damp = 700;
    private static final char delimiter = '-';
    private static final int initial_bias = 72;
    private static final int initial_n = 128;
    private static final int skew = 38;
    private static final int tmax = 26;
    private static final int tmin = 1;

    private int adapt(int i, int i2, boolean z) {
        int i3;
        if (z) {
            i3 = i / 700;
        } else {
            i3 = i / 2;
        }
        int i4 = i3 + (i3 / i2);
        int i5 = 0;
        while (i4 > 455) {
            i4 /= 35;
            i5 += 36;
        }
        return i5 + ((i4 * 36) / (i4 + 38));
    }

    private int digit(char c) {
        if (c >= 'A' && c <= 'Z') {
            return c - 'A';
        }
        if (c >= 'a' && c <= 'z') {
            return c - 'a';
        }
        if (c >= '0' && c <= '9') {
            return c - 22;
        }
        throw new IllegalArgumentException("illegal digit: " + c);
    }

    public String decode(String str) {
        boolean z;
        int i;
        StringBuilder sb = new StringBuilder(str.length());
        int lastIndexOf = str.lastIndexOf(45);
        int i2 = 128;
        int i3 = 72;
        if (lastIndexOf != -1) {
            sb.append(str.subSequence(0, lastIndexOf));
            str = str.substring(lastIndexOf + 1);
        }
        int i4 = 0;
        while (!str.isEmpty()) {
            int i5 = 36;
            int i6 = i4;
            int i7 = 1;
            while (!str.isEmpty()) {
                char charAt = str.charAt(0);
                str = str.substring(1);
                int digit = digit(charAt);
                i6 += digit * i7;
                if (i5 <= i3 + 1) {
                    i = 1;
                } else if (i5 >= i3 + 26) {
                    i = 26;
                } else {
                    i = i5 - i3;
                }
                if (digit < i) {
                    break;
                }
                i7 *= 36 - i;
                i5 += 36;
            }
            int i8 = i6 - i4;
            int length = sb.length() + 1;
            if (i4 == 0) {
                z = true;
            } else {
                z = false;
            }
            i3 = adapt(i8, length, z);
            i2 += i6 / (sb.length() + 1);
            int length2 = i6 % (sb.length() + 1);
            sb.insert(length2, (char) i2);
            i4 = length2 + 1;
        }
        return sb.toString();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.utils.Idn
    public String toUnicode(String str) {
        StringBuilder sb = new StringBuilder(str.length());
        StringTokenizer stringTokenizer = new StringTokenizer(str, FileUtils.FILE_EXTENSION_SEPARATOR);
        while (stringTokenizer.hasMoreTokens()) {
            String nextToken = stringTokenizer.nextToken();
            if (sb.length() > 0) {
                sb.append('.');
            }
            if (nextToken.startsWith(ACE_PREFIX)) {
                nextToken = decode(nextToken.substring(4));
            }
            sb.append(nextToken);
        }
        return sb.toString();
    }
}
