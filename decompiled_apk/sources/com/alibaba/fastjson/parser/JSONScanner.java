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
import java.util.Date;
import java.util.SimpleTimeZone;

/* loaded from: classes.dex */
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
            } else if (c5 != '1' || (c6 != '0' && c6 != '1' && c6 != '2')) {
                return false;
            }
            if (i == 48) {
                return i2 >= 49 && i2 <= 57;
            }
            if (i != 49 && i != 50) {
                return i == 51 && (i2 == 48 || i2 == 49);
            }
            if (i2 >= 48 && i2 <= 57) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x001d, code lost:
    
        if (r6 <= '4') goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean checkTime(char r5, char r6, char r7, char r8, char r9, char r10) {
        /*
            r4 = this;
            r0 = 57
            r1 = 0
            r2 = 48
            if (r5 != r2) goto Lc
            if (r6 < r2) goto Lb
            if (r6 <= r0) goto L20
        Lb:
            return r1
        Lc:
            r3 = 49
            if (r5 != r3) goto L15
            if (r6 < r2) goto L14
            if (r6 <= r0) goto L20
        L14:
            return r1
        L15:
            r3 = 50
            if (r5 != r3) goto L42
            if (r6 < r2) goto L42
            r5 = 52
            if (r6 <= r5) goto L20
            goto L42
        L20:
            r5 = 54
            r6 = 53
            if (r7 < r2) goto L2d
            if (r7 > r6) goto L2d
            if (r8 < r2) goto L2c
            if (r8 <= r0) goto L32
        L2c:
            return r1
        L2d:
            if (r7 != r5) goto L42
            if (r8 == r2) goto L32
            return r1
        L32:
            if (r9 < r2) goto L3b
            if (r9 > r6) goto L3b
            if (r10 < r2) goto L3a
            if (r10 <= r0) goto L40
        L3a:
            return r1
        L3b:
            if (r9 != r5) goto L42
            if (r10 == r2) goto L40
            return r1
        L40:
            r5 = 1
            return r5
        L42:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONScanner.checkTime(char, char, char, char, char, char):boolean");
    }

    private void setCalendar(char c, char c2, char c3, char c4, char c5, char c6, char c7, char c8) {
        Calendar calendar = Calendar.getInstance(this.timeZone, this.locale);
        this.calendar = calendar;
        calendar.set(1, ((c - '0') * 1000) + ((c2 - '0') * 100) + ((c3 - '0') * 10) + (c4 - '0'));
        this.calendar.set(2, (((c5 - '0') * 10) + (c6 - '0')) - 1);
        this.calendar.set(5, ((c7 - '0') * 10) + (c8 - '0'));
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final String addSymbol(int i, int i2, int i3, SymbolTable symbolTable) {
        return symbolTable.addSymbol(this.text, i, i2, i3);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final void arrayCopy(int i, char[] cArr, int i2, int i3) {
        this.text.getChars(i, i3 + i, cArr, i2);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
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
        }
        if (!this.hasSpecial) {
            return IOUtils.decodeBase64(this.text, this.np + 1, this.sp);
        }
        return IOUtils.decodeBase64(new String(this.sbuf, 0, this.sp));
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final char charAt(int i) {
        if (i >= this.len) {
            return JSONLexer.EOI;
        }
        return this.text.charAt(i);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final void copyTo(int i, int i2, char[] cArr) {
        this.text.getChars(i, i2 + i, cArr, 0);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
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

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final int indexOf(char c, int i) {
        return this.text.indexOf(c, i);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public String info() {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int i2 = 1;
        int i3 = 1;
        while (i < this.bp) {
            if (this.text.charAt(i) == '\n') {
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

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public boolean isEOF() {
        int i = this.bp;
        int i2 = this.len;
        if (i == i2) {
            return true;
        }
        if (this.ch == 26 && i + 1 >= i2) {
            return true;
        }
        return false;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
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

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final char next() {
        char charAt;
        int i = this.bp + 1;
        this.bp = i;
        if (i >= this.len) {
            charAt = JSONLexer.EOI;
        } else {
            charAt = this.text.charAt(i);
        }
        this.ch = charAt;
        return charAt;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final String numberString() {
        char charAt = charAt((this.np + this.sp) - 1);
        int i = this.sp;
        if (charAt == 'L' || charAt == 'S' || charAt == 'B' || charAt == 'F' || charAt == 'D') {
            i--;
        }
        return subString(this.np, i);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public Date scanDate(char c) {
        char c2;
        long j;
        Date date;
        char charAt;
        boolean z = false;
        this.matchStat = 0;
        int i = this.bp;
        char c3 = this.ch;
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
                            int i3 = indexOf + 1;
                            char charAt3 = charAt(indexOf + 2);
                            indexOf = i3;
                            c2 = charAt3;
                        } else {
                            this.bp = i;
                            this.ch = c3;
                            this.matchStat = -1;
                            return null;
                        }
                    }
                    this.bp = indexOf + 1;
                    this.ch = c2;
                } else {
                    this.bp = i;
                    this.ch = c3;
                    this.matchStat = -1;
                    return null;
                }
            } else {
                throw new JSONException("unclosed str");
            }
        } else {
            char c4 = '9';
            char c5 = '0';
            if (charAt2 != '-' && (charAt2 < '0' || charAt2 > '9')) {
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
                this.ch = c3;
                this.matchStat = -1;
                return null;
            }
            if (charAt2 == '-') {
                charAt2 = charAt(i2);
                i2 = i + 2;
                z = true;
            }
            if (charAt2 >= '0' && charAt2 <= '9') {
                j = charAt2 - '0';
                while (true) {
                    int i7 = i2 + 1;
                    charAt = charAt(i2);
                    if (charAt < c5 || charAt > c4) {
                        break;
                    }
                    j = (j * 10) + (charAt - '0');
                    i2 = i7;
                    c4 = '9';
                    c5 = '0';
                }
                if (charAt == ',' || charAt == ']') {
                    this.bp = i2;
                }
                c2 = charAt;
            } else {
                c2 = charAt2;
                j = 0;
            }
            if (j < 0) {
                this.bp = i;
                this.ch = c3;
                this.matchStat = -1;
                return null;
            }
            if (z) {
                j = -j;
            }
            date = new Date(j);
        }
        if (c2 == ',') {
            int i8 = this.bp + 1;
            this.bp = i8;
            this.ch = charAt(i8);
            this.matchStat = 3;
            return date;
        }
        int i9 = this.bp + 1;
        this.bp = i9;
        char charAt4 = charAt(i9);
        if (charAt4 == ',') {
            this.token = 16;
            int i10 = this.bp + 1;
            this.bp = i10;
            this.ch = charAt(i10);
        } else if (charAt4 == ']') {
            this.token = 15;
            int i11 = this.bp + 1;
            this.bp = i11;
            this.ch = charAt(i11);
        } else if (charAt4 == '}') {
            this.token = 13;
            int i12 = this.bp + 1;
            this.bp = i12;
            this.ch = charAt(i12);
        } else if (charAt4 == 26) {
            this.ch = JSONLexer.EOI;
            this.token = 20;
        } else {
            this.bp = i;
            this.ch = c3;
            this.matchStat = -1;
            return null;
        }
        this.matchStat = 4;
        return date;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public double scanDouble(char c) {
        boolean z;
        boolean z2;
        int i;
        char charAt;
        long j;
        boolean z3;
        int i2;
        int i3;
        double parseDouble;
        char charAt2;
        this.matchStat = 0;
        int i4 = this.bp;
        int i5 = i4 + 1;
        char charAt3 = charAt(i4);
        if (charAt3 == '\"') {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            charAt3 = charAt(i5);
            i5 = i4 + 2;
        }
        if (charAt3 == '-') {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            charAt3 = charAt(i5);
            i5++;
        }
        if (charAt3 >= '0') {
            char c2 = '9';
            if (charAt3 <= '9') {
                long j2 = charAt3 - '0';
                while (true) {
                    i = i5 + 1;
                    charAt = charAt(i5);
                    if (charAt < '0' || charAt > '9') {
                        break;
                    }
                    j2 = (j2 * 10) + (charAt - '0');
                    i5 = i;
                }
                if (charAt == '.') {
                    int i6 = i5 + 2;
                    char charAt4 = charAt(i);
                    if (charAt4 >= '0' && charAt4 <= '9') {
                        j2 = (j2 * 10) + (charAt4 - '0');
                        long j3 = 10;
                        while (true) {
                            i = i6 + 1;
                            charAt2 = charAt(i6);
                            if (charAt2 < '0' || charAt2 > c2) {
                                break;
                            }
                            j2 = (j2 * 10) + (charAt2 - '0');
                            j3 *= 10;
                            i6 = i;
                            c2 = '9';
                        }
                        long j4 = j3;
                        charAt = charAt2;
                        j = j4;
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
                    int i7 = i + 1;
                    char charAt5 = charAt(i);
                    if (charAt5 != '+' && charAt5 != '-') {
                        i = i7;
                        charAt = charAt5;
                    } else {
                        i += 2;
                        charAt = charAt(i7);
                    }
                    while (charAt >= '0' && charAt <= '9') {
                        int i8 = i + 1;
                        char charAt6 = charAt(i);
                        i = i8;
                        charAt = charAt6;
                    }
                }
                if (z) {
                    if (charAt != '\"') {
                        this.matchStat = -1;
                        return OOXIXo.f3760XO;
                    }
                    int i9 = i + 1;
                    char charAt7 = charAt(i);
                    i2 = this.bp + 1;
                    i3 = (i9 - i2) - 2;
                    i = i9;
                    charAt = charAt7;
                } else {
                    i2 = this.bp;
                    i3 = (i - i2) - 1;
                }
                if (!z3 && i3 < 18) {
                    parseDouble = j2 / j;
                    if (z2) {
                        parseDouble = -parseDouble;
                    }
                } else {
                    parseDouble = Double.parseDouble(subString(i2, i3));
                }
                if (charAt == c) {
                    this.bp = i;
                    this.ch = charAt(i);
                    this.matchStat = 3;
                    this.token = 16;
                    return parseDouble;
                }
                this.matchStat = -1;
                return parseDouble;
            }
        }
        if (charAt3 == 'n') {
            int i10 = i5 + 1;
            if (charAt(i5) == 'u') {
                int i11 = i5 + 2;
                if (charAt(i10) == 'l') {
                    int i12 = i5 + 3;
                    if (charAt(i11) == 'l') {
                        this.matchStat = 5;
                        int i13 = i5 + 4;
                        char charAt8 = charAt(i12);
                        if (z && charAt8 == '\"') {
                            charAt8 = charAt(i13);
                            i13 = i5 + 5;
                        }
                        while (charAt8 != ',') {
                            if (charAt8 == ']') {
                                this.bp = i13;
                                this.ch = charAt(i13);
                                this.matchStat = 5;
                                this.token = 15;
                                return OOXIXo.f3760XO;
                            }
                            if (JSONLexerBase.isWhitespace(charAt8)) {
                                char charAt9 = charAt(i13);
                                i13++;
                                charAt8 = charAt9;
                            } else {
                                this.matchStat = -1;
                                return OOXIXo.f3760XO;
                            }
                        }
                        this.bp = i13;
                        this.ch = charAt(i13);
                        this.matchStat = 5;
                        this.token = 16;
                        return OOXIXo.f3760XO;
                    }
                }
            }
        }
        this.matchStat = -1;
        return OOXIXo.f3760XO;
    }

    /* JADX WARN: Code restructure failed: missing block: B:61:0x0151, code lost:
    
        return r2;
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00f3 A[SYNTHETIC] */
    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean scanFieldBoolean(char[] r12) {
        /*
            Method dump skipped, instructions count: 385
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONScanner.scanFieldBoolean(char[]):boolean");
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public Date scanFieldDate(char[] cArr) {
        long j;
        Date date;
        char c;
        char charAt;
        boolean z = false;
        this.matchStat = 0;
        int i = this.bp;
        char c2 = this.ch;
        if (!charArrayCompare(this.text, i, cArr)) {
            this.matchStat = -2;
            return null;
        }
        int length = this.bp + cArr.length;
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
                            int i3 = indexOf + 1;
                            char charAt3 = charAt(indexOf + 2);
                            indexOf = i3;
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
            if (charAt2 != '-' && (charAt2 < '0' || charAt2 > '9')) {
                this.matchStat = -1;
                return null;
            }
            if (charAt2 == '-') {
                charAt2 = charAt(i2);
                i2 = length + 2;
                z = true;
            }
            if (charAt2 >= '0' && charAt2 <= '9') {
                long j2 = charAt2 - '0';
                while (true) {
                    int i4 = i2 + 1;
                    charAt = charAt(i2);
                    if (charAt < c4 || charAt > c3) {
                        break;
                    }
                    j2 = (j2 * 10) + (charAt - '0');
                    i2 = i4;
                    c3 = '9';
                    c4 = '0';
                }
                if (charAt == ',' || charAt == '}') {
                    this.bp = i2;
                }
                long j3 = j2;
                charAt2 = charAt;
                j = j3;
            } else {
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
            c = charAt2;
        }
        if (c == ',') {
            int i5 = this.bp + 1;
            this.bp = i5;
            this.ch = charAt(i5);
            this.matchStat = 3;
            this.token = 16;
            return date;
        }
        int i6 = this.bp + 1;
        this.bp = i6;
        char charAt4 = charAt(i6);
        if (charAt4 == ',') {
            this.token = 16;
            int i7 = this.bp + 1;
            this.bp = i7;
            this.ch = charAt(i7);
        } else if (charAt4 == ']') {
            this.token = 15;
            int i8 = this.bp + 1;
            this.bp = i8;
            this.ch = charAt(i8);
        } else if (charAt4 == '}') {
            this.token = 13;
            int i9 = this.bp + 1;
            this.bp = i9;
            this.ch = charAt(i9);
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

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0063, code lost:
    
        if (r12 != '.') goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0065, code lost:
    
        r14.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0067, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0068, code lost:
    
        if (r4 >= 0) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x006a, code lost:
    
        r14.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x006c, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x006d, code lost:
    
        if (r7 == false) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x006f, code lost:
    
        if (r12 == '\"') goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0071, code lost:
    
        r14.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0073, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0074, code lost:
    
        r15 = r15 + 2;
        r12 = charAt(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x007a, code lost:
    
        r11 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x007f, code lost:
    
        if (r12 == ',') goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0081, code lost:
    
        if (r12 != '}') goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0088, code lost:
    
        if (com.alibaba.fastjson.parser.JSONLexerBase.isWhitespace(r12) == false) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x008a, code lost:
    
        r15 = r11 + 1;
        r12 = charAt(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x007a, code lost:
    
        r11 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0091, code lost:
    
        r14.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0093, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0094, code lost:
    
        r14.bp = r11 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x009a, code lost:
    
        if (r12 != ',') goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x009c, code lost:
    
        r14.bp = r11;
        r14.ch = charAt(r11);
        r14.matchStat = 3;
        r14.token = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00a9, code lost:
    
        if (r3 == false) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00ac, code lost:
    
        return -r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:?, code lost:
    
        return r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00ad, code lost:
    
        if (r12 != '}') goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00af, code lost:
    
        r14.bp = r11;
        r8 = charAt(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00b5, code lost:
    
        if (r8 != ',') goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00c7, code lost:
    
        if (r8 != ']') goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00d9, code lost:
    
        if (r8 != '}') goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00ed, code lost:
    
        if (r8 != 26) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00fb, code lost:
    
        if (com.alibaba.fastjson.parser.JSONLexerBase.isWhitespace(r8) == false) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00fd, code lost:
    
        r8 = r14.bp + 1;
        r14.bp = r8;
        r8 = charAt(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0107, code lost:
    
        r14.bp = r1;
        r14.ch = r2;
        r14.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x010d, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x00ef, code lost:
    
        r14.token = 20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x00f3, code lost:
    
        r14.matchStat = 4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x00db, code lost:
    
        r14.token = 13;
        r15 = r14.bp + 1;
        r14.bp = r15;
        r14.ch = charAt(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x00c9, code lost:
    
        r14.token = 15;
        r15 = r14.bp + 1;
        r14.bp = r15;
        r14.ch = charAt(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x00b7, code lost:
    
        r14.token = 16;
        r15 = r14.bp + 1;
        r14.bp = r15;
        r14.ch = charAt(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x010e, code lost:
    
        if (r3 == false) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0111, code lost:
    
        return -r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:?, code lost:
    
        return r4;
     */
    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int scanFieldInt(char[] r15) {
        /*
            Method dump skipped, instructions count: 277
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONScanner.scanFieldInt(char[]):int");
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public long scanFieldLong(char[] cArr) {
        boolean z;
        int i;
        char charAt;
        boolean z2 = false;
        this.matchStat = 0;
        int i2 = this.bp;
        char c = this.ch;
        if (!charArrayCompare(this.text, i2, cArr)) {
            this.matchStat = -2;
            return 0L;
        }
        int length = this.bp + cArr.length;
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
        if (charAt2 >= '0' && charAt2 <= '9') {
            long j = charAt2 - '0';
            while (true) {
                i = i3 + 1;
                charAt = charAt(i3);
                if (charAt < '0' || charAt > '9') {
                    break;
                }
                j = (j * 10) + (charAt - '0');
                i3 = i;
            }
            if (charAt == '.') {
                this.matchStat = -1;
                return 0L;
            }
            if (z) {
                if (charAt != '\"') {
                    this.matchStat = -1;
                    return 0L;
                }
                charAt = charAt(i);
                i = i3 + 2;
            }
            if (charAt == ',' || charAt == '}') {
                this.bp = i - 1;
            }
            if (j < 0 && (j != Long.MIN_VALUE || !z2)) {
                this.bp = i2;
                this.ch = c;
                this.matchStat = -1;
                return 0L;
            }
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
                        }
                        if (charAt3 == ']') {
                            this.token = 15;
                            int i7 = this.bp + i4;
                            this.bp = i7;
                            this.ch = charAt(i7);
                            break;
                        }
                        if (charAt3 == '}') {
                            this.token = 13;
                            int i8 = this.bp + i4;
                            this.bp = i8;
                            this.ch = charAt(i8);
                            break;
                        }
                        if (charAt3 == 26) {
                            this.token = 20;
                            break;
                        }
                        if (JSONLexerBase.isWhitespace(charAt3)) {
                            int i9 = this.bp + 1;
                            this.bp = i9;
                            charAt3 = charAt(i9);
                            i4 = 1;
                        } else {
                            this.bp = i2;
                            this.ch = c;
                            this.matchStat = -1;
                            return 0L;
                        }
                    }
                    this.matchStat = 4;
                    if (z2) {
                        return -j;
                    }
                    return j;
                }
                if (JSONLexerBase.isWhitespace(charAt)) {
                    this.bp = i;
                    charAt = charAt(i);
                    i++;
                } else {
                    this.matchStat = -1;
                    return 0L;
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
        return 0L;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
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
                int i4 = i2 + 1;
                char charAt2 = charAt(i2);
                i2 = i4;
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
                int length2 = indexOf - (((cArr.length + i7) + 1) + i3);
                subString = JSONLexerBase.readString(sub_chars(i7 + cArr.length + 1 + i3, length2), length2);
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
                int i8 = indexOf + 2;
                this.bp = i8;
                this.ch = charAt(i8);
                this.matchStat = 3;
                return subString;
            }
            int i9 = indexOf + 2;
            this.bp = i9;
            char charAt5 = charAt(i9);
            if (charAt5 == ',') {
                this.token = 16;
                int i10 = this.bp + 1;
                this.bp = i10;
                this.ch = charAt(i10);
            } else if (charAt5 == ']') {
                this.token = 15;
                int i11 = this.bp + 1;
                this.bp = i11;
                this.ch = charAt(i11);
            } else if (charAt5 == '}') {
                this.token = 13;
                int i12 = this.bp + 1;
                this.bp = i12;
                this.ch = charAt(i12);
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

    /* JADX WARN: Code restructure failed: missing block: B:89:0x00d9, code lost:
    
        if (r9 != ']') goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x00df, code lost:
    
        if (r3.size() != 0) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x00e1, code lost:
    
        r2 = charAt(r1);
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x00ed, code lost:
    
        r17.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x00ef, code lost:
    
        return null;
     */
    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.Collection<java.lang.String> scanFieldStringArray(char[] r18, java.lang.Class<?> r19) {
        /*
            Method dump skipped, instructions count: 411
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONScanner.scanFieldStringArray(char[], java.lang.Class):java.util.Collection");
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
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
                return 0L;
            }
        }
        int length = this.bp + cArr.length;
        int i = length + 1;
        char charAt = charAt(length);
        if (charAt != '\"') {
            while (JSONLexerBase.isWhitespace(charAt)) {
                charAt = charAt(i);
                i++;
            }
            if (charAt != '\"') {
                this.matchStat = -1;
                return 0L;
            }
        }
        long j = TypeUtils.fnv1a_64_magic_hashcode;
        while (true) {
            int i2 = i + 1;
            char charAt2 = charAt(i);
            if (charAt2 == '\"') {
                this.bp = i2;
                char charAt3 = charAt(i2);
                this.ch = charAt3;
                while (charAt3 != ',') {
                    if (charAt3 == '}') {
                        next();
                        skipWhitespace();
                        char current = getCurrent();
                        if (current == ',') {
                            this.token = 16;
                            int i3 = this.bp + 1;
                            this.bp = i3;
                            this.ch = charAt(i3);
                        } else if (current == ']') {
                            this.token = 15;
                            int i4 = this.bp + 1;
                            this.bp = i4;
                            this.ch = charAt(i4);
                        } else if (current == '}') {
                            this.token = 13;
                            int i5 = this.bp + 1;
                            this.bp = i5;
                            this.ch = charAt(i5);
                        } else if (current == 26) {
                            this.token = 20;
                        } else {
                            this.matchStat = -1;
                            return 0L;
                        }
                        this.matchStat = 4;
                        return j;
                    }
                    if (JSONLexerBase.isWhitespace(charAt3)) {
                        int i6 = this.bp + 1;
                        this.bp = i6;
                        charAt3 = charAt(i6);
                    } else {
                        this.matchStat = -1;
                        return 0L;
                    }
                }
                int i7 = this.bp + 1;
                this.bp = i7;
                this.ch = charAt(i7);
                this.matchStat = 3;
                return j;
            }
            if (i2 > this.len) {
                this.matchStat = -1;
                return 0L;
            }
            j = (j ^ charAt2) * TypeUtils.fnv1a_64_magic_prime;
            i = i2;
        }
    }

    public boolean scanISO8601DateIfMatch() {
        return scanISO8601DateIfMatch(true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x007e, code lost:
    
        if (r13 != '.') goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0080, code lost:
    
        r16.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0082, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0083, code lost:
    
        if (r7 == false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0085, code lost:
    
        if (r13 == '\"') goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0087, code lost:
    
        r16.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0089, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x008a, code lost:
    
        r13 = charAt(r12);
        r12 = r3 + 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0091, code lost:
    
        if (r4 >= 0) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0093, code lost:
    
        r16.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0095, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0098, code lost:
    
        if (r13 != r17) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00af, code lost:
    
        if (com.alibaba.fastjson.parser.JSONLexerBase.isWhitespace(r13) == false) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00b1, code lost:
    
        r13 = charAt(r12);
        r12 = r12 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00b9, code lost:
    
        r16.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00bb, code lost:
    
        if (r6 == false) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00be, code lost:
    
        return -r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:?, code lost:
    
        return r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x009a, code lost:
    
        r16.bp = r12;
        r16.ch = charAt(r12);
        r16.matchStat = 3;
        r16.token = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00a7, code lost:
    
        if (r6 == false) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00aa, code lost:
    
        return -r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:?, code lost:
    
        return r4;
     */
    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int scanInt(char r17) {
        /*
            Method dump skipped, instructions count: 299
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONScanner.scanInt(char):int");
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
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
        if (charAt2 >= '0' && charAt2 <= '9') {
            long j = charAt2 - '0';
            while (true) {
                i = i3 + 1;
                charAt = charAt(i3);
                if (charAt < '0' || charAt > '9') {
                    break;
                }
                j = (j * 10) + (charAt - '0');
                i3 = i;
            }
            if (charAt == '.') {
                this.matchStat = -1;
                return 0L;
            }
            if (z) {
                if (charAt != '\"') {
                    this.matchStat = -1;
                    return 0L;
                }
                charAt = charAt(i);
                i = i3 + 2;
            }
            if (j < 0 && (j != Long.MIN_VALUE || !z2)) {
                this.matchStat = -1;
                return 0L;
            }
            while (charAt != c) {
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
                                return 0L;
                            }
                            if (JSONLexerBase.isWhitespace(charAt3)) {
                                char charAt4 = charAt(i7);
                                i7++;
                                charAt3 = charAt4;
                            } else {
                                this.matchStat = -1;
                                return 0L;
                            }
                        }
                        this.bp = i7;
                        this.ch = charAt(i7);
                        this.matchStat = 5;
                        this.token = 16;
                        return 0L;
                    }
                }
            }
        }
        this.matchStat = -1;
        return 0L;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
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

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
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
                    if (c != '\"' && c != '\'') {
                        if (c == '{') {
                            next();
                            this.token = 12;
                            skipObject(false);
                        } else if (c == '[') {
                            next();
                            this.token = 14;
                            skipArray(false);
                        } else {
                            for (int i4 = this.bp + 1; i4 < this.text.length(); i4++) {
                                char charAt = this.text.charAt(i4);
                                if (charAt == ',') {
                                    int i5 = i4 + 1;
                                    this.bp = i5;
                                    this.ch = charAt(i5);
                                } else {
                                    if (charAt == ']') {
                                        int i6 = i4 + 1;
                                        this.bp = i6;
                                        this.ch = charAt(i6);
                                        nextToken();
                                        return false;
                                    }
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
                    } else {
                        skipString();
                        char c2 = this.ch;
                        if (c2 == ',') {
                            next();
                        } else {
                            if (c2 == ']') {
                                next();
                                nextToken(16);
                                return false;
                            }
                            throw new JSONException("illegal json.");
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

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public int seekObjectToField(long j, boolean z) {
        char c;
        int i = this.token;
        int i2 = -1;
        if (i == 20) {
            return -1;
        }
        if (i != 13) {
            int i3 = 15;
            if (i != 15) {
                int i4 = 16;
                if (i != 12 && i != 16) {
                    throw new UnsupportedOperationException(JSONToken.name(this.token));
                }
                while (true) {
                    char c2 = this.ch;
                    if (c2 == '}') {
                        next();
                        nextToken();
                        return i2;
                    }
                    if (c2 == 26) {
                        return i2;
                    }
                    if (c2 != '\"') {
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
                                this.ch = i6 >= this.text.length() ? JSONLexer.EOI : this.text.charAt(this.bp);
                            } else {
                                j2 = (j2 ^ charAt) * TypeUtils.fnv1a_64_magic_prime;
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
                            char charAt2 = i7 >= this.text.length() ? JSONLexer.EOI : this.text.charAt(i7);
                            this.ch = charAt2;
                            if (charAt2 == ',') {
                                int i8 = this.bp + 1;
                                this.bp = i8;
                                this.ch = i8 >= this.text.length() ? JSONLexer.EOI : this.text.charAt(i8);
                                this.token = i4;
                                return 3;
                            }
                            if (charAt2 == ']') {
                                int i9 = this.bp + 1;
                                this.bp = i9;
                                this.ch = i9 >= this.text.length() ? JSONLexer.EOI : this.text.charAt(i9);
                                this.token = i3;
                                return 3;
                            }
                            if (charAt2 == '}') {
                                int i10 = this.bp + 1;
                                this.bp = i10;
                                this.ch = i10 >= this.text.length() ? JSONLexer.EOI : this.text.charAt(i10);
                                this.token = 13;
                                return 3;
                            }
                            if (charAt2 >= '0' && charAt2 <= '9') {
                                this.sp = 0;
                                this.pos = this.bp;
                                scanNumber();
                                return 3;
                            }
                            nextToken(2);
                            return 3;
                        }
                        if (this.ch != ':') {
                            skipWhitespace();
                        }
                        if (this.ch == ':') {
                            int i11 = this.bp + 1;
                            this.bp = i11;
                            char charAt3 = i11 >= this.text.length() ? JSONLexer.EOI : this.text.charAt(i11);
                            this.ch = charAt3;
                            if (charAt3 != '\"' && charAt3 != '\'' && charAt3 != '{' && charAt3 != '[' && charAt3 != '0' && charAt3 != '1' && charAt3 != '2' && charAt3 != '3' && charAt3 != '4' && charAt3 != '5' && charAt3 != '6' && charAt3 != '7' && charAt3 != '8' && charAt3 != '9' && charAt3 != '+' && charAt3 != '-') {
                                skipWhitespace();
                            }
                            char c3 = this.ch;
                            if (c3 == '-' || c3 == '+' || (c3 >= '0' && c3 <= '9')) {
                                next();
                                while (true) {
                                    c = this.ch;
                                    if (c < '0' || c > '9') {
                                        break;
                                    }
                                    next();
                                }
                                if (c == '.') {
                                    next();
                                    while (true) {
                                        char c4 = this.ch;
                                        if (c4 < '0' || c4 > '9') {
                                            break;
                                        }
                                        next();
                                    }
                                }
                                char c5 = this.ch;
                                if (c5 == 'E' || c5 == 'e') {
                                    next();
                                    char c6 = this.ch;
                                    if (c6 == '-' || c6 == '+') {
                                        next();
                                    }
                                    while (true) {
                                        char c7 = this.ch;
                                        if (c7 < '0' || c7 > '9') {
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
                            } else if (c3 == '\"') {
                                skipString();
                                char c8 = this.ch;
                                if (c8 != ',' && c8 != '}') {
                                    skipWhitespace();
                                }
                                if (this.ch == ',') {
                                    next();
                                }
                            } else if (c3 == 't') {
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
                                char c9 = this.ch;
                                if (c9 != ',' && c9 != '}') {
                                    skipWhitespace();
                                }
                                if (this.ch == ',') {
                                    next();
                                }
                            } else if (c3 == 'n') {
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
                                char c10 = this.ch;
                                if (c10 != ',' && c10 != '}') {
                                    skipWhitespace();
                                }
                                if (this.ch == ',') {
                                    next();
                                }
                            } else if (c3 == 'f') {
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
                                char c11 = this.ch;
                                if (c11 != ',' && c11 != '}') {
                                    skipWhitespace();
                                }
                                if (this.ch == ',') {
                                    next();
                                }
                            } else if (c3 == '{') {
                                int i12 = this.bp + 1;
                                this.bp = i12;
                                this.ch = i12 >= this.text.length() ? JSONLexer.EOI : this.text.charAt(i12);
                                if (z) {
                                    this.token = 12;
                                    return 1;
                                }
                                skipObject(false);
                                if (this.token == 13) {
                                    return -1;
                                }
                            } else if (c3 == '[') {
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
                    } else {
                        throw new UnsupportedOperationException();
                    }
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

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final void skipArray() {
        skipArray(false);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
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

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final String stringVal() {
        if (!this.hasSpecial) {
            return subString(this.np + 1, this.sp);
        }
        return new String(this.sbuf, 0, this.sp);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final String subString(int i, int i2) {
        if (ASMUtils.IS_ANDROID) {
            char[] cArr = this.sbuf;
            if (i2 < cArr.length) {
                this.text.getChars(i, i + i2, cArr, 0);
                return new String(this.sbuf, 0, i2);
            }
            char[] cArr2 = new char[i2];
            this.text.getChars(i, i2 + i, cArr2, 0);
            return new String(cArr2);
        }
        return this.text.substring(i, i2 + i);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
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
                if (i >= this.len - 1) {
                    this.ch = charAt;
                    this.bp = i;
                    throw new JSONException("illegal str, " + info());
                }
                i++;
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
                    } else {
                        this.ch = this.text.charAt(this.bp);
                        nextToken(16);
                        return;
                    }
                }
            } else if (!z2) {
                i2++;
            }
            i++;
        }
        if (i != this.text.length()) {
            return;
        }
        throw new JSONException("illegal str, " + info());
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final void skipObject(boolean z) {
        int i = this.bp;
        boolean z2 = false;
        int i2 = 0;
        while (i < this.text.length()) {
            char charAt = this.text.charAt(i);
            if (charAt == '\\') {
                if (i >= this.len - 1) {
                    this.ch = charAt;
                    this.bp = i;
                    throw new JSONException("illegal str, " + info());
                }
                i++;
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
                }
                if (charAt2 == '}') {
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
        if (i != this.text.length()) {
            return;
        }
        throw new JSONException("illegal str, " + info());
    }

    /* JADX WARN: Removed duplicated region for block: B:69:0x0216 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0218  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean scanISO8601DateIfMatch(boolean r35, int r36) {
        /*
            Method dump skipped, instructions count: 1809
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONScanner.scanISO8601DateIfMatch(boolean, int):boolean");
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final boolean charArrayCompare(char[] cArr) {
        return charArrayCompare(this.text, this.bp, cArr);
    }

    public JSONScanner(char[] cArr, int i) {
        this(cArr, i, JSON.DEFAULT_PARSER_FEATURE);
    }

    public JSONScanner(char[] cArr, int i, int i2) {
        this(new String(cArr, 0, i), i2);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public String[] scanFieldStringArray(char[] cArr, int i, SymbolTable symbolTable) {
        int i2;
        char c;
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
                } else {
                    if (this.ch != '\"') {
                        this.bp = i3;
                        this.ch = c2;
                        this.matchStat = -1;
                        return null;
                    }
                    String scanSymbol = scanSymbol(symbolTable, '\"');
                    if (i5 == strArr.length) {
                        String[] strArr2 = new String[strArr.length + (strArr.length >> 1) + 1];
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
        } else {
            if (c == 'n' && this.text.startsWith("ull", this.bp + 1)) {
                int i7 = this.bp + 4;
                this.bp = i7;
                this.ch = this.text.charAt(i7);
                return null;
            }
            this.matchStat = -1;
            return null;
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public int seekObjectToField(long[] jArr) {
        char c;
        int i = this.token;
        if (i != 12 && i != 16) {
            throw new UnsupportedOperationException();
        }
        while (true) {
            char c2 = this.ch;
            if (c2 == '}') {
                next();
                nextToken();
                this.matchStat = -1;
                return -1;
            }
            char c3 = JSONLexer.EOI;
            if (c2 == 26) {
                this.matchStat = -1;
                return -1;
            }
            if (c2 != '\"') {
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
                        this.ch = i3 >= this.text.length() ? JSONLexer.EOI : this.text.charAt(this.bp);
                    } else {
                        j = (j ^ charAt) * TypeUtils.fnv1a_64_magic_prime;
                        i2++;
                    }
                }
                int i4 = 0;
                while (true) {
                    if (i4 >= jArr.length) {
                        i4 = -1;
                        break;
                    }
                    if (j == jArr[i4]) {
                        break;
                    }
                    i4++;
                }
                if (i4 != -1) {
                    if (this.ch != ':') {
                        skipWhitespace();
                    }
                    if (this.ch == ':') {
                        int i5 = this.bp + 1;
                        this.bp = i5;
                        char charAt2 = i5 >= this.text.length() ? JSONLexer.EOI : this.text.charAt(i5);
                        this.ch = charAt2;
                        if (charAt2 == ',') {
                            int i6 = this.bp + 1;
                            this.bp = i6;
                            if (i6 < this.text.length()) {
                                c3 = this.text.charAt(i6);
                            }
                            this.ch = c3;
                            this.token = 16;
                        } else if (charAt2 == ']') {
                            int i7 = this.bp + 1;
                            this.bp = i7;
                            if (i7 < this.text.length()) {
                                c3 = this.text.charAt(i7);
                            }
                            this.ch = c3;
                            this.token = 15;
                        } else if (charAt2 == '}') {
                            int i8 = this.bp + 1;
                            this.bp = i8;
                            if (i8 < this.text.length()) {
                                c3 = this.text.charAt(i8);
                            }
                            this.ch = c3;
                            this.token = 13;
                        } else if (charAt2 >= '0' && charAt2 <= '9') {
                            this.sp = 0;
                            this.pos = this.bp;
                            scanNumber();
                        } else {
                            nextToken(2);
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
                    char charAt3 = i9 >= this.text.length() ? JSONLexer.EOI : this.text.charAt(i9);
                    this.ch = charAt3;
                    if (charAt3 != '\"' && charAt3 != '\'' && charAt3 != '{' && charAt3 != '[' && charAt3 != '0' && charAt3 != '1' && charAt3 != '2' && charAt3 != '3' && charAt3 != '4' && charAt3 != '5' && charAt3 != '6' && charAt3 != '7' && charAt3 != '8' && charAt3 != '9' && charAt3 != '+' && charAt3 != '-') {
                        skipWhitespace();
                    }
                    char c4 = this.ch;
                    if (c4 == '-' || c4 == '+' || (c4 >= '0' && c4 <= '9')) {
                        next();
                        while (true) {
                            c = this.ch;
                            if (c < '0' || c > '9') {
                                break;
                            }
                            next();
                        }
                        if (c == '.') {
                            next();
                            while (true) {
                                char c5 = this.ch;
                                if (c5 < '0' || c5 > '9') {
                                    break;
                                }
                                next();
                            }
                        }
                        char c6 = this.ch;
                        if (c6 == 'E' || c6 == 'e') {
                            next();
                            char c7 = this.ch;
                            if (c7 == '-' || c7 == '+') {
                                next();
                            }
                            while (true) {
                                char c8 = this.ch;
                                if (c8 < '0' || c8 > '9') {
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
                    } else if (c4 == '\"') {
                        skipString();
                        char c9 = this.ch;
                        if (c9 != ',' && c9 != '}') {
                            skipWhitespace();
                        }
                        if (this.ch == ',') {
                            next();
                        }
                    } else if (c4 == '{') {
                        int i10 = this.bp + 1;
                        this.bp = i10;
                        if (i10 < this.text.length()) {
                            c3 = this.text.charAt(i10);
                        }
                        this.ch = c3;
                        skipObject(false);
                    } else if (c4 == '[') {
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
    }
}
