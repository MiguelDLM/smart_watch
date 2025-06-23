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
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Locale;
import java.util.TimeZone;
import java.util.UUID;

/* loaded from: classes.dex */
public abstract class JSONLexerBase implements JSONLexer, Closeable {
    protected static final int INT_MULTMIN_RADIX_TEN = -214748364;
    protected static final long MULTMIN_RADIX_TEN = -922337203685477580L;
    protected int bp;
    protected char ch;
    protected int eofPos;
    protected int features;
    protected boolean hasSpecial;
    protected int np;
    protected int pos;
    protected char[] sbuf;
    protected int sp;
    protected String stringDefaultValue;
    protected int token;
    private static final ThreadLocal<char[]> SBUF_LOCAL = new ThreadLocal<>();
    protected static final char[] typeFieldName = ("\"" + JSON.DEFAULT_TYPE_KEY + "\":\"").toCharArray();
    protected static final int[] digits = new int[103];
    protected Calendar calendar = null;
    protected TimeZone timeZone = JSON.defaultTimeZone;
    protected Locale locale = JSON.defaultLocale;
    public int matchStat = 0;
    protected int nanos = 0;

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
        this.stringDefaultValue = null;
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
        return c <= ' ' && (c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == '\f' || c == '\b');
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:26:0x0044. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:27:0x0047. Please report as an issue. */
    public static String readString(char[] cArr, int i) {
        int i2;
        int i3;
        int i4 = 5;
        char[] cArr2 = new char[i];
        int i5 = 0;
        int i6 = 0;
        while (i5 < i) {
            char c = cArr[i5];
            if (c != '\\') {
                cArr2[i6] = c;
                i6++;
            } else {
                int i7 = i5 + 1;
                char c2 = cArr[i7];
                if (c2 != '\"') {
                    if (c2 != '\'') {
                        if (c2 != 'F') {
                            if (c2 != '\\') {
                                if (c2 != 'b') {
                                    if (c2 != 'f') {
                                        if (c2 != 'n') {
                                            if (c2 != 'r') {
                                                if (c2 != 'x') {
                                                    switch (c2) {
                                                        case '/':
                                                            i2 = i6 + 1;
                                                            cArr2[i6] = IOUtils.DIR_SEPARATOR_UNIX;
                                                            break;
                                                        case '0':
                                                            i2 = i6 + 1;
                                                            cArr2[i6] = 0;
                                                            break;
                                                        case '1':
                                                            i2 = i6 + 1;
                                                            cArr2[i6] = 1;
                                                            break;
                                                        case '2':
                                                            i2 = i6 + 1;
                                                            cArr2[i6] = 2;
                                                            break;
                                                        case '3':
                                                            i2 = i6 + 1;
                                                            cArr2[i6] = 3;
                                                            break;
                                                        case '4':
                                                            i2 = i6 + 1;
                                                            cArr2[i6] = 4;
                                                            break;
                                                        case '5':
                                                            i2 = i6 + 1;
                                                            cArr2[i6] = 5;
                                                            break;
                                                        case '6':
                                                            i3 = i6 + 1;
                                                            cArr2[i6] = 6;
                                                            i6 = i3;
                                                            i5 = i7;
                                                            break;
                                                        case '7':
                                                            i3 = i6 + 1;
                                                            cArr2[i6] = 7;
                                                            i6 = i3;
                                                            i5 = i7;
                                                            break;
                                                        default:
                                                            switch (c2) {
                                                                case 't':
                                                                    i3 = i6 + 1;
                                                                    cArr2[i6] = '\t';
                                                                    i6 = i3;
                                                                    i5 = i7;
                                                                    break;
                                                                case 'u':
                                                                    char c3 = cArr[i5 + 2];
                                                                    char c4 = cArr[i5 + 3];
                                                                    char c5 = cArr[i5 + 4];
                                                                    i5 += i4;
                                                                    cArr2[i6] = (char) Integer.parseInt(new String(new char[]{c3, c4, c5, cArr[i5]}), 16);
                                                                    i6++;
                                                                    break;
                                                                case 'v':
                                                                    cArr2[i6] = 11;
                                                                    i6++;
                                                                    i5 = i7;
                                                                    break;
                                                                default:
                                                                    throw new JSONException("unclosed.str.lit");
                                                            }
                                                    }
                                                } else {
                                                    int[] iArr = digits;
                                                    int i8 = iArr[cArr[i5 + 2]] * 16;
                                                    i5 += 3;
                                                    cArr2[i6] = (char) (i8 + iArr[cArr[i5]]);
                                                    i6++;
                                                    i5++;
                                                    i4 = 5;
                                                }
                                            } else {
                                                i2 = i6 + 1;
                                                cArr2[i6] = '\r';
                                            }
                                        } else {
                                            i2 = i6 + 1;
                                            cArr2[i6] = '\n';
                                        }
                                    }
                                } else {
                                    i2 = i6 + 1;
                                    cArr2[i6] = '\b';
                                }
                            } else {
                                i2 = i6 + 1;
                                cArr2[i6] = '\\';
                            }
                        }
                        i2 = i6 + 1;
                        cArr2[i6] = '\f';
                    } else {
                        i2 = i6 + 1;
                        cArr2[i6] = '\'';
                    }
                } else {
                    i2 = i6 + 1;
                    cArr2[i6] = '\"';
                }
                i6 = i2;
                i5 = i7;
                i5++;
                i4 = 5;
            }
            i5++;
            i4 = 5;
        }
        return new String(cArr2, 0, i6);
    }

