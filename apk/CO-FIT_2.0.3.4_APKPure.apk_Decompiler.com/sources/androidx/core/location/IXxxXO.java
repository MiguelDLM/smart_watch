package androidx.core.location;

import android.os.CancellationSignal;
import androidx.core.location.LocationManagerCompat;

public final /* synthetic */ class IXxxXO implements CancellationSignal.OnCancelListener {

    /* renamed from: oIX0oI  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.CancellableLocationListener f315oIX0oI;

    public /* synthetic */ IXxxXO(LocationManagerCompat.CancellableLocationListener cancellableLocationListener) {
        this.f315oIX0oI = cancellableLocationListener;
    }

    public final void onCancel() {
        this.f315oIX0oI.cancel();
    }
}
