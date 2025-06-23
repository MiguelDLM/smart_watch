package com.baidu.tts.tools;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.UUID;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes8.dex */
public class CommonUtility {
    public static byte[] AES_cbc_decrypt(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        try {
            Cipher.getMaxAllowedKeyLength("AES/CBC/PKCS5Padding");
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, secretKeySpec, new IvParameterSpec(bArr3));
            return cipher.doFinal(bArr);
        } catch (Exception e) {
            e.printStackTrace();
            return new byte[0];
        }
    }

    public static String AES_cbc_encrypt(String str, String str2, String str3) {
        try {
            Cipher.getMaxAllowedKeyLength("AES/CBC/PKCS5Padding");
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes("utf-8"), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(1, secretKeySpec, new IvParameterSpec(str3.getBytes("utf-8")));
            return parseByte2HexStr(cipher.doFinal(str.getBytes("utf-8")));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static byte[] addCAFHeaderForPCMData(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            long length = ((16 * (44 + bArr.length)) * 1) / 8;
            byte b = (byte) 0;
            byte[] bArr2 = new byte[bArr.length + 44];
            System.arraycopy(new byte[]{82, 73, 70, 70, (byte) (r14 & 255), (byte) ((r14 >> 8) & 255), (byte) ((r14 >> 16) & 255), (byte) ((r14 >> 24) & 255), 87, 65, 86, 69, 102, 109, 116, 32, 16, 0, 0, 0, 1, 0, (byte) 1, 0, (byte) 128, (byte) 62, b, b, (byte) (length & 255), (byte) ((length >> 8) & 255), (byte) ((length >> 16) & 255), (byte) ((length >> 24) & 255), 2, 0, 16, 0, 100, 97, 116, 97, (byte) (r12 & 255), (byte) ((r12 >> 8) & 255), (byte) ((r12 >> 16) & 255), (byte) ((r12 >> 24) & 255)}, 0, bArr2, 0, 44);
            System.arraycopy(bArr, 0, bArr2, 44, bArr.length);
            return bArr2;
        }
        return null;
    }

    public static void asserts(boolean z, String str) {
        if (z) {
        } else {
            throw new AssertionError(str);
        }
    }

    public static byte[] copyBytesOfRange(byte[] bArr, int i, int i2) {
        if (i <= i2 && i >= 0 && i2 >= 0 && i2 <= bArr.length) {
            byte[] bArr2 = new byte[i2 - i];
            for (int i3 = i; i3 < i2; i3++) {
                bArr2[i3 - i] = bArr[i3];
            }
            return bArr2;
        }
        return null;
    }

    public static String generateSerialNumber() {
        return UUID.randomUUID().toString();
    }

    public static NetworkInfo getNetworkInfo(Context context) {
        return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
    }

    public static int indexOf(byte[] bArr, byte[] bArr2, int i) {
        int[] iArr;
        int i2;
        try {
            iArr = new int[bArr2.length];
            i2 = 0;
            int i3 = 0;
            for (int i4 = 1; i4 < bArr2.length; i4++) {
                while (i3 > 0 && bArr2[i3] != bArr2[i4]) {
                    i3 = iArr[i3 - 1];
                }
                if (bArr2[i3] == bArr2[i4]) {
                    i3++;
                }
                iArr[i4] = i3;
            }
        } catch (Exception unused) {
        }
        if (bArr.length == 0 || i >= bArr.length) {
            return -1;
        }
        while (i < bArr.length) {
            while (i2 > 0 && bArr2[i2] != bArr[i]) {
                i2 = iArr[i2 - 1];
            }
            if (bArr2[i2] == bArr[i]) {
                i2++;
            }
            if (i2 == bArr2.length) {
                return (i - bArr2.length) + 1;
            }
            i++;
        }
        return -1;
    }

    public static boolean isNetworkConnected(Context context) {
        NetworkInfo networkInfo = getNetworkInfo(context);
        if (networkInfo != null && networkInfo.isConnected()) {
            return true;
        }
        return false;
    }

    public static boolean isWifiConnected(Context context) {
        NetworkInfo networkInfo = getNetworkInfo(context);
        if (networkInfo != null && networkInfo.isConnected() && networkInfo.getType() == 1) {
            return true;
        }
        return false;
    }

    public static String parseByte2HexStr(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() == 1) {
                hexString = '0' + hexString;
            }
            sb.append(hexString.toUpperCase());
        }
        return sb.toString();
    }

    public static byte[] parseHexStr2Byte(String str) {
        if (str.length() < 1) {
            return null;
        }
        byte[] bArr = new byte[str.length() / 2];
        for (int i = 0; i < str.length() / 2; i++) {
            int i2 = i * 2;
            int i3 = i2 + 1;
            bArr[i] = (byte) ((Integer.parseInt(str.substring(i2, i3), 16) * 16) + Integer.parseInt(str.substring(i3, i2 + 2), 16));
        }
        return bArr;
    }

    public static boolean ping6(String str) {
        try {
            String str2 = "ping6 -c 1 -W 1 " + str;
            Process exec = Runtime.getRuntime().exec(str2);
            Process exec2 = Runtime.getRuntime().exec(str2);
            Process exec3 = Runtime.getRuntime().exec(str2);
            int waitFor = exec.waitFor();
            int waitFor2 = exec2.waitFor();
            int waitFor3 = exec3.waitFor();
            if (waitFor != 0 && waitFor2 != 0 && waitFor3 != 0) {
                LoggerProxy.d("ping6", " status = " + waitFor + " status1 = " + waitFor2 + " status2 =" + waitFor3);
                return false;
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } catch (InterruptedException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static byte[] shortArrayToByteArray(short[] sArr) {
        int length = sArr.length;
        ByteBuffer allocate = ByteBuffer.allocate(sArr.length * 2);
        allocate.clear();
        allocate.order(ByteOrder.nativeOrder());
        for (int i = 0; i < length; i++) {
            allocate.putShort(i * 2, sArr[i]);
        }
        return allocate.array();
    }

    public static String urlEncoded(HashMap<String, String> hashMap) throws UnsupportedEncodingException {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (String str : hashMap.keySet()) {
            String str2 = hashMap.get(str);
            if (str2 == null) {
                str2 = "";
            }
            if (i == 0) {
                sb.append(String.format("%s=%s", str, URLEncoder.encode(str2, "utf-8")));
            } else {
                sb.append(String.format("&%s=%s", str, URLEncoder.encode(str2, "utf-8")));
            }
            i++;
        }
        return sb.toString();
    }
}
