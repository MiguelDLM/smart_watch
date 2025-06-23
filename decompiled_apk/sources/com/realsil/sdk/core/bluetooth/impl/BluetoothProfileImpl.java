package com.realsil.sdk.core.bluetooth.impl;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import androidx.annotation.RequiresPermission;
import com.realsil.sdk.core.a.a;
import com.realsil.sdk.core.bluetooth.utils.BluetoothHelper;
import com.realsil.sdk.core.logger.ZLogger;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.paho.android.service.MqttServiceConstants;

/* loaded from: classes11.dex */
public class BluetoothProfileImpl {
    public static final int A2DP_SINK = 11;
    public static final int AVRCP = 13;
    public static final int AVRCP_CONTROLLER = 12;
    public static final String CLASS_NAME_BLUETOOTH_A2DP = "android.bluetooth.BluetoothA2dp";
    public static final int HEADSET_CLIENT = 16;
    public static final int HEARING_AID = 21;
    public static final int HID_DEVICE = 19;
    public static final int HID_HOST = 4;
    public static final int MAP = 9;
    public static final int MAP_CLIENT = 18;
    public static final int OPP = 20;
    public static final int PAN = 5;
    public static final int PBAP = 6;
    public static final int PBAP_CLIENT = 17;
    public static int PRIORITY_AUTO_CONNECT = 1000;

    public static boolean connectProfile(BluetoothProfile bluetoothProfile, BluetoothDevice bluetoothDevice) {
        if (bluetoothProfile != null && bluetoothDevice != null) {
            try {
                ZLogger.v("connectProfile :" + BluetoothHelper.formatAddress(bluetoothDevice.getAddress(), true));
                Method method = bluetoothProfile.getClass().getMethod(MqttServiceConstants.CONNECT_ACTION, BluetoothDevice.class);
                method.setAccessible(true);
                return ((Boolean) method.invoke(bluetoothProfile, bluetoothDevice)).booleanValue();
            } catch (IllegalAccessException e) {
                StringBuilder a2 = a.a("Could not execute method 'connect' in profile ");
                a2.append(bluetoothProfile.getClass().getName());
                a2.append(", ignoring request.");
                a2.append(e.toString());
                ZLogger.w(a2.toString());
                return false;
            } catch (NoSuchMethodException unused) {
                StringBuilder a3 = a.a("No connect method in the ");
                a3.append(bluetoothProfile.getClass().getName());
                a3.append(" class, ignoring request.");
                ZLogger.w(a3.toString());
            } catch (InvocationTargetException e2) {
                StringBuilder a4 = a.a("Could not execute method 'connect' in profile ");
                a4.append(bluetoothProfile.getClass().getName());
                a4.append(", ignoring request.");
                a4.append(e2.toString());
                ZLogger.w(a4.toString());
                return false;
            }
        }
        return false;
    }

    public static boolean disconnect(BluetoothProfile bluetoothProfile, BluetoothDevice bluetoothDevice) {
        if (bluetoothProfile != null && bluetoothDevice != null) {
            String str = "";
            try {
                str = bluetoothProfile.getClass().getName();
                ZLogger.v(String.format("disconnect : %s : %s", str, BluetoothHelper.formatAddress(bluetoothDevice.getAddress(), true)));
                Method method = bluetoothProfile.getClass().getMethod(MqttServiceConstants.DISCONNECT_ACTION, BluetoothDevice.class);
                method.setAccessible(true);
                return ((Boolean) method.invoke(bluetoothProfile, bluetoothDevice)).booleanValue();
            } catch (IllegalAccessException e) {
                e = e;
                ZLogger.w("Could not execute method 'disconnect' in profile " + str + ", ignoring request." + e.toString());
                return false;
            } catch (NoSuchMethodException unused) {
                ZLogger.w("No disconnect method in the " + str + " class, ignoring request.");
            } catch (InvocationTargetException e2) {
                e = e2;
                ZLogger.w("Could not execute method 'disconnect' in profile " + str + ", ignoring request." + e.toString());
                return false;
            }
        }
        return false;
    }

