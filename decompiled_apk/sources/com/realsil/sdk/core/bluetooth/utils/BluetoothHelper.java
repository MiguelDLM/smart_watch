package com.realsil.sdk.core.bluetooth.utils;

import XXO0.oIX0oI;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothClass;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import android.os.ParcelUuid;
import com.facebook.internal.AnalyticsEvents;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.realsil.sdk.core.a.a;
import com.realsil.sdk.core.bluetooth.impl.BluetoothDeviceImpl;
import com.realsil.sdk.core.bluetooth.impl.BluetoothGattImpl;
import com.realsil.sdk.core.logger.ZLogger;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes11.dex */
public final class BluetoothHelper {
    public static final int BD_ADDR_LEN = 6;
    public static final int BD_UUID_LEN = 16;

    public static byte[] convertAddress(String str) {
        byte[] bArr = new byte[6];
        if (str != null && str.length() >= 17) {
            bArr[0] = (byte) (Character.digit(str.charAt(16), 16) + (Character.digit(str.charAt(15), 16) * 16));
            bArr[1] = (byte) (Character.digit(str.charAt(13), 16) + (Character.digit(str.charAt(12), 16) * 16));
            bArr[2] = (byte) (Character.digit(str.charAt(10), 16) + (Character.digit(str.charAt(9), 16) * 16));
            bArr[3] = (byte) (Character.digit(str.charAt(7), 16) + (Character.digit(str.charAt(6), 16) * 16));
            bArr[4] = (byte) (Character.digit(str.charAt(4), 16) + (Character.digit(str.charAt(3), 16) * 16));
            bArr[5] = (byte) (Character.digit(str.charAt(1), 16) + (Character.digit(str.charAt(0), 16) * 16));
        } else {
            bArr[0] = 0;
            bArr[1] = 0;
            bArr[2] = 0;
            bArr[3] = 0;
            bArr[4] = 0;
            bArr[5] = 0;
        }
        return bArr;
    }

    public static String convertMac(byte[] bArr) {
        String str;
        String sb;
        String sb2;
        String sb3;
        String sb4;
        if (bArr != null && bArr.length >= 6) {
            if ((bArr[5] & 255) <= 15) {
                StringBuilder a2 = a.a("0");
                a2.append(Integer.toHexString(bArr[5] & 255).toUpperCase());
                a2.append(":");
                str = a2.toString();
            } else {
                str = Integer.toHexString(bArr[5] & 255).toUpperCase() + ":";
            }
            if ((bArr[4] & 255) <= 15) {
                sb = str + "0" + Integer.toHexString(bArr[4] & 255).toUpperCase() + ":";
            } else {
                StringBuilder a3 = a.a(str);
                a3.append(Integer.toHexString(bArr[4] & 255).toUpperCase());
                a3.append(":");
                sb = a3.toString();
            }
            if ((bArr[3] & 255) <= 15) {
                sb2 = sb + "0" + Integer.toHexString(bArr[3] & 255).toUpperCase() + ":";
            } else {
                StringBuilder a4 = a.a(sb);
                a4.append(Integer.toHexString(bArr[3] & 255).toUpperCase());
                a4.append(":");
                sb2 = a4.toString();
            }
            if ((bArr[2] & 255) <= 15) {
                sb3 = sb2 + "0" + Integer.toHexString(bArr[2] & 255).toUpperCase() + ":";
            } else {
                StringBuilder a5 = a.a(sb2);
                a5.append(Integer.toHexString(bArr[2] & 255).toUpperCase());
                a5.append(":");
                sb3 = a5.toString();
            }
            if ((bArr[1] & 255) <= 15) {
                sb4 = sb3 + "0" + Integer.toHexString(bArr[1] & 255).toUpperCase() + ":";
            } else {
                StringBuilder a6 = a.a(sb3);
                a6.append(Integer.toHexString(bArr[1] & 255).toUpperCase());
                a6.append(":");
                sb4 = a6.toString();
            }
            if ((bArr[0] & 255) <= 15) {
                return sb4 + "0" + Integer.toHexString(bArr[0] & 255).toUpperCase();
            }
            StringBuilder a7 = a.a(sb4);
            a7.append(Integer.toHexString(bArr[0] & 255).toUpperCase());
            return a7.toString();
        }
        return "";
    }

