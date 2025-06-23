package com.realsil.sdk.core.bluetooth.impl;

import XXO0.oIX0oI;
import android.bluetooth.BluetoothClass;
import com.baidu.navisdk.comapi.mapcontrol.BNMapObserver;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.blankj.utilcode.constant.PermissionConstants;
import com.realsil.sdk.core.logger.ZLogger;
import com.realsil.sdk.dfu.DfuConstants;
import com.realsil.sdk.dfu.image.constants.SubBinId;
import java.util.Locale;

/* loaded from: classes11.dex */
public class BluetoothClassImpl {
    public static final int PROFILE_A2DP = 1;
    public static final int PROFILE_A2DP_SINK = 6;
    public static final int PROFILE_HEADSET = 0;
    public static final int PROFILE_HID = 3;
    public static final int PROFILE_NAP = 5;
    public static final int PROFILE_OPP = 2;
    public static final int PROFILE_PANU = 4;

    /* loaded from: classes11.dex */
    public static class Device {
        public static final int PERIPHERAL_KEYBOARD = 1344;
        public static final int PERIPHERAL_KEYBOARD_POINTING = 1472;
        public static final int PERIPHERAL_NON_KEYBOARD_NON_POINTING = 1280;
        public static final int PERIPHERAL_POINTING = 1408;
    }

    public static boolean doesClassMatch(BluetoothClass bluetoothClass, int i) {
        int deviceClass;
        int deviceClass2;
        int deviceClass3;
        if (i == 1) {
            if (!bluetoothClass.hasService(262144) && (deviceClass3 = bluetoothClass.getDeviceClass()) != 1044 && deviceClass3 != 1048 && deviceClass3 != 1056 && deviceClass3 != 1064) {
                return false;
            }
            return true;
        }
        if (i == 6) {
            if (!bluetoothClass.hasService(524288) && (deviceClass2 = bluetoothClass.getDeviceClass()) != 1060 && deviceClass2 != 1064 && deviceClass2 != 1068) {
                return false;
            }
            return true;
        }
        if (i == 0) {
            if (!bluetoothClass.hasService(262144) && (deviceClass = bluetoothClass.getDeviceClass()) != 1028 && deviceClass != 1032 && deviceClass != 1056) {
                return false;
            }
            return true;
        }
        if (i == 2) {
            if (bluetoothClass.hasService(1048576)) {
                return true;
            }
            switch (bluetoothClass.getDeviceClass()) {
                case 256:
                case 260:
                case 264:
                case 268:
                case 272:
                case 276:
                case 280:
                case 512:
                case 516:
                case 520:
                case DfuConstants.PROGRESS_ACTIVE_IMAGE_AND_RESET /* 524 */:
                case BNMapObserver.EventMapView.EVENT_CLICKED_ROUTE_PAN_ITEM /* 528 */:
                case 532:
                    return true;
                default:
                    return false;
            }
        }
        if (i == 3) {
            if ((bluetoothClass.getDeviceClass() & 1280) != 1280) {
                return false;
            }
            return true;
        }
        if (i != 4 && i != 5) {
            return false;
        }
        if (!bluetoothClass.hasService(131072) && (bluetoothClass.getDeviceClass() & 768) != 768) {
            return false;
        }
        return true;
    }

    public static boolean isAudioDevice(BluetoothClass bluetoothClass) {
        if (bluetoothClass == null) {
            return false;
        }
        ZLogger.v(String.format("getDeviceClass: 0x%04X", Integer.valueOf(bluetoothClass.getDeviceClass())));
        switch (bluetoothClass.getDeviceClass()) {
            default:
                if (!doesClassMatch(bluetoothClass, 0) && !doesClassMatch(bluetoothClass, 1)) {
                    return false;
                }
                break;
            case 1024:
            case 1028:
            case 1032:
            case SubBinId.Bbpro.DSP_UI_PARAMETER_FILE /* 1040 */:
            case 1044:
            case 1048:
            case 1052:
            case 1056:
            case 1060:
            case 1064:
            case 1068:
            case 1072:
            case 1076:
            case ScreenUtil.DEFAULT_WIDTH /* 1080 */:
            case 1084:
            case 1088:
            case 1096:
                return true;
        }
    }

    public static boolean isHidDevice(BluetoothClass bluetoothClass) {
        boolean z;
        if (bluetoothClass == null) {
            return false;
        }
        int deviceClass = bluetoothClass.getDeviceClass();
        if (deviceClass != 1344 && deviceClass != 1408 && deviceClass != 1472) {
            z = false;
        } else {
            z = true;
        }
        ZLogger.v(String.format("getDeviceClass: 0x%04X, isHid=%b", Integer.valueOf(bluetoothClass.getDeviceClass()), Boolean.valueOf(z)));
        return z;
    }

    public static String parseDeviceClass(BluetoothClass bluetoothClass) {
        StringBuilder sb = new StringBuilder();
        Locale locale = Locale.US;
        sb.append(String.format(locale, "major=0x%04X(", Integer.valueOf(bluetoothClass.getMajorDeviceClass())));
        int majorDeviceClass = bluetoothClass.getMajorDeviceClass();
        if (majorDeviceClass != 0) {
            if (majorDeviceClass != 256) {
                if (majorDeviceClass != 512) {
                    if (majorDeviceClass != 768) {
                        if (majorDeviceClass != 1024) {
                            if (majorDeviceClass != 1280) {
                                if (majorDeviceClass != 1536) {
                                    if (majorDeviceClass != 1792) {
                                        if (majorDeviceClass != 2048) {
                                            if (majorDeviceClass != 2304) {
                                                sb.append("UNCATEGORIZED");
                                            } else {
                                                sb.append("HEALTH");
                                            }
                                        } else {
                                            sb.append("TOY");
                                        }
                                    } else {
                                        sb.append("WEARABLE");
                                    }
                                } else {
                                    sb.append("IMAGING");
                                }
                            } else {
                                sb.append("PERIPHERAL");
                            }
                        } else {
                            sb.append("AUDIO_VIDEO");
                        }
                    } else {
                        sb.append("NETWORKING");
                    }
                } else {
                    sb.append(PermissionConstants.PHONE);
                }
            } else {
                sb.append("COMPUTER");
            }
        } else {
            sb.append("MISC");
        }
        sb.append(oIX0oI.I0Io.f4095I0Io);
        sb.append(String.format(locale, "device=0x%04X(", Integer.valueOf(bluetoothClass.getDeviceClass())));
        int deviceClass = bluetoothClass.getDeviceClass();
        if (deviceClass != 260) {
            if (deviceClass != 1344) {
                if (deviceClass != 1408) {
                    if (deviceClass != 1472) {
                        sb.append("UNCATEGORIZED");
                    } else {
                        sb.append("PERIPHERAL_KEYBOARD_POINTING");
                    }
                } else {
                    sb.append("PERIPHERAL_POINTING");
                }
            } else {
                sb.append("PERIPHERAL_KEYBOARD");
            }
        } else {
            sb.append("COMPUTER_DESKTOP");
        }
        sb.append(oIX0oI.I0Io.f4095I0Io);
        return sb.toString();
    }
}
