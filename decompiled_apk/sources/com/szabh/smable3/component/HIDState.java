package com.szabh.smable3.component;

import OXOo.OOXIXo;
import com.facebook.internal.AnalyticsEvents;

/* loaded from: classes13.dex */
public final class HIDState {
    public static final int CONNECTED = 1;
    public static final int DISCONNECTED = 0;

    @OOXIXo
    public static final HIDState INSTANCE = new HIDState();

    private HIDState() {
    }

    @OOXIXo
    public final String getState(int i) {
        if (i != 0) {
            if (i != 1) {
                return AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
            }
            return "Connected";
        }
        return "Disconnected";
    }
}
