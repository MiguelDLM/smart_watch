package com.sma.smartv3.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.io.Serializable;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class WatchFaceBanner extends JsonFieldContainer implements Serializable {

    @OOXIXo
    private final String id;
    private final int slideEleId;

    @OOXIXo
    private final String slidePath;

    @OOXIXo
    private final String slideType;

    public WatchFaceBanner() {
        this(null, null, 0, null, 15, null);
    }

    public static /* synthetic */ WatchFaceBanner copy$default(WatchFaceBanner watchFaceBanner, String str, String str2, int i, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = watchFaceBanner.slidePath;
        }
        if ((i2 & 2) != 0) {
            str2 = watchFaceBanner.slideType;
        }
        if ((i2 & 4) != 0) {
            i = watchFaceBanner.slideEleId;
        }
        if ((i2 & 8) != 0) {
            str3 = watchFaceBanner.id;
        }
        return watchFaceBanner.copy(str, str2, i, str3);
    }

    @OOXIXo
    public final String component1() {
        return this.slidePath;
    }

    @OOXIXo
    public final String component2() {
        return this.slideType;
    }

    public final int component3() {
        return this.slideEleId;
    }

    @OOXIXo
    public final String component4() {
        return this.id;
    }

    @OOXIXo
    public final WatchFaceBanner copy(@OOXIXo String slidePath, @OOXIXo String slideType, int i, @OOXIXo String id) {
        IIX0o.x0xO0oo(slidePath, "slidePath");
        IIX0o.x0xO0oo(slideType, "slideType");
        IIX0o.x0xO0oo(id, "id");
        return new WatchFaceBanner(slidePath, slideType, i, id);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WatchFaceBanner)) {
            return false;
        }
        WatchFaceBanner watchFaceBanner = (WatchFaceBanner) obj;
        return IIX0o.Oxx0IOOO(this.slidePath, watchFaceBanner.slidePath) && IIX0o.Oxx0IOOO(this.slideType, watchFaceBanner.slideType) && this.slideEleId == watchFaceBanner.slideEleId && IIX0o.Oxx0IOOO(this.id, watchFaceBanner.id);
    }

    @OOXIXo
    public final String getId() {
        return this.id;
    }

    public final int getSlideEleId() {
        return this.slideEleId;
    }

    @OOXIXo
    public final String getSlidePath() {
        return this.slidePath;
    }

    @OOXIXo
    public final String getSlideType() {
        return this.slideType;
    }

    public int hashCode() {
        return (((((this.slidePath.hashCode() * 31) + this.slideType.hashCode()) * 31) + this.slideEleId) * 31) + this.id.hashCode();
    }

    @OOXIXo
    public String toString() {
        return "WatchFaceBanner(slidePath=" + this.slidePath + ", slideType=" + this.slideType + ", slideEleId=" + this.slideEleId + ", id=" + this.id + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ WatchFaceBanner(String str, String str2, int i, String str3, int i2, IIXOooo iIXOooo) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? 0 : i, (i2 & 8) != 0 ? "" : str3);
    }

    public WatchFaceBanner(@OOXIXo String slidePath, @OOXIXo String slideType, int i, @OOXIXo String id) {
        IIX0o.x0xO0oo(slidePath, "slidePath");
        IIX0o.x0xO0oo(slideType, "slideType");
        IIX0o.x0xO0oo(id, "id");
        this.slidePath = slidePath;
        this.slideType = slideType;
        this.slideEleId = i;
        this.id = id;
    }
}
