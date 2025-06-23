package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleReadable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.nio.ByteOrder;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BleHRRaw extends BleReadable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_LENGTH = 4;
    private int mPpg;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public BleHRRaw() {
        this(0, 1, null);
    }

    public static /* synthetic */ BleHRRaw copy$default(BleHRRaw bleHRRaw, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = bleHRRaw.mPpg;
        }
        return bleHRRaw.copy(i);
    }

    public final int component1() {
        return this.mPpg;
    }

    @OOXIXo
    public final BleHRRaw copy(int i) {
        return new BleHRRaw(i);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        ByteOrder LITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        this.mPpg = readInt32(LITTLE_ENDIAN);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof BleHRRaw) && this.mPpg == ((BleHRRaw) obj).mPpg;
    }

    public final int getMPpg() {
        return this.mPpg;
    }

    public int hashCode() {
        return this.mPpg;
    }

    public final void setMPpg(int i) {
        this.mPpg = i;
    }

    @OOXIXo
    public String toString() {
        return "BleHRRaw(mPpg=" + this.mPpg + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleHRRaw(int i, int i2, IIXOooo iIXOooo) {
        this((i2 & 1) != 0 ? 0 : i);
    }

    public BleHRRaw(int i) {
        this.mPpg = i;
    }
}
