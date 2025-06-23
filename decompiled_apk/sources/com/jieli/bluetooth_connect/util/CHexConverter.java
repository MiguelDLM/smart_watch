package com.jieli.bluetooth_connect.util;

import android.text.TextUtils;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.tencent.connect.common.II0xO0;
import java.io.UnsupportedEncodingException;
import java.util.Locale;
import oOoIIO0.oIX0oI;

/* loaded from: classes10.dex */
public class CHexConverter {
    private static final char[] mChars = "0123456789ABCDEF".toCharArray();
    private static final String mHexStr = "0123456789ABCDEF";

    public static String byte2HexStr(byte[] b) {
        if (b == null) {
            return "";
        }
        return byte2HexStr(b, b.length);
    }

    public static String byte2String(byte[] b, int len) {
        if (b == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append(String.valueOf((int) b[i]));
        }
        return sb.toString();
    }

    public static String byteToBit(byte b) {
        return "" + ((int) ((byte) ((b >> 7) & 1))) + ((int) ((byte) ((b >> 6) & 1))) + ((int) ((byte) ((b >> 5) & 1))) + ((int) ((byte) ((b >> 4) & 1))) + ((int) ((byte) ((b >> 3) & 1))) + ((int) ((byte) ((b >> 2) & 1))) + ((int) ((byte) ((b >> 1) & 1))) + ((int) ((byte) (b & 1)));
    }

    public static String byteToHexString(byte b) {
        return intToHexString(b & 255);
    }

    public static int byteToInt(byte b) {
        return b & 255;
    }

    public static int bytesToInt(byte h, byte l) {
        return ((h & 255) << 8) + (l & 255);
    }

    public static long bytesToLong(byte[] data, int start, int len) {
        long j = 0;
        int i = 0;
        int i2 = start;
        while (i2 < start + len) {
            j |= (data[i2] & 255) << (((len - 1) - i) * 8);
            i2++;
            i++;
        }
        return j;
    }

    public static short bytesToShort(byte h, byte l) {
        return (short) bytesToInt(h, l);
    }

    public static String bytesToStr(byte[] data) {
        if (data == null) {
            return "";
        }
        return hexStr2Str(byte2HexStr(data, data.length));
    }

    public static boolean checkBitValue(byte value, int bit) {
        return bit >= 0 && bit <= 7 && ((value >> bit) & 1) == 1;
    }

