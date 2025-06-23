package androidx.core.util;

import android.annotation.SuppressLint;
import java.util.Objects;

/* loaded from: classes.dex */
public final /* synthetic */ class OOXIXo {
    @SuppressLint({"MissingNullability"})
    public static Predicate I0Io(final Predicate predicate, @SuppressLint({"MissingNullability"}) final Predicate predicate2) {
        Objects.requireNonNull(predicate2);
        return new Predicate() { // from class: androidx.core.util.XO
            @Override // androidx.core.util.Predicate
            public /* synthetic */ Predicate and(Predicate predicate3) {
                return OOXIXo.oIX0oI(this, predicate3);
            }

            @Override // androidx.core.util.Predicate
            public /* synthetic */ Predicate negate() {
                return OOXIXo.II0xO0(this);
            }

            @Override // androidx.core.util.Predicate
            public /* synthetic */ Predicate or(Predicate predicate3) {
                return OOXIXo.I0Io(this, predicate3);
            }

            @Override // androidx.core.util.Predicate
            public final boolean test(Object obj) {
                return OOXIXo.XO(Predicate.this, predicate2, obj);
            }
        };
    }

    @SuppressLint({"MissingNullability"})
    public static Predicate II0xO0(final Predicate predicate) {
        return new Predicate() { // from class: androidx.core.util.xoIox
            @Override // androidx.core.util.Predicate
            public /* synthetic */ Predicate and(Predicate predicate2) {
                return OOXIXo.oIX0oI(this, predicate2);
            }

            @Override // androidx.core.util.Predicate
            public /* synthetic */ Predicate negate() {
                return OOXIXo.II0xO0(this);
            }

            @Override // androidx.core.util.Predicate
            public /* synthetic */ Predicate or(Predicate predicate2) {
                return OOXIXo.I0Io(this, predicate2);
            }

            @Override // androidx.core.util.Predicate
            public final boolean test(Object obj) {
                return OOXIXo.X0o0xo(Predicate.this, obj);
            }
        };
    }

    @SuppressLint({"MissingNullability"})
    public static <T> Predicate<T> Oxx0IOOO(@SuppressLint({"MissingNullability"}) final Object obj) {
        if (obj == null) {
            return new Predicate() { // from class: androidx.core.util.Oxx0IOOO
                @Override // androidx.core.util.Predicate
                public /* synthetic */ Predicate and(Predicate predicate) {
                    return OOXIXo.oIX0oI(this, predicate);
                }

                @Override // androidx.core.util.Predicate
                public /* synthetic */ Predicate negate() {
                    return OOXIXo.II0xO0(this);
                }

                @Override // androidx.core.util.Predicate
                public /* synthetic */ Predicate or(Predicate predicate) {
                    return OOXIXo.I0Io(this, predicate);
                }

                @Override // androidx.core.util.Predicate
                public final boolean test(Object obj2) {
                    boolean oIX0oI2;
                    oIX0oI2 = X0o0xo.oIX0oI(obj2);
                    return oIX0oI2;
                }
            };
        }
        return new Predicate() { // from class: androidx.core.util.II0XooXoX
            @Override // androidx.core.util.Predicate
            public /* synthetic */ Predicate and(Predicate predicate) {
                return OOXIXo.oIX0oI(this, predicate);
            }

            @Override // androidx.core.util.Predicate
            public /* synthetic */ Predicate negate() {
                return OOXIXo.II0xO0(this);
            }

            @Override // androidx.core.util.Predicate
            public /* synthetic */ Predicate or(Predicate predicate) {
                return OOXIXo.I0Io(this, predicate);
            }

            @Override // androidx.core.util.Predicate
            public final boolean test(Object obj2) {
                boolean equals;
                equals = obj.equals(obj2);
                return equals;
            }
        };
    }

    public static /* synthetic */ boolean X0o0xo(Predicate predicate, Object obj) {
        return !predicate.test(obj);
    }

    public static /* synthetic */ boolean XO(Predicate predicate, Predicate predicate2, Object obj) {
        if (!predicate.test(obj) && !predicate2.test(obj)) {
            return false;
        }
        return true;
    }

    @SuppressLint({"MissingNullability"})
    public static Predicate oIX0oI(final Predicate predicate, @SuppressLint({"MissingNullability"}) final Predicate predicate2) {
        Objects.requireNonNull(predicate2);
        return new Predicate() { // from class: androidx.core.util.xxIXOIIO
            @Override // androidx.core.util.Predicate
            public /* synthetic */ Predicate and(Predicate predicate3) {
                return OOXIXo.oIX0oI(this, predicate3);
            }

            @Override // androidx.core.util.Predicate
            public /* synthetic */ Predicate negate() {
                return OOXIXo.II0xO0(this);
            }

            @Override // androidx.core.util.Predicate
            public /* synthetic */ Predicate or(Predicate predicate3) {
                return OOXIXo.I0Io(this, predicate3);
            }

            @Override // androidx.core.util.Predicate
            public final boolean test(Object obj) {
                return OOXIXo.oxoX(Predicate.this, predicate2, obj);
            }
        };
    }

    public static /* synthetic */ boolean oxoX(Predicate predicate, Predicate predicate2, Object obj) {
        if (predicate.test(obj) && predicate2.test(obj)) {
            return true;
        }
        return false;
    }

    @SuppressLint({"MissingNullability"})
    public static <T> Predicate<T> xoIox(@SuppressLint({"MissingNullability"}) Predicate<? super T> predicate) {
        Objects.requireNonNull(predicate);
        return predicate.negate();
    }
}
