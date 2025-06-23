package com.sma.smartv3.network;

import OXOo.OOXIXo;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class BGEMeasurementByDate {

    @OOXIXo
    public static final BGEMeasurementByDate INSTANCE = new BGEMeasurementByDate();

    @OOXIXo
    public static final String URL = "/glicemia/measurement";

    private BGEMeasurementByDate() {
    }

    @OOXIXo
    public final String getURL(@OOXIXo String startDate, @OOXIXo String endDate) {
        IIX0o.x0xO0oo(startDate, "startDate");
        IIX0o.x0xO0oo(endDate, "endDate");
        return "/glicemia/measurement?startDate=" + startDate + "&endDate=" + endDate;
    }
}
