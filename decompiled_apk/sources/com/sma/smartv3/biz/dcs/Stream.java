package com.sma.smartv3.biz.dcs;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.sma.smartv3.model.JsonFieldContainer;
import java.io.Serializable;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class Stream extends JsonFieldContainer implements Serializable {

    @OOXIXo
    private final String url;

    public Stream(@OOXIXo String url) {
        IIX0o.x0xO0oo(url, "url");
        this.url = url;
    }

    public static /* synthetic */ Stream copy$default(Stream stream, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = stream.url;
        }
        return stream.copy(str);
    }

    @OOXIXo
    public final String component1() {
        return this.url;
    }

    @OOXIXo
    public final Stream copy(@OOXIXo String url) {
        IIX0o.x0xO0oo(url, "url");
        return new Stream(url);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Stream) && IIX0o.Oxx0IOOO(this.url, ((Stream) obj).url);
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
        return "Stream(url=" + this.url + HexStringBuilder.COMMENT_END_CHAR;
    }
}
