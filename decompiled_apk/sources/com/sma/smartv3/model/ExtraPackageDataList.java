package com.sma.smartv3.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.util.ArrayList;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class ExtraPackageDataList extends JsonFieldContainer {

    @OOXIXo
    private ArrayList<ExtraPackageData> data;
    private int total;

    /* JADX WARN: Multi-variable type inference failed */
    public ExtraPackageDataList() {
        this(0, null, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ExtraPackageDataList copy$default(ExtraPackageDataList extraPackageDataList, int i, ArrayList arrayList, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = extraPackageDataList.total;
        }
        if ((i2 & 2) != 0) {
            arrayList = extraPackageDataList.data;
        }
        return extraPackageDataList.copy(i, arrayList);
    }

    public final int component1() {
        return this.total;
    }

    @OOXIXo
    public final ArrayList<ExtraPackageData> component2() {
        return this.data;
    }

    @OOXIXo
    public final ExtraPackageDataList copy(int i, @OOXIXo ArrayList<ExtraPackageData> data) {
        IIX0o.x0xO0oo(data, "data");
        return new ExtraPackageDataList(i, data);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ExtraPackageDataList)) {
            return false;
        }
        ExtraPackageDataList extraPackageDataList = (ExtraPackageDataList) obj;
        return this.total == extraPackageDataList.total && IIX0o.Oxx0IOOO(this.data, extraPackageDataList.data);
    }

    @OOXIXo
    public final ArrayList<ExtraPackageData> getData() {
        return this.data;
    }

    public final int getTotal() {
        return this.total;
    }

    public int hashCode() {
        return (this.total * 31) + this.data.hashCode();
    }

    public final void setData(@OOXIXo ArrayList<ExtraPackageData> arrayList) {
        IIX0o.x0xO0oo(arrayList, "<set-?>");
        this.data = arrayList;
    }

    public final void setTotal(int i) {
        this.total = i;
    }

    @OOXIXo
    public String toString() {
        return "ExtraPackageDataList(total=" + this.total + ", data=" + this.data + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ ExtraPackageDataList(int i, ArrayList arrayList, int i2, IIXOooo iIXOooo) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? new ArrayList() : arrayList);
    }

    public ExtraPackageDataList(int i, @OOXIXo ArrayList<ExtraPackageData> data) {
        IIX0o.x0xO0oo(data, "data");
        this.total = i;
        this.data = data;
    }
}
