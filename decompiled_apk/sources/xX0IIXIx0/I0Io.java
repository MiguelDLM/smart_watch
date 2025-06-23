package xX0IIXIx0;

import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;

/* loaded from: classes9.dex */
public abstract class I0Io extends Oxx0IOOO {

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public oIX0oI f34506Oxx0IOOO;

    /* loaded from: classes9.dex */
    public class oIX0oI {

        /* renamed from: I0Io, reason: collision with root package name */
        public int f34507I0Io;

        /* renamed from: II0xO0, reason: collision with root package name */
        public int f34508II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public int f34509oIX0oI;

        public oIX0oI() {
        }

        public void oIX0oI(OOXIxO0.II0xO0 iI0xO0, IIxOXoOo0.II0xO0 iI0xO02) {
            int oxoX2;
            float max = Math.max(0.0f, Math.min(1.0f, I0Io.this.f34530II0xO0.II0XooXoX()));
            float lowestVisibleX = iI0xO0.getLowestVisibleX();
            float highestVisibleX = iI0xO0.getHighestVisibleX();
            T Ix00oIoI2 = iI0xO02.Ix00oIoI(lowestVisibleX, Float.NaN, DataSet.Rounding.DOWN);
            T Ix00oIoI3 = iI0xO02.Ix00oIoI(highestVisibleX, Float.NaN, DataSet.Rounding.UP);
            int i = 0;
            if (Ix00oIoI2 == 0) {
                oxoX2 = 0;
            } else {
                oxoX2 = iI0xO02.oxoX(Ix00oIoI2);
            }
            this.f34509oIX0oI = oxoX2;
            if (Ix00oIoI3 != 0) {
                i = iI0xO02.oxoX(Ix00oIoI3);
            }
            this.f34508II0xO0 = i;
            this.f34507I0Io = (int) ((i - this.f34509oIX0oI) * max);
        }
    }

    public I0Io(Ioxxx.oIX0oI oix0oi, XIXIX.oOoXoXO oooxoxo) {
        super(oix0oi, oooxoxo);
        this.f34506Oxx0IOOO = new oIX0oI();
    }

    public boolean oOoXoXO(Entry entry, IIxOXoOo0.II0xO0 iI0xO0) {
        if (entry == null || iI0xO0.oxoX(entry) >= iI0xO0.X0xxXX0() * this.f34530II0xO0.II0XooXoX()) {
            return false;
        }
        return true;
    }

    public boolean ooOOo0oXI(IIxOXoOo0.X0o0xo x0o0xo) {
        if (x0o0xo.isVisible() && (x0o0xo.xoO0xx0() || x0o0xo.oo0xXOI0I())) {
            return true;
        }
        return false;
    }
}
