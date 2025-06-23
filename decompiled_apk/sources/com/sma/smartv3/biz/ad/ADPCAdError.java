package com.sma.smartv3.biz.ad;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.adp.sdk.dto.AdpError;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class ADPCAdError {

    @oOoXoXO
    private String code;

    @oOoXoXO
    private String msg;

    public ADPCAdError(@OOXIXo AdpError error) {
        IIX0o.x0xO0oo(error, "error");
        this.code = error.getCode();
        this.msg = error.getMessage();
    }

    @oOoXoXO
    public final String getCode() {
        return this.code;
    }

    @oOoXoXO
    public final String getMsg() {
        return this.msg;
    }

    public final void setCode(@oOoXoXO String str) {
        this.code = str;
    }

    public final void setMsg(@oOoXoXO String str) {
        this.msg = str;
    }

    public ADPCAdError(@OOXIXo String code, @OOXIXo String msg) {
        IIX0o.x0xO0oo(code, "code");
        IIX0o.x0xO0oo(msg, "msg");
        this.code = code;
        this.msg = msg;
    }
}
