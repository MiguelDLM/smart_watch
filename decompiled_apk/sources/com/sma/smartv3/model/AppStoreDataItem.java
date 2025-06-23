package com.sma.smartv3.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.szabh.smable3.entity.BleAppInfo;
import java.io.Serializable;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class AppStoreDataItem implements Serializable {
    private int appStoreType;

    @OOXIXo
    private String binOnlinePath;

    @OOXIXo
    private final BleAppInfo bleAppInfo;
    private final int id;
    private boolean isShowNewFlag;

    @OOXIXo
    private final String onlinePath;
    private final int path;

    public AppStoreDataItem() {
        this(0, null, 0, null, null, false, 0, 127, null);
    }

    public static /* synthetic */ AppStoreDataItem copy$default(AppStoreDataItem appStoreDataItem, int i, BleAppInfo bleAppInfo, int i2, String str, String str2, boolean z, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = appStoreDataItem.id;
        }
        if ((i4 & 2) != 0) {
            bleAppInfo = appStoreDataItem.bleAppInfo;
        }
        BleAppInfo bleAppInfo2 = bleAppInfo;
        if ((i4 & 4) != 0) {
            i2 = appStoreDataItem.path;
        }
        int i5 = i2;
        if ((i4 & 8) != 0) {
            str = appStoreDataItem.onlinePath;
        }
        String str3 = str;
        if ((i4 & 16) != 0) {
            str2 = appStoreDataItem.binOnlinePath;
        }
        String str4 = str2;
        if ((i4 & 32) != 0) {
            z = appStoreDataItem.isShowNewFlag;
        }
        boolean z2 = z;
        if ((i4 & 64) != 0) {
            i3 = appStoreDataItem.appStoreType;
        }
        return appStoreDataItem.copy(i, bleAppInfo2, i5, str3, str4, z2, i3);
    }

    public final int component1() {
        return this.id;
    }

    @OOXIXo
    public final BleAppInfo component2() {
        return this.bleAppInfo;
    }

    public final int component3() {
        return this.path;
    }

    @OOXIXo
    public final String component4() {
        return this.onlinePath;
    }

    @OOXIXo
    public final String component5() {
        return this.binOnlinePath;
    }

    public final boolean component6() {
        return this.isShowNewFlag;
    }

    public final int component7() {
        return this.appStoreType;
    }

    @OOXIXo
    public final AppStoreDataItem copy(int i, @OOXIXo BleAppInfo bleAppInfo, int i2, @OOXIXo String onlinePath, @OOXIXo String binOnlinePath, boolean z, int i3) {
        IIX0o.x0xO0oo(bleAppInfo, "bleAppInfo");
        IIX0o.x0xO0oo(onlinePath, "onlinePath");
        IIX0o.x0xO0oo(binOnlinePath, "binOnlinePath");
        return new AppStoreDataItem(i, bleAppInfo, i2, onlinePath, binOnlinePath, z, i3);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AppStoreDataItem)) {
            return false;
        }
        AppStoreDataItem appStoreDataItem = (AppStoreDataItem) obj;
        return this.id == appStoreDataItem.id && IIX0o.Oxx0IOOO(this.bleAppInfo, appStoreDataItem.bleAppInfo) && this.path == appStoreDataItem.path && IIX0o.Oxx0IOOO(this.onlinePath, appStoreDataItem.onlinePath) && IIX0o.Oxx0IOOO(this.binOnlinePath, appStoreDataItem.binOnlinePath) && this.isShowNewFlag == appStoreDataItem.isShowNewFlag && this.appStoreType == appStoreDataItem.appStoreType;
    }

    public final int getAppStoreType() {
        return this.appStoreType;
    }

    @OOXIXo
    public final String getBinOnlinePath() {
        return this.binOnlinePath;
    }

    @OOXIXo
    public final BleAppInfo getBleAppInfo() {
        return this.bleAppInfo;
    }

    public final int getId() {
        return this.id;
    }

    @OOXIXo
    public final String getOnlinePath() {
        return this.onlinePath;
    }

    public final int getPath() {
        return this.path;
    }

    public int hashCode() {
        return (((((((((((this.id * 31) + this.bleAppInfo.hashCode()) * 31) + this.path) * 31) + this.onlinePath.hashCode()) * 31) + this.binOnlinePath.hashCode()) * 31) + androidx.work.oIX0oI.oIX0oI(this.isShowNewFlag)) * 31) + this.appStoreType;
    }

    public final boolean isShowNewFlag() {
        return this.isShowNewFlag;
    }

    public final void setAppStoreType(int i) {
        this.appStoreType = i;
    }

    public final void setBinOnlinePath(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.binOnlinePath = str;
    }

    public final void setShowNewFlag(boolean z) {
        this.isShowNewFlag = z;
    }

    @OOXIXo
    public String toString() {
        return "AppStoreDataItem(id=" + this.id + ", bleAppInfo=" + this.bleAppInfo + ", path=" + this.path + ", onlinePath=" + this.onlinePath + ", binOnlinePath=" + this.binOnlinePath + ", isShowNewFlag=" + this.isShowNewFlag + ", appStoreType=" + this.appStoreType + HexStringBuilder.COMMENT_END_CHAR;
    }

    public AppStoreDataItem(int i, @OOXIXo BleAppInfo bleAppInfo, int i2, @OOXIXo String onlinePath, @OOXIXo String binOnlinePath, boolean z, int i3) {
        IIX0o.x0xO0oo(bleAppInfo, "bleAppInfo");
        IIX0o.x0xO0oo(onlinePath, "onlinePath");
        IIX0o.x0xO0oo(binOnlinePath, "binOnlinePath");
        this.id = i;
        this.bleAppInfo = bleAppInfo;
        this.path = i2;
        this.onlinePath = onlinePath;
        this.binOnlinePath = binOnlinePath;
        this.isShowNewFlag = z;
        this.appStoreType = i3;
    }

    public /* synthetic */ AppStoreDataItem(int i, BleAppInfo bleAppInfo, int i2, String str, String str2, boolean z, int i3, int i4, IIXOooo iIXOooo) {
        this((i4 & 1) != 0 ? -1 : i, (i4 & 2) != 0 ? new BleAppInfo(null, null, null, 0, 0, 0, null, 127, null) : bleAppInfo, (i4 & 4) == 0 ? i2 : -1, (i4 & 8) != 0 ? "" : str, (i4 & 16) == 0 ? str2 : "", (i4 & 32) != 0 ? false : z, (i4 & 64) != 0 ? AppStoreItemType.INSTALL.getType() : i3);
    }
}
