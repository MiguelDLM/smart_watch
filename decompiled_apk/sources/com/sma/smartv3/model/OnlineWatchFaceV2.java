package com.sma.smartv3.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.io.Serializable;
import java.util.Arrays;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class OnlineWatchFaceV2 extends JsonFieldContainer implements Serializable {

    @OOXIXo
    private final String typeCssClass;

    @OOXIXo
    private final String typeId;

    @OOXIXo
    private final String typeName;

    @oOoXoXO
    private final WatchFaceCategoryV2[] watchFaceList;

    public /* synthetic */ OnlineWatchFaceV2(String str, String str2, String str3, WatchFaceCategoryV2[] watchFaceCategoryV2Arr, int i, IIXOooo iIXOooo) {
        this((i & 1) != 0 ? "0" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, watchFaceCategoryV2Arr);
    }

    public static /* synthetic */ OnlineWatchFaceV2 copy$default(OnlineWatchFaceV2 onlineWatchFaceV2, String str, String str2, String str3, WatchFaceCategoryV2[] watchFaceCategoryV2Arr, int i, Object obj) {
        if ((i & 1) != 0) {
            str = onlineWatchFaceV2.typeId;
        }
        if ((i & 2) != 0) {
            str2 = onlineWatchFaceV2.typeName;
        }
        if ((i & 4) != 0) {
            str3 = onlineWatchFaceV2.typeCssClass;
        }
        if ((i & 8) != 0) {
            watchFaceCategoryV2Arr = onlineWatchFaceV2.watchFaceList;
        }
        return onlineWatchFaceV2.copy(str, str2, str3, watchFaceCategoryV2Arr);
    }

    @OOXIXo
    public final String component1() {
        return this.typeId;
    }

    @OOXIXo
    public final String component2() {
        return this.typeName;
    }

    @OOXIXo
    public final String component3() {
        return this.typeCssClass;
    }

    @oOoXoXO
    public final WatchFaceCategoryV2[] component4() {
        return this.watchFaceList;
    }

    @OOXIXo
    public final OnlineWatchFaceV2 copy(@OOXIXo String typeId, @OOXIXo String typeName, @OOXIXo String typeCssClass, @oOoXoXO WatchFaceCategoryV2[] watchFaceCategoryV2Arr) {
        IIX0o.x0xO0oo(typeId, "typeId");
        IIX0o.x0xO0oo(typeName, "typeName");
        IIX0o.x0xO0oo(typeCssClass, "typeCssClass");
        return new OnlineWatchFaceV2(typeId, typeName, typeCssClass, watchFaceCategoryV2Arr);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OnlineWatchFaceV2)) {
            return false;
        }
        OnlineWatchFaceV2 onlineWatchFaceV2 = (OnlineWatchFaceV2) obj;
        return IIX0o.Oxx0IOOO(this.typeId, onlineWatchFaceV2.typeId) && IIX0o.Oxx0IOOO(this.typeName, onlineWatchFaceV2.typeName) && IIX0o.Oxx0IOOO(this.typeCssClass, onlineWatchFaceV2.typeCssClass) && IIX0o.Oxx0IOOO(this.watchFaceList, onlineWatchFaceV2.watchFaceList);
    }

    @OOXIXo
    public final String getTypeCssClass() {
        return this.typeCssClass;
    }

    @OOXIXo
    public final String getTypeId() {
        return this.typeId;
    }

    @OOXIXo
    public final String getTypeName() {
        return this.typeName;
    }

    @oOoXoXO
    public final WatchFaceCategoryV2[] getWatchFaceList() {
        return this.watchFaceList;
    }

    public int hashCode() {
        int hashCode = ((((this.typeId.hashCode() * 31) + this.typeName.hashCode()) * 31) + this.typeCssClass.hashCode()) * 31;
        WatchFaceCategoryV2[] watchFaceCategoryV2Arr = this.watchFaceList;
        return hashCode + (watchFaceCategoryV2Arr == null ? 0 : Arrays.hashCode(watchFaceCategoryV2Arr));
    }

    @OOXIXo
    public String toString() {
        return "OnlineWatchFaceV2(typeId=" + this.typeId + ", typeName=" + this.typeName + ", typeCssClass=" + this.typeCssClass + ", watchFaceList=" + Arrays.toString(this.watchFaceList) + HexStringBuilder.COMMENT_END_CHAR;
    }

    public OnlineWatchFaceV2(@OOXIXo String typeId, @OOXIXo String typeName, @OOXIXo String typeCssClass, @oOoXoXO WatchFaceCategoryV2[] watchFaceCategoryV2Arr) {
        IIX0o.x0xO0oo(typeId, "typeId");
        IIX0o.x0xO0oo(typeName, "typeName");
        IIX0o.x0xO0oo(typeCssClass, "typeCssClass");
        this.typeId = typeId;
        this.typeName = typeName;
        this.typeCssClass = typeCssClass;
        this.watchFaceList = watchFaceCategoryV2Arr;
    }
}
