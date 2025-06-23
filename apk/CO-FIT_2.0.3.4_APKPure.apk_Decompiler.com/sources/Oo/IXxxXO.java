package Oo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import xoXoI.oIX0oI;

public abstract class IXxxXO<V, O> implements x0xO0oo<V, O> {

    /* renamed from: oIX0oI  reason: collision with root package name */
    public final List<oIX0oI<V>> f100oIX0oI;

    public IXxxXO(V v) {
        this(Collections.singletonList(new oIX0oI(v)));
    }

    public boolean I0Io() {
        if (this.f100oIX0oI.isEmpty()) {
            return true;
        }
        if (this.f100oIX0oI.size() != 1 || !this.f100oIX0oI.get(0).II0XooXoX()) {
            return false;
        }
        return true;
    }

    public List<oIX0oI<V>> II0xO0() {
        return this.f100oIX0oI;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.f100oIX0oI.isEmpty()) {
            sb.append("values=");
            sb.append(Arrays.toString(this.f100oIX0oI.toArray()));
        }
        return sb.toString();
    }

    public IXxxXO(List<oIX0oI<V>> list) {
        this.f100oIX0oI = list;
    }
}
