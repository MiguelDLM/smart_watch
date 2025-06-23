package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleWritable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nBleMatchClassicSettings.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BleMatchClassicSettings.kt\ncom/szabh/smable3/entity/BleMatchClassicSettings\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,54:1\n1#2:55\n*E\n"})
/* loaded from: classes13.dex */
public final class BleMatchClassicSettings extends BleWritable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int NAME_LENGTH = 25;

    @OOXIXo
    private List<Integer> mBreakTime;
    private int mButtonType;
    private int mGps;
    private int mMatchView;

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

    public BleMatchClassicSettings() {
        this(0, null, null, 0, 0, 0, 0, 0, null, null, 1023, null);
    }

    public final int component1() {
        return this.mPeriods;
    }

    @OOXIXo
    public final List<String> component10() {
        return this.mRefereeRole;
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
        return this.mGps;
    }

    public final int component7() {
        return this.mScreen;
    }

    public final int component8() {
        return this.mMatchView;
    }

    @OOXIXo
    public final List<String> component9() {
        return this.mTeamNames;
    }

    @OOXIXo
    public final BleMatchClassicSettings copy(int i, @OOXIXo List<Integer> mPeriodTime, @OOXIXo List<Integer> mBreakTime, int i2, int i3, int i4, int i5, int i6, @OOXIXo List<String> mTeamNames, @OOXIXo List<String> mRefereeRole) {
        IIX0o.x0xO0oo(mPeriodTime, "mPeriodTime");
        IIX0o.x0xO0oo(mBreakTime, "mBreakTime");
        IIX0o.x0xO0oo(mTeamNames, "mTeamNames");
        IIX0o.x0xO0oo(mRefereeRole, "mRefereeRole");
        return new BleMatchClassicSettings(i, mPeriodTime, mBreakTime, i2, i3, i4, i5, i6, mTeamNames, mRefereeRole);
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public void encode() {
        String str;
        Integer num;
        Integer num2;
        super.encode();
        writeInt8(1);
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
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleMatchClassicSettings)) {
            return false;
        }
        BleMatchClassicSettings bleMatchClassicSettings = (BleMatchClassicSettings) obj;
        return this.mPeriods == bleMatchClassicSettings.mPeriods && IIX0o.Oxx0IOOO(this.mPeriodTime, bleMatchClassicSettings.mPeriodTime) && IIX0o.Oxx0IOOO(this.mBreakTime, bleMatchClassicSettings.mBreakTime) && this.mVibration == bleMatchClassicSettings.mVibration && this.mButtonType == bleMatchClassicSettings.mButtonType && this.mGps == bleMatchClassicSettings.mGps && this.mScreen == bleMatchClassicSettings.mScreen && this.mMatchView == bleMatchClassicSettings.mMatchView && IIX0o.Oxx0IOOO(this.mTeamNames, bleMatchClassicSettings.mTeamNames) && IIX0o.Oxx0IOOO(this.mRefereeRole, bleMatchClassicSettings.mRefereeRole);
    }

    @OOXIXo
    public final List<Integer> getMBreakTime() {
        return this.mBreakTime;
    }

    public final int getMButtonType() {
        return this.mButtonType;
    }

    public final int getMGps() {
        return this.mGps;
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public int getMLengthToWrite() {
        return 192;
    }

    public final int getMMatchView() {
        return this.mMatchView;
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
        return (((((((((((((((((this.mPeriods * 31) + this.mPeriodTime.hashCode()) * 31) + this.mBreakTime.hashCode()) * 31) + this.mVibration) * 31) + this.mButtonType) * 31) + this.mGps) * 31) + this.mScreen) * 31) + this.mMatchView) * 31) + this.mTeamNames.hashCode()) * 31) + this.mRefereeRole.hashCode();
    }

    public final void setMBreakTime(@OOXIXo List<Integer> list) {
        IIX0o.x0xO0oo(list, "<set-?>");
        this.mBreakTime = list;
    }

    public final void setMButtonType(int i) {
        this.mButtonType = i;
    }

    public final void setMGps(int i) {
        this.mGps = i;
    }

    public final void setMMatchView(int i) {
        this.mMatchView = i;
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
        return "BleMatchClassicSettings(mPeriods=" + this.mPeriods + ", mPeriodTime=" + this.mPeriodTime + ", mBreakTime=" + this.mBreakTime + ", mVibration=" + this.mVibration + ", mButtonType=" + this.mButtonType + ", mGps=" + this.mGps + ", mScreen=" + this.mScreen + ", mMatchView=" + this.mMatchView + ", mTeamNames=" + this.mTeamNames + ", mRefereeRole=" + this.mRefereeRole + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleMatchClassicSettings(int i, List list, List list2, int i2, int i3, int i4, int i5, int i6, List list3, List list4, int i7, IIXOooo iIXOooo) {
        this((i7 & 1) != 0 ? 0 : i, (i7 & 2) != 0 ? new ArrayList() : list, (i7 & 4) != 0 ? new ArrayList() : list2, (i7 & 8) != 0 ? 0 : i2, (i7 & 16) != 0 ? 0 : i3, (i7 & 32) != 0 ? 0 : i4, (i7 & 64) != 0 ? 0 : i5, (i7 & 128) == 0 ? i6 : 0, (i7 & 256) != 0 ? new ArrayList() : list3, (i7 & 512) != 0 ? new ArrayList() : list4);
    }

    public BleMatchClassicSettings(int i, @OOXIXo List<Integer> mPeriodTime, @OOXIXo List<Integer> mBreakTime, int i2, int i3, int i4, int i5, int i6, @OOXIXo List<String> mTeamNames, @OOXIXo List<String> mRefereeRole) {
        IIX0o.x0xO0oo(mPeriodTime, "mPeriodTime");
        IIX0o.x0xO0oo(mBreakTime, "mBreakTime");
        IIX0o.x0xO0oo(mTeamNames, "mTeamNames");
        IIX0o.x0xO0oo(mRefereeRole, "mRefereeRole");
        this.mPeriods = i;
        this.mPeriodTime = mPeriodTime;
        this.mBreakTime = mBreakTime;
        this.mVibration = i2;
        this.mButtonType = i3;
        this.mGps = i4;
        this.mScreen = i5;
        this.mMatchView = i6;
        this.mTeamNames = mTeamNames;
        this.mRefereeRole = mRefereeRole;
    }
}
