package com.szabh.smable3.component;

import OXOo.OOXIXo;
import com.facebook.internal.AnalyticsEvents;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.protocol.HTTP;

/* loaded from: classes13.dex */
public final class ClassicBluetoothState {
    public static final int CLOSE = 0;
    public static final int CLOSE_SUCCESSFULLY = 2;

    @OOXIXo
    public static final ClassicBluetoothState INSTANCE = new ClassicBluetoothState();
    public static final int OPEN = 1;
    public static final int OPEN_SUCCESSFULLY = 3;

    private ClassicBluetoothState() {
    }

    @OOXIXo
    public final String getState(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
                    }
                    return "Open Successfully";
                }
                return "Close Successfully";
            }
            return "Open";
        }
        return HTTP.CONN_CLOSE;
    }
}
