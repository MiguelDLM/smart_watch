package com.sma.smartv3.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class TransmissionMusicItem {

    @OOXIXo
    private final String path;

    @OOXIXo
    private final String title;

    @OOXIXo
    private final String uri;

    @OOXIXo
    private final String url;

    public TransmissionMusicItem() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ TransmissionMusicItem copy$default(TransmissionMusicItem transmissionMusicItem, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = transmissionMusicItem.path;
        }
        if ((i & 2) != 0) {
            str2 = transmissionMusicItem.url;
        }
        if ((i & 4) != 0) {
            str3 = transmissionMusicItem.uri;
        }
        if ((i & 8) != 0) {
            str4 = transmissionMusicItem.title;
        }
        return transmissionMusicItem.copy(str, str2, str3, str4);
    }

    @OOXIXo
    public final String component1() {
        return this.path;
    }

    @OOXIXo
    public final String component2() {
        return this.url;
    }

    @OOXIXo
    public final String component3() {
        return this.uri;
    }

    @OOXIXo
    public final String component4() {
        return this.title;
    }

    @OOXIXo
    public final TransmissionMusicItem copy(@OOXIXo String path, @OOXIXo String url, @OOXIXo String uri, @OOXIXo String title) {
        IIX0o.x0xO0oo(path, "path");
        IIX0o.x0xO0oo(url, "url");
        IIX0o.x0xO0oo(uri, "uri");
        IIX0o.x0xO0oo(title, "title");
        return new TransmissionMusicItem(path, url, uri, title);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TransmissionMusicItem)) {
            return false;
        }
        TransmissionMusicItem transmissionMusicItem = (TransmissionMusicItem) obj;
        return IIX0o.Oxx0IOOO(this.path, transmissionMusicItem.path) && IIX0o.Oxx0IOOO(this.url, transmissionMusicItem.url) && IIX0o.Oxx0IOOO(this.uri, transmissionMusicItem.uri) && IIX0o.Oxx0IOOO(this.title, transmissionMusicItem.title);
    }

    @OOXIXo
    public final String getPath() {
        return this.path;
    }

    @OOXIXo
    public final String getTitle() {
        return this.title;
    }

    @OOXIXo
    public final String getUri() {
        return this.uri;
    }

    @OOXIXo
    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        return (((((this.path.hashCode() * 31) + this.url.hashCode()) * 31) + this.uri.hashCode()) * 31) + this.title.hashCode();
    }

    @OOXIXo
    public String toString() {
        return "TransmissionMusicItem(path=" + this.path + ", url=" + this.url + ", uri=" + this.uri + ", title=" + this.title + HexStringBuilder.COMMENT_END_CHAR;
    }

    public TransmissionMusicItem(@OOXIXo String path, @OOXIXo String url, @OOXIXo String uri, @OOXIXo String title) {
        IIX0o.x0xO0oo(path, "path");
        IIX0o.x0xO0oo(url, "url");
        IIX0o.x0xO0oo(uri, "uri");
        IIX0o.x0xO0oo(title, "title");
        this.path = path;
        this.url = url;
        this.uri = uri;
        this.title = title;
    }

    public /* synthetic */ TransmissionMusicItem(String str, String str2, String str3, String str4, int i, IIXOooo iIXOooo) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4);
    }
}
