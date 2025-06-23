package com.sma.smartv3.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.sma.smartv3.db.entity.AIRecords;
import java.io.Serializable;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class AIRecordsViewData implements Serializable {

    @oOoXoXO
    private AIRecords first;

    @oOoXoXO
    private AIRecords last;

    /* JADX WARN: Multi-variable type inference failed */
    public AIRecordsViewData() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ AIRecordsViewData copy$default(AIRecordsViewData aIRecordsViewData, AIRecords aIRecords, AIRecords aIRecords2, int i, Object obj) {
        if ((i & 1) != 0) {
            aIRecords = aIRecordsViewData.first;
        }
        if ((i & 2) != 0) {
            aIRecords2 = aIRecordsViewData.last;
        }
        return aIRecordsViewData.copy(aIRecords, aIRecords2);
    }

    @oOoXoXO
    public final AIRecords component1() {
        return this.first;
    }

    @oOoXoXO
    public final AIRecords component2() {
        return this.last;
    }

    @OOXIXo
    public final AIRecordsViewData copy(@oOoXoXO AIRecords aIRecords, @oOoXoXO AIRecords aIRecords2) {
        return new AIRecordsViewData(aIRecords, aIRecords2);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AIRecordsViewData)) {
            return false;
        }
        AIRecordsViewData aIRecordsViewData = (AIRecordsViewData) obj;
        return IIX0o.Oxx0IOOO(this.first, aIRecordsViewData.first) && IIX0o.Oxx0IOOO(this.last, aIRecordsViewData.last);
    }

    @oOoXoXO
    public final AIRecords getFirst() {
        return this.first;
    }

    @oOoXoXO
    public final AIRecords getLast() {
        return this.last;
    }

    public int hashCode() {
        AIRecords aIRecords = this.first;
        int hashCode = (aIRecords == null ? 0 : aIRecords.hashCode()) * 31;
        AIRecords aIRecords2 = this.last;
        return hashCode + (aIRecords2 != null ? aIRecords2.hashCode() : 0);
    }

    public final void setFirst(@oOoXoXO AIRecords aIRecords) {
        this.first = aIRecords;
    }

    public final void setLast(@oOoXoXO AIRecords aIRecords) {
        this.last = aIRecords;
    }

    @OOXIXo
    public String toString() {
        return "AIRecordsViewData(first=" + this.first + ", last=" + this.last + HexStringBuilder.COMMENT_END_CHAR;
    }

    public AIRecordsViewData(@oOoXoXO AIRecords aIRecords, @oOoXoXO AIRecords aIRecords2) {
        this.first = aIRecords;
        this.last = aIRecords2;
    }

    public /* synthetic */ AIRecordsViewData(AIRecords aIRecords, AIRecords aIRecords2, int i, IIXOooo iIXOooo) {
        this((i & 1) != 0 ? null : aIRecords, (i & 2) != 0 ? null : aIRecords2);
    }
}
