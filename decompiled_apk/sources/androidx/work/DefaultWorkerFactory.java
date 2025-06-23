package androidx.work;

import android.content.Context;
import androidx.annotation.RestrictTo;
import kotlin.jvm.internal.IIX0o;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public final class DefaultWorkerFactory extends WorkerFactory {

    @OXOo.OOXIXo
    public static final DefaultWorkerFactory INSTANCE = new DefaultWorkerFactory();

    private DefaultWorkerFactory() {
    }

    @OXOo.oOoXoXO
    /* renamed from: createWorker, reason: collision with other method in class */
    public Void m38createWorker(@OXOo.OOXIXo Context appContext, @OXOo.OOXIXo String workerClassName, @OXOo.OOXIXo WorkerParameters workerParameters) {
        IIX0o.x0xO0oo(appContext, "appContext");
        IIX0o.x0xO0oo(workerClassName, "workerClassName");
        IIX0o.x0xO0oo(workerParameters, "workerParameters");
        return null;
    }

    @Override // androidx.work.WorkerFactory
    public /* bridge */ /* synthetic */ ListenableWorker createWorker(Context context, String str, WorkerParameters workerParameters) {
        return (ListenableWorker) m38createWorker(context, str, workerParameters);
    }
}
