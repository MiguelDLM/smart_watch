package com.sma.smartv3.model;

import OXOo.OOXIXo;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class BDUpLoadLocationResponse {
    private int status;
    private int success_num;

    @OOXIXo
    private String message = "";

    @OOXIXo
    private Object fail_info = new Object() { // from class: com.sma.smartv3.model.BDUpLoadLocationResponse$fail_info$1
    };

    @OOXIXo
    public final Object getFail_info() {
        return this.fail_info;
    }

    @OOXIXo
    public final String getMessage() {
        return this.message;
    }

    public final int getStatus() {
        return this.status;
    }

    public final int getSuccess_num() {
        return this.success_num;
    }

    public final void setFail_info(@OOXIXo Object obj) {
        IIX0o.x0xO0oo(obj, "<set-?>");
        this.fail_info = obj;
    }

    public final void setMessage(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.message = str;
    }

    public final void setStatus(int i) {
        this.status = i;
    }

    public final void setSuccess_num(int i) {
        this.success_num = i;
    }

    @OOXIXo
    public String toString() {
        return "BDUpLoadLocationResponse(status=" + this.status + ", message='" + this.message + "', success_num=" + this.success_num + ", fail_info=" + this.fail_info + HexStringBuilder.COMMENT_END_CHAR;
    }
}
