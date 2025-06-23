package com.sma.smartv3.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class UserExtra extends JsonField {

    @OOXIXo
    private String countryCode;

    /* JADX WARN: Multi-variable type inference failed */
    public UserExtra() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ UserExtra copy$default(UserExtra userExtra, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = userExtra.countryCode;
        }
        return userExtra.copy(str);
    }

    @OOXIXo
    public final String component1() {
        return this.countryCode;
    }

    @OOXIXo
    public final UserExtra copy(@OOXIXo String countryCode) {
        IIX0o.x0xO0oo(countryCode, "countryCode");
        return new UserExtra(countryCode);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof UserExtra) && IIX0o.Oxx0IOOO(this.countryCode, ((UserExtra) obj).countryCode);
    }

    @OOXIXo
    public final String getCountryCode() {
        return this.countryCode;
    }

    public int hashCode() {
        return this.countryCode.hashCode();
    }

    public final void setCountryCode(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.countryCode = str;
    }

    @OOXIXo
    public String toString() {
        return "UserExtra(countryCode=" + this.countryCode + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ UserExtra(String str, int i, IIXOooo iIXOooo) {
        this((i & 1) != 0 ? "" : str);
    }

    public UserExtra(@OOXIXo String countryCode) {
        IIX0o.x0xO0oo(countryCode, "countryCode");
        this.countryCode = countryCode;
    }
}
