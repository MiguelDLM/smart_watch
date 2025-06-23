package I00O;

import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;

/* loaded from: classes13.dex */
public class oIX0oI {

    /* renamed from: II0xO0, reason: collision with root package name */
    public int f56II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final char[] f57oIX0oI;

    public oIX0oI(int i) {
        this.f56II0xO0 = -1;
        if (i > 0) {
            this.f57oIX0oI = new char[i];
        } else {
            this.f57oIX0oI = new char[0];
        }
    }

    public boolean II0xO0() {
        if (this.f56II0xO0 <= 0) {
            return true;
        }
        return false;
    }

    public int oIX0oI(Reader reader) throws IOException {
        char[] cArr = this.f57oIX0oI;
        int read = reader.read(cArr, 0, cArr.length);
        this.f56II0xO0 = read;
        return read;
    }

    public oIX0oI(int i, char c) {
        this(i);
        if (i > 0) {
            Arrays.fill(this.f57oIX0oI, c);
        }
    }
}
