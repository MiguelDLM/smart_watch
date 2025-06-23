package com.sma.smartv3.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.io.Serializable;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class AccountPoints extends JsonFieldContainer implements Serializable {
    private int getPointFlag;
    private int points;
    private int userId;

    public AccountPoints() {
        this(0, 0, 0, 7, null);
    }

    public static /* synthetic */ AccountPoints copy$default(AccountPoints accountPoints, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = accountPoints.userId;
        }
        if ((i4 & 2) != 0) {
            i2 = accountPoints.points;
        }
        if ((i4 & 4) != 0) {
            i3 = accountPoints.getPointFlag;
        }
        return accountPoints.copy(i, i2, i3);
    }

    public final int component1() {
        return this.userId;
    }

    public final int component2() {
        return this.points;
    }

    public final int component3() {
        return this.getPointFlag;
    }

    @OOXIXo
    public final AccountPoints copy(int i, int i2, int i3) {
        return new AccountPoints(i, i2, i3);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AccountPoints)) {
            return false;
        }
        AccountPoints accountPoints = (AccountPoints) obj;
        return this.userId == accountPoints.userId && this.points == accountPoints.points && this.getPointFlag == accountPoints.getPointFlag;
    }

    public final int getGetPointFlag() {
        return this.getPointFlag;
    }

    public final int getPoints() {
        return this.points;
    }

    public final int getUserId() {
        return this.userId;
    }

    public int hashCode() {
        return (((this.userId * 31) + this.points) * 31) + this.getPointFlag;
    }

    public final void setGetPointFlag(int i) {
        this.getPointFlag = i;
    }

    public final void setPoints(int i) {
        this.points = i;
    }

    public final void setUserId(int i) {
        this.userId = i;
    }

    @OOXIXo
    public String toString() {
        return "AccountPoints(userId=" + this.userId + ", points=" + this.points + ", getPointFlag=" + this.getPointFlag + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ AccountPoints(int i, int i2, int i3, int i4, IIXOooo iIXOooo) {
        this((i4 & 1) != 0 ? 0 : i, (i4 & 2) != 0 ? 0 : i2, (i4 & 4) != 0 ? 0 : i3);
    }

    public AccountPoints(int i, int i2, int i3) {
        this.userId = i;
        this.points = i2;
        this.getPointFlag = i3;
    }
}
