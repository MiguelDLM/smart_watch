package com.realsil.sdk.dfu.c;

import com.iflytek.sparkchain.utils.constants.ErrorCode;

/* loaded from: classes11.dex */
public final class b {
    public static int a(int i) {
        switch (i) {
            case ErrorCode.MSP_ERROR_CONFIG_INITIALIZE /* 10128 */:
                return 0;
            case ErrorCode.MSP_ERROR_CREATE_HANDLE /* 10129 */:
                return 1;
            case ErrorCode.MSP_ERROR_CODING_LIB_NOT_LOAD /* 10130 */:
                return 2;
            case ErrorCode.MSP_ERROR_USER_CANCELLED /* 10131 */:
                return 3;
            case ErrorCode.MSP_ERROR_INVALID_OPERATION /* 10132 */:
                return 4;
            case ErrorCode.MSP_ERROR_MESSAGE_NOT_COMPLETE /* 10133 */:
                return 5;
            case 10134:
                return 6;
            case 10135:
                return 7;
            case ErrorCode.MSP_ERROR_USER_ACTIVE_ABORT /* 10136 */:
                return 8;
            default:
                return 254;
        }
    }

    public static int a(int i, int i2) {
        if (i > i2) {
            return 1;
        }
        return i == i2 ? 0 : -1;
    }
}
