package I00O;

import java.io.Reader;

/* loaded from: classes13.dex */
public class II0xO0 extends x0oox0.oIX0oI {

    /* renamed from: IIXOooo, reason: collision with root package name */
    public final int f47IIXOooo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public final int f48OxxIIOOXO;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public I0Io f49oI0IIXIo;

    public II0xO0(char c, int i, int i2) {
        super(c);
        this.f48OxxIIOOXO = i;
        this.f47IIXOooo = i2;
    }

    @Override // x0oox0.oIX0oI
    public void O0xOxO(Reader reader) {
        stop();
        this.f49oI0IIXIo = new I0Io(reader, this.f48OxxIIOOXO, this.f47IIXOooo);
    }

    @Override // x0oox0.oIX0oI
    public void o00() {
        oIX0oI oIX0oI2 = this.f49oI0IIXIo.oIX0oI();
        this.f34034x0xO0oo = oIX0oI2.f57oIX0oI;
        this.f34023Oo = oIX0oI2.f56II0xO0;
    }

    @Override // x0oox0.I0Io
    public void stop() {
        I0Io i0Io = this.f49oI0IIXIo;
        if (i0Io != null) {
            i0Io.II0xO0();
        }
    }

    public II0xO0(char[] cArr, char c, int i, int i2) {
        super(cArr, c);
        this.f48OxxIIOOXO = i;
        this.f47IIXOooo = i2;
    }
}
