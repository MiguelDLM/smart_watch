package androidx.work.impl.background.greedy;

import androidx.work.impl.StartStopToken;

public final /* synthetic */ class oIX0oI implements Runnable {

    /* renamed from: Oo  reason: collision with root package name */
    public final /* synthetic */ StartStopToken f526Oo;

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ TimeLimiter f527XO;

    public /* synthetic */ oIX0oI(TimeLimiter timeLimiter, StartStopToken startStopToken) {
        this.f527XO = timeLimiter;
        this.f526Oo = startStopToken;
    }

    public final void run() {
        TimeLimiter.track$lambda$0(this.f527XO, this.f526Oo);
    }
}
