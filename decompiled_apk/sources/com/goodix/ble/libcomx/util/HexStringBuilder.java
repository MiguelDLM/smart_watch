package com.goodix.ble.libcomx.util;

import java.util.Formatter;
import java.util.Locale;
import kotlin.OX00O0xII;

/* loaded from: classes9.dex */
public class HexStringBuilder implements CharSequence, Appendable {
    public static final char COMMENT_BEGIN_CHAR = '(';
    public static final char COMMENT_END_CHAR = ')';
    public static final String DEFAULT_PREFIX = "0x";
    public static final String DEFAULT_SEPARATOR = " ";
    public static final String DEFAULT_STRING_FOR_NULL = "null";
    private StringBuilder builder;
    private Formatter formatter;
    private String octetSeparator;
    private String strForNull;

    public HexStringBuilder() {
        this.strForNull = "null";
        this.builder = new StringBuilder(32);
    }

    public HexStringBuilder Ox() {
        return prefix();
    }

    public HexStringBuilder a(CharSequence charSequence) {
        return put(charSequence);
    }

    @Override // java.lang.CharSequence
    public char charAt(int i) {
        return this.builder.charAt(i);
    }

    public HexStringBuilder clear() {
        if (this.builder.length() > 0) {
            StringBuilder sb = this.builder;
            sb.delete(0, sb.length());
        }
        return this;
    }

    public HexStringBuilder comment(String str) {
        StringBuilder sb = this.builder;
        sb.append(COMMENT_BEGIN_CHAR);
        sb.append(str);
        sb.append(COMMENT_END_CHAR);
        return this;
    }

    public HexStringBuilder dump(byte[] bArr, int i) {
        if (bArr == null) {
            return put(this.strForNull);
        }
        return dump(bArr, 0, bArr.length, i, null, null);
    }

    public HexStringBuilder dumpAsAscii(byte[] bArr) {
        return dumpAsAscii(bArr, 0, -1, '.', '.');
    }

    public HexStringBuilder format(String str, Object... objArr) {
        if (this.formatter == null) {
            this.formatter = new Formatter(this.builder);
        }
        this.formatter.format(str, objArr);
        return this;
    }

    public StringBuilder getStringBuilder() {
        return this.builder;
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.builder.length();
    }

    public HexStringBuilder newLine() {
        this.builder.append("\n");
        return this;
    }

    public HexStringBuilder prefix() {
        this.builder.append(DEFAULT_PREFIX);
        return this;
    }

    public HexStringBuilder put(byte b) {
        format("%02X", Integer.valueOf(b & 255));
        return this;
    }

    public HexStringBuilder putSeparator() {
        String str = this.octetSeparator;
        if (str != null) {
            this.builder.append(str);
        } else {
            this.builder.append(" ");
        }
        return this;
    }

    public HexStringBuilder setDefaultStringForNull(String str) {
        this.strForNull = str;
        return this;
    }

    public HexStringBuilder setSeparator(String str) {
        this.octetSeparator = str;
        return this;
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i, int i2) {
        return this.builder.subSequence(i, i2);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        StringBuilder sb = this.builder;
        if (sb == null) {
            return super.toString();
        }
        return sb.toString();
    }

    public HexStringBuilder useSeparator() {
        return setSeparator(" ");
    }

    public HexStringBuilder comment(String str, Object... objArr) {
        this.builder.append(COMMENT_BEGIN_CHAR);
        format(str, objArr);
        this.builder.append(COMMENT_END_CHAR);
        return this;
    }

