package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleWritable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.nio.ByteOrder;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BleSGCameraSet extends BleWritable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_LENGTH = 4;
    private int mRecordLocation;
    private int mVideoDuration;
    private int mVideoOrientation;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public BleSGCameraSet() {
        this(0, 0, 0, 7, null);
    }

    public static /* synthetic */ BleSGCameraSet copy$default(BleSGCameraSet bleSGCameraSet, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = bleSGCameraSet.mVideoDuration;
        }
        if ((i4 & 2) != 0) {
            i2 = bleSGCameraSet.mVideoOrientation;
        }
        if ((i4 & 4) != 0) {
            i3 = bleSGCameraSet.mRecordLocation;
        }
        return bleSGCameraSet.copy(i, i2, i3);
    }

    public final int component1() {
        return this.mVideoDuration;
    }

    public final int component2() {
        return this.mVideoOrientation;
    }

    public final int component3() {
        return this.mRecordLocation;
    }

    @OOXIXo
    public final BleSGCameraSet copy(int i, int i2, int i3) {
        return new BleSGCameraSet(i, i2, i3);
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public void encode() {
        super.encode();
        int i = this.mVideoDuration;
        ByteOrder LITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        writeInt16(i, LITTLE_ENDIAN);
        writeInt8(this.mVideoOrientation);
        writeInt8(this.mRecordLocation);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleSGCameraSet)) {
            return false;
        }
        BleSGCameraSet bleSGCameraSet = (BleSGCameraSet) obj;
        return this.mVideoDuration == bleSGCameraSet.mVideoDuration && this.mVideoOrientation == bleSGCameraSet.mVideoOrientation && this.mRecordLocation == bleSGCameraSet.mRecordLocation;
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public int getMLengthToWrite() {
        return 4;
    }

    public final int getMRecordLocation() {
        return this.mRecordLocation;
    }

    public final int getMVideoDuration() {
        return this.mVideoDuration;
    }

    public final int getMVideoOrientation() {
        return this.mVideoOrientation;
    }

    public int hashCode() {
        return (((this.mVideoDuration * 31) + this.mVideoOrientation) * 31) + this.mRecordLocation;
    }

    public final void setMRecordLocation(int i) {
        this.mRecordLocation = i;
    }

    public final void setMVideoDuration(int i) {
        this.mVideoDuration = i;
    }

    public final void setMVideoOrientation(int i) {
        this.mVideoOrientation = i;
    }

    @OOXIXo
    public String toString() {
        return "BleSGCameraSet(mVideoDuration=" + this.mVideoDuration + ", mVideoOrientation=" + this.mVideoOrientation + ", mRecordLocation=" + this.mRecordLocation + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleSGCameraSet(int i, int i2, int i3, int i4, IIXOooo iIXOooo) {
        this((i4 & 1) != 0 ? 0 : i, (i4 & 2) != 0 ? 0 : i2, (i4 & 4) != 0 ? 0 : i3);
    }

    public BleSGCameraSet(int i, int i2, int i3) {
        this.mVideoDuration = i;
        this.mVideoOrientation = i2;
        this.mRecordLocation = i3;
    }
}
