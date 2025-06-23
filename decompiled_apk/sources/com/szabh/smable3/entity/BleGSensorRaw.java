package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleReadable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.nio.ByteOrder;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BleGSensorRaw extends BleReadable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_LENGTH = 6;
    private short mX;
    private short mY;
    private short mZ;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public BleGSensorRaw() {
        this((short) 0, (short) 0, (short) 0, 7, null);
    }

    public static /* synthetic */ BleGSensorRaw copy$default(BleGSensorRaw bleGSensorRaw, short s, short s2, short s3, int i, Object obj) {
        if ((i & 1) != 0) {
            s = bleGSensorRaw.mX;
        }
        if ((i & 2) != 0) {
            s2 = bleGSensorRaw.mY;
        }
        if ((i & 4) != 0) {
            s3 = bleGSensorRaw.mZ;
        }
        return bleGSensorRaw.copy(s, s2, s3);
    }

    public final short component1() {
        return this.mX;
    }

    public final short component2() {
        return this.mY;
    }

    public final short component3() {
        return this.mZ;
    }

    @OOXIXo
    public final BleGSensorRaw copy(short s, short s2, short s3) {
        return new BleGSensorRaw(s, s2, s3);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
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
        if (!(obj instanceof BleGSensorRaw)) {
            return false;
        }
        BleGSensorRaw bleGSensorRaw = (BleGSensorRaw) obj;
        return this.mX == bleGSensorRaw.mX && this.mY == bleGSensorRaw.mY && this.mZ == bleGSensorRaw.mZ;
    }

    public final short getMX() {
        return this.mX;
    }

    public final short getMY() {
        return this.mY;
    }

    public final short getMZ() {
        return this.mZ;
    }

    public int hashCode() {
        return (((this.mX * 31) + this.mY) * 31) + this.mZ;
    }

    public final void setMX(short s) {
        this.mX = s;
    }

    public final void setMY(short s) {
        this.mY = s;
    }

    public final void setMZ(short s) {
        this.mZ = s;
    }

    @OOXIXo
    public String toString() {
        return "BleGSensorRaw(mX=" + ((int) this.mX) + ", mY=" + ((int) this.mY) + ", mZ=" + ((int) this.mZ) + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleGSensorRaw(short s, short s2, short s3, int i, IIXOooo iIXOooo) {
        this((i & 1) != 0 ? (short) 0 : s, (i & 2) != 0 ? (short) 0 : s2, (i & 4) != 0 ? (short) 0 : s3);
    }

    public BleGSensorRaw(short s, short s2, short s3) {
        this.mX = s;
        this.mY = s2;
        this.mZ = s3;
    }
}
