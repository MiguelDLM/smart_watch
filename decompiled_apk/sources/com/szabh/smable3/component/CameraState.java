package com.szabh.smable3.component;

import OXOo.OOXIXo;
import com.facebook.internal.AnalyticsEvents;

/* loaded from: classes13.dex */
public final class CameraState {
    public static final int CAPTURE = 2;
    public static final int ENTER = 1;
    public static final int EXCHANGE = 3;
    public static final int EXIT = 0;

    @OOXIXo
    public static final CameraState INSTANCE = new CameraState();

    private CameraState() {
    }

    @OOXIXo
    public final String getState(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
                    }
                    return "Exchange";
                }
                return "Capture";
            }
            return "Enter";
        }
        return "Exit";
    }
}
