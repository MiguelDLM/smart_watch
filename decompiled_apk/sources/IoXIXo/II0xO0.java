package IoXIXo;

import com.octopus.ad.internal.b.p;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* loaded from: classes11.dex */
public class II0xO0 implements O0IxXx.oIX0oI {

    /* renamed from: I0Io, reason: collision with root package name */
    public RandomAccessFile f811I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public File f812II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final oIX0oI f813oIX0oI;

    public II0xO0(File file, oIX0oI oix0oi) throws p {
        File file2;
        String str;
        try {
            if (oix0oi != null) {
                this.f813oIX0oI = oix0oi;
                oxoX.oIX0oI(file.getParentFile());
                boolean exists = file.exists();
                if (exists) {
                    file2 = file;
                } else {
                    file2 = new File(file.getParentFile(), file.getName() + ".download");
                }
                this.f812II0xO0 = file2;
                File file3 = this.f812II0xO0;
                if (exists) {
                    str = "r";
                } else {
                    str = "rw";
                }
                this.f811I0Io = new RandomAccessFile(file3, str);
                return;
            }
            throw new NullPointerException();
        } catch (IOException e) {
            throw new p("Error using file " + file + " as disc cache", e);
        }
    }

    @Override // O0IxXx.oIX0oI
    public synchronized long a() throws p {
        try {
        } catch (IOException e) {
            throw new p("Error reading length of file " + this.f812II0xO0, e);
        }
        return (int) this.f811I0Io.length();
    }

    @Override // O0IxXx.oIX0oI
    public synchronized void b() throws p {
        try {
            this.f811I0Io.close();
            this.f813oIX0oI.a(this.f812II0xO0);
        } catch (IOException e) {
            throw new p("Error closing file " + this.f812II0xO0, e);
        }
    }

    @Override // O0IxXx.oIX0oI
    public synchronized void c() throws p {
        if (d()) {
            return;
        }
        b();
        File file = new File(this.f812II0xO0.getParentFile(), this.f812II0xO0.getName().substring(0, this.f812II0xO0.getName().length() - 9));
        if (this.f812II0xO0.renameTo(file)) {
            this.f812II0xO0 = file;
            try {
                this.f811I0Io = new RandomAccessFile(this.f812II0xO0, "r");
                this.f813oIX0oI.a(this.f812II0xO0);
                return;
            } catch (IOException e) {
                throw new p("Error opening " + this.f812II0xO0 + " as disc cache", e);
            }
        }
        throw new p("Error renaming file " + this.f812II0xO0 + " to " + file + " for completion!");
    }

    @Override // O0IxXx.oIX0oI
    public synchronized boolean d() {
        return !oIX0oI(this.f812II0xO0);
    }

    public final boolean oIX0oI(File file) {
        return file.getName().endsWith(".download");
    }

    @Override // O0IxXx.oIX0oI
    public synchronized int a(byte[] bArr, long j, int i) throws p {
        try {
            this.f811I0Io.seek(j);
        } catch (IOException e) {
            throw new p(String.format("Error reading %d bytes with offset %d from file[%d bytes] to buffer[%d bytes]", Integer.valueOf(i), Long.valueOf(j), Long.valueOf(a()), Integer.valueOf(bArr.length)), e);
        }
        return this.f811I0Io.read(bArr, 0, i);
    }

    @Override // O0IxXx.oIX0oI
    public synchronized void a(byte[] bArr, int i) throws p {
        try {
            if (!d()) {
                this.f811I0Io.seek(a());
                this.f811I0Io.write(bArr, 0, i);
            } else {
                throw new p("Error append cache: cache file " + this.f812II0xO0 + " is completed!");
            }
        } catch (IOException e) {
            throw new p(String.format("Error writing %d bytes to %s from buffer with size %d", Integer.valueOf(i), this.f811I0Io, Integer.valueOf(bArr.length)), e);
        }
    }
}
