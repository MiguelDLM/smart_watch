package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleReadable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.io.Serializable;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BleMatchRecordPlayer extends BleReadable implements Serializable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_LENGTH = 26;
    public static final int NAME_LENGTH = 25;

    @OOXIXo
    private String mName;
    private int mNum;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BleMatchRecordPlayer() {
        this(null, 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ BleMatchRecordPlayer copy$default(BleMatchRecordPlayer bleMatchRecordPlayer, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = bleMatchRecordPlayer.mName;
        }
        if ((i2 & 2) != 0) {
            i = bleMatchRecordPlayer.mNum;
        }
        return bleMatchRecordPlayer.copy(str, i);
    }

    @OOXIXo
    public final String component1() {
        return this.mName;
    }

    public final int component2() {
        return this.mNum;
    }

    @OOXIXo
    public final BleMatchRecordPlayer copy(@OOXIXo String mName, int i) {
        IIX0o.x0xO0oo(mName, "mName");
        return new BleMatchRecordPlayer(mName, i);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        this.mName = BleReadable.readString$default(this, 25, null, 2, null);
        this.mNum = readInt8();
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleMatchRecordPlayer)) {
            return false;
        }
        BleMatchRecordPlayer bleMatchRecordPlayer = (BleMatchRecordPlayer) obj;
        return IIX0o.Oxx0IOOO(this.mName, bleMatchRecordPlayer.mName) && this.mNum == bleMatchRecordPlayer.mNum;
    }

    @OOXIXo
    public final String getMName() {
        return this.mName;
    }

    public final int getMNum() {
        return this.mNum;
    }

    public int hashCode() {
        return (this.mName.hashCode() * 31) + this.mNum;
    }

    public final void setMName(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mName = str;
    }

    public final void setMNum(int i) {
        this.mNum = i;
    }

    @OOXIXo
    public String toString() {
        return "BleMatchRecordPlayer(mName=" + this.mName + ", mNum=" + this.mNum + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleMatchRecordPlayer(String str, int i, int i2, IIXOooo iIXOooo) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? 0 : i);
    }

    public BleMatchRecordPlayer(@OOXIXo String mName, int i) {
        IIX0o.x0xO0oo(mName, "mName");
        this.mName = mName;
        this.mNum = i;
    }
}
