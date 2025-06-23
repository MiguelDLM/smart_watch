package androidx.core.location;

import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

public final /* synthetic */ class xxX implements Runnable {

    /* renamed from: IXxxXO  reason: collision with root package name */
    public final /* synthetic */ GnssStatusCompat f357IXxxXO;

    /* renamed from: Oo  reason: collision with root package name */
    public final /* synthetic */ Executor f358Oo;

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.GpsStatusTransport f359XO;

    public /* synthetic */ xxX(LocationManagerCompat.GpsStatusTransport gpsStatusTransport, Executor executor, GnssStatusCompat gnssStatusCompat) {
        this.f359XO = gpsStatusTransport;
        this.f358Oo = executor;
        this.f357IXxxXO = gnssStatusCompat;
    }

    public final void run() {
        this.f359XO.lambda$onGpsStatusChanged$3(this.f358Oo, this.f357IXxxXO);
    }
}
