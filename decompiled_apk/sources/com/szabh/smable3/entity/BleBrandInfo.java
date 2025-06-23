package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleWritable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.nio.ByteOrder;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
final class BleBrandInfo extends BleWritable {

    @OOXIXo
    private BleBrandInfoHeader mHeader;

    @OOXIXo
    private BleBrandInfoItem0 mItem0;

    @OOXIXo
    private BleBrandInfoItem1 mItem1;

    public BleBrandInfo() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ BleBrandInfo copy$default(BleBrandInfo bleBrandInfo, BleBrandInfoHeader bleBrandInfoHeader, BleBrandInfoItem0 bleBrandInfoItem0, BleBrandInfoItem1 bleBrandInfoItem1, int i, Object obj) {
        if ((i & 1) != 0) {
            bleBrandInfoHeader = bleBrandInfo.mHeader;
        }
        if ((i & 2) != 0) {
            bleBrandInfoItem0 = bleBrandInfo.mItem0;
        }
        if ((i & 4) != 0) {
            bleBrandInfoItem1 = bleBrandInfo.mItem1;
        }
        return bleBrandInfo.copy(bleBrandInfoHeader, bleBrandInfoItem0, bleBrandInfoItem1);
    }

    @OOXIXo
    public final BleBrandInfoHeader component1() {
        return this.mHeader;
    }

    @OOXIXo
    public final BleBrandInfoItem0 component2() {
        return this.mItem0;
    }

    @OOXIXo
    public final BleBrandInfoItem1 component3() {
        return this.mItem1;
    }

    @OOXIXo
    public final BleBrandInfo copy(@OOXIXo BleBrandInfoHeader mHeader, @OOXIXo BleBrandInfoItem0 mItem0, @OOXIXo BleBrandInfoItem1 mItem1) {
        IIX0o.x0xO0oo(mHeader, "mHeader");
        IIX0o.x0xO0oo(mItem0, "mItem0");
        IIX0o.x0xO0oo(mItem1, "mItem1");
        return new BleBrandInfo(mHeader, mItem0, mItem1);
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public void encode() {
        super.encode();
        writeObject(this.mHeader);
        ByteOrder LITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        writeUInt32(40L, LITTLE_ENDIAN);
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        writeUInt32(168L, LITTLE_ENDIAN);
        writeObject(this.mItem0);
        writeObject(this.mItem1);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleBrandInfo)) {
            return false;
        }
        BleBrandInfo bleBrandInfo = (BleBrandInfo) obj;
        return IIX0o.Oxx0IOOO(this.mHeader, bleBrandInfo.mHeader) && IIX0o.Oxx0IOOO(this.mItem0, bleBrandInfo.mItem0) && IIX0o.Oxx0IOOO(this.mItem1, bleBrandInfo.mItem1);
    }

    @OOXIXo
    public final BleBrandInfoHeader getMHeader() {
        return this.mHeader;
    }

    @OOXIXo
    public final BleBrandInfoItem0 getMItem0() {
        return this.mItem0;
    }

    @OOXIXo
    public final BleBrandInfoItem1 getMItem1() {
        return this.mItem1;
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public int getMLengthToWrite() {
        return this.mItem1.getMLengthToWrite() + 168;
    }

    public int hashCode() {
        return (((this.mHeader.hashCode() * 31) + this.mItem0.hashCode()) * 31) + this.mItem1.hashCode();
    }

    public final void setMHeader(@OOXIXo BleBrandInfoHeader bleBrandInfoHeader) {
        IIX0o.x0xO0oo(bleBrandInfoHeader, "<set-?>");
        this.mHeader = bleBrandInfoHeader;
    }

    public final void setMItem0(@OOXIXo BleBrandInfoItem0 bleBrandInfoItem0) {
        IIX0o.x0xO0oo(bleBrandInfoItem0, "<set-?>");
        this.mItem0 = bleBrandInfoItem0;
    }

    public final void setMItem1(@OOXIXo BleBrandInfoItem1 bleBrandInfoItem1) {
        IIX0o.x0xO0oo(bleBrandInfoItem1, "<set-?>");
        this.mItem1 = bleBrandInfoItem1;
    }

    @OOXIXo
    public String toString() {
        return "BleBrandInfo(mHeader=" + this.mHeader + ", mItem0=" + this.mItem0 + ", mItem1=" + this.mItem1 + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleBrandInfo(BleBrandInfoHeader bleBrandInfoHeader, BleBrandInfoItem0 bleBrandInfoItem0, BleBrandInfoItem1 bleBrandInfoItem1, int i, IIXOooo iIXOooo) {
        this((i & 1) != 0 ? new BleBrandInfoHeader(null, 0, 0L, 0, 15, null) : bleBrandInfoHeader, (i & 2) != 0 ? new BleBrandInfoItem0(null, 1, null) : bleBrandInfoItem0, (i & 4) != 0 ? new BleBrandInfoItem1(0, 0, 0, 0, 0, null, null, 127, null) : bleBrandInfoItem1);
    }

    public BleBrandInfo(@OOXIXo BleBrandInfoHeader mHeader, @OOXIXo BleBrandInfoItem0 mItem0, @OOXIXo BleBrandInfoItem1 mItem1) {
        IIX0o.x0xO0oo(mHeader, "mHeader");
        IIX0o.x0xO0oo(mItem0, "mItem0");
        IIX0o.x0xO0oo(mItem1, "mItem1");
        this.mHeader = mHeader;
        this.mItem0 = mItem0;
        this.mItem1 = mItem1;
    }
}
