package com.jieli.jl_rcsp.exception;

import com.jieli.jl_rcsp.util.CHexConver;

/* loaded from: classes.dex */
public class ParseDataException extends BaseException {
    public static final int REASON_INSUFFICIENT_DATA = 1;
    public static final int REASON_TYPE_NOT_MATCH = 2;
    private byte[] data;
    private final int reason;

    public ParseDataException(int i, String str) {
        this(i, str, new byte[0]);
    }

    public byte[] getData() {
        return this.data;
    }

    @Override // com.jieli.jl_rcsp.exception.BaseException
    public int getErrorCode() {
        return 12289;
    }

    public int getReason() {
        return this.reason;
    }

    public ParseDataException setData(byte[] bArr) {
        this.data = bArr;
        return this;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "ParseException{data=" + CHexConver.byte2HexStr(this.data) + ", reason=" + this.reason + ", message=\"" + getMessage() + "\"}";
    }

    public ParseDataException(int i, String str, byte[] bArr) {
        super(str);
        this.reason = i;
        this.data = bArr;
    }
}
