package androidx.work.impl.utils;

import androidx.annotation.RestrictTo;
import androidx.work.Logger;
import androidx.work.WorkInfo;
import androidx.work.impl.Processor;
import androidx.work.impl.StartStopToken;
import kotlin.jvm.internal.IIX0o;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public final class StopWorkRunnable implements Runnable {

    @OXOo.OOXIXo
    private final Processor processor;
    private final int reason;
    private final boolean stopInForeground;

    @OXOo.OOXIXo
    private final StartStopToken token;

    public StopWorkRunnable(@OXOo.OOXIXo Processor processor, @OXOo.OOXIXo StartStopToken token, boolean z, int i) {
        IIX0o.x0xO0oo(processor, "processor");
        IIX0o.x0xO0oo(token, "token");
        this.processor = processor;
        this.token = token;
        this.stopInForeground = z;
        this.reason = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean stopWork;
        if (this.stopInForeground) {
            stopWork = this.processor.stopForegroundWork(this.token, this.reason);
        } else {
            stopWork = this.processor.stopWork(this.token, this.reason);
        }
        Logger.get().debug(Logger.tagWithPrefix("StopWorkRunnable"), "StopWorkRunnable for " + this.token.getId().getWorkSpecId() + "; Processor.stopWork = " + stopWork);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StopWorkRunnable(@OXOo.OOXIXo Processor processor, @OXOo.OOXIXo StartStopToken token, boolean z) {
        this(processor, token, z, WorkInfo.STOP_REASON_UNKNOWN);
        IIX0o.x0xO0oo(processor, "processor");
        IIX0o.x0xO0oo(token, "token");
    }
}
