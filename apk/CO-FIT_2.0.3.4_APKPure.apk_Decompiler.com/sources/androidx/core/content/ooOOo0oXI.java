package androidx.core.content;

import android.net.Uri;
import androidx.core.util.OOXIXo;
import androidx.core.util.Predicate;

public final /* synthetic */ class ooOOo0oXI implements Predicate {

    /* renamed from: oIX0oI  reason: collision with root package name */
    public final /* synthetic */ String f304oIX0oI;

    public /* synthetic */ ooOOo0oXI(String str) {
        this.f304oIX0oI = str;
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
        return this.f304oIX0oI.equals(((Uri) obj).getAuthority());
    }
}
