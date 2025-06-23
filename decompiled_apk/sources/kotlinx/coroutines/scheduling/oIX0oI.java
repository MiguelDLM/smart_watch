package kotlinx.coroutines.scheduling;

import OXOo.OOXIXo;
import XO0OX.xxIXOIIO;
import kotlinx.coroutines.scheduling.CoroutineScheduler;

/* loaded from: classes6.dex */
public final class oIX0oI {
    @xxIXOIIO(name = "mayNotBlock")
    public static final boolean II0xO0(@OOXIXo Thread thread) {
        if ((thread instanceof CoroutineScheduler.I0Io) && ((CoroutineScheduler.I0Io) thread).f30379IXxxXO == CoroutineScheduler.WorkerState.CPU_ACQUIRED) {
            return true;
        }
        return false;
    }

    @xxIXOIIO(name = "isSchedulerWorker")
    public static final boolean oIX0oI(@OOXIXo Thread thread) {
        return thread instanceof CoroutineScheduler.I0Io;
    }
}
