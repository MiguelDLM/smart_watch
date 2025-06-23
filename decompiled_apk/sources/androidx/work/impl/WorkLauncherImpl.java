package androidx.work.impl;

import androidx.work.WorkerParameters;
import androidx.work.impl.utils.StopWorkRunnable;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes.dex */
public final class WorkLauncherImpl implements WorkLauncher {

    @OXOo.OOXIXo
    private final Processor processor;

    @OXOo.OOXIXo
    private final TaskExecutor workTaskExecutor;

    public WorkLauncherImpl(@OXOo.OOXIXo Processor processor, @OXOo.OOXIXo TaskExecutor workTaskExecutor) {
        IIX0o.x0xO0oo(processor, "processor");
        IIX0o.x0xO0oo(workTaskExecutor, "workTaskExecutor");
        this.processor = processor;
        this.workTaskExecutor = workTaskExecutor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startWork$lambda$0(WorkLauncherImpl workLauncherImpl, StartStopToken startStopToken, WorkerParameters.RuntimeExtras runtimeExtras) {
        workLauncherImpl.processor.startWork(startStopToken, runtimeExtras);
    }

    @OXOo.OOXIXo
    public final Processor getProcessor() {
        return this.processor;
    }

    @OXOo.OOXIXo
    public final TaskExecutor getWorkTaskExecutor() {
        return this.workTaskExecutor;
    }

    @Override // androidx.work.impl.WorkLauncher
    public /* synthetic */ void startWork(StartStopToken startStopToken) {
        xxIXOIIO.oIX0oI(this, startStopToken);
    }

    @Override // androidx.work.impl.WorkLauncher
    public /* synthetic */ void stopWork(StartStopToken startStopToken) {
        xxIXOIIO.II0xO0(this, startStopToken);
    }

    @Override // androidx.work.impl.WorkLauncher
    public /* synthetic */ void stopWorkWithReason(StartStopToken startStopToken, int i) {
        xxIXOIIO.I0Io(this, startStopToken, i);
    }

    @Override // androidx.work.impl.WorkLauncher
    public void startWork(@OXOo.OOXIXo final StartStopToken workSpecId, @OXOo.oOoXoXO final WorkerParameters.RuntimeExtras runtimeExtras) {
        IIX0o.x0xO0oo(workSpecId, "workSpecId");
        this.workTaskExecutor.executeOnTaskThread(new Runnable() { // from class: androidx.work.impl.xoIox
            @Override // java.lang.Runnable
            public final void run() {
                WorkLauncherImpl.startWork$lambda$0(WorkLauncherImpl.this, workSpecId, runtimeExtras);
            }
        });
    }

    @Override // androidx.work.impl.WorkLauncher
    public void stopWork(@OXOo.OOXIXo StartStopToken workSpecId, int i) {
        IIX0o.x0xO0oo(workSpecId, "workSpecId");
        this.workTaskExecutor.executeOnTaskThread(new StopWorkRunnable(this.processor, workSpecId, false, i));
    }
}
