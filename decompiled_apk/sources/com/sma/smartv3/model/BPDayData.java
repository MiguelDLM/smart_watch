package com.sma.smartv3.model;

import OXOo.OOXIXo;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class BPDayData {
    private int dbpMax;
    private int dbpMin;
    private int sbpMax;
    private int sbpMin;

    @OOXIXo
    private String status;

    public BPDayData() {
        this(0, 0, 0, 0, null, 31, null);
    }

    public final int getDbpMax() {
        return this.dbpMax;
    }

    public final int getDbpMin() {
        return this.dbpMin;
    }

    public final int getSbpMax() {
        return this.sbpMax;
    }

    public final int getSbpMin() {
        return this.sbpMin;
    }

    @OOXIXo
    public final String getStatus() {
        return this.status;
    }

    public final void setDbpMax(int i) {
        this.dbpMax = i;
    }

    public final void setDbpMin(int i) {
        this.dbpMin = i;
    }

    public final void setSbpMax(int i) {
        this.sbpMax = i;
    }

    public final void setSbpMin(int i) {
        this.sbpMin = i;
    }

    public final void setStatus(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.status = str;
    }

    public BPDayData(int i, int i2, int i3, int i4, @OOXIXo String status) {
        IIX0o.x0xO0oo(status, "status");
        this.dbpMax = i;
        this.dbpMin = i2;
        this.sbpMax = i3;
        this.sbpMin = i4;
        this.status = status;
    }

    public /* synthetic */ BPDayData(int i, int i2, int i3, int i4, String str, int i5, IIXOooo iIXOooo) {
        this((i5 & 1) != 0 ? 0 : i, (i5 & 2) != 0 ? 0 : i2, (i5 & 4) != 0 ? 0 : i3, (i5 & 8) == 0 ? i4 : 0, (i5 & 16) != 0 ? HelpFormatter.DEFAULT_LONG_OPT_PREFIX : str);
    }
}
