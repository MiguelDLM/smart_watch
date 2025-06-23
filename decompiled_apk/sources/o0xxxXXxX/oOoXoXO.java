package o0xxxXXxX;

import android.util.Log;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.data.Entry;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes9.dex */
public class oOoXoXO extends I0Io<IIxOXoOo0.II0xO0<? extends Entry>> {

    /* renamed from: OOXIXo, reason: collision with root package name */
    public oIX0oI f31290OOXIXo;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public oI0IIXIo f31291oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public xxIXOIIO f31292ooOOo0oXI;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public Oxx0IOOO f31293x0XOIxOo;

    /* renamed from: xoIox, reason: collision with root package name */
    public ooOOo0oXI f31294xoIox;

    public void I0X0x0oIo(oI0IIXIo oi0iixio) {
        this.f31291oOoXoXO = oi0iixio;
        XxX0x0xxx();
    }

    public ooOOo0oXI I0oOoX() {
        return this.f31294xoIox;
    }

    public I0Io Io(int i) {
        return xII().get(i);
    }

    public xxIXOIIO OI0() {
        return this.f31292ooOOo0oXI;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [IIxOXoOo0.X0o0xo] */
    @Override // o0xxxXXxX.OOXIXo
    public Entry Oxx0xo(XI0oooXX.oxoX oxox) {
        if (oxox.I0Io() >= xII().size()) {
            return null;
        }
        I0Io Io2 = Io(oxox.I0Io());
        if (oxox.oxoX() >= Io2.ooOOo0oXI()) {
            return null;
        }
        for (Entry entry : Io2.OOXIXo(oxox.oxoX()).OxxIIOOXO(oxox.II0XooXoX())) {
            if (entry.I0Io() == oxox.xoIox() || Float.isNaN(oxox.xoIox())) {
                return entry;
            }
        }
        return null;
    }

    public Oxx0IOOO XOxIOxOx() {
        return this.f31293x0XOIxOo;
    }

    public IIxOXoOo0.II0xO0<? extends Entry> XX(XI0oooXX.oxoX oxox) {
        if (oxox.I0Io() >= xII().size()) {
            return null;
        }
        I0Io Io2 = Io(oxox.I0Io());
        if (oxox.oxoX() >= Io2.ooOOo0oXI()) {
            return null;
        }
        return (IIxOXoOo0.II0xO0) Io2.Oo().get(oxox.oxoX());
    }

    public void XX0(ooOOo0oXI ooooo0oxi) {
        this.f31294xoIox = ooooo0oxi;
        XxX0x0xxx();
    }

    @Override // o0xxxXXxX.OOXIXo
    /* renamed from: XoX, reason: merged with bridge method [inline-methods] */
    public boolean IIX0o(IIxOXoOo0.II0xO0<? extends Entry> iI0xO0) {
        Iterator<I0Io> it = xII().iterator();
        boolean z = false;
        while (it.hasNext() && !(z = it.next().IIX0o(iI0xO0))) {
        }
        return z;
    }

    @Override // o0xxxXXxX.OOXIXo
    public void XxX0x0xxx() {
        ooOOo0oXI ooooo0oxi = this.f31294xoIox;
        if (ooooo0oxi != null) {
            ooooo0oxi.XxX0x0xxx();
        }
        oIX0oI oix0oi = this.f31290OOXIXo;
        if (oix0oi != null) {
            oix0oi.XxX0x0xxx();
        }
        xxIXOIIO xxixoiio = this.f31292ooOOo0oXI;
        if (xxixoiio != null) {
            xxixoiio.XxX0x0xxx();
        }
        oI0IIXIo oi0iixio = this.f31291oOoXoXO;
        if (oi0iixio != null) {
            oi0iixio.XxX0x0xxx();
        }
        Oxx0IOOO oxx0IOOO = this.f31293x0XOIxOo;
        if (oxx0IOOO != null) {
            oxx0IOOO.XxX0x0xxx();
        }
        oxoX();
    }

    public int o0(OOXIXo oOXIXo) {
        return xII().indexOf(oOXIXo);
    }

    @Override // o0xxxXXxX.OOXIXo
    @Deprecated
    public boolean ooXIXxIX(float f, int i) {
        Log.e(Chart.f15859o0, "removeEntry(...) not supported for CombinedData");
        return false;
    }

    public void oxXx0IX(oIX0oI oix0oi) {
        this.f31290OOXIXo = oix0oi;
        XxX0x0xxx();
    }

    @Override // o0xxxXXxX.OOXIXo
    public void oxoX() {
        if (this.f31251xxIXOIIO == null) {
            this.f31251xxIXOIIO = new ArrayList();
        }
        this.f31251xxIXOIIO.clear();
        this.f31249oIX0oI = -3.4028235E38f;
        this.f31245II0xO0 = Float.MAX_VALUE;
        this.f31243I0Io = -3.4028235E38f;
        this.f31250oxoX = Float.MAX_VALUE;
        this.f31247X0o0xo = -3.4028235E38f;
        this.f31248XO = Float.MAX_VALUE;
        this.f31246Oxx0IOOO = -3.4028235E38f;
        this.f31244II0XooXoX = Float.MAX_VALUE;
        for (I0Io i0Io : xII()) {
            i0Io.oxoX();
            this.f31251xxIXOIIO.addAll(i0Io.Oo());
            if (i0Io.O0xOxO() > this.f31249oIX0oI) {
                this.f31249oIX0oI = i0Io.O0xOxO();
            }
            if (i0Io.XI0IXoo() < this.f31245II0xO0) {
                this.f31245II0xO0 = i0Io.XI0IXoo();
            }
            if (i0Io.o00() > this.f31243I0Io) {
                this.f31243I0Io = i0Io.o00();
            }
            if (i0Io.OxI() < this.f31250oxoX) {
                this.f31250oxoX = i0Io.OxI();
            }
            float f = i0Io.f31247X0o0xo;
            if (f > this.f31247X0o0xo) {
                this.f31247X0o0xo = f;
            }
            float f2 = i0Io.f31248XO;
            if (f2 < this.f31248XO) {
                this.f31248XO = f2;
            }
            float f3 = i0Io.f31246Oxx0IOOO;
            if (f3 > this.f31246Oxx0IOOO) {
                this.f31246Oxx0IOOO = f3;
            }
            float f4 = i0Io.f31244II0XooXoX;
            if (f4 < this.f31244II0XooXoX) {
                this.f31244II0XooXoX = f4;
            }
        }
    }

    public oI0IIXIo oxxXoxO() {
        return this.f31291oOoXoXO;
    }

    public oIX0oI x0o() {
        return this.f31290OOXIXo;
    }

    @Override // o0xxxXXxX.OOXIXo
    @Deprecated
    public boolean xI(Entry entry, int i) {
        Log.e(Chart.f15859o0, "removeEntry(...) not supported for CombinedData");
        return false;
    }

    public List<I0Io> xII() {
        ArrayList arrayList = new ArrayList();
        ooOOo0oXI ooooo0oxi = this.f31294xoIox;
        if (ooooo0oxi != null) {
            arrayList.add(ooooo0oxi);
        }
        oIX0oI oix0oi = this.f31290OOXIXo;
        if (oix0oi != null) {
            arrayList.add(oix0oi);
        }
        oI0IIXIo oi0iixio = this.f31291oOoXoXO;
        if (oi0iixio != null) {
            arrayList.add(oi0iixio);
        }
        xxIXOIIO xxixoiio = this.f31292ooOOo0oXI;
        if (xxixoiio != null) {
            arrayList.add(xxixoiio);
        }
        Oxx0IOOO oxx0IOOO = this.f31293x0XOIxOo;
        if (oxx0IOOO != null) {
            arrayList.add(oxx0IOOO);
        }
        return arrayList;
    }

    public void xXOx(xxIXOIIO xxixoiio) {
        this.f31292ooOOo0oXI = xxixoiio;
        XxX0x0xxx();
    }

    @Override // o0xxxXXxX.OOXIXo
    @Deprecated
    public boolean xXxxox0I(int i) {
        Log.e(Chart.f15859o0, "removeDataSet(int index) not supported for CombinedData");
        return false;
    }

    public void xo0x(Oxx0IOOO oxx0IOOO) {
        this.f31293x0XOIxOo = oxx0IOOO;
        XxX0x0xxx();
    }
}
