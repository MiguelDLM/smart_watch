package o0xxxXXxX;

import android.content.Context;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Typeface;
import androidx.core.view.ViewCompat;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes9.dex */
public abstract class X0o0xo<T extends Entry> implements IIxOXoOo0.X0o0xo<T> {

    /* renamed from: I0Io, reason: collision with root package name */
    public List<OX00O0xII.oIX0oI> f31264I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public transient ox.x0xO0oo f31265II0XooXoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    public OX00O0xII.oIX0oI f31266II0xO0;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public boolean f31267IXxxXO;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public float f31268OOXIXo;

    /* renamed from: Oo, reason: collision with root package name */
    public float f31269Oo;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public boolean f31270Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public String f31271X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public YAxis.AxisDependency f31272XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public List<Integer> f31273oIX0oI;

    /* renamed from: oO, reason: collision with root package name */
    public boolean f31274oO;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public float f31275oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public DashPathEffect f31276ooOOo0oXI;

    /* renamed from: oxoX, reason: collision with root package name */
    public List<Integer> f31277oxoX;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public boolean f31278x0XOIxOo;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public XIXIX.Oxx0IOOO f31279x0xO0oo;

    /* renamed from: xoIox, reason: collision with root package name */
    public Legend.LegendForm f31280xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public Typeface f31281xxIXOIIO;

    public X0o0xo() {
        this.f31273oIX0oI = null;
        this.f31266II0xO0 = null;
        this.f31264I0Io = null;
        this.f31277oxoX = null;
        this.f31271X0o0xo = "DataSet";
        this.f31272XO = YAxis.AxisDependency.LEFT;
        this.f31270Oxx0IOOO = true;
        this.f31280xoIox = Legend.LegendForm.DEFAULT;
        this.f31268OOXIXo = Float.NaN;
        this.f31275oOoXoXO = Float.NaN;
        this.f31276ooOOo0oXI = null;
        this.f31278x0XOIxOo = true;
        this.f31274oO = true;
        this.f31279x0xO0oo = new XIXIX.Oxx0IOOO();
        this.f31269Oo = 17.0f;
        this.f31267IXxxXO = true;
        this.f31273oIX0oI = new ArrayList();
        this.f31277oxoX = new ArrayList();
        this.f31273oIX0oI.add(Integer.valueOf(Color.rgb(140, 234, 255)));
        this.f31277oxoX.add(Integer.valueOf(ViewCompat.MEASURED_STATE_MASK));
    }

    @Override // IIxOXoOo0.X0o0xo
    public void I0Io(YAxis.AxisDependency axisDependency) {
        this.f31272XO = axisDependency;
    }

    public void I0xX0() {
        I0();
    }

    @Override // IIxOXoOo0.X0o0xo
    public boolean IIX0(float f) {
        return x0o(Ox0O(f, Float.NaN));
    }

    @Override // IIxOXoOo0.X0o0xo
    public List<OX00O0xII.oIX0oI> IIXOooo() {
        return this.f31264I0Io;
    }

    @Override // IIxOXoOo0.X0o0xo
    public XIXIX.Oxx0IOOO IO0XoXxO() {
        return this.f31279x0xO0oo;
    }

    @Override // IIxOXoOo0.X0o0xo
    public boolean IXO() {
        if (this.f31265II0XooXoX == null) {
            return true;
        }
        return false;
    }

    @Override // IIxOXoOo0.X0o0xo
    public void Io(List<Integer> list) {
        this.f31277oxoX = list;
    }

    @Override // IIxOXoOo0.X0o0xo
    public OX00O0xII.oIX0oI IoIOOxIIo() {
        return this.f31266II0xO0;
    }

    @Override // IIxOXoOo0.X0o0xo
    public int Ioxxx(int i) {
        for (int i2 = 0; i2 < X0xxXX0(); i2++) {
            if (i == OOXIXo(i2).xxIXOIIO()) {
                return i2;
            }
        }
        return -1;
    }

    public void O00(float f) {
        this.f31268OOXIXo = f;
    }

    @Override // IIxOXoOo0.X0o0xo
    public void O0Xx(ox.x0xO0oo x0xo0oo) {
        if (x0xo0oo == null) {
            return;
        }
        this.f31265II0XooXoX = x0xo0oo;
    }

    @Override // IIxOXoOo0.X0o0xo
    public void O0xOxO(boolean z) {
        this.f31278x0XOIxOo = z;
    }

