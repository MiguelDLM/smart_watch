package com.jieli.jl_bt_ota.util;

import com.jieli.jl_bt_ota.constant.BluetoothConstant;
import com.jieli.jl_bt_ota.model.BleScanMessage;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* loaded from: classes10.dex */
public class ParseDataUtil {

    /* renamed from: a, reason: collision with root package name */
    private static final String f17814a = "ParseDataUtil";
    private static final char[] b = "0123456789ABCDEF".toCharArray();

    static {
        System.loadLibrary(BluetoothConstant.JL_AUTH);
    }

    private static byte[] a(byte[] bArr) {
        if (bArr != null && bArr.length > 1) {
            byte[] bArr2 = new byte[bArr.length];
            for (int i = 0; i < bArr.length; i++) {
                bArr2[i] = bArr[(bArr.length - i) - 1];
            }
            return bArr2;
        }
        return bArr;
    }

    public static int filterFile(byte[] bArr, int i, int i2) {
        return nativeFilterFile(bArr, i, i2, 0);
    }

    public static String hexDataCovetToAddress(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        if (bArr != null && bArr.length == 6) {
            for (int i = 0; i < bArr.length; i++) {
                char[] cArr = b;
                sb.append(cArr[(bArr[i] & 255) >> 4]);
                sb.append(cArr[bArr[i] & 15]);
                if (i != bArr.length - 1) {
                    sb.append(":");
                }
            }
        }
        return sb.toString();
    }

    private static native int nativeFilterFile(byte[] bArr, int i, int i2, int i3);

    public static BleScanMessage parseOTAFlagFilterWithBroad(byte[] bArr, String str) {
        BleScanMessage bleScanMessage = null;
        if (bArr != null && bArr.length > 2) {
            int i = 0;
            while (true) {
                int i2 = i + 2;
                if (i2 <= bArr.length) {
                    int byteToInt = CHexConver.byteToInt(bArr[i]);
                    if (byteToInt == 0) {
                        i++;
                    } else {
                        if (byteToInt < 1) {
                            break;
                        }
                        int i3 = i + 1;
                        if (i3 + byteToInt >= bArr.length) {
                            break;
                        }
                        if (CHexConver.byteToInt(bArr[i3]) == 255) {
                            int i4 = byteToInt - 1;
                            byte[] bArr2 = new byte[i4];
                            System.arraycopy(bArr, i2, bArr2, 0, i4);
                            bleScanMessage = parseWithOTAFlagFilter(bArr2, str);
                            if (bleScanMessage != null) {
                                break;
                            }
                        }
                        i += byteToInt + 1;
                    }
                } else {
                    break;
                }
            }
        }
        return bleScanMessage;
    }

    public static BleScanMessage parseWithOTAFlagFilter(byte[] bArr, String str) {
        if (bArr == null || str == null || str.length() == 0 || bArr.length <= str.getBytes().length + 2) {
            return null;
        }
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        wrap.order(ByteOrder.LITTLE_ENDIAN);
        short s = wrap.getShort();
        byte[] bArr2 = new byte[str.getBytes().length];
        ByteBuffer byteBuffer = wrap.get(bArr2);
        byte[] a2 = a(bArr2);
        if (!Arrays.equals(a2, str.getBytes())) {
            JL_Log.i(f17814a, CommonUtil.formatString("parseWithOTAFlagFilter :: flag not match. adv flag : %s, flag : %s", CHexConver.byte2HexStr(a2), CHexConver.byte2HexStr(str.getBytes())));
            return null;
        }
        int byteToInt = CHexConver.byteToInt(byteBuffer.get());
        if (byteToInt != 1) {
            byte[] bArr3 = new byte[6];
            ByteBuffer byteBuffer2 = byteBuffer.get(bArr3);
            String hexDataCovetToAddress = hexDataCovetToAddress(a(bArr3));
            byteBuffer2.get(new byte[byteBuffer2.remaining()]);
            return new BleScanMessage().setVid(s).setOTA(true).setIdentify(str).setVersion(byteToInt).setOldBleAddress(hexDataCovetToAddress);
        }
        byte[] bArr4 = new byte[6];
        ByteBuffer byteBuffer3 = byteBuffer.get(bArr4);
        String hexDataCovetToAddress2 = hexDataCovetToAddress(a(bArr4));
        short s2 = byteBuffer3.getShort();
        short s3 = byteBuffer3.getShort();
        byte b2 = byteBuffer3.get();
        int byteToInt2 = CHexConver.byteToInt(byteBuffer3.get());
        byteBuffer3.get(new byte[byteBuffer3.remaining()]);
        return new BleScanMessage().setOTA(true).setIdentify(str).setVersion(byteToInt).setOldBleAddress(hexDataCovetToAddress2).setVid(s).setUid(s2).setPid(s3).setDeviceType((b2 >> 4) & 255).setDeviceVersion(b2 & 15).setBattery(byteToInt2);
    }
}
