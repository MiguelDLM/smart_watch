package com.huawei.openalliance.ad.utils;

import android.text.TextUtils;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.huawei.hms.ads.fb;
import java.util.Locale;

/* loaded from: classes10.dex */
public abstract class v {
    private static final String Code = "";
    private static final String V = "HexUtil";

    public static String Code(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() == 1) {
                sb.append('0');
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    public static byte[] Code(String str) {
        StringBuilder sb;
        if (TextUtils.isEmpty(str)) {
            return new byte[0];
        }
        String upperCase = str.toUpperCase(Locale.ENGLISH);
        int length = upperCase.length() / 2;
        byte[] bArr = new byte[length];
        try {
            byte[] bytes = upperCase.getBytes("UTF-8");
            for (int i = 0; i < length; i++) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(HexStringBuilder.DEFAULT_PREFIX);
                int i2 = i * 2;
                sb2.append(new String(new byte[]{bytes[i2]}, "UTF-8"));
                bArr[i] = (byte) (((byte) (Byte.decode(sb2.toString()).byteValue() << 4)) ^ Byte.decode(HexStringBuilder.DEFAULT_PREFIX + new String(new byte[]{bytes[i2 + 1]}, "UTF-8")).byteValue());
            }
        } catch (NumberFormatException e) {
            e = e;
            sb = new StringBuilder();
            sb.append("hex string 2 byte: ");
            sb.append(e.getClass().getSimpleName());
            fb.Z(V, sb.toString());
            return bArr;
        } catch (Throwable th) {
            e = th;
            sb = new StringBuilder();
            sb.append("hex string 2 byte: ");
            sb.append(e.getClass().getSimpleName());
            fb.Z(V, sb.toString());
            return bArr;
        }
        return bArr;
    }
}
