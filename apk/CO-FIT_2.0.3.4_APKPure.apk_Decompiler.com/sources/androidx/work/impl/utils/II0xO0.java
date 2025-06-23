package androidx.work.impl.utils;

import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;

public final /* synthetic */ class II0xO0 implements Runnable {

    /* renamed from: Oo  reason: collision with root package name */
    public final /* synthetic */ WorkManagerImpl f547Oo;

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ WorkDatabase f548XO;

    public /* synthetic */ II0xO0(WorkDatabase workDatabase, WorkManagerImpl workManagerImpl) {
        this.f548XO = workDatabase;
        this.f547Oo = workManagerImpl;
    }

    public final void run() {
        CancelWorkRunnable$forAll$1.invoke$lambda$0(this.f548XO, this.f547Oo);
    }
}
