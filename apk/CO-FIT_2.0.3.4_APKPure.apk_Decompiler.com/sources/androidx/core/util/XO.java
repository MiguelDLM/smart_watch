package androidx.core.util;

public final /* synthetic */ class XO implements Predicate {

    /* renamed from: II0xO0  reason: collision with root package name */
    public final /* synthetic */ Predicate f361II0xO0;

    /* renamed from: oIX0oI  reason: collision with root package name */
    public final /* synthetic */ Predicate f362oIX0oI;

    public /* synthetic */ XO(Predicate predicate, Predicate predicate2) {
        this.f362oIX0oI = predicate;
        this.f361II0xO0 = predicate2;
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
        return OOXIXo.XO(this.f362oIX0oI, this.f361II0xO0, obj);
    }
}