    public static List<BluetoothDevice> getConnectedDevices(BluetoothProfile bluetoothProfile, String str) {
        ArrayList arrayList = new ArrayList();
        if (bluetoothProfile == null) {
            return arrayList;
        }
        try {
            Method method = bluetoothProfile.getClass().asSubclass(Class.forName(str)).getMethod("getConnectedDevices", null);
            method.setAccessible(true);
            return (List) method.invoke(bluetoothProfile, null);
        } catch (ClassNotFoundException e) {
            ZLogger.w("Could not find clas: " + str + ", ignoring request." + e.toString());
            return arrayList;
        } catch (IllegalAccessException e2) {
            e = e2;
            StringBuilder a2 = a.a("Could not execute method 'connect' in profile CLASS_NAME, ignoring request.");
            a2.append(e.toString());
            ZLogger.w(a2.toString());
            return arrayList;
        } catch (NoSuchMethodException unused) {
            ZLogger.w("No connect method in the CLASS_NAME class, ignoring request.");
            return arrayList;
        } catch (InvocationTargetException e3) {
            e = e3;
            StringBuilder a22 = a.a("Could not execute method 'connect' in profile CLASS_NAME, ignoring request.");
            a22.append(e.toString());
            ZLogger.w(a22.toString());
            return arrayList;
        }
    }

    @RequiresPermission("android.permission.BLUETOOTH")
    @TargetApi(19)
    public static int getConnectionState(BluetoothProfile bluetoothProfile, String str, BluetoothDevice bluetoothDevice) {
        if (bluetoothProfile != null && bluetoothDevice != null) {
            try {
                Method method = bluetoothProfile.getClass().asSubclass(Class.forName(str)).getMethod("getConnectionState", BluetoothDevice.class);
                method.setAccessible(true);
                return ((Integer) method.invoke(bluetoothProfile, bluetoothDevice)).intValue();
            } catch (ClassNotFoundException e) {
                ZLogger.w("Could not find clas: " + str + ", ignoring request." + e.toString());
                return 0;
            } catch (IllegalAccessException e2) {
                e = e2;
                StringBuilder a2 = a.a("Could not execute method 'connect' in profile CLASS_NAME, ignoring request.");
                a2.append(e.toString());
                ZLogger.w(a2.toString());
                return 0;
            } catch (NoSuchMethodException unused) {
                ZLogger.w("No connect method in the CLASS_NAME class, ignoring request.");
            } catch (InvocationTargetException e3) {
                e = e3;
                StringBuilder a22 = a.a("Could not execute method 'connect' in profile CLASS_NAME, ignoring request.");
                a22.append(e.toString());
                ZLogger.w(a22.toString());
                return 0;
            }
        }
        return 0;
    }

    public static String getProfileName(int i) {
        switch (i) {
            case 1:
                return "HEADSET";
            case 2:
                return "A2DP";
            case 3:
            case 14:
            case 15:
            default:
                return "UNKNOWN_PROFILE";
            case 4:
                return "HID_HOST";
            case 5:
                return "PAN";
            case 6:
                return "PBAP";
            case 7:
                return "GATT";
            case 8:
                return "GATT_SERVER";
            case 9:
                return "MAP";
            case 10:
                return "SAP";
            case 11:
                return "A2DP_SINK";
            case 12:
                return "AVRCP_CONTROLLER";
            case 13:
                return "AVRCP";
            case 16:
                return "HEADSET_CLIENT";
            case 17:
                return "PBAP_CLIENT";
            case 18:
                return "MAP_CLIENT";
            case 19:
                return "HID_DEVICE";
            case 20:
                return "OPP";
            case 21:
                return "HEARING_AID";
        }
    }

    public static boolean isConnectMethodSupported(BluetoothProfile bluetoothProfile, String str) {
        if (bluetoothProfile == null) {
            return false;
        }
        try {
            Class<? extends U> asSubclass = bluetoothProfile.getClass().asSubclass(Class.forName(str));
            if (asSubclass == 0) {
                ZLogger.w("no class found: " + str);
                return false;
            }
            if (asSubclass.getMethod(MqttServiceConstants.CONNECT_ACTION, BluetoothDevice.class) != null) {
                return true;
            }
            return false;
        } catch (ClassNotFoundException e) {
            ZLogger.w("Could not find clas: " + str + ", ignoring request." + e.toString());
            return false;
        } catch (NoSuchMethodException unused) {
            ZLogger.w("No connect method in the " + str + " class, ignoring request.");
            return false;
        }
    }

