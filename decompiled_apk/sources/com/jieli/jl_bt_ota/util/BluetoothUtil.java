package com.jieli.jl_bt_ota.util;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothA2dp;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHeadset;
import android.bluetooth.BluetoothProfile;
import android.content.Context;
import android.os.ParcelUuid;
import android.text.TextUtils;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.eclipse.paho.android.service.MqttServiceConstants;

/* loaded from: classes10.dex */
public class BluetoothUtil {

    /* renamed from: a, reason: collision with root package name */
    private static final String f17808a = "BluetoothUtil";
    private static final char[] b = "0123456789ABCDEF".toCharArray();

    public static byte[] addressCovertToByteArray(String str) {
        if (TextUtils.isEmpty(str) || !str.contains(":")) {
            return null;
        }
        String replace = str.replace(":", "");
        int length = replace.length() / 2;
        byte[] bArr = new byte[length];
        if (length != 6) {
            return null;
        }
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            int i3 = i2 + 2;
            if (i3 <= replace.length()) {
                try {
                    bArr[i] = (byte) Integer.valueOf(replace.substring(i2, i3), 16).intValue();
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
        return bArr;
    }

    @SuppressLint({"MissingPermission"})
    public static boolean connectDeviceA2dp(Context context, BluetoothA2dp bluetoothA2dp, BluetoothDevice bluetoothDevice) {
        if (bluetoothA2dp == null || bluetoothDevice == null || !CommonUtil.checkHasConnectPermission(context)) {
            return false;
        }
        try {
            Object invoke = bluetoothA2dp.getClass().getMethod(MqttServiceConstants.CONNECT_ACTION, BluetoothDevice.class).invoke(bluetoothA2dp, bluetoothDevice);
            if (!(invoke instanceof Boolean)) {
                return false;
            }
            return ((Boolean) invoke).booleanValue();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @SuppressLint({"MissingPermission"})
    public static boolean connectDeviceHfp(Context context, BluetoothHeadset bluetoothHeadset, BluetoothDevice bluetoothDevice) {
        if (bluetoothHeadset == null || bluetoothDevice == null || !CommonUtil.checkHasConnectPermission(context)) {
            return false;
        }
        try {
            Method method = bluetoothHeadset.getClass().getMethod(MqttServiceConstants.CONNECT_ACTION, BluetoothDevice.class);
            method.setAccessible(true);
            Object invoke = method.invoke(bluetoothHeadset, bluetoothDevice);
            if (!(invoke instanceof Boolean)) {
                return false;
            }
            return ((Boolean) invoke).booleanValue();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @SuppressLint({"MissingPermission"})
    public static boolean createBond(Context context, BluetoothDevice bluetoothDevice, int i) {
        if (!CommonUtil.checkHasConnectPermission(context)) {
            return false;
        }
        try {
            Method declaredMethod = BluetoothDevice.class.getDeclaredMethod("createBond", Integer.TYPE);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(bluetoothDevice, Integer.valueOf(i));
            if (invoke instanceof Boolean) {
                return ((Boolean) invoke).booleanValue();
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean deviceEquals(BluetoothDevice bluetoothDevice, BluetoothDevice bluetoothDevice2) {
        if (bluetoothDevice != null && bluetoothDevice2 != null && bluetoothDevice.getAddress().equals(bluetoothDevice2.getAddress())) {
            return true;
        }
        return false;
    }

    public static boolean deviceHasProfile(BluetoothDevice bluetoothDevice, UUID uuid) {
        return deviceHasProfile(CommonUtil.getMainContext(), bluetoothDevice, uuid);
    }

    @SuppressLint({"MissingPermission"})
    public static boolean disconnectDeviceA2dp(Context context, BluetoothA2dp bluetoothA2dp, BluetoothDevice bluetoothDevice) {
        if (bluetoothA2dp == null || bluetoothDevice == null || !CommonUtil.checkHasConnectPermission(context)) {
            return false;
        }
        try {
            Method method = bluetoothA2dp.getClass().getMethod(MqttServiceConstants.DISCONNECT_ACTION, BluetoothDevice.class);
            method.setAccessible(true);
            Object invoke = method.invoke(bluetoothA2dp, bluetoothDevice);
            if (!(invoke instanceof Boolean)) {
                return false;
            }
            return ((Boolean) invoke).booleanValue();
        } catch (Exception e) {
            JL_Log.e(f17808a, "-disconnectDeviceA2dp- have an exception : " + e);
            e.printStackTrace();
            return false;
        }
    }

    @SuppressLint({"MissingPermission"})
    public static boolean disconnectDeviceHfp(Context context, BluetoothHeadset bluetoothHeadset, BluetoothDevice bluetoothDevice) {
        if (bluetoothHeadset == null || bluetoothDevice == null || !CommonUtil.checkHasConnectPermission(context)) {
            return false;
        }
        try {
            Method method = bluetoothHeadset.getClass().getMethod(MqttServiceConstants.DISCONNECT_ACTION, BluetoothDevice.class);
            method.setAccessible(true);
            Object invoke = method.invoke(bluetoothHeadset, bluetoothDevice);
            if (!(invoke instanceof Boolean)) {
                return false;
            }
            return ((Boolean) invoke).booleanValue();
        } catch (Exception e) {
            JL_Log.e(f17808a, "-disconnectFromHfp- have an exception : " + e);
            e.printStackTrace();
            return false;
        }
    }

    @SuppressLint({"DiscouragedPrivateApi", "MissingPermission"})
    public static int getBtAdapterConnectionState(Context context, BluetoothAdapter bluetoothAdapter) {
        if (!CommonUtil.checkHasConnectPermission(context) || bluetoothAdapter == null) {
            return -1;
        }
        try {
            Method declaredMethod = bluetoothAdapter.getClass().getDeclaredMethod("getConnectionState", null);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(bluetoothAdapter, null);
            if (!(invoke instanceof Integer)) {
                return -1;
            }
            return ((Integer) invoke).intValue();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static Method getDeclaredMethod() throws Exception {
        return Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
    }

    @SuppressLint({"MissingPermission"})
    public static int getPriority(Context context, BluetoothProfile bluetoothProfile, BluetoothDevice bluetoothDevice) {
        if (bluetoothProfile != null && bluetoothDevice != null && CommonUtil.checkHasConnectPermission(context)) {
            try {
                Method method = (Method) getDeclaredMethod().invoke(bluetoothProfile.getClass(), "getPriority", new Class[]{BluetoothDevice.class});
                if (method == null) {
                    return 0;
                }
                Object invoke = method.invoke(bluetoothProfile, bluetoothDevice);
                if (!(invoke instanceof Integer)) {
                    return 0;
                }
                return ((Integer) invoke).intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public static BluetoothDevice getRemoteDevice(String str) {
        BluetoothAdapter defaultAdapter;
        if (!BluetoothAdapter.checkBluetoothAddress(str) || (defaultAdapter = BluetoothAdapter.getDefaultAdapter()) == null) {
            return null;
        }
        try {
            return defaultAdapter.getRemoteDevice(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @SuppressLint({"MissingPermission"})
    public static List<BluetoothDevice> getSystemConnectedBtDeviceList(Context context) {
        if (!CommonUtil.checkHasConnectPermission(context)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        try {
            int btAdapterConnectionState = getBtAdapterConnectionState(context, defaultAdapter);
            if (btAdapterConnectionState == 2 || btAdapterConnectionState == 0) {
                for (BluetoothDevice bluetoothDevice : defaultAdapter.getBondedDevices()) {
                    if (isBTConnected(context, bluetoothDevice)) {
                        arrayList.add(bluetoothDevice);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (arrayList.size() <= 0) {
            return null;
        }
        return arrayList;
    }

    public static boolean hasBle(Context context) {
        if (context != null && context.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le")) {
            return true;
        }
        return false;
    }

    public static String hexDataCovetToAddress(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        if (bArr != null && bArr.length == 6) {
            for (int i = 0; i < bArr.length; i++) {
                char[] cArr = b;
                sb.append(cArr[(bArr[i] & 255) >> 4]);
                sb.append(cArr[bArr[i] & 15]);
                if (i != bArr.length - 1) {
                    sb.append(":");
                }
            }
        }
        return sb.toString();
    }

    public static byte[] hexStringCovertToByteArray(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            int i3 = i2 + 2;
            if (i3 <= str.length()) {
                try {
                    bArr[i] = (byte) Integer.valueOf(str.substring(i2, i3), 16).intValue();
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
        return bArr;
    }

    @SuppressLint({"MissingPermission"})
    public static boolean isBTConnected(Context context, BluetoothDevice bluetoothDevice) {
        if (!CommonUtil.checkHasConnectPermission(context) || bluetoothDevice == null) {
            return false;
        }
        try {
            Object invoke = bluetoothDevice.getClass().getDeclaredMethod("isConnected", null).invoke(bluetoothDevice, null);
            if (!(invoke instanceof Boolean)) {
                return false;
            }
            return ((Boolean) invoke).booleanValue();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @SuppressLint({"MissingPermission"})
    public static boolean isBluetoothEnable() {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter != null && defaultAdapter.isEnabled()) {
            return true;
        }
        return false;
    }

    public static boolean isHeadSetType(int i) {
        return i == 2 || i == 4;
    }

    @Deprecated
    public static String printBtDeviceInfo(BluetoothDevice bluetoothDevice) {
        return printBtDeviceInfo(CommonUtil.getMainContext(), bluetoothDevice);
    }

    @SuppressLint({"MissingPermission"})
    public static boolean removeBond(Context context, BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice == null || !CommonUtil.checkHasConnectPermission(context)) {
            return false;
        }
        try {
            Object invoke = bluetoothDevice.getClass().getMethod("removeBond", null).invoke(bluetoothDevice, null);
            if (!(invoke instanceof Boolean)) {
                return false;
            }
            return ((Boolean) invoke).booleanValue();
        } catch (Exception e) {
            e.printStackTrace();
            JL_Log.e(f17808a, "Invoke removeBond : " + e.getMessage());
            return false;
        }
    }

    public static String reverseAddressString(String str) {
        boolean z;
        boolean z2;
        if (!BluetoothAdapter.checkBluetoothAddress(str)) {
            return str;
        }
        if (str.contains(":")) {
            str = str.replaceAll(":", "");
        }
        byte[] hexStringCovertToByteArray = hexStringCovertToByteArray(str);
        if (hexStringCovertToByteArray == null) {
            return str;
        }
        byte[] bArr = new byte[6];
        int length = hexStringCovertToByteArray.length - 1;
        int i = 0;
        while (true) {
            if (i < hexStringCovertToByteArray.length) {
                z = true;
            } else {
                z = false;
            }
            if (length >= 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z & z2) {
                bArr[i] = hexStringCovertToByteArray[length];
                i++;
                length--;
            } else {
                return hexDataCovetToAddress(bArr);
            }
        }
    }

    @SuppressLint({"MissingPermission"})
    public static boolean setPriority(Context context, BluetoothProfile bluetoothProfile, BluetoothDevice bluetoothDevice, int i) {
        if (bluetoothProfile != null && bluetoothDevice != null && CommonUtil.checkHasConnectPermission(context)) {
            try {
                Method method = (Method) getDeclaredMethod().invoke(bluetoothProfile.getClass(), "setPriority", new Class[]{BluetoothDevice.class, Integer.TYPE});
                if (method == null) {
                    return false;
                }
                Object invoke = method.invoke(bluetoothProfile, bluetoothDevice, Integer.valueOf(i));
                if (!(invoke instanceof Boolean)) {
                    return false;
                }
                return ((Boolean) invoke).booleanValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @SuppressLint({"MissingPermission"})
    public static boolean deviceHasProfile(Context context, BluetoothDevice bluetoothDevice, UUID uuid) {
        ParcelUuid[] uuids;
        if (!isBluetoothEnable() || bluetoothDevice == null || uuid == null || TextUtils.isEmpty(uuid.toString()) || !CommonUtil.checkHasConnectPermission(context) || (uuids = bluetoothDevice.getUuids()) == null) {
            return false;
        }
        for (ParcelUuid parcelUuid : uuids) {
            if (parcelUuid != null && uuid.toString().equalsIgnoreCase(parcelUuid.toString())) {
                return true;
            }
        }
        return false;
    }

    @SuppressLint({"MissingPermission"})
    public static String printBtDeviceInfo(Context context, BluetoothDevice bluetoothDevice) {
        if (!CommonUtil.checkHasConnectPermission(context) || bluetoothDevice == null) {
            return "null";
        }
        return "name : " + bluetoothDevice.getName() + " ,type : " + bluetoothDevice.getType() + " ,address : " + bluetoothDevice.getAddress();
    }

    public static boolean createBond(BluetoothDevice bluetoothDevice) {
        return createBond(CommonUtil.getMainContext(), bluetoothDevice);
    }

    @SuppressLint({"MissingPermission"})
    public static boolean createBond(Context context, BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice == null || !CommonUtil.checkHasConnectPermission(context)) {
            return false;
        }
        return bluetoothDevice.createBond();
    }
}
