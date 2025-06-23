package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleWritable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BleBloodPressureCalibration extends BleWritable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_LENGTH = 2;
    private int mDiastolic;
    private int mSystolic;

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
    public BleBloodPressureCalibration() {
        /*
            r3 = this;
            r0 = 3
            r1 = 0
            r2 = 0
            r3.<init>(r2, r2, r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.szabh.smable3.entity.BleBloodPressureCalibration.<init>():void");
    }

    public static /* synthetic */ BleBloodPressureCalibration copy$default(BleBloodPressureCalibration bleBloodPressureCalibration, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = bleBloodPressureCalibration.mSystolic;
        }
        if ((i3 & 2) != 0) {
            i2 = bleBloodPressureCalibration.mDiastolic;
        }
        return bleBloodPressureCalibration.copy(i, i2);
    }

    public final int component1() {
        return this.mSystolic;
    }

    public final int component2() {
        return this.mDiastolic;
    }

    @OOXIXo
    public final BleBloodPressureCalibration copy(int i, int i2) {
        return new BleBloodPressureCalibration(i, i2);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        this.mSystolic = readUInt8();
        this.mDiastolic = readUInt8();
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public void encode() {
        super.encode();
        writeInt8(this.mSystolic);
        writeInt8(this.mDiastolic);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleBloodPressureCalibration)) {
            return false;
        }
        BleBloodPressureCalibration bleBloodPressureCalibration = (BleBloodPressureCalibration) obj;
        return this.mSystolic == bleBloodPressureCalibration.mSystolic && this.mDiastolic == bleBloodPressureCalibration.mDiastolic;
    }

    public final int getMDiastolic() {
        return this.mDiastolic;
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public int getMLengthToWrite() {
        return 2;
    }

    public final int getMSystolic() {
        return this.mSystolic;
    }

    public int hashCode() {
        return (this.mSystolic * 31) + this.mDiastolic;
    }

    public final void setMDiastolic(int i) {
        this.mDiastolic = i;
    }

    public final void setMSystolic(int i) {
        this.mSystolic = i;
    }

    @OOXIXo
    public String toString() {
        return "BleBloodPressureCalibration(mSystolic=" + this.mSystolic + ", mDiastolic=" + this.mDiastolic + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleBloodPressureCalibration(int i, int i2, int i3, IIXOooo iIXOooo) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2);
    }

    public BleBloodPressureCalibration(int i, int i2) {
        this.mSystolic = i;
        this.mDiastolic = i2;
    }
}
