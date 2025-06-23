package com.github.mikephil.charting.data;

import IIxOXoOo0.xxIXOIIO;
import XIXIX.OOXIXo;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes9.dex */
public class PieDataSet extends DataSet<PieEntry> implements xxIXOIIO {

    /* renamed from: IIX0o, reason: collision with root package name */
    public float f16025IIX0o;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public float f16026O0xOxO;

    /* renamed from: OxI, reason: collision with root package name */
    public boolean f16027OxI;

    /* renamed from: X0IIOO, reason: collision with root package name */
    public ValuePosition f16028X0IIOO;

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public ValuePosition f16029XI0IXoo;

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public boolean f16030XIxXXX0x0;

    /* renamed from: XxX0x0xxx, reason: collision with root package name */
    public float f16031XxX0x0xxx;

    /* renamed from: o00, reason: collision with root package name */
    public float f16032o00;

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    public float f16033ooXIXxIX;

    /* renamed from: xI, reason: collision with root package name */
    public boolean f16034xI;

    /* renamed from: xXxxox0I, reason: collision with root package name */
    public float f16035xXxxox0I;

    /* renamed from: xxX, reason: collision with root package name */
    public int f16036xxX;

    /* loaded from: classes9.dex */
    public enum ValuePosition {
        INSIDE_SLICE,
        OUTSIDE_SLICE
    }

    public PieDataSet(List<PieEntry> list, String str) {
        super(list, str);
        this.f16032o00 = 0.0f;
        this.f16026O0xOxO = 18.0f;
        ValuePosition valuePosition = ValuePosition.INSIDE_SLICE;
        this.f16028X0IIOO = valuePosition;
        this.f16029XI0IXoo = valuePosition;
        this.f16030XIxXXX0x0 = false;
        this.f16036xxX = ViewCompat.MEASURED_STATE_MASK;
        this.f16031XxX0x0xxx = 1.0f;
        this.f16035xXxxox0I = 75.0f;
        this.f16025IIX0o = 0.3f;
        this.f16033ooXIXxIX = 0.4f;
        this.f16034xI = true;
    }

    @Override // IIxOXoOo0.xxIXOIIO
    public ValuePosition IO() {
        return this.f16028X0IIOO;
    }

    @Override // IIxOXoOo0.xxIXOIIO
    public ValuePosition IoXIXo() {
        return this.f16029XI0IXoo;
    }

    public void OOIXx0x(ValuePosition valuePosition) {
        this.f16028X0IIOO = valuePosition;
    }

    public void OOOI(PieDataSet pieDataSet) {
        super.x00IOx(pieDataSet);
    }

    public void OOxOI(float f) {
        this.f16035xXxxox0I = f;
    }

    public void OXXoIoXI(boolean z) {
        this.f16034xI = z;
    }

    public void OxO(float f) {
        if (f > 20.0f) {
            f = 20.0f;
        }
        if (f < 0.0f) {
            f = 0.0f;
        }
        this.f16032o00 = OOXIXo.X0o0xo(f);
    }

    @Override // com.github.mikephil.charting.data.DataSet
    /* renamed from: OxXXx0X, reason: merged with bridge method [inline-methods] */
    public void oxOXxoXII(PieEntry pieEntry) {
        if (pieEntry == null) {
            return;
        }
        XO0o(pieEntry);
    }

    @Override // IIxOXoOo0.xxIXOIIO
    public float Oxx0xo() {
        return this.f16033ooXIXxIX;
    }

    public void X00xOoXI(float f) {
        this.f16025IIX0o = f;
    }

    public void X0O0I0(float f) {
        this.f16026O0xOxO = OOXIXo.X0o0xo(f);
    }

    public void XO00XOO(float f) {
        this.f16033ooXIXxIX = f;
    }

    @Override // IIxOXoOo0.xxIXOIIO
    public float XX0xXo() {
        return this.f16031XxX0x0xxx;
    }

    public void XooIO0oo0(float f) {
        this.f16031XxX0x0xxx = f;
    }

    public void o0Xo(int i) {
        this.f16036xxX = i;
    }

    public void o0oxo0oI(boolean z) {
        this.f16027OxI = z;
    }

    @Override // IIxOXoOo0.xxIXOIIO
    public float o0xxxXXxX() {
        return this.f16025IIX0o;
    }

    @Override // IIxOXoOo0.xxIXOIIO
    public float oOo() {
        return this.f16032o00;
    }

    @Override // com.github.mikephil.charting.data.DataSet
    public DataSet<PieEntry> oX0I0O() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.f16010Oxx0xo.size(); i++) {
            arrayList.add(((PieEntry) this.f16010Oxx0xo.get(i)).Oxx0IOOO());
        }
        PieDataSet pieDataSet = new PieDataSet(arrayList, getLabel());
        OOOI(pieDataSet);
        return pieDataSet;
    }

    @Override // IIxOXoOo0.xxIXOIIO
    public float oxxXoxO() {
        return this.f16035xXxxox0I;
    }

    @Override // IIxOXoOo0.xxIXOIIO
    public int x0OIX00oO() {
        return this.f16036xxX;
    }

    public void xIx0XO(ValuePosition valuePosition) {
        this.f16029XI0IXoo = valuePosition;
    }

    @Override // IIxOXoOo0.xxIXOIIO
    public boolean xXoOI00O() {
        return this.f16030XIxXXX0x0;
    }

    @Override // IIxOXoOo0.xxIXOIIO
    public boolean xoIox() {
        return this.f16027OxI;
    }

    @Override // IIxOXoOo0.xxIXOIIO
    public float xoXoI() {
        return this.f16026O0xOxO;
    }

    @Override // IIxOXoOo0.xxIXOIIO
    public boolean xxOXOOoIX() {
        return this.f16034xI;
    }

    public void xxx00(boolean z) {
        this.f16030XIxXXX0x0 = z;
    }
}
