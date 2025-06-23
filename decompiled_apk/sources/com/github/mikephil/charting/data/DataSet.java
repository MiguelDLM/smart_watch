package com.github.mikephil.charting.data;

import XIXIX.OOXIXo;
import com.github.mikephil.charting.data.Entry;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import o0xxxXXxX.X0o0xo;

/* loaded from: classes9.dex */
public abstract class DataSet<T extends Entry> extends X0o0xo<T> {

    /* renamed from: IIXOooo, reason: collision with root package name */
    public float f16009IIXOooo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public List<T> f16010Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public float f16011OxxIIOOXO;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public float f16012oI0IIXIo;

    /* renamed from: xoXoI, reason: collision with root package name */
    public float f16013xoXoI;

    /* loaded from: classes9.dex */
    public enum Rounding {
        UP,
        DOWN,
        CLOSEST
    }

    public DataSet(List<T> list, String str) {
        super(str);
        this.f16012oI0IIXIo = -3.4028235E38f;
        this.f16011OxxIIOOXO = Float.MAX_VALUE;
        this.f16009IIXOooo = -3.4028235E38f;
        this.f16013xoXoI = Float.MAX_VALUE;
        this.f16010Oxx0xo = list;
        if (list == null) {
            this.f16010Oxx0xo = new ArrayList();
        }
        I0();
    }

    @Override // IIxOXoOo0.X0o0xo
    public void I0() {
        List<T> list = this.f16010Oxx0xo;
        if (list != null && !list.isEmpty()) {
            this.f16012oI0IIXIo = -3.4028235E38f;
            this.f16011OxxIIOOXO = Float.MAX_VALUE;
            this.f16009IIXOooo = -3.4028235E38f;
            this.f16013xoXoI = Float.MAX_VALUE;
            Iterator<T> it = this.f16010Oxx0xo.iterator();
            while (it.hasNext()) {
                oxOXxoXII(it.next());
            }
        }
    }

    @Override // IIxOXoOo0.X0o0xo
    public float I0oOoX() {
        return this.f16009IIXOooo;
    }

    @Override // IIxOXoOo0.X0o0xo
    public float IIX0o() {
        return this.f16013xoXoI;
    }

    @Override // IIxOXoOo0.X0o0xo
    public T Ix00oIoI(float f, float f2, Rounding rounding) {
        int XOxIOxOx2 = XOxIOxOx(f, f2, rounding);
        if (XOxIOxOx2 > -1) {
            return this.f16010Oxx0xo.get(XOxIOxOx2);
        }
        return null;
    }

    public void IxX00(T t) {
        if (t.xxIXOIIO() < this.f16013xoXoI) {
            this.f16013xoXoI = t.xxIXOIIO();
        }
        if (t.xxIXOIIO() > this.f16009IIXOooo) {
            this.f16009IIXOooo = t.xxIXOIIO();
        }
    }

    @Override // IIxOXoOo0.X0o0xo
    public boolean O00XxXI(T t) {
        if (t == null) {
            return false;
        }
        List<T> xX2 = xX();
        if (xX2 == null) {
            xX2 = new ArrayList<>();
        }
        oxOXxoXII(t);
        return xX2.add(t);
    }

    @Override // IIxOXoOo0.X0o0xo
    public T OOXIXo(int i) {
        return this.f16010Oxx0xo.get(i);
    }

    @Override // IIxOXoOo0.X0o0xo
    public T Ox0O(float f, float f2) {
        return Ix00oIoI(f, f2, Rounding.CLOSEST);
    }

    @Override // IIxOXoOo0.X0o0xo
    public List<T> OxxIIOOXO(float f) {
        ArrayList arrayList = new ArrayList();
        int size = this.f16010Oxx0xo.size() - 1;
        int i = 0;
        while (true) {
            if (i > size) {
                break;
            }
            int i2 = (size + i) / 2;
            T t = this.f16010Oxx0xo.get(i2);
            if (f == t.xxIXOIIO()) {
                while (i2 > 0 && this.f16010Oxx0xo.get(i2 - 1).xxIXOIIO() == f) {
                    i2--;
                }
                int size2 = this.f16010Oxx0xo.size();
                while (i2 < size2) {
                    T t2 = this.f16010Oxx0xo.get(i2);
                    if (t2.xxIXOIIO() != f) {
                        break;
                    }
                    arrayList.add(t2);
                    i2++;
                }
            } else if (f > t.xxIXOIIO()) {
                i = i2 + 1;
            } else {
                size = i2 - 1;
            }
        }
        return arrayList;
    }

    @Override // IIxOXoOo0.X0o0xo
    public int X0xxXX0() {
        return this.f16010Oxx0xo.size();
    }

    public void XO0o(T t) {
        if (t.I0Io() < this.f16011OxxIIOOXO) {
            this.f16011OxxIIOOXO = t.I0Io();
        }
        if (t.I0Io() > this.f16012oI0IIXIo) {
            this.f16012oI0IIXIo = t.I0Io();
        }
    }

