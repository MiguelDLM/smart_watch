package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleReadable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nBleMatchRecord2.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BleMatchRecord2.kt\ncom/szabh/smable3/entity/BleMatchRecord2\n+ 2 BleReadable.kt\ncom/bestmafen/baseble/data/BleReadable\n*L\n1#1,55:1\n222#2,4:56\n232#2,3:60\n222#2,15:63\n232#2,3:78\n222#2,15:81\n222#2,4:96\n222#2,4:100\n*S KotlinDebug\n*F\n+ 1 BleMatchRecord2.kt\ncom/szabh/smable3/entity/BleMatchRecord2\n*L\n30#1:56,4\n31#1:60,3\n31#1:63,15\n39#1:78,3\n39#1:81,15\n41#1:96,4\n42#1:100,4\n*E\n"})
/* loaded from: classes13.dex */
public final class BleMatchRecord2 extends BleReadable {
    public static final int CLASSIC = 1;

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_LENGTH = 3256;
    public static final int PROFILE = 2;
    public static final int TRAINING = 3;
    public static final int YOUTH = 0;
    private int mIsStopWatchData;

    @OOXIXo
    private List<BleMatchLog2> mLogList;
    private int mLogListSize;

    @OOXIXo
    private BleMatchPeriod2 mPeriod;

    @OOXIXo
    private List<BleMatchPeriod2> mPeriodList;
    private int mPeriodListSize;
    private int mStart;

    @OOXIXo
    private List<Integer> mStopWatchList;

    @OOXIXo
    private BleMatchRecordTeam mTeamInfo;
    private int mType;

    @OOXIXo
    private BleWeather mWeather;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public BleMatchRecord2() {
        this(0, 0, 0, 0, 0, null, null, null, null, null, null, 2047, null);
    }

    public final int component1() {
        return this.mStart;
    }

    @OOXIXo
    public final BleMatchRecordTeam component10() {
        return this.mTeamInfo;
    }

    @OOXIXo
    public final BleWeather component11() {
        return this.mWeather;
    }

    public final int component2() {
        return this.mType;
    }

    public final int component3() {
        return this.mPeriodListSize;
    }

    public final int component4() {
        return this.mLogListSize;
    }

    public final int component5() {
        return this.mIsStopWatchData;
    }

    @OOXIXo
    public final BleMatchPeriod2 component6() {
        return this.mPeriod;
    }

    @OOXIXo
    public final List<BleMatchPeriod2> component7() {
        return this.mPeriodList;
    }

    @OOXIXo
    public final List<BleMatchLog2> component8() {
        return this.mLogList;
    }

    @OOXIXo
    public final List<Integer> component9() {
        return this.mStopWatchList;
    }

