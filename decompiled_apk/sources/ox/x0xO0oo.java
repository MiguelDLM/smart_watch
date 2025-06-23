package ox;

import XX0xXo.oIX0oI;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.BubbleEntry;
import com.github.mikephil.charting.data.CandleEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.data.RadarEntry;

/* loaded from: classes9.dex */
public abstract class x0xO0oo implements xxIXOIIO, OOXIXo {
    public String I0Io(float f, oIX0oI oix0oi) {
        return II0XooXoX(f);
    }

    public String II0XooXoX(float f) {
        return String.valueOf(f);
    }

    @Override // ox.xxIXOIIO
    @Deprecated
    public String II0xO0(float f, oIX0oI oix0oi) {
        return II0XooXoX(f);
    }

    public String OOXIXo(RadarEntry radarEntry) {
        return II0XooXoX(radarEntry.I0Io());
    }

    public String Oxx0IOOO(CandleEntry candleEntry) {
        return II0XooXoX(candleEntry.x0XOIxOo());
    }

    public String X0o0xo(float f, BarEntry barEntry) {
        return II0XooXoX(f);
    }

    public String XO(BubbleEntry bubbleEntry) {
        return II0XooXoX(bubbleEntry.oOoXoXO());
    }

    @Override // ox.OOXIXo
    @Deprecated
    public String oIX0oI(float f, Entry entry, int i, XIXIX.oOoXoXO oooxoxo) {
        return II0XooXoX(f);
    }

    public String oxoX(BarEntry barEntry) {
        return II0XooXoX(barEntry.I0Io());
    }

    public String xoIox(Entry entry) {
        return II0XooXoX(entry.I0Io());
    }

    public String xxIXOIIO(float f, PieEntry pieEntry) {
        return II0XooXoX(f);
    }
}
