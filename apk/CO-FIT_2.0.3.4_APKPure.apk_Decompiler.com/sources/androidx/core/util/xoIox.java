package androidx.core.util;

public final /* synthetic */ class xoIox implements Predicate {

    /* renamed from: oIX0oI  reason: collision with root package name */
    public final /* synthetic */ Predicate f363oIX0oI;

    public /* synthetic */ xoIox(Predicate predicate) {
        this.f363oIX0oI = predicate;
    }

    public /* synthetic */ Predicate and(Predicate predicate) {
        return OOXIXo.oIX0oI(this, predicate);
    }

    public /* synthetic */ Predicate negate() {
        return OOXIXo.II0xO0(this);
    }

    public /* synthetic */ Predicate or(Predicate predicate) {
        return OOXIXo.I0Io(this, predicate);
    }

    public final boolean test(Object obj) {
        return OOXIXo.X0o0xo(this.f363oIX0oI, obj);
    }
}