    public static boolean checkHexStr(String sHex) {
        String upperCase;
        int length;
        if (sHex == null || (length = (upperCase = sHex.trim().replace(" ", "").toUpperCase(Locale.US)).length()) <= 1 || length % 2 != 0) {
            return false;
        }
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            if (!"0123456789ABCDEF".contains(upperCase.substring(i, i2))) {
                return false;
            }
            i = i2;
        }
        return true;
    }

    public static byte decodeBinaryString(String byteStr) {
        int parseInt;
        if (byteStr == null) {
            return (byte) 0;
        }
        int length = byteStr.length();
        if (length != 4 && length != 8) {
            return (byte) 0;
        }
        if (length == 8) {
            if (byteStr.charAt(0) == '0') {
                parseInt = Integer.parseInt(byteStr, 2);
            } else {
                parseInt = Integer.parseInt(byteStr, 2) - 256;
            }
        } else {
            parseInt = Integer.parseInt(byteStr, 2);
        }
        return (byte) parseInt;
    }

    public static byte decodeHexChar(char hChar, char lChar) {
        String hexChar2BinaryString = hexChar2BinaryString(hChar);
        String hexChar2BinaryString2 = hexChar2BinaryString(lChar);
        if (TextUtils.isEmpty(hexChar2BinaryString)) {
            hexChar2BinaryString = "";
        }
        if (!TextUtils.isEmpty(hexChar2BinaryString2)) {
            hexChar2BinaryString = hexChar2BinaryString + hexChar2BinaryString2;
        }
        if (TextUtils.isEmpty(hexChar2BinaryString)) {
            return (byte) 0;
        }
        return decodeBinaryString(hexChar2BinaryString);
    }

    public static int getBitByPosition(int src, int pos) {
        if (pos < 0 || pos >= 32) {
            return 0;
        }
        return (src >> pos) & 1;
    }

    public static byte[] getBooleanArray(byte b) {
        byte[] bArr = new byte[8];
        for (int i = 7; i >= 0; i--) {
            bArr[i] = (byte) (b & 1);
            b = (byte) (b >> 1);
        }
        return bArr;
    }

    public static byte[] getBooleanArrayBig(byte b) {
        byte[] bArr = new byte[8];
        for (int i = 0; i < 8; i++) {
            bArr[i] = (byte) (b & 1);
            b = (byte) (b >> 1);
        }
        return bArr;
    }

    private static String hexChar2BinaryString(char src) {
        if (src == '0') {
            return "0000";
        }
        if (src == '1') {
            return "0001";
        }
        if (src == '2') {
            return "0010";
        }
        if (src == '3') {
            return "0011";
        }
        if (src == '4') {
            return "0100";
        }
        if (src == '5') {
            return "0101";
        }
        if (src == '6') {
            return "0110";
        }
        if (src == '7') {
            return "0111";
        }
        if (src == '8') {
            return II0xO0.f26842oIX0oI;
        }
        if (src == '9') {
            return oIX0oI.f32056oIX0oI;
        }
        if (src != 'A' && src != 'a') {
            if (src != 'B' && src != 'b') {
                if (src != 'C' && src != 'c') {
                    if (src != 'D' && src != 'd') {
                        if (src != 'E' && src != 'e') {
                            if (src != 'F' && src != 'f') {
                                return "";
                            }
                            return "1111";
                        }
                        return "1110";
                    }
                    return "1101";
                }
                return "1100";
            }
            return "1011";
        }
        return "1010";
    }

    public static byte[] hexStr2Bytes(String src) {
        if (src == null) {
            return null;
        }
        String upperCase = src.trim().replace(" ", "").toUpperCase(Locale.US);
        int length = upperCase.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            int i3 = i2 + 1;
            bArr[i] = (byte) (Integer.decode(HexStringBuilder.DEFAULT_PREFIX + upperCase.substring(i2, i3) + upperCase.substring(i3, i2 + 2)).intValue() & 255);
        }
        return bArr;
    }

    public static String hexStr2Str(String hexStr) {
        if (hexStr == null) {
            return null;
        }
        String upperCase = hexStr.trim().replace(" ", "").toUpperCase(Locale.US);
        char[] charArray = upperCase.toCharArray();
        int length = upperCase.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) (("0123456789ABCDEF".indexOf(charArray[i2 + 1]) | ("0123456789ABCDEF".indexOf(charArray[i2]) << 4)) & 255);
        }
        try {
            return new String(bArr, "GBK");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String int2HexStr(int[] b, int iLen) {
        if (b == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iLen; i++) {
            char[] cArr = mChars;
            sb.append(cArr[(((byte) b[i]) & 255) >> 4]);
            sb.append(cArr[((byte) b[i]) & 15]);
        }
        return sb.toString().trim().toUpperCase(Locale.US);
    }

    public static byte[] int2byte2(int res) {
        return new byte[]{(byte) ((res >> 8) & 255), (byte) (res & 255)};
    }

    public static byte[] intToBigBytes(int n) {
        return new byte[]{(byte) ((n >> 24) & 255), (byte) ((n >> 16) & 255), (byte) ((n >> 8) & 255), (byte) (n & 255)};
    }

    public static byte intToByte(int num) {
        return (byte) num;
    }

    public static byte[] intToBytes(int n) {
        return new byte[]{(byte) (n & 255), (byte) ((n >> 8) & 255), (byte) ((n >> 16) & 255), (byte) ((n >> 24) & 255)};
    }

    public static String intToHexString(int num) {
        return String.format(Locale.ENGLISH, "%02x", Integer.valueOf(num));
    }

    public static byte setBitValue(byte value, int bit, boolean result) {
        if (bit < 0 || bit > 7) {
            return value;
        }
        return (byte) (result ? value | (1 << bit) : value & (~(1 << bit)));
    }

    public static byte[] shortToBigBytes(short n) {
        return new byte[]{(byte) ((n >> 8) & 255), (byte) (n & 255)};
    }

    public static byte[] shortToBytes(short n) {
        return new byte[]{(byte) (n & 255), (byte) ((n >> 8) & 255)};
    }

    public static String str2HexStr(String str) {
        byte[] bArr = null;
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        try {
            bArr = str.getBytes("GBK");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (bArr == null) {
            return "";
        }
        for (byte b : bArr) {
            char[] cArr = mChars;
            sb.append(cArr[(b & 255) >> 4]);
            sb.append(cArr[b & 15]);
        }
        return sb.toString().trim();
    }

    public static String strToUnicode(String strText) {
        if (strText == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strText.length(); i++) {
            char charAt = strText.charAt(i);
            String hexString = Integer.toHexString(charAt);
            if (charAt > 128) {
                sb.append("\\u");
            } else {
                sb.append("\\u00");
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    public static String unicodeToString(String hex) {
        if (hex == null) {
            return null;
        }
        int length = hex.length() / 6;
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < length) {
            int i2 = i * 6;
            i++;
            String substring = hex.substring(i2, i * 6);
            sb.append(new String(Character.toChars(Integer.valueOf(substring.substring(4), 16).intValue() | (Integer.valueOf(substring.substring(2, 4), 16).intValue() << 8))));
        }
        return sb.toString();
    }

    public static int writeBitValue(int value, int bit, boolean result) {
        return (bit < 0 || bit > 31) ? value : result ? value | (1 << bit) : value & (~(1 << bit));
    }

    public static int bytesToInt(byte[] data, int start, int len) {
        if (len == 4) {
            byte[] bArr = new byte[4];
            System.arraycopy(data, start, bArr, 0, len);
            return bytesToInt(bArr);
        }
        if (len == 2) {
            return bytesToInt(data[start], data[start + 1]);
        }
        return 0;
    }

    public static boolean checkBitValue(int value, int bit) {
        return bit >= 0 && bit <= 31 && ((value >> bit) & 1) == 1;
    }

    public static String byte2HexStr(byte[] b, int iLen) {
        if (b == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iLen; i++) {
            char[] cArr = mChars;
            sb.append(cArr[(b[i] & 255) >> 4]);
            sb.append(cArr[b[i] & 15]);
        }
        return sb.toString().trim().toUpperCase(Locale.US);
    }

    public static int bytesToInt(byte[] value) {
        if (value == null || value.length < 4) {
            return 0;
        }
        return (value[3] & 255) | ((value[0] & 255) << 24) | ((value[1] & 255) << 16) | ((value[2] & 255) << 8);
    }
}
