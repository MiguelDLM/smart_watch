package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleReadable;
import com.bestmafen.baseble.data.BleWritable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.collections.ooOOo0oXI;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nBleCalibrationData.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BleCalibrationData.kt\ncom/szabh/smable3/entity/BleCalibrationData\n+ 2 BleReadable.kt\ncom/bestmafen/baseble/data/BleReadable$Companion\n*L\n1#1,68:1\n277#2,5:69\n*S KotlinDebug\n*F\n+ 1 BleCalibrationData.kt\ncom/szabh/smable3/entity/BleCalibrationData\n*L\n55#1:69,5\n*E\n"})
/* loaded from: classes13.dex */
public final class BleCalibrationData extends BleWritable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int TYPE_HR = 1;

    @OOXIXo
    private BleWritable mResponse;
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
    public BleCalibrationData() {
        this(0, null, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ BleCalibrationData copy$default(BleCalibrationData bleCalibrationData, int i, BleWritable bleWritable, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = bleCalibrationData.mType;
        }
        if ((i2 & 2) != 0) {
            bleWritable = bleCalibrationData.mResponse;
        }
        return bleCalibrationData.copy(i, bleWritable);
    }

    public final int component1() {
        return this.mType;
    }

    @OOXIXo
    public final BleWritable component2() {
        return this.mResponse;
    }

    @OOXIXo
    public final BleCalibrationData copy(int i, @OOXIXo BleWritable mResponse) {
        IIX0o.x0xO0oo(mResponse, "mResponse");
        return new BleCalibrationData(i, mResponse);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        BleWritable bleWritable;
        super.decode();
        this.mType = readUInt8();
        readInt8();
        if (this.mType == 1) {
            byte[] mBytes = getMBytes();
            IIX0o.ooOOo0oXI(mBytes);
            int length = mBytes.length;
            Object newInstance = BleCalibrationHrData.class.newInstance();
            BleReadable bleReadable = (BleReadable) newInstance;
            bleReadable.setMBytes(ooOOo0oXI.xxOXOOoIX(mBytes, 2, length));
            bleReadable.decode();
            IIX0o.oO(newInstance, "also(...)");
            bleWritable = (BleWritable) bleReadable;
        } else {
            bleWritable = new BleWritable();
        }
        this.mResponse = bleWritable;
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public void encode() {
        super.encode();
        writeInt8(this.mType);
        writeInt8(this.mResponse.getMLengthToWrite());
        writeObject(this.mResponse);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleCalibrationData)) {
            return false;
        }
        BleCalibrationData bleCalibrationData = (BleCalibrationData) obj;
        return this.mType == bleCalibrationData.mType && IIX0o.Oxx0IOOO(this.mResponse, bleCalibrationData.mResponse);
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public int getMLengthToWrite() {
        return this.mResponse.getMLengthToWrite() + 2;
    }

    @OOXIXo
    public final BleWritable getMResponse() {
        return this.mResponse;
    }

    public final int getMType() {
        return this.mType;
    }

    public int hashCode() {
        return (this.mType * 31) + this.mResponse.hashCode();
    }

    public final void setMResponse(@OOXIXo BleWritable bleWritable) {
        IIX0o.x0xO0oo(bleWritable, "<set-?>");
        this.mResponse = bleWritable;
    }

    public final void setMType(int i) {
        this.mType = i;
    }

    @OOXIXo
    public String toString() {
        return "BleFactoryTest(mType=" + this.mType + ", mResponse=" + this.mResponse + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleCalibrationData(int i, BleWritable bleWritable, int i2, IIXOooo iIXOooo) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? new BleWritable() : bleWritable);
    }

    public BleCalibrationData(int i, @OOXIXo BleWritable mResponse) {
        IIX0o.x0xO0oo(mResponse, "mResponse");
        this.mType = i;
        this.mResponse = mResponse;
    }
}
