package oox000IX;

import XIOOI.I0Io;
import androidx.collection.SparseArrayCompat;

/* loaded from: classes6.dex */
public class II0xO0<T> {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public SparseArrayCompat<oIX0oI<T>> f32461oIX0oI = new SparseArrayCompat<>();

    public void I0Io(I0Io i0Io, T t, int i) {
        int size = this.f32461oIX0oI.size();
        for (int i2 = 0; i2 < size; i2++) {
            oIX0oI<T> valueAt = this.f32461oIX0oI.valueAt(i2);
            if (valueAt.oIX0oI(t, i)) {
                valueAt.I0Io(i0Io, t, i);
                return;
            }
        }
        throw new IllegalArgumentException("No ItemViewDelegateManager added that matches position=" + i + " in data source");
    }

    public int II0XooXoX(T t, int i) {
        for (int size = this.f32461oIX0oI.size() - 1; size >= 0; size--) {
            if (this.f32461oIX0oI.valueAt(size).oIX0oI(t, i)) {
                return this.f32461oIX0oI.keyAt(size);
            }
        }
        throw new IllegalArgumentException("No ItemViewDelegate added that matches position=" + i + " in data source");
    }

    public II0xO0<T> II0xO0(oIX0oI<T> oix0oi) {
        int size = this.f32461oIX0oI.size();
        if (oix0oi != null) {
            this.f32461oIX0oI.put(size, oix0oi);
        }
        return this;
    }

    public II0xO0<T> OOXIXo(oIX0oI<T> oix0oi) {
        if (oix0oi != null) {
            int indexOfValue = this.f32461oIX0oI.indexOfValue(oix0oi);
            if (indexOfValue >= 0) {
                this.f32461oIX0oI.removeAt(indexOfValue);
            }
            return this;
        }
        throw new NullPointerException("ItemViewDelegate is null");
    }

    public int Oxx0IOOO(T t, int i) {
        return oxoX(t, i).II0xO0();
    }

    public int X0o0xo() {
        return this.f32461oIX0oI.size();
    }

    public int XO(int i) {
        return this.f32461oIX0oI.get(i).II0xO0();
    }

    public II0xO0<T> oIX0oI(int i, oIX0oI<T> oix0oi) {
        if (this.f32461oIX0oI.get(i) == null) {
            this.f32461oIX0oI.put(i, oix0oi);
            return this;
        }
        throw new IllegalArgumentException("An ItemViewDelegate is already registered for the viewType = " + i + ". Already registered ItemViewDelegate is " + this.f32461oIX0oI.get(i));
    }

    public oIX0oI oxoX(T t, int i) {
        for (int size = this.f32461oIX0oI.size() - 1; size >= 0; size--) {
            oIX0oI<T> valueAt = this.f32461oIX0oI.valueAt(size);
            if (valueAt.oIX0oI(t, i)) {
                return valueAt;
            }
        }
        throw new IllegalArgumentException("No ItemViewDelegate added that matches position=" + i + " in data source");
    }

    public II0xO0<T> xoIox(int i) {
        int indexOfKey = this.f32461oIX0oI.indexOfKey(i);
        if (indexOfKey >= 0) {
            this.f32461oIX0oI.removeAt(indexOfKey);
        }
        return this;
    }

    public int xxIXOIIO(oIX0oI oix0oi) {
        return this.f32461oIX0oI.indexOfValue(oix0oi);
    }
}
