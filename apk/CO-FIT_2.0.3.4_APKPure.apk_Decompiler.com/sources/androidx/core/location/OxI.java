package androidx.core.location;

import android.location.GnssMeasurementsEvent;
import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

public final /* synthetic */ class OxI implements Runnable {

    /* renamed from: IXxxXO  reason: collision with root package name */
    public final /* synthetic */ GnssMeasurementsEvent f322IXxxXO;

    /* renamed from: Oo  reason: collision with root package name */
    public final /* synthetic */ Executor f323Oo;

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.GnssMeasurementsTransport f324XO;

    public /* synthetic */ OxI(LocationManagerCompat.GnssMeasurementsTransport gnssMeasurementsTransport, Executor executor, GnssMeasurementsEvent gnssMeasurementsEvent) {
        this.f324XO = gnssMeasurementsTransport;
        this.f323Oo = executor;
        this.f322IXxxXO = gnssMeasurementsEvent;
    }

    public final void run() {
        this.f324XO.lambda$onGnssMeasurementsReceived$0(this.f323Oo, this.f322IXxxXO);
    }
}
