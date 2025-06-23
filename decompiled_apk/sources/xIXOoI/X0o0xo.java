package xIXOoI;

import java.io.File;
import java.io.OutputStream;
import java.io.Writer;
import java.nio.charset.Charset;
import x0oox0.xoIox;

/* loaded from: classes13.dex */
public class X0o0xo extends com.univocity.parsers.common.II0xO0<XO> {

    /* renamed from: O0xOxO, reason: collision with root package name */
    public boolean f34176O0xOxO;

    /* renamed from: OxI, reason: collision with root package name */
    public boolean f34177OxI;

    /* renamed from: X0IIOO, reason: collision with root package name */
    public char f34178X0IIOO;

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public char f34179XI0IXoo;

    /* renamed from: o00, reason: collision with root package name */
    public boolean f34180o00;

    public X0o0xo(XO xo2) {
        this((Writer) null, xo2);
    }

    private void oXxOI0oIx(String str) {
        int i;
        char c;
        char c2;
        if (str == null) {
            str = this.f27035oOoXoXO;
        }
        if (str == null) {
            return;
        }
        if (this.f34180o00) {
            i = com.univocity.parsers.common.II0xO0.XoX(str);
        } else {
            i = 0;
        }
        int length = str.length();
        int i2 = i;
        char c3 = 0;
        while (i < length) {
            c3 = str.charAt(i);
            if (c3 == '\t' || c3 == '\n' || c3 == '\r' || c3 == '\\') {
                this.f27038x0XOIxOo.oOoXoXO(str, i2, i);
                i2 = i + 1;
                this.f27038x0XOIxOo.append(this.f34178X0IIOO);
                if (c3 == '\t') {
                    this.f27038x0XOIxOo.append('t');
                } else if (c3 == '\n') {
                    xoIox xoiox = this.f27038x0XOIxOo;
                    if (this.f34176O0xOxO) {
                        c2 = this.f34179XI0IXoo;
                    } else {
                        c2 = 'n';
                    }
                    xoiox.append(c2);
                } else if (c3 == '\\') {
                    this.f27038x0XOIxOo.append('\\');
                } else if (c3 == '\r') {
                    xoIox xoiox2 = this.f27038x0XOIxOo;
                    if (this.f34176O0xOxO) {
                        c = this.f34179XI0IXoo;
                    } else {
                        c = 'r';
                    }
                    xoiox2.append(c);
                }
            }
            i++;
        }
        this.f27038x0XOIxOo.oOoXoXO(str, i2, i);
        if (c3 <= ' ' && this.f34177OxI) {
            this.f27038x0XOIxOo.Oxx0xo();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.univocity.parsers.common.II0xO0
    /* renamed from: XOxxooXI, reason: merged with bridge method [inline-methods] */
    public final void IIXOooo(XO xo2) {
        this.f34178X0IIOO = ((oIX0oI) xo2.xxIXOIIO()).x0xO0oo();
        this.f34180o00 = xo2.OOXIXo();
        this.f34177OxI = xo2.oOoXoXO();
        this.f34176O0xOxO = xo2.x0o();
        this.f34179XI0IXoo = ((oIX0oI) xo2.xxIXOIIO()).Oxx0IOOO();
    }

    @Override // com.univocity.parsers.common.II0xO0
    public void o0(Object[] objArr) {
        String str;
        for (int i = 0; i < objArr.length; i++) {
            if (i != 0) {
                II0XooXoX('\t');
            }
            String OxxIIOOXO2 = OxxIIOOXO(objArr[i]);
            int length = this.f27038x0XOIxOo.length();
            oXxOI0oIx(OxxIIOOXO2);
            if (this.f27038x0XOIxOo.length() == length && (str = this.f27035oOoXoXO) != null && !str.isEmpty()) {
                oXxOI0oIx(this.f27035oOoXoXO);
            }
            xxIXOIIO();
        }
    }

    public X0o0xo(Writer writer, XO xo2) {
        super(writer, xo2);
    }

    public X0o0xo(File file, XO xo2) {
        super(file, xo2);
    }

    public X0o0xo(File file, String str, XO xo2) {
        super(file, str, xo2);
    }

    public X0o0xo(File file, Charset charset, XO xo2) {
        super(file, charset, xo2);
    }

    public X0o0xo(OutputStream outputStream, XO xo2) {
        super(outputStream, xo2);
    }

    public X0o0xo(OutputStream outputStream, String str, XO xo2) {
        super(outputStream, str, xo2);
    }

    public X0o0xo(OutputStream outputStream, Charset charset, XO xo2) {
        super(outputStream, charset, xo2);
    }
}
