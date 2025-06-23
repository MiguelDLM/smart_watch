package IxI;

import com.univocity.parsers.common.II0xO0;
import com.univocity.parsers.common.TextWritingException;
import com.univocity.parsers.fixed.FieldAlignment;
import java.io.File;
import java.io.OutputStream;
import java.io.Writer;
import java.nio.charset.Charset;

/* loaded from: classes13.dex */
public class OOXIXo extends II0xO0<oOoXoXO> {

    /* renamed from: IIX0o, reason: collision with root package name */
    public ooOOo0oXI[] f1049IIX0o;

    /* renamed from: IoOoX, reason: collision with root package name */
    public FieldAlignment[] f1050IoOoX;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public int[] f1051O0xOxO;

    /* renamed from: OxI, reason: collision with root package name */
    public boolean f1052OxI;

    /* renamed from: X00IoxXI, reason: collision with root package name */
    public FieldAlignment f1053X00IoxXI;

    /* renamed from: X0IIOO, reason: collision with root package name */
    public FieldAlignment[] f1054X0IIOO;

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public char[] f1055XI0IXoo;

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public char f1056XIxXXX0x0;

    /* renamed from: Xx000oIo, reason: collision with root package name */
    public boolean f1057Xx000oIo;

    /* renamed from: XxX0x0xxx, reason: collision with root package name */
    public int f1058XxX0x0xxx;

    /* renamed from: o00, reason: collision with root package name */
    public boolean f1059o00;

    /* renamed from: oOXoIIIo, reason: collision with root package name */
    public char[] f1060oOXoIIIo;

    /* renamed from: oo, reason: collision with root package name */
    public int[] f1061oo;

    /* renamed from: oo0xXOI0I, reason: collision with root package name */
    public ooOOo0oXI f1062oo0xXOI0I;

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    public ooOOo0oXI[] f1063ooXIXxIX;

    /* renamed from: xI, reason: collision with root package name */
    public char[] f1064xI;

    /* renamed from: xXxxox0I, reason: collision with root package name */
    public FieldAlignment f1065xXxxox0I;

    /* renamed from: xxX, reason: collision with root package name */
    public char f1066xxX;

    public OOXIXo(oOoXoXO oooxoxo) {
        this((Writer) null, oooxoxo);
    }

