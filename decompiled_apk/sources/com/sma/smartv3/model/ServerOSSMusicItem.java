package com.sma.smartv3.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.io.Serializable;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class ServerOSSMusicItem implements Serializable {
    private final int isdir;

    @OOXIXo
    private final String path;

    @OOXIXo
    private final String title;

    public ServerOSSMusicItem() {
        this(null, null, 0, 7, null);
    }

    public static /* synthetic */ ServerOSSMusicItem copy$default(ServerOSSMusicItem serverOSSMusicItem, String str, String str2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = serverOSSMusicItem.path;
        }
        if ((i2 & 2) != 0) {
            str2 = serverOSSMusicItem.title;
        }
        if ((i2 & 4) != 0) {
            i = serverOSSMusicItem.isdir;
        }
        return serverOSSMusicItem.copy(str, str2, i);
    }

    @OOXIXo
    public final String component1() {
        return this.path;
    }

    @OOXIXo
    public final String component2() {
        return this.title;
    }

    public final int component3() {
        return this.isdir;
    }

    @OOXIXo
    public final ServerOSSMusicItem copy(@OOXIXo String path, @OOXIXo String title, int i) {
        IIX0o.x0xO0oo(path, "path");
        IIX0o.x0xO0oo(title, "title");
        return new ServerOSSMusicItem(path, title, i);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ServerOSSMusicItem)) {
            return false;
        }
        ServerOSSMusicItem serverOSSMusicItem = (ServerOSSMusicItem) obj;
        return IIX0o.Oxx0IOOO(this.path, serverOSSMusicItem.path) && IIX0o.Oxx0IOOO(this.title, serverOSSMusicItem.title) && this.isdir == serverOSSMusicItem.isdir;
    }

    public final int getIsdir() {
        return this.isdir;
    }

    @OOXIXo
    public final String getPath() {
        return this.path;
    }

    @OOXIXo
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return (((this.path.hashCode() * 31) + this.title.hashCode()) * 31) + this.isdir;
    }

    @OOXIXo
    public String toString() {
        return "ServerOSSMusicItem(path=" + this.path + ", title=" + this.title + ", isdir=" + this.isdir + HexStringBuilder.COMMENT_END_CHAR;
    }

    public ServerOSSMusicItem(@OOXIXo String path, @OOXIXo String title, int i) {
        IIX0o.x0xO0oo(path, "path");
        IIX0o.x0xO0oo(title, "title");
        this.path = path;
        this.title = title;
        this.isdir = i;
    }

    public /* synthetic */ ServerOSSMusicItem(String str, String str2, int i, int i2, IIXOooo iIXOooo) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? 0 : i);
    }
}
