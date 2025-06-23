package androidx.core.location;

import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

public final /* synthetic */ class O0xOxO implements Runnable {

    /* renamed from: IXxxXO  reason: collision with root package name */
    public final /* synthetic */ int f319IXxxXO;

    /* renamed from: Oo  reason: collision with root package name */
    public final /* synthetic */ Executor f320Oo;

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.GnssMeasurementsTransport f321XO;

    public /* synthetic */ O0xOxO(LocationManagerCompat.GnssMeasurementsTransport gnssMeasurementsTransport, Executor executor, int i) {
        this.f321XO = gnssMeasurementsTransport;
        this.f320Oo = executor;
        this.f319IXxxXO = i;
    }

    public final void run() {
        this.f321XO.lambda$onStatusChanged$1(this.f320Oo, this.f319IXxxXO);
    }
}
