package IxI;

import com.univocity.parsers.common.TextParsingException;
import com.univocity.parsers.common.oO;
import com.univocity.parsers.common.x0xO0oo;
import com.univocity.parsers.fixed.FieldAlignment;

/* loaded from: classes13.dex */
public class II0XooXoX extends com.univocity.parsers.common.oIX0oI<xxIXOIIO> {

    /* renamed from: IIX0o, reason: collision with root package name */
    public boolean f1024IIX0o;

    /* renamed from: IIXOooo, reason: collision with root package name */
    public char[] f1025IIXOooo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public int[] f1026IXxxXO;

    /* renamed from: IoOoX, reason: collision with root package name */
    public int f1027IoOoX;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public ooOOo0oXI f1028O0xOxO;

    /* renamed from: Oo, reason: collision with root package name */
    public int[] f1029Oo;

    /* renamed from: OxI, reason: collision with root package name */
    public ooOOo0oXI f1030OxI;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public FieldAlignment[] f1031Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public char[] f1032OxxIIOOXO;

    /* renamed from: X0IIOO, reason: collision with root package name */
    public int f1033X0IIOO;

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public final boolean f1034XI0IXoo;

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public final boolean f1035XIxXXX0x0;

    /* renamed from: Xx000oIo, reason: collision with root package name */
    public x0oox0.II0XooXoX f1036Xx000oIo;

    /* renamed from: XxX0x0xxx, reason: collision with root package name */
    public final boolean f1037XxX0x0xxx;

    /* renamed from: o00, reason: collision with root package name */
    public final ooOOo0oXI[] f1038o00;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public FieldAlignment[] f1039oI0IIXIo;

    /* renamed from: oOXoIIIo, reason: collision with root package name */
    public boolean f1040oOXoIIIo;

    /* renamed from: oo, reason: collision with root package name */
    public final char f1041oo;

    /* renamed from: oo0xXOI0I, reason: collision with root package name */
    public FieldAlignment f1042oo0xXOI0I;

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    public final char f1043ooXIXxIX;

    /* renamed from: xI, reason: collision with root package name */
    public char f1044xI;

    /* renamed from: xXxxox0I, reason: collision with root package name */
    public final boolean f1045xXxxox0I;

    /* renamed from: xoXoI, reason: collision with root package name */
    public final ooOOo0oXI[] f1046xoXoI;

    /* renamed from: xxX, reason: collision with root package name */
    public final boolean f1047xxX;

    /* loaded from: classes13.dex */
    public class oIX0oI extends x0xO0oo {
        public oIX0oI(oO oOVar) {
            super(oOVar);
        }

