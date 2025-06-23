package androidx.work;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.content.Context;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.IIX0o;

public class DelegatingWorkerFactory extends WorkerFactory {
    @OOXIXo
    private final List<WorkerFactory> factories = new CopyOnWriteArrayList();

    public final void addFactory(@OOXIXo WorkerFactory workerFactory) {
        IIX0o.x0xO0oo(workerFactory, "workerFactory");
        this.factories.add(workerFactory);
    }

    @oOoXoXO
    public final ListenableWorker createWorker(@OOXIXo Context context, @OOXIXo String str, @OOXIXo WorkerParameters workerParameters) {
        IIX0o.x0xO0oo(context, "appContext");
        IIX0o.x0xO0oo(str, "workerClassName");
        IIX0o.x0xO0oo(workerParameters, "workerParameters");
        for (WorkerFactory createWorker : this.factories) {
            try {
                ListenableWorker createWorker2 = createWorker.createWorker(context, str, workerParameters);
                if (createWorker2 != null) {
                    return createWorker2;
                }
            } catch (Throwable th) {
                Logger.get().error(DelegatingWorkerFactoryKt.TAG, "Unable to instantiate a ListenableWorker (" + str + HexStringBuilder.COMMENT_END_CHAR, th);
                throw th;
            }
        }
        return null;
    }
}
