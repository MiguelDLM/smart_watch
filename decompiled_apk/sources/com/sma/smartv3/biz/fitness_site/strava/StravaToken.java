package com.sma.smartv3.biz.fitness_site.strava;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import androidx.collection.oIX0oI;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class StravaToken {

    @OOXIXo
    private String access_token;
    private long expires_at;
    private int expires_in;

    @OOXIXo
    private String refresh_token;

    @OOXIXo
    private String token_type;

    public StravaToken() {
        this(null, 0L, 0, null, null, 31, null);
    }

    public static /* synthetic */ StravaToken copy$default(StravaToken stravaToken, String str, long j, int i, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = stravaToken.token_type;
        }
        if ((i2 & 2) != 0) {
            j = stravaToken.expires_at;
        }
        long j2 = j;
        if ((i2 & 4) != 0) {
            i = stravaToken.expires_in;
        }
        int i3 = i;
        if ((i2 & 8) != 0) {
            str2 = stravaToken.refresh_token;
        }
        String str4 = str2;
        if ((i2 & 16) != 0) {
            str3 = stravaToken.access_token;
        }
        return stravaToken.copy(str, j2, i3, str4, str3);
    }

    @OOXIXo
    public final String component1() {
        return this.token_type;
    }

    public final long component2() {
        return this.expires_at;
    }

    public final int component3() {
        return this.expires_in;
    }

    @OOXIXo
    public final String component4() {
        return this.refresh_token;
    }

    @OOXIXo
    public final String component5() {
        return this.access_token;
    }

    @OOXIXo
    public final StravaToken copy(@OOXIXo String token_type, long j, int i, @OOXIXo String refresh_token, @OOXIXo String access_token) {
        IIX0o.x0xO0oo(token_type, "token_type");
        IIX0o.x0xO0oo(refresh_token, "refresh_token");
        IIX0o.x0xO0oo(access_token, "access_token");
        return new StravaToken(token_type, j, i, refresh_token, access_token);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StravaToken)) {
            return false;
        }
        StravaToken stravaToken = (StravaToken) obj;
        return IIX0o.Oxx0IOOO(this.token_type, stravaToken.token_type) && this.expires_at == stravaToken.expires_at && this.expires_in == stravaToken.expires_in && IIX0o.Oxx0IOOO(this.refresh_token, stravaToken.refresh_token) && IIX0o.Oxx0IOOO(this.access_token, stravaToken.access_token);
    }

    @OOXIXo
    public final String getAccess_token() {
        return this.access_token;
    }

    public final long getExpires_at() {
        return this.expires_at;
    }

    public final int getExpires_in() {
        return this.expires_in;
    }

    @OOXIXo
    public final String getRefresh_token() {
        return this.refresh_token;
    }

    @OOXIXo
    public final String getToken_type() {
        return this.token_type;
    }

    public int hashCode() {
        return (((((((this.token_type.hashCode() * 31) + oIX0oI.oIX0oI(this.expires_at)) * 31) + this.expires_in) * 31) + this.refresh_token.hashCode()) * 31) + this.access_token.hashCode();
    }

    public final void setAccess_token(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.access_token = str;
    }

    public final void setExpires_at(long j) {
        this.expires_at = j;
    }

    public final void setExpires_in(int i) {
        this.expires_in = i;
    }

    public final void setRefresh_token(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.refresh_token = str;
    }

    public final void setToken_type(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.token_type = str;
    }

    @OOXIXo
    public String toString() {
        return "StravaToken(token_type=" + this.token_type + ", expires_at=" + this.expires_at + ", expires_in=" + this.expires_in + ", refresh_token=" + this.refresh_token + ", access_token=" + this.access_token + HexStringBuilder.COMMENT_END_CHAR;
    }

    public StravaToken(@OOXIXo String token_type, long j, int i, @OOXIXo String refresh_token, @OOXIXo String access_token) {
        IIX0o.x0xO0oo(token_type, "token_type");
        IIX0o.x0xO0oo(refresh_token, "refresh_token");
        IIX0o.x0xO0oo(access_token, "access_token");
        this.token_type = token_type;
        this.expires_at = j;
        this.expires_in = i;
        this.refresh_token = refresh_token;
        this.access_token = access_token;
    }

    public /* synthetic */ StravaToken(String str, long j, int i, String str2, String str3, int i2, IIXOooo iIXOooo) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? 0L : j, (i2 & 4) != 0 ? 0 : i, (i2 & 8) != 0 ? "" : str2, (i2 & 16) != 0 ? "" : str3);
    }
}
