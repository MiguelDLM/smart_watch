package com.univocity.parsers.common;

/* loaded from: classes13.dex */
public class TextWritingException extends AbstractException {
    private static final long serialVersionUID = 7198462597717255519L;
    private final String recordCharacters;
    private final long recordCount;
    private final Object[] recordData;

    private TextWritingException(String str, long j, Object[] objArr, String str2, Throwable th) {
        super(str, th);
        this.recordCount = j;
        this.recordData = objArr;
        this.recordCharacters = str2;
    }

    @Override // com.univocity.parsers.common.AbstractException
    public String getDetails() {
        return AbstractException.printIfNotEmpty(AbstractException.printIfNotEmpty(AbstractException.printIfNotEmpty("", "recordCount", Long.valueOf(this.recordCount)), "recordData", this.recordData), "recordCharacters", this.recordCharacters);
    }

    @Override // com.univocity.parsers.common.AbstractException
    public String getErrorDescription() {
        return "Error writing data";
    }

    public String getRecordCharacters() {
        return this.recordCharacters;
    }

    public long getRecordCount() {
        return this.recordCount;
    }

    public Object[] getRecordData() {
        return this.recordData;
    }

    public TextWritingException(String str, long j, String str2, Throwable th) {
        this(str, j, null, str2, th);
    }

    public TextWritingException(String str, long j, Object[] objArr, Throwable th) {
        this(str, j, objArr, null, th);
    }

    public TextWritingException(String str) {
        this(str, 0L, null, null, null);
    }

    public TextWritingException(Throwable th) {
        this(th != null ? th.getMessage() : null, 0L, null, null, th);
    }

    public TextWritingException(String str, long j, Object[] objArr) {
        this(str, j, objArr, (Throwable) null);
    }

    public TextWritingException(String str, long j, String str2) {
        this(str, j, null, str2, null);
    }
}
