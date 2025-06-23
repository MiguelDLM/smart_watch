package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.text.TextUtils;
import com.bestmafen.baseble.data.BleReadable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nBleMatchRecordTeam.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BleMatchRecordTeam.kt\ncom/szabh/smable3/entity/BleMatchRecordTeam\n+ 2 BleReadable.kt\ncom/bestmafen/baseble/data/BleReadable\n*L\n1#1,79:1\n232#2,3:80\n222#2,15:83\n232#2,3:98\n222#2,15:101\n*S KotlinDebug\n*F\n+ 1 BleMatchRecordTeam.kt\ncom/szabh/smable3/entity/BleMatchRecordTeam\n*L\n46#1:80,3\n46#1:83,15\n48#1:98,3\n48#1:101,15\n*E\n"})
/* loaded from: classes13.dex */
public final class BleMatchRecordTeam extends BleReadable implements Serializable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_LENGTH = 1908;
    public static final int NAME_LENGTH = 25;

    @OOXIXo
    private List<String> mGoalTypes;

    @OOXIXo
    private List<BleMatchRecordPlayer> mGuestPlayers;
    private int mGuestTeamColor;

    @OOXIXo
    private List<BleMatchRecordPlayer> mHomePlayers;
    private int mHomeTeamColor;

    @OOXIXo
    private List<String> mRedCardTypes;

    @OOXIXo
    private List<String> mRefereeRoles;

    @OOXIXo
    private List<String> mTeamNames;

    @OOXIXo
    private List<String> mYellowCardTypes;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public BleMatchRecordTeam() {
        this(null, 0, 0, null, null, null, null, null, null, 511, null);
    }

    @OOXIXo
    public final List<String> component1() {
        return this.mTeamNames;
    }

    public final int component2() {
        return this.mHomeTeamColor;
    }

    public final int component3() {
        return this.mGuestTeamColor;
    }

    @OOXIXo
    public final List<String> component4() {
        return this.mRefereeRoles;
    }

    @OOXIXo
    public final List<BleMatchRecordPlayer> component5() {
        return this.mHomePlayers;
    }

    @OOXIXo
    public final List<BleMatchRecordPlayer> component6() {
        return this.mGuestPlayers;
    }

    @OOXIXo
    public final List<String> component7() {
        return this.mGoalTypes;
    }

    @OOXIXo
    public final List<String> component8() {
        return this.mYellowCardTypes;
    }

    @OOXIXo
    public final List<String> component9() {
        return this.mRedCardTypes;
    }

    @OOXIXo
    public final BleMatchRecordTeam copy(@OOXIXo List<String> mTeamNames, int i, int i2, @OOXIXo List<String> mRefereeRoles, @OOXIXo List<BleMatchRecordPlayer> mHomePlayers, @OOXIXo List<BleMatchRecordPlayer> mGuestPlayers, @OOXIXo List<String> mGoalTypes, @OOXIXo List<String> mYellowCardTypes, @OOXIXo List<String> mRedCardTypes) {
        IIX0o.x0xO0oo(mTeamNames, "mTeamNames");
        IIX0o.x0xO0oo(mRefereeRoles, "mRefereeRoles");
        IIX0o.x0xO0oo(mHomePlayers, "mHomePlayers");
        IIX0o.x0xO0oo(mGuestPlayers, "mGuestPlayers");
        IIX0o.x0xO0oo(mGoalTypes, "mGoalTypes");
        IIX0o.x0xO0oo(mYellowCardTypes, "mYellowCardTypes");
        IIX0o.x0xO0oo(mRedCardTypes, "mRedCardTypes");
        return new BleMatchRecordTeam(mTeamNames, i, i2, mRefereeRoles, mHomePlayers, mGuestPlayers, mGoalTypes, mYellowCardTypes, mRedCardTypes);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 2; i++) {
            String readString$default = BleReadable.readString$default(this, 25, null, 2, null);
            if (!TextUtils.isEmpty(readString$default)) {
                arrayList.add(readString$default);
            }
        }
        this.mTeamNames = arrayList;
        this.mHomeTeamColor = readInt8();
        this.mGuestTeamColor = readInt8();
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < 4; i2++) {
            String readString$default2 = BleReadable.readString$default(this, 25, null, 2, null);
            if (!TextUtils.isEmpty(readString$default2)) {
                arrayList2.add(readString$default2);
            }
        }
        this.mRefereeRoles = arrayList2;
        ArrayList arrayList3 = new ArrayList();
        for (int i3 = 0; i3 < 25; i3++) {
            BleReadable bleReadable = (BleReadable) BleMatchRecordPlayer.class.newInstance();
            bleReadable.setMBytes(readBytes(26));
            bleReadable.decode();
            IIX0o.ooOOo0oXI(bleReadable);
            arrayList3.add(bleReadable);
        }
        ArrayList arrayList4 = new ArrayList();
        for (int i4 = 0; i4 < 25; i4++) {
            BleReadable bleReadable2 = (BleReadable) BleMatchRecordPlayer.class.newInstance();
            bleReadable2.setMBytes(readBytes(26));
            bleReadable2.decode();
            IIX0o.ooOOo0oXI(bleReadable2);
            arrayList4.add(bleReadable2);
        }
        ArrayList arrayList5 = new ArrayList();
        for (int i5 = 0; i5 < 8; i5++) {
            arrayList5.add(BleReadable.readString$default(this, 25, null, 2, null));
        }
        ArrayList arrayList6 = new ArrayList();
        for (int i6 = 0; i6 < 5; i6++) {
            arrayList6.add(BleReadable.readString$default(this, 25, null, 2, null));
        }
        ArrayList arrayList7 = new ArrayList();
        for (int i7 = 0; i7 < 5; i7++) {
            arrayList7.add(BleReadable.readString$default(this, 25, null, 2, null));
        }
        this.mHomePlayers = CollectionsKt___CollectionsKt.O0o000XOX(arrayList3, readInt8());
        this.mGuestPlayers = CollectionsKt___CollectionsKt.O0o000XOX(arrayList4, readInt8());
        this.mGoalTypes = CollectionsKt___CollectionsKt.O0o000XOX(arrayList5, readInt8());
        this.mYellowCardTypes = CollectionsKt___CollectionsKt.O0o000XOX(arrayList6, readInt8());
        this.mRedCardTypes = CollectionsKt___CollectionsKt.O0o000XOX(arrayList7, readInt8());
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleMatchRecordTeam)) {
            return false;
        }
        BleMatchRecordTeam bleMatchRecordTeam = (BleMatchRecordTeam) obj;
        return IIX0o.Oxx0IOOO(this.mTeamNames, bleMatchRecordTeam.mTeamNames) && this.mHomeTeamColor == bleMatchRecordTeam.mHomeTeamColor && this.mGuestTeamColor == bleMatchRecordTeam.mGuestTeamColor && IIX0o.Oxx0IOOO(this.mRefereeRoles, bleMatchRecordTeam.mRefereeRoles) && IIX0o.Oxx0IOOO(this.mHomePlayers, bleMatchRecordTeam.mHomePlayers) && IIX0o.Oxx0IOOO(this.mGuestPlayers, bleMatchRecordTeam.mGuestPlayers) && IIX0o.Oxx0IOOO(this.mGoalTypes, bleMatchRecordTeam.mGoalTypes) && IIX0o.Oxx0IOOO(this.mYellowCardTypes, bleMatchRecordTeam.mYellowCardTypes) && IIX0o.Oxx0IOOO(this.mRedCardTypes, bleMatchRecordTeam.mRedCardTypes);
    }

    @OOXIXo
    public final List<String> getMGoalTypes() {
        return this.mGoalTypes;
    }

    @OOXIXo
    public final List<BleMatchRecordPlayer> getMGuestPlayers() {
        return this.mGuestPlayers;
    }

    public final int getMGuestTeamColor() {
        return this.mGuestTeamColor;
    }

    @OOXIXo
    public final List<BleMatchRecordPlayer> getMHomePlayers() {
        return this.mHomePlayers;
    }

    public final int getMHomeTeamColor() {
        return this.mHomeTeamColor;
    }

    @OOXIXo
    public final List<String> getMRedCardTypes() {
        return this.mRedCardTypes;
    }

    @OOXIXo
    public final List<String> getMRefereeRoles() {
        return this.mRefereeRoles;
    }

    @OOXIXo
    public final List<String> getMTeamNames() {
        return this.mTeamNames;
    }

    @OOXIXo
    public final List<String> getMYellowCardTypes() {
        return this.mYellowCardTypes;
    }

    public int hashCode() {
        return (((((((((((((((this.mTeamNames.hashCode() * 31) + this.mHomeTeamColor) * 31) + this.mGuestTeamColor) * 31) + this.mRefereeRoles.hashCode()) * 31) + this.mHomePlayers.hashCode()) * 31) + this.mGuestPlayers.hashCode()) * 31) + this.mGoalTypes.hashCode()) * 31) + this.mYellowCardTypes.hashCode()) * 31) + this.mRedCardTypes.hashCode();
    }

    public final void setMGoalTypes(@OOXIXo List<String> list) {
        IIX0o.x0xO0oo(list, "<set-?>");
        this.mGoalTypes = list;
    }

    public final void setMGuestPlayers(@OOXIXo List<BleMatchRecordPlayer> list) {
        IIX0o.x0xO0oo(list, "<set-?>");
        this.mGuestPlayers = list;
    }

    public final void setMGuestTeamColor(int i) {
        this.mGuestTeamColor = i;
    }

    public final void setMHomePlayers(@OOXIXo List<BleMatchRecordPlayer> list) {
        IIX0o.x0xO0oo(list, "<set-?>");
        this.mHomePlayers = list;
    }

    public final void setMHomeTeamColor(int i) {
        this.mHomeTeamColor = i;
    }

    public final void setMRedCardTypes(@OOXIXo List<String> list) {
        IIX0o.x0xO0oo(list, "<set-?>");
        this.mRedCardTypes = list;
    }

    public final void setMRefereeRoles(@OOXIXo List<String> list) {
        IIX0o.x0xO0oo(list, "<set-?>");
        this.mRefereeRoles = list;
    }

    public final void setMTeamNames(@OOXIXo List<String> list) {
        IIX0o.x0xO0oo(list, "<set-?>");
        this.mTeamNames = list;
    }

    public final void setMYellowCardTypes(@OOXIXo List<String> list) {
        IIX0o.x0xO0oo(list, "<set-?>");
        this.mYellowCardTypes = list;
    }

    @OOXIXo
    public String toString() {
        return "BleMatchRecordTeam(mTeamNames=" + this.mTeamNames + ", mHomeTeamColor=" + this.mHomeTeamColor + ", mGuestTeamColor=" + this.mGuestTeamColor + ", mRefereeRoles=" + this.mRefereeRoles + ", mHomePlayers=" + this.mHomePlayers + ", mGuestPlayers=" + this.mGuestPlayers + ", mGoalTypes=" + this.mGoalTypes + ", mYellowCardTypes=" + this.mYellowCardTypes + ", mRedCardTypes=" + this.mRedCardTypes + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleMatchRecordTeam(List list, int i, int i2, List list2, List list3, List list4, List list5, List list6, List list7, int i3, IIXOooo iIXOooo) {
        this((i3 & 1) != 0 ? new ArrayList() : list, (i3 & 2) != 0 ? 0 : i, (i3 & 4) == 0 ? i2 : 0, (i3 & 8) != 0 ? new ArrayList() : list2, (i3 & 16) != 0 ? new ArrayList() : list3, (i3 & 32) != 0 ? new ArrayList() : list4, (i3 & 64) != 0 ? new ArrayList() : list5, (i3 & 128) != 0 ? new ArrayList() : list6, (i3 & 256) != 0 ? new ArrayList() : list7);
    }

    public BleMatchRecordTeam(@OOXIXo List<String> mTeamNames, int i, int i2, @OOXIXo List<String> mRefereeRoles, @OOXIXo List<BleMatchRecordPlayer> mHomePlayers, @OOXIXo List<BleMatchRecordPlayer> mGuestPlayers, @OOXIXo List<String> mGoalTypes, @OOXIXo List<String> mYellowCardTypes, @OOXIXo List<String> mRedCardTypes) {
        IIX0o.x0xO0oo(mTeamNames, "mTeamNames");
        IIX0o.x0xO0oo(mRefereeRoles, "mRefereeRoles");
        IIX0o.x0xO0oo(mHomePlayers, "mHomePlayers");
        IIX0o.x0xO0oo(mGuestPlayers, "mGuestPlayers");
        IIX0o.x0xO0oo(mGoalTypes, "mGoalTypes");
        IIX0o.x0xO0oo(mYellowCardTypes, "mYellowCardTypes");
        IIX0o.x0xO0oo(mRedCardTypes, "mRedCardTypes");
        this.mTeamNames = mTeamNames;
        this.mHomeTeamColor = i;
        this.mGuestTeamColor = i2;
        this.mRefereeRoles = mRefereeRoles;
        this.mHomePlayers = mHomePlayers;
        this.mGuestPlayers = mGuestPlayers;
        this.mGoalTypes = mGoalTypes;
        this.mYellowCardTypes = mYellowCardTypes;
        this.mRedCardTypes = mRedCardTypes;
    }
}
