package o0oIxXOx;

import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

/* loaded from: classes6.dex */
public final class OOXIXo<V> extends oIX0oI {

    /* renamed from: I0Io, reason: collision with root package name */
    public final Function<String, V> f31154I0Io;

    public OOXIXo(Function<String, V> function) {
        this.f31154I0Io = function;
    }

    public static <R> OOXIXo<R> II0XooXoX(Function<String, R> function) {
        return new OOXIXo<>(function);
    }

    public static <V> OOXIXo<V> Oxx0IOOO(final Map<String, V> map) {
        map.getClass();
        return II0XooXoX(new Function() { // from class: o0oIxXOx.xoIox
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return map.get((String) obj);
            }
        });
    }

    @Override // o0oIxXOx.OxxIIOOXO
    public String lookup(String str) {
        Object apply;
        Function<String, V> function = this.f31154I0Io;
        if (function != null) {
            try {
                apply = function.apply(str);
                return Objects.toString(apply, null);
            } catch (IllegalArgumentException | NullPointerException | SecurityException unused) {
                return null;
            }
        }
        return null;
    }

    public String toString() {
        return super.toString() + " [function=" + this.f31154I0Io + "]";
    }
}
