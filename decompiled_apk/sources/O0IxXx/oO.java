package O0IxXx;

import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import java.io.Closeable;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes11.dex */
public class oO {
    public static void I0Io(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                com.octopus.ad.internal.utilities.oIX0oI.X0o0xo(com.octopus.ad.internal.utilities.oIX0oI.f18694OxxIIOOXO, "Error closing resource", e);
            }
        }
    }

    public static String II0xO0(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : bArr) {
            stringBuffer.append(String.format("%02x", Byte.valueOf(b)));
        }
        return stringBuffer.toString();
    }

    public static String Oxx0IOOO(String str) {
        try {
            return II0xO0(MessageDigest.getInstance("MD5").digest(str.getBytes()));
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e);
        }
    }

    public static String X0o0xo(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Error encoding url", e);
        }
    }

    public static String XO(String str) {
        try {
            return URLDecoder.decode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Error decoding url", e);
        }
    }

    public static String oIX0oI(String str) {
        MimeTypeMap singleton = MimeTypeMap.getSingleton();
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str);
        if (TextUtils.isEmpty(fileExtensionFromUrl)) {
            return null;
        }
        return singleton.getMimeTypeFromExtension(fileExtensionFromUrl);
    }

    public static void oxoX(byte[] bArr, long j, int i) {
        boolean z;
        ooOOo0oXI.II0xO0(bArr, "Buffer must be not null!");
        boolean z2 = false;
        if (j >= 0) {
            z = true;
        } else {
            z = false;
        }
        ooOOo0oXI.oxoX(z, "Data offset must be positive!");
        if (i >= 0 && i <= bArr.length) {
            z2 = true;
        }
        ooOOo0oXI.oxoX(z2, "Length must be in range [0..buffer.length]");
    }
}
