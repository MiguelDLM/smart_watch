package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleReadable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.nio.ByteOrder;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BleMatchLog2 extends BleReadable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int GOAL_GUEST = 7;
    public static final int GOAL_HOME = 6;
    public static final int INCIDENT_BREAK = 10;
    public static final int ITEM_LENGTH = 12;
    public static final int KICK_OFF = 0;
    public static final int MERCY_END = 9;
    public static final int PENALTY = 5;
    public static final int PERIOD_END = 3;
    public static final int PERIOD_RESET = 4;
    public static final int RED_CARD = 12;
    public static final int SUBSTITUTION = 13;
    public static final int TIME_START = 1;
    public static final int TIME_STOP = 2;
    public static final int UNDO_LAST = 8;
    public static final int YELLOW_CARD = 11;
    private int mCancelType;
    private int mCount;
    private int mOtherType;
    private int mPeriodNumber;
    private int mPeriodTime;
    private int mPlayer;
    private int mStopWatchTotal;
    private int mTeam;
    private int mTime;
    private int mType;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public BleMatchLog2() {
        this(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1023, null);
    }

    public final int component1() {
        return this.mTime;
    }

    public final int component10() {
        return this.mStopWatchTotal;
    }

    public final int component2() {
        return this.mPeriodTime;
    }

    public final int component3() {
        return this.mPeriodNumber;
    }

    public final int component4() {
        return this.mType;
    }

    public final int component5() {
        return this.mCount;
    }

    public final int component6() {
        return this.mCancelType;
    }

    public final int component7() {
        return this.mTeam;
    }

    public final int component8() {
        return this.mPlayer;
    }

    public final int component9() {
        return this.mOtherType;
    }

    @OOXIXo
    public final BleMatchLog2 copy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        return new BleMatchLog2(i, i2, i3, i4, i5, i6, i7, i8, i9, i10);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        ByteOrder LITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        this.mTime = readUInt16(LITTLE_ENDIAN);
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        this.mPeriodTime = readUInt16(LITTLE_ENDIAN);
        byte readInt8 = readInt8();
        byte readInt82 = readInt8();
        this.mPeriodNumber = readInt8;
        this.mType = readInt82;
        this.mStopWatchTotal = (readInt8 & 255) | ((readInt82 & 255) << 8);
        this.mCount = readUInt8();
        this.mCancelType = readUInt8();
        this.mTeam = readUInt8();
        this.mPlayer = readUInt8();
        this.mOtherType = readUInt8();
        readUInt8();
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleMatchLog2)) {
            return false;
        }
        BleMatchLog2 bleMatchLog2 = (BleMatchLog2) obj;
        return this.mTime == bleMatchLog2.mTime && this.mPeriodTime == bleMatchLog2.mPeriodTime && this.mPeriodNumber == bleMatchLog2.mPeriodNumber && this.mType == bleMatchLog2.mType && this.mCount == bleMatchLog2.mCount && this.mCancelType == bleMatchLog2.mCancelType && this.mTeam == bleMatchLog2.mTeam && this.mPlayer == bleMatchLog2.mPlayer && this.mOtherType == bleMatchLog2.mOtherType && this.mStopWatchTotal == bleMatchLog2.mStopWatchTotal;
    }

    public final int getMCancelType() {
        return this.mCancelType;
    }

    public final int getMCount() {
        return this.mCount;
    }

    public final int getMOtherType() {
        return this.mOtherType;
    }

    public final int getMPeriodNumber() {
        return this.mPeriodNumber;
    }

    public final int getMPeriodTime() {
        return this.mPeriodTime;
    }

    public final int getMPlayer() {
        return this.mPlayer;
    }

    public final int getMStopWatchTotal() {
        return this.mStopWatchTotal;
    }

    public final int getMTeam() {
        return this.mTeam;
    }

    public final int getMTime() {
        return this.mTime;
    }

    public final int getMType() {
        return this.mType;
    }

    public int hashCode() {
        return (((((((((((((((((this.mTime * 31) + this.mPeriodTime) * 31) + this.mPeriodNumber) * 31) + this.mType) * 31) + this.mCount) * 31) + this.mCancelType) * 31) + this.mTeam) * 31) + this.mPlayer) * 31) + this.mOtherType) * 31) + this.mStopWatchTotal;
    }

    public final void setMCancelType(int i) {
        this.mCancelType = i;
    }

    public final void setMCount(int i) {
        this.mCount = i;
    }

    public final void setMOtherType(int i) {
        this.mOtherType = i;
    }

    public final void setMPeriodNumber(int i) {
        this.mPeriodNumber = i;
    }

    public final void setMPeriodTime(int i) {
        this.mPeriodTime = i;
    }

    public final void setMPlayer(int i) {
        this.mPlayer = i;
    }

    public final void setMStopWatchTotal(int i) {
        this.mStopWatchTotal = i;
    }

    public final void setMTeam(int i) {
        this.mTeam = i;
    }

    public final void setMTime(int i) {
        this.mTime = i;
    }

    public final void setMType(int i) {
        this.mType = i;
    }

    @OOXIXo
    public String toString() {
        return "BleMatchLog2(mTime=" + this.mTime + ", mPeriodTime=" + this.mPeriodTime + ", mPeriodNumber=" + this.mPeriodNumber + ", mType=" + this.mType + ", mCount=" + this.mCount + ", mCancelType=" + this.mCancelType + ", mTeam=" + this.mTeam + ", mPlayer=" + this.mPlayer + ", mOtherType=" + this.mOtherType + ", mStopWatchTotal=" + this.mStopWatchTotal + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleMatchLog2(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, IIXOooo iIXOooo) {
        this((i11 & 1) != 0 ? 0 : i, (i11 & 2) != 0 ? 0 : i2, (i11 & 4) != 0 ? 0 : i3, (i11 & 8) != 0 ? 0 : i4, (i11 & 16) != 0 ? 0 : i5, (i11 & 32) != 0 ? 0 : i6, (i11 & 64) != 0 ? 0 : i7, (i11 & 128) != 0 ? 0 : i8, (i11 & 256) != 0 ? 0 : i9, (i11 & 512) == 0 ? i10 : 0);
    }

    public BleMatchLog2(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        this.mTime = i;
        this.mPeriodTime = i2;
        this.mPeriodNumber = i3;
        this.mType = i4;
        this.mCount = i5;
        this.mCancelType = i6;
        this.mTeam = i7;
        this.mPlayer = i8;
        this.mOtherType = i9;
        this.mStopWatchTotal = i10;
    }
}
