package com.szabh.smable3.component;

import OXOo.OOXIXo;
import com.facebook.internal.AnalyticsEvents;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpHeaders;

/* loaded from: classes13.dex */
public final class SyncState {
    public static final int COMPLETED = 0;
    public static final int DISCONNECTED = -2;

    @OOXIXo
    public static final SyncState INSTANCE = new SyncState();
    public static final int SYNCING = 1;
    public static final int TIMEOUT = -1;

    private SyncState() {
    }

    @OOXIXo
    public final String getState(int i) {
        if (i != -2) {
            if (i != -1) {
                if (i != 0) {
                    if (i != 1) {
                        return AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
                    }
                    return "Syncing";
                }
                return "completed";
            }
            return HttpHeaders.TIMEOUT;
        }
        return "Disconnected";
    }
}
