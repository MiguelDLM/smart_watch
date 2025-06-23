package androidx.work.impl;

import OXOo.OOXIXo;
import androidx.work.WorkInfo;
import androidx.work.WorkerParameters;
import kotlin.jvm.internal.IIX0o;

public final /* synthetic */ class xxIXOIIO {
    public static void I0Io(WorkLauncher workLauncher, @OOXIXo StartStopToken startStopToken, int i) {
        IIX0o.x0xO0oo(startStopToken, "workSpecId");
        workLauncher.stopWork(startStopToken, i);
    }

    public static void II0xO0(WorkLauncher workLauncher, @OOXIXo StartStopToken startStopToken) {
        IIX0o.x0xO0oo(startStopToken, "workSpecId");
        workLauncher.stopWork(startStopToken, WorkInfo.STOP_REASON_UNKNOWN);
    }

    public static void oIX0oI(WorkLauncher workLauncher, @OOXIXo StartStopToken startStopToken) {
        IIX0o.x0xO0oo(startStopToken, "workSpecId");
        workLauncher.startWork(startStopToken, (WorkerParameters.RuntimeExtras) null);
    }
}
