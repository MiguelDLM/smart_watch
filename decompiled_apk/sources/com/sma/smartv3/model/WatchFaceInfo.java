package com.sma.smartv3.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.io.Serializable;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class WatchFaceInfo extends JsonFieldContainer implements Serializable {

    @OOXIXo
    private final String binPath;
    private final int id;

    @OOXIXo
    private final String previewPath;

    public WatchFaceInfo(int i, @OOXIXo String previewPath, @OOXIXo String binPath) {
        IIX0o.x0xO0oo(previewPath, "previewPath");
        IIX0o.x0xO0oo(binPath, "binPath");
        this.id = i;
        this.previewPath = previewPath;
        this.binPath = binPath;
    }

    public static /* synthetic */ WatchFaceInfo copy$default(WatchFaceInfo watchFaceInfo, int i, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = watchFaceInfo.id;
        }
        if ((i2 & 2) != 0) {
            str = watchFaceInfo.previewPath;
        }
        if ((i2 & 4) != 0) {
            str2 = watchFaceInfo.binPath;
        }
        return watchFaceInfo.copy(i, str, str2);
    }

    public final int component1() {
        return this.id;
    }

    @OOXIXo
    public final String component2() {
        return this.previewPath;
    }

    @OOXIXo
    public final String component3() {
        return this.binPath;
    }

    @OOXIXo
    public final WatchFaceInfo copy(int i, @OOXIXo String previewPath, @OOXIXo String binPath) {
        IIX0o.x0xO0oo(previewPath, "previewPath");
        IIX0o.x0xO0oo(binPath, "binPath");
        return new WatchFaceInfo(i, previewPath, binPath);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WatchFaceInfo)) {
            return false;
        }
        WatchFaceInfo watchFaceInfo = (WatchFaceInfo) obj;
        return this.id == watchFaceInfo.id && IIX0o.Oxx0IOOO(this.previewPath, watchFaceInfo.previewPath) && IIX0o.Oxx0IOOO(this.binPath, watchFaceInfo.binPath);
    }

    @OOXIXo
    public final String getBinPath() {
        return this.binPath;
    }

    public final int getId() {
        return this.id;
    }

    @OOXIXo
    public final String getPreviewPath() {
        return this.previewPath;
    }

    public int hashCode() {
        return (((this.id * 31) + this.previewPath.hashCode()) * 31) + this.binPath.hashCode();
    }

    @OOXIXo
    public String toString() {
        return "WatchFaceInfo(id=" + this.id + ", previewPath=" + this.previewPath + ", binPath=" + this.binPath + HexStringBuilder.COMMENT_END_CHAR;
    }
}
