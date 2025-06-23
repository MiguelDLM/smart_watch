package com.alibaba.fastjson.parser;

import XIXIX.OOXIXo;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.TypeUtils;
import com.garmin.fit.O0Xx;
import com.google.android.exoplayer2.C;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.IOUtils;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import java.io.Closeable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Locale;
import java.util.TimeZone;
import java.util.UUID;

public abstract class JSONLexerBase implements JSONLexer, Closeable {
    protected static final int INT_MULTMIN_RADIX_TEN = -214748364;
    protected static final long MULTMIN_RADIX_TEN = -922337203685477580L;
    private static final ThreadLocal<char[]> SBUF_LOCAL = new ThreadLocal<>();
    protected static final int[] digits = new int[103];
    protected static final char[] typeFieldName = ("\"" + JSON.DEFAULT_TYPE_KEY + "\":\"").toCharArray();
    protected int bp;
    protected Calendar calendar = null;
    protected char ch;
    protected int eofPos;
    protected int features;
    protected boolean hasSpecial;
    protected Locale locale = JSON.defaultLocale;
    public int matchStat = 0;
    protected int nanos = 0;
    protected int np;
    protected int pos;
    protected char[] sbuf;
    protected int sp;
    protected String stringDefaultValue = null;
    protected TimeZone timeZone = JSON.defaultTimeZone;
    protected int token;

    static {
        for (int i = 48; i <= 57; i++) {
            digits[i] = i - 48;
        }
        for (int i2 = 97; i2 <= 102; i2++) {
            digits[i2] = i2 - 87;
        }
        for (int i3 = 65; i3 <= 70; i3++) {
            digits[i3] = i3 - 55;
        }
    }

    public JSONLexerBase(int i) {
        this.features = i;
        if ((i & Feature.InitStringFieldAsEmpty.mask) != 0) {
            this.stringDefaultValue = "";
        }
        char[] cArr = SBUF_LOCAL.get();
        this.sbuf = cArr;
        if (cArr == null) {
            this.sbuf = new char[512];
        }
    }

