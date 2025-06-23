package androidx.work.impl;

import androidx.work.WorkInfo;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes.dex */
public final /* synthetic */ class xxIXOIIO {
    public static void I0Io(WorkLauncher workLauncher, @OXOo.OOXIXo StartStopToken workSpecId, int i) {
        IIX0o.x0xO0oo(workSpecId, "workSpecId");
        workLauncher.stopWork(workSpecId, i);
    }

    public static void II0xO0(WorkLauncher workLauncher, @OXOo.OOXIXo StartStopToken workSpecId) {
        IIX0o.x0xO0oo(workSpecId, "workSpecId");
        workLauncher.stopWork(workSpecId, WorkInfo.STOP_REASON_UNKNOWN);
    }

    public static void oIX0oI(WorkLauncher workLauncher, @OXOo.OOXIXo StartStopToken workSpecId) {
        IIX0o.x0xO0oo(workSpecId, "workSpecId");
        workLauncher.startWork(workSpecId, null);
    }
}
