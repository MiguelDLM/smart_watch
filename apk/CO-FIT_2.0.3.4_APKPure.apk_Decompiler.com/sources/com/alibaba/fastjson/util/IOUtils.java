package com.alibaba.fastjson.util;

import com.alibaba.fastjson.JSONException;
import com.miguelcatalan.materialsearchview.MaterialSearchView;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Arrays;
import java.util.Properties;
import okio.Utf8;

public class IOUtils {
    public static final char[] ASCII_CHARS = {'0', '0', '0', '1', '0', '2', '0', '3', '0', '4', '0', '5', '0', '6', '0', '7', '0', '8', '0', '9', '0', 'A', '0', 'B', '0', 'C', '0', 'D', '0', 'E', '0', 'F', '1', '0', '1', '1', '1', '2', '1', '3', '1', '4', '1', '5', '1', '6', '1', '7', '1', '8', '1', '9', '1', 'A', '1', 'B', '1', 'C', '1', 'D', '1', 'E', '1', 'F', '2', '0', '2', '1', '2', '2', '2', '3', '2', '4', '2', '5', '2', '6', '2', '7', '2', '8', '2', '9', '2', 'A', '2', 'B', '2', 'C', '2', 'D', '2', 'E', '2', 'F'};
    public static final char[] CA;
    public static final Properties DEFAULT_PROPERTIES = new Properties();
    public static final char[] DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    static final char[] DigitOnes = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    static final char[] DigitTens = {'0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '4', '4', '4', '4', '4', '4', '4', '4', '4', '4', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '6', '6', '6', '6', '6', '6', '6', '6', '6', '6', '7', '7', '7', '7', '7', '7', '7', '7', '7', '7', '8', '8', '8', '8', '8', '8', '8', '8', '8', '8', '9', '9', '9', '9', '9', '9', '9', '9', '9', '9'};
    public static final String FASTJSON_COMPATIBLEWITHFIELDNAME = "fastjson.compatibleWithFieldName";
    public static final String FASTJSON_COMPATIBLEWITHJAVABEAN = "fastjson.compatibleWithJavaBean";
    public static final String FASTJSON_PROPERTIES = "fastjson.properties";
    public static final int[] IA;
    public static final Charset UTF8 = Charset.forName("UTF-8");
    static final char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    public static final boolean[] firstIdentifierFlags = new boolean[256];
    public static final boolean[] identifierFlags = new boolean[256];
    public static final char[] replaceChars = new char[93];
    static final int[] sizeTable = {9, 99, 999, MaterialSearchView.f3894Xx000oIo, 99999, 999999, 9999999, 99999999, 999999999, Integer.MAX_VALUE};
    public static final byte[] specicalFlags_doubleQuotes;
    public static final boolean[] specicalFlags_doubleQuotesFlags = new boolean[161];
    public static final byte[] specicalFlags_singleQuotes;
    public static final boolean[] specicalFlags_singleQuotesFlags = new boolean[161];

    static {
        boolean z;
        boolean z2;
        char c = 0;
        while (true) {
            boolean[] zArr = firstIdentifierFlags;
            if (c >= zArr.length) {
                break;
            }
            if (c >= 'A' && c <= 'Z') {
                zArr[c] = true;
            } else if (c >= 'a' && c <= 'z') {
                zArr[c] = true;
            } else if (c == '_' || c == '$') {
                zArr[c] = true;
            }
            c = (char) (c + 1);
        }
        char c2 = 0;
        while (true) {
            boolean[] zArr2 = identifierFlags;
            if (c2 < zArr2.length) {
                if (c2 >= 'A' && c2 <= 'Z') {
                    zArr2[c2] = true;
                } else if (c2 >= 'a' && c2 <= 'z') {
                    zArr2[c2] = true;
                } else if (c2 == '_') {
                    zArr2[c2] = true;
                } else if (c2 >= '0' && c2 <= '9') {
                    zArr2[c2] = true;
                }
                c2 = (char) (c2 + 1);
            } else {
                try {
                    break;
                } catch (Throwable unused) {
                }
            }
        }
        loadPropertiesFromFile();
        byte[] bArr = new byte[161];
        specicalFlags_doubleQuotes = bArr;
        byte[] bArr2 = new byte[161];
        specicalFlags_singleQuotes = bArr2;
        bArr[0] = 4;
        bArr[1] = 4;
        bArr[2] = 4;
        bArr[3] = 4;
        bArr[4] = 4;
        bArr[5] = 4;
        bArr[6] = 4;
        bArr[7] = 4;
        bArr[8] = 1;
        bArr[9] = 1;
        bArr[10] = 1;
        bArr[11] = 4;
        bArr[12] = 1;
        bArr[13] = 1;
        bArr[34] = 1;
        bArr[92] = 1;
        bArr2[0] = 4;
        bArr2[1] = 4;
        bArr2[2] = 4;
        bArr2[3] = 4;
        bArr2[4] = 4;
        bArr2[5] = 4;
        bArr2[6] = 4;
        bArr2[7] = 4;
        bArr2[8] = 1;
        bArr2[9] = 1;
        bArr2[10] = 1;
        bArr2[11] = 4;
        bArr2[12] = 1;
        bArr2[13] = 1;
        bArr2[92] = 1;
        bArr2[39] = 1;
        for (int i = 14; i <= 31; i++) {
            specicalFlags_doubleQuotes[i] = 4;
            specicalFlags_singleQuotes[i] = 4;
        }
        for (int i2 = 127; i2 < 160; i2++) {
            specicalFlags_doubleQuotes[i2] = 4;
            specicalFlags_singleQuotes[i2] = 4;
        }
        for (int i3 = 0; i3 < 161; i3++) {
            boolean[] zArr3 = specicalFlags_doubleQuotesFlags;
            if (specicalFlags_doubleQuotes[i3] != 0) {
                z = true;
            } else {
                z = false;
            }
            zArr3[i3] = z;
            boolean[] zArr4 = specicalFlags_singleQuotesFlags;
            if (specicalFlags_singleQuotes[i3] != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            zArr4[i3] = z2;
        }
        char[] cArr = replaceChars;
        cArr[0] = '0';
        cArr[1] = '1';
        cArr[2] = '2';
        cArr[3] = '3';
        cArr[4] = '4';
        cArr[5] = '5';
        cArr[6] = '6';
        cArr[7] = '7';
        cArr[8] = 'b';
        cArr[9] = 't';
        cArr[10] = 'n';
        cArr[11] = 'v';
        cArr[12] = 'f';
        cArr[13] = 'r';
        cArr[34] = '\"';
        cArr[39] = '\'';
        cArr[47] = com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.IOUtils.DIR_SEPARATOR_UNIX;
        cArr[92] = '\\';
        char[] charArray = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
        CA = charArray;
        int[] iArr = new int[256];
        IA = iArr;
        Arrays.fill(iArr, -1);
        int length = charArray.length;
        for (int i4 = 0; i4 < length; i4++) {
            IA[CA[i4]] = i4;
        }
        IA[61] = 0;
    }

    public static void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    public static void decode(CharsetDecoder charsetDecoder, ByteBuffer byteBuffer, CharBuffer charBuffer) {
        try {
            CoderResult decode = charsetDecoder.decode(byteBuffer, charBuffer, true);
            if (!decode.isUnderflow()) {
                decode.throwException();
            }
            CoderResult flush = charsetDecoder.flush(charBuffer);
            if (!flush.isUnderflow()) {
                flush.throwException();
            }
        } catch (CharacterCodingException e) {
            throw new JSONException("utf8 decode error, " + e.getMessage(), e);
        }
    }

    public static byte[] decodeBase64(char[] cArr, int i, int i2) {
        int i3;
        int i4 = i2;
        int i5 = 0;
        if (i4 == 0) {
            return new byte[0];
        }
        int i6 = (i + i4) - 1;
        int i7 = i;
        while (i7 < i6 && IA[cArr[i7]] < 0) {
            i7++;
        }
        while (i6 > 0 && IA[cArr[i6]] < 0) {
            i6--;
        }
        int i8 = cArr[i6] == '=' ? cArr[i6 + -1] == '=' ? 2 : 1 : 0;
        int i9 = (i6 - i7) + 1;
        if (i4 > 76) {
            i3 = (cArr[76] == 13 ? i9 / 78 : 0) << 1;
        } else {
            i3 = 0;
        }
        int i10 = (((i9 - i3) * 6) >> 3) - i8;
        byte[] bArr = new byte[i10];
        int i11 = (i10 / 3) * 3;
        int i12 = 0;
        loop2:
        while (true) {
            int i13 = 0;
            while (i12 < i11) {
                int[] iArr = IA;
                int i14 = i7 + 4;
                int i15 = iArr[cArr[i7 + 3]] | (iArr[cArr[i7 + 1]] << 12) | (iArr[cArr[i7]] << 18) | (iArr[cArr[i7 + 2]] << 6);
                bArr[i12] = (byte) (i15 >> 16);
                int i16 = i12 + 2;
                bArr[i12 + 1] = (byte) (i15 >> 8);
                i12 += 3;
                bArr[i16] = (byte) i15;
                if (i3 <= 0 || (i13 = i13 + 1) != 19) {
                    i7 = i14;
                } else {
                    i7 += 6;
                }
            }
            break loop2;
        }
        if (i12 < i10) {
            int i17 = 0;
            while (i7 <= i6 - i8) {
                i5 |= IA[cArr[i7]] << (18 - (i17 * 6));
                i17++;
                i7++;
            }
            int i18 = 16;
            while (i12 < i10) {
                bArr[i12] = (byte) (i5 >> i18);
                i18 -= 8;
                i12++;
            }
        }
        return bArr;
    }

    public static int decodeUTF8(byte[] bArr, int i, int i2, char[] cArr) {
        int i3;
        int i4 = i + i2;
        int min = Math.min(i2, cArr.length);
        int i5 = 0;
        while (i3 < min) {
            byte b = bArr[r9];
            if (b < 0) {
                break;
            }
            i = r9 + 1;
            cArr[i3] = (char) b;
            i5 = i3 + 1;
        }
        while (r9 < i4) {
            int i6 = r9 + 1;
            byte b2 = bArr[r9];
            if (b2 >= 0) {
                cArr[i3] = (char) b2;
                i3++;
                r9 = i6;
            } else if ((b2 >> 5) != -2 || (b2 & 30) == 0) {
                if ((b2 >> 4) == -2) {
                    int i7 = r9 + 2;
                    if (i7 < i4) {
                        byte b3 = bArr[i6];
                        r9 += 3;
                        byte b4 = bArr[i7];
                        if (!(b2 == -32 && (b3 & 224) == 128) && (b3 & 192) == 128 && (b4 & 192) == 128) {
                            char c = (char) (((b3 << 6) ^ (b2 << 12)) ^ (-123008 ^ b4));
                            if (c >= 55296 && c < 57344) {
                                return -1;
                            }
                            cArr[i3] = c;
                            i3++;
                        }
                    }
                    return -1;
                }
                if ((b2 >> 3) == -2 && r9 + 3 < i4) {
                    byte b5 = bArr[i6];
                    int i8 = r9 + 3;
                    byte b6 = bArr[r9 + 2];
                    r9 += 4;
                    byte b7 = bArr[i8];
                    byte b8 = (((b2 << 18) ^ (b5 << 12)) ^ (b6 << 6)) ^ (3678080 ^ b7);
                    if ((b5 & 192) == 128 && (b6 & 192) == 128 && (b7 & 192) == 128 && b8 >= 65536 && b8 < 1114112) {
                        int i9 = i3 + 1;
                        cArr[i3] = (char) ((b8 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
                        i3 += 2;
                        cArr[i9] = (char) ((b8 & 1023) + Utf8.LOG_SURROGATE_HEADER);
                    }
                }
                return -1;
            } else if (i6 >= i4) {
                return -1;
            } else {
                r9 += 2;
                byte b9 = bArr[i6];
                if ((b9 & 192) != 128) {
                    return -1;
                }
                cArr[i3] = (char) ((b9 ^ (b2 << 6)) ^ 3968);
                i3++;
            }
        }
        return i3;
    }

    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Incorrect type for immutable var: ssa=char, code=int, for r3v0, types: [int, char] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int encodeUTF8(char[] r9, int r10, int r11, byte[] r12) {
        /*
            int r0 = r10 + r11
            int r1 = r12.length
            int r11 = java.lang.Math.min(r11, r1)
            r1 = 0
        L_0x0008:
            r2 = 128(0x80, float:1.794E-43)
            if (r1 >= r11) goto L_0x0019
            char r3 = r9[r10]
            if (r3 >= r2) goto L_0x0019
            int r2 = r1 + 1
            int r10 = r10 + 1
            byte r3 = (byte) r3
            r12[r1] = r3
            r1 = r2
            goto L_0x0008
        L_0x0019:
            if (r10 >= r0) goto L_0x00c0
            int r11 = r10 + 1
            char r3 = r9[r10]
            if (r3 >= r2) goto L_0x0027
            int r10 = r1 + 1
            byte r3 = (byte) r3
            r12[r1] = r3
            goto L_0x006b
        L_0x0027:
            r4 = 2048(0x800, float:2.87E-42)
            if (r3 >= r4) goto L_0x003d
            int r10 = r1 + 1
            int r4 = r3 >> 6
            r4 = r4 | 192(0xc0, float:2.69E-43)
            byte r4 = (byte) r4
            r12[r1] = r4
            int r1 = r1 + 2
            r3 = r3 & 63
            r3 = r3 | r2
            byte r3 = (byte) r3
            r12[r10] = r3
            goto L_0x006c
        L_0x003d:
            r4 = 55296(0xd800, float:7.7486E-41)
            r5 = 63
            if (r3 < r4) goto L_0x00a5
            r6 = 57344(0xe000, float:8.0356E-41)
            if (r3 >= r6) goto L_0x00a5
            r7 = 56320(0xdc00, float:7.8921E-41)
            if (r3 < r4) goto L_0x006e
            if (r3 >= r7) goto L_0x006e
            int r4 = r0 - r10
            r8 = 2
            if (r4 >= r8) goto L_0x0057
            r3 = -1
            goto L_0x0077
        L_0x0057:
            int r4 = r10 + 1
            char r4 = r9[r4]
            if (r4 < r7) goto L_0x0067
            if (r4 >= r6) goto L_0x0067
            int r3 = r3 << 10
            int r3 = r3 + r4
            r4 = -56613888(0xfffffffffca02400, float:-6.651981E36)
            int r3 = r3 + r4
            goto L_0x0077
        L_0x0067:
            int r10 = r1 + 1
            r12[r1] = r5
        L_0x006b:
            r1 = r10
        L_0x006c:
            r10 = r11
            goto L_0x0019
        L_0x006e:
            if (r3 < r7) goto L_0x0077
            if (r3 >= r6) goto L_0x0077
            int r10 = r1 + 1
            r12[r1] = r5
            goto L_0x006b
        L_0x0077:
            if (r3 >= 0) goto L_0x007e
            int r10 = r1 + 1
            r12[r1] = r5
            goto L_0x006b
        L_0x007e:
            int r11 = r1 + 1
            int r4 = r3 >> 18
            r4 = r4 | 240(0xf0, float:3.36E-43)
            byte r4 = (byte) r4
            r12[r1] = r4
            int r4 = r1 + 2
            int r6 = r3 >> 12
            r6 = r6 & r5
            r6 = r6 | r2
            byte r6 = (byte) r6
            r12[r11] = r6
            int r11 = r1 + 3
            int r6 = r3 >> 6
            r5 = r5 & r6
            r5 = r5 | r2
            byte r5 = (byte) r5
            r12[r4] = r5
            int r1 = r1 + 4
            r3 = r3 & 63
            r3 = r3 | r2
            byte r3 = (byte) r3
            r12[r11] = r3
            int r11 = r10 + 2
            r10 = r1
            goto L_0x006b
        L_0x00a5:
            int r10 = r1 + 1
            int r4 = r3 >> 12
            r4 = r4 | 224(0xe0, float:3.14E-43)
            byte r4 = (byte) r4
            r12[r1] = r4
            int r4 = r1 + 2
            int r6 = r3 >> 6
            r5 = r5 & r6
            r5 = r5 | r2
            byte r5 = (byte) r5
            r12[r10] = r5
            int r1 = r1 + 3
            r10 = r3 & 63
            r10 = r10 | r2
            byte r10 = (byte) r10
            r12[r4] = r10
            goto L_0x006c
        L_0x00c0:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.util.IOUtils.encodeUTF8(char[], int, int, byte[]):int");
    }

    public static boolean firstIdentifier(char c) {
        boolean[] zArr = firstIdentifierFlags;
        if (c >= zArr.length || !zArr[c]) {
            return false;
        }
        return true;
    }

    public static void getChars(long j, int i, char[] cArr) {
        char c;
        if (j < 0) {
            j = -j;
            c = '-';
        } else {
            c = 0;
        }
        while (j > 2147483647L) {
            long j2 = j / 100;
            int i2 = (int) (j - (((j2 << 6) + (j2 << 5)) + (j2 << 2)));
            cArr[i - 1] = DigitOnes[i2];
            i -= 2;
            cArr[i] = DigitTens[i2];
            j = j2;
        }
        int i3 = (int) j;
        while (i3 >= 65536) {
            int i4 = i3 / 100;
            int i5 = i3 - (((i4 << 6) + (i4 << 5)) + (i4 << 2));
            cArr[i - 1] = DigitOnes[i5];
            i -= 2;
            cArr[i] = DigitTens[i5];
            i3 = i4;
        }
        while (true) {
            int i6 = (52429 * i3) >>> 19;
            int i7 = i - 1;
            cArr[i7] = digits[i3 - ((i6 << 3) + (i6 << 1))];
            if (i6 == 0) {
                break;
            }
            i3 = i6;
            i = i7;
        }
        if (c != 0) {
            cArr[i - 2] = c;
        }
    }

    public static String getStringProperty(String str) {
        String str2;
        try {
            str2 = System.getProperty(str);
        } catch (SecurityException unused) {
            str2 = null;
        }
        if (str2 == null) {
            return DEFAULT_PROPERTIES.getProperty(str);
        }
        return str2;
    }

    public static boolean isIdent(char c) {
        boolean[] zArr = identifierFlags;
        if (c >= zArr.length || !zArr[c]) {
            return false;
        }
        return true;
    }

    public static boolean isValidJsonpQueryParam(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt != '.' && !isIdent(charAt)) {
                return false;
            }
        }
        return true;
    }

    public static void loadPropertiesFromFile() {
        InputStream inputStream = (InputStream) AccessController.doPrivileged(new PrivilegedAction<InputStream>() {
            public InputStream run() {
                ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
                if (contextClassLoader != null) {
                    return contextClassLoader.getResourceAsStream(IOUtils.FASTJSON_PROPERTIES);
                }
                return ClassLoader.getSystemResourceAsStream(IOUtils.FASTJSON_PROPERTIES);
            }
        });
        if (inputStream != null) {
            try {
                DEFAULT_PROPERTIES.load(inputStream);
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    public static String readAll(Reader reader) {
        StringBuilder sb = new StringBuilder();
        try {
            char[] cArr = new char[2048];
            while (true) {
                int read = reader.read(cArr, 0, 2048);
                if (read < 0) {
                    return sb.toString();
                }
                sb.append(cArr, 0, read);
            }
        } catch (Exception e) {
            throw new JSONException("read string from reader error", e);
        }
    }

    public static int stringSize(long j) {
        long j2 = 10;
        for (int i = 1; i < 19; i++) {
            if (j < j2) {
                return i;
            }
            j2 *= 10;
        }
        return 19;
    }

    public static int stringSize(int i) {
        int i2 = 0;
        while (i > sizeTable[i2]) {
            i2++;
        }
        return i2 + 1;
    }

    public static void getChars(int i, int i2, char[] cArr) {
        char c;
        if (i < 0) {
            i = -i;
            c = '-';
        } else {
            c = 0;
        }
        while (i >= 65536) {
            int i3 = i / 100;
            int i4 = i - (((i3 << 6) + (i3 << 5)) + (i3 << 2));
            cArr[i2 - 1] = DigitOnes[i4];
            i2 -= 2;
            cArr[i2] = DigitTens[i4];
            i = i3;
        }
        while (true) {
            int i5 = (52429 * i) >>> 19;
            int i6 = i2 - 1;
            cArr[i6] = digits[i - ((i5 << 3) + (i5 << 1))];
            if (i5 == 0) {
                break;
            }
            i = i5;
            i2 = i6;
        }
        if (c != 0) {
            cArr[i2 - 2] = c;
        }
    }

    public static byte[] decodeBase64(String str, int i, int i2) {
        int i3;
        int i4;
        String str2 = str;
        int i5 = i2;
        if (i5 == 0) {
            return new byte[0];
        }
        int i6 = (i + i5) - 1;
        int i7 = i;
        while (i3 < i6 && IA[str2.charAt(i3)] < 0) {
            i7 = i3 + 1;
        }
        while (i6 > 0 && IA[str2.charAt(i6)] < 0) {
            i6--;
        }
        int i8 = str2.charAt(i6) == '=' ? str2.charAt(i6 + -1) == '=' ? 2 : 1 : 0;
        int i9 = (i6 - i3) + 1;
        if (i5 > 76) {
            i4 = (str2.charAt(76) == 13 ? i9 / 78 : 0) << 1;
        } else {
            i4 = 0;
        }
        int i10 = (((i9 - i4) * 6) >> 3) - i8;
        byte[] bArr = new byte[i10];
        int i11 = (i10 / 3) * 3;
        int i12 = 0;
        int i13 = 0;
        while (i12 < i11) {
            int[] iArr = IA;
            int i14 = i3 + 4;
            int i15 = iArr[str2.charAt(i3 + 3)] | (iArr[str2.charAt(i3 + 1)] << 12) | (iArr[str2.charAt(i3)] << 18) | (iArr[str2.charAt(i3 + 2)] << 6);
            bArr[i12] = (byte) (i15 >> 16);
            int i16 = i12 + 2;
            bArr[i12 + 1] = (byte) (i15 >> 8);
            i12 += 3;
            bArr[i16] = (byte) i15;
            if (i4 <= 0 || (i13 = i13 + 1) != 19) {
                i3 = i14;
            } else {
                i3 += 6;
                i13 = 0;
            }
        }
        if (i12 < i10) {
            int i17 = 0;
            int i18 = 0;
            while (i3 <= i6 - i8) {
                i17 |= IA[str2.charAt(i3)] << (18 - (i18 * 6));
                i18++;
                i3++;
            }
            int i19 = 16;
            while (i12 < i10) {
                bArr[i12] = (byte) (i17 >> i19);
                i19 -= 8;
                i12++;
            }
        }
        return bArr;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v9, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void getChars(byte r4, int r5, char[] r6) {
        /*
            if (r4 >= 0) goto L_0x0006
            int r4 = -r4
            r0 = 45
            goto L_0x0007
        L_0x0006:
            r0 = 0
        L_0x0007:
            r1 = 52429(0xcccd, float:7.3469E-41)
            int r1 = r1 * r4
            int r1 = r1 >>> 19
            int r2 = r1 << 3
            int r3 = r1 << 1
            int r2 = r2 + r3
            int r4 = r4 - r2
            int r2 = r5 + -1
            char[] r3 = digits
            char r4 = r3[r4]
            r6[r2] = r4
            if (r1 != 0) goto L_0x0025
            if (r0 == 0) goto L_0x0024
            int r5 = r5 + -2
            r6[r5] = r0
        L_0x0024:
            return
        L_0x0025:
            r4 = r1
            r5 = r2
            goto L_0x0007
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.util.IOUtils.getChars(byte, int, char[]):void");
    }

    public static byte[] decodeBase64(String str) {
        int i;
        int i2;
        String str2 = str;
        int length = str.length();
        if (length == 0) {
            return new byte[0];
        }
        int i3 = length - 1;
        int i4 = 0;
        while (i < i3 && IA[str2.charAt(i) & 255] < 0) {
            i4 = i + 1;
        }
        while (i3 > 0 && IA[str2.charAt(i3) & 255] < 0) {
            i3--;
        }
        int i5 = str2.charAt(i3) == '=' ? str2.charAt(i3 + -1) == '=' ? 2 : 1 : 0;
        int i6 = (i3 - i) + 1;
        if (length > 76) {
            i2 = (str2.charAt(76) == 13 ? i6 / 78 : 0) << 1;
        } else {
            i2 = 0;
        }
        int i7 = (((i6 - i2) * 6) >> 3) - i5;
        byte[] bArr = new byte[i7];
        int i8 = (i7 / 3) * 3;
        int i9 = 0;
        int i10 = 0;
        while (i9 < i8) {
            int[] iArr = IA;
            int i11 = i + 4;
            int i12 = iArr[str2.charAt(i + 3)] | (iArr[str2.charAt(i + 1)] << 12) | (iArr[str2.charAt(i)] << 18) | (iArr[str2.charAt(i + 2)] << 6);
            bArr[i9] = (byte) (i12 >> 16);
            int i13 = i9 + 2;
            bArr[i9 + 1] = (byte) (i12 >> 8);
            i9 += 3;
            bArr[i13] = (byte) i12;
            if (i2 <= 0 || (i10 = i10 + 1) != 19) {
                i = i11;
            } else {
                i += 6;
                i10 = 0;
            }
        }
        if (i9 < i7) {
            int i14 = 0;
            int i15 = 0;
            while (i <= i3 - i5) {
                i14 |= IA[str2.charAt(i)] << (18 - (i15 * 6));
                i15++;
                i++;
            }
            int i16 = 16;
            while (i9 < i7) {
                bArr[i9] = (byte) (i14 >> i16);
                i16 -= 8;
                i9++;
            }
        }
        return bArr;
    }
}
