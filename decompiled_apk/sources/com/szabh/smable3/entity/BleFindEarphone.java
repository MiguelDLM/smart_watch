package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleWritable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BleFindEarphone extends BleWritable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_LENGTH = 2;
    private int mLeft;
    private int mRight;

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
    public BleFindEarphone() {
        /*
            r3 = this;
            r0 = 3
            r1 = 0
            r2 = 0
            r3.<init>(r2, r2, r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.szabh.smable3.entity.BleFindEarphone.<init>():void");
    }

    public static /* synthetic */ BleFindEarphone copy$default(BleFindEarphone bleFindEarphone, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = bleFindEarphone.mLeft;
        }
        if ((i3 & 2) != 0) {
            i2 = bleFindEarphone.mRight;
        }
        return bleFindEarphone.copy(i, i2);
    }

    public final int component1() {
        return this.mLeft;
    }

    public final int component2() {
        return this.mRight;
    }

    @OOXIXo
    public final BleFindEarphone copy(int i, int i2) {
        return new BleFindEarphone(i, i2);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        this.mLeft = readInt8();
        this.mRight = readInt8();
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public void encode() {
        super.encode();
        writeInt8(this.mLeft);
        writeInt8(this.mRight);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleFindEarphone)) {
            return false;
        }
        BleFindEarphone bleFindEarphone = (BleFindEarphone) obj;
        return this.mLeft == bleFindEarphone.mLeft && this.mRight == bleFindEarphone.mRight;
    }

    public final int getMLeft() {
        return this.mLeft;
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public int getMLengthToWrite() {
        return 2;
    }

    public final int getMRight() {
        return this.mRight;
    }

    public int hashCode() {
        return (this.mLeft * 31) + this.mRight;
    }

    public final void setMLeft(int i) {
        this.mLeft = i;
    }

    public final void setMRight(int i) {
        this.mRight = i;
    }

    @OOXIXo
    public String toString() {
        return "BleFindEarphone(mLeft=" + this.mLeft + ", mRight=" + this.mRight + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleFindEarphone(int i, int i2, int i3, IIXOooo iIXOooo) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2);
    }

    public BleFindEarphone(int i, int i2) {
        this.mLeft = i;
        this.mRight = i2;
    }
}
