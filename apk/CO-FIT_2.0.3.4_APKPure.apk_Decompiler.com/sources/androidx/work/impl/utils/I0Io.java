package androidx.work.impl.utils;

import androidx.work.impl.WorkManagerImpl;
import java.util.UUID;

public final /* synthetic */ class I0Io implements Runnable {

    /* renamed from: Oo  reason: collision with root package name */
    public final /* synthetic */ UUID f545Oo;

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ WorkManagerImpl f546XO;

    public /* synthetic */ I0Io(WorkManagerImpl workManagerImpl, UUID uuid) {
        this.f546XO = workManagerImpl;
        this.f545Oo = uuid;
    }

    public final void run() {
        CancelWorkRunnable$forId$1.invoke$lambda$0(this.f546XO, this.f545Oo);
    }
}
