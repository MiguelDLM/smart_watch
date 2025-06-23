package xoxXI;

import com.garmin.fit.Fit;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes9.dex */
public class oxoX {
    public static void I0Io(ByteArrayOutputStream byteArrayOutputStream, String str, Boolean bool) throws Exception {
        FileOutputStream fileOutputStream = new FileOutputStream(str);
        if (bool.booleanValue()) {
            fileOutputStream.write(Fit.f11225x0);
        }
        byteArrayOutputStream.writeTo(fileOutputStream);
    }

    public static ByteArrayInputStream II0xO0(InputStream inputStream) throws IOException {
        int available = inputStream.available();
        if (available > 0) {
            byte[] bArr = new byte[available];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                int read = inputStream.read(bArr, 0, available);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                }
            }
        } else {
            return null;
        }
    }

    public static ByteArrayInputStream oIX0oI(String str) throws IOException {
        return II0xO0(new FileInputStream(str));
    }
}
