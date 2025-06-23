package com.sma.smartv3.biz.fitness_site.fitbit;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import androidx.collection.oIX0oI;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class FitbitToken {

    @OOXIXo
    private String access_token;
    private long expires_at;
    private int expires_in;

    @OOXIXo
    private String refresh_token;

    @OOXIXo
    private String token_type;

    @OOXIXo
    private String user_id;

    public FitbitToken() {
        this(null, 0, null, 0L, null, null, 63, null);
    }

    public static /* synthetic */ FitbitToken copy$default(FitbitToken fitbitToken, String str, int i, String str2, long j, String str3, String str4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = fitbitToken.access_token;
        }
        if ((i2 & 2) != 0) {
            i = fitbitToken.expires_in;
        }
        int i3 = i;
        if ((i2 & 4) != 0) {
            str2 = fitbitToken.refresh_token;
        }
        String str5 = str2;
        if ((i2 & 8) != 0) {
            j = fitbitToken.expires_at;
        }
        long j2 = j;
        if ((i2 & 16) != 0) {
            str3 = fitbitToken.token_type;
        }
        String str6 = str3;
        if ((i2 & 32) != 0) {
            str4 = fitbitToken.user_id;
        }
        return fitbitToken.copy(str, i3, str5, j2, str6, str4);
    }

    @OOXIXo
    public final String component1() {
        return this.access_token;
    }

    public final int component2() {
        return this.expires_in;
    }

    @OOXIXo
    public final String component3() {
        return this.refresh_token;
    }

    public final long component4() {
        return this.expires_at;
    }

    @OOXIXo
    public final String component5() {
        return this.token_type;
    }

    @OOXIXo
    public final String component6() {
        return this.user_id;
    }

    @OOXIXo
    public final FitbitToken copy(@OOXIXo String access_token, int i, @OOXIXo String refresh_token, long j, @OOXIXo String token_type, @OOXIXo String user_id) {
        IIX0o.x0xO0oo(access_token, "access_token");
        IIX0o.x0xO0oo(refresh_token, "refresh_token");
        IIX0o.x0xO0oo(token_type, "token_type");
        IIX0o.x0xO0oo(user_id, "user_id");
        return new FitbitToken(access_token, i, refresh_token, j, token_type, user_id);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FitbitToken)) {
            return false;
        }
        FitbitToken fitbitToken = (FitbitToken) obj;
        return IIX0o.Oxx0IOOO(this.access_token, fitbitToken.access_token) && this.expires_in == fitbitToken.expires_in && IIX0o.Oxx0IOOO(this.refresh_token, fitbitToken.refresh_token) && this.expires_at == fitbitToken.expires_at && IIX0o.Oxx0IOOO(this.token_type, fitbitToken.token_type) && IIX0o.Oxx0IOOO(this.user_id, fitbitToken.user_id);
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

    @OOXIXo
    public final String getUser_id() {
        return this.user_id;
    }

    public int hashCode() {
        return (((((((((this.access_token.hashCode() * 31) + this.expires_in) * 31) + this.refresh_token.hashCode()) * 31) + oIX0oI.oIX0oI(this.expires_at)) * 31) + this.token_type.hashCode()) * 31) + this.user_id.hashCode();
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

    public final void setUser_id(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.user_id = str;
    }

    @OOXIXo
    public String toString() {
        return "FitbitToken(access_token=" + this.access_token + ", expires_in=" + this.expires_in + ", refresh_token=" + this.refresh_token + ", expires_at=" + this.expires_at + ", token_type=" + this.token_type + ", user_id=" + this.user_id + HexStringBuilder.COMMENT_END_CHAR;
    }

    public FitbitToken(@OOXIXo String access_token, int i, @OOXIXo String refresh_token, long j, @OOXIXo String token_type, @OOXIXo String user_id) {
        IIX0o.x0xO0oo(access_token, "access_token");
        IIX0o.x0xO0oo(refresh_token, "refresh_token");
        IIX0o.x0xO0oo(token_type, "token_type");
        IIX0o.x0xO0oo(user_id, "user_id");
        this.access_token = access_token;
        this.expires_in = i;
        this.refresh_token = refresh_token;
        this.expires_at = j;
        this.token_type = token_type;
        this.user_id = user_id;
    }

    public /* synthetic */ FitbitToken(String str, int i, String str2, long j, String str3, String str4, int i2, IIXOooo iIXOooo) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? 0 : i, (i2 & 4) != 0 ? "" : str2, (i2 & 8) != 0 ? 0L : j, (i2 & 16) != 0 ? "" : str3, (i2 & 32) != 0 ? "" : str4);
    }
}
