package androidx.work.impl.utils;

import OXOo.OOXIXo;
import androidx.annotation.RestrictTo;
import androidx.work.Logger;
import androidx.work.WorkInfo;
import androidx.work.impl.Processor;
import androidx.work.impl.StartStopToken;
import kotlin.jvm.internal.IIX0o;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class StopWorkRunnable implements Runnable {
    @OOXIXo
    private final Processor processor;
    private final int reason;
    private final boolean stopInForeground;
    @OOXIXo
    private final StartStopToken token;

    public StopWorkRunnable(@OOXIXo Processor processor2, @OOXIXo StartStopToken startStopToken, boolean z, int i) {
        IIX0o.x0xO0oo(processor2, "processor");
        IIX0o.x0xO0oo(startStopToken, "token");
        this.processor = processor2;
        this.token = startStopToken;
        this.stopInForeground = z;
        this.reason = i;
    }

    public void run() {
        boolean z;
        if (this.stopInForeground) {
            z = this.processor.stopForegroundWork(this.token, this.reason);
        } else {
            z = this.processor.stopWork(this.token, this.reason);
        }
        Logger logger = Logger.get();
        String tagWithPrefix = Logger.tagWithPrefix("StopWorkRunnable");
        logger.debug(tagWithPrefix, "StopWorkRunnable for " + this.token.getId().getWorkSpecId() + "; Processor.stopWork = " + z);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public StopWorkRunnable(@OOXIXo Processor processor2, @OOXIXo StartStopToken startStopToken, boolean z) {
        this(processor2, startStopToken, z, WorkInfo.STOP_REASON_UNKNOWN);
        IIX0o.x0xO0oo(processor2, "processor");
        IIX0o.x0xO0oo(startStopToken, "token");
    }
}
