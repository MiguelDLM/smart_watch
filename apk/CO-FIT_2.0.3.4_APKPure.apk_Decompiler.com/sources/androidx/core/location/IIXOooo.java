package androidx.core.location;

import android.location.Location;
import androidx.core.util.Consumer;

public final /* synthetic */ class IIXOooo implements Runnable {

    /* renamed from: Oo  reason: collision with root package name */
    public final /* synthetic */ Location f313Oo;

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ Consumer f314XO;

    public /* synthetic */ IIXOooo(Consumer consumer, Location location) {
        this.f314XO = consumer;
        this.f313Oo = location;
    }

    public final void run() {
        this.f314XO.accept(this.f313Oo);
    }
}
