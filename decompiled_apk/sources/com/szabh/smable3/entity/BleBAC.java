package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleReadable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BleBAC extends BleReadable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_LENGTH = 12;
    private int mColor;
    private int mTime;
    private int mValue;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public BleBAC() {
        this(0, 0, 0, 7, null);
    }

    public static /* synthetic */ BleBAC copy$default(BleBAC bleBAC, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = bleBAC.mTime;
        }
        if ((i4 & 2) != 0) {
            i2 = bleBAC.mValue;
        }
        if ((i4 & 4) != 0) {
            i3 = bleBAC.mColor;
        }
        return bleBAC.copy(i, i2, i3);
    }

    public final int component1() {
        return this.mTime;
    }

    public final int component2() {
        return this.mValue;
    }

    public final int component3() {
        return this.mColor;
    }

    @OOXIXo
    public final BleBAC copy(int i, int i2, int i3) {
        return new BleBAC(i, i2, i3);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        this.mTime = BleReadable.readInt32$default(this, null, 1, null);
        this.mValue = BleReadable.readInt32$default(this, null, 1, null);
        this.mColor = readInt8();
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleBAC)) {
            return false;
        }
        BleBAC bleBAC = (BleBAC) obj;
        return this.mTime == bleBAC.mTime && this.mValue == bleBAC.mValue && this.mColor == bleBAC.mColor;
    }

    public final int getMColor() {
        return this.mColor;
    }

    public final int getMTime() {
        return this.mTime;
    }

    public final int getMValue() {
        return this.mValue;
    }

    public int hashCode() {
        return (((this.mTime * 31) + this.mValue) * 31) + this.mColor;
    }

    public final void setMColor(int i) {
        this.mColor = i;
    }

    public final void setMTime(int i) {
        this.mTime = i;
    }

    public final void setMValue(int i) {
        this.mValue = i;
    }

    @OOXIXo
    public String toString() {
        return "BleBAC(mTime=" + this.mTime + ", mValue=" + this.mValue + ", mColor=" + this.mColor + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleBAC(int i, int i2, int i3, int i4, IIXOooo iIXOooo) {
        this((i4 & 1) != 0 ? 0 : i, (i4 & 2) != 0 ? 0 : i2, (i4 & 4) != 0 ? 0 : i3);
    }

    public BleBAC(int i, int i2, int i3) {
        this.mTime = i;
        this.mValue = i2;
        this.mColor = i3;
    }
}
