package com.baidu.location;

import XIXIX.OOXIXo;

/* loaded from: classes7.dex */
public class Jni {

    /* renamed from: a, reason: collision with root package name */
    private static int f5600a = 0;
    private static int b = 1;
    private static int c = 2;
    private static int d = 11;
    private static int e = 12;
    private static int f = 13;
    private static int g = 14;
    private static int h = 15;
    private static int i = 1024;
    private static boolean j = false;

    static {
        try {
            System.loadLibrary("locSDK8b");
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            j = true;
        }
    }

    private static native String a(byte[] bArr, int i2);

    private static native String b(double d2, double d3, int i2, int i3);

    private static native String c(byte[] bArr, int i2);

    public static double[] coorEncrypt(double d2, double d3, String str) {
        double[] dArr = {OOXIXo.f3760XO, OOXIXo.f3760XO};
        if (j) {
            return dArr;
        }
        try {
            String[] split = b(d2, d3, str.equals("gcj2wgs") ? 16 : str.equals("bd09") ? f5600a : str.equals("bd09ll") ? b : str.equals("gcj02") ? c : str.equals(BDLocation.BDLOCATION_WGS84_TO_GCJ02) ? d : str.equals(BDLocation.BDLOCATION_BD09_TO_GCJ02) ? e : str.equals(BDLocation.BDLOCATION_BD09LL_TO_GCJ02) ? f : str.equals("wgs842mc") ? h : -1, 132456).split(":");
            dArr[0] = Double.parseDouble(split[0]);
            dArr[1] = Double.parseDouble(split[1]);
        } catch (Throwable unused) {
            dArr[0] = 0.0d;
            dArr[1] = 0.0d;
        }
        return dArr;
    }

    private static native String ee(String str, int i2);

    public static String en1(String str) {
        if (j) {
            return "err!";
        }
        if (str == null) {
            return "null";
        }
        byte[] bytes = str.getBytes();
        byte[] bArr = new byte[i];
        int length = bytes.length;
        if (length > 740) {
            length = 740;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            byte b2 = bytes[i3];
            if (b2 != 0) {
                bArr[i2] = b2;
                i2++;
            }
        }
        try {
            return a(bArr, 132456);
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            return "err!";
        }
    }

    public static String encode(String str) {
        if (j) {
            return "err!";
        }
        return en1(str) + "|tp=3";
    }

    public static String encode2(String str) {
        if (j) {
            return "err!";
        }
        if (str == null) {
            return "null";
        }
        try {
            return c(str.getBytes(), 132456);
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            return "err!";
        }
    }

    public static Long encode3(String str) {
        String str2;
        if (j) {
            return null;
        }
        try {
            str2 = new String(str.getBytes(), "UTF-8");
        } catch (Exception unused) {
            str2 = "";
        }
        try {
            return Long.valueOf(murmur(str2));
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static native String encodeNotLimit(String str, int i2);

    public static String encodeOfflineLocationUpdateRequest(String str) {
        String str2;
        String str3 = "err!";
        if (j) {
            return "err!";
        }
        try {
            str2 = new String(str.getBytes(), "UTF-8");
        } catch (Exception unused) {
            str2 = "";
        }
        try {
            str3 = encodeNotLimit(str2, 132456);
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        }
        return str3 + "|tp=3";
    }

    public static String encodeTp4(String str) {
        String str2;
        String str3 = "err!";
        if (j) {
            return "err!";
        }
        try {
            str2 = new String(str.getBytes(), "UTF-8");
        } catch (Exception unused) {
            str2 = "";
        }
        try {
            str3 = ee(str2, 132456);
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        }
        return str3 + "|tp=4";
    }

    public static String encodeTp4NoTag(String str) {
        String str2;
        if (j) {
            return "err!";
        }
        try {
            str2 = new String(str.getBytes(), "UTF-8");
        } catch (Exception unused) {
            str2 = "";
        }
        try {
            return ee(str2, 132456);
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            return "err!";
        }
    }

    private static native byte[] encrypt(byte[] bArr);

    private static native void f(byte[] bArr, byte[] bArr2);

    private static native String g(byte[] bArr);

    public static double getGpsSwiftRadius(float f2, double d2, double d3) {
        if (j) {
            return OOXIXo.f3760XO;
        }
        try {
            return gsr(f2, d2, d3);
        } catch (UnsatisfiedLinkError unused) {
            return OOXIXo.f3760XO;
        }
    }

    public static String getldkaiv() {
        if (j) {
            return null;
        }
        try {
            return ldkaiv();
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static native double gsr(float f2, double d2, double d3);

    private static native String ldkaiv();

    private static native long murmur(String str);
}