    public static boolean isDisConnectMethodSupported(BluetoothProfile bluetoothProfile, String str) {
        if (bluetoothProfile == null) {
            return false;
        }
        try {
            Class<? extends U> asSubclass = bluetoothProfile.getClass().asSubclass(Class.forName(str));
            if (asSubclass == 0) {
                ZLogger.w("no class found: " + str);
                return false;
            }
            if (asSubclass.getMethod(MqttServiceConstants.DISCONNECT_ACTION, BluetoothDevice.class) != null) {
                return true;
            }
            return false;
        } catch (ClassNotFoundException e) {
            ZLogger.w("Could not find clas: " + str + ", ignoring request." + e.toString());
            return false;
        } catch (NoSuchMethodException unused) {
            ZLogger.w("No disconnect method in the " + str + " class, ignoring request.");
            return false;
        }
    }

    public static boolean setPriority(BluetoothProfile bluetoothProfile, BluetoothDevice bluetoothDevice, int i) {
        if (bluetoothProfile == null) {
            return false;
        }
        try {
            bluetoothProfile.getClass().getMethod("setPriority", BluetoothDevice.class, Integer.TYPE).invoke(bluetoothProfile, bluetoothDevice, Integer.valueOf(i));
            return true;
        } catch (Exception e) {
            ZLogger.w(e.toString());
            return false;
        }
    }

    public static boolean disconnect(BluetoothProfile bluetoothProfile, String str, BluetoothDevice bluetoothDevice) {
        if (bluetoothProfile != null && bluetoothDevice != null) {
            try {
                ZLogger.v(String.format("disconnect : %s : %s", str, BluetoothHelper.formatAddress(bluetoothDevice.getAddress(), true)));
                Method method = bluetoothProfile.getClass().asSubclass(Class.forName(str)).getMethod(MqttServiceConstants.DISCONNECT_ACTION, BluetoothDevice.class);
                method.setAccessible(true);
                return ((Boolean) method.invoke(bluetoothProfile, bluetoothDevice)).booleanValue();
            } catch (ClassNotFoundException e) {
                ZLogger.w("Could not find clas: " + str + ", ignoring request." + e.toString());
            } catch (IllegalAccessException e2) {
                ZLogger.w("Could not execute method 'disconnect' in profile " + str + ", ignoring request." + e2.toString());
            } catch (NoSuchMethodException unused) {
                ZLogger.w("No disconnect method in the " + str + " class, ignoring request.");
            } catch (InvocationTargetException e3) {
                ZLogger.w("Could not execute method 'disconnect' in profile " + str + ", ignoring request." + e3.toString());
            }
        }
        return false;
    }

    public static boolean connectProfile(BluetoothProfile bluetoothProfile, String str, BluetoothDevice bluetoothDevice) {
        if (bluetoothProfile != null && bluetoothDevice != null) {
            try {
                ZLogger.v("connectProfile :" + BluetoothHelper.formatAddress(bluetoothDevice.getAddress(), true));
                Class<? extends U> asSubclass = bluetoothProfile.getClass().asSubclass(Class.forName(str));
                if (asSubclass == 0) {
                    ZLogger.w("no class found: " + str);
                    return false;
                }
                Method method = asSubclass.getMethod(MqttServiceConstants.CONNECT_ACTION, BluetoothDevice.class);
                method.setAccessible(true);
                return ((Boolean) method.invoke(bluetoothProfile, bluetoothDevice)).booleanValue();
            } catch (ClassNotFoundException e) {
                ZLogger.w("Could not find clas: " + str + ", ignoring request." + e.toString());
            } catch (IllegalAccessException e2) {
                ZLogger.w("Could not execute method 'connect' in profile " + str + ", ignoring request." + e2.toString());
            } catch (NoSuchMethodException unused) {
                ZLogger.w("No connect method in the " + str + " class, ignoring request.");
            } catch (InvocationTargetException e3) {
                ZLogger.w("Could not execute method 'connect' in profile " + str + ", ignoring request." + e3.toString());
            }
        }
        return false;
    }
}
