package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleWritable;
import com.bestmafen.baseble.data.ByteArrayExtKt;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.util.Arrays;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.text.oxoX;

/* loaded from: classes13.dex */
public final class BleDeviceUniqueDataSettings extends BleWritable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int TYPE_IMEI = 1;

    @OOXIXo
    private byte[] mData;
    private int mType;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BleDeviceUniqueDataSettings() {
        this(0, null, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ BleDeviceUniqueDataSettings copy$default(BleDeviceUniqueDataSettings bleDeviceUniqueDataSettings, int i, byte[] bArr, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = bleDeviceUniqueDataSettings.mType;
        }
        if ((i2 & 2) != 0) {
            bArr = bleDeviceUniqueDataSettings.mData;
        }
        return bleDeviceUniqueDataSettings.copy(i, bArr);
    }

    public final int component1() {
        return this.mType;
    }

    @OOXIXo
    public final byte[] component2() {
        return this.mData;
    }

    @OOXIXo
    public final BleDeviceUniqueDataSettings copy(int i, @OOXIXo byte[] mData) {
        IIX0o.x0xO0oo(mData, "mData");
        return new BleDeviceUniqueDataSettings(i, mData);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        this.mType = readUInt8();
        this.mData = readBytes(readInt8());
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public void encode() {
        super.encode();
        writeInt8(this.mType);
        writeInt8(this.mData.length);
        BleWritable.writeBytes$default(this, this.mData, null, 2, null);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleDeviceUniqueDataSettings)) {
            return false;
        }
        BleDeviceUniqueDataSettings bleDeviceUniqueDataSettings = (BleDeviceUniqueDataSettings) obj;
        return this.mType == bleDeviceUniqueDataSettings.mType && IIX0o.Oxx0IOOO(this.mData, bleDeviceUniqueDataSettings.mData);
    }

    @OOXIXo
    public final byte[] getMData() {
        return this.mData;
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public int getMLengthToWrite() {
        return this.mData.length + 2;
    }

    public final int getMType() {
        return this.mType;
    }

    public int hashCode() {
        return (this.mType * 31) + Arrays.hashCode(this.mData);
    }

    public final void setMData(@OOXIXo byte[] bArr) {
        IIX0o.x0xO0oo(bArr, "<set-?>");
        this.mData = bArr;
    }

    public final void setMType(int i) {
        this.mType = i;
    }

    @OOXIXo
    public String toString() {
        String mHexString;
        StringBuilder sb = new StringBuilder();
        sb.append("BleDeviceUniqueDataSettings(mType=");
        sb.append(this.mType);
        sb.append(", mSize=");
        sb.append(this.mData.length);
        sb.append(", mData=");
        if (this.mType == 1) {
            mHexString = new String(this.mData, oxoX.f29584XO);
        } else {
            mHexString = ByteArrayExtKt.getMHexString(this.mData);
        }
        sb.append(mHexString);
        sb.append(HexStringBuilder.COMMENT_END_CHAR);
        return sb.toString();
    }

    public /* synthetic */ BleDeviceUniqueDataSettings(int i, byte[] bArr, int i2, IIXOooo iIXOooo) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? new byte[0] : bArr);
    }

    public BleDeviceUniqueDataSettings(int i, @OOXIXo byte[] mData) {
        IIX0o.x0xO0oo(mData, "mData");
        this.mType = i;
        this.mData = mData;
    }
}
