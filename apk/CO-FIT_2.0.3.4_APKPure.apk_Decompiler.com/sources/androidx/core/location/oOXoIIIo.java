package androidx.core.location;

import android.location.GnssStatus;
import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

public final /* synthetic */ class oOXoIIIo implements Runnable {

    /* renamed from: IXxxXO  reason: collision with root package name */
    public final /* synthetic */ GnssStatus f342IXxxXO;

    /* renamed from: Oo  reason: collision with root package name */
    public final /* synthetic */ Executor f343Oo;

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.PreRGnssStatusTransport f344XO;

    public /* synthetic */ oOXoIIIo(LocationManagerCompat.PreRGnssStatusTransport preRGnssStatusTransport, Executor executor, GnssStatus gnssStatus) {
        this.f344XO = preRGnssStatusTransport;
        this.f343Oo = executor;
        this.f342IXxxXO = gnssStatus;
    }

    public final void run() {
        this.f344XO.lambda$onSatelliteStatusChanged$3(this.f343Oo, this.f342IXxxXO);
    }
}
