package com.github.mikephil.charting.data;

import IIxOXoOo0.XO;
import XIXIX.OOXIXo;
import XIXIX.oIX0oI;
import android.content.Context;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import o0xxxXXxX.x0XOIxOo;
import ox.Oxx0IOOO;
import ox.xoIox;

/* loaded from: classes9.dex */
public class LineDataSet extends x0XOIxOo<Entry> implements XO {

    /* renamed from: IO, reason: collision with root package name */
    public boolean f16015IO;

    /* renamed from: IoOoX, reason: collision with root package name */
    public float f16016IoOoX;

    /* renamed from: X00IoxXI, reason: collision with root package name */
    public xoIox f16017X00IoxXI;

    /* renamed from: Xx000oIo, reason: collision with root package name */
    public DashPathEffect f16018Xx000oIo;

    /* renamed from: oOXoIIIo, reason: collision with root package name */
    public float f16019oOXoIIIo;

    /* renamed from: oo, reason: collision with root package name */
    public float f16020oo;

    /* renamed from: oo0xXOI0I, reason: collision with root package name */
    public int f16021oo0xXOI0I;

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    public Mode f16022ooXIXxIX;

    /* renamed from: xI, reason: collision with root package name */
    public List<Integer> f16023xI;

    /* renamed from: xII, reason: collision with root package name */
    public boolean f16024xII;

    /* loaded from: classes9.dex */
    public enum Mode {
        LINEAR,
        STEPPED,
        CUBIC_BEZIER,
        HORIZONTAL_BEZIER
    }

    public LineDataSet(List<Entry> list, String str) {
        super(list, str);
        this.f16022ooXIXxIX = Mode.LINEAR;
        this.f16023xI = null;
        this.f16021oo0xXOI0I = -1;
        this.f16020oo = 8.0f;
        this.f16016IoOoX = 4.0f;
        this.f16019oOXoIIIo = 0.2f;
        this.f16018Xx000oIo = null;
        this.f16017X00IoxXI = new Oxx0IOOO();
        this.f16015IO = true;
        this.f16024xII = true;
        if (this.f16023xI == null) {
            this.f16023xI = new ArrayList();
        }
        this.f16023xI.clear();
        this.f16023xI.add(Integer.valueOf(Color.rgb(140, 234, 255)));
    }

    @Override // IIxOXoOo0.XO
    public float I0X0x0oIo() {
        return this.f16016IoOoX;
    }

    @Override // IIxOXoOo0.XO
    public int II0XooXoX() {
        return this.f16021oo0xXOI0I;
    }

    @Deprecated
    public float IIOIX() {
        return OoO();
    }

    public void IOOoXo0Ix(float f) {
        if (f > 1.0f) {
            f = 1.0f;
        }
        if (f < 0.05f) {
            f = 0.05f;
        }
        this.f16019oOXoIIIo = f;
    }

    @Override // IIxOXoOo0.XO
    public boolean IOoo() {
        return this.f16024xII;
    }

    public void Ix0(xoIox xoiox) {
        if (xoiox == null) {
            this.f16017X00IoxXI = new Oxx0IOOO();
        } else {
            this.f16017X00IoxXI = xoiox;
        }
    }

    public void IxIo(int[] iArr, Context context) {
        List<Integer> list = this.f16023xI;
        if (list == null) {
            list = new ArrayList<>();
        }
        list.clear();
        for (int i : iArr) {
            list.add(Integer.valueOf(context.getResources().getColor(i)));
        }
        this.f16023xI = list;
    }

    @Override // IIxOXoOo0.XO
    public float OoO() {
        return this.f16020oo;
    }

    public void Oxo00O(boolean z) {
        this.f16015IO = z;
    }

    public void X0IOOI(boolean z) {
        this.f16024xII = z;
    }

    @Override // IIxOXoOo0.XO
    @Deprecated
    public boolean X0o0xo() {
        if (this.f16022ooXIXxIX == Mode.CUBIC_BEZIER) {
            return true;
        }
        return false;
    }

