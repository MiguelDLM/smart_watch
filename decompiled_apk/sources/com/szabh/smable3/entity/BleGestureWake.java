package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleReadable;
import com.bestmafen.baseble.data.BleWritable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nBleGestureWake.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BleGestureWake.kt\ncom/szabh/smable3/entity/BleGestureWake\n+ 2 BleReadable.kt\ncom/bestmafen/baseble/data/BleReadable\n*L\n1#1,25:1\n222#2,4:26\n*S KotlinDebug\n*F\n+ 1 BleGestureWake.kt\ncom/szabh/smable3/entity/BleGestureWake\n*L\n18#1:26,4\n*E\n"})
/* loaded from: classes13.dex */
public final class BleGestureWake extends BleWritable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_LENGTH = 5;

    @OOXIXo
    private BleTimeRange mBleTimeRange;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BleGestureWake() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ BleGestureWake copy$default(BleGestureWake bleGestureWake, BleTimeRange bleTimeRange, int i, Object obj) {
        if ((i & 1) != 0) {
            bleTimeRange = bleGestureWake.mBleTimeRange;
        }
        return bleGestureWake.copy(bleTimeRange);
    }

    @OOXIXo
    public final BleTimeRange component1() {
        return this.mBleTimeRange;
    }

    @OOXIXo
    public final BleGestureWake copy(@OOXIXo BleTimeRange mBleTimeRange) {
        IIX0o.x0xO0oo(mBleTimeRange, "mBleTimeRange");
        return new BleGestureWake(mBleTimeRange);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        BleReadable bleReadable = (BleReadable) BleTimeRange.class.newInstance();
        bleReadable.setMBytes(readBytes(5));
        bleReadable.decode();
        IIX0o.ooOOo0oXI(bleReadable);
        this.mBleTimeRange = (BleTimeRange) bleReadable;
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public void encode() {
        super.encode();
        writeObject(this.mBleTimeRange);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof BleGestureWake) && IIX0o.Oxx0IOOO(this.mBleTimeRange, ((BleGestureWake) obj).mBleTimeRange);
    }

    @OOXIXo
    public final BleTimeRange getMBleTimeRange() {
        return this.mBleTimeRange;
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public int getMLengthToWrite() {
        return 5;
    }

    public int hashCode() {
        return this.mBleTimeRange.hashCode();
    }

    public final void setMBleTimeRange(@OOXIXo BleTimeRange bleTimeRange) {
        IIX0o.x0xO0oo(bleTimeRange, "<set-?>");
        this.mBleTimeRange = bleTimeRange;
    }

    @OOXIXo
    public String toString() {
        return "BleGestureWake(mBleTimeRange=" + this.mBleTimeRange + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleGestureWake(BleTimeRange bleTimeRange, int i, IIXOooo iIXOooo) {
        this((i & 1) != 0 ? new BleTimeRange(0, 0, 0, 0, 0, 31, null) : bleTimeRange);
    }

    public BleGestureWake(@OOXIXo BleTimeRange mBleTimeRange) {
        IIX0o.x0xO0oo(mBleTimeRange, "mBleTimeRange");
        this.mBleTimeRange = mBleTimeRange;
    }
}
