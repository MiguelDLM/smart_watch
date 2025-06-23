package androidx.core.location;

import android.location.Location;
import androidx.core.util.Consumer;

public final /* synthetic */ class x0xO0oo implements Runnable {

    /* renamed from: Oo  reason: collision with root package name */
    public final /* synthetic */ Location f351Oo;

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ Consumer f352XO;

    public /* synthetic */ x0xO0oo(Consumer consumer, Location location) {
        this.f352XO = consumer;
        this.f351Oo = location;
    }

    public final void run() {
        this.f352XO.accept(this.f351Oo);
    }
}
