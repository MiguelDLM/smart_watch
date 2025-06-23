package o0xxxXXxX;

import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.RadarEntry;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes9.dex */
public class Oxx0xo extends x0XOIxOo<RadarEntry> implements IIxOXoOo0.xoIox {

    /* renamed from: IoOoX, reason: collision with root package name */
    public float f31252IoOoX;

    /* renamed from: Xx000oIo, reason: collision with root package name */
    public float f31253Xx000oIo;

    /* renamed from: oOXoIIIo, reason: collision with root package name */
    public float f31254oOXoIIIo;

    /* renamed from: oo, reason: collision with root package name */
    public int f31255oo;

    /* renamed from: oo0xXOI0I, reason: collision with root package name */
    public int f31256oo0xXOI0I;

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    public boolean f31257ooXIXxIX;

    /* renamed from: xI, reason: collision with root package name */
    public int f31258xI;

    public Oxx0xo(List<RadarEntry> list, String str) {
        super(list, str);
        this.f31257ooXIXxIX = false;
        this.f31258xI = -1;
        this.f31256oo0xXOI0I = XIXIX.oIX0oI.f3782oIX0oI;
        this.f31255oo = 76;
        this.f31252IoOoX = 3.0f;
        this.f31254oOXoIIIo = 4.0f;
        this.f31253Xx000oIo = 2.0f;
    }

    @Override // IIxOXoOo0.xoIox
    public int II0xO0() {
        return this.f31258xI;
    }

    public void IIOIX(int i) {
        this.f31255oo = i;
    }

    @Override // IIxOXoOo0.xoIox
    public boolean O0() {
        return this.f31257ooXIXxIX;
    }

    @Override // IIxOXoOo0.xoIox
    public float O0X() {
        return this.f31252IoOoX;
    }

    @Override // IIxOXoOo0.xoIox
    public void OI0(boolean z) {
        this.f31257ooXIXxIX = z;
    }

    @Override // IIxOXoOo0.xoIox
    public int OO() {
        return this.f31256oo0xXOI0I;
    }

    @Override // IIxOXoOo0.xoIox
    public float OO0x0xX() {
        return this.f31254oOXoIIIo;
    }

    public void X0ooXIooI(float f) {
        this.f31253Xx000oIo = f;
    }

    @Override // IIxOXoOo0.xoIox
    public float XIXIX() {
        return this.f31253Xx000oIo;
    }

    public void Xo(float f) {
        this.f31252IoOoX = f;
    }

    public void XoOxI0ox(int i) {
        this.f31256oo0xXOI0I = i;
    }

    @Override // com.github.mikephil.charting.data.DataSet
    public DataSet<RadarEntry> oX0I0O() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.f16010Oxx0xo.size(); i++) {
            arrayList.add(((RadarEntry) this.f16010Oxx0xo.get(i)).Oxx0IOOO());
        }
        Oxx0xo oxx0xo = new Oxx0xo(arrayList, getLabel());
        xOOxI(oxx0xo);
        return oxx0xo;
    }

    public void oXO0oOx0(float f) {
        this.f31254oOXoIIIo = f;
    }

    public void xIx(int i) {
        this.f31258xI = i;
    }

    public void xOOxI(Oxx0xo oxx0xo) {
        super.OXXoIoXI(oxx0xo);
        oxx0xo.f31257ooXIXxIX = this.f31257ooXIXxIX;
        oxx0xo.f31258xI = this.f31258xI;
        oxx0xo.f31252IoOoX = this.f31252IoOoX;
        oxx0xo.f31255oo = this.f31255oo;
        oxx0xo.f31256oo0xXOI0I = this.f31256oo0xXOI0I;
        oxx0xo.f31253Xx000oIo = this.f31253Xx000oIo;
    }

    @Override // IIxOXoOo0.xoIox
    public int xXxxox0I() {
        return this.f31255oo;
    }
}
