package xI0OXooO;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

/* loaded from: classes6.dex */
public class xxIXOIIO<T> implements OxxIIOOXO<II0XooXoX> {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final Function<CharSequence, Collection<T>> f34142oIX0oI;

    /* loaded from: classes6.dex */
    public class I0Io {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final Map<T, II0xO0> f34144oIX0oI;

        public I0Io(int i) {
            this.f34144oIX0oI = new HashMap(i);
        }

        public int I0Io(Object obj) {
            II0xO0 iI0xO0 = this.f34144oIX0oI.get(obj);
            if (iI0xO0 != null) {
                return iI0xO0.f34145oIX0oI;
            }
            return 0;
        }

        public Set<Map.Entry<T, II0xO0>> II0xO0() {
            return this.f34144oIX0oI.entrySet();
        }

        public void oIX0oI(T t) {
            II0xO0 iI0xO0 = this.f34144oIX0oI.get(t);
            if (iI0xO0 == null) {
                this.f34144oIX0oI.put(t, new II0xO0());
            } else {
                iI0xO0.f34145oIX0oI++;
            }
        }

        public int oxoX() {
            return this.f34144oIX0oI.size();
        }
    }

    /* loaded from: classes6.dex */
    public static class II0xO0 {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public int f34145oIX0oI;

        public II0xO0() {
            this.f34145oIX0oI = 1;
        }
    }

    public xxIXOIIO(Function<CharSequence, Collection<T>> function) {
        if (function != null) {
            this.f34142oIX0oI = function;
            return;
        }
        throw new IllegalArgumentException("Converter must not be null");
    }

    public static <T> int I0Io(Set<T> set, Set<T> set2) {
        Iterator<T> it = set.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (set2.contains(it.next())) {
                i++;
            }
        }
        return i;
    }

    @Override // xI0OXooO.OxxIIOOXO
    /* renamed from: II0xO0, reason: merged with bridge method [inline-methods] */
    public II0XooXoX oIX0oI(CharSequence charSequence, CharSequence charSequence2) {
        Object apply;
        Object apply2;
        int oxoX2;
        if (charSequence != null && charSequence2 != null) {
            apply = this.f34142oIX0oI.apply(charSequence);
            Collection<T> collection = (Collection) apply;
            apply2 = this.f34142oIX0oI.apply(charSequence2);
            Collection<T> collection2 = (Collection) apply2;
            int size = collection.size();
            int size2 = collection2.size();
            if (Math.min(size, size2) == 0) {
                return new II0XooXoX(size, size2, 0);
            }
            if ((collection instanceof Set) && (collection2 instanceof Set)) {
                if (size < size2) {
                    oxoX2 = I0Io((Set) collection, (Set) collection2);
                } else {
                    oxoX2 = I0Io((Set) collection2, (Set) collection);
                }
            } else {
                xxIXOIIO<T>.I0Io X0o0xo2 = X0o0xo(collection);
                xxIXOIIO<T>.I0Io X0o0xo3 = X0o0xo(collection2);
                if (X0o0xo2.oxoX() < X0o0xo3.oxoX()) {
                    oxoX2 = oxoX(X0o0xo2, X0o0xo3);
                } else {
                    oxoX2 = oxoX(X0o0xo3, X0o0xo2);
                }
            }
            return new II0XooXoX(size, size2, oxoX2);
        }
        throw new IllegalArgumentException("Input cannot be null");
    }

    public final xxIXOIIO<T>.I0Io X0o0xo(Collection<T> collection) {
        xxIXOIIO<T>.I0Io i0Io = new I0Io(collection.size());
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            i0Io.oIX0oI(it.next());
        }
        return i0Io;
    }

    public final int oxoX(xxIXOIIO<T>.I0Io i0Io, xxIXOIIO<T>.I0Io i0Io2) {
        int i = 0;
        for (Map.Entry<T, II0xO0> entry : i0Io.II0xO0()) {
            i += Math.min(entry.getValue().f34145oIX0oI, i0Io2.I0Io(entry.getKey()));
        }
        return i;
    }
}
