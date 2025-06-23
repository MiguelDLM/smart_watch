package com.sma.smartv3.biz.dcs;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.sma.smartv3.model.JsonFieldContainer;
import java.io.Serializable;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class Header extends JsonFieldContainer implements Serializable {

    @OOXIXo
    private final String name;

    @OOXIXo
    private final String namespace;

    public Header(@OOXIXo String namespace, @OOXIXo String name) {
        IIX0o.x0xO0oo(namespace, "namespace");
        IIX0o.x0xO0oo(name, "name");
        this.namespace = namespace;
        this.name = name;
    }

    public static /* synthetic */ Header copy$default(Header header, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = header.namespace;
        }
        if ((i & 2) != 0) {
            str2 = header.name;
        }
        return header.copy(str, str2);
    }

    @OOXIXo
    public final String component1() {
        return this.namespace;
    }

    @OOXIXo
    public final String component2() {
        return this.name;
    }

    @OOXIXo
    public final Header copy(@OOXIXo String namespace, @OOXIXo String name) {
        IIX0o.x0xO0oo(namespace, "namespace");
        IIX0o.x0xO0oo(name, "name");
        return new Header(namespace, name);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Header)) {
            return false;
        }
        Header header = (Header) obj;
        return IIX0o.Oxx0IOOO(this.namespace, header.namespace) && IIX0o.Oxx0IOOO(this.name, header.name);
    }

    @OOXIXo
    public final String getName() {
        return this.name;
    }

    @OOXIXo
    public final String getNamespace() {
        return this.namespace;
    }

    public int hashCode() {
        return (this.namespace.hashCode() * 31) + this.name.hashCode();
    }

    @OOXIXo
    public String toString() {
        return "Header(namespace=" + this.namespace + ", name=" + this.name + HexStringBuilder.COMMENT_END_CHAR;
    }
}
