package com.sma.smartv3.biz.dcs;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.sma.smartv3.model.JsonFieldContainer;
import java.io.Serializable;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class ResponseData extends JsonFieldContainer implements Serializable {

    @OOXIXo
    private final String answer;
    private final int index;

    @OOXIXo
    private final String part;

    @OOXIXo
    private final String role;

    public ResponseData(@OOXIXo String answer, @OOXIXo String part, int i, @OOXIXo String role) {
        IIX0o.x0xO0oo(answer, "answer");
        IIX0o.x0xO0oo(part, "part");
        IIX0o.x0xO0oo(role, "role");
        this.answer = answer;
        this.part = part;
        this.index = i;
        this.role = role;
    }

    public static /* synthetic */ ResponseData copy$default(ResponseData responseData, String str, String str2, int i, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = responseData.answer;
        }
        if ((i2 & 2) != 0) {
            str2 = responseData.part;
        }
        if ((i2 & 4) != 0) {
            i = responseData.index;
        }
        if ((i2 & 8) != 0) {
            str3 = responseData.role;
        }
        return responseData.copy(str, str2, i, str3);
    }

    @OOXIXo
    public final String component1() {
        return this.answer;
    }

    @OOXIXo
    public final String component2() {
        return this.part;
    }

    public final int component3() {
        return this.index;
    }

    @OOXIXo
    public final String component4() {
        return this.role;
    }

    @OOXIXo
    public final ResponseData copy(@OOXIXo String answer, @OOXIXo String part, int i, @OOXIXo String role) {
        IIX0o.x0xO0oo(answer, "answer");
        IIX0o.x0xO0oo(part, "part");
        IIX0o.x0xO0oo(role, "role");
        return new ResponseData(answer, part, i, role);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResponseData)) {
            return false;
        }
        ResponseData responseData = (ResponseData) obj;
        return IIX0o.Oxx0IOOO(this.answer, responseData.answer) && IIX0o.Oxx0IOOO(this.part, responseData.part) && this.index == responseData.index && IIX0o.Oxx0IOOO(this.role, responseData.role);
    }

    @OOXIXo
    public final String getAnswer() {
        return this.answer;
    }

    public final int getIndex() {
        return this.index;
    }

    @OOXIXo
    public final String getPart() {
        return this.part;
    }

    @OOXIXo
    public final String getRole() {
        return this.role;
    }

    public int hashCode() {
        return (((((this.answer.hashCode() * 31) + this.part.hashCode()) * 31) + this.index) * 31) + this.role.hashCode();
    }

    @OOXIXo
    public String toString() {
        return "ResponseData(answer=" + this.answer + ", part=" + this.part + ", index=" + this.index + ", role=" + this.role + HexStringBuilder.COMMENT_END_CHAR;
    }
}
