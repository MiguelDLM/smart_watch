package com.jd.ad.sdk.jad_do;

import android.text.TextUtils;

/* loaded from: classes10.dex */
public final class jad_jw {
    public static boolean jad_an(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            int length = str.length();
            if (length % 4 != 0) {
                return false;
            }
            char[] charArray = str.toCharArray();
            for (int i = 0; i < length; i++) {
                if (i == length - 3 && charArray[i] == '=') {
                    return false;
                }
                char c = charArray[i];
                if ((c < 'A' || c > 'Z') && ((c < 'a' || c > 'z') && !((c >= '0' && c <= '9') || c == '_' || c == '-' || c == '='))) {
                    return false;
                }
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
