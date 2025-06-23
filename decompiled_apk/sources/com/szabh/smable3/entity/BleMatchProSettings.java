package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.text.TextUtils;
import com.bestmafen.baseble.data.BleWritable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;
import oI00o.XO;

@XX({"SMAP\nBleMatchProSettings.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BleMatchProSettings.kt\ncom/szabh/smable3/entity/BleMatchProSettings\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,99:1\n1#2:100\n1855#3,2:101\n1855#3,2:103\n1855#3,2:105\n*S KotlinDebug\n*F\n+ 1 BleMatchProSettings.kt\ncom/szabh/smable3/entity/BleMatchProSettings\n*L\n63#1:101,2\n74#1:103,2\n85#1:105,2\n*E\n"})
/* loaded from: classes13.dex */
public final class BleMatchProSettings extends BleWritable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int NAME_LENGTH = 25;

    @OOXIXo
    private List<Integer> mBreakTime;
    private int mButtonType;

    @OOXIXo
    private List<String> mGoalTypes;
    private int mGoalTypesEnable;
    private int mGps;
    private int mGuestTeamColor;
    private int mHomeTeamColor;
    private int mMatchView;

    @OOXIXo
    private List<Integer> mPeriodTime;
    private int mPeriods;

    @OOXIXo
    private List<String> mRedCardTypes;
    private int mRedCardTypesEnable;

    @OOXIXo
    private List<String> mRefereeRole;
    private int mScreen;

    @OOXIXo
    private List<String> mTeamNames;
    private int mVibration;

    @OOXIXo
    private List<String> mYellowCardTypes;
    private int mYellowCardTypesEnable;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public BleMatchProSettings() {
        this(0, null, null, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, null, 0, 0, 0, XO.f31358oIX0oI, null);
    }

    public final int component1() {
        return this.mPeriods;
    }

    public final int component10() {
        return this.mMatchView;
    }

    @OOXIXo
    public final List<String> component11() {
        return this.mTeamNames;
    }

    @OOXIXo
    public final List<String> component12() {
        return this.mRefereeRole;
    }

    @OOXIXo
    public final List<String> component13() {
        return this.mGoalTypes;
    }

    @OOXIXo
    public final List<String> component14() {
        return this.mYellowCardTypes;
    }

    @OOXIXo
    public final List<String> component15() {
        return this.mRedCardTypes;
    }

    public final int component16() {
        return this.mGoalTypesEnable;
    }

    public final int component17() {
        return this.mYellowCardTypesEnable;
    }

    public final int component18() {
        return this.mRedCardTypesEnable;
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
        return this.mGps;
    }

    public final int component9() {
        return this.mScreen;
    }

    @OOXIXo
    public final BleMatchProSettings copy(int i, @OOXIXo List<Integer> mPeriodTime, @OOXIXo List<Integer> mBreakTime, int i2, int i3, int i4, int i5, int i6, int i7, int i8, @OOXIXo List<String> mTeamNames, @OOXIXo List<String> mRefereeRole, @OOXIXo List<String> mGoalTypes, @OOXIXo List<String> mYellowCardTypes, @OOXIXo List<String> mRedCardTypes, int i9, int i10, int i11) {
        IIX0o.x0xO0oo(mPeriodTime, "mPeriodTime");
        IIX0o.x0xO0oo(mBreakTime, "mBreakTime");
        IIX0o.x0xO0oo(mTeamNames, "mTeamNames");
        IIX0o.x0xO0oo(mRefereeRole, "mRefereeRole");
        IIX0o.x0xO0oo(mGoalTypes, "mGoalTypes");
        IIX0o.x0xO0oo(mYellowCardTypes, "mYellowCardTypes");
        IIX0o.x0xO0oo(mRedCardTypes, "mRedCardTypes");
        return new BleMatchProSettings(i, mPeriodTime, mBreakTime, i2, i3, i4, i5, i6, i7, i8, mTeamNames, mRefereeRole, mGoalTypes, mYellowCardTypes, mRedCardTypes, i9, i10, i11);
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public void encode() {
        String str;
        String str2;
        String str3;
        String str4;
        Integer num;
        Integer num2;
        super.encode();
        writeInt8(2);
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
        writeInt8(this.mGps);
        writeInt8(this.mScreen);
        writeInt8(this.mMatchView);
        int i3 = 0;
        while (true) {
            String str5 = "";
            if (i3 >= 2) {
                break;
            }
            List<String> list3 = this.mTeamNames;
            if (i3 >= 0 && i3 <= CollectionsKt__CollectionsKt.oo0xXOI0I(list3)) {
                str5 = list3.get(i3);
            }
            BleWritable.writeStringWithFix$default(this, str5, 25, null, 4, null);
            i3++;
        }
        for (int i4 = 0; i4 < 4; i4++) {
            List<String> list4 = this.mRefereeRole;
            if (i4 < 0 || i4 > CollectionsKt__CollectionsKt.oo0xXOI0I(list4)) {
                str4 = "";
            } else {
                str4 = list4.get(i4);
            }
            BleWritable.writeStringWithFix$default(this, str4, 25, null, 4, null);
        }
        Iterator<T> it = this.mGoalTypes.iterator();
        int i5 = 0;
        while (it.hasNext()) {
            if (!TextUtils.isEmpty((String) it.next())) {
                i5++;
            }
        }
        if (this.mGoalTypesEnable == 0) {
            i5 = 0;
        }
        writeInt8(i5);
        for (int i6 = 0; i6 < 8; i6++) {
            List<String> list5 = this.mGoalTypes;
            if (i6 < 0 || i6 > CollectionsKt__CollectionsKt.oo0xXOI0I(list5)) {
                str3 = "";
            } else {
                str3 = list5.get(i6);
            }
            BleWritable.writeStringWithFix$default(this, str3, 25, null, 4, null);
        }
        Iterator<T> it2 = this.mYellowCardTypes.iterator();
        int i7 = 0;
        while (it2.hasNext()) {
            if (!TextUtils.isEmpty((String) it2.next())) {
                i7++;
            }
        }
        if (this.mYellowCardTypesEnable == 0) {
            i7 = 0;
        }
        writeInt8(i7);
        for (int i8 = 0; i8 < 5; i8++) {
            List<String> list6 = this.mYellowCardTypes;
            if (i8 < 0 || i8 > CollectionsKt__CollectionsKt.oo0xXOI0I(list6)) {
                str2 = "";
            } else {
                str2 = list6.get(i8);
            }
            BleWritable.writeStringWithFix$default(this, str2, 25, null, 4, null);
        }
        Iterator<T> it3 = this.mRedCardTypes.iterator();
        int i9 = 0;
        while (it3.hasNext()) {
            if (!TextUtils.isEmpty((String) it3.next())) {
                i9++;
            }
        }
        if (this.mRedCardTypesEnable == 0) {
            i9 = 0;
        }
        writeInt8(i9);
        for (int i10 = 0; i10 < 5; i10++) {
            List<String> list7 = this.mRedCardTypes;
            if (i10 < 0 || i10 > CollectionsKt__CollectionsKt.oo0xXOI0I(list7)) {
                str = "";
            } else {
                str = list7.get(i10);
            }
            BleWritable.writeStringWithFix$default(this, str, 25, null, 4, null);
        }
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleMatchProSettings)) {
            return false;
        }
        BleMatchProSettings bleMatchProSettings = (BleMatchProSettings) obj;
        return this.mPeriods == bleMatchProSettings.mPeriods && IIX0o.Oxx0IOOO(this.mPeriodTime, bleMatchProSettings.mPeriodTime) && IIX0o.Oxx0IOOO(this.mBreakTime, bleMatchProSettings.mBreakTime) && this.mVibration == bleMatchProSettings.mVibration && this.mButtonType == bleMatchProSettings.mButtonType && this.mHomeTeamColor == bleMatchProSettings.mHomeTeamColor && this.mGuestTeamColor == bleMatchProSettings.mGuestTeamColor && this.mGps == bleMatchProSettings.mGps && this.mScreen == bleMatchProSettings.mScreen && this.mMatchView == bleMatchProSettings.mMatchView && IIX0o.Oxx0IOOO(this.mTeamNames, bleMatchProSettings.mTeamNames) && IIX0o.Oxx0IOOO(this.mRefereeRole, bleMatchProSettings.mRefereeRole) && IIX0o.Oxx0IOOO(this.mGoalTypes, bleMatchProSettings.mGoalTypes) && IIX0o.Oxx0IOOO(this.mYellowCardTypes, bleMatchProSettings.mYellowCardTypes) && IIX0o.Oxx0IOOO(this.mRedCardTypes, bleMatchProSettings.mRedCardTypes) && this.mGoalTypesEnable == bleMatchProSettings.mGoalTypesEnable && this.mYellowCardTypesEnable == bleMatchProSettings.mYellowCardTypesEnable && this.mRedCardTypesEnable == bleMatchProSettings.mRedCardTypesEnable;
    }

    @OOXIXo
    public final List<Integer> getMBreakTime() {
        return this.mBreakTime;
    }

    public final int getMButtonType() {
        return this.mButtonType;
    }

    @OOXIXo
    public final List<String> getMGoalTypes() {
        return this.mGoalTypes;
    }

    public final int getMGoalTypesEnable() {
        return this.mGoalTypesEnable;
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
        return 646;
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
    public final List<String> getMRedCardTypes() {
        return this.mRedCardTypes;
    }

    public final int getMRedCardTypesEnable() {
        return this.mRedCardTypesEnable;
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

    @OOXIXo
    public final List<String> getMYellowCardTypes() {
        return this.mYellowCardTypes;
    }

    public final int getMYellowCardTypesEnable() {
        return this.mYellowCardTypesEnable;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((this.mPeriods * 31) + this.mPeriodTime.hashCode()) * 31) + this.mBreakTime.hashCode()) * 31) + this.mVibration) * 31) + this.mButtonType) * 31) + this.mHomeTeamColor) * 31) + this.mGuestTeamColor) * 31) + this.mGps) * 31) + this.mScreen) * 31) + this.mMatchView) * 31) + this.mTeamNames.hashCode()) * 31) + this.mRefereeRole.hashCode()) * 31) + this.mGoalTypes.hashCode()) * 31) + this.mYellowCardTypes.hashCode()) * 31) + this.mRedCardTypes.hashCode()) * 31) + this.mGoalTypesEnable) * 31) + this.mYellowCardTypesEnable) * 31) + this.mRedCardTypesEnable;
    }

    public final void setMBreakTime(@OOXIXo List<Integer> list) {
        IIX0o.x0xO0oo(list, "<set-?>");
        this.mBreakTime = list;
    }

    public final void setMButtonType(int i) {
        this.mButtonType = i;
    }

    public final void setMGoalTypes(@OOXIXo List<String> list) {
        IIX0o.x0xO0oo(list, "<set-?>");
        this.mGoalTypes = list;
    }

    public final void setMGoalTypesEnable(int i) {
        this.mGoalTypesEnable = i;
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

    public final void setMPeriodTime(@OOXIXo List<Integer> list) {
        IIX0o.x0xO0oo(list, "<set-?>");
        this.mPeriodTime = list;
    }

    public final void setMPeriods(int i) {
        this.mPeriods = i;
    }

    public final void setMRedCardTypes(@OOXIXo List<String> list) {
        IIX0o.x0xO0oo(list, "<set-?>");
        this.mRedCardTypes = list;
    }

    public final void setMRedCardTypesEnable(int i) {
        this.mRedCardTypesEnable = i;
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

    public final void setMYellowCardTypes(@OOXIXo List<String> list) {
        IIX0o.x0xO0oo(list, "<set-?>");
        this.mYellowCardTypes = list;
    }

    public final void setMYellowCardTypesEnable(int i) {
        this.mYellowCardTypesEnable = i;
    }

    @OOXIXo
    public String toString() {
        return "BleMatchProSettings(mPeriods=" + this.mPeriods + ", mPeriodTime=" + this.mPeriodTime + ", mBreakTime=" + this.mBreakTime + ", mVibration=" + this.mVibration + ", mButtonType=" + this.mButtonType + ", mHomeTeamColor=" + this.mHomeTeamColor + ", mGuestTeamColor=" + this.mGuestTeamColor + ", mGps=" + this.mGps + ", mScreen=" + this.mScreen + ", mMatchView=" + this.mMatchView + ", mTeamNames=" + this.mTeamNames + ", mRefereeRole=" + this.mRefereeRole + ", mGoalTypes=" + this.mGoalTypes + ", mYellowCardTypes=" + this.mYellowCardTypes + ", mRedCardTypes=" + this.mRedCardTypes + ", mGoalTypesEnable=" + this.mGoalTypesEnable + ", mYellowCardTypesEnable=" + this.mYellowCardTypesEnable + ", mRedCardTypesEnable=" + this.mRedCardTypesEnable + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleMatchProSettings(int i, List list, List list2, int i2, int i3, int i4, int i5, int i6, int i7, int i8, List list3, List list4, List list5, List list6, List list7, int i9, int i10, int i11, int i12, IIXOooo iIXOooo) {
        this((i12 & 1) != 0 ? 0 : i, (i12 & 2) != 0 ? new ArrayList() : list, (i12 & 4) != 0 ? new ArrayList() : list2, (i12 & 8) != 0 ? 0 : i2, (i12 & 16) != 0 ? 0 : i3, (i12 & 32) != 0 ? 0 : i4, (i12 & 64) != 0 ? 0 : i5, (i12 & 128) != 0 ? 0 : i6, (i12 & 256) != 0 ? 0 : i7, (i12 & 512) != 0 ? 0 : i8, (i12 & 1024) != 0 ? new ArrayList() : list3, (i12 & 2048) != 0 ? new ArrayList() : list4, (i12 & 4096) != 0 ? new ArrayList() : list5, (i12 & 8192) != 0 ? new ArrayList() : list6, (i12 & 16384) != 0 ? new ArrayList() : list7, (i12 & 32768) != 0 ? 0 : i9, (i12 & 65536) != 0 ? 0 : i10, (i12 & 131072) != 0 ? 0 : i11);
    }

    public BleMatchProSettings(int i, @OOXIXo List<Integer> mPeriodTime, @OOXIXo List<Integer> mBreakTime, int i2, int i3, int i4, int i5, int i6, int i7, int i8, @OOXIXo List<String> mTeamNames, @OOXIXo List<String> mRefereeRole, @OOXIXo List<String> mGoalTypes, @OOXIXo List<String> mYellowCardTypes, @OOXIXo List<String> mRedCardTypes, int i9, int i10, int i11) {
        IIX0o.x0xO0oo(mPeriodTime, "mPeriodTime");
        IIX0o.x0xO0oo(mBreakTime, "mBreakTime");
        IIX0o.x0xO0oo(mTeamNames, "mTeamNames");
        IIX0o.x0xO0oo(mRefereeRole, "mRefereeRole");
        IIX0o.x0xO0oo(mGoalTypes, "mGoalTypes");
        IIX0o.x0xO0oo(mYellowCardTypes, "mYellowCardTypes");
        IIX0o.x0xO0oo(mRedCardTypes, "mRedCardTypes");
        this.mPeriods = i;
        this.mPeriodTime = mPeriodTime;
        this.mBreakTime = mBreakTime;
        this.mVibration = i2;
        this.mButtonType = i3;
        this.mHomeTeamColor = i4;
        this.mGuestTeamColor = i5;
        this.mGps = i6;
        this.mScreen = i7;
        this.mMatchView = i8;
        this.mTeamNames = mTeamNames;
        this.mRefereeRole = mRefereeRole;
        this.mGoalTypes = mGoalTypes;
        this.mYellowCardTypes = mYellowCardTypes;
        this.mRedCardTypes = mRedCardTypes;
        this.mGoalTypesEnable = i9;
        this.mYellowCardTypesEnable = i10;
        this.mRedCardTypesEnable = i11;
    }
}
