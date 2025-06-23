package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleWritable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BleAppSportState extends BleWritable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_LENGTH = 2;
    public static final int MODE_CLIMBING = 13;
    public static final int MODE_CYCLING = 10;
    public static final int MODE_INDOOR = 8;
    public static final int MODE_OUTDOOR = 9;
    public static final int STATE_END = 4;
    public static final int STATE_PAUSE = 3;
    public static final int STATE_RESUME = 2;
    public static final int STATE_START = 1;
    private int mMode;
    private int mState;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public BleAppSportState() {
        /*
            r3 = this;
            r0 = 3
            r1 = 0
            r2 = 0
            r3.<init>(r2, r2, r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.szabh.smable3.entity.BleAppSportState.<init>():void");
    }

    public static /* synthetic */ BleAppSportState copy$default(BleAppSportState bleAppSportState, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = bleAppSportState.mMode;
        }
        if ((i3 & 2) != 0) {
            i2 = bleAppSportState.mState;
        }
        return bleAppSportState.copy(i, i2);
    }

    public final int component1() {
        return this.mMode;
    }

    public final int component2() {
        return this.mState;
    }

    @OOXIXo
    public final BleAppSportState copy(int i, int i2) {
        return new BleAppSportState(i, i2);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        this.mMode = readInt8();
        this.mState = readInt8();
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public void encode() {
        super.encode();
        writeInt8(this.mMode);
        writeInt8(this.mState);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleAppSportState)) {
            return false;
        }
        BleAppSportState bleAppSportState = (BleAppSportState) obj;
        return this.mMode == bleAppSportState.mMode && this.mState == bleAppSportState.mState;
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public int getMLengthToWrite() {
        return 2;
    }

    public final int getMMode() {
        return this.mMode;
    }

    public final int getMState() {
        return this.mState;
    }

    public int hashCode() {
        return (this.mMode * 31) + this.mState;
    }

    public final void setMMode(int i) {
        this.mMode = i;
    }

    public final void setMState(int i) {
        this.mState = i;
    }

    @OOXIXo
    public String toString() {
        return "BleAppSportState(mMode=" + this.mMode + ", mState=" + this.mState + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleAppSportState(int i, int i2, int i3, IIXOooo iIXOooo) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2);
    }

    public BleAppSportState(int i, int i2) {
        this.mMode = i;
        this.mState = i2;
    }
}
