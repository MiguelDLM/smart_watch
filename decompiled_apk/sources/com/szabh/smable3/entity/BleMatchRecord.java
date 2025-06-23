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

@XX({"SMAP\nBleMatchRecord.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BleMatchRecord.kt\ncom/szabh/smable3/entity/BleMatchRecord\n+ 2 BleReadable.kt\ncom/bestmafen/baseble/data/BleReadable\n*L\n1#1,42:1\n222#2,4:43\n232#2,3:47\n222#2,15:50\n232#2,3:65\n222#2,15:68\n*S KotlinDebug\n*F\n+ 1 BleMatchRecord.kt\ncom/szabh/smable3/entity/BleMatchRecord\n*L\n27#1:43,4\n28#1:47,3\n28#1:50,15\n29#1:65,3\n29#1:68,15\n*E\n"})
/* loaded from: classes13.dex */
public final class BleMatchRecord extends BleReadable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_LENGTH = 920;
    public static final int PROFILE1 = 1;
    public static final int PROFILE2 = 2;
    public static final int TRAINING = 3;
    public static final int YOUTH = 0;

    @OOXIXo
    private List<BleMatchLog> mLogList;
    private int mLogListSize;

    @OOXIXo
    private BleMatchPeriod mPeriod;

    @OOXIXo
    private List<BleMatchPeriod> mPeriodList;
    private int mPeriodListSize;
    private int mStart;
    private int mType;
    private int mUndefined;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public BleMatchRecord() {
        this(0, 0, 0, 0, 0, null, null, null, 255, null);
    }

    public final int component1() {
        return this.mStart;
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
        return this.mUndefined;
    }

    @OOXIXo
    public final BleMatchPeriod component6() {
        return this.mPeriod;
    }

    @OOXIXo
    public final List<BleMatchPeriod> component7() {
        return this.mPeriodList;
    }

    @OOXIXo
    public final List<BleMatchLog> component8() {
        return this.mLogList;
    }

    @OOXIXo
    public final BleMatchRecord copy(int i, int i2, int i3, int i4, int i5, @OOXIXo BleMatchPeriod mPeriod, @OOXIXo List<BleMatchPeriod> mPeriodList, @OOXIXo List<BleMatchLog> mLogList) {
        IIX0o.x0xO0oo(mPeriod, "mPeriod");
        IIX0o.x0xO0oo(mPeriodList, "mPeriodList");
        IIX0o.x0xO0oo(mLogList, "mLogList");
        return new BleMatchRecord(i, i2, i3, i4, i5, mPeriod, mPeriodList, mLogList);
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
        this.mUndefined = readUInt8();
        BleReadable bleReadable = (BleReadable) BleMatchPeriod.class.newInstance();
        bleReadable.setMBytes(readBytes(12));
        bleReadable.decode();
        IIX0o.ooOOo0oXI(bleReadable);
        this.mPeriod = (BleMatchPeriod) bleReadable;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 9; i++) {
            BleReadable bleReadable2 = (BleReadable) BleMatchPeriod.class.newInstance();
            bleReadable2.setMBytes(readBytes(12));
            bleReadable2.decode();
            IIX0o.ooOOo0oXI(bleReadable2);
            arrayList.add(bleReadable2);
        }
        this.mPeriodList = CollectionsKt___CollectionsKt.O0o000XOX(arrayList, this.mPeriodListSize);
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < 99; i2++) {
            BleReadable bleReadable3 = (BleReadable) BleMatchLog.class.newInstance();
            bleReadable3.setMBytes(readBytes(8));
            bleReadable3.decode();
            IIX0o.ooOOo0oXI(bleReadable3);
            arrayList2.add(bleReadable3);
        }
        this.mLogList = CollectionsKt___CollectionsKt.O0o000XOX(arrayList2, this.mLogListSize);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleMatchRecord)) {
            return false;
        }
        BleMatchRecord bleMatchRecord = (BleMatchRecord) obj;
        return this.mStart == bleMatchRecord.mStart && this.mType == bleMatchRecord.mType && this.mPeriodListSize == bleMatchRecord.mPeriodListSize && this.mLogListSize == bleMatchRecord.mLogListSize && this.mUndefined == bleMatchRecord.mUndefined && IIX0o.Oxx0IOOO(this.mPeriod, bleMatchRecord.mPeriod) && IIX0o.Oxx0IOOO(this.mPeriodList, bleMatchRecord.mPeriodList) && IIX0o.Oxx0IOOO(this.mLogList, bleMatchRecord.mLogList);
    }

    @OOXIXo
    public final List<BleMatchLog> getMLogList() {
        return this.mLogList;
    }

    public final int getMLogListSize() {
        return this.mLogListSize;
    }

    @OOXIXo
    public final BleMatchPeriod getMPeriod() {
        return this.mPeriod;
    }

    @OOXIXo
    public final List<BleMatchPeriod> getMPeriodList() {
        return this.mPeriodList;
    }

    public final int getMPeriodListSize() {
        return this.mPeriodListSize;
    }

    public final int getMStart() {
        return this.mStart;
    }

    public final int getMType() {
        return this.mType;
    }

    public final int getMUndefined() {
        return this.mUndefined;
    }

    public int hashCode() {
        return (((((((((((((this.mStart * 31) + this.mType) * 31) + this.mPeriodListSize) * 31) + this.mLogListSize) * 31) + this.mUndefined) * 31) + this.mPeriod.hashCode()) * 31) + this.mPeriodList.hashCode()) * 31) + this.mLogList.hashCode();
    }

    public final void setMLogList(@OOXIXo List<BleMatchLog> list) {
        IIX0o.x0xO0oo(list, "<set-?>");
        this.mLogList = list;
    }

    public final void setMLogListSize(int i) {
        this.mLogListSize = i;
    }

    public final void setMPeriod(@OOXIXo BleMatchPeriod bleMatchPeriod) {
        IIX0o.x0xO0oo(bleMatchPeriod, "<set-?>");
        this.mPeriod = bleMatchPeriod;
    }

    public final void setMPeriodList(@OOXIXo List<BleMatchPeriod> list) {
        IIX0o.x0xO0oo(list, "<set-?>");
        this.mPeriodList = list;
    }

    public final void setMPeriodListSize(int i) {
        this.mPeriodListSize = i;
    }

    public final void setMStart(int i) {
        this.mStart = i;
    }

    public final void setMType(int i) {
        this.mType = i;
    }

    public final void setMUndefined(int i) {
        this.mUndefined = i;
    }

    @OOXIXo
    public String toString() {
        return "BleMatchRecord(mStart=" + this.mStart + ", mType=" + this.mType + ", mPeriodListSize=" + this.mPeriodListSize + ", mLogListSize=" + this.mLogListSize + ", mUndefined=" + this.mUndefined + ", mPeriod=" + this.mPeriod + ", mPeriodList=" + this.mPeriodList + ", mLogList=" + this.mLogList + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleMatchRecord(int i, int i2, int i3, int i4, int i5, BleMatchPeriod bleMatchPeriod, List list, List list2, int i6, IIXOooo iIXOooo) {
        this((i6 & 1) != 0 ? 0 : i, (i6 & 2) != 0 ? 0 : i2, (i6 & 4) != 0 ? 0 : i3, (i6 & 8) != 0 ? 0 : i4, (i6 & 16) == 0 ? i5 : 0, (i6 & 32) != 0 ? new BleMatchPeriod(0, 0, 0, 0, 0, 0, 0, 127, null) : bleMatchPeriod, (i6 & 64) != 0 ? new ArrayList() : list, (i6 & 128) != 0 ? new ArrayList() : list2);
    }

    public BleMatchRecord(int i, int i2, int i3, int i4, int i5, @OOXIXo BleMatchPeriod mPeriod, @OOXIXo List<BleMatchPeriod> mPeriodList, @OOXIXo List<BleMatchLog> mLogList) {
        IIX0o.x0xO0oo(mPeriod, "mPeriod");
        IIX0o.x0xO0oo(mPeriodList, "mPeriodList");
        IIX0o.x0xO0oo(mLogList, "mLogList");
        this.mStart = i;
        this.mType = i2;
        this.mPeriodListSize = i3;
        this.mLogListSize = i4;
        this.mUndefined = i5;
        this.mPeriod = mPeriod;
        this.mPeriodList = mPeriodList;
        this.mLogList = mLogList;
    }
}