    public static boolean isWhitespace(char c) {
        return c <= ' ' && (c == ' ' || c == 10 || c == 13 || c == 9 || c == 12 || c == 8);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0059, code lost:
        r8 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x008a, code lost:
        r9 = r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String readString(char[] r17, int r18) {
        /*
            r0 = r18
            r1 = 5
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            char[] r6 = new char[r0]
            r7 = 0
            r8 = 0
            r9 = 0
        L_0x000c:
            if (r8 >= r0) goto L_0x0116
            char r10 = r17[r8]
            r11 = 92
            if (r10 == r11) goto L_0x001c
            int r11 = r9 + 1
            r6[r9] = r10
            r9 = r11
        L_0x0019:
            r12 = 5
            goto L_0x0112
        L_0x001c:
            int r10 = r8 + 1
            char r12 = r17[r10]
            r13 = 34
            if (r12 == r13) goto L_0x010c
            r13 = 39
            if (r12 == r13) goto L_0x0106
            r13 = 70
            if (r12 == r13) goto L_0x00ef
            if (r12 == r11) goto L_0x00f9
            r11 = 98
            if (r12 == r11) goto L_0x00f1
            r11 = 102(0x66, float:1.43E-43)
            if (r12 == r11) goto L_0x00ef
            r11 = 110(0x6e, float:1.54E-43)
            if (r12 == r11) goto L_0x00e7
            r11 = 114(0x72, float:1.6E-43)
            if (r12 == r11) goto L_0x00df
            r11 = 120(0x78, float:1.68E-43)
            r13 = 16
            if (r12 == r11) goto L_0x00c7
            switch(r12) {
                case 47: goto L_0x00bf;
                case 48: goto L_0x00b9;
                case 49: goto L_0x00b3;
                case 50: goto L_0x00ad;
                case 51: goto L_0x00a7;
                case 52: goto L_0x00a1;
                case 53: goto L_0x0098;
                case 54: goto L_0x0092;
                case 55: goto L_0x008c;
                default: goto L_0x0047;
            }
        L_0x0047:
            switch(r12) {
                case 116: goto L_0x0084;
                case 117: goto L_0x005b;
                case 118: goto L_0x0052;
                default: goto L_0x004a;
            }
        L_0x004a:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
            java.lang.String r1 = "unclosed.str.lit"
            r0.<init>(r1)
            throw r0
        L_0x0052:
            int r8 = r9 + 1
            r11 = 11
            r6[r9] = r11
            r9 = r8
        L_0x0059:
            r8 = r10
            goto L_0x0019
        L_0x005b:
            int r10 = r9 + 1
            java.lang.String r11 = new java.lang.String
            int r12 = r8 + 2
            char r12 = r17[r12]
            int r14 = r8 + 3
            char r14 = r17[r14]
            int r15 = r8 + 4
            char r15 = r17[r15]
            int r8 = r8 + r1
            char r16 = r17[r8]
            char[] r1 = new char[r2]
            r1[r7] = r12
            r1[r5] = r14
            r1[r4] = r15
            r1[r3] = r16
            r11.<init>(r1)
            int r1 = java.lang.Integer.parseInt(r11, r13)
            char r1 = (char) r1
            r6[r9] = r1
            r9 = r10
            goto L_0x0019
        L_0x0084:
            int r1 = r9 + 1
            r8 = 9
            r6[r9] = r8
        L_0x008a:
            r9 = r1
            goto L_0x0059
        L_0x008c:
            int r1 = r9 + 1
            r8 = 7
            r6[r9] = r8
            goto L_0x008a
        L_0x0092:
            int r1 = r9 + 1
            r8 = 6
            r6[r9] = r8
            goto L_0x008a
        L_0x0098:
            int r1 = r9 + 1
            r12 = 5
            r6[r9] = r12
        L_0x009d:
            r9 = r1
            r8 = r10
            goto L_0x0112
        L_0x00a1:
            r12 = 5
            int r1 = r9 + 1
            r6[r9] = r2
            goto L_0x009d
        L_0x00a7:
            r12 = 5
            int r1 = r9 + 1
            r6[r9] = r3
            goto L_0x009d
        L_0x00ad:
            r12 = 5
            int r1 = r9 + 1
            r6[r9] = r4
            goto L_0x009d
        L_0x00b3:
            r12 = 5
            int r1 = r9 + 1
            r6[r9] = r5
            goto L_0x009d
        L_0x00b9:
            r12 = 5
            int r1 = r9 + 1
            r6[r9] = r7
            goto L_0x009d
        L_0x00bf:
            r12 = 5
            int r1 = r9 + 1
            r8 = 47
            r6[r9] = r8
            goto L_0x009d
        L_0x00c7:
            r12 = 5
            int r1 = r9 + 1
            int[] r10 = digits
            int r11 = r8 + 2
            char r11 = r17[r11]
            r11 = r10[r11]
            int r11 = r11 * 16
            int r8 = r8 + r3
            char r13 = r17[r8]
            r10 = r10[r13]
            int r11 = r11 + r10
            char r10 = (char) r11
            r6[r9] = r10
            r9 = r1
            goto L_0x0112
        L_0x00df:
            r12 = 5
            int r1 = r9 + 1
            r8 = 13
            r6[r9] = r8
            goto L_0x009d
        L_0x00e7:
            r12 = 5
            int r1 = r9 + 1
            r8 = 10
            r6[r9] = r8
            goto L_0x009d
        L_0x00ef:
            r12 = 5
            goto L_0x00ff
        L_0x00f1:
            r12 = 5
            int r1 = r9 + 1
            r8 = 8
            r6[r9] = r8
            goto L_0x009d
        L_0x00f9:
            r12 = 5
            int r1 = r9 + 1
            r6[r9] = r11
            goto L_0x009d
        L_0x00ff:
            int r1 = r9 + 1
            r8 = 12
            r6[r9] = r8
            goto L_0x009d
        L_0x0106:
            r12 = 5
            int r1 = r9 + 1
            r6[r9] = r13
            goto L_0x009d
        L_0x010c:
            r12 = 5
            int r1 = r9 + 1
            r6[r9] = r13
            goto L_0x009d
        L_0x0112:
            int r8 = r8 + r5
            r1 = 5
            goto L_0x000c
        L_0x0116:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r6, r7, r9)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.readString(char[], int):java.lang.String");
    }

    private void scanStringSingleQuote() {
        char next;
        char next2;
        boolean z;
        boolean z2;
        this.np = this.bp;
        this.hasSpecial = false;
        while (true) {
            char next3 = next();
            if (next3 == '\'') {
                this.token = 4;
                next();
                return;
            } else if (next3 == 26) {
                if (!isEOF()) {
                    putChar(JSONLexer.EOI);
                } else {
                    throw new JSONException("unclosed single-quote string");
                }
            } else if (next3 == '\\') {
                if (!this.hasSpecial) {
                    this.hasSpecial = true;
                    int i = this.sp;
                    char[] cArr = this.sbuf;
                    if (i > cArr.length) {
                        char[] cArr2 = new char[(i * 2)];
                        System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
                        this.sbuf = cArr2;
                    }
                    copyTo(this.np + 1, this.sp, this.sbuf);
                }
                char next4 = next();
                if (next4 == '\"') {
                    putChar('\"');
                } else if (next4 != '\'') {
                    if (next4 != 'F') {
                        if (next4 == '\\') {
                            putChar('\\');
                        } else if (next4 == 'b') {
                            putChar(8);
                        } else if (next4 != 'f') {
                            if (next4 == 'n') {
                                putChar(10);
                            } else if (next4 == 'r') {
                                putChar(13);
                            } else if (next4 != 'x') {
                                switch (next4) {
                                    case '/':
                                        putChar(IOUtils.DIR_SEPARATOR_UNIX);
                                        break;
                                    case '0':
                                        putChar(0);
                                        break;
                                    case '1':
                                        putChar(1);
                                        break;
                                    case '2':
                                        putChar(2);
                                        break;
                                    case '3':
                                        putChar(3);
                                        break;
                                    case '4':
                                        putChar(4);
                                        break;
                                    case '5':
                                        putChar(5);
                                        break;
                                    case '6':
                                        putChar(6);
                                        break;
                                    case '7':
                                        putChar(7);
                                        break;
                                    default:
                                        switch (next4) {
                                            case 't':
                                                putChar(9);
                                                break;
                                            case 'u':
                                                putChar((char) Integer.parseInt(new String(new char[]{next(), next(), next(), next()}), 16));
                                                break;
                                            case 'v':
                                                putChar(11);
                                                break;
                                            default:
                                                this.ch = next4;
                                                throw new JSONException("unclosed single-quote string");
                                        }
                                }
                            } else {
                                next = next();
                                next2 = next();
                                if ((next < '0' || next > '9') && ((next < 'a' || next > 'f') && (next < 'A' || next > 'F'))) {
                                    z = false;
                                } else {
                                    z = true;
                                }
                                if ((next2 < '0' || next2 > '9') && ((next2 < 'a' || next2 > 'f') && (next2 < 'A' || next2 > 'F'))) {
                                    z2 = false;
                                } else {
                                    z2 = true;
                                }
                                if (!z || !z2) {
                                } else {
                                    int[] iArr = digits;
                                    putChar((char) ((iArr[next] * 16) + iArr[next2]));
                                }
                            }
                        }
                    }
                    putChar(12);
                } else {
                    putChar('\'');
                }
            } else if (!this.hasSpecial) {
                this.sp++;
            } else {
                int i2 = this.sp;
                char[] cArr3 = this.sbuf;
                if (i2 == cArr3.length) {
                    putChar(next3);
                } else {
                    this.sp = i2 + 1;
                    cArr3[i2] = next3;
                }
            }
        }
        throw new JSONException("invalid escape character \\x" + next + next2);
    }

    public abstract String addSymbol(int i, int i2, int i3, SymbolTable symbolTable);

    public abstract void arrayCopy(int i, char[] cArr, int i2, int i3);

    public abstract byte[] bytesValue();

    public abstract boolean charArrayCompare(char[] cArr);

    public abstract char charAt(int i);

    public void close() {
        char[] cArr = this.sbuf;
        if (cArr.length <= 8192) {
            SBUF_LOCAL.set(cArr);
        }
        this.sbuf = null;
    }

    public void config(Feature feature, boolean z) {
        int config = Feature.config(this.features, feature, z);
        this.features = config;
        if ((config & Feature.InitStringFieldAsEmpty.mask) != 0) {
            this.stringDefaultValue = "";
        }
    }

    public abstract void copyTo(int i, int i2, char[] cArr);

    public final Number decimalValue(boolean z) {
        char charAt = charAt((this.np + this.sp) - 1);
        if (charAt == 'F') {
            try {
                return Float.valueOf(Float.parseFloat(numberString()));
            } catch (NumberFormatException e) {
                throw new JSONException(e.getMessage() + ", " + info());
            }
        } else if (charAt == 'D') {
            return Double.valueOf(Double.parseDouble(numberString()));
        } else {
            if (z) {
                return decimalValue();
            }
            return Double.valueOf(doubleValue());
        }
    }

    public abstract BigDecimal decimalValue();

    public double doubleValue() {
        return Double.parseDouble(numberString());
    }

    public float floatValue() {
        char charAt;
        String numberString = numberString();
        float parseFloat = Float.parseFloat(numberString);
        if ((parseFloat != 0.0f && parseFloat != Float.POSITIVE_INFINITY) || (charAt = numberString.charAt(0)) <= '0' || charAt > '9') {
            return parseFloat;
        }
        throw new JSONException("float overflow : " + numberString);
    }

    public Calendar getCalendar() {
        return this.calendar;
    }

    public final char getCurrent() {
        return this.ch;
    }

    public int getFeatures() {
        return this.features;
    }

    public Locale getLocale() {
        return this.locale;
    }

    public TimeZone getTimeZone() {
        return this.timeZone;
    }

    public abstract int indexOf(char c, int i);

    public String info() {
        return "";
    }

    public final int intValue() {
        boolean z;
        int i;
        int i2 = 0;
        if (this.np == -1) {
            this.np = 0;
        }
        int i3 = this.np;
        int i4 = this.sp + i3;
        if (charAt(i3) == '-') {
            i3++;
            i = Integer.MIN_VALUE;
            z = true;
        } else {
            i = C.RATE_UNSET_INT;
            z = false;
        }
        if (i3 < i4) {
            i2 = -(charAt(i3) - '0');
            i3++;
        }
        while (true) {
            if (i3 >= i4) {
                break;
            }
            int i5 = i3 + 1;
            char charAt = charAt(i3);
            if (charAt == 'L' || charAt == 'S' || charAt == 'B') {
                i3 = i5;
            } else {
                int i6 = charAt - '0';
                if (((long) i2) >= -214748364) {
                    int i7 = i2 * 10;
                    if (i7 >= i + i6) {
                        i2 = i7 - i6;
                        i3 = i5;
                    } else {
                        throw new NumberFormatException(numberString());
                    }
                } else {
                    throw new NumberFormatException(numberString());
                }
            }
        }
        if (!z) {
            return -i2;
        }
        if (i3 > this.np + 1) {
            return i2;
        }
        throw new NumberFormatException(numberString());
    }

    public final Number integerValue() throws NumberFormatException {
        char c;
        long j;
        long j2;
        boolean z = false;
        if (this.np == -1) {
            this.np = 0;
        }
        int i = this.np;
        int i2 = this.sp + i;
        char charAt = charAt(i2 - 1);
        if (charAt == 'B') {
            i2--;
            c = 'B';
        } else if (charAt == 'L') {
            i2--;
            c = 'L';
        } else if (charAt != 'S') {
            c = TokenParser.SP;
        } else {
            i2--;
            c = 'S';
        }
        if (charAt(this.np) == '-') {
            i++;
            j = Long.MIN_VALUE;
            z = true;
        } else {
            j = C.TIME_UNSET;
        }
        if (i < i2) {
            j2 = (long) (-(charAt(i) - '0'));
            i++;
        } else {
            j2 = 0;
        }
        while (i < i2) {
            int i3 = i + 1;
            int charAt2 = charAt(i) - '0';
            if (j2 < -922337203685477580L) {
                return new BigInteger(numberString(), 10);
            }
            long j3 = j2 * 10;
            long j4 = (long) charAt2;
            if (j3 < j + j4) {
                return new BigInteger(numberString(), 10);
            }
            j2 = j3 - j4;
            i = i3;
        }
        if (!z) {
            long j5 = -j2;
            if (j5 > 2147483647L || c == 'L') {
                return Long.valueOf(j5);
            }
            if (c == 'S') {
                return Short.valueOf((short) ((int) j5));
            }
            if (c == 'B') {
                return Byte.valueOf((byte) ((int) j5));
            }
            return Integer.valueOf((int) j5);
        } else if (i <= this.np + 1) {
            throw new JSONException("illegal number format : " + numberString());
        } else if (j2 < O0Xx.f30774xXxxox0I || c == 'L') {
            return Long.valueOf(j2);
        } else {
            if (c == 'S') {
                return Short.valueOf((short) ((int) j2));
            }
            if (c == 'B') {
                return Byte.valueOf((byte) ((int) j2));
            }
            return Integer.valueOf((int) j2);
        }
    }

    public boolean isBlankInput() {
        int i = 0;
        while (true) {
            char charAt = charAt(i);
            if (charAt == 26) {
                this.token = 20;
                return true;
            } else if (!isWhitespace(charAt)) {
                return false;
            } else {
                i++;
            }
        }
    }

    public abstract boolean isEOF();

    public final boolean isEnabled(Feature feature) {
        return isEnabled(feature.mask);
    }

    public final boolean isRef() {
        if (this.sp == 4 && charAt(this.np + 1) == '$' && charAt(this.np + 2) == 'r' && charAt(this.np + 3) == 'e' && charAt(this.np + 4) == 'f') {
            return true;
        }
        return false;
    }

    public void lexError(String str, Object... objArr) {
        this.token = 1;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0086  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long longValue() throws java.lang.NumberFormatException {
        /*
            r13 = this;
            int r0 = r13.np
            r1 = -1
            r2 = 0
            if (r0 != r1) goto L_0x0008
            r13.np = r2
        L_0x0008:
            int r0 = r13.np
            int r1 = r13.sp
            int r1 = r1 + r0
            char r3 = r13.charAt(r0)
            r4 = 45
            r5 = 1
            if (r3 != r4) goto L_0x001d
            int r0 = r0 + 1
            r2 = -9223372036854775808
            r3 = r2
            r2 = 1
            goto L_0x0022
        L_0x001d:
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L_0x0022:
            if (r0 >= r1) goto L_0x0030
            int r6 = r0 + 1
            char r0 = r13.charAt(r0)
            int r0 = r0 + -48
            int r0 = -r0
            long r7 = (long) r0
        L_0x002e:
            r0 = r6
            goto L_0x0032
        L_0x0030:
            r7 = 0
        L_0x0032:
            if (r0 >= r1) goto L_0x0074
            int r6 = r0 + 1
            char r0 = r13.charAt(r0)
            r9 = 76
            if (r0 == r9) goto L_0x0073
            r9 = 83
            if (r0 == r9) goto L_0x0073
            r9 = 66
            if (r0 != r9) goto L_0x0047
            goto L_0x0073
        L_0x0047:
            int r0 = r0 + -48
            r9 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            int r11 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r11 < 0) goto L_0x0069
            r9 = 10
            long r7 = r7 * r9
            long r9 = (long) r0
            long r11 = r3 + r9
            int r0 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r0 < 0) goto L_0x005f
            long r7 = r7 - r9
            goto L_0x002e
        L_0x005f:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r1 = r13.numberString()
            r0.<init>(r1)
            throw r0
        L_0x0069:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r1 = r13.numberString()
            r0.<init>(r1)
            throw r0
        L_0x0073:
            r0 = r6
        L_0x0074:
            if (r2 == 0) goto L_0x0086
            int r1 = r13.np
            int r1 = r1 + r5
            if (r0 <= r1) goto L_0x007c
            return r7
        L_0x007c:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r1 = r13.numberString()
            r0.<init>(r1)
            throw r0
        L_0x0086:
            long r0 = -r7
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.longValue():long");
    }

    public final boolean matchField(char[] cArr) {
        while (!charArrayCompare(cArr)) {
            if (!isWhitespace(this.ch)) {
                return false;
            }
            next();
        }
        int length = this.bp + cArr.length;
        this.bp = length;
        char charAt = charAt(length);
        this.ch = charAt;
        if (charAt == '{') {
            next();
            this.token = 12;
        } else if (charAt == '[') {
            next();
            this.token = 14;
        } else if (charAt == 'S' && charAt(this.bp + 1) == 'e' && charAt(this.bp + 2) == 't' && charAt(this.bp + 3) == '[') {
            int i = this.bp + 3;
            this.bp = i;
            this.ch = charAt(i);
            this.token = 21;
        } else {
            nextToken();
        }
        return true;
    }

    public boolean matchField2(char[] cArr) {
        throw new UnsupportedOperationException();
    }

    public final int matchStat() {
        return this.matchStat;
    }

    public Collection<String> newCollectionByType(Class<?> cls) {
        if (cls.isAssignableFrom(HashSet.class)) {
            return new HashSet();
        }
        if (cls.isAssignableFrom(ArrayList.class)) {
            return new ArrayList();
        }
        if (cls.isAssignableFrom(LinkedList.class)) {
            return new LinkedList();
        }
        try {
            return (Collection) cls.newInstance();
        } catch (Exception e) {
            throw new JSONException(e.getMessage(), e);
        }
    }

    public abstract char next();

    public final void nextIdent() {
        while (isWhitespace(this.ch)) {
            next();
        }
        char c = this.ch;
        if (c == '_' || c == '$' || Character.isLetter(c)) {
            scanIdent();
        } else {
            nextToken();
        }
    }

    public final void nextToken() {
        this.sp = 0;
        while (true) {
            this.pos = this.bp;
            char c = this.ch;
            if (c == '/') {
                skipComment();
            } else if (c == '\"') {
                scanString();
                return;
            } else if (c == ',') {
                next();
                this.token = 16;
                return;
            } else if (c >= '0' && c <= '9') {
                scanNumber();
                return;
            } else if (c == '-') {
                scanNumber();
                return;
            } else {
                switch (c) {
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 13:
                    case ' ':
                        next();
                        break;
                    case '\'':
                        if (isEnabled(Feature.AllowSingleQuotes)) {
                            scanStringSingleQuote();
                            return;
                        }
                        throw new JSONException("Feature.AllowSingleQuotes is false");
                    case '(':
                        next();
                        this.token = 10;
                        return;
                    case ')':
                        next();
                        this.token = 11;
                        return;
                    case '+':
                        next();
                        scanNumber();
                        return;
                    case '.':
                        next();
                        this.token = 25;
                        return;
                    case ':':
                        next();
                        this.token = 17;
                        return;
                    case ';':
                        next();
                        this.token = 24;
                        return;
                    case 'N':
                    case 'S':
                    case 'T':
                    case 'u':
                        scanIdent();
                        return;
                    case '[':
                        next();
                        this.token = 14;
                        return;
                    case ']':
                        next();
                        this.token = 15;
                        return;
                    case 'f':
                        scanFalse();
                        return;
                    case 'n':
                        scanNullOrNew();
                        return;
                    case 't':
                        scanTrue();
                        return;
                    case 'x':
                        scanHex();
                        return;
                    case '{':
                        next();
                        this.token = 12;
                        return;
                    case '}':
                        next();
                        this.token = 13;
                        return;
                    default:
                        if (!isEOF()) {
                            char c2 = this.ch;
                            if (c2 <= 31 || c2 == 127) {
                                next();
                                break;
                            } else {
                                lexError("illegal.char", String.valueOf(c2));
                                next();
                                return;
                            }
                        } else if (this.token != 20) {
                            this.token = 20;
                            int i = this.bp;
                            this.pos = i;
                            this.eofPos = i;
                            return;
                        } else {
                            throw new JSONException("EOF error");
                        }
                }
            }
        }
    }

    public final void nextTokenWithChar(char c) {
        this.sp = 0;
        while (true) {
            char c2 = this.ch;
            if (c2 == c) {
                next();
                nextToken();
                return;
            } else if (c2 == ' ' || c2 == 10 || c2 == 13 || c2 == 9 || c2 == 12 || c2 == 8) {
                next();
            } else {
                throw new JSONException("not match " + c + " - " + this.ch + ", info : " + info());
            }
        }
    }

    public final void nextTokenWithColon() {
        nextTokenWithChar(':');
    }

    public abstract String numberString();

    public final int pos() {
        return this.pos;
    }

    public final void putChar(char c) {
        int i = this.sp;
        char[] cArr = this.sbuf;
        if (i >= cArr.length) {
            int length = cArr.length * 2;
            if (length < i) {
                length = i + 1;
            }
            char[] cArr2 = new char[length];
            System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
            this.sbuf = cArr2;
        }
        char[] cArr3 = this.sbuf;
        int i2 = this.sp;
        this.sp = i2 + 1;
        cArr3[i2] = c;
    }

    public final void resetStringPosition() {
        this.sp = 0;
    }

    public boolean scanBoolean(char c) {
        boolean z = false;
        this.matchStat = 0;
        char charAt = charAt(this.bp);
        int i = 5;
        if (charAt == 't') {
            if (charAt(this.bp + 1) == 'r' && charAt(this.bp + 2) == 'u' && charAt(this.bp + 3) == 'e') {
                charAt = charAt(this.bp + 4);
                z = true;
            } else {
                this.matchStat = -1;
                return false;
            }
        } else if (charAt != 'f') {
            if (charAt == '1') {
                charAt = charAt(this.bp + 1);
                z = true;
            } else if (charAt == '0') {
                charAt = charAt(this.bp + 1);
            } else {
                i = 1;
            }
            i = 2;
        } else if (charAt(this.bp + 1) == 'a' && charAt(this.bp + 2) == 'l' && charAt(this.bp + 3) == 's' && charAt(this.bp + 4) == 'e') {
            charAt = charAt(this.bp + 5);
            i = 6;
        } else {
            this.matchStat = -1;
            return false;
        }
        while (charAt != c) {
            if (isWhitespace(charAt)) {
                charAt = charAt(this.bp + i);
                i++;
            } else {
                this.matchStat = -1;
                return z;
            }
        }
        int i2 = this.bp + i;
        this.bp = i2;
        this.ch = charAt(i2);
        this.matchStat = 3;
        return z;
    }

    public Date scanDate(char c) {
        char c2;
        int i;
        Date date;
        long j;
        int i2;
        char charAt;
        boolean z = false;
        this.matchStat = 0;
        char charAt2 = charAt(this.bp);
        int i3 = 1;
        if (charAt2 == '\"') {
            int indexOf = indexOf('\"', this.bp + 1);
            if (indexOf != -1) {
                int i4 = this.bp + 1;
                String subString = subString(i4, indexOf - i4);
                if (subString.indexOf(92) != -1) {
                    while (true) {
                        int i5 = indexOf - 1;
                        int i6 = 0;
                        while (i5 >= 0 && charAt(i5) == '\\') {
                            i6++;
                            i5--;
                        }
                        if (i6 % 2 == 0) {
                            break;
                        }
                        indexOf = indexOf('\"', indexOf + 1);
                    }
                    int i7 = this.bp;
                    int i8 = indexOf - (i7 + 1);
                    subString = readString(sub_chars(i7 + 1, i8), i8);
                }
                int i9 = this.bp;
                int i10 = indexOf - (i9 + 1);
                int i11 = i10 + 2;
                i = i10 + 3;
                c2 = charAt(i9 + i11);
                JSONScanner jSONScanner = new JSONScanner(subString);
                try {
                    if (jSONScanner.scanISO8601DateIfMatch(false)) {
                        date = jSONScanner.getCalendar().getTime();
                    } else {
                        this.matchStat = -1;
                        jSONScanner.close();
                        return null;
                    }
                } finally {
                    jSONScanner.close();
                }
            } else {
                throw new JSONException("unclosed str");
            }
        } else {
            char c3 = '9';
            if (charAt2 == '-' || (charAt2 >= '0' && charAt2 <= '9')) {
                if (charAt2 == '-') {
                    charAt2 = charAt(this.bp + 1);
                    z = true;
                    i3 = 2;
                }
                if (charAt2 < '0' || charAt2 > '9') {
                    j = 0;
                    int i12 = i3;
                    c2 = charAt2;
                    i = i12;
                } else {
                    j = (long) (charAt2 - '0');
                    while (true) {
                        i2 = i3 + 1;
                        charAt = charAt(this.bp + i3);
                        if (charAt < '0' || charAt > c3) {
                            c2 = charAt;
                            i = i2;
                        } else {
                            j = (j * 10) + ((long) (charAt - '0'));
                            i3 = i2;
                            c3 = '9';
                        }
                    }
                    c2 = charAt;
                    i = i2;
                }
                if (j < 0) {
                    this.matchStat = -1;
                    return null;
                }
                if (z) {
                    j = -j;
                }
                date = new Date(j);
            } else if (charAt2 == 'n' && charAt(this.bp + 1) == 'u' && charAt(this.bp + 2) == 'l' && charAt(this.bp + 3) == 'l') {
                i = 5;
                this.matchStat = 5;
                c2 = charAt(this.bp + 4);
                date = null;
            } else {
                this.matchStat = -1;
                return null;
            }
        }
        if (c2 == ',') {
            int i13 = this.bp + i;
            this.bp = i13;
            this.ch = charAt(i13);
            this.matchStat = 3;
            this.token = 16;
            return date;
        } else if (c2 == ']') {
            int i14 = i + 1;
            char charAt3 = charAt(this.bp + i);
            if (charAt3 == ',') {
                this.token = 16;
                int i15 = this.bp + i14;
                this.bp = i15;
                this.ch = charAt(i15);
            } else if (charAt3 == ']') {
                this.token = 15;
                int i16 = this.bp + i14;
                this.bp = i16;
                this.ch = charAt(i16);
            } else if (charAt3 == '}') {
                this.token = 13;
                int i17 = this.bp + i14;
                this.bp = i17;
                this.ch = charAt(i17);
            } else if (charAt3 == 26) {
                this.token = 20;
                this.bp += i;
                this.ch = JSONLexer.EOI;
            } else {
                this.matchStat = -1;
                return null;
            }
            this.matchStat = 4;
            return date;
        } else {
            this.matchStat = -1;
            return null;
        }
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public java.math.BigDecimal scanDecimal(char r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = 0
            r0.matchStat = r1
            int r2 = r0.bp
            char r2 = r0.charAt(r2)
            r3 = 1
            r4 = 34
            if (r2 != r4) goto L_0x0012
            r5 = 1
            goto L_0x0013
        L_0x0012:
            r5 = 0
        L_0x0013:
            r6 = 2
            if (r5 == 0) goto L_0x001f
            int r2 = r0.bp
            int r2 = r2 + r3
            char r2 = r0.charAt(r2)
            r7 = 2
            goto L_0x0020
        L_0x001f:
            r7 = 1
        L_0x0020:
            r8 = 45
            if (r2 != r8) goto L_0x002e
            int r2 = r0.bp
            int r9 = r7 + 1
            int r2 = r2 + r7
            char r2 = r0.charAt(r2)
            r7 = r9
        L_0x002e:
            r11 = 16
            r12 = 44
            r13 = 48
            r14 = -1
            r15 = 0
            if (r2 < r13) goto L_0x0150
            r9 = 57
            if (r2 > r9) goto L_0x0150
        L_0x003c:
            int r2 = r0.bp
            int r16 = r7 + 1
            int r2 = r2 + r7
            char r2 = r0.charAt(r2)
            if (r2 < r13) goto L_0x004c
            if (r2 > r9) goto L_0x004c
            r7 = r16
            goto L_0x003c
        L_0x004c:
            r10 = 46
            if (r2 != r10) goto L_0x0070
            int r2 = r0.bp
            int r7 = r7 + r6
            int r2 = r2 + r16
            char r2 = r0.charAt(r2)
            if (r2 < r13) goto L_0x006d
            if (r2 > r9) goto L_0x006d
        L_0x005d:
            int r2 = r0.bp
            int r16 = r7 + 1
            int r2 = r2 + r7
            char r2 = r0.charAt(r2)
            if (r2 < r13) goto L_0x0070
            if (r2 > r9) goto L_0x0070
            r7 = r16
            goto L_0x005d
        L_0x006d:
            r0.matchStat = r14
            return r15
        L_0x0070:
            r7 = 101(0x65, float:1.42E-43)
            if (r2 == r7) goto L_0x0078
            r7 = 69
            if (r2 != r7) goto L_0x00a4
        L_0x0078:
            int r2 = r0.bp
            int r7 = r16 + 1
            int r2 = r2 + r16
            char r2 = r0.charAt(r2)
            r10 = 43
            if (r2 == r10) goto L_0x008c
            if (r2 != r8) goto L_0x0089
            goto L_0x008c
        L_0x0089:
            r16 = r7
            goto L_0x0095
        L_0x008c:
            int r2 = r0.bp
            int r16 = r16 + 2
            int r2 = r2 + r7
            char r2 = r0.charAt(r2)
        L_0x0095:
            if (r2 < r13) goto L_0x00a4
            if (r2 > r9) goto L_0x00a4
            int r2 = r0.bp
            int r7 = r16 + 1
            int r2 = r2 + r16
            char r2 = r0.charAt(r2)
            goto L_0x0089
        L_0x00a4:
            if (r5 == 0) goto L_0x00bf
            if (r2 == r4) goto L_0x00ab
            r0.matchStat = r14
            return r15
        L_0x00ab:
            int r2 = r0.bp
            int r3 = r16 + 1
            int r2 = r2 + r16
            char r2 = r0.charAt(r2)
            int r4 = r0.bp
            int r5 = r4 + 1
            int r4 = r4 + r3
            int r4 = r4 - r5
            int r4 = r4 - r6
            r16 = r3
            goto L_0x00c5
        L_0x00bf:
            int r5 = r0.bp
            int r4 = r5 + r16
            int r4 = r4 - r5
            int r4 = r4 - r3
        L_0x00c5:
            r3 = 65535(0xffff, float:9.1834E-41)
            if (r4 > r3) goto L_0x0148
            char[] r3 = r0.sub_chars(r5, r4)
            java.math.BigDecimal r4 = new java.math.BigDecimal
            int r5 = r3.length
            java.math.MathContext r6 = java.math.MathContext.UNLIMITED
            r4.<init>(r3, r1, r5, r6)
            if (r2 != r12) goto L_0x00ea
            int r1 = r0.bp
            int r1 = r1 + r16
            r0.bp = r1
            char r1 = r0.charAt(r1)
            r0.ch = r1
            r1 = 3
            r0.matchStat = r1
            r0.token = r11
            return r4
        L_0x00ea:
            r1 = 93
            if (r2 != r1) goto L_0x0145
            int r2 = r0.bp
            int r3 = r16 + 1
            int r2 = r2 + r16
            char r2 = r0.charAt(r2)
            if (r2 != r12) goto L_0x0108
            r0.token = r11
            int r1 = r0.bp
            int r1 = r1 + r3
            r0.bp = r1
            char r1 = r0.charAt(r1)
            r0.ch = r1
            goto L_0x013e
        L_0x0108:
            if (r2 != r1) goto L_0x011a
            r1 = 15
            r0.token = r1
            int r1 = r0.bp
            int r1 = r1 + r3
            r0.bp = r1
            char r1 = r0.charAt(r1)
            r0.ch = r1
            goto L_0x013e
        L_0x011a:
            r1 = 125(0x7d, float:1.75E-43)
            if (r2 != r1) goto L_0x012e
            r1 = 13
            r0.token = r1
            int r1 = r0.bp
            int r1 = r1 + r3
            r0.bp = r1
            char r1 = r0.charAt(r1)
            r0.ch = r1
            goto L_0x013e
        L_0x012e:
            r1 = 26
            if (r2 != r1) goto L_0x0142
            r2 = 20
            r0.token = r2
            int r2 = r0.bp
            int r2 = r2 + r16
            r0.bp = r2
            r0.ch = r1
        L_0x013e:
            r1 = 4
            r0.matchStat = r1
            return r4
        L_0x0142:
            r0.matchStat = r14
            return r15
        L_0x0145:
            r0.matchStat = r14
            return r15
        L_0x0148:
            com.alibaba.fastjson.JSONException r1 = new com.alibaba.fastjson.JSONException
            java.lang.String r2 = "decimal overflow"
            r1.<init>(r2)
            throw r1
        L_0x0150:
            r1 = 110(0x6e, float:1.54E-43)
            if (r2 != r1) goto L_0x01ce
            int r1 = r0.bp
            int r1 = r1 + r7
            char r1 = r0.charAt(r1)
            r2 = 117(0x75, float:1.64E-43)
            if (r1 != r2) goto L_0x01ce
            int r1 = r0.bp
            int r1 = r1 + r7
            int r1 = r1 + r3
            char r1 = r0.charAt(r1)
            r2 = 108(0x6c, float:1.51E-43)
            if (r1 != r2) goto L_0x01ce
            int r1 = r0.bp
            int r1 = r1 + r7
            int r1 = r1 + r6
            char r1 = r0.charAt(r1)
            if (r1 != r2) goto L_0x01ce
            r1 = 5
            r0.matchStat = r1
            int r2 = r7 + 3
            int r3 = r0.bp
            int r6 = r7 + 4
            int r3 = r3 + r2
            char r2 = r0.charAt(r3)
            if (r5 == 0) goto L_0x0190
            if (r2 != r4) goto L_0x0190
            int r2 = r0.bp
            int r7 = r7 + r1
            int r2 = r2 + r6
            char r2 = r0.charAt(r2)
            r6 = r7
        L_0x0190:
            if (r2 != r12) goto L_0x01a2
            int r2 = r0.bp
            int r2 = r2 + r6
            r0.bp = r2
            char r2 = r0.charAt(r2)
            r0.ch = r2
            r0.matchStat = r1
            r0.token = r11
            return r15
        L_0x01a2:
            r3 = 125(0x7d, float:1.75E-43)
            if (r2 != r3) goto L_0x01b8
            int r2 = r0.bp
            int r2 = r2 + r6
            r0.bp = r2
            char r2 = r0.charAt(r2)
            r0.ch = r2
            r0.matchStat = r1
            r4 = 13
            r0.token = r4
            return r15
        L_0x01b8:
            r4 = 13
            boolean r2 = isWhitespace(r2)
            if (r2 == 0) goto L_0x01cb
            int r2 = r0.bp
            int r5 = r6 + 1
            int r2 = r2 + r6
            char r2 = r0.charAt(r2)
            r6 = r5
            goto L_0x0190
        L_0x01cb:
            r0.matchStat = r14
            return r15
        L_0x01ce:
            r0.matchStat = r14
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanDecimal(char):java.math.BigDecimal");
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public double scanDouble(char r21) {
        /*
            r20 = this;
            r0 = r20
            r1 = 0
            r0.matchStat = r1
            int r2 = r0.bp
            char r2 = r0.charAt(r2)
            r3 = 1
            r4 = 34
            if (r2 != r4) goto L_0x0012
            r5 = 1
            goto L_0x0013
        L_0x0012:
            r5 = 0
        L_0x0013:
            r6 = 2
            if (r5 == 0) goto L_0x001f
            int r2 = r0.bp
            int r2 = r2 + r3
            char r2 = r0.charAt(r2)
            r7 = 2
            goto L_0x0020
        L_0x001f:
            r7 = 1
        L_0x0020:
            r8 = 45
            if (r2 != r8) goto L_0x0026
            r9 = 1
            goto L_0x0027
        L_0x0026:
            r9 = 0
        L_0x0027:
            if (r9 == 0) goto L_0x0033
            int r2 = r0.bp
            int r10 = r7 + 1
            int r2 = r2 + r7
            char r2 = r0.charAt(r2)
            r7 = r10
        L_0x0033:
            r11 = 0
            r13 = -1
            r14 = 48
            if (r2 < r14) goto L_0x0125
            r15 = 57
            if (r2 > r15) goto L_0x0125
            int r2 = r2 - r14
            long r1 = (long) r2
        L_0x0040:
            int r10 = r0.bp
            int r17 = r7 + 1
            int r10 = r10 + r7
            char r10 = r0.charAt(r10)
            r18 = 10
            if (r10 < r14) goto L_0x005b
            if (r10 > r15) goto L_0x005b
            long r1 = r1 * r18
            int r10 = r10 + -48
            long r3 = (long) r10
            long r1 = r1 + r3
            r7 = r17
            r3 = 1
            r4 = 34
            goto L_0x0040
        L_0x005b:
            r3 = 46
            if (r10 != r3) goto L_0x008f
            int r3 = r0.bp
            int r7 = r7 + r6
            int r3 = r3 + r17
            char r3 = r0.charAt(r3)
            if (r3 < r14) goto L_0x008c
            if (r3 > r15) goto L_0x008c
            long r1 = r1 * r18
            int r3 = r3 - r14
            long r3 = (long) r3
            long r1 = r1 + r3
            r3 = r18
        L_0x0073:
            int r10 = r0.bp
            int r17 = r7 + 1
            int r10 = r10 + r7
            char r10 = r0.charAt(r10)
            if (r10 < r14) goto L_0x0091
            if (r10 > r15) goto L_0x0091
            long r1 = r1 * r18
            int r10 = r10 + -48
            long r6 = (long) r10
            long r1 = r1 + r6
            long r3 = r3 * r18
            r7 = r17
            r6 = 2
            goto L_0x0073
        L_0x008c:
            r0.matchStat = r13
            return r11
        L_0x008f:
            r3 = 1
        L_0x0091:
            r6 = 101(0x65, float:1.42E-43)
            if (r10 == r6) goto L_0x009d
            r6 = 69
            if (r10 != r6) goto L_0x009a
            goto L_0x009d
        L_0x009a:
            r16 = 0
            goto L_0x009f
        L_0x009d:
            r16 = 1
        L_0x009f:
            if (r16 == 0) goto L_0x00cf
            int r6 = r0.bp
            int r7 = r17 + 1
            int r6 = r6 + r17
            char r6 = r0.charAt(r6)
            r10 = 43
            if (r6 == r10) goto L_0x00b6
            if (r6 != r8) goto L_0x00b2
            goto L_0x00b6
        L_0x00b2:
            r10 = r6
        L_0x00b3:
            r17 = r7
            goto L_0x00c0
        L_0x00b6:
            int r6 = r0.bp
            int r17 = r17 + 2
            int r6 = r6 + r7
            char r6 = r0.charAt(r6)
            r10 = r6
        L_0x00c0:
            if (r10 < r14) goto L_0x00cf
            if (r10 > r15) goto L_0x00cf
            int r6 = r0.bp
            int r7 = r17 + 1
            int r6 = r6 + r17
            char r10 = r0.charAt(r6)
            goto L_0x00b3
        L_0x00cf:
            if (r5 == 0) goto L_0x00ed
            r5 = 34
            if (r10 == r5) goto L_0x00d8
            r0.matchStat = r13
            return r11
        L_0x00d8:
            int r5 = r0.bp
            int r6 = r17 + 1
            int r5 = r5 + r17
            char r10 = r0.charAt(r5)
            int r5 = r0.bp
            int r7 = r5 + 1
            int r5 = r5 + r6
            int r5 = r5 - r7
            r8 = 2
            int r5 = r5 - r8
            r17 = r6
            goto L_0x00f4
        L_0x00ed:
            int r7 = r0.bp
            int r5 = r7 + r17
            int r5 = r5 - r7
            r6 = 1
            int r5 = r5 - r6
        L_0x00f4:
            if (r16 != 0) goto L_0x0103
            r6 = 17
            if (r5 >= r6) goto L_0x0103
            double r1 = (double) r1
            double r3 = (double) r3
            double r1 = r1 / r3
            if (r9 == 0) goto L_0x0100
            double r1 = -r1
        L_0x0100:
            r3 = r21
            goto L_0x010c
        L_0x0103:
            java.lang.String r1 = r0.subString(r7, r5)
            double r1 = java.lang.Double.parseDouble(r1)
            goto L_0x0100
        L_0x010c:
            if (r10 != r3) goto L_0x0122
            int r3 = r0.bp
            int r3 = r3 + r17
            r0.bp = r3
            char r3 = r0.charAt(r3)
            r0.ch = r3
            r3 = 3
            r0.matchStat = r3
            r3 = 16
            r0.token = r3
            return r1
        L_0x0122:
            r0.matchStat = r13
            return r1
        L_0x0125:
            r1 = 110(0x6e, float:1.54E-43)
            if (r2 != r1) goto L_0x01ab
            int r1 = r0.bp
            int r1 = r1 + r7
            char r1 = r0.charAt(r1)
            r2 = 117(0x75, float:1.64E-43)
            if (r1 != r2) goto L_0x01ab
            int r1 = r0.bp
            int r1 = r1 + r7
            r2 = 1
            int r1 = r1 + r2
            char r1 = r0.charAt(r1)
            r2 = 108(0x6c, float:1.51E-43)
            if (r1 != r2) goto L_0x01ab
            int r1 = r0.bp
            int r1 = r1 + r7
            r3 = 2
            int r1 = r1 + r3
            char r1 = r0.charAt(r1)
            if (r1 != r2) goto L_0x01ab
            r1 = 5
            r0.matchStat = r1
            int r2 = r7 + 3
            int r3 = r0.bp
            int r4 = r7 + 4
            int r3 = r3 + r2
            char r2 = r0.charAt(r3)
            if (r5 == 0) goto L_0x0169
            r3 = 34
            if (r2 != r3) goto L_0x0169
            int r2 = r0.bp
            int r7 = r7 + r1
            int r2 = r2 + r4
            char r2 = r0.charAt(r2)
            r4 = r7
        L_0x0169:
            r3 = 44
            if (r2 != r3) goto L_0x017f
            int r2 = r0.bp
            int r2 = r2 + r4
            r0.bp = r2
            char r2 = r0.charAt(r2)
            r0.ch = r2
            r0.matchStat = r1
            r3 = 16
            r0.token = r3
            return r11
        L_0x017f:
            r3 = 16
            r5 = 93
            if (r2 != r5) goto L_0x0197
            int r2 = r0.bp
            int r2 = r2 + r4
            r0.bp = r2
            char r2 = r0.charAt(r2)
            r0.ch = r2
            r0.matchStat = r1
            r1 = 15
            r0.token = r1
            return r11
        L_0x0197:
            boolean r2 = isWhitespace(r2)
            if (r2 == 0) goto L_0x01a8
            int r2 = r0.bp
            int r5 = r4 + 1
            int r2 = r2 + r4
            char r2 = r0.charAt(r2)
            r4 = r5
            goto L_0x0169
        L_0x01a8:
            r0.matchStat = r13
            return r11
        L_0x01ab:
            r0.matchStat = r13
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanDouble(char):double");
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [java.lang.Class<?>, java.lang.Class] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Enum<?> scanEnum(java.lang.Class<?> r1, com.alibaba.fastjson.parser.SymbolTable r2, char r3) {
        /*
            r0 = this;
            java.lang.String r2 = r0.scanSymbolWithSeperator(r2, r3)
            if (r2 != 0) goto L_0x0008
            r1 = 0
            return r1
        L_0x0008:
            java.lang.Enum r1 = java.lang.Enum.valueOf(r1, r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanEnum(java.lang.Class, com.alibaba.fastjson.parser.SymbolTable, char):java.lang.Enum");
    }

    public long scanEnumSymbol(char[] cArr) {
        int i;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return 0;
        }
        int length = cArr.length;
        int i2 = length + 1;
        if (charAt(this.bp + length) != '\"') {
            this.matchStat = -1;
            return 0;
        }
        long j = TypeUtils.fnv1a_64_magic_hashcode;
        while (true) {
            int i3 = i2 + 1;
            char charAt = charAt(this.bp + i2);
            if (charAt == '\"') {
                int i4 = i2 + 2;
                char charAt2 = charAt(this.bp + i3);
                if (charAt2 == ',') {
                    int i5 = this.bp + i4;
                    this.bp = i5;
                    this.ch = charAt(i5);
                    this.matchStat = 3;
                    return j;
                } else if (charAt2 == '}') {
                    int i6 = i2 + 3;
                    char charAt3 = charAt(this.bp + i4);
                    if (charAt3 == ',') {
                        this.token = 16;
                        int i7 = this.bp + i6;
                        this.bp = i7;
                        this.ch = charAt(i7);
                    } else if (charAt3 == ']') {
                        this.token = 15;
                        int i8 = this.bp + i6;
                        this.bp = i8;
                        this.ch = charAt(i8);
                    } else if (charAt3 == '}') {
                        this.token = 13;
                        int i9 = this.bp + i6;
                        this.bp = i9;
                        this.ch = charAt(i9);
                    } else if (charAt3 == 26) {
                        this.token = 20;
                        this.bp += i2 + 2;
                        this.ch = JSONLexer.EOI;
                    } else {
                        this.matchStat = -1;
                        return 0;
                    }
                    this.matchStat = 4;
                    return j;
                } else {
                    this.matchStat = -1;
                    return 0;
                }
            } else {
                if (charAt < 'A' || charAt > 'Z') {
                    i = charAt;
                } else {
                    i = charAt + TokenParser.SP;
                }
                j = (j ^ ((long) i)) * TypeUtils.fnv1a_64_magic_prime;
                if (charAt == '\\') {
                    this.matchStat = -1;
                    return 0;
                }
                i2 = i3;
            }
        }
    }

    public final void scanFalse() {
        if (this.ch == 'f') {
            next();
            if (this.ch == 'a') {
                next();
                if (this.ch == 'l') {
                    next();
                    if (this.ch == 's') {
                        next();
                        if (this.ch == 'e') {
                            next();
                            char c = this.ch;
                            if (c == ' ' || c == ',' || c == '}' || c == ']' || c == 10 || c == 13 || c == 9 || c == 26 || c == 12 || c == 8 || c == ':' || c == '/') {
                                this.token = 7;
                                return;
                            }
                            throw new JSONException("scan false error");
                        }
                        throw new JSONException("error parse false");
                    }
                    throw new JSONException("error parse false");
                }
                throw new JSONException("error parse false");
            }
            throw new JSONException("error parse false");
        }
        throw new JSONException("error parse false");
    }

    public BigInteger scanFieldBigInteger(char[] cArr) {
        boolean z;
        boolean z2;
        int i;
        char charAt;
        boolean z3;
        int i2;
        int i3;
        BigInteger bigInteger;
        char[] cArr2 = cArr;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return null;
        }
        int length = cArr2.length;
        int i4 = length + 1;
        char charAt2 = charAt(this.bp + length);
        if (charAt2 == '\"') {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            charAt2 = charAt(this.bp + i4);
            i4 = length + 2;
        }
        if (charAt2 == '-') {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            charAt2 = charAt(this.bp + i4);
            i4++;
        }
        if (charAt2 >= '0') {
            char c = '9';
            if (charAt2 <= '9') {
                long j = (long) (charAt2 - '0');
                while (true) {
                    i = i4 + 1;
                    charAt = charAt(this.bp + i4);
                    if (charAt < '0' || charAt > c) {
                        z3 = false;
                    } else {
                        long j2 = (10 * j) + ((long) (charAt - '0'));
                        if (j2 < j) {
                            z3 = true;
                            break;
                        }
                        j = j2;
                        i4 = i;
                        c = '9';
                    }
                }
                z3 = false;
                if (!z) {
                    int i5 = this.bp;
                    i3 = cArr2.length + i5;
                    i2 = ((i5 + i) - i3) - 1;
                } else if (charAt != '\"') {
                    this.matchStat = -1;
                    return null;
                } else {
                    int i6 = i4 + 2;
                    charAt = charAt(this.bp + i);
                    int i7 = this.bp;
                    i3 = cArr2.length + i7 + 1;
                    i2 = ((i7 + i6) - i3) - 2;
                    i = i6;
                }
                if (!z3 && (i2 < 20 || (z2 && i2 < 21))) {
                    if (z2) {
                        j = -j;
                    }
                    bigInteger = BigInteger.valueOf(j);
                } else if (i2 <= 65535) {
                    bigInteger = new BigInteger(subString(i3, i2), 10);
                } else {
                    throw new JSONException("scanInteger overflow");
                }
                if (charAt == ',') {
                    int i8 = this.bp + i;
                    this.bp = i8;
                    this.ch = charAt(i8);
                    this.matchStat = 3;
                    this.token = 16;
                    return bigInteger;
                } else if (charAt == '}') {
                    int i9 = i + 1;
                    char charAt3 = charAt(this.bp + i);
                    if (charAt3 == ',') {
                        this.token = 16;
                        int i10 = this.bp + i9;
                        this.bp = i10;
                        this.ch = charAt(i10);
                    } else if (charAt3 == ']') {
                        this.token = 15;
                        int i11 = this.bp + i9;
                        this.bp = i11;
                        this.ch = charAt(i11);
                    } else if (charAt3 == '}') {
                        this.token = 13;
                        int i12 = this.bp + i9;
                        this.bp = i12;
                        this.ch = charAt(i12);
                    } else if (charAt3 == 26) {
                        this.token = 20;
                        this.bp += i;
                        this.ch = JSONLexer.EOI;
                    } else {
                        this.matchStat = -1;
                        return null;
                    }
                    this.matchStat = 4;
                    return bigInteger;
                } else {
                    this.matchStat = -1;
                    return null;
                }
            }
        }
        if (charAt2 == 'n' && charAt(this.bp + i4) == 'u' && charAt(this.bp + i4 + 1) == 'l' && charAt(this.bp + i4 + 2) == 'l') {
            this.matchStat = 5;
            int i13 = i4 + 4;
            char charAt4 = charAt(this.bp + i4 + 3);
            if (z && charAt4 == '\"') {
                charAt4 = charAt(this.bp + i13);
                i13 = i4 + 5;
            }
            while (charAt4 != ',') {
                if (charAt4 == '}') {
                    int i14 = this.bp + i13;
                    this.bp = i14;
                    this.ch = charAt(i14);
                    this.matchStat = 5;
                    this.token = 13;
                    return null;
                } else if (isWhitespace(charAt4)) {
                    charAt4 = charAt(this.bp + i13);
                    i13++;
                } else {
                    this.matchStat = -1;
                    return null;
                }
            }
            int i15 = this.bp + i13;
            this.bp = i15;
            this.ch = charAt(i15);
            this.matchStat = 5;
            this.token = 16;
            return null;
        }
        this.matchStat = -1;
        return null;
    }

    public boolean scanFieldBoolean(char[] cArr) {
        int i;
        boolean z;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return false;
        }
        int length = cArr.length;
        int i2 = length + 1;
        char charAt = charAt(this.bp + length);
        if (charAt == 't') {
            int i3 = length + 2;
            if (charAt(this.bp + i2) != 'r') {
                this.matchStat = -1;
                return false;
            }
            int i4 = length + 3;
            if (charAt(this.bp + i3) != 'u') {
                this.matchStat = -1;
                return false;
            }
            i = length + 4;
            if (charAt(this.bp + i4) != 'e') {
                this.matchStat = -1;
                return false;
            }
            z = true;
        } else if (charAt == 'f') {
            int i5 = length + 2;
            if (charAt(this.bp + i2) != 'a') {
                this.matchStat = -1;
                return false;
            }
            int i6 = length + 3;
            if (charAt(this.bp + i5) != 'l') {
                this.matchStat = -1;
                return false;
            }
            int i7 = length + 4;
            if (charAt(this.bp + i6) != 's') {
                this.matchStat = -1;
                return false;
            }
            i = length + 5;
            if (charAt(this.bp + i7) != 'e') {
                this.matchStat = -1;
                return false;
            }
            z = false;
        } else {
            this.matchStat = -1;
            return false;
        }
        int i8 = i + 1;
        char charAt2 = charAt(this.bp + i);
        if (charAt2 == ',') {
            int i9 = this.bp + i8;
            this.bp = i9;
            this.ch = charAt(i9);
            this.matchStat = 3;
            this.token = 16;
            return z;
        } else if (charAt2 == '}') {
            int i10 = i + 2;
            char charAt3 = charAt(this.bp + i8);
            if (charAt3 == ',') {
                this.token = 16;
                int i11 = this.bp + i10;
                this.bp = i11;
                this.ch = charAt(i11);
            } else if (charAt3 == ']') {
                this.token = 15;
                int i12 = this.bp + i10;
                this.bp = i12;
                this.ch = charAt(i12);
            } else if (charAt3 == '}') {
                this.token = 13;
                int i13 = this.bp + i10;
                this.bp = i13;
                this.ch = charAt(i13);
            } else if (charAt3 == 26) {
                this.token = 20;
                this.bp += i + 1;
                this.ch = JSONLexer.EOI;
            } else {
                this.matchStat = -1;
                return false;
            }
            this.matchStat = 4;
            return z;
        } else {
            this.matchStat = -1;
            return false;
        }
    }

    public Date scanFieldDate(char[] cArr) {
        int i;
        char c;
        Date date;
        long j;
        int i2;
        char charAt;
        boolean z = false;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return null;
        }
        int length = cArr.length;
        int i3 = length + 1;
        char charAt2 = charAt(this.bp + length);
        if (charAt2 == '\"') {
            int indexOf = indexOf('\"', this.bp + cArr.length + 1);
            if (indexOf != -1) {
                int length2 = this.bp + cArr.length + 1;
                String subString = subString(length2, indexOf - length2);
                if (subString.indexOf(92) != -1) {
                    while (true) {
                        int i4 = indexOf - 1;
                        int i5 = 0;
                        while (i4 >= 0 && charAt(i4) == '\\') {
                            i5++;
                            i4--;
                        }
                        if (i5 % 2 == 0) {
                            break;
                        }
                        indexOf = indexOf('\"', indexOf + 1);
                    }
                    int i6 = this.bp;
                    int length3 = indexOf - ((cArr.length + i6) + 1);
                    subString = readString(sub_chars(i6 + cArr.length + 1, length3), length3);
                }
                int i7 = this.bp;
                int length4 = i3 + (indexOf - ((cArr.length + i7) + 1)) + 1;
                i = length4 + 1;
                c = charAt(i7 + length4);
                JSONScanner jSONScanner = new JSONScanner(subString);
                try {
                    if (jSONScanner.scanISO8601DateIfMatch(false)) {
                        date = jSONScanner.getCalendar().getTime();
                    } else {
                        this.matchStat = -1;
                        jSONScanner.close();
                        return null;
                    }
                } finally {
                    jSONScanner.close();
                }
            } else {
                throw new JSONException("unclosed str");
            }
        } else if (charAt2 == '-' || (charAt2 >= '0' && charAt2 <= '9')) {
            if (charAt2 == '-') {
                charAt2 = charAt(this.bp + i3);
                i3 = length + 2;
                z = true;
            }
            if (charAt2 < '0' || charAt2 > '9') {
                c = charAt2;
                i = i3;
                j = 0;
            } else {
                j = (long) (charAt2 - '0');
                while (true) {
                    i2 = i3 + 1;
                    charAt = charAt(this.bp + i3);
                    if (charAt < '0' || charAt > '9') {
                        int i8 = i2;
                        c = charAt;
                        i = i8;
                    } else {
                        j = (j * 10) + ((long) (charAt - '0'));
                        i3 = i2;
                    }
                }
                int i82 = i2;
                c = charAt;
                i = i82;
            }
            if (j < 0) {
                this.matchStat = -1;
                return null;
            }
            if (z) {
                j = -j;
            }
            date = new Date(j);
        } else {
            this.matchStat = -1;
            return null;
        }
        if (c == ',') {
            int i9 = this.bp + i;
            this.bp = i9;
            this.ch = charAt(i9);
            this.matchStat = 3;
            return date;
        } else if (c == '}') {
            int i10 = i + 1;
            char charAt3 = charAt(this.bp + i);
            if (charAt3 == ',') {
                this.token = 16;
                int i11 = this.bp + i10;
                this.bp = i11;
                this.ch = charAt(i11);
            } else if (charAt3 == ']') {
                this.token = 15;
                int i12 = this.bp + i10;
                this.bp = i12;
                this.ch = charAt(i12);
            } else if (charAt3 == '}') {
                this.token = 13;
                int i13 = this.bp + i10;
                this.bp = i13;
                this.ch = charAt(i13);
            } else if (charAt3 == 26) {
                this.token = 20;
                this.bp += i;
                this.ch = JSONLexer.EOI;
            } else {
                this.matchStat = -1;
                return null;
            }
            this.matchStat = 4;
            return date;
        } else {
            this.matchStat = -1;
            return null;
        }
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public java.math.BigDecimal scanFieldDecimal(char[] r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = 0
            r0.matchStat = r2
            boolean r3 = r17.charArrayCompare(r18)
            r4 = 0
            if (r3 != 0) goto L_0x0012
            r1 = -2
            r0.matchStat = r1
            return r4
        L_0x0012:
            int r3 = r1.length
            int r5 = r0.bp
            int r6 = r3 + 1
            int r5 = r5 + r3
            char r5 = r0.charAt(r5)
            r7 = 34
            r8 = 1
            if (r5 != r7) goto L_0x0023
            r9 = 1
            goto L_0x0024
        L_0x0023:
            r9 = 0
        L_0x0024:
            if (r9 == 0) goto L_0x0030
            int r5 = r0.bp
            int r3 = r3 + 2
            int r5 = r5 + r6
            char r5 = r0.charAt(r5)
            r6 = r3
        L_0x0030:
            r3 = 45
            if (r5 != r3) goto L_0x003e
            int r5 = r0.bp
            int r10 = r6 + 1
            int r5 = r5 + r6
            char r5 = r0.charAt(r5)
            r6 = r10
        L_0x003e:
            r12 = 16
            r13 = 44
            r14 = 48
            r15 = -1
            if (r5 < r14) goto L_0x016b
            r10 = 57
            if (r5 > r10) goto L_0x016b
        L_0x004b:
            int r5 = r0.bp
            int r16 = r6 + 1
            int r5 = r5 + r6
            char r5 = r0.charAt(r5)
            if (r5 < r14) goto L_0x005b
            if (r5 > r10) goto L_0x005b
            r6 = r16
            goto L_0x004b
        L_0x005b:
            r11 = 46
            if (r5 != r11) goto L_0x0080
            int r5 = r0.bp
            int r6 = r6 + 2
            int r5 = r5 + r16
            char r5 = r0.charAt(r5)
            if (r5 < r14) goto L_0x007d
            if (r5 > r10) goto L_0x007d
        L_0x006d:
            int r5 = r0.bp
            int r16 = r6 + 1
            int r5 = r5 + r6
            char r5 = r0.charAt(r5)
            if (r5 < r14) goto L_0x0080
            if (r5 > r10) goto L_0x0080
            r6 = r16
            goto L_0x006d
        L_0x007d:
            r0.matchStat = r15
            return r4
        L_0x0080:
            r6 = 101(0x65, float:1.42E-43)
            if (r5 == r6) goto L_0x0088
            r6 = 69
            if (r5 != r6) goto L_0x00b7
        L_0x0088:
            int r5 = r0.bp
            int r6 = r16 + 1
            int r5 = r5 + r16
            char r5 = r0.charAt(r5)
            r11 = 43
            if (r5 == r11) goto L_0x009c
            if (r5 != r3) goto L_0x0099
            goto L_0x009c
        L_0x0099:
            r16 = r6
            goto L_0x00a6
        L_0x009c:
            int r3 = r0.bp
            int r16 = r16 + 2
            int r3 = r3 + r6
            char r3 = r0.charAt(r3)
        L_0x00a5:
            r5 = r3
        L_0x00a6:
            if (r5 < r14) goto L_0x00b7
            if (r5 > r10) goto L_0x00b7
            int r3 = r0.bp
            int r5 = r16 + 1
            int r3 = r3 + r16
            char r3 = r0.charAt(r3)
            r16 = r5
            goto L_0x00a5
        L_0x00b7:
            if (r9 == 0) goto L_0x00d5
            if (r5 == r7) goto L_0x00be
            r0.matchStat = r15
            return r4
        L_0x00be:
            int r3 = r0.bp
            int r5 = r16 + 1
            int r3 = r3 + r16
            char r3 = r0.charAt(r3)
            int r6 = r0.bp
            int r1 = r1.length
            int r1 = r1 + r6
            int r1 = r1 + r8
            int r6 = r6 + r5
            int r6 = r6 - r1
            int r6 = r6 + -2
            r16 = r5
            r5 = r3
            goto L_0x00de
        L_0x00d5:
            int r3 = r0.bp
            int r1 = r1.length
            int r1 = r1 + r3
            int r3 = r3 + r16
            int r3 = r3 - r1
            int r6 = r3 + -1
        L_0x00de:
            r3 = 65535(0xffff, float:9.1834E-41)
            if (r6 > r3) goto L_0x0163
            char[] r1 = r0.sub_chars(r1, r6)
            java.math.BigDecimal r3 = new java.math.BigDecimal
            int r6 = r1.length
            java.math.MathContext r7 = java.math.MathContext.UNLIMITED
            r3.<init>(r1, r2, r6, r7)
            if (r5 != r13) goto L_0x0103
            int r1 = r0.bp
            int r1 = r1 + r16
            r0.bp = r1
            char r1 = r0.charAt(r1)
            r0.ch = r1
            r1 = 3
            r0.matchStat = r1
            r0.token = r12
            return r3
        L_0x0103:
            r1 = 125(0x7d, float:1.75E-43)
            if (r5 != r1) goto L_0x0160
            int r1 = r0.bp
            int r2 = r16 + 1
            int r1 = r1 + r16
            char r1 = r0.charAt(r1)
            if (r1 != r13) goto L_0x0121
            r0.token = r12
            int r1 = r0.bp
            int r1 = r1 + r2
            r0.bp = r1
            char r1 = r0.charAt(r1)
            r0.ch = r1
            goto L_0x0159
        L_0x0121:
            r5 = 93
            if (r1 != r5) goto L_0x0135
            r1 = 15
            r0.token = r1
            int r1 = r0.bp
            int r1 = r1 + r2
            r0.bp = r1
            char r1 = r0.charAt(r1)
            r0.ch = r1
            goto L_0x0159
        L_0x0135:
            r5 = 125(0x7d, float:1.75E-43)
            if (r1 != r5) goto L_0x0149
            r5 = 13
            r0.token = r5
            int r1 = r0.bp
            int r1 = r1 + r2
            r0.bp = r1
            char r1 = r0.charAt(r1)
            r0.ch = r1
            goto L_0x0159
        L_0x0149:
            r2 = 26
            if (r1 != r2) goto L_0x015d
            r1 = 20
            r0.token = r1
            int r1 = r0.bp
            int r1 = r1 + r16
            r0.bp = r1
            r0.ch = r2
        L_0x0159:
            r1 = 4
            r0.matchStat = r1
            return r3
        L_0x015d:
            r0.matchStat = r15
            return r4
        L_0x0160:
            r0.matchStat = r15
            return r4
        L_0x0163:
            com.alibaba.fastjson.JSONException r1 = new com.alibaba.fastjson.JSONException
            java.lang.String r2 = "scan decimal overflow"
            r1.<init>(r2)
            throw r1
        L_0x016b:
            r1 = 110(0x6e, float:1.54E-43)
            if (r5 != r1) goto L_0x01ea
            int r1 = r0.bp
            int r1 = r1 + r6
            char r1 = r0.charAt(r1)
            r2 = 117(0x75, float:1.64E-43)
            if (r1 != r2) goto L_0x01ea
            int r1 = r0.bp
            int r1 = r1 + r6
            int r1 = r1 + r8
            char r1 = r0.charAt(r1)
            r2 = 108(0x6c, float:1.51E-43)
            if (r1 != r2) goto L_0x01ea
            int r1 = r0.bp
            int r1 = r1 + r6
            int r1 = r1 + 2
            char r1 = r0.charAt(r1)
            if (r1 != r2) goto L_0x01ea
            r1 = 5
            r0.matchStat = r1
            int r2 = r6 + 3
            int r3 = r0.bp
            int r5 = r6 + 4
            int r3 = r3 + r2
            char r2 = r0.charAt(r3)
            if (r9 == 0) goto L_0x01ac
            if (r2 != r7) goto L_0x01ac
            int r2 = r0.bp
            int r6 = r6 + r1
            int r2 = r2 + r5
            char r2 = r0.charAt(r2)
            r5 = r6
        L_0x01ac:
            if (r2 != r13) goto L_0x01be
            int r2 = r0.bp
            int r2 = r2 + r5
            r0.bp = r2
            char r2 = r0.charAt(r2)
            r0.ch = r2
            r0.matchStat = r1
            r0.token = r12
            return r4
        L_0x01be:
            r3 = 125(0x7d, float:1.75E-43)
            if (r2 != r3) goto L_0x01d4
            int r2 = r0.bp
            int r2 = r2 + r5
            r0.bp = r2
            char r2 = r0.charAt(r2)
            r0.ch = r2
            r0.matchStat = r1
            r6 = 13
            r0.token = r6
            return r4
        L_0x01d4:
            r6 = 13
            boolean r2 = isWhitespace(r2)
            if (r2 == 0) goto L_0x01e7
            int r2 = r0.bp
            int r7 = r5 + 1
            int r2 = r2 + r5
            char r2 = r0.charAt(r2)
            r5 = r7
            goto L_0x01ac
        L_0x01e7:
            r0.matchStat = r15
            return r4
        L_0x01ea:
            r0.matchStat = r15
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanFieldDecimal(char[]):java.math.BigDecimal");
    }

    public final double scanFieldDouble(char[] cArr) {
        boolean z;
        boolean z2;
        long j;
        int i;
        char charAt;
        int i2;
        long j2;
        char c;
        boolean z3;
        int i3;
        int i4;
        double parseDouble;
        char[] cArr2 = cArr;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return OOXIXo.f29376XO;
        }
        int length = cArr2.length;
        int i5 = length + 1;
        char charAt2 = charAt(this.bp + length);
        if (charAt2 == '\"') {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            charAt2 = charAt(this.bp + i5);
            i5 = length + 2;
        }
        if (charAt2 == '-') {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            charAt2 = charAt(this.bp + i5);
            i5++;
        }
        if (charAt2 >= '0' && charAt2 <= '9') {
            long j3 = (long) (charAt2 - '0');
            while (true) {
                i = i5 + 1;
                charAt = charAt(this.bp + i5);
                if (charAt >= '0' && charAt <= '9') {
                    j3 = (j * 10) + ((long) (charAt - '0'));
                    i5 = i;
                }
            }
            if (charAt == '.') {
                int i6 = i5 + 2;
                char charAt3 = charAt(this.bp + i);
                if (charAt3 >= '0' && charAt3 <= '9') {
                    j = (j * 10) + ((long) (charAt3 - '0'));
                    j2 = 10;
                    while (true) {
                        i = i6 + 1;
                        charAt = charAt(this.bp + i6);
                        if (charAt < '0' || charAt > '9') {
                            break;
                        }
                        j = (j * 10) + ((long) (charAt - '0'));
                        j2 *= 10;
                        i6 = i;
                    }
                } else {
                    this.matchStat = -1;
                    return OOXIXo.f29376XO;
                }
            } else {
                j2 = 1;
            }
            if (c == 'e' || c == 'E') {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3) {
                int i7 = i2 + 1;
                c = charAt(this.bp + i2);
                if (c == '+' || c == '-') {
                    i2 += 2;
                    c = charAt(this.bp + i7);
                } else {
                    i2 = i7;
                }
                while (c >= '0' && c <= '9') {
                    c = charAt(this.bp + i2);
                    i2++;
                }
            }
            if (!z) {
                int i8 = this.bp;
                i4 = cArr2.length + i8;
                i3 = ((i8 + i2) - i4) - 1;
            } else if (c != '\"') {
                this.matchStat = -1;
                return OOXIXo.f29376XO;
            } else {
                int i9 = i2 + 1;
                c = charAt(this.bp + i2);
                int i10 = this.bp;
                i4 = cArr2.length + i10 + 1;
                i3 = ((i10 + i9) - i4) - 2;
                i2 = i9;
            }
            if (z3 || i3 >= 17) {
                parseDouble = Double.parseDouble(subString(i4, i3));
            } else {
                parseDouble = ((double) j) / ((double) j2);
                if (z2) {
                    parseDouble = -parseDouble;
                }
            }
            if (c == ',') {
                int i11 = this.bp + i2;
                this.bp = i11;
                this.ch = charAt(i11);
                this.matchStat = 3;
                this.token = 16;
                return parseDouble;
            } else if (c == '}') {
                int i12 = i2 + 1;
                char charAt4 = charAt(this.bp + i2);
                if (charAt4 == ',') {
                    this.token = 16;
                    int i13 = this.bp + i12;
                    this.bp = i13;
                    this.ch = charAt(i13);
                } else if (charAt4 == ']') {
                    this.token = 15;
                    int i14 = this.bp + i12;
                    this.bp = i14;
                    this.ch = charAt(i14);
                } else if (charAt4 == '}') {
                    this.token = 13;
                    int i15 = this.bp + i12;
                    this.bp = i15;
                    this.ch = charAt(i15);
                } else if (charAt4 == 26) {
                    this.token = 20;
                    this.bp += i2;
                    this.ch = JSONLexer.EOI;
                } else {
                    this.matchStat = -1;
                    return OOXIXo.f29376XO;
                }
                this.matchStat = 4;
                return parseDouble;
            } else {
                this.matchStat = -1;
                return OOXIXo.f29376XO;
            }
        } else if (charAt2 == 'n' && charAt(this.bp + i5) == 'u' && charAt(this.bp + i5 + 1) == 'l' && charAt(this.bp + i5 + 2) == 'l') {
            this.matchStat = 5;
            int i16 = i5 + 4;
            char charAt5 = charAt(this.bp + i5 + 3);
            if (z && charAt5 == '\"') {
                charAt5 = charAt(this.bp + i16);
                i16 = i5 + 5;
            }
            while (charAt5 != ',') {
                if (charAt5 == '}') {
                    int i17 = this.bp + i16;
                    this.bp = i17;
                    this.ch = charAt(i17);
                    this.matchStat = 5;
                    this.token = 13;
                    return OOXIXo.f29376XO;
                } else if (isWhitespace(charAt5)) {
                    charAt5 = charAt(this.bp + i16);
                    i16++;
                } else {
                    this.matchStat = -1;
                    return OOXIXo.f29376XO;
                }
            }
            int i18 = this.bp + i16;
            this.bp = i18;
            this.ch = charAt(i18);
            this.matchStat = 5;
            this.token = 16;
            return OOXIXo.f29376XO;
        } else {
            this.matchStat = -1;
            return OOXIXo.f29376XO;
        }
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public final float scanFieldFloat(char[] r21) {
        /*
            r20 = this;
            r0 = r20
            r1 = r21
            r2 = 0
            r0.matchStat = r2
            boolean r3 = r20.charArrayCompare(r21)
            r4 = 0
            if (r3 != 0) goto L_0x0012
            r1 = -2
            r0.matchStat = r1
            return r4
        L_0x0012:
            int r3 = r1.length
            int r5 = r0.bp
            int r6 = r3 + 1
            int r5 = r5 + r3
            char r5 = r0.charAt(r5)
            r7 = 34
            if (r5 != r7) goto L_0x0022
            r9 = 1
            goto L_0x0023
        L_0x0022:
            r9 = 0
        L_0x0023:
            if (r9 == 0) goto L_0x002f
            int r5 = r0.bp
            int r3 = r3 + 2
            int r5 = r5 + r6
            char r5 = r0.charAt(r5)
            r6 = r3
        L_0x002f:
            r3 = 45
            if (r5 != r3) goto L_0x0035
            r10 = 1
            goto L_0x0036
        L_0x0035:
            r10 = 0
        L_0x0036:
            if (r10 == 0) goto L_0x0042
            int r5 = r0.bp
            int r11 = r6 + 1
            int r5 = r5 + r6
            char r5 = r0.charAt(r5)
            r6 = r11
        L_0x0042:
            r15 = -1
            r2 = 48
            if (r5 < r2) goto L_0x0196
            r11 = 57
            if (r5 > r11) goto L_0x0196
            int r5 = r5 - r2
            long r12 = (long) r5
        L_0x004d:
            int r5 = r0.bp
            int r17 = r6 + 1
            int r5 = r5 + r6
            char r5 = r0.charAt(r5)
            r18 = 10
            if (r5 < r2) goto L_0x0065
            if (r5 > r11) goto L_0x0065
            long r12 = r12 * r18
            int r5 = r5 + -48
            long r5 = (long) r5
            long r12 = r12 + r5
            r6 = r17
            goto L_0x004d
        L_0x0065:
            r14 = 46
            if (r5 != r14) goto L_0x0099
            int r5 = r0.bp
            int r6 = r6 + 2
            int r5 = r5 + r17
            char r5 = r0.charAt(r5)
            if (r5 < r2) goto L_0x0096
            if (r5 > r11) goto L_0x0096
            long r12 = r12 * r18
            int r5 = r5 - r2
            long r7 = (long) r5
            long r12 = r12 + r7
            r7 = r18
        L_0x007e:
            int r5 = r0.bp
            int r17 = r6 + 1
            int r5 = r5 + r6
            char r5 = r0.charAt(r5)
            if (r5 < r2) goto L_0x009b
            if (r5 > r11) goto L_0x009b
            long r12 = r12 * r18
            int r5 = r5 + -48
            long r5 = (long) r5
            long r12 = r12 + r5
            long r7 = r7 * r18
            r6 = r17
            goto L_0x007e
        L_0x0096:
            r0.matchStat = r15
            return r4
        L_0x0099:
            r7 = 1
        L_0x009b:
            r6 = 101(0x65, float:1.42E-43)
            if (r5 == r6) goto L_0x00a7
            r6 = 69
            if (r5 != r6) goto L_0x00a4
            goto L_0x00a7
        L_0x00a4:
            r16 = 0
            goto L_0x00a9
        L_0x00a7:
            r16 = 1
        L_0x00a9:
            if (r16 == 0) goto L_0x00da
            int r5 = r0.bp
            int r6 = r17 + 1
            int r5 = r5 + r17
            char r5 = r0.charAt(r5)
            r14 = 43
            if (r5 == r14) goto L_0x00bf
            if (r5 != r3) goto L_0x00bc
            goto L_0x00bf
        L_0x00bc:
            r17 = r6
            goto L_0x00c9
        L_0x00bf:
            int r3 = r0.bp
            int r17 = r17 + 2
            int r3 = r3 + r6
            char r3 = r0.charAt(r3)
        L_0x00c8:
            r5 = r3
        L_0x00c9:
            if (r5 < r2) goto L_0x00da
            if (r5 > r11) goto L_0x00da
            int r3 = r0.bp
            int r5 = r17 + 1
            int r3 = r3 + r17
            char r3 = r0.charAt(r3)
            r17 = r5
            goto L_0x00c8
        L_0x00da:
            if (r9 == 0) goto L_0x00fa
            r2 = 34
            if (r5 == r2) goto L_0x00e3
            r0.matchStat = r15
            return r4
        L_0x00e3:
            int r2 = r0.bp
            int r3 = r17 + 1
            int r2 = r2 + r17
            char r5 = r0.charAt(r2)
            int r2 = r0.bp
            int r1 = r1.length
            int r1 = r1 + r2
            r6 = 1
            int r1 = r1 + r6
            int r2 = r2 + r3
            int r2 = r2 - r1
            int r2 = r2 + -2
            r17 = r3
            goto L_0x0103
        L_0x00fa:
            r6 = 1
            int r2 = r0.bp
            int r1 = r1.length
            int r1 = r1 + r2
            int r2 = r2 + r17
            int r2 = r2 - r1
            int r2 = r2 - r6
        L_0x0103:
            if (r16 != 0) goto L_0x0113
            r3 = 17
            if (r2 >= r3) goto L_0x0113
            double r1 = (double) r12
            double r6 = (double) r7
            double r1 = r1 / r6
            float r1 = (float) r1
            if (r10 == 0) goto L_0x0110
            float r1 = -r1
        L_0x0110:
            r2 = 44
            goto L_0x011c
        L_0x0113:
            java.lang.String r1 = r0.subString(r1, r2)
            float r1 = java.lang.Float.parseFloat(r1)
            goto L_0x0110
        L_0x011c:
            if (r5 != r2) goto L_0x0132
            int r2 = r0.bp
            int r2 = r2 + r17
            r0.bp = r2
            char r2 = r0.charAt(r2)
            r0.ch = r2
            r2 = 3
            r0.matchStat = r2
            r2 = 16
            r0.token = r2
            return r1
        L_0x0132:
            r2 = 16
            r3 = 125(0x7d, float:1.75E-43)
            if (r5 != r3) goto L_0x0193
            int r3 = r0.bp
            int r5 = r17 + 1
            int r3 = r3 + r17
            char r3 = r0.charAt(r3)
            r6 = 44
            if (r3 != r6) goto L_0x0154
            r0.token = r2
            int r2 = r0.bp
            int r2 = r2 + r5
            r0.bp = r2
            char r2 = r0.charAt(r2)
            r0.ch = r2
            goto L_0x018c
        L_0x0154:
            r2 = 93
            if (r3 != r2) goto L_0x0168
            r2 = 15
            r0.token = r2
            int r2 = r0.bp
            int r2 = r2 + r5
            r0.bp = r2
            char r2 = r0.charAt(r2)
            r0.ch = r2
            goto L_0x018c
        L_0x0168:
            r2 = 125(0x7d, float:1.75E-43)
            if (r3 != r2) goto L_0x017c
            r2 = 13
            r0.token = r2
            int r2 = r0.bp
            int r2 = r2 + r5
            r0.bp = r2
            char r2 = r0.charAt(r2)
            r0.ch = r2
            goto L_0x018c
        L_0x017c:
            r2 = 26
            if (r3 != r2) goto L_0x0190
            int r3 = r0.bp
            int r3 = r3 + r17
            r0.bp = r3
            r3 = 20
            r0.token = r3
            r0.ch = r2
        L_0x018c:
            r2 = 4
            r0.matchStat = r2
            return r1
        L_0x0190:
            r0.matchStat = r15
            return r4
        L_0x0193:
            r0.matchStat = r15
            return r4
        L_0x0196:
            r1 = 110(0x6e, float:1.54E-43)
            if (r5 != r1) goto L_0x021e
            int r1 = r0.bp
            int r1 = r1 + r6
            char r1 = r0.charAt(r1)
            r2 = 117(0x75, float:1.64E-43)
            if (r1 != r2) goto L_0x021e
            int r1 = r0.bp
            int r1 = r1 + r6
            r2 = 1
            int r1 = r1 + r2
            char r1 = r0.charAt(r1)
            r2 = 108(0x6c, float:1.51E-43)
            if (r1 != r2) goto L_0x021e
            int r1 = r0.bp
            int r1 = r1 + r6
            int r1 = r1 + 2
            char r1 = r0.charAt(r1)
            if (r1 != r2) goto L_0x021e
            r1 = 5
            r0.matchStat = r1
            int r2 = r6 + 3
            int r3 = r0.bp
            int r5 = r6 + 4
            int r3 = r3 + r2
            char r2 = r0.charAt(r3)
            if (r9 == 0) goto L_0x01da
            r3 = 34
            if (r2 != r3) goto L_0x01da
            int r2 = r0.bp
            int r6 = r6 + r1
            int r2 = r2 + r5
            char r2 = r0.charAt(r2)
            r5 = r6
        L_0x01da:
            r3 = 44
        L_0x01dc:
            if (r2 != r3) goto L_0x01f0
            int r2 = r0.bp
            int r2 = r2 + r5
            r0.bp = r2
            char r2 = r0.charAt(r2)
            r0.ch = r2
            r0.matchStat = r1
            r6 = 16
            r0.token = r6
            return r4
        L_0x01f0:
            r6 = 16
            r7 = 125(0x7d, float:1.75E-43)
            if (r2 != r7) goto L_0x0208
            int r2 = r0.bp
            int r2 = r2 + r5
            r0.bp = r2
            char r2 = r0.charAt(r2)
            r0.ch = r2
            r0.matchStat = r1
            r8 = 13
            r0.token = r8
            return r4
        L_0x0208:
            r8 = 13
            boolean r2 = isWhitespace(r2)
            if (r2 == 0) goto L_0x021b
            int r2 = r0.bp
            int r9 = r5 + 1
            int r2 = r2 + r5
            char r2 = r0.charAt(r2)
            r5 = r9
            goto L_0x01dc
        L_0x021b:
            r0.matchStat = r15
            return r4
        L_0x021e:
            r0.matchStat = r15
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanFieldFloat(char[]):float");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:94:0x01bc, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final float[] scanFieldFloatArray(char[] r20) {
        /*
            r19 = this;
            r0 = r19
            r1 = 0
            r0.matchStat = r1
            boolean r2 = r19.charArrayCompare(r20)
            r3 = -2
            r4 = 0
            if (r2 != 0) goto L_0x0010
            r0.matchStat = r3
            return r4
        L_0x0010:
            r2 = r20
            int r2 = r2.length
            int r5 = r0.bp
            int r6 = r2 + 1
            int r5 = r5 + r2
            char r5 = r0.charAt(r5)
            r7 = 91
            if (r5 == r7) goto L_0x0023
            r0.matchStat = r3
            return r4
        L_0x0023:
            int r3 = r0.bp
            int r2 = r2 + 2
            int r3 = r3 + r6
            char r3 = r0.charAt(r3)
            r5 = 16
            float[] r6 = new float[r5]
            r7 = 0
        L_0x0031:
            int r8 = r0.bp
            int r9 = r8 + r2
            r10 = 1
            int r9 = r9 - r10
            r11 = 45
            if (r3 != r11) goto L_0x003d
            r12 = 1
            goto L_0x003e
        L_0x003d:
            r12 = 0
        L_0x003e:
            if (r12 == 0) goto L_0x004c
            int r3 = r2 + 1
            int r8 = r8 + r2
            char r2 = r0.charAt(r8)
            r18 = r3
            r3 = r2
            r2 = r18
        L_0x004c:
            r8 = -1
            r13 = 48
            if (r3 < r13) goto L_0x01b9
            r14 = 57
            if (r3 > r14) goto L_0x01b9
            int r3 = r3 + -48
        L_0x0057:
            int r15 = r0.bp
            int r16 = r2 + 1
            int r15 = r15 + r2
            char r15 = r0.charAt(r15)
            if (r15 < r13) goto L_0x006c
            if (r15 > r14) goto L_0x006c
            int r3 = r3 * 10
            int r15 = r15 + -48
            int r3 = r3 + r15
            r2 = r16
            goto L_0x0057
        L_0x006c:
            r5 = 46
            r1 = 10
            if (r15 != r5) goto L_0x00a1
            int r5 = r0.bp
            int r2 = r2 + 2
            int r5 = r5 + r16
            char r5 = r0.charAt(r5)
            if (r5 < r13) goto L_0x009e
            if (r5 > r14) goto L_0x009e
            int r3 = r3 * 10
            int r5 = r5 + -48
            int r3 = r3 + r5
            r5 = 10
        L_0x0087:
            int r15 = r0.bp
            int r16 = r2 + 1
            int r15 = r15 + r2
            char r15 = r0.charAt(r15)
            if (r15 < r13) goto L_0x00a2
            if (r15 > r14) goto L_0x00a2
            int r3 = r3 * 10
            int r15 = r15 + -48
            int r3 = r3 + r15
            int r5 = r5 * 10
            r2 = r16
            goto L_0x0087
        L_0x009e:
            r0.matchStat = r8
            return r4
        L_0x00a1:
            r5 = 1
        L_0x00a2:
            r2 = 101(0x65, float:1.42E-43)
            if (r15 == r2) goto L_0x00ad
            r2 = 69
            if (r15 != r2) goto L_0x00ab
            goto L_0x00ad
        L_0x00ab:
            r2 = 0
            goto L_0x00ae
        L_0x00ad:
            r2 = 1
        L_0x00ae:
            if (r2 == 0) goto L_0x00e0
            int r15 = r0.bp
            int r17 = r16 + 1
            int r15 = r15 + r16
            char r15 = r0.charAt(r15)
            r4 = 43
            if (r15 == r4) goto L_0x00c4
            if (r15 != r11) goto L_0x00c1
            goto L_0x00c4
        L_0x00c1:
            r16 = r17
            goto L_0x00cf
        L_0x00c4:
            int r4 = r0.bp
            int r16 = r16 + 2
            int r4 = r4 + r17
            char r4 = r0.charAt(r4)
            r15 = r4
        L_0x00cf:
            if (r15 < r13) goto L_0x00e0
            if (r15 > r14) goto L_0x00e0
            int r4 = r0.bp
            int r11 = r16 + 1
            int r4 = r4 + r16
            char r15 = r0.charAt(r4)
            r16 = r11
            goto L_0x00cf
        L_0x00e0:
            int r4 = r0.bp
            int r4 = r4 + r16
            int r4 = r4 - r9
            int r4 = r4 - r10
            if (r2 != 0) goto L_0x00f1
            if (r4 >= r1) goto L_0x00f1
            float r1 = (float) r3
            float r2 = (float) r5
            float r1 = r1 / r2
            if (r12 == 0) goto L_0x00f9
            float r1 = -r1
            goto L_0x00f9
        L_0x00f1:
            java.lang.String r1 = r0.subString(r9, r4)
            float r1 = java.lang.Float.parseFloat(r1)
        L_0x00f9:
            int r2 = r6.length
            r3 = 3
            if (r7 < r2) goto L_0x0109
            int r2 = r6.length
            int r2 = r2 * 3
            int r2 = r2 / 2
            float[] r2 = new float[r2]
            r4 = 0
            java.lang.System.arraycopy(r6, r4, r2, r4, r7)
            r6 = r2
        L_0x0109:
            int r4 = r7 + 1
            r6[r7] = r1
            r1 = 44
            if (r15 != r1) goto L_0x0122
            int r1 = r0.bp
            int r2 = r16 + 1
            int r1 = r1 + r16
            char r1 = r0.charAt(r1)
            r15 = r1
            r1 = 0
            r3 = 16
            r11 = 0
            goto L_0x01b1
        L_0x0122:
            r2 = 93
            if (r15 != r2) goto L_0x01ab
            int r5 = r0.bp
            int r7 = r16 + 1
            int r5 = r5 + r16
            char r5 = r0.charAt(r5)
            int r9 = r6.length
            if (r4 == r9) goto L_0x013a
            float[] r9 = new float[r4]
            r11 = 0
            java.lang.System.arraycopy(r6, r11, r9, r11, r4)
            r6 = r9
        L_0x013a:
            if (r5 != r1) goto L_0x014c
            int r1 = r0.bp
            int r1 = r1 + r16
            r0.bp = r1
            r19.next()
            r0.matchStat = r3
            r3 = 16
            r0.token = r3
            return r6
        L_0x014c:
            r3 = 16
            r4 = 125(0x7d, float:1.75E-43)
            if (r5 != r4) goto L_0x01a7
            int r5 = r0.bp
            int r5 = r5 + r7
            char r5 = r0.charAt(r5)
            if (r5 != r1) goto L_0x0169
            r0.token = r3
            int r1 = r0.bp
            int r16 = r16 + 1
            int r1 = r1 + r16
            r0.bp = r1
            r19.next()
            goto L_0x019f
        L_0x0169:
            if (r5 != r2) goto L_0x017b
            r1 = 15
            r0.token = r1
            int r1 = r0.bp
            int r16 = r16 + 1
            int r1 = r1 + r16
            r0.bp = r1
            r19.next()
            goto L_0x019f
        L_0x017b:
            if (r5 != r4) goto L_0x018d
            r1 = 13
            r0.token = r1
            int r1 = r0.bp
            int r16 = r16 + 1
            int r1 = r1 + r16
            r0.bp = r1
            r19.next()
            goto L_0x019f
        L_0x018d:
            r1 = 26
            if (r5 != r1) goto L_0x01a3
            int r2 = r0.bp
            int r16 = r16 + 1
            int r2 = r2 + r16
            r0.bp = r2
            r2 = 20
            r0.token = r2
            r0.ch = r1
        L_0x019f:
            r1 = 4
            r0.matchStat = r1
            return r6
        L_0x01a3:
            r0.matchStat = r8
            r1 = 0
            return r1
        L_0x01a7:
            r1 = 0
            r0.matchStat = r8
            return r1
        L_0x01ab:
            r1 = 0
            r3 = 16
            r11 = 0
            r2 = r16
        L_0x01b1:
            r7 = r4
            r3 = r15
            r5 = 16
            r4 = r1
            r1 = 0
            goto L_0x0031
        L_0x01b9:
            r1 = r4
            r0.matchStat = r8
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanFieldFloatArray(char[]):float[]");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00b5, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0137, code lost:
        r4 = r18 + 1;
        r1 = charAt(r0.bp + r18);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0142, code lost:
        if (r2 == r3.length) goto L_0x014c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0144, code lost:
        r5 = new float[r2];
        r7 = 0;
        java.lang.System.arraycopy(r3, 0, r5, 0, r2);
        r3 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x014c, code lost:
        r7 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x014e, code lost:
        if (r8 < r6.length) goto L_0x015c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0150, code lost:
        r5 = new float[((r6.length * 3) / 2)][];
        java.lang.System.arraycopy(r3, r7, r5, r7, r2);
        r6 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x015c, code lost:
        r5 = r8 + 1;
        r6[r8] = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0162, code lost:
        if (r1 != ',') goto L_0x0171;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0164, code lost:
        r3 = charAt(r0.bp + r4);
        r2 = r18 + 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0173, code lost:
        if (r1 != ']') goto L_0x0180;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0175, code lost:
        r2 = r18 + 2;
        r3 = charAt(r0.bp + r4);
        r8 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0180, code lost:
        r3 = r1;
        r2 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0199, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final float[][] scanFieldFloatArray2(char[] r22) {
        /*
            r21 = this;
            r0 = r21
            r1 = 0
            r0.matchStat = r1
            boolean r2 = r21.charArrayCompare(r22)
            r3 = -2
            r4 = 0
            if (r2 != 0) goto L_0x0010
            r0.matchStat = r3
            return r4
        L_0x0010:
            r2 = r22
            int r2 = r2.length
            int r5 = r0.bp
            int r6 = r2 + 1
            int r5 = r5 + r2
            char r5 = r0.charAt(r5)
            r7 = 91
            if (r5 == r7) goto L_0x0023
            r0.matchStat = r3
            return r4
        L_0x0023:
            int r3 = r0.bp
            int r2 = r2 + 2
            int r3 = r3 + r6
            char r3 = r0.charAt(r3)
            r5 = 16
            float[][] r6 = new float[r5][]
            r8 = 0
        L_0x0031:
            r12 = -1
            r13 = 1
            if (r3 != r7) goto L_0x019a
            int r3 = r0.bp
            int r14 = r2 + 1
            int r3 = r3 + r2
            char r2 = r0.charAt(r3)
            float[] r3 = new float[r5]
            r15 = 0
        L_0x0041:
            int r7 = r0.bp
            int r16 = r7 + r14
            int r5 = r16 + -1
            r9 = 45
            if (r2 != r9) goto L_0x004e
            r17 = 1
            goto L_0x0050
        L_0x004e:
            r17 = 0
        L_0x0050:
            if (r17 == 0) goto L_0x005b
            int r2 = r14 + 1
            int r7 = r7 + r14
            char r7 = r0.charAt(r7)
            r14 = r2
            r2 = r7
        L_0x005b:
            r7 = 48
            if (r2 < r7) goto L_0x0196
            r11 = 57
            if (r2 > r11) goto L_0x0196
            int r2 = r2 + -48
        L_0x0065:
            int r1 = r0.bp
            int r18 = r14 + 1
            int r1 = r1 + r14
            char r1 = r0.charAt(r1)
            if (r1 < r7) goto L_0x007a
            if (r1 > r11) goto L_0x007a
            int r2 = r2 * 10
            int r1 = r1 + -48
            int r2 = r2 + r1
            r14 = r18
            goto L_0x0065
        L_0x007a:
            r10 = 46
            r13 = 10
            if (r1 != r10) goto L_0x00b6
            int r1 = r0.bp
            int r14 = r14 + 2
            int r1 = r1 + r18
            char r1 = r0.charAt(r1)
            if (r1 < r7) goto L_0x00b3
            if (r1 > r11) goto L_0x00b3
            int r2 = r2 * 10
            int r1 = r1 + -48
            int r2 = r2 + r1
            r1 = 10
        L_0x0095:
            int r10 = r0.bp
            int r18 = r14 + 1
            int r10 = r10 + r14
            char r10 = r0.charAt(r10)
            if (r10 < r7) goto L_0x00ac
            if (r10 > r11) goto L_0x00ac
            int r2 = r2 * 10
            int r10 = r10 + -48
            int r2 = r2 + r10
            int r1 = r1 * 10
            r14 = r18
            goto L_0x0095
        L_0x00ac:
            r20 = r2
            r2 = r1
            r1 = r10
            r10 = r20
            goto L_0x00b8
        L_0x00b3:
            r0.matchStat = r12
            return r4
        L_0x00b6:
            r10 = r2
            r2 = 1
        L_0x00b8:
            r14 = 101(0x65, float:1.42E-43)
            if (r1 == r14) goto L_0x00c3
            r14 = 69
            if (r1 != r14) goto L_0x00c1
            goto L_0x00c3
        L_0x00c1:
            r14 = 0
            goto L_0x00c4
        L_0x00c3:
            r14 = 1
        L_0x00c4:
            if (r14 == 0) goto L_0x00f5
            int r1 = r0.bp
            int r19 = r18 + 1
            int r1 = r1 + r18
            char r1 = r0.charAt(r1)
            r4 = 43
            if (r1 == r4) goto L_0x00da
            if (r1 != r9) goto L_0x00d7
            goto L_0x00da
        L_0x00d7:
            r18 = r19
            goto L_0x00e4
        L_0x00da:
            int r1 = r0.bp
            int r18 = r18 + 2
            int r1 = r1 + r19
            char r1 = r0.charAt(r1)
        L_0x00e4:
            if (r1 < r7) goto L_0x00f5
            if (r1 > r11) goto L_0x00f5
            int r1 = r0.bp
            int r4 = r18 + 1
            int r1 = r1 + r18
            char r1 = r0.charAt(r1)
            r18 = r4
            goto L_0x00e4
        L_0x00f5:
            int r4 = r0.bp
            int r4 = r4 + r18
            int r4 = r4 - r5
            r7 = 1
            int r4 = r4 - r7
            if (r14 != 0) goto L_0x0107
            if (r4 >= r13) goto L_0x0107
            float r4 = (float) r10
            float r2 = (float) r2
            float r4 = r4 / r2
            if (r17 == 0) goto L_0x010f
            float r4 = -r4
            goto L_0x010f
        L_0x0107:
            java.lang.String r2 = r0.subString(r5, r4)
            float r4 = java.lang.Float.parseFloat(r2)
        L_0x010f:
            int r2 = r3.length
            if (r15 < r2) goto L_0x011f
            int r2 = r3.length
            r5 = 3
            int r2 = r2 * 3
            int r2 = r2 / 2
            float[] r2 = new float[r2]
            r5 = 0
            java.lang.System.arraycopy(r3, r5, r2, r5, r15)
            r3 = r2
        L_0x011f:
            int r2 = r15 + 1
            r3[r15] = r4
            r4 = 44
            if (r1 != r4) goto L_0x0133
            int r1 = r0.bp
            int r4 = r18 + 1
            int r1 = r1 + r18
            char r1 = r0.charAt(r1)
            r14 = r4
            goto L_0x018d
        L_0x0133:
            r4 = 93
            if (r1 != r4) goto L_0x018b
            int r1 = r0.bp
            int r4 = r18 + 1
            int r1 = r1 + r18
            char r1 = r0.charAt(r1)
            int r5 = r3.length
            if (r2 == r5) goto L_0x014c
            float[] r5 = new float[r2]
            r7 = 0
            java.lang.System.arraycopy(r3, r7, r5, r7, r2)
            r3 = r5
            goto L_0x014d
        L_0x014c:
            r7 = 0
        L_0x014d:
            int r5 = r6.length
            if (r8 < r5) goto L_0x015c
            int r5 = r6.length
            r6 = 3
            int r5 = r5 * 3
            int r5 = r5 / 2
            float[][] r5 = new float[r5][]
            java.lang.System.arraycopy(r3, r7, r5, r7, r2)
            r6 = r5
        L_0x015c:
            int r5 = r8 + 1
            r6[r8] = r3
            r2 = 44
            if (r1 != r2) goto L_0x0171
            int r1 = r0.bp
            int r18 = r18 + 2
            int r1 = r1 + r4
            char r1 = r0.charAt(r1)
            r3 = r1
            r2 = r18
            goto L_0x0182
        L_0x0171:
            r2 = 93
            if (r1 != r2) goto L_0x0180
            int r1 = r0.bp
            int r2 = r18 + 2
            int r1 = r1 + r4
            char r3 = r0.charAt(r1)
            r8 = r5
            goto L_0x019a
        L_0x0180:
            r3 = r1
            r2 = r4
        L_0x0182:
            r8 = r5
            r1 = 0
            r4 = 0
            r5 = 16
            r7 = 91
            goto L_0x0031
        L_0x018b:
            r14 = r18
        L_0x018d:
            r15 = r2
            r4 = 0
            r5 = 16
            r13 = 1
            r2 = r1
            r1 = 0
            goto L_0x0041
        L_0x0196:
            r0.matchStat = r12
            r1 = 0
            return r1
        L_0x019a:
            int r1 = r6.length
            if (r8 == r1) goto L_0x01a4
            float[][] r1 = new float[r8][]
            r4 = 0
            java.lang.System.arraycopy(r6, r4, r1, r4, r8)
            r6 = r1
        L_0x01a4:
            r1 = 44
            if (r3 != r1) goto L_0x01ba
            int r1 = r0.bp
            r3 = 1
            int r2 = r2 - r3
            int r1 = r1 + r2
            r0.bp = r1
            r21.next()
            r1 = 3
            r0.matchStat = r1
            r1 = 16
            r0.token = r1
            return r6
        L_0x01ba:
            r1 = 16
            r4 = 125(0x7d, float:1.75E-43)
            if (r3 != r4) goto L_0x020d
            int r3 = r0.bp
            int r3 = r3 + r2
            char r3 = r0.charAt(r3)
            r5 = 44
            if (r3 != r5) goto L_0x01d6
            r0.token = r1
            int r1 = r0.bp
            int r1 = r1 + r2
            r0.bp = r1
            r21.next()
            goto L_0x0205
        L_0x01d6:
            r1 = 93
            if (r3 != r1) goto L_0x01e7
            r1 = 15
            r0.token = r1
            int r1 = r0.bp
            int r1 = r1 + r2
            r0.bp = r1
            r21.next()
            goto L_0x0205
        L_0x01e7:
            if (r3 != r4) goto L_0x01f6
            r1 = 13
            r0.token = r1
            int r1 = r0.bp
            int r1 = r1 + r2
            r0.bp = r1
            r21.next()
            goto L_0x0205
        L_0x01f6:
            r1 = 26
            if (r3 != r1) goto L_0x0209
            int r3 = r0.bp
            int r3 = r3 + r2
            r0.bp = r3
            r2 = 20
            r0.token = r2
            r0.ch = r1
        L_0x0205:
            r1 = 4
            r0.matchStat = r1
            return r6
        L_0x0209:
            r0.matchStat = r12
            r1 = 0
            return r1
        L_0x020d:
            r1 = 0
            r0.matchStat = r12
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanFieldFloatArray2(char[]):float[][]");
    }

    public int scanFieldInt(char[] cArr) {
        boolean z;
        int i;
        char charAt;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return 0;
        }
        int length = cArr.length;
        int i2 = length + 1;
        char charAt2 = charAt(this.bp + length);
        if (charAt2 == '-') {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            charAt2 = charAt(this.bp + i2);
            i2 = length + 2;
        }
        if (charAt2 < '0' || charAt2 > '9') {
            this.matchStat = -1;
            return 0;
        }
        int i3 = charAt2 - '0';
        while (true) {
            i = i2 + 1;
            charAt = charAt(this.bp + i2);
            if (charAt >= '0' && charAt <= '9') {
                i3 = (i3 * 10) + (charAt - '0');
                i2 = i;
            }
        }
        if (charAt == '.') {
            this.matchStat = -1;
            return 0;
        } else if ((i3 < 0 || i > cArr.length + 14) && !(i3 == Integer.MIN_VALUE && i == 17 && z)) {
            this.matchStat = -1;
            return 0;
        } else if (charAt == ',') {
            int i4 = this.bp + i;
            this.bp = i4;
            this.ch = charAt(i4);
            this.matchStat = 3;
            this.token = 16;
            if (z) {
                return -i3;
            }
            return i3;
        } else if (charAt == '}') {
            int i5 = i2 + 2;
            char charAt3 = charAt(this.bp + i);
            if (charAt3 == ',') {
                this.token = 16;
                int i6 = this.bp + i5;
                this.bp = i6;
                this.ch = charAt(i6);
            } else if (charAt3 == ']') {
                this.token = 15;
                int i7 = this.bp + i5;
                this.bp = i7;
                this.ch = charAt(i7);
            } else if (charAt3 == '}') {
                this.token = 13;
                int i8 = this.bp + i5;
                this.bp = i8;
                this.ch = charAt(i8);
            } else if (charAt3 == 26) {
                this.token = 20;
                this.bp += i2 + 1;
                this.ch = JSONLexer.EOI;
            } else {
                this.matchStat = -1;
                return 0;
            }
            this.matchStat = 4;
            if (z) {
                return -i3;
            }
            return i3;
        } else {
            this.matchStat = -1;
            return 0;
        }
    }

    public final int[] scanFieldIntArray(char[] cArr) {
        int i;
        char c;
        int i2;
        boolean z;
        int i3;
        char charAt;
        int[] iArr;
        this.matchStat = 0;
        int[] iArr2 = null;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return null;
        }
        int length = cArr.length;
        int i4 = length + 1;
        if (charAt(this.bp + length) != '[') {
            this.matchStat = -2;
            return null;
        }
        int i5 = length + 2;
        char charAt2 = charAt(this.bp + i4);
        int[] iArr3 = new int[16];
        if (charAt2 == ']') {
            i2 = length + 3;
            c = charAt(this.bp + i5);
            i = 0;
        } else {
            int i6 = 0;
            while (true) {
                if (charAt2 == '-') {
                    charAt2 = charAt(this.bp + i5);
                    i5++;
                    z = true;
                } else {
                    z = false;
                }
                if (charAt2 < '0' || charAt2 > '9') {
                    int[] iArr4 = iArr2;
                    this.matchStat = -1;
                } else {
                    int i7 = charAt2 - '0';
                    while (true) {
                        i3 = i5 + 1;
                        charAt = charAt(this.bp + i5);
                        if (charAt >= '0' && charAt <= '9') {
                            i7 = (i7 * 10) + (charAt - '0');
                            i5 = i3;
                        }
                    }
                    if (i6 >= iArr3.length) {
                        int[] iArr5 = new int[((iArr3.length * 3) / 2)];
                        System.arraycopy(iArr3, 0, iArr5, 0, i6);
                        iArr3 = iArr5;
                    }
                    i = i6 + 1;
                    if (z) {
                        i7 = -i7;
                    }
                    iArr3[i6] = i7;
                    if (charAt == ',') {
                        i5 += 2;
                        charAt2 = charAt(this.bp + i3);
                        iArr = null;
                    } else if (charAt == ']') {
                        c = charAt(this.bp + i3);
                        i2 = i5 + 2;
                        break;
                    } else {
                        iArr = null;
                        charAt2 = charAt;
                        i5 = i3;
                    }
                    iArr2 = iArr;
                    i6 = i;
                }
            }
            int[] iArr42 = iArr2;
            this.matchStat = -1;
            return iArr42;
        }
        if (i != iArr3.length) {
            int[] iArr6 = new int[i];
            System.arraycopy(iArr3, 0, iArr6, 0, i);
            iArr3 = iArr6;
        }
        if (c == ',') {
            this.bp += i2 - 1;
            next();
            this.matchStat = 3;
            this.token = 16;
            return iArr3;
        } else if (c == '}') {
            char charAt3 = charAt(this.bp + i2);
            if (charAt3 == ',') {
                this.token = 16;
                this.bp += i2;
                next();
            } else if (charAt3 == ']') {
                this.token = 15;
                this.bp += i2;
                next();
            } else if (charAt3 == '}') {
                this.token = 13;
                this.bp += i2;
                next();
            } else if (charAt3 == 26) {
                this.bp += i2;
                this.token = 20;
                this.ch = JSONLexer.EOI;
            } else {
                this.matchStat = -1;
                return null;
            }
            this.matchStat = 4;
            return iArr3;
        } else {
            this.matchStat = -1;
            return null;
        }
    }

    public long scanFieldLong(char[] cArr) {
        int i;
        char charAt;
        boolean z = false;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return 0;
        }
        int length = cArr.length;
        int i2 = length + 1;
        char charAt2 = charAt(this.bp + length);
        if (charAt2 == '-') {
            charAt2 = charAt(this.bp + i2);
            i2 = length + 2;
            z = true;
        }
        if (charAt2 < '0' || charAt2 > '9') {
            this.matchStat = -1;
            return 0;
        }
        long j = (long) (charAt2 - '0');
        while (true) {
            i = i2 + 1;
            charAt = charAt(this.bp + i2);
            if (charAt >= '0' && charAt <= '9') {
                j = (j * 10) + ((long) (charAt - '0'));
                i2 = i;
            }
        }
        if (charAt == '.') {
            this.matchStat = -1;
            return 0;
        } else if (i - cArr.length >= 21 || (j < 0 && (j != Long.MIN_VALUE || !z))) {
            this.matchStat = -1;
            return 0;
        } else if (charAt == ',') {
            int i3 = this.bp + i;
            this.bp = i3;
            this.ch = charAt(i3);
            this.matchStat = 3;
            this.token = 16;
            if (z) {
                return -j;
            }
            return j;
        } else if (charAt == '}') {
            int i4 = i2 + 2;
            char charAt3 = charAt(this.bp + i);
            if (charAt3 == ',') {
                this.token = 16;
                int i5 = this.bp + i4;
                this.bp = i5;
                this.ch = charAt(i5);
            } else if (charAt3 == ']') {
                this.token = 15;
                int i6 = this.bp + i4;
                this.bp = i6;
                this.ch = charAt(i6);
            } else if (charAt3 == '}') {
                this.token = 13;
                int i7 = this.bp + i4;
                this.bp = i7;
                this.ch = charAt(i7);
            } else if (charAt3 == 26) {
                this.token = 20;
                this.bp += i2 + 1;
                this.ch = JSONLexer.EOI;
            } else {
                this.matchStat = -1;
                return 0;
            }
            this.matchStat = 4;
            if (z) {
                return -j;
            }
            return j;
        } else {
            this.matchStat = -1;
            return 0;
        }
    }

    public String scanFieldString(char[] cArr) {
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return stringDefaultValue();
        }
        int length = cArr.length;
        int i = length + 1;
        if (charAt(this.bp + length) != '\"') {
            this.matchStat = -1;
            return stringDefaultValue();
        }
        int indexOf = indexOf('\"', this.bp + cArr.length + 1);
        if (indexOf != -1) {
            int length2 = this.bp + cArr.length + 1;
            String subString = subString(length2, indexOf - length2);
            if (subString.indexOf(92) != -1) {
                while (true) {
                    int i2 = indexOf - 1;
                    int i3 = 0;
                    while (i2 >= 0 && charAt(i2) == '\\') {
                        i3++;
                        i2--;
                    }
                    if (i3 % 2 == 0) {
                        break;
                    }
                    indexOf = indexOf('\"', indexOf + 1);
                }
                int i4 = this.bp;
                int length3 = indexOf - ((cArr.length + i4) + 1);
                subString = readString(sub_chars(i4 + cArr.length + 1, length3), length3);
            }
            int i5 = this.bp;
            int length4 = i + (indexOf - ((cArr.length + i5) + 1)) + 1;
            int i6 = length4 + 1;
            char charAt = charAt(i5 + length4);
            if (charAt == ',') {
                int i7 = this.bp + i6;
                this.bp = i7;
                this.ch = charAt(i7);
                this.matchStat = 3;
                return subString;
            } else if (charAt == '}') {
                int i8 = length4 + 2;
                char charAt2 = charAt(this.bp + i6);
                if (charAt2 == ',') {
                    this.token = 16;
                    int i9 = this.bp + i8;
                    this.bp = i9;
                    this.ch = charAt(i9);
                } else if (charAt2 == ']') {
                    this.token = 15;
                    int i10 = this.bp + i8;
                    this.bp = i10;
                    this.ch = charAt(i10);
                } else if (charAt2 == '}') {
                    this.token = 13;
                    int i11 = this.bp + i8;
                    this.bp = i11;
                    this.ch = charAt(i11);
                } else if (charAt2 == 26) {
                    this.token = 20;
                    this.bp += length4 + 1;
                    this.ch = JSONLexer.EOI;
                } else {
                    this.matchStat = -1;
                    return stringDefaultValue();
                }
                this.matchStat = 4;
                return subString;
            } else {
                this.matchStat = -1;
                return stringDefaultValue();
            }
        } else {
            throw new JSONException("unclosed str");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00fc, code lost:
        if (r13 != ',') goto L_0x010d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00fe, code lost:
        r13 = r12.bp + r0;
        r12.bp = r13;
        r12.ch = charAt(r13);
        r12.matchStat = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x010c, code lost:
        return r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x010f, code lost:
        if (r13 != '}') goto L_0x0166;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0111, code lost:
        r6 = r0 + 1;
        r13 = charAt(r12.bp + r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x011a, code lost:
        if (r13 != ',') goto L_0x012c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x011c, code lost:
        r12.token = 16;
        r13 = r12.bp + r6;
        r12.bp = r13;
        r12.ch = charAt(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x012c, code lost:
        if (r13 != ']') goto L_0x013e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x012e, code lost:
        r12.token = 15;
        r13 = r12.bp + r6;
        r12.bp = r13;
        r12.ch = charAt(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x013e, code lost:
        if (r13 != '}') goto L_0x0150;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0140, code lost:
        r12.token = 13;
        r13 = r12.bp + r6;
        r12.bp = r13;
        r12.ch = charAt(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0152, code lost:
        if (r13 != 26) goto L_0x0163;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0154, code lost:
        r12.bp += r0;
        r12.token = 20;
        r12.ch = com.alibaba.fastjson.parser.JSONLexer.EOI;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x015f, code lost:
        r12.matchStat = 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0162, code lost:
        return r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0163, code lost:
        r12.matchStat = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0165, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0166, code lost:
        r12.matchStat = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0168, code lost:
        return null;
     */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0169  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.Collection<java.lang.String> scanFieldStringArray(char[] r13, java.lang.Class<?> r14) {
        /*
            r12 = this;
            r0 = 0
            r12.matchStat = r0
            boolean r1 = r12.charArrayCompare(r13)
            r2 = 0
            if (r1 != 0) goto L_0x000e
            r13 = -2
            r12.matchStat = r13
            return r2
        L_0x000e:
            java.util.Collection r14 = r12.newCollectionByType(r14)
            int r13 = r13.length
            int r1 = r12.bp
            int r3 = r13 + 1
            int r1 = r1 + r13
            char r1 = r12.charAt(r1)
            r4 = 91
            r5 = -1
            if (r1 == r4) goto L_0x0024
            r12.matchStat = r5
            return r2
        L_0x0024:
            int r1 = r12.bp
            int r13 = r13 + 2
            int r1 = r1 + r3
            char r1 = r12.charAt(r1)
        L_0x002d:
            r3 = 93
            r4 = 44
            r6 = 34
            if (r1 != r6) goto L_0x0095
            int r1 = r12.bp
            int r1 = r1 + r13
            int r1 = r12.indexOf(r6, r1)
            if (r1 == r5) goto L_0x008d
            int r7 = r12.bp
            int r7 = r7 + r13
            int r8 = r1 - r7
            java.lang.String r7 = r12.subString(r7, r8)
            r8 = 92
            int r9 = r7.indexOf(r8)
            if (r9 == r5) goto L_0x007a
        L_0x004f:
            int r7 = r1 + -1
            r9 = 0
        L_0x0052:
            if (r7 < 0) goto L_0x005f
            char r10 = r12.charAt(r7)
            if (r10 != r8) goto L_0x005f
            int r9 = r9 + 1
            int r7 = r7 + -1
            goto L_0x0052
        L_0x005f:
            int r9 = r9 % 2
            if (r9 != 0) goto L_0x0073
            int r6 = r12.bp
            int r7 = r6 + r13
            int r7 = r1 - r7
            int r6 = r6 + r13
            char[] r6 = r12.sub_chars(r6, r7)
            java.lang.String r7 = readString(r6, r7)
            goto L_0x007a
        L_0x0073:
            int r1 = r1 + 1
            int r1 = r12.indexOf(r6, r1)
            goto L_0x004f
        L_0x007a:
            int r6 = r12.bp
            int r8 = r6 + r13
            int r1 = r1 - r8
            int r1 = r1 + 1
            int r13 = r13 + r1
            int r1 = r13 + 1
            int r6 = r6 + r13
            char r13 = r12.charAt(r6)
            r14.add(r7)
            goto L_0x00cd
        L_0x008d:
            com.alibaba.fastjson.JSONException r13 = new com.alibaba.fastjson.JSONException
            java.lang.String r14 = "unclosed str"
            r13.<init>(r14)
            throw r13
        L_0x0095:
            r6 = 110(0x6e, float:1.54E-43)
            if (r1 != r6) goto L_0x00ea
            int r6 = r12.bp
            int r6 = r6 + r13
            char r6 = r12.charAt(r6)
            r7 = 117(0x75, float:1.64E-43)
            if (r6 != r7) goto L_0x00ea
            int r6 = r12.bp
            int r6 = r6 + r13
            int r6 = r6 + 1
            char r6 = r12.charAt(r6)
            r7 = 108(0x6c, float:1.51E-43)
            if (r6 != r7) goto L_0x00ea
            int r6 = r12.bp
            int r6 = r6 + r13
            int r6 = r6 + 2
            char r6 = r12.charAt(r6)
            if (r6 != r7) goto L_0x00ea
            int r1 = r13 + 3
            int r6 = r12.bp
            int r13 = r13 + 4
            int r6 = r6 + r1
            char r1 = r12.charAt(r6)
            r14.add(r2)
            r11 = r1
            r1 = r13
            r13 = r11
        L_0x00cd:
            if (r13 != r4) goto L_0x00db
            int r13 = r12.bp
            int r3 = r1 + 1
            int r13 = r13 + r1
            char r1 = r12.charAt(r13)
            r13 = r3
            goto L_0x002d
        L_0x00db:
            if (r13 != r3) goto L_0x00e7
            int r13 = r12.bp
            int r0 = r1 + 1
            int r13 = r13 + r1
            char r13 = r12.charAt(r13)
            goto L_0x00fc
        L_0x00e7:
            r12.matchStat = r5
            return r2
        L_0x00ea:
            if (r1 != r3) goto L_0x0169
            int r0 = r14.size()
            if (r0 != 0) goto L_0x0169
            int r0 = r12.bp
            int r1 = r13 + 1
            int r0 = r0 + r13
            char r13 = r12.charAt(r0)
            r0 = r1
        L_0x00fc:
            if (r13 != r4) goto L_0x010d
            int r13 = r12.bp
            int r13 = r13 + r0
            r12.bp = r13
            char r13 = r12.charAt(r13)
            r12.ch = r13
            r13 = 3
            r12.matchStat = r13
            return r14
        L_0x010d:
            r1 = 125(0x7d, float:1.75E-43)
            if (r13 != r1) goto L_0x0166
            int r13 = r12.bp
            int r6 = r0 + 1
            int r13 = r13 + r0
            char r13 = r12.charAt(r13)
            if (r13 != r4) goto L_0x012c
            r13 = 16
            r12.token = r13
            int r13 = r12.bp
            int r13 = r13 + r6
            r12.bp = r13
            char r13 = r12.charAt(r13)
            r12.ch = r13
            goto L_0x015f
        L_0x012c:
            if (r13 != r3) goto L_0x013e
            r13 = 15
            r12.token = r13
            int r13 = r12.bp
            int r13 = r13 + r6
            r12.bp = r13
            char r13 = r12.charAt(r13)
            r12.ch = r13
            goto L_0x015f
        L_0x013e:
            if (r13 != r1) goto L_0x0150
            r13 = 13
            r12.token = r13
            int r13 = r12.bp
            int r13 = r13 + r6
            r12.bp = r13
            char r13 = r12.charAt(r13)
            r12.ch = r13
            goto L_0x015f
        L_0x0150:
            r1 = 26
            if (r13 != r1) goto L_0x0163
            int r13 = r12.bp
            int r13 = r13 + r0
            r12.bp = r13
            r13 = 20
            r12.token = r13
            r12.ch = r1
        L_0x015f:
            r13 = 4
            r12.matchStat = r13
            return r14
        L_0x0163:
            r12.matchStat = r5
            return r2
        L_0x0166:
            r12.matchStat = r5
            return r2
        L_0x0169:
            com.alibaba.fastjson.JSONException r13 = new com.alibaba.fastjson.JSONException
            java.lang.String r14 = "illega str"
            r13.<init>(r14)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanFieldStringArray(char[], java.lang.Class):java.util.Collection");
    }

    public long scanFieldSymbol(char[] cArr) {
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return 0;
        }
        int length = cArr.length;
        int i = length + 1;
        if (charAt(this.bp + length) != '\"') {
            this.matchStat = -1;
            return 0;
        }
        long j = TypeUtils.fnv1a_64_magic_hashcode;
        while (true) {
            int i2 = i + 1;
            char charAt = charAt(this.bp + i);
            if (charAt == '\"') {
                int i3 = i + 2;
                char charAt2 = charAt(this.bp + i2);
                if (charAt2 == ',') {
                    int i4 = this.bp + i3;
                    this.bp = i4;
                    this.ch = charAt(i4);
                    this.matchStat = 3;
                    return j;
                } else if (charAt2 == '}') {
                    int i5 = i + 3;
                    char charAt3 = charAt(this.bp + i3);
                    if (charAt3 == ',') {
                        this.token = 16;
                        int i6 = this.bp + i5;
                        this.bp = i6;
                        this.ch = charAt(i6);
                    } else if (charAt3 == ']') {
                        this.token = 15;
                        int i7 = this.bp + i5;
                        this.bp = i7;
                        this.ch = charAt(i7);
                    } else if (charAt3 == '}') {
                        this.token = 13;
                        int i8 = this.bp + i5;
                        this.bp = i8;
                        this.ch = charAt(i8);
                    } else if (charAt3 == 26) {
                        this.token = 20;
                        this.bp += i + 2;
                        this.ch = JSONLexer.EOI;
                    } else {
                        this.matchStat = -1;
                        return 0;
                    }
                    this.matchStat = 4;
                    return j;
                } else {
                    this.matchStat = -1;
                    return 0;
                }
            } else {
                j = (j ^ ((long) charAt)) * TypeUtils.fnv1a_64_magic_prime;
                if (charAt == '\\') {
                    this.matchStat = -1;
                    return 0;
                }
                i = i2;
            }
        }
    }

    public UUID scanFieldUUID(char[] cArr) {
        char c;
        UUID uuid;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        char[] cArr2 = cArr;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return null;
        }
        int length = cArr2.length;
        int i9 = length + 1;
        char charAt = charAt(this.bp + length);
        char c2 = 4;
        if (charAt == '\"') {
            int indexOf = indexOf('\"', this.bp + cArr2.length + 1);
            if (indexOf != -1) {
                int length2 = this.bp + cArr2.length + 1;
                int i10 = indexOf - length2;
                char c3 = 'F';
                char c4 = 'A';
                char c5 = 'f';
                char c6 = 'a';
                char c7 = '9';
                if (i10 == 36) {
                    int i11 = 0;
                    long j = 0;
                    while (i11 < 8) {
                        char charAt2 = charAt(length2 + i11);
                        if (charAt2 >= '0' && charAt2 <= '9') {
                            i8 = charAt2 - '0';
                        } else if (charAt2 >= 'a' && charAt2 <= 'f') {
                            i8 = charAt2 - 'W';
                        } else if (charAt2 < 'A' || charAt2 > 'F') {
                            this.matchStat = -2;
                            return null;
                        } else {
                            i8 = charAt2 - '7';
                        }
                        j = (j << c2) | ((long) i8);
                        i11++;
                        c2 = 4;
                    }
                    for (int i12 = 9; i12 < 13; i12++) {
                        char charAt3 = charAt(length2 + i12);
                        if (charAt3 >= '0' && charAt3 <= '9') {
                            i7 = charAt3 - '0';
                        } else if (charAt3 >= 'a' && charAt3 <= 'f') {
                            i7 = charAt3 - 'W';
                        } else if (charAt3 < 'A' || charAt3 > 'F') {
                            this.matchStat = -2;
                            return null;
                        } else {
                            i7 = charAt3 - '7';
                        }
                        j = (j << 4) | ((long) i7);
                    }
                    int i13 = 14;
                    long j2 = j;
                    while (i13 < 18) {
                        char charAt4 = charAt(length2 + i13);
                        if (charAt4 >= '0' && charAt4 <= '9') {
                            i6 = charAt4 - '0';
                        } else if (charAt4 >= 'a' && charAt4 <= 'f') {
                            i6 = charAt4 - 'W';
                        } else if (charAt4 < 'A' || charAt4 > c3) {
                            this.matchStat = -2;
                            return null;
                        } else {
                            i6 = charAt4 - '7';
                        }
                        j2 = (j2 << 4) | ((long) i6);
                        i13++;
                        indexOf = indexOf;
                        c3 = 'F';
                    }
                    int i14 = indexOf;
                    int i15 = 19;
                    long j3 = 0;
                    while (i15 < 23) {
                        char charAt5 = charAt(length2 + i15);
                        if (charAt5 >= '0' && charAt5 <= '9') {
                            i5 = charAt5 - '0';
                        } else if (charAt5 >= 'a' && charAt5 <= c5) {
                            i5 = charAt5 - 'W';
                        } else if (charAt5 < c4 || charAt5 > 'F') {
                            this.matchStat = -2;
                            return null;
                        } else {
                            i5 = charAt5 - '7';
                        }
                        j3 = (j3 << 4) | ((long) i5);
                        i15++;
                        c4 = 'A';
                        c5 = 'f';
                    }
                    int i16 = 24;
                    long j4 = j3;
                    int i17 = 36;
                    while (i16 < i17) {
                        char charAt6 = charAt(length2 + i16);
                        if (charAt6 >= '0' && charAt6 <= c7) {
                            i4 = charAt6 - '0';
                        } else if (charAt6 >= c6 && charAt6 <= 'f') {
                            i4 = charAt6 - 'W';
                        } else if (charAt6 < 'A' || charAt6 > 'F') {
                            this.matchStat = -2;
                            return null;
                        } else {
                            i4 = charAt6 - '7';
                        }
                        j4 = (j4 << 4) | ((long) i4);
                        i16++;
                        i17 = 36;
                        c7 = '9';
                        c6 = 'a';
                    }
                    uuid = new UUID(j2, j4);
                    int i18 = this.bp;
                    int length3 = i9 + (i14 - ((cArr2.length + i18) + 1)) + 1;
                    i = length3 + 1;
                    c = charAt(i18 + length3);
                } else {
                    int i19 = indexOf;
                    if (i10 == 32) {
                        int i20 = 0;
                        long j5 = 0;
                        for (int i21 = 16; i20 < i21; i21 = 16) {
                            char charAt7 = charAt(length2 + i20);
                            if (charAt7 >= '0' && charAt7 <= '9') {
                                i3 = charAt7 - '0';
                            } else if (charAt7 >= 'a' && charAt7 <= 'f') {
                                i3 = charAt7 - 'W';
                            } else if (charAt7 < 'A' || charAt7 > 'F') {
                                this.matchStat = -2;
                                return null;
                            } else {
                                i3 = charAt7 - '7';
                            }
                            j5 = (j5 << 4) | ((long) i3);
                            i20++;
                        }
                        int i22 = 16;
                        long j6 = 0;
                        for (int i23 = 32; i22 < i23; i23 = 32) {
                            char charAt8 = charAt(length2 + i22);
                            if (charAt8 >= '0' && charAt8 <= '9') {
                                i2 = charAt8 - '0';
                            } else if (charAt8 >= 'a' && charAt8 <= 'f') {
                                i2 = charAt8 - 'W';
                            } else if (charAt8 < 'A' || charAt8 > 'F') {
                                this.matchStat = -2;
                                return null;
                            } else {
                                i2 = charAt8 - '7';
                                j6 = (j6 << 4) | ((long) i2);
                                i22++;
                            }
                            j6 = (j6 << 4) | ((long) i2);
                            i22++;
                        }
                        uuid = new UUID(j5, j6);
                        int i24 = this.bp;
                        int length4 = i9 + (i19 - ((cArr2.length + i24) + 1)) + 1;
                        i = length4 + 1;
                        c = charAt(i24 + length4);
                    } else {
                        this.matchStat = -1;
                        return null;
                    }
                }
            } else {
                throw new JSONException("unclosed str");
            }
        } else {
            if (charAt == 'n') {
                int i25 = length + 2;
                if (charAt(this.bp + i9) == 'u') {
                    int i26 = length + 3;
                    if (charAt(this.bp + i25) == 'l') {
                        int i27 = length + 4;
                        if (charAt(this.bp + i26) == 'l') {
                            int i28 = length + 5;
                            c = charAt(this.bp + i27);
                            i = i28;
                            uuid = null;
                        }
                    }
                }
            }
            this.matchStat = -1;
            return null;
        }
        if (c == ',') {
            int i29 = this.bp + i;
            this.bp = i29;
            this.ch = charAt(i29);
            this.matchStat = 3;
            return uuid;
        } else if (c == '}') {
            int i30 = i + 1;
            char charAt9 = charAt(this.bp + i);
            if (charAt9 == ',') {
                this.token = 16;
                int i31 = this.bp + i30;
                this.bp = i31;
                this.ch = charAt(i31);
            } else if (charAt9 == ']') {
                this.token = 15;
                int i32 = this.bp + i30;
                this.bp = i32;
                this.ch = charAt(i32);
            } else if (charAt9 == '}') {
                this.token = 13;
                int i33 = this.bp + i30;
                this.bp = i33;
                this.ch = charAt(i33);
            } else if (charAt9 == 26) {
                this.token = 20;
                this.bp += i;
                this.ch = JSONLexer.EOI;
            } else {
                this.matchStat = -1;
                return null;
            }
            this.matchStat = 4;
            return uuid;
        } else {
            this.matchStat = -1;
            return null;
        }
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public final float scanFloat(char r21) {
        /*
            r20 = this;
            r0 = r20
            r1 = 0
            r0.matchStat = r1
            int r2 = r0.bp
            char r2 = r0.charAt(r2)
            r3 = 1
            r4 = 34
            if (r2 != r4) goto L_0x0012
            r5 = 1
            goto L_0x0013
        L_0x0012:
            r5 = 0
        L_0x0013:
            r6 = 2
            if (r5 == 0) goto L_0x001f
            int r2 = r0.bp
            int r2 = r2 + r3
            char r2 = r0.charAt(r2)
            r7 = 2
            goto L_0x0020
        L_0x001f:
            r7 = 1
        L_0x0020:
            r8 = 45
            if (r2 != r8) goto L_0x0026
            r9 = 1
            goto L_0x0027
        L_0x0026:
            r9 = 0
        L_0x0027:
            if (r9 == 0) goto L_0x0033
            int r2 = r0.bp
            int r10 = r7 + 1
            int r2 = r2 + r7
            char r2 = r0.charAt(r2)
            r7 = r10
        L_0x0033:
            r10 = 16
            r11 = 0
            r12 = -1
            r13 = 48
            if (r2 < r13) goto L_0x0125
            r14 = 57
            if (r2 > r14) goto L_0x0125
            int r2 = r2 - r13
            long r1 = (long) r2
        L_0x0041:
            int r15 = r0.bp
            int r17 = r7 + 1
            int r15 = r15 + r7
            char r15 = r0.charAt(r15)
            r18 = 10
            if (r15 < r13) goto L_0x005c
            if (r15 > r14) goto L_0x005c
            long r1 = r1 * r18
            int r15 = r15 + -48
            long r3 = (long) r15
            long r1 = r1 + r3
            r7 = r17
            r3 = 1
            r4 = 34
            goto L_0x0041
        L_0x005c:
            r3 = 46
            if (r15 != r3) goto L_0x0090
            int r3 = r0.bp
            int r7 = r7 + r6
            int r3 = r3 + r17
            char r3 = r0.charAt(r3)
            if (r3 < r13) goto L_0x008d
            if (r3 > r14) goto L_0x008d
            long r1 = r1 * r18
            int r3 = r3 - r13
            long r3 = (long) r3
            long r1 = r1 + r3
            r3 = r18
        L_0x0074:
            int r15 = r0.bp
            int r17 = r7 + 1
            int r15 = r15 + r7
            char r15 = r0.charAt(r15)
            if (r15 < r13) goto L_0x0092
            if (r15 > r14) goto L_0x0092
            long r1 = r1 * r18
            int r15 = r15 + -48
            long r6 = (long) r15
            long r1 = r1 + r6
            long r3 = r3 * r18
            r7 = r17
            r6 = 2
            goto L_0x0074
        L_0x008d:
            r0.matchStat = r12
            return r11
        L_0x0090:
            r3 = 1
        L_0x0092:
            r6 = 101(0x65, float:1.42E-43)
            if (r15 == r6) goto L_0x009e
            r6 = 69
            if (r15 != r6) goto L_0x009b
            goto L_0x009e
        L_0x009b:
            r16 = 0
            goto L_0x00a0
        L_0x009e:
            r16 = 1
        L_0x00a0:
            if (r16 == 0) goto L_0x00d0
            int r6 = r0.bp
            int r7 = r17 + 1
            int r6 = r6 + r17
            char r6 = r0.charAt(r6)
            r15 = 43
            if (r6 == r15) goto L_0x00b7
            if (r6 != r8) goto L_0x00b3
            goto L_0x00b7
        L_0x00b3:
            r15 = r6
        L_0x00b4:
            r17 = r7
            goto L_0x00c1
        L_0x00b7:
            int r6 = r0.bp
            int r17 = r17 + 2
            int r6 = r6 + r7
            char r6 = r0.charAt(r6)
            r15 = r6
        L_0x00c1:
            if (r15 < r13) goto L_0x00d0
            if (r15 > r14) goto L_0x00d0
            int r6 = r0.bp
            int r7 = r17 + 1
            int r6 = r6 + r17
            char r15 = r0.charAt(r6)
            goto L_0x00b4
        L_0x00d0:
            if (r5 == 0) goto L_0x00ee
            r5 = 34
            if (r15 == r5) goto L_0x00d9
            r0.matchStat = r12
            return r11
        L_0x00d9:
            int r5 = r0.bp
            int r6 = r17 + 1
            int r5 = r5 + r17
            char r15 = r0.charAt(r5)
            int r5 = r0.bp
            int r7 = r5 + 1
            int r5 = r5 + r6
            int r5 = r5 - r7
            r8 = 2
            int r5 = r5 - r8
            r17 = r6
            goto L_0x00f5
        L_0x00ee:
            int r7 = r0.bp
            int r5 = r7 + r17
            int r5 = r5 - r7
            r6 = 1
            int r5 = r5 - r6
        L_0x00f5:
            if (r16 != 0) goto L_0x0105
            r6 = 17
            if (r5 >= r6) goto L_0x0105
            double r1 = (double) r1
            double r3 = (double) r3
            double r1 = r1 / r3
            float r1 = (float) r1
            if (r9 == 0) goto L_0x0102
            float r1 = -r1
        L_0x0102:
            r2 = r21
            goto L_0x010e
        L_0x0105:
            java.lang.String r1 = r0.subString(r7, r5)
            float r1 = java.lang.Float.parseFloat(r1)
            goto L_0x0102
        L_0x010e:
            if (r15 != r2) goto L_0x0122
            int r2 = r0.bp
            int r2 = r2 + r17
            r0.bp = r2
            char r2 = r0.charAt(r2)
            r0.ch = r2
            r2 = 3
            r0.matchStat = r2
            r0.token = r10
            return r1
        L_0x0122:
            r0.matchStat = r12
            return r1
        L_0x0125:
            r1 = 110(0x6e, float:1.54E-43)
            if (r2 != r1) goto L_0x01a7
            int r1 = r0.bp
            int r1 = r1 + r7
            char r1 = r0.charAt(r1)
            r2 = 117(0x75, float:1.64E-43)
            if (r1 != r2) goto L_0x01a7
            int r1 = r0.bp
            int r1 = r1 + r7
            r2 = 1
            int r1 = r1 + r2
            char r1 = r0.charAt(r1)
            r2 = 108(0x6c, float:1.51E-43)
            if (r1 != r2) goto L_0x01a7
            int r1 = r0.bp
            int r1 = r1 + r7
            r3 = 2
            int r1 = r1 + r3
            char r1 = r0.charAt(r1)
            if (r1 != r2) goto L_0x01a7
            r1 = 5
            r0.matchStat = r1
            int r2 = r7 + 3
            int r3 = r0.bp
            int r4 = r7 + 4
            int r3 = r3 + r2
            char r2 = r0.charAt(r3)
            if (r5 == 0) goto L_0x0169
            r3 = 34
            if (r2 != r3) goto L_0x0169
            int r2 = r0.bp
            int r7 = r7 + r1
            int r2 = r2 + r4
            char r2 = r0.charAt(r2)
            r4 = r7
        L_0x0169:
            r3 = 44
            if (r2 != r3) goto L_0x017d
            int r2 = r0.bp
            int r2 = r2 + r4
            r0.bp = r2
            char r2 = r0.charAt(r2)
            r0.ch = r2
            r0.matchStat = r1
            r0.token = r10
            return r11
        L_0x017d:
            r3 = 93
            if (r2 != r3) goto L_0x0193
            int r2 = r0.bp
            int r2 = r2 + r4
            r0.bp = r2
            char r2 = r0.charAt(r2)
            r0.ch = r2
            r0.matchStat = r1
            r1 = 15
            r0.token = r1
            return r11
        L_0x0193:
            boolean r2 = isWhitespace(r2)
            if (r2 == 0) goto L_0x01a4
            int r2 = r0.bp
            int r3 = r4 + 1
            int r2 = r2 + r4
            char r2 = r0.charAt(r2)
            r4 = r3
            goto L_0x0169
        L_0x01a4:
            r0.matchStat = r12
            return r11
        L_0x01a7:
            r0.matchStat = r12
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanFloat(char):float");
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x004d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void scanHex() {
        /*
            r5 = this;
            char r0 = r5.ch
            r1 = 120(0x78, float:1.68E-43)
            java.lang.String r2 = "illegal state. "
            if (r0 != r1) goto L_0x0079
            r5.next()
            char r0 = r5.ch
            r1 = 39
            if (r0 != r1) goto L_0x0062
            int r0 = r5.bp
            r5.np = r0
            r5.next()
            char r0 = r5.ch
            r3 = 26
            if (r0 != r1) goto L_0x0024
            r5.next()
            r5.token = r3
            return
        L_0x0024:
            char r0 = r5.next()
            r4 = 48
            if (r0 < r4) goto L_0x0030
            r4 = 57
            if (r0 <= r4) goto L_0x0038
        L_0x0030:
            r4 = 65
            if (r0 < r4) goto L_0x003f
            r4 = 70
            if (r0 > r4) goto L_0x003f
        L_0x0038:
            int r0 = r5.sp
            int r0 = r0 + 1
            r5.sp = r0
            goto L_0x0024
        L_0x003f:
            if (r0 != r1) goto L_0x004d
            int r0 = r5.sp
            int r0 = r0 + 1
            r5.sp = r0
            r5.next()
            r5.token = r3
            return
        L_0x004d:
            com.alibaba.fastjson.JSONException r1 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r2)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r1.<init>(r0)
            throw r1
        L_0x0062:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r2)
            char r2 = r5.ch
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0079:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r2)
            char r2 = r5.ch
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanHex():void");
    }

    public final void scanIdent() {
        this.np = this.bp - 1;
        this.hasSpecial = false;
        do {
            this.sp++;
            next();
        } while (Character.isLetterOrDigit(this.ch));
        String stringVal = stringVal();
        if ("null".equalsIgnoreCase(stringVal)) {
            this.token = 8;
        } else if ("new".equals(stringVal)) {
            this.token = 9;
        } else if ("true".equals(stringVal)) {
            this.token = 6;
        } else if ("false".equals(stringVal)) {
            this.token = 7;
        } else if ("undefined".equals(stringVal)) {
            this.token = 23;
        } else if ("Set".equals(stringVal)) {
            this.token = 21;
        } else if ("TreeSet".equals(stringVal)) {
            this.token = 22;
        } else {
            this.token = 18;
        }
    }

    public int scanInt(char c) {
        boolean z;
        int i;
        boolean z2;
        int i2;
        char charAt;
        this.matchStat = 0;
        char charAt2 = charAt(this.bp);
        if (charAt2 == '\"') {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            charAt2 = charAt(this.bp + 1);
            i = 2;
        } else {
            i = 1;
        }
        if (charAt2 == '-') {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            charAt2 = charAt(this.bp + i);
            i++;
        }
        if (charAt2 >= '0' && charAt2 <= '9') {
            int i3 = charAt2 - '0';
            while (true) {
                i2 = i + 1;
                charAt = charAt(this.bp + i);
                if (charAt >= '0' && charAt <= '9') {
                    i3 = (i3 * 10) + (charAt - '0');
                    i = i2;
                }
            }
            if (charAt == '.') {
                this.matchStat = -1;
                return 0;
            } else if (i3 < 0) {
                this.matchStat = -1;
                return 0;
            } else {
                while (charAt != c) {
                    if (isWhitespace(charAt)) {
                        i2++;
                        charAt = charAt(this.bp + i2);
                    } else {
                        this.matchStat = -1;
                        if (z2) {
                            return -i3;
                        }
                        return i3;
                    }
                }
                int i4 = this.bp + i2;
                this.bp = i4;
                this.ch = charAt(i4);
                this.matchStat = 3;
                this.token = 16;
                if (z2) {
                    return -i3;
                }
                return i3;
            }
        } else if (charAt2 == 'n' && charAt(this.bp + i) == 'u' && charAt(this.bp + i + 1) == 'l' && charAt(this.bp + i + 2) == 'l') {
            this.matchStat = 5;
            int i5 = i + 4;
            char charAt3 = charAt(this.bp + i + 3);
            if (z && charAt3 == '\"') {
                charAt3 = charAt(this.bp + i5);
                i5 = i + 5;
            }
            while (charAt3 != ',') {
                if (charAt3 == ']') {
                    int i6 = this.bp + i5;
                    this.bp = i6;
                    this.ch = charAt(i6);
                    this.matchStat = 5;
                    this.token = 15;
                    return 0;
                } else if (isWhitespace(charAt3)) {
                    charAt3 = charAt(this.bp + i5);
                    i5++;
                } else {
                    this.matchStat = -1;
                    return 0;
                }
            }
            int i7 = this.bp + i5;
            this.bp = i7;
            this.ch = charAt(i7);
            this.matchStat = 5;
            this.token = 16;
            return 0;
        } else {
            this.matchStat = -1;
            return 0;
        }
    }

    public long scanLong(char c) {
        boolean z;
        int i;
        int i2;
        char charAt;
        char c2;
        boolean z2 = false;
        this.matchStat = 0;
        char charAt2 = charAt(this.bp);
        if (charAt2 == '\"') {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            charAt2 = charAt(this.bp + 1);
            i = 2;
        } else {
            i = 1;
        }
        if (charAt2 == '-') {
            z2 = true;
        }
        if (z2) {
            charAt2 = charAt(this.bp + i);
            i++;
        }
        if (charAt2 >= '0') {
            char c3 = '9';
            if (charAt2 <= '9') {
                long j = (long) (charAt2 - '0');
                while (true) {
                    i2 = i + 1;
                    charAt = charAt(this.bp + i);
                    if (charAt >= '0' && charAt <= c3) {
                        j = (j * 10) + ((long) (charAt - '0'));
                        i = i2;
                        c3 = '9';
                    }
                }
                if (charAt == '.') {
                    this.matchStat = -1;
                    return 0;
                } else if (j >= 0 || (j == Long.MIN_VALUE && z2)) {
                    if (!z) {
                        c2 = c;
                    } else if (charAt != '\"') {
                        this.matchStat = -1;
                        return 0;
                    } else {
                        charAt = charAt(this.bp + i2);
                        c2 = c;
                        i2 = i + 2;
                    }
                    while (charAt != c2) {
                        if (isWhitespace(charAt)) {
                            charAt = charAt(this.bp + i2);
                            i2++;
                        } else {
                            this.matchStat = -1;
                            return j;
                        }
                    }
                    int i3 = this.bp + i2;
                    this.bp = i3;
                    this.ch = charAt(i3);
                    this.matchStat = 3;
                    this.token = 16;
                    if (z2) {
                        return -j;
                    }
                    return j;
                } else {
                    throw new NumberFormatException(subString(this.bp, i));
                }
            }
        }
        if (charAt2 == 'n' && charAt(this.bp + i) == 'u' && charAt(this.bp + i + 1) == 'l' && charAt(this.bp + i + 2) == 'l') {
            this.matchStat = 5;
            int i4 = i + 4;
            char charAt3 = charAt(this.bp + i + 3);
            if (z && charAt3 == '\"') {
                charAt3 = charAt(this.bp + i4);
                i4 = i + 5;
            }
            while (charAt3 != ',') {
                if (charAt3 == ']') {
                    int i5 = this.bp + i4;
                    this.bp = i5;
                    this.ch = charAt(i5);
                    this.matchStat = 5;
                    this.token = 15;
                    return 0;
                } else if (isWhitespace(charAt3)) {
                    charAt3 = charAt(this.bp + i4);
                    i4++;
                } else {
                    this.matchStat = -1;
                    return 0;
                }
            }
            int i6 = this.bp + i4;
            this.bp = i6;
            this.ch = charAt(i6);
            this.matchStat = 5;
            this.token = 16;
            return 0;
        }
        this.matchStat = -1;
        return 0;
    }

    public final void scanNullOrNew() {
        scanNullOrNew(true);
    }

    /* JADX WARNING: Removed duplicated region for block: B:50:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00c6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void scanNumber() {
        /*
            r10 = this;
            int r0 = r10.bp
            r10.np = r0
            char r0 = r10.ch
            r1 = 1
            r2 = 45
            if (r0 != r2) goto L_0x0013
            int r0 = r10.sp
            int r0 = r0 + r1
            r10.sp = r0
            r10.next()
        L_0x0013:
            char r0 = r10.ch
            r3 = 57
            r4 = 48
            if (r0 < r4) goto L_0x0026
            if (r0 > r3) goto L_0x0026
            int r0 = r10.sp
            int r0 = r0 + r1
            r10.sp = r0
            r10.next()
            goto L_0x0013
        L_0x0026:
            r5 = 46
            if (r0 != r5) goto L_0x0043
            int r0 = r10.sp
            int r0 = r0 + r1
            r10.sp = r0
            r10.next()
        L_0x0032:
            char r0 = r10.ch
            if (r0 < r4) goto L_0x0041
            if (r0 > r3) goto L_0x0041
            int r0 = r10.sp
            int r0 = r0 + r1
            r10.sp = r0
            r10.next()
            goto L_0x0032
        L_0x0041:
            r0 = 1
            goto L_0x0044
        L_0x0043:
            r0 = 0
        L_0x0044:
            int r5 = r10.sp
            r6 = 65535(0xffff, float:9.1834E-41)
            if (r5 > r6) goto L_0x00ca
            char r6 = r10.ch
            r7 = 76
            if (r6 != r7) goto L_0x0058
            int r5 = r5 + r1
            r10.sp = r5
            r10.next()
            goto L_0x008d
        L_0x0058:
            r7 = 83
            if (r6 != r7) goto L_0x0063
            int r5 = r5 + r1
            r10.sp = r5
            r10.next()
            goto L_0x008d
        L_0x0063:
            r7 = 66
            if (r6 != r7) goto L_0x006e
            int r5 = r5 + r1
            r10.sp = r5
            r10.next()
            goto L_0x008d
        L_0x006e:
            r7 = 70
            if (r6 != r7) goto L_0x0079
            int r5 = r5 + r1
            r10.sp = r5
            r10.next()
            goto L_0x00c0
        L_0x0079:
            r8 = 68
            if (r6 != r8) goto L_0x0084
            int r5 = r5 + r1
            r10.sp = r5
            r10.next()
            goto L_0x00c0
        L_0x0084:
            r9 = 101(0x65, float:1.42E-43)
            if (r6 == r9) goto L_0x008f
            r9 = 69
            if (r6 != r9) goto L_0x008d
            goto L_0x008f
        L_0x008d:
            r1 = r0
            goto L_0x00c0
        L_0x008f:
            int r5 = r5 + r1
            r10.sp = r5
            r10.next()
            char r0 = r10.ch
            r5 = 43
            if (r0 == r5) goto L_0x009d
            if (r0 != r2) goto L_0x00a5
        L_0x009d:
            int r0 = r10.sp
            int r0 = r0 + r1
            r10.sp = r0
            r10.next()
        L_0x00a5:
            char r0 = r10.ch
            if (r0 < r4) goto L_0x00b4
            if (r0 > r3) goto L_0x00b4
            int r0 = r10.sp
            int r0 = r0 + r1
            r10.sp = r0
            r10.next()
            goto L_0x00a5
        L_0x00b4:
            if (r0 == r8) goto L_0x00b8
            if (r0 != r7) goto L_0x00c0
        L_0x00b8:
            int r0 = r10.sp
            int r0 = r0 + r1
            r10.sp = r0
            r10.next()
        L_0x00c0:
            if (r1 == 0) goto L_0x00c6
            r0 = 3
            r10.token = r0
            goto L_0x00c9
        L_0x00c6:
            r0 = 2
            r10.token = r0
        L_0x00c9:
            return
        L_0x00ca:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
            java.lang.String r1 = "scanNumber overflow"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanNumber():void");
    }

    public final void scanString() {
        char next;
        char next2;
        this.np = this.bp;
        this.hasSpecial = false;
        while (true) {
            char next3 = next();
            if (next3 == '\"') {
                this.token = 4;
                this.ch = next();
                return;
            } else if (next3 == 26) {
                if (!isEOF()) {
                    putChar(JSONLexer.EOI);
                } else {
                    throw new JSONException("unclosed string : " + next3);
                }
            } else if (next3 == '\\') {
                if (!this.hasSpecial) {
                    this.hasSpecial = true;
                    int i = this.sp;
                    char[] cArr = this.sbuf;
                    if (i >= cArr.length) {
                        int length = cArr.length * 2;
                        if (i <= length) {
                            i = length;
                        }
                        char[] cArr2 = new char[i];
                        System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
                        this.sbuf = cArr2;
                    }
                    copyTo(this.np + 1, this.sp, this.sbuf);
                }
                char next4 = next();
                if (next4 == '\"') {
                    putChar('\"');
                } else if (next4 != '\'') {
                    if (next4 != 'F') {
                        if (next4 == '\\') {
                            putChar('\\');
                        } else if (next4 == 'b') {
                            putChar(8);
                        } else if (next4 != 'f') {
                            if (next4 == 'n') {
                                putChar(10);
                            } else if (next4 == 'r') {
                                putChar(13);
                            } else if (next4 != 'x') {
                                switch (next4) {
                                    case '/':
                                        putChar(IOUtils.DIR_SEPARATOR_UNIX);
                                        break;
                                    case '0':
                                        putChar(0);
                                        break;
                                    case '1':
                                        putChar(1);
                                        break;
                                    case '2':
                                        putChar(2);
                                        break;
                                    case '3':
                                        putChar(3);
                                        break;
                                    case '4':
                                        putChar(4);
                                        break;
                                    case '5':
                                        putChar(5);
                                        break;
                                    case '6':
                                        putChar(6);
                                        break;
                                    case '7':
                                        putChar(7);
                                        break;
                                    default:
                                        switch (next4) {
                                            case 't':
                                                putChar(9);
                                                break;
                                            case 'u':
                                                putChar((char) Integer.parseInt(new String(new char[]{next(), next(), next(), next()}), 16));
                                                break;
                                            case 'v':
                                                putChar(11);
                                                break;
                                            default:
                                                this.ch = next4;
                                                throw new JSONException("unclosed string : " + next4);
                                        }
                                }
                            } else {
                                next = next();
                                next2 = next();
                                boolean z = (next >= '0' && next <= '9') || (next >= 'a' && next <= 'f') || (next >= 'A' && next <= 'F');
                                boolean z2 = (next2 >= '0' && next2 <= '9') || (next2 >= 'a' && next2 <= 'f') || (next2 >= 'A' && next2 <= 'F');
                                if (!z || !z2) {
                                } else {
                                    int[] iArr = digits;
                                    putChar((char) ((iArr[next] * 16) + iArr[next2]));
                                }
                            }
                        }
                    }
                    putChar(12);
                } else {
                    putChar('\'');
                }
            } else if (!this.hasSpecial) {
                this.sp++;
            } else {
                int i2 = this.sp;
                char[] cArr3 = this.sbuf;
                if (i2 == cArr3.length) {
                    putChar(next3);
                } else {
                    this.sp = i2 + 1;
                    cArr3[i2] = next3;
                }
            }
        }
        throw new JSONException("invalid escape character \\x" + next + next2);
    }

    public void scanStringArray(Collection<String> collection, char c) {
        int i;
        char c2;
        int i2;
        char c3;
        Collection<String> collection2 = collection;
        char c4 = c;
        this.matchStat = 0;
        char charAt = charAt(this.bp);
        char c5 = 'u';
        char c6 = 'l';
        if (charAt == 'n' && charAt(this.bp + 1) == 'u' && charAt(this.bp + 2) == 'l' && charAt(this.bp + 3) == 'l' && charAt(this.bp + 4) == c4) {
            int i3 = this.bp + 5;
            this.bp = i3;
            this.ch = charAt(i3);
            this.matchStat = 5;
        } else if (charAt != '[') {
            this.matchStat = -1;
        } else {
            char charAt2 = charAt(this.bp + 1);
            int i4 = 2;
            while (true) {
                if (charAt2 != 'n' || charAt(this.bp + i4) != c5 || charAt(this.bp + i4 + 1) != c6 || charAt(this.bp + i4 + 2) != c6) {
                    if (charAt2 == ']' && collection.size() == 0) {
                        i = i4 + 1;
                        c2 = charAt(this.bp + i4);
                        break;
                    } else if (charAt2 != '\"') {
                        this.matchStat = -1;
                        return;
                    } else {
                        int i5 = this.bp + i4;
                        int indexOf = indexOf('\"', i5);
                        if (indexOf != -1) {
                            String subString = subString(this.bp + i4, indexOf - i5);
                            if (subString.indexOf(92) != -1) {
                                while (true) {
                                    int i6 = indexOf - 1;
                                    int i7 = 0;
                                    while (i6 >= 0 && charAt(i6) == '\\') {
                                        i7++;
                                        i6--;
                                    }
                                    if (i7 % 2 == 0) {
                                        break;
                                    }
                                    indexOf = indexOf('\"', indexOf + 1);
                                }
                                int i8 = indexOf - i5;
                                subString = readString(sub_chars(this.bp + i4, i8), i8);
                            }
                            int i9 = this.bp;
                            int i10 = i4 + (indexOf - (i9 + i4)) + 1;
                            c3 = charAt(i9 + i10);
                            collection2.add(subString);
                            i2 = i10 + 1;
                        } else {
                            throw new JSONException("unclosed str");
                        }
                    }
                } else {
                    int i11 = i4 + 3;
                    i2 = i4 + 4;
                    c3 = charAt(this.bp + i11);
                    collection2.add((Object) null);
                }
                if (c3 == ',') {
                    i4 = i2 + 1;
                    c5 = 'u';
                    c6 = 'l';
                    charAt2 = charAt(this.bp + i2);
                } else if (c3 == ']') {
                    i = i2 + 1;
                    c2 = charAt(this.bp + i2);
                } else {
                    this.matchStat = -1;
                    return;
                }
            }
            if (c2 == c4) {
                int i12 = this.bp + i;
                this.bp = i12;
                this.ch = charAt(i12);
                this.matchStat = 3;
                return;
            }
            this.matchStat = -1;
        }
    }

    public final String scanSymbol(SymbolTable symbolTable) {
        skipWhitespace();
        char c = this.ch;
        if (c == '\"') {
            return scanSymbol(symbolTable, '\"');
        }
        if (c == '\'') {
            if (isEnabled(Feature.AllowSingleQuotes)) {
                return scanSymbol(symbolTable, '\'');
            }
            throw new JSONException("syntax error");
        } else if (c == '}') {
            next();
            this.token = 13;
            return null;
        } else if (c == ',') {
            next();
            this.token = 16;
            return null;
        } else if (c == 26) {
            this.token = 20;
            return null;
        } else if (isEnabled(Feature.AllowUnQuotedFieldNames)) {
            return scanSymbolUnQuoted(symbolTable);
        } else {
            throw new JSONException("syntax error");
        }
    }

    public final String scanSymbolUnQuoted(SymbolTable symbolTable) {
        if (this.token == 1 && this.pos == 0 && this.bp == 1) {
            this.bp = 0;
        }
        boolean[] zArr = com.alibaba.fastjson.util.IOUtils.firstIdentifierFlags;
        int i = this.ch;
        if (i >= zArr.length || zArr[i]) {
            boolean[] zArr2 = com.alibaba.fastjson.util.IOUtils.identifierFlags;
            this.np = this.bp;
            this.sp = 1;
            while (true) {
                char next = next();
                if (next < zArr2.length && !zArr2[next]) {
                    break;
                }
                i = (i * 31) + next;
                this.sp++;
            }
            this.ch = charAt(this.bp);
            this.token = 18;
            if (this.sp == 4 && i == 3392903 && charAt(this.np) == 'n' && charAt(this.np + 1) == 'u' && charAt(this.np + 2) == 'l' && charAt(this.np + 3) == 'l') {
                return null;
            }
            if (symbolTable == null) {
                return subString(this.np, this.sp);
            }
            return addSymbol(this.np, this.sp, i, symbolTable);
        }
        throw new JSONException("illegal identifier : " + this.ch + info());
    }

    public String scanSymbolWithSeperator(SymbolTable symbolTable, char c) {
        int i = 0;
        this.matchStat = 0;
        char charAt = charAt(this.bp);
        if (charAt == 'n') {
            if (charAt(this.bp + 1) != 'u' || charAt(this.bp + 2) != 'l' || charAt(this.bp + 3) != 'l') {
                this.matchStat = -1;
                return null;
            } else if (charAt(this.bp + 4) == c) {
                int i2 = this.bp + 5;
                this.bp = i2;
                this.ch = charAt(i2);
                this.matchStat = 3;
                return null;
            } else {
                this.matchStat = -1;
                return null;
            }
        } else if (charAt != '\"') {
            this.matchStat = -1;
            return null;
        } else {
            int i3 = 1;
            while (true) {
                int i4 = i3 + 1;
                char charAt2 = charAt(this.bp + i3);
                if (charAt2 == '\"') {
                    int i5 = this.bp;
                    int i6 = i5 + 1;
                    String addSymbol = addSymbol(i6, ((i5 + i4) - i6) - 1, i, symbolTable);
                    int i7 = i3 + 2;
                    char charAt3 = charAt(this.bp + i4);
                    while (charAt3 != c) {
                        if (isWhitespace(charAt3)) {
                            charAt3 = charAt(this.bp + i7);
                            i7++;
                        } else {
                            this.matchStat = -1;
                            return addSymbol;
                        }
                    }
                    int i8 = this.bp + i7;
                    this.bp = i8;
                    this.ch = charAt(i8);
                    this.matchStat = 3;
                    return addSymbol;
                }
                i = (i * 31) + charAt2;
                if (charAt2 == '\\') {
                    this.matchStat = -1;
                    return null;
                }
                i3 = i4;
            }
        }
    }

    public final void scanTrue() {
        if (this.ch == 't') {
            next();
            if (this.ch == 'r') {
                next();
                if (this.ch == 'u') {
                    next();
                    if (this.ch == 'e') {
                        next();
                        char c = this.ch;
                        if (c == ' ' || c == ',' || c == '}' || c == ']' || c == 10 || c == 13 || c == 9 || c == 26 || c == 12 || c == 8 || c == ':' || c == '/') {
                            this.token = 6;
                            return;
                        }
                        throw new JSONException("scan true error");
                    }
                    throw new JSONException("error parse true");
                }
                throw new JSONException("error parse true");
            }
            throw new JSONException("error parse true");
        }
        throw new JSONException("error parse true");
    }

    public final int scanType(String str) {
        int i;
        this.matchStat = 0;
        char[] cArr = typeFieldName;
        if (!charArrayCompare(cArr)) {
            return -2;
        }
        int length = this.bp + cArr.length;
        int length2 = str.length();
        for (int i2 = 0; i2 < length2; i2++) {
            if (str.charAt(i2) != charAt(length + i2)) {
                return -1;
            }
        }
        int i3 = length + length2;
        if (charAt(i3) != '\"') {
            return -1;
        }
        int i4 = i3 + 1;
        char charAt = charAt(i4);
        this.ch = charAt;
        if (charAt == ',') {
            int i5 = i3 + 2;
            this.ch = charAt(i5);
            this.bp = i5;
            this.token = 16;
            return 3;
        }
        if (charAt == '}') {
            i4 = i3 + 2;
            char charAt2 = charAt(i4);
            this.ch = charAt2;
            if (charAt2 == ',') {
                this.token = 16;
                i = i3 + 3;
                this.ch = charAt(i);
            } else if (charAt2 == ']') {
                this.token = 15;
                i = i3 + 3;
                this.ch = charAt(i);
            } else if (charAt2 == '}') {
                this.token = 13;
                i = i3 + 3;
                this.ch = charAt(i);
            } else if (charAt2 != 26) {
                return -1;
            } else {
                this.token = 20;
                this.matchStat = 4;
            }
            i4 = i;
            this.matchStat = 4;
        }
        this.bp = i4;
        return this.matchStat;
    }

    public String scanTypeName(SymbolTable symbolTable) {
        return null;
    }

    public UUID scanUUID(char c) {
        int i;
        char c2;
        UUID uuid;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        this.matchStat = 0;
        char charAt = charAt(this.bp);
        if (charAt == '\"') {
            int indexOf = indexOf('\"', this.bp + 1);
            if (indexOf != -1) {
                int i9 = this.bp + 1;
                int i10 = indexOf - i9;
                char c3 = 'A';
                char c4 = 'f';
                char c5 = 'a';
                char c6 = '9';
                if (i10 == 36) {
                    int i11 = 0;
                    long j = 0;
                    while (i11 < 8) {
                        char charAt2 = charAt(i9 + i11);
                        if (charAt2 >= '0' && charAt2 <= '9') {
                            i8 = charAt2 - '0';
                        } else if (charAt2 >= 'a' && charAt2 <= 'f') {
                            i8 = charAt2 - 'W';
                        } else if (charAt2 < c3 || charAt2 > 'F') {
                            this.matchStat = -2;
                            return null;
                        } else {
                            i8 = charAt2 - '7';
                        }
                        j = (j << 4) | ((long) i8);
                        i11++;
                        indexOf = indexOf;
                        c3 = 'A';
                    }
                    int i12 = indexOf;
                    int i13 = 9;
                    while (i13 < 13) {
                        char charAt3 = charAt(i9 + i13);
                        if (charAt3 >= '0' && charAt3 <= '9') {
                            i7 = charAt3 - '0';
                        } else if (charAt3 >= 'a' && charAt3 <= c4) {
                            i7 = charAt3 - 'W';
                        } else if (charAt3 < 'A' || charAt3 > 'F') {
                            this.matchStat = -2;
                            return null;
                        } else {
                            i7 = charAt3 - '7';
                        }
                        j = (j << 4) | ((long) i7);
                        i13++;
                        c4 = 'f';
                    }
                    int i14 = 14;
                    long j2 = j;
                    while (i14 < 18) {
                        char charAt4 = charAt(i9 + i14);
                        if (charAt4 >= '0' && charAt4 <= c6) {
                            i6 = charAt4 - '0';
                        } else if (charAt4 >= 'a' && charAt4 <= 'f') {
                            i6 = charAt4 - 'W';
                        } else if (charAt4 < 'A' || charAt4 > 'F') {
                            this.matchStat = -2;
                            return null;
                        } else {
                            i6 = charAt4 - '7';
                        }
                        j2 = (j2 << 4) | ((long) i6);
                        i14++;
                        c6 = '9';
                    }
                    int i15 = 19;
                    long j3 = 0;
                    while (i15 < 23) {
                        char charAt5 = charAt(i9 + i15);
                        if (charAt5 >= '0' && charAt5 <= '9') {
                            i5 = charAt5 - '0';
                        } else if (charAt5 >= c5 && charAt5 <= 'f') {
                            i5 = charAt5 - 'W';
                        } else if (charAt5 < 'A' || charAt5 > 'F') {
                            this.matchStat = -2;
                            return null;
                        } else {
                            i5 = charAt5 - '7';
                        }
                        j3 = (j3 << 4) | ((long) i5);
                        i15++;
                        c5 = 'a';
                    }
                    long j4 = j3;
                    for (int i16 = 24; i16 < 36; i16++) {
                        char charAt6 = charAt(i9 + i16);
                        if (charAt6 >= '0' && charAt6 <= '9') {
                            i4 = charAt6 - '0';
                        } else if (charAt6 >= 'a' && charAt6 <= 'f') {
                            i4 = charAt6 - 'W';
                        } else if (charAt6 < 'A' || charAt6 > 'F') {
                            this.matchStat = -2;
                            return null;
                        } else {
                            i4 = charAt6 - '7';
                        }
                        j4 = (j4 << 4) | ((long) i4);
                    }
                    uuid = new UUID(j2, j4);
                    int i17 = this.bp;
                    int i18 = i12 - (i17 + 1);
                    int i19 = i18 + 2;
                    i = i18 + 3;
                    c2 = charAt(i17 + i19);
                } else {
                    int i20 = indexOf;
                    if (i10 == 32) {
                        int i21 = 0;
                        long j5 = 0;
                        for (int i22 = 16; i21 < i22; i22 = 16) {
                            char charAt7 = charAt(i9 + i21);
                            if (charAt7 >= '0' && charAt7 <= '9') {
                                i3 = charAt7 - '0';
                            } else if (charAt7 >= 'a' && charAt7 <= 'f') {
                                i3 = charAt7 - 'W';
                            } else if (charAt7 < 'A' || charAt7 > 'F') {
                                this.matchStat = -2;
                                return null;
                            } else {
                                i3 = charAt7 - '7';
                            }
                            j5 = (j5 << 4) | ((long) i3);
                            i21++;
                        }
                        int i23 = 16;
                        long j6 = 0;
                        for (int i24 = 32; i23 < i24; i24 = 32) {
                            char charAt8 = charAt(i9 + i23);
                            if (charAt8 >= '0' && charAt8 <= '9') {
                                i2 = charAt8 - '0';
                            } else if (charAt8 >= 'a' && charAt8 <= 'f') {
                                i2 = charAt8 - 'W';
                            } else if (charAt8 < 'A' || charAt8 > 'F') {
                                this.matchStat = -2;
                                return null;
                            } else {
                                i2 = charAt8 - '7';
                                j6 = (j6 << 4) | ((long) i2);
                                i23++;
                            }
                            j6 = (j6 << 4) | ((long) i2);
                            i23++;
                        }
                        uuid = new UUID(j5, j6);
                        int i25 = this.bp;
                        int i26 = i20 - (i25 + 1);
                        int i27 = i26 + 2;
                        i = i26 + 3;
                        c2 = charAt(i25 + i27);
                    } else {
                        this.matchStat = -1;
                        return null;
                    }
                }
            } else {
                throw new JSONException("unclosed str");
            }
        } else if (charAt == 'n' && charAt(this.bp + 1) == 'u' && charAt(this.bp + 2) == 'l' && charAt(this.bp + 3) == 'l') {
            c2 = charAt(this.bp + 4);
            i = 5;
            uuid = null;
        } else {
            this.matchStat = -1;
            return null;
        }
        if (c2 == ',') {
            int i28 = this.bp + i;
            this.bp = i28;
            this.ch = charAt(i28);
            this.matchStat = 3;
            return uuid;
        } else if (c2 == ']') {
            int i29 = i + 1;
            char charAt9 = charAt(this.bp + i);
            if (charAt9 == ',') {
                this.token = 16;
                int i30 = this.bp + i29;
                this.bp = i30;
                this.ch = charAt(i30);
            } else if (charAt9 == ']') {
                this.token = 15;
                int i31 = this.bp + i29;
                this.bp = i31;
                this.ch = charAt(i31);
            } else if (charAt9 == '}') {
                this.token = 13;
                int i32 = this.bp + i29;
                this.bp = i32;
                this.ch = charAt(i32);
            } else if (charAt9 == 26) {
                this.token = 20;
                this.bp += i;
                this.ch = JSONLexer.EOI;
            } else {
                this.matchStat = -1;
                return null;
            }
            this.matchStat = 4;
            return uuid;
        } else {
            this.matchStat = -1;
            return null;
        }
    }

    public boolean seekArrayToItem(int i) {
        throw new UnsupportedOperationException();
    }

    public int seekObjectToField(long j, boolean z) {
        throw new UnsupportedOperationException();
    }

    public int seekObjectToFieldDeepScan(long j) {
        throw new UnsupportedOperationException();
    }

    public void setFeatures(int i) {
        this.features = i;
    }

    public void setLocale(Locale locale2) {
        this.locale = locale2;
    }

    public void setTimeZone(TimeZone timeZone2) {
        this.timeZone = timeZone2;
    }

    public void setToken(int i) {
        this.token = i;
    }

    public void skipArray() {
        throw new UnsupportedOperationException();
    }

    public void skipComment() {
        char c;
        next();
        char c2 = this.ch;
        if (c2 == '/') {
            do {
                next();
                c = this.ch;
                if (c == 10) {
                    next();
                    return;
                }
            } while (c != 26);
        } else if (c2 == '*') {
            next();
            while (true) {
                char c3 = this.ch;
                if (c3 == 26) {
                    return;
                }
                if (c3 == '*') {
                    next();
                    if (this.ch == '/') {
                        next();
                        return;
                    }
                } else {
                    next();
                }
            }
        } else {
            throw new JSONException("invalid comment");
        }
    }

    public void skipObject() {
        throw new UnsupportedOperationException();
    }

    public final void skipWhitespace() {
        while (true) {
            char c = this.ch;
            if (c > '/') {
                return;
            }
            if (c == ' ' || c == 13 || c == 10 || c == 9 || c == 12 || c == 8) {
                next();
            } else if (c == '/') {
                skipComment();
            } else {
                return;
            }
        }
    }

    public final String stringDefaultValue() {
        return this.stringDefaultValue;
    }

    public abstract String stringVal();

    public abstract String subString(int i, int i2);

    public abstract char[] sub_chars(int i, int i2);

    public final int token() {
        return this.token;
    }

    public final String tokenName() {
        return JSONToken.name(this.token);
    }

    public final boolean isEnabled(int i) {
        return (i & this.features) != 0;
    }

    public final void nextTokenWithColon(int i) {
        nextTokenWithChar(':');
    }

    public final void scanNullOrNew(boolean z) {
        if (this.ch == 'n') {
            next();
            char c = this.ch;
            if (c == 'u') {
                next();
                if (this.ch == 'l') {
                    next();
                    if (this.ch == 'l') {
                        next();
                        char c2 = this.ch;
                        if (c2 == ' ' || c2 == ',' || c2 == '}' || c2 == ']' || c2 == 10 || c2 == 13 || c2 == 9 || c2 == 26 || ((c2 == ':' && z) || c2 == 12 || c2 == 8)) {
                            this.token = 8;
                            return;
                        }
                        throw new JSONException("scan null error");
                    }
                    throw new JSONException("error parse null");
                }
                throw new JSONException("error parse null");
            } else if (c == 'e') {
                next();
                if (this.ch == 'w') {
                    next();
                    char c3 = this.ch;
                    if (c3 == ' ' || c3 == ',' || c3 == '}' || c3 == ']' || c3 == 10 || c3 == 13 || c3 == 9 || c3 == 26 || c3 == 12 || c3 == 8) {
                        this.token = 9;
                        return;
                    }
                    throw new JSONException("scan new error");
                }
                throw new JSONException("error parse new");
            } else {
                throw new JSONException("error parse new");
            }
        } else {
            throw new JSONException("error parse null or new");
        }
    }

    public int seekObjectToField(long[] jArr) {
        throw new UnsupportedOperationException();
    }

    public void skipObject(boolean z) {
        throw new UnsupportedOperationException();
    }

    public final boolean isEnabled(int i, int i2) {
        return ((this.features & i2) == 0 && (i & i2) == 0) ? false : true;
    }

    public int matchField(long j) {
        throw new UnsupportedOperationException();
    }

    public final String scanSymbol(SymbolTable symbolTable, char c) {
        String str;
        SymbolTable symbolTable2 = symbolTable;
        this.np = this.bp;
        this.sp = 0;
        boolean z = false;
        int i = 0;
        while (true) {
            char next = next();
            if (next == c) {
                this.token = 4;
                if (!z) {
                    int i2 = this.np;
                    str = addSymbol(i2 == -1 ? 0 : i2 + 1, this.sp, i, symbolTable2);
                } else {
                    str = symbolTable2.addSymbol(this.sbuf, 0, this.sp, i);
                }
                this.sp = 0;
                next();
                return str;
            } else if (next == 26) {
                throw new JSONException("unclosed.str");
            } else if (next == '\\') {
                if (!z) {
                    int i3 = this.sp;
                    char[] cArr = this.sbuf;
                    if (i3 >= cArr.length) {
                        int length = cArr.length * 2;
                        if (i3 <= length) {
                            i3 = length;
                        }
                        char[] cArr2 = new char[i3];
                        System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
                        this.sbuf = cArr2;
                    }
                    arrayCopy(this.np + 1, this.sbuf, 0, this.sp);
                    z = true;
                }
                char next2 = next();
                if (next2 == '\"') {
                    i = (i * 31) + 34;
                    putChar('\"');
                } else if (next2 != '\'') {
                    if (next2 != 'F') {
                        if (next2 == '\\') {
                            i = (i * 31) + 92;
                            putChar('\\');
                        } else if (next2 == 'b') {
                            i = (i * 31) + 8;
                            putChar(8);
                        } else if (next2 != 'f') {
                            if (next2 == 'n') {
                                i = (i * 31) + 10;
                                putChar(10);
                            } else if (next2 == 'r') {
                                i = (i * 31) + 13;
                                putChar(13);
                            } else if (next2 != 'x') {
                                switch (next2) {
                                    case '/':
                                        i = (i * 31) + 47;
                                        putChar(IOUtils.DIR_SEPARATOR_UNIX);
                                        break;
                                    case '0':
                                        i = (i * 31) + next2;
                                        putChar(0);
                                        break;
                                    case '1':
                                        i = (i * 31) + next2;
                                        putChar(1);
                                        break;
                                    case '2':
                                        i = (i * 31) + next2;
                                        putChar(2);
                                        break;
                                    case '3':
                                        i = (i * 31) + next2;
                                        putChar(3);
                                        break;
                                    case '4':
                                        i = (i * 31) + next2;
                                        putChar(4);
                                        break;
                                    case '5':
                                        i = (i * 31) + next2;
                                        putChar(5);
                                        break;
                                    case '6':
                                        i = (i * 31) + next2;
                                        putChar(6);
                                        break;
                                    case '7':
                                        i = (i * 31) + next2;
                                        putChar(7);
                                        break;
                                    default:
                                        switch (next2) {
                                            case 't':
                                                i = (i * 31) + 9;
                                                putChar(9);
                                                break;
                                            case 'u':
                                                int parseInt = Integer.parseInt(new String(new char[]{next(), next(), next(), next()}), 16);
                                                i = (i * 31) + parseInt;
                                                putChar((char) parseInt);
                                                break;
                                            case 'v':
                                                i = (i * 31) + 11;
                                                putChar(11);
                                                break;
                                            default:
                                                this.ch = next2;
                                                throw new JSONException("unclosed.str.lit");
                                        }
                                }
                            } else {
                                char next3 = next();
                                this.ch = next3;
                                char next4 = next();
                                this.ch = next4;
                                int[] iArr = digits;
                                char c2 = (char) ((iArr[next3] * 16) + iArr[next4]);
                                i = (i * 31) + c2;
                                putChar(c2);
                            }
                        }
                    }
                    i = (i * 31) + 12;
                    putChar(12);
                } else {
                    i = (i * 31) + 39;
                    putChar('\'');
                }
            } else {
                i = (i * 31) + next;
                if (!z) {
                    this.sp++;
                } else {
                    int i4 = this.sp;
                    char[] cArr3 = this.sbuf;
                    if (i4 == cArr3.length) {
                        putChar(next);
                    } else {
                        this.sp = i4 + 1;
                        cArr3[i4] = next;
                    }
                }
            }
        }
    }

    public final void nextToken(int i) {
        this.sp = 0;
        while (true) {
            if (i == 2) {
                char c = this.ch;
                if (c >= '0' && c <= '9') {
                    this.pos = this.bp;
                    scanNumber();
                    return;
                } else if (c == '\"') {
                    this.pos = this.bp;
                    scanString();
                    return;
                } else if (c == '[') {
                    this.token = 14;
                    next();
                    return;
                } else if (c == '{') {
                    this.token = 12;
                    next();
                    return;
                }
            } else if (i == 4) {
                char c2 = this.ch;
                if (c2 == '\"') {
                    this.pos = this.bp;
                    scanString();
                    return;
                } else if (c2 >= '0' && c2 <= '9') {
                    this.pos = this.bp;
                    scanNumber();
                    return;
                } else if (c2 == '[') {
                    this.token = 14;
                    next();
                    return;
                } else if (c2 == '{') {
                    this.token = 12;
                    next();
                    return;
                }
            } else if (i == 12) {
                char c3 = this.ch;
                if (c3 == '{') {
                    this.token = 12;
                    next();
                    return;
                } else if (c3 == '[') {
                    this.token = 14;
                    next();
                    return;
                }
            } else if (i != 18) {
                if (i != 20) {
                    switch (i) {
                        case 14:
                            char c4 = this.ch;
                            if (c4 == '[') {
                                this.token = 14;
                                next();
                                return;
                            } else if (c4 == '{') {
                                this.token = 12;
                                next();
                                return;
                            }
                            break;
                        case 15:
                            if (this.ch == ']') {
                                this.token = 15;
                                next();
                                return;
                            }
                            break;
                        case 16:
                            char c5 = this.ch;
                            if (c5 == ',') {
                                this.token = 16;
                                next();
                                return;
                            } else if (c5 == '}') {
                                this.token = 13;
                                next();
                                return;
                            } else if (c5 == ']') {
                                this.token = 15;
                                next();
                                return;
                            } else if (c5 == 26) {
                                this.token = 20;
                                return;
                            } else if (c5 == 'n') {
                                scanNullOrNew(false);
                                return;
                            }
                            break;
                    }
                }
                if (this.ch == 26) {
                    this.token = 20;
                    return;
                }
            } else {
                nextIdent();
                return;
            }
            char c6 = this.ch;
            if (c6 == ' ' || c6 == 10 || c6 == 13 || c6 == 9 || c6 == 12 || c6 == 8) {
                next();
            } else {
                nextToken();
                return;
            }
        }
    }

    public String[] scanFieldStringArray(char[] cArr, int i, SymbolTable symbolTable) {
        throw new UnsupportedOperationException();
    }

    public String scanString(char c) {
        this.matchStat = 0;
        char charAt = charAt(this.bp);
        if (charAt != 'n') {
            int i = 1;
            while (charAt != '\"') {
                if (isWhitespace(charAt)) {
                    charAt = charAt(this.bp + i);
                    i++;
                } else {
                    this.matchStat = -1;
                    return stringDefaultValue();
                }
            }
            int i2 = this.bp + i;
            int indexOf = indexOf('\"', i2);
            if (indexOf != -1) {
                String subString = subString(this.bp + i, indexOf - i2);
                if (subString.indexOf(92) != -1) {
                    while (true) {
                        int i3 = indexOf - 1;
                        int i4 = 0;
                        while (i3 >= 0 && charAt(i3) == '\\') {
                            i4++;
                            i3--;
                        }
                        if (i4 % 2 == 0) {
                            break;
                        }
                        indexOf = indexOf('\"', indexOf + 1);
                    }
                    int i5 = indexOf - i2;
                    subString = readString(sub_chars(this.bp + 1, i5), i5);
                }
                int i6 = i + (indexOf - i2) + 1;
                int i7 = i6 + 1;
                char charAt2 = charAt(this.bp + i6);
                while (charAt2 != c) {
                    if (isWhitespace(charAt2)) {
                        charAt2 = charAt(this.bp + i7);
                        i7++;
                    } else {
                        if (charAt2 == ']') {
                            int i8 = this.bp + i7;
                            this.bp = i8;
                            this.ch = charAt(i8);
                            this.matchStat = -1;
                        }
                        return subString;
                    }
                }
                int i9 = this.bp + i7;
                this.bp = i9;
                this.ch = charAt(i9);
                this.matchStat = 3;
                this.token = 16;
                return subString;
            }
            throw new JSONException("unclosed str");
        } else if (charAt(this.bp + 1) != 'u' || charAt(this.bp + 2) != 'l' || charAt(this.bp + 3) != 'l') {
            this.matchStat = -1;
            return null;
        } else if (charAt(this.bp + 4) == c) {
            int i10 = this.bp + 5;
            this.bp = i10;
            this.ch = charAt(i10);
            this.matchStat = 3;
            return null;
        } else {
            this.matchStat = -1;
            return null;
        }
    }
}
