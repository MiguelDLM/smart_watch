package androidx.core.view;

import android.view.ViewConfiguration;
import androidx.core.util.Supplier;

public final /* synthetic */ class IoOoX implements Supplier {

    /* renamed from: oIX0oI  reason: collision with root package name */
    public final /* synthetic */ ViewConfiguration f369oIX0oI;

    public /* synthetic */ IoOoX(ViewConfiguration viewConfiguration) {
        this.f369oIX0oI = viewConfiguration;
    }

    public final Object get() {
        return Integer.valueOf(this.f369oIX0oI.getScaledMaximumFlingVelocity());
    }
}
