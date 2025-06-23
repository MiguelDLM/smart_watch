package OXIOoo0X0;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes13.dex */
public class OOXIXo<T> {

    /* renamed from: II0xO0, reason: collision with root package name */
    public final List<OOXIXo<T>> f1986II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final List<T> f1987oIX0oI;

    public OOXIXo() {
        this.f1987oIX0oI = new ArrayList();
        this.f1986II0xO0 = Collections.emptyList();
    }

    public OOXIXo<T> I0Io(Collection<T> collection) {
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            X0o0xo(it.next());
        }
        Iterator<OOXIXo<T>> it2 = this.f1986II0xO0.iterator();
        while (it2.hasNext()) {
            it2.next().I0Io(collection);
        }
        return this;
    }

    public OOXIXo<T> II0XooXoX(T... tArr) {
        for (T t : tArr) {
            this.f1987oIX0oI.remove(t);
        }
        Iterator<OOXIXo<T>> it = this.f1986II0xO0.iterator();
        while (it.hasNext()) {
            it.next().II0XooXoX(tArr);
        }
        return this;
    }

    public OOXIXo<T> Oxx0IOOO(Collection<T> collection) {
        this.f1987oIX0oI.removeAll(collection);
        Iterator<OOXIXo<T>> it = this.f1986II0xO0.iterator();
        while (it.hasNext()) {
            it.next().Oxx0IOOO(collection);
        }
        return this;
    }

    public final void X0o0xo(T t) {
        if (!this.f1987oIX0oI.contains(t)) {
            this.f1987oIX0oI.add(t);
            return;
        }
        throw new IllegalArgumentException("Field '" + t + "' is already selected");
    }

    public List<T> XO() {
        return new ArrayList(this.f1987oIX0oI);
    }

    public String oIX0oI() {
        return "field selection: " + this.f1987oIX0oI.toString();
    }

    public OOXIXo<T> oxoX(T... tArr) {
        for (T t : tArr) {
            X0o0xo(t);
        }
        Iterator<OOXIXo<T>> it = this.f1986II0xO0.iterator();
        while (it.hasNext()) {
            it.next().oxoX(tArr);
        }
        return this;
    }

    public String toString() {
        return this.f1987oIX0oI.toString();
    }

    public OOXIXo<T> xoIox(T... tArr) {
        this.f1987oIX0oI.clear();
        oxoX(tArr);
        Iterator<OOXIXo<T>> it = this.f1986II0xO0.iterator();
        while (it.hasNext()) {
            it.next().xoIox(tArr);
        }
        return this;
    }

    public OOXIXo<T> xxIXOIIO(Collection<T> collection) {
        this.f1987oIX0oI.clear();
        I0Io(collection);
        Iterator<OOXIXo<T>> it = this.f1986II0xO0.iterator();
        while (it.hasNext()) {
            it.next().xxIXOIIO(collection);
        }
        return this;
    }

    public OOXIXo(List<OOXIXo<T>> list) {
        this.f1987oIX0oI = new ArrayList();
        this.f1986II0xO0 = list;
        if (list.contains(this)) {
            list.remove(this);
        }
    }
}
