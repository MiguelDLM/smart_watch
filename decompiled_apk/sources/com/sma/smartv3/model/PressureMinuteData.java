package com.sma.smartv3.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;

/* loaded from: classes12.dex */
public final class PressureMinuteData {
    private int num;
    private int total;

    public PressureMinuteData(int i, int i2) {
        this.total = i;
        this.num = i2;
    }

    public static /* synthetic */ PressureMinuteData copy$default(PressureMinuteData pressureMinuteData, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = pressureMinuteData.total;
        }
        if ((i3 & 2) != 0) {
            i2 = pressureMinuteData.num;
        }
        return pressureMinuteData.copy(i, i2);
    }

    public final int component1() {
        return this.total;
    }

    public final int component2() {
        return this.num;
    }

    @OOXIXo
    public final PressureMinuteData copy(int i, int i2) {
        return new PressureMinuteData(i, i2);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PressureMinuteData)) {
            return false;
        }
        PressureMinuteData pressureMinuteData = (PressureMinuteData) obj;
        return this.total == pressureMinuteData.total && this.num == pressureMinuteData.num;
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
        return "PressureMinuteData(total=" + this.total + ", num=" + this.num + HexStringBuilder.COMMENT_END_CHAR;
    }
}
