package jxl.write.biff;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;

/* loaded from: classes6.dex */
public class ooXIXxIX implements XIxXXX0x0 {

    /* renamed from: I0Io, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f28928I0Io = XxIIOXIXx.X0o0xo.Oxx0IOOO(ooXIXxIX.class);

    /* renamed from: II0xO0, reason: collision with root package name */
    public RandomAccessFile f28929II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public File f28930oIX0oI;

    public ooXIXxIX(File file) throws IOException {
        File createTempFile = File.createTempFile("jxl", ".tmp", file);
        this.f28930oIX0oI = createTempFile;
        createTempFile.deleteOnExit();
        this.f28929II0xO0 = new RandomAccessFile(this.f28930oIX0oI, "rw");
    }

    @Override // jxl.write.biff.XIxXXX0x0
    public void II0xO0(OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[1024];
        this.f28929II0xO0.seek(0L);
        while (true) {
            int read = this.f28929II0xO0.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    @Override // jxl.write.biff.XIxXXX0x0
    public void close() throws IOException {
        this.f28929II0xO0.close();
        this.f28930oIX0oI.delete();
    }

    @Override // jxl.write.biff.XIxXXX0x0
    public int getPosition() throws IOException {
        return (int) this.f28929II0xO0.getFilePointer();
    }

    @Override // jxl.write.biff.XIxXXX0x0
    public void oIX0oI(byte[] bArr, int i) throws IOException {
        long filePointer = this.f28929II0xO0.getFilePointer();
        this.f28929II0xO0.seek(i);
        this.f28929II0xO0.write(bArr);
        this.f28929II0xO0.seek(filePointer);
    }

    @Override // jxl.write.biff.XIxXXX0x0
    public void write(byte[] bArr) throws IOException {
        this.f28929II0xO0.write(bArr);
    }
}
