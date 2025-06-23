package com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.language;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.EncoderException;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.StringEncoder;

/* loaded from: classes10.dex */
public class Metaphone implements StringEncoder {
    private static final String FRONTV = "EIY";
    private static final String VARSON = "CSPTG";
    private static final String VOWELS = "AEIOU";
    private int maxCodeLen = 4;

    private boolean isLastChar(int i, int i2) {
        return i2 + 1 == i;
    }

    private boolean isNextChar(StringBuilder sb, int i, char c) {
        if (i < 0 || i >= sb.length() - 1 || sb.charAt(i + 1) != c) {
            return false;
        }
        return true;
    }

    private boolean isPreviousChar(StringBuilder sb, int i, char c) {
        if (i <= 0 || i >= sb.length() || sb.charAt(i - 1) != c) {
            return false;
        }
        return true;
    }

    private boolean isVowel(StringBuilder sb, int i) {
        if (VOWELS.indexOf(sb.charAt(i)) >= 0) {
            return true;
        }
        return false;
    }

    private boolean regionMatch(StringBuilder sb, int i, String str) {
        if (i >= 0 && (str.length() + i) - 1 < sb.length()) {
            return sb.substring(i, str.length() + i).equals(str);
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.Encoder
    public Object encode(Object obj) throws EncoderException {
        if (obj instanceof String) {
            return metaphone((String) obj);
        }
        throw new EncoderException("Parameter supplied to Metaphone encode is not of type java.lang.String");
    }

    public int getMaxCodeLen() {
        return this.maxCodeLen;
    }

    public boolean isMetaphoneEqual(String str, String str2) {
        return metaphone(str).equals(metaphone(str2));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x028f, code lost:
    
        r5 = r5 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String metaphone(java.lang.String r17) {
        /*
            Method dump skipped, instructions count: 740
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.language.Metaphone.metaphone(java.lang.String):java.lang.String");
    }

    public void setMaxCodeLen(int i) {
        this.maxCodeLen = i;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.StringEncoder
    public String encode(String str) {
        return metaphone(str);
    }
}
