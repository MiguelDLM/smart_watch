package x0oox0;

import java.io.IOException;
import java.io.Reader;

/* loaded from: classes13.dex */
public class X0o0xo extends oIX0oI {

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public Reader f34017oI0IIXIo;

    public X0o0xo(char c, int i) {
        super(c);
        this.f34034x0xO0oo = new char[i];
    }

    @Override // x0oox0.oIX0oI
    public void O0xOxO(Reader reader) {
        this.f34017oI0IIXIo = reader;
    }

    @Override // x0oox0.oIX0oI
    public void o00() {
        try {
            Reader reader = this.f34017oI0IIXIo;
            char[] cArr = this.f34034x0xO0oo;
            this.f34023Oo = reader.read(cArr, 0, cArr.length);
        } catch (IOException e) {
            throw new IllegalStateException("Error reading from input", e);
        }
    }

    @Override // x0oox0.I0Io
    public void stop() {
        try {
            Reader reader = this.f34017oI0IIXIo;
            if (reader != null) {
                reader.close();
            }
        } catch (IOException e) {
            throw new IllegalStateException("Error closing input", e);
        }
    }

    public X0o0xo(char[] cArr, char c, int i) {
        super(cArr, c);
        this.f34034x0xO0oo = new char[i];
    }
}
