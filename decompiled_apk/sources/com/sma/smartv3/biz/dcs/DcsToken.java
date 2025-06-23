package com.sma.smartv3.biz.dcs;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import androidx.collection.oIX0oI;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class DcsToken {

    @OOXIXo
    private String access_token;

    @OOXIXo
    private String client_id;
    private int expires_in;

    @OOXIXo
    private String refresh_token;

    @OOXIXo
    private String scope;

    @OOXIXo
    private String session_key;

    @OOXIXo
    private String session_secret;

    @OOXIXo
    private String time;
    private long timestamp;

    public DcsToken() {
        this(null, 0, null, null, null, null, null, null, 0L, 511, null);
    }

    @OOXIXo
    public final String component1() {
        return this.refresh_token;
    }

    public final int component2() {
        return this.expires_in;
    }

    @OOXIXo
    public final String component3() {
        return this.session_key;
    }

    @OOXIXo
    public final String component4() {
        return this.client_id;
    }

    @OOXIXo
    public final String component5() {
        return this.access_token;
    }

    @OOXIXo
    public final String component6() {
        return this.scope;
    }

    @OOXIXo
    public final String component7() {
        return this.session_secret;
    }

    @OOXIXo
    public final String component8() {
        return this.time;
    }

    public final long component9() {
        return this.timestamp;
    }

    @OOXIXo
    public final DcsToken copy(@OOXIXo String refresh_token, int i, @OOXIXo String session_key, @OOXIXo String client_id, @OOXIXo String access_token, @OOXIXo String scope, @OOXIXo String session_secret, @OOXIXo String time, long j) {
        IIX0o.x0xO0oo(refresh_token, "refresh_token");
        IIX0o.x0xO0oo(session_key, "session_key");
        IIX0o.x0xO0oo(client_id, "client_id");
        IIX0o.x0xO0oo(access_token, "access_token");
        IIX0o.x0xO0oo(scope, "scope");
        IIX0o.x0xO0oo(session_secret, "session_secret");
        IIX0o.x0xO0oo(time, "time");
        return new DcsToken(refresh_token, i, session_key, client_id, access_token, scope, session_secret, time, j);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DcsToken)) {
            return false;
        }
        DcsToken dcsToken = (DcsToken) obj;
        return IIX0o.Oxx0IOOO(this.refresh_token, dcsToken.refresh_token) && this.expires_in == dcsToken.expires_in && IIX0o.Oxx0IOOO(this.session_key, dcsToken.session_key) && IIX0o.Oxx0IOOO(this.client_id, dcsToken.client_id) && IIX0o.Oxx0IOOO(this.access_token, dcsToken.access_token) && IIX0o.Oxx0IOOO(this.scope, dcsToken.scope) && IIX0o.Oxx0IOOO(this.session_secret, dcsToken.session_secret) && IIX0o.Oxx0IOOO(this.time, dcsToken.time) && this.timestamp == dcsToken.timestamp;
    }

    @OOXIXo
    public final String getAccess_token() {
        return this.access_token;
    }

    @OOXIXo
    public final String getClient_id() {
        return this.client_id;
    }

    public final int getExpires_in() {
        return this.expires_in;
    }

    @OOXIXo
    public final String getRefresh_token() {
        return this.refresh_token;
    }

    @OOXIXo
    public final String getScope() {
        return this.scope;
    }

    @OOXIXo
    public final String getSession_key() {
        return this.session_key;
    }

    @OOXIXo
    public final String getSession_secret() {
        return this.session_secret;
    }

    @OOXIXo
    public final String getTime() {
        return this.time;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        return (((((((((((((((this.refresh_token.hashCode() * 31) + this.expires_in) * 31) + this.session_key.hashCode()) * 31) + this.client_id.hashCode()) * 31) + this.access_token.hashCode()) * 31) + this.scope.hashCode()) * 31) + this.session_secret.hashCode()) * 31) + this.time.hashCode()) * 31) + oIX0oI.oIX0oI(this.timestamp);
    }

    public final void setAccess_token(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.access_token = str;
    }

    public final void setClient_id(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.client_id = str;
    }

    public final void setExpires_in(int i) {
        this.expires_in = i;
    }

    public final void setRefresh_token(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.refresh_token = str;
    }

    public final void setScope(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.scope = str;
    }

    public final void setSession_key(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.session_key = str;
    }

    public final void setSession_secret(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.session_secret = str;
    }

    public final void setTime(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.time = str;
    }

    public final void setTimestamp(long j) {
        this.timestamp = j;
    }

    @OOXIXo
    public String toString() {
        return "DcsToken(refresh_token=" + this.refresh_token + ", expires_in=" + this.expires_in + ", session_key=" + this.session_key + ", client_id=" + this.client_id + ", access_token=" + this.access_token + ", scope=" + this.scope + ", session_secret=" + this.session_secret + ", time=" + this.time + ", timestamp=" + this.timestamp + HexStringBuilder.COMMENT_END_CHAR;
    }

    public DcsToken(@OOXIXo String refresh_token, int i, @OOXIXo String session_key, @OOXIXo String client_id, @OOXIXo String access_token, @OOXIXo String scope, @OOXIXo String session_secret, @OOXIXo String time, long j) {
        IIX0o.x0xO0oo(refresh_token, "refresh_token");
        IIX0o.x0xO0oo(session_key, "session_key");
        IIX0o.x0xO0oo(client_id, "client_id");
        IIX0o.x0xO0oo(access_token, "access_token");
        IIX0o.x0xO0oo(scope, "scope");
        IIX0o.x0xO0oo(session_secret, "session_secret");
        IIX0o.x0xO0oo(time, "time");
        this.refresh_token = refresh_token;
        this.expires_in = i;
        this.session_key = session_key;
        this.client_id = client_id;
        this.access_token = access_token;
        this.scope = scope;
        this.session_secret = session_secret;
        this.time = time;
        this.timestamp = j;
    }

    public /* synthetic */ DcsToken(String str, int i, String str2, String str3, String str4, String str5, String str6, String str7, long j, int i2, IIXOooo iIXOooo) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? 0 : i, (i2 & 4) != 0 ? "" : str2, (i2 & 8) != 0 ? "" : str3, (i2 & 16) != 0 ? "" : str4, (i2 & 32) != 0 ? "" : str5, (i2 & 64) != 0 ? "" : str6, (i2 & 128) == 0 ? str7 : "", (i2 & 256) != 0 ? 0L : j);
    }
}
