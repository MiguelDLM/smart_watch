package com.sma.smartv3.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class TeraBoxTokenInfo {

    @OOXIXo
    private final String client_id;

    @OOXIXo
    private final String user_id;

    /* JADX WARN: Multi-variable type inference failed */
    public TeraBoxTokenInfo() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ TeraBoxTokenInfo copy$default(TeraBoxTokenInfo teraBoxTokenInfo, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = teraBoxTokenInfo.client_id;
        }
        if ((i & 2) != 0) {
            str2 = teraBoxTokenInfo.user_id;
        }
        return teraBoxTokenInfo.copy(str, str2);
    }

    @OOXIXo
    public final String component1() {
        return this.client_id;
    }

    @OOXIXo
    public final String component2() {
        return this.user_id;
    }

    @OOXIXo
    public final TeraBoxTokenInfo copy(@OOXIXo String client_id, @OOXIXo String user_id) {
        IIX0o.x0xO0oo(client_id, "client_id");
        IIX0o.x0xO0oo(user_id, "user_id");
        return new TeraBoxTokenInfo(client_id, user_id);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TeraBoxTokenInfo)) {
            return false;
        }
        TeraBoxTokenInfo teraBoxTokenInfo = (TeraBoxTokenInfo) obj;
        return IIX0o.Oxx0IOOO(this.client_id, teraBoxTokenInfo.client_id) && IIX0o.Oxx0IOOO(this.user_id, teraBoxTokenInfo.user_id);
    }

    @OOXIXo
    public final String getClient_id() {
        return this.client_id;
    }

    @OOXIXo
    public final String getUser_id() {
        return this.user_id;
    }

    public int hashCode() {
        return (this.client_id.hashCode() * 31) + this.user_id.hashCode();
    }

    @OOXIXo
    public String toString() {
        return "TeraBoxTokenInfo(client_id=" + this.client_id + ", user_id=" + this.user_id + HexStringBuilder.COMMENT_END_CHAR;
    }

    public TeraBoxTokenInfo(@OOXIXo String client_id, @OOXIXo String user_id) {
        IIX0o.x0xO0oo(client_id, "client_id");
        IIX0o.x0xO0oo(user_id, "user_id");
        this.client_id = client_id;
        this.user_id = user_id;
    }

    public /* synthetic */ TeraBoxTokenInfo(String str, String str2, int i, IIXOooo iIXOooo) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2);
    }
}
