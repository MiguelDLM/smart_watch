package androidx.emoji2.text;

import android.os.Handler;
import java.util.concurrent.Executor;

public final /* synthetic */ class oIX0oI implements Executor {

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ Handler f392XO;

    public /* synthetic */ oIX0oI(Handler handler) {
        this.f392XO = handler;
    }

    public final void execute(Runnable runnable) {
        this.f392XO.post(runnable);
    }
}
