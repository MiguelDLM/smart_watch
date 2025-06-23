package com.sma.smartv3.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;

/* loaded from: classes12.dex */
public final class ECGMinuteData {
    private int num;
    private int total;

    public ECGMinuteData(int i, int i2) {
        this.total = i;
        this.num = i2;
    }

    public static /* synthetic */ ECGMinuteData copy$default(ECGMinuteData eCGMinuteData, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = eCGMinuteData.total;
        }
        if ((i3 & 2) != 0) {
            i2 = eCGMinuteData.num;
        }
        return eCGMinuteData.copy(i, i2);
    }

    public final int component1() {
        return this.total;
    }

    public final int component2() {
        return this.num;
    }

    @OOXIXo
    public final ECGMinuteData copy(int i, int i2) {
        return new ECGMinuteData(i, i2);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ECGMinuteData)) {
            return false;
        }
        ECGMinuteData eCGMinuteData = (ECGMinuteData) obj;
        return this.total == eCGMinuteData.total && this.num == eCGMinuteData.num;
    }

    public final int getNum() {
        return this.num;
    }

    public final int getTotal() {
        return this.total;
    }

    public int hashCode() {
        return (this.total * 31) + this.num;
    }

    public final void setNum(int i) {
        this.num = i;
    }

    public final void setTotal(int i) {
        this.total = i;
    }

    @OOXIXo
    public String toString() {
        return "ECGMinuteData(total=" + this.total + ", num=" + this.num + HexStringBuilder.COMMENT_END_CHAR;
    }
}
