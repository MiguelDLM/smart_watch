package androidx.core.location;

import android.os.Bundle;
import androidx.core.location.LocationManagerCompat;

public final /* synthetic */ class oo0xXOI0I implements Runnable {

    /* renamed from: IXxxXO  reason: collision with root package name */
    public final /* synthetic */ int f345IXxxXO;

    /* renamed from: Oo  reason: collision with root package name */
    public final /* synthetic */ String f346Oo;

    /* renamed from: Oxx0xo  reason: collision with root package name */
    public final /* synthetic */ Bundle f347Oxx0xo;

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.LocationListenerTransport f348XO;

    public /* synthetic */ oo0xXOI0I(LocationManagerCompat.LocationListenerTransport locationListenerTransport, String str, int i, Bundle bundle) {
        this.f348XO = locationListenerTransport;
        this.f346Oo = str;
        this.f345IXxxXO = i;
        this.f347Oxx0xo = bundle;
    }

    public final void run() {
        this.f348XO.lambda$onStatusChanged$3(this.f346Oo, this.f345IXxxXO, this.f347Oxx0xo);
    }
}
