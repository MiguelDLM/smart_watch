package com.sma.smartv3.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class AppStoreItemList implements Serializable {
    private boolean isShowAll;

    @OOXIXo
    private final List<AppStoreDataItem> list;

    @OOXIXo
    private final String typeName;

    public AppStoreItemList() {
        this(null, null, false, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AppStoreItemList copy$default(AppStoreItemList appStoreItemList, String str, List list, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = appStoreItemList.typeName;
        }
        if ((i & 2) != 0) {
            list = appStoreItemList.list;
        }
        if ((i & 4) != 0) {
            z = appStoreItemList.isShowAll;
        }
        return appStoreItemList.copy(str, list, z);
    }

    @OOXIXo
    public final String component1() {
        return this.typeName;
    }

    @OOXIXo
    public final List<AppStoreDataItem> component2() {
        return this.list;
    }

    public final boolean component3() {
        return this.isShowAll;
    }

    @OOXIXo
    public final AppStoreItemList copy(@OOXIXo String typeName, @OOXIXo List<AppStoreDataItem> list, boolean z) {
        IIX0o.x0xO0oo(typeName, "typeName");
        IIX0o.x0xO0oo(list, "list");
        return new AppStoreItemList(typeName, list, z);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AppStoreItemList)) {
            return false;
        }
        AppStoreItemList appStoreItemList = (AppStoreItemList) obj;
        return IIX0o.Oxx0IOOO(this.typeName, appStoreItemList.typeName) && IIX0o.Oxx0IOOO(this.list, appStoreItemList.list) && this.isShowAll == appStoreItemList.isShowAll;
    }

    @OOXIXo
    public final List<AppStoreDataItem> getList() {
        return this.list;
    }

    @OOXIXo
    public final String getTypeName() {
        return this.typeName;
    }

    public int hashCode() {
        return (((this.typeName.hashCode() * 31) + this.list.hashCode()) * 31) + androidx.work.oIX0oI.oIX0oI(this.isShowAll);
    }

    public final boolean isShowAll() {
        return this.isShowAll;
    }

    public final void setShowAll(boolean z) {
        this.isShowAll = z;
    }

    @OOXIXo
    public String toString() {
        return "AppStoreItemList(typeName=" + this.typeName + ", list=" + this.list + ", isShowAll=" + this.isShowAll + HexStringBuilder.COMMENT_END_CHAR;
    }

    public AppStoreItemList(@OOXIXo String typeName, @OOXIXo List<AppStoreDataItem> list, boolean z) {
        IIX0o.x0xO0oo(typeName, "typeName");
        IIX0o.x0xO0oo(list, "list");
        this.typeName = typeName;
        this.list = list;
        this.isShowAll = z;
    }

    public /* synthetic */ AppStoreItemList(String str, List list, boolean z, int i, IIXOooo iIXOooo) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? new ArrayList() : list, (i & 4) != 0 ? false : z);
    }
}
