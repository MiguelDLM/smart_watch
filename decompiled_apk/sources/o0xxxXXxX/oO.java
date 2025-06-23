package o0xxxXXxX;

import android.graphics.DashPathEffect;
import com.github.mikephil.charting.data.Entry;
import java.util.List;

/* loaded from: classes9.dex */
public abstract class oO<T extends Entry> extends oxoX<T> implements IIxOXoOo0.II0XooXoX<T> {

    /* renamed from: O0xOxO, reason: collision with root package name */
    public boolean f31286O0xOxO;

    /* renamed from: OxI, reason: collision with root package name */
    public boolean f31287OxI;

    /* renamed from: X0IIOO, reason: collision with root package name */
    public float f31288X0IIOO;

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public DashPathEffect f31289XI0IXoo;

    public oO(List<T> list, String str) {
        super(list, str);
        this.f31287OxI = true;
        this.f31286O0xOxO = true;
        this.f31288X0IIOO = 0.5f;
        this.f31289XI0IXoo = null;
        this.f31288X0IIOO = XIXIX.OOXIXo.X0o0xo(0.5f);
    }

    @Override // IIxOXoOo0.II0XooXoX
    public DashPathEffect O0IxXx() {
        return this.f31289XI0IXoo;
    }

    public void OOxOI(boolean z) {
        this.f31287OxI = z;
    }

    public void OxO(float f, float f2, float f3) {
        this.f31289XI0IXoo = new DashPathEffect(new float[]{f, f2}, f3);
    }

    public void X00xOoXI(boolean z) {
        this.f31286O0xOxO = z;
    }

    public void X0O0I0() {
        this.f31289XI0IXoo = null;
    }

    @Override // IIxOXoOo0.II0XooXoX
    public boolean XI0IXoo() {
        return this.f31287OxI;
    }

    public void XO00XOO(float f) {
        this.f31288X0IIOO = XIXIX.OOXIXo.X0o0xo(f);
    }

    @Override // IIxOXoOo0.II0XooXoX
    public boolean XOxxooXI() {
        return this.f31286O0xOxO;
    }

    public void o0Xo(boolean z) {
        OOxOI(z);
        X00xOoXI(z);
    }

    public void o0oxo0oI(oO oOVar) {
        super.OxXXx0X(oOVar);
        oOVar.f31286O0xOxO = this.f31286O0xOxO;
        oOVar.f31287OxI = this.f31287OxI;
        oOVar.f31288X0IIOO = this.f31288X0IIOO;
        oOVar.f31289XI0IXoo = this.f31289XI0IXoo;
    }

    @Override // IIxOXoOo0.II0XooXoX
    public float xI0oxI00() {
        return this.f31288X0IIOO;
    }

    public boolean xxx00() {
        if (this.f31289XI0IXoo == null) {
            return false;
        }
        return true;
    }
}
