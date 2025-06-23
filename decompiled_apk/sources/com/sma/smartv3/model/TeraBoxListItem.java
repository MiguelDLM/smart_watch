package com.sma.smartv3.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.io.Serializable;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class TeraBoxListItem implements Serializable {

    @OOXIXo
    private final String category;
    private final long fs_id;
    private final int isdir;
    private final long local_mtime;

    @OOXIXo
    private final String path;
    private final long server_ctime;

    @OOXIXo
    private final String server_filename;
    private final int size;

    public TeraBoxListItem() {
        this(0L, null, 0L, 0L, null, 0, 0, null, 255, null);
    }

    public final long component1() {
        return this.fs_id;
    }

    @OOXIXo
    public final String component2() {
        return this.category;
    }

    public final long component3() {
        return this.local_mtime;
    }

    public final long component4() {
        return this.server_ctime;
    }

    @OOXIXo
    public final String component5() {
        return this.server_filename;
    }

    public final int component6() {
        return this.size;
    }

    public final int component7() {
        return this.isdir;
    }

    @OOXIXo
    public final String component8() {
        return this.path;
    }

    @OOXIXo
    public final TeraBoxListItem copy(long j, @OOXIXo String category, long j2, long j3, @OOXIXo String server_filename, int i, int i2, @OOXIXo String path) {
        IIX0o.x0xO0oo(category, "category");
        IIX0o.x0xO0oo(server_filename, "server_filename");
        IIX0o.x0xO0oo(path, "path");
        return new TeraBoxListItem(j, category, j2, j3, server_filename, i, i2, path);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TeraBoxListItem)) {
            return false;
        }
        TeraBoxListItem teraBoxListItem = (TeraBoxListItem) obj;
        return this.fs_id == teraBoxListItem.fs_id && IIX0o.Oxx0IOOO(this.category, teraBoxListItem.category) && this.local_mtime == teraBoxListItem.local_mtime && this.server_ctime == teraBoxListItem.server_ctime && IIX0o.Oxx0IOOO(this.server_filename, teraBoxListItem.server_filename) && this.size == teraBoxListItem.size && this.isdir == teraBoxListItem.isdir && IIX0o.Oxx0IOOO(this.path, teraBoxListItem.path);
    }

    @OOXIXo
    public final String getCategory() {
        return this.category;
    }

    public final long getFs_id() {
        return this.fs_id;
    }

    public final int getIsdir() {
        return this.isdir;
    }

    public final long getLocal_mtime() {
        return this.local_mtime;
    }

    @OOXIXo
    public final String getPath() {
        return this.path;
    }

    public final long getServer_ctime() {
        return this.server_ctime;
    }

    @OOXIXo
    public final String getServer_filename() {
        return this.server_filename;
    }

    public final int getSize() {
        return this.size;
    }

    public int hashCode() {
        return (((((((((((((androidx.collection.oIX0oI.oIX0oI(this.fs_id) * 31) + this.category.hashCode()) * 31) + androidx.collection.oIX0oI.oIX0oI(this.local_mtime)) * 31) + androidx.collection.oIX0oI.oIX0oI(this.server_ctime)) * 31) + this.server_filename.hashCode()) * 31) + this.size) * 31) + this.isdir) * 31) + this.path.hashCode();
    }

    @OOXIXo
    public String toString() {
        return "TeraBoxListItem(fs_id=" + this.fs_id + ", category=" + this.category + ", local_mtime=" + this.local_mtime + ", server_ctime=" + this.server_ctime + ", server_filename=" + this.server_filename + ", size=" + this.size + ", isdir=" + this.isdir + ", path=" + this.path + HexStringBuilder.COMMENT_END_CHAR;
    }

    public TeraBoxListItem(long j, @OOXIXo String category, long j2, long j3, @OOXIXo String server_filename, int i, int i2, @OOXIXo String path) {
        IIX0o.x0xO0oo(category, "category");
        IIX0o.x0xO0oo(server_filename, "server_filename");
        IIX0o.x0xO0oo(path, "path");
        this.fs_id = j;
        this.category = category;
        this.local_mtime = j2;
        this.server_ctime = j3;
        this.server_filename = server_filename;
        this.size = i;
        this.isdir = i2;
        this.path = path;
    }

    public /* synthetic */ TeraBoxListItem(long j, String str, long j2, long j3, String str2, int i, int i2, String str3, int i3, IIXOooo iIXOooo) {
        this((i3 & 1) != 0 ? 0L : j, (i3 & 2) != 0 ? "" : str, (i3 & 4) != 0 ? 0L : j2, (i3 & 8) == 0 ? j3 : 0L, (i3 & 16) != 0 ? "" : str2, (i3 & 32) != 0 ? 0 : i, (i3 & 64) == 0 ? i2 : 0, (i3 & 128) == 0 ? str3 : "");
    }
}
