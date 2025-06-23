package com.sma.smartv3.biz.dcs;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.sma.smartv3.model.JsonFieldContainer;
import java.io.Serializable;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class Directive extends JsonFieldContainer implements Serializable {

    @OOXIXo
    private final Header header;

    @OOXIXo
    private final PlayPayload payload;

    public Directive(@OOXIXo Header header, @OOXIXo PlayPayload payload) {
        IIX0o.x0xO0oo(header, "header");
        IIX0o.x0xO0oo(payload, "payload");
        this.header = header;
        this.payload = payload;
    }

    public static /* synthetic */ Directive copy$default(Directive directive, Header header, PlayPayload playPayload, int i, Object obj) {
        if ((i & 1) != 0) {
            header = directive.header;
        }
        if ((i & 2) != 0) {
            playPayload = directive.payload;
        }
        return directive.copy(header, playPayload);
    }

    @OOXIXo
    public final Header component1() {
        return this.header;
    }

    @OOXIXo
    public final PlayPayload component2() {
        return this.payload;
    }

    @OOXIXo
    public final Directive copy(@OOXIXo Header header, @OOXIXo PlayPayload payload) {
        IIX0o.x0xO0oo(header, "header");
        IIX0o.x0xO0oo(payload, "payload");
        return new Directive(header, payload);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Directive)) {
            return false;
        }
        Directive directive = (Directive) obj;
        return IIX0o.Oxx0IOOO(this.header, directive.header) && IIX0o.Oxx0IOOO(this.payload, directive.payload);
    }

    @OOXIXo
    public final Header getHeader() {
        return this.header;
    }

    @OOXIXo
    public final PlayPayload getPayload() {
        return this.payload;
    }

    public int hashCode() {
        return (this.header.hashCode() * 31) + this.payload.hashCode();
    }

    @OOXIXo
    public String toString() {
        return "Directive(header=" + this.header + ", payload=" + this.payload + HexStringBuilder.COMMENT_END_CHAR;
    }
}
