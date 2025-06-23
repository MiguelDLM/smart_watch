package XxXX;

import android.util.Base64;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.digest.MessageDigestAlgorithms;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes13.dex */
public class oxoX {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static byte[] f4231oIX0oI = {1, 2, 3, 4, 5, 6, 7, 8};

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final char[] f4230II0xO0 = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String I0Io(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            char[] cArr = new char[bArr.length * 2];
            for (int i = 0; i < bArr.length; i++) {
                byte b = bArr[i];
                int i2 = i * 2;
                char[] cArr2 = f4230II0xO0;
                cArr[i2 + 1] = cArr2[b & 15];
                cArr[i2] = cArr2[((byte) (b >>> 4)) & 15];
            }
            return new String(cArr);
        }
        return "";
    }

    public static String II0xO0(String str, String str2, byte[] bArr) {
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr);
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(1, secretKeySpec, ivParameterSpec);
            return Base64.encodeToString(cipher.doFinal(str.getBytes()), 0);
        } catch (Exception e) {
            xx0.xxIXOIIO.xxIXOIIO("DESUtils", "encryptAES", e);
            return null;
        }
    }

    public static String Oxx0IOOO(String str, String str2) {
        return XO(str, str2, f4231oIX0oI);
    }

    public static String X0o0xo(String str, String str2) {
        return II0xO0(str, str2, f4231oIX0oI);
    }

    public static String XO(String str, String str2, byte[] bArr) {
        try {
            byte[] decode = Base64.decode(str, 0);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr);
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(2, secretKeySpec, ivParameterSpec);
            return new String(cipher.doFinal(decode));
        } catch (Exception e) {
            xx0.xxIXOIIO.xxIXOIIO("DESUtils", "decryptAES", e);
            return null;
        }
    }

    public static String oIX0oI(String str, String str2) {
        try {
            byte[] decode = Base64.decode(str, 0);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(f4231oIX0oI);
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), "DES");
            Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
            cipher.init(2, secretKeySpec, ivParameterSpec);
            return new String(cipher.doFinal(decode));
        } catch (Exception e) {
            xx0.xxIXOIIO.xxIXOIIO("DESUtils", "decryptDES", e);
            return null;
        }
    }

    public static byte[] oxoX(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256);
            messageDigest.update(str.getBytes());
            return messageDigest.digest();
        } catch (Exception e) {
            xx0.xxIXOIIO.xxIXOIIO("DESUtils", "encryptSha", e);
            return null;
        }
    }
}
