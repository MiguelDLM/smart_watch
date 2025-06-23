package com.sma.smartv3.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.util.ArrayList;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class FirmwareVersionList extends JsonFieldContainer {

    @OOXIXo
    private ArrayList<FirmwareVersion> data;
    private int total;

    /* JADX WARN: Multi-variable type inference failed */
    public FirmwareVersionList() {
        this(0, null, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FirmwareVersionList copy$default(FirmwareVersionList firmwareVersionList, int i, ArrayList arrayList, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = firmwareVersionList.total;
        }
        if ((i2 & 2) != 0) {
            arrayList = firmwareVersionList.data;
        }
        return firmwareVersionList.copy(i, arrayList);
    }

    public final int component1() {
        return this.total;
    }

    @OOXIXo
    public final ArrayList<FirmwareVersion> component2() {
        return this.data;
    }

    @OOXIXo
    public final FirmwareVersionList copy(int i, @OOXIXo ArrayList<FirmwareVersion> data) {
        IIX0o.x0xO0oo(data, "data");
        return new FirmwareVersionList(i, data);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FirmwareVersionList)) {
            return false;
        }
        FirmwareVersionList firmwareVersionList = (FirmwareVersionList) obj;
        return this.total == firmwareVersionList.total && IIX0o.Oxx0IOOO(this.data, firmwareVersionList.data);
    }

    @OOXIXo
    public final ArrayList<FirmwareVersion> getData() {
        return this.data;
    }

    public final int getTotal() {
        return this.total;
    }

    public int hashCode() {
        return (this.total * 31) + this.data.hashCode();
    }

    public final void setData(@OOXIXo ArrayList<FirmwareVersion> arrayList) {
        IIX0o.x0xO0oo(arrayList, "<set-?>");
        this.data = arrayList;
    }

    public final void setTotal(int i) {
        this.total = i;
    }

    @OOXIXo
    public String toString() {
        return "FirmwareVersionList(total=" + this.total + ", data=" + this.data + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ FirmwareVersionList(int i, ArrayList arrayList, int i2, IIXOooo iIXOooo) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? new ArrayList() : arrayList);
    }

    public FirmwareVersionList(int i, @OOXIXo ArrayList<FirmwareVersion> data) {
        IIX0o.x0xO0oo(data, "data");
        this.total = i;
        this.data = data;
    }
}
