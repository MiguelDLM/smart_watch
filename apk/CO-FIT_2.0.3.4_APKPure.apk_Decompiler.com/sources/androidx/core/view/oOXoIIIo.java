package androidx.core.view;

import android.view.ViewConfiguration;
import androidx.core.util.Supplier;

public final /* synthetic */ class oOXoIIIo implements Supplier {

    /* renamed from: oIX0oI  reason: collision with root package name */
    public final /* synthetic */ ViewConfiguration f380oIX0oI;

    public /* synthetic */ oOXoIIIo(ViewConfiguration viewConfiguration) {
        this.f380oIX0oI = viewConfiguration;
    }

    public final Object get() {
        return Integer.valueOf(this.f380oIX0oI.getScaledMinimumFlingVelocity());
    }
}
