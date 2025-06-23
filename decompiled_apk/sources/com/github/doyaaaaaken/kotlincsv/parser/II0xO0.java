package com.github.doyaaaaaken.kotlincsv.parser;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.github.doyaaaaaken.kotlincsv.util.CSVParseFormatException;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.text.OxxIIOOXO;

/* loaded from: classes9.dex */
public final class II0xO0 {

    /* renamed from: I0Io, reason: collision with root package name */
    public final char f15787I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public final char f15788II0xO0;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public long f15789Oxx0IOOO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final char f15792oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    @OOXIXo
    public ParseState f15793oxoX = ParseState.START;

    /* renamed from: X0o0xo, reason: collision with root package name */
    @OOXIXo
    public final ArrayList<String> f15790X0o0xo = new ArrayList<>();

    /* renamed from: XO, reason: collision with root package name */
    @OOXIXo
    public StringBuilder f15791XO = new StringBuilder();

    /* loaded from: classes9.dex */
    public /* synthetic */ class oIX0oI {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public static final /* synthetic */ int[] f15794oIX0oI;

        static {
            int[] iArr = new int[ParseState.values().length];
            iArr[ParseState.START.ordinal()] = 1;
            iArr[ParseState.FIELD.ordinal()] = 2;
            iArr[ParseState.DELIMITER.ordinal()] = 3;
            iArr[ParseState.QUOTE_START.ordinal()] = 4;
            iArr[ParseState.QUOTED_FIELD.ordinal()] = 5;
            iArr[ParseState.QUOTE_END.ordinal()] = 6;
            iArr[ParseState.END.ordinal()] = 7;
            f15794oIX0oI = iArr;
        }
    }

    public II0xO0(char c, char c2, char c3) {
        this.f15792oIX0oI = c;
        this.f15788II0xO0 = c2;
        this.f15787I0Io = c3;
    }

