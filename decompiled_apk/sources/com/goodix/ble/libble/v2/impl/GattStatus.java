package com.goodix.ble.libble.v2.impl;

import XXO0.oIX0oI;

/* loaded from: classes9.dex */
public class GattStatus {
    public static String gattDisconnectReasonToString(int i) {
        return i != 0 ? i != 1 ? i != 8 ? i != 19 ? i != 22 ? i != 34 ? i != 62 ? i != 256 ? gattStatusToString(i) : "GATT CONN CANCEL " : "GATT CONN FAIL ESTABLISH" : "GATT CONN LMP TIMEOUT" : "GATT CONN TERMINATE LOCAL HOST" : "GATT CONN TERMINATE PEER USER" : "GATT CONN TIMEOUT" : "GATT CONN L2C FAILURE" : "GATT CONN UNKNOWN";
    }

    public static String gattStatusToString(int i) {
        if (i == 257) {
            return "GATT FAILURE";
        }
        switch (i) {
            case 0:
                return "GATT SUCCESS";
            case 1:
                return "GATT INVALID HANDLE";
            case 2:
                return "GATT READ NOT PERMITTED";
            case 3:
                return "GATT WRITE NOT PERMITTED";
            case 4:
                return "GATT INVALID PDU";
            case 5:
                return "GATT INSUFFICIENT AUTHENTICATION";
            case 6:
                return "GATT REQUEST NOT SUPPORTED";
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
                return "GATT INVALID ATTRIBUTE LENGTH";
            case 14:
                return "GATT ERR UNLIKELY";
            case 15:
                return "GATT INSUFFICIENT ENCRYPTION";
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
                        return "GATT ENCRYPED NO MITM";
                    case 142:
                        return "GATT NOT ENCRYPTED";
                    case 143:
                        return "GATT CONNECTION CONGESTED";
                    case 144:
                        return "GATT DUP REG";
                    case 145:
                        return "GATT ALREADY OPEN";
                    case 146:
                        return "GATT CANCEL";
                    default:
                        switch (i) {
                            case 253:
                                return "GATT CCC CFG ERR";
                            case 254:
                                return "GATT PRC IN PROGRESS";
                            case 255:
                                return "GATT OUT OF RANGE";
                            default:
                                return "UNKNOWN (" + i + oIX0oI.I0Io.f4095I0Io;
                        }
                }
        }
    }
}
