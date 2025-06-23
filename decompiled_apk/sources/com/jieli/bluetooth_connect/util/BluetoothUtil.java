package com.jieli.bluetooth_connect.util;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothA2dp;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothHeadset;
import android.bluetooth.BluetoothManager;
import android.bluetooth.BluetoothProfile;
import android.content.Context;
import android.os.ParcelUuid;
import android.text.TextUtils;
import com.jieli.bluetooth_connect.constant.BluetoothConstant;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.eclipse.paho.android.service.MqttServiceConstants;

/* loaded from: classes10.dex */
public class BluetoothUtil {
    private static final String TAG = "BluetoothUtil";
    private static final char[] mChars = "0123456789ABCDEF".toCharArray();

    public static byte[] addressCovertToByteArray(String address) {
        if (TextUtils.isEmpty(address) || !address.contains(":")) {
            return null;
        }
        String replace = address.replace(":", "");
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
    public static boolean connectDeviceA2dp(Context context, BluetoothA2dp bluetoothA2dp, BluetoothDevice device) {
        if (bluetoothA2dp == null || device == null || !ConnectUtil.isHasConnectPermission(context)) {
            return false;
        }
        try {
            Object invoke = bluetoothA2dp.getClass().getMethod(MqttServiceConstants.CONNECT_ACTION, BluetoothDevice.class).invoke(bluetoothA2dp, device);
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
    public static boolean connectDeviceHfp(Context context, BluetoothHeadset bluetoothHeadset, BluetoothDevice device) {
        if (bluetoothHeadset == null || device == null || !ConnectUtil.isHasConnectPermission(context)) {
            return false;
        }
        try {
            Method method = bluetoothHeadset.getClass().getMethod(MqttServiceConstants.CONNECT_ACTION, BluetoothDevice.class);
            method.setAccessible(true);
            Object invoke = method.invoke(bluetoothHeadset, device);
            if (!(invoke instanceof Boolean)) {
                return false;
            }
            return ((Boolean) invoke).booleanValue();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String connectionString(int connection) {
        if (connection != 1) {
            if (connection != 2) {
                return "STATE_DISCONNECTED(0)";
            }
            return "STATE_CONNECTED(2)";
        }
        return "STATE_CONNECTING(1)";
    }

    @SuppressLint({"DiscouragedPrivateApi"})
    public static boolean createBond(Context context, BluetoothDevice device, int transport) {
        if (device == null || !ConnectUtil.isHasConnectPermission(context)) {
            return false;
        }
        try {
            Method declaredMethod = device.getClass().getDeclaredMethod("createBond", Integer.TYPE);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(device, Integer.valueOf(transport));
            if (invoke instanceof Boolean) {
                return ((Boolean) invoke).booleanValue();
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean deviceEquals(BluetoothDevice device1, BluetoothDevice device2) {
        if (device1 != null && device2 != null && device1.getAddress().equals(device2.getAddress())) {
            return true;
        }
        return false;
    }

    public static boolean deviceHasA2dp(Context context, BluetoothDevice device) {
        return deviceHasProfile(context, device, BluetoothConstant.UUID_A2DP);
    }

    public static boolean deviceHasHfp(Context context, BluetoothDevice device) {
        return deviceHasProfile(context, device, BluetoothConstant.UUID_HFP);
    }

    @SuppressLint({"MissingPermission"})
    public static boolean deviceHasProfile(Context context, BluetoothDevice device, UUID profileUuid) {
        ParcelUuid[] uuids;
        if (!isBluetoothEnable() || device == null || profileUuid == null || TextUtils.isEmpty(profileUuid.toString()) || !ConnectUtil.isHasConnectPermission(context) || (uuids = device.getUuids()) == null) {
            return false;
        }
        for (ParcelUuid parcelUuid : uuids) {
            if (parcelUuid != null && profileUuid.toString().equalsIgnoreCase(parcelUuid.toString())) {
                return true;
            }
        }
        return false;
    }

    @SuppressLint({"MissingPermission"})
    public static boolean disableBluetooth(Context context) {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter != null && ConnectUtil.isHasConnectPermission(context)) {
            if (defaultAdapter.isEnabled()) {
                return defaultAdapter.disable();
            }
            return true;
        }
        return false;
    }

    @SuppressLint({"MissingPermission"})
    public static boolean disconnectDeviceA2dp(Context context, BluetoothA2dp bluetoothA2dp, BluetoothDevice device) {
        if (bluetoothA2dp == null || device == null || !ConnectUtil.isHasConnectPermission(context)) {
            return false;
        }
        try {
            Method method = bluetoothA2dp.getClass().getMethod(MqttServiceConstants.DISCONNECT_ACTION, BluetoothDevice.class);
            method.setAccessible(true);
            Object invoke = method.invoke(bluetoothA2dp, device);
            if (!(invoke instanceof Boolean)) {
                return false;
            }
            return ((Boolean) invoke).booleanValue();
        } catch (Exception e) {
            JL_Log.e(TAG, "disconnectDeviceA2dp", "have an exception : " + e);
            e.printStackTrace();
            return false;
        }
    }

    @SuppressLint({"MissingPermission"})
    public static boolean disconnectDeviceHfp(Context context, BluetoothHeadset bluetoothHeadset, BluetoothDevice device) {
        if (bluetoothHeadset == null || device == null || !ConnectUtil.isHasConnectPermission(context)) {
            return false;
        }
        try {
            Method method = bluetoothHeadset.getClass().getMethod(MqttServiceConstants.DISCONNECT_ACTION, BluetoothDevice.class);
            method.setAccessible(true);
            Object invoke = method.invoke(bluetoothHeadset, device);
            if (!(invoke instanceof Boolean)) {
                return false;
            }
            return ((Boolean) invoke).booleanValue();
        } catch (Exception e) {
            JL_Log.e(TAG, "disconnectDeviceHfp", "have an exception : " + e);
            e.printStackTrace();
            return false;
        }
    }

    @SuppressLint({"MissingPermission"})
    public static boolean enableBluetooth(Context context) {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter != null && ConnectUtil.isHasConnectPermission(context)) {
            if (defaultAdapter.isEnabled()) {
                return true;
            }
            return defaultAdapter.enable();
        }
        return false;
    }

    public static int formatBleMtu(int mtu) {
        if (mtu < 20) {
            mtu = 20;
        }
        if (mtu > 509) {
            return 509;
        }
        return mtu;
    }

    @SuppressLint({"DiscouragedPrivateApi", "MissingPermission"})
    public static BluetoothDevice getActivityDevice(Context context, BluetoothA2dp bluetoothA2dp) {
        if (bluetoothA2dp == null || !ConnectUtil.isHasConnectPermission(context)) {
            return null;
        }
        try {
            Method declaredMethod = bluetoothA2dp.getClass().getDeclaredMethod("getActiveDevice", null);
            declaredMethod.setAccessible(true);
            return (BluetoothDevice) declaredMethod.invoke(bluetoothA2dp, null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @SuppressLint({"DiscouragedPrivateApi", "MissingPermission"})
    public static int getBtAdapterConnectionState(Context context, BluetoothAdapter bluetoothAdapter) {
        if (!ConnectUtil.isHasConnectPermission(context) || bluetoothAdapter == null) {
            return 0;
        }
        try {
            Method declaredMethod = bluetoothAdapter.getClass().getDeclaredMethod("getConnectionState", null);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(bluetoothAdapter, null);
            if (!(invoke instanceof Integer)) {
                return 0;
            }
            return ((Integer) invoke).intValue();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @SuppressLint({"MissingPermission"})
    public static List<BluetoothDevice> getConnectedBleDeviceList(Context context) {
        BluetoothManager bluetoothManager;
        if (ConnectUtil.isHasConnectPermission(context) && (bluetoothManager = (BluetoothManager) context.getSystemService("bluetooth")) != null) {
            try {
                return bluetoothManager.getConnectedDevices(7);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static Method getDeclaredMethod() throws Exception {
        return Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
    }

    @SuppressLint({"MissingPermission"})
    public static List<BluetoothDevice> getPairedBLEDevices(Context context) {
        List<BluetoothDevice> pairedDevices;
        if (!ConnectUtil.isHasConnectPermission(context) || (pairedDevices = getPairedDevices(context)) == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (BluetoothDevice bluetoothDevice : pairedDevices) {
            int type = bluetoothDevice.getType();
            if (type == 2 || type == 3) {
                arrayList.add(bluetoothDevice);
            }
        }
        return arrayList;
    }

    @SuppressLint({"MissingPermission"})
    public static List<BluetoothDevice> getPairedDevices(Context context) {
        BluetoothAdapter defaultAdapter;
        if (!ConnectUtil.isHasConnectPermission(context) || (defaultAdapter = BluetoothAdapter.getDefaultAdapter()) == null || !defaultAdapter.isEnabled()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (defaultAdapter.getBondedDevices() != null) {
            arrayList.addAll(defaultAdapter.getBondedDevices());
        }
        return arrayList;
    }

    @SuppressLint({"MissingPermission"})
    public static int getPriority(Context context, BluetoothProfile profile, BluetoothDevice device) {
        if (profile != null && device != null && ConnectUtil.isHasConnectPermission(context)) {
            try {
                Method method = (Method) getDeclaredMethod().invoke(profile.getClass(), "getPriority", new Class[]{BluetoothDevice.class});
                if (method == null) {
                    return 0;
                }
                Object invoke = method.invoke(profile, device);
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

    @Deprecated
    public static BluetoothDevice getRemoteDevice(String address) {
        return getRemoteDevice(ConnectUtil.getContext(), address);
    }

    @SuppressLint({"MissingPermission"})
    public static List<BluetoothDevice> getSystemConnectedBtDeviceList(Context context) {
        if (!ConnectUtil.isHasConnectPermission(context)) {
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

    public static String hexDataCovetToAddress(byte[] data) {
        StringBuilder sb = new StringBuilder();
        if (data != null && data.length == 6) {
            for (int i = 0; i < data.length; i++) {
                char[] cArr = mChars;
                sb.append(cArr[(data[i] & 255) >> 4]);
                sb.append(cArr[data[i] & 15]);
                if (i != data.length - 1) {
                    sb.append(":");
                }
            }
        }
        return sb.toString();
    }

    public static byte[] hexStringCovertToByteArray(String hexString) {
        if (TextUtils.isEmpty(hexString)) {
            return null;
        }
        int length = hexString.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            int i3 = i2 + 2;
            if (i3 <= hexString.length()) {
                try {
                    bArr[i] = (byte) Integer.valueOf(hexString.substring(i2, i3), 16).intValue();
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
        return bArr;
    }

    @SuppressLint({"MissingPermission"})
    public static boolean isBTConnected(Context context, BluetoothDevice device) {
        if (!ConnectUtil.isHasConnectPermission(context) || device == null) {
            return false;
        }
        try {
            Object invoke = device.getClass().getDeclaredMethod("isConnected", null).invoke(device, null);
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
    public static boolean isBleConnected(Context context, BluetoothDevice device) {
        List<BluetoothDevice> connectedBleDeviceList;
        if (context == null || device == null || !ConnectUtil.isHasConnectPermission(context) || (connectedBleDeviceList = getConnectedBleDeviceList(context)) == null) {
            return false;
        }
        for (BluetoothDevice bluetoothDevice : connectedBleDeviceList) {
            if (bluetoothDevice != null && device.getAddress().equals(bluetoothDevice.getAddress())) {
                return true;
            }
        }
        return false;
    }

    @SuppressLint({"MissingPermission"})
    public static boolean isBluetoothEnable() {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter != null && defaultAdapter.isEnabled()) {
            return true;
        }
        return false;
    }

    @SuppressLint({"MissingPermission"})
    public static void printBleGattServices(Context context, BluetoothDevice device, BluetoothGatt gatt, int status) {
        if (device != null && gatt != null && ConnectUtil.isHasConnectPermission(context) && JL_Log.isLog()) {
            String str = TAG;
            JL_Log.d(str, ConnectUtil.formatString("[[============================Bluetooth[%s], Discovery Services status[%d]=================================]]\n", printBtDeviceInfo(context, device), Integer.valueOf(status)));
            List<BluetoothGattService> services = gatt.getServices();
            if (services != null) {
                JL_Log.d(str, "[[======Service Size:" + services.size() + "======================\n");
                for (BluetoothGattService bluetoothGattService : services) {
                    if (bluetoothGattService != null) {
                        String str2 = TAG;
                        JL_Log.d(str2, "[[======Service:" + bluetoothGattService.getUuid() + "======================\n");
                        List<BluetoothGattCharacteristic> characteristics = bluetoothGattService.getCharacteristics();
                        if (characteristics != null) {
                            JL_Log.d(str2, "[[[[=============characteristics Size:" + characteristics.size() + "======================\n");
                            for (BluetoothGattCharacteristic bluetoothGattCharacteristic : characteristics) {
                                if (bluetoothGattCharacteristic != null) {
                                    String str3 = TAG;
                                    JL_Log.d(str3, "[[[[=============characteristic:" + bluetoothGattCharacteristic.getUuid() + ",write type : " + bluetoothGattCharacteristic.getWriteType() + "======================\n");
                                    List<BluetoothGattDescriptor> descriptors = bluetoothGattCharacteristic.getDescriptors();
                                    if (descriptors != null) {
                                        JL_Log.d(str3, "[[[[[[=============descriptors Size:" + descriptors.size() + "======================\n");
                                        for (BluetoothGattDescriptor bluetoothGattDescriptor : descriptors) {
                                            if (bluetoothGattDescriptor != null) {
                                                JL_Log.d(TAG, "[[[[[[=============descriptor:" + bluetoothGattDescriptor.getUuid() + ",permission:" + bluetoothGattDescriptor.getPermissions() + "\nvalue : " + CHexConverter.byte2HexStr(bluetoothGattDescriptor.getValue()) + "======================\n");
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            JL_Log.d(TAG, "[[============================Bluetooth[" + printBtDeviceInfo(context, device) + "] Services show End=================================]]\n");
        }
    }

    @Deprecated
    public static String printBtDeviceInfo(BluetoothDevice device) {
        return printBtDeviceInfo(ConnectUtil.getContext(), device, true);
    }

    @SuppressLint({"MissingPermission"})
    public static boolean refreshBleDeviceCache(Context context, BluetoothGatt bluetoothGatt) {
        if (bluetoothGatt == null || !ConnectUtil.isHasConnectPermission(context)) {
            return false;
        }
        try {
            Object invoke = bluetoothGatt.getClass().getMethod("refresh", null).invoke(bluetoothGatt, null);
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
    public static boolean removeBond(Context context, BluetoothDevice device) {
        if (device == null || !ConnectUtil.isHasConnectPermission(context)) {
            return false;
        }
        try {
            Object invoke = device.getClass().getMethod("removeBond", null).invoke(device, null);
            if (!(invoke instanceof Boolean)) {
                return false;
            }
            return ((Boolean) invoke).booleanValue();
        } catch (Exception e) {
            e.printStackTrace();
            JL_Log.e(TAG, "removeBond", "Invoke removeBond : " + e.getMessage());
            return false;
        }
    }

    public static String reverseAddressString(String srcAddr) {
        boolean z;
        boolean z2;
        if (!BluetoothAdapter.checkBluetoothAddress(srcAddr)) {
            return srcAddr;
        }
        if (srcAddr.contains(":")) {
            srcAddr = srcAddr.replaceAll(":", "");
        }
        byte[] hexStringCovertToByteArray = hexStringCovertToByteArray(srcAddr);
        if (hexStringCovertToByteArray == null) {
            return srcAddr;
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

    @SuppressLint({"DiscouragedPrivateApi", "MissingPermission"})
    public static boolean setActivityDevice(Context context, BluetoothA2dp bluetoothA2dp, BluetoothDevice device) {
        if (bluetoothA2dp == null || device == null || !ConnectUtil.isHasConnectPermission(context)) {
            return false;
        }
        try {
            Method declaredMethod = bluetoothA2dp.getClass().getDeclaredMethod("setActiveDevice", device.getClass());
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(bluetoothA2dp, device);
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
    public static boolean setPriority(Context context, BluetoothProfile profile, BluetoothDevice device, int priority) {
        if (profile != null && device != null && ConnectUtil.isHasConnectPermission(context)) {
            try {
                Method method = (Method) getDeclaredMethod().invoke(profile.getClass(), "setPriority", new Class[]{BluetoothDevice.class, Integer.TYPE});
                if (method == null) {
                    return false;
                }
                Object invoke = method.invoke(profile, device, Integer.valueOf(priority));
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

    public static BluetoothDevice getRemoteDevice(Context context, String address) {
        BluetoothAdapter defaultAdapter;
        if (!BluetoothAdapter.checkBluetoothAddress(address) || !ConnectUtil.isHasConnectPermission(context) || (defaultAdapter = BluetoothAdapter.getDefaultAdapter()) == null) {
            return null;
        }
        try {
            return defaultAdapter.getRemoteDevice(address);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String printBtDeviceInfo(Context context, BluetoothDevice device) {
        return printBtDeviceInfo(context, device, true);
    }

    @SuppressLint({"MissingPermission"})
    public static String printBtDeviceInfo(Context context, BluetoothDevice device, boolean isDetail) {
        if (device == null || !ConnectUtil.isHasConnectPermission(context)) {
            return "null";
        }
        if (isDetail) {
            return "name : " + device.getName() + ", type : " + device.getType() + ", address : " + device.getAddress();
        }
        return device.getAddress();
    }

    @SuppressLint({"MissingPermission"})
    public static boolean createBond(Context context, BluetoothDevice device) {
        if (device == null || !ConnectUtil.isHasConnectPermission(context)) {
            return false;
        }
        return device.createBond();
    }
}
