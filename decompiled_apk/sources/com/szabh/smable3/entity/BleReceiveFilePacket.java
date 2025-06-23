package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleReadable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.nio.ByteOrder;
import java.util.Arrays;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.oxxXoxO;

/* loaded from: classes13.dex */
public final class BleReceiveFilePacket extends BleReadable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int TYPE_IMAGE = 1;
    private int mCRC;

    @OOXIXo
    private byte[] mFileContent;
    private int mFileSize;
    private int mFileType;
    private int mOffsetValue;
    private int mTime;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public BleReceiveFilePacket() {
        this(0, 0, 0, 0, 0, null, 63, null);
    }

    public static /* synthetic */ BleReceiveFilePacket copy$default(BleReceiveFilePacket bleReceiveFilePacket, int i, int i2, int i3, int i4, int i5, byte[] bArr, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = bleReceiveFilePacket.mFileType;
        }
        if ((i6 & 2) != 0) {
            i2 = bleReceiveFilePacket.mTime;
        }
        int i7 = i2;
        if ((i6 & 4) != 0) {
            i3 = bleReceiveFilePacket.mFileSize;
        }
        int i8 = i3;
        if ((i6 & 8) != 0) {
            i4 = bleReceiveFilePacket.mCRC;
        }
        int i9 = i4;
        if ((i6 & 16) != 0) {
            i5 = bleReceiveFilePacket.mOffsetValue;
        }
        int i10 = i5;
        if ((i6 & 32) != 0) {
            bArr = bleReceiveFilePacket.mFileContent;
        }
        return bleReceiveFilePacket.copy(i, i7, i8, i9, i10, bArr);
    }

    public final int component1() {
        return this.mFileType;
    }

    public final int component2() {
        return this.mTime;
    }

    public final int component3() {
        return this.mFileSize;
    }

    public final int component4() {
        return this.mCRC;
    }

    public final int component5() {
        return this.mOffsetValue;
    }

    @OOXIXo
    public final byte[] component6() {
        return this.mFileContent;
    }

    @OOXIXo
    public final BleReceiveFilePacket copy(int i, int i2, int i3, int i4, int i5, @OOXIXo byte[] mFileContent) {
        IIX0o.x0xO0oo(mFileContent, "mFileContent");
        return new BleReceiveFilePacket(i, i2, i3, i4, i5, mFileContent);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        this.mFileType = readInt8();
        BleReadable.readInt24$default(this, null, 1, null);
        ByteOrder LITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        this.mTime = readInt32(LITTLE_ENDIAN);
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        this.mFileSize = readInt32(LITTLE_ENDIAN);
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        this.mCRC = readInt16(LITTLE_ENDIAN);
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        this.mOffsetValue = readInt32(LITTLE_ENDIAN);
        byte[] mBytes = getMBytes();
        IIX0o.ooOOo0oXI(mBytes);
        if (mBytes.length > 18) {
            byte[] mBytes2 = getMBytes();
            IIX0o.ooOOo0oXI(mBytes2);
            this.mFileContent = readBytes(mBytes2.length - 18);
        }
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleReceiveFilePacket)) {
            return false;
        }
        BleReceiveFilePacket bleReceiveFilePacket = (BleReceiveFilePacket) obj;
        return this.mFileType == bleReceiveFilePacket.mFileType && this.mTime == bleReceiveFilePacket.mTime && this.mFileSize == bleReceiveFilePacket.mFileSize && this.mCRC == bleReceiveFilePacket.mCRC && this.mOffsetValue == bleReceiveFilePacket.mOffsetValue && IIX0o.Oxx0IOOO(this.mFileContent, bleReceiveFilePacket.mFileContent);
    }

    public final int getMCRC() {
        return this.mCRC;
    }

    @OOXIXo
    public final byte[] getMFileContent() {
        return this.mFileContent;
    }

    public final int getMFileSize() {
        return this.mFileSize;
    }

    public final int getMFileType() {
        return this.mFileType;
    }

    public final int getMOffsetValue() {
        return this.mOffsetValue;
    }

    public final int getMTime() {
        return this.mTime;
    }

    public int hashCode() {
        return (((((((((this.mFileType * 31) + this.mTime) * 31) + this.mFileSize) * 31) + this.mCRC) * 31) + this.mOffsetValue) * 31) + Arrays.hashCode(this.mFileContent);
    }

    public final void setMCRC(int i) {
        this.mCRC = i;
    }

    public final void setMFileContent(@OOXIXo byte[] bArr) {
        IIX0o.x0xO0oo(bArr, "<set-?>");
        this.mFileContent = bArr;
    }

    public final void setMFileSize(int i) {
        this.mFileSize = i;
    }

    public final void setMFileType(int i) {
        this.mFileType = i;
    }

    public final void setMOffsetValue(int i) {
        this.mOffsetValue = i;
    }

    public final void setMTime(int i) {
        this.mTime = i;
    }

    @OOXIXo
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BleReceiveFilePacket(mFileType=");
        sb.append(this.mFileType);
        sb.append(", mTime=");
        sb.append(this.mTime);
        sb.append(", mFileSize=");
        sb.append(this.mFileSize);
        sb.append(", mCRC=");
        oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
        String format = String.format("%02X", Arrays.copyOf(new Object[]{Integer.valueOf(this.mCRC)}, 1));
        IIX0o.oO(format, "format(...)");
        sb.append(format);
        sb.append(", mOffsetValue=");
        sb.append(this.mOffsetValue);
        sb.append(", mFileContent=");
        sb.append(this.mFileContent.length);
        sb.append(HexStringBuilder.COMMENT_END_CHAR);
        return sb.toString();
    }

    public /* synthetic */ BleReceiveFilePacket(int i, int i2, int i3, int i4, int i5, byte[] bArr, int i6, IIXOooo iIXOooo) {
        this((i6 & 1) != 0 ? 0 : i, (i6 & 2) != 0 ? 0 : i2, (i6 & 4) != 0 ? 0 : i3, (i6 & 8) != 0 ? 0 : i4, (i6 & 16) != 0 ? 0 : i5, (i6 & 32) != 0 ? new byte[0] : bArr);
    }

    public BleReceiveFilePacket(int i, int i2, int i3, int i4, int i5, @OOXIXo byte[] mFileContent) {
        IIX0o.x0xO0oo(mFileContent, "mFileContent");
        this.mFileType = i;
        this.mTime = i2;
        this.mFileSize = i3;
        this.mCRC = i4;
        this.mOffsetValue = i5;
        this.mFileContent = mFileContent;
    }
}
