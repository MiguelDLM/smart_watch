package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleWritable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.nio.ByteOrder;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BleGameControl extends BleWritable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_LENGTH = 16;
    public static final int STATE_CLOSE_GSENSOR = 6;
    public static final int STATE_END = 4;
    public static final int STATE_GOING = 1;
    public static final int STATE_OPEN_GSENSOR = 5;
    public static final int STATE_PAUSE = 3;
    public static final int STATE_RESUME = 2;
    public static final int STATE_START = 0;
    private int mState;
    private int mX;
    private int mY;
    private int mZ;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public BleGameControl() {
        this(0, 0, 0, 0, 15, null);
    }

    public static /* synthetic */ BleGameControl copy$default(BleGameControl bleGameControl, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = bleGameControl.mState;
        }
        if ((i5 & 2) != 0) {
            i2 = bleGameControl.mX;
        }
        if ((i5 & 4) != 0) {
            i3 = bleGameControl.mY;
        }
        if ((i5 & 8) != 0) {
            i4 = bleGameControl.mZ;
        }
        return bleGameControl.copy(i, i2, i3, i4);
    }

    public final int component1() {
        return this.mState;
    }

    public final int component2() {
        return this.mX;
    }

    public final int component3() {
        return this.mY;
    }

    public final int component4() {
        return this.mZ;
    }

    @OOXIXo
    public final BleGameControl copy(int i, int i2, int i3, int i4) {
        return new BleGameControl(i, i2, i3, i4);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        this.mState = readInt8();
        readInt8();
        ByteOrder LITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        this.mX = readInt16(LITTLE_ENDIAN);
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        this.mY = readInt16(LITTLE_ENDIAN);
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        this.mZ = readInt16(LITTLE_ENDIAN);
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public void encode() {
        super.encode();
        writeInt8(this.mState);
        writeInt8(0);
        int i = this.mX;
        ByteOrder LITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        writeInt16(i, LITTLE_ENDIAN);
        int i2 = this.mY;
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        writeInt16(i2, LITTLE_ENDIAN);
        int i3 = this.mZ;
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        writeInt16(i3, LITTLE_ENDIAN);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleGameControl)) {
            return false;
        }
        BleGameControl bleGameControl = (BleGameControl) obj;
        return this.mState == bleGameControl.mState && this.mX == bleGameControl.mX && this.mY == bleGameControl.mY && this.mZ == bleGameControl.mZ;
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public int getMLengthToWrite() {
        return 16;
    }

    public final int getMState() {
        return this.mState;
    }

    public final int getMX() {
        return this.mX;
    }

    public final int getMY() {
        return this.mY;
    }

    public final int getMZ() {
        return this.mZ;
    }

    public int hashCode() {
        return (((((this.mState * 31) + this.mX) * 31) + this.mY) * 31) + this.mZ;
    }

    public final void setMState(int i) {
        this.mState = i;
    }

    public final void setMX(int i) {
        this.mX = i;
    }

    public final void setMY(int i) {
        this.mY = i;
    }

    public final void setMZ(int i) {
        this.mZ = i;
    }

    @OOXIXo
    public String toString() {
        return "BleGameControl(mState=" + this.mState + ", mX=" + this.mX + ", mY=" + this.mY + ", mZ=" + this.mZ + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleGameControl(int i, int i2, int i3, int i4, int i5, IIXOooo iIXOooo) {
        this((i5 & 1) != 0 ? 0 : i, (i5 & 2) != 0 ? 0 : i2, (i5 & 4) != 0 ? 0 : i3, (i5 & 8) != 0 ? 0 : i4);
    }

    public BleGameControl(int i, int i2, int i3, int i4) {
        this.mState = i;
        this.mX = i2;
        this.mY = i3;
        this.mZ = i4;
    }
}
