package Oo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import xoXoI.oIX0oI;

/* loaded from: classes.dex */
public abstract class IXxxXO<V, O> implements x0xO0oo<V, O> {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final List<oIX0oI<V>> f2012oIX0oI;

    public IXxxXO(V v) {
        this(Collections.singletonList(new oIX0oI(v)));
    }

    @Override // Oo.x0xO0oo
    public boolean I0Io() {
        if (this.f2012oIX0oI.isEmpty()) {
            return true;
        }
        if (this.f2012oIX0oI.size() == 1 && this.f2012oIX0oI.get(0).II0XooXoX()) {
            return true;
        }
        return false;
    }

    @Override // Oo.x0xO0oo
    public List<oIX0oI<V>> II0xO0() {
        return this.f2012oIX0oI;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.f2012oIX0oI.isEmpty()) {
            sb.append("values=");
            sb.append(Arrays.toString(this.f2012oIX0oI.toArray()));
        }
        return sb.toString();
    }

    public IXxxXO(List<oIX0oI<V>> list) {
        this.f2012oIX0oI = list;
    }
}
