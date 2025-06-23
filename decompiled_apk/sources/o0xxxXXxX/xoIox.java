package o0xxxXXxX;

import android.graphics.Paint;
import com.github.mikephil.charting.data.CandleEntry;
import com.github.mikephil.charting.data.DataSet;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes9.dex */
public class xoIox extends oO<CandleEntry> implements IIxOXoOo0.oxoX {

    /* renamed from: IIX0o, reason: collision with root package name */
    public Paint.Style f31301IIX0o;

    /* renamed from: IoOoX, reason: collision with root package name */
    public int f31302IoOoX;

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public float f31303XIxXXX0x0;

    /* renamed from: XxX0x0xxx, reason: collision with root package name */
    public float f31304XxX0x0xxx;

    /* renamed from: oo, reason: collision with root package name */
    public int f31305oo;

    /* renamed from: oo0xXOI0I, reason: collision with root package name */
    public int f31306oo0xXOI0I;

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    public Paint.Style f31307ooXIXxIX;

    /* renamed from: xI, reason: collision with root package name */
    public int f31308xI;

    /* renamed from: xXxxox0I, reason: collision with root package name */
    public boolean f31309xXxxox0I;

    /* renamed from: xxX, reason: collision with root package name */
    public boolean f31310xxX;

    public xoIox(List<CandleEntry> list, String str) {
        super(list, str);
        this.f31303XIxXXX0x0 = 3.0f;
        this.f31310xxX = true;
        this.f31304XxX0x0xxx = 0.1f;
        this.f31309xXxxox0I = false;
        this.f31301IIX0o = Paint.Style.STROKE;
        this.f31307ooXIXxIX = Paint.Style.FILL;
        this.f31308xI = XIXIX.oIX0oI.f3778II0xO0;
        this.f31306oo0xXOI0I = XIXIX.oIX0oI.f3778II0xO0;
        this.f31305oo = XIXIX.oIX0oI.f3778II0xO0;
        this.f31302IoOoX = XIXIX.oIX0oI.f3778II0xO0;
    }

    public void IIOIX(int i) {
        this.f31302IoOoX = i;
    }

    public void OOIXx0x(xoIox xoiox) {
        super.o0oxo0oI(xoiox);
        xoiox.f31303XIxXXX0x0 = this.f31303XIxXXX0x0;
        xoiox.f31310xxX = this.f31310xxX;
        xoiox.f31304XxX0x0xxx = this.f31304XxX0x0xxx;
        xoiox.f31309xXxxox0I = this.f31309xXxxox0I;
        xoiox.f31295o00 = this.f31295o00;
        xoiox.f31301IIX0o = this.f31301IIX0o;
        xoiox.f31307ooXIXxIX = this.f31307ooXIXxIX;
        xoiox.f31308xI = this.f31308xI;
        xoiox.f31306oo0xXOI0I = this.f31306oo0xXOI0I;
        xoiox.f31305oo = this.f31305oo;
        xoiox.f31302IoOoX = this.f31302IoOoX;
    }

    @Override // com.github.mikephil.charting.data.DataSet
    /* renamed from: OXXoIoXI, reason: merged with bridge method [inline-methods] */
    public void oxOXxoXII(CandleEntry candleEntry) {
        if (candleEntry.oO() < this.f16011OxxIIOOXO) {
            this.f16011OxxIIOOXO = candleEntry.oO();
        }
        if (candleEntry.x0XOIxOo() > this.f16012oI0IIXIo) {
            this.f16012oI0IIXIo = candleEntry.x0XOIxOo();
        }
        IxX00(candleEntry);
    }

    @Override // IIxOXoOo0.oxoX
    public boolean X0IIOO() {
        return this.f31310xxX;
    }

    public void X0ooXIooI(float f) {
        this.f31303XIxXXX0x0 = XIXIX.OOXIXo.X0o0xo(f);
    }

    @Override // IIxOXoOo0.oxoX
    public boolean XI0oooXX() {
        return this.f31309xXxxox0I;
    }

    @Override // IIxOXoOo0.oxoX
    public float XIXIxO() {
        return this.f31304XxX0x0xxx;
    }

    public void Xo(Paint.Style style) {
        this.f31301IIX0o = style;
    }

    @Override // IIxOXoOo0.oxoX
    public int XoI0Ixx0() {
        return this.f31305oo;
    }

    public void XoOxI0ox(boolean z) {
        this.f31309xXxxox0I = z;
    }

    @Override // com.github.mikephil.charting.data.DataSet
    /* renamed from: XooIO0oo0, reason: merged with bridge method [inline-methods] */
    public void XO0o(CandleEntry candleEntry) {
        if (candleEntry.x0XOIxOo() < this.f16011OxxIIOOXO) {
            this.f16011OxxIIOOXO = candleEntry.x0XOIxOo();
        }
        if (candleEntry.x0XOIxOo() > this.f16012oI0IIXIo) {
            this.f16012oI0IIXIo = candleEntry.x0XOIxOo();
        }
        if (candleEntry.oO() < this.f16011OxxIIOOXO) {
            this.f16011OxxIIOOXO = candleEntry.oO();
        }
        if (candleEntry.oO() > this.f16012oI0IIXIo) {
            this.f16012oI0IIXIo = candleEntry.oO();
        }
    }

    @Override // IIxOXoOo0.oxoX
    public int o00() {
        return this.f31306oo0xXOI0I;
    }

    public void oX000x(boolean z) {
        this.f31310xxX = z;
    }

    @Override // com.github.mikephil.charting.data.DataSet
    public DataSet<CandleEntry> oX0I0O() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.f16010Oxx0xo.size(); i++) {
            arrayList.add(((CandleEntry) this.f16010Oxx0xo.get(i)).Oxx0IOOO());
        }
        xoIox xoiox = new xoIox(arrayList, getLabel());
        OOIXx0x(xoiox);
        return xoiox;
    }

    @Override // IIxOXoOo0.oxoX
    public int oXIO0o0XI() {
        return this.f31308xI;
    }

    public void oXO0oOx0(int i) {
        this.f31308xI = i;
    }

    public void oXxx000(int i) {
        this.f31305oo = i;
    }

    @Override // IIxOXoOo0.oxoX
    public Paint.Style oxIIX0o() {
        return this.f31307ooXIXxIX;
    }

    @Override // IIxOXoOo0.oxoX
    public int x0() {
        return this.f31302IoOoX;
    }

    @Override // IIxOXoOo0.oxoX
    public Paint.Style xII() {
        return this.f31301IIX0o;
    }

    public void xIx(int i) {
        this.f31306oo0xXOI0I = i;
    }

    public void xIx0XO(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (f > 0.45f) {
            f = 0.45f;
        }
        this.f31304XxX0x0xxx = f;
    }

    public void xOOxI(Paint.Style style) {
        this.f31307ooXIXxIX = style;
    }

    @Override // IIxOXoOo0.oxoX
    public float xOoOIoI() {
        return this.f31303XIxXXX0x0;
    }
}
