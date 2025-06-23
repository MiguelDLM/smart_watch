package Ix0x;

/* loaded from: classes13.dex */
public class x0xO0oo extends OOXIXo {

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public static x0xO0oo f1020oI0IIXIo;

    public static x0xO0oo OOXIxO0() {
        x0xO0oo x0xo0oo = f1020oI0IIXIo;
        if (x0xo0oo == null) {
            x0xO0oo x0xo0oo2 = new x0xO0oo();
            f1020oI0IIXIo = x0xo0oo2;
            return x0xo0oo2;
        }
        return x0xo0oo;
    }

    @Override // Ix0x.OOXIXo, Ix0x.II0XooXoX
    public double I0Io() {
        double oX2 = oX();
        boolean oOoXoXO2 = oOoXoXO();
        double d = this.f973II0xO0;
        if (oOoXoXO2) {
            return (((((d * 0.0245d) + 1.5458d) - (this.f982oxoX * 0.0063d)) + (this.f978oIX0oI * 0.0644d)) - ((this.f976X0o0xo * 2.0E-4d) / 1000.0d)) + (1.2573d / oX2);
        }
        return (((((d * 0.032d) + 0.8935d) - (this.f982oxoX * 0.0064d)) + (this.f978oIX0oI * 0.0445d)) - ((this.f976X0o0xo * 0.0029d) / 1000.0d)) - (17.995d / oX2);
    }

    @Override // Ix0x.OOXIXo, Ix0x.II0XooXoX
    public double Ioxxx() {
        double d;
        double d2;
        double oX2 = oX();
        boolean oOoXoXO2 = oOoXoXO();
        double d3 = this.f973II0xO0;
        if (oOoXoXO2) {
            d = (74.2077d - (d3 * 0.113d)) + (this.f982oxoX * 0.1204d) + (this.f978oIX0oI * 0.0113d) + ((this.f976X0o0xo * 0.0191d) / 1000.0d);
            d2 = 664.217d;
        } else {
            d = (88.1858d - (d3 * 0.201d)) + (this.f982oxoX * 0.1515d) + (this.f978oIX0oI * 0.0061d) + ((this.f976X0o0xo * 0.0232d) / 1000.0d);
            d2 = 551.2267d;
        }
        double d4 = d - (d2 / oX2);
        if (d4 <= XIXIX.OOXIXo.f3760XO) {
            return XIXIX.OOXIXo.f3760XO;
        }
        return d4;
    }

    @Override // Ix0x.II0XooXoX
    public int Xo0() {
        double d;
        double d2;
        double d3;
        if (oOoXoXO()) {
            d = ((this.f973II0xO0 * 5.746d) + 75.0176d) - (this.f982oxoX * 7.8251d);
            d2 = this.f978oIX0oI;
            d3 = 15.762d;
        } else {
            d = ((this.f973II0xO0 * 2.3919d) + 889.2632d) - (this.f982oxoX * 6.3097d);
            d2 = this.f978oIX0oI;
            d3 = 12.9041d;
        }
        return (int) (d + (d2 * d3));
    }

    @Override // Ix0x.OOXIXo, Ix0x.II0XooXoX
    public double ox() {
        double d;
        double d2;
        double oX2 = oX();
        boolean oOoXoXO2 = oOoXoXO();
        double d3 = this.f973II0xO0;
        if (oOoXoXO2) {
            d = ((((d3 * 0.0835d) + 19.0424d) - (this.f982oxoX * 0.0888d)) - (this.f978oIX0oI * 0.0086d)) - ((this.f976X0o0xo * 0.0141d) / 1000.0d);
            d2 = 491.1694d;
        } else {
            d = ((((d3 * 0.1492d) + 8.6017d) - (this.f982oxoX * 0.1118d)) - (this.f978oIX0oI * 0.0045d)) - ((this.f976X0o0xo * 0.017d) / 1000.0d);
            d2 = 406.9141d;
        }
        return d + (d2 / oX2);
    }

    @Override // Ix0x.OOXIXo, Ix0x.II0XooXoX
    public double xxIO() {
        double oX2 = oX();
        boolean oOoXoXO2 = oOoXoXO();
        double d = this.f973II0xO0;
        if (oOoXoXO2) {
            return (((49.7124d - (d * 0.1129d)) - (this.f982oxoX * 0.1403d)) - (this.f978oIX0oI * 0.0112d)) + ((this.f976X0o0xo * 7.0E-4d) / 1000.0d) + (439.5602d / oX2);
        }
        return (((((d * 0.0723d) + 28.4579d) - (this.f982oxoX * 0.1798d)) - (this.f978oIX0oI * 0.0624d)) - ((this.f976X0o0xo * 0.0154d) / 1000.0d)) + (108.6855d / oX2);
    }
}
