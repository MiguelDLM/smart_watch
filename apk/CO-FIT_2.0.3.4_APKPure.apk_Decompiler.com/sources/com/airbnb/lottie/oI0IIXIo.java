package com.airbnb.lottie;

import IIXOooo.II0XooXoX;
import android.util.Log;
import androidx.collection.ArraySet;
import androidx.core.util.Pair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class oI0IIXIo {

    /* renamed from: I0Io  reason: collision with root package name */
    public final Map<String, II0XooXoX> f957I0Io = new HashMap();

    /* renamed from: II0xO0  reason: collision with root package name */
    public final Set<II0xO0> f958II0xO0 = new ArraySet();

    /* renamed from: oIX0oI  reason: collision with root package name */
    public boolean f959oIX0oI = false;

    /* renamed from: oxoX  reason: collision with root package name */
    public final Comparator<Pair<String, Float>> f960oxoX = new oIX0oI();

    public interface II0xO0 {
        void oIX0oI(float f);
    }

    public class oIX0oI implements Comparator<Pair<String, Float>> {
        public oIX0oI() {
        }

        /* renamed from: oIX0oI */
        public int compare(Pair<String, Float> pair, Pair<String, Float> pair2) {
            float floatValue = ((Float) pair.second).floatValue();
            float floatValue2 = ((Float) pair2.second).floatValue();
            if (floatValue2 > floatValue) {
                return 1;
            }
            if (floatValue > floatValue2) {
                return -1;
            }
            return 0;
        }
    }

    public List<Pair<String, Float>> I0Io() {
        if (!this.f959oIX0oI) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(this.f957I0Io.size());
        for (Map.Entry next : this.f957I0Io.entrySet()) {
            arrayList.add(new Pair(next.getKey(), Float.valueOf(((II0XooXoX) next.getValue()).II0xO0())));
        }
        Collections.sort(arrayList, this.f960oxoX);
        return arrayList;
    }

    public void II0xO0() {
        this.f957I0Io.clear();
    }

    public void Oxx0IOOO(boolean z) {
        this.f959oIX0oI = z;
    }

    public void X0o0xo(String str, float f) {
        if (this.f959oIX0oI) {
            II0XooXoX iI0XooXoX = this.f957I0Io.get(str);
            if (iI0XooXoX == null) {
                iI0XooXoX = new II0XooXoX();
                this.f957I0Io.put(str, iI0XooXoX);
            }
            iI0XooXoX.oIX0oI(f);
            if (str.equals("__container")) {
                for (II0xO0 oIX0oI2 : this.f958II0xO0) {
                    oIX0oI2.oIX0oI(f);
                }
            }
        }
    }

    public void XO(II0xO0 iI0xO0) {
        this.f958II0xO0.remove(iI0xO0);
    }

    public void oIX0oI(II0xO0 iI0xO0) {
        this.f958II0xO0.add(iI0xO0);
    }

    public void oxoX() {
        if (this.f959oIX0oI) {
            List<Pair<String, Float>> I0Io2 = I0Io();
            Log.d(X0o0xo.f825II0xO0, "Render times:");
            for (int i = 0; i < I0Io2.size(); i++) {
                Pair pair = I0Io2.get(i);
                Log.d(X0o0xo.f825II0xO0, String.format("\t\t%30s:%.2f", new Object[]{pair.first, pair.second}));
            }
        }
    }
}
