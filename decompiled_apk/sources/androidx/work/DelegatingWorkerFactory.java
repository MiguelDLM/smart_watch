package androidx.work;

import android.content.Context;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes.dex */
public class DelegatingWorkerFactory extends WorkerFactory {

    @OXOo.OOXIXo
    private final List<WorkerFactory> factories = new CopyOnWriteArrayList();

    public final void addFactory(@OXOo.OOXIXo WorkerFactory workerFactory) {
        IIX0o.x0xO0oo(workerFactory, "workerFactory");
        this.factories.add(workerFactory);
    }

    @Override // androidx.work.WorkerFactory
    @OXOo.oOoXoXO
    public final ListenableWorker createWorker(@OXOo.OOXIXo Context appContext, @OXOo.OOXIXo String workerClassName, @OXOo.OOXIXo WorkerParameters workerParameters) {
        String str;
        IIX0o.x0xO0oo(appContext, "appContext");
        IIX0o.x0xO0oo(workerClassName, "workerClassName");
        IIX0o.x0xO0oo(workerParameters, "workerParameters");
        Iterator<T> it = this.factories.iterator();
        while (it.hasNext()) {
            try {
                ListenableWorker createWorker = ((WorkerFactory) it.next()).createWorker(appContext, workerClassName, workerParameters);
                if (createWorker != null) {
                    return createWorker;
                }
            } catch (Throwable th) {
                String str2 = "Unable to instantiate a ListenableWorker (" + workerClassName + HexStringBuilder.COMMENT_END_CHAR;
                Logger logger = Logger.get();
                str = DelegatingWorkerFactoryKt.TAG;
                logger.error(str, str2, th);
                throw th;
            }
        }
        return null;
    }
}
