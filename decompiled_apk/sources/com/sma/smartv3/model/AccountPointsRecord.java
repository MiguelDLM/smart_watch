package com.sma.smartv3.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.io.Serializable;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class AccountPointsRecord extends JsonFieldContainer implements Serializable {
    private int accountId;

    @OOXIXo
    private String createdAt;
    private int id;

    @OOXIXo
    private String pointsChange;

    @OOXIXo
    private String recordItem;

    public AccountPointsRecord() {
        this(0, 0, null, null, null, 31, null);
    }

    public static /* synthetic */ AccountPointsRecord copy$default(AccountPointsRecord accountPointsRecord, int i, int i2, String str, String str2, String str3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = accountPointsRecord.id;
        }
        if ((i3 & 2) != 0) {
            i2 = accountPointsRecord.accountId;
        }
        int i4 = i2;
        if ((i3 & 4) != 0) {
            str = accountPointsRecord.recordItem;
        }
        String str4 = str;
        if ((i3 & 8) != 0) {
            str2 = accountPointsRecord.pointsChange;
        }
        String str5 = str2;
        if ((i3 & 16) != 0) {
            str3 = accountPointsRecord.createdAt;
        }
        return accountPointsRecord.copy(i, i4, str4, str5, str3);
    }

    public final int component1() {
        return this.id;
    }

    public final int component2() {
        return this.accountId;
    }

    @OOXIXo
    public final String component3() {
        return this.recordItem;
    }

    @OOXIXo
    public final String component4() {
        return this.pointsChange;
    }

    @OOXIXo
    public final String component5() {
        return this.createdAt;
    }

    @OOXIXo
    public final AccountPointsRecord copy(int i, int i2, @OOXIXo String recordItem, @OOXIXo String pointsChange, @OOXIXo String createdAt) {
        IIX0o.x0xO0oo(recordItem, "recordItem");
        IIX0o.x0xO0oo(pointsChange, "pointsChange");
        IIX0o.x0xO0oo(createdAt, "createdAt");
        return new AccountPointsRecord(i, i2, recordItem, pointsChange, createdAt);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AccountPointsRecord)) {
            return false;
        }
        AccountPointsRecord accountPointsRecord = (AccountPointsRecord) obj;
        return this.id == accountPointsRecord.id && this.accountId == accountPointsRecord.accountId && IIX0o.Oxx0IOOO(this.recordItem, accountPointsRecord.recordItem) && IIX0o.Oxx0IOOO(this.pointsChange, accountPointsRecord.pointsChange) && IIX0o.Oxx0IOOO(this.createdAt, accountPointsRecord.createdAt);
    }

    public final int getAccountId() {
        return this.accountId;
    }

    @OOXIXo
    public final String getCreatedAt() {
        return this.createdAt;
    }

    public final int getId() {
        return this.id;
    }

    @OOXIXo
    public final String getPointsChange() {
        return this.pointsChange;
    }

    @OOXIXo
    public final String getRecordItem() {
        return this.recordItem;
    }

    public int hashCode() {
        return (((((((this.id * 31) + this.accountId) * 31) + this.recordItem.hashCode()) * 31) + this.pointsChange.hashCode()) * 31) + this.createdAt.hashCode();
    }

    public final void setAccountId(int i) {
        this.accountId = i;
    }

    public final void setCreatedAt(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.createdAt = str;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final void setPointsChange(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.pointsChange = str;
    }

    public final void setRecordItem(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.recordItem = str;
    }

    @OOXIXo
    public String toString() {
        return "AccountPointsRecord(id=" + this.id + ", accountId=" + this.accountId + ", recordItem=" + this.recordItem + ", pointsChange=" + this.pointsChange + ", createdAt=" + this.createdAt + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ AccountPointsRecord(int i, int i2, String str, String str2, String str3, int i3, IIXOooo iIXOooo) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) == 0 ? i2 : 0, (i3 & 4) != 0 ? "" : str, (i3 & 8) != 0 ? "" : str2, (i3 & 16) != 0 ? "" : str3);
    }

    public AccountPointsRecord(int i, int i2, @OOXIXo String recordItem, @OOXIXo String pointsChange, @OOXIXo String createdAt) {
        IIX0o.x0xO0oo(recordItem, "recordItem");
        IIX0o.x0xO0oo(pointsChange, "pointsChange");
        IIX0o.x0xO0oo(createdAt, "createdAt");
        this.id = i;
        this.accountId = i2;
        this.recordItem = recordItem;
        this.pointsChange = pointsChange;
        this.createdAt = createdAt;
    }
}
