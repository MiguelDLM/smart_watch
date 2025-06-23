package XxXX;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.ProtocolException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Properties;
import java.util.zip.ZipException;

/* loaded from: classes13.dex */
public final class oIX0oI {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final xoIox f4227oIX0oI = new xoIox(101010256);

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final OOXIXo f4226II0xO0 = new OOXIXo(38651);

    /* loaded from: classes13.dex */
    public static class II0xO0 {

        /* renamed from: II0xO0, reason: collision with root package name */
        public byte[] f4228II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public Properties f4229oIX0oI;

        public II0xO0() {
            this.f4229oIX0oI = new Properties();
        }

        public void oIX0oI(byte[] bArr) throws IOException {
            if (bArr == null) {
                return;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            int length = oIX0oI.f4226II0xO0.oIX0oI().length;
            byte[] bArr2 = new byte[length];
            wrap.get(bArr2);
            if (oIX0oI.f4226II0xO0.equals(new OOXIXo(bArr2))) {
                if (bArr.length - length <= 2) {
                    return;
                }
                byte[] bArr3 = new byte[2];
                wrap.get(bArr3);
                int II0xO02 = new OOXIXo(bArr3).II0xO0();
                if ((bArr.length - length) - 2 < II0xO02) {
                    return;
                }
                byte[] bArr4 = new byte[II0xO02];
                wrap.get(bArr4);
                this.f4229oIX0oI.load(new ByteArrayInputStream(bArr4));
                int length2 = ((bArr.length - length) - II0xO02) - 2;
                if (length2 > 0) {
                    byte[] bArr5 = new byte[length2];
                    this.f4228II0xO0 = bArr5;
                    wrap.get(bArr5);
                    return;
                }
                return;
            }
            throw new ProtocolException("unknow protocl [" + Arrays.toString(bArr) + "]");
        }

        public String toString() {
            return "ApkExternalInfo [p=" + this.f4229oIX0oI + ", otherData=" + Arrays.toString(this.f4228II0xO0) + "]";
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String I0Io(File file, String str) throws IOException {
        RandomAccessFile randomAccessFile = null;
        Object[] objArr = 0;
        try {
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, "r");
            try {
                byte[] oxoX2 = oxoX(randomAccessFile2);
                if (oxoX2 == null) {
                    randomAccessFile2.close();
                    return null;
                }
                II0xO0 iI0xO0 = new II0xO0();
                iI0xO0.oIX0oI(oxoX2);
                String property = iI0xO0.f4229oIX0oI.getProperty(str);
                randomAccessFile2.close();
                return property;
            } catch (Throwable th) {
                th = th;
                randomAccessFile = randomAccessFile2;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String II0xO0(File file) throws IOException {
        return I0Io(file, "channelNo");
    }

    public static byte[] oxoX(RandomAccessFile randomAccessFile) throws IOException {
        long length = randomAccessFile.length() - 22;
        randomAccessFile.seek(length);
        byte[] oIX0oI2 = f4227oIX0oI.oIX0oI();
        int read = randomAccessFile.read();
        while (read != -1) {
            if (read == oIX0oI2[0] && randomAccessFile.read() == oIX0oI2[1] && randomAccessFile.read() == oIX0oI2[2] && randomAccessFile.read() == oIX0oI2[3]) {
                randomAccessFile.seek(length + 20);
                byte[] bArr = new byte[2];
                randomAccessFile.readFully(bArr);
                int II0xO02 = new OOXIXo(bArr).II0xO0();
                if (II0xO02 == 0) {
                    return null;
                }
                byte[] bArr2 = new byte[II0xO02];
                randomAccessFile.read(bArr2);
                return bArr2;
            }
            length--;
            randomAccessFile.seek(length);
            read = randomAccessFile.read();
        }
        throw new ZipException("archive is not a ZIP archive");
    }
}
