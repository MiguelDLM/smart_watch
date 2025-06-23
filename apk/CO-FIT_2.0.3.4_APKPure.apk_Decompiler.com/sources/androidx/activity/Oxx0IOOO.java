package androidx.activity;

import androidx.activity.ComponentActivity;

public final /* synthetic */ class Oxx0IOOO implements Runnable {

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ ComponentActivity.ReportFullyDrawnExecutorImpl f257XO;

    public /* synthetic */ Oxx0IOOO(ComponentActivity.ReportFullyDrawnExecutorImpl reportFullyDrawnExecutorImpl) {
        this.f257XO = reportFullyDrawnExecutorImpl;
    }

    public final void run() {
        ComponentActivity.ReportFullyDrawnExecutorImpl.execute$lambda$0(this.f257XO);
    }
}
