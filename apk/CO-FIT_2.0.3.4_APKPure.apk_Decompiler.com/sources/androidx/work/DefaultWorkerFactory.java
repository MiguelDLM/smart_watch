package androidx.work;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.content.Context;
import androidx.annotation.RestrictTo;
import kotlin.jvm.internal.IIX0o;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class DefaultWorkerFactory extends WorkerFactory {
    @OOXIXo
    public static final DefaultWorkerFactory INSTANCE = new DefaultWorkerFactory();

    private DefaultWorkerFactory() {
    }

    @oOoXoXO
    public Void createWorker(@OOXIXo Context context, @OOXIXo String str, @OOXIXo WorkerParameters workerParameters) {
        IIX0o.x0xO0oo(context, "appContext");
        IIX0o.x0xO0oo(str, "workerClassName");
        IIX0o.x0xO0oo(workerParameters, "workerParameters");
        return null;
    }
}
