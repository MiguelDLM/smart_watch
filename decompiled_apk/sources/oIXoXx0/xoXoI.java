package oIXoXx0;

import jxl.write.WriteException;
import jxl.write.biff.X0xII0I;

/* loaded from: classes6.dex */
public class xoXoI extends X0xII0I {

    /* renamed from: O0xOxO, reason: collision with root package name */
    public static final int f31715O0xOxO = 10;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public static final II0xO0 f31719oI0IIXIo = new II0xO0("Arial");

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public static final II0xO0 f31717OxxIIOOXO = new II0xO0("Times New Roman");

    /* renamed from: IIXOooo, reason: collision with root package name */
    public static final II0xO0 f31714IIXOooo = new II0xO0("Courier New");

    /* renamed from: xoXoI, reason: collision with root package name */
    public static final II0xO0 f31720xoXoI = new II0xO0("Tahoma");

    /* renamed from: o00, reason: collision with root package name */
    public static final oIX0oI f31718o00 = new oIX0oI(400);

    /* renamed from: OxI, reason: collision with root package name */
    public static final oIX0oI f31716OxI = new oIX0oI(700);

    /* loaded from: classes6.dex */
    public static class II0xO0 {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public String f31721oIX0oI;

        public II0xO0(String str) {
            this.f31721oIX0oI = str;
        }
    }

    /* loaded from: classes6.dex */
    public static class oIX0oI {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public int f31722oIX0oI;

        public oIX0oI(int i) {
            this.f31722oIX0oI = i;
        }
    }

    public xoXoI(II0xO0 iI0xO0) {
        this(iI0xO0, 10, f31718o00, false, oI0X0.x0xO0oo.f31599oxoX, oI0X0.XO.f31413XO, oI0X0.oO.f31466oxoX);
    }

    public static II0xO0 XX0xXo(String str) {
        return new II0xO0(str);
    }

    @Override // jxl.write.biff.X0xII0I
    public void Ioxxx(boolean z) throws WriteException {
        super.Ioxxx(z);
    }

    public void O00XxXI(oI0X0.XO xo2) throws WriteException {
        super.xoIxX(xo2.II0XooXoX());
    }

    @Override // jxl.write.biff.X0xII0I
    public void OO0x0xX(int i) throws WriteException {
        super.OO0x0xX(i);
    }

    public void XI0oooXX(oI0X0.x0xO0oo x0xo0oo) throws WriteException {
        super.xxIO(x0xo0oo.I0Io());
    }

    public void o0xxxXXxX(oIX0oI oix0oi) throws WriteException {
        super.IoOoo(oix0oi.f31722oIX0oI);
    }

    public void ox(oI0X0.oO oOVar) throws WriteException {
        super.XIo0oOXIx(oOVar.I0Io());
    }

    @Override // jxl.write.biff.X0xII0I
    public void x0xO(boolean z) throws WriteException {
        super.x0xO(z);
    }

    @Override // OoIXo.XIxXXX0x0, oI0X0.Oxx0IOOO
    public boolean x0xO0oo() {
        return super.x0xO0oo();
    }

    public xoXoI(oI0X0.Oxx0IOOO oxx0IOOO) {
        super(oxx0IOOO);
    }

    public xoXoI(II0xO0 iI0xO0, int i) {
        this(iI0xO0, i, f31718o00, false, oI0X0.x0xO0oo.f31599oxoX, oI0X0.XO.f31413XO, oI0X0.oO.f31466oxoX);
    }

    public xoXoI(II0xO0 iI0xO0, int i, oIX0oI oix0oi) {
        this(iI0xO0, i, oix0oi, false, oI0X0.x0xO0oo.f31599oxoX, oI0X0.XO.f31413XO, oI0X0.oO.f31466oxoX);
    }

    public xoXoI(II0xO0 iI0xO0, int i, oIX0oI oix0oi, boolean z) {
        this(iI0xO0, i, oix0oi, z, oI0X0.x0xO0oo.f31599oxoX, oI0X0.XO.f31413XO, oI0X0.oO.f31466oxoX);
    }

    public xoXoI(II0xO0 iI0xO0, int i, oIX0oI oix0oi, boolean z, oI0X0.x0xO0oo x0xo0oo) {
        this(iI0xO0, i, oix0oi, z, x0xo0oo, oI0X0.XO.f31413XO, oI0X0.oO.f31466oxoX);
    }

    public xoXoI(II0xO0 iI0xO0, int i, oIX0oI oix0oi, boolean z, oI0X0.x0xO0oo x0xo0oo, oI0X0.XO xo2) {
        this(iI0xO0, i, oix0oi, z, x0xo0oo, xo2, oI0X0.oO.f31466oxoX);
    }

    public xoXoI(II0xO0 iI0xO0, int i, oIX0oI oix0oi, boolean z, oI0X0.x0xO0oo x0xo0oo, oI0X0.XO xo2, oI0X0.oO oOVar) {
        super(iI0xO0.f31721oIX0oI, i, oix0oi.f31722oIX0oI, z, x0xo0oo.I0Io(), xo2.II0XooXoX(), oOVar.I0Io());
    }
}
