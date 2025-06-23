package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleReadable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.nio.ByteOrder;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BleGsensorData extends BleReadable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_LENGTH = 7;
    private int mType;
    private int mX;
    private int mY;
    private int mZ;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public BleGsensorData() {
        this(0, 0, 0, 0, 15, null);
    }

    public static /* synthetic */ BleGsensorData copy$default(BleGsensorData bleGsensorData, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = bleGsensorData.mType;
        }
        if ((i5 & 2) != 0) {
            i2 = bleGsensorData.mX;
        }
        if ((i5 & 4) != 0) {
            i3 = bleGsensorData.mY;
        }
        if ((i5 & 8) != 0) {
            i4 = bleGsensorData.mZ;
        }
        return bleGsensorData.copy(i, i2, i3, i4);
    }

    public final int component1() {
        return this.mType;
    }

    public final int component2() {
        return this.mX;
    }

    public final int component3() {
        return this.mY;
    }

    public final int component4() {
        return this.mZ;
    }

    @OOXIXo
    public final BleGsensorData copy(int i, int i2, int i3, int i4) {
        return new BleGsensorData(i, i2, i3, i4);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        this.mType = readInt8();
        ByteOrder LITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        this.mX = readInt16(LITTLE_ENDIAN);
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        this.mY = readInt16(LITTLE_ENDIAN);
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        this.mZ = readInt16(LITTLE_ENDIAN);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleGsensorData)) {
            return false;
        }
        BleGsensorData bleGsensorData = (BleGsensorData) obj;
        return this.mType == bleGsensorData.mType && this.mX == bleGsensorData.mX && this.mY == bleGsensorData.mY && this.mZ == bleGsensorData.mZ;
    }

    public final int getMType() {
        return this.mType;
    }

    public final int getMX() {
        return this.mX;
    }

    public final int getMY() {
        return this.mY;
    }

    public final int getMZ() {
        return this.mZ;
    }

    public int hashCode() {
        return (((((this.mType * 31) + this.mX) * 31) + this.mY) * 31) + this.mZ;
    }

    public final void setMType(int i) {
        this.mType = i;
    }

    public final void setMX(int i) {
        this.mX = i;
    }

    public final void setMY(int i) {
        this.mY = i;
    }

    public final void setMZ(int i) {
        this.mZ = i;
    }

    @OOXIXo
    public String toString() {
        return "BleGsensorData(mType=" + this.mType + ", mX=" + this.mX + ", mY=" + this.mY + ", mZ=" + this.mZ + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleGsensorData(int i, int i2, int i3, int i4, int i5, IIXOooo iIXOooo) {
        this((i5 & 1) != 0 ? 0 : i, (i5 & 2) != 0 ? 0 : i2, (i5 & 4) != 0 ? 0 : i3, (i5 & 8) != 0 ? 0 : i4);
    }

    public BleGsensorData(int i, int i2, int i3, int i4) {
        this.mType = i;
        this.mX = i2;
        this.mY = i3;
        this.mZ = i4;
    }
}
