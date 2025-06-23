package androidx.core.location;

import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

public final /* synthetic */ class X00IoxXI implements Runnable {

    /* renamed from: Oo  reason: collision with root package name */
    public final /* synthetic */ Executor f328Oo;

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.PreRGnssStatusTransport f329XO;

    public /* synthetic */ X00IoxXI(LocationManagerCompat.PreRGnssStatusTransport preRGnssStatusTransport, Executor executor) {
        this.f329XO = preRGnssStatusTransport;
        this.f328Oo = executor;
    }

    public final void run() {
        this.f329XO.lambda$onStarted$0(this.f328Oo);
    }
}
