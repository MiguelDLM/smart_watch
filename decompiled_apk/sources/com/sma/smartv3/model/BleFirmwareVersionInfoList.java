package com.sma.smartv3.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.util.ArrayList;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class BleFirmwareVersionInfoList extends JsonFieldContainer {

    @OOXIXo
    private ArrayList<BleFirmwareInfo> data;
    private int total;

    /* JADX WARN: Multi-variable type inference failed */
    public BleFirmwareVersionInfoList() {
        this(0, null, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BleFirmwareVersionInfoList copy$default(BleFirmwareVersionInfoList bleFirmwareVersionInfoList, int i, ArrayList arrayList, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = bleFirmwareVersionInfoList.total;
        }
        if ((i2 & 2) != 0) {
            arrayList = bleFirmwareVersionInfoList.data;
        }
        return bleFirmwareVersionInfoList.copy(i, arrayList);
    }

    public final int component1() {
        return this.total;
    }

    @OOXIXo
    public final ArrayList<BleFirmwareInfo> component2() {
        return this.data;
    }

    @OOXIXo
    public final BleFirmwareVersionInfoList copy(int i, @OOXIXo ArrayList<BleFirmwareInfo> data) {
        IIX0o.x0xO0oo(data, "data");
        return new BleFirmwareVersionInfoList(i, data);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleFirmwareVersionInfoList)) {
            return false;
        }
        BleFirmwareVersionInfoList bleFirmwareVersionInfoList = (BleFirmwareVersionInfoList) obj;
        return this.total == bleFirmwareVersionInfoList.total && IIX0o.Oxx0IOOO(this.data, bleFirmwareVersionInfoList.data);
    }

    @OOXIXo
    public final ArrayList<BleFirmwareInfo> getData() {
        return this.data;
    }

    public final int getTotal() {
        return this.total;
    }

    public int hashCode() {
        return (this.total * 31) + this.data.hashCode();
    }

    public final void setData(@OOXIXo ArrayList<BleFirmwareInfo> arrayList) {
        IIX0o.x0xO0oo(arrayList, "<set-?>");
        this.data = arrayList;
    }

    public final void setTotal(int i) {
        this.total = i;
    }

    @OOXIXo
    public String toString() {
        return "BleFirmwareVersionInfoList(total=" + this.total + ", data=" + this.data + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleFirmwareVersionInfoList(int i, ArrayList arrayList, int i2, IIXOooo iIXOooo) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? new ArrayList() : arrayList);
    }

    public BleFirmwareVersionInfoList(int i, @OOXIXo ArrayList<BleFirmwareInfo> data) {
        IIX0o.x0xO0oo(data, "data");
        this.total = i;
        this.data = data;
    }
}
