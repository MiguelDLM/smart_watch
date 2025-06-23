package com.blankj.utilcode.util;

import android.annotation.SuppressLint;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.annotation.RequiresPermission;
import com.kuaishou.weapon.p0.g;

/* loaded from: classes8.dex */
public final class PhoneUtils {
    private PhoneUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    @RequiresPermission("android.permission.CALL_PHONE")
    public static void call(String str) {
        Utils.getApp().startActivity(UtilsBridge.getCallIntent(str));
    }

    public static void dial(String str) {
        Utils.getApp().startActivity(UtilsBridge.getDialIntent(str));
    }

    @RequiresPermission(g.c)
    @SuppressLint({"HardwareIds"})
    public static String getDeviceId() {
        String imei;
        String meid;
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            return "";
        }
        TelephonyManager telephonyManager = getTelephonyManager();
        String deviceId = telephonyManager.getDeviceId();
        if (!TextUtils.isEmpty(deviceId)) {
            return deviceId;
        }
        if (i >= 26) {
            imei = telephonyManager.getImei();
            if (TextUtils.isEmpty(imei)) {
                meid = telephonyManager.getMeid();
                if (TextUtils.isEmpty(meid)) {
                    return "";
                }
                return meid;
            }
            return imei;
        }
        return "";
    }

    @RequiresPermission(g.c)
    public static String getIMEI() {
        return getImeiOrMeid(true);
    }

    @RequiresPermission(g.c)
    @SuppressLint({"HardwareIds"})
    public static String getIMSI() {
        if (Build.VERSION.SDK_INT >= 29) {
            try {
                getTelephonyManager().getSubscriberId();
            } catch (SecurityException e) {
                e.printStackTrace();
                return "";
            }
        }
        return getTelephonyManager().getSubscriberId();
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x00a1, code lost:
    
        if (r0.length() < 15) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00b7, code lost:
    
        if (r0.length() == 14) goto L58;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a6  */
    @androidx.annotation.RequiresPermission(com.kuaishou.weapon.p0.g.c)
    @android.annotation.SuppressLint({"HardwareIds"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String getImeiOrMeid(boolean r10) {
        /*
            r0 = 0
            r1 = 1
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 29
            java.lang.String r4 = ""
            if (r2 < r3) goto Lb
            return r4
        Lb:
            android.telephony.TelephonyManager r3 = getTelephonyManager()
            r5 = 26
            if (r2 < r5) goto L2f
            if (r10 == 0) goto L22
            java.lang.String r10 = com.blankj.utilcode.util.oI0IIXIo.oIX0oI(r3, r0)
            java.lang.String r0 = com.blankj.utilcode.util.oI0IIXIo.oIX0oI(r3, r1)
            java.lang.String r10 = getMinOne(r10, r0)
            return r10
        L22:
            java.lang.String r10 = com.blankj.utilcode.util.OxxIIOOXO.oIX0oI(r3, r0)
            java.lang.String r0 = com.blankj.utilcode.util.OxxIIOOXO.oIX0oI(r3, r1)
            java.lang.String r10 = getMinOne(r10, r0)
            return r10
        L2f:
            if (r10 == 0) goto L34
            java.lang.String r2 = "ril.gsm.imei"
            goto L36
        L34:
            java.lang.String r2 = "ril.cdma.meid"
        L36:
            java.lang.String r2 = getSystemPropertyByReflect(r2)
            boolean r5 = android.text.TextUtils.isEmpty(r2)
            r6 = 2
            if (r5 != 0) goto L56
            java.lang.String r10 = ","
            java.lang.String[] r10 = r2.split(r10)
            int r2 = r10.length
            if (r2 != r6) goto L53
            r0 = r10[r0]
            r10 = r10[r1]
            java.lang.String r10 = getMinOne(r0, r10)
            return r10
        L53:
            r10 = r10[r0]
            return r10
        L56:
            java.lang.String r2 = r3.getDeviceId()
            java.lang.Class r5 = r3.getClass()     // Catch: java.lang.reflect.InvocationTargetException -> L7c java.lang.IllegalAccessException -> L7e java.lang.NoSuchMethodException -> L80
            java.lang.String r7 = "getDeviceId"
            java.lang.Class[] r8 = new java.lang.Class[r1]     // Catch: java.lang.reflect.InvocationTargetException -> L7c java.lang.IllegalAccessException -> L7e java.lang.NoSuchMethodException -> L80
            java.lang.Class r9 = java.lang.Integer.TYPE     // Catch: java.lang.reflect.InvocationTargetException -> L7c java.lang.IllegalAccessException -> L7e java.lang.NoSuchMethodException -> L80
            r8[r0] = r9     // Catch: java.lang.reflect.InvocationTargetException -> L7c java.lang.IllegalAccessException -> L7e java.lang.NoSuchMethodException -> L80
            java.lang.reflect.Method r5 = r5.getMethod(r7, r8)     // Catch: java.lang.reflect.InvocationTargetException -> L7c java.lang.IllegalAccessException -> L7e java.lang.NoSuchMethodException -> L80
            if (r10 == 0) goto L6d
            r6 = 1
        L6d:
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch: java.lang.reflect.InvocationTargetException -> L7c java.lang.IllegalAccessException -> L7e java.lang.NoSuchMethodException -> L80
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.reflect.InvocationTargetException -> L7c java.lang.IllegalAccessException -> L7e java.lang.NoSuchMethodException -> L80
            r1[r0] = r6     // Catch: java.lang.reflect.InvocationTargetException -> L7c java.lang.IllegalAccessException -> L7e java.lang.NoSuchMethodException -> L80
            java.lang.Object r0 = r5.invoke(r3, r1)     // Catch: java.lang.reflect.InvocationTargetException -> L7c java.lang.IllegalAccessException -> L7e java.lang.NoSuchMethodException -> L80
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.reflect.InvocationTargetException -> L7c java.lang.IllegalAccessException -> L7e java.lang.NoSuchMethodException -> L80
            goto L8e
        L7c:
            r0 = move-exception
            goto L82
        L7e:
            r0 = move-exception
            goto L86
        L80:
            r0 = move-exception
            goto L8a
        L82:
            r0.printStackTrace()
            goto L8d
        L86:
            r0.printStackTrace()
            goto L8d
        L8a:
            r0.printStackTrace()
        L8d:
            r0 = r4
        L8e:
            if (r10 == 0) goto La6
            r10 = 15
            if (r2 == 0) goto L9b
            int r1 = r2.length()
            if (r1 >= r10) goto L9b
            r2 = r4
        L9b:
            if (r0 == 0) goto La4
            int r1 = r0.length()
            if (r1 >= r10) goto La4
            goto Lb9
        La4:
            r4 = r0
            goto Lb9
        La6:
            r10 = 14
            if (r2 == 0) goto Lb1
            int r1 = r2.length()
            if (r1 != r10) goto Lb1
            r2 = r4
        Lb1:
            if (r0 == 0) goto La4
            int r1 = r0.length()
            if (r1 != r10) goto La4
        Lb9:
            java.lang.String r10 = getMinOne(r2, r4)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blankj.utilcode.util.PhoneUtils.getImeiOrMeid(boolean):java.lang.String");
    }

    @RequiresPermission(g.c)
    public static String getMEID() {
        return getImeiOrMeid(false);
    }

    private static String getMinOne(String str, String str2) {
        boolean isEmpty = TextUtils.isEmpty(str);
        boolean isEmpty2 = TextUtils.isEmpty(str2);
        if (isEmpty && isEmpty2) {
            return "";
        }
        if (!isEmpty && !isEmpty2) {
            if (str.compareTo(str2) <= 0) {
                return str;
            }
            return str2;
        }
        if (!isEmpty) {
            return str;
        }
        return str2;
    }

    public static int getPhoneType() {
        return getTelephonyManager().getPhoneType();
    }

    @RequiresPermission(g.c)
    @SuppressLint({"HardwareIds"})
    public static String getSerial() {
        String serial;
        String serial2;
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            try {
                serial = Build.getSerial();
                return serial;
            } catch (SecurityException e) {
                e.printStackTrace();
                return "";
            }
        }
        if (i >= 26) {
            serial2 = Build.getSerial();
            return serial2;
        }
        return Build.SERIAL;
    }

    public static String getSimOperatorByMnc() {
        String simOperator = getTelephonyManager().getSimOperator();
        if (simOperator == null) {
            return "";
        }
        char c = 65535;
        switch (simOperator.hashCode()) {
            case 49679470:
                if (simOperator.equals("46000")) {
                    c = 0;
                    break;
                }
                break;
            case 49679471:
                if (simOperator.equals("46001")) {
                    c = 1;
                    break;
                }
                break;
            case 49679472:
                if (simOperator.equals("46002")) {
                    c = 2;
                    break;
                }
                break;
            case 49679473:
                if (simOperator.equals("46003")) {
                    c = 3;
                    break;
                }
                break;
            case 49679475:
                if (simOperator.equals("46005")) {
                    c = 4;
                    break;
                }
                break;
            case 49679476:
                if (simOperator.equals("46006")) {
                    c = 5;
                    break;
                }
                break;
            case 49679477:
                if (simOperator.equals("46007")) {
                    c = 6;
                    break;
                }
                break;
            case 49679479:
                if (simOperator.equals("46009")) {
                    c = 7;
                    break;
                }
                break;
            case 49679502:
                if (simOperator.equals("46011")) {
                    c = '\b';
                    break;
                }
                break;
            case 49679532:
                if (simOperator.equals("46020")) {
                    c = '\t';
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 2:
            case 6:
            case '\t':
                return "中国移动";
            case 1:
            case 5:
            case 7:
                return "中国联通";
            case 3:
            case 4:
            case '\b':
                return "中国电信";
            default:
                return simOperator;
        }
    }

    public static String getSimOperatorName() {
        return getTelephonyManager().getSimOperatorName();
    }

    private static String getSystemPropertyByReflect(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, "");
        } catch (Exception unused) {
            return "";
        }
    }

    private static TelephonyManager getTelephonyManager() {
        return (TelephonyManager) Utils.getApp().getSystemService("phone");
    }

    public static boolean isPhone() {
        if (getTelephonyManager().getPhoneType() != 0) {
            return true;
        }
        return false;
    }

    public static boolean isSimCardReady() {
        if (getTelephonyManager().getSimState() == 5) {
            return true;
        }
        return false;
    }

    public static void sendSms(String str, String str2) {
        Utils.getApp().startActivity(UtilsBridge.getSendSmsIntent(str, str2));
    }
}
