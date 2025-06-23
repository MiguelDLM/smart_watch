package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleReadable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BleBacCalibration extends BleIdObject {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_LENGTH = 16;
    private int value1;
    private int value2;
    private int value3;
    private int value4;
    private int value5;
    private int value6;
    private int value7;
    private int value8;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public BleBacCalibration() {
        this(0, 0, 0, 0, 0, 0, 0, 0, 255, null);
    }

    public final int component1() {
        return this.value1;
    }

    public final int component2() {
        return this.value2;
    }

    public final int component3() {
        return this.value3;
    }

    public final int component4() {
        return this.value4;
    }

    public final int component5() {
        return this.value5;
    }

    public final int component6() {
        return this.value6;
    }

    public final int component7() {
        return this.value7;
    }

    public final int component8() {
        return this.value8;
    }

    @OOXIXo
    public final BleBacCalibration copy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        return new BleBacCalibration(i, i2, i3, i4, i5, i6, i7, i8);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        this.value1 = readInt8();
        this.value2 = readInt8();
        this.value3 = BleReadable.readInt16$default(this, null, 1, null);
        this.value4 = readInt8();
        this.value5 = BleReadable.readInt16$default(this, null, 1, null);
        this.value6 = BleReadable.readInt16$default(this, null, 1, null);
        this.value7 = BleReadable.readInt16$default(this, null, 1, null);
        this.value8 = BleReadable.readInt16$default(this, null, 1, null);
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public void encode() {
        super.encode();
        writeInt8(this.value1);
        writeInt8(this.value2);
        writeInt8(this.value3);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleBacCalibration)) {
            return false;
        }
        BleBacCalibration bleBacCalibration = (BleBacCalibration) obj;
        return this.value1 == bleBacCalibration.value1 && this.value2 == bleBacCalibration.value2 && this.value3 == bleBacCalibration.value3 && this.value4 == bleBacCalibration.value4 && this.value5 == bleBacCalibration.value5 && this.value6 == bleBacCalibration.value6 && this.value7 == bleBacCalibration.value7 && this.value8 == bleBacCalibration.value8;
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public int getMLengthToWrite() {
        return 16;
    }

    public final int getValue1() {
        return this.value1;
    }

    public final int getValue2() {
        return this.value2;
    }

    public final int getValue3() {
        return this.value3;
    }

    public final int getValue4() {
        return this.value4;
    }

    public final int getValue5() {
        return this.value5;
    }

    public final int getValue6() {
        return this.value6;
    }

    public final int getValue7() {
        return this.value7;
    }

    public final int getValue8() {
        return this.value8;
    }

    public int hashCode() {
        return (((((((((((((this.value1 * 31) + this.value2) * 31) + this.value3) * 31) + this.value4) * 31) + this.value5) * 31) + this.value6) * 31) + this.value7) * 31) + this.value8;
    }

    public final void setValue1(int i) {
        this.value1 = i;
    }

    public final void setValue2(int i) {
        this.value2 = i;
    }

    public final void setValue3(int i) {
        this.value3 = i;
    }

    public final void setValue4(int i) {
        this.value4 = i;
    }

    public final void setValue5(int i) {
        this.value5 = i;
    }

    public final void setValue6(int i) {
        this.value6 = i;
    }

    public final void setValue7(int i) {
        this.value7 = i;
    }

    public final void setValue8(int i) {
        this.value8 = i;
    }

    @OOXIXo
    public String toString() {
        return "BleBacCalibration(value1=" + this.value1 + ", value2=" + this.value2 + ", value3=" + this.value3 + ", value4=" + this.value4 + ", value5=" + this.value5 + ", value6=" + this.value6 + ", value7=" + this.value7 + ", value8=" + this.value8 + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleBacCalibration(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, IIXOooo iIXOooo) {
        this((i9 & 1) != 0 ? 1 : i, (i9 & 2) != 0 ? 0 : i2, (i9 & 4) != 0 ? 0 : i3, (i9 & 8) != 0 ? 0 : i4, (i9 & 16) != 0 ? 0 : i5, (i9 & 32) != 0 ? 0 : i6, (i9 & 64) != 0 ? 0 : i7, (i9 & 128) == 0 ? i8 : 0);
    }

    public BleBacCalibration(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.value1 = i;
        this.value2 = i2;
        this.value3 = i3;
        this.value4 = i4;
        this.value5 = i5;
        this.value6 = i6;
        this.value7 = i7;
        this.value8 = i8;
    }
}
