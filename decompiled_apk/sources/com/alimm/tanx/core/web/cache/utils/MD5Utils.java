package com.alimm.tanx.core.web.cache.utils;

import java.security.MessageDigest;

/* loaded from: classes.dex */
public class MD5Utils {
    public static String bytesToHex(byte[] bArr, boolean z) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i];
            if (i2 < 0) {
                i2 += 256;
            }
            if (i2 < 16) {
                stringBuffer.append("0");
            }
            stringBuffer.append(Integer.toHexString(i2));
        }
        if (z) {
            return stringBuffer.toString().toUpperCase();
        }
        return stringBuffer.toString().toLowerCase();
    }

    public static String getMD5(String str) {
        return getMD5(str, true);
    }

    public static String getMD5(String str, boolean z) {
        try {
            return bytesToHex(MessageDigest.getInstance("MD5").digest(str.getBytes()), z);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
