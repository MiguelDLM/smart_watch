package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleReadable;
import com.bestmafen.baseble.data.BleWritable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nBleBloodOxyGenSettings.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BleBloodOxyGenSettings.kt\ncom/szabh/smable3/entity/BleBloodOxyGenSettings\n+ 2 BleReadable.kt\ncom/bestmafen/baseble/data/BleReadable\n*L\n1#1,28:1\n222#2,4:29\n*S KotlinDebug\n*F\n+ 1 BleBloodOxyGenSettings.kt\ncom/szabh/smable3/entity/BleBloodOxyGenSettings\n*L\n20#1:29,4\n*E\n"})
/* loaded from: classes13.dex */
public final class BleBloodOxyGenSettings extends BleWritable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_LENGTH = 6;

    @OOXIXo
    private BleTimeRange mBleTimeRange;
    private int mInterval;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BleBloodOxyGenSettings() {
        this(null, 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ BleBloodOxyGenSettings copy$default(BleBloodOxyGenSettings bleBloodOxyGenSettings, BleTimeRange bleTimeRange, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            bleTimeRange = bleBloodOxyGenSettings.mBleTimeRange;
        }
        if ((i2 & 2) != 0) {
            i = bleBloodOxyGenSettings.mInterval;
        }
        return bleBloodOxyGenSettings.copy(bleTimeRange, i);
    }

    @OOXIXo
    public final BleTimeRange component1() {
        return this.mBleTimeRange;
    }

    public final int component2() {
        return this.mInterval;
    }

    @OOXIXo
    public final BleBloodOxyGenSettings copy(@OOXIXo BleTimeRange mBleTimeRange, int i) {
        IIX0o.x0xO0oo(mBleTimeRange, "mBleTimeRange");
        return new BleBloodOxyGenSettings(mBleTimeRange, i);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        BleReadable bleReadable = (BleReadable) BleTimeRange.class.newInstance();
        bleReadable.setMBytes(readBytes(5));
        bleReadable.decode();
        IIX0o.ooOOo0oXI(bleReadable);
        this.mBleTimeRange = (BleTimeRange) bleReadable;
        this.mInterval = readUInt8();
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public void encode() {
        super.encode();
        writeObject(this.mBleTimeRange);
        writeInt8(this.mInterval);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleBloodOxyGenSettings)) {
            return false;
        }
        BleBloodOxyGenSettings bleBloodOxyGenSettings = (BleBloodOxyGenSettings) obj;
        return IIX0o.Oxx0IOOO(this.mBleTimeRange, bleBloodOxyGenSettings.mBleTimeRange) && this.mInterval == bleBloodOxyGenSettings.mInterval;
    }

    @OOXIXo
    public final BleTimeRange getMBleTimeRange() {
        return this.mBleTimeRange;
    }

    public final int getMInterval() {
        return this.mInterval;
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public int getMLengthToWrite() {
        return 6;
    }

    public int hashCode() {
        return (this.mBleTimeRange.hashCode() * 31) + this.mInterval;
    }

    public final void setMBleTimeRange(@OOXIXo BleTimeRange bleTimeRange) {
        IIX0o.x0xO0oo(bleTimeRange, "<set-?>");
        this.mBleTimeRange = bleTimeRange;
    }

    public final void setMInterval(int i) {
        this.mInterval = i;
    }

    @OOXIXo
    public String toString() {
        return "BleBloodOxyGenSettings(mBleTimeRange=" + this.mBleTimeRange + ", mInterval=" + this.mInterval + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleBloodOxyGenSettings(BleTimeRange bleTimeRange, int i, int i2, IIXOooo iIXOooo) {
        this((i2 & 1) != 0 ? new BleTimeRange(0, 0, 0, 0, 0, 31, null) : bleTimeRange, (i2 & 2) != 0 ? 60 : i);
    }

    public BleBloodOxyGenSettings(@OOXIXo BleTimeRange mBleTimeRange, int i) {
        IIX0o.x0xO0oo(mBleTimeRange, "mBleTimeRange");
        this.mBleTimeRange = mBleTimeRange;
        this.mInterval = i;
    }
}
