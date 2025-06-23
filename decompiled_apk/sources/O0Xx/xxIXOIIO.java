package O0Xx;

import com.garmin.fit.Fit;
import com.garmin.fit.I0;
import com.garmin.fit.IIxOXoOo0;
import com.garmin.fit.IXIxx0;
import com.garmin.fit.O0xO0;
import com.garmin.fit.X0xII0I;
import com.garmin.fit.XXXI;
import com.garmin.fit.oIXoXx0;
import com.garmin.fit.x0OxxIOxX;
import com.garmin.fit.xooxxX;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes9.dex */
public class xxIXOIIO extends xoIox implements IXIxx0, O0xO0 {

    /* renamed from: OOXIXo, reason: collision with root package name */
    public int f1464OOXIXo;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public boolean f1465oOoXoXO;

    /* renamed from: xoIox, reason: collision with root package name */
    public int f1466xoIox;

    public xxIXOIIO(ByteArrayOutputStream byteArrayOutputStream) {
        super(byteArrayOutputStream);
        this.f1466xoIox = 0;
        this.f1464OOXIXo = 0;
    }

    @Override // com.garmin.fit.IXIxx0
    public void II0xO0(oIXoXx0 oixoxx0) {
        Collection<X0xII0I> XIXIxO2 = oixoxx0.XIXIxO();
        if (oixoxx0.x0OIX00oO().equals("unknown") && this.f1459X0o0xo) {
            this.f1466xoIox++;
            return;
        }
        this.f1461oIX0oI.oIX0oI();
        this.f1461oIX0oI.oxoX("Type", "Data");
        this.f1461oIX0oI.oxoX("Local Number", Integer.valueOf(oixoxx0.OIOoIIOIx()));
        this.f1461oIX0oI.oxoX("Message", oixoxx0.x0OIX00oO());
        if (this.f1458Oxx0IOOO) {
            oixoxx0.xxOXOOoIX();
        }
        int i = 0;
        for (X0xII0I x0xII0I : XIXIxO2) {
            int xoIox2 = oixoxx0.xoIox(x0xII0I.OooI());
            if (!x0xII0I.getName().equals("unknown") || !this.f1459X0o0xo) {
                i++;
                this.f1461oIX0oI.oxoX("Field " + i, x0xII0I.OO(xoIox2));
                String oO2 = oO(x0xII0I, xoIox2);
                this.f1461oIX0oI.oxoX("Value " + i, oO2);
                this.f1461oIX0oI.oxoX("Units " + i, x0XOIxOo(x0xII0I.OIOoIIOIx(), x0xII0I.OIx00oxx().name()));
            }
        }
        for (IIxOXoOo0 iIxOXoOo0 : oixoxx0.x0XOIxOo()) {
            if (iIxOXoOo0.xOOxIO() || !this.f1459X0o0xo) {
                i++;
                this.f1461oIX0oI.oxoX("Field " + i, iIxOXoOo0.getName());
                String oO3 = oO(iIxOXoOo0, 65535);
                this.f1461oIX0oI.oxoX("Value " + i, oO3);
                this.f1461oIX0oI.oxoX("Units " + i, ooOOo0oXI(iIxOXoOo0.OIOoIIOIx()));
            }
        }
        this.f1461oIX0oI.XO();
        this.f1465oOoXoXO = true;
    }

    public int O0xOxO() {
        return this.f1466xoIox;
    }

    public int OxI() {
        return this.f1464OOXIXo;
    }

    public boolean o00() {
        return this.f1465oOoXoXO;
    }

    @Override // O0Xx.xoIox
    public void oIX0oI() {
        this.f1461oIX0oI.II0xO0();
    }

    @Override // com.garmin.fit.O0xO0
    public void oxoX(xooxxX xooxxx) {
        ArrayList<XXXI> II0XooXoX2 = xooxxx.II0XooXoX();
        oIXoXx0 XO2 = x0OxxIOxX.XO(xooxxx.xoIox());
        if (this.f1459X0o0xo && XO2.x0OIX00oO().equals("unknown")) {
            return;
        }
        this.f1461oIX0oI.oIX0oI();
        this.f1461oIX0oI.oxoX("Type", "Definition");
        this.f1461oIX0oI.oxoX("Local Number", Integer.valueOf(xooxxx.xxIXOIIO()));
        this.f1461oIX0oI.oxoX("Message", XO2.x0OIX00oO());
        int i = 0;
        for (XXXI xxxi : II0XooXoX2) {
            X0xII0I oIX0oI2 = x0OxxIOxX.oIX0oI(xooxxx.xoIox(), xxxi.I0Io());
            if (this.f1459X0o0xo && oIX0oI2.getName().equals("unknown")) {
                this.f1464OOXIXo++;
            } else {
                i++;
                this.f1461oIX0oI.oxoX("Field " + i, oIX0oI2.getName());
                this.f1461oIX0oI.oxoX("Value " + i, Integer.valueOf(xxxi.oIX0oI() / Fit.f11152IoXIXo[xxxi.oxoX() & 31]));
                this.f1461oIX0oI.oxoX("Units " + i, "");
            }
        }
        for (I0 i0 : xooxxx.XO()) {
            if (this.f1459X0o0xo && !i0.x0XOIxOo()) {
                this.f1464OOXIXo++;
            } else {
                i++;
                if (!i0.x0XOIxOo()) {
                    this.f1461oIX0oI.oxoX("Field " + i, "undefined-dev-data");
                } else {
                    this.f1461oIX0oI.oxoX("Field " + i, i0.Oxx0IOOO());
                }
                this.f1461oIX0oI.oxoX("Value " + i, Integer.valueOf(i0.oIX0oI() / Fit.f11152IoXIXo[i0.oOoXoXO() & 31]));
                this.f1461oIX0oI.oxoX("Units " + i, "");
            }
        }
        this.f1461oIX0oI.XO();
        this.f1465oOoXoXO = true;
    }
}
