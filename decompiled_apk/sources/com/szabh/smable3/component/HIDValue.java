package com.szabh.smable3.component;

import OXOo.OOXIXo;
import com.facebook.internal.AnalyticsEvents;

/* loaded from: classes13.dex */
public final class HIDValue {
    public static final int HOME = 5;

    @OOXIXo
    public static final HIDValue INSTANCE = new HIDValue();
    public static final int NEXT_TRACK = 0;
    public static final int PLAY_OR_PAUSE = 2;
    public static final int PREVIOUS_TRACK = 1;
    public static final int VOLUME_DEC = 4;
    public static final int VOLUME_INC = 3;

    private HIDValue() {
    }

    @OOXIXo
    public final String getValue(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                return AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
                            }
                            return "HOME";
                        }
                        return "VOLUME_DEC";
                    }
                    return "VOLUME_INC";
                }
                return "PLAY_OR_PAUSE";
            }
            return "PREVIOUS_TRACK";
        }
        return "NEXT_TRACK";
    }
}
