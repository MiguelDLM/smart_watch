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
public final class LearnCardItemList implements Serializable {
    private boolean isAllChoose;

    @OOXIXo
    private final List<LearnCardDataItem> list;

    @OOXIXo
    private final String typeName;

    public LearnCardItemList() {
        this(null, null, false, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LearnCardItemList copy$default(LearnCardItemList learnCardItemList, String str, List list, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = learnCardItemList.typeName;
        }
        if ((i & 2) != 0) {
            list = learnCardItemList.list;
        }
        if ((i & 4) != 0) {
            z = learnCardItemList.isAllChoose;
        }
        return learnCardItemList.copy(str, list, z);
    }

    @OOXIXo
    public final String component1() {
        return this.typeName;
    }

    @OOXIXo
    public final List<LearnCardDataItem> component2() {
        return this.list;
    }

    public final boolean component3() {
        return this.isAllChoose;
    }

    @OOXIXo
    public final LearnCardItemList copy(@OOXIXo String typeName, @OOXIXo List<LearnCardDataItem> list, boolean z) {
        IIX0o.x0xO0oo(typeName, "typeName");
        IIX0o.x0xO0oo(list, "list");
        return new LearnCardItemList(typeName, list, z);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LearnCardItemList)) {
            return false;
        }
        LearnCardItemList learnCardItemList = (LearnCardItemList) obj;
        return IIX0o.Oxx0IOOO(this.typeName, learnCardItemList.typeName) && IIX0o.Oxx0IOOO(this.list, learnCardItemList.list) && this.isAllChoose == learnCardItemList.isAllChoose;
    }

    @OOXIXo
    public final List<LearnCardDataItem> getList() {
        return this.list;
    }

    @OOXIXo
    public final String getTypeName() {
        return this.typeName;
    }

    public int hashCode() {
        return (((this.typeName.hashCode() * 31) + this.list.hashCode()) * 31) + androidx.work.oIX0oI.oIX0oI(this.isAllChoose);
    }

    public final boolean isAllChoose() {
        return this.isAllChoose;
    }

    public final void setAllChoose(boolean z) {
        this.isAllChoose = z;
    }

    @OOXIXo
    public String toString() {
        return "LearnCardItemList(typeName=" + this.typeName + ", list=" + this.list + ", isAllChoose=" + this.isAllChoose + HexStringBuilder.COMMENT_END_CHAR;
    }

    public LearnCardItemList(@OOXIXo String typeName, @OOXIXo List<LearnCardDataItem> list, boolean z) {
        IIX0o.x0xO0oo(typeName, "typeName");
        IIX0o.x0xO0oo(list, "list");
        this.typeName = typeName;
        this.list = list;
        this.isAllChoose = z;
    }

    public /* synthetic */ LearnCardItemList(String str, List list, boolean z, int i, IIXOooo iIXOooo) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? new ArrayList() : list, (i & 4) != 0 ? false : z);
    }
}
