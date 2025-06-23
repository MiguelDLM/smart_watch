package o0xxxXXxX;

import IIxOXoOo0.X0o0xo;
import android.graphics.Typeface;
import android.util.Log;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes9.dex */
public abstract class OOXIXo<T extends IIxOXoOo0.X0o0xo<? extends Entry>> {

    /* renamed from: I0Io, reason: collision with root package name */
    public float f31243I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public float f31244II0XooXoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    public float f31245II0xO0;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public float f31246Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public float f31247X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public float f31248XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public float f31249oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public float f31250oxoX;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public List<T> f31251xxIXOIIO;

    public OOXIXo() {
        this.f31249oIX0oI = -3.4028235E38f;
        this.f31245II0xO0 = Float.MAX_VALUE;
        this.f31243I0Io = -3.4028235E38f;
        this.f31250oxoX = Float.MAX_VALUE;
        this.f31247X0o0xo = -3.4028235E38f;
        this.f31248XO = Float.MAX_VALUE;
        this.f31246Oxx0IOOO = -3.4028235E38f;
        this.f31244II0XooXoX = Float.MAX_VALUE;
        this.f31251xxIXOIIO = new ArrayList();
    }

    public final List<T> I0Io(T[] tArr) {
        ArrayList arrayList = new ArrayList();
        for (T t : tArr) {
            arrayList.add(t);
        }
        return arrayList;
    }

    public void II0XooXoX() {
        List<T> list = this.f31251xxIXOIIO;
        if (list != null) {
            list.clear();
        }
        XxX0x0xxx();
    }

    public void II0xO0(Entry entry, int i) {
        if (this.f31251xxIXOIIO.size() > i && i >= 0) {
            T t = this.f31251xxIXOIIO.get(i);
            if (!t.O00XxXI(entry)) {
                return;
            }
            XO(entry, t.OX00O0xII());
            return;
        }
        Log.e("addEntry", "Cannot add Entry because dataSetIndex too high or too low.");
    }

    public boolean IIX0o(T t) {
        if (t == null) {
            return false;
        }
        boolean remove = this.f31251xxIXOIIO.remove(t);
        if (remove) {
            oxoX();
        }
        return remove;
    }

    public int IIXOooo(T t) {
        return this.f31251xxIXOIIO.indexOf(t);
    }

    public void IO(Typeface typeface) {
        Iterator<T> it = this.f31251xxIXOIIO.iterator();
        while (it.hasNext()) {
            it.next().oo(typeface);
        }
    }

    public int IXxxXO() {
        Iterator<T> it = this.f31251xxIXOIIO.iterator();
        int i = 0;
        while (it.hasNext()) {
            i += it.next().X0xxXX0();
        }
        return i;
    }

    public void IoOoX(ox.x0xO0oo x0xo0oo) {
        if (x0xo0oo == null) {
            return;
        }
        Iterator<T> it = this.f31251xxIXOIIO.iterator();
        while (it.hasNext()) {
            it.next().O0Xx(x0xo0oo);
        }
    }

    public float O0xOxO() {
        return this.f31249oIX0oI;
    }

    public T OOXIXo(int i) {
        List<T> list = this.f31251xxIXOIIO;
        if (list != null && i >= 0 && i < list.size()) {
            return this.f31251xxIXOIIO.get(i);
        }
        return null;
    }

    public List<T> Oo() {
        return this.f31251xxIXOIIO;
    }

    public float OxI() {
        return this.f31250oxoX;
    }

    public void Oxx0IOOO(float f, float f2) {
        Iterator<T> it = this.f31251xxIXOIIO.iterator();
        while (it.hasNext()) {
            it.next().oI0IIXIo(f, f2);
        }
        oxoX();
    }

    public Entry Oxx0xo(XI0oooXX.oxoX oxox) {
        if (oxox.oxoX() >= this.f31251xxIXOIIO.size()) {
            return null;
        }
        return this.f31251xxIXOIIO.get(oxox.oxoX()).Ox0O(oxox.II0XooXoX(), oxox.xoIox());
    }

