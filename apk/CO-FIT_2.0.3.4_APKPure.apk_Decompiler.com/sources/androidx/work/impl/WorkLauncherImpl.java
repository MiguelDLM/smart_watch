package androidx.work.impl;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import androidx.work.WorkerParameters;
import androidx.work.impl.utils.StopWorkRunnable;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import kotlin.jvm.internal.IIX0o;

public final class WorkLauncherImpl implements WorkLauncher {
    @OOXIXo
    private final Processor processor;
    @OOXIXo
    private final TaskExecutor workTaskExecutor;

    public WorkLauncherImpl(@OOXIXo Processor processor2, @OOXIXo TaskExecutor taskExecutor) {
        IIX0o.x0xO0oo(processor2, "processor");
        IIX0o.x0xO0oo(taskExecutor, "workTaskExecutor");
        this.processor = processor2;
        this.workTaskExecutor = taskExecutor;
    }

    /* access modifiers changed from: private */
    public static final void startWork$lambda$0(WorkLauncherImpl workLauncherImpl, StartStopToken startStopToken, WorkerParameters.RuntimeExtras runtimeExtras) {
        workLauncherImpl.processor.startWork(startStopToken, runtimeExtras);
    }

    @OOXIXo
    public final Processor getProcessor() {
        return this.processor;
    }

    @OOXIXo
    public final TaskExecutor getWorkTaskExecutor() {
        return this.workTaskExecutor;
    }

    public /* synthetic */ void startWork(StartStopToken startStopToken) {
        xxIXOIIO.oIX0oI(this, startStopToken);
    }

    public /* synthetic */ void stopWork(StartStopToken startStopToken) {
        xxIXOIIO.II0xO0(this, startStopToken);
    }

    public /* synthetic */ void stopWorkWithReason(StartStopToken startStopToken, int i) {
        xxIXOIIO.I0Io(this, startStopToken, i);
    }

    public void startWork(@OOXIXo StartStopToken startStopToken, @oOoXoXO WorkerParameters.RuntimeExtras runtimeExtras) {
        IIX0o.x0xO0oo(startStopToken, "workSpecId");
        this.workTaskExecutor.executeOnTaskThread(new xoIox(this, startStopToken, runtimeExtras));
    }

    public void stopWork(@OOXIXo StartStopToken startStopToken, int i) {
        IIX0o.x0xO0oo(startStopToken, "workSpecId");
        this.workTaskExecutor.executeOnTaskThread(new StopWorkRunnable(this.processor, startStopToken, false, i));
    }
}
