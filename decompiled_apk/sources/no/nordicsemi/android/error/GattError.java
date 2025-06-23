package no.nordicsemi.android.error;

import XXO0.oIX0oI;

/* loaded from: classes6.dex */
public class GattError {
    public static String parse(int i) {
        if (i != 26) {
            if (i != 30) {
                if (i != 34) {
                    if (i != 42) {
                        if (i != 257) {
                            if (i != 58) {
                                if (i != 59) {
                                    switch (i) {
                                        case 1:
                                            return "GATT INVALID HANDLE";
                                        case 2:
                                            return "GATT READ NOT PERMIT";
                                        case 3:
                                            return "GATT WRITE NOT PERMIT";
                                        case 4:
                                            return "GATT INVALID PDU";
                                        case 5:
                                            return "GATT INSUF AUTHENTICATION";
                                        case 6:
                                            return "GATT REQ NOT SUPPORTED";
                                        case 7:
                                            return "GATT INVALID OFFSET";
                                        case 8:
                                            return "GATT INSUF AUTHORIZATION";
                                        case 9:
                                            return "GATT PREPARE Q FULL";
                                        case 10:
                                            return "GATT NOT FOUND";
                                        case 11:
                                            return "GATT NOT LONG";
                                        case 12:
                                            return "GATT INSUF KEY SIZE";
                                        case 13:
                                            return "GATT INVALID ATTR LEN";
                                        case 14:
                                            return "GATT ERR UNLIKELY";
                                        case 15:
                                            return "GATT INSUF ENCRYPTION";
                                        case 16:
                                            return "GATT UNSUPPORT GRP TYPE";
                                        case 17:
                                            return "GATT INSUF RESOURCE";
                                        default:
                                            switch (i) {
                                                case 128:
                                                    return "GATT NO RESOURCES";
                                                case 129:
                                                    return "GATT INTERNAL ERROR";
                                                case 130:
                                                    return "GATT WRONG STATE";
                                                case 131:
                                                    return "GATT DB FULL";
                                                case 132:
                                                    return "GATT BUSY";
                                                case 133:
                                                    return "GATT ERROR";
                                                case 134:
                                                    return "GATT CMD STARTED";
                                                case 135:
                                                    return "GATT ILLEGAL PARAMETER";
                                                case 136:
                                                    return "GATT PENDING";
                                                case 137:
                                                    return "GATT AUTH FAIL";
                                                case 138:
                                                    return "GATT MORE";
                                                case 139:
                                                    return "GATT INVALID CFG";
                                                case 140:
                                                    return "GATT SERVICE STARTED";
                                                case 141:
                                                    return "GATT ENCRYPTED NO MITM";
                                                case 142:
                                                    return "GATT NOT ENCRYPTED";
                                                case 143:
                                                    return "GATT CONGESTED";
                                                default:
                                                    switch (i) {
                                                        case 253:
                                                            return "GATT CCCD CFG ERROR";
                                                        case 254:
                                                            return "GATT PROCEDURE IN PROGRESS";
                                                        case 255:
                                                            return "GATT VALUE OUT OF RANGE";
                                                        default:
                                                            switch (i) {
                                                                case 4096:
                                                                    return "DFU DEVICE DISCONNECTED";
                                                                case 4097:
                                                                    return "DFU FILE NOT FOUND";
                                                                case 4098:
                                                                    return "DFU FILE ERROR";
                                                                case 4099:
                                                                    return "DFU NOT A VALID HEX FILE";
                                                                case 4100:
                                                                    return "DFU IO EXCEPTION";
                                                                case 4101:
                                                                    return "DFU SERVICE DISCOVERY NOT STARTED";
                                                                case 4102:
                                                                    return "DFU CHARACTERISTICS NOT FOUND";
                                                                default:
                                                                    switch (i) {
                                                                        case 4104:
                                                                            return "DFU INVALID RESPONSE";
                                                                        case 4105:
                                                                            return "DFU FILE TYPE NOT SUPPORTED";
                                                                        case 4106:
                                                                            return "BLUETOOTH ADAPTER DISABLED";
                                                                        case 4107:
                                                                        case 4108:
                                                                            return "DFU INIT PACKET REQUIRED";
                                                                        case 4109:
                                                                            return "DFU CRC ERROR";
                                                                        case 4110:
                                                                            return "DFU DEVICE NOT BONDED";
                                                                        default:
                                                                            return "UNKNOWN (" + i + oIX0oI.I0Io.f4095I0Io;
                                                                    }
                                                            }
                                                    }
                                            }
                                    }
                                }
                                return "GATT UNACCEPT CONN INTERVAL";
                            }
                            return "GATT CONTROLLER BUSY";
                        }
                        return "TOO MANY OPEN CONNECTIONS";
                    }
                    return "HCI ERROR DIFF TRANSACTION COLLISION";
                }
                return "GATT CONN LMP TIMEOUT";
            }
            return "HCI ERROR INVALID LMP PARAM";
        }
        return "HCI ERROR UNSUPPORTED REMOTE FEATURE";
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
                                        if (i != 143) {
                                            if (i != 147) {
                                                if (i != 256) {
                                                    if (i != 257) {
                                                        return "UNKNOWN (" + i + oIX0oI.I0Io.f4095I0Io;
                                                    }
                                                    return "GATT FAILURE";
                                                }
                                                return "GATT CONN CANCEL";
                                            }
                                            return "GATT CONN TIMEOUT";
                                        }
                                        return "GATT CONN CONGESTED";
                                    }
                                    return "GATT ERROR";
                                }
                                return "GATT CONN FAIL ESTABLISH";
                            }
                            return "GATT CONN LMP TIMEOUT";
                        }
                        return "GATT CONN TERMINATE LOCAL HOST";
                    }
                    return "GATT CONN TERMINATE PEER USER";
                }
                return "GATT CONN TIMEOUT";
            }
            return "GATT CONN L2C FAILURE";
        }
        return "SUCCESS";
    }

    public static String parseDfuRemoteError(int i) {
        int i2 = i & 3840;
        if (i2 != 256) {
            if (i2 != 512) {
                if (i2 != 1024) {
                    if (i2 != 2048) {
                        return "UNKNOWN (" + i + oIX0oI.I0Io.f4095I0Io;
                    }
                    return SecureDfuError.parseButtonlessError(i);
                }
                return SecureDfuError.parseExtendedError(i);
            }
            return SecureDfuError.parse(i);
        }
        return LegacyDfuError.parse(i);
    }
}
