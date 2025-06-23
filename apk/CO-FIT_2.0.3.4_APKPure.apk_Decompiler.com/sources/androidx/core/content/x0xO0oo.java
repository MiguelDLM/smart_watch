package androidx.core.content;

import androidx.core.content.IntentSanitizer;
import androidx.core.util.OOXIXo;
import androidx.core.util.Predicate;

public final /* synthetic */ class x0xO0oo implements Predicate {
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
        return IntentSanitizer.Builder.lambda$new$2((String) obj);
    }
}
