package com.realsil.sdk.dfu;

import XXO0.oIX0oI;

/* loaded from: classes11.dex */
public class DfuConstants {
    public static final int AES_ENCRYPTION_SIZE = 16;
    public static final int AES_SECRET_KEY_LENGTH = 32;
    public static final int BANK_INFO_0 = 0;
    public static final int BANK_INFO_1 = 1;
    public static final byte BANK_INFO_NOT_SUPPORTED = 15;
    public static final byte DFU_RESPONSE_BUFFER_CHECK_LENGTH_ERROR = 6;
    public static final byte DFU_RESPONSE_CRC_ERROR = 5;
    public static final byte DFU_RESPONSE_DATA_SIZE_EXCEEDS_LIMIT = 4;
    public static final byte DFU_RESPONSE_FLASH_ERASE_ERROR = 8;
    public static final byte DFU_RESPONSE_FLASH_WRITE_ERROR = 7;
    public static final byte DFU_RESPONSE_INVALID_PARAM = 2;
    public static final byte DFU_RESPONSE_NOT_SUPPORTED = -2;
    public static final byte DFU_RESPONSE_OPERATION_FAILED = 3;
    public static final byte DFU_RESPONSE_SUCCESS = 1;
    public static final int DFU_UPLOAD_IMAGE_TIMEOUT = 60000;
    public static final int IC_BB2 = 11;
    public static final int IC_BBLITE = 8;
    public static final int IC_BBLITE_ANC = 6;
    public static final int IC_BBPRO = 4;
    public static final int IC_BBPRO2 = 7;
    public static final int IC_BBPRO3 = 10;
    public static final int IC_BEE1 = 3;
    public static final int IC_BEE2 = 5;
    public static final int IC_BEE3 = 12;
    public static final int IC_SBEE2 = 9;
    public static final int KB = 1024;
    public static final int MANUFACTURER_ID_REALTEK = 93;
    public static final int MAX_BUFFER_CHECK_MTU_SIZE = 256;
    public static final int MAX_BUFFER_CHECK_PACKET_SIZE = 16;
    public static final int MAX_CALLBACK_LOCK_WAIT_TIME = 15000;
    public static final int MAX_CONNECTION_LOCK_TIMEOUT = 32000;
    public static final int MAX_CONNECTION_RETRY_TIMES_FOR_FULL_FUNCTION = 2;
    public static final int MB = 1048576;
    public static final int OTA_MODE_AUTOMATIC = 255;
    public static final int OTA_MODE_NORMAL_FUNCTION = 0;
    public static final int OTA_MODE_SILENT_DUALBANK_FORCE_COPY = 20;
    public static final int OTA_MODE_SILENT_DUALBANK_FORCE_COPY_DATA_IMAGE = 20;
    public static final int OTA_MODE_SILENT_DUALBANK_FORCE_TEMP = 19;
    public static final int OTA_MODE_SILENT_EXTEND_FLASH = 17;
    public static final int OTA_MODE_SILENT_FUNCTION = 16;
    public static final int OTA_MODE_SILENT_NO_TEMP = 18;
    public static final int OTA_MODE_SILENT_RWS = 21;
    public static final int PROCESS_STATE_BUSY_MASK = 512;
    public static final int PROCESS_STATE_IDLE_MASK = 256;
    public static final int PROGRESS_ABORTED = 259;
    public static final int PROGRESS_ABORT_PROCESSING = 525;
    public static final int PROGRESS_ACTIVE_IMAGE_AND_RESET = 524;
    public static final int PROGRESS_COMPLETED = 261;
    public static final int PROGRESS_CONNECT_OTA_REMOTE = 520;
    public static final int PROGRESS_CONNECT_REMOTE = 516;
    public static final int PROGRESS_DOWNLOAD_FIRMWARE = 526;
    public static final int PROGRESS_HAND_OVER_PROCESSING = 522;
    public static final int PROGRESS_IMAGE_ACTIVE_SUCCESS = 258;
    public static final int PROGRESS_INITIALIZE = 513;
    public static final int PROGRESS_ORIGIN = 257;
    public static final int PROGRESS_PENDING_ACTIVE_IMAGE = 523;
    public static final int PROGRESS_PREPARE_OTA_ENVIRONMENT = 517;
    public static final int PROGRESS_PROCESSING_ERROR = 260;
    public static final int PROGRESS_REMOTE_ENTER_OTA = 518;
    public static final int PROGRESS_SCAN_OTA_REMOTE = 519;
    public static final int PROGRESS_SCAN_REMOTE = 515;
    public static final int PROGRESS_SCAN_SECONDARY_BUD = 527;
    public static final int PROGRESS_STARTED = 514;
    public static final int PROGRESS_START_DFU_PROCESS = 521;
    public static final long SCAN_PERIOD = 30000;
    public static final int SPEED_LEVEL_AUTOMATIC = 0;
    public static final int SPEED_LEVEL_SLOW = 1;
    public static final int SPEED_LEVEL_SLOW_X2 = 2;
    public static final int SPEED_LEVEL_SLOW_X3 = 3;
    public static final int SPEED_LEVEL_SLOW_X4 = 4;
    public static final int SPEED_LEVEL_SLOW_X5 = 5;
    public static final int SPEED_LEVEL_SLOW_X6 = 6;
    public static final int STATE_CLOSED = 1280;
    public static final int STATE_CONNECTED = 512;
    public static final int STATE_CONNECTED_AND_READY = 515;
    public static final int STATE_CONNECTING = 256;
    public static final int STATE_DISCONNECTED = 0;
    public static final int STATE_DISCONNECTING = 1024;
    public static final int STATE_DISCOVER_SERVICE = 513;
    public static final int STATE_SET_PREFERRED_PHY = 514;

