package com.alibaba.fastjson.parser;

import XIXIX.OOXIXo;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.ASMUtils;
import com.alibaba.fastjson.util.IOUtils;
import com.alibaba.fastjson.util.TypeUtils;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.SimpleTimeZone;

public final class JSONScanner extends JSONLexerBase {
    private final int len;
    private final String text;

    public JSONScanner(String str) {
        this(str, JSON.DEFAULT_PARSER_FEATURE);
    }

    public static boolean charArrayCompare(String str, int i, char[] cArr) {
        int length = cArr.length;
        if (length + i > str.length()) {
            return false;
        }
        for (int i2 = 0; i2 < length; i2++) {
            if (cArr[i2] != str.charAt(i + i2)) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkDate(char c, char c2, char c3, char c4, char c5, char c6, int i, int i2) {
        if (c >= '0' && c <= '9' && c2 >= '0' && c2 <= '9' && c3 >= '0' && c3 <= '9' && c4 >= '0' && c4 <= '9') {
            if (c5 == '0') {
                if (c6 < '1' || c6 > '9') {
                    return false;
                }
            } else if (!(c5 == '1' && (c6 == '0' || c6 == '1' || c6 == '2'))) {
                return false;
            }
            return i == 48 ? i2 >= 49 && i2 <= 57 : (i == 49 || i == 50) ? i2 >= 48 && i2 <= 57 : i == 51 && (i2 == 48 || i2 == 49);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001d, code lost:
        if (r6 <= '4') goto L_0x0020;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean checkTime(char r5, char r6, char r7, char r8, char r9, char r10) {
        /*
            r4 = this;
            r0 = 57
            r1 = 0
            r2 = 48
            if (r5 != r2) goto L_0x000c
            if (r6 < r2) goto L_0x000b
            if (r6 <= r0) goto L_0x0020
        L_0x000b:
            return r1
        L_0x000c:
            r3 = 49
            if (r5 != r3) goto L_0x0015
            if (r6 < r2) goto L_0x0014
            if (r6 <= r0) goto L_0x0020
        L_0x0014:
            return r1
        L_0x0015:
            r3 = 50
            if (r5 != r3) goto L_0x0042
            if (r6 < r2) goto L_0x0042
            r5 = 52
            if (r6 <= r5) goto L_0x0020
            goto L_0x0042
        L_0x0020:
            r5 = 54
            r6 = 53
            if (r7 < r2) goto L_0x002d
            if (r7 > r6) goto L_0x002d
            if (r8 < r2) goto L_0x002c
            if (r8 <= r0) goto L_0x0032
        L_0x002c:
            return r1
        L_0x002d:
            if (r7 != r5) goto L_0x0042
            if (r8 == r2) goto L_0x0032
            return r1
        L_0x0032:
            if (r9 < r2) goto L_0x003b
            if (r9 > r6) goto L_0x003b
            if (r10 < r2) goto L_0x003a
            if (r10 <= r0) goto L_0x0040
        L_0x003a:
            return r1
        L_0x003b:
            if (r9 != r5) goto L_0x0042
            if (r10 == r2) goto L_0x0040
            return r1
        L_0x0040:
            r5 = 1
            return r5
        L_0x0042:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONScanner.checkTime(char, char, char, char, char, char):boolean");
    }

    private void setCalendar(char c, char c2, char c3, char c4, char c5, char c6, char c7, char c8) {
        Calendar instance = Calendar.getInstance(this.timeZone, this.locale);
        this.calendar = instance;
        instance.set(1, ((c - '0') * 1000) + ((c2 - '0') * 100) + ((c3 - '0') * 10) + (c4 - '0'));
        this.calendar.set(2, (((c5 - '0') * 10) + (c6 - '0')) - 1);
        this.calendar.set(5, ((c7 - '0') * 10) + (c8 - '0'));
    }

    public final String addSymbol(int i, int i2, int i3, SymbolTable symbolTable) {
        return symbolTable.addSymbol(this.text, i, i2, i3);
    }

    public final void arrayCopy(int i, char[] cArr, int i2, int i3) {
        this.text.getChars(i, i3 + i, cArr, i2);
    }

    public byte[] bytesValue() {
        char c;
        if (this.token == 26) {
            int i = this.np + 1;
            int i2 = this.sp;
            if (i2 % 2 == 0) {
                int i3 = i2 / 2;
                byte[] bArr = new byte[i3];
                for (int i4 = 0; i4 < i3; i4++) {
                    int i5 = (i4 * 2) + i;
                    char charAt = this.text.charAt(i5);
                    char charAt2 = this.text.charAt(i5 + 1);
                    char c2 = '7';
                    if (charAt <= '9') {
                        c = '0';
                    } else {
                        c = '7';
                    }
                    int i6 = charAt - c;
                    if (charAt2 <= '9') {
                        c2 = '0';
                    }
                    bArr[i4] = (byte) ((i6 << 4) | (charAt2 - c2));
                }
                return bArr;
            }
            throw new JSONException("illegal state. " + i2);
        } else if (!this.hasSpecial) {
            return IOUtils.decodeBase64(this.text, this.np + 1, this.sp);
        } else {
            return IOUtils.decodeBase64(new String(this.sbuf, 0, this.sp));
        }
    }

    public final char charAt(int i) {
        if (i >= this.len) {
            return JSONLexer.EOI;
        }
        return this.text.charAt(i);
    }

    public final void copyTo(int i, int i2, char[] cArr) {
        this.text.getChars(i, i2 + i, cArr, 0);
    }

    public final BigDecimal decimalValue() {
        char charAt = charAt((this.np + this.sp) - 1);
        int i = this.sp;
        if (charAt == 'L' || charAt == 'S' || charAt == 'B' || charAt == 'F' || charAt == 'D') {
            i--;
        }
        if (i <= 65535) {
            int i2 = this.np;
            char[] cArr = this.sbuf;
            if (i < cArr.length) {
                this.text.getChars(i2, i2 + i, cArr, 0);
                return new BigDecimal(this.sbuf, 0, i, MathContext.UNLIMITED);
            }
            char[] cArr2 = new char[i];
            this.text.getChars(i2, i2 + i, cArr2, 0);
            return new BigDecimal(cArr2, 0, i, MathContext.UNLIMITED);
        }
        throw new JSONException("decimal overflow");
    }

    public final int indexOf(char c, int i) {
        return this.text.indexOf(c, i);
    }

    public String info() {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int i2 = 1;
        int i3 = 1;
        while (i < this.bp) {
            if (this.text.charAt(i) == 10) {
                i2++;
                i3 = 1;
            }
            i++;
            i3++;
        }
        sb.append("pos ");
        sb.append(this.bp);
        sb.append(", line ");
        sb.append(i2);
        sb.append(", column ");
        sb.append(i3);
        if (this.text.length() < 65535) {
            sb.append(this.text);
        } else {
            sb.append(this.text.substring(0, 65535));
        }
        return sb.toString();
    }

    public boolean isEOF() {
        int i = this.bp;
        int i2 = this.len;
        if (i == i2) {
            return true;
        }
        if (this.ch != 26 || i + 1 < i2) {
            return false;
        }
        return true;
    }

    public boolean matchField2(char[] cArr) {
        while (JSONLexerBase.isWhitespace(this.ch)) {
            next();
        }
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return false;
        }
        int length = this.bp + cArr.length;
        int i = length + 1;
        char charAt = this.text.charAt(length);
        while (JSONLexerBase.isWhitespace(charAt)) {
            charAt = this.text.charAt(i);
            i++;
        }
        if (charAt == ':') {
            this.bp = i;
            this.ch = charAt(i);
            return true;
        }
        this.matchStat = -2;
        return false;
    }

    public final char next() {
        char c;
        int i = this.bp + 1;
        this.bp = i;
        if (i >= this.len) {
            c = JSONLexer.EOI;
        } else {
            c = this.text.charAt(i);
        }
        this.ch = c;
        return c;
    }

    public final String numberString() {
        char charAt = charAt((this.np + this.sp) - 1);
        int i = this.sp;
        if (charAt == 'L' || charAt == 'S' || charAt == 'B' || charAt == 'F' || charAt == 'D') {
            i--;
        }
        return subString(this.np, i);
    }

    public Date scanDate(char c) {
        char c2;
        Date date;
        long j;
        char c3;
        char charAt;
        boolean z = false;
        this.matchStat = 0;
        int i = this.bp;
        char c4 = this.ch;
        int i2 = i + 1;
        char charAt2 = charAt(i);
        if (charAt2 == '\"') {
            int indexOf = indexOf('\"', i2);
            if (indexOf != -1) {
                this.bp = i2;
                if (scanISO8601DateIfMatch(false, indexOf - i2)) {
                    date = this.calendar.getTime();
                    c2 = charAt(indexOf + 1);
                    this.bp = i;
                    while (c2 != ',' && c2 != ']') {
                        if (JSONLexerBase.isWhitespace(c2)) {
                            char charAt3 = charAt(indexOf + 2);
                            indexOf++;
                            c2 = charAt3;
                        } else {
                            this.bp = i;
                            this.ch = c4;
                            this.matchStat = -1;
                            return null;
                        }
                    }
                    this.bp = indexOf + 1;
                    this.ch = c2;
                } else {
                    this.bp = i;
                    this.ch = c4;
                    this.matchStat = -1;
                    return null;
                }
            } else {
                throw new JSONException("unclosed str");
            }
        } else {
            char c5 = '9';
            char c6 = '0';
            if (charAt2 == '-' || (charAt2 >= '0' && charAt2 <= '9')) {
                if (charAt2 == '-') {
                    charAt2 = charAt(i2);
                    i2 = i + 2;
                    z = true;
                }
                if (charAt2 < '0' || charAt2 > '9') {
                    c3 = charAt2;
                    j = 0;
                } else {
                    j = (long) (charAt2 - '0');
                    while (true) {
                        int i3 = i2 + 1;
                        charAt = charAt(i2);
                        if (charAt >= c6 && charAt <= c5) {
                            j = (j * 10) + ((long) (charAt - '0'));
                            i2 = i3;
                            c5 = '9';
                            c6 = '0';
                        } else if (charAt == ',' || charAt == ']') {
                            this.bp = i2;
                        }
                    }
                    this.bp = i2;
                    c3 = charAt;
                }
                if (j < 0) {
                    this.bp = i;
                    this.ch = c4;
                    this.matchStat = -1;
                    return null;
                }
                if (z) {
                    j = -j;
                }
                date = new Date(j);
            } else {
                if (charAt2 == 'n') {
                    int i4 = i + 2;
                    if (charAt(i2) == 'u') {
                        int i5 = i + 3;
                        if (charAt(i4) == 'l') {
                            int i6 = i + 4;
                            if (charAt(i5) == 'l') {
                                c2 = charAt(i6);
                                this.bp = i6;
                                date = null;
                            }
                        }
                    }
                }
                this.bp = i;
                this.ch = c4;
                this.matchStat = -1;
                return null;
            }
        }
        if (c2 == ',') {
            int i7 = this.bp + 1;
            this.bp = i7;
            this.ch = charAt(i7);
            this.matchStat = 3;
            return date;
        }
        int i8 = this.bp + 1;
        this.bp = i8;
        char charAt4 = charAt(i8);
        if (charAt4 == ',') {
            this.token = 16;
            int i9 = this.bp + 1;
            this.bp = i9;
            this.ch = charAt(i9);
        } else if (charAt4 == ']') {
            this.token = 15;
            int i10 = this.bp + 1;
            this.bp = i10;
            this.ch = charAt(i10);
        } else if (charAt4 == '}') {
            this.token = 13;
            int i11 = this.bp + 1;
            this.bp = i11;
            this.ch = charAt(i11);
        } else if (charAt4 == 26) {
            this.ch = JSONLexer.EOI;
            this.token = 20;
        } else {
            this.bp = i;
            this.ch = c4;
            this.matchStat = -1;
            return null;
        }
        this.matchStat = 4;
        return date;
    }

    public double scanDouble(char c) {
        boolean z;
        boolean z2;
        long j;
        int i;
        char charAt;
        int i2;
        long j2;
        char c2;
        boolean z3;
        int i3;
        int i4;
        double parseDouble;
        char charAt2;
        this.matchStat = 0;
        int i5 = this.bp;
        int i6 = i5 + 1;
        char charAt3 = charAt(i5);
        if (charAt3 == '\"') {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            charAt3 = charAt(i6);
            i6 = i5 + 2;
        }
        if (charAt3 == '-') {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            charAt3 = charAt(i6);
            i6++;
        }
        if (charAt3 >= '0') {
            char c3 = '9';
            if (charAt3 <= '9') {
                long j3 = (long) (charAt3 - '0');
                while (true) {
                    i = i6 + 1;
                    charAt = charAt(i6);
                    if (charAt >= '0' && charAt <= '9') {
                        j3 = (j * 10) + ((long) (charAt - '0'));
                        i6 = i;
                    }
                }
                if (charAt == '.') {
                    int i7 = i6 + 2;
                    char charAt4 = charAt(i);
                    if (charAt4 < '0' || charAt4 > '9') {
                        this.matchStat = -1;
                        return OOXIXo.f29376XO;
                    }
                    j = (j * 10) + ((long) (charAt4 - '0'));
                    long j4 = 10;
                    while (true) {
                        i = i7 + 1;
                        charAt2 = charAt(i7);
                        if (charAt2 < '0' || charAt2 > c3) {
                            long j5 = j4;
                            charAt = charAt2;
                            j2 = j5;
                        } else {
                            j = (j * 10) + ((long) (charAt2 - '0'));
                            j4 *= 10;
                            i7 = i;
                            c3 = '9';
                        }
                    }
                    long j52 = j4;
                    charAt = charAt2;
                    j2 = j52;
                } else {
                    j2 = 1;
                }
                if (c2 == 'e' || c2 == 'E') {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3) {
                    int i8 = i2 + 1;
                    char charAt5 = charAt(i2);
                    if (charAt5 == '+' || charAt5 == '-') {
                        i2 += 2;
                        c2 = charAt(i8);
                    } else {
                        i2 = i8;
                        c2 = charAt5;
                    }
                    while (c2 >= '0' && c2 <= '9') {
                        char charAt6 = charAt(i2);
                        i2++;
                        c2 = charAt6;
                    }
                }
                if (!z) {
                    i4 = this.bp;
                    i3 = (i2 - i4) - 1;
                } else if (c2 != '\"') {
                    this.matchStat = -1;
                    return OOXIXo.f29376XO;
                } else {
                    int i9 = i2 + 1;
                    char charAt7 = charAt(i2);
                    i4 = this.bp + 1;
                    i3 = (i9 - i4) - 2;
                    char c4 = charAt7;
                    i2 = i9;
                    c2 = c4;
                }
                if (z3 || i3 >= 18) {
                    parseDouble = Double.parseDouble(subString(i4, i3));
                } else {
                    parseDouble = ((double) j) / ((double) j2);
                    if (z2) {
                        parseDouble = -parseDouble;
                    }
                }
                if (c2 == c) {
                    this.bp = i2;
                    this.ch = charAt(i2);
                    this.matchStat = 3;
                    this.token = 16;
                    return parseDouble;
                }
                this.matchStat = -1;
                return parseDouble;
            }
        }
        if (charAt3 == 'n') {
            int i10 = i6 + 1;
            if (charAt(i6) == 'u') {
                int i11 = i6 + 2;
                if (charAt(i10) == 'l') {
                    int i12 = i6 + 3;
                    if (charAt(i11) == 'l') {
                        this.matchStat = 5;
                        int i13 = i6 + 4;
                        char charAt8 = charAt(i12);
                        if (z && charAt8 == '\"') {
                            charAt8 = charAt(i13);
                            i13 = i6 + 5;
                        }
                        while (charAt8 != ',') {
                            if (charAt8 == ']') {
                                this.bp = i13;
                                this.ch = charAt(i13);
                                this.matchStat = 5;
                                this.token = 15;
                                return OOXIXo.f29376XO;
                            } else if (JSONLexerBase.isWhitespace(charAt8)) {
                                char charAt9 = charAt(i13);
                                i13++;
                                charAt8 = charAt9;
                            } else {
                                this.matchStat = -1;
                                return OOXIXo.f29376XO;
                            }
                        }
                        this.bp = i13;
                        this.ch = charAt(i13);
                        this.matchStat = 5;
                        this.token = 16;
                        return OOXIXo.f29376XO;
                    }
                }
            }
        }
        this.matchStat = -1;
        return OOXIXo.f29376XO;
    }

    /* JADX WARNING: Removed duplicated region for block: B:106:0x00f3 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0104  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean scanFieldBoolean(char[] r12) {
        /*
            r11 = this;
            r0 = 0
            r11.matchStat = r0
            java.lang.String r1 = r11.text
            int r2 = r11.bp
            boolean r1 = charArrayCompare(r1, r2, r12)
            if (r1 != 0) goto L_0x0011
            r12 = -2
            r11.matchStat = r12
            return r0
        L_0x0011:
            int r1 = r11.bp
            int r12 = r12.length
            int r12 = r12 + r1
            int r2 = r12 + 1
            char r3 = r11.charAt(r12)
            r4 = 34
            r5 = 1
            if (r3 != r4) goto L_0x0022
            r6 = 1
            goto L_0x0023
        L_0x0022:
            r6 = 0
        L_0x0023:
            if (r6 == 0) goto L_0x002c
            int r12 = r12 + 2
            char r3 = r11.charAt(r2)
            r2 = r12
        L_0x002c:
            r12 = 116(0x74, float:1.63E-43)
            r7 = 101(0x65, float:1.42E-43)
            r8 = 4
            r9 = -1
            if (r3 != r12) goto L_0x006f
            int r12 = r2 + 1
            char r3 = r11.charAt(r2)
            r10 = 114(0x72, float:1.6E-43)
            if (r3 == r10) goto L_0x0041
            r11.matchStat = r9
            return r0
        L_0x0041:
            int r3 = r2 + 2
            char r12 = r11.charAt(r12)
            r10 = 117(0x75, float:1.64E-43)
            if (r12 == r10) goto L_0x004e
            r11.matchStat = r9
            return r0
        L_0x004e:
            int r12 = r2 + 3
            char r3 = r11.charAt(r3)
            if (r3 == r7) goto L_0x0059
            r11.matchStat = r9
            return r0
        L_0x0059:
            if (r6 == 0) goto L_0x0066
            int r2 = r2 + r8
            char r12 = r11.charAt(r12)
            if (r12 == r4) goto L_0x0065
            r11.matchStat = r9
            return r0
        L_0x0065:
            r12 = r2
        L_0x0066:
            r11.bp = r12
            char r12 = r11.charAt(r12)
        L_0x006c:
            r2 = 1
            goto L_0x00ed
        L_0x006f:
            r12 = 102(0x66, float:1.43E-43)
            if (r3 != r12) goto L_0x00bb
            int r12 = r2 + 1
            char r3 = r11.charAt(r2)
            r10 = 97
            if (r3 == r10) goto L_0x0080
            r11.matchStat = r9
            return r0
        L_0x0080:
            int r3 = r2 + 2
            char r12 = r11.charAt(r12)
            r10 = 108(0x6c, float:1.51E-43)
            if (r12 == r10) goto L_0x008d
            r11.matchStat = r9
            return r0
        L_0x008d:
            int r12 = r2 + 3
            char r3 = r11.charAt(r3)
            r10 = 115(0x73, float:1.61E-43)
            if (r3 == r10) goto L_0x009a
            r11.matchStat = r9
            return r0
        L_0x009a:
            int r3 = r2 + 4
            char r12 = r11.charAt(r12)
            if (r12 == r7) goto L_0x00a5
            r11.matchStat = r9
            return r0
        L_0x00a5:
            if (r6 == 0) goto L_0x00b3
            int r2 = r2 + 5
            char r12 = r11.charAt(r3)
            if (r12 == r4) goto L_0x00b2
            r11.matchStat = r9
            return r0
        L_0x00b2:
            r3 = r2
        L_0x00b3:
            r11.bp = r3
            char r12 = r11.charAt(r3)
        L_0x00b9:
            r2 = 0
            goto L_0x00ed
        L_0x00bb:
            r12 = 49
            if (r3 != r12) goto L_0x00d4
            if (r6 == 0) goto L_0x00cd
            int r12 = r2 + 1
            char r2 = r11.charAt(r2)
            if (r2 == r4) goto L_0x00cc
            r11.matchStat = r9
            return r0
        L_0x00cc:
            r2 = r12
        L_0x00cd:
            r11.bp = r2
            char r12 = r11.charAt(r2)
            goto L_0x006c
        L_0x00d4:
            r12 = 48
            if (r3 != r12) goto L_0x017e
            if (r6 == 0) goto L_0x00e6
            int r12 = r2 + 1
            char r2 = r11.charAt(r2)
            if (r2 == r4) goto L_0x00e5
            r11.matchStat = r9
            return r0
        L_0x00e5:
            r2 = r12
        L_0x00e6:
            r11.bp = r2
            char r12 = r11.charAt(r2)
            goto L_0x00b9
        L_0x00ed:
            r3 = 16
            r4 = 44
            if (r12 != r4) goto L_0x0104
            int r12 = r11.bp
            int r12 = r12 + r5
            r11.bp = r12
            char r12 = r11.charAt(r12)
            r11.ch = r12
            r12 = 3
            r11.matchStat = r12
            r11.token = r3
            goto L_0x0151
        L_0x0104:
            r6 = 125(0x7d, float:1.75E-43)
            if (r12 != r6) goto L_0x0165
            int r12 = r11.bp
            int r12 = r12 + r5
            r11.bp = r12
            char r12 = r11.charAt(r12)
        L_0x0111:
            if (r12 != r4) goto L_0x0121
            r11.token = r3
            int r12 = r11.bp
            int r12 = r12 + r5
            r11.bp = r12
            char r12 = r11.charAt(r12)
            r11.ch = r12
            goto L_0x014f
        L_0x0121:
            r1 = 93
            if (r12 != r1) goto L_0x0135
            r12 = 15
            r11.token = r12
            int r12 = r11.bp
            int r12 = r12 + r5
            r11.bp = r12
            char r12 = r11.charAt(r12)
            r11.ch = r12
            goto L_0x014f
        L_0x0135:
            if (r12 != r6) goto L_0x0147
            r12 = 13
            r11.token = r12
            int r12 = r11.bp
            int r12 = r12 + r5
            r11.bp = r12
            char r12 = r11.charAt(r12)
            r11.ch = r12
            goto L_0x014f
        L_0x0147:
            r1 = 26
            if (r12 != r1) goto L_0x0152
            r12 = 20
            r11.token = r12
        L_0x014f:
            r11.matchStat = r8
        L_0x0151:
            return r2
        L_0x0152:
            boolean r12 = com.alibaba.fastjson.parser.JSONLexerBase.isWhitespace(r12)
            if (r12 == 0) goto L_0x0162
            int r12 = r11.bp
            int r12 = r12 + r5
            r11.bp = r12
            char r12 = r11.charAt(r12)
            goto L_0x0111
        L_0x0162:
            r11.matchStat = r9
            return r0
        L_0x0165:
            boolean r12 = com.alibaba.fastjson.parser.JSONLexerBase.isWhitespace(r12)
            if (r12 == 0) goto L_0x0176
            int r12 = r11.bp
            int r12 = r12 + r5
            r11.bp = r12
            char r12 = r11.charAt(r12)
            goto L_0x00ed
        L_0x0176:
            r11.bp = r1
            r11.charAt(r1)
            r11.matchStat = r9
            return r0
        L_0x017e:
            r11.matchStat = r9
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONScanner.scanFieldBoolean(char[]):boolean");
    }

    public Date scanFieldDate(char[] cArr) {
        char c;
        Date date;
        long j;
        char charAt;
        char[] cArr2 = cArr;
        boolean z = false;
        this.matchStat = 0;
        int i = this.bp;
        char c2 = this.ch;
        if (!charArrayCompare(this.text, i, cArr2)) {
            this.matchStat = -2;
            return null;
        }
        int length = this.bp + cArr2.length;
        int i2 = length + 1;
        char charAt2 = charAt(length);
        if (charAt2 == '\"') {
            int indexOf = indexOf('\"', i2);
            if (indexOf != -1) {
                this.bp = i2;
                if (scanISO8601DateIfMatch(false, indexOf - i2)) {
                    date = this.calendar.getTime();
                    c = charAt(indexOf + 1);
                    this.bp = i;
                    while (c != ',' && c != '}') {
                        if (JSONLexerBase.isWhitespace(c)) {
                            char charAt3 = charAt(indexOf + 2);
                            indexOf++;
                            c = charAt3;
                        } else {
                            this.matchStat = -1;
                            return null;
                        }
                    }
                    this.bp = indexOf + 1;
                    this.ch = c;
                } else {
                    this.bp = i;
                    this.matchStat = -1;
                    return null;
                }
            } else {
                throw new JSONException("unclosed str");
            }
        } else {
            char c3 = '9';
            char c4 = '0';
            if (charAt2 == '-' || (charAt2 >= '0' && charAt2 <= '9')) {
                if (charAt2 == '-') {
                    charAt2 = charAt(i2);
                    i2 = length + 2;
                    z = true;
                }
                if (charAt2 < '0' || charAt2 > '9') {
                    j = 0;
                } else {
                    long j2 = (long) (charAt2 - '0');
                    while (true) {
                        int i3 = i2 + 1;
                        charAt = charAt(i2);
                        if (charAt >= c4 && charAt <= c3) {
                            j2 = (j2 * 10) + ((long) (charAt - '0'));
                            i2 = i3;
                            c3 = '9';
                            c4 = '0';
                        } else if (charAt == ',' || charAt == '}') {
                            this.bp = i2;
                        }
                    }
                    this.bp = i2;
                    long j3 = j2;
                    charAt2 = charAt;
                    j = j3;
                }
                if (j < 0) {
                    this.matchStat = -1;
                    return null;
                }
                if (z) {
                    j = -j;
                }
                date = new Date(j);
                c = charAt2;
            } else {
                this.matchStat = -1;
                return null;
            }
        }
        if (c == ',') {
            int i4 = this.bp + 1;
            this.bp = i4;
            this.ch = charAt(i4);
            this.matchStat = 3;
            this.token = 16;
            return date;
        }
        int i5 = this.bp + 1;
        this.bp = i5;
        char charAt4 = charAt(i5);
        if (charAt4 == ',') {
            this.token = 16;
            int i6 = this.bp + 1;
            this.bp = i6;
            this.ch = charAt(i6);
        } else if (charAt4 == ']') {
            this.token = 15;
            int i7 = this.bp + 1;
            this.bp = i7;
            this.ch = charAt(i7);
        } else if (charAt4 == '}') {
            this.token = 13;
            int i8 = this.bp + 1;
            this.bp = i8;
            this.ch = charAt(i8);
        } else if (charAt4 == 26) {
            this.token = 20;
        } else {
            this.bp = i;
            this.ch = c2;
            this.matchStat = -1;
            return null;
        }
        this.matchStat = 4;
        return date;
    }

    /* JADX WARNING: Removed duplicated region for block: B:52:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00ad  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int scanFieldInt(char[] r15) {
        /*
            r14 = this;
            r0 = 0
            r14.matchStat = r0
            int r1 = r14.bp
            char r2 = r14.ch
            java.lang.String r3 = r14.text
            boolean r3 = charArrayCompare(r3, r1, r15)
            if (r3 != 0) goto L_0x0013
            r15 = -2
            r14.matchStat = r15
            return r0
        L_0x0013:
            int r3 = r14.bp
            int r15 = r15.length
            int r3 = r3 + r15
            int r15 = r3 + 1
            char r4 = r14.charAt(r3)
            r5 = 34
            r6 = 1
            if (r4 != r5) goto L_0x0024
            r7 = 1
            goto L_0x0025
        L_0x0024:
            r7 = 0
        L_0x0025:
            if (r7 == 0) goto L_0x002e
            int r3 = r3 + 2
            char r4 = r14.charAt(r15)
            r15 = r3
        L_0x002e:
            r3 = 45
            if (r4 != r3) goto L_0x0034
            r3 = 1
            goto L_0x0035
        L_0x0034:
            r3 = 0
        L_0x0035:
            if (r3 == 0) goto L_0x0040
            int r4 = r15 + 1
            char r15 = r14.charAt(r15)
            r13 = r4
            r4 = r15
            r15 = r13
        L_0x0040:
            r8 = 48
            r9 = -1
            if (r4 < r8) goto L_0x0112
            r10 = 57
            if (r4 > r10) goto L_0x0112
            int r4 = r4 - r8
        L_0x004a:
            int r11 = r15 + 1
            char r12 = r14.charAt(r15)
            if (r12 < r8) goto L_0x0061
            if (r12 > r10) goto L_0x0061
            int r15 = r4 * 10
            if (r15 >= r4) goto L_0x005b
            r14.matchStat = r9
            return r0
        L_0x005b:
            int r12 = r12 + -48
            int r4 = r15 + r12
            r15 = r11
            goto L_0x004a
        L_0x0061:
            r8 = 46
            if (r12 != r8) goto L_0x0068
            r14.matchStat = r9
            return r0
        L_0x0068:
            if (r4 >= 0) goto L_0x006d
            r14.matchStat = r9
            return r0
        L_0x006d:
            if (r7 == 0) goto L_0x007b
            if (r12 == r5) goto L_0x0074
            r14.matchStat = r9
            return r0
        L_0x0074:
            int r15 = r15 + 2
            char r12 = r14.charAt(r11)
        L_0x007a:
            r11 = r15
        L_0x007b:
            r15 = 125(0x7d, float:1.75E-43)
            r5 = 44
            if (r12 == r5) goto L_0x0094
            if (r12 != r15) goto L_0x0084
            goto L_0x0094
        L_0x0084:
            boolean r15 = com.alibaba.fastjson.parser.JSONLexerBase.isWhitespace(r12)
            if (r15 == 0) goto L_0x0091
            int r15 = r11 + 1
            char r12 = r14.charAt(r11)
            goto L_0x007a
        L_0x0091:
            r14.matchStat = r9
            return r0
        L_0x0094:
            int r7 = r11 + -1
            r14.bp = r7
            r7 = 16
            if (r12 != r5) goto L_0x00ad
            r14.bp = r11
            char r15 = r14.charAt(r11)
            r14.ch = r15
            r15 = 3
            r14.matchStat = r15
            r14.token = r7
            if (r3 == 0) goto L_0x00ac
            int r4 = -r4
        L_0x00ac:
            return r4
        L_0x00ad:
            if (r12 != r15) goto L_0x010e
            r14.bp = r11
            char r8 = r14.charAt(r11)
        L_0x00b5:
            if (r8 != r5) goto L_0x00c5
            r14.token = r7
            int r15 = r14.bp
            int r15 = r15 + r6
            r14.bp = r15
            char r15 = r14.charAt(r15)
            r14.ch = r15
            goto L_0x00f3
        L_0x00c5:
            r10 = 93
            if (r8 != r10) goto L_0x00d9
            r15 = 15
            r14.token = r15
            int r15 = r14.bp
            int r15 = r15 + r6
            r14.bp = r15
            char r15 = r14.charAt(r15)
            r14.ch = r15
            goto L_0x00f3
        L_0x00d9:
            if (r8 != r15) goto L_0x00eb
            r15 = 13
            r14.token = r15
            int r15 = r14.bp
            int r15 = r15 + r6
            r14.bp = r15
            char r15 = r14.charAt(r15)
            r14.ch = r15
            goto L_0x00f3
        L_0x00eb:
            r10 = 26
            if (r8 != r10) goto L_0x00f7
            r15 = 20
            r14.token = r15
        L_0x00f3:
            r15 = 4
            r14.matchStat = r15
            goto L_0x010e
        L_0x00f7:
            boolean r8 = com.alibaba.fastjson.parser.JSONLexerBase.isWhitespace(r8)
            if (r8 == 0) goto L_0x0107
            int r8 = r14.bp
            int r8 = r8 + r6
            r14.bp = r8
            char r8 = r14.charAt(r8)
            goto L_0x00b5
        L_0x0107:
            r14.bp = r1
            r14.ch = r2
            r14.matchStat = r9
            return r0
        L_0x010e:
            if (r3 == 0) goto L_0x0111
            int r4 = -r4
        L_0x0111:
            return r4
        L_0x0112:
            r14.matchStat = r9
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONScanner.scanFieldInt(char[]):int");
    }

    public long scanFieldLong(char[] cArr) {
        boolean z;
        int i;
        char charAt;
        char[] cArr2 = cArr;
        boolean z2 = false;
        this.matchStat = 0;
        int i2 = this.bp;
        char c = this.ch;
        if (!charArrayCompare(this.text, i2, cArr2)) {
            this.matchStat = -2;
            return 0;
        }
        int length = this.bp + cArr2.length;
        int i3 = length + 1;
        char charAt2 = charAt(length);
        if (charAt2 == '\"') {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            charAt2 = charAt(i3);
            i3 = length + 2;
        }
        if (charAt2 == '-') {
            charAt2 = charAt(i3);
            i3++;
            z2 = true;
        }
        if (charAt2 < '0' || charAt2 > '9') {
            this.bp = i2;
            this.ch = c;
            this.matchStat = -1;
            return 0;
        }
        long j = (long) (charAt2 - '0');
        while (true) {
            i = i3 + 1;
            charAt = charAt(i3);
            if (charAt >= '0' && charAt <= '9') {
                j = (j * 10) + ((long) (charAt - '0'));
                i3 = i;
            }
        }
        if (charAt == '.') {
            this.matchStat = -1;
            return 0;
        }
        if (z) {
            if (charAt != '\"') {
                this.matchStat = -1;
                return 0;
            }
            charAt = charAt(i);
            i = i3 + 2;
        }
        if (charAt == ',' || charAt == '}') {
            this.bp = i - 1;
        }
        if (j >= 0 || (j == Long.MIN_VALUE && z2)) {
            while (charAt != ',') {
                if (charAt == '}') {
                    int i4 = 1;
                    int i5 = this.bp + 1;
                    this.bp = i5;
                    char charAt3 = charAt(i5);
                    while (true) {
                        if (charAt3 == ',') {
                            this.token = 16;
                            int i6 = this.bp + i4;
                            this.bp = i6;
                            this.ch = charAt(i6);
                            break;
                        } else if (charAt3 == ']') {
                            this.token = 15;
                            int i7 = this.bp + i4;
                            this.bp = i7;
                            this.ch = charAt(i7);
                            break;
                        } else if (charAt3 == '}') {
                            this.token = 13;
                            int i8 = this.bp + i4;
                            this.bp = i8;
                            this.ch = charAt(i8);
                            break;
                        } else if (charAt3 == 26) {
                            this.token = 20;
                            break;
                        } else if (JSONLexerBase.isWhitespace(charAt3)) {
                            int i9 = this.bp + 1;
                            this.bp = i9;
                            charAt3 = charAt(i9);
                            i4 = 1;
                        } else {
                            this.bp = i2;
                            this.ch = c;
                            this.matchStat = -1;
                            return 0;
                        }
                    }
                    this.matchStat = 4;
                    if (z2) {
                        return -j;
                    }
                    return j;
                } else if (JSONLexerBase.isWhitespace(charAt)) {
                    this.bp = i;
                    charAt = charAt(i);
                    i++;
                } else {
                    this.matchStat = -1;
                    return 0;
                }
            }
            int i10 = this.bp + 1;
            this.bp = i10;
            this.ch = charAt(i10);
            this.matchStat = 3;
            this.token = 16;
            if (z2) {
                return -j;
            }
            return j;
        }
        this.bp = i2;
        this.ch = c;
        this.matchStat = -1;
        return 0;
    }

    public String scanFieldString(char[] cArr) {
        this.matchStat = 0;
        int i = this.bp;
        char c = this.ch;
        while (!charArrayCompare(this.text, this.bp, cArr)) {
            if (JSONLexerBase.isWhitespace(this.ch)) {
                next();
                while (JSONLexerBase.isWhitespace(this.ch)) {
                    next();
                }
            } else {
                this.matchStat = -2;
                return stringDefaultValue();
            }
        }
        int length = this.bp + cArr.length;
        int i2 = length + 1;
        char charAt = charAt(length);
        int i3 = 0;
        if (charAt != '\"') {
            while (JSONLexerBase.isWhitespace(charAt)) {
                i3++;
                char charAt2 = charAt(i2);
                i2++;
                charAt = charAt2;
            }
            if (charAt != '\"') {
                this.matchStat = -1;
                return stringDefaultValue();
            }
        }
        int indexOf = indexOf('\"', i2);
        if (indexOf != -1) {
            String subString = subString(i2, indexOf - i2);
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
                int length2 = indexOf - (((cArr.length + i6) + 1) + i3);
                subString = JSONLexerBase.readString(sub_chars(i6 + cArr.length + 1 + i3, length2), length2);
            }
            if ((this.features & Feature.TrimStringFieldValue.mask) != 0) {
                subString = subString.trim();
            }
            char charAt3 = charAt(indexOf + 1);
            while (charAt3 != ',' && charAt3 != '}') {
                if (JSONLexerBase.isWhitespace(charAt3)) {
                    char charAt4 = charAt(indexOf + 2);
                    indexOf++;
                    charAt3 = charAt4;
                } else {
                    this.matchStat = -1;
                    return stringDefaultValue();
                }
            }
            this.bp = indexOf + 1;
            this.ch = charAt3;
            if (charAt3 == ',') {
                int i7 = indexOf + 2;
                this.bp = i7;
                this.ch = charAt(i7);
                this.matchStat = 3;
                return subString;
            }
            int i8 = indexOf + 2;
            this.bp = i8;
            char charAt5 = charAt(i8);
            if (charAt5 == ',') {
                this.token = 16;
                int i9 = this.bp + 1;
                this.bp = i9;
                this.ch = charAt(i9);
            } else if (charAt5 == ']') {
                this.token = 15;
                int i10 = this.bp + 1;
                this.bp = i10;
                this.ch = charAt(i10);
            } else if (charAt5 == '}') {
                this.token = 13;
                int i11 = this.bp + 1;
                this.bp = i11;
                this.ch = charAt(i11);
            } else if (charAt5 == 26) {
                this.token = 20;
            } else {
                this.bp = i;
                this.ch = c;
                this.matchStat = -1;
                return stringDefaultValue();
            }
            this.matchStat = 4;
            return subString;
        }
        throw new JSONException("unclosed str");
    }

    public Collection<String> scanFieldStringArray(char[] cArr, Class<?> cls) {
        char c;
        char c2;
        int i;
        boolean z;
        int i2;
        char c3;
        char[] cArr2 = cArr;
        this.matchStat = 0;
        while (true) {
            char c4 = this.ch;
            if (c4 != 10 && c4 != ' ') {
                break;
            }
            Class<?> cls2 = cls;
            int i3 = this.bp + 1;
            this.bp = i3;
            if (i3 >= this.len) {
                c = JSONLexer.EOI;
            } else {
                c = this.text.charAt(i3);
            }
            this.ch = c;
        }
        if (!charArrayCompare(this.text, this.bp, cArr2)) {
            this.matchStat = -2;
            return null;
        }
        Collection<String> newCollectionByType = newCollectionByType(cls);
        int i4 = this.bp;
        char c5 = this.ch;
        int length = cArr2.length + i4;
        int i5 = length + 1;
        if (charAt(length) == '[') {
            int i6 = length + 2;
            char charAt = charAt(i5);
            while (true) {
                if (charAt == '\"') {
                    int indexOf = indexOf('\"', i6);
                    if (indexOf != -1) {
                        String subString = subString(i6, indexOf - i6);
                        if (subString.indexOf(92) != -1) {
                            while (true) {
                                int i7 = indexOf - 1;
                                int i8 = 0;
                                while (i7 >= 0 && charAt(i7) == '\\') {
                                    i8++;
                                    i7--;
                                }
                                if (i8 % 2 == 0) {
                                    break;
                                }
                                indexOf = indexOf('\"', indexOf + 1);
                            }
                            int i9 = indexOf - i6;
                            subString = JSONLexerBase.readString(sub_chars(i6, i9), i9);
                        }
                        int i10 = indexOf + 1;
                        i2 = indexOf + 2;
                        c3 = charAt(i10);
                        newCollectionByType.add(subString);
                    } else {
                        throw new JSONException("unclosed str");
                    }
                } else if (charAt == 'n' && this.text.startsWith("ull", i6)) {
                    i2 = i6 + 4;
                    c3 = charAt(i6 + 3);
                    newCollectionByType.add((Object) null);
                } else if (charAt == ']' && newCollectionByType.size() == 0) {
                    c2 = charAt(i6);
                    i = i6 + 1;
                } else {
                    this.matchStat = -1;
                    return null;
                }
                if (c3 == ',') {
                    i6 = i2 + 1;
                    charAt = charAt(i2);
                } else if (c3 == ']') {
                    i = i2 + 1;
                    c2 = charAt(i2);
                    while (JSONLexerBase.isWhitespace(c2)) {
                        c2 = charAt(i);
                        i++;
                    }
                } else {
                    this.matchStat = -1;
                    return null;
                }
            }
        } else if (this.text.startsWith("ull", i5)) {
            int i11 = length + 4;
            i = length + 5;
            c2 = charAt(i11);
            newCollectionByType = null;
        } else {
            this.matchStat = -1;
            return null;
        }
        this.bp = i;
        if (c2 == ',') {
            this.ch = charAt(i);
            this.matchStat = 3;
            return newCollectionByType;
        } else if (c2 == '}') {
            char charAt2 = charAt(i);
            do {
                if (charAt2 == ',') {
                    this.token = 16;
                    int i12 = this.bp + 1;
                    this.bp = i12;
                    this.ch = charAt(i12);
                } else if (charAt2 == ']') {
                    this.token = 15;
                    int i13 = this.bp + 1;
                    this.bp = i13;
                    this.ch = charAt(i13);
                } else if (charAt2 == '}') {
                    this.token = 13;
                    int i14 = this.bp + 1;
                    this.bp = i14;
                    this.ch = charAt(i14);
                } else if (charAt2 == 26) {
                    this.token = 20;
                    this.ch = charAt2;
                } else {
                    z = false;
                    while (JSONLexerBase.isWhitespace(charAt2)) {
                        int i15 = i + 1;
                        char charAt3 = charAt(i);
                        this.bp = i15;
                        z = true;
                        int i16 = i15;
                        charAt2 = charAt3;
                        i = i16;
                    }
                }
                this.matchStat = 4;
                return newCollectionByType;
            } while (z);
            this.matchStat = -1;
            return null;
        } else {
            this.ch = c5;
            this.bp = i4;
            this.matchStat = -1;
            return null;
        }
    }

    public long scanFieldSymbol(char[] cArr) {
        this.matchStat = 0;
        while (!charArrayCompare(this.text, this.bp, cArr)) {
            if (JSONLexerBase.isWhitespace(this.ch)) {
                next();
                while (JSONLexerBase.isWhitespace(this.ch)) {
                    next();
                }
            } else {
                this.matchStat = -2;
                return 0;
            }
        }
        int length = this.bp + cArr.length;
        int i = length + 1;
        char charAt = charAt(length);
        if (charAt != '\"') {
            while (JSONLexerBase.isWhitespace(charAt)) {
                int i2 = i + 1;
                charAt = charAt(i);
                i = i2;
            }
            if (charAt != '\"') {
                this.matchStat = -1;
                return 0;
            }
        }
        long j = TypeUtils.fnv1a_64_magic_hashcode;
        while (true) {
            int i3 = i + 1;
            char charAt2 = charAt(i);
            if (charAt2 == '\"') {
                this.bp = i3;
                char charAt3 = charAt(i3);
                this.ch = charAt3;
                while (charAt3 != ',') {
                    if (charAt3 == '}') {
                        next();
                        skipWhitespace();
                        char current = getCurrent();
                        if (current == ',') {
                            this.token = 16;
                            int i4 = this.bp + 1;
                            this.bp = i4;
                            this.ch = charAt(i4);
                        } else if (current == ']') {
                            this.token = 15;
                            int i5 = this.bp + 1;
                            this.bp = i5;
                            this.ch = charAt(i5);
                        } else if (current == '}') {
                            this.token = 13;
                            int i6 = this.bp + 1;
                            this.bp = i6;
                            this.ch = charAt(i6);
                        } else if (current == 26) {
                            this.token = 20;
                        } else {
                            this.matchStat = -1;
                            return 0;
                        }
                        this.matchStat = 4;
                        return j;
                    } else if (JSONLexerBase.isWhitespace(charAt3)) {
                        int i7 = this.bp + 1;
                        this.bp = i7;
                        charAt3 = charAt(i7);
                    } else {
                        this.matchStat = -1;
                        return 0;
                    }
                }
                int i8 = this.bp + 1;
                this.bp = i8;
                this.ch = charAt(i8);
                this.matchStat = 3;
                return j;
            } else if (i3 > this.len) {
                this.matchStat = -1;
                return 0;
            } else {
                j = (j ^ ((long) charAt2)) * TypeUtils.fnv1a_64_magic_prime;
                i = i3;
            }
        }
    }

    public boolean scanISO8601DateIfMatch() {
        return scanISO8601DateIfMatch(true);
    }

    public final int scanInt(char c) {
        boolean z;
        int i;
        char charAt;
        this.matchStat = 0;
        int i2 = this.bp;
        int i3 = i2 + 1;
        char charAt2 = charAt(i2);
        while (JSONLexerBase.isWhitespace(charAt2)) {
            int i4 = i3 + 1;
            charAt2 = charAt(i3);
            i3 = i4;
        }
        boolean z2 = true;
        if (charAt2 == '\"') {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            int i5 = i3 + 1;
            charAt2 = charAt(i3);
            i3 = i5;
        }
        if (charAt2 != '-') {
            z2 = false;
        }
        if (z2) {
            int i6 = i3 + 1;
            charAt2 = charAt(i3);
            i3 = i6;
        }
        if (charAt2 < '0' || charAt2 > '9') {
            if (charAt2 == 'n') {
                int i7 = i3 + 1;
                if (charAt(i3) == 'u') {
                    int i8 = i3 + 2;
                    if (charAt(i7) == 'l') {
                        int i9 = i3 + 3;
                        if (charAt(i8) == 'l') {
                            this.matchStat = 5;
                            int i10 = i3 + 4;
                            char charAt3 = charAt(i9);
                            if (z && charAt3 == '\"') {
                                charAt3 = charAt(i10);
                                i10 = i3 + 5;
                            }
                            while (charAt3 != ',') {
                                if (charAt3 == ']') {
                                    this.bp = i10;
                                    this.ch = charAt(i10);
                                    this.matchStat = 5;
                                    this.token = 15;
                                    return 0;
                                } else if (JSONLexerBase.isWhitespace(charAt3)) {
                                    char charAt4 = charAt(i10);
                                    i10++;
                                    charAt3 = charAt4;
                                } else {
                                    this.matchStat = -1;
                                    return 0;
                                }
                            }
                            this.bp = i10;
                            this.ch = charAt(i10);
                            this.matchStat = 5;
                            this.token = 16;
                            return 0;
                        }
                    }
                }
            }
            this.matchStat = -1;
            return 0;
        }
        int i11 = charAt2 - '0';
        while (true) {
            i = i3 + 1;
            charAt = charAt(i3);
            if (charAt >= '0' && charAt <= '9') {
                int i12 = i11 * 10;
                if (i12 >= i11) {
                    i11 = i12 + (charAt - '0');
                    i3 = i;
                } else {
                    throw new JSONException("parseInt error : " + subString(i2, i3));
                }
            }
        }
        if (charAt == '.') {
            this.matchStat = -1;
            return 0;
        }
        if (z) {
            if (charAt != '\"') {
                this.matchStat = -1;
                return 0;
            }
            charAt = charAt(i);
            i = i3 + 2;
        }
        if (i11 < 0) {
            this.matchStat = -1;
            return 0;
        }
        char c2 = c;
        while (charAt != c2) {
            if (JSONLexerBase.isWhitespace(charAt)) {
                charAt = charAt(i);
                i++;
            } else {
                this.matchStat = -1;
                if (z2) {
                    return -i11;
                }
                return i11;
            }
        }
        this.bp = i;
        this.ch = charAt(i);
        this.matchStat = 3;
        this.token = 16;
        if (z2) {
            return -i11;
        }
        return i11;
    }

    public long scanLong(char c) {
        boolean z;
        int i;
        char charAt;
        boolean z2 = false;
        this.matchStat = 0;
        int i2 = this.bp;
        int i3 = i2 + 1;
        char charAt2 = charAt(i2);
        if (charAt2 == '\"') {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            charAt2 = charAt(i3);
            i3 = i2 + 2;
        }
        if (charAt2 == '-') {
            z2 = true;
        }
        if (z2) {
            charAt2 = charAt(i3);
            i3++;
        }
        if (charAt2 < '0' || charAt2 > '9') {
            if (charAt2 == 'n') {
                int i4 = i3 + 1;
                if (charAt(i3) == 'u') {
                    int i5 = i3 + 2;
                    if (charAt(i4) == 'l') {
                        int i6 = i3 + 3;
                        if (charAt(i5) == 'l') {
                            this.matchStat = 5;
                            int i7 = i3 + 4;
                            char charAt3 = charAt(i6);
                            if (z && charAt3 == '\"') {
                                charAt3 = charAt(i7);
                                i7 = i3 + 5;
                            }
                            while (charAt3 != ',') {
                                if (charAt3 == ']') {
                                    this.bp = i7;
                                    this.ch = charAt(i7);
                                    this.matchStat = 5;
                                    this.token = 15;
                                    return 0;
                                } else if (JSONLexerBase.isWhitespace(charAt3)) {
                                    char charAt4 = charAt(i7);
                                    i7++;
                                    charAt3 = charAt4;
                                } else {
                                    this.matchStat = -1;
                                    return 0;
                                }
                            }
                            this.bp = i7;
                            this.ch = charAt(i7);
                            this.matchStat = 5;
                            this.token = 16;
                            return 0;
                        }
                    }
                }
            }
            this.matchStat = -1;
            return 0;
        }
        long j = (long) (charAt2 - '0');
        while (true) {
            i = i3 + 1;
            charAt = charAt(i3);
            if (charAt >= '0' && charAt <= '9') {
                j = (j * 10) + ((long) (charAt - '0'));
                i3 = i;
            }
        }
        if (charAt == '.') {
            this.matchStat = -1;
            return 0;
        }
        if (z) {
            if (charAt != '\"') {
                this.matchStat = -1;
                return 0;
            }
            charAt = charAt(i);
            i = i3 + 2;
        }
        if (j >= 0 || (j == Long.MIN_VALUE && z2)) {
            char c2 = c;
            while (charAt != c2) {
                if (JSONLexerBase.isWhitespace(charAt)) {
                    charAt = charAt(i);
                    i++;
                } else {
                    this.matchStat = -1;
                    return j;
                }
            }
            this.bp = i;
            this.ch = charAt(i);
            this.matchStat = 3;
            this.token = 16;
            if (z2) {
                return -j;
            }
            return j;
        }
        this.matchStat = -1;
        return 0;
    }

    public String scanTypeName(SymbolTable symbolTable) {
        int indexOf;
        if (!this.text.startsWith("\"@type\":\"", this.bp) || (indexOf = this.text.indexOf(34, this.bp + 9)) == -1) {
            return null;
        }
        int i = this.bp + 9;
        this.bp = i;
        int i2 = 0;
        while (i < indexOf) {
            i2 = (i2 * 31) + this.text.charAt(i);
            i++;
        }
        int i3 = this.bp;
        String addSymbol = addSymbol(i3, indexOf - i3, i2, symbolTable);
        char charAt = this.text.charAt(indexOf + 1);
        if (charAt != ',' && charAt != ']') {
            return null;
        }
        int i4 = indexOf + 2;
        this.bp = i4;
        this.ch = this.text.charAt(i4);
        return addSymbol;
    }

    public boolean seekArrayToItem(int i) {
        if (i >= 0) {
            int i2 = this.token;
            if (i2 == 20) {
                return false;
            }
            if (i2 == 14) {
                for (int i3 = 0; i3 < i; i3++) {
                    skipWhitespace();
                    char c = this.ch;
                    if (c == '\"' || c == '\'') {
                        skipString();
                        char c2 = this.ch;
                        if (c2 == ',') {
                            next();
                        } else if (c2 == ']') {
                            next();
                            nextToken(16);
                            return false;
                        } else {
                            throw new JSONException("illegal json.");
                        }
                    } else {
                        if (c == '{') {
                            next();
                            this.token = 12;
                            skipObject(false);
                        } else if (c == '[') {
                            next();
                            this.token = 14;
                            skipArray(false);
                        } else {
                            int i4 = this.bp + 1;
                            while (i4 < this.text.length()) {
                                char charAt = this.text.charAt(i4);
                                if (charAt == ',') {
                                    int i5 = i4 + 1;
                                    this.bp = i5;
                                    this.ch = charAt(i5);
                                } else if (charAt == ']') {
                                    int i6 = i4 + 1;
                                    this.bp = i6;
                                    this.ch = charAt(i6);
                                    nextToken();
                                    return false;
                                } else {
                                    i4++;
                                }
                            }
                            throw new JSONException("illegal json.");
                        }
                        int i7 = this.token;
                        if (i7 != 16) {
                            if (i7 == 15) {
                                return false;
                            }
                            throw new UnsupportedOperationException();
                        }
                    }
                }
                nextToken();
                return true;
            }
            throw new UnsupportedOperationException();
        }
        throw new IllegalArgumentException("index must > 0, but " + i);
    }

    public int seekObjectToField(long j, boolean z) {
        char c;
        char c2;
        char c3;
        char c4;
        char c5;
        char c6;
        char c7;
        char c8;
        int i = this.token;
        int i2 = -1;
        if (i == 20) {
            return -1;
        }
        if (i != 13) {
            int i3 = 15;
            if (i != 15) {
                int i4 = 16;
                if (i == 12 || i == 16) {
                    while (true) {
                        char c9 = this.ch;
                        if (c9 == '}') {
                            next();
                            nextToken();
                            return i2;
                        } else if (c9 == 26) {
                            return i2;
                        } else {
                            if (c9 != '\"') {
                                skipWhitespace();
                            }
                            if (this.ch == '\"') {
                                int i5 = this.bp + 1;
                                long j2 = TypeUtils.fnv1a_64_magic_hashcode;
                                while (true) {
                                    if (i5 >= this.text.length()) {
                                        break;
                                    }
                                    char charAt = this.text.charAt(i5);
                                    if (charAt == '\\') {
                                        i5++;
                                        if (i5 != this.text.length()) {
                                            charAt = this.text.charAt(i5);
                                        } else {
                                            throw new JSONException("unclosed str, " + info());
                                        }
                                    }
                                    if (charAt == '\"') {
                                        int i6 = i5 + 1;
                                        this.bp = i6;
                                        if (i6 >= this.text.length()) {
                                            c8 = JSONLexer.EOI;
                                        } else {
                                            c8 = this.text.charAt(this.bp);
                                        }
                                        this.ch = c8;
                                    } else {
                                        j2 = (j2 ^ ((long) charAt)) * TypeUtils.fnv1a_64_magic_prime;
                                        i5++;
                                    }
                                }
                                if (j2 == j) {
                                    if (this.ch != ':') {
                                        skipWhitespace();
                                    }
                                    if (this.ch != ':') {
                                        return 3;
                                    }
                                    int i7 = this.bp + 1;
                                    this.bp = i7;
                                    if (i7 >= this.text.length()) {
                                        c = JSONLexer.EOI;
                                    } else {
                                        c = this.text.charAt(i7);
                                    }
                                    this.ch = c;
                                    if (c == ',') {
                                        int i8 = this.bp + 1;
                                        this.bp = i8;
                                        if (i8 >= this.text.length()) {
                                            c4 = JSONLexer.EOI;
                                        } else {
                                            c4 = this.text.charAt(i8);
                                        }
                                        this.ch = c4;
                                        this.token = i4;
                                        return 3;
                                    } else if (c == ']') {
                                        int i9 = this.bp + 1;
                                        this.bp = i9;
                                        if (i9 >= this.text.length()) {
                                            c3 = JSONLexer.EOI;
                                        } else {
                                            c3 = this.text.charAt(i9);
                                        }
                                        this.ch = c3;
                                        this.token = i3;
                                        return 3;
                                    } else if (c == '}') {
                                        int i10 = this.bp + 1;
                                        this.bp = i10;
                                        if (i10 >= this.text.length()) {
                                            c2 = JSONLexer.EOI;
                                        } else {
                                            c2 = this.text.charAt(i10);
                                        }
                                        this.ch = c2;
                                        this.token = 13;
                                        return 3;
                                    } else if (c < '0' || c > '9') {
                                        nextToken(2);
                                        return 3;
                                    } else {
                                        this.sp = 0;
                                        this.pos = this.bp;
                                        scanNumber();
                                        return 3;
                                    }
                                } else {
                                    if (this.ch != ':') {
                                        skipWhitespace();
                                    }
                                    if (this.ch == ':') {
                                        int i11 = this.bp + 1;
                                        this.bp = i11;
                                        if (i11 >= this.text.length()) {
                                            c5 = JSONLexer.EOI;
                                        } else {
                                            c5 = this.text.charAt(i11);
                                        }
                                        this.ch = c5;
                                        if (!(c5 == '\"' || c5 == '\'' || c5 == '{' || c5 == '[' || c5 == '0' || c5 == '1' || c5 == '2' || c5 == '3' || c5 == '4' || c5 == '5' || c5 == '6' || c5 == '7' || c5 == '8' || c5 == '9' || c5 == '+' || c5 == '-')) {
                                            skipWhitespace();
                                        }
                                        char c10 = this.ch;
                                        if (c10 == '-' || c10 == '+' || (c10 >= '0' && c10 <= '9')) {
                                            next();
                                            while (true) {
                                                c6 = this.ch;
                                                if (c6 >= '0' && c6 <= '9') {
                                                    next();
                                                }
                                            }
                                            if (c6 == '.') {
                                                next();
                                                while (true) {
                                                    char c11 = this.ch;
                                                    if (c11 < '0' || c11 > '9') {
                                                        break;
                                                    }
                                                    next();
                                                }
                                            }
                                            char c12 = this.ch;
                                            if (c12 == 'E' || c12 == 'e') {
                                                next();
                                                char c13 = this.ch;
                                                if (c13 == '-' || c13 == '+') {
                                                    next();
                                                }
                                                while (true) {
                                                    char c14 = this.ch;
                                                    if (c14 < '0' || c14 > '9') {
                                                        break;
                                                    }
                                                    next();
                                                }
                                            }
                                            if (this.ch != ',') {
                                                skipWhitespace();
                                            }
                                            if (this.ch == ',') {
                                                next();
                                            }
                                        } else if (c10 == '\"') {
                                            skipString();
                                            char c15 = this.ch;
                                            if (!(c15 == ',' || c15 == '}')) {
                                                skipWhitespace();
                                            }
                                            if (this.ch == ',') {
                                                next();
                                            }
                                        } else if (c10 == 't') {
                                            next();
                                            if (this.ch == 'r') {
                                                next();
                                                if (this.ch == 'u') {
                                                    next();
                                                    if (this.ch == 'e') {
                                                        next();
                                                    }
                                                }
                                            }
                                            char c16 = this.ch;
                                            if (!(c16 == ',' || c16 == '}')) {
                                                skipWhitespace();
                                            }
                                            if (this.ch == ',') {
                                                next();
                                            }
                                        } else if (c10 == 'n') {
                                            next();
                                            if (this.ch == 'u') {
                                                next();
                                                if (this.ch == 'l') {
                                                    next();
                                                    if (this.ch == 'l') {
                                                        next();
                                                    }
                                                }
                                            }
                                            char c17 = this.ch;
                                            if (!(c17 == ',' || c17 == '}')) {
                                                skipWhitespace();
                                            }
                                            if (this.ch == ',') {
                                                next();
                                            }
                                        } else if (c10 == 'f') {
                                            next();
                                            if (this.ch == 'a') {
                                                next();
                                                if (this.ch == 'l') {
                                                    next();
                                                    if (this.ch == 's') {
                                                        next();
                                                        if (this.ch == 'e') {
                                                            next();
                                                        }
                                                    }
                                                }
                                            }
                                            char c18 = this.ch;
                                            if (!(c18 == ',' || c18 == '}')) {
                                                skipWhitespace();
                                            }
                                            if (this.ch == ',') {
                                                next();
                                            }
                                        } else if (c10 == '{') {
                                            int i12 = this.bp + 1;
                                            this.bp = i12;
                                            if (i12 >= this.text.length()) {
                                                c7 = JSONLexer.EOI;
                                            } else {
                                                c7 = this.text.charAt(i12);
                                            }
                                            this.ch = c7;
                                            if (z) {
                                                this.token = 12;
                                                return 1;
                                            }
                                            skipObject(false);
                                            if (this.token == 13) {
                                                return -1;
                                            }
                                        } else if (c10 == '[') {
                                            next();
                                            if (z) {
                                                this.token = 14;
                                                return 2;
                                            }
                                            skipArray(false);
                                            if (this.token == 13) {
                                                return -1;
                                            }
                                        } else {
                                            throw new UnsupportedOperationException();
                                        }
                                        i2 = -1;
                                        i3 = 15;
                                        i4 = 16;
                                    } else {
                                        throw new JSONException("illegal json, " + info());
                                    }
                                }
                            } else {
                                throw new UnsupportedOperationException();
                            }
                        }
                    }
                } else {
                    throw new UnsupportedOperationException(JSONToken.name(this.token));
                }
            }
        }
        nextToken();
        return -1;
    }

    public void setTime(char c, char c2, char c3, char c4, char c5, char c6) {
        this.calendar.set(11, ((c - '0') * 10) + (c2 - '0'));
        this.calendar.set(12, ((c3 - '0') * 10) + (c4 - '0'));
        this.calendar.set(13, ((c5 - '0') * 10) + (c6 - '0'));
    }

    public void setTimeZone(char c, char c2, char c3) {
        setTimeZone(c, c2, c3, '0', '0');
    }

    public final void skipArray() {
        skipArray(false);
    }

    public final void skipObject() {
        skipObject(false);
    }

    public final void skipString() {
        if (this.ch == '\"') {
            int i = this.bp;
            while (true) {
                i++;
                if (i < this.text.length()) {
                    char charAt = this.text.charAt(i);
                    if (charAt == '\\') {
                        if (i < this.len - 1) {
                            i++;
                        }
                    } else if (charAt == '\"') {
                        String str = this.text;
                        int i2 = i + 1;
                        this.bp = i2;
                        this.ch = str.charAt(i2);
                        return;
                    }
                } else {
                    throw new JSONException("unclosed str");
                }
            }
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public final String stringVal() {
        if (!this.hasSpecial) {
            return subString(this.np + 1, this.sp);
        }
        return new String(this.sbuf, 0, this.sp);
    }

    public final String subString(int i, int i2) {
        if (!ASMUtils.IS_ANDROID) {
            return this.text.substring(i, i2 + i);
        }
        char[] cArr = this.sbuf;
        if (i2 < cArr.length) {
            this.text.getChars(i, i + i2, cArr, 0);
            return new String(this.sbuf, 0, i2);
        }
        char[] cArr2 = new char[i2];
        this.text.getChars(i, i2 + i, cArr2, 0);
        return new String(cArr2);
    }

    public final char[] sub_chars(int i, int i2) {
        if (ASMUtils.IS_ANDROID) {
            char[] cArr = this.sbuf;
            if (i2 < cArr.length) {
                this.text.getChars(i, i2 + i, cArr, 0);
                return this.sbuf;
            }
        }
        char[] cArr2 = new char[i2];
        this.text.getChars(i, i2 + i, cArr2, 0);
        return cArr2;
    }

    public JSONScanner(String str, int i) {
        super(i);
        this.text = str;
        this.len = str.length();
        this.bp = -1;
        next();
        if (this.ch == 65279) {
            next();
        }
    }

    public boolean scanISO8601DateIfMatch(boolean z) {
        return scanISO8601DateIfMatch(z, this.len - this.bp);
    }

    public void setTimeZone(char c, char c2, char c3, char c4, char c5) {
        int i = ((((c2 - '0') * 10) + (c3 - '0')) * 3600000) + ((((c4 - '0') * 10) + (c5 - '0')) * 60000);
        if (c == '-') {
            i = -i;
        }
        if (this.calendar.getTimeZone().getRawOffset() != i) {
            this.calendar.setTimeZone(new SimpleTimeZone(i, Integer.toString(i)));
        }
    }

    public final void skipArray(boolean z) {
        int i = this.bp;
        boolean z2 = false;
        int i2 = 0;
        while (i < this.text.length()) {
            char charAt = this.text.charAt(i);
            if (charAt == '\\') {
                if (i < this.len - 1) {
                    i++;
                } else {
                    this.ch = charAt;
                    this.bp = i;
                    throw new JSONException("illegal str, " + info());
                }
            } else if (charAt == '\"') {
                z2 = !z2;
            } else if (charAt != '[') {
                char c = JSONLexer.EOI;
                if (charAt == '{' && z) {
                    int i3 = this.bp + 1;
                    this.bp = i3;
                    if (i3 < this.text.length()) {
                        c = this.text.charAt(i3);
                    }
                    this.ch = c;
                    skipObject(z);
                } else if (charAt == ']' && !z2 && i2 - 1 == -1) {
                    int i4 = i + 1;
                    this.bp = i4;
                    if (i4 == this.text.length()) {
                        this.ch = JSONLexer.EOI;
                        this.token = 20;
                        return;
                    }
                    this.ch = this.text.charAt(this.bp);
                    nextToken(16);
                    return;
                }
            } else if (!z2) {
                i2++;
            }
            i++;
        }
        if (i == this.text.length()) {
            throw new JSONException("illegal str, " + info());
        }
    }

    public final void skipObject(boolean z) {
        int i = this.bp;
        boolean z2 = false;
        int i2 = 0;
        while (i < this.text.length()) {
            char charAt = this.text.charAt(i);
            if (charAt == '\\') {
                if (i < this.len - 1) {
                    i++;
                } else {
                    this.ch = charAt;
                    this.bp = i;
                    throw new JSONException("illegal str, " + info());
                }
            } else if (charAt == '\"') {
                z2 = !z2;
            } else if (charAt == '{') {
                if (!z2) {
                    i2++;
                }
            } else if (charAt == '}' && !z2 && i2 - 1 == -1) {
                int i3 = i + 1;
                this.bp = i3;
                int length = this.text.length();
                char c = JSONLexer.EOI;
                if (i3 == length) {
                    this.ch = JSONLexer.EOI;
                    this.token = 20;
                    return;
                }
                char charAt2 = this.text.charAt(this.bp);
                this.ch = charAt2;
                if (charAt2 == ',') {
                    this.token = 16;
                    int i4 = this.bp + 1;
                    this.bp = i4;
                    if (i4 < this.text.length()) {
                        c = this.text.charAt(i4);
                    }
                    this.ch = c;
                    return;
                } else if (charAt2 == '}') {
                    this.token = 13;
                    next();
                    return;
                } else if (charAt2 == ']') {
                    this.token = 15;
                    next();
                    return;
                } else {
                    nextToken(16);
                    return;
                }
            }
            i++;
        }
        for (int i5 = 0; i5 < this.bp; i5++) {
            if (i5 < this.text.length() && this.text.charAt(i5) == ' ') {
                i++;
            }
        }
        if (i == this.text.length()) {
            throw new JSONException("illegal str, " + info());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:117:0x0216 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0218  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean scanISO8601DateIfMatch(boolean r35, int r36) {
        /*
            r34 = this;
            r9 = r34
            r10 = r36
            r11 = 0
            r12 = 8
            if (r10 >= r12) goto L_0x000a
            return r11
        L_0x000a:
            int r0 = r9.bp
            char r13 = r9.charAt(r0)
            int r0 = r9.bp
            r14 = 1
            int r0 = r0 + r14
            char r15 = r9.charAt(r0)
            int r0 = r9.bp
            r8 = 2
            int r0 = r0 + r8
            char r0 = r9.charAt(r0)
            int r1 = r9.bp
            r16 = 3
            int r1 = r1 + 3
            char r7 = r9.charAt(r1)
            int r1 = r9.bp
            int r1 = r1 + 4
            char r1 = r9.charAt(r1)
            int r2 = r9.bp
            r6 = 5
            int r2 = r2 + r6
            char r2 = r9.charAt(r2)
            int r3 = r9.bp
            r17 = 6
            int r3 = r3 + 6
            char r3 = r9.charAt(r3)
            int r4 = r9.bp
            int r4 = r4 + 7
            char r4 = r9.charAt(r4)
            r5 = 57
            r12 = 48
            if (r35 != 0) goto L_0x00c4
            r6 = 13
            if (r10 <= r6) goto L_0x00c3
            int r6 = r9.bp
            int r6 = r6 + r10
            int r6 = r6 - r14
            char r6 = r9.charAt(r6)
            int r14 = r9.bp
            int r14 = r14 + r10
            int r14 = r14 - r8
            char r14 = r9.charAt(r14)
            r8 = 47
            if (r13 != r8) goto L_0x00c3
            r8 = 68
            if (r15 != r8) goto L_0x00c3
            r8 = 97
            if (r0 != r8) goto L_0x00c3
            r8 = 116(0x74, float:1.63E-43)
            if (r7 != r8) goto L_0x00c3
            r8 = 101(0x65, float:1.42E-43)
            if (r1 != r8) goto L_0x00c3
            r8 = 40
            if (r2 != r8) goto L_0x00c3
            r8 = 47
            if (r6 != r8) goto L_0x00c3
            r6 = 41
            if (r14 != r6) goto L_0x00c3
            r0 = -1
            r1 = 6
        L_0x0088:
            if (r1 >= r10) goto L_0x009f
            int r2 = r9.bp
            int r2 = r2 + r1
            char r2 = r9.charAt(r2)
            r3 = 43
            if (r2 != r3) goto L_0x0097
            r0 = r1
            goto L_0x009c
        L_0x0097:
            if (r2 < r12) goto L_0x009f
            if (r2 <= r5) goto L_0x009c
            goto L_0x009f
        L_0x009c:
            int r1 = r1 + 1
            goto L_0x0088
        L_0x009f:
            r1 = -1
            if (r0 != r1) goto L_0x00a3
            return r11
        L_0x00a3:
            int r1 = r9.bp
            int r2 = r1 + 6
            int r1 = r1 + r0
            int r1 = r1 - r2
            java.lang.String r0 = r9.subString(r2, r1)
            long r0 = java.lang.Long.parseLong(r0)
            java.util.TimeZone r2 = r9.timeZone
            java.util.Locale r3 = r9.locale
            java.util.Calendar r2 = java.util.Calendar.getInstance(r2, r3)
            r9.calendar = r2
            r2.setTimeInMillis(r0)
            r6 = 5
            r9.token = r6
        L_0x00c1:
            r0 = 1
            return r0
        L_0x00c3:
            r6 = 5
        L_0x00c4:
            r14 = 16
            r12 = 14
            r11 = 45
            r21 = 10
            r5 = 8
            if (r10 == r5) goto L_0x00e5
            if (r10 == r12) goto L_0x00e5
            if (r10 != r14) goto L_0x00eb
            int r5 = r9.bp
            int r5 = r5 + 10
            char r5 = r9.charAt(r5)
            r6 = 84
            if (r5 == r6) goto L_0x00e5
            r6 = 32
            if (r5 == r6) goto L_0x00e5
            goto L_0x00eb
        L_0x00e5:
            r5 = 0
            r12 = 58
            r14 = 5
            goto L_0x0592
        L_0x00eb:
            r5 = 17
            if (r10 != r5) goto L_0x00fa
            int r5 = r9.bp
            int r5 = r5 + 6
            char r5 = r9.charAt(r5)
            if (r5 == r11) goto L_0x00fa
            goto L_0x00e5
        L_0x00fa:
            r5 = 9
            if (r10 >= r5) goto L_0x0100
            r6 = 0
            return r6
        L_0x0100:
            int r6 = r9.bp
            r18 = 8
            int r6 = r6 + 8
            char r6 = r9.charAt(r6)
            int r8 = r9.bp
            int r8 = r8 + r5
            char r5 = r9.charAt(r8)
            r8 = 51068(0xc77c, float:7.1562E-41)
            r12 = 26085(0x65e5, float:3.6553E-41)
            if (r1 != r11) goto L_0x011e
            if (r4 == r11) goto L_0x011b
            goto L_0x011e
        L_0x011b:
            r14 = 32
            goto L_0x0127
        L_0x011e:
            r14 = 47
            if (r1 != r14) goto L_0x0145
            r14 = 47
            if (r4 != r14) goto L_0x0145
            goto L_0x011b
        L_0x0127:
            if (r5 != r14) goto L_0x0136
            r5 = r2
            r4 = r7
            r1 = r13
            r2 = r15
            r7 = 48
            r13 = 9
        L_0x0131:
            r15 = r6
            r6 = r3
        L_0x0133:
            r3 = r0
            goto L_0x0200
        L_0x0136:
            r4 = r7
            r1 = r13
            r13 = 10
        L_0x013a:
            r7 = r6
            r6 = r3
            r3 = r0
            r32 = r5
            r5 = r2
            r2 = r15
            r15 = r32
            goto L_0x0200
        L_0x0145:
            r14 = 32
            if (r1 != r11) goto L_0x016e
            if (r3 != r11) goto L_0x016e
            if (r6 != r14) goto L_0x015b
            r3 = r0
            r6 = r2
            r1 = r13
            r2 = r15
            r5 = 48
            r13 = 8
        L_0x0155:
            r15 = r4
            r4 = r7
            r7 = 48
            goto L_0x0200
        L_0x015b:
            r3 = r0
            r1 = r13
            r5 = 48
            r13 = 9
        L_0x0161:
            r32 = r6
            r6 = r2
            r2 = r15
            r15 = r32
            r33 = r7
            r7 = r4
            r4 = r33
            goto L_0x0200
        L_0x016e:
            r14 = 46
            if (r0 != r14) goto L_0x0176
            r14 = 46
            if (r2 == r14) goto L_0x017a
        L_0x0176:
            if (r0 != r11) goto L_0x0188
            if (r2 != r11) goto L_0x0188
        L_0x017a:
            r2 = r4
            r4 = r5
            r5 = r7
            r7 = r13
            r13 = 10
            r32 = r6
            r6 = r1
            r1 = r3
            r3 = r32
            goto L_0x0200
        L_0x0188:
            r14 = 84
            if (r6 != r14) goto L_0x0196
            r5 = r1
            r6 = r2
            r1 = r13
            r2 = r15
            r13 = 8
            r15 = r4
            r4 = r7
            r7 = r3
            goto L_0x0133
        L_0x0196:
            r14 = 24180(0x5e74, float:3.3883E-41)
            if (r1 == r14) goto L_0x01a2
            r14 = 45380(0xb144, float:6.3591E-41)
            if (r1 != r14) goto L_0x01a0
            goto L_0x01a2
        L_0x01a0:
            r1 = 0
            return r1
        L_0x01a2:
            r1 = 26376(0x6708, float:3.696E-41)
            if (r4 == r1) goto L_0x01d4
            r1 = 50900(0xc6d4, float:7.1326E-41)
            if (r4 != r1) goto L_0x01ac
            goto L_0x01d4
        L_0x01ac:
            r1 = 26376(0x6708, float:3.696E-41)
            if (r3 == r1) goto L_0x01b5
            r1 = 50900(0xc6d4, float:7.1326E-41)
            if (r3 != r1) goto L_0x01b7
        L_0x01b5:
            r1 = 0
            goto L_0x01b9
        L_0x01b7:
            r1 = 0
            return r1
        L_0x01b9:
            if (r6 == r12) goto L_0x01cb
            if (r6 != r8) goto L_0x01be
            goto L_0x01cb
        L_0x01be:
            if (r5 == r12) goto L_0x01c4
            if (r5 != r8) goto L_0x01c3
            goto L_0x01c4
        L_0x01c3:
            return r1
        L_0x01c4:
            r3 = r0
            r1 = r13
            r5 = 48
            r13 = 10
            goto L_0x0161
        L_0x01cb:
            r3 = r0
            r6 = r2
            r1 = r13
            r2 = r15
            r5 = 48
            r13 = 10
            goto L_0x0155
        L_0x01d4:
            if (r5 == r12) goto L_0x01f6
            if (r5 != r8) goto L_0x01d9
            goto L_0x01f6
        L_0x01d9:
            int r1 = r9.bp
            int r1 = r1 + 10
            char r1 = r9.charAt(r1)
            if (r1 == r12) goto L_0x01f0
            int r1 = r9.bp
            int r1 = r1 + 10
            char r1 = r9.charAt(r1)
            if (r1 != r8) goto L_0x01ee
            goto L_0x01f0
        L_0x01ee:
            r1 = 0
            return r1
        L_0x01f0:
            r4 = r7
            r1 = r13
            r13 = 11
            goto L_0x013a
        L_0x01f6:
            r5 = r2
            r4 = r7
            r1 = r13
            r2 = r15
            r7 = 48
            r13 = 10
            goto L_0x0131
        L_0x0200:
            r24 = r1
            r25 = r2
            r26 = r3
            r27 = r4
            r28 = r5
            r29 = r6
            r30 = r7
            r31 = r15
            boolean r0 = checkDate(r24, r25, r26, r27, r28, r29, r30, r31)
            if (r0 != 0) goto L_0x0218
            r0 = 0
            return r0
        L_0x0218:
            r0 = r34
            r14 = 57
            r14 = 5
            r11 = 2
            r8 = r15
            r0.setCalendar(r1, r2, r3, r4, r5, r6, r7, r8)
            int r0 = r9.bp
            int r0 = r0 + r13
            char r7 = r9.charAt(r0)
            r0 = 84
            if (r7 != r0) goto L_0x02bc
            r0 = 16
            if (r10 != r0) goto L_0x02ba
            r0 = 8
            if (r13 != r0) goto L_0x02ba
            int r0 = r9.bp
            int r0 = r0 + 15
            char r0 = r9.charAt(r0)
            r1 = 90
            if (r0 != r1) goto L_0x02ba
            int r0 = r9.bp
            int r0 = r0 + r13
            r1 = 1
            int r0 = r0 + r1
            char r7 = r9.charAt(r0)
            int r0 = r9.bp
            int r0 = r0 + r13
            int r0 = r0 + r11
            char r8 = r9.charAt(r0)
            int r0 = r9.bp
            int r0 = r0 + r13
            int r0 = r0 + 3
            char r10 = r9.charAt(r0)
            int r0 = r9.bp
            int r0 = r0 + r13
            int r0 = r0 + 4
            char r11 = r9.charAt(r0)
            int r0 = r9.bp
            int r0 = r0 + r13
            int r0 = r0 + r14
            char r12 = r9.charAt(r0)
            int r0 = r9.bp
            int r0 = r0 + r13
            int r0 = r0 + 6
            char r13 = r9.charAt(r0)
            r0 = r34
            r1 = r7
            r2 = r8
            r3 = r10
            r4 = r11
            r5 = r12
            r6 = r13
            boolean r0 = r0.checkTime(r1, r2, r3, r4, r5, r6)
            if (r0 != 0) goto L_0x0285
            r15 = 0
            return r15
        L_0x0285:
            r15 = 0
            r0 = r34
            r1 = r7
            r2 = r8
            r3 = r10
            r4 = r11
            r5 = r12
            r6 = r13
            r0.setTime(r1, r2, r3, r4, r5, r6)
            java.util.Calendar r0 = r9.calendar
            r1 = 14
            r0.set(r1, r15)
            java.util.Calendar r0 = r9.calendar
            java.util.TimeZone r0 = r0.getTimeZone()
            int r0 = r0.getRawOffset()
            if (r0 == 0) goto L_0x02b6
            java.lang.String[] r0 = java.util.TimeZone.getAvailableIDs(r15)
            int r1 = r0.length
            if (r1 <= 0) goto L_0x02b6
            r0 = r0[r15]
            java.util.TimeZone r0 = java.util.TimeZone.getTimeZone(r0)
            java.util.Calendar r1 = r9.calendar
            r1.setTimeZone(r0)
        L_0x02b6:
            r9.token = r14
            goto L_0x00c1
        L_0x02ba:
            r0 = 84
        L_0x02bc:
            if (r7 == r0) goto L_0x02c4
            r0 = 32
            if (r7 != r0) goto L_0x02c8
            if (r35 != 0) goto L_0x02c8
        L_0x02c4:
            r12 = 58
            goto L_0x036c
        L_0x02c8:
            r0 = 34
            if (r7 == r0) goto L_0x02d7
            r0 = 26
            if (r7 == r0) goto L_0x02d7
            if (r7 == r12) goto L_0x02d7
            r0 = 51068(0xc77c, float:7.1562E-41)
            if (r7 != r0) goto L_0x02d9
        L_0x02d7:
            r0 = 0
            goto L_0x0341
        L_0x02d9:
            r0 = 43
            if (r7 == r0) goto L_0x02e4
            r0 = 45
            if (r7 != r0) goto L_0x02e2
            goto L_0x02e4
        L_0x02e2:
            r0 = 0
            return r0
        L_0x02e4:
            int r0 = r9.len
            int r1 = r13 + 6
            if (r0 != r1) goto L_0x033f
            int r0 = r9.bp
            int r0 = r0 + r13
            int r0 = r0 + 3
            char r0 = r9.charAt(r0)
            r12 = 58
            if (r0 != r12) goto L_0x030e
            int r0 = r9.bp
            int r0 = r0 + r13
            int r0 = r0 + 4
            char r0 = r9.charAt(r0)
            r1 = 48
            if (r0 != r1) goto L_0x030e
            int r0 = r9.bp
            int r0 = r0 + r13
            int r0 = r0 + r14
            char r0 = r9.charAt(r0)
            if (r0 == r1) goto L_0x0310
        L_0x030e:
            r0 = 0
            goto L_0x033e
        L_0x0310:
            r5 = 48
            r6 = 48
            r1 = 48
            r2 = 48
            r3 = 48
            r4 = 48
            r0 = r34
            r0.setTime(r1, r2, r3, r4, r5, r6)
            java.util.Calendar r0 = r9.calendar
            r1 = 0
            r2 = 14
            r0.set(r2, r1)
            int r0 = r9.bp
            int r0 = r0 + r13
            r1 = 1
            int r0 = r0 + r1
            char r0 = r9.charAt(r0)
            int r2 = r9.bp
            int r2 = r2 + r13
            int r2 = r2 + r11
            char r2 = r9.charAt(r2)
            r9.setTimeZone(r7, r0, r2)
            return r1
        L_0x033e:
            return r0
        L_0x033f:
            r0 = 0
            return r0
        L_0x0341:
            java.util.Calendar r1 = r9.calendar
            r2 = 11
            r1.set(r2, r0)
            java.util.Calendar r1 = r9.calendar
            r2 = 12
            r1.set(r2, r0)
            java.util.Calendar r1 = r9.calendar
            r2 = 13
            r1.set(r2, r0)
            java.util.Calendar r1 = r9.calendar
            r2 = 14
            r1.set(r2, r0)
            int r0 = r9.bp
            int r0 = r0 + r13
            r9.bp = r0
            char r0 = r9.charAt(r0)
            r9.ch = r0
            r9.token = r14
            goto L_0x00c1
        L_0x036c:
            int r0 = r13 + 9
            if (r10 >= r0) goto L_0x0372
            r0 = 0
            return r0
        L_0x0372:
            r0 = 0
            int r1 = r9.bp
            int r1 = r1 + r13
            int r1 = r1 + 3
            char r1 = r9.charAt(r1)
            if (r1 == r12) goto L_0x037f
            return r0
        L_0x037f:
            int r1 = r9.bp
            int r1 = r1 + r13
            int r1 = r1 + 6
            char r1 = r9.charAt(r1)
            if (r1 == r12) goto L_0x038b
            return r0
        L_0x038b:
            int r0 = r9.bp
            int r0 = r0 + r13
            r1 = 1
            int r0 = r0 + r1
            char r7 = r9.charAt(r0)
            int r0 = r9.bp
            int r0 = r0 + r13
            int r0 = r0 + r11
            char r8 = r9.charAt(r0)
            int r0 = r9.bp
            int r0 = r0 + r13
            int r0 = r0 + 4
            char r15 = r9.charAt(r0)
            int r0 = r9.bp
            int r0 = r0 + r13
            int r0 = r0 + r14
            char r19 = r9.charAt(r0)
            int r0 = r9.bp
            int r0 = r0 + r13
            int r0 = r0 + 7
            char r20 = r9.charAt(r0)
            int r0 = r9.bp
            int r0 = r0 + r13
            r1 = 8
            int r0 = r0 + r1
            char r18 = r9.charAt(r0)
            r0 = r34
            r1 = r7
            r2 = r8
            r3 = r15
            r4 = r19
            r5 = r20
            r6 = r18
            boolean r0 = r0.checkTime(r1, r2, r3, r4, r5, r6)
            if (r0 != 0) goto L_0x03d3
            r0 = 0
            return r0
        L_0x03d3:
            r0 = r34
            r1 = r7
            r2 = r8
            r3 = r15
            r4 = r19
            r5 = r20
            r6 = r18
            r0.setTime(r1, r2, r3, r4, r5, r6)
            int r0 = r9.bp
            int r0 = r0 + r13
            r1 = 9
            int r0 = r0 + r1
            char r0 = r9.charAt(r0)
            r1 = 46
            if (r0 != r1) goto L_0x043c
            int r0 = r13 + 11
            if (r10 >= r0) goto L_0x03f5
            r1 = 0
            return r1
        L_0x03f5:
            int r1 = r9.bp
            int r1 = r1 + r13
            int r1 = r1 + 10
            char r1 = r9.charAt(r1)
            r2 = 48
            if (r1 < r2) goto L_0x0406
            r3 = 57
            if (r1 <= r3) goto L_0x0408
        L_0x0406:
            r0 = 0
            goto L_0x043b
        L_0x0408:
            int r1 = r1 - r2
            if (r10 <= r0) goto L_0x041f
            int r0 = r9.bp
            int r0 = r0 + r13
            r4 = 11
            int r0 = r0 + r4
            char r0 = r9.charAt(r0)
            if (r0 < r2) goto L_0x041f
            if (r0 > r3) goto L_0x041f
            int r1 = r1 * 10
            int r0 = r0 - r2
            int r1 = r1 + r0
            r8 = 2
            goto L_0x0420
        L_0x041f:
            r8 = 1
        L_0x0420:
            if (r8 != r11) goto L_0x0439
            int r0 = r9.bp
            int r0 = r0 + r13
            int r0 = r0 + 12
            char r0 = r9.charAt(r0)
            r2 = 48
            if (r0 < r2) goto L_0x0439
            r3 = 57
            if (r0 > r3) goto L_0x0439
            int r1 = r1 * 10
            int r0 = r0 - r2
            int r0 = r0 + r1
            r8 = 3
            goto L_0x043e
        L_0x0439:
            r0 = r1
            goto L_0x043e
        L_0x043b:
            return r0
        L_0x043c:
            r8 = -1
            r0 = 0
        L_0x043e:
            java.util.Calendar r1 = r9.calendar
            r2 = 14
            r1.set(r2, r0)
            int r0 = r9.bp
            int r0 = r0 + r13
            int r0 = r0 + 10
            int r0 = r0 + r8
            char r0 = r9.charAt(r0)
            r1 = 32
            if (r0 != r1) goto L_0x045f
            int r8 = r8 + 1
            int r0 = r9.bp
            int r0 = r0 + r13
            int r0 = r0 + 10
            int r0 = r0 + r8
            char r0 = r9.charAt(r0)
        L_0x045f:
            r1 = r0
            r0 = 43
            if (r1 == r0) goto L_0x0494
            r0 = 45
            if (r1 != r0) goto L_0x0469
            goto L_0x0494
        L_0x0469:
            r0 = 90
            if (r1 != r0) goto L_0x0490
            java.util.Calendar r0 = r9.calendar
            java.util.TimeZone r0 = r0.getTimeZone()
            int r0 = r0.getRawOffset()
            if (r0 == 0) goto L_0x048c
            r0 = 0
            java.lang.String[] r1 = java.util.TimeZone.getAvailableIDs(r0)
            int r2 = r1.length
            if (r2 <= 0) goto L_0x048c
            r1 = r1[r0]
            java.util.TimeZone r0 = java.util.TimeZone.getTimeZone(r1)
            java.util.Calendar r1 = r9.calendar
            r1.setTimeZone(r0)
        L_0x048c:
            r16 = 1
            goto L_0x056c
        L_0x0490:
            r16 = 0
            goto L_0x056c
        L_0x0494:
            int r0 = r9.bp
            int r0 = r0 + r13
            int r0 = r0 + 10
            int r0 = r0 + r8
            r2 = 1
            int r0 = r0 + r2
            char r2 = r9.charAt(r0)
            r0 = 48
            if (r2 < r0) goto L_0x04a8
            r3 = 49
            if (r2 <= r3) goto L_0x04ab
        L_0x04a8:
            r5 = 0
            goto L_0x0591
        L_0x04ab:
            int r3 = r9.bp
            int r3 = r3 + r13
            int r3 = r3 + 10
            int r3 = r3 + r8
            int r3 = r3 + r11
            char r3 = r9.charAt(r3)
            if (r3 < r0) goto L_0x04bc
            r0 = 57
            if (r3 <= r0) goto L_0x04bf
        L_0x04bc:
            r5 = 0
            goto L_0x0591
        L_0x04bf:
            int r0 = r9.bp
            int r0 = r0 + r13
            int r0 = r0 + 10
            int r0 = r0 + r8
            int r0 = r0 + 3
            char r0 = r9.charAt(r0)
            r4 = 51
            if (r0 != r12) goto L_0x0517
            int r0 = r9.bp
            int r0 = r0 + r13
            int r0 = r0 + 10
            int r0 = r0 + r8
            int r0 = r0 + 4
            char r0 = r9.charAt(r0)
            int r5 = r9.bp
            int r5 = r5 + r13
            int r5 = r5 + 10
            int r5 = r5 + r8
            int r5 = r5 + r14
            char r5 = r9.charAt(r5)
            r6 = 52
            if (r0 != r6) goto L_0x0508
            r6 = 53
            if (r5 != r6) goto L_0x0508
            r6 = 49
            if (r2 != r6) goto L_0x04f9
            r6 = 50
            if (r3 == r6) goto L_0x0513
            if (r3 != r4) goto L_0x04f9
            goto L_0x0513
        L_0x04f9:
            r4 = 48
            if (r2 != r4) goto L_0x0506
            r4 = 53
            if (r3 == r4) goto L_0x0513
            r4 = 56
            if (r3 != r4) goto L_0x0506
            goto L_0x0513
        L_0x0506:
            r6 = 0
            return r6
        L_0x0508:
            r6 = 0
            r7 = 48
            if (r0 == r7) goto L_0x0510
            if (r0 == r4) goto L_0x0510
            return r6
        L_0x0510:
            if (r5 == r7) goto L_0x0513
            return r6
        L_0x0513:
            r4 = r0
            r16 = 6
            goto L_0x0567
        L_0x0517:
            r7 = 48
            if (r0 != r7) goto L_0x0533
            int r0 = r9.bp
            int r0 = r0 + r13
            int r0 = r0 + 10
            int r0 = r0 + r8
            int r0 = r0 + 4
            char r0 = r9.charAt(r0)
            if (r0 == r7) goto L_0x052d
            if (r0 == r4) goto L_0x052d
            r4 = 0
            return r4
        L_0x052d:
            r4 = r0
        L_0x052e:
            r5 = 48
        L_0x0530:
            r16 = 5
            goto L_0x0567
        L_0x0533:
            if (r0 != r4) goto L_0x0546
            int r5 = r9.bp
            int r5 = r5 + r13
            int r5 = r5 + 10
            int r5 = r5 + r8
            int r5 = r5 + 4
            char r5 = r9.charAt(r5)
            r6 = 48
            if (r5 != r6) goto L_0x0546
            goto L_0x052e
        L_0x0546:
            r4 = 52
            if (r0 != r4) goto L_0x0563
            int r0 = r9.bp
            int r0 = r0 + r13
            int r0 = r0 + 10
            int r0 = r0 + r8
            int r0 = r0 + 4
            char r0 = r9.charAt(r0)
            r4 = 53
            if (r0 != r4) goto L_0x0563
            r0 = 52
            r4 = 53
            r4 = 52
            r5 = 53
            goto L_0x0530
        L_0x0563:
            r4 = 48
            r5 = 48
        L_0x0567:
            r0 = r34
            r0.setTimeZone(r1, r2, r3, r4, r5)
        L_0x056c:
            int r0 = r9.bp
            int r13 = r13 + 10
            int r13 = r13 + r8
            int r13 = r13 + r16
            int r0 = r0 + r13
            char r0 = r9.charAt(r0)
            r1 = 26
            if (r0 == r1) goto L_0x0582
            r1 = 34
            if (r0 == r1) goto L_0x0582
            r5 = 0
            return r5
        L_0x0582:
            int r0 = r9.bp
            int r0 = r0 + r13
            r9.bp = r0
            char r0 = r9.charAt(r0)
            r9.ch = r0
            r9.token = r14
            goto L_0x00c1
        L_0x0591:
            return r5
        L_0x0592:
            if (r35 == 0) goto L_0x0595
            return r5
        L_0x0595:
            int r5 = r9.bp
            r6 = 8
            int r5 = r5 + r6
            char r11 = r9.charAt(r5)
            r5 = 45
            if (r1 != r5) goto L_0x05a6
            if (r4 != r5) goto L_0x05a6
            r5 = 1
            goto L_0x05a7
        L_0x05a6:
            r5 = 0
        L_0x05a7:
            if (r5 == 0) goto L_0x05b0
            r6 = 16
            if (r10 != r6) goto L_0x05b0
            r16 = 1
            goto L_0x05b2
        L_0x05b0:
            r16 = 0
        L_0x05b2:
            if (r5 == 0) goto L_0x05bb
            r5 = 17
            if (r10 != r5) goto L_0x05bb
            r17 = 1
            goto L_0x05bd
        L_0x05bb:
            r17 = 0
        L_0x05bd:
            if (r17 != 0) goto L_0x05da
            if (r16 == 0) goto L_0x05c2
            goto L_0x05da
        L_0x05c2:
            r5 = 45
            if (r1 != r5) goto L_0x05d1
            if (r3 != r5) goto L_0x05d1
            r22 = r2
            r24 = r4
            r19 = 48
            r23 = 48
            goto L_0x05eb
        L_0x05d1:
            r19 = r1
            r22 = r2
            r23 = r3
            r24 = r4
            goto L_0x05eb
        L_0x05da:
            int r1 = r9.bp
            r4 = 9
            int r1 = r1 + r4
            char r1 = r9.charAt(r1)
            r24 = r1
            r19 = r2
            r22 = r3
            r23 = r11
        L_0x05eb:
            r1 = r13
            r2 = r15
            r3 = r0
            r4 = r7
            r5 = r19
            r6 = r22
            r25 = r7
            r7 = r23
            r8 = r24
            boolean r1 = checkDate(r1, r2, r3, r4, r5, r6, r7, r8)
            if (r1 != 0) goto L_0x0601
            r1 = 0
            return r1
        L_0x0601:
            r3 = r0
            r0 = r34
            r1 = r13
            r2 = r15
            r4 = r25
            r5 = r19
            r6 = r22
            r7 = r23
            r8 = r24
            r0.setCalendar(r1, r2, r3, r4, r5, r6, r7, r8)
            r0 = 8
            if (r10 == r0) goto L_0x06ed
            int r0 = r9.bp
            r1 = 9
            int r0 = r0 + r1
            char r0 = r9.charAt(r0)
            int r1 = r9.bp
            int r1 = r1 + 10
            char r1 = r9.charAt(r1)
            int r2 = r9.bp
            r3 = 11
            int r2 = r2 + r3
            char r2 = r9.charAt(r2)
            int r3 = r9.bp
            int r3 = r3 + 12
            char r3 = r9.charAt(r3)
            int r4 = r9.bp
            int r4 = r4 + 13
            char r4 = r9.charAt(r4)
            if (r17 == 0) goto L_0x0656
            r5 = 84
            if (r1 != r5) goto L_0x0656
            if (r4 != r12) goto L_0x0656
            int r5 = r9.bp
            r6 = 16
            int r5 = r5 + r6
            char r5 = r9.charAt(r5)
            r6 = 90
            if (r5 == r6) goto L_0x0662
        L_0x0656:
            if (r16 == 0) goto L_0x067c
            r5 = 32
            if (r1 == r5) goto L_0x0660
            r5 = 84
            if (r1 != r5) goto L_0x067c
        L_0x0660:
            if (r4 != r12) goto L_0x067c
        L_0x0662:
            int r0 = r9.bp
            r1 = 14
            int r0 = r0 + r1
            char r1 = r9.charAt(r0)
            int r0 = r9.bp
            int r0 = r0 + 15
            char r0 = r9.charAt(r0)
            r13 = r0
            r8 = r1
            r15 = r2
            r7 = r3
            r11 = 48
            r12 = 48
            goto L_0x0682
        L_0x067c:
            r7 = r0
            r8 = r1
            r13 = r2
            r12 = r4
            r15 = r11
            r11 = r3
        L_0x0682:
            r0 = r34
            r1 = r15
            r2 = r7
            r3 = r8
            r4 = r13
            r5 = r11
            r6 = r12
            boolean r0 = r0.checkTime(r1, r2, r3, r4, r5, r6)
            if (r0 != 0) goto L_0x0692
            r0 = 0
            return r0
        L_0x0692:
            r0 = 17
            if (r10 != r0) goto L_0x06d5
            if (r17 != 0) goto L_0x06d5
            int r0 = r9.bp
            r1 = 14
            int r0 = r0 + r1
            char r0 = r9.charAt(r0)
            int r1 = r9.bp
            int r1 = r1 + 15
            char r1 = r9.charAt(r1)
            int r2 = r9.bp
            r3 = 16
            int r2 = r2 + r3
            char r2 = r9.charAt(r2)
            r3 = 48
            if (r0 < r3) goto L_0x06ba
            r4 = 57
            if (r0 <= r4) goto L_0x06bc
        L_0x06ba:
            r0 = 0
            goto L_0x06d4
        L_0x06bc:
            if (r1 < r3) goto L_0x06c0
            if (r1 <= r4) goto L_0x06c2
        L_0x06c0:
            r0 = 0
            goto L_0x06d4
        L_0x06c2:
            if (r2 < r3) goto L_0x06c6
            if (r2 <= r4) goto L_0x06c8
        L_0x06c6:
            r0 = 0
            goto L_0x06d4
        L_0x06c8:
            int r0 = r0 - r3
            int r0 = r0 * 100
            int r1 = r1 - r3
            int r1 = r1 * 10
            int r0 = r0 + r1
            int r2 = r2 - r3
            int r0 = r0 + r2
        L_0x06d1:
            r1 = 48
            goto L_0x06d7
        L_0x06d4:
            return r0
        L_0x06d5:
            r0 = 0
            goto L_0x06d1
        L_0x06d7:
            int r15 = r15 - r1
            int r15 = r15 * 10
            int r7 = r7 - r1
            int r2 = r15 + r7
            int r8 = r8 - r1
            int r8 = r8 * 10
            int r13 = r13 - r1
            int r3 = r8 + r13
            int r11 = r11 - r1
            int r11 = r11 * 10
            int r12 = r12 - r1
            int r11 = r11 + r12
            r1 = r11
            r11 = r2
            r2 = r0
            r0 = r3
            goto L_0x06f1
        L_0x06ed:
            r0 = 0
            r1 = 0
            r2 = 0
            r11 = 0
        L_0x06f1:
            java.util.Calendar r3 = r9.calendar
            r4 = 11
            r3.set(r4, r11)
            java.util.Calendar r3 = r9.calendar
            r4 = 12
            r3.set(r4, r0)
            java.util.Calendar r0 = r9.calendar
            r3 = 13
            r0.set(r3, r1)
            java.util.Calendar r0 = r9.calendar
            r1 = 14
            r0.set(r1, r2)
            r9.token = r14
            goto L_0x00c1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONScanner.scanISO8601DateIfMatch(boolean, int):boolean");
    }

    public final boolean charArrayCompare(char[] cArr) {
        return charArrayCompare(this.text, this.bp, cArr);
    }

    public JSONScanner(char[] cArr, int i) {
        this(cArr, i, JSON.DEFAULT_PARSER_FEATURE);
    }

    public JSONScanner(char[] cArr, int i, int i2) {
        this(new String(cArr, 0, i), i2);
    }

    public String[] scanFieldStringArray(char[] cArr, int i, SymbolTable symbolTable) {
        char c;
        int i2;
        int i3 = this.bp;
        char c2 = this.ch;
        while (JSONLexerBase.isWhitespace(this.ch)) {
            next();
        }
        if (cArr != null) {
            this.matchStat = 0;
            if (!charArrayCompare(cArr)) {
                this.matchStat = -2;
                return null;
            }
            int length = this.bp + cArr.length;
            int i4 = length + 1;
            char charAt = this.text.charAt(length);
            while (JSONLexerBase.isWhitespace(charAt)) {
                charAt = this.text.charAt(i4);
                i4++;
            }
            if (charAt == ':') {
                i2 = i4 + 1;
                c = this.text.charAt(i4);
                while (JSONLexerBase.isWhitespace(c)) {
                    c = this.text.charAt(i2);
                    i2++;
                }
            } else {
                this.matchStat = -1;
                return null;
            }
        } else {
            i2 = this.bp + 1;
            c = this.ch;
        }
        if (c == '[') {
            this.bp = i2;
            this.ch = this.text.charAt(i2);
            String[] strArr = i >= 0 ? new String[i] : new String[4];
            int i5 = 0;
            while (true) {
                if (JSONLexerBase.isWhitespace(this.ch)) {
                    next();
                } else if (this.ch != '\"') {
                    this.bp = i3;
                    this.ch = c2;
                    this.matchStat = -1;
                    return null;
                } else {
                    String scanSymbol = scanSymbol(symbolTable, '\"');
                    if (i5 == strArr.length) {
                        String[] strArr2 = new String[(strArr.length + (strArr.length >> 1) + 1)];
                        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
                        strArr = strArr2;
                    }
                    int i6 = i5 + 1;
                    strArr[i5] = scanSymbol;
                    while (JSONLexerBase.isWhitespace(this.ch)) {
                        next();
                    }
                    if (this.ch == ',') {
                        next();
                        i5 = i6;
                    } else {
                        if (strArr.length != i6) {
                            String[] strArr3 = new String[i6];
                            System.arraycopy(strArr, 0, strArr3, 0, i6);
                            strArr = strArr3;
                        }
                        while (JSONLexerBase.isWhitespace(this.ch)) {
                            next();
                        }
                        if (this.ch == ']') {
                            next();
                            return strArr;
                        }
                        this.bp = i3;
                        this.ch = c2;
                        this.matchStat = -1;
                        return null;
                    }
                }
            }
        } else if (c != 'n' || !this.text.startsWith("ull", this.bp + 1)) {
            this.matchStat = -1;
            return null;
        } else {
            int i7 = this.bp + 4;
            this.bp = i7;
            this.ch = this.text.charAt(i7);
            return null;
        }
    }

    public int seekObjectToField(long[] jArr) {
        char c;
        char c2;
        char c3;
        char c4;
        int i = this.token;
        if (i == 12 || i == 16) {
            while (true) {
                char c5 = this.ch;
                if (c5 == '}') {
                    next();
                    nextToken();
                    this.matchStat = -1;
                    return -1;
                }
                char c6 = JSONLexer.EOI;
                if (c5 == 26) {
                    this.matchStat = -1;
                    return -1;
                }
                if (c5 != '\"') {
                    skipWhitespace();
                }
                if (this.ch == '\"') {
                    int i2 = this.bp + 1;
                    long j = TypeUtils.fnv1a_64_magic_hashcode;
                    while (true) {
                        if (i2 >= this.text.length()) {
                            break;
                        }
                        char charAt = this.text.charAt(i2);
                        if (charAt == '\\') {
                            i2++;
                            if (i2 != this.text.length()) {
                                charAt = this.text.charAt(i2);
                            } else {
                                throw new JSONException("unclosed str, " + info());
                            }
                        }
                        if (charAt == '\"') {
                            int i3 = i2 + 1;
                            this.bp = i3;
                            if (i3 >= this.text.length()) {
                                c4 = JSONLexer.EOI;
                            } else {
                                c4 = this.text.charAt(this.bp);
                            }
                            this.ch = c4;
                        } else {
                            j = (j ^ ((long) charAt)) * TypeUtils.fnv1a_64_magic_prime;
                            i2++;
                        }
                    }
                    int i4 = 0;
                    while (true) {
                        if (i4 >= jArr.length) {
                            i4 = -1;
                            break;
                        } else if (j == jArr[i4]) {
                            break;
                        } else {
                            i4++;
                        }
                    }
                    if (i4 != -1) {
                        if (this.ch != ':') {
                            skipWhitespace();
                        }
                        if (this.ch == ':') {
                            int i5 = this.bp + 1;
                            this.bp = i5;
                            if (i5 >= this.text.length()) {
                                c = JSONLexer.EOI;
                            } else {
                                c = this.text.charAt(i5);
                            }
                            this.ch = c;
                            if (c == ',') {
                                int i6 = this.bp + 1;
                                this.bp = i6;
                                if (i6 < this.text.length()) {
                                    c6 = this.text.charAt(i6);
                                }
                                this.ch = c6;
                                this.token = 16;
                            } else if (c == ']') {
                                int i7 = this.bp + 1;
                                this.bp = i7;
                                if (i7 < this.text.length()) {
                                    c6 = this.text.charAt(i7);
                                }
                                this.ch = c6;
                                this.token = 15;
                            } else if (c == '}') {
                                int i8 = this.bp + 1;
                                this.bp = i8;
                                if (i8 < this.text.length()) {
                                    c6 = this.text.charAt(i8);
                                }
                                this.ch = c6;
                                this.token = 13;
                            } else if (c < '0' || c > '9') {
                                nextToken(2);
                            } else {
                                this.sp = 0;
                                this.pos = this.bp;
                                scanNumber();
                            }
                        }
                        this.matchStat = 3;
                        return i4;
                    }
                    if (this.ch != ':') {
                        skipWhitespace();
                    }
                    if (this.ch == ':') {
                        int i9 = this.bp + 1;
                        this.bp = i9;
                        if (i9 >= this.text.length()) {
                            c2 = JSONLexer.EOI;
                        } else {
                            c2 = this.text.charAt(i9);
                        }
                        this.ch = c2;
                        if (!(c2 == '\"' || c2 == '\'' || c2 == '{' || c2 == '[' || c2 == '0' || c2 == '1' || c2 == '2' || c2 == '3' || c2 == '4' || c2 == '5' || c2 == '6' || c2 == '7' || c2 == '8' || c2 == '9' || c2 == '+' || c2 == '-')) {
                            skipWhitespace();
                        }
                        char c7 = this.ch;
                        if (c7 == '-' || c7 == '+' || (c7 >= '0' && c7 <= '9')) {
                            next();
                            while (true) {
                                c3 = this.ch;
                                if (c3 >= '0' && c3 <= '9') {
                                    next();
                                }
                            }
                            if (c3 == '.') {
                                next();
                                while (true) {
                                    char c8 = this.ch;
                                    if (c8 < '0' || c8 > '9') {
                                        break;
                                    }
                                    next();
                                }
                            }
                            char c9 = this.ch;
                            if (c9 == 'E' || c9 == 'e') {
                                next();
                                char c10 = this.ch;
                                if (c10 == '-' || c10 == '+') {
                                    next();
                                }
                                while (true) {
                                    char c11 = this.ch;
                                    if (c11 < '0' || c11 > '9') {
                                        break;
                                    }
                                    next();
                                }
                            }
                            if (this.ch != ',') {
                                skipWhitespace();
                            }
                            if (this.ch == ',') {
                                next();
                            }
                        } else if (c7 == '\"') {
                            skipString();
                            char c12 = this.ch;
                            if (!(c12 == ',' || c12 == '}')) {
                                skipWhitespace();
                            }
                            if (this.ch == ',') {
                                next();
                            }
                        } else if (c7 == '{') {
                            int i10 = this.bp + 1;
                            this.bp = i10;
                            if (i10 < this.text.length()) {
                                c6 = this.text.charAt(i10);
                            }
                            this.ch = c6;
                            skipObject(false);
                        } else if (c7 == '[') {
                            next();
                            skipArray(false);
                        } else {
                            throw new UnsupportedOperationException();
                        }
                    } else {
                        throw new JSONException("illegal json, " + info());
                    }
                } else {
                    throw new UnsupportedOperationException();
                }
            }
        } else {
            throw new UnsupportedOperationException();
        }
    }
}
