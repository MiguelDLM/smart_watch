package com.sma.smartv3.model;

import OXOo.OOXIXo;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class TemperatureDayData {
    private float avg;
    private float max;
    private float min;

    public TemperatureDayData() {
        this(0.0f, 0.0f, 0.0f, 7, null);
    }

    public final float getAvg() {
        return this.avg;
    }

    public final float getMax() {
        return this.max;
    }

    public final float getMin() {
        return this.min;
    }

    public final void setAvg(float f) {
        this.avg = f;
    }

    public final void setMax(float f) {
        this.max = f;
    }

    public final void setMin(float f) {
        this.min = f;
    }

    @OOXIXo
    public String toString() {
        return "TemperatureDayData(max=" + this.max + ", min=" + this.min + ", avg=" + this.avg + HexStringBuilder.COMMENT_END_CHAR;
    }

    public TemperatureDayData(float f, float f2, float f3) {
        this.max = f;
        this.min = f2;
        this.avg = f3;
    }

    public /* synthetic */ TemperatureDayData(float f, float f2, float f3, int i, IIXOooo iIXOooo) {
        this((i & 1) != 0 ? 0.0f : f, (i & 2) != 0 ? 0.0f : f2, (i & 4) != 0 ? 0.0f : f3);
    }
}
