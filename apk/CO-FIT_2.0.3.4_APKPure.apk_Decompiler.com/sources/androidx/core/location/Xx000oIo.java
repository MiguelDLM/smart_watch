package androidx.core.location;

import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

public final /* synthetic */ class Xx000oIo implements Runnable {

    /* renamed from: Oo  reason: collision with root package name */
    public final /* synthetic */ Executor f337Oo;

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.PreRGnssStatusTransport f338XO;

    public /* synthetic */ Xx000oIo(LocationManagerCompat.PreRGnssStatusTransport preRGnssStatusTransport, Executor executor) {
        this.f338XO = preRGnssStatusTransport;
        this.f337Oo = executor;
    }

    public final void run() {
        this.f338XO.lambda$onStopped$1(this.f337Oo);
    }
}