        @Override // com.univocity.parsers.common.x0xO0oo, com.univocity.parsers.common.oO
        public String[] X0o0xo() {
            if (II0XooXoX.this.f1030OxI != null) {
                return II0XooXoX.this.f1030OxI.f1080X0o0xo;
            }
            return super.X0o0xo();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public II0XooXoX(xxIXOIIO xxixoiio) {
        super(xxixoiio);
        boolean z = false;
        this.f1040oOXoIIIo = false;
        this.f1034XI0IXoo = xxixoiio.OOXIXo();
        this.f1035XIxXXX0x0 = xxixoiio.oOoXoXO();
        this.f1047xxX = xxixoiio.xoIxX();
        this.f1037XxX0x0xxx = xxixoiio.IoOoo();
        this.f1045xXxxox0I = xxixoiio.Oo();
        this.f1029Oo = xxixoiio.O0Xx();
        this.f1031Oxx0xo = xxixoiio.XoI0Ixx0();
        this.f1032OxxIIOOXO = xxixoiio.I0oOIX();
        ooOOo0oXI[] xoxXI2 = xxixoiio.xoxXI();
        this.f1046xoXoI = xoxXI2;
        ooOOo0oXI[] OO2 = xxixoiio.OO();
        this.f1038o00 = OO2;
        if (xoxXI2 != null || OO2 != null) {
            this.f1040oOXoIIIo = true;
            this.f1026IXxxXO = this.f1029Oo;
            this.f1039oI0IIXIo = this.f1031Oxx0xo;
            this.f1025IIXOooo = this.f1032OxxIIOOXO;
            this.f1033X0IIOO = ooOOo0oXI.II0xO0(xoxXI2, OO2);
            this.f27071XO = new oIX0oI(this.f27071XO);
        }
        Oxx0IOOO oxx0IOOO = (Oxx0IOOO) xxixoiio.xxIXOIIO();
        char x0xO0oo2 = oxx0IOOO.x0xO0oo();
        this.f1044xI = x0xO0oo2;
        this.f1043ooXIXxIX = x0xO0oo2;
        this.f1041oo = oxx0IOOO.Oxx0IOOO();
        if (xxixoiio.x0xO() && xxixoiio.IO()) {
            z = true;
        }
        this.f1024IIX0o = z;
    }

    public final void I0oOoX() {
        if (this.f1035XIxXXX0x0) {
            if (this.f1042oo0xXOI0I == FieldAlignment.RIGHT) {
                while (true) {
                    int i = this.f1027IoOoX;
                    this.f1027IoOoX = i - 1;
                    if (i > 0) {
                        this.f27067II0xO0.f27098Oxx0IOOO.xoIox(this.f27080xxIXOIIO);
                        this.f27080xxIXOIIO = this.f27066II0XooXoX.Oxx0IOOO();
                    } else {
                        return;
                    }
                }
            } else {
                while (true) {
                    int i2 = this.f1027IoOoX;
                    this.f1027IoOoX = i2 - 1;
                    if (i2 > 0) {
                        this.f27067II0xO0.f27098Oxx0IOOO.xxIXOIIO(this.f27080xxIXOIIO, this.f1044xI);
                        this.f27080xxIXOIIO = this.f27066II0XooXoX.Oxx0IOOO();
                    } else {
                        return;
                    }
                }
            }
        } else if (this.f1042oo0xXOI0I == FieldAlignment.RIGHT) {
            while (true) {
                int i3 = this.f1027IoOoX;
                this.f1027IoOoX = i3 - 1;
                if (i3 > 0) {
                    this.f27067II0xO0.f27098Oxx0IOOO.append(this.f27080xxIXOIIO);
                    this.f27080xxIXOIIO = this.f27066II0XooXoX.Oxx0IOOO();
                } else {
                    return;
                }
            }
        } else {
            while (true) {
                int i4 = this.f1027IoOoX;
                this.f1027IoOoX = i4 - 1;
                if (i4 > 0) {
                    this.f27067II0xO0.f27098Oxx0IOOO.II0xO0(this.f27080xxIXOIIO, this.f1044xI);
                    this.f27080xxIXOIIO = this.f27066II0XooXoX.Oxx0IOOO();
                } else {
                    return;
                }
            }
        }
    }

    public final void XoX() {
        while (this.f27080xxIXOIIO == this.f1044xI) {
            int i = this.f1027IoOoX;
            this.f1027IoOoX = i - 1;
            if (i > 0) {
                this.f27080xxIXOIIO = this.f27066II0XooXoX.Oxx0IOOO();
            } else {
                return;
            }
        }
    }

    public final void oxXx0IX() {
        while (this.f27080xxIXOIIO != this.f1041oo) {
            this.f27080xxIXOIIO = this.f27066II0XooXoX.Oxx0IOOO();
        }
    }

    public final void oxxXoxO() {
        char c;
        char c2;
        char c3;
        char c4;
        if (this.f1035XIxXXX0x0) {
            if (this.f1042oo0xXOI0I == FieldAlignment.RIGHT) {
                while (true) {
                    int i = this.f1027IoOoX;
                    this.f1027IoOoX = i - 1;
                    if (i > 0 && (c4 = this.f27080xxIXOIIO) != this.f1041oo) {
                        this.f27067II0xO0.f27098Oxx0IOOO.xoIox(c4);
                        this.f27080xxIXOIIO = this.f27066II0XooXoX.Oxx0IOOO();
                    } else {
                        return;
                    }
                }
            } else {
                while (true) {
                    int i2 = this.f1027IoOoX;
                    this.f1027IoOoX = i2 - 1;
                    if (i2 > 0 && (c3 = this.f27080xxIXOIIO) != this.f1041oo) {
                        this.f27067II0xO0.f27098Oxx0IOOO.xxIXOIIO(c3, this.f1044xI);
                        this.f27080xxIXOIIO = this.f27066II0XooXoX.Oxx0IOOO();
                    } else {
                        return;
                    }
                }
            }
        } else if (this.f1042oo0xXOI0I == FieldAlignment.RIGHT) {
            while (true) {
                int i3 = this.f1027IoOoX;
                this.f1027IoOoX = i3 - 1;
                if (i3 > 0 && (c2 = this.f27080xxIXOIIO) != this.f1041oo) {
                    this.f27067II0xO0.f27098Oxx0IOOO.append(c2);
                    this.f27080xxIXOIIO = this.f27066II0XooXoX.Oxx0IOOO();
                } else {
                    return;
                }
            }
        } else {
            while (true) {
                int i4 = this.f1027IoOoX;
                this.f1027IoOoX = i4 - 1;
                if (i4 > 0 && (c = this.f27080xxIXOIIO) != this.f1041oo) {
                    this.f27067II0xO0.f27098Oxx0IOOO.II0xO0(c, this.f1044xI);
                    this.f27080xxIXOIIO = this.f27066II0XooXoX.Oxx0IOOO();
                } else {
                    return;
                }
            }
        }
    }

    @Override // com.univocity.parsers.common.oIX0oI
    public void xII() {
        char c;
        char c2 = this.f27080xxIXOIIO;
        char c3 = this.f1041oo;
        if (c2 == c3 && this.f1045xXxxox0I) {
            return;
        }
        if (this.f1046xoXoI != null || this.f1038o00 != null) {
            if (this.f1040oOXoIIIo) {
                this.f1040oOXoIIIo = false;
                x0oox0.II0XooXoX iI0XooXoX = new x0oox0.II0XooXoX(this.f27066II0XooXoX, c3);
                this.f1036Xx000oIo = iI0XooXoX;
                this.f27066II0XooXoX = iI0XooXoX;
            }
            this.f1036Xx000oIo.OxxIIOOXO(this.f1033X0IIOO);
            boolean z = true;
            if (this.f1046xoXoI != null) {
                int i = 0;
                while (true) {
                    ooOOo0oXI[] ooooo0oxiArr = this.f1046xoXoI;
                    if (i < ooooo0oxiArr.length) {
                        if (this.f1036Xx000oIo.IIXOooo(this.f27080xxIXOIIO, ooooo0oxiArr[i].f1081oIX0oI)) {
                            ooOOo0oXI ooooo0oxi = this.f1046xoXoI[i];
                            this.f1029Oo = ooooo0oxi.f1079II0xO0;
                            this.f1030OxI = ooooo0oxi;
                            break;
                        }
                        i++;
                    } else {
                        z = false;
                        break;
                    }
                }
                if (this.f1038o00 != null && z) {
                    this.f1028O0xOxO = null;
                    int i2 = 0;
                    while (true) {
                        ooOOo0oXI[] ooooo0oxiArr2 = this.f1038o00;
                        if (i2 >= ooooo0oxiArr2.length) {
                            break;
                        }
                        if (this.f1036Xx000oIo.IIXOooo(this.f27080xxIXOIIO, ooooo0oxiArr2[i2].f1081oIX0oI)) {
                            this.f1028O0xOxO = this.f1038o00[i2];
                            break;
                        }
                        i2++;
                    }
                }
            } else {
                int i3 = 0;
                while (true) {
                    ooOOo0oXI[] ooooo0oxiArr3 = this.f1038o00;
                    if (i3 < ooooo0oxiArr3.length) {
                        if (this.f1036Xx000oIo.IIXOooo(this.f27080xxIXOIIO, ooooo0oxiArr3[i3].f1081oIX0oI)) {
                            this.f1028O0xOxO = this.f1038o00[i3];
                            this.f1029Oo = this.f1026IXxxXO;
                            break;
                        }
                        i3++;
                    } else {
                        z = false;
                        break;
                    }
                }
            }
            if (!z) {
                ooOOo0oXI ooooo0oxi2 = this.f1028O0xOxO;
                if (ooooo0oxi2 == null) {
                    int[] iArr = this.f1026IXxxXO;
                    if (iArr != null) {
                        this.f1029Oo = iArr;
                        this.f1031Oxx0xo = this.f1039oI0IIXIo;
                        this.f1032OxxIIOOXO = this.f1025IIXOooo;
                        this.f1030OxI = null;
                    } else {
                        throw new TextParsingException(this.f27071XO, "Cannot process input with the given configuration. No default field lengths defined and no lookahead/lookbehind value match '" + this.f1036Xx000oIo.oI0IIXIo(this.f27080xxIXOIIO) + '\'');
                    }
                } else {
                    this.f1029Oo = ooooo0oxi2.f1079II0xO0;
                    this.f1031Oxx0xo = ooooo0oxi2.f1078I0Io;
                    this.f1032OxxIIOOXO = ooooo0oxi2.f1082oxoX;
                    this.f1030OxI = ooooo0oxi2;
                }
            }
        }
        int i4 = 0;
        while (true) {
            int[] iArr2 = this.f1029Oo;
            if (i4 < iArr2.length) {
                this.f1027IoOoX = iArr2[i4];
                char[] cArr = this.f1032OxxIIOOXO;
                if (cArr != null) {
                    if (this.f1024IIX0o) {
                        c = this.f1043ooXIXxIX;
                    } else {
                        c = cArr[i4];
                    }
                    this.f1044xI = c;
                }
                FieldAlignment[] fieldAlignmentArr = this.f1031Oxx0xo;
                if (fieldAlignmentArr != null) {
                    this.f1042oo0xXOI0I = fieldAlignmentArr[i4];
                }
                XoX();
                if (this.f1034XI0IXoo) {
                    xo0x();
                }
                if (this.f1037XxX0x0xxx) {
                    oxxXoxO();
                    if (this.f27080xxIXOIIO == this.f1041oo) {
                        this.f27067II0xO0.oOoXoXO();
                        this.f1024IIX0o = false;
                        return;
                    }
                } else {
                    I0oOoX();
                }
                this.f27067II0xO0.oOoXoXO();
                i4++;
            } else {
                if (this.f1047xxX) {
                    oxXx0IX();
                }
                this.f1024IIX0o = false;
                return;
            }
        }
    }

    public final void xo0x() {
        while (this.f27080xxIXOIIO <= ' ') {
            int i = this.f1027IoOoX;
            this.f1027IoOoX = i - 1;
            if (i > 0) {
                this.f27080xxIXOIIO = this.f27066II0XooXoX.Oxx0IOOO();
            } else {
                return;
            }
        }
    }
}
