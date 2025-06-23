package com.sma.smartv3.db.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import androidx.collection.oIX0oI;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.szabh.smable3.component.BleConstsKt;
import com.szabh.smable3.entity.BleHanBaoVibration;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

@Entity(indices = {@Index(unique = true, value = {"mTime"})})
/* loaded from: classes12.dex */
public final class HanBaoVibration {

    @ColumnInfo
    private int mBOValue;

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    private final int mId;

    @ColumnInfo
    private int mIsSnore;

    @ColumnInfo
    private int mIsSync;

    @OOXIXo
    @ColumnInfo
    private String mLocalTime;

    @ColumnInfo
    private long mTime;

    @ColumnInfo
    private int mVibration;

    public HanBaoVibration() {
        this(0, 0L, null, 0, 0, 0, 0, 127, null);
    }

    public final int component1() {
        return this.mId;
    }

    public final long component2() {
        return this.mTime;
    }

    @OOXIXo
    public final String component3() {
        return this.mLocalTime;
    }

    public final int component4() {
        return this.mVibration;
    }

    public final int component5() {
        return this.mBOValue;
    }

    public final int component6() {
        return this.mIsSnore;
    }

    public final int component7() {
        return this.mIsSync;
    }

    @OOXIXo
    public final HanBaoVibration copy(int i, long j, @OOXIXo String mLocalTime, int i2, int i3, int i4, int i5) {
        IIX0o.x0xO0oo(mLocalTime, "mLocalTime");
        return new HanBaoVibration(i, j, mLocalTime, i2, i3, i4, i5);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HanBaoVibration)) {
            return false;
        }
        HanBaoVibration hanBaoVibration = (HanBaoVibration) obj;
        return this.mId == hanBaoVibration.mId && this.mTime == hanBaoVibration.mTime && IIX0o.Oxx0IOOO(this.mLocalTime, hanBaoVibration.mLocalTime) && this.mVibration == hanBaoVibration.mVibration && this.mBOValue == hanBaoVibration.mBOValue && this.mIsSnore == hanBaoVibration.mIsSnore && this.mIsSync == hanBaoVibration.mIsSync;
    }

    public final int getMBOValue() {
        return this.mBOValue;
    }

    public final int getMId() {
        return this.mId;
    }

    public final int getMIsSnore() {
        return this.mIsSnore;
    }

    public final int getMIsSync() {
        return this.mIsSync;
    }

    @OOXIXo
    public final String getMLocalTime() {
        return this.mLocalTime;
    }

    public final long getMTime() {
        return this.mTime;
    }

    public final int getMVibration() {
        return this.mVibration;
    }

    public int hashCode() {
        return (((((((((((this.mId * 31) + oIX0oI.oIX0oI(this.mTime)) * 31) + this.mLocalTime.hashCode()) * 31) + this.mVibration) * 31) + this.mBOValue) * 31) + this.mIsSnore) * 31) + this.mIsSync;
    }

    public final void setMBOValue(int i) {
        this.mBOValue = i;
    }

    public final void setMIsSnore(int i) {
        this.mIsSnore = i;
    }

    public final void setMIsSync(int i) {
        this.mIsSync = i;
    }

    public final void setMLocalTime(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mLocalTime = str;
    }

    public final void setMTime(long j) {
        this.mTime = j;
    }

    public final void setMVibration(int i) {
        this.mVibration = i;
    }

    @OOXIXo
    public String toString() {
        return "HanBaoVibration(mId=" + this.mId + ", mTime=" + this.mTime + ", mLocalTime=" + this.mLocalTime + ", mVibration=" + this.mVibration + ", mBOValue=" + this.mBOValue + ", mIsSnore=" + this.mIsSnore + ", mIsSync=" + this.mIsSync + HexStringBuilder.COMMENT_END_CHAR;
    }

    public HanBaoVibration(int i, long j, @OOXIXo String mLocalTime, int i2, int i3, int i4, int i5) {
        IIX0o.x0xO0oo(mLocalTime, "mLocalTime");
        this.mId = i;
        this.mTime = j;
        this.mLocalTime = mLocalTime;
        this.mVibration = i2;
        this.mBOValue = i3;
        this.mIsSnore = i4;
        this.mIsSync = i5;
    }

    public /* synthetic */ HanBaoVibration(int i, long j, String str, int i2, int i3, int i4, int i5, int i6, IIXOooo iIXOooo) {
        this((i6 & 1) != 0 ? 0 : i, (i6 & 2) != 0 ? 0L : j, (i6 & 4) != 0 ? "" : str, (i6 & 8) != 0 ? 0 : i2, (i6 & 16) != 0 ? 0 : i3, (i6 & 32) != 0 ? 0 : i4, (i6 & 64) == 0 ? i5 : 0);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HanBaoVibration(@OOXIXo BleHanBaoVibration bleHanBaoVibration, long j) {
        this(0, ((bleHanBaoVibration.getMTime() + BleConstsKt.DATA_EPOCH) * 1000) - j, null, bleHanBaoVibration.getMVibration(), bleHanBaoVibration.getMBOValue(), bleHanBaoVibration.getMIsSnore(), 0, 69, null);
        IIX0o.x0xO0oo(bleHanBaoVibration, "bleHanBaoVibration");
    }
}
