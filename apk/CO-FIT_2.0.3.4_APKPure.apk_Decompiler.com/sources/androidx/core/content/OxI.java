package androidx.core.content;

import android.content.UriMatcher;
import android.net.Uri;
import androidx.core.util.OOXIXo;
import androidx.core.util.Predicate;

public final /* synthetic */ class OxI implements Predicate {

    /* renamed from: oIX0oI  reason: collision with root package name */
    public final /* synthetic */ UriMatcher f299oIX0oI;

    public /* synthetic */ OxI(UriMatcher uriMatcher) {
        this.f299oIX0oI = uriMatcher;
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
        return UriMatcherCompat.lambda$asPredicate$0(this.f299oIX0oI, (Uri) obj);
    }
}
