package androidx.core.util;

public final /* synthetic */ class II0XooXoX implements Predicate {

    /* renamed from: oIX0oI  reason: collision with root package name */
    public final /* synthetic */ Object f360oIX0oI;

    public /* synthetic */ II0XooXoX(Object obj) {
        this.f360oIX0oI = obj;
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
        return this.f360oIX0oI.equals(obj);
    }
}
