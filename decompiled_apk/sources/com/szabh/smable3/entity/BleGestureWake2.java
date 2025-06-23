package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleReadable;
import com.bestmafen.baseble.data.BleWritable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nBleGestureWake2.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BleGestureWake2.kt\ncom/szabh/smable3/entity/BleGestureWake2\n+ 2 BleReadable.kt\ncom/bestmafen/baseble/data/BleReadable\n*L\n1#1,30:1\n222#2,4:31\n*S KotlinDebug\n*F\n+ 1 BleGestureWake2.kt\ncom/szabh/smable3/entity/BleGestureWake2\n*L\n22#1:31,4\n*E\n"})
/* loaded from: classes13.dex */
public final class BleGestureWake2 extends BleWritable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_LENGTH = 8;

    @OOXIXo
    private BleTimeRange mBleTimeRange1;
    private int mEnabled;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BleGestureWake2() {
        this(0, null, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ BleGestureWake2 copy$default(BleGestureWake2 bleGestureWake2, int i, BleTimeRange bleTimeRange, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = bleGestureWake2.mEnabled;
        }
        if ((i2 & 2) != 0) {
            bleTimeRange = bleGestureWake2.mBleTimeRange1;
        }
        return bleGestureWake2.copy(i, bleTimeRange);
    }

    public final int component1() {
        return this.mEnabled;
    }

    @OOXIXo
    public final BleTimeRange component2() {
        return this.mBleTimeRange1;
    }

    @OOXIXo
    public final BleGestureWake2 copy(int i, @OOXIXo BleTimeRange mBleTimeRange1) {
        IIX0o.x0xO0oo(mBleTimeRange1, "mBleTimeRange1");
        return new BleGestureWake2(i, mBleTimeRange1);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        this.mEnabled = readUInt8();
        BleReadable bleReadable = (BleReadable) BleTimeRange.class.newInstance();
        bleReadable.setMBytes(readBytes(5));
        bleReadable.decode();
        IIX0o.ooOOo0oXI(bleReadable);
        this.mBleTimeRange1 = (BleTimeRange) bleReadable;
        BleReadable.readInt16$default(this, null, 1, null);
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public void encode() {
        super.encode();
        writeInt8(this.mEnabled);
        writeObject(this.mBleTimeRange1);
        BleWritable.writeInt16$default(this, 0, null, 2, null);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleGestureWake2)) {
            return false;
        }
        BleGestureWake2 bleGestureWake2 = (BleGestureWake2) obj;
        return this.mEnabled == bleGestureWake2.mEnabled && IIX0o.Oxx0IOOO(this.mBleTimeRange1, bleGestureWake2.mBleTimeRange1);
    }

    @OOXIXo
    public final BleTimeRange getMBleTimeRange1() {
        return this.mBleTimeRange1;
    }

    public final int getMEnabled() {
        return this.mEnabled;
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public int getMLengthToWrite() {
        return 8;
    }

    public int hashCode() {
        return (this.mEnabled * 31) + this.mBleTimeRange1.hashCode();
    }

    public final void setMBleTimeRange1(@OOXIXo BleTimeRange bleTimeRange) {
        IIX0o.x0xO0oo(bleTimeRange, "<set-?>");
        this.mBleTimeRange1 = bleTimeRange;
    }

    public final void setMEnabled(int i) {
        this.mEnabled = i;
    }

    @OOXIXo
    public String toString() {
        return "BleGestureWake2(mEnabled=" + this.mEnabled + ", mBleTimeRange1=" + this.mBleTimeRange1 + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleGestureWake2(int i, BleTimeRange bleTimeRange, int i2, IIXOooo iIXOooo) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? new BleTimeRange(0, 0, 0, 0, 0, 31, null) : bleTimeRange);
    }

    public BleGestureWake2(int i, @OOXIXo BleTimeRange mBleTimeRange1) {
        IIX0o.x0xO0oo(mBleTimeRange1, "mBleTimeRange1");
        this.mEnabled = i;
        this.mBleTimeRange1 = mBleTimeRange1;
    }
}
