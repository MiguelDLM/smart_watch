package com.sma.smartv3.biz.ai;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.sma.smartv3.model.JsonFieldContainer;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class AIError extends JsonFieldContainer {

    @OOXIXo
    private String code;

    @OOXIXo
    private String message;

    @OOXIXo
    private String param;

    @OOXIXo
    private String type;

    public AIError() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ AIError copy$default(AIError aIError, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = aIError.message;
        }
        if ((i & 2) != 0) {
            str2 = aIError.type;
        }
        if ((i & 4) != 0) {
            str3 = aIError.param;
        }
        if ((i & 8) != 0) {
            str4 = aIError.code;
        }
        return aIError.copy(str, str2, str3, str4);
    }

    @OOXIXo
    public final String component1() {
        return this.message;
    }

    @OOXIXo
    public final String component2() {
        return this.type;
    }

    @OOXIXo
    public final String component3() {
        return this.param;
    }

    @OOXIXo
    public final String component4() {
        return this.code;
    }

    @OOXIXo
    public final AIError copy(@OOXIXo String message, @OOXIXo String type, @OOXIXo String param, @OOXIXo String code) {
        IIX0o.x0xO0oo(message, "message");
        IIX0o.x0xO0oo(type, "type");
        IIX0o.x0xO0oo(param, "param");
        IIX0o.x0xO0oo(code, "code");
        return new AIError(message, type, param, code);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AIError)) {
            return false;
        }
        AIError aIError = (AIError) obj;
        return IIX0o.Oxx0IOOO(this.message, aIError.message) && IIX0o.Oxx0IOOO(this.type, aIError.type) && IIX0o.Oxx0IOOO(this.param, aIError.param) && IIX0o.Oxx0IOOO(this.code, aIError.code);
    }

    @OOXIXo
    public final String getCode() {
        return this.code;
    }

    @OOXIXo
    public final String getMessage() {
        return this.message;
    }

    @OOXIXo
    public final String getParam() {
        return this.param;
    }

    @OOXIXo
    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        return (((((this.message.hashCode() * 31) + this.type.hashCode()) * 31) + this.param.hashCode()) * 31) + this.code.hashCode();
    }

    public final void setCode(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.code = str;
    }

    public final void setMessage(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.message = str;
    }

    public final void setParam(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.param = str;
    }

    public final void setType(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.type = str;
    }

    @OOXIXo
    public String toString() {
        return "AIError(message=" + this.message + ", type=" + this.type + ", param=" + this.param + ", code=" + this.code + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ AIError(String str, String str2, String str3, String str4, int i, IIXOooo iIXOooo) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4);
    }

    public AIError(@OOXIXo String message, @OOXIXo String type, @OOXIXo String param, @OOXIXo String code) {
        IIX0o.x0xO0oo(message, "message");
        IIX0o.x0xO0oo(type, "type");
        IIX0o.x0xO0oo(param, "param");
        IIX0o.x0xO0oo(code, "code");
        this.message = message;
        this.type = type;
        this.param = param;
        this.code = code;
    }
}
