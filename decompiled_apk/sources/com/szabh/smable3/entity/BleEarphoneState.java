package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleReadable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BleEarphoneState extends BleReadable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int STATE_CHARGE_CONNECTED = 1;
    public static final int STATE_CHARGING = 0;
    public static final int STATE_PHONE_CONNECTED = 2;
    public static final int STATE_SHUTDOWN = 3;
    private int mLeftState;
    private int mRightState;

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
    public BleEarphoneState() {
        /*
            r3 = this;
            r0 = 3
            r1 = 0
            r2 = 0
            r3.<init>(r2, r2, r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.szabh.smable3.entity.BleEarphoneState.<init>():void");
    }

    public static /* synthetic */ BleEarphoneState copy$default(BleEarphoneState bleEarphoneState, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = bleEarphoneState.mLeftState;
        }
        if ((i3 & 2) != 0) {
            i2 = bleEarphoneState.mRightState;
        }
        return bleEarphoneState.copy(i, i2);
    }

    public final int component1() {
        return this.mLeftState;
    }

    public final int component2() {
        return this.mRightState;
    }

    @OOXIXo
    public final BleEarphoneState copy(int i, int i2) {
        return new BleEarphoneState(i, i2);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        this.mLeftState = readInt8();
        this.mRightState = readInt8();
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleEarphoneState)) {
            return false;
        }
        BleEarphoneState bleEarphoneState = (BleEarphoneState) obj;
        return this.mLeftState == bleEarphoneState.mLeftState && this.mRightState == bleEarphoneState.mRightState;
    }

    public final int getMLeftState() {
        return this.mLeftState;
    }

    public final int getMRightState() {
        return this.mRightState;
    }

    public int hashCode() {
        return (this.mLeftState * 31) + this.mRightState;
    }

    public final void setMLeftState(int i) {
        this.mLeftState = i;
    }

    public final void setMRightState(int i) {
        this.mRightState = i;
    }

    @OOXIXo
    public String toString() {
        return "BleEarphoneState(mLeftState=" + this.mLeftState + ", mRightState=" + this.mRightState + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleEarphoneState(int i, int i2, int i3, IIXOooo iIXOooo) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2);
    }

    public BleEarphoneState(int i, int i2) {
        this.mLeftState = i;
        this.mRightState = i2;
    }
}
