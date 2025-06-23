package com.vtrump.vtble;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.util.Log;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.huawei.openalliance.ad.constant.bn;
import com.huawei.openalliance.ad.uriaction.i;
import com.vtrump.vtble.Scale.ScaleUserInfo;
import java.math.BigDecimal;
import java.math.RoundingMode;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes13.dex */
public class xxX {
    public static int I0Io(double d, int i) {
        return new BigDecimal(d + "").multiply(new BigDecimal(i + "")).intValue();
    }

    public static boolean II0XooXoX() {
        return true;
    }

    public static double II0xO0(float f, int i) {
        double d = f;
        if (!Double.isInfinite(d) && !Double.isNaN(d)) {
            return new BigDecimal(String.valueOf(f)).setScale(i, RoundingMode.HALF_UP).doubleValue();
        }
        Log.d("VTUtils", "getDoubleValue: " + f);
        return XIXIX.OOXIXo.f3760XO;
    }

    public static String IIXOooo(byte[] bArr) {
        StringBuilder sb = new StringBuilder("");
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() < 2) {
                sb.append(0);
            }
            sb.append(hexString);
            sb.append(HelpFormatter.DEFAULT_OPT_PREFIX);
        }
        return sb.toString();
    }

    public static String IXxxXO(String str) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int i = 0;
        while (i < str.length() - 1) {
            int i2 = i + 2;
            int parseInt = Integer.parseInt(str.substring(i, i2), 16);
            sb.append((char) parseInt);
            sb2.append(parseInt);
            i = i2;
        }
        System.out.println("hex2string, Decimal : " + sb2.toString());
        return sb.toString();
    }

    public static String O0xOxO(byte[] bArr) {
        if (bArr == null || bArr.length != 6) {
            return null;
        }
        return String.format("%02X:%02X:%02X:%02X:%02X:%02X", Byte.valueOf(bArr[0]), Byte.valueOf(bArr[1]), Byte.valueOf(bArr[2]), Byte.valueOf(bArr[3]), Byte.valueOf(bArr[4]), Byte.valueOf(bArr[5]));
    }

    public static byte[] OOXIXo(String str) {
        byte[] bArr = new byte[6];
        int i = 0;
        int i2 = 0;
        while (i < str.length()) {
            if (str.charAt(i) != ':') {
                bArr[i2] = (byte) Integer.parseInt(str.substring(i, i + 2), 16);
                i2++;
                i++;
            }
            i++;
        }
        return bArr;
    }

    public static double Oo(double d, int i) {
        if (!Double.isInfinite(d) && !Double.isNaN(d)) {
            return new BigDecimal(String.valueOf(d)).setScale(i, RoundingMode.HALF_UP).doubleValue();
        }
        Log.d("VTUtils", "getDoubleValue: " + d);
        return XIXIX.OOXIXo.f3760XO;
    }

    public static String OxI(byte[] bArr) {
        StringBuilder sb = new StringBuilder("");
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() < 2) {
                sb.append(0);
            }
            sb.append(hexString);
            sb.append(":");
        }
        return sb.toString();
    }

    public static JSONArray Oxx0IOOO(double[] dArr, int i) {
        JSONArray jSONArray = new JSONArray();
        if (dArr != null && dArr.length != 0) {
            for (double d : dArr) {
                try {
                    jSONArray.put(Oo(d, i));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        return jSONArray;
    }

    public static String Oxx0xo(byte[] bArr) {
        StringBuilder sb = new StringBuilder("");
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() < 2) {
                sb.append(0);
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    public static byte[] OxxIIOOXO(int i) {
        return new byte[]{(byte) ((i >> 24) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)};
    }

    public static String X0o0xo(ScaleUserInfo scaleUserInfo, byte[] bArr, byte[] bArr2, String str, String str2, int i, VTDevice vTDevice) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("key", xoXoI.OOXIxO0().IIxOXoOo0());
            jSONObject.put("source", i);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("type", 0);
            jSONObject2.put("dataId", str2);
            jSONObject2.put("rawData", XO(bArr2));
            jSONObject2.put("adv", XO(bArr));
            jSONObject.put("data", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("height", scaleUserInfo.oxoX());
            jSONObject3.put("age", scaleUserInfo.II0xO0());
            jSONObject3.put("gender", scaleUserInfo.I0Io());
            jSONObject.put("user", jSONObject3);
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("sn", oxoX(xoXoI.OOXIxO0().OO0x0xX("getAndroidId")));
            jSONObject.put("phone", jSONObject4);
            JSONObject jSONObject5 = new JSONObject();
            jSONObject5.put("sn", str.toUpperCase());
            if (vTDevice != null && (vTDevice instanceof xxIXOIIO)) {
                jSONObject5.put("name", vTDevice.oI0IIXIo());
                jSONObject5.put("fwVer", vTDevice.IXxxXO());
            }
            jSONObject.put(DeviceRequestsHelper.DEVICE_INFO_DEVICE, jSONObject5);
            JSONObject jSONObject6 = new JSONObject();
            Context OO0x0xX2 = xoXoI.OOXIxO0().OO0x0xX("getapkname");
            if (OO0x0xX2 != null) {
                jSONObject6.put(i.Code, OO0x0xX2.getPackageName());
            }
            jSONObject6.put(bn.f.Code, "3.7.7");
            jSONObject.put("debugInfo", jSONObject6);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static String XO(byte[] bArr) {
        StringBuilder sb = new StringBuilder("");
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        for (int i = 0; i < bArr.length; i++) {
            if (i != 0) {
                sb.append(HelpFormatter.DEFAULT_OPT_PREFIX);
            }
            String hexString = Integer.toHexString(bArr[i] & 255);
            if (hexString.length() < 2) {
                sb.append(0);
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    public static String o00(byte[] bArr) {
        StringBuilder sb = new StringBuilder("");
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() < 2) {
                sb.append(0);
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    public static boolean oI0IIXIo() {
        return Build.VERSION.SDK_INT >= 23;
    }

    public static byte oIX0oI(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }

    public static double[] oO(double[] dArr, int i, double d) {
        int length = dArr.length;
        double[] dArr2 = new double[length];
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            if (i3 != i) {
                dArr2[i2] = dArr[i3];
            } else {
                dArr2[i2] = d;
            }
            i2++;
        }
        return dArr2;
    }

    public static byte[] oOoXoXO(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[bArr.length - ((i2 - i) + 1)];
        int i3 = 0;
        for (int i4 = 0; i4 < bArr.length; i4++) {
            if (i4 < i) {
                bArr2[i3] = bArr[i4];
                i3++;
            }
            if (i4 > i2) {
                bArr2[i3] = bArr[i4];
                i3++;
            }
        }
        return bArr2;
    }

    public static byte[] ooOOo0oXI(byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            bArr = new byte[0];
        }
        byte[] bArr3 = new byte[bArr.length + bArr2.length];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    public static String oxoX(Context context) {
        return Settings.Secure.getString(context.getContentResolver(), "android_id");
    }

    public static double[] x0XOIxOo(double[] dArr) {
        if (dArr == null) {
            return new double[0];
        }
        if (dArr.length == 0) {
            return new double[0];
        }
        int i = 0;
        for (double d : dArr) {
            if (d == XIXIX.OOXIXo.f3760XO) {
                i++;
            }
        }
        return i == dArr.length ? new double[0] : dArr;
    }

    public static byte x0xO0oo(byte[] bArr, int i, int i2) {
        byte b = bArr[i];
        while (true) {
            i++;
            if (i > i2) {
                return b;
            }
            b = (byte) (b ^ bArr[i]);
        }
    }

    public static byte[] xoIox(int i) {
        return new byte[]{(byte) ((i >> 8) & 255), (byte) (i & 255)};
    }

    public static byte[] xoXoI(String str) {
        if (str == null || str.equals("")) {
            return null;
        }
        String upperCase = str.toUpperCase();
        int length = upperCase.length() / 2;
        char[] charArray = upperCase.toCharArray();
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) (oIX0oI(charArray[i2 + 1]) | (oIX0oI(charArray[i2]) << 4));
        }
        return bArr;
    }

    public static boolean xxIXOIIO(ScaleUserInfo scaleUserInfo) {
        return scaleUserInfo.I0Io() == 4 || scaleUserInfo.I0Io() == 5;
    }
}