    public void O0xxXxI(List<OX00O0xII.oIX0oI> list) {
        this.f31264I0Io = list;
    }

    public void OIx00oxx(Legend.LegendForm legendForm) {
        this.f31280xoIox = legendForm;
    }

    public void OO0(int[] iArr, int i) {
        Oxx();
        for (int i2 : iArr) {
            oIIxXoo(Color.argb(i, Color.red(i2), Color.green(i2), Color.blue(i2)));
        }
    }

    @Override // IIxOXoOo0.X0o0xo
    public List<Integer> OOXIxO0() {
        return this.f31273oIX0oI;
    }

    public void OX(int i) {
        Oxx();
        this.f31273oIX0oI.add(Integer.valueOf(i));
    }

    @Override // IIxOXoOo0.X0o0xo
    public YAxis.AxisDependency OX00O0xII() {
        return this.f31272XO;
    }

    @Override // IIxOXoOo0.X0o0xo
    public void Oo(float f) {
        this.f31269Oo = XIXIX.OOXIXo.X0o0xo(f);
    }

    public void OooI(int[] iArr, Context context) {
        if (this.f31273oIX0oI == null) {
            this.f31273oIX0oI = new ArrayList();
        }
        this.f31273oIX0oI.clear();
        for (int i : iArr) {
            this.f31273oIX0oI.add(Integer.valueOf(context.getResources().getColor(i)));
        }
    }

    @Override // IIxOXoOo0.X0o0xo
    public boolean OxI(int i) {
        return x0o(OOXIXo(i));
    }

    public void Oxx() {
        if (this.f31273oIX0oI == null) {
            this.f31273oIX0oI = new ArrayList();
        }
        this.f31273oIX0oI.clear();
    }

    @Override // IIxOXoOo0.X0o0xo
    public Legend.LegendForm Oxx0IOOO() {
        return this.f31280xoIox;
    }

    @Override // IIxOXoOo0.X0o0xo
    public float X00IoxXI() {
        return this.f31275oOoXoXO;
    }

    @Override // IIxOXoOo0.X0o0xo
    public boolean XX0() {
        return this.f31270Oxx0IOOO;
    }

    public List<Integer> XXXI() {
        return this.f31277oxoX;
    }

    @Override // IIxOXoOo0.X0o0xo
    public int XXoOx0(int i) {
        List<Integer> list = this.f31273oIX0oI;
        return list.get(i % list.size()).intValue();
    }

    @Override // IIxOXoOo0.X0o0xo
    public void Xo0(String str) {
        this.f31271X0o0xo = str;
    }

    public void XoIxOXIXo(int... iArr) {
        this.f31273oIX0oI = XIXIX.oIX0oI.I0Io(iArr);
    }

    @Override // IIxOXoOo0.X0o0xo
    public void Xx000oIo(int i) {
        this.f31277oxoX.clear();
        this.f31277oxoX.add(Integer.valueOf(i));
    }

    @Override // IIxOXoOo0.X0o0xo
    public String getLabel() {
        return this.f31271X0o0xo;
    }

    @Override // IIxOXoOo0.X0o0xo
    public boolean isVisible() {
        return this.f31267IXxxXO;
    }

    @Override // IIxOXoOo0.X0o0xo
    public void o0(XIXIX.Oxx0IOOO oxx0IOOO) {
        XIXIX.Oxx0IOOO oxx0IOOO2 = this.f31279x0xO0oo;
        oxx0IOOO2.f3771IXxxXO = oxx0IOOO.f3771IXxxXO;
        oxx0IOOO2.f3772Oxx0xo = oxx0IOOO.f3772Oxx0xo;
    }

    public void o0IXXIx(List<Integer> list) {
        this.f31273oIX0oI = list;
    }

    @Override // IIxOXoOo0.X0o0xo
    public float o0oIxOo() {
        return this.f31269Oo;
    }

    public void oIIxXoo(int i) {
        if (this.f31273oIX0oI == null) {
            this.f31273oIX0oI = new ArrayList();
        }
        this.f31273oIX0oI.add(Integer.valueOf(i));
    }

    @Override // IIxOXoOo0.X0o0xo
    public void oIX0oI(boolean z) {
        this.f31270Oxx0IOOO = z;
    }

    @Override // IIxOXoOo0.X0o0xo
    public float oOoXoXO() {
        return this.f31268OOXIXo;
    }

    public void oXIoO(int i, int i2) {
        OX(Color.argb(i2, Color.red(i), Color.green(i), Color.blue(i)));
    }

