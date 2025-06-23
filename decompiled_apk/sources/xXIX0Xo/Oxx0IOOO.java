package xXIX0Xo;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes6.dex */
public abstract class Oxx0IOOO {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final int f34662oIX0oI = 2048;

    public static void I0Io(InputStream inputStream, OutputStream outputStream) throws IOException {
        oIX0oI(inputStream, outputStream);
        inputStream.close();
        outputStream.close();
    }

    public static void II0xO0(InputStream inputStream, OutputStream outputStream, int i) throws IOException {
        byte[] bArr = new byte[i];
        int read = inputStream.read(bArr);
        while (read != -1) {
            outputStream.write(bArr, 0, read);
            read = inputStream.read(bArr);
        }
        outputStream.flush();
    }

    public static void oIX0oI(InputStream inputStream, OutputStream outputStream) throws IOException {
        II0xO0(inputStream, outputStream, 2048);
    }

    public static byte[] oxoX(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        oIX0oI(inputStream, byteArrayOutputStream);
        byteArrayOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }
}
