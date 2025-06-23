package com.realsil.sdk.core.bluetooth.impl;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothDevice;
import android.os.ParcelUuid;
import androidx.annotation.RequiresPermission;
import com.facebook.internal.AnalyticsEvents;
import com.realsil.sdk.core.a.a;
import com.realsil.sdk.core.logger.ZLogger;
import java.lang.reflect.Method;

/* loaded from: classes11.dex */
public class BluetoothDeviceImpl {
    public static final int BATTERY_LEVEL_UNKNOWN = -1;
    public static final int PAIRING_VARIANT_CONSENT = 3;
    public static final int PAIRING_VARIANT_DISPLAY_PASSKEY = 4;
    public static final int PAIRING_VARIANT_DISPLAY_PIN = 5;
    public static final int PAIRING_VARIANT_OOB_CONSENT = 6;
    public static final int PAIRING_VARIANT_PASSKEY = 1;

    public static boolean cancelBondProcess(BluetoothDevice bluetoothDevice) {
        try {
            Method method = bluetoothDevice.getClass().getMethod("cancelBondProcess", null);
            if (method != null) {
                method.setAccessible(true);
                return ((Boolean) method.invoke(bluetoothDevice, null)).booleanValue();
            }
            return false;
        } catch (Exception e) {
            StringBuilder a2 = a.a("An exception occurred while cancelBondProcess : ");
            a2.append(e.getMessage());
            ZLogger.w(a2.toString());
            return false;
        }
    }

    @SuppressLint({"NewApi"})
    public static boolean createBond(BluetoothDevice bluetoothDevice) {
        return bluetoothDevice.createBond();
    }

    public static void dumpSupportedUuids(BluetoothDevice bluetoothDevice) {
        ParcelUuid[] uuids = bluetoothDevice.getUuids();
        if (uuids != null && uuids.length > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("supported features (UUIDs)");
            for (ParcelUuid parcelUuid : uuids) {
                StringBuilder a2 = a.a("\n\t");
                a2.append(parcelUuid.toString());
                sb.append(a2.toString());
            }
            ZLogger.v(sb.toString());
        }
    }

    @RequiresPermission("android.permission.BLUETOOTH")
    public static boolean isConnected(BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice == null) {
            return false;
        }
        try {
            Method declaredMethod = BluetoothDevice.class.getDeclaredMethod("isConnected", null);
            declaredMethod.setAccessible(true);
            return ((Boolean) declaredMethod.invoke(bluetoothDevice, null)).booleanValue();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String pairingVariantToString(int i) {
        switch (i) {
            case 0:
                return "PAIRING_VARIANT_PIN";
            case 1:
                return "PAIRING_VARIANT_PASSKEY";
            case 2:
                return "PAIRING_VARIANT_PASSKEY_CONFIRMATION";
            case 3:
                return "PAIRING_VARIANT_CONSENT";
            case 4:
                return "PAIRING_VARIANT_DISPLAY_PASSKEY";
            case 5:
                return "PAIRING_VARIANT_DISPLAY_PIN";
            case 6:
                return "PAIRING_VARIANT_OOB_CONSENT";
            default:
                return "UNKNOWN";
        }
    }

    public static String parseDeviceType(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    return AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
                }
                return "DUAL(BR/EDR/LE)";
            }
            return "LE";
        }
        return "BR/EDR";
    }

    public static boolean removeBond(BluetoothDevice bluetoothDevice) {
        try {
            Method method = bluetoothDevice.getClass().getMethod("removeBond", null);
            if (method != null) {
                method.setAccessible(true);
                return ((Boolean) method.invoke(bluetoothDevice, null)).booleanValue();
            }
            return false;
        } catch (Exception e) {
            StringBuilder a2 = a.a("An exception occurred while removing bond information: ");
            a2.append(e.getMessage());
            ZLogger.w(a2.toString());
            return false;
        }
    }

    public static boolean createBond(BluetoothDevice bluetoothDevice, int i) {
        if (bluetoothDevice == null) {
            return false;
        }
        try {
            Method method = bluetoothDevice.getClass().getMethod("createBond", Integer.TYPE);
            if (method != null) {
                return ((Boolean) method.invoke(bluetoothDevice, Integer.valueOf(i))).booleanValue();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
