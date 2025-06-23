package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleReadable;
import com.bestmafen.baseble.data.BleWritable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nBleGirlCareSettings.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BleGirlCareSettings.kt\ncom/szabh/smable3/entity/BleGirlCareMenstruationDate\n+ 2 BleReadable.kt\ncom/bestmafen/baseble/data/BleReadable\n*L\n1#1,82:1\n222#2,4:83\n*S KotlinDebug\n*F\n+ 1 BleGirlCareSettings.kt\ncom/szabh/smable3/entity/BleGirlCareMenstruationDate\n*L\n21#1:83,4\n*E\n"})
/* loaded from: classes13.dex */
public final class BleGirlCareMenstruationDate extends BleWritable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_LENGTH = 7;

    @OOXIXo
    private BleTime mTime;
    private int mType;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BleGirlCareMenstruationDate() {
        this(0, null, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ BleGirlCareMenstruationDate copy$default(BleGirlCareMenstruationDate bleGirlCareMenstruationDate, int i, BleTime bleTime, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = bleGirlCareMenstruationDate.mType;
        }
        if ((i2 & 2) != 0) {
            bleTime = bleGirlCareMenstruationDate.mTime;
        }
        return bleGirlCareMenstruationDate.copy(i, bleTime);
    }

    public final int component1() {
        return this.mType;
    }

    @OOXIXo
    public final BleTime component2() {
        return this.mTime;
    }

    @OOXIXo
    public final BleGirlCareMenstruationDate copy(int i, @OOXIXo BleTime mTime) {
        IIX0o.x0xO0oo(mTime, "mTime");
        return new BleGirlCareMenstruationDate(i, mTime);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        this.mType = readInt8();
        BleReadable bleReadable = (BleReadable) BleTime.class.newInstance();
        bleReadable.setMBytes(readBytes(6));
        bleReadable.decode();
        IIX0o.ooOOo0oXI(bleReadable);
        this.mTime = (BleTime) bleReadable;
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public void encode() {
        super.encode();
        writeInt8(this.mType);
        writeObject(this.mTime);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleGirlCareMenstruationDate)) {
            return false;
        }
        BleGirlCareMenstruationDate bleGirlCareMenstruationDate = (BleGirlCareMenstruationDate) obj;
        return this.mType == bleGirlCareMenstruationDate.mType && IIX0o.Oxx0IOOO(this.mTime, bleGirlCareMenstruationDate.mTime);
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public int getMLengthToWrite() {
        return 7;
    }

    @OOXIXo
    public final BleTime getMTime() {
        return this.mTime;
    }

    public final int getMType() {
        return this.mType;
    }

    public int hashCode() {
        return (this.mType * 31) + this.mTime.hashCode();
    }

    public final void setMTime(@OOXIXo BleTime bleTime) {
        IIX0o.x0xO0oo(bleTime, "<set-?>");
        this.mTime = bleTime;
    }

    public final void setMType(int i) {
        this.mType = i;
    }

    @OOXIXo
    public String toString() {
        return "BleGirlCareMenstruationDate(mType=" + this.mType + ", mTime=" + this.mTime + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleGirlCareMenstruationDate(int i, BleTime bleTime, int i2, IIXOooo iIXOooo) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? new BleTime(0, 0, 0, 0, 0, 0, 63, null) : bleTime);
    }

    public BleGirlCareMenstruationDate(int i, @OOXIXo BleTime mTime) {
        IIX0o.x0xO0oo(mTime, "mTime");
        this.mType = i;
        this.mTime = mTime;
    }
}
