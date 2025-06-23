package com.sma.smartv3.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class TeraBoxShareLink {

    @OOXIXo
    private final String shareUrl;

    /* JADX WARN: Multi-variable type inference failed */
    public TeraBoxShareLink() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ TeraBoxShareLink copy$default(TeraBoxShareLink teraBoxShareLink, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = teraBoxShareLink.shareUrl;
        }
        return teraBoxShareLink.copy(str);
    }

    @OOXIXo
    public final String component1() {
        return this.shareUrl;
    }

    @OOXIXo
    public final TeraBoxShareLink copy(@OOXIXo String shareUrl) {
        IIX0o.x0xO0oo(shareUrl, "shareUrl");
        return new TeraBoxShareLink(shareUrl);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof TeraBoxShareLink) && IIX0o.Oxx0IOOO(this.shareUrl, ((TeraBoxShareLink) obj).shareUrl);
    }

    @OOXIXo
    public final String getShareUrl() {
        return this.shareUrl;
    }

    public int hashCode() {
        return this.shareUrl.hashCode();
    }

    @OOXIXo
    public String toString() {
        return "TeraBoxShareLink(shareUrl=" + this.shareUrl + HexStringBuilder.COMMENT_END_CHAR;
    }

    public TeraBoxShareLink(@OOXIXo String shareUrl) {
        IIX0o.x0xO0oo(shareUrl, "shareUrl");
        this.shareUrl = shareUrl;
    }

    public /* synthetic */ TeraBoxShareLink(String str, int i, IIXOooo iIXOooo) {
        this((i & 1) != 0 ? "" : str);
    }
}
