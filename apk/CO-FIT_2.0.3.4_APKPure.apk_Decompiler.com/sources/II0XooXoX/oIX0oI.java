package II0XooXoX;

import java.nio.charset.StandardCharsets;

public class oIX0oI {
    public static byte[] oIX0oI(String str, String str2, String str3) {
        int i;
        byte[] bArr = new byte[16];
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        int i2 = 8;
        if (bytes.length >= 8) {
            for (int i3 = 0; i3 < 8; i3++) {
                bArr[i3] = bytes[i3];
            }
            byte[] bytes2 = str2.getBytes(StandardCharsets.UTF_8);
            if (bytes2.length >= 4) {
                while (true) {
                    if (i2 >= 12) {
                        break;
                    }
                    bArr[i2] = bytes2[i2 - 8];
                    i2++;
                }
                byte[] bytes3 = str3.getBytes(StandardCharsets.UTF_8);
                if (bytes3.length >= 4) {
                    for (i = 12; i < 16; i++) {
                        bArr[i] = bytes3[i - 12];
                    }
                    return bArr;
                }
                throw new Exception("pk 小于4个字节");
            }
            throw new Exception("ts 小于4个字节");
        }
        throw new Exception("sonce 小于8字节");
    }
}
