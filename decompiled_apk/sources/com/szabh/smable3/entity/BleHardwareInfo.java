package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleReadable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BleHardwareInfo extends BleReadable {

    @OOXIXo
    private List<BleHardwareDevice> mDeviceTypeList;

    /* JADX WARN: Multi-variable type inference failed */
    public BleHardwareInfo() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BleHardwareInfo copy$default(BleHardwareInfo bleHardwareInfo, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = bleHardwareInfo.mDeviceTypeList;
        }
        return bleHardwareInfo.copy(list);
    }

    @OOXIXo
    public final List<BleHardwareDevice> component1() {
        return this.mDeviceTypeList;
    }

    @OOXIXo
    public final BleHardwareInfo copy(@OOXIXo List<BleHardwareDevice> mDeviceTypeList) {
        IIX0o.x0xO0oo(mDeviceTypeList, "mDeviceTypeList");
        return new BleHardwareInfo(mDeviceTypeList);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        try {
            char readUInt8 = readUInt8();
            if (readUInt8 <= 0) {
                return;
            }
            do {
                this.mDeviceTypeList.add(new BleHardwareDevice(readUInt8, readUInt8(), readUInt8(), readBytes(readUInt8 - 2)));
                readUInt8 = readUInt8();
            } while (readUInt8 > 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof BleHardwareInfo) && IIX0o.Oxx0IOOO(this.mDeviceTypeList, ((BleHardwareInfo) obj).mDeviceTypeList);
    }

    @OOXIXo
    public final List<BleHardwareDevice> getMDeviceTypeList() {
        return this.mDeviceTypeList;
    }

    public int hashCode() {
        return this.mDeviceTypeList.hashCode();
    }

    public final void setMDeviceTypeList(@OOXIXo List<BleHardwareDevice> list) {
        IIX0o.x0xO0oo(list, "<set-?>");
        this.mDeviceTypeList = list;
    }

    @OOXIXo
    public String toString() {
        return "BleHardwareInfo(mDeviceTypeList=" + this.mDeviceTypeList + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleHardwareInfo(List list, int i, IIXOooo iIXOooo) {
        this((i & 1) != 0 ? new ArrayList() : list);
    }

    public BleHardwareInfo(@OOXIXo List<BleHardwareDevice> mDeviceTypeList) {
        IIX0o.x0xO0oo(mDeviceTypeList, "mDeviceTypeList");
        this.mDeviceTypeList = mDeviceTypeList;
    }
}
