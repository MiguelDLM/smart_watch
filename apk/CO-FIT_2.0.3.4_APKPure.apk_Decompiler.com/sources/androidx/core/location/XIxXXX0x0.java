package androidx.core.location;

import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

public final /* synthetic */ class XIxXXX0x0 implements Runnable {

    /* renamed from: IXxxXO  reason: collision with root package name */
    public final /* synthetic */ int f334IXxxXO;

    /* renamed from: Oo  reason: collision with root package name */
    public final /* synthetic */ Executor f335Oo;

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.GpsStatusTransport f336XO;

    public /* synthetic */ XIxXXX0x0(LocationManagerCompat.GpsStatusTransport gpsStatusTransport, Executor executor, int i) {
        this.f336XO = gpsStatusTransport;
        this.f335Oo = executor;
        this.f334IXxxXO = i;
    }

    public final void run() {
        this.f336XO.lambda$onGpsStatusChanged$2(this.f335Oo, this.f334IXxxXO);
    }
}
