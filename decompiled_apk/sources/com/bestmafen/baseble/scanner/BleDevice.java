package com.bestmafen.baseble.scanner;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.bluetooth.BluetoothDevice;
import com.bestmafen.baseble.data.ByteArrayExtKt;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.io.Serializable;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes8.dex */
public final class BleDevice implements Serializable {

    @OOXIXo
    private String mAddress;

    @OOXIXo
    private transient BluetoothDevice mBluetoothDevice;

    @OOXIXo
    private String mName;
    private int mRssi;

    @oOoXoXO
    private byte[] mScanRecord;
    private int mType;

    public BleDevice(@OOXIXo BluetoothDevice mBluetoothDevice, int i, @oOoXoXO byte[] bArr, @OOXIXo String mName, int i2, @OOXIXo String mAddress) {
        IIX0o.x0xO0oo(mBluetoothDevice, "mBluetoothDevice");
        IIX0o.x0xO0oo(mName, "mName");
        IIX0o.x0xO0oo(mAddress, "mAddress");
        this.mBluetoothDevice = mBluetoothDevice;
        this.mRssi = i;
        this.mScanRecord = bArr;
        this.mName = mName;
        this.mType = i2;
        this.mAddress = mAddress;
    }

    public static /* synthetic */ BleDevice copy$default(BleDevice bleDevice, BluetoothDevice bluetoothDevice, int i, byte[] bArr, String str, int i2, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            bluetoothDevice = bleDevice.mBluetoothDevice;
        }
        if ((i3 & 2) != 0) {
            i = bleDevice.mRssi;
        }
        int i4 = i;
        if ((i3 & 4) != 0) {
            bArr = bleDevice.mScanRecord;
        }
        byte[] bArr2 = bArr;
        if ((i3 & 8) != 0) {
            str = bleDevice.mName;
        }
        String str3 = str;
        if ((i3 & 16) != 0) {
            i2 = bleDevice.mType;
        }
        int i5 = i2;
        if ((i3 & 32) != 0) {
            str2 = bleDevice.mAddress;
        }
        return bleDevice.copy(bluetoothDevice, i4, bArr2, str3, i5, str2);
    }

    @OOXIXo
    public final BluetoothDevice component1() {
        return this.mBluetoothDevice;
    }

    public final int component2() {
        return this.mRssi;
    }

    @oOoXoXO
    public final byte[] component3() {
        return this.mScanRecord;
    }

    @OOXIXo
    public final String component4() {
        return this.mName;
    }

    public final int component5() {
        return this.mType;
    }

    @OOXIXo
    public final String component6() {
        return this.mAddress;
    }

    @OOXIXo
    public final BleDevice copy(@OOXIXo BluetoothDevice mBluetoothDevice, int i, @oOoXoXO byte[] bArr, @OOXIXo String mName, int i2, @OOXIXo String mAddress) {
        IIX0o.x0xO0oo(mBluetoothDevice, "mBluetoothDevice");
        IIX0o.x0xO0oo(mName, "mName");
        IIX0o.x0xO0oo(mAddress, "mAddress");
        return new BleDevice(mBluetoothDevice, i, bArr, mName, i2, mAddress);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (obj instanceof BleDevice) {
            return IIX0o.Oxx0IOOO(this.mBluetoothDevice, ((BleDevice) obj).mBluetoothDevice);
        }
        return false;
    }

    @OOXIXo
    public final String getMAddress() {
        return this.mAddress;
    }

    @OOXIXo
    public final BluetoothDevice getMBluetoothDevice() {
        return this.mBluetoothDevice;
    }

    @OOXIXo
    public final String getMName() {
        return this.mName;
    }

    public final int getMRssi() {
        return this.mRssi;
    }

    @oOoXoXO
    public final byte[] getMScanRecord() {
        return this.mScanRecord;
    }

    public final int getMType() {
        return this.mType;
    }

    public int hashCode() {
        return this.mBluetoothDevice.hashCode();
    }

    public final void setMAddress(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mAddress = str;
    }

    public final void setMBluetoothDevice(@OOXIXo BluetoothDevice bluetoothDevice) {
        IIX0o.x0xO0oo(bluetoothDevice, "<set-?>");
        this.mBluetoothDevice = bluetoothDevice;
    }

    public final void setMName(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mName = str;
    }

    public final void setMRssi(int i) {
        this.mRssi = i;
    }

    public final void setMScanRecord(@oOoXoXO byte[] bArr) {
        this.mScanRecord = bArr;
    }

    public final void setMType(int i) {
        this.mType = i;
    }

    @OOXIXo
    public String toString() {
        return "BleDevice(type=" + this.mType + ", name=" + this.mName + ", address=" + this.mAddress + ", mRssi=" + this.mRssi + ", mScanRecord=" + ByteArrayExtKt.getMHexString(this.mScanRecord) + HexStringBuilder.COMMENT_END_CHAR;
    }
}
