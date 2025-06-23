package com.univocity.parsers.common;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;

/* loaded from: classes13.dex */
public class TextParsingException extends AbstractException {
    private static final long serialVersionUID = 1410975527141918214L;
    private long charIndex;
    private int columnIndex;
    private String content;
    protected int[] extractedIndexes;
    private String[] headers;
    private long lineIndex;
    private long recordNumber;

    public TextParsingException(oO oOVar, String str, Throwable th) {
        super(str, th);
        setContext(oOVar);
    }

    public long getCharIndex() {
        return this.charIndex;
    }

    public int getColumnIndex() {
        return this.columnIndex;
    }

    @Override // com.univocity.parsers.common.AbstractException
    public String getDetails() {
        return AbstractException.printIfNotEmpty(AbstractException.printIfNotEmpty(AbstractException.printIfNotEmpty(AbstractException.printIfNotEmpty(AbstractException.printIfNotEmpty(AbstractException.printIfNotEmpty("", "line", Long.valueOf(this.lineIndex)), XXooOOI.oIX0oI.f4124x0xO0oo, Integer.valueOf(this.columnIndex)), "record", Long.valueOf(this.recordNumber)), "charIndex", Long.valueOf(this.charIndex)), TTDownloadField.TT_HEADERS, this.headers), "content parsed", this.content);
    }

    @Override // com.univocity.parsers.common.AbstractException
    public String getErrorDescription() {
        return "Error parsing input";
    }

    public final String[] getHeaders() {
        return this.headers;
    }

    public long getLineIndex() {
        return this.lineIndex;
    }

    public final String getParsedContent() {
        return this.content;
    }

    public long getRecordNumber() {
        return this.lineIndex;
    }

    public void setContext(oO oOVar) {
        long II0XooXoX2;
        long Oxx0IOOO2;
        int XO2;
        String oO2;
        String[] X0o0xo2;
        long j = -1;
        if (oOVar == null) {
            II0XooXoX2 = -1;
        } else {
            II0XooXoX2 = oOVar.II0XooXoX();
        }
        this.lineIndex = II0XooXoX2;
        if (oOVar == null) {
            Oxx0IOOO2 = 0;
        } else {
            Oxx0IOOO2 = oOVar.Oxx0IOOO();
        }
        this.charIndex = Oxx0IOOO2;
        if (oOVar == null) {
            XO2 = -1;
        } else {
            XO2 = oOVar.XO();
        }
        this.columnIndex = XO2;
        if (oOVar != null) {
            j = oOVar.xoIox();
        }
        this.recordNumber = j;
        int[] iArr = null;
        if (oOVar == null) {
            oO2 = null;
        } else {
            oO2 = oOVar.oO();
        }
        this.content = oO2;
        if (this.headers == null) {
            if (oOVar == null) {
                X0o0xo2 = null;
            } else {
                X0o0xo2 = oOVar.X0o0xo();
            }
            this.headers = X0o0xo2;
        }
        if (oOVar != null) {
            iArr = oOVar.x0XOIxOo();
        }
        this.extractedIndexes = iArr;
    }

    public TextParsingException(oO oOVar, String str) {
        this(oOVar, str, null);
    }

    public TextParsingException(oO oOVar, Throwable th) {
        this(oOVar, th != null ? th.getMessage() : null, th);
    }

    public TextParsingException(oO oOVar) {
        this(oOVar, null, null);
    }
}