    public static String parseAppBankInfo(int i) {
        if (i != 0) {
            if (i != 1) {
                return "Not Supported";
            }
            return "Bank 1";
        }
        return "Bank 0";
    }

    public static String parseConnectionState(int i) {
        if (i != 0) {
            if (i != 256) {
                if (i != 1024) {
                    if (i != 1280) {
                        switch (i) {
                            case 512:
                                return "STATE_CONNECTED";
                            case 513:
                                return "STATE_DISCOVER_SERVICE";
                            case 514:
                                return "SET_PREFERRED_PHY";
                            case 515:
                                return "STATE_CONNECTED_AND_READY";
                            default:
                                return "Unknown: " + i;
                        }
                    }
                    return "STATE_CLOSED";
                }
                return "STATE_DISCONNECTING";
            }
            return "STATE_CONNECTING";
        }
        return "STATE_DISCONNECTED";
    }

    public static String parseDfuStatus(int i) {
        switch (i) {
            case 1:
                return "0x01-SUCCESS";
            case 2:
                return "0x02-INVALID_PARAM";
            case 3:
                return "0x03-OPERATION_FAILED";
            case 4:
                return "0x04-DATA_SIZE_EXCEEDS_LIMIT";
            case 5:
                return "0x05-CRC_ERROR";
            case 6:
                return "0x06-BUFFER_CHECK_LENGTH_ERROR";
            case 7:
                return "0x07-FLASH_WRITE_ERROR";
            case 8:
                return "0x08-FLASH_ERASE_ERROR";
            default:
                return String.format("Unknown error (0x%02X)", Integer.valueOf(i));
        }
    }

    public static String parseOtaMode(int i) {
        if (i != 0) {
            switch (i) {
                case 16:
                    return "SILENT_FUNCTION";
                case 17:
                    return "SILENT_EXTEND_FLASH";
                case 18:
                    return "SILENT_NO_TEMP";
                case 19:
                    return "SILENT_DUALBANK_FORCE_TEMP";
                case 20:
                    return "SILENT_DUALBANK_FORCE_COPY_DATA_IMAGE";
                case 21:
                    return "SILENT_RWS";
                default:
                    return "Unknown (" + i + oIX0oI.I0Io.f4095I0Io;
            }
        }
        return "NORMAL_FUNCTION";
    }

    public static String parseOtaState(int i) {
        switch (i) {
            case 257:
                return "PROGRESS_ORIGIN";
            case 258:
                return "PROGRESS_IMAGE_ACTIVE_SUCCESS";
            case 259:
                return "PROGRESS_ABORTED";
            case 260:
                return "PROGRESS_PROCESSING_ERROR";
            case 261:
                return "PROGRESS_COMPLETED";
            default:
                switch (i) {
                    case 513:
                        return "PROGRESS_INITIALIZE";
                    case 514:
                        return "PROGRESS_STARTED";
                    case 515:
                        return "PROGRESS_SCAN_REMOTE";
                    case 516:
                        return "PROGRESS_CONNECT_REMOTE";
                    case 517:
                        return "PROGRESS_PREPARE_OTA_ENVIRONMENT";
                    case 518:
                        return "PROGRESS_REMOTE_ENTER_OTA";
                    case 519:
                        return "PROGRESS_SCAN_OTA_REMOTE";
                    case 520:
                        return "PROGRESS_CONNECT_OTA_REMOTE";
                    case 521:
                        return "PROGRESS_START_DFU_PROCESS";
                    case PROGRESS_HAND_OVER_PROCESSING /* 522 */:
                        return "PROGRESS_HAND_OVER_PROCESSING";
                    case 523:
                        return "PROGRESS_PENDING_ACTIVE_IMAGE";
                    case PROGRESS_ACTIVE_IMAGE_AND_RESET /* 524 */:
                        return "PROGRESS_ACTIVE_IMAGE_AND_RESET";
                    case 525:
                        return "PROGRESS_ABORT_PROCESSING";
                    case 526:
                        return "PROGRESS_DOWNLOAD_FIRMWARE";
                    case 527:
                        return "PROGRESS_SCAN_SECONDARY_BUD";
                    default:
                        return String.format("Unknown: 0x%04X", Integer.valueOf(i));
                }
        }
    }

    public static String parsePatchBankInfo(int i) {
        if (i != 0) {
            if (i != 1) {
                return "Not Supported";
            }
            return "Bank 1";
        }
        return "Bank 0";
    }
}
