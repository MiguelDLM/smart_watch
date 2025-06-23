package com.sma.smartv3.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.io.Serializable;
import java.util.Arrays;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class WatchFaceCategory extends JsonFieldContainer implements Serializable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int TYPE_BUSINESS = 3;
    public static final int TYPE_CUSTOM = 100;
    public static final int TYPE_DYNAMIC = 1;
    public static final int TYPE_EXERCISE = 2;
    public static final int TYPE_ILLUSTRATION = 6;
    public static final int TYPE_MACHINERY = 4;
    public static final int TYPE_OTHER = 0;
    public static final int TYPE_SIMPLE = 5;

    @OOXIXo
    private final String dir;

    @OOXIXo
    private WatchFaceInfo[] list;
    private final int total;
    private final int type;

    /* loaded from: classes12.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public WatchFaceCategory(int i, @OOXIXo String dir, int i2, @OOXIXo WatchFaceInfo[] list) {
        IIX0o.x0xO0oo(dir, "dir");
        IIX0o.x0xO0oo(list, "list");
        this.type = i;
        this.dir = dir;
        this.total = i2;
        this.list = list;
    }

    public static /* synthetic */ WatchFaceCategory copy$default(WatchFaceCategory watchFaceCategory, int i, String str, int i2, WatchFaceInfo[] watchFaceInfoArr, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = watchFaceCategory.type;
        }
        if ((i3 & 2) != 0) {
            str = watchFaceCategory.dir;
        }
        if ((i3 & 4) != 0) {
            i2 = watchFaceCategory.total;
        }
        if ((i3 & 8) != 0) {
            watchFaceInfoArr = watchFaceCategory.list;
        }
        return watchFaceCategory.copy(i, str, i2, watchFaceInfoArr);
    }

    public final int component1() {
        return this.type;
    }

    @OOXIXo
    public final String component2() {
        return this.dir;
    }

    public final int component3() {
        return this.total;
    }

    @OOXIXo
    public final WatchFaceInfo[] component4() {
        return this.list;
    }

    @OOXIXo
    public final WatchFaceCategory copy(int i, @OOXIXo String dir, int i2, @OOXIXo WatchFaceInfo[] list) {
        IIX0o.x0xO0oo(dir, "dir");
        IIX0o.x0xO0oo(list, "list");
        return new WatchFaceCategory(i, dir, i2, list);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WatchFaceCategory)) {
            return false;
        }
        WatchFaceCategory watchFaceCategory = (WatchFaceCategory) obj;
        return this.type == watchFaceCategory.type && IIX0o.Oxx0IOOO(this.dir, watchFaceCategory.dir) && this.total == watchFaceCategory.total && IIX0o.Oxx0IOOO(this.list, watchFaceCategory.list);
    }

    @OOXIXo
    public final String getDir() {
        return this.dir;
    }

    @OOXIXo
    public final WatchFaceInfo[] getList() {
        return this.list;
    }

    public final int getTotal() {
        return this.total;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        return (((((this.type * 31) + this.dir.hashCode()) * 31) + this.total) * 31) + Arrays.hashCode(this.list);
    }

    public final void setList(@OOXIXo WatchFaceInfo[] watchFaceInfoArr) {
        IIX0o.x0xO0oo(watchFaceInfoArr, "<set-?>");
        this.list = watchFaceInfoArr;
    }

    @OOXIXo
    public String toString() {
        return "WatchFaceCategory(type=" + this.type + ", dir=" + this.dir + ", total=" + this.total + ", list=" + Arrays.toString(this.list) + HexStringBuilder.COMMENT_END_CHAR;
    }
}
