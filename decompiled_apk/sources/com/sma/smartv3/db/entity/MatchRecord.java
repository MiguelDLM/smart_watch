package com.sma.smartv3.db.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import androidx.collection.oIX0oI;
import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;
import com.garmin.fit.xxXXXxIxo;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.google.android.exoplayer2.C;
import com.szabh.smable3.entity.BleMatchRecordTeam;
import com.szabh.smable3.entity.BleWeather;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;
import kotlinx.coroutines.internal.O0xOxO;

@TypeConverters({MatchRecordConverter.class})
@Entity(indices = {@Index(unique = true, value = {"mStart"})})
@XX({"SMAP\nMatchRecord.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MatchRecord.kt\ncom/sma/smartv3/db/entity/MatchRecord\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,139:1\n1549#2:140\n1620#2,3:141\n1549#2:144\n1620#2,3:145\n1549#2:148\n1620#2,3:149\n1549#2:152\n1620#2,3:153\n1855#2,2:156\n*S KotlinDebug\n*F\n+ 1 MatchRecord.kt\ncom/sma/smartv3/db/entity/MatchRecord\n*L\n105#1:140\n105#1:141,3\n106#1:144\n106#1:145,3\n116#1:148\n116#1:149,3\n117#1:152\n117#1:153,3\n126#1:156,2\n*E\n"})
/* loaded from: classes12.dex */
public final class MatchRecord implements Serializable {

    @ColumnInfo
    private int mAirPressure;

    @ColumnInfo
    private int mAltitude;

    @ColumnInfo
    private int mGuestTeamScore;

    @ColumnInfo
    private int mHomeTeamScore;

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    private int mId;

    @ColumnInfo
    private int mIsDelete;

    @ColumnInfo
    private int mIsStopWatchData;

    @ColumnInfo
    private int mIsSync;

    @OOXIXo
    @ColumnInfo
    private String mLocalTime;

    @OOXIXo
    @Ignore
    private List<MatchLog> mLogList;

    @ColumnInfo
    private int mLogListSize;

    @ColumnInfo
    private int mMaxAltitude;

    @ColumnInfo
    private int mMaxPace;

    @ColumnInfo
    private int mMaxSpm;

    @ColumnInfo
    private int mMinAltitude;

    @ColumnInfo
    private int mMinBpm;

    @ColumnInfo
    private int mMinPace;

    @ColumnInfo
    private int mMinSpm;

    @ColumnInfo
    private int mMode;

    @ColumnInfo
    private int mPace;

    @OOXIXo
    @Embedded(prefix = "p_")
    private MatchPeriod mPeriod;

    @OOXIXo
    @Ignore
    private List<MatchPeriod> mPeriodList;

    @ColumnInfo
    private int mPeriodListSize;

    @ColumnInfo
    private int mSource;

    @ColumnInfo
    private int mSpm;

    @ColumnInfo
    private long mStart;

    @oOoXoXO
    @ColumnInfo(defaultValue = "")
    private List<Integer> mStopWatchList;

    @oOoXoXO
    @ColumnInfo(defaultValue = "")
    private BleMatchRecordTeam mTeamInfo;

    @ColumnInfo
    private int mType;

    @oOoXoXO
    @ColumnInfo(defaultValue = "")
    private BleWeather mWeather;

    public MatchRecord() {
        this(0, 0L, null, 0, 0, 0, null, 0, 0, null, null, 0, 0, null, null, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, O0xOxO.f30252xoIox, null);
    }

    public final int component1() {
        return this.mId;
    }

    @OOXIXo
    public final List<MatchPeriod> component10() {
        return this.mPeriodList;
    }

    @OOXIXo
    public final List<MatchLog> component11() {
        return this.mLogList;
    }

    public final int component12() {
        return this.mSource;
    }

    public final int component13() {
        return this.mIsStopWatchData;
    }

    @oOoXoXO
    public final List<Integer> component14() {
        return this.mStopWatchList;
    }

    @oOoXoXO
    public final BleMatchRecordTeam component15() {
        return this.mTeamInfo;
    }

    @oOoXoXO
    public final BleWeather component16() {
        return this.mWeather;
    }

