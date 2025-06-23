package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleWritable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BleEarphoneKey extends BleWritable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_LENGTH = 9;
    public static final int KEY_NEXT = 2;
    public static final int KEY_NONE = 0;
    public static final int KEY_PLAY_PAUSE = 3;
    public static final int KEY_PRE = 1;
    public static final int KEY_SWITCH_ENV = 4;
    public static final int KEY_TURN_OFF_AI = 9;
    public static final int KEY_TURN_OFF_TRANSLATION = 11;
    public static final int KEY_TURN_ON_AI = 8;
    public static final int KEY_TURN_ON_TRANSLATION = 10;
    public static final int KEY_VOICE_ASSISTANT = 7;
    public static final int KEY_VOL_DOWN = 6;
    public static final int KEY_VOL_UP = 5;
    private int mLeftClick;
    private int mLeftDoubleClick;
    private int mLeftLongClick;
    private int mLeftTripleClick;
    private int mRightClick;
    private int mRightDoubleClick;
    private int mRightLongClick;
    private int mRightTripleClick;
    private int mType;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public BleEarphoneKey() {
        this(0, 0, 0, 0, 0, 0, 0, 0, 0, 511, null);
    }

    public final int component1() {
        return this.mLeftClick;
    }

    public final int component2() {
        return this.mLeftDoubleClick;
    }

    public final int component3() {
        return this.mLeftTripleClick;
    }

    public final int component4() {
        return this.mLeftLongClick;
    }

    public final int component5() {
        return this.mRightClick;
    }

    public final int component6() {
        return this.mRightDoubleClick;
    }

    public final int component7() {
        return this.mRightTripleClick;
    }

    public final int component8() {
        return this.mRightLongClick;
    }

    public final int component9() {
        return this.mType;
    }

    @OOXIXo
    public final BleEarphoneKey copy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        return new BleEarphoneKey(i, i2, i3, i4, i5, i6, i7, i8, i9);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        this.mLeftClick = readInt8();
        this.mLeftDoubleClick = readInt8();
        this.mLeftTripleClick = readInt8();
        this.mLeftLongClick = readInt8();
        this.mRightClick = readInt8();
        this.mRightDoubleClick = readInt8();
        this.mRightTripleClick = readInt8();
        this.mRightLongClick = readInt8();
        this.mType = readInt8();
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public void encode() {
        super.encode();
        writeInt8(this.mLeftClick);
        writeInt8(this.mLeftDoubleClick);
        writeInt8(this.mLeftTripleClick);
        writeInt8(this.mLeftLongClick);
        writeInt8(this.mRightClick);
        writeInt8(this.mRightDoubleClick);
        writeInt8(this.mRightTripleClick);
        writeInt8(this.mRightLongClick);
        writeInt8(this.mType);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleEarphoneKey)) {
            return false;
        }
        BleEarphoneKey bleEarphoneKey = (BleEarphoneKey) obj;
        return this.mLeftClick == bleEarphoneKey.mLeftClick && this.mLeftDoubleClick == bleEarphoneKey.mLeftDoubleClick && this.mLeftTripleClick == bleEarphoneKey.mLeftTripleClick && this.mLeftLongClick == bleEarphoneKey.mLeftLongClick && this.mRightClick == bleEarphoneKey.mRightClick && this.mRightDoubleClick == bleEarphoneKey.mRightDoubleClick && this.mRightTripleClick == bleEarphoneKey.mRightTripleClick && this.mRightLongClick == bleEarphoneKey.mRightLongClick && this.mType == bleEarphoneKey.mType;
    }

    public final int getMLeftClick() {
        return this.mLeftClick;
    }

    public final int getMLeftDoubleClick() {
        return this.mLeftDoubleClick;
    }

    public final int getMLeftLongClick() {
        return this.mLeftLongClick;
    }

    public final int getMLeftTripleClick() {
        return this.mLeftTripleClick;
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public int getMLengthToWrite() {
        return 9;
    }

    public final int getMRightClick() {
        return this.mRightClick;
    }

    public final int getMRightDoubleClick() {
        return this.mRightDoubleClick;
    }

    public final int getMRightLongClick() {
        return this.mRightLongClick;
    }

    public final int getMRightTripleClick() {
        return this.mRightTripleClick;
    }

    public final int getMType() {
        return this.mType;
    }

    public int hashCode() {
        return (((((((((((((((this.mLeftClick * 31) + this.mLeftDoubleClick) * 31) + this.mLeftTripleClick) * 31) + this.mLeftLongClick) * 31) + this.mRightClick) * 31) + this.mRightDoubleClick) * 31) + this.mRightTripleClick) * 31) + this.mRightLongClick) * 31) + this.mType;
    }

    public final void setMLeftClick(int i) {
        this.mLeftClick = i;
    }

    public final void setMLeftDoubleClick(int i) {
        this.mLeftDoubleClick = i;
    }

    public final void setMLeftLongClick(int i) {
        this.mLeftLongClick = i;
    }

    public final void setMLeftTripleClick(int i) {
        this.mLeftTripleClick = i;
    }

    public final void setMRightClick(int i) {
        this.mRightClick = i;
    }

    public final void setMRightDoubleClick(int i) {
        this.mRightDoubleClick = i;
    }

    public final void setMRightLongClick(int i) {
        this.mRightLongClick = i;
    }

    public final void setMRightTripleClick(int i) {
        this.mRightTripleClick = i;
    }

    public final void setMType(int i) {
        this.mType = i;
    }

    @OOXIXo
    public String toString() {
        return "BleEarphoneKey(mLeftClick=" + this.mLeftClick + ", mLeftDoubleClick=" + this.mLeftDoubleClick + ", mLeftTripleClick=" + this.mLeftTripleClick + ", mLeftLongClick=" + this.mLeftLongClick + ", mRightClick=" + this.mRightClick + ", mRightDoubleClick=" + this.mRightDoubleClick + ", mRightTripleClick=" + this.mRightTripleClick + ", mRightLongClick=" + this.mRightLongClick + ", mType=" + this.mType + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleEarphoneKey(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, IIXOooo iIXOooo) {
        this((i10 & 1) != 0 ? 0 : i, (i10 & 2) != 0 ? 0 : i2, (i10 & 4) != 0 ? 0 : i3, (i10 & 8) != 0 ? 0 : i4, (i10 & 16) != 0 ? 0 : i5, (i10 & 32) != 0 ? 0 : i6, (i10 & 64) != 0 ? 0 : i7, (i10 & 128) != 0 ? 0 : i8, (i10 & 256) == 0 ? i9 : 0);
    }

    public BleEarphoneKey(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.mLeftClick = i;
        this.mLeftDoubleClick = i2;
        this.mLeftTripleClick = i3;
        this.mLeftLongClick = i4;
        this.mRightClick = i5;
        this.mRightDoubleClick = i6;
        this.mRightTripleClick = i7;
        this.mRightLongClick = i8;
        this.mType = i9;
    }
}