    public final void XI(String str) {
        if (str != null) {
            oXxOI0oIx(str);
        }
        this.f27038x0XOIxOo.oIX0oI(this.f1056XIxXXX0x0, this.f1058XxX0x0xxx);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.univocity.parsers.common.II0xO0
    /* renamed from: XOxxooXI, reason: merged with bridge method [inline-methods] */
    public final void IIXOooo(oOoXoXO oooxoxo) {
        char x0xO0oo2 = ((Oxx0IOOO) oooxoxo.xxIXOIIO()).x0xO0oo();
        this.f1056XIxXXX0x0 = x0xO0oo2;
        this.f1066xxX = x0xO0oo2;
        this.f1059o00 = oooxoxo.OOXIXo();
        this.f1052OxI = oooxoxo.oOoXoXO();
        this.f1051O0xOxO = oooxoxo.o0();
        this.f1054X0IIOO = oooxoxo.Io();
        this.f1055XI0IXoo = oooxoxo.XX();
        this.f1049IIX0o = oooxoxo.I0oOoX();
        this.f1063ooXIXxIX = oooxoxo.oxxXoxO();
        this.f1057Xx000oIo = oooxoxo.XoX();
        this.f1053X00IoxXI = oooxoxo.OI0();
        ooOOo0oXI[] ooooo0oxiArr = this.f1049IIX0o;
        if (ooooo0oxiArr == null && this.f1063ooXIXxIX == null) {
            this.f1064xI = null;
            this.f1061oo = null;
            this.f1050IoOoX = null;
            this.f1060oOXoIIIo = null;
            return;
        }
        this.f1064xI = new char[ooOOo0oXI.II0xO0(ooooo0oxiArr, this.f1063ooXIXxIX)];
        this.f1061oo = this.f1051O0xOxO;
        this.f1050IoOoX = this.f1054X0IIOO;
        this.f1060oOXoIIIo = this.f1055XI0IXoo;
    }

    @Override // com.univocity.parsers.common.II0xO0
    public void o0(Object[] objArr) {
        int length;
        int length2;
        if ((objArr.length > 0 && this.f1049IIX0o != null) || this.f1063ooXIXxIX != null) {
            String valueOf = String.valueOf(objArr[0]);
            int length3 = valueOf.length();
            char[] cArr = this.f1064xI;
            boolean z = true;
            if (length3 >= cArr.length) {
                length2 = cArr.length;
            } else {
                length2 = valueOf.length();
                for (int length4 = this.f1064xI.length - 1; length4 > length2; length4--) {
                    this.f1064xI[length4] = 0;
                }
            }
            valueOf.getChars(0, length2, this.f1064xI, 0);
            if (this.f1049IIX0o != null) {
                int i = 0;
                while (true) {
                    ooOOo0oXI[] ooooo0oxiArr = this.f1049IIX0o;
                    if (i < ooooo0oxiArr.length) {
                        if (ooooo0oxiArr[i].oxoX(this.f1064xI)) {
                            ooOOo0oXI ooooo0oxi = this.f1049IIX0o[i];
                            this.f1051O0xOxO = ooooo0oxi.f1079II0xO0;
                            this.f1054X0IIOO = ooooo0oxi.f1078I0Io;
                            this.f1055XI0IXoo = ooooo0oxi.f1082oxoX;
                            break;
                        }
                        i++;
                    } else {
                        z = false;
                        break;
                    }
                }
                if (this.f1063ooXIXxIX != null && z) {
                    this.f1062oo0xXOI0I = null;
                    int i2 = 0;
                    while (true) {
                        ooOOo0oXI[] ooooo0oxiArr2 = this.f1063ooXIXxIX;
                        if (i2 >= ooooo0oxiArr2.length) {
                            break;
                        }
                        if (ooooo0oxiArr2[i2].oxoX(this.f1064xI)) {
                            this.f1062oo0xXOI0I = this.f1063ooXIXxIX[i2];
                            break;
                        }
                        i2++;
                    }
                }
            } else {
                int i3 = 0;
                while (true) {
                    ooOOo0oXI[] ooooo0oxiArr3 = this.f1063ooXIXxIX;
                    if (i3 < ooooo0oxiArr3.length) {
                        if (ooooo0oxiArr3[i3].oxoX(this.f1064xI)) {
                            this.f1062oo0xXOI0I = this.f1063ooXIXxIX[i3];
                            this.f1051O0xOxO = this.f1061oo;
                            this.f1054X0IIOO = this.f1050IoOoX;
                            this.f1055XI0IXoo = this.f1060oOXoIIIo;
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
                ooOOo0oXI ooooo0oxi2 = this.f1062oo0xXOI0I;
                if (ooooo0oxi2 == null) {
                    int[] iArr = this.f1061oo;
                    if (iArr != null) {
                        this.f1051O0xOxO = iArr;
                        this.f1054X0IIOO = this.f1050IoOoX;
                        this.f1055XI0IXoo = this.f1060oOXoIIIo;
                    } else {
                        throw new TextWritingException("Cannot write with the given configuration. No default field lengths defined and no lookahead/lookbehind value match '" + new String(this.f1064xI) + '\'', Oxx0xo(), objArr);
                    }
                } else {
                    this.f1051O0xOxO = ooooo0oxi2.f1079II0xO0;
                    this.f1054X0IIOO = ooooo0oxi2.f1078I0Io;
                    this.f1055XI0IXoo = ooooo0oxi2.f1082oxoX;
                }
            }
        }
        int[] iArr2 = this.f1051O0xOxO;
        if (iArr2.length < objArr.length) {
            length = iArr2.length;
        } else {
            length = objArr.length;
        }
        for (int i4 = 0; i4 < length; i4++) {
            this.f1058XxX0x0xxx = this.f1051O0xOxO[i4];
            this.f1065xXxxox0I = this.f1054X0IIOO[i4];
            this.f1056XIxXXX0x0 = this.f1055XI0IXoo[i4];
            if (this.f27028Oxx0xo) {
                if (this.f1057Xx000oIo) {
                    this.f1056XIxXXX0x0 = this.f1066xxX;
                }
                FieldAlignment fieldAlignment = this.f1053X00IoxXI;
                if (fieldAlignment != null) {
                    this.f1065xXxxox0I = fieldAlignment;
                }
            }
            XI(OxxIIOOXO(objArr[i4]));
            xxIXOIIO();
        }
    }

    public final void oXxOI0oIx(String str) {
        int i;
        if (this.f1059o00) {
            i = II0xO0.XoX(str);
        } else {
            i = 0;
        }
        int calculatePadding = this.f1065xXxxox0I.calculatePadding(this.f1058XxX0x0xxx, str.length() - i);
        this.f1058XxX0x0xxx -= calculatePadding;
        this.f27038x0XOIxOo.oIX0oI(this.f1056XIxXXX0x0, calculatePadding);
        if (this.f1052OxI) {
            while (i < str.length() && this.f1058XxX0x0xxx > 0) {
                while (i < str.length()) {
                    int i2 = this.f1058XxX0x0xxx;
                    this.f1058XxX0x0xxx = i2 - 1;
                    if (i2 <= 0) {
                        break;
                    }
                    this.f27038x0XOIxOo.xoIox(str.charAt(i));
                    i++;
                }
                if (this.f1058XxX0x0xxx == -1 && this.f27038x0XOIxOo.Oxx0IOOO() > 0) {
                    int i3 = i;
                    while (true) {
                        if (i3 >= str.length()) {
                            break;
                        }
                        if (str.charAt(i3) > ' ') {
                            this.f27038x0XOIxOo.I0Io();
                            break;
                        }
                        i3++;
                    }
                    if (this.f27038x0XOIxOo.Oxx0IOOO() > 0) {
                        this.f1058XxX0x0xxx = 0;
                    }
                }
                this.f1058XxX0x0xxx += this.f27038x0XOIxOo.Oxx0IOOO();
                xxIXOIIO();
            }
            return;
        }
        while (i < str.length()) {
            int i4 = this.f1058XxX0x0xxx;
            this.f1058XxX0x0xxx = i4 - 1;
            if (i4 > 0) {
                this.f27038x0XOIxOo.append(str.charAt(i));
                i++;
            } else {
                return;
            }
        }
    }

    public OOXIXo(Writer writer, oOoXoXO oooxoxo) {
        super(writer, oooxoxo);
    }

    public OOXIXo(File file, oOoXoXO oooxoxo) {
        super(file, oooxoxo);
    }

    public OOXIXo(File file, String str, oOoXoXO oooxoxo) {
        super(file, str, oooxoxo);
    }

    public OOXIXo(File file, Charset charset, oOoXoXO oooxoxo) {
        super(file, charset, oooxoxo);
    }

    public OOXIXo(OutputStream outputStream, oOoXoXO oooxoxo) {
        super(outputStream, oooxoxo);
    }

    public OOXIXo(OutputStream outputStream, String str, oOoXoXO oooxoxo) {
        super(outputStream, str, oooxoxo);
    }

    public OOXIXo(OutputStream outputStream, Charset charset, oOoXoXO oooxoxo) {
        super(outputStream, charset, oooxoxo);
    }
}
