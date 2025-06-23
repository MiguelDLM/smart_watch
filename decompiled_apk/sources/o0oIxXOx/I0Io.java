package o0oIxXOx;

import java.util.Map;
import java.util.Objects;
import java.util.function.BiFunction;

/* loaded from: classes6.dex */
public final class I0Io<P, R> implements X0o0xo<P> {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final BiFunction<String, P, R> f31148oIX0oI;

    public I0Io(BiFunction<String, P, R> biFunction) {
        this.f31148oIX0oI = biFunction;
    }

    public static <U, T> I0Io<U, T> X0o0xo(BiFunction<String, U, T> biFunction) {
        return new I0Io<>(biFunction);
    }

    public static <U, T> I0Io<U, T> oxoX(final Map<String, T> map) {
        return X0o0xo(new BiFunction() { // from class: o0oIxXOx.II0xO0
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                Object obj3;
                obj3 = map.get((String) obj);
                return obj3;
            }
        });
    }

    @Override // o0oIxXOx.OxxIIOOXO
    public String lookup(String str) {
        return oIX0oI(str, null);
    }

    @Override // o0oIxXOx.X0o0xo
    public String oIX0oI(String str, P p) {
        Object apply;
        BiFunction<String, P, R> biFunction = this.f31148oIX0oI;
        if (biFunction != null) {
            try {
                apply = biFunction.apply(str, p);
                return Objects.toString(apply, null);
            } catch (IllegalArgumentException | NullPointerException | SecurityException unused) {
                return null;
            }
        }
        return null;
    }

    public String toString() {
        return super.toString() + " [function=" + this.f31148oIX0oI + "]";
    }
}
