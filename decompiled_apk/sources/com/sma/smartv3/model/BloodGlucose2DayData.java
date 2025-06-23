package com.sma.smartv3.model;

import OXOo.OOXIXo;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class BloodGlucose2DayData {
    private int max;
    private int min;

    @OOXIXo
    private String status;

    public BloodGlucose2DayData() {
        this(0, 0, null, 7, null);
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

    public BloodGlucose2DayData(int i, int i2, @OOXIXo String status) {
        IIX0o.x0xO0oo(status, "status");
        this.max = i;
        this.min = i2;
        this.status = status;
    }

    public /* synthetic */ BloodGlucose2DayData(int i, int i2, String str, int i3, IIXOooo iIXOooo) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2, (i3 & 4) != 0 ? HelpFormatter.DEFAULT_LONG_OPT_PREFIX : str);
    }
}