    public final long I0Io(char c, @oOoXoXO Character ch, long j) {
        long j2 = this.f15789Oxx0IOOO;
        switch (oIX0oI.f15794oIX0oI[this.f15793oxoX.ordinal()]) {
            case 1:
                if (c != 65279) {
                    if (c == this.f15792oIX0oI) {
                        this.f15793oxoX = ParseState.QUOTE_START;
                    } else if (c == this.f15788II0xO0) {
                        oIX0oI();
                        this.f15793oxoX = ParseState.DELIMITER;
                    } else if (c == '\n' || c == 8232 || c == 8233 || c == 133) {
                        oIX0oI();
                        this.f15793oxoX = ParseState.END;
                    } else if (c == '\r') {
                        if (ch != null && ch.charValue() == '\n') {
                            this.f15789Oxx0IOOO++;
                        }
                        oIX0oI();
                        this.f15793oxoX = ParseState.END;
                    } else {
                        this.f15791XO.append(c);
                        this.f15793oxoX = ParseState.FIELD;
                    }
                }
                this.f15789Oxx0IOOO++;
                break;
            case 2:
                char c2 = this.f15787I0Io;
                if (c == c2) {
                    if (ch != null && ch.charValue() == c2) {
                        this.f15791XO.append(ch.charValue());
                        this.f15793oxoX = ParseState.FIELD;
                        this.f15789Oxx0IOOO++;
                    } else {
                        throw new CSVParseFormatException(j, this.f15789Oxx0IOOO, c, "must appear escapeChar(" + this.f15787I0Io + ") after escapeChar(" + this.f15787I0Io + HexStringBuilder.COMMENT_END_CHAR);
                    }
                } else if (c == this.f15788II0xO0) {
                    oIX0oI();
                    this.f15793oxoX = ParseState.DELIMITER;
                } else if (c == '\n' || c == 8232 || c == 8233 || c == 133) {
                    oIX0oI();
                    this.f15793oxoX = ParseState.END;
                } else if (c == '\r') {
                    if (ch != null && ch.charValue() == '\n') {
                        this.f15789Oxx0IOOO++;
                    }
                    oIX0oI();
                    this.f15793oxoX = ParseState.END;
                } else {
                    this.f15791XO.append(c);
                    this.f15793oxoX = ParseState.FIELD;
                }
                this.f15789Oxx0IOOO++;
                break;
            case 3:
                if (c == this.f15792oIX0oI) {
                    this.f15793oxoX = ParseState.QUOTE_START;
                } else if (c == this.f15788II0xO0) {
                    oIX0oI();
                    this.f15793oxoX = ParseState.DELIMITER;
                } else if (c == '\n' || c == 8232 || c == 8233 || c == 133) {
                    oIX0oI();
                    this.f15793oxoX = ParseState.END;
                } else if (c == '\r') {
                    if (ch != null && ch.charValue() == '\n') {
                        this.f15789Oxx0IOOO++;
                    }
                    oIX0oI();
                    this.f15793oxoX = ParseState.END;
                } else {
                    this.f15791XO.append(c);
                    this.f15793oxoX = ParseState.FIELD;
                }
                this.f15789Oxx0IOOO++;
                break;
            case 4:
            case 5:
                char c3 = this.f15787I0Io;
                if (c == c3 && c3 != this.f15792oIX0oI) {
                    if (ch != null) {
                        if (ch.charValue() != c3) {
                            if (ch.charValue() != this.f15792oIX0oI) {
                                throw new CSVParseFormatException(j, this.f15789Oxx0IOOO, c, "escape character must appear consecutively twice");
                            }
                        }
                        this.f15791XO.append(ch.charValue());
                        this.f15793oxoX = ParseState.QUOTED_FIELD;
                        this.f15789Oxx0IOOO++;
                    } else {
                        throw new CSVParseFormatException(j, this.f15789Oxx0IOOO, c, "end of quote doesn't exist");
                    }
                } else {
                    char c4 = this.f15792oIX0oI;
                    if (c == c4) {
                        if (ch != null && ch.charValue() == c4) {
                            this.f15791XO.append(this.f15792oIX0oI);
                            this.f15793oxoX = ParseState.QUOTED_FIELD;
                            this.f15789Oxx0IOOO++;
                        } else {
                            this.f15793oxoX = ParseState.QUOTE_END;
                        }
                    } else {
                        this.f15791XO.append(c);
                        this.f15793oxoX = ParseState.QUOTED_FIELD;
                    }
                }
                this.f15789Oxx0IOOO++;
                break;
            case 6:
                if (c == this.f15788II0xO0) {
                    oIX0oI();
                    this.f15793oxoX = ParseState.DELIMITER;
                } else if (c == '\n' || c == 8232 || c == 8233 || c == 133) {
                    oIX0oI();
                    this.f15793oxoX = ParseState.END;
                } else if (c == '\r') {
                    if (ch != null && ch.charValue() == '\n') {
                        this.f15789Oxx0IOOO++;
                    }
                    oIX0oI();
                    this.f15793oxoX = ParseState.END;
                } else {
                    throw new CSVParseFormatException(j, this.f15789Oxx0IOOO, c, "must appear delimiter or line terminator after quote end");
                }
                this.f15789Oxx0IOOO++;
                break;
            case 7:
                throw new CSVParseFormatException(j, this.f15789Oxx0IOOO, c, "unexpected error");
        }
        return this.f15789Oxx0IOOO - j2;
    }

    @oOoXoXO
    public final List<String> II0xO0() {
        int i = oIX0oI.f15794oIX0oI[this.f15793oxoX.ordinal()];
        if (i != 2) {
            if (i != 3) {
                if (i != 5) {
                    if (i != 6) {
                        return CollectionsKt___CollectionsKt.oOo0o(this.f15790X0o0xo);
                    }
                } else {
                    return null;
                }
            } else {
                this.f15790X0o0xo.add("");
                return CollectionsKt___CollectionsKt.oOo0o(this.f15790X0o0xo);
            }
        }
        this.f15790X0o0xo.add(this.f15791XO.toString());
        return CollectionsKt___CollectionsKt.oOo0o(this.f15790X0o0xo);
    }

    public final void oIX0oI() {
        this.f15790X0o0xo.add(this.f15791XO.toString());
        OxxIIOOXO.oxxXoxO(this.f15791XO);
    }
}
