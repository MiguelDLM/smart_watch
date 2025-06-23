package com.sma.smartv3.network;

import OXOo.OOXIXo;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class BGEMeasurementById {

    @OOXIXo
    public static final BGEMeasurementById INSTANCE = new BGEMeasurementById();

    @OOXIXo
    public static final String URL = "/glicemia/measurement";

    private BGEMeasurementById() {
    }

    @OOXIXo
    public final String getURL(@OOXIXo String measurementId) {
        IIX0o.x0xO0oo(measurementId, "measurementId");
        return "/glicemia/measurement/" + measurementId;
    }
}
