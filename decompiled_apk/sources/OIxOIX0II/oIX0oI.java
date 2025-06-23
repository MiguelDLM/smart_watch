package OIxOIX0II;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Objects;
import org.apache.commons.text.TextStringBuilder;
import org.apache.commons.text.ooOOo0oXI;
import xOx.II0XooXoX;
import xOx.Oxx0IOOO;

/* loaded from: classes6.dex */
public class oIX0oI extends FilterReader {

    /* renamed from: IIXOooo, reason: collision with root package name */
    public static final int f1692IIXOooo = -1;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public final Oxx0IOOO f1693IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public boolean f1694Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public final char[] f1695Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public int f1696OxxIIOOXO;

    /* renamed from: XO, reason: collision with root package name */
    public final TextStringBuilder f1697XO;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public final ooOOo0oXI f1698oI0IIXIo;

    public oIX0oI(Reader reader, ooOOo0oXI ooooo0oxi) {
        super(reader);
        this.f1697XO = new TextStringBuilder();
        this.f1695Oxx0xo = new char[]{0};
        Objects.requireNonNull(ooooo0oxi);
        this.f1698oI0IIXIo = ooooo0oxi;
        this.f1693IXxxXO = II0XooXoX.f34478I0Io.II0xO0(ooooo0oxi.I0Io()).X0o0xo(ooooo0oxi.XO());
    }

    public final int I0Io(char[] cArr, int i, int i2) {
        int drainChars = this.f1697XO.drainChars(0, Math.min(this.f1697XO.length(), i2), cArr, i);
        this.f1696OxxIIOOXO -= drainChars;
        if (this.f1697XO.isEmpty() || this.f1696OxxIIOOXO == 0) {
            this.f1696OxxIIOOXO = 0;
        }
        return drainChars;
    }

    public final int II0xO0(int i, char[] cArr, int i2, int i3) throws IOException {
        return oxoX(oIX0oI(i), cArr, i2, i3);
    }

    public final int Oxx0IOOO(int i, int i2) {
        int size = this.f1697XO.size() - i2;
        if (size >= i) {
            return 0;
        }
        return i - size;
    }

    public final boolean X0o0xo(Oxx0IOOO oxx0IOOO, int i) {
        if (oxx0IOOO.II0xO0(this.f1697XO, i) == oxx0IOOO.size()) {
            return true;
        }
        return false;
    }

    public final boolean XO() {
        if (this.f1696OxxIIOOXO > 0) {
            return true;
        }
        return false;
    }

    public final int oIX0oI(int i) throws IOException {
        boolean z;
        int readFrom = this.f1697XO.readFrom(((FilterReader) this).in, i);
        if (readFrom == -1) {
            z = true;
        } else {
            z = false;
        }
        this.f1694Oo = z;
        return readFrom;
    }

    public final int oxoX(int i, char[] cArr, int i2, int i3) {
        if (i == -1) {
            if (!this.f1697XO.isNotEmpty()) {
                return -1;
            }
            this.f1696OxxIIOOXO = this.f1697XO.size();
            return I0Io(cArr, i2, i3);
        }
        return i;
    }

    @Override // java.io.FilterReader, java.io.Reader
    public int read() throws IOException {
        int read;
        do {
            read = read(this.f1695Oxx0xo, 0, 1);
            if (read == -1) {
                return -1;
            }
        } while (read < 1);
        return this.f1695Oxx0xo[0];
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x00b3, code lost:
    
        if (r6 == (-1)) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00b5, code lost:
    
        r3 = r3 + r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00b6, code lost:
    
        r3 = r3 - r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00b7, code lost:
    
        if (r3 <= 0) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00ba, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:?, code lost:
    
        return -1;
     */
    @Override // java.io.FilterReader, java.io.Reader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int read(char[] r10, int r11, int r12) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 350
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: OIxOIX0II.oIX0oI.read(char[], int, int):int");
    }
}
