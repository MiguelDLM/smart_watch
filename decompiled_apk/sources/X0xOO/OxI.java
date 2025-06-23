package X0xOO;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes6.dex */
public class OxI extends X0IIOO {

    /* renamed from: XO, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f3341XO = XxIIOXIXx.X0o0xo.Oxx0IOOO(OxI.class);

    /* renamed from: X0o0xo, reason: collision with root package name */
    public ArrayList f3342X0o0xo;

    /* renamed from: oxoX, reason: collision with root package name */
    public boolean f3343oxoX;

    public OxI(XI0IXoo xI0IXoo) {
        super(xI0IXoo);
        this.f3343oxoX = false;
        this.f3342X0o0xo = new ArrayList();
    }

    @Override // X0xOO.X0IIOO
    public byte[] II0xO0() {
        if (!this.f3343oxoX) {
            x0xO0oo();
        }
        byte[] bArr = new byte[0];
        Iterator it = this.f3342X0o0xo.iterator();
        while (it.hasNext()) {
            byte[] II0xO02 = ((X0IIOO) it.next()).II0xO0();
            if (II0xO02 != null) {
                byte[] bArr2 = new byte[bArr.length + II0xO02.length];
                System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                System.arraycopy(II0xO02, 0, bArr2, bArr.length, II0xO02.length);
                bArr = bArr2;
            }
        }
        return OOXIXo(bArr);
    }

    public void Oo(X0IIOO x0iioo) {
        this.f3342X0o0xo.remove(x0iioo);
    }

    public X0IIOO[] oO() {
        if (!this.f3343oxoX) {
            x0xO0oo();
        }
        ArrayList arrayList = this.f3342X0o0xo;
        return (X0IIOO[]) arrayList.toArray(new X0IIOO[arrayList.size()]);
    }

    public void x0XOIxOo(X0IIOO x0iioo) {
        this.f3342X0o0xo.add(x0iioo);
    }

    public final void x0xO0oo() {
        X0IIOO o00Var;
        int Oxx0IOOO2 = Oxx0IOOO() + 8;
        int min = Math.min(Oxx0IOOO() + XO(), II0XooXoX());
        while (Oxx0IOOO2 < min) {
            XI0IXoo xI0IXoo = new XI0IXoo(oxoX(), Oxx0IOOO2);
            XIxXXX0x0 xxIXOIIO2 = xI0IXoo.xxIXOIIO();
            if (xxIXOIIO2 == XIxXXX0x0.f3428xxIXOIIO) {
                o00Var = new x0xO0oo(xI0IXoo);
            } else if (xxIXOIIO2 == XIxXXX0x0.f3416OOXIXo) {
                o00Var = new x0XOIxOo(xI0IXoo);
            } else if (xxIXOIIO2 == XIxXXX0x0.f3419X0o0xo) {
                o00Var = new oIX0oI(xI0IXoo);
            } else if (xxIXOIIO2 == XIxXXX0x0.f3418Oxx0IOOO) {
                o00Var = new x0o(xI0IXoo);
            } else if (xxIXOIIO2 == XIxXXX0x0.f3413II0XooXoX) {
                o00Var = new IO(xI0IXoo);
            } else if (xxIXOIIO2 == XIxXXX0x0.f3422oOoXoXO) {
                o00Var = new xII(xI0IXoo);
            } else if (xxIXOIIO2 == XIxXXX0x0.f3423ooOOo0oXI) {
                o00Var = new X00IoxXI(xI0IXoo);
            } else if (xxIXOIIO2 == XIxXXX0x0.f3421oO) {
                o00Var = new xxIXOIIO(xI0IXoo);
            } else if (xxIXOIIO2 == XIxXXX0x0.f3426x0xO0oo) {
                o00Var = new xoIox(xI0IXoo);
            } else if (xxIXOIIO2 == XIxXXX0x0.f3427xoIox) {
                o00Var = new II0xO0(xI0IXoo);
            } else if (xxIXOIIO2 == XIxXXX0x0.f3425x0XOIxOo) {
                o00Var = new xI(xI0IXoo);
            } else if (xxIXOIIO2 == XIxXXX0x0.f3415IXxxXO) {
                o00Var = new XOxIOxOx(xI0IXoo);
            } else if (xxIXOIIO2 == XIxXXX0x0.f3417Oo) {
                o00Var = new OOXIXo(xI0IXoo);
            } else {
                o00Var = new o00(xI0IXoo);
            }
            this.f3342X0o0xo.add(o00Var);
            Oxx0IOOO2 += o00Var.XO();
        }
        this.f3343oxoX = true;
    }

    public OxI(XIxXXX0x0 xIxXXX0x0) {
        super(xIxXXX0x0);
        xoIox(true);
        this.f3342X0o0xo = new ArrayList();
    }
}
