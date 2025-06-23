package com.szabh.smable3.component;

import OXOo.OOXIXo;
import com.facebook.internal.AnalyticsEvents;

/* loaded from: classes13.dex */
public final class WorkoutState {
    public static final int END = 4;

    @OOXIXo
    public static final WorkoutState INSTANCE = new WorkoutState();
    public static final int ONGOING = 2;
    public static final int PAUSE = 3;
    public static final int RESUME = 5;
    public static final int START = 1;

    private WorkoutState() {
    }

    @OOXIXo
    public final String getState(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        if (i != 5) {
                            return AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
                        }
                        return "Resume";
                    }
                    return "End";
                }
                return "Pause";
            }
            return "Ongoing";
        }
        return "Start";
    }
}
