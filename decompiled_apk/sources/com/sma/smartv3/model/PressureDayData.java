package com.sma.smartv3.model;

import OXOo.OOXIXo;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class PressureDayData {
    private int avg;
    private int max;
    private int min;

    @OOXIXo
    private String status;

    public PressureDayData() {
        this(0, 0, 0, null, 15, null);
    }

    public final int getAvg() {
        return this.avg;
    }

    public final int getMax() {
        return this.max;
    }

    public final int getMin() {
        return this.min;
    }

    @OOXIXo
    public final String getStatus() {
        return this.status;
    }

    public final void setAvg(int i) {
        this.avg = i;
    }

    public final void setMax(int i) {
        this.max = i;
    }

    public final void setMin(int i) {
        this.min = i;
    }

    public final void setStatus(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.status = str;
    }

    public PressureDayData(int i, int i2, int i3, @OOXIXo String status) {
        IIX0o.x0xO0oo(status, "status");
        this.max = i;
        this.min = i2;
        this.avg = i3;
        this.status = status;
    }

    public /* synthetic */ PressureDayData(int i, int i2, int i3, String str, int i4, IIXOooo iIXOooo) {
        this((i4 & 1) != 0 ? 0 : i, (i4 & 2) != 0 ? 0 : i2, (i4 & 4) != 0 ? 0 : i3, (i4 & 8) != 0 ? HelpFormatter.DEFAULT_LONG_OPT_PREFIX : str);
    }
}
