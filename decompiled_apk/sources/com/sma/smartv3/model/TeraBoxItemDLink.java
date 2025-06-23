package com.sma.smartv3.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class TeraBoxItemDLink {

    @OOXIXo
    private final String dlink;
    private final long fs_id;

    public TeraBoxItemDLink() {
        this(0L, null, 3, null);
    }

    public static /* synthetic */ TeraBoxItemDLink copy$default(TeraBoxItemDLink teraBoxItemDLink, long j, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            j = teraBoxItemDLink.fs_id;
        }
        if ((i & 2) != 0) {
            str = teraBoxItemDLink.dlink;
        }
        return teraBoxItemDLink.copy(j, str);
    }

    public final long component1() {
        return this.fs_id;
    }

    @OOXIXo
    public final String component2() {
        return this.dlink;
    }

    @OOXIXo
    public final TeraBoxItemDLink copy(long j, @OOXIXo String dlink) {
        IIX0o.x0xO0oo(dlink, "dlink");
        return new TeraBoxItemDLink(j, dlink);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TeraBoxItemDLink)) {
            return false;
        }
        TeraBoxItemDLink teraBoxItemDLink = (TeraBoxItemDLink) obj;
        return this.fs_id == teraBoxItemDLink.fs_id && IIX0o.Oxx0IOOO(this.dlink, teraBoxItemDLink.dlink);
    }

    @OOXIXo
    public final String getDlink() {
        return this.dlink;
    }

    public final long getFs_id() {
        return this.fs_id;
    }

    public int hashCode() {
        return (androidx.collection.oIX0oI.oIX0oI(this.fs_id) * 31) + this.dlink.hashCode();
    }

    @OOXIXo
    public String toString() {
        return "TeraBoxItemDLink(fs_id=" + this.fs_id + ", dlink=" + this.dlink + HexStringBuilder.COMMENT_END_CHAR;
    }

    public TeraBoxItemDLink(long j, @OOXIXo String dlink) {
        IIX0o.x0xO0oo(dlink, "dlink");
        this.fs_id = j;
        this.dlink = dlink;
    }

    public /* synthetic */ TeraBoxItemDLink(long j, String str, int i, IIXOooo iIXOooo) {
        this((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? "" : str);
    }
}
