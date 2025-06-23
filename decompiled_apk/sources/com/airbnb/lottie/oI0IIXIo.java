package com.airbnb.lottie;

import android.util.Log;
import androidx.collection.ArraySet;
import androidx.core.util.Pair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class oI0IIXIo {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public boolean f4953oIX0oI = false;

    /* renamed from: II0xO0, reason: collision with root package name */
    public final Set<II0xO0> f4952II0xO0 = new ArraySet();

    /* renamed from: I0Io, reason: collision with root package name */
    public final Map<String, IIXOooo.II0XooXoX> f4951I0Io = new HashMap();

    /* renamed from: oxoX, reason: collision with root package name */
    public final Comparator<Pair<String, Float>> f4954oxoX = new oIX0oI();

    /* loaded from: classes.dex */
    public interface II0xO0 {
        void oIX0oI(float f);
    }

    /* loaded from: classes.dex */
    public class oIX0oI implements Comparator<Pair<String, Float>> {
        public oIX0oI() {
        }

        @Override // java.util.Comparator
        /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
        public int compare(Pair<String, Float> pair, Pair<String, Float> pair2) {
            float floatValue = pair.second.floatValue();
            float floatValue2 = pair2.second.floatValue();
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
        if (!this.f4953oIX0oI) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(this.f4951I0Io.size());
        for (Map.Entry<String, IIXOooo.II0XooXoX> entry : this.f4951I0Io.entrySet()) {
            arrayList.add(new Pair(entry.getKey(), Float.valueOf(entry.getValue().II0xO0())));
        }
        Collections.sort(arrayList, this.f4954oxoX);
        return arrayList;
    }

    public void II0xO0() {
        this.f4951I0Io.clear();
    }

    public void Oxx0IOOO(boolean z) {
        this.f4953oIX0oI = z;
    }

    public void X0o0xo(String str, float f) {
        if (!this.f4953oIX0oI) {
            return;
        }
        IIXOooo.II0XooXoX iI0XooXoX = this.f4951I0Io.get(str);
        if (iI0XooXoX == null) {
            iI0XooXoX = new IIXOooo.II0XooXoX();
            this.f4951I0Io.put(str, iI0XooXoX);
        }
        iI0XooXoX.oIX0oI(f);
        if (str.equals("__container")) {
            Iterator<II0xO0> it = this.f4952II0xO0.iterator();
            while (it.hasNext()) {
                it.next().oIX0oI(f);
            }
        }
    }

    public void XO(II0xO0 iI0xO0) {
        this.f4952II0xO0.remove(iI0xO0);
    }

    public void oIX0oI(II0xO0 iI0xO0) {
        this.f4952II0xO0.add(iI0xO0);
    }

    public void oxoX() {
        if (!this.f4953oIX0oI) {
            return;
        }
        List<Pair<String, Float>> I0Io2 = I0Io();
        Log.d(X0o0xo.f4819II0xO0, "Render times:");
        for (int i = 0; i < I0Io2.size(); i++) {
            Pair<String, Float> pair = I0Io2.get(i);
            Log.d(X0o0xo.f4819II0xO0, String.format("\t\t%30s:%.2f", pair.first, pair.second));
        }
    }
}
