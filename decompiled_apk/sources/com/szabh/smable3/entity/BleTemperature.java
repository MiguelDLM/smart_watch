package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleReadable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BleTemperature extends BleReadable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_LENGTH = 6;
    private int mTemperature;
    private int mTime;

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
    public BleTemperature() {
        /*
            r3 = this;
            r0 = 3
            r1 = 0
            r2 = 0
            r3.<init>(r2, r2, r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.szabh.smable3.entity.BleTemperature.<init>():void");
    }

    public static /* synthetic */ BleTemperature copy$default(BleTemperature bleTemperature, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = bleTemperature.mTime;
        }
        if ((i3 & 2) != 0) {
            i2 = bleTemperature.mTemperature;
        }
        return bleTemperature.copy(i, i2);
    }

    public final int component1() {
        return this.mTime;
    }

    public final int component2() {
        return this.mTemperature;
    }

    @OOXIXo
    public final BleTemperature copy(int i, int i2) {
        return new BleTemperature(i, i2);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        this.mTime = BleReadable.readInt32$default(this, null, 1, null);
        this.mTemperature = BleReadable.readInt16$default(this, null, 1, null);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleTemperature)) {
            return false;
        }
        BleTemperature bleTemperature = (BleTemperature) obj;
        return this.mTime == bleTemperature.mTime && this.mTemperature == bleTemperature.mTemperature;
    }

    public final int getMTemperature() {
        return this.mTemperature;
    }

    public final int getMTime() {
        return this.mTime;
    }

    public int hashCode() {
        return (this.mTime * 31) + this.mTemperature;
    }

    public final void setMTemperature(int i) {
        this.mTemperature = i;
    }

    public final void setMTime(int i) {
        this.mTime = i;
    }

    @OOXIXo
    public String toString() {
        return "BleTemperature(mTime=" + this.mTime + ", mTemperature=" + this.mTemperature + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleTemperature(int i, int i2, int i3, IIXOooo iIXOooo) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2);
    }

    public BleTemperature(int i, int i2) {
        this.mTime = i;
        this.mTemperature = i2;
    }
}
