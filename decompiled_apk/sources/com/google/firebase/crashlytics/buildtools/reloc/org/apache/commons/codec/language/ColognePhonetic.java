package com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.language;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.EncoderException;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.StringEncoder;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.IOUtils;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.util.Locale;

/* loaded from: classes10.dex */
public class ColognePhonetic implements StringEncoder {
    private static final char[] AEIJOUY = {'A', 'E', 'I', 'J', 'O', 'U', 'Y'};
    private static final char[] SCZ = {'S', 'C', 'Z'};
    private static final char[] WFPV = {'W', 'F', 'P', 'V'};
    private static final char[] GKQ = {'G', 'K', 'Q'};
    private static final char[] CKQ = {'C', 'K', 'Q'};
    private static final char[] AHKLOQRUX = {'A', 'H', 'K', 'L', 'O', 'Q', 'R', 'U', 'X'};
    private static final char[] SZ = {'S', 'Z'};
    private static final char[] AHOUKQX = {'A', 'H', 'O', 'U', 'K', 'Q', 'X'};
    private static final char[] TDX = {'T', 'D', 'X'};
    private static final char[][] PREPROCESS_MAP = {new char[]{196, 'A'}, new char[]{220, 'U'}, new char[]{214, 'O'}, new char[]{223, 'S'}};

    /* loaded from: classes10.dex */
    public class CologneInputBuffer extends CologneBuffer {
        public CologneInputBuffer(char[] cArr) {
            super(cArr);
        }

        public void addLeft(char c) {
            this.length++;
            this.data[getNextPos()] = c;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.language.ColognePhonetic.CologneBuffer
        public char[] copyData(int i, int i2) {
            char[] cArr = new char[i2];
            char[] cArr2 = this.data;
            System.arraycopy(cArr2, (cArr2.length - this.length) + i, cArr, 0, i2);
            return cArr;
        }

        public char getNextChar() {
            return this.data[getNextPos()];
        }

        public int getNextPos() {
            return this.data.length - this.length;
        }

        public char removeNext() {
            this.length--;
            return getNextChar();
        }
    }

    /* loaded from: classes10.dex */
    public class CologneOutputBuffer extends CologneBuffer {
        public CologneOutputBuffer(int i) {
            super(i);
        }

        public void addRight(char c) {
            char[] cArr = this.data;
            int i = this.length;
            cArr[i] = c;
            this.length = i + 1;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.language.ColognePhonetic.CologneBuffer
        public char[] copyData(int i, int i2) {
            char[] cArr = new char[i2];
            System.arraycopy(this.data, i, cArr, 0, i2);
            return cArr;
        }
    }

    private static boolean arrayContains(char[] cArr, char c) {
        for (char c2 : cArr) {
            if (c2 == c) {
                return true;
            }
        }
        return false;
    }

    private String preprocess(String str) {
        char[] charArray = str.toUpperCase(Locale.GERMAN).toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] > 'Z') {
                char[][] cArr = PREPROCESS_MAP;
                int length = cArr.length;
                int i2 = 0;
                while (true) {
                    if (i2 < length) {
                        char[] cArr2 = cArr[i2];
                        if (charArray[i] == cArr2[0]) {
                            charArray[i] = cArr2[1];
                            break;
                        }
                        i2++;
                    }
                }
            }
        }
        return new String(charArray);
    }

    public String colognePhonetic(String str) {
        char c;
        char c2;
        if (str == null) {
            return null;
        }
        String preprocess = preprocess(str);
        CologneOutputBuffer cologneOutputBuffer = new CologneOutputBuffer(preprocess.length() * 2);
        CologneInputBuffer cologneInputBuffer = new CologneInputBuffer(preprocess.toCharArray());
        int length = cologneInputBuffer.length();
        char c3 = IOUtils.DIR_SEPARATOR_UNIX;
        char c4 = '-';
        while (length > 0) {
            char removeNext = cologneInputBuffer.removeNext();
            int length2 = cologneInputBuffer.length();
            if (length2 > 0) {
                c = cologneInputBuffer.getNextChar();
            } else {
                c = '-';
            }
            if (arrayContains(AEIJOUY, removeNext)) {
                c2 = '0';
            } else if (removeNext != 'H' && removeNext >= 'A' && removeNext <= 'Z') {
                if (removeNext != 'B' && (removeNext != 'P' || c == 'H')) {
                    if ((removeNext == 'D' || removeNext == 'T') && !arrayContains(SCZ, c)) {
                        c2 = '2';
                    } else if (arrayContains(WFPV, removeNext)) {
                        c2 = '3';
                    } else {
                        if (!arrayContains(GKQ, removeNext)) {
                            if (removeNext == 'X' && !arrayContains(CKQ, c4)) {
                                cologneInputBuffer.addLeft('S');
                                length2++;
                            } else {
                                if (removeNext != 'S' && removeNext != 'Z') {
                                    if (removeNext == 'C') {
                                        if (c3 != '/') {
                                        }
                                    } else if (!arrayContains(TDX, removeNext)) {
                                        if (removeNext == 'R') {
                                            c2 = '7';
                                        } else if (removeNext == 'L') {
                                            c2 = '5';
                                        } else if (removeNext != 'M' && removeNext != 'N') {
                                            c2 = removeNext;
                                        } else {
                                            c2 = '6';
                                        }
                                    }
                                }
                                c2 = '8';
                            }
                        }
                        c2 = '4';
                    }
                } else {
                    c2 = '1';
                }
            } else if (c3 == '/') {
                length = length2;
            } else {
                c2 = '-';
            }
            if (c2 != '-' && ((c3 != c2 && (c2 != '0' || c3 == '/')) || c2 < '0' || c2 > '8')) {
                cologneOutputBuffer.addRight(c2);
            }
            c3 = c2;
            c4 = removeNext;
            length = length2;
        }
        return cologneOutputBuffer.toString();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.Encoder
    public Object encode(Object obj) throws EncoderException {
        if (obj instanceof String) {
            return encode((String) obj);
        }
        throw new EncoderException("This method's parameter was expected to be of the type " + String.class.getName() + ". But actually it was of the type " + obj.getClass().getName() + FileUtils.FILE_EXTENSION_SEPARATOR);
    }

    public boolean isEncodeEqual(String str, String str2) {
        return colognePhonetic(str).equals(colognePhonetic(str2));
    }

    /* loaded from: classes10.dex */
    public abstract class CologneBuffer {
        protected final char[] data;
        protected int length;

        public CologneBuffer(char[] cArr) {
            this.length = 0;
            this.data = cArr;
            this.length = cArr.length;
        }

        public abstract char[] copyData(int i, int i2);

        public int length() {
            return this.length;
        }

        public String toString() {
            return new String(copyData(0, this.length));
        }

        public CologneBuffer(int i) {
            this.length = 0;
            this.data = new char[i];
            this.length = 0;
        }
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.StringEncoder
    public String encode(String str) {
        return colognePhonetic(str);
    }
}
