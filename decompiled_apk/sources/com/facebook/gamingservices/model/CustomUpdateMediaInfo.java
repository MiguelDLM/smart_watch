package com.facebook.gamingservices.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes8.dex */
public final class CustomUpdateMediaInfo {

    @OOXIXo
    private final String url;

    public CustomUpdateMediaInfo(@OOXIXo String url) {
        IIX0o.x0xO0oo(url, "url");
        this.url = url;
    }

    public static /* synthetic */ CustomUpdateMediaInfo copy$default(CustomUpdateMediaInfo customUpdateMediaInfo, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = customUpdateMediaInfo.url;
        }
        return customUpdateMediaInfo.copy(str);
    }

    @OOXIXo
    public final String component1() {
        return this.url;
    }

    @OOXIXo
    public final CustomUpdateMediaInfo copy(@OOXIXo String url) {
        IIX0o.x0xO0oo(url, "url");
        return new CustomUpdateMediaInfo(url);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof CustomUpdateMediaInfo) && IIX0o.Oxx0IOOO(this.url, ((CustomUpdateMediaInfo) obj).url);
    }

    @OOXIXo
    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        return this.url.hashCode();
    }

    @OOXIXo
    public String toString() {
        return "CustomUpdateMediaInfo(url=" + this.url + HexStringBuilder.COMMENT_END_CHAR;
    }
}
