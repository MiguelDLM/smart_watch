package com.szabh.smable3.component;

import OXOo.OOXIXo;
import com.facebook.internal.AnalyticsEvents;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.protocol.HTTP;

/* loaded from: classes13.dex */
public final class PowerSaveModeState {
    public static final int CLOSE = 0;

    @OOXIXo
    public static final PowerSaveModeState INSTANCE = new PowerSaveModeState();
    public static final int OPEN = 1;

    private PowerSaveModeState() {
    }

    @OOXIXo
    public final String getState(int i) {
        if (i != 0) {
            if (i != 1) {
                return AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
            }
            return "Open";
        }
        return HTTP.CONN_CLOSE;
    }
}
