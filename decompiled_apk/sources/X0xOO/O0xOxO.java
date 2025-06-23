package X0xOO;

import X0xOO.xI;
import com.huawei.openalliance.ad.constant.x;
import java.io.BufferedWriter;
import java.io.IOException;

/* loaded from: classes6.dex */
public class O0xOxO {

    /* renamed from: II0xO0, reason: collision with root package name */
    public BufferedWriter f3334II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public xxX f3335oIX0oI;

    public O0xOxO(xxX xxx2, BufferedWriter bufferedWriter) {
        this.f3335oIX0oI = xxx2;
        this.f3334II0xO0 = bufferedWriter;
    }

    public final void I0Io(X0IIOO x0iioo, int i) throws IOException {
        oxoX(i);
        XIxXXX0x0 xxIXOIIO2 = x0iioo.xxIXOIIO();
        this.f3334II0xO0.write(Integer.toString(xxIXOIIO2.II0xO0(), 16));
        this.f3334II0xO0.write(" - ");
        if (xxIXOIIO2 == XIxXXX0x0.f3424oxoX) {
            this.f3334II0xO0.write("Dgg Container");
            this.f3334II0xO0.newLine();
            return;
        }
        if (xxIXOIIO2 == XIxXXX0x0.f3419X0o0xo) {
            this.f3334II0xO0.write("BStore Container");
            this.f3334II0xO0.newLine();
            return;
        }
        if (xxIXOIIO2 == XIxXXX0x0.f3420XO) {
            this.f3334II0xO0.write("Dg Container");
            this.f3334II0xO0.newLine();
            return;
        }
        if (xxIXOIIO2 == XIxXXX0x0.f3418Oxx0IOOO) {
            this.f3334II0xO0.write("Spgr Container");
            this.f3334II0xO0.newLine();
            return;
        }
        if (xxIXOIIO2 == XIxXXX0x0.f3413II0XooXoX) {
            this.f3334II0xO0.write("Sp Container");
            this.f3334II0xO0.newLine();
            return;
        }
        if (xxIXOIIO2 == XIxXXX0x0.f3428xxIXOIIO) {
            this.f3334II0xO0.write("Dgg");
            this.f3334II0xO0.newLine();
            return;
        }
        if (xxIXOIIO2 == XIxXXX0x0.f3427xoIox) {
            this.f3334II0xO0.write("Bse");
            this.f3334II0xO0.newLine();
            return;
        }
        if (xxIXOIIO2 == XIxXXX0x0.f3416OOXIXo) {
            x0XOIxOo x0xoixoo = new x0XOIxOo(x0iioo.I0Io());
            this.f3334II0xO0.write("Dg:  drawing id " + x0xoixoo.x0XOIxOo() + " shape count " + x0xoixoo.oO());
            this.f3334II0xO0.newLine();
            return;
        }
        if (xxIXOIIO2 == XIxXXX0x0.f3422oOoXoXO) {
            this.f3334II0xO0.write("Spgr");
            this.f3334II0xO0.newLine();
            return;
        }
        if (xxIXOIIO2 == XIxXXX0x0.f3423ooOOo0oXI) {
            X00IoxXI x00IoxXI = new X00IoxXI(x0iioo.I0Io());
            this.f3334II0xO0.write("Sp:  shape id " + x00IoxXI.x0XOIxOo() + " shape type " + x00IoxXI.oO());
            this.f3334II0xO0.newLine();
            return;
        }
        if (xxIXOIIO2 == XIxXXX0x0.f3425x0XOIxOo) {
            xI xIVar = new xI(x0iioo.I0Io());
            xI.oIX0oI x0xO0oo2 = xIVar.x0xO0oo(260);
            xI.oIX0oI x0xO0oo3 = xIVar.x0xO0oo(261);
            this.f3334II0xO0.write("Opt (value, stringValue): ");
            if (x0xO0oo2 != null) {
                this.f3334II0xO0.write("260: " + x0xO0oo2.f3628oxoX + ", " + x0xO0oo2.f3626X0o0xo + x.aL);
            }
            if (x0xO0oo3 != null) {
                this.f3334II0xO0.write("261: " + x0xO0oo3.f3628oxoX + ", " + x0xO0oo3.f3626X0o0xo + x.aL);
            }
            this.f3334II0xO0.newLine();
            return;
        }
        if (xxIXOIIO2 == XIxXXX0x0.f3421oO) {
            this.f3334II0xO0.write("Client Anchor");
            this.f3334II0xO0.newLine();
            return;
        }
        if (xxIXOIIO2 == XIxXXX0x0.f3426x0xO0oo) {
            this.f3334II0xO0.write("Client Data");
            this.f3334II0xO0.newLine();
        } else if (xxIXOIIO2 == XIxXXX0x0.f3417Oo) {
            this.f3334II0xO0.write("Client Text Box");
            this.f3334II0xO0.newLine();
        } else if (xxIXOIIO2 == XIxXXX0x0.f3415IXxxXO) {
            this.f3334II0xO0.write("Split Menu Colors");
            this.f3334II0xO0.newLine();
        } else {
            this.f3334II0xO0.write("???");
            this.f3334II0xO0.newLine();
        }
    }

    public final void II0xO0(OxI oxI, int i) throws IOException {
        I0Io(oxI, i);
        int i2 = i + 1;
        for (X0IIOO x0iioo : oxI.oO()) {
            if (x0iioo.I0Io().xoIox()) {
                II0xO0((OxI) x0iioo, i2);
            } else {
                I0Io(x0iioo, i2);
            }
        }
    }

    public void oIX0oI() throws IOException {
        II0xO0(new OxI(new XI0IXoo(this.f3335oIX0oI, 0)), 0);
    }

    public final void oxoX(int i) throws IOException {
        for (int i2 = 0; i2 < i * 2; i2++) {
            this.f3334II0xO0.write(32);
        }
    }
}
