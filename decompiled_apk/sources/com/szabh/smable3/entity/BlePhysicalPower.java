package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleReadable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BlePhysicalPower extends BleReadable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_LENGTH = 6;
    private int mTime;
    private int mValue;

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
    public BlePhysicalPower() {
        /*
            r3 = this;
            r0 = 3
            r1 = 0
            r2 = 0
            r3.<init>(r2, r2, r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.szabh.smable3.entity.BlePhysicalPower.<init>():void");
    }

    public static /* synthetic */ BlePhysicalPower copy$default(BlePhysicalPower blePhysicalPower, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = blePhysicalPower.mTime;
        }
        if ((i3 & 2) != 0) {
            i2 = blePhysicalPower.mValue;
        }
        return blePhysicalPower.copy(i, i2);
    }

    public final int component1() {
        return this.mTime;
    }

    public final int component2() {
        return this.mValue;
    }

    @OOXIXo
    public final BlePhysicalPower copy(int i, int i2) {
        return new BlePhysicalPower(i, i2);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        this.mTime = BleReadable.readInt32$default(this, null, 1, null);
        this.mValue = readUInt8();
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BlePhysicalPower)) {
            return false;
        }
        BlePhysicalPower blePhysicalPower = (BlePhysicalPower) obj;
        return this.mTime == blePhysicalPower.mTime && this.mValue == blePhysicalPower.mValue;
    }

    public final int getMTime() {
        return this.mTime;
    }

    public final int getMValue() {
        return this.mValue;
    }

    public int hashCode() {
        return (this.mTime * 31) + this.mValue;
    }

    public final void setMTime(int i) {
        this.mTime = i;
    }

    public final void setMValue(int i) {
        this.mValue = i;
    }

    @OOXIXo
    public String toString() {
        return "BlePhysicalPower(mTime=" + this.mTime + ", mValue=" + this.mValue + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BlePhysicalPower(int i, int i2, int i3, IIXOooo iIXOooo) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2);
    }

    public BlePhysicalPower(int i, int i2) {
        this.mTime = i;
        this.mValue = i2;
    }
}
