package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleReadable;
import com.bestmafen.baseble.data.BleWritable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BleRange extends BleWritable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_LENGTH = 12;
    private int mEnd;
    private int mStart;

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
    public BleRange() {
        /*
            r3 = this;
            r0 = 3
            r1 = 0
            r2 = 0
            r3.<init>(r2, r2, r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.szabh.smable3.entity.BleRange.<init>():void");
    }

    public static /* synthetic */ BleRange copy$default(BleRange bleRange, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = bleRange.mStart;
        }
        if ((i3 & 2) != 0) {
            i2 = bleRange.mEnd;
        }
        return bleRange.copy(i, i2);
    }

    public final int component1() {
        return this.mStart;
    }

    public final int component2() {
        return this.mEnd;
    }

    @OOXIXo
    public final BleRange copy(int i, int i2) {
        return new BleRange(i, i2);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        this.mStart = BleReadable.readInt32$default(this, null, 1, null);
        this.mEnd = BleReadable.readInt32$default(this, null, 1, null);
        BleReadable.readInt32$default(this, null, 1, null);
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public void encode() {
        super.encode();
        BleWritable.writeInt32$default(this, this.mStart, null, 2, null);
        BleWritable.writeInt32$default(this, this.mEnd, null, 2, null);
        BleWritable.writeInt32$default(this, 0, null, 2, null);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleRange)) {
            return false;
        }
        BleRange bleRange = (BleRange) obj;
        return this.mStart == bleRange.mStart && this.mEnd == bleRange.mEnd;
    }

    public final int getMEnd() {
        return this.mEnd;
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public int getMLengthToWrite() {
        return 12;
    }

    public final int getMStart() {
        return this.mStart;
    }

    public int hashCode() {
        return (this.mStart * 31) + this.mEnd;
    }

    public final void setMEnd(int i) {
        this.mEnd = i;
    }

    public final void setMStart(int i) {
        this.mStart = i;
    }

    @OOXIXo
    public String toString() {
        return "BleRange(mStart=" + this.mStart + ", mEnd=" + this.mEnd + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleRange(int i, int i2, int i3, IIXOooo iIXOooo) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2);
    }

    public BleRange(int i, int i2) {
        this.mStart = i;
        this.mEnd = i2;
    }
}
