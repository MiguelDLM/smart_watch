package o00xOoIO;

import com.univocity.parsers.common.TextParsingException;
import com.univocity.parsers.common.oO;
import com.univocity.parsers.csv.UnescapedQuoteHandling;
import x0oox0.xxIXOIIO;

/* loaded from: classes13.dex */
public class oxoX extends com.univocity.parsers.common.oIX0oI<X0o0xo> {

    /* renamed from: IIXOooo, reason: collision with root package name */
    public final boolean f31068IIXOooo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public final boolean f31069IXxxXO;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public final char f31070O0xOxO;

    /* renamed from: Oo, reason: collision with root package name */
    public final boolean f31071Oo;

    /* renamed from: OxI, reason: collision with root package name */
    public char f31072OxI;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public boolean f31073Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public final boolean f31074OxxIIOOXO;

    /* renamed from: X0IIOO, reason: collision with root package name */
    public final char f31075X0IIOO;

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public final x0oox0.oxoX f31076XI0IXoo;

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public final boolean f31077XIxXXX0x0;

    /* renamed from: o00, reason: collision with root package name */
    public char f31078o00;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public boolean f31079oI0IIXIo;

    /* renamed from: xoXoI, reason: collision with root package name */
    public char f31080xoXoI;

    /* renamed from: xxX, reason: collision with root package name */
    public UnescapedQuoteHandling f31081xxX;