    @OOXIXo
    public final BleMatchRecord2 copy(int i, int i2, int i3, int i4, int i5, @OOXIXo BleMatchPeriod2 mPeriod, @OOXIXo List<BleMatchPeriod2> mPeriodList, @OOXIXo List<BleMatchLog2> mLogList, @OOXIXo List<Integer> mStopWatchList, @OOXIXo BleMatchRecordTeam mTeamInfo, @OOXIXo BleWeather mWeather) {
        IIX0o.x0xO0oo(mPeriod, "mPeriod");
        IIX0o.x0xO0oo(mPeriodList, "mPeriodList");
        IIX0o.x0xO0oo(mLogList, "mLogList");
        IIX0o.x0xO0oo(mStopWatchList, "mStopWatchList");
        IIX0o.x0xO0oo(mTeamInfo, "mTeamInfo");
        IIX0o.x0xO0oo(mWeather, "mWeather");
        return new BleMatchRecord2(i, i2, i3, i4, i5, mPeriod, mPeriodList, mLogList, mStopWatchList, mTeamInfo, mWeather);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        ByteOrder LITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        this.mStart = readInt32(LITTLE_ENDIAN);
        this.mType = readUInt8();
        this.mPeriodListSize = readUInt8();
        this.mLogListSize = readUInt8();
        this.mIsStopWatchData = readUInt8();
        BleReadable bleReadable = (BleReadable) BleMatchPeriod2.class.newInstance();
        bleReadable.setMBytes(readBytes(14));
        bleReadable.decode();
        IIX0o.ooOOo0oXI(bleReadable);
        this.mPeriod = (BleMatchPeriod2) bleReadable;
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (int i2 = 0; i2 < 9; i2++) {
            BleReadable bleReadable2 = (BleReadable) BleMatchPeriod2.class.newInstance();
            bleReadable2.setMBytes(readBytes(14));
            bleReadable2.decode();
            IIX0o.ooOOo0oXI(bleReadable2);
            arrayList.add(bleReadable2);
        }
        this.mPeriodList = CollectionsKt___CollectionsKt.O0o000XOX(arrayList, this.mPeriodListSize);
        if (this.mIsStopWatchData == 1) {
            ArrayList arrayList2 = new ArrayList();
            while (i < 297) {
                ByteOrder LITTLE_ENDIAN2 = ByteOrder.LITTLE_ENDIAN;
                IIX0o.oO(LITTLE_ENDIAN2, "LITTLE_ENDIAN");
                arrayList2.add(Integer.valueOf(readInt32(LITTLE_ENDIAN2)));
                i++;
            }
            this.mStopWatchList = CollectionsKt___CollectionsKt.O0o000XOX(arrayList2, this.mLogListSize);
        } else {
            ArrayList arrayList3 = new ArrayList();
            while (i < 99) {
                BleReadable bleReadable3 = (BleReadable) BleMatchLog2.class.newInstance();
                bleReadable3.setMBytes(readBytes(12));
                bleReadable3.decode();
                IIX0o.ooOOo0oXI(bleReadable3);
                arrayList3.add(bleReadable3);
                i++;
            }
            this.mLogList = CollectionsKt___CollectionsKt.O0o000XOX(arrayList3, this.mLogListSize);
        }
        BleReadable bleReadable4 = (BleReadable) BleMatchRecordTeam.class.newInstance();
        bleReadable4.setMBytes(readBytes(BleMatchRecordTeam.ITEM_LENGTH));
        bleReadable4.decode();
        IIX0o.ooOOo0oXI(bleReadable4);
        this.mTeamInfo = (BleMatchRecordTeam) bleReadable4;
        BleReadable bleReadable5 = (BleReadable) BleWeather.class.newInstance();
        bleReadable5.setMBytes(readBytes(10));
        bleReadable5.decode();
        IIX0o.ooOOo0oXI(bleReadable5);
        this.mWeather = (BleWeather) bleReadable5;
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleMatchRecord2)) {
            return false;
        }
        BleMatchRecord2 bleMatchRecord2 = (BleMatchRecord2) obj;
        return this.mStart == bleMatchRecord2.mStart && this.mType == bleMatchRecord2.mType && this.mPeriodListSize == bleMatchRecord2.mPeriodListSize && this.mLogListSize == bleMatchRecord2.mLogListSize && this.mIsStopWatchData == bleMatchRecord2.mIsStopWatchData && IIX0o.Oxx0IOOO(this.mPeriod, bleMatchRecord2.mPeriod) && IIX0o.Oxx0IOOO(this.mPeriodList, bleMatchRecord2.mPeriodList) && IIX0o.Oxx0IOOO(this.mLogList, bleMatchRecord2.mLogList) && IIX0o.Oxx0IOOO(this.mStopWatchList, bleMatchRecord2.mStopWatchList) && IIX0o.Oxx0IOOO(this.mTeamInfo, bleMatchRecord2.mTeamInfo) && IIX0o.Oxx0IOOO(this.mWeather, bleMatchRecord2.mWeather);
    }

    public final int getMIsStopWatchData() {
        return this.mIsStopWatchData;
    }

    @OOXIXo
    public final List<BleMatchLog2> getMLogList() {
        return this.mLogList;
    }

    public final int getMLogListSize() {
        return this.mLogListSize;
    }

    @OOXIXo
    public final BleMatchPeriod2 getMPeriod() {
        return this.mPeriod;
    }

    @OOXIXo
    public final List<BleMatchPeriod2> getMPeriodList() {
        return this.mPeriodList;
    }

    public final int getMPeriodListSize() {
        return this.mPeriodListSize;
    }

    public final int getMStart() {
        return this.mStart;
    }

    @OOXIXo
    public final List<Integer> getMStopWatchList() {
        return this.mStopWatchList;
    }

    @OOXIXo
    public final BleMatchRecordTeam getMTeamInfo() {
        return this.mTeamInfo;
    }

    public final int getMType() {
        return this.mType;
    }

    @OOXIXo
    public final BleWeather getMWeather() {
        return this.mWeather;
    }

    public int hashCode() {
        return (((((((((((((((((((this.mStart * 31) + this.mType) * 31) + this.mPeriodListSize) * 31) + this.mLogListSize) * 31) + this.mIsStopWatchData) * 31) + this.mPeriod.hashCode()) * 31) + this.mPeriodList.hashCode()) * 31) + this.mLogList.hashCode()) * 31) + this.mStopWatchList.hashCode()) * 31) + this.mTeamInfo.hashCode()) * 31) + this.mWeather.hashCode();
    }

    public final void setMIsStopWatchData(int i) {
        this.mIsStopWatchData = i;
    }

    public final void setMLogList(@OOXIXo List<BleMatchLog2> list) {
        IIX0o.x0xO0oo(list, "<set-?>");
        this.mLogList = list;
    }

    public final void setMLogListSize(int i) {
        this.mLogListSize = i;
    }

    public final void setMPeriod(@OOXIXo BleMatchPeriod2 bleMatchPeriod2) {
        IIX0o.x0xO0oo(bleMatchPeriod2, "<set-?>");
        this.mPeriod = bleMatchPeriod2;
    }

    public final void setMPeriodList(@OOXIXo List<BleMatchPeriod2> list) {
        IIX0o.x0xO0oo(list, "<set-?>");
        this.mPeriodList = list;
    }

    public final void setMPeriodListSize(int i) {
        this.mPeriodListSize = i;
    }

    public final void setMStart(int i) {
        this.mStart = i;
    }

    public final void setMStopWatchList(@OOXIXo List<Integer> list) {
        IIX0o.x0xO0oo(list, "<set-?>");
        this.mStopWatchList = list;
    }

    public final void setMTeamInfo(@OOXIXo BleMatchRecordTeam bleMatchRecordTeam) {
        IIX0o.x0xO0oo(bleMatchRecordTeam, "<set-?>");
        this.mTeamInfo = bleMatchRecordTeam;
    }

    public final void setMType(int i) {
        this.mType = i;
    }

    public final void setMWeather(@OOXIXo BleWeather bleWeather) {
        IIX0o.x0xO0oo(bleWeather, "<set-?>");
        this.mWeather = bleWeather;
    }

    @OOXIXo
    public String toString() {
        return "BleMatchRecord2(mStart=" + this.mStart + ", mType=" + this.mType + ", mPeriodListSize=" + this.mPeriodListSize + ", mLogListSize=" + this.mLogListSize + ", mIsStopWatchData=" + this.mIsStopWatchData + ", mPeriod=" + this.mPeriod + ", mPeriodList=" + this.mPeriodList + ", mLogList=" + this.mLogList + ", mStopWatchList=" + this.mStopWatchList + ", mTeamInfo=" + this.mTeamInfo + ", mWeather=" + this.mWeather + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleMatchRecord2(int i, int i2, int i3, int i4, int i5, BleMatchPeriod2 bleMatchPeriod2, List list, List list2, List list3, BleMatchRecordTeam bleMatchRecordTeam, BleWeather bleWeather, int i6, IIXOooo iIXOooo) {
        this((i6 & 1) != 0 ? 0 : i, (i6 & 2) != 0 ? 0 : i2, (i6 & 4) != 0 ? 0 : i3, (i6 & 8) != 0 ? 0 : i4, (i6 & 16) == 0 ? i5 : 0, (i6 & 32) != 0 ? new BleMatchPeriod2(0, 0, 0, 0, 0, 0, 0, 0, 255, null) : bleMatchPeriod2, (i6 & 64) != 0 ? new ArrayList() : list, (i6 & 128) != 0 ? new ArrayList() : list2, (i6 & 256) != 0 ? new ArrayList() : list3, (i6 & 512) != 0 ? new BleMatchRecordTeam(null, 0, 0, null, null, null, null, null, null, 511, null) : bleMatchRecordTeam, (i6 & 1024) != 0 ? new BleWeather(0, 0, 0, 0, 0, 0, 0, 0, 0, 511, null) : bleWeather);
    }

    public BleMatchRecord2(int i, int i2, int i3, int i4, int i5, @OOXIXo BleMatchPeriod2 mPeriod, @OOXIXo List<BleMatchPeriod2> mPeriodList, @OOXIXo List<BleMatchLog2> mLogList, @OOXIXo List<Integer> mStopWatchList, @OOXIXo BleMatchRecordTeam mTeamInfo, @OOXIXo BleWeather mWeather) {
        IIX0o.x0xO0oo(mPeriod, "mPeriod");
        IIX0o.x0xO0oo(mPeriodList, "mPeriodList");
        IIX0o.x0xO0oo(mLogList, "mLogList");
        IIX0o.x0xO0oo(mStopWatchList, "mStopWatchList");
        IIX0o.x0xO0oo(mTeamInfo, "mTeamInfo");
        IIX0o.x0xO0oo(mWeather, "mWeather");
        this.mStart = i;
        this.mType = i2;
        this.mPeriodListSize = i3;
        this.mLogListSize = i4;
        this.mIsStopWatchData = i5;
        this.mPeriod = mPeriod;
        this.mPeriodList = mPeriodList;
        this.mLogList = mLogList;
        this.mStopWatchList = mStopWatchList;
        this.mTeamInfo = mTeamInfo;
        this.mWeather = mWeather;
    }
}
