package androidx.work.impl;

import androidx.work.WorkerParameters;

/* loaded from: classes.dex */
public interface WorkLauncher {
    void startWork(@OXOo.OOXIXo StartStopToken startStopToken);

    void startWork(@OXOo.OOXIXo StartStopToken startStopToken, @OXOo.oOoXoXO WorkerParameters.RuntimeExtras runtimeExtras);

    void stopWork(@OXOo.OOXIXo StartStopToken startStopToken);

    void stopWork(@OXOo.OOXIXo StartStopToken startStopToken, int i);

    void stopWorkWithReason(@OXOo.OOXIXo StartStopToken startStopToken, int i);
}
