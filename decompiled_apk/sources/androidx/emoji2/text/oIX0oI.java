package androidx.emoji2.text;

import android.os.Handler;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final /* synthetic */ class oIX0oI implements Executor {

    /* renamed from: XO, reason: collision with root package name */
    public final /* synthetic */ Handler f4386XO;

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f4386XO.post(runnable);
    }
}