    /* loaded from: classes13.dex */
    public static /* synthetic */ class II0xO0 {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public static final /* synthetic */ int[] f31082oIX0oI;

        static {
            int[] iArr = new int[UnescapedQuoteHandling.values().length];
            f31082oIX0oI = iArr;
            try {
                iArr[UnescapedQuoteHandling.SKIP_VALUE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f31082oIX0oI[UnescapedQuoteHandling.RAISE_ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f31082oIX0oI[UnescapedQuoteHandling.STOP_AT_CLOSING_QUOTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f31082oIX0oI[UnescapedQuoteHandling.STOP_AT_DELIMITER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes13.dex */
    public class oIX0oI extends I0Io {
        public oIX0oI(int i, X0o0xo x0o0xo) {
            super(i, x0o0xo);
        }

        @Override // o00xOoIO.I0Io
        public void II0xO0(char c, char c2, char c3) {
            if (((X0o0xo) oxoX.this.f27072oIX0oI).XoI0Ixx0()) {
                oxoX.this.f31080xoXoI = c;
            }
            if (((X0o0xo) oxoX.this.f27072oIX0oI).xoIxX()) {
                oxoX.this.f31078o00 = c2;
                oxoX.this.f31072OxI = c3;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public oxoX(X0o0xo x0o0xo) {
        super(x0o0xo);
        boolean z;
        this.f31071Oo = x0o0xo.oOoXoXO();
        this.f31069IXxxXO = x0o0xo.OOXIXo();
        this.f31073Oxx0xo = x0o0xo.OO();
        this.f31079oI0IIXIo = x0o0xo.IoOoo();
        this.f31074OxxIIOOXO = !x0o0xo.O0Xx();
        this.f31068IIXOooo = x0o0xo.I0oOIX();
        this.f31077XIxXXX0x0 = x0o0xo.xoxXI();
        o00xOoIO.II0xO0 iI0xO0 = (o00xOoIO.II0xO0) x0o0xo.xxIXOIIO();
        this.f31080xoXoI = iI0xO0.Oo();
        this.f31078o00 = iI0xO0.IXxxXO();
        this.f31072OxI = iI0xO0.Oxx0xo();
        this.f31070O0xOxO = iI0xO0.x0xO0oo();
        this.f31075X0IIOO = iI0xO0.Oxx0IOOO();
        this.f31076XI0IXoo = new x0oox0.oxoX(x0o0xo.ooOOo0oXI(), "");
        UnescapedQuoteHandling Xo02 = x0o0xo.Xo0();
        this.f31081xxX = Xo02;
        if (Xo02 == null) {
            if (this.f31073Oxx0xo) {
                if (this.f31079oI0IIXIo) {
                    this.f31081xxX = UnescapedQuoteHandling.STOP_AT_DELIMITER;
                    return;
                } else {
                    this.f31081xxX = UnescapedQuoteHandling.STOP_AT_CLOSING_QUOTE;
                    return;
                }
            }
            this.f31081xxX = UnescapedQuoteHandling.RAISE_ERROR;
            return;
        }
        if (Xo02 != UnescapedQuoteHandling.STOP_AT_DELIMITER && Xo02 != UnescapedQuoteHandling.SKIP_VALUE) {
            z = false;
        } else {
            z = true;
        }
        this.f31079oI0IIXIo = z;
        this.f31073Oxx0xo = Xo02 != UnescapedQuoteHandling.RAISE_ERROR;
    }

    public final void I0X0x0oIo(boolean z) {
        String str;
        int i = II0xO0.f31082oIX0oI[this.f31081xxX.ordinal()];
        if (i != 1) {
            if (i == 2) {
                oO oOVar = this.f27071XO;
                StringBuilder sb = new StringBuilder();
                sb.append("Unescaped quote character '");
                sb.append(this.f31078o00);
                sb.append("' inside ");
                if (z) {
                    str = "quoted";
                } else {
                    str = "";
                }
                sb.append(str);
                sb.append(" value of CSV field. To allow unescaped quotes, set 'parseUnescapedQuotes' to 'true' in the CSV parser settings. Cannot parse CSV input.");
                throw new TextParsingException(oOVar, sb.toString());
            }
            return;
        }
        XoI0Ixx0();
    }

    @Override // com.univocity.parsers.common.oIX0oI
    public x0oox0.XO OOXIXo() {
        if (!((X0o0xo) this.f27072oIX0oI).XoI0Ixx0() && !((X0o0xo) this.f27072oIX0oI).xoIxX()) {
            return null;
        }
        return new oIX0oI(20, (X0o0xo) this.f27072oIX0oI);
    }

    @Override // com.univocity.parsers.common.oIX0oI
    public void Oo() {
        this.f27066II0XooXoX.II0xO0(this.f31080xoXoI);
        this.f27066II0XooXoX.oOoXoXO(this.f31078o00);
        this.f27066II0XooXoX.IXxxXO(this.f31072OxI);
        this.f27066II0XooXoX.oxoX(this.f31070O0xOxO);
    }

    public final void XX0() {
        int i = II0xO0.f31082oIX0oI[this.f31081xxX.ordinal()];
        if (i != 3 && i != 4) {
            I0X0x0oIo(false);
        } else {
            this.f27067II0xO0.f27098Oxx0IOOO.append(this.f31078o00);
            Xo0(this.f27080xxIXOIIO);
        }
    }

    public final void Xo0(char c) {
        char c2;
        char c3;
        if (this.f31071Oo) {
            while (true) {
                char c4 = this.f27080xxIXOIIO;
                if (c4 != this.f31080xoXoI && c4 != this.f31075X0IIOO) {
                    char c5 = this.f31078o00;
                    if (c4 != c5 && c4 != this.f31072OxI) {
                        if (c == c5) {
                            XX0();
                            return;
                        }
                        this.f27067II0xO0.f27098Oxx0IOOO.xoIox(c4);
                    } else {
                        char c6 = this.f31072OxI;
                        if (c4 == c6 && c == (c3 = this.f31070O0xOxO) && c3 != 0) {
                            if (this.f31068IIXOooo) {
                                this.f27067II0xO0.f27098Oxx0IOOO.xoIox(c3);
                            }
                            this.f27067II0xO0.f27098Oxx0IOOO.xoIox(this.f31072OxI);
                            this.f27080xxIXOIIO = (char) 0;
                        } else if (c == c6) {
                            if (c4 == c5) {
                                if (this.f31068IIXOooo) {
                                    this.f27067II0xO0.f27098Oxx0IOOO.xoIox(c6);
                                }
                                this.f27067II0xO0.f27098Oxx0IOOO.xoIox(this.f31078o00);
                                this.f27080xxIXOIIO = (char) 0;
                            } else {
                                this.f27067II0xO0.f27098Oxx0IOOO.xoIox(c);
                            }
                        } else if (c4 == c5 && c == c5) {
                            this.f27067II0xO0.f27098Oxx0IOOO.xoIox(c5);
                        }
                    }
                    c = this.f27080xxIXOIIO;
                    this.f27080xxIXOIIO = this.f27066II0XooXoX.Oxx0IOOO();
                } else {
                    return;
                }
            }
        } else {
            while (true) {
                char c7 = this.f27080xxIXOIIO;
                if (c7 != this.f31080xoXoI && c7 != this.f31075X0IIOO) {
                    char c8 = this.f31078o00;
                    if (c7 != c8 && c7 != this.f31072OxI) {
                        if (c == c8) {
                            XX0();
                            return;
                        }
                        this.f27067II0xO0.f27098Oxx0IOOO.append(c7);
                    } else {
                        char c9 = this.f31072OxI;
                        if (c7 == c9 && c == (c2 = this.f31070O0xOxO) && c2 != 0) {
                            if (this.f31068IIXOooo) {
                                this.f27067II0xO0.f27098Oxx0IOOO.append(c2);
                            }
                            this.f27067II0xO0.f27098Oxx0IOOO.append(this.f31072OxI);
                            this.f27080xxIXOIIO = (char) 0;
                        } else if (c == c9) {
                            if (c7 == c8) {
                                if (this.f31068IIXOooo) {
                                    this.f27067II0xO0.f27098Oxx0IOOO.append(c9);
                                }
                                this.f27067II0xO0.f27098Oxx0IOOO.append(this.f31078o00);
                                this.f27080xxIXOIIO = (char) 0;
                            } else {
                                this.f27067II0xO0.f27098Oxx0IOOO.append(c);
                            }
                        } else if (c7 == c8 && c == c8) {
                            this.f27067II0xO0.f27098Oxx0IOOO.xoIox(c8);
                        }
                    }
                    c = this.f27080xxIXOIIO;
                    this.f27080xxIXOIIO = this.f27066II0XooXoX.Oxx0IOOO();
                } else {
                    return;
                }
            }
        }
    }

    public final void XoI0Ixx0() {
        this.f27067II0xO0.f27098Oxx0IOOO.reset();
        this.f27080xxIXOIIO = this.f27066II0XooXoX.II0XooXoX(this.f27080xxIXOIIO, xxIXOIIO.OOXIXo());
    }

    public final void oX(char c) {
        char c2;
        char Oxx0IOOO2;
        if (c != 0 && this.f31079oI0IIXIo) {
            if (this.f31081xxX == UnescapedQuoteHandling.SKIP_VALUE) {
                XoI0Ixx0();
                return;
            }
            this.f27067II0xO0.f27098Oxx0IOOO.X0o0xo(this.f31078o00);
            char Oxx0IOOO3 = this.f27066II0XooXoX.Oxx0IOOO();
            this.f27080xxIXOIIO = Oxx0IOOO3;
            if (this.f31071Oo) {
                this.f27080xxIXOIIO = this.f27066II0XooXoX.X0o0xo(Oxx0IOOO3, this.f27067II0xO0.f27098Oxx0IOOO);
                return;
            } else {
                this.f27080xxIXOIIO = this.f27066II0XooXoX.II0XooXoX(Oxx0IOOO3, this.f27067II0xO0.f27098Oxx0IOOO);
                return;
            }
        }
        while (true) {
            char Oxx0IOOO4 = this.f27066II0XooXoX.Oxx0IOOO();
            this.f27080xxIXOIIO = Oxx0IOOO4;
            char c3 = this.f31078o00;
            if (c == c3 && (Oxx0IOOO4 <= ' ' || Oxx0IOOO4 == this.f31080xoXoI || Oxx0IOOO4 == this.f31075X0IIOO)) {
                break;
            }
            if (Oxx0IOOO4 != c3 && Oxx0IOOO4 != this.f31072OxI) {
                if (c == c3) {
                    if (!xXOx()) {
                        return;
                    }
                } else {
                    this.f27080xxIXOIIO = this.f27066II0XooXoX.ooOOo0oXI(Oxx0IOOO4, this.f27067II0xO0.f27098Oxx0IOOO);
                }
            } else {
                char c4 = this.f31072OxI;
                if (Oxx0IOOO4 == c4 && c == (c2 = this.f31070O0xOxO) && c2 != 0) {
                    if (this.f31068IIXOooo) {
                        this.f27067II0xO0.f27098Oxx0IOOO.append(c2);
                    }
                    this.f27067II0xO0.f27098Oxx0IOOO.append(this.f31072OxI);
                    this.f27080xxIXOIIO = (char) 0;
                } else if (c == c4) {
                    if (Oxx0IOOO4 == c3) {
                        if (this.f31068IIXOooo) {
                            this.f27067II0xO0.f27098Oxx0IOOO.append(c4);
                        }
                        this.f27067II0xO0.f27098Oxx0IOOO.append(this.f31078o00);
                        this.f27080xxIXOIIO = (char) 0;
                    } else {
                        this.f27067II0xO0.f27098Oxx0IOOO.append(c);
                    }
                } else if (Oxx0IOOO4 == c3 && c == c3) {
                    this.f27067II0xO0.f27098Oxx0IOOO.append(c3);
                }
            }
            c = this.f27080xxIXOIIO;
        }
        char c5 = this.f27080xxIXOIIO;
        if (c5 != this.f31080xoXoI && c5 != this.f31075X0IIOO && c5 <= ' ') {
            this.f31076XI0IXoo.reset();
            do {
                this.f31076XI0IXoo.append(this.f27080xxIXOIIO);
                Oxx0IOOO2 = this.f27066II0XooXoX.Oxx0IOOO();
                this.f27080xxIXOIIO = Oxx0IOOO2;
                if (Oxx0IOOO2 == this.f31075X0IIOO) {
                    return;
                }
            } while (Oxx0IOOO2 <= ' ');
            if (Oxx0IOOO2 != this.f31080xoXoI && this.f31073Oxx0xo) {
                x0oox0.II0xO0 iI0xO0 = this.f27067II0xO0.f27098Oxx0IOOO;
                if (iI0xO0 instanceof x0oox0.oxoX) {
                    iI0xO0.append(this.f31078o00);
                    ((x0oox0.oxoX) this.f27067II0xO0.f27098Oxx0IOOO).OOXIXo(this.f31076XI0IXoo);
                }
                char c6 = this.f27080xxIXOIIO;
                if (c6 != this.f31078o00 && c6 != this.f31072OxI) {
                    this.f27067II0xO0.f27098Oxx0IOOO.append(c6);
                }
                oX(this.f27080xxIXOIIO);
            }
        }
        char c7 = this.f27080xxIXOIIO;
        if (c7 != this.f31080xoXoI && c7 != this.f31075X0IIOO) {
            throw new TextParsingException(this.f27071XO, "Unexpected character '" + this.f27080xxIXOIIO + "' following quoted value of CSV field. Expecting '" + this.f31080xoXoI + "'. Cannot parse CSV input.");
        }
    }

    @Override // com.univocity.parsers.common.oIX0oI
    public void xII() {
        char c = this.f27080xxIXOIIO;
        if (c <= ' ' && this.f31069IXxxXO) {
            this.f27080xxIXOIIO = this.f27066II0XooXoX.XO(c);
        }
        while (true) {
            char c2 = this.f27080xxIXOIIO;
            if (c2 != this.f31075X0IIOO) {
                if (c2 <= ' ' && this.f31069IXxxXO) {
                    this.f27080xxIXOIIO = this.f27066II0XooXoX.XO(c2);
                }
                char c3 = this.f27080xxIXOIIO;
                if (c3 == this.f31080xoXoI) {
                    this.f27067II0xO0.II0xO0();
                } else {
                    if (c3 == this.f31078o00) {
                        if (this.f31077XIxXXX0x0) {
                            oX((char) 0);
                        } else {
                            this.f27066II0XooXoX.x0XOIxOo(false);
                            oX((char) 0);
                            this.f27066II0XooXoX.x0XOIxOo(true);
                        }
                    } else if (this.f31074OxxIIOOXO) {
                        if (this.f31071Oo) {
                            this.f27080xxIXOIIO = this.f27066II0XooXoX.X0o0xo(c3, this.f27067II0xO0.f27098Oxx0IOOO);
                        } else {
                            this.f27080xxIXOIIO = this.f27066II0XooXoX.II0XooXoX(c3, this.f27067II0xO0.f27098Oxx0IOOO);
                        }
                    } else {
                        Xo0((char) 0);
                    }
                    this.f27067II0xO0.oOoXoXO();
                }
                if (this.f27080xxIXOIIO != this.f31075X0IIOO) {
                    char Oxx0IOOO2 = this.f27066II0XooXoX.Oxx0IOOO();
                    this.f27080xxIXOIIO = Oxx0IOOO2;
                    if (Oxx0IOOO2 == this.f31075X0IIOO) {
                        this.f27067II0xO0.II0xO0();
                    }
                }
            } else {
                return;
            }
        }
    }

    public final boolean xXOx() {
        int i = II0xO0.f31082oIX0oI[this.f31081xxX.ordinal()];
        if (i != 3 && i != 4) {
            I0X0x0oIo(true);
            return false;
        }
        this.f27067II0xO0.f27098Oxx0IOOO.append(this.f31078o00);
        this.f27067II0xO0.f27098Oxx0IOOO.append(this.f27080xxIXOIIO);
        oX(this.f27080xxIXOIIO);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final o00xOoIO.II0xO0 xo0x() {
        o00xOoIO.II0xO0 iI0xO0;
        if (((X0o0xo) this.f27072oIX0oI).XoI0Ixx0()) {
            iI0xO0 = ((o00xOoIO.II0xO0) ((X0o0xo) this.f27072oIX0oI).xxIXOIIO()).clone();
            iI0xO0.OxI(this.f31080xoXoI);
        } else {
            iI0xO0 = null;
        }
        if (((X0o0xo) this.f27072oIX0oI).xoIxX()) {
            if (iI0xO0 == null) {
                iI0xO0 = ((o00xOoIO.II0xO0) ((X0o0xo) this.f27072oIX0oI).xxIXOIIO()).clone();
            }
            iI0xO0.O0xOxO(this.f31078o00);
            iI0xO0.X0IIOO(this.f31072OxI);
        }
        if (((X0o0xo) this.f27072oIX0oI).xII()) {
            if (iI0xO0 == null) {
                iI0xO0 = ((o00xOoIO.II0xO0) ((X0o0xo) this.f27072oIX0oI).xxIXOIIO()).clone();
            }
            iI0xO0.ooOOo0oXI(this.f27066II0XooXoX.x0xO0oo());
        }
        return iI0xO0;
    }
}
