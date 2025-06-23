package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleWritable;
import com.garmin.fit.OOxOOxIO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nBleMatchYouthSettings.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BleMatchYouthSettings.kt\ncom/szabh/smable3/entity/BleMatchYouthSettings\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,62:1\n1#2:63\n*E\n"})
/* loaded from: classes13.dex */
public final class BleMatchYouthSettings extends BleWritable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int NAME_LENGTH = 25;

    @OOXIXo
    private List<Integer> mBreakTime;
    private int mButtonType;
    private int mEventTime;
    private int mGps;
    private int mGuestTeamColor;
    private int mHomeTeamColor;
    private int mMatchView;
    private int mPenaltyTime;

    @OOXIXo
    private List<Integer> mPeriodTime;
    private int mPeriods;

    @OOXIXo
    private List<String> mRefereeRole;
    private int mScreen;

    @OOXIXo
    private List<String> mTeamNames;
    private int mVibration;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public BleMatchYouthSettings() {
        this(0, null, null, 0, 0, 0, 0, 0, 0, 0, 0, null, null, 0, OOxOOxIO.f12624oIX0oI, null);
    }

    public final int component1() {
        return this.mPeriods;
    }

    public final int component10() {
        return this.mScreen;
    }

    public final int component11() {
        return this.mMatchView;
    }

    @OOXIXo
    public final List<String> component12() {
        return this.mTeamNames;
    }

    @OOXIXo
    public final List<String> component13() {
        return this.mRefereeRole;
    }

    public final int component14() {
        return this.mEventTime;
    }

    @OOXIXo
    public final List<Integer> component2() {
        return this.mPeriodTime;
    }

    @OOXIXo
    public final List<Integer> component3() {
        return this.mBreakTime;
    }

    public final int component4() {
        return this.mVibration;
    }

    public final int component5() {
        return this.mButtonType;
    }

    public final int component6() {
        return this.mHomeTeamColor;
    }

    public final int component7() {
        return this.mGuestTeamColor;
    }

    public final int component8() {
        return this.mPenaltyTime;
    }

    public final int component9() {
        return this.mGps;
    }

    @OOXIXo
    public final BleMatchYouthSettings copy(int i, @OOXIXo List<Integer> mPeriodTime, @OOXIXo List<Integer> mBreakTime, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, @OOXIXo List<String> mTeamNames, @OOXIXo List<String> mRefereeRole, int i10) {
        IIX0o.x0xO0oo(mPeriodTime, "mPeriodTime");
        IIX0o.x0xO0oo(mBreakTime, "mBreakTime");
        IIX0o.x0xO0oo(mTeamNames, "mTeamNames");
        IIX0o.x0xO0oo(mRefereeRole, "mRefereeRole");
        return new BleMatchYouthSettings(i, mPeriodTime, mBreakTime, i2, i3, i4, i5, i6, i7, i8, i9, mTeamNames, mRefereeRole, i10);
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public void encode() {
        String str;
        Integer num;
        Integer num2;
        super.encode();
        writeInt8(0);
        writeInt8(this.mPeriods);
        for (int i = 0; i < 9; i++) {
            List<Integer> list = this.mPeriodTime;
            if (i >= 0 && i <= CollectionsKt__CollectionsKt.oo0xXOI0I(list)) {
                num2 = list.get(i);
            } else {
                num2 = 0;
            }
            BleWritable.writeInt16$default(this, num2.intValue(), null, 2, null);
        }
        for (int i2 = 0; i2 < 8; i2++) {
            List<Integer> list2 = this.mBreakTime;
            if (i2 >= 0 && i2 <= CollectionsKt__CollectionsKt.oo0xXOI0I(list2)) {
                num = list2.get(i2);
            } else {
                num = 0;
            }
            BleWritable.writeInt16$default(this, num.intValue(), null, 2, null);
        }
        writeInt8(this.mVibration);
        writeInt8(this.mButtonType);
        writeInt8(this.mHomeTeamColor);
        writeInt8(this.mGuestTeamColor);
        BleWritable.writeInt16$default(this, this.mPenaltyTime, null, 2, null);
        writeInt8(this.mGps);
        writeInt8(this.mScreen);
        writeInt8(this.mMatchView);
        int i3 = 0;
        while (true) {
            String str2 = "";
            if (i3 >= 2) {
                break;
            }
            List<String> list3 = this.mTeamNames;
            if (i3 >= 0 && i3 <= CollectionsKt__CollectionsKt.oo0xXOI0I(list3)) {
                str2 = list3.get(i3);
            }
            BleWritable.writeStringWithFix$default(this, str2, 25, null, 4, null);
            i3++;
        }
        for (int i4 = 0; i4 < 4; i4++) {
            List<String> list4 = this.mRefereeRole;
            if (i4 < 0 || i4 > CollectionsKt__CollectionsKt.oo0xXOI0I(list4)) {
                str = "";
            } else {
                str = list4.get(i4);
            }
            BleWritable.writeStringWithFix$default(this, str, 25, null, 4, null);
        }
        writeInt8(this.mEventTime);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleMatchYouthSettings)) {
            return false;
        }
        BleMatchYouthSettings bleMatchYouthSettings = (BleMatchYouthSettings) obj;
        return this.mPeriods == bleMatchYouthSettings.mPeriods && IIX0o.Oxx0IOOO(this.mPeriodTime, bleMatchYouthSettings.mPeriodTime) && IIX0o.Oxx0IOOO(this.mBreakTime, bleMatchYouthSettings.mBreakTime) && this.mVibration == bleMatchYouthSettings.mVibration && this.mButtonType == bleMatchYouthSettings.mButtonType && this.mHomeTeamColor == bleMatchYouthSettings.mHomeTeamColor && this.mGuestTeamColor == bleMatchYouthSettings.mGuestTeamColor && this.mPenaltyTime == bleMatchYouthSettings.mPenaltyTime && this.mGps == bleMatchYouthSettings.mGps && this.mScreen == bleMatchYouthSettings.mScreen && this.mMatchView == bleMatchYouthSettings.mMatchView && IIX0o.Oxx0IOOO(this.mTeamNames, bleMatchYouthSettings.mTeamNames) && IIX0o.Oxx0IOOO(this.mRefereeRole, bleMatchYouthSettings.mRefereeRole) && this.mEventTime == bleMatchYouthSettings.mEventTime;
    }

    @OOXIXo
    public final List<Integer> getMBreakTime() {
        return this.mBreakTime;
    }

    public final int getMButtonType() {
        return this.mButtonType;
    }

    public final int getMEventTime() {
        return this.mEventTime;
    }

    public final int getMGps() {
        return this.mGps;
    }

    public final int getMGuestTeamColor() {
        return this.mGuestTeamColor;
    }

    public final int getMHomeTeamColor() {
        return this.mHomeTeamColor;
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public int getMLengthToWrite() {
        return 196;
    }

    public final int getMMatchView() {
        return this.mMatchView;
    }

    public final int getMPenaltyTime() {
        return this.mPenaltyTime;
    }

    @OOXIXo
    public final List<Integer> getMPeriodTime() {
        return this.mPeriodTime;
    }

    public final int getMPeriods() {
        return this.mPeriods;
    }

    @OOXIXo
    public final List<String> getMRefereeRole() {
        return this.mRefereeRole;
    }

    public final int getMScreen() {
        return this.mScreen;
    }

    @OOXIXo
    public final List<String> getMTeamNames() {
        return this.mTeamNames;
    }

    public final int getMVibration() {
        return this.mVibration;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((this.mPeriods * 31) + this.mPeriodTime.hashCode()) * 31) + this.mBreakTime.hashCode()) * 31) + this.mVibration) * 31) + this.mButtonType) * 31) + this.mHomeTeamColor) * 31) + this.mGuestTeamColor) * 31) + this.mPenaltyTime) * 31) + this.mGps) * 31) + this.mScreen) * 31) + this.mMatchView) * 31) + this.mTeamNames.hashCode()) * 31) + this.mRefereeRole.hashCode()) * 31) + this.mEventTime;
    }

    public final void setMBreakTime(@OOXIXo List<Integer> list) {
        IIX0o.x0xO0oo(list, "<set-?>");
        this.mBreakTime = list;
    }

    public final void setMButtonType(int i) {
        this.mButtonType = i;
    }

    public final void setMEventTime(int i) {
        this.mEventTime = i;
    }

    public final void setMGps(int i) {
        this.mGps = i;
    }

    public final void setMGuestTeamColor(int i) {
        this.mGuestTeamColor = i;
    }

    public final void setMHomeTeamColor(int i) {
        this.mHomeTeamColor = i;
    }

    public final void setMMatchView(int i) {
        this.mMatchView = i;
    }

    public final void setMPenaltyTime(int i) {
        this.mPenaltyTime = i;
    }

    public final void setMPeriodTime(@OOXIXo List<Integer> list) {
        IIX0o.x0xO0oo(list, "<set-?>");
        this.mPeriodTime = list;
    }

    public final void setMPeriods(int i) {
        this.mPeriods = i;
    }

    public final void setMRefereeRole(@OOXIXo List<String> list) {
        IIX0o.x0xO0oo(list, "<set-?>");
        this.mRefereeRole = list;
    }

    public final void setMScreen(int i) {
        this.mScreen = i;
    }

    public final void setMTeamNames(@OOXIXo List<String> list) {
        IIX0o.x0xO0oo(list, "<set-?>");
        this.mTeamNames = list;
    }

    public final void setMVibration(int i) {
        this.mVibration = i;
    }

    @OOXIXo
    public String toString() {
        return "BleMatchYouthSettings(mPeriods=" + this.mPeriods + ", mPeriodTime=" + this.mPeriodTime + ", mBreakTime=" + this.mBreakTime + ", mVibration=" + this.mVibration + ", mButtonType=" + this.mButtonType + ", mHomeTeamColor=" + this.mHomeTeamColor + ", mGuestTeamColor=" + this.mGuestTeamColor + ", mPenaltyTime=" + this.mPenaltyTime + ", mGps=" + this.mGps + ", mScreen=" + this.mScreen + ", mMatchView=" + this.mMatchView + ", mTeamNames=" + this.mTeamNames + ", mRefereeRole=" + this.mRefereeRole + ", mEventTime=" + this.mEventTime + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleMatchYouthSettings(int i, List list, List list2, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, List list3, List list4, int i10, int i11, IIXOooo iIXOooo) {
        this((i11 & 1) != 0 ? 0 : i, (i11 & 2) != 0 ? new ArrayList() : list, (i11 & 4) != 0 ? new ArrayList() : list2, (i11 & 8) != 0 ? 0 : i2, (i11 & 16) != 0 ? 0 : i3, (i11 & 32) != 0 ? 0 : i4, (i11 & 64) != 0 ? 0 : i5, (i11 & 128) != 0 ? 0 : i6, (i11 & 256) != 0 ? 0 : i7, (i11 & 512) != 0 ? 0 : i8, (i11 & 1024) != 0 ? 0 : i9, (i11 & 2048) != 0 ? new ArrayList() : list3, (i11 & 4096) != 0 ? new ArrayList() : list4, (i11 & 8192) == 0 ? i10 : 0);
    }

    public BleMatchYouthSettings(int i, @OOXIXo List<Integer> mPeriodTime, @OOXIXo List<Integer> mBreakTime, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, @OOXIXo List<String> mTeamNames, @OOXIXo List<String> mRefereeRole, int i10) {
        IIX0o.x0xO0oo(mPeriodTime, "mPeriodTime");
        IIX0o.x0xO0oo(mBreakTime, "mBreakTime");
        IIX0o.x0xO0oo(mTeamNames, "mTeamNames");
        IIX0o.x0xO0oo(mRefereeRole, "mRefereeRole");
        this.mPeriods = i;
        this.mPeriodTime = mPeriodTime;
        this.mBreakTime = mBreakTime;
        this.mVibration = i2;
        this.mButtonType = i3;
        this.mHomeTeamColor = i4;
        this.mGuestTeamColor = i5;
        this.mPenaltyTime = i6;
        this.mGps = i7;
        this.mScreen = i8;
        this.mMatchView = i9;
        this.mTeamNames = mTeamNames;
        this.mRefereeRole = mRefereeRole;
        this.mEventTime = i10;
    }
}
