package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleReadable;
import com.bestmafen.baseble.data.BleWritable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nBleNoDisturbSettings.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BleNoDisturbSettings.kt\ncom/szabh/smable3/entity/BleNoDisturbSettings\n+ 2 BleReadable.kt\ncom/bestmafen/baseble/data/BleReadable\n*L\n1#1,34:1\n222#2,4:35\n222#2,4:39\n222#2,4:43\n*S KotlinDebug\n*F\n+ 1 BleNoDisturbSettings.kt\ncom/szabh/smable3/entity/BleNoDisturbSettings\n*L\n25#1:35,4\n26#1:39,4\n27#1:43,4\n*E\n"})
/* loaded from: classes13.dex */
public final class BleNoDisturbSettings extends BleWritable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_LENGTH = 16;

    @OOXIXo
    private BleTimeRange mBleTimeRange1;

    @OOXIXo
    private BleTimeRange mBleTimeRange2;

    @OOXIXo
    private BleTimeRange mBleTimeRange3;
    private int mEnabled;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public BleNoDisturbSettings() {
        this(0, null, null, null, 15, null);
    }

    public static /* synthetic */ BleNoDisturbSettings copy$default(BleNoDisturbSettings bleNoDisturbSettings, int i, BleTimeRange bleTimeRange, BleTimeRange bleTimeRange2, BleTimeRange bleTimeRange3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = bleNoDisturbSettings.mEnabled;
        }
        if ((i2 & 2) != 0) {
            bleTimeRange = bleNoDisturbSettings.mBleTimeRange1;
        }
        if ((i2 & 4) != 0) {
            bleTimeRange2 = bleNoDisturbSettings.mBleTimeRange2;
        }
        if ((i2 & 8) != 0) {
            bleTimeRange3 = bleNoDisturbSettings.mBleTimeRange3;
        }
        return bleNoDisturbSettings.copy(i, bleTimeRange, bleTimeRange2, bleTimeRange3);
    }

    public final int component1() {
        return this.mEnabled;
    }

    @OOXIXo
    public final BleTimeRange component2() {
        return this.mBleTimeRange1;
    }

    @OOXIXo
    public final BleTimeRange component3() {
        return this.mBleTimeRange2;
    }

    @OOXIXo
    public final BleTimeRange component4() {
        return this.mBleTimeRange3;
    }

    @OOXIXo
    public final BleNoDisturbSettings copy(int i, @OOXIXo BleTimeRange mBleTimeRange1, @OOXIXo BleTimeRange mBleTimeRange2, @OOXIXo BleTimeRange mBleTimeRange3) {
        IIX0o.x0xO0oo(mBleTimeRange1, "mBleTimeRange1");
        IIX0o.x0xO0oo(mBleTimeRange2, "mBleTimeRange2");
        IIX0o.x0xO0oo(mBleTimeRange3, "mBleTimeRange3");
        return new BleNoDisturbSettings(i, mBleTimeRange1, mBleTimeRange2, mBleTimeRange3);
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
        BleReadable bleReadable2 = (BleReadable) BleTimeRange.class.newInstance();
        bleReadable2.setMBytes(readBytes(5));
        bleReadable2.decode();
        IIX0o.ooOOo0oXI(bleReadable2);
        this.mBleTimeRange2 = (BleTimeRange) bleReadable2;
        BleReadable bleReadable3 = (BleReadable) BleTimeRange.class.newInstance();
        bleReadable3.setMBytes(readBytes(5));
        bleReadable3.decode();
        IIX0o.ooOOo0oXI(bleReadable3);
        this.mBleTimeRange3 = (BleTimeRange) bleReadable3;
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public void encode() {
        super.encode();
        writeInt8(this.mEnabled);
        writeObject(this.mBleTimeRange1);
        writeObject(this.mBleTimeRange2);
        writeObject(this.mBleTimeRange3);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleNoDisturbSettings)) {
            return false;
        }
        BleNoDisturbSettings bleNoDisturbSettings = (BleNoDisturbSettings) obj;
        return this.mEnabled == bleNoDisturbSettings.mEnabled && IIX0o.Oxx0IOOO(this.mBleTimeRange1, bleNoDisturbSettings.mBleTimeRange1) && IIX0o.Oxx0IOOO(this.mBleTimeRange2, bleNoDisturbSettings.mBleTimeRange2) && IIX0o.Oxx0IOOO(this.mBleTimeRange3, bleNoDisturbSettings.mBleTimeRange3);
    }

    @OOXIXo
    public final BleTimeRange getMBleTimeRange1() {
        return this.mBleTimeRange1;
    }

    @OOXIXo
    public final BleTimeRange getMBleTimeRange2() {
        return this.mBleTimeRange2;
    }

    @OOXIXo
    public final BleTimeRange getMBleTimeRange3() {
        return this.mBleTimeRange3;
    }

    public final int getMEnabled() {
        return this.mEnabled;
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public int getMLengthToWrite() {
        return 16;
    }

    public int hashCode() {
        return (((((this.mEnabled * 31) + this.mBleTimeRange1.hashCode()) * 31) + this.mBleTimeRange2.hashCode()) * 31) + this.mBleTimeRange3.hashCode();
    }

    public final void setMBleTimeRange1(@OOXIXo BleTimeRange bleTimeRange) {
        IIX0o.x0xO0oo(bleTimeRange, "<set-?>");
        this.mBleTimeRange1 = bleTimeRange;
    }

    public final void setMBleTimeRange2(@OOXIXo BleTimeRange bleTimeRange) {
        IIX0o.x0xO0oo(bleTimeRange, "<set-?>");
        this.mBleTimeRange2 = bleTimeRange;
    }

    public final void setMBleTimeRange3(@OOXIXo BleTimeRange bleTimeRange) {
        IIX0o.x0xO0oo(bleTimeRange, "<set-?>");
        this.mBleTimeRange3 = bleTimeRange;
    }

    public final void setMEnabled(int i) {
        this.mEnabled = i;
    }

    @OOXIXo
    public String toString() {
        return "BleNoDisturbSettings(mEnabled=" + this.mEnabled + ", mBleTimeRange1=" + this.mBleTimeRange1 + ", mBleTimeRange2=" + this.mBleTimeRange2 + ", mBleTimeRange3=" + this.mBleTimeRange3 + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleNoDisturbSettings(int i, BleTimeRange bleTimeRange, BleTimeRange bleTimeRange2, BleTimeRange bleTimeRange3, int i2, IIXOooo iIXOooo) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? new BleTimeRange(0, 0, 0, 0, 0, 31, null) : bleTimeRange, (i2 & 4) != 0 ? new BleTimeRange(0, 0, 0, 0, 0, 31, null) : bleTimeRange2, (i2 & 8) != 0 ? new BleTimeRange(0, 0, 0, 0, 0, 31, null) : bleTimeRange3);
    }

    public BleNoDisturbSettings(int i, @OOXIXo BleTimeRange mBleTimeRange1, @OOXIXo BleTimeRange mBleTimeRange2, @OOXIXo BleTimeRange mBleTimeRange3) {
        IIX0o.x0xO0oo(mBleTimeRange1, "mBleTimeRange1");
        IIX0o.x0xO0oo(mBleTimeRange2, "mBleTimeRange2");
        IIX0o.x0xO0oo(mBleTimeRange3, "mBleTimeRange3");
        this.mEnabled = i;
        this.mBleTimeRange1 = mBleTimeRange1;
        this.mBleTimeRange2 = mBleTimeRange2;
        this.mBleTimeRange3 = mBleTimeRange3;
    }
}
