package com.sma.androidnetworklib.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;

/* loaded from: classes11.dex */
public final class Response<T> {
    private int code;

    @oOoXoXO
    private final T data;

    @OOXIXo
    private final String mesg = "";

    @OOXIXo
    private final String requestID = "";

    public final int getCode() {
        return this.code;
    }

    @oOoXoXO
    public final T getData() {
        return this.data;
    }

    @OOXIXo
    public final String getMesg() {
        return this.mesg;
    }

    @OOXIXo
    public final String getRequestID() {
        return this.requestID;
    }

    public final void setCode(int i) {
        this.code = i;
    }

    @OOXIXo
    public String toString() {
        return "Response(code=" + this.code + ", requestID='" + this.requestID + "', mesg='" + this.mesg + "', data=" + this.data + HexStringBuilder.COMMENT_END_CHAR;
    }
}
