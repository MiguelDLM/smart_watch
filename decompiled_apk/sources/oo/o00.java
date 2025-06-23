package oo;

import androidx.collection.SparseArrayCompat;
import com.bestmafen.androidbase.adapter.recyclerview.base.ViewHolder;

/* loaded from: classes8.dex */
public class o00<T> {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public SparseArrayCompat<xoXoI<T>> f32191oIX0oI = new SparseArrayCompat<>();

    public void I0Io(ViewHolder viewHolder, T t, int i) {
        int size = this.f32191oIX0oI.size();
        for (int i2 = 0; i2 < size; i2++) {
            xoXoI<T> valueAt = this.f32191oIX0oI.valueAt(i2);
            if (valueAt.oIX0oI(t, i)) {
                valueAt.I0Io(viewHolder, t, i);
                return;
            }
        }
        throw new IllegalArgumentException("No ItemViewDelegateManager added that matches position=" + i + " in data source");
    }

    public int II0XooXoX(xoXoI xoxoi) {
        return this.f32191oIX0oI.indexOfValue(xoxoi);
    }

    public o00<T> II0xO0(xoXoI<T> xoxoi) {
        int size = this.f32191oIX0oI.size();
        if (xoxoi != null) {
            this.f32191oIX0oI.put(size, xoxoi);
        }
        return this;
    }

    public int Oxx0IOOO(T t, int i) {
        for (int size = this.f32191oIX0oI.size() - 1; size >= 0; size--) {
            if (this.f32191oIX0oI.valueAt(size).oIX0oI(t, i)) {
                return this.f32191oIX0oI.keyAt(size);
            }
        }
        throw new IllegalArgumentException("No ItemViewDelegate added that matches position=" + i + " in data source");
    }

    public int X0o0xo() {
        return this.f32191oIX0oI.size();
    }

    public int XO(int i) {
        return oxoX(i).II0xO0();
    }

    public o00<T> oIX0oI(int i, xoXoI<T> xoxoi) {
        if (this.f32191oIX0oI.get(i) == null) {
            this.f32191oIX0oI.put(i, xoxoi);
            return this;
        }
        throw new IllegalArgumentException("An ItemViewDelegate is already registered for the viewType = " + i + ". Already registered ItemViewDelegate is " + this.f32191oIX0oI.get(i));
    }

    public xoXoI oxoX(int i) {
        return this.f32191oIX0oI.get(i);
    }

    public o00<T> xoIox(xoXoI<T> xoxoi) {
        if (xoxoi != null) {
            int indexOfValue = this.f32191oIX0oI.indexOfValue(xoxoi);
            if (indexOfValue >= 0) {
                this.f32191oIX0oI.removeAt(indexOfValue);
            }
            return this;
        }
        throw new NullPointerException("ItemViewDelegate is null");
    }

    public o00<T> xxIXOIIO(int i) {
        int indexOfKey = this.f32191oIX0oI.indexOfKey(i);
        if (indexOfKey >= 0) {
            this.f32191oIX0oI.removeAt(indexOfKey);
        }
        return this;
    }
}
