package com.sma.smartv3.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.io.Serializable;
import java.util.Arrays;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class OnlineWatchFace extends JsonFieldContainer implements Serializable {

    @oOoXoXO
    private final WatchFaceCategory[] categorys;

    @OOXIXo
    private final String time;
    private final int total;

    public OnlineWatchFace(int i, @OOXIXo String time, @oOoXoXO WatchFaceCategory[] watchFaceCategoryArr) {
        IIX0o.x0xO0oo(time, "time");
        this.total = i;
        this.time = time;
        this.categorys = watchFaceCategoryArr;
    }

    public static /* synthetic */ OnlineWatchFace copy$default(OnlineWatchFace onlineWatchFace, int i, String str, WatchFaceCategory[] watchFaceCategoryArr, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = onlineWatchFace.total;
        }
        if ((i2 & 2) != 0) {
            str = onlineWatchFace.time;
        }
        if ((i2 & 4) != 0) {
            watchFaceCategoryArr = onlineWatchFace.categorys;
        }
        return onlineWatchFace.copy(i, str, watchFaceCategoryArr);
    }

    public final int component1() {
        return this.total;
    }

    @OOXIXo
    public final String component2() {
        return this.time;
    }

    @oOoXoXO
    public final WatchFaceCategory[] component3() {
        return this.categorys;
    }

    @OOXIXo
    public final OnlineWatchFace copy(int i, @OOXIXo String time, @oOoXoXO WatchFaceCategory[] watchFaceCategoryArr) {
        IIX0o.x0xO0oo(time, "time");
        return new OnlineWatchFace(i, time, watchFaceCategoryArr);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OnlineWatchFace)) {
            return false;
        }
        OnlineWatchFace onlineWatchFace = (OnlineWatchFace) obj;
        return this.total == onlineWatchFace.total && IIX0o.Oxx0IOOO(this.time, onlineWatchFace.time) && IIX0o.Oxx0IOOO(this.categorys, onlineWatchFace.categorys);
    }

    @oOoXoXO
    public final WatchFaceCategory[] getCategorys() {
        return this.categorys;
    }

    @OOXIXo
    public final String getTime() {
        return this.time;
    }

    public final int getTotal() {
        return this.total;
    }

    public int hashCode() {
        int hashCode = ((this.total * 31) + this.time.hashCode()) * 31;
        WatchFaceCategory[] watchFaceCategoryArr = this.categorys;
        return hashCode + (watchFaceCategoryArr == null ? 0 : Arrays.hashCode(watchFaceCategoryArr));
    }

    @OOXIXo
    public String toString() {
        return "OnlineWatchFace(total=" + this.total + ", time=" + this.time + ", categorys=" + Arrays.toString(this.categorys) + HexStringBuilder.COMMENT_END_CHAR;
    }
}