    public void X0ooXIooI(int i) {
        XoOxI0ox();
        this.f16023xI.add(Integer.valueOf(i));
    }

    @Override // IIxOXoOo0.XO
    public float XIo0oOXIx() {
        return this.f16019oOXoIIIo;
    }

    @Override // IIxOXoOo0.XO
    public boolean XO() {
        if (this.f16018Xx000oIo == null) {
            return false;
        }
        return true;
    }

    public void XOxoX(float f) {
        if (f >= 0.5f) {
            this.f16016IoOoX = OOXIXo.X0o0xo(f);
        } else {
            Log.e("LineDataSet", "Circle radius cannot be < 0.5");
        }
    }

    public void Xo(float f, float f2, float f3) {
        this.f16018Xx000oIo = new DashPathEffect(new float[]{f, f2}, f3);
    }

    public void XoOxI0ox() {
        if (this.f16023xI == null) {
            this.f16023xI = new ArrayList();
        }
        this.f16023xI.clear();
    }

    @Override // IIxOXoOo0.XO
    public Mode getMode() {
        return this.f16022ooXIXxIX;
    }

    @Override // IIxOXoOo0.XO
    public DashPathEffect oOXoIIIo() {
        return this.f16018Xx000oIo;
    }

    public void oX000x(List<Integer> list) {
        this.f16023xI = list;
    }

    @Override // com.github.mikephil.charting.data.DataSet
    public DataSet<Entry> oX0I0O() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.f16010Oxx0xo.size(); i++) {
            arrayList.add(((Entry) this.f16010Oxx0xo.get(i)).Oxx0IOOO());
        }
        LineDataSet lineDataSet = new LineDataSet(arrayList, getLabel());
        xOOxI(lineDataSet);
        return lineDataSet;
    }

    public List<Integer> oXO0oOx0() {
        return this.f16023xI;
    }

    @Override // IIxOXoOo0.XO
    public xoIox ooXIXxIX() {
        return this.f16017X00IoxXI;
    }

    public void x0oxIIIX(int i) {
        this.f16021oo0xXOI0I = i;
    }

    public void xIOXX(int... iArr) {
        this.f16023xI = oIX0oI.I0Io(iArr);
    }

    public void xIXIOX(float f) {
        if (f >= 1.0f) {
            this.f16020oo = OOXIXo.X0o0xo(f);
        } else {
            Log.e("LineDataSet", "Circle radius cannot be < 1");
        }
    }

    public void xIx() {
        this.f16018Xx000oIo = null;
    }

    @Override // IIxOXoOo0.XO
    @Deprecated
    public boolean xOOOX() {
        if (this.f16022ooXIXxIX == Mode.STEPPED) {
            return true;
        }
        return false;
    }

    public void xOOxI(LineDataSet lineDataSet) {
        super.OXXoIoXI(lineDataSet);
        lineDataSet.f16023xI = this.f16023xI;
        lineDataSet.f16021oo0xXOI0I = this.f16021oo0xXOI0I;
        lineDataSet.f16016IoOoX = this.f16016IoOoX;
        lineDataSet.f16020oo = this.f16020oo;
        lineDataSet.f16019oOXoIIIo = this.f16019oOXoIIIo;
        lineDataSet.f16018Xx000oIo = this.f16018Xx000oIo;
        lineDataSet.f16024xII = this.f16024xII;
        lineDataSet.f16015IO = this.f16024xII;
        lineDataSet.f16017X00IoxXI = this.f16017X00IoxXI;
        lineDataSet.f16022ooXIXxIX = this.f16022ooXIXxIX;
    }

    @Override // IIxOXoOo0.XO
    public boolean xXOx() {
        return this.f16015IO;
    }

    @Deprecated
    public void xo(float f) {
        xIXIOX(f);
    }

    @Override // IIxOXoOo0.XO
    public int xo0x(int i) {
        return this.f16023xI.get(i).intValue();
    }

    public void xox(Mode mode) {
        this.f16022ooXIXxIX = mode;
    }

    @Override // IIxOXoOo0.XO
    public int xxX() {
        return this.f16023xI.size();
    }
}
