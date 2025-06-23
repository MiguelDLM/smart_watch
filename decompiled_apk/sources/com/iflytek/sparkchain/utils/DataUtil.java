package com.iflytek.sparkchain.utils;

import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import androidx.core.view.ViewCompat;
import com.garmin.fit.Fit;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.iflytek.sparkchain.utils.log.LogUtil;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class DataUtil {
    public static final String DEF_CHARSET = "gb2312";
    public static final String GB2312 = "gb2312";
    public static final int SIZE_1K = 1024;
    public static final int SIZE_64K = 65536;
    public static final String UNICODE = "unicode";
    public static final String UTF8 = "utf-8";
    public static DisplayMetrics mMetrics;

    public static int RandomInt(int i, int i2) {
        return i + new Random().nextInt(i2 - i);
    }

    public static long byteToLong(byte[] bArr, int i) {
        long j = 0;
        if (bArr != null && bArr.length >= 8) {
            for (int i2 = 0; i2 < 8; i2++) {
                j |= bArr[i2] & 255;
                if (i2 < 7) {
                    j <<= 8;
                }
            }
        }
        return j;
    }

    public static boolean compareJsonInt(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            return jSONObject2.getInt(str) >= jSONObject.getInt(str);
        } catch (JSONException unused) {
            LogUtil.e("invalid jsonobject,compare " + str + " error");
            return false;
        }
    }

    public static boolean compareJsonLong(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            return jSONObject2.getLong(str) >= jSONObject.getLong(str);
        } catch (JSONException unused) {
            LogUtil.e("invalid jsonobject,compare " + str + " error");
            return false;
        }
    }

    public static boolean compareJsonString(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            String string = jSONObject.getString(str);
            String string2 = jSONObject2.getString(str);
            if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                if (string.equalsIgnoreCase(string2)) {
                    return true;
                }
            }
            return false;
        } catch (JSONException unused) {
            LogUtil.e("invalid jsonobject,compare " + str + " error");
            return false;
        }
    }

    public static int dip2px(Context context, float f) {
        if (mMetrics == null) {
            mMetrics = context.getResources().getDisplayMetrics();
        }
        return (int) TypedValue.applyDimension(1, f, mMetrics);
    }

    public static String getComplexDateTime(long j) {
        return new SimpleDateFormat("yyyy/MM/dd HH:mm:ss SSS").format(Long.valueOf(j));
    }

    public static String getFileNameByDateTime(Date date) {
        try {
            return new SimpleDateFormat("yyyyMMdd_HHmmssSSS").format(date);
        } catch (Exception e) {
            LogUtil.e(e);
            return null;
        }
    }

    public static byte[] getNativeByteArray(String str) throws UnsupportedEncodingException {
        return getNativeByteArray(str, "gb2312");
    }

    public static String getSimpleDateTime(long j) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(j));
    }

    public static String getStringFromNativeByteArray(byte[] bArr) {
        return getStringFromNativeByteArray(bArr, "gb2312");
    }

    public static byte[] getUTF8Bom(String str) {
        byte[] bArr = null;
        try {
            byte[] bytes = str.getBytes("utf-8");
            int length = bytes.length + 3;
            bArr = new byte[length];
            bArr[0] = -17;
            bArr[1] = Fit.f11239xXoOI00O;
            bArr[2] = Fit.f11227x0OxxIOxX;
            for (int i = 3; i < length; i++) {
                bArr[i] = bytes[i - 3];
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return bArr;
    }

    public static int hexstring2Int(String str) {
        if (str.substring(0, 2).equalsIgnoreCase(HexStringBuilder.DEFAULT_PREFIX)) {
            str = str.substring(2);
        }
        return (int) Long.parseLong(str.toLowerCase(), 16);
    }

    public static byte[] longToByte(long j) {
        byte[] bArr = new byte[8];
        for (int i = 7; i >= 0; i += -1) {
            bArr[i] = (byte) (255 & j);
            LogUtil.d(" i = " + ((int) bArr[i]));
            j >>= 8;
        }
        return bArr;
    }

    public static int readInt(byte[] bArr, int i) {
        return ((bArr[i] << 24) & ViewCompat.MEASURED_STATE_MASK) | (bArr[i + 3] & 255) | ((bArr[i + 2] << 8) & 65280) | ((bArr[i + 1] << 16) & 16711680);
    }

    public static int sp2px(Context context, float f) {
        if (mMetrics == null) {
            mMetrics = context.getResources().getDisplayMetrics();
        }
        return (int) TypedValue.applyDimension(2, f, mMetrics);
    }

    public static int spModify(Context context, float f) {
        if (mMetrics == null) {
            mMetrics = context.getResources().getDisplayMetrics();
        }
        return (int) ((f * TypedValue.applyDimension(1, 1.0f, mMetrics)) / TypedValue.applyDimension(2, 1.0f, mMetrics));
    }

    public static ArrayList<byte[]> splitBuffer(byte[] bArr, int i, int i2, int i3) {
        ArrayList<byte[]> arrayList = new ArrayList<>();
        if (i3 > 0 && i2 > 0 && bArr != null && bArr.length >= i2 + i) {
            int i4 = 0;
            while (i4 < i2 - i) {
                int i5 = (i2 - i4) - i;
                if (i3 < i5) {
                    byte[] bArr2 = new byte[i3];
                    System.arraycopy(bArr, i4 + i, bArr2, 0, i3);
                    arrayList.add(bArr2);
                    i4 += i3;
                } else {
                    byte[] bArr3 = new byte[i5];
                    System.arraycopy(bArr, i4 + i, bArr3, 0, i5);
                    arrayList.add(bArr3);
                    i4 += i5;
                }
            }
        }
        return arrayList;
    }

    public static byte[] getNativeByteArray(String str, String str2) throws UnsupportedEncodingException {
        if (str == null) {
            return null;
        }
        if (str.length() <= 0) {
            return new byte[]{0};
        }
        byte[] bytes = str.getBytes(str2);
        byte[] bArr = new byte[bytes.length + 1];
        System.arraycopy(bytes, 0, bArr, 0, bytes.length);
        bArr[bytes.length] = 0;
        return bArr;
    }

    public static String getStringFromNativeByteArray(byte[] bArr, String str) {
        if (bArr == null) {
            return null;
        }
        int i = 0;
        while (i < bArr.length && bArr[i] != 0) {
            i++;
        }
        return new String(bArr, 0, Math.min(i, bArr.length), Charset.forName(str));
    }

    public static byte[] getUTF8Bom(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length + 3];
        bArr2[0] = -17;
        bArr2[1] = Fit.f11239xXoOI00O;
        bArr2[2] = Fit.f11227x0OxxIOxX;
        System.arraycopy(bArr, 0, bArr2, 3, bArr.length);
        return bArr2;
    }
}
