package org.apache.commons.text;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import java.util.HashSet;
import java.util.Set;
import org.apache.commons.lang3.xXOx;

/* loaded from: classes6.dex */
public class I0Io {
    public static String II0xO0(String str, boolean z, char... cArr) {
        if (xXOx.XIXIX(str)) {
            return str;
        }
        String lowerCase = str.toLowerCase();
        int length = lowerCase.length();
        int[] iArr = new int[length];
        Set<Integer> oIX0oI2 = oIX0oI(cArr);
        boolean z2 = z;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int codePointAt = lowerCase.codePointAt(i);
            if (oIX0oI2.contains(Integer.valueOf(codePointAt))) {
                if (i2 != 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                i += Character.charCount(codePointAt);
            } else if (!z2 && (i2 != 0 || !z)) {
                iArr[i2] = codePointAt;
                i += Character.charCount(codePointAt);
                i2++;
            } else {
                int titleCase = Character.toTitleCase(codePointAt);
                iArr[i2] = titleCase;
                i += Character.charCount(titleCase);
                i2++;
                z2 = false;
            }
        }
        if (i2 != 0) {
            return new String(iArr, 0, i2);
        }
        return lowerCase;
    }

    public static Set<Integer> oIX0oI(char[] cArr) {
        HashSet hashSet = new HashSet();
        hashSet.add(Integer.valueOf(Character.codePointAt(new char[]{TokenParser.SP}, 0)));
        if (org.apache.commons.lang3.oxoX.x0(cArr)) {
            return hashSet;
        }
        for (int i = 0; i < cArr.length; i++) {
            hashSet.add(Integer.valueOf(Character.codePointAt(cArr, i)));
        }
        return hashSet;
    }
}
