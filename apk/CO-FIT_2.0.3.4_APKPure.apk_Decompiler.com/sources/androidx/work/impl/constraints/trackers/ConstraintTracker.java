package androidx.work.impl.constraints.trackers;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.content.Context;
import androidx.annotation.RestrictTo;
import androidx.work.Logger;
import androidx.work.impl.constraints.ConstraintListener;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.huawei.openalliance.ad.constant.bn;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@XX({"SMAP\nConstraintTracker.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConstraintTracker.kt\nandroidx/work/impl/constraints/trackers/ConstraintTracker\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,113:1\n1855#2,2:114\n*S KotlinDebug\n*F\n+ 1 ConstraintTracker.kt\nandroidx/work/impl/constraints/trackers/ConstraintTracker\n*L\n90#1:114,2\n*E\n"})
public abstract class ConstraintTracker<T> {
    @OOXIXo
    private final Context appContext;
    @oOoXoXO
    private T currentState;
    @OOXIXo
    private final LinkedHashSet<ConstraintListener<T>> listeners = new LinkedHashSet<>();
    @OOXIXo
    private final Object lock = new Object();
    @OOXIXo
    private final TaskExecutor taskExecutor;

    public ConstraintTracker(@OOXIXo Context context, @OOXIXo TaskExecutor taskExecutor2) {
        IIX0o.x0xO0oo(context, bn.f.o);
        IIX0o.x0xO0oo(taskExecutor2, "taskExecutor");
        this.taskExecutor = taskExecutor2;
        Context applicationContext = context.getApplicationContext();
        IIX0o.oO(applicationContext, "context.applicationContext");
        this.appContext = applicationContext;
    }

    /* access modifiers changed from: private */
    public static final void _set_state_$lambda$4$lambda$3(List list, ConstraintTracker constraintTracker) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((ConstraintListener) it.next()).onConstraintChanged(constraintTracker.currentState);
        }
    }

    public final void addListener(@OOXIXo ConstraintListener<T> constraintListener) {
        IIX0o.x0xO0oo(constraintListener, "listener");
        synchronized (this.lock) {
            try {
                if (this.listeners.add(constraintListener)) {
                    if (this.listeners.size() == 1) {
                        this.currentState = readSystemState();
                        Logger logger = Logger.get();
                        String access$getTAG$p = ConstraintTrackerKt.TAG;
                        logger.debug(access$getTAG$p, getClass().getSimpleName() + ": initial state = " + this.currentState);
                        startTracking();
                    }
                    constraintListener.onConstraintChanged(this.currentState);
                }
                oXIO0o0XI oxio0o0xi = oXIO0o0XI.f19155oIX0oI;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @OOXIXo
    public final Context getAppContext() {
        return this.appContext;
    }

    public final T getState() {
        T t = this.currentState;
        if (t == null) {
            return readSystemState();
        }
        return t;
    }

    public abstract T readSystemState();

    public final void removeListener(@OOXIXo ConstraintListener<T> constraintListener) {
        IIX0o.x0xO0oo(constraintListener, "listener");
        synchronized (this.lock) {
            try {
                if (this.listeners.remove(constraintListener) && this.listeners.isEmpty()) {
                    stopTracking();
                }
                oXIO0o0XI oxio0o0xi = oXIO0o0XI.f19155oIX0oI;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void setState(T t) {
        synchronized (this.lock) {
            T t2 = this.currentState;
            if (t2 == null || !IIX0o.Oxx0IOOO(t2, t)) {
                this.currentState = t;
                this.taskExecutor.getMainThreadExecutor().execute(new oIX0oI(CollectionsKt___CollectionsKt.oOo0o(this.listeners), this));
                oXIO0o0XI oxio0o0xi = oXIO0o0XI.f19155oIX0oI;
            }
        }
    }

    public abstract void startTracking();

    public abstract void stopTracking();
}
