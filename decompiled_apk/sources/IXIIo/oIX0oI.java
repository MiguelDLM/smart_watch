package IXIIo;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes6.dex */
public class oIX0oI extends InputStream {

    /* renamed from: Oo, reason: collision with root package name */
    public int f700Oo = 0;

    /* renamed from: XO, reason: collision with root package name */
    public InputStream f701XO;

    public oIX0oI(InputStream inputStream) {
        this.f701XO = inputStream;
    }

    public void II0xO0() {
        this.f700Oo = 0;
    }

    public int oIX0oI() {
        return this.f700Oo;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        int read = this.f701XO.read();
        if (read != -1) {
            this.f700Oo++;
        }
        return read;
    }
}