    public static String dumpBluetoothDevice(BluetoothDevice bluetoothDevice) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("BluetoothDevice{ %s/%s", formatAddress(bluetoothDevice.getAddress(), true), bluetoothDevice.getName()));
        Locale locale = Locale.US;
        sb.append(String.format(locale, "\n\tbondState=%d, type=0x%02X", Integer.valueOf(bluetoothDevice.getBondState()), Integer.valueOf(bluetoothDevice.getType())));
        BluetoothClass bluetoothClass = bluetoothDevice.getBluetoothClass();
        if (bluetoothClass != null) {
            sb.append(String.format(locale, ", majorDeviceClass=0x%04X", Integer.valueOf(bluetoothClass.getMajorDeviceClass())));
            sb.append(String.format(locale, ", deviceClass=0x%04X", Integer.valueOf(bluetoothClass.getDeviceClass())));
        }
        ParcelUuid[] uuids = bluetoothDevice.getUuids();
        if (uuids != null && uuids.length > 0) {
            sb.append("\n\tsupportedFeaturesUuids");
            for (ParcelUuid parcelUuid : uuids) {
                sb.append(String.format("\n\t\t%s", parcelUuid.toString()));
            }
        }
        sb.append("\n}");
        return sb.toString();
    }

    public static String dumpBluetoothGattService(BluetoothGatt bluetoothGatt) {
        return dumpBluetoothGattService(bluetoothGatt.getServices());
    }

    public static String dumpService(BluetoothGattService bluetoothGattService, int i) {
        StringBuilder sb = new StringBuilder();
        String str = "";
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 == 0) {
                str = str + "╎";
            }
            str = str + HelpFormatter.DEFAULT_LONG_OPT_PREFIX;
        }
        sb.append("\n" + str + "[service]");
        sb.append("\n" + str + "UUID: " + bluetoothGattService.getUuid());
        sb.append("\n" + str + "type: " + bluetoothGattService.getType());
        sb.append("\n" + str + "instanceId: " + bluetoothGattService.getInstanceId());
        sb.append(String.format("\n%s  [characteristics]", str));
        for (BluetoothGattCharacteristic bluetoothGattCharacteristic : bluetoothGattService.getCharacteristics()) {
            sb.append("\n" + str + "    UUID: " + bluetoothGattCharacteristic.getUuid());
            sb.append("\n" + str + "      prop= " + String.format("0x%02X (%s)", Integer.valueOf(bluetoothGattCharacteristic.getProperties()), BluetoothGattImpl.parseProperty2(bluetoothGattCharacteristic.getProperties())));
            sb.append("\n" + str + "      perms= " + String.format("0x%02X (%s)", Integer.valueOf(bluetoothGattCharacteristic.getPermissions()), BluetoothGattImpl.getCharPermission(bluetoothGattCharacteristic.getPermissions())));
            List<BluetoothGattDescriptor> descriptors = bluetoothGattCharacteristic.getDescriptors();
            if (descriptors != null && descriptors.size() > 0) {
                sb.append("\n" + str + "      [descriptors]");
                for (BluetoothGattDescriptor bluetoothGattDescriptor : descriptors) {
                    sb.append("\n" + str + "        UUID: " + bluetoothGattDescriptor.getUuid());
                    sb.append("\n" + str + "          perms= " + String.format("0x%02X (%s)", Integer.valueOf(bluetoothGattDescriptor.getPermissions()), BluetoothGattImpl.getCharPermission(bluetoothGattDescriptor.getPermissions())));
                }
            }
        }
        if (bluetoothGattService.getIncludedServices() != null) {
            sb.append("\n" + str + "  [included services]");
            Iterator<BluetoothGattService> it = bluetoothGattService.getIncludedServices().iterator();
            while (it.hasNext()) {
                dumpService(it.next(), i + 1);
            }
        }
        return sb.toString();
    }

    public static String formatAddress(String str, boolean z) {
        if (!z) {
            return str;
        }
        if (str == null || str.length() != 17) {
            return "";
        }
        byte[] convertAddress = convertAddress(str);
        return convertAddress.length < 6 ? "" : String.format("%02X:%02X:**:**:**:%02X", Byte.valueOf(convertAddress[5]), Byte.valueOf(convertAddress[4]), Byte.valueOf(convertAddress[0]));
    }

    public static String formatAddressNegatitive(byte[] bArr) {
        return formatAddress(bArr, true, true);
    }

    public static String formatAddressPositive(byte[] bArr) {
        return formatAddress(bArr, false, false);
    }

    public static List<BluetoothDevice> getBondedBluetoothDevices() {
        ArrayList arrayList = new ArrayList();
        try {
            for (BluetoothDevice bluetoothDevice : BluetoothAdapter.getDefaultAdapter().getBondedDevices()) {
                if (BluetoothDeviceImpl.isConnected(bluetoothDevice)) {
                    ZLogger.v("connected: " + formatAddress(bluetoothDevice.getAddress(), true));
                    arrayList.add(bluetoothDevice);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public static String getCharPermission(int i) {
        return BluetoothGattImpl.getCharPermission(i);
    }

    public static String getCharPropertie(int i) {
        return BluetoothGattImpl.getCharPropertie(i);
    }

    public static List<BluetoothDevice> getConnectedBluetoothDevices() {
        ArrayList arrayList = new ArrayList();
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        try {
            Method declaredMethod = BluetoothAdapter.class.getDeclaredMethod("getConnectionState", null);
            declaredMethod.setAccessible(true);
            if (((Integer) declaredMethod.invoke(defaultAdapter, null)).intValue() == 2) {
                for (BluetoothDevice bluetoothDevice : defaultAdapter.getBondedDevices()) {
                    if (BluetoothDeviceImpl.isConnected(bluetoothDevice)) {
                        ZLogger.v("connected: " + formatAddress(bluetoothDevice.getAddress(), true));
                        arrayList.add(bluetoothDevice);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public static String getDescPermission(int i) {
        return BluetoothGattImpl.getDescPermission(i);
    }

    public static boolean isBleEnabled() {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter != null && defaultAdapter.isEnabled()) {
            return true;
        }
        return false;
    }

    public static boolean isBleSupported(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
    }

    public static String parseDeviceType(int i) {
        return BluetoothDeviceImpl.parseDeviceType(i);
    }

    public static String parseProfile(int i) {
        if (i != 16) {
            if (i != 17) {
                switch (i) {
                    case 1:
                        return "HEADSET";
                    case 2:
                        return "A2DP";
                    case 3:
                        return "HEALTH";
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
                    default:
                        return AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
                }
            }
            return "PBAP_CLIENT";
        }
        return "HEADSET_CLIENT";
    }

    public static String parseProfileState(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return "UNKNOWN (" + i + oIX0oI.I0Io.f4095I0Io;
                    }
                    return "3-BluetoothProfile.STATE_DISCONNECTING";
                }
                return "2-BluetoothProfile.STATE_CONNECTED";
            }
            return "1-BluetoothProfile.STATE_CONNECTING";
        }
        return "0-BluetoothProfile.STATE_DISCONNECTED";
    }

    public static List<String> parseProperty(int i) {
        return BluetoothGattImpl.parseProperty(i);
    }

    public static String parseProperty2(int i) {
        return BluetoothGattImpl.parseProperty2(i);
    }

    public static String dumpBluetoothGattService(List<BluetoothGattService> list) {
        StringBuilder sb = new StringBuilder();
        for (BluetoothGattService bluetoothGattService : list) {
            sb.append(String.format(Locale.US, "service: type=%d, %02X/%s\n", Integer.valueOf(bluetoothGattService.getType()), Integer.valueOf(bluetoothGattService.getInstanceId()), bluetoothGattService.getUuid().toString()));
            for (BluetoothGattCharacteristic bluetoothGattCharacteristic : bluetoothGattService.getCharacteristics()) {
                sb.append(String.format(Locale.US, "\tcharacteristic: %02X/%s\n", Integer.valueOf(bluetoothGattCharacteristic.getInstanceId()), bluetoothGattCharacteristic.getUuid().toString()));
            }
        }
        return sb.toString();
    }

    public static String formatAddress(byte[] bArr, boolean z) {
        return formatAddress(bArr, false, z);
    }

    public static String formatAddress(byte[] bArr, boolean z, boolean z2) {
        if (bArr == null || bArr.length < 6) {
            return "";
        }
        return z ? z2 ? String.format("%02X:%02X:**:**:**:%02X", Byte.valueOf(bArr[5]), Byte.valueOf(bArr[4]), Byte.valueOf(bArr[0])) : String.format("%02X:%02X:%02X:%02X:%02X:%02X", Byte.valueOf(bArr[5]), Byte.valueOf(bArr[4]), Byte.valueOf(bArr[3]), Byte.valueOf(bArr[2]), Byte.valueOf(bArr[1]), Byte.valueOf(bArr[0])) : z2 ? String.format("%02X:%02X:**:**:**:%02X", Byte.valueOf(bArr[0]), Byte.valueOf(bArr[1]), Byte.valueOf(bArr[5])) : String.format("%02X:%02X:%02X:%02X:%02X:%02X", Byte.valueOf(bArr[0]), Byte.valueOf(bArr[1]), Byte.valueOf(bArr[2]), Byte.valueOf(bArr[3]), Byte.valueOf(bArr[4]), Byte.valueOf(bArr[5]));
    }

    public static List<BluetoothDevice> getConnectedBluetoothDevices(int i) {
        ArrayList arrayList = new ArrayList();
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        try {
            if (defaultAdapter.getProfileConnectionState(i) == 2) {
                for (BluetoothDevice bluetoothDevice : defaultAdapter.getBondedDevices()) {
                    if (BluetoothDeviceImpl.isConnected(bluetoothDevice)) {
                        ZLogger.v("connected: " + formatAddress(bluetoothDevice.getAddress(), true));
                        arrayList.add(bluetoothDevice);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }
}
