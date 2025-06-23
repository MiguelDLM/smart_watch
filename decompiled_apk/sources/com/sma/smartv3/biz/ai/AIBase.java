package com.sma.smartv3.biz.ai;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.sma.smartv3.model.JsonFieldContainer;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class AIBase extends JsonFieldContainer {

    @OOXIXo
    private AIError error;

    public AIBase(@OOXIXo AIError error) {
        IIX0o.x0xO0oo(error, "error");
        this.error = error;
    }

    public static /* synthetic */ AIBase copy$default(AIBase aIBase, AIError aIError, int i, Object obj) {
        if ((i & 1) != 0) {
            aIError = aIBase.error;
        }
        return aIBase.copy(aIError);
    }

    @OOXIXo
    public final AIError component1() {
        return this.error;
    }

    @OOXIXo
    public final AIBase copy(@OOXIXo AIError error) {
        IIX0o.x0xO0oo(error, "error");
        return new AIBase(error);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AIBase) && IIX0o.Oxx0IOOO(this.error, ((AIBase) obj).error);
    }

    @OOXIXo
    public final AIError getError() {
        return this.error;
    }

    public int hashCode() {
        return this.error.hashCode();
    }

    public final void setError(@OOXIXo AIError aIError) {
        IIX0o.x0xO0oo(aIError, "<set-?>");
        this.error = aIError;
    }

    @OOXIXo
    public String toString() {
        return "AIBase(error=" + this.error + HexStringBuilder.COMMENT_END_CHAR;
    }
}
