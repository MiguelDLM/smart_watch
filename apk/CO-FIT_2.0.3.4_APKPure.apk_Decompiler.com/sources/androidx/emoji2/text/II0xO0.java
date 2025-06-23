package androidx.emoji2.text;

import java.util.concurrent.ThreadFactory;

public final /* synthetic */ class II0xO0 implements ThreadFactory {

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ String f389XO;

    public /* synthetic */ II0xO0(String str) {
        this.f389XO = str;
    }

    public final Thread newThread(Runnable runnable) {
        return ConcurrencyHelpers.lambda$createBackgroundPriorityExecutor$0(this.f389XO, runnable);
    }
}
