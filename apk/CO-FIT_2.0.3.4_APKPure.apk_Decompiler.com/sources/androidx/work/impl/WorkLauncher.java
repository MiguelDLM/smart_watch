package androidx.work.impl;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import androidx.work.WorkerParameters;

public interface WorkLauncher {
    void startWork(@OOXIXo StartStopToken startStopToken);

    void startWork(@OOXIXo StartStopToken startStopToken, @oOoXoXO WorkerParameters.RuntimeExtras runtimeExtras);

    void stopWork(@OOXIXo StartStopToken startStopToken);

    void stopWork(@OOXIXo StartStopToken startStopToken, int i);

    void stopWorkWithReason(@OOXIXo StartStopToken startStopToken, int i);
}
