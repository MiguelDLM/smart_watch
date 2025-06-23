package androidx.work.impl.utils;

import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;

public final /* synthetic */ class oIX0oI implements Runnable {

    /* renamed from: IXxxXO  reason: collision with root package name */
    public final /* synthetic */ WorkManagerImpl f556IXxxXO;

    /* renamed from: Oo  reason: collision with root package name */
    public final /* synthetic */ String f557Oo;

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ WorkDatabase f558XO;

    public /* synthetic */ oIX0oI(WorkDatabase workDatabase, String str, WorkManagerImpl workManagerImpl) {
        this.f558XO = workDatabase;
        this.f557Oo = str;
        this.f556IXxxXO = workManagerImpl;
    }

    public final void run() {
        CancelWorkRunnable.forNameInline$lambda$0(this.f558XO, this.f557Oo, this.f556IXxxXO);
    }
}
