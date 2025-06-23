package OoIXo;

/* loaded from: classes6.dex */
public abstract class ooXIXxIX {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final String f2351II0XooXoX = "&S";

    /* renamed from: IIXOooo, reason: collision with root package name */
    public static final String f2352IIXOooo = "&A";

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static final String f2353IXxxXO = "&N";

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final String f2354OOXIXo = "&Y";

    /* renamed from: Oo, reason: collision with root package name */
    public static final String f2355Oo = "&P";

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final String f2356Oxx0IOOO = "&I";

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static final String f2357Oxx0xo = "&D";

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public static final String f2358OxxIIOOXO = "&F";

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final String f2359X0o0xo = "&B";

    /* renamed from: XO, reason: collision with root package name */
    public static final String f2360XO = "&U";

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public static final String f2361oI0IIXIo = "&T";

    /* renamed from: oO, reason: collision with root package name */
    public static final String f2362oO = "&C";

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final String f2363oOoXoXO = "&O";

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final String f2364ooOOo0oXI = "&H";

    /* renamed from: oxoX, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f2365oxoX = XxIIOXIXx.X0o0xo.Oxx0IOOO(ooXIXxIX.class);

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final String f2366x0XOIxOo = "&L";

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static final String f2367x0xO0oo = "&R";

    /* renamed from: xoIox, reason: collision with root package name */
    public static final String f2368xoIox = "&X";

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final String f2369xxIXOIIO = "&E";

    /* renamed from: I0Io, reason: collision with root package name */
    public oIX0oI f2370I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public oIX0oI f2371II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public oIX0oI f2372oIX0oI;

    public ooXIXxIX() {
        this.f2372oIX0oI = II0xO0();
        this.f2371II0xO0 = II0xO0();
        this.f2370I0Io = II0xO0();
    }

    public abstract oIX0oI I0Io(oIX0oI oix0oi);

    public abstract oIX0oI II0xO0();

    public oIX0oI Oxx0IOOO() {
        return this.f2371II0xO0;
    }

    public oIX0oI X0o0xo() {
        return this.f2370I0Io;
    }

    public oIX0oI XO() {
        return this.f2372oIX0oI;
    }

    public void oIX0oI() {
        this.f2372oIX0oI.xoIox();
        this.f2371II0xO0.xoIox();
        this.f2370I0Io.xoIox();
    }

