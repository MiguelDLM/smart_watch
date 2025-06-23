package com.blankj.utilcode.util;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;
import com.blankj.utilcode.util.ShellUtils;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.kuaishou.weapon.p0.bi;
import com.kuaishou.weapon.p0.g;
import java.io.File;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.UUID;

/* loaded from: classes8.dex */
public final class DeviceUtils {
    private static final String KEY_UDID = "KEY_UDID";
    private static volatile String udid;

    private DeviceUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static String[] getABIs() {
        return Build.SUPPORTED_ABIS;
    }

    @SuppressLint({"HardwareIds"})
    public static String getAndroidID() {
        String string = Settings.Secure.getString(Utils.getApp().getContentResolver(), "android_id");
        if ("9774d56d682e549c".equals(string) || string == null) {
            return "";
        }
        return string;
    }

    private static InetAddress getInetAddress() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface nextElement = networkInterfaces.nextElement();
                if (nextElement.isUp()) {
                    Enumeration<InetAddress> inetAddresses = nextElement.getInetAddresses();
                    while (inetAddresses.hasMoreElements()) {
                        InetAddress nextElement2 = inetAddresses.nextElement();
                        if (!nextElement2.isLoopbackAddress() && nextElement2.getHostAddress().indexOf(58) < 0) {
                            return nextElement2;
                        }
                    }
                }
            }
            return null;
        } catch (SocketException e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequiresPermission(allOf = {g.d, g.f18396a, "android.permission.CHANGE_WIFI_STATE"})
    public static String getMacAddress() {
        String macAddress = getMacAddress(null);
        if (!TextUtils.isEmpty(macAddress) || getWifiEnabled()) {
            return macAddress;
        }
        setWifiEnabled(true);
        setWifiEnabled(false);
        return getMacAddress(null);
    }

    private static String getMacAddressByFile() {
        String str;
        String str2;
        ShellUtils.CommandResult execCmd = UtilsBridge.execCmd("getprop wifi.interface", false);
        if (execCmd.result == 0 && (str = execCmd.successMsg) != null) {
            ShellUtils.CommandResult execCmd2 = UtilsBridge.execCmd("cat /sys/class/net/" + str + "/address", false);
            if (execCmd2.result == 0 && (str2 = execCmd2.successMsg) != null && str2.length() > 0) {
                return str2;
            }
            return "02:00:00:00:00:00";
        }
        return "02:00:00:00:00:00";
    }

    private static String getMacAddressByInetAddress() {
        NetworkInterface byInetAddress;
        byte[] hardwareAddress;
        try {
            InetAddress inetAddress = getInetAddress();
            if (inetAddress != null && (byInetAddress = NetworkInterface.getByInetAddress(inetAddress)) != null && (hardwareAddress = byInetAddress.getHardwareAddress()) != null && hardwareAddress.length > 0) {
                StringBuilder sb = new StringBuilder();
                for (byte b : hardwareAddress) {
                    sb.append(String.format("%02x:", Byte.valueOf(b)));
                }
                return sb.substring(0, sb.length() - 1);
            }
            return "02:00:00:00:00:00";
        } catch (Exception e) {
            e.printStackTrace();
            return "02:00:00:00:00:00";
        }
    }

    private static String getMacAddressByNetworkInterface() {
        byte[] hardwareAddress;
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface nextElement = networkInterfaces.nextElement();
                if (nextElement != null && nextElement.getName().equalsIgnoreCase("wlan0") && (hardwareAddress = nextElement.getHardwareAddress()) != null && hardwareAddress.length > 0) {
                    StringBuilder sb = new StringBuilder();
                    for (byte b : hardwareAddress) {
                        sb.append(String.format("%02x:", Byte.valueOf(b)));
                    }
                    return sb.substring(0, sb.length() - 1);
                }
            }
            return "02:00:00:00:00:00";
        } catch (Exception e) {
            e.printStackTrace();
            return "02:00:00:00:00:00";
        }
    }

    @SuppressLint({"MissingPermission", "HardwareIds"})
    private static String getMacAddressByWifiInfo() {
        WifiInfo connectionInfo;
        try {
            WifiManager wifiManager = (WifiManager) Utils.getApp().getApplicationContext().getSystemService("wifi");
            if (wifiManager != null && (connectionInfo = wifiManager.getConnectionInfo()) != null) {
                String macAddress = connectionInfo.getMacAddress();
                if (!TextUtils.isEmpty(macAddress)) {
                    return macAddress;
                }
                return "02:00:00:00:00:00";
            }
            return "02:00:00:00:00:00";
        } catch (Exception e) {
            e.printStackTrace();
            return "02:00:00:00:00:00";
        }
    }

    public static String getManufacturer() {
        return Build.MANUFACTURER;
    }

    public static String getModel() {
        String str = Build.MODEL;
        if (str == null) {
            return "";
        }
        return str.trim().replaceAll("\\s*", "");
    }

    public static int getSDKVersionCode() {
        return Build.VERSION.SDK_INT;
    }

    public static String getSDKVersionName() {
        return Build.VERSION.RELEASE;
    }

    private static String getUdid(String str, String str2) {
        if (str2.equals("")) {
            return str + UUID.randomUUID().toString().replace(HelpFormatter.DEFAULT_OPT_PREFIX, "");
        }
        return str + UUID.nameUUIDFromBytes(str2.getBytes()).toString().replace(HelpFormatter.DEFAULT_OPT_PREFIX, "");
    }

    @SuppressLint({"MissingPermission", "HardwareIds"})
    public static String getUniqueDeviceId() {
        return getUniqueDeviceId("", true);
    }

    private static String getUniqueDeviceIdReal(String str) {
        try {
            String androidID = getAndroidID();
            if (!TextUtils.isEmpty(androidID)) {
                return saveUdid(str + 2, androidID);
            }
        } catch (Exception unused) {
        }
        return saveUdid(str + 9, "");
    }

    private static boolean getWifiEnabled() {
        WifiManager wifiManager = (WifiManager) Utils.getApp().getSystemService("wifi");
        if (wifiManager == null) {
            return false;
        }
        return wifiManager.isWifiEnabled();
    }

    @RequiresApi(api = 17)
    public static boolean isAdbEnabled() {
        if (Settings.Secure.getInt(Utils.getApp().getContentResolver(), "adb_enabled", 0) <= 0) {
            return false;
        }
        return true;
    }

    private static boolean isAddressNotInExcepts(String str, String... strArr) {
        if (TextUtils.isEmpty(str) || "02:00:00:00:00:00".equals(str)) {
            return false;
        }
        if (strArr != null && strArr.length != 0) {
            for (String str2 : strArr) {
                if (str2 != null && str2.equals(str)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isDeviceRooted() {
        String[] strArr = {"/system/bin/", "/system/xbin/", "/sbin/", "/system/sd/xbin/", "/system/bin/failsafe/", "/data/local/xbin/", "/data/local/bin/", "/data/local/", "/system/sbin/", "/usr/bin/", "/vendor/bin/"};
        for (int i = 0; i < 11; i++) {
            if (new File(strArr[i] + bi.y).exists()) {
                return true;
            }
        }
        return false;
    }

    public static boolean isEmulator() {
        String str;
        String str2 = Build.FINGERPRINT;
        if (!str2.startsWith("generic") && !str2.toLowerCase().contains("vbox") && !str2.toLowerCase().contains("test-keys")) {
            String str3 = Build.MODEL;
            if (!str3.contains("google_sdk") && !str3.contains("Emulator") && !str3.contains("Android SDK built for x86") && !Build.MANUFACTURER.contains("Genymotion") && ((!Build.BRAND.startsWith("generic") || !Build.DEVICE.startsWith("generic")) && !"google_sdk".equals(Build.PRODUCT))) {
                TelephonyManager telephonyManager = (TelephonyManager) Utils.getApp().getSystemService("phone");
                if (telephonyManager == null || (str = telephonyManager.getNetworkOperatorName()) == null) {
                    str = "";
                }
                if (str.toLowerCase().equals("android")) {
                    return true;
                }
                Intent intent = new Intent();
                intent.setData(Uri.parse("tel:123456"));
                intent.setAction("android.intent.action.DIAL");
                if (intent.resolveActivity(Utils.getApp().getPackageManager()) == null) {
                    return true;
                }
                return false;
            }
        }
        return true;
    }

    @SuppressLint({"MissingPermission", "HardwareIds"})
    public static boolean isSameDevice(String str) {
        if (TextUtils.isEmpty(str) && str.length() < 33) {
            return false;
        }
        if (str.equals(udid) || str.equals(UtilsBridge.getSpUtils4Utils().getString(KEY_UDID, null))) {
            return true;
        }
        int length = str.length();
        int i = length - 33;
        int i2 = length - 32;
        String substring = str.substring(i, i2);
        if (substring.startsWith("1")) {
            String macAddress = getMacAddress();
            if (macAddress.equals("")) {
                return false;
            }
            return str.substring(i2).equals(getUdid("", macAddress));
        }
        if (!substring.startsWith("2")) {
            return false;
        }
        String androidID = getAndroidID();
        if (TextUtils.isEmpty(androidID)) {
            return false;
        }
        return str.substring(i2).equals(getUdid("", androidID));
    }

    public static boolean isTablet() {
        if ((Resources.getSystem().getConfiguration().screenLayout & 15) >= 3) {
            return true;
        }
        return false;
    }

    private static String saveUdid(String str, String str2) {
        udid = getUdid(str, str2);
        UtilsBridge.getSpUtils4Utils().put(KEY_UDID, udid);
        return udid;
    }

    @RequiresPermission("android.permission.CHANGE_WIFI_STATE")
    private static void setWifiEnabled(boolean z) {
        WifiManager wifiManager = (WifiManager) Utils.getApp().getSystemService("wifi");
        if (wifiManager == null || z == wifiManager.isWifiEnabled()) {
            return;
        }
        wifiManager.setWifiEnabled(z);
    }

    @SuppressLint({"MissingPermission", "HardwareIds"})
    public static String getUniqueDeviceId(String str) {
        return getUniqueDeviceId(str, true);
    }

    @SuppressLint({"MissingPermission", "HardwareIds"})
    public static String getUniqueDeviceId(boolean z) {
        return getUniqueDeviceId("", z);
    }

    @SuppressLint({"MissingPermission", "HardwareIds"})
    public static String getUniqueDeviceId(String str, boolean z) {
        if (!z) {
            return getUniqueDeviceIdReal(str);
        }
        if (udid == null) {
            synchronized (DeviceUtils.class) {
                try {
                    if (udid == null) {
                        String string = UtilsBridge.getSpUtils4Utils().getString(KEY_UDID, null);
                        if (string != null) {
                            udid = string;
                            return udid;
                        }
                        return getUniqueDeviceIdReal(str);
                    }
                } finally {
                }
            }
        }
        return udid;
    }

    @RequiresPermission(allOf = {g.d, g.f18396a})
    public static String getMacAddress(String... strArr) {
        String macAddressByNetworkInterface = getMacAddressByNetworkInterface();
        if (isAddressNotInExcepts(macAddressByNetworkInterface, strArr)) {
            return macAddressByNetworkInterface;
        }
        String macAddressByInetAddress = getMacAddressByInetAddress();
        if (isAddressNotInExcepts(macAddressByInetAddress, strArr)) {
            return macAddressByInetAddress;
        }
        String macAddressByWifiInfo = getMacAddressByWifiInfo();
        if (isAddressNotInExcepts(macAddressByWifiInfo, strArr)) {
            return macAddressByWifiInfo;
        }
        String macAddressByFile = getMacAddressByFile();
        return isAddressNotInExcepts(macAddressByFile, strArr) ? macAddressByFile : "";
    }
}
