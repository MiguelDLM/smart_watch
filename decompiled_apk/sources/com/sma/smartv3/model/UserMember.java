package com.sma.smartv3.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.io.Serializable;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class UserMember extends JsonFieldContainer implements Serializable {
    private boolean getGameMemberFlag;
    private boolean getMemberFlag;
    private long latestDateTime;
    private long latestGameMemberDateTime;
    private long serverDateTime;

    public UserMember() {
        this(false, 0L, 0L, false, 0L, 31, null);
    }

    public final boolean component1() {
        return this.getMemberFlag;
    }

    public final long component2() {
        return this.latestDateTime;
    }

    public final long component3() {
        return this.serverDateTime;
    }

    public final boolean component4() {
        return this.getGameMemberFlag;
    }

    public final long component5() {
        return this.latestGameMemberDateTime;
    }

    @OOXIXo
    public final UserMember copy(boolean z, long j, long j2, boolean z2, long j3) {
        return new UserMember(z, j, j2, z2, j3);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserMember)) {
            return false;
        }
        UserMember userMember = (UserMember) obj;
        return this.getMemberFlag == userMember.getMemberFlag && this.latestDateTime == userMember.latestDateTime && this.serverDateTime == userMember.serverDateTime && this.getGameMemberFlag == userMember.getGameMemberFlag && this.latestGameMemberDateTime == userMember.latestGameMemberDateTime;
    }

    public final boolean getGetGameMemberFlag() {
        return this.getGameMemberFlag;
    }

    public final boolean getGetMemberFlag() {
        return this.getMemberFlag;
    }

    public final long getLatestDateTime() {
        return this.latestDateTime;
    }

    public final long getLatestGameMemberDateTime() {
        return this.latestGameMemberDateTime;
    }

    public final long getServerDateTime() {
        return this.serverDateTime;
    }

    public int hashCode() {
        return (((((((androidx.work.oIX0oI.oIX0oI(this.getMemberFlag) * 31) + androidx.collection.oIX0oI.oIX0oI(this.latestDateTime)) * 31) + androidx.collection.oIX0oI.oIX0oI(this.serverDateTime)) * 31) + androidx.work.oIX0oI.oIX0oI(this.getGameMemberFlag)) * 31) + androidx.collection.oIX0oI.oIX0oI(this.latestGameMemberDateTime);
    }

    public final void setGetGameMemberFlag(boolean z) {
        this.getGameMemberFlag = z;
    }

    public final void setGetMemberFlag(boolean z) {
        this.getMemberFlag = z;
    }

    public final void setLatestDateTime(long j) {
        this.latestDateTime = j;
    }

    public final void setLatestGameMemberDateTime(long j) {
        this.latestGameMemberDateTime = j;
    }

    public final void setServerDateTime(long j) {
        this.serverDateTime = j;
    }

    @OOXIXo
    public String toString() {
        return "UserMember(getMemberFlag=" + this.getMemberFlag + ", latestDateTime=" + this.latestDateTime + ", serverDateTime=" + this.serverDateTime + ", getGameMemberFlag=" + this.getGameMemberFlag + ", latestGameMemberDateTime=" + this.latestGameMemberDateTime + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ UserMember(boolean z, long j, long j2, boolean z2, long j3, int i, IIXOooo iIXOooo) {
        this((i & 1) != 0 ? true : z, (i & 2) != 0 ? 0L : j, (i & 4) != 0 ? 0L : j2, (i & 8) == 0 ? z2 : true, (i & 16) == 0 ? j3 : 0L);
    }

    public UserMember(boolean z, long j, long j2, boolean z2, long j3) {
        this.getMemberFlag = z;
        this.latestDateTime = j;
        this.serverDateTime = j2;
        this.getGameMemberFlag = z2;
        this.latestGameMemberDateTime = j3;
    }
}