    public T OxxIIOOXO(List<T> list) {
        for (T t : list) {
            if (t.OX00O0xII() == YAxis.AxisDependency.RIGHT) {
                return t;
            }
        }
        return null;
    }

    public void X00IoxXI(float f) {
        Iterator<T> it = this.f31251xxIXOIIO.iterator();
        while (it.hasNext()) {
            it.next().Oo(f);
        }
    }

    public float X0IIOO(YAxis.AxisDependency axisDependency) {
        if (axisDependency == YAxis.AxisDependency.LEFT) {
            float f = this.f31247X0o0xo;
            if (f == -3.4028235E38f) {
                return this.f31246Oxx0IOOO;
            }
            return f;
        }
        float f2 = this.f31246Oxx0IOOO;
        if (f2 == -3.4028235E38f) {
            return this.f31247X0o0xo;
        }
        return f2;
    }

    public void X0o0xo(T t) {
        if (this.f31249oIX0oI < t.xoxXI()) {
            this.f31249oIX0oI = t.xoxXI();
        }
        if (this.f31245II0xO0 > t.x0xO()) {
            this.f31245II0xO0 = t.x0xO();
        }
        if (this.f31243I0Io < t.I0oOoX()) {
            this.f31243I0Io = t.I0oOoX();
        }
        if (this.f31250oxoX > t.IIX0o()) {
            this.f31250oxoX = t.IIX0o();
        }
        if (t.OX00O0xII() == YAxis.AxisDependency.LEFT) {
            if (this.f31247X0o0xo < t.xoxXI()) {
                this.f31247X0o0xo = t.xoxXI();
            }
            if (this.f31248XO > t.x0xO()) {
                this.f31248XO = t.x0xO();
                return;
            }
            return;
        }
        if (this.f31246Oxx0IOOO < t.xoxXI()) {
            this.f31246Oxx0IOOO = t.xoxXI();
        }
        if (this.f31244II0XooXoX > t.x0xO()) {
            this.f31244II0XooXoX = t.x0xO();
        }
    }

    public float XI0IXoo() {
        return this.f31245II0xO0;
    }

    public float XIxXXX0x0(YAxis.AxisDependency axisDependency) {
        if (axisDependency == YAxis.AxisDependency.LEFT) {
            float f = this.f31248XO;
            if (f == Float.MAX_VALUE) {
                return this.f31244II0XooXoX;
            }
            return f;
        }
        float f2 = this.f31244II0XooXoX;
        if (f2 == Float.MAX_VALUE) {
            return this.f31248XO;
        }
        return f2;
    }

    public void XO(Entry entry, YAxis.AxisDependency axisDependency) {
        if (this.f31249oIX0oI < entry.I0Io()) {
            this.f31249oIX0oI = entry.I0Io();
        }
        if (this.f31245II0xO0 > entry.I0Io()) {
            this.f31245II0xO0 = entry.I0Io();
        }
        if (this.f31243I0Io < entry.xxIXOIIO()) {
            this.f31243I0Io = entry.xxIXOIIO();
        }
        if (this.f31250oxoX > entry.xxIXOIIO()) {
            this.f31250oxoX = entry.xxIXOIIO();
        }
        if (axisDependency == YAxis.AxisDependency.LEFT) {
            if (this.f31247X0o0xo < entry.I0Io()) {
                this.f31247X0o0xo = entry.I0Io();
            }
            if (this.f31248XO > entry.I0Io()) {
                this.f31248XO = entry.I0Io();
                return;
            }
            return;
        }
        if (this.f31246Oxx0IOOO < entry.I0Io()) {
            this.f31246Oxx0IOOO = entry.I0Io();
        }
        if (this.f31244II0XooXoX > entry.I0Io()) {
            this.f31244II0XooXoX = entry.I0Io();
        }
    }

    public void Xx000oIo(List<Integer> list) {
        Iterator<T> it = this.f31251xxIXOIIO.iterator();
        while (it.hasNext()) {
            it.next().Io(list);
        }
    }

    public void XxX0x0xxx() {
        oxoX();
    }

    public float o00() {
        return this.f31243I0Io;
    }

