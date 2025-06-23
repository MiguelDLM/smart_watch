package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleWritable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BleAirPressureCalibration extends BleWritable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_LENGTH = 8;
    private int mAirPressure;
    private int mAltitude;

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
    public BleAirPressureCalibration() {
        /*
            r3 = this;
            r0 = 3
            r1 = 0
            r2 = 0
            r3.<init>(r2, r2, r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.szabh.smable3.entity.BleAirPressureCalibration.<init>():void");
    }

    public static /* synthetic */ BleAirPressureCalibration copy$default(BleAirPressureCalibration bleAirPressureCalibration, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = bleAirPressureCalibration.mAirPressure;
        }
        if ((i3 & 2) != 0) {
            i2 = bleAirPressureCalibration.mAltitude;
        }
        return bleAirPressureCalibration.copy(i, i2);
    }

    public final int component1() {
        return this.mAirPressure;
    }

    public final int component2() {
        return this.mAltitude;
    }

    @OOXIXo
    public final BleAirPressureCalibration copy(int i, int i2) {
        return new BleAirPressureCalibration(i, i2);
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public void encode() {
        super.encode();
        BleWritable.writeInt32$default(this, this.mAirPressure, null, 2, null);
        BleWritable.writeInt16$default(this, this.mAltitude, null, 2, null);
        BleWritable.writeInt16$default(this, 0, null, 2, null);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleAirPressureCalibration)) {
            return false;
        }
        BleAirPressureCalibration bleAirPressureCalibration = (BleAirPressureCalibration) obj;
        return this.mAirPressure == bleAirPressureCalibration.mAirPressure && this.mAltitude == bleAirPressureCalibration.mAltitude;
    }

    public final int getMAirPressure() {
        return this.mAirPressure;
    }

    public final int getMAltitude() {
        return this.mAltitude;
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public int getMLengthToWrite() {
        return 8;
    }

    public int hashCode() {
        return (this.mAirPressure * 31) + this.mAltitude;
    }

    public final void setMAirPressure(int i) {
        this.mAirPressure = i;
    }

    public final void setMAltitude(int i) {
        this.mAltitude = i;
    }

    @OOXIXo
    public String toString() {
        return "BleAirPressureCalibration(mAirPressure=" + this.mAirPressure + ", mAltitude=" + this.mAltitude + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleAirPressureCalibration(int i, int i2, int i3, IIXOooo iIXOooo) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2);
    }

    public BleAirPressureCalibration(int i, int i2) {
        this.mAirPressure = i;
        this.mAltitude = i2;
    }
}
