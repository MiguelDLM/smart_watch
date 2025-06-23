package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleReadable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BleTestKeyData extends BleReadable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_LENGTH = 2;
    public static final int KEY_DOWN = 3;
    public static final int KEY_HOME = 1;
    public static final int KEY_KNOB_DOWN = 6;
    public static final int KEY_KNOB_UP = 5;
    public static final int KEY_POWER = 0;
    public static final int KEY_UP = 2;
    public static final int KEY_WORKOUT = 4;
    private int mType;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public BleTestKeyData() {
        this(0, 1, null);
    }

    public static /* synthetic */ BleTestKeyData copy$default(BleTestKeyData bleTestKeyData, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = bleTestKeyData.mType;
        }
        return bleTestKeyData.copy(i);
    }

    public final int component1() {
        return this.mType;
    }

    @OOXIXo
    public final BleTestKeyData copy(int i) {
        return new BleTestKeyData(i);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        this.mType = readInt8();
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof BleTestKeyData) && this.mType == ((BleTestKeyData) obj).mType;
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
        return "BleTestKeyData(mType=" + this.mType + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleTestKeyData(int i, int i2, IIXOooo iIXOooo) {
        this((i2 & 1) != 0 ? 0 : i);
    }

    public BleTestKeyData(int i) {
        this.mType = i;
    }
}
