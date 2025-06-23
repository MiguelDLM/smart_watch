package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleWritable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.util.Arrays;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BleAlipaySettings extends BleWritable {
    public static final int ADDRESS_LENGTH = 6;

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_LENGTH = 10;
    private int isActivate;

    @OOXIXo
    private byte[] mAddress;
    private int mAlipayVersion;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public BleAlipaySettings() {
        this(0, 0, null, 7, null);
    }

    public static /* synthetic */ BleAlipaySettings copy$default(BleAlipaySettings bleAlipaySettings, int i, int i2, byte[] bArr, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = bleAlipaySettings.mAlipayVersion;
        }
        if ((i3 & 2) != 0) {
            i2 = bleAlipaySettings.isActivate;
        }
        if ((i3 & 4) != 0) {
            bArr = bleAlipaySettings.mAddress;
        }
        return bleAlipaySettings.copy(i, i2, bArr);
    }

    public final int component1() {
        return this.mAlipayVersion;
    }

    public final int component2() {
        return this.isActivate;
    }

    @OOXIXo
    public final byte[] component3() {
        return this.mAddress;
    }

    @OOXIXo
    public final BleAlipaySettings copy(int i, int i2, @OOXIXo byte[] mAddress) {
        IIX0o.x0xO0oo(mAddress, "mAddress");
        return new BleAlipaySettings(i, i2, mAddress);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        this.mAlipayVersion = readUInt8();
        this.isActivate = readUInt8();
        this.mAddress = readBytes(6);
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public void encode() {
        super.encode();
        writeInt8(this.mAlipayVersion);
        writeInt8(this.isActivate);
        BleWritable.writeBytes$default(this, ArraysKt___ArraysKt.OXXO(this.mAddress), null, 2, null);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleAlipaySettings)) {
            return false;
        }
        BleAlipaySettings bleAlipaySettings = (BleAlipaySettings) obj;
        return this.mAlipayVersion == bleAlipaySettings.mAlipayVersion && this.isActivate == bleAlipaySettings.isActivate && IIX0o.Oxx0IOOO(this.mAddress, bleAlipaySettings.mAddress);
    }

    @OOXIXo
    public final byte[] getMAddress() {
        return this.mAddress;
    }

    public final int getMAlipayVersion() {
        return this.mAlipayVersion;
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public int getMLengthToWrite() {
        return 10;
    }

    public int hashCode() {
        return (((this.mAlipayVersion * 31) + this.isActivate) * 31) + Arrays.hashCode(this.mAddress);
    }

    public final int isActivate() {
        return this.isActivate;
    }

    public final void setActivate(int i) {
        this.isActivate = i;
    }

    public final void setMAddress(@OOXIXo byte[] bArr) {
        IIX0o.x0xO0oo(bArr, "<set-?>");
        this.mAddress = bArr;
    }

    public final void setMAlipayVersion(int i) {
        this.mAlipayVersion = i;
    }

    @OOXIXo
    public String toString() {
        return "BleAlipaySettings(mAlipayVersion=" + this.mAlipayVersion + ", isActivate=" + this.isActivate + ", mAddress=" + Arrays.toString(this.mAddress) + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleAlipaySettings(int i, int i2, byte[] bArr, int i3, IIXOooo iIXOooo) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2, (i3 & 4) != 0 ? new byte[6] : bArr);
    }

    public BleAlipaySettings(int i, int i2, @OOXIXo byte[] mAddress) {
        IIX0o.x0xO0oo(mAddress, "mAddress");
        this.mAlipayVersion = i;
        this.isActivate = i2;
        this.mAddress = mAddress;
    }
}
