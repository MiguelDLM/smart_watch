package com.jieli.jl_rcsp.constant;

import com.jieli.jl_rcsp.model.base.BaseError;
import com.jieli.jl_rcsp.model.base.CmdError;

/* loaded from: classes.dex */
public class RcspErrorCode {
    public static final int ERR_AUTH_DEVICE = 8195;
    public static final int ERR_CANCEL_OP = 4098;
    public static final int ERR_CMD_SEND = 12288;
    public static final int ERR_DATA_LOAD_COMPLETE = 16386;
    public static final int ERR_DEVICE_NOT_MATCH = 8193;
    public static final int ERR_DIR_TOO_DEEP = 16388;
    public static final int ERR_FILE_BROWSING = 16385;
    public static final int ERR_FILE_NOT_IN_STORAGE = 16390;
    public static final int ERR_INVALID_PARAMETER = 4097;
    public static final int ERR_IO_EXCEPTION = 16389;
    public static final int ERR_MISSING_FILE_DATA = 16387;
    public static final int ERR_NONE = 0;
    public static final int ERR_OPERATION_TIMEOUT = 4099;
    public static final int ERR_PARSE_DATA = 12289;
    public static final int ERR_REMOTE_NOT_CONNECT = 8192;
    public static final int ERR_RESPONSE_BAD_RESULT = 12293;
    public static final int ERR_RESPONSE_BAD_STATUS = 12292;
    public static final int ERR_RESPONSE_TIMEOUT = 12290;
    public static final int ERR_STORAGE_OFFLINE = 16384;
    public static final int ERR_SYSTEM_BUSY = 12291;
    public static final int ERR_USE_SYSTEM_API = 8194;

    public static BaseError buildJsonError(int i, int i2, int i3, String str) {
        CmdError cmdError = new CmdError(i, i2, i3);
        cmdError.setDesc(getErrorDesc(i2));
        cmdError.setSubDesc(str);
        return new BaseError(i2, cmdError.toString());
    }

    public static String getErrorDesc(int i) {
        if (i != 0) {
            switch (i) {
                case 4097:
                    return "Invalid Parameter.";
                case 4098:
                    return "Cancel Operation.";
                case 4099:
                    return "Operation timeout.";
                default:
                    switch (i) {
                        case 8192:
                            return "The remote device is not connected.";
                        case 8193:
                            return "The device is not the same as the device in use.";
                        case 8194:
                            return "Failed to use system reflection function.";
                        case 8195:
                            return "Failed to auth device.";
                        default:
                            switch (i) {
                                case 12288:
                                    return "Command sending failed.";
                                case 12289:
                                    return "Failed to parse RCSP data.";
                                case 12290:
                                    return "Waiting for a reply packet timed out.";
                                case 12291:
                                    return "System is busy.";
                                case 12292:
                                    return "Device returns a failed state.";
                                case 12293:
                                    return "Device returns a failure result.";
                                default:
                                    switch (i) {
                                        case 16384:
                                            return "Storage offline.";
                                        case 16385:
                                            return "File browsing.";
                                        case 16386:
                                            return "File data is loaded.";
                                        case 16387:
                                            return "Missing file data.";
                                        case 16388:
                                            return "Directory hierarchy is too deep.";
                                        case 16389:
                                            return "IO Exception.";
                                        case 16390:
                                            return "File does not match storage";
                                        default:
                                            return "Unknown Code : " + i;
                                    }
                            }
                    }
            }
        }
        return "Success";
    }
}
