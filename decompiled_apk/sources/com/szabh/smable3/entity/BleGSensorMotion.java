package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleReadable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.nio.ByteOrder;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BleGSensorMotion extends BleReadable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_LENGTH = 2;
    private short mMotion;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public BleGSensorMotion() {
        this((short) 0, 1, null);
    }

    public static /* synthetic */ BleGSensorMotion copy$default(BleGSensorMotion bleGSensorMotion, short s, int i, Object obj) {
        if ((i & 1) != 0) {
            s = bleGSensorMotion.mMotion;
        }
        return bleGSensorMotion.copy(s);
    }

    public final short component1() {
        return this.mMotion;
    }

    @OOXIXo
    public final BleGSensorMotion copy(short s) {
        return new BleGSensorMotion(s);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        ByteOrder LITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        this.mMotion = readInt16(LITTLE_ENDIAN);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof BleGSensorMotion) && this.mMotion == ((BleGSensorMotion) obj).mMotion;
    }

    public final short getMMotion() {
        return this.mMotion;
    }

    public int hashCode() {
        return this.mMotion;
    }

    public final void setMMotion(short s) {
        this.mMotion = s;
    }

    @OOXIXo
    public String toString() {
        return "BleGSensorMotion(mMotion=" + ((int) this.mMotion) + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleGSensorMotion(short s, int i, IIXOooo iIXOooo) {
        this((i & 1) != 0 ? (short) 0 : s);
    }

    public BleGSensorMotion(short s) {
        this.mMotion = s;
    }
}