    public T oI0IIXIo(List<T> list) {
        for (T t : list) {
            if (t.OX00O0xII() == YAxis.AxisDependency.LEFT) {
                return t;
            }
        }
        return null;
    }

    public void oIX0oI(T t) {
        if (t == null) {
            return;
        }
        X0o0xo(t);
        this.f31251xxIXOIIO.add(t);
    }

    public int oO(List<T> list, String str, boolean z) {
        int i = 0;
        if (z) {
            while (i < list.size()) {
                if (str.equalsIgnoreCase(list.get(i).getLabel())) {
                    return i;
                }
                i++;
            }
            return -1;
        }
        while (i < list.size()) {
            if (str.equals(list.get(i).getLabel())) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public void oOXoIIIo(int i) {
        Iterator<T> it = this.f31251xxIXOIIO.iterator();
        while (it.hasNext()) {
            it.next().Xx000oIo(i);
        }
    }

    public T oOoXoXO(String str, boolean z) {
        int oO2 = oO(this.f31251xxIXOIIO, str, z);
        if (oO2 >= 0 && oO2 < this.f31251xxIXOIIO.size()) {
            return this.f31251xxIXOIIO.get(oO2);
        }
        return null;
    }

    public void oo(boolean z) {
        Iterator<T> it = this.f31251xxIXOIIO.iterator();
        while (it.hasNext()) {
            it.next().oIX0oI(z);
        }
    }

    public void oo0xXOI0I(boolean z) {
        Iterator<T> it = this.f31251xxIXOIIO.iterator();
        while (it.hasNext()) {
            it.next().O0xOxO(z);
        }
    }

    public int ooOOo0oXI() {
        List<T> list = this.f31251xxIXOIIO;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public boolean ooXIXxIX(float f, int i) {
        Entry Ox0O2;
        if (i >= this.f31251xxIXOIIO.size() || (Ox0O2 = this.f31251xxIXOIIO.get(i).Ox0O(f, Float.NaN)) == null) {
            return false;
        }
        return xI(Ox0O2, i);
    }

    public void oxoX() {
        List<T> list = this.f31251xxIXOIIO;
        if (list == null) {
            return;
        }
        this.f31249oIX0oI = -3.4028235E38f;
        this.f31245II0xO0 = Float.MAX_VALUE;
        this.f31243I0Io = -3.4028235E38f;
        this.f31250oxoX = Float.MAX_VALUE;
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            X0o0xo(it.next());
        }
        this.f31247X0o0xo = -3.4028235E38f;
        this.f31248XO = Float.MAX_VALUE;
        this.f31246Oxx0IOOO = -3.4028235E38f;
        this.f31244II0XooXoX = Float.MAX_VALUE;
        T oI0IIXIo2 = oI0IIXIo(this.f31251xxIXOIIO);
        if (oI0IIXIo2 != null) {
            this.f31247X0o0xo = oI0IIXIo2.xoxXI();
            this.f31248XO = oI0IIXIo2.x0xO();
            for (T t : this.f31251xxIXOIIO) {
                if (t.OX00O0xII() == YAxis.AxisDependency.LEFT) {
                    if (t.x0xO() < this.f31248XO) {
                        this.f31248XO = t.x0xO();
                    }
                    if (t.xoxXI() > this.f31247X0o0xo) {
                        this.f31247X0o0xo = t.xoxXI();
                    }
                }
            }
        }
        T OxxIIOOXO2 = OxxIIOOXO(this.f31251xxIXOIIO);
        if (OxxIIOOXO2 != null) {
            this.f31246Oxx0IOOO = OxxIIOOXO2.xoxXI();
            this.f31244II0XooXoX = OxxIIOOXO2.x0xO();
            for (T t2 : this.f31251xxIXOIIO) {
                if (t2.OX00O0xII() == YAxis.AxisDependency.RIGHT) {
                    if (t2.x0xO() < this.f31244II0XooXoX) {
                        this.f31244II0XooXoX = t2.x0xO();
                    }
                    if (t2.xoxXI() > this.f31246Oxx0IOOO) {
                        this.f31246Oxx0IOOO = t2.xoxXI();
                    }
                }
            }
        }
    }

    public T x0XOIxOo(Entry entry) {
        if (entry == null) {
            return null;
        }
        for (int i = 0; i < this.f31251xxIXOIIO.size(); i++) {
            T t = this.f31251xxIXOIIO.get(i);
            for (int i2 = 0; i2 < t.X0xxXX0(); i2++) {
                if (entry.II0XooXoX(t.Ox0O(entry.xxIXOIIO(), entry.I0Io()))) {
                    return t;
                }
            }
        }
        return null;
    }

    public String[] x0xO0oo() {
        String[] strArr = new String[this.f31251xxIXOIIO.size()];
        for (int i = 0; i < this.f31251xxIXOIIO.size(); i++) {
            strArr[i] = this.f31251xxIXOIIO.get(i).getLabel();
        }
        return strArr;
    }

    public boolean xI(Entry entry, int i) {
        T t;
        if (entry == null || i >= this.f31251xxIXOIIO.size() || (t = this.f31251xxIXOIIO.get(i)) == null) {
            return false;
        }
        boolean x0o2 = t.x0o(entry);
        if (x0o2) {
            oxoX();
        }
        return x0o2;
    }

    public boolean xXxxox0I(int i) {
        if (i < this.f31251xxIXOIIO.size() && i >= 0) {
            return IIX0o(this.f31251xxIXOIIO.get(i));
        }
        return false;
    }

    public int[] xoIox() {
        if (this.f31251xxIXOIIO == null) {
            return null;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.f31251xxIXOIIO.size(); i2++) {
            i += this.f31251xxIXOIIO.get(i2).OOXIxO0().size();
        }
        int[] iArr = new int[i];
        int i3 = 0;
        for (int i4 = 0; i4 < this.f31251xxIXOIIO.size(); i4++) {
            Iterator<Integer> it = this.f31251xxIXOIIO.get(i4).OOXIxO0().iterator();
            while (it.hasNext()) {
                iArr[i3] = it.next().intValue();
                i3++;
            }
        }
        return iArr;
    }

    public T xoXoI() {
        List<T> list = this.f31251xxIXOIIO;
        if (list != null && !list.isEmpty()) {
            T t = this.f31251xxIXOIIO.get(0);
            for (T t2 : this.f31251xxIXOIIO) {
                if (t2.X0xxXX0() > t.X0xxXX0()) {
                    t = t2;
                }
            }
            return t;
        }
        return null;
    }

    public boolean xxIXOIIO(T t) {
        Iterator<T> it = this.f31251xxIXOIIO.iterator();
        while (it.hasNext()) {
            if (it.next().equals(t)) {
                return true;
            }
        }
        return false;
    }

    public boolean xxX() {
        Iterator<T> it = this.f31251xxIXOIIO.iterator();
        while (it.hasNext()) {
            if (!it.next().XX0()) {
                return false;
            }
        }
        return true;
    }

    public OOXIXo(T... tArr) {
        this.f31249oIX0oI = -3.4028235E38f;
        this.f31245II0xO0 = Float.MAX_VALUE;
        this.f31243I0Io = -3.4028235E38f;
        this.f31250oxoX = Float.MAX_VALUE;
        this.f31247X0o0xo = -3.4028235E38f;
        this.f31248XO = Float.MAX_VALUE;
        this.f31246Oxx0IOOO = -3.4028235E38f;
        this.f31244II0XooXoX = Float.MAX_VALUE;
        this.f31251xxIXOIIO = I0Io(tArr);
        XxX0x0xxx();
    }

    public OOXIXo(List<T> list) {
        this.f31249oIX0oI = -3.4028235E38f;
        this.f31245II0xO0 = Float.MAX_VALUE;
        this.f31243I0Io = -3.4028235E38f;
        this.f31250oxoX = Float.MAX_VALUE;
        this.f31247X0o0xo = -3.4028235E38f;
        this.f31248XO = Float.MAX_VALUE;
        this.f31246Oxx0IOOO = -3.4028235E38f;
        this.f31244II0XooXoX = Float.MAX_VALUE;
        this.f31251xxIXOIIO = list;
        XxX0x0xxx();
    }
}
