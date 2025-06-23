package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleWritable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BleDeviceOp extends BleWritable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_LENGTH = 4;
    public static final int TYPE_REBOOT = 1;
    public static final int TYPE_RESTORE_FACTORY = 3;
    public static final int TYPE_RESTORE_FACTORY_ALL = 2;
    public static final int TYPE_SHUTDOWN = 0;
    private int mType;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public BleDeviceOp() {
        this(0, 1, null);
    }

    public static /* synthetic */ BleDeviceOp copy$default(BleDeviceOp bleDeviceOp, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = bleDeviceOp.mType;
        }
        return bleDeviceOp.copy(i);
    }

    public final int component1() {
        return this.mType;
    }

    @OOXIXo
    public final BleDeviceOp copy(int i) {
        return new BleDeviceOp(i);
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public void encode() {
        super.encode();
        writeInt8(this.mType);
        BleWritable.writeInt24$default(this, 0, null, 2, null);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof BleDeviceOp) && this.mType == ((BleDeviceOp) obj).mType;
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public int getMLengthToWrite() {
        return 4;
    }

    public final int getMType() {
        return this.mType;
    }

    public int hashCode() {
        return this.mType;
    }

    public final void setMType(int i) {
        this.mType = i;
    }

    @OOXIXo
    public String toString() {
        return "BleDeviceOp(mType=" + this.mType + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleDeviceOp(int i, int i2, IIXOooo iIXOooo) {
        this((i2 & 1) != 0 ? 0 : i);
    }

    public BleDeviceOp(int i) {
        this.mType = i;
    }
}
