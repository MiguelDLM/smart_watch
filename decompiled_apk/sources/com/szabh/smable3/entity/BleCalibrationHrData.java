package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleReadable;
import com.bestmafen.baseble.data.BleWritable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BleCalibrationHrData extends BleWritable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_LENGTH = 4;
    private int mBioDiffValue;
    private int mBioMaxValue;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public BleCalibrationHrData() {
        /*
            r3 = this;
            r0 = 3
            r1 = 0
            r2 = 0
            r3.<init>(r2, r2, r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.szabh.smable3.entity.BleCalibrationHrData.<init>():void");
    }

    public static /* synthetic */ BleCalibrationHrData copy$default(BleCalibrationHrData bleCalibrationHrData, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = bleCalibrationHrData.mBioMaxValue;
        }
        if ((i3 & 2) != 0) {
            i2 = bleCalibrationHrData.mBioDiffValue;
        }
        return bleCalibrationHrData.copy(i, i2);
    }

    public final int component1() {
        return this.mBioMaxValue;
    }

    public final int component2() {
        return this.mBioDiffValue;
    }

    @OOXIXo
    public final BleCalibrationHrData copy(int i, int i2) {
        return new BleCalibrationHrData(i, i2);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        this.mBioMaxValue = BleReadable.readUInt16$default(this, null, 1, null);
        this.mBioDiffValue = BleReadable.readUInt16$default(this, null, 1, null);
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public void encode() {
        super.encode();
        BleWritable.writeInt16$default(this, this.mBioMaxValue, null, 2, null);
        BleWritable.writeInt16$default(this, this.mBioDiffValue, null, 2, null);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleCalibrationHrData)) {
            return false;
        }
        BleCalibrationHrData bleCalibrationHrData = (BleCalibrationHrData) obj;
        return this.mBioMaxValue == bleCalibrationHrData.mBioMaxValue && this.mBioDiffValue == bleCalibrationHrData.mBioDiffValue;
    }

    public final int getMBioDiffValue() {
        return this.mBioDiffValue;
    }

    public final int getMBioMaxValue() {
        return this.mBioMaxValue;
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public int getMLengthToWrite() {
        return 4;
    }

    public int hashCode() {
        return (this.mBioMaxValue * 31) + this.mBioDiffValue;
    }

    public final void setMBioDiffValue(int i) {
        this.mBioDiffValue = i;
    }

    public final void setMBioMaxValue(int i) {
        this.mBioMaxValue = i;
    }

    @OOXIXo
    public String toString() {
        return "BleCalibrationHrData(mBioMaxValue=" + this.mBioMaxValue + ", mBioDiffValue=" + this.mBioDiffValue + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleCalibrationHrData(int i, int i2, int i3, IIXOooo iIXOooo) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2);
    }

    public BleCalibrationHrData(int i, int i2) {
        this.mBioMaxValue = i;
        this.mBioDiffValue = i2;
    }
}
