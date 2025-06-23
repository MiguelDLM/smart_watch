package com.jieli.jl_bt_ota.model;

import android.text.TextUtils;
import com.jieli.jl_bt_ota.constant.ErrorCode;
import com.jieli.jl_bt_ota.model.base.BaseError;

/* loaded from: classes10.dex */
public class OTAError {
    public static BaseError buildError(int i) {
        return new BaseError(i, getErrorDesc(i));
    }

    public static String getErrorDesc(int i) {
        if (i != 12295) {
            if (i != 12296) {
                if (i != 12298) {
                    if (i != 12299) {
                        if (i != 0) {
                            if (i != 4097) {
                                if (i != 4099) {
                                    if (i != 4114) {
                                        if (i != 8194) {
                                            if (i != 20481) {
                                                switch (i) {
                                                    case 12290:
                                                        return "Failed to send data.";
                                                    case 12291:
                                                        return "System is busy.";
                                                    case 12292:
                                                        return "Abnormal data format.";
                                                    case 12293:
                                                        return "Failed to parse data.";
                                                    default:
                                                        switch (i) {
                                                            case 16385:
                                                                return "Update failed.";
                                                            case 16386:
                                                                return "Device is in low charge.";
                                                            case 16387:
                                                                return "Corrupted upgrade file.";
                                                            case 16388:
                                                                return "Data offset error.";
                                                            case 16389:
                                                                return "Data verification failure.";
                                                            case 16390:
                                                                return "Key of the upgrade file does not match.";
                                                            case ErrorCode.SUB_ERR_UPGRADE_TYPE_NOT_MATCH /* 16391 */:
                                                                return "The type of the upgrade file is incorrect.";
                                                            case ErrorCode.SUB_ERR_OTA_IN_HANDLE /* 16392 */:
                                                                return "OTA is in progress.";
                                                            case ErrorCode.SUB_ERR_UPGRADE_DATA_LEN /* 16393 */:
                                                                return "Data length error.";
                                                            case ErrorCode.SUB_ERR_UPGRADE_FLASH_READ /* 16394 */:
                                                                return "Flash IO exception.";
                                                            case ErrorCode.SUB_ERR_UPGRADE_CMD_TIMEOUT /* 16395 */:
                                                                return "Command processing timeout.";
                                                            case ErrorCode.SUB_ERR_UPGRADE_FILE_VERSION_SAME /* 16396 */:
                                                                return "File version is the same as the device version.";
                                                            case ErrorCode.SUB_ERR_TWS_NOT_CONNECT /* 16397 */:
                                                                return "The TWS is not connected.";
                                                            case ErrorCode.SUB_ERR_HEADSET_NOT_IN_CHARGING_BIN /* 16398 */:
                                                                return "The headphones are not in the charging bin.";
                                                            case ErrorCode.SUB_ERR_UPGRADE_SAME_FILE /* 16399 */:
                                                                return "Same upgrade file.";
                                                            case ErrorCode.SUB_ERR_UPGRADE_UNKNOWN /* 16400 */:
                                                                return "Unknown error code.";
                                                            case ErrorCode.SUB_ERR_RECONNECT_TIMEOUT /* 16401 */:
                                                                return "Reconnecting to the device timed out.";
                                                            case ErrorCode.SUB_ERR_RECONNECT_FAILED /* 16402 */:
                                                                return "Failed to reconnect the device.";
                                                            case ErrorCode.SUB_ERR_OTA_IN_PROGRESS /* 16403 */:
                                                                return "Device is being upgraded.";
                                                            case ErrorCode.SUB_ERR_DEVICE_IN_DOUBLE_CONNECTION /* 16404 */:
                                                                return "Device is in device dual mode.";
                                                            default:
                                                                switch (i) {
                                                                    case ErrorCode.SUB_ERR_FILE_NOT_FOUND /* 20484 */:
                                                                        return "Not found file.";
                                                                    case ErrorCode.SUB_ERR_DATA_NOT_FOUND /* 20485 */:
                                                                        return "No upgrade data found.";
                                                                    case ErrorCode.SUB_ERR_IO_EXCEPTION /* 20486 */:
                                                                        return "I/O exception.";
                                                                    default:
                                                                        return "Unknown Error";
                                                                }
                                                        }
                                                }
                                            }
                                            return "Device authentication fails.";
                                        }
                                        return "Searching for a Device Exception.";
                                    }
                                    return "Bluetooth device is disconnected.";
                                }
                                return "Bluetooth is close.";
                            }
                            return "Parameter error.";
                        }
                        return "Success.";
                    }
                    return "Waiting command timeout.";
                }
                return "Device returned an error result.";
            }
            return "Device returned the failed result.";
        }
        return "Command waiting for the device to reply timed out.";
    }

    public static BaseError buildError(int i, String str) {
        return TextUtils.isEmpty(str) ? buildError(i) : buildError(i, 0, str);
    }

    public static BaseError buildError(int i, int i2, String str) {
        return new BaseError(i, new ErrorMsg(i, getErrorDesc(i), i2, str).toString());
    }
}
