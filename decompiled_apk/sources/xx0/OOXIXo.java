package xx0;

import xx0.oO;

/* loaded from: classes13.dex */
public abstract class OOXIXo {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public Oxx0xo f35201IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public volatile boolean f35202Oo;

    /* renamed from: XO, reason: collision with root package name */
    public volatile int f35203XO;

    public OOXIXo() {
        this(x0XOIxOo.f35238oIX0oI, true, Oxx0xo.f35204oIX0oI);
    }

    public void I0Io(Oxx0xo oxx0xo) {
        this.f35201IXxxXO = oxx0xo;
    }

    public void II0xO0(int i, Thread thread, long j, String str, String str2, Throwable th) {
        if (X0o0xo() && oO.oIX0oI.oIX0oI(this.f35203XO, i)) {
            XO(i, thread, j, str, str2, th);
        }
    }

    public Oxx0xo Oxx0IOOO() {
        return this.f35201IXxxXO;
    }

    public boolean X0o0xo() {
        return this.f35202Oo;
    }

    public abstract void XO(int i, Thread thread, long j, String str, String str2, Throwable th);

    public void oIX0oI(int i) {
        this.f35203XO = i;
    }

    public void oxoX(boolean z) {
        this.f35202Oo = z;
    }

    public OOXIXo(int i, boolean z, Oxx0xo oxx0xo) {
        this.f35203XO = x0XOIxOo.f35238oIX0oI;
        this.f35202Oo = true;
        this.f35201IXxxXO = Oxx0xo.f35204oIX0oI;
        oIX0oI(i);
        oxoX(z);
        I0Io(oxx0xo);
    }
}
