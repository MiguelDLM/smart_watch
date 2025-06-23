package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleWritable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BleSGKeySet extends BleWritable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_LENGTH = 8;
    public static final int TYPE_BURST = 3;
    public static final int TYPE_PHOTO = 1;
    public static final int TYPE_VIDEO = 2;
    private int mClick;
    private int mLong1;

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
    public BleSGKeySet() {
        /*
            r3 = this;
            r0 = 3
            r1 = 0
            r2 = 0
            r3.<init>(r2, r2, r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.szabh.smable3.entity.BleSGKeySet.<init>():void");
    }

    public static /* synthetic */ BleSGKeySet copy$default(BleSGKeySet bleSGKeySet, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = bleSGKeySet.mClick;
        }
        if ((i3 & 2) != 0) {
            i2 = bleSGKeySet.mLong1;
        }
        return bleSGKeySet.copy(i, i2);
    }

    public final int component1() {
        return this.mClick;
    }

    public final int component2() {
        return this.mLong1;
    }

    @OOXIXo
    public final BleSGKeySet copy(int i, int i2) {
        return new BleSGKeySet(i, i2);
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public void encode() {
        super.encode();
        writeInt8(this.mClick);
        writeInt8(this.mLong1);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleSGKeySet)) {
            return false;
        }
        BleSGKeySet bleSGKeySet = (BleSGKeySet) obj;
        return this.mClick == bleSGKeySet.mClick && this.mLong1 == bleSGKeySet.mLong1;
    }

    public final int getMClick() {
        return this.mClick;
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public int getMLengthToWrite() {
        return 8;
    }

    public final int getMLong1() {
        return this.mLong1;
    }

    public int hashCode() {
        return (this.mClick * 31) + this.mLong1;
    }

    public final void setMClick(int i) {
        this.mClick = i;
    }

    public final void setMLong1(int i) {
        this.mLong1 = i;
    }

    @OOXIXo
    public String toString() {
        return "BleSGKeySet(mClick=" + this.mClick + ", mLong1=" + this.mLong1 + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleSGKeySet(int i, int i2, int i3, IIXOooo iIXOooo) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2);
    }

    public BleSGKeySet(int i, int i2) {
        this.mClick = i;
        this.mLong1 = i2;
    }
}
