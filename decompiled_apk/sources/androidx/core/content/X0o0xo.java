package androidx.core.content;

import androidx.core.util.Predicate;

/* loaded from: classes.dex */
public final /* synthetic */ class X0o0xo implements Predicate {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final /* synthetic */ String f4295oIX0oI;

    @Override // androidx.core.util.Predicate
    public /* synthetic */ Predicate and(Predicate predicate) {
        return androidx.core.util.OOXIXo.oIX0oI(this, predicate);
    }

    @Override // androidx.core.util.Predicate
    public /* synthetic */ Predicate negate() {
        return androidx.core.util.OOXIXo.II0xO0(this);
    }

    @Override // androidx.core.util.Predicate
    public /* synthetic */ Predicate or(Predicate predicate) {
        return androidx.core.util.OOXIXo.I0Io(this, predicate);
    }

    @Override // androidx.core.util.Predicate
    public final boolean test(Object obj) {
        return this.f4295oIX0oI.equals((String) obj);
    }
}
