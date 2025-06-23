package com.facebook.internal.gatekeeper;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes8.dex */
public final class GateKeeper {

    @OOXIXo
    private final String name;
    private final boolean value;

    public GateKeeper(@OOXIXo String name, boolean z) {
        IIX0o.x0xO0oo(name, "name");
        this.name = name;
        this.value = z;
    }

    public static /* synthetic */ GateKeeper copy$default(GateKeeper gateKeeper, String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = gateKeeper.name;
        }
        if ((i & 2) != 0) {
            z = gateKeeper.value;
        }
        return gateKeeper.copy(str, z);
    }

    @OOXIXo
    public final String component1() {
        return this.name;
    }

    public final boolean component2() {
        return this.value;
    }

    @OOXIXo
    public final GateKeeper copy(@OOXIXo String name, boolean z) {
        IIX0o.x0xO0oo(name, "name");
        return new GateKeeper(name, z);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GateKeeper)) {
            return false;
        }
        GateKeeper gateKeeper = (GateKeeper) obj;
        return IIX0o.Oxx0IOOO(this.name, gateKeeper.name) && this.value == gateKeeper.value;
    }

    @OOXIXo
    public final String getName() {
        return this.name;
    }

    public final boolean getValue() {
        return this.value;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.name.hashCode() * 31;
        boolean z = this.value;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return hashCode + i;
    }

    @OOXIXo
    public String toString() {
        return "GateKeeper(name=" + this.name + ", value=" + this.value + HexStringBuilder.COMMENT_END_CHAR;
    }
}
