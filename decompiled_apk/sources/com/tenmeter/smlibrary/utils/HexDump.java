package com.tenmeter.smlibrary.utils;

import java.io.IOException;
import java.io.StringReader;

/* loaded from: classes13.dex */
public class HexDump {
    private static final char[] m_hexCodes = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final int[] m_shifts = {60, 56, 52, 48, 44, 40, 36, 32, 28, 24, 20, 16, 12, 8, 4, 0};

    private static int charToNumber(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        if (c >= 'a' && c <= 'f') {
            return c - 'W';
        }
        if (c < 'A' || c > 'F') {
            return -1;
        }
        return c - '7';
    }

    public static byte[] restoreBytes(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            int charToNumber = charToNumber(str.charAt(i2));
            int charToNumber2 = charToNumber(str.charAt(i2 + 1));
            if (charToNumber != -1 && charToNumber2 != -1) {
                bArr[i] = (byte) ((charToNumber << 4) + charToNumber2);
            } else {
                return null;
            }
        }
        return bArr;
    }

    public static String tablify(byte[] bArr) {
        return new HexTablifier().format(toHex(bArr));
    }

    private static String toHex(long j, int i) {
        StringBuilder sb = new StringBuilder(i);
        for (int i2 = 0; i2 < i; i2++) {
            sb.append(m_hexCodes[(int) ((j >> m_shifts[(16 - i) + i2]) & 15)]);
        }
        return sb.toString();
    }

    public static String tablify(byte[] bArr, int i) {
        return new HexTablifier(new HexDump(), i).format(toHex(bArr));
    }

    /* loaded from: classes13.dex */
    public class HexTablifier {
        private String m_post;
        private String m_pre;
        private int m_row;

        public HexTablifier() {
            this.m_row = 8;
            this.m_pre = "";
            this.m_post = "\n";
        }

        private boolean getHexByte(StringBuilder sb, StringReader stringReader) throws IOException {
            char[] cArr = new char[4];
            int read = stringReader.read(cArr);
            if (read == -1) {
                return false;
            }
            sb.append(cArr, 0, read);
            sb.append(" ");
            if (read != 4) {
                return false;
            }
            return true;
        }

        private boolean getHexLine(StringBuilder sb, StringReader stringReader) throws IOException {
            StringBuilder sb2 = new StringBuilder();
            boolean z = true;
            for (int i = 0; i < this.m_row && (z = getHexByte(sb2, stringReader)); i++) {
            }
            if (sb2.length() > 0) {
                sb.append(this.m_pre);
                sb.append((CharSequence) sb2);
                sb.append(this.m_post);
            }
            return z;
        }

        public String format(String str) {
            StringReader stringReader = new StringReader(str);
            StringBuilder sb = new StringBuilder(str.length() * 2);
            do {
            } while (getHexLine(sb, stringReader));
            return sb.toString();
        }

        public HexTablifier(HexDump hexDump, int i) {
            this(i, "", "\n");
        }

        public HexTablifier(HexDump hexDump, int i, String str) {
            this(i, str, "\n");
        }

        public HexTablifier(int i, String str, String str2) {
            this.m_row = i;
            this.m_pre = str;
            this.m_post = str2;
        }
    }

    public static String tablify(byte[] bArr, int i, String str) {
        return new HexTablifier(new HexDump(), i, str).format(toHex(bArr));
    }

    public static String toHex(byte b) {
        return toHex(b, 2);
    }

    public static String toHex(short s) {
        return toHex(s, 4);
    }

    public static String toHex(int i) {
        return toHex(i, 8);
    }

    public static String tablify(String str, int i, String str2, String str3) {
        return new HexTablifier(i, str2, str3).format(str);
    }

    public static String toHex(long j) {
        return toHex(j, 16);
    }

    public static String toHex(byte[] bArr) {
        return toHex(bArr, 0, bArr.length);
    }

    public static String toHex(byte[] bArr, int i, int i2) {
        StringBuilder sb = new StringBuilder();
        int i3 = i2 + i;
        while (i < i3) {
            sb.append(toHex(bArr[i]));
            i++;
        }
        return sb.toString();
    }
}
