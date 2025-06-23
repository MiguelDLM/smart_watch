package com.sma.smartv3.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.io.Serializable;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class WatchFaceInstallRecord extends JsonFieldContainer implements Serializable {

    @OOXIXo
    private final String createdAt;
    private final int id;

    @OOXIXo
    private final String updateAt;
    private final int userId;

    @oOoXoXO
    private final WatchFaceCategoryV2 watchFace;

    public /* synthetic */ WatchFaceInstallRecord(int i, WatchFaceCategoryV2 watchFaceCategoryV2, int i2, String str, String str2, int i3, IIXOooo iIXOooo) {
        this((i3 & 1) != 0 ? 0 : i, watchFaceCategoryV2, (i3 & 4) != 0 ? 0 : i2, (i3 & 8) != 0 ? "" : str, (i3 & 16) != 0 ? "" : str2);
    }

    public static /* synthetic */ WatchFaceInstallRecord copy$default(WatchFaceInstallRecord watchFaceInstallRecord, int i, WatchFaceCategoryV2 watchFaceCategoryV2, int i2, String str, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = watchFaceInstallRecord.userId;
        }
        if ((i3 & 2) != 0) {
            watchFaceCategoryV2 = watchFaceInstallRecord.watchFace;
        }
        WatchFaceCategoryV2 watchFaceCategoryV22 = watchFaceCategoryV2;
        if ((i3 & 4) != 0) {
            i2 = watchFaceInstallRecord.id;
        }
        int i4 = i2;
        if ((i3 & 8) != 0) {
            str = watchFaceInstallRecord.createdAt;
        }
        String str3 = str;
        if ((i3 & 16) != 0) {
            str2 = watchFaceInstallRecord.updateAt;
        }
        return watchFaceInstallRecord.copy(i, watchFaceCategoryV22, i4, str3, str2);
    }

    public final int component1() {
        return this.userId;
    }

    @oOoXoXO
    public final WatchFaceCategoryV2 component2() {
        return this.watchFace;
    }

    public final int component3() {
        return this.id;
    }

    @OOXIXo
    public final String component4() {
        return this.createdAt;
    }

    @OOXIXo
    public final String component5() {
        return this.updateAt;
    }

    @OOXIXo
    public final WatchFaceInstallRecord copy(int i, @oOoXoXO WatchFaceCategoryV2 watchFaceCategoryV2, int i2, @OOXIXo String createdAt, @OOXIXo String updateAt) {
        IIX0o.x0xO0oo(createdAt, "createdAt");
        IIX0o.x0xO0oo(updateAt, "updateAt");
        return new WatchFaceInstallRecord(i, watchFaceCategoryV2, i2, createdAt, updateAt);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WatchFaceInstallRecord)) {
            return false;
        }
        WatchFaceInstallRecord watchFaceInstallRecord = (WatchFaceInstallRecord) obj;
        return this.userId == watchFaceInstallRecord.userId && IIX0o.Oxx0IOOO(this.watchFace, watchFaceInstallRecord.watchFace) && this.id == watchFaceInstallRecord.id && IIX0o.Oxx0IOOO(this.createdAt, watchFaceInstallRecord.createdAt) && IIX0o.Oxx0IOOO(this.updateAt, watchFaceInstallRecord.updateAt);
    }

    @OOXIXo
    public final String getCreatedAt() {
        return this.createdAt;
    }

    public final int getId() {
        return this.id;
    }

    @OOXIXo
    public final String getUpdateAt() {
        return this.updateAt;
    }

    public final int getUserId() {
        return this.userId;
    }

    @oOoXoXO
    public final WatchFaceCategoryV2 getWatchFace() {
        return this.watchFace;
    }

    public int hashCode() {
        int i = this.userId * 31;
        WatchFaceCategoryV2 watchFaceCategoryV2 = this.watchFace;
        return ((((((i + (watchFaceCategoryV2 == null ? 0 : watchFaceCategoryV2.hashCode())) * 31) + this.id) * 31) + this.createdAt.hashCode()) * 31) + this.updateAt.hashCode();
    }

    @OOXIXo
    public String toString() {
        return "WatchFaceInstallRecord(userId=" + this.userId + ", watchFace=" + this.watchFace + ", id=" + this.id + ", createdAt=" + this.createdAt + ", updateAt=" + this.updateAt + HexStringBuilder.COMMENT_END_CHAR;
    }

    public WatchFaceInstallRecord(int i, @oOoXoXO WatchFaceCategoryV2 watchFaceCategoryV2, int i2, @OOXIXo String createdAt, @OOXIXo String updateAt) {
        IIX0o.x0xO0oo(createdAt, "createdAt");
        IIX0o.x0xO0oo(updateAt, "updateAt");
        this.userId = i;
        this.watchFace = watchFaceCategoryV2;
        this.id = i2;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }
}