    public HexStringBuilder dumpAsAscii(byte[] bArr, int i, int i2, char c, char c2) {
        if (bArr == null) {
            return this;
        }
        if (i < 0 && (i = i + bArr.length) < 0) {
            i = 0;
        }
        if (i2 < 0) {
            i2 = bArr.length;
        }
        int i3 = i2 + i;
        if (i3 > bArr.length) {
            i3 = bArr.length;
        }
        int i4 = i3 - i;
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = bArr[i + i5] & 255;
            if (i6 < 32) {
                i6 = c;
            }
            if (i6 == 32) {
                i6 = c2;
            }
            if (i6 > 126) {
                i6 = c;
            }
            this.builder.append((char) i6);
        }
        return this;
    }

    public HexStringBuilder put(byte[] bArr) {
        if (bArr == null) {
            return put(this.strForNull);
        }
        return put(bArr, 0, bArr.length);
    }

    @Override // java.lang.Appendable
    public HexStringBuilder append(CharSequence charSequence) {
        this.builder.append(charSequence);
        return this;
    }

    public HexStringBuilder dump(byte[] bArr, int i, int i2, int i3, CharSequence charSequence, CharSequence charSequence2) {
        if (bArr == null) {
            return put(this.strForNull);
        }
        if (i < 0 && (i = i + bArr.length) < 0) {
            i = 0;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        int i4 = i2 + i;
        if (i4 > bArr.length) {
            i4 = bArr.length;
        }
        int i5 = i4 - i;
        if (i3 < 1) {
            i3 = 1;
        }
        int i6 = 0;
        while (i6 < i5) {
            if (i6 != 0) {
                newLine();
            }
            if (charSequence != null) {
                put(charSequence);
            }
            for (int i7 = 0; i7 < i3; i7++) {
                int i8 = i + i7;
                if (i8 < i4) {
                    format("%02X ", Integer.valueOf(bArr[i8] & 255));
                } else {
                    put("   ");
                }
            }
            for (int i9 = 0; i9 < i3; i9++) {
                int i10 = i + i9;
                if (i10 < i4) {
                    int i11 = bArr[i10] & 255;
                    if (i11 < 32) {
                        i11 = 46;
                    }
                    this.builder.append((char) (i11 <= 126 ? i11 : 46));
                } else {
                    put(" ");
                }
            }
            if (charSequence != null) {
                put(charSequence2);
            }
            i6 += i3;
            i += i3;
        }
        return this;
    }

    public HexStringBuilder(int i) {
        this.strForNull = "null";
        this.builder = new StringBuilder(i);
    }

    @Override // java.lang.Appendable
    public Appendable append(CharSequence charSequence, int i, int i2) {
        this.builder.append(charSequence, i, i2);
        return this;
    }

    public HexStringBuilder put(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            return put(this.strForNull);
        }
        if (i < 0 && (i = i + bArr.length) < 0) {
            i = 0;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        int i3 = i2 + i;
        if (i3 > bArr.length) {
            i3 = bArr.length;
        }
        while (i < i3) {
            put(bArr[i]);
            i++;
            String str = this.octetSeparator;
            if (str != null && i < i3) {
                this.builder.append(str);
            }
        }
        return this;
    }

    @Override // java.lang.Appendable
    public HexStringBuilder append(char c) {
        this.builder.append(c);
        return this;
    }

    public HexStringBuilder append(boolean z) {
        this.builder.append(z);
        return this;
    }

    public HexStringBuilder(StringBuilder sb) {
        this.strForNull = "null";
        this.builder = sb;
    }

    public HexStringBuilder append(int i) {
        this.builder.append(i);
        return this;
    }

    public HexStringBuilder append(long j) {
        this.builder.append(j);
        return this;
    }

    public HexStringBuilder append(float f) {
        this.builder.append(f);
        return this;
    }

    public HexStringBuilder append(double d) {
        this.builder.append(d);
        return this;
    }

    public HexStringBuilder put(CharSequence charSequence) {
        this.builder.append(charSequence);
        return this;
    }

    public HexStringBuilder put(boolean z) {
        this.builder.append(z);
        return this;
    }

    public HexStringBuilder put(short s) {
        format("%04X", Integer.valueOf(s & OX00O0xII.f29066Oxx0xo));
        return this;
    }

    public HexStringBuilder put(int i) {
        format("%08X", Integer.valueOf(i));
        return this;
    }

    public HexStringBuilder put(int i, int i2) {
        if (i2 < 1) {
            i2 = 1;
        }
        if (i2 > 4) {
            i2 = 4;
        }
        format(String.format(Locale.US, "%%0%dX", Integer.valueOf(i2 * 2)), Integer.valueOf(i));
        return this;
    }
}
