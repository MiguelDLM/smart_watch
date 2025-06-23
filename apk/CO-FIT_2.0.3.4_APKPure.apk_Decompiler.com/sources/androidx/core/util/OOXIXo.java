package androidx.core.util;

import android.annotation.SuppressLint;
import java.util.Objects;

public final /* synthetic */ class OOXIXo {
    @SuppressLint({"MissingNullability"})
    public static Predicate I0Io(Predicate predicate, @SuppressLint({"MissingNullability"}) Predicate predicate2) {
        Objects.requireNonNull(predicate2);
        return new XO(predicate, predicate2);
    }

    @SuppressLint({"MissingNullability"})
    public static Predicate II0xO0(Predicate predicate) {
        return new xoIox(predicate);
    }

    @SuppressLint({"MissingNullability"})
    public static <T> Predicate<T> Oxx0IOOO(@SuppressLint({"MissingNullability"}) Object obj) {
        if (obj == null) {
            return new Oxx0IOOO();
        }
        return new II0XooXoX(obj);
    }

    public static /* synthetic */ boolean X0o0xo(Predicate predicate, Object obj) {
        return !predicate.test(obj);
    }

    public static /* synthetic */ boolean XO(Predicate predicate, Predicate predicate2, Object obj) {
        if (predicate.test(obj) || predicate2.test(obj)) {
            return true;
        }
        return false;
    }

    @SuppressLint({"MissingNullability"})
    public static Predicate oIX0oI(Predicate predicate, @SuppressLint({"MissingNullability"}) Predicate predicate2) {
        Objects.requireNonNull(predicate2);
        return new xxIXOIIO(predicate, predicate2);
    }

    public static /* synthetic */ boolean oxoX(Predicate predicate, Predicate predicate2, Object obj) {
        if (!predicate.test(obj) || !predicate2.test(obj)) {
            return false;
        }
        return true;
    }

    @SuppressLint({"MissingNullability"})
    public static <T> Predicate<T> xoIox(@SuppressLint({"MissingNullability"}) Predicate<? super T> predicate) {
        Objects.requireNonNull(predicate);
        return predicate.negate();
    }
}
