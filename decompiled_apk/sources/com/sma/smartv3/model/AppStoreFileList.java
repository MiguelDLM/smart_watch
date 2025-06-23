package com.sma.smartv3.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.io.Serializable;
import java.util.Arrays;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class AppStoreFileList extends JsonFieldContainer implements Serializable {

    @oOoXoXO
    private final AppFileDetail[] appx;

    @OOXIXo
    private final String groupId;

    public /* synthetic */ AppStoreFileList(String str, AppFileDetail[] appFileDetailArr, int i, IIXOooo iIXOooo) {
        this((i & 1) != 0 ? "" : str, appFileDetailArr);
    }

    public static /* synthetic */ AppStoreFileList copy$default(AppStoreFileList appStoreFileList, String str, AppFileDetail[] appFileDetailArr, int i, Object obj) {
        if ((i & 1) != 0) {
            str = appStoreFileList.groupId;
        }
        if ((i & 2) != 0) {
            appFileDetailArr = appStoreFileList.appx;
        }
        return appStoreFileList.copy(str, appFileDetailArr);
    }

    @OOXIXo
    public final String component1() {
        return this.groupId;
    }

    @oOoXoXO
    public final AppFileDetail[] component2() {
        return this.appx;
    }

    @OOXIXo
    public final AppStoreFileList copy(@OOXIXo String groupId, @oOoXoXO AppFileDetail[] appFileDetailArr) {
        IIX0o.x0xO0oo(groupId, "groupId");
        return new AppStoreFileList(groupId, appFileDetailArr);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AppStoreFileList)) {
            return false;
        }
        AppStoreFileList appStoreFileList = (AppStoreFileList) obj;
        return IIX0o.Oxx0IOOO(this.groupId, appStoreFileList.groupId) && IIX0o.Oxx0IOOO(this.appx, appStoreFileList.appx);
    }

    @oOoXoXO
    public final AppFileDetail[] getAppx() {
        return this.appx;
    }

    @OOXIXo
    public final String getGroupId() {
        return this.groupId;
    }

    public int hashCode() {
        int hashCode = this.groupId.hashCode() * 31;
        AppFileDetail[] appFileDetailArr = this.appx;
        return hashCode + (appFileDetailArr == null ? 0 : Arrays.hashCode(appFileDetailArr));
    }

    @OOXIXo
    public String toString() {
        return "AppStoreFileList(groupId=" + this.groupId + ", appx=" + Arrays.toString(this.appx) + HexStringBuilder.COMMENT_END_CHAR;
    }

    public AppStoreFileList(@OOXIXo String groupId, @oOoXoXO AppFileDetail[] appFileDetailArr) {
        IIX0o.x0xO0oo(groupId, "groupId");
        this.groupId = groupId;
        this.appx = appFileDetailArr;
    }
}
