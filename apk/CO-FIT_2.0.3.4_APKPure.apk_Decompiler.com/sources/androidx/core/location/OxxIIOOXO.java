package androidx.core.location;

import androidx.core.location.LocationManagerCompat;

public final /* synthetic */ class OxxIIOOXO implements Runnable {

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.CancellableLocationListener f327XO;

    public /* synthetic */ OxxIIOOXO(LocationManagerCompat.CancellableLocationListener cancellableLocationListener) {
        this.f327XO = cancellableLocationListener;
    }

    public final void run() {
        this.f327XO.lambda$startTimeout$0();
    }
}
