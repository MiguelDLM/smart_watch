package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleReadable;
import com.bestmafen.baseble.data.BleWritable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nBleStandbyWatchFaceSet.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BleStandbyWatchFaceSet.kt\ncom/szabh/smable3/entity/BleStandbyWatchFaceSet\n+ 2 BleReadable.kt\ncom/bestmafen/baseble/data/BleReadable\n*L\n1#1,34:1\n222#2,4:35\n*S KotlinDebug\n*F\n+ 1 BleStandbyWatchFaceSet.kt\ncom/szabh/smable3/entity/BleStandbyWatchFaceSet\n*L\n26#1:35,4\n*E\n"})
/* loaded from: classes13.dex */
public final class BleStandbyWatchFaceSet extends BleWritable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_LENGTH = 8;

    @OOXIXo
    private BleTimeRange mBleTimeRange1;
    private int mEnabled;
    private int mReserved;
    private int mStandbyEnable;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public BleStandbyWatchFaceSet() {
        this(0, 0, null, 0, 15, null);
    }

    public static /* synthetic */ BleStandbyWatchFaceSet copy$default(BleStandbyWatchFaceSet bleStandbyWatchFaceSet, int i, int i2, BleTimeRange bleTimeRange, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = bleStandbyWatchFaceSet.mStandbyEnable;
        }
        if ((i4 & 2) != 0) {
            i2 = bleStandbyWatchFaceSet.mEnabled;
        }
        if ((i4 & 4) != 0) {
            bleTimeRange = bleStandbyWatchFaceSet.mBleTimeRange1;
        }
        if ((i4 & 8) != 0) {
            i3 = bleStandbyWatchFaceSet.mReserved;
        }
        return bleStandbyWatchFaceSet.copy(i, i2, bleTimeRange, i3);
    }

    public final int component1() {
        return this.mStandbyEnable;
    }

    public final int component2() {
        return this.mEnabled;
    }

    @OOXIXo
    public final BleTimeRange component3() {
        return this.mBleTimeRange1;
    }

    public final int component4() {
        return this.mReserved;
    }

    @OOXIXo
    public final BleStandbyWatchFaceSet copy(int i, int i2, @OOXIXo BleTimeRange mBleTimeRange1, int i3) {
        IIX0o.x0xO0oo(mBleTimeRange1, "mBleTimeRange1");
        return new BleStandbyWatchFaceSet(i, i2, mBleTimeRange1, i3);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        this.mStandbyEnable = readUInt8();
        this.mEnabled = readUInt8();
        BleReadable bleReadable = (BleReadable) BleTimeRange.class.newInstance();
        bleReadable.setMBytes(readBytes(5));
        bleReadable.decode();
        IIX0o.ooOOo0oXI(bleReadable);
        this.mBleTimeRange1 = (BleTimeRange) bleReadable;
        this.mReserved = readInt8();
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public void encode() {
        super.encode();
        writeInt8(this.mStandbyEnable);
        writeInt8(this.mEnabled);
        writeObject(this.mBleTimeRange1);
        writeInt8(this.mReserved);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleStandbyWatchFaceSet)) {
            return false;
        }
        BleStandbyWatchFaceSet bleStandbyWatchFaceSet = (BleStandbyWatchFaceSet) obj;
        return this.mStandbyEnable == bleStandbyWatchFaceSet.mStandbyEnable && this.mEnabled == bleStandbyWatchFaceSet.mEnabled && IIX0o.Oxx0IOOO(this.mBleTimeRange1, bleStandbyWatchFaceSet.mBleTimeRange1) && this.mReserved == bleStandbyWatchFaceSet.mReserved;
    }

    @OOXIXo
    public final BleTimeRange getMBleTimeRange1() {
        return this.mBleTimeRange1;
    }

    public final int getMEnabled() {
        return this.mEnabled;
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public int getMLengthToWrite() {
        return 8;
    }

    public final int getMReserved() {
        return this.mReserved;
    }

    public final int getMStandbyEnable() {
        return this.mStandbyEnable;
    }

    public int hashCode() {
        return (((((this.mStandbyEnable * 31) + this.mEnabled) * 31) + this.mBleTimeRange1.hashCode()) * 31) + this.mReserved;
    }

    public final void setMBleTimeRange1(@OOXIXo BleTimeRange bleTimeRange) {
        IIX0o.x0xO0oo(bleTimeRange, "<set-?>");
        this.mBleTimeRange1 = bleTimeRange;
    }

    public final void setMEnabled(int i) {
        this.mEnabled = i;
    }

    public final void setMReserved(int i) {
        this.mReserved = i;
    }

    public final void setMStandbyEnable(int i) {
        this.mStandbyEnable = i;
    }

    @OOXIXo
    public String toString() {
        return "BleStandbyWatchFaceSet(mStandbyEnable=" + this.mStandbyEnable + ", mEnabled=" + this.mEnabled + ", mBleTimeRange1=" + this.mBleTimeRange1 + ", mReserved=" + this.mReserved + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleStandbyWatchFaceSet(int i, int i2, BleTimeRange bleTimeRange, int i3, int i4, IIXOooo iIXOooo) {
        this((i4 & 1) != 0 ? 0 : i, (i4 & 2) != 0 ? 0 : i2, (i4 & 4) != 0 ? new BleTimeRange(0, 0, 0, 0, 0, 31, null) : bleTimeRange, (i4 & 8) != 0 ? 1 : i3);
    }

    public BleStandbyWatchFaceSet(int i, int i2, @OOXIXo BleTimeRange mBleTimeRange1, int i3) {
        IIX0o.x0xO0oo(mBleTimeRange1, "mBleTimeRange1");
        this.mStandbyEnable = i;
        this.mEnabled = i2;
        this.mBleTimeRange1 = mBleTimeRange1;
        this.mReserved = i3;
    }
}