    public final int component17() {
        return this.mHomeTeamScore;
    }

    public final int component18() {
        return this.mGuestTeamScore;
    }

    public final int component19() {
        return this.mMode;
    }

    public final long component2() {
        return this.mStart;
    }

    public final int component20() {
        return this.mMinBpm;
    }

    public final int component21() {
        return this.mAirPressure;
    }

    public final int component22() {
        return this.mPace;
    }

    public final int component23() {
        return this.mMaxPace;
    }

    public final int component24() {
        return this.mMinPace;
    }

    public final int component25() {
        return this.mSpm;
    }

    public final int component26() {
        return this.mMaxSpm;
    }

    public final int component27() {
        return this.mMinSpm;
    }

    public final int component28() {
        return this.mAltitude;
    }

    public final int component29() {
        return this.mMaxAltitude;
    }

    @OOXIXo
    public final String component3() {
        return this.mLocalTime;
    }

    public final int component30() {
        return this.mMinAltitude;
    }

    public final int component4() {
        return this.mType;
    }

    public final int component5() {
        return this.mPeriodListSize;
    }

    public final int component6() {
        return this.mLogListSize;
    }

    @OOXIXo
    public final MatchPeriod component7() {
        return this.mPeriod;
    }

    public final int component8() {
        return this.mIsSync;
    }

    public final int component9() {
        return this.mIsDelete;
    }