    public void oXX0IoI(X0o0xo x0o0xo) {
        x0o0xo.f31272XO = this.f31272XO;
        x0o0xo.f31273oIX0oI = this.f31273oIX0oI;
        x0o0xo.f31274oO = this.f31274oO;
        x0o0xo.f31278x0XOIxOo = this.f31278x0XOIxOo;
        x0o0xo.f31280xoIox = this.f31280xoIox;
        x0o0xo.f31276ooOOo0oXI = this.f31276ooOOo0oXI;
        x0o0xo.f31275oOoXoXO = this.f31275oOoXoXO;
        x0o0xo.f31268OOXIXo = this.f31268OOXIXo;
        x0o0xo.f31266II0xO0 = this.f31266II0xO0;
        x0o0xo.f31264I0Io = this.f31264I0Io;
        x0o0xo.f31270Oxx0IOOO = this.f31270Oxx0IOOO;
        x0o0xo.f31279x0xO0oo = this.f31279x0xO0oo;
        x0o0xo.f31277oxoX = this.f31277oxoX;
        x0o0xo.f31265II0XooXoX = this.f31265II0XooXoX;
        x0o0xo.f31277oxoX = this.f31277oxoX;
        x0o0xo.f31269Oo = this.f31269Oo;
        x0o0xo.f31267IXxxXO = this.f31267IXxxXO;
    }

    @Override // IIxOXoOo0.X0o0xo
    public OX00O0xII.oIX0oI oXxOI0oIx(int i) {
        List<OX00O0xII.oIX0oI> list = this.f31264I0Io;
        return list.get(i % list.size());
    }

    @Override // IIxOXoOo0.X0o0xo
    public void oo(Typeface typeface) {
        this.f31281xxIXOIIO = typeface;
    }

    @Override // IIxOXoOo0.X0o0xo
    public boolean oo0xXOI0I() {
        return this.f31274oO;
    }

    @Override // IIxOXoOo0.X0o0xo
    public void ooOOo0oXI(boolean z) {
        this.f31274oO = z;
    }

    @Override // IIxOXoOo0.X0o0xo
    public boolean ox(T t) {
        for (int i = 0; i < X0xxXX0(); i++) {
            if (OOXIXo(i).equals(t)) {
                return true;
            }
        }
        return false;
    }

    @Override // IIxOXoOo0.X0o0xo
    public boolean removeFirst() {
        if (X0xxXX0() <= 0) {
            return false;
        }
        return x0o(OOXIXo(0));
    }

    @Override // IIxOXoOo0.X0o0xo
    public boolean removeLast() {
        if (X0xxXX0() > 0) {
            return x0o(OOXIXo(X0xxXX0() - 1));
        }
        return false;
    }

    @Override // IIxOXoOo0.X0o0xo
    public void setVisible(boolean z) {
        this.f31267IXxxXO = z;
    }

    @Override // IIxOXoOo0.X0o0xo
    public Typeface x0XOIxOo() {
        return this.f31281xxIXOIIO;
    }

    @Override // IIxOXoOo0.X0o0xo
    public int x0xO0oo(int i) {
        List<Integer> list = this.f31277oxoX;
        return list.get(i % list.size()).intValue();
    }

    @Override // IIxOXoOo0.X0o0xo
    public DashPathEffect xI() {
        return this.f31276ooOOo0oXI;
    }

    public void xIXX(DashPathEffect dashPathEffect) {
        this.f31276ooOOo0oXI = dashPathEffect;
    }

    public void xOOxIO(int i, int i2) {
        this.f31266II0xO0 = new OX00O0xII.oIX0oI(i, i2);
    }

    @Override // IIxOXoOo0.X0o0xo
    public int xX0IIXIx0() {
        return this.f31273oIX0oI.get(0).intValue();
    }

    @Override // IIxOXoOo0.X0o0xo
    public boolean xoO0xx0() {
        return this.f31278x0XOIxOo;
    }

    @Override // IIxOXoOo0.X0o0xo
    public int xx0X0() {
        return this.f31277oxoX.get(0).intValue();
    }

    @Override // IIxOXoOo0.X0o0xo
    public ox.x0xO0oo xxIO() {
        if (IXO()) {
            return XIXIX.OOXIXo.Oxx0xo();
        }
        return this.f31265II0XooXoX;
    }

    public void xxxI(float f) {
        this.f31275oOoXoXO = f;
    }

    public X0o0xo(String str) {
        this();
        this.f31271X0o0xo = str;
    }
}
