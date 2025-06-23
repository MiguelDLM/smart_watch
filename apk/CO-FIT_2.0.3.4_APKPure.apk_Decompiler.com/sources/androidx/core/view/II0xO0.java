package androidx.core.view;

import android.content.ClipData;
import androidx.core.util.OOXIXo;
import androidx.core.util.Predicate;

public final /* synthetic */ class II0xO0 implements Predicate {

    /* renamed from: oIX0oI  reason: collision with root package name */
    public final /* synthetic */ java.util.function.Predicate f366oIX0oI;

    public /* synthetic */ II0xO0(java.util.function.Predicate predicate) {
        this.f366oIX0oI = predicate;
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
        return this.f366oIX0oI.test((ClipData.Item) obj);
    }
}
