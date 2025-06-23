package x0;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.digest.MessageDigestAlgorithms;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes11.dex */
public class oo0xXOI0I {
    public static String I0Io(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_1);
            messageDigest.update(str.getBytes());
            return oIX0oI(messageDigest.digest());
        } catch (NoSuchAlgorithmException unused) {
            return "";
        }
    }

    public static String II0xO0(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            return oIX0oI(messageDigest.digest());
        } catch (NoSuchAlgorithmException unused) {
            return "";
        }
    }

    public static String oIX0oI(byte[] bArr) {
        int i;
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            int i2 = (b >>> 4) & 15;
            int i3 = 0;
            while (true) {
                if (i2 >= 0 && i2 <= 9) {
                    i = i2 + 48;
                } else {
                    i = i2 + 87;
                }
                sb.append((char) i);
                i2 = b & 15;
                int i4 = i3 + 1;
                if (i3 >= 1) {
                    break;
                }
                i3 = i4;
            }
        }
        return sb.toString();
    }
}
