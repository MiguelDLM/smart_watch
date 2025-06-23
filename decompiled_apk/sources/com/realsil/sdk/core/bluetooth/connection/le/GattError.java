package com.realsil.sdk.core.bluetooth.connection.le;

import XXO0.oIX0oI;

/* loaded from: classes11.dex */
public final class GattError {
    public static final int BLE_HCI_INSTANT_PASSED = 40;
    public static final int GATT_CONN_CANCEL = 256;
    public static final int GATT_CONN_FAIL_ESTABLISH = 62;
    public static final int GATT_CONN_L2C_FAILURE = 1;
    public static final int GATT_CONN_LMP_TIMEOUT = 34;
    public static final int GATT_CONN_TERMINATE_LOCAL_HOST = 22;
    public static final int GATT_CONN_TERMINATE_PEER_USER = 19;
    public static final int GATT_CONN_TIMEOUT = 8;
    public static final int GATT_ERROR = 133;

    public static String parse(int i) {
        if (i != 257) {
            switch (i) {
                case 0:
                    return "0x0000-SUCCESS";
                case 1:
                    return "0x0001-GATT_INVALID_HANDLE";
                case 2:
                    return "0x0002-GATT_READ_NOT_PERMIT";
                case 3:
                    return "0x0003-GATT_WRITE_NOT_PERMIT";
                case 4:
                    return "0x0004-GATT_INVALID_PDU";
                case 5:
                    return "0x0005-GATT_INSUF_AUTHENTICATION";
                case 6:
                    return "0x0006-GATT_REQ_NOT_SUPPORTED";
                case 7:
                    return "0x0007-GATT_INVALID_OFFSET";
                case 8:
                    return "0x0008-GATT_INSUF_AUTHORIZATION";
                case 9:
                    return "0x0009-GATT_PREPARE_Q_FULL";
                case 10:
                    return "0x000a-GATT_NOT_FOUND";
                case 11:
                    return "0x000b-GATT_NOT_LONG";
                case 12:
                    return "0x000c-GATT_INSUF_KEY_SIZE";
                case 13:
                    return "0x000d-GATT_INVALID_ATTR_LEN";
                case 14:
                    return "0x000e-GATT_ERR_UNLIKELY";
                case 15:
                    return "0x000f-GATT_INSUF_ENCRYPTION";
                case 16:
                    return "0x0010-GATT_UNSUPPORT_GRP_TYPE";
                case 17:
                    return "0x0011-GATT_INSUF_RESOURCE";
                default:
                    switch (i) {
                        case 128:
                            return "0x0080-GATT_NO_RESOURCES";
                        case 129:
                            return "0x0081-GATT_INTERNAL_ERROR";
                        case 130:
                            return "0x0082-GATT_WRONG_STATE";
                        case 131:
                            return "0x0083-GATT_DB_FULL";
                        case 132:
                            return "0x0084-GATT_BUSY";
                        case 133:
                            return "0x0085-GATT_ERROR";
                        case 134:
                            return "0x0086-GATT_CMD_STARTED";
                        case 135:
                            return "0x0087-GATT_ILLEGAL_PARAMETER";
                        case 136:
                            return "0x0088-GATT_PENDING";
                        case 137:
                            return "0x0089-GATT_AUTH_FAIL";
                        case 138:
                            return "0x008a-GATT_MORE";
                        case 139:
                            return "0x008b-GATT_INVALID_CFG";
                        case 140:
                            return "0x008c-GATT_SERVICE_STARTED";
                        case 141:
                            return "0x008d-GATT_ENCRYPED_NO_MITM";
                        case 142:
                            return "0x008e-GATT_NOT_ENCRYPTED";
                        case 143:
                            return "0x008f-GATT_CONGESTED";
                        default:
                            switch (i) {
                                case 253:
                                    return "0x00FD-GATT_CCC_CFG_ERR";
                                case 254:
                                    return "0x00FE-GATT_PRC_IN_PROGRESS";
                                case 255:
                                    return "0x00FF-GATT_OUT_OF_RANGE";
                                default:
                                    return "UNKNOWN (" + i + oIX0oI.I0Io.f4095I0Io;
                            }
                    }
            }
        }
        return "0x0101-TOO MANY OPEN CONNECTIONS";
    }

    public static String parseConnectionError(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 8) {
                    if (i != 19) {
                        if (i != 22) {
                            if (i != 34) {
                                if (i != 62) {
                                    if (i != 133) {
                                        if (i != 256) {
                                            return "UNKNOWN (" + i + oIX0oI.I0Io.f4095I0Io;
                                        }
                                        return "0x0100-GATT_CONN_CANCEL";
                                    }
                                    return "0x0085-GATT_ERROR";
                                }
                                return "0x3E-GATT_CONN_FAIL_ESTABLISH";
                            }
                            return "0x22-GATT_CONN_LMP_TIMEOUT";
                        }
                        return "0x16-GATT_CONN_TERMINATE_LOCAL_HOST";
                    }
                    return "0x13-GATT_CONN_TERMINATE_PEER_USER";
                }
                return "0x08-GATT_CONN_TIMEOUT";
            }
            return "0x01-GATT_CONN_L2C_FAILURE";
        }
        return "0x00-SUCCESS";
    }
}
