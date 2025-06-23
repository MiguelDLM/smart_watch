package androidx.work.impl;

import androidx.work.WorkerParameters;

public final /* synthetic */ class xoIox implements Runnable {

    /* renamed from: IXxxXO  reason: collision with root package name */
    public final /* synthetic */ WorkerParameters.RuntimeExtras f574IXxxXO;

    /* renamed from: Oo  reason: collision with root package name */
    public final /* synthetic */ StartStopToken f575Oo;

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ WorkLauncherImpl f576XO;

    public /* synthetic */ xoIox(WorkLauncherImpl workLauncherImpl, StartStopToken startStopToken, WorkerParameters.RuntimeExtras runtimeExtras) {
        this.f576XO = workLauncherImpl;
        this.f575Oo = startStopToken;
        this.f574IXxxXO = runtimeExtras;
    }

    public final void run() {
        WorkLauncherImpl.startWork$lambda$0(this.f576XO, this.f575Oo, this.f574IXxxXO);
    }
}
