package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleReadable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.nio.ByteOrder;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BlePower2 extends BleReadable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_LENGTH = 8;
    private int mPower;
    private int mVoltage;

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
    public BlePower2() {
        /*
            r3 = this;
            r0 = 3
            r1 = 0
            r2 = 0
            r3.<init>(r2, r2, r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.szabh.smable3.entity.BlePower2.<init>():void");
    }

    public static /* synthetic */ BlePower2 copy$default(BlePower2 blePower2, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = blePower2.mVoltage;
        }
        if ((i3 & 2) != 0) {
            i2 = blePower2.mPower;
        }
        return blePower2.copy(i, i2);
    }

    public final int component1() {
        return this.mVoltage;
    }

    public final int component2() {
        return this.mPower;
    }

    @OOXIXo
    public final BlePower2 copy(int i, int i2) {
        return new BlePower2(i, i2);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        ByteOrder BIG_ENDIAN = ByteOrder.BIG_ENDIAN;
        IIX0o.oO(BIG_ENDIAN, "BIG_ENDIAN");
        this.mVoltage = readInt32(BIG_ENDIAN);
        this.mPower = readUInt8();
        BleReadable.readInt24$default(this, null, 1, null);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BlePower2)) {
            return false;
        }
        BlePower2 blePower2 = (BlePower2) obj;
        return this.mVoltage == blePower2.mVoltage && this.mPower == blePower2.mPower;
    }

    public final int getMPower() {
        return this.mPower;
    }

    public final int getMVoltage() {
        return this.mVoltage;
    }

    public int hashCode() {
        return (this.mVoltage * 31) + this.mPower;
    }

    public final void setMPower(int i) {
        this.mPower = i;
    }

    public final void setMVoltage(int i) {
        this.mVoltage = i;
    }

    @OOXIXo
    public String toString() {
        return "BlePower2(mVoltage=" + this.mVoltage + ", mPower=" + this.mPower + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BlePower2(int i, int i2, int i3, IIXOooo iIXOooo) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2);
    }

    public BlePower2(int i, int i2) {
        this.mVoltage = i;
        this.mPower = i2;
    }
}
