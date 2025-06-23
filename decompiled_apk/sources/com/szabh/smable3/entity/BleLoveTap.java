package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import androidx.collection.oIX0oI;
import com.bestmafen.baseble.data.BleWritable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.nio.ByteOrder;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BleLoveTap extends BleWritable {
    public static final int ACTION_DOWN = 1;
    public static final int ACTION_UP = 2;

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_LENGTH = 10;
    private int mActionType;
    private int mId;
    private long mTime;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public BleLoveTap() {
        this(0L, 0, 0, 7, null);
    }

    public static /* synthetic */ BleLoveTap copy$default(BleLoveTap bleLoveTap, long j, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j = bleLoveTap.mTime;
        }
        if ((i3 & 2) != 0) {
            i = bleLoveTap.mId;
        }
        if ((i3 & 4) != 0) {
            i2 = bleLoveTap.mActionType;
        }
        return bleLoveTap.copy(j, i, i2);
    }

    public final long component1() {
        return this.mTime;
    }

    public final int component2() {
        return this.mId;
    }

    public final int component3() {
        return this.mActionType;
    }

    @OOXIXo
    public final BleLoveTap copy(long j, int i, int i2) {
        return new BleLoveTap(j, i, i2);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        ByteOrder LITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        this.mTime = readInt64(LITTLE_ENDIAN);
        this.mId = readUInt8();
        this.mActionType = readUInt8();
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public void encode() {
        super.encode();
        long j = this.mTime;
        ByteOrder LITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        writeLong(j, LITTLE_ENDIAN);
        writeInt8(this.mId);
        writeInt8(this.mActionType);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleLoveTap)) {
            return false;
        }
        BleLoveTap bleLoveTap = (BleLoveTap) obj;
        return this.mTime == bleLoveTap.mTime && this.mId == bleLoveTap.mId && this.mActionType == bleLoveTap.mActionType;
    }

    public final int getMActionType() {
        return this.mActionType;
    }

    public final int getMId() {
        return this.mId;
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public int getMLengthToWrite() {
        return 10;
    }

    public final long getMTime() {
        return this.mTime;
    }

    public int hashCode() {
        return (((oIX0oI.oIX0oI(this.mTime) * 31) + this.mId) * 31) + this.mActionType;
    }

    public final void setMActionType(int i) {
        this.mActionType = i;
    }

    public final void setMId(int i) {
        this.mId = i;
    }

    public final void setMTime(long j) {
        this.mTime = j;
    }

    @OOXIXo
    public String toString() {
        return "BleLoveTap(mTime=" + this.mTime + ", mId=" + this.mId + ", mActionType=" + this.mActionType + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleLoveTap(long j, int i, int i2, int i3, IIXOooo iIXOooo) {
        this((i3 & 1) != 0 ? 0L : j, (i3 & 2) != 0 ? 0 : i, (i3 & 4) != 0 ? 0 : i2);
    }

    public BleLoveTap(long j, int i, int i2) {
        this.mTime = j;
        this.mId = i;
        this.mActionType = i2;
    }
}