    @Override // IIxOXoOo0.X0o0xo
    public int XOxIOxOx(float f, float f2, Rounding rounding) {
        int i;
        T t;
        List<T> list = this.f16010Oxx0xo;
        if (list == null || list.isEmpty()) {
            return -1;
        }
        int size = this.f16010Oxx0xo.size() - 1;
        int i2 = 0;
        while (i2 < size) {
            int i3 = (i2 + size) / 2;
            float xxIXOIIO2 = this.f16010Oxx0xo.get(i3).xxIXOIIO() - f;
            int i4 = i3 + 1;
            float xxIXOIIO3 = this.f16010Oxx0xo.get(i4).xxIXOIIO() - f;
            float abs = Math.abs(xxIXOIIO2);
            float abs2 = Math.abs(xxIXOIIO3);
            if (abs2 >= abs) {
                if (abs >= abs2) {
                    double d = xxIXOIIO2;
                    if (d < OOXIXo.f3760XO) {
                        if (d < OOXIXo.f3760XO) {
                        }
                    }
                }
                size = i3;
            }
            i2 = i4;
        }
        if (size != -1) {
            float xxIXOIIO4 = this.f16010Oxx0xo.get(size).xxIXOIIO();
            if (rounding == Rounding.UP) {
                if (xxIXOIIO4 < f && size < this.f16010Oxx0xo.size() - 1) {
                    size++;
                }
            } else if (rounding == Rounding.DOWN && xxIXOIIO4 > f && size > 0) {
                size--;
            }
            if (!Float.isNaN(f2)) {
                while (size > 0 && this.f16010Oxx0xo.get(size - 1).xxIXOIIO() == xxIXOIIO4) {
                    size--;
                }
                float I0Io2 = this.f16010Oxx0xo.get(size).I0Io();
                loop2: while (true) {
                    i = size;
                    do {
                        size++;
                        if (size >= this.f16010Oxx0xo.size()) {
                            break loop2;
                        }
                        t = this.f16010Oxx0xo.get(size);
                        if (t.xxIXOIIO() != xxIXOIIO4) {
                            break loop2;
                        }
                    } while (Math.abs(t.I0Io() - f2) >= Math.abs(I0Io2 - f2));
                    I0Io2 = f2;
                }
                return i;
            }
            return size;
        }
        return size;
    }

    @Override // IIxOXoOo0.X0o0xo
    public void clear() {
        this.f16010Oxx0xo.clear();
        I0xX0();
    }

    @Override // IIxOXoOo0.X0o0xo
    public void oI0IIXIo(float f, float f2) {
        List<T> list = this.f16010Oxx0xo;
        if (list != null && !list.isEmpty()) {
            this.f16012oI0IIXIo = -3.4028235E38f;
            this.f16011OxxIIOOXO = Float.MAX_VALUE;
            int XOxIOxOx2 = XOxIOxOx(f2, Float.NaN, Rounding.UP);
            for (int XOxIOxOx3 = XOxIOxOx(f, Float.NaN, Rounding.DOWN); XOxIOxOx3 <= XOxIOxOx2; XOxIOxOx3++) {
                XO0o(this.f16010Oxx0xo.get(XOxIOxOx3));
            }
        }
    }

    @Override // IIxOXoOo0.X0o0xo
    public void oX(T t) {
        if (t == null) {
            return;
        }
        if (this.f16010Oxx0xo == null) {
            this.f16010Oxx0xo = new ArrayList();
        }
        oxOXxoXII(t);
        if (this.f16010Oxx0xo.size() > 0) {
            if (this.f16010Oxx0xo.get(r0.size() - 1).xxIXOIIO() > t.xxIXOIIO()) {
                this.f16010Oxx0xo.add(XOxIOxOx(t.xxIXOIIO(), t.I0Io(), Rounding.UP), t);
                return;
            }
        }
        this.f16010Oxx0xo.add(t);
    }

    public abstract DataSet<T> oX0I0O();

    public void oX0ooo0I0(List<T> list) {
        this.f16010Oxx0xo = list;
        I0xX0();
    }

    public String oo00() {
        String label;
        StringBuffer stringBuffer = new StringBuffer();
        StringBuilder sb = new StringBuilder();
        sb.append("DataSet, label: ");
        if (getLabel() == null) {
            label = "";
        } else {
            label = getLabel();
        }
        sb.append(label);
        sb.append(", entries: ");
        sb.append(this.f16010Oxx0xo.size());
        sb.append("\n");
        stringBuffer.append(sb.toString());
        return stringBuffer.toString();
    }

    public void oxOXxoXII(T t) {
        if (t == null) {
            return;
        }
        IxX00(t);
        XO0o(t);
    }

    @Override // IIxOXoOo0.X0o0xo
    public int oxoX(Entry entry) {
        return this.f16010Oxx0xo.indexOf(entry);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(oo00());
        for (int i = 0; i < this.f16010Oxx0xo.size(); i++) {
            stringBuffer.append(this.f16010Oxx0xo.get(i).toString() + " ");
        }
        return stringBuffer.toString();
    }

    public void x00IOx(DataSet dataSet) {
        super.oXX0IoI(dataSet);
    }

    @Override // IIxOXoOo0.X0o0xo
    public boolean x0o(T t) {
        List<T> list;
        if (t == null || (list = this.f16010Oxx0xo) == null) {
            return false;
        }
        boolean remove = list.remove(t);
        if (remove) {
            I0();
        }
        return remove;
    }

    @Override // IIxOXoOo0.X0o0xo
    public float x0xO() {
        return this.f16011OxxIIOOXO;
    }

    public List<T> xX() {
        return this.f16010Oxx0xo;
    }

    @Override // IIxOXoOo0.X0o0xo
    public float xoxXI() {
        return this.f16012oI0IIXIo;
    }
}
