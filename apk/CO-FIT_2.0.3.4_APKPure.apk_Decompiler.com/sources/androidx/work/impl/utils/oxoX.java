package androidx.work.impl.utils;

import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;

public final /* synthetic */ class oxoX implements Runnable {

    /* renamed from: IXxxXO  reason: collision with root package name */
    public final /* synthetic */ WorkManagerImpl f559IXxxXO;

    /* renamed from: Oo  reason: collision with root package name */
    public final /* synthetic */ String f560Oo;

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ WorkDatabase f561XO;

    public /* synthetic */ oxoX(WorkDatabase workDatabase, String str, WorkManagerImpl workManagerImpl) {
        this.f561XO = workDatabase;
        this.f560Oo = str;
        this.f559IXxxXO = workManagerImpl;
    }

    public final void run() {
        CancelWorkRunnable$forTag$1.invoke$lambda$0(this.f561XO, this.f560Oo, this.f559IXxxXO);
    }
}
