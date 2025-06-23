package com.realsil.sdk.bbpro.core;

import com.facebook.internal.AnalyticsEvents;
import java.util.Locale;

/* loaded from: classes11.dex */
public class BeeError {
    public static final int ERROR = 1;
    public static final int ERR_CMD_NOT_SUPPORTED = 49;
    public static final int ERR_DEVICE_CONNECT_FAILED = 33;
    public static final int ERR_DEVICE_DISCONNECTED = 32;
    public static final int ERR_OPERATION_FAILED = 17;
    public static final int ERR_PARAMETER_INVALID = 48;
    public static final int ERR_SERVICE_NOT_INITIALIZED = 16;
    public static final int ERR_TRANSPORT_RETRAINS_EXCEED_MAX_TIMES = 64;
    public static final int SUCCESS = 0;
    public int code;
    public String message;

    public BeeError(int i) {
        this.code = i;
        this.message = parseError(i);
    }

    public static String parseError(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 16) {
                    if (i != 17) {
                        if (i != 32) {
                            if (i != 33) {
                                if (i != 48) {
                                    if (i != 49) {
                                        if (i != 64) {
                                            return AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
                                        }
                                        return "retrans exceed max times";
                                    }
                                    return "CMD_NOT_SUPPORTED";
                                }
                                return "Parameter invalid";
                            }
                            return "Connect device failed";
                        }
                        return "Device disconnected";
                    }
                    return "operation failed";
                }
                return "Service not initialized";
            }
            return "Error";
        }
        return "Success";
    }

    public String toString() {
        return String.format(Locale.US, "%d--%s", Integer.valueOf(this.code), this.message);
    }

    public BeeError(int i, String str) {
        this.code = i;
        this.message = str;
    }
}
