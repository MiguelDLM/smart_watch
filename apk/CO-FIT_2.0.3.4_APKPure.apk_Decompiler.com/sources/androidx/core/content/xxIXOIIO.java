package androidx.core.content;

import android.content.ComponentName;
import androidx.core.util.OOXIXo;
import androidx.core.util.Predicate;

public final /* synthetic */ class xxIXOIIO implements Predicate {

    /* renamed from: oIX0oI  reason: collision with root package name */
    public final /* synthetic */ ComponentName f310oIX0oI;

    public /* synthetic */ xxIXOIIO(ComponentName componentName) {
        this.f310oIX0oI = componentName;
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
        return this.f310oIX0oI.equals((ComponentName) obj);
    }
}