    @OOXIXo
    public final MatchRecord copy(int i, long j, @OOXIXo String mLocalTime, int i2, int i3, int i4, @OOXIXo MatchPeriod mPeriod, int i5, int i6, @OOXIXo List<MatchPeriod> mPeriodList, @OOXIXo List<MatchLog> mLogList, int i7, int i8, @oOoXoXO List<Integer> list, @oOoXoXO BleMatchRecordTeam bleMatchRecordTeam, @oOoXoXO BleWeather bleWeather, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i20, int i21, int i22) {
        IIX0o.x0xO0oo(mLocalTime, "mLocalTime");
        IIX0o.x0xO0oo(mPeriod, "mPeriod");
        IIX0o.x0xO0oo(mPeriodList, "mPeriodList");
        IIX0o.x0xO0oo(mLogList, "mLogList");
        return new MatchRecord(i, j, mLocalTime, i2, i3, i4, mPeriod, i5, i6, mPeriodList, mLogList, i7, i8, list, bleMatchRecordTeam, bleWeather, i9, i10, i11, i12, i13, i14, i15, i16, i17, i18, i19, i20, i21, i22);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MatchRecord)) {
            return false;
        }
        MatchRecord matchRecord = (MatchRecord) obj;
        return this.mId == matchRecord.mId && this.mStart == matchRecord.mStart && IIX0o.Oxx0IOOO(this.mLocalTime, matchRecord.mLocalTime) && this.mType == matchRecord.mType && this.mPeriodListSize == matchRecord.mPeriodListSize && this.mLogListSize == matchRecord.mLogListSize && IIX0o.Oxx0IOOO(this.mPeriod, matchRecord.mPeriod) && this.mIsSync == matchRecord.mIsSync && this.mIsDelete == matchRecord.mIsDelete && IIX0o.Oxx0IOOO(this.mPeriodList, matchRecord.mPeriodList) && IIX0o.Oxx0IOOO(this.mLogList, matchRecord.mLogList) && this.mSource == matchRecord.mSource && this.mIsStopWatchData == matchRecord.mIsStopWatchData && IIX0o.Oxx0IOOO(this.mStopWatchList, matchRecord.mStopWatchList) && IIX0o.Oxx0IOOO(this.mTeamInfo, matchRecord.mTeamInfo) && IIX0o.Oxx0IOOO(this.mWeather, matchRecord.mWeather) && this.mHomeTeamScore == matchRecord.mHomeTeamScore && this.mGuestTeamScore == matchRecord.mGuestTeamScore && this.mMode == matchRecord.mMode && this.mMinBpm == matchRecord.mMinBpm && this.mAirPressure == matchRecord.mAirPressure && this.mPace == matchRecord.mPace && this.mMaxPace == matchRecord.mMaxPace && this.mMinPace == matchRecord.mMinPace && this.mSpm == matchRecord.mSpm && this.mMaxSpm == matchRecord.mMaxSpm && this.mMinSpm == matchRecord.mMinSpm && this.mAltitude == matchRecord.mAltitude && this.mMaxAltitude == matchRecord.mMaxAltitude && this.mMinAltitude == matchRecord.mMinAltitude;
    }

    public final int getMAirPressure() {
        return this.mAirPressure;
    }

    public final int getMAltitude() {
        return this.mAltitude;
    }

    public final int getMGuestTeamScore() {
        return this.mGuestTeamScore;
    }

    public final int getMHomeTeamScore() {
        return this.mHomeTeamScore;
    }

    public final int getMId() {
        return this.mId;
    }

    public final int getMIsDelete() {
        return this.mIsDelete;
    }

    public final int getMIsStopWatchData() {
        return this.mIsStopWatchData;
    }

    public final int getMIsSync() {
        return this.mIsSync;
    }

    @OOXIXo
    public final String getMLocalTime() {
        return this.mLocalTime;
    }

    @OOXIXo
    public final List<MatchLog> getMLogList() {
        return this.mLogList;
    }

    public final int getMLogListSize() {
        return this.mLogListSize;
    }

    public final int getMMaxAltitude() {
        return this.mMaxAltitude;
    }

    public final int getMMaxPace() {
        return this.mMaxPace;
    }

    public final int getMMaxSpm() {
        return this.mMaxSpm;
    }

    public final int getMMinAltitude() {
        return this.mMinAltitude;
    }

    public final int getMMinBpm() {
        return this.mMinBpm;
    }

    public final int getMMinPace() {
        return this.mMinPace;
    }

    public final int getMMinSpm() {
        return this.mMinSpm;
    }

    public final int getMMode() {
        return this.mMode;
    }

    public final int getMPace() {
        return this.mPace;
    }

    @OOXIXo
    public final MatchPeriod getMPeriod() {
        return this.mPeriod;
    }

    @OOXIXo
    public final List<MatchPeriod> getMPeriodList() {
        return this.mPeriodList;
    }

    public final int getMPeriodListSize() {
        return this.mPeriodListSize;
    }

    public final int getMSource() {
        return this.mSource;
    }

    public final int getMSpm() {
        return this.mSpm;
    }

    public final long getMStart() {
        return this.mStart;
    }

    @oOoXoXO
    public final List<Integer> getMStopWatchList() {
        return this.mStopWatchList;
    }

    @oOoXoXO
    public final BleMatchRecordTeam getMTeamInfo() {
        return this.mTeamInfo;
    }

    public final int getMType() {
        return this.mType;
    }

    @oOoXoXO
    public final BleWeather getMWeather() {
        return this.mWeather;
    }

    public int hashCode() {
        int oIX0oI2 = ((((((((((((((((((((((((this.mId * 31) + oIX0oI.oIX0oI(this.mStart)) * 31) + this.mLocalTime.hashCode()) * 31) + this.mType) * 31) + this.mPeriodListSize) * 31) + this.mLogListSize) * 31) + this.mPeriod.hashCode()) * 31) + this.mIsSync) * 31) + this.mIsDelete) * 31) + this.mPeriodList.hashCode()) * 31) + this.mLogList.hashCode()) * 31) + this.mSource) * 31) + this.mIsStopWatchData) * 31;
        List<Integer> list = this.mStopWatchList;
        int hashCode = (oIX0oI2 + (list == null ? 0 : list.hashCode())) * 31;
        BleMatchRecordTeam bleMatchRecordTeam = this.mTeamInfo;
        int hashCode2 = (hashCode + (bleMatchRecordTeam == null ? 0 : bleMatchRecordTeam.hashCode())) * 31;
        BleWeather bleWeather = this.mWeather;
        return ((((((((((((((((((((((((((((hashCode2 + (bleWeather != null ? bleWeather.hashCode() : 0)) * 31) + this.mHomeTeamScore) * 31) + this.mGuestTeamScore) * 31) + this.mMode) * 31) + this.mMinBpm) * 31) + this.mAirPressure) * 31) + this.mPace) * 31) + this.mMaxPace) * 31) + this.mMinPace) * 31) + this.mSpm) * 31) + this.mMaxSpm) * 31) + this.mMinSpm) * 31) + this.mAltitude) * 31) + this.mMaxAltitude) * 31) + this.mMinAltitude;
    }

    public final void setMAirPressure(int i) {
        this.mAirPressure = i;
    }

    public final void setMAltitude(int i) {
        this.mAltitude = i;
    }

    public final void setMGuestTeamScore(int i) {
        this.mGuestTeamScore = i;
    }

    public final void setMHomeTeamScore(int i) {
        this.mHomeTeamScore = i;
    }

    public final void setMId(int i) {
        this.mId = i;
    }

    public final void setMIsDelete(int i) {
        this.mIsDelete = i;
    }

    public final void setMIsStopWatchData(int i) {
        this.mIsStopWatchData = i;
    }

    public final void setMIsSync(int i) {
        this.mIsSync = i;
    }

    public final void setMLocalTime(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mLocalTime = str;
    }

    public final void setMLogList(@OOXIXo List<MatchLog> list) {
        IIX0o.x0xO0oo(list, "<set-?>");
        this.mLogList = list;
    }

    public final void setMLogListSize(int i) {
        this.mLogListSize = i;
    }

    public final void setMMaxAltitude(int i) {
        this.mMaxAltitude = i;
    }

    public final void setMMaxPace(int i) {
        this.mMaxPace = i;
    }

    public final void setMMaxSpm(int i) {
        this.mMaxSpm = i;
    }

    public final void setMMinAltitude(int i) {
        this.mMinAltitude = i;
    }

    public final void setMMinBpm(int i) {
        this.mMinBpm = i;
    }

    public final void setMMinPace(int i) {
        this.mMinPace = i;
    }

    public final void setMMinSpm(int i) {
        this.mMinSpm = i;
    }

    public final void setMMode(int i) {
        this.mMode = i;
    }

    public final void setMPace(int i) {
        this.mPace = i;
    }

    public final void setMPeriod(@OOXIXo MatchPeriod matchPeriod) {
        IIX0o.x0xO0oo(matchPeriod, "<set-?>");
        this.mPeriod = matchPeriod;
    }

    public final void setMPeriodList(@OOXIXo List<MatchPeriod> list) {
        IIX0o.x0xO0oo(list, "<set-?>");
        this.mPeriodList = list;
    }

    public final void setMPeriodListSize(int i) {
        this.mPeriodListSize = i;
    }

    public final void setMSource(int i) {
        this.mSource = i;
    }

    public final void setMSpm(int i) {
        this.mSpm = i;
    }

    public final void setMStart(long j) {
        this.mStart = j;
    }

    public final void setMStopWatchList(@oOoXoXO List<Integer> list) {
        this.mStopWatchList = list;
    }

    public final void setMTeamInfo(@oOoXoXO BleMatchRecordTeam bleMatchRecordTeam) {
        this.mTeamInfo = bleMatchRecordTeam;
    }

    public final void setMType(int i) {
        this.mType = i;
    }

    public final void setMWeather(@oOoXoXO BleWeather bleWeather) {
        this.mWeather = bleWeather;
    }

    @OOXIXo
    public String toString() {
        return "MatchRecord(mId=" + this.mId + ", mStart=" + this.mStart + ", mLocalTime=" + this.mLocalTime + ", mType=" + this.mType + ", mPeriodListSize=" + this.mPeriodListSize + ", mLogListSize=" + this.mLogListSize + ", mPeriod=" + this.mPeriod + ", mIsSync=" + this.mIsSync + ", mIsDelete=" + this.mIsDelete + ", mPeriodList=" + this.mPeriodList + ", mLogList=" + this.mLogList + ", mSource=" + this.mSource + ", mIsStopWatchData=" + this.mIsStopWatchData + ", mStopWatchList=" + this.mStopWatchList + ", mTeamInfo=" + this.mTeamInfo + ", mWeather=" + this.mWeather + ", mHomeTeamScore=" + this.mHomeTeamScore + ", mGuestTeamScore=" + this.mGuestTeamScore + ", mMode=" + this.mMode + ", mMinBpm=" + this.mMinBpm + ", mAirPressure=" + this.mAirPressure + ", mPace=" + this.mPace + ", mMaxPace=" + this.mMaxPace + ", mMinPace=" + this.mMinPace + ", mSpm=" + this.mSpm + ", mMaxSpm=" + this.mMaxSpm + ", mMinSpm=" + this.mMinSpm + ", mAltitude=" + this.mAltitude + ", mMaxAltitude=" + this.mMaxAltitude + ", mMinAltitude=" + this.mMinAltitude + HexStringBuilder.COMMENT_END_CHAR;
    }

    public MatchRecord(int i, long j, @OOXIXo String mLocalTime, int i2, int i3, int i4, @OOXIXo MatchPeriod mPeriod, int i5, int i6, @OOXIXo List<MatchPeriod> mPeriodList, @OOXIXo List<MatchLog> mLogList, int i7, int i8, @oOoXoXO List<Integer> list, @oOoXoXO BleMatchRecordTeam bleMatchRecordTeam, @oOoXoXO BleWeather bleWeather, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i20, int i21, int i22) {
        IIX0o.x0xO0oo(mLocalTime, "mLocalTime");
        IIX0o.x0xO0oo(mPeriod, "mPeriod");
        IIX0o.x0xO0oo(mPeriodList, "mPeriodList");
        IIX0o.x0xO0oo(mLogList, "mLogList");
        this.mId = i;
        this.mStart = j;
        this.mLocalTime = mLocalTime;
        this.mType = i2;
        this.mPeriodListSize = i3;
        this.mLogListSize = i4;
        this.mPeriod = mPeriod;
        this.mIsSync = i5;
        this.mIsDelete = i6;
        this.mPeriodList = mPeriodList;
        this.mLogList = mLogList;
        this.mSource = i7;
        this.mIsStopWatchData = i8;
        this.mStopWatchList = list;
        this.mTeamInfo = bleMatchRecordTeam;
        this.mWeather = bleWeather;
        this.mHomeTeamScore = i9;
        this.mGuestTeamScore = i10;
        this.mMode = i11;
        this.mMinBpm = i12;
        this.mAirPressure = i13;
        this.mPace = i14;
        this.mMaxPace = i15;
        this.mMinPace = i16;
        this.mSpm = i17;
        this.mMaxSpm = i18;
        this.mMinSpm = i19;
        this.mAltitude = i20;
        this.mMaxAltitude = i21;
        this.mMinAltitude = i22;
    }

    public /* synthetic */ MatchRecord(int i, long j, String str, int i2, int i3, int i4, MatchPeriod matchPeriod, int i5, int i6, List list, List list2, int i7, int i8, List list3, BleMatchRecordTeam bleMatchRecordTeam, BleWeather bleWeather, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i20, int i21, int i22, int i23, IIXOooo iIXOooo) {
        this((i23 & 1) != 0 ? 0 : i, (i23 & 2) != 0 ? 0L : j, (i23 & 4) != 0 ? "" : str, (i23 & 8) != 0 ? 0 : i2, (i23 & 16) != 0 ? 0 : i3, (i23 & 32) != 0 ? 0 : i4, (i23 & 64) != 0 ? new MatchPeriod(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, xxXXXxIxo.f15726I0Io, null) : matchPeriod, (i23 & 128) != 0 ? 0 : i5, (i23 & 256) != 0 ? 0 : i6, (i23 & 512) != 0 ? new ArrayList() : list, (i23 & 1024) != 0 ? new ArrayList() : list2, (i23 & 2048) != 0 ? 0 : i7, (i23 & 4096) != 0 ? 0 : i8, (i23 & 8192) != 0 ? null : list3, (i23 & 16384) != 0 ? null : bleMatchRecordTeam, (i23 & 32768) == 0 ? bleWeather : null, (i23 & 65536) != 0 ? 0 : i9, (i23 & 131072) != 0 ? 0 : i10, (i23 & 262144) != 0 ? 0 : i11, (i23 & 524288) != 0 ? 0 : i12, (i23 & 1048576) != 0 ? 0 : i13, (i23 & 2097152) != 0 ? 0 : i14, (i23 & 4194304) != 0 ? 0 : i15, (i23 & 8388608) != 0 ? 0 : i16, (i23 & 16777216) != 0 ? 0 : i17, (i23 & 33554432) != 0 ? 0 : i18, (i23 & 67108864) != 0 ? 0 : i19, (i23 & C.BUFFER_FLAG_FIRST_SAMPLE) != 0 ? 0 : i20, (i23 & 268435456) != 0 ? 0 : i21, (i23 & 536870912) != 0 ? 0 : i22);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public MatchRecord(@OXOo.OOXIXo com.szabh.smable3.entity.BleMatchRecord r41, long r42) {
        /*
            r40 = this;
            r0 = r42
            java.lang.String r2 = "bleMatchRecord"
            r3 = r41
            kotlin.jvm.internal.IIX0o.x0xO0oo(r3, r2)
            int r2 = r41.getMStart()
            r4 = 946684800(0x386d4380, float:5.6568068E-5)
            int r2 = r2 + r4
            long r4 = (long) r2
            r6 = 1000(0x3e8, double:4.94E-321)
            long r4 = r4 * r6
            long r8 = r4 - r0
            int r11 = r41.getMType()
            int r12 = r41.getMPeriodListSize()
            int r13 = r41.getMLogListSize()
            com.sma.smartv3.db.entity.MatchPeriod r14 = new com.sma.smartv3.db.entity.MatchPeriod
            com.szabh.smable3.entity.BleMatchPeriod r2 = r41.getMPeriod()
            r14.<init>(r2, r0)
            java.util.List r2 = r41.getMPeriodList()
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.ArrayList r4 = new java.util.ArrayList
            r5 = 10
            int r6 = kotlin.collections.OxxIIOOXO.xo0x(r2, r5)
            r4.<init>(r6)
            java.util.Iterator r2 = r2.iterator()
        L42:
            boolean r6 = r2.hasNext()
            if (r6 == 0) goto L57
            java.lang.Object r6 = r2.next()
            com.szabh.smable3.entity.BleMatchPeriod r6 = (com.szabh.smable3.entity.BleMatchPeriod) r6
            com.sma.smartv3.db.entity.MatchPeriod r7 = new com.sma.smartv3.db.entity.MatchPeriod
            r7.<init>(r6, r0)
            r4.add(r7)
            goto L42
        L57:
            java.util.List r2 = r41.getMLogList()
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.ArrayList r3 = new java.util.ArrayList
            int r5 = kotlin.collections.OxxIIOOXO.xo0x(r2, r5)
            r3.<init>(r5)
            java.util.Iterator r2 = r2.iterator()
        L6a:
            boolean r5 = r2.hasNext()
            if (r5 == 0) goto L7f
            java.lang.Object r5 = r2.next()
            com.szabh.smable3.entity.BleMatchLog r5 = (com.szabh.smable3.entity.BleMatchLog) r5
            com.sma.smartv3.db.entity.MatchLog r6 = new com.sma.smartv3.db.entity.MatchLog
            r6.<init>(r5, r0)
            r3.add(r6)
            goto L6a
        L7f:
            r38 = 1073740165(0x3ffff985, float:1.9998022)
            r39 = 0
            r7 = 0
            r10 = 0
            r15 = 0
            r16 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r30 = 0
            r31 = 0
            r32 = 0
            r33 = 0
            r34 = 0
            r35 = 0
            r36 = 0
            r37 = 0
            r6 = r40
            r17 = r4
            r18 = r3
            r6.<init>(r7, r8, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.db.entity.MatchRecord.<init>(com.szabh.smable3.entity.BleMatchRecord, long):void");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public MatchRecord(@OXOo.OOXIXo com.szabh.smable3.entity.BleMatchRecord2 r37, long r38) {
        /*
            Method dump skipped, instructions count: 288
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.db.entity.MatchRecord.<init>(com.szabh.smable3.entity.BleMatchRecord2, long):void");
    }
}
