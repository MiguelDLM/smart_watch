package com.sma.smartv3.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class TeraBoxToken {

    @OOXIXo
    private final String access_token;
    private final long expires_in;

    @OOXIXo
    private final String refresh_token;

    public TeraBoxToken() {
        this(0L, null, null, 7, null);
    }

    public static /* synthetic */ TeraBoxToken copy$default(TeraBoxToken teraBoxToken, long j, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = teraBoxToken.expires_in;
        }
        if ((i & 2) != 0) {
            str = teraBoxToken.refresh_token;
        }
        if ((i & 4) != 0) {
            str2 = teraBoxToken.access_token;
        }
        return teraBoxToken.copy(j, str, str2);
    }

    public final long component1() {
        return this.expires_in;
    }

    @OOXIXo
    public final String component2() {
        return this.refresh_token;
    }

    @OOXIXo
    public final String component3() {
        return this.access_token;
    }

    @OOXIXo
    public final TeraBoxToken copy(long j, @OOXIXo String refresh_token, @OOXIXo String access_token) {
        IIX0o.x0xO0oo(refresh_token, "refresh_token");
        IIX0o.x0xO0oo(access_token, "access_token");
        return new TeraBoxToken(j, refresh_token, access_token);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TeraBoxToken)) {
            return false;
        }
        TeraBoxToken teraBoxToken = (TeraBoxToken) obj;
        return this.expires_in == teraBoxToken.expires_in && IIX0o.Oxx0IOOO(this.refresh_token, teraBoxToken.refresh_token) && IIX0o.Oxx0IOOO(this.access_token, teraBoxToken.access_token);
    }

    @OOXIXo
    public final String getAccess_token() {
        return this.access_token;
    }

    public final long getExpires_in() {
        return this.expires_in;
    }

    @OOXIXo
    public final String getRefresh_token() {
        return this.refresh_token;
    }

    public int hashCode() {
        return (((androidx.collection.oIX0oI.oIX0oI(this.expires_in) * 31) + this.refresh_token.hashCode()) * 31) + this.access_token.hashCode();
    }

    @OOXIXo
    public String toString() {
        return "TeraBoxToken(expires_in=" + this.expires_in + ", refresh_token=" + this.refresh_token + ", access_token=" + this.access_token + HexStringBuilder.COMMENT_END_CHAR;
    }

    public TeraBoxToken(long j, @OOXIXo String refresh_token, @OOXIXo String access_token) {
        IIX0o.x0xO0oo(refresh_token, "refresh_token");
        IIX0o.x0xO0oo(access_token, "access_token");
        this.expires_in = j;
        this.refresh_token = refresh_token;
        this.access_token = access_token;
    }

    public /* synthetic */ TeraBoxToken(long j, String str, String str2, int i, IIXOooo iIXOooo) {
        this((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? "" : str2);
    }
}
