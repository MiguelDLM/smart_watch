package X0xOO;

/* loaded from: classes6.dex */
public final class oOXoIIIo {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public int f3491oIX0oI;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static oOXoIIIo[] f3486II0xO0 = new oOXoIIIo[0];

    /* renamed from: I0Io, reason: collision with root package name */
    public static final oOXoIIIo f3485I0Io = new oOXoIIIo(0);

    /* renamed from: oxoX, reason: collision with root package name */
    public static final oOXoIIIo f3490oxoX = new oOXoIIIo(75);

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final oOXoIIIo f3488X0o0xo = new oOXoIIIo(201);

    /* renamed from: XO, reason: collision with root package name */
    public static final oOXoIIIo f3489XO = new oOXoIIIo(202);

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final oOXoIIIo f3487Oxx0IOOO = new oOXoIIIo(-1);

    public oOXoIIIo(int i) {
        this.f3491oIX0oI = i;
        oOXoIIIo[] ooxoiiioArr = f3486II0xO0;
        oOXoIIIo[] ooxoiiioArr2 = new oOXoIIIo[ooxoiiioArr.length + 1];
        f3486II0xO0 = ooxoiiioArr2;
        System.arraycopy(ooxoiiioArr, 0, ooxoiiioArr2, 0, ooxoiiioArr.length);
        f3486II0xO0[ooxoiiioArr.length] = this;
    }

    public static oOXoIIIo oIX0oI(int i) {
        oOXoIIIo ooxoiiio = f3487Oxx0IOOO;
        int i2 = 0;
        boolean z = false;
        while (true) {
            oOXoIIIo[] ooxoiiioArr = f3486II0xO0;
            if (i2 >= ooxoiiioArr.length || z) {
                break;
            }
            oOXoIIIo ooxoiiio2 = ooxoiiioArr[i2];
            if (ooxoiiio2.f3491oIX0oI == i) {
                ooxoiiio = ooxoiiio2;
                z = true;
            }
            i2++;
        }
        return ooxoiiio;
    }

    public int II0xO0() {
        return this.f3491oIX0oI;
    }
}
