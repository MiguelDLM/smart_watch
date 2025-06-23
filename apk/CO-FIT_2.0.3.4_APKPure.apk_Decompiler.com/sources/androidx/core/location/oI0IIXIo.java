package androidx.core.location;

import android.location.Location;
import java.util.function.Consumer;

public final /* synthetic */ class oI0IIXIo implements Consumer {

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ androidx.core.util.Consumer f341XO;

    public /* synthetic */ oI0IIXIo(androidx.core.util.Consumer consumer) {
        this.f341XO = consumer;
    }

    public final void accept(Object obj) {
        this.f341XO.accept((Location) obj);
    }
}