    /* JADX WARN: Code restructure failed: missing block: B:90:0x014b, code lost:
    
        throw new com.alibaba.fastjson.JSONException("invalid escape character \\x" + r5 + r7);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void scanStringSingleQuote() {
        /*
            Method dump skipped, instructions count: 438
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanStringSingleQuote():void");
    }

    public abstract String addSymbol(int i, int i2, int i3, SymbolTable symbolTable);

    public abstract void arrayCopy(int i, char[] cArr, int i2, int i3);

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public abstract byte[] bytesValue();

    public abstract boolean charArrayCompare(char[] cArr);

    public abstract char charAt(int i);

    @Override // com.alibaba.fastjson.parser.JSONLexer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        char[] cArr = this.sbuf;
        if (cArr.length <= 8192) {
            SBUF_LOCAL.set(cArr);
        }
        this.sbuf = null;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public void config(Feature feature, boolean z) {
        int config = Feature.config(this.features, feature, z);
        this.features = config;
        if ((config & Feature.InitStringFieldAsEmpty.mask) != 0) {
            this.stringDefaultValue = "";
        }
    }

    public abstract void copyTo(int i, int i2, char[] cArr);

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final Number decimalValue(boolean z) {
        char charAt = charAt((this.np + this.sp) - 1);
        try {
            if (charAt == 'F') {
                return Float.valueOf(Float.parseFloat(numberString()));
            }
            if (charAt == 'D') {
                return Double.valueOf(Double.parseDouble(numberString()));
            }
            if (z) {
                return decimalValue();
            }
            return Double.valueOf(doubleValue());
        } catch (NumberFormatException e) {
            throw new JSONException(e.getMessage() + ", " + info());
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public abstract BigDecimal decimalValue();

    public double doubleValue() {
        return Double.parseDouble(numberString());
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public float floatValue() {
        char charAt;
        String numberString = numberString();
        float parseFloat = Float.parseFloat(numberString);
        if ((parseFloat == 0.0f || parseFloat == Float.POSITIVE_INFINITY) && (charAt = numberString.charAt(0)) > '0' && charAt <= '9') {
            throw new JSONException("float overflow : " + numberString);
        }
        return parseFloat;
    }

    public Calendar getCalendar() {
        return this.calendar;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final char getCurrent() {
        return this.ch;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public int getFeatures() {
        return this.features;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public Locale getLocale() {
        return this.locale;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public TimeZone getTimeZone() {
        return this.timeZone;
    }

    public abstract int indexOf(char c, int i);

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public String info() {
        return "";
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final int intValue() {
        int i;
        boolean z;
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
        while (i3 < i4) {
            int i5 = i3 + 1;
            char charAt = charAt(i3);
            if (charAt != 'L' && charAt != 'S' && charAt != 'B') {
                int i6 = charAt - '0';
                if (i2 >= -214748364) {
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
            } else {
                i3 = i5;
                break;
            }
        }
        if (z) {
            if (i3 > this.np + 1) {
                return i2;
            }
            throw new NumberFormatException(numberString());
        }
        return -i2;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
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
        if (charAt != 'B') {
            if (charAt != 'L') {
                if (charAt != 'S') {
                    c = TokenParser.SP;
                } else {
                    i2--;
                    c = 'S';
                }
            } else {
                i2--;
                c = 'L';
            }
        } else {
            i2--;
            c = 'B';
        }
        if (charAt(this.np) == '-') {
            i++;
            j = Long.MIN_VALUE;
            z = true;
        } else {
            j = C.TIME_UNSET;
        }
        if (i < i2) {
            j2 = -(charAt(i) - '0');
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
            long j4 = charAt2;
            if (j3 < j + j4) {
                return new BigInteger(numberString(), 10);
            }
            j2 = j3 - j4;
            i = i3;
        }
        if (z) {
            if (i > this.np + 1) {
                if (j2 >= O0Xx.f12378xXxxox0I && c != 'L') {
                    if (c == 'S') {
                        return Short.valueOf((short) j2);
                    }
                    if (c == 'B') {
                        return Byte.valueOf((byte) j2);
                    }
                    return Integer.valueOf((int) j2);
                }
                return Long.valueOf(j2);
            }
            throw new JSONException("illegal number format : " + numberString());
        }
        long j5 = -j2;
        if (j5 <= 2147483647L && c != 'L') {
            if (c == 'S') {
                return Short.valueOf((short) j5);
            }
            if (c == 'B') {
                return Byte.valueOf((byte) j5);
            }
            return Integer.valueOf((int) j5);
        }
        return Long.valueOf(j5);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public boolean isBlankInput() {
        int i = 0;
        while (true) {
            char charAt = charAt(i);
            if (charAt == 26) {
                this.token = 20;
                return true;
            }
            if (!isWhitespace(charAt)) {
                return false;
            }
            i++;
        }
    }

    public abstract boolean isEOF();

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final boolean isEnabled(Feature feature) {
        return isEnabled(feature.mask);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final boolean isRef() {
        if (this.sp != 4 || charAt(this.np + 1) != '$' || charAt(this.np + 2) != 'r' || charAt(this.np + 3) != 'e' || charAt(this.np + 4) != 'f') {
            return false;
        }
        return true;
    }

    public void lexError(String str, Object... objArr) {
        this.token = 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0086  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x005d -> B:9:0x002e). Please report as a decompilation issue!!! */
    @Override // com.alibaba.fastjson.parser.JSONLexer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long longValue() throws java.lang.NumberFormatException {
        /*
            r13 = this;
            int r0 = r13.np
            r1 = -1
            r2 = 0
            if (r0 != r1) goto L8
            r13.np = r2
        L8:
            int r0 = r13.np
            int r1 = r13.sp
            int r1 = r1 + r0
            char r3 = r13.charAt(r0)
            r4 = 45
            r5 = 1
            if (r3 != r4) goto L1d
            int r0 = r0 + 1
            r2 = -9223372036854775808
            r3 = r2
            r2 = 1
            goto L22
        L1d:
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L22:
            if (r0 >= r1) goto L30
            int r6 = r0 + 1
            char r0 = r13.charAt(r0)
            int r0 = r0 + (-48)
            int r0 = -r0
            long r7 = (long) r0
        L2e:
            r0 = r6
            goto L32
        L30:
            r7 = 0
        L32:
            if (r0 >= r1) goto L74
            int r6 = r0 + 1
            char r0 = r13.charAt(r0)
            r9 = 76
            if (r0 == r9) goto L73
            r9 = 83
            if (r0 == r9) goto L73
            r9 = 66
            if (r0 != r9) goto L47
            goto L73
        L47:
            int r0 = r0 + (-48)
            r9 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            int r11 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r11 < 0) goto L69
            r9 = 10
            long r7 = r7 * r9
            long r9 = (long) r0
            long r11 = r3 + r9
            int r0 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r0 < 0) goto L5f
            long r7 = r7 - r9
            goto L2e
        L5f:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r1 = r13.numberString()
            r0.<init>(r1)
            throw r0
        L69:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r1 = r13.numberString()
            r0.<init>(r1)
            throw r0
        L73:
            r0 = r6
        L74:
            if (r2 == 0) goto L86
            int r1 = r13.np
            int r1 = r1 + r5
            if (r0 <= r1) goto L7c
            return r7
        L7c:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r1 = r13.numberString()
            r0.<init>(r1)
            throw r0
        L86:
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

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public abstract char next();

    public final void nextIdent() {
        while (isWhitespace(this.ch)) {
            next();
        }
        char c = this.ch;
        if (c != '_' && c != '$' && !Character.isLetter(c)) {
            nextToken();
        } else {
            scanIdent();
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void nextToken() {
        this.sp = 0;
        while (true) {
            this.pos = this.bp;
            char c = this.ch;
            if (c == '/') {
                skipComment();
            } else {
                if (c == '\"') {
                    scanString();
                    return;
                }
                if (c == ',') {
                    next();
                    this.token = 16;
                    return;
                }
                if (c >= '0' && c <= '9') {
                    scanNumber();
                    return;
                }
                if (c == '-') {
                    scanNumber();
                    return;
                }
                switch (c) {
                    case '\b':
                    case '\t':
                    case '\n':
                    case '\f':
                    case '\r':
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
                        if (isEOF()) {
                            if (this.token != 20) {
                                this.token = 20;
                                int i = this.bp;
                                this.pos = i;
                                this.eofPos = i;
                                return;
                            }
                            throw new JSONException("EOF error");
                        }
                        char c2 = this.ch;
                        if (c2 > 31 && c2 != 127) {
                            lexError("illegal.char", String.valueOf((int) c2));
                            next();
                            return;
                        } else {
                            next();
                            break;
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
            }
            if (c2 != ' ' && c2 != '\n' && c2 != '\r' && c2 != '\t' && c2 != '\f' && c2 != '\b') {
                throw new JSONException("not match " + c + " - " + this.ch + ", info : " + info());
            }
            next();
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void nextTokenWithColon() {
        nextTokenWithChar(':');
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public abstract String numberString();

    @Override // com.alibaba.fastjson.parser.JSONLexer
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

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void resetStringPosition() {
        this.sp = 0;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
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
        } else if (charAt == 'f') {
            if (charAt(this.bp + 1) == 'a' && charAt(this.bp + 2) == 'l' && charAt(this.bp + 3) == 's' && charAt(this.bp + 4) == 'e') {
                charAt = charAt(this.bp + 5);
                i = 6;
            } else {
                this.matchStat = -1;
                return false;
            }
        } else {
            if (charAt == '1') {
                charAt = charAt(this.bp + 1);
                z = true;
            } else if (charAt == '0') {
                charAt = charAt(this.bp + 1);
            } else {
                i = 1;
            }
            i = 2;
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
        long j;
        char c2;
        int i;
        Date date;
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
                        int i5 = 0;
                        for (int i6 = indexOf - 1; i6 >= 0 && charAt(i6) == '\\'; i6--) {
                            i5++;
                        }
                        if (i5 % 2 == 0) {
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
            if (charAt2 != '-' && (charAt2 < '0' || charAt2 > '9')) {
                if (charAt2 == 'n' && charAt(this.bp + 1) == 'u' && charAt(this.bp + 2) == 'l' && charAt(this.bp + 3) == 'l') {
                    i = 5;
                    this.matchStat = 5;
                    c2 = charAt(this.bp + 4);
                    date = null;
                } else {
                    this.matchStat = -1;
                    return null;
                }
            } else {
                if (charAt2 == '-') {
                    charAt2 = charAt(this.bp + 1);
                    z = true;
                    i3 = 2;
                }
                if (charAt2 >= '0' && charAt2 <= '9') {
                    j = charAt2 - '0';
                    while (true) {
                        i2 = i3 + 1;
                        charAt = charAt(this.bp + i3);
                        if (charAt < '0' || charAt > c3) {
                            break;
                        }
                        j = (j * 10) + (charAt - '0');
                        i3 = i2;
                        c3 = '9';
                    }
                    c2 = charAt;
                    i = i2;
                } else {
                    j = 0;
                    int i12 = i3;
                    c2 = charAt2;
                    i = i12;
                }
                if (j < 0) {
                    this.matchStat = -1;
                    return null;
                }
                if (z) {
                    j = -j;
                }
                date = new Date(j);
            }
        }
        if (c2 == ',') {
            int i13 = this.bp + i;
            this.bp = i13;
            this.ch = charAt(i13);
            this.matchStat = 3;
            this.token = 16;
            return date;
        }
        if (c2 == ']') {
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
        }
        this.matchStat = -1;
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:75:0x0097 A[ADDED_TO_REGION] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:73:0x0099 -> B:70:0x0089). Please report as a decompilation issue!!! */
    @Override // com.alibaba.fastjson.parser.JSONLexer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.math.BigDecimal scanDecimal(char r18) {
        /*
            Method dump skipped, instructions count: 465
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanDecimal(char):java.math.BigDecimal");
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00c2 A[ADDED_TO_REGION] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x00c4 -> B:41:0x00b3). Please report as a decompilation issue!!! */
    @Override // com.alibaba.fastjson.parser.JSONLexer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public double scanDouble(char r21) {
        /*
            Method dump skipped, instructions count: 430
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanDouble(char):double");
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public Enum<?> scanEnum(Class<?> cls, SymbolTable symbolTable, char c) {
        String scanSymbolWithSeperator = scanSymbolWithSeperator(symbolTable, c);
        if (scanSymbolWithSeperator == null) {
            return null;
        }
        return Enum.valueOf(cls, scanSymbolWithSeperator);
    }

    public long scanEnumSymbol(char[] cArr) {
        int i;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return 0L;
        }
        int length = cArr.length;
        int i2 = length + 1;
        if (charAt(this.bp + length) != '\"') {
            this.matchStat = -1;
            return 0L;
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
                }
                if (charAt2 == '}') {
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
                        return 0L;
                    }
                    this.matchStat = 4;
                    return j;
                }
                this.matchStat = -1;
                return 0L;
            }
            if (charAt >= 'A' && charAt <= 'Z') {
                i = charAt + TokenParser.SP;
            } else {
                i = charAt;
            }
            j = (j ^ i) * TypeUtils.fnv1a_64_magic_prime;
            if (charAt == '\\') {
                this.matchStat = -1;
                return 0L;
            }
            i2 = i3;
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
                            if (c != ' ' && c != ',' && c != '}' && c != ']' && c != '\n' && c != '\r' && c != '\t' && c != 26 && c != '\f' && c != '\b' && c != ':' && c != '/') {
                                throw new JSONException("scan false error");
                            }
                            this.token = 7;
                            return;
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
        int length;
        int i2;
        BigInteger bigInteger;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return null;
        }
        int length2 = cArr.length;
        int i3 = length2 + 1;
        char charAt2 = charAt(this.bp + length2);
        if (charAt2 == '\"') {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            charAt2 = charAt(this.bp + i3);
            i3 = length2 + 2;
        }
        if (charAt2 == '-') {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            charAt2 = charAt(this.bp + i3);
            i3++;
        }
        if (charAt2 >= '0') {
            char c = '9';
            if (charAt2 <= '9') {
                long j = charAt2 - '0';
                while (true) {
                    i = i3 + 1;
                    charAt = charAt(this.bp + i3);
                    if (charAt < '0' || charAt > c) {
                        break;
                    }
                    long j2 = (10 * j) + (charAt - '0');
                    if (j2 < j) {
                        z3 = true;
                        break;
                    }
                    j = j2;
                    i3 = i;
                    c = '9';
                }
                z3 = false;
                if (z) {
                    if (charAt != '\"') {
                        this.matchStat = -1;
                        return null;
                    }
                    int i4 = i3 + 2;
                    charAt = charAt(this.bp + i);
                    int i5 = this.bp;
                    length = cArr.length + i5 + 1;
                    i2 = ((i5 + i4) - length) - 2;
                    i = i4;
                } else {
                    int i6 = this.bp;
                    length = cArr.length + i6;
                    i2 = ((i6 + i) - length) - 1;
                }
                if (!z3 && (i2 < 20 || (z2 && i2 < 21))) {
                    if (z2) {
                        j = -j;
                    }
                    bigInteger = BigInteger.valueOf(j);
                } else if (i2 <= 65535) {
                    bigInteger = new BigInteger(subString(length, i2), 10);
                } else {
                    throw new JSONException("scanInteger overflow");
                }
                if (charAt == ',') {
                    int i7 = this.bp + i;
                    this.bp = i7;
                    this.ch = charAt(i7);
                    this.matchStat = 3;
                    this.token = 16;
                    return bigInteger;
                }
                if (charAt == '}') {
                    int i8 = i + 1;
                    char charAt3 = charAt(this.bp + i);
                    if (charAt3 == ',') {
                        this.token = 16;
                        int i9 = this.bp + i8;
                        this.bp = i9;
                        this.ch = charAt(i9);
                    } else if (charAt3 == ']') {
                        this.token = 15;
                        int i10 = this.bp + i8;
                        this.bp = i10;
                        this.ch = charAt(i10);
                    } else if (charAt3 == '}') {
                        this.token = 13;
                        int i11 = this.bp + i8;
                        this.bp = i11;
                        this.ch = charAt(i11);
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
                }
                this.matchStat = -1;
                return null;
            }
        }
        if (charAt2 == 'n' && charAt(this.bp + i3) == 'u' && charAt(this.bp + i3 + 1) == 'l' && charAt(this.bp + i3 + 2) == 'l') {
            this.matchStat = 5;
            int i12 = i3 + 4;
            char charAt4 = charAt(this.bp + i3 + 3);
            if (z && charAt4 == '\"') {
                charAt4 = charAt(this.bp + i12);
                i12 = i3 + 5;
            }
            while (charAt4 != ',') {
                if (charAt4 == '}') {
                    int i13 = this.bp + i12;
                    this.bp = i13;
                    this.ch = charAt(i13);
                    this.matchStat = 5;
                    this.token = 13;
                    return null;
                }
                if (isWhitespace(charAt4)) {
                    charAt4 = charAt(this.bp + i12);
                    i12++;
                } else {
                    this.matchStat = -1;
                    return null;
                }
            }
            int i14 = this.bp + i12;
            this.bp = i14;
            this.ch = charAt(i14);
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
        }
        if (charAt2 == '}') {
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
        }
        this.matchStat = -1;
        return false;
    }

    public Date scanFieldDate(char[] cArr) {
        char c;
        int i;
        long j;
        Date date;
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
                        int i4 = 0;
                        for (int i5 = indexOf - 1; i5 >= 0 && charAt(i5) == '\\'; i5--) {
                            i4++;
                        }
                        if (i4 % 2 == 0) {
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
                        return null;
                    }
                } finally {
                    jSONScanner.close();
                }
            } else {
                throw new JSONException("unclosed str");
            }
        } else {
            if (charAt2 != '-' && (charAt2 < '0' || charAt2 > '9')) {
                this.matchStat = -1;
                return null;
            }
            if (charAt2 == '-') {
                charAt2 = charAt(this.bp + i3);
                i3 = length + 2;
                z = true;
            }
            if (charAt2 >= '0' && charAt2 <= '9') {
                j = charAt2 - '0';
                while (true) {
                    i2 = i3 + 1;
                    charAt = charAt(this.bp + i3);
                    if (charAt < '0' || charAt > '9') {
                        break;
                    }
                    j = (j * 10) + (charAt - '0');
                    i3 = i2;
                }
                c = charAt;
                i = i2;
            } else {
                c = charAt2;
                i = i3;
                j = 0;
            }
            if (j < 0) {
                this.matchStat = -1;
                return null;
            }
            if (z) {
                j = -j;
            }
            date = new Date(j);
        }
        if (c == ',') {
            int i8 = this.bp + i;
            this.bp = i8;
            this.ch = charAt(i8);
            this.matchStat = 3;
            return date;
        }
        if (c == '}') {
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
            return date;
        }
        this.matchStat = -1;
        return null;
    }

    public BigDecimal scanFieldDecimal(char[] cArr) {
        boolean z;
        int i;
        char charAt;
        int length;
        int i2;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return null;
        }
        int length2 = cArr.length;
        int i3 = length2 + 1;
        char charAt2 = charAt(this.bp + length2);
        if (charAt2 == '\"') {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            charAt2 = charAt(this.bp + i3);
            i3 = length2 + 2;
        }
        if (charAt2 == '-') {
            charAt2 = charAt(this.bp + i3);
            i3++;
        }
        if (charAt2 >= '0' && charAt2 <= '9') {
            while (true) {
                i = i3 + 1;
                charAt = charAt(this.bp + i3);
                if (charAt < '0' || charAt > '9') {
                    break;
                }
                i3 = i;
            }
            if (charAt == '.') {
                int i4 = i3 + 2;
                char charAt3 = charAt(this.bp + i);
                if (charAt3 >= '0' && charAt3 <= '9') {
                    while (true) {
                        i = i4 + 1;
                        charAt = charAt(this.bp + i4);
                        if (charAt < '0' || charAt > '9') {
                            break;
                        }
                        i4 = i;
                    }
                } else {
                    this.matchStat = -1;
                    return null;
                }
            }
            if (charAt == 'e' || charAt == 'E') {
                int i5 = i + 1;
                charAt = charAt(this.bp + i);
                if (charAt != '+' && charAt != '-') {
                    i = i5;
                } else {
                    i += 2;
                    charAt = charAt(this.bp + i5);
                }
                while (charAt >= '0' && charAt <= '9') {
                    char charAt4 = charAt(this.bp + i);
                    i++;
                    charAt = charAt4;
                }
            }
            if (z) {
                if (charAt != '\"') {
                    this.matchStat = -1;
                    return null;
                }
                int i6 = i + 1;
                char charAt5 = charAt(this.bp + i);
                int i7 = this.bp;
                length = cArr.length + i7 + 1;
                i2 = ((i7 + i6) - length) - 2;
                i = i6;
                charAt = charAt5;
            } else {
                int i8 = this.bp;
                length = cArr.length + i8;
                i2 = ((i8 + i) - length) - 1;
            }
            if (i2 <= 65535) {
                char[] sub_chars = sub_chars(length, i2);
                BigDecimal bigDecimal = new BigDecimal(sub_chars, 0, sub_chars.length, MathContext.UNLIMITED);
                if (charAt == ',') {
                    int i9 = this.bp + i;
                    this.bp = i9;
                    this.ch = charAt(i9);
                    this.matchStat = 3;
                    this.token = 16;
                    return bigDecimal;
                }
                if (charAt == '}') {
                    int i10 = i + 1;
                    char charAt6 = charAt(this.bp + i);
                    if (charAt6 == ',') {
                        this.token = 16;
                        int i11 = this.bp + i10;
                        this.bp = i11;
                        this.ch = charAt(i11);
                    } else if (charAt6 == ']') {
                        this.token = 15;
                        int i12 = this.bp + i10;
                        this.bp = i12;
                        this.ch = charAt(i12);
                    } else if (charAt6 == '}') {
                        this.token = 13;
                        int i13 = this.bp + i10;
                        this.bp = i13;
                        this.ch = charAt(i13);
                    } else if (charAt6 == 26) {
                        this.token = 20;
                        this.bp += i;
                        this.ch = JSONLexer.EOI;
                    } else {
                        this.matchStat = -1;
                        return null;
                    }
                    this.matchStat = 4;
                    return bigDecimal;
                }
                this.matchStat = -1;
                return null;
            }
            throw new JSONException("scan decimal overflow");
        }
        if (charAt2 == 'n' && charAt(this.bp + i3) == 'u' && charAt(this.bp + i3 + 1) == 'l' && charAt(this.bp + i3 + 2) == 'l') {
            this.matchStat = 5;
            int i14 = i3 + 4;
            char charAt7 = charAt(this.bp + i3 + 3);
            if (z && charAt7 == '\"') {
                charAt7 = charAt(this.bp + i14);
                i14 = i3 + 5;
            }
            while (charAt7 != ',') {
                if (charAt7 == '}') {
                    int i15 = this.bp + i14;
                    this.bp = i15;
                    this.ch = charAt(i15);
                    this.matchStat = 5;
                    this.token = 13;
                    return null;
                }
                if (isWhitespace(charAt7)) {
                    charAt7 = charAt(this.bp + i14);
                    i14++;
                } else {
                    this.matchStat = -1;
                    return null;
                }
            }
            int i16 = this.bp + i14;
            this.bp = i16;
            this.ch = charAt(i16);
            this.matchStat = 5;
            this.token = 16;
            return null;
        }
        this.matchStat = -1;
        return null;
    }

    public final double scanFieldDouble(char[] cArr) {
        boolean z;
        boolean z2;
        int i;
        char charAt;
        long j;
        boolean z3;
        int length;
        int i2;
        double parseDouble;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return OOXIXo.f3760XO;
        }
        int length2 = cArr.length;
        int i3 = length2 + 1;
        char charAt2 = charAt(this.bp + length2);
        if (charAt2 == '\"') {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            charAt2 = charAt(this.bp + i3);
            i3 = length2 + 2;
        }
        if (charAt2 == '-') {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            charAt2 = charAt(this.bp + i3);
            i3++;
        }
        if (charAt2 >= '0' && charAt2 <= '9') {
            long j2 = charAt2 - '0';
            while (true) {
                i = i3 + 1;
                charAt = charAt(this.bp + i3);
                if (charAt < '0' || charAt > '9') {
                    break;
                }
                j2 = (j2 * 10) + (charAt - '0');
                i3 = i;
            }
            if (charAt == '.') {
                int i4 = i3 + 2;
                char charAt3 = charAt(this.bp + i);
                if (charAt3 >= '0' && charAt3 <= '9') {
                    j2 = (j2 * 10) + (charAt3 - '0');
                    j = 10;
                    while (true) {
                        i = i4 + 1;
                        charAt = charAt(this.bp + i4);
                        if (charAt < '0' || charAt > '9') {
                            break;
                        }
                        j2 = (j2 * 10) + (charAt - '0');
                        j *= 10;
                        i4 = i;
                    }
                } else {
                    this.matchStat = -1;
                    return OOXIXo.f3760XO;
                }
            } else {
                j = 1;
            }
            if (charAt != 'e' && charAt != 'E') {
                z3 = false;
            } else {
                z3 = true;
            }
            if (z3) {
                int i5 = i + 1;
                charAt = charAt(this.bp + i);
                if (charAt != '+' && charAt != '-') {
                    i = i5;
                } else {
                    i += 2;
                    charAt = charAt(this.bp + i5);
                }
                while (charAt >= '0' && charAt <= '9') {
                    charAt = charAt(this.bp + i);
                    i++;
                }
            }
            if (z) {
                if (charAt != '\"') {
                    this.matchStat = -1;
                    return OOXIXo.f3760XO;
                }
                int i6 = i + 1;
                charAt = charAt(this.bp + i);
                int i7 = this.bp;
                length = cArr.length + i7 + 1;
                i2 = ((i7 + i6) - length) - 2;
                i = i6;
            } else {
                int i8 = this.bp;
                length = cArr.length + i8;
                i2 = ((i8 + i) - length) - 1;
            }
            if (!z3 && i2 < 17) {
                parseDouble = j2 / j;
                if (z2) {
                    parseDouble = -parseDouble;
                }
            } else {
                parseDouble = Double.parseDouble(subString(length, i2));
            }
            if (charAt == ',') {
                int i9 = this.bp + i;
                this.bp = i9;
                this.ch = charAt(i9);
                this.matchStat = 3;
                this.token = 16;
                return parseDouble;
            }
            if (charAt == '}') {
                int i10 = i + 1;
                char charAt4 = charAt(this.bp + i);
                if (charAt4 == ',') {
                    this.token = 16;
                    int i11 = this.bp + i10;
                    this.bp = i11;
                    this.ch = charAt(i11);
                } else if (charAt4 == ']') {
                    this.token = 15;
                    int i12 = this.bp + i10;
                    this.bp = i12;
                    this.ch = charAt(i12);
                } else if (charAt4 == '}') {
                    this.token = 13;
                    int i13 = this.bp + i10;
                    this.bp = i13;
                    this.ch = charAt(i13);
                } else if (charAt4 == 26) {
                    this.token = 20;
                    this.bp += i;
                    this.ch = JSONLexer.EOI;
                } else {
                    this.matchStat = -1;
                    return OOXIXo.f3760XO;
                }
                this.matchStat = 4;
                return parseDouble;
            }
            this.matchStat = -1;
            return OOXIXo.f3760XO;
        }
        if (charAt2 == 'n' && charAt(this.bp + i3) == 'u' && charAt(this.bp + i3 + 1) == 'l' && charAt(this.bp + i3 + 2) == 'l') {
            this.matchStat = 5;
            int i14 = i3 + 4;
            char charAt5 = charAt(this.bp + i3 + 3);
            if (z && charAt5 == '\"') {
                charAt5 = charAt(this.bp + i14);
                i14 = i3 + 5;
            }
            while (charAt5 != ',') {
                if (charAt5 == '}') {
                    int i15 = this.bp + i14;
                    this.bp = i15;
                    this.ch = charAt(i15);
                    this.matchStat = 5;
                    this.token = 13;
                    return OOXIXo.f3760XO;
                }
                if (isWhitespace(charAt5)) {
                    charAt5 = charAt(this.bp + i14);
                    i14++;
                } else {
                    this.matchStat = -1;
                    return OOXIXo.f3760XO;
                }
            }
            int i16 = this.bp + i14;
            this.bp = i16;
            this.ch = charAt(i16);
            this.matchStat = 5;
            this.token = 16;
            return OOXIXo.f3760XO;
        }
        this.matchStat = -1;
        return OOXIXo.f3760XO;
    }

    public final float scanFieldFloat(char[] cArr) {
        boolean z;
        boolean z2;
        int i;
        char charAt;
        long j;
        boolean z3;
        int length;
        int i2;
        float parseFloat;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return 0.0f;
        }
        int length2 = cArr.length;
        int i3 = length2 + 1;
        char charAt2 = charAt(this.bp + length2);
        if (charAt2 == '\"') {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            charAt2 = charAt(this.bp + i3);
            i3 = length2 + 2;
        }
        if (charAt2 == '-') {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            charAt2 = charAt(this.bp + i3);
            i3++;
        }
        if (charAt2 >= '0' && charAt2 <= '9') {
            long j2 = charAt2 - '0';
            while (true) {
                i = i3 + 1;
                charAt = charAt(this.bp + i3);
                if (charAt < '0' || charAt > '9') {
                    break;
                }
                j2 = (j2 * 10) + (charAt - '0');
                i3 = i;
            }
            if (charAt == '.') {
                int i4 = i3 + 2;
                char charAt3 = charAt(this.bp + i);
                if (charAt3 >= '0' && charAt3 <= '9') {
                    j2 = (j2 * 10) + (charAt3 - '0');
                    j = 10;
                    while (true) {
                        i = i4 + 1;
                        charAt = charAt(this.bp + i4);
                        if (charAt < '0' || charAt > '9') {
                            break;
                        }
                        j2 = (j2 * 10) + (charAt - '0');
                        j *= 10;
                        i4 = i;
                    }
                } else {
                    this.matchStat = -1;
                    return 0.0f;
                }
            } else {
                j = 1;
            }
            if (charAt != 'e' && charAt != 'E') {
                z3 = false;
            } else {
                z3 = true;
            }
            if (z3) {
                int i5 = i + 1;
                charAt = charAt(this.bp + i);
                if (charAt != '+' && charAt != '-') {
                    i = i5;
                } else {
                    i += 2;
                    charAt = charAt(this.bp + i5);
                }
                while (charAt >= '0' && charAt <= '9') {
                    char charAt4 = charAt(this.bp + i);
                    i++;
                    charAt = charAt4;
                }
            }
            if (z) {
                if (charAt != '\"') {
                    this.matchStat = -1;
                    return 0.0f;
                }
                int i6 = i + 1;
                charAt = charAt(this.bp + i);
                int i7 = this.bp;
                length = cArr.length + i7 + 1;
                i2 = ((i7 + i6) - length) - 2;
                i = i6;
            } else {
                int i8 = this.bp;
                length = cArr.length + i8;
                i2 = ((i8 + i) - length) - 1;
            }
            if (!z3 && i2 < 17) {
                parseFloat = (float) (j2 / j);
                if (z2) {
                    parseFloat = -parseFloat;
                }
            } else {
                parseFloat = Float.parseFloat(subString(length, i2));
            }
            if (charAt == ',') {
                int i9 = this.bp + i;
                this.bp = i9;
                this.ch = charAt(i9);
                this.matchStat = 3;
                this.token = 16;
                return parseFloat;
            }
            if (charAt == '}') {
                int i10 = i + 1;
                char charAt5 = charAt(this.bp + i);
                if (charAt5 == ',') {
                    this.token = 16;
                    int i11 = this.bp + i10;
                    this.bp = i11;
                    this.ch = charAt(i11);
                } else if (charAt5 == ']') {
                    this.token = 15;
                    int i12 = this.bp + i10;
                    this.bp = i12;
                    this.ch = charAt(i12);
                } else if (charAt5 == '}') {
                    this.token = 13;
                    int i13 = this.bp + i10;
                    this.bp = i13;
                    this.ch = charAt(i13);
                } else if (charAt5 == 26) {
                    this.bp += i;
                    this.token = 20;
                    this.ch = JSONLexer.EOI;
                } else {
                    this.matchStat = -1;
                    return 0.0f;
                }
                this.matchStat = 4;
                return parseFloat;
            }
            this.matchStat = -1;
            return 0.0f;
        }
        if (charAt2 == 'n' && charAt(this.bp + i3) == 'u' && charAt(this.bp + i3 + 1) == 'l' && charAt(this.bp + i3 + 2) == 'l') {
            this.matchStat = 5;
            int i14 = i3 + 4;
            char charAt6 = charAt(this.bp + i3 + 3);
            if (z && charAt6 == '\"') {
                charAt6 = charAt(this.bp + i14);
                i14 = i3 + 5;
            }
            while (charAt6 != ',') {
                if (charAt6 == '}') {
                    int i15 = this.bp + i14;
                    this.bp = i15;
                    this.ch = charAt(i15);
                    this.matchStat = 5;
                    this.token = 13;
                    return 0.0f;
                }
                if (isWhitespace(charAt6)) {
                    charAt6 = charAt(this.bp + i14);
                    i14++;
                } else {
                    this.matchStat = -1;
                    return 0.0f;
                }
            }
            int i16 = this.bp + i14;
            this.bp = i16;
            this.ch = charAt(i16);
            this.matchStat = 5;
            this.token = 16;
            return 0.0f;
        }
        this.matchStat = -1;
        return 0.0f;
    }

    /* JADX WARN: Code restructure failed: missing block: B:107:0x01b9, code lost:
    
        r1 = r4;
        r19.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x01bc, code lost:
    
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final float[] scanFieldFloatArray(char[] r20) {
        /*
            Method dump skipped, instructions count: 445
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanFieldFloatArray(char[]):float[]");
    }

    /* JADX WARN: Code restructure failed: missing block: B:120:0x014c, code lost:
    
        r7 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x00b3, code lost:
    
        r21.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x00b5, code lost:
    
        return r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x0196, code lost:
    
        r21.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x0199, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0137, code lost:
    
        r4 = r18 + 1;
        r1 = charAt(r21.bp + r18);
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0142, code lost:
    
        if (r2 == r3.length) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0144, code lost:
    
        r5 = new float[r2];
        r7 = 0;
        java.lang.System.arraycopy(r3, 0, r5, 0, r2);
        r3 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x014e, code lost:
    
        if (r8 < r6.length) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0150, code lost:
    
        r5 = new float[(r6.length * 3) / 2];
        java.lang.System.arraycopy(r3, r7, r5, r7, r2);
        r6 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x015c, code lost:
    
        r5 = r8 + 1;
        r6[r8] = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0162, code lost:
    
        if (r1 != ',') goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0164, code lost:
    
        r3 = charAt(r21.bp + r4);
        r2 = r18 + 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0173, code lost:
    
        if (r1 != ']') goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0180, code lost:
    
        r3 = r1;
        r2 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0175, code lost:
    
        r2 = r18 + 2;
        r3 = charAt(r21.bp + r4);
        r8 = r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final float[][] scanFieldFloatArray2(char[] r22) {
        /*
            Method dump skipped, instructions count: 529
            To view this dump add '--comments-level debug' option
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
        if (charAt2 >= '0' && charAt2 <= '9') {
            int i3 = charAt2 - '0';
            while (true) {
                i = i2 + 1;
                charAt = charAt(this.bp + i2);
                if (charAt < '0' || charAt > '9') {
                    break;
                }
                i3 = (i3 * 10) + (charAt - '0');
                i2 = i;
            }
            if (charAt == '.') {
                this.matchStat = -1;
                return 0;
            }
            if ((i3 >= 0 && i <= cArr.length + 14) || (i3 == Integer.MIN_VALUE && i == 17 && z)) {
                if (charAt == ',') {
                    int i4 = this.bp + i;
                    this.bp = i4;
                    this.ch = charAt(i4);
                    this.matchStat = 3;
                    this.token = 16;
                    if (z) {
                        return -i3;
                    }
                    return i3;
                }
                if (charAt == '}') {
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
                }
                this.matchStat = -1;
                return 0;
            }
            this.matchStat = -1;
            return 0;
        }
        this.matchStat = -1;
        return 0;
    }

    public final int[] scanFieldIntArray(char[] cArr) {
        boolean z;
        int i;
        char charAt;
        int i2;
        char charAt2;
        int i3;
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
        char charAt3 = charAt(this.bp + i4);
        int[] iArr3 = new int[16];
        if (charAt3 == ']') {
            i3 = length + 3;
            charAt2 = charAt(this.bp + i5);
            i2 = 0;
        } else {
            int i6 = 0;
            while (true) {
                if (charAt3 == '-') {
                    charAt3 = charAt(this.bp + i5);
                    i5++;
                    z = true;
                } else {
                    z = false;
                }
                if (charAt3 < '0' || charAt3 > '9') {
                    break;
                }
                int i7 = charAt3 - '0';
                while (true) {
                    i = i5 + 1;
                    charAt = charAt(this.bp + i5);
                    if (charAt < '0' || charAt > '9') {
                        break;
                    }
                    i7 = (i7 * 10) + (charAt - '0');
                    i5 = i;
                }
                if (i6 >= iArr3.length) {
                    int[] iArr4 = new int[(iArr3.length * 3) / 2];
                    System.arraycopy(iArr3, 0, iArr4, 0, i6);
                    iArr3 = iArr4;
                }
                i2 = i6 + 1;
                if (z) {
                    i7 = -i7;
                }
                iArr3[i6] = i7;
                if (charAt == ',') {
                    i5 += 2;
                    charAt3 = charAt(this.bp + i);
                    iArr = null;
                } else {
                    if (charAt == ']') {
                        charAt2 = charAt(this.bp + i);
                        i3 = i5 + 2;
                        break;
                    }
                    iArr = null;
                    charAt3 = charAt;
                    i5 = i;
                }
                iArr2 = iArr;
                i6 = i2;
            }
            int[] iArr5 = iArr2;
            this.matchStat = -1;
            return iArr5;
        }
        if (i2 != iArr3.length) {
            int[] iArr6 = new int[i2];
            System.arraycopy(iArr3, 0, iArr6, 0, i2);
            iArr3 = iArr6;
        }
        if (charAt2 == ',') {
            this.bp += i3 - 1;
            next();
            this.matchStat = 3;
            this.token = 16;
            return iArr3;
        }
        if (charAt2 == '}') {
            char charAt4 = charAt(this.bp + i3);
            if (charAt4 == ',') {
                this.token = 16;
                this.bp += i3;
                next();
            } else if (charAt4 == ']') {
                this.token = 15;
                this.bp += i3;
                next();
            } else if (charAt4 == '}') {
                this.token = 13;
                this.bp += i3;
                next();
            } else if (charAt4 == 26) {
                this.bp += i3;
                this.token = 20;
                this.ch = JSONLexer.EOI;
            } else {
                this.matchStat = -1;
                return null;
            }
            this.matchStat = 4;
            return iArr3;
        }
        this.matchStat = -1;
        return null;
    }

    public long scanFieldLong(char[] cArr) {
        int i;
        char charAt;
        boolean z = false;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return 0L;
        }
        int length = cArr.length;
        int i2 = length + 1;
        char charAt2 = charAt(this.bp + length);
        if (charAt2 == '-') {
            charAt2 = charAt(this.bp + i2);
            i2 = length + 2;
            z = true;
        }
        if (charAt2 >= '0' && charAt2 <= '9') {
            long j = charAt2 - '0';
            while (true) {
                i = i2 + 1;
                charAt = charAt(this.bp + i2);
                if (charAt < '0' || charAt > '9') {
                    break;
                }
                j = (j * 10) + (charAt - '0');
                i2 = i;
            }
            if (charAt == '.') {
                this.matchStat = -1;
                return 0L;
            }
            if (i - cArr.length < 21 && (j >= 0 || (j == Long.MIN_VALUE && z))) {
                if (charAt == ',') {
                    int i3 = this.bp + i;
                    this.bp = i3;
                    this.ch = charAt(i3);
                    this.matchStat = 3;
                    this.token = 16;
                    if (z) {
                        return -j;
                    }
                    return j;
                }
                if (charAt == '}') {
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
                        return 0L;
                    }
                    this.matchStat = 4;
                    if (z) {
                        return -j;
                    }
                    return j;
                }
                this.matchStat = -1;
                return 0L;
            }
            this.matchStat = -1;
            return 0L;
        }
        this.matchStat = -1;
        return 0L;
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
                    int i2 = 0;
                    for (int i3 = indexOf - 1; i3 >= 0 && charAt(i3) == '\\'; i3--) {
                        i2++;
                    }
                    if (i2 % 2 == 0) {
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
            }
            if (charAt == '}') {
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
            }
            this.matchStat = -1;
            return stringDefaultValue();
        }
        throw new JSONException("unclosed str");
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x00fc, code lost:
    
        if (r13 != ',') goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00fe, code lost:
    
        r13 = r12.bp + r0;
        r12.bp = r13;
        r12.ch = charAt(r13);
        r12.matchStat = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x010c, code lost:
    
        return r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x010f, code lost:
    
        if (r13 != '}') goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0111, code lost:
    
        r6 = r0 + 1;
        r13 = charAt(r12.bp + r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x011a, code lost:
    
        if (r13 != ',') goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x011c, code lost:
    
        r12.token = 16;
        r13 = r12.bp + r6;
        r12.bp = r13;
        r12.ch = charAt(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x015f, code lost:
    
        r12.matchStat = 4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0162, code lost:
    
        return r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x012c, code lost:
    
        if (r13 != ']') goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x012e, code lost:
    
        r12.token = 15;
        r13 = r12.bp + r6;
        r12.bp = r13;
        r12.ch = charAt(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x013e, code lost:
    
        if (r13 != '}') goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0140, code lost:
    
        r12.token = 13;
        r13 = r12.bp + r6;
        r12.bp = r13;
        r12.ch = charAt(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0152, code lost:
    
        if (r13 != 26) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0154, code lost:
    
        r12.bp += r0;
        r12.token = 20;
        r12.ch = com.alibaba.fastjson.parser.JSONLexer.EOI;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0163, code lost:
    
        r12.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0165, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0166, code lost:
    
        r12.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0168, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00f0, code lost:
    
        if (r14.size() != 0) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00f2, code lost:
    
        r1 = r13 + 1;
        r13 = charAt(r12.bp + r13);
        r0 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0170, code lost:
    
        throw new com.alibaba.fastjson.JSONException("illega str");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.Collection<java.lang.String> scanFieldStringArray(char[] r13, java.lang.Class<?> r14) {
        /*
            Method dump skipped, instructions count: 369
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanFieldStringArray(char[], java.lang.Class):java.util.Collection");
    }

    public long scanFieldSymbol(char[] cArr) {
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return 0L;
        }
        int length = cArr.length;
        int i = length + 1;
        if (charAt(this.bp + length) != '\"') {
            this.matchStat = -1;
            return 0L;
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
                }
                if (charAt2 == '}') {
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
                        return 0L;
                    }
                    this.matchStat = 4;
                    return j;
                }
                this.matchStat = -1;
                return 0L;
            }
            j = (j ^ charAt) * TypeUtils.fnv1a_64_magic_prime;
            if (charAt == '\\') {
                this.matchStat = -1;
                return 0L;
            }
            i = i2;
        }
    }

    public UUID scanFieldUUID(char[] cArr) {
        char charAt;
        int i;
        UUID uuid;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return null;
        }
        int length = cArr.length;
        int i9 = length + 1;
        char charAt2 = charAt(this.bp + length);
        char c = 4;
        if (charAt2 == '\"') {
            int indexOf = indexOf('\"', this.bp + cArr.length + 1);
            if (indexOf != -1) {
                int length2 = this.bp + cArr.length + 1;
                int i10 = indexOf - length2;
                char c2 = 'F';
                char c3 = 'A';
                char c4 = 'f';
                char c5 = 'a';
                char c6 = '9';
                if (i10 == 36) {
                    int i11 = 0;
                    long j = 0;
                    while (i11 < 8) {
                        char charAt3 = charAt(length2 + i11);
                        if (charAt3 >= '0' && charAt3 <= '9') {
                            i8 = charAt3 - '0';
                        } else if (charAt3 >= 'a' && charAt3 <= 'f') {
                            i8 = charAt3 - 'W';
                        } else {
                            if (charAt3 < 'A' || charAt3 > 'F') {
                                this.matchStat = -2;
                                return null;
                            }
                            i8 = charAt3 - '7';
                        }
                        j = (j << c) | i8;
                        i11++;
                        c = 4;
                    }
                    for (int i12 = 9; i12 < 13; i12++) {
                        char charAt4 = charAt(length2 + i12);
                        if (charAt4 >= '0' && charAt4 <= '9') {
                            i7 = charAt4 - '0';
                        } else if (charAt4 >= 'a' && charAt4 <= 'f') {
                            i7 = charAt4 - 'W';
                        } else {
                            if (charAt4 < 'A' || charAt4 > 'F') {
                                this.matchStat = -2;
                                return null;
                            }
                            i7 = charAt4 - '7';
                        }
                        j = (j << 4) | i7;
                    }
                    int i13 = 14;
                    long j2 = j;
                    while (i13 < 18) {
                        char charAt5 = charAt(length2 + i13);
                        if (charAt5 >= '0' && charAt5 <= '9') {
                            i6 = charAt5 - '0';
                        } else if (charAt5 >= 'a' && charAt5 <= 'f') {
                            i6 = charAt5 - 'W';
                        } else {
                            if (charAt5 < 'A' || charAt5 > c2) {
                                this.matchStat = -2;
                                return null;
                            }
                            i6 = charAt5 - '7';
                        }
                        j2 = (j2 << 4) | i6;
                        i13++;
                        indexOf = indexOf;
                        c2 = 'F';
                    }
                    int i14 = indexOf;
                    int i15 = 19;
                    long j3 = 0;
                    while (i15 < 23) {
                        char charAt6 = charAt(length2 + i15);
                        if (charAt6 >= '0' && charAt6 <= '9') {
                            i5 = charAt6 - '0';
                        } else if (charAt6 >= 'a' && charAt6 <= c4) {
                            i5 = charAt6 - 'W';
                        } else {
                            if (charAt6 < c3 || charAt6 > 'F') {
                                this.matchStat = -2;
                                return null;
                            }
                            i5 = charAt6 - '7';
                        }
                        j3 = (j3 << 4) | i5;
                        i15++;
                        c3 = 'A';
                        c4 = 'f';
                    }
                    int i16 = 24;
                    long j4 = j3;
                    int i17 = 36;
                    while (i16 < i17) {
                        char charAt7 = charAt(length2 + i16);
                        if (charAt7 >= '0' && charAt7 <= c6) {
                            i4 = charAt7 - '0';
                        } else if (charAt7 >= c5 && charAt7 <= 'f') {
                            i4 = charAt7 - 'W';
                        } else {
                            if (charAt7 < 'A' || charAt7 > 'F') {
                                this.matchStat = -2;
                                return null;
                            }
                            i4 = charAt7 - '7';
                        }
                        j4 = (j4 << 4) | i4;
                        i16++;
                        i17 = 36;
                        c6 = '9';
                        c5 = 'a';
                    }
                    uuid = new UUID(j2, j4);
                    int i18 = this.bp;
                    int length3 = i9 + (i14 - ((cArr.length + i18) + 1)) + 1;
                    i = length3 + 1;
                    charAt = charAt(i18 + length3);
                } else {
                    if (i10 == 32) {
                        int i19 = 0;
                        long j5 = 0;
                        for (int i20 = 16; i19 < i20; i20 = 16) {
                            char charAt8 = charAt(length2 + i19);
                            if (charAt8 >= '0' && charAt8 <= '9') {
                                i3 = charAt8 - '0';
                            } else if (charAt8 >= 'a' && charAt8 <= 'f') {
                                i3 = charAt8 - 'W';
                            } else {
                                if (charAt8 < 'A' || charAt8 > 'F') {
                                    this.matchStat = -2;
                                    return null;
                                }
                                i3 = charAt8 - '7';
                            }
                            j5 = (j5 << 4) | i3;
                            i19++;
                        }
                        int i21 = 16;
                        long j6 = 0;
                        for (int i22 = 32; i21 < i22; i22 = 32) {
                            char charAt9 = charAt(length2 + i21);
                            if (charAt9 >= '0' && charAt9 <= '9') {
                                i2 = charAt9 - '0';
                            } else if (charAt9 >= 'a' && charAt9 <= 'f') {
                                i2 = charAt9 - 'W';
                            } else if (charAt9 >= 'A' && charAt9 <= 'F') {
                                i2 = charAt9 - '7';
                                j6 = (j6 << 4) | i2;
                                i21++;
                            } else {
                                this.matchStat = -2;
                                return null;
                            }
                            j6 = (j6 << 4) | i2;
                            i21++;
                        }
                        uuid = new UUID(j5, j6);
                        int i23 = this.bp;
                        int length4 = i9 + (indexOf - ((cArr.length + i23) + 1)) + 1;
                        i = length4 + 1;
                        charAt = charAt(i23 + length4);
                    } else {
                        this.matchStat = -1;
                        return null;
                    }
                }
            } else {
                throw new JSONException("unclosed str");
            }
        } else {
            if (charAt2 == 'n') {
                int i24 = length + 2;
                if (charAt(this.bp + i9) == 'u') {
                    int i25 = length + 3;
                    if (charAt(this.bp + i24) == 'l') {
                        int i26 = length + 4;
                        if (charAt(this.bp + i25) == 'l') {
                            int i27 = length + 5;
                            charAt = charAt(this.bp + i26);
                            i = i27;
                            uuid = null;
                        }
                    }
                }
            }
            this.matchStat = -1;
            return null;
        }
        if (charAt == ',') {
            int i28 = this.bp + i;
            this.bp = i28;
            this.ch = charAt(i28);
            this.matchStat = 3;
            return uuid;
        }
        if (charAt == '}') {
            int i29 = i + 1;
            char charAt10 = charAt(this.bp + i);
            if (charAt10 == ',') {
                this.token = 16;
                int i30 = this.bp + i29;
                this.bp = i30;
                this.ch = charAt(i30);
            } else if (charAt10 == ']') {
                this.token = 15;
                int i31 = this.bp + i29;
                this.bp = i31;
                this.ch = charAt(i31);
            } else if (charAt10 == '}') {
                this.token = 13;
                int i32 = this.bp + i29;
                this.bp = i32;
                this.ch = charAt(i32);
            } else if (charAt10 == 26) {
                this.token = 20;
                this.bp += i;
                this.ch = JSONLexer.EOI;
            } else {
                this.matchStat = -1;
                return null;
            }
            this.matchStat = 4;
            return uuid;
        }
        this.matchStat = -1;
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00c3 A[ADDED_TO_REGION] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x00c5 -> B:41:0x00b4). Please report as a decompilation issue!!! */
    @Override // com.alibaba.fastjson.parser.JSONLexer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final float scanFloat(char r21) {
        /*
            Method dump skipped, instructions count: 426
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanFloat(char):float");
    }

    public final void scanHex() {
        char next;
        if (this.ch == 'x') {
            next();
            if (this.ch == '\'') {
                this.np = this.bp;
                next();
                if (this.ch == '\'') {
                    next();
                    this.token = 26;
                    return;
                }
                while (true) {
                    next = next();
                    if ((next < '0' || next > '9') && (next < 'A' || next > 'F')) {
                        break;
                    } else {
                        this.sp++;
                    }
                }
                if (next == '\'') {
                    this.sp++;
                    next();
                    this.token = 26;
                    return;
                } else {
                    throw new JSONException("illegal state. " + next);
                }
            }
            throw new JSONException("illegal state. " + this.ch);
        }
        throw new JSONException("illegal state. " + this.ch);
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
            return;
        }
        if ("new".equals(stringVal)) {
            this.token = 9;
            return;
        }
        if ("true".equals(stringVal)) {
            this.token = 6;
            return;
        }
        if ("false".equals(stringVal)) {
            this.token = 7;
            return;
        }
        if ("undefined".equals(stringVal)) {
            this.token = 23;
            return;
        }
        if ("Set".equals(stringVal)) {
            this.token = 21;
        } else if ("TreeSet".equals(stringVal)) {
            this.token = 22;
        } else {
            this.token = 18;
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
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
                if (charAt < '0' || charAt > '9') {
                    break;
                }
                i3 = (i3 * 10) + (charAt - '0');
                i = i2;
            }
            if (charAt == '.') {
                this.matchStat = -1;
                return 0;
            }
            if (i3 < 0) {
                this.matchStat = -1;
                return 0;
            }
            while (charAt != c) {
                if (isWhitespace(charAt)) {
                    char charAt3 = charAt(this.bp + i2);
                    i2++;
                    charAt = charAt3;
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
        if (charAt2 == 'n' && charAt(this.bp + i) == 'u' && charAt(this.bp + i + 1) == 'l' && charAt(this.bp + i + 2) == 'l') {
            this.matchStat = 5;
            int i5 = i + 4;
            char charAt4 = charAt(this.bp + i + 3);
            if (z && charAt4 == '\"') {
                charAt4 = charAt(this.bp + i5);
                i5 = i + 5;
            }
            while (charAt4 != ',') {
                if (charAt4 == ']') {
                    int i6 = this.bp + i5;
                    this.bp = i6;
                    this.ch = charAt(i6);
                    this.matchStat = 5;
                    this.token = 15;
                    return 0;
                }
                if (isWhitespace(charAt4)) {
                    charAt4 = charAt(this.bp + i5);
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
        }
        this.matchStat = -1;
        return 0;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
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
                long j = charAt2 - '0';
                while (true) {
                    i2 = i + 1;
                    charAt = charAt(this.bp + i);
                    if (charAt < '0' || charAt > c3) {
                        break;
                    }
                    j = (j * 10) + (charAt - '0');
                    i = i2;
                    c3 = '9';
                }
                if (charAt == '.') {
                    this.matchStat = -1;
                    return 0L;
                }
                if (j < 0 && (j != Long.MIN_VALUE || !z2)) {
                    throw new NumberFormatException(subString(this.bp, i));
                }
                if (z) {
                    if (charAt != '\"') {
                        this.matchStat = -1;
                        return 0L;
                    }
                    charAt = charAt(this.bp + i2);
                    c2 = c;
                    i2 = i + 2;
                } else {
                    c2 = c;
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
                    return 0L;
                }
                if (isWhitespace(charAt3)) {
                    charAt3 = charAt(this.bp + i4);
                    i4++;
                } else {
                    this.matchStat = -1;
                    return 0L;
                }
            }
            int i6 = this.bp + i4;
            this.bp = i6;
            this.ch = charAt(i6);
            this.matchStat = 5;
            this.token = 16;
            return 0L;
        }
        this.matchStat = -1;
        return 0L;
    }

    public final void scanNullOrNew() {
        scanNullOrNew(true);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00c6  */
    @Override // com.alibaba.fastjson.parser.JSONLexer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void scanNumber() {
        /*
            Method dump skipped, instructions count: 210
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanNumber():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:94:0x0171, code lost:
    
        throw new com.alibaba.fastjson.JSONException("invalid escape character \\x" + r5 + r7);
     */
    @Override // com.alibaba.fastjson.parser.JSONLexer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void scanString() {
        /*
            Method dump skipped, instructions count: 476
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanString():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0127, code lost:
    
        if (r1 != r18) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0129, code lost:
    
        r1 = r16.bp + r3;
        r16.bp = r1;
        r16.ch = charAt(r1);
        r16.matchStat = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0136, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0137, code lost:
    
        r16.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0139, code lost:
    
        return;
     */
    @Override // com.alibaba.fastjson.parser.JSONLexer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void scanStringArray(java.util.Collection<java.lang.String> r17, char r18) {
        /*
            Method dump skipped, instructions count: 325
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanStringArray(java.util.Collection, char):void");
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
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
        }
        if (c == '}') {
            next();
            this.token = 13;
            return null;
        }
        if (c == ',') {
            next();
            this.token = 16;
            return null;
        }
        if (c == 26) {
            this.token = 20;
            return null;
        }
        if (isEnabled(Feature.AllowUnQuotedFieldNames)) {
            return scanSymbolUnQuoted(symbolTable);
        }
        throw new JSONException("syntax error");
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final String scanSymbolUnQuoted(SymbolTable symbolTable) {
        if (this.token == 1 && this.pos == 0 && this.bp == 1) {
            this.bp = 0;
        }
        boolean[] zArr = com.alibaba.fastjson.util.IOUtils.firstIdentifierFlags;
        int i = this.ch;
        if (i < zArr.length && !zArr[i]) {
            throw new JSONException("illegal identifier : " + this.ch + info());
        }
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

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public String scanSymbolWithSeperator(SymbolTable symbolTable, char c) {
        int i = 0;
        this.matchStat = 0;
        char charAt = charAt(this.bp);
        if (charAt == 'n') {
            if (charAt(this.bp + 1) == 'u' && charAt(this.bp + 2) == 'l' && charAt(this.bp + 3) == 'l') {
                if (charAt(this.bp + 4) == c) {
                    int i2 = this.bp + 5;
                    this.bp = i2;
                    this.ch = charAt(i2);
                    this.matchStat = 3;
                    return null;
                }
                this.matchStat = -1;
                return null;
            }
            this.matchStat = -1;
            return null;
        }
        if (charAt != '\"') {
            this.matchStat = -1;
            return null;
        }
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
                        if (c != ' ' && c != ',' && c != '}' && c != ']' && c != '\n' && c != '\r' && c != '\t' && c != 26 && c != '\f' && c != '\b' && c != ':' && c != '/') {
                            throw new JSONException("scan true error");
                        }
                        this.token = 6;
                        return;
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
            } else {
                if (charAt2 != 26) {
                    return -1;
                }
                this.token = 20;
                this.matchStat = 4;
            }
            i4 = i;
            this.matchStat = 4;
        }
        this.bp = i4;
        return this.matchStat;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public String scanTypeName(SymbolTable symbolTable) {
        return null;
    }

    public UUID scanUUID(char c) {
        char charAt;
        int i;
        UUID uuid;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        this.matchStat = 0;
        char charAt2 = charAt(this.bp);
        if (charAt2 == '\"') {
            int indexOf = indexOf('\"', this.bp + 1);
            if (indexOf != -1) {
                int i9 = this.bp + 1;
                int i10 = indexOf - i9;
                char c2 = 'A';
                char c3 = 'f';
                char c4 = 'a';
                char c5 = '9';
                if (i10 == 36) {
                    int i11 = 0;
                    long j = 0;
                    while (i11 < 8) {
                        char charAt3 = charAt(i9 + i11);
                        if (charAt3 >= '0' && charAt3 <= '9') {
                            i8 = charAt3 - '0';
                        } else if (charAt3 >= 'a' && charAt3 <= 'f') {
                            i8 = charAt3 - 'W';
                        } else {
                            if (charAt3 < c2 || charAt3 > 'F') {
                                this.matchStat = -2;
                                return null;
                            }
                            i8 = charAt3 - '7';
                        }
                        j = (j << 4) | i8;
                        i11++;
                        indexOf = indexOf;
                        c2 = 'A';
                    }
                    int i12 = indexOf;
                    int i13 = 9;
                    while (i13 < 13) {
                        char charAt4 = charAt(i9 + i13);
                        if (charAt4 >= '0' && charAt4 <= '9') {
                            i7 = charAt4 - '0';
                        } else if (charAt4 >= 'a' && charAt4 <= c3) {
                            i7 = charAt4 - 'W';
                        } else {
                            if (charAt4 < 'A' || charAt4 > 'F') {
                                this.matchStat = -2;
                                return null;
                            }
                            i7 = charAt4 - '7';
                        }
                        j = (j << 4) | i7;
                        i13++;
                        c3 = 'f';
                    }
                    int i14 = 14;
                    long j2 = j;
                    while (i14 < 18) {
                        char charAt5 = charAt(i9 + i14);
                        if (charAt5 >= '0' && charAt5 <= c5) {
                            i6 = charAt5 - '0';
                        } else if (charAt5 >= 'a' && charAt5 <= 'f') {
                            i6 = charAt5 - 'W';
                        } else {
                            if (charAt5 < 'A' || charAt5 > 'F') {
                                this.matchStat = -2;
                                return null;
                            }
                            i6 = charAt5 - '7';
                        }
                        j2 = (j2 << 4) | i6;
                        i14++;
                        c5 = '9';
                    }
                    int i15 = 19;
                    long j3 = 0;
                    while (i15 < 23) {
                        char charAt6 = charAt(i9 + i15);
                        if (charAt6 >= '0' && charAt6 <= '9') {
                            i5 = charAt6 - '0';
                        } else if (charAt6 >= c4 && charAt6 <= 'f') {
                            i5 = charAt6 - 'W';
                        } else {
                            if (charAt6 < 'A' || charAt6 > 'F') {
                                this.matchStat = -2;
                                return null;
                            }
                            i5 = charAt6 - '7';
                        }
                        j3 = (j3 << 4) | i5;
                        i15++;
                        c4 = 'a';
                    }
                    long j4 = j3;
                    for (int i16 = 24; i16 < 36; i16++) {
                        char charAt7 = charAt(i9 + i16);
                        if (charAt7 >= '0' && charAt7 <= '9') {
                            i4 = charAt7 - '0';
                        } else if (charAt7 >= 'a' && charAt7 <= 'f') {
                            i4 = charAt7 - 'W';
                        } else {
                            if (charAt7 < 'A' || charAt7 > 'F') {
                                this.matchStat = -2;
                                return null;
                            }
                            i4 = charAt7 - '7';
                        }
                        j4 = (j4 << 4) | i4;
                    }
                    uuid = new UUID(j2, j4);
                    int i17 = this.bp;
                    int i18 = i12 - (i17 + 1);
                    int i19 = i18 + 2;
                    i = i18 + 3;
                    charAt = charAt(i17 + i19);
                } else {
                    if (i10 == 32) {
                        int i20 = 0;
                        long j5 = 0;
                        for (int i21 = 16; i20 < i21; i21 = 16) {
                            char charAt8 = charAt(i9 + i20);
                            if (charAt8 >= '0' && charAt8 <= '9') {
                                i3 = charAt8 - '0';
                            } else if (charAt8 >= 'a' && charAt8 <= 'f') {
                                i3 = charAt8 - 'W';
                            } else {
                                if (charAt8 < 'A' || charAt8 > 'F') {
                                    this.matchStat = -2;
                                    return null;
                                }
                                i3 = charAt8 - '7';
                            }
                            j5 = (j5 << 4) | i3;
                            i20++;
                        }
                        int i22 = 16;
                        long j6 = 0;
                        for (int i23 = 32; i22 < i23; i23 = 32) {
                            char charAt9 = charAt(i9 + i22);
                            if (charAt9 >= '0' && charAt9 <= '9') {
                                i2 = charAt9 - '0';
                            } else if (charAt9 >= 'a' && charAt9 <= 'f') {
                                i2 = charAt9 - 'W';
                            } else if (charAt9 >= 'A' && charAt9 <= 'F') {
                                i2 = charAt9 - '7';
                                j6 = (j6 << 4) | i2;
                                i22++;
                            } else {
                                this.matchStat = -2;
                                return null;
                            }
                            j6 = (j6 << 4) | i2;
                            i22++;
                        }
                        uuid = new UUID(j5, j6);
                        int i24 = this.bp;
                        int i25 = indexOf - (i24 + 1);
                        int i26 = i25 + 2;
                        i = i25 + 3;
                        charAt = charAt(i24 + i26);
                    } else {
                        this.matchStat = -1;
                        return null;
                    }
                }
            } else {
                throw new JSONException("unclosed str");
            }
        } else if (charAt2 == 'n' && charAt(this.bp + 1) == 'u' && charAt(this.bp + 2) == 'l' && charAt(this.bp + 3) == 'l') {
            charAt = charAt(this.bp + 4);
            i = 5;
            uuid = null;
        } else {
            this.matchStat = -1;
            return null;
        }
        if (charAt == ',') {
            int i27 = this.bp + i;
            this.bp = i27;
            this.ch = charAt(i27);
            this.matchStat = 3;
            return uuid;
        }
        if (charAt == ']') {
            int i28 = i + 1;
            char charAt10 = charAt(this.bp + i);
            if (charAt10 == ',') {
                this.token = 16;
                int i29 = this.bp + i28;
                this.bp = i29;
                this.ch = charAt(i29);
            } else if (charAt10 == ']') {
                this.token = 15;
                int i30 = this.bp + i28;
                this.bp = i30;
                this.ch = charAt(i30);
            } else if (charAt10 == '}') {
                this.token = 13;
                int i31 = this.bp + i28;
                this.bp = i31;
                this.ch = charAt(i31);
            } else if (charAt10 == 26) {
                this.token = 20;
                this.bp += i;
                this.ch = JSONLexer.EOI;
            } else {
                this.matchStat = -1;
                return null;
            }
            this.matchStat = 4;
            return uuid;
        }
        this.matchStat = -1;
        return null;
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

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public void setFeatures(int i) {
        this.features = i;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public void setTimeZone(TimeZone timeZone) {
        this.timeZone = timeZone;
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
        if (c2 != '/') {
            if (c2 == '*') {
                next();
                while (true) {
                    char c3 = this.ch;
                    if (c3 != 26) {
                        if (c3 == '*') {
                            next();
                            if (this.ch == '/') {
                                next();
                                return;
                            }
                        } else {
                            next();
                        }
                    } else {
                        return;
                    }
                }
            } else {
                throw new JSONException("invalid comment");
            }
        }
        do {
            next();
            c = this.ch;
            if (c == '\n') {
                next();
                return;
            }
        } while (c != 26);
    }

    public void skipObject() {
        throw new UnsupportedOperationException();
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void skipWhitespace() {
        while (true) {
            char c = this.ch;
            if (c <= '/') {
                if (c != ' ' && c != '\r' && c != '\n' && c != '\t' && c != '\f' && c != '\b') {
                    if (c == '/') {
                        skipComment();
                    } else {
                        return;
                    }
                } else {
                    next();
                }
            } else {
                return;
            }
        }
    }

    public final String stringDefaultValue() {
        return this.stringDefaultValue;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public abstract String stringVal();

    public abstract String subString(int i, int i2);

    public abstract char[] sub_chars(int i, int i2);

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final int token() {
        return this.token;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final String tokenName() {
        return JSONToken.name(this.token);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final boolean isEnabled(int i) {
        return (i & this.features) != 0;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void nextTokenWithColon(int i) {
        nextTokenWithChar(':');
    }

    public final void scanNullOrNew(boolean z) {
        if (this.ch == 'n') {
            next();
            char c = this.ch;
            if (c != 'u') {
                if (c == 'e') {
                    next();
                    if (this.ch == 'w') {
                        next();
                        char c2 = this.ch;
                        if (c2 != ' ' && c2 != ',' && c2 != '}' && c2 != ']' && c2 != '\n' && c2 != '\r' && c2 != '\t' && c2 != 26 && c2 != '\f' && c2 != '\b') {
                            throw new JSONException("scan new error");
                        }
                        this.token = 9;
                        return;
                    }
                    throw new JSONException("error parse new");
                }
                throw new JSONException("error parse new");
            }
            next();
            if (this.ch == 'l') {
                next();
                if (this.ch == 'l') {
                    next();
                    char c3 = this.ch;
                    if (c3 != ' ' && c3 != ',' && c3 != '}' && c3 != ']' && c3 != '\n' && c3 != '\r' && c3 != '\t' && c3 != 26 && ((c3 != ':' || !z) && c3 != '\f' && c3 != '\b')) {
                        throw new JSONException("scan null error");
                    }
                    this.token = 8;
                    return;
                }
                throw new JSONException("error parse null");
            }
            throw new JSONException("error parse null");
        }
        throw new JSONException("error parse null or new");
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

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final String scanSymbol(SymbolTable symbolTable, char c) {
        String addSymbol;
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
                    addSymbol = addSymbol(i2 == -1 ? 0 : i2 + 1, this.sp, i, symbolTable);
                } else {
                    addSymbol = symbolTable.addSymbol(this.sbuf, 0, this.sp, i);
                }
                this.sp = 0;
                next();
                return addSymbol;
            }
            if (next == 26) {
                throw new JSONException("unclosed.str");
            }
            if (next == '\\') {
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
                            putChar('\b');
                        } else if (next2 != 'f') {
                            if (next2 == 'n') {
                                i = (i * 31) + 10;
                                putChar('\n');
                            } else if (next2 == 'r') {
                                i = (i * 31) + 13;
                                putChar('\r');
                            } else if (next2 != 'x') {
                                switch (next2) {
                                    case '/':
                                        i = (i * 31) + 47;
                                        putChar(IOUtils.DIR_SEPARATOR_UNIX);
                                        break;
                                    case '0':
                                        i = (i * 31) + next2;
                                        putChar((char) 0);
                                        break;
                                    case '1':
                                        i = (i * 31) + next2;
                                        putChar((char) 1);
                                        break;
                                    case '2':
                                        i = (i * 31) + next2;
                                        putChar((char) 2);
                                        break;
                                    case '3':
                                        i = (i * 31) + next2;
                                        putChar((char) 3);
                                        break;
                                    case '4':
                                        i = (i * 31) + next2;
                                        putChar((char) 4);
                                        break;
                                    case '5':
                                        i = (i * 31) + next2;
                                        putChar((char) 5);
                                        break;
                                    case '6':
                                        i = (i * 31) + next2;
                                        putChar((char) 6);
                                        break;
                                    case '7':
                                        i = (i * 31) + next2;
                                        putChar((char) 7);
                                        break;
                                    default:
                                        switch (next2) {
                                            case 't':
                                                i = (i * 31) + 9;
                                                putChar('\t');
                                                break;
                                            case 'u':
                                                int parseInt = Integer.parseInt(new String(new char[]{next(), next(), next(), next()}), 16);
                                                i = (i * 31) + parseInt;
                                                putChar((char) parseInt);
                                                break;
                                            case 'v':
                                                i = (i * 31) + 11;
                                                putChar((char) 11);
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
                    putChar('\f');
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

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:12:0x0029. Please report as an issue. */
    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void nextToken(int i) {
        this.sp = 0;
        while (true) {
            if (i == 2) {
                char c = this.ch;
                if (c >= '0' && c <= '9') {
                    this.pos = this.bp;
                    scanNumber();
                    return;
                }
                if (c == '\"') {
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
                }
                if (c2 >= '0' && c2 <= '9') {
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
                            }
                            if (c5 == '}') {
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
            if (c6 != ' ' && c6 != '\n' && c6 != '\r' && c6 != '\t' && c6 != '\f' && c6 != '\b') {
                nextToken();
                return;
            }
            next();
        }
    }

    public String[] scanFieldStringArray(char[] cArr, int i, SymbolTable symbolTable) {
        throw new UnsupportedOperationException();
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public String scanString(char c) {
        this.matchStat = 0;
        char charAt = charAt(this.bp);
        if (charAt == 'n') {
            if (charAt(this.bp + 1) == 'u' && charAt(this.bp + 2) == 'l' && charAt(this.bp + 3) == 'l') {
                if (charAt(this.bp + 4) == c) {
                    int i = this.bp + 5;
                    this.bp = i;
                    this.ch = charAt(i);
                    this.matchStat = 3;
                    return null;
                }
                this.matchStat = -1;
                return null;
            }
            this.matchStat = -1;
            return null;
        }
        int i2 = 1;
        while (charAt != '\"') {
            if (isWhitespace(charAt)) {
                charAt = charAt(this.bp + i2);
                i2++;
            } else {
                this.matchStat = -1;
                return stringDefaultValue();
            }
        }
        int i3 = this.bp + i2;
        int indexOf = indexOf('\"', i3);
        if (indexOf != -1) {
            String subString = subString(this.bp + i2, indexOf - i3);
            if (subString.indexOf(92) != -1) {
                while (true) {
                    int i4 = 0;
                    for (int i5 = indexOf - 1; i5 >= 0 && charAt(i5) == '\\'; i5--) {
                        i4++;
                    }
                    if (i4 % 2 == 0) {
                        break;
                    }
                    indexOf = indexOf('\"', indexOf + 1);
                }
                int i6 = indexOf - i3;
                subString = readString(sub_chars(this.bp + 1, i6), i6);
            }
            int i7 = i2 + (indexOf - i3) + 1;
            int i8 = i7 + 1;
            char charAt2 = charAt(this.bp + i7);
            while (charAt2 != c) {
                if (!isWhitespace(charAt2)) {
                    if (charAt2 == ']') {
                        int i9 = this.bp + i8;
                        this.bp = i9;
                        this.ch = charAt(i9);
                        this.matchStat = -1;
                    }
                    return subString;
                }
                charAt2 = charAt(this.bp + i8);
                i8++;
            }
            int i10 = this.bp + i8;
            this.bp = i10;
            this.ch = charAt(i10);
            this.matchStat = 3;
            this.token = 16;
            return subString;
        }
        throw new JSONException("unclosed str");
    }
}
