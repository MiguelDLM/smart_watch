package com.sma.smartv3.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;

/* loaded from: classes12.dex */
public final class BGEMResponse<T> {

    @oOoXoXO
    private final T data;

    @oOoXoXO
    private BGEMStatus status;

    @oOoXoXO
    public final T getData() {
        return this.data;
    }

    @oOoXoXO
    public final BGEMStatus getStatus() {
        return this.status;
    }

    public final void setStatus(@oOoXoXO BGEMStatus bGEMStatus) {
        this.status = bGEMStatus;
    }

    @OOXIXo
    public String toString() {
        return "BGEMResponse(status=" + this.status + ", data=" + this.data + HexStringBuilder.COMMENT_END_CHAR;
    }
}