    public abstract oIX0oI oxoX(String str);

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        if (!this.f2372oIX0oI.OOXIXo()) {
            stringBuffer.append(f2366x0XOIxOo);
            stringBuffer.append(this.f2372oIX0oI.oOoXoXO());
        }
        if (!this.f2370I0Io.OOXIXo()) {
            stringBuffer.append(f2362oO);
            stringBuffer.append(this.f2370I0Io.oOoXoXO());
        }
        if (!this.f2371II0xO0.OOXIXo()) {
            stringBuffer.append(f2367x0xO0oo);
            stringBuffer.append(this.f2371II0xO0.oOoXoXO());
        }
        return stringBuffer.toString();
    }

    /* loaded from: classes6.dex */
    public static class oIX0oI {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public StringBuffer f2373oIX0oI;

        public oIX0oI() {
            this.f2373oIX0oI = new StringBuffer();
        }

        public final void I0Io(char c) {
            if (this.f2373oIX0oI == null) {
                this.f2373oIX0oI = new StringBuffer();
            }
            this.f2373oIX0oI.append(c);
        }

        public void II0XooXoX() {
            oxoX(ooXIXxIX.f2352IIXOooo);
        }

        public void II0xO0() {
            oxoX(ooXIXxIX.f2357Oxx0xo);
        }

        public void IIXOooo() {
            oxoX(ooXIXxIX.f2368xoIox);
        }

        public void IXxxXO() {
            oxoX(ooXIXxIX.f2363oOoXoXO);
        }

        public boolean OOXIXo() {
            StringBuffer stringBuffer = this.f2373oIX0oI;
            if (stringBuffer != null && stringBuffer.length() != 0) {
                return false;
            }
            return true;
        }

        public void Oo() {
            oxoX(ooXIXxIX.f2356Oxx0IOOO);
        }

        public void Oxx0IOOO() {
            oxoX(ooXIXxIX.f2353IXxxXO);
        }

        public void Oxx0xo() {
            oxoX(ooXIXxIX.f2364ooOOo0oXI);
        }

        public void OxxIIOOXO() {
            oxoX(ooXIXxIX.f2354OOXIXo);
        }

        public void X0o0xo() {
            oxoX(ooXIXxIX.f2355Oo);
        }

        public void XO() {
            oxoX(ooXIXxIX.f2361oI0IIXIo);
        }

        public void oI0IIXIo() {
            oxoX(ooXIXxIX.f2351II0XooXoX);
        }

        public void oIX0oI(String str) {
            oxoX(str);
        }

        public void oO() {
            oxoX(ooXIXxIX.f2359X0o0xo);
        }

        public String oOoXoXO() {
            StringBuffer stringBuffer = this.f2373oIX0oI;
            if (stringBuffer != null) {
                return stringBuffer.toString();
            }
            return "";
        }

        public void ooOOo0oXI(String str) {
            oxoX("&\"");
            oxoX(str);
            I0Io('\"');
        }

        public final void oxoX(String str) {
            if (this.f2373oIX0oI == null) {
                this.f2373oIX0oI = new StringBuffer();
            }
            this.f2373oIX0oI.append(str);
        }

        public boolean x0XOIxOo(int i) {
            String num;
            if (i >= 1 && i <= 99) {
                if (i < 10) {
                    num = "0" + i;
                } else {
                    num = Integer.toString(i);
                }
                I0Io(kotlin.text.XIxXXX0x0.f29558oxoX);
                oxoX(num);
                return true;
            }
            return false;
        }

        public void x0xO0oo() {
            oxoX(ooXIXxIX.f2369xxIXOIIO);
        }

        public void xoIox() {
            this.f2373oIX0oI = null;
        }

        public void xoXoI() {
            oxoX(ooXIXxIX.f2360XO);
        }

        public void xxIXOIIO() {
            oxoX(ooXIXxIX.f2358OxxIIOOXO);
        }

        public oIX0oI(String str) {
            this.f2373oIX0oI = new StringBuffer(str);
        }

        public oIX0oI(oIX0oI oix0oi) {
            this.f2373oIX0oI = new StringBuffer(oix0oi.oOoXoXO());
        }
    }

    public ooXIXxIX(ooXIXxIX ooxixxix) {
        this.f2372oIX0oI = I0Io(ooxixxix.f2372oIX0oI);
        this.f2371II0xO0 = I0Io(ooxixxix.f2371II0xO0);
        this.f2370I0Io = I0Io(ooxixxix.f2370I0Io);
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x003d, code lost:
    
        if (r1 > r0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x005b, code lost:
    
        if (r0 > r1) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public ooXIXxIX(java.lang.String r7) {
        /*
            r6 = this;
            r6.<init>()
            if (r7 == 0) goto La8
            int r0 = r7.length()
            if (r0 != 0) goto Ld
            goto La8
        Ld:
            java.lang.String r0 = "&L"
            int r0 = r7.indexOf(r0)
            java.lang.String r1 = "&R"
            int r1 = r7.indexOf(r1)
            java.lang.String r2 = "&C"
            int r2 = r7.indexOf(r2)
            r3 = -1
            if (r0 != r3) goto L2e
            if (r1 != r3) goto L2e
            if (r2 != r3) goto L2e
            OoIXo.ooXIXxIX$oIX0oI r7 = r6.oxoX(r7)
            r6.f2370I0Io = r7
            goto L89
        L2e:
            if (r0 == r3) goto L4c
            int r4 = r7.length()
            if (r2 <= r0) goto L3d
            if (r1 <= r0) goto L3b
            if (r2 <= r1) goto L3b
            goto L3f
        L3b:
            r4 = r2
            goto L40
        L3d:
            if (r1 <= r0) goto L40
        L3f:
            r4 = r1
        L40:
            int r5 = r0 + 2
            java.lang.String r4 = r7.substring(r5, r4)
            OoIXo.ooXIXxIX$oIX0oI r4 = r6.oxoX(r4)
            r6.f2372oIX0oI = r4
        L4c:
            if (r1 == r3) goto L6a
            int r4 = r7.length()
            if (r2 <= r1) goto L5b
            if (r0 <= r1) goto L59
            if (r2 <= r0) goto L59
            goto L5d
        L59:
            r4 = r2
            goto L5e
        L5b:
            if (r0 <= r1) goto L5e
        L5d:
            r4 = r0
        L5e:
            int r5 = r1 + 2
            java.lang.String r4 = r7.substring(r5, r4)
            OoIXo.ooXIXxIX$oIX0oI r4 = r6.oxoX(r4)
            r6.f2371II0xO0 = r4
        L6a:
            if (r2 == r3) goto L89
            int r3 = r7.length()
            if (r1 <= r2) goto L79
            if (r0 <= r2) goto L77
            if (r1 <= r0) goto L77
            goto L7d
        L77:
            r0 = r1
            goto L7d
        L79:
            if (r0 <= r2) goto L7c
            goto L7d
        L7c:
            r0 = r3
        L7d:
            int r2 = r2 + 2
            java.lang.String r7 = r7.substring(r2, r0)
            OoIXo.ooXIXxIX$oIX0oI r7 = r6.oxoX(r7)
            r6.f2370I0Io = r7
        L89:
            OoIXo.ooXIXxIX$oIX0oI r7 = r6.f2372oIX0oI
            if (r7 != 0) goto L93
            OoIXo.ooXIXxIX$oIX0oI r7 = r6.II0xO0()
            r6.f2372oIX0oI = r7
        L93:
            OoIXo.ooXIXxIX$oIX0oI r7 = r6.f2370I0Io
            if (r7 != 0) goto L9d
            OoIXo.ooXIXxIX$oIX0oI r7 = r6.II0xO0()
            r6.f2370I0Io = r7
        L9d:
            OoIXo.ooXIXxIX$oIX0oI r7 = r6.f2371II0xO0
            if (r7 != 0) goto La7
            OoIXo.ooXIXxIX$oIX0oI r7 = r6.II0xO0()
            r6.f2371II0xO0 = r7
        La7:
            return
        La8:
            OoIXo.ooXIXxIX$oIX0oI r7 = r6.II0xO0()
            r6.f2372oIX0oI = r7
            OoIXo.ooXIXxIX$oIX0oI r7 = r6.II0xO0()
            r6.f2371II0xO0 = r7
            OoIXo.ooXIXxIX$oIX0oI r7 = r6.II0xO0()
            r6.f2370I0Io = r7
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: OoIXo.ooXIXxIX.<init>(java.lang.String):void");
    }
}
