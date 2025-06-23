package androidx.core.location;

import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

public final /* synthetic */ class IoOoX implements Runnable {

    /* renamed from: IXxxXO  reason: collision with root package name */
    public final /* synthetic */ int f316IXxxXO;

    /* renamed from: Oo  reason: collision with root package name */
    public final /* synthetic */ Executor f317Oo;

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.PreRGnssStatusTransport f318XO;

    public /* synthetic */ IoOoX(LocationManagerCompat.PreRGnssStatusTransport preRGnssStatusTransport, Executor executor, int i) {
        this.f318XO = preRGnssStatusTransport;
        this.f317Oo = executor;
        this.f316IXxxXO = i;
    }

    public final void run() {
        this.f318XO.lambda$onFirstFix$2(this.f317Oo, this.f316IXxxXO);
    }
}
