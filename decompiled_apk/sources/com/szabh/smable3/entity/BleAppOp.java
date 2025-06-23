package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleReadable;
import com.bestmafen.baseble.data.BleWritable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BleAppOp extends BleWritable {
    public static final int COMMAND_HIDE = 1;
    public static final int COMMAND_INSTALL = 3;
    public static final int COMMAND_SHOW = 2;
    public static final int COMMAND_UNINSTALL = 0;

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_LENGTH = 26;
    public static final int STATUS_FAIL = 2;
    public static final int STATUS_INSTALLING = 0;
    public static final int STATUS_SUCCESS = 1;
    private int mCommand;

    @OOXIXo
    private String mPackage;
    private int mStatus;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public BleAppOp() {
        this(0, null, 0, 7, null);
    }

    public static /* synthetic */ BleAppOp copy$default(BleAppOp bleAppOp, int i, String str, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = bleAppOp.mCommand;
        }
        if ((i3 & 2) != 0) {
            str = bleAppOp.mPackage;
        }
        if ((i3 & 4) != 0) {
            i2 = bleAppOp.mStatus;
        }
        return bleAppOp.copy(i, str, i2);
    }

    public final int component1() {
        return this.mCommand;
    }

    @OOXIXo
    public final String component2() {
        return this.mPackage;
    }

    public final int component3() {
        return this.mStatus;
    }

    @OOXIXo
    public final BleAppOp copy(int i, @OOXIXo String mPackage, int i2) {
        IIX0o.x0xO0oo(mPackage, "mPackage");
        return new BleAppOp(i, mPackage, i2);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        this.mCommand = readInt8();
        this.mPackage = BleReadable.readString$default(this, 24, null, 2, null);
        this.mStatus = readInt8();
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public void encode() {
        super.encode();
        writeInt8(this.mCommand);
        BleWritable.writeStringWithFix$default(this, this.mPackage, 24, null, 4, null);
        writeInt8(this.mStatus);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleAppOp)) {
            return false;
        }
        BleAppOp bleAppOp = (BleAppOp) obj;
        return this.mCommand == bleAppOp.mCommand && IIX0o.Oxx0IOOO(this.mPackage, bleAppOp.mPackage) && this.mStatus == bleAppOp.mStatus;
    }

    public final int getMCommand() {
        return this.mCommand;
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public int getMLengthToWrite() {
        return 26;
    }

    @OOXIXo
    public final String getMPackage() {
        return this.mPackage;
    }

    public final int getMStatus() {
        return this.mStatus;
    }

    public int hashCode() {
        return (((this.mCommand * 31) + this.mPackage.hashCode()) * 31) + this.mStatus;
    }

    public final void setMCommand(int i) {
        this.mCommand = i;
    }

    public final void setMPackage(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mPackage = str;
    }

    public final void setMStatus(int i) {
        this.mStatus = i;
    }

    @OOXIXo
    public String toString() {
        return "BleAppOp(mCommand=" + this.mCommand + ", mPackage='" + this.mPackage + "', mStatus=" + this.mStatus + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleAppOp(int i, String str, int i2, int i3, IIXOooo iIXOooo) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? "" : str, (i3 & 4) != 0 ? 0 : i2);
    }

    public BleAppOp(int i, @OOXIXo String mPackage, int i2) {
        IIX0o.x0xO0oo(mPackage, "mPackage");
        this.mCommand = i;
        this.mPackage = mPackage;
        this.mStatus = i2;
    }
}
