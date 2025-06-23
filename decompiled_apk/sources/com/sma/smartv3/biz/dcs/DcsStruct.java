package com.sma.smartv3.biz.dcs;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.sma.smartv3.model.JsonFieldContainer;
import java.io.Serializable;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class DcsStruct extends JsonFieldContainer implements Serializable {

    @OOXIXo
    private final Directive directive;

    public DcsStruct(@OOXIXo Directive directive) {
        IIX0o.x0xO0oo(directive, "directive");
        this.directive = directive;
    }

    public static /* synthetic */ DcsStruct copy$default(DcsStruct dcsStruct, Directive directive, int i, Object obj) {
        if ((i & 1) != 0) {
            directive = dcsStruct.directive;
        }
        return dcsStruct.copy(directive);
    }

    @OOXIXo
    public final Directive component1() {
        return this.directive;
    }

    @OOXIXo
    public final DcsStruct copy(@OOXIXo Directive directive) {
        IIX0o.x0xO0oo(directive, "directive");
        return new DcsStruct(directive);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof DcsStruct) && IIX0o.Oxx0IOOO(this.directive, ((DcsStruct) obj).directive);
    }

    @OOXIXo
    public final Directive getDirective() {
        return this.directive;
    }

    public int hashCode() {
        return this.directive.hashCode();
    }

    @OOXIXo
    public String toString() {
        return "DcsStruct(directive=" + this.directive + HexStringBuilder.COMMENT_END_CHAR;
    }
}
