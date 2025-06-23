package com.github.doyaaaaaken.kotlincsv.util;

import OXOo.OOXIXo;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes9.dex */
public final class CSVParseFormatException extends MalformedCSVException {

    /* renamed from: char, reason: not valid java name */
    private final char f4char;
    private final long colIndex;
    private final long rowNum;

    public /* synthetic */ CSVParseFormatException(long j, long j2, char c, String str, int i, IIXOooo iIXOooo) {
        this(j, j2, c, (i & 8) != 0 ? "Exception happened on parsing csv" : str);
    }

    public final char getChar() {
        return this.f4char;
    }

    public final long getColIndex() {
        return this.colIndex;
    }

    public final long getRowNum() {
        return this.rowNum;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CSVParseFormatException(long j, long j2, char c, @OOXIXo String message) {
        super(message + " [rowNum = " + j + ", colIndex = " + j2 + ", char = " + c + ']');
        IIX0o.x0xO0oo(message, "message");
        this.rowNum = j;
        this.colIndex = j2;
        this.f4char = c;
    }
}
