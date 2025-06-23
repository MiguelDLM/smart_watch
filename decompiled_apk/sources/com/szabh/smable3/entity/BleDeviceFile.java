package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleReadable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.util.Arrays;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BleDeviceFile extends BleReadable {
    public static final int AUDIO = 0;
    public static final int BIN = 2;
    public static final int BMP = 3;

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int WAV = 1;

    @OOXIXo
    private byte[] mFileContent;
    private int mFileFormat;
    private int mFileSize;
    private int mFileType;
    private int mIndex;
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

    public BleDeviceFile() {
        this(0, 0, 0, 0, 0, 0, null, 127, null);
    }

    public static /* synthetic */ BleDeviceFile copy$default(BleDeviceFile bleDeviceFile, int i, int i2, int i3, int i4, int i5, int i6, byte[] bArr, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            i = bleDeviceFile.mFileType;
        }
        if ((i7 & 2) != 0) {
            i2 = bleDeviceFile.mTime;
        }
        int i8 = i2;
        if ((i7 & 4) != 0) {
            i3 = bleDeviceFile.mIndex;
        }
        int i9 = i3;
        if ((i7 & 8) != 0) {
            i4 = bleDeviceFile.mFileFormat;
        }
        int i10 = i4;
        if ((i7 & 16) != 0) {
            i5 = bleDeviceFile.mFileSize;
        }
        int i11 = i5;
        if ((i7 & 32) != 0) {
            i6 = bleDeviceFile.mOffsetValue;
        }
        int i12 = i6;
        if ((i7 & 64) != 0) {
            bArr = bleDeviceFile.mFileContent;
        }
        return bleDeviceFile.copy(i, i8, i9, i10, i11, i12, bArr);
    }

    public final int component1() {
        return this.mFileType;
    }

    public final int component2() {
        return this.mTime;
    }

    public final int component3() {
        return this.mIndex;
    }

    public final int component4() {
        return this.mFileFormat;
    }

    public final int component5() {
        return this.mFileSize;
    }

    public final int component6() {
        return this.mOffsetValue;
    }

    @OOXIXo
    public final byte[] component7() {
        return this.mFileContent;
    }

    @OOXIXo
    public final BleDeviceFile copy(int i, int i2, int i3, int i4, int i5, int i6, @OOXIXo byte[] mFileContent) {
        IIX0o.x0xO0oo(mFileContent, "mFileContent");
        return new BleDeviceFile(i, i2, i3, i4, i5, i6, mFileContent);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        this.mFileType = readInt8();
        this.mTime = BleReadable.readInt32$default(this, null, 1, null);
        this.mIndex = BleReadable.readInt32$default(this, null, 1, null);
        this.mFileFormat = readInt8();
        this.mFileSize = BleReadable.readInt32$default(this, null, 1, null);
        this.mOffsetValue = BleReadable.readInt32$default(this, null, 1, null);
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
        if (!(obj instanceof BleDeviceFile)) {
            return false;
        }
        BleDeviceFile bleDeviceFile = (BleDeviceFile) obj;
        return this.mFileType == bleDeviceFile.mFileType && this.mTime == bleDeviceFile.mTime && this.mIndex == bleDeviceFile.mIndex && this.mFileFormat == bleDeviceFile.mFileFormat && this.mFileSize == bleDeviceFile.mFileSize && this.mOffsetValue == bleDeviceFile.mOffsetValue && IIX0o.Oxx0IOOO(this.mFileContent, bleDeviceFile.mFileContent);
    }

    @OOXIXo
    public final byte[] getMFileContent() {
        return this.mFileContent;
    }

    public final int getMFileFormat() {
        return this.mFileFormat;
    }

    public final int getMFileSize() {
        return this.mFileSize;
    }

    public final int getMFileType() {
        return this.mFileType;
    }

    public final int getMIndex() {
        return this.mIndex;
    }

    public final int getMOffsetValue() {
        return this.mOffsetValue;
    }

    public final int getMTime() {
        return this.mTime;
    }

    public int hashCode() {
        return (((((((((((this.mFileType * 31) + this.mTime) * 31) + this.mIndex) * 31) + this.mFileFormat) * 31) + this.mFileSize) * 31) + this.mOffsetValue) * 31) + Arrays.hashCode(this.mFileContent);
    }

    public final void setMFileContent(@OOXIXo byte[] bArr) {
        IIX0o.x0xO0oo(bArr, "<set-?>");
        this.mFileContent = bArr;
    }

    public final void setMFileFormat(int i) {
        this.mFileFormat = i;
    }

    public final void setMFileSize(int i) {
        this.mFileSize = i;
    }

    public final void setMFileType(int i) {
        this.mFileType = i;
    }

    public final void setMIndex(int i) {
        this.mIndex = i;
    }

    public final void setMOffsetValue(int i) {
        this.mOffsetValue = i;
    }

    public final void setMTime(int i) {
        this.mTime = i;
    }

    @OOXIXo
    public String toString() {
        return "BleDeviceFile(mFileType=" + this.mFileType + ", mTime=" + this.mTime + ", mIndex=" + this.mIndex + ", mFileFormat=" + this.mFileFormat + ", mFileSize=" + this.mFileSize + ", mOffsetValue=" + this.mOffsetValue + ", mFileContent=" + Arrays.toString(this.mFileContent) + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleDeviceFile(int i, int i2, int i3, int i4, int i5, int i6, byte[] bArr, int i7, IIXOooo iIXOooo) {
        this((i7 & 1) != 0 ? 0 : i, (i7 & 2) != 0 ? 0 : i2, (i7 & 4) != 0 ? 0 : i3, (i7 & 8) != 0 ? 0 : i4, (i7 & 16) != 0 ? 0 : i5, (i7 & 32) != 0 ? 0 : i6, (i7 & 64) != 0 ? new byte[0] : bArr);
    }

    public BleDeviceFile(int i, int i2, int i3, int i4, int i5, int i6, @OOXIXo byte[] mFileContent) {
        IIX0o.x0xO0oo(mFileContent, "mFileContent");
        this.mFileType = i;
        this.mTime = i2;
        this.mIndex = i3;
        this.mFileFormat = i4;
        this.mFileSize = i5;
        this.mOffsetValue = i6;
        this.mFileContent = mFileContent;
    }
}
